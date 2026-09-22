package com.j7volumeduck.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.VDBus;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.client.listener.VDBindListener;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.carinfo.VDEventCarInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * Door-open audio ducking, ported from the proven J7Recon v35 door watcher
 * via J7Toolkit service v1 (confirmed working on the car).
 *
 * Volumes are tracked by command, never by the readback returned immediately
 * after setStreamVolume: the HU applies volume changes asynchronously, so an
 * immediate getStreamVolume() is stale. Restoration ramps back to the saved
 * user volume over 1s and is cancelled whenever a read differs from the last
 * commanded value, preserving whatever the user set instead.
 */
public class AudioDuckFeature {

    private static final String TAG = "J7VolumeDuck";
    private static final int DOOR_ITEM_MIN = 15;
    private static final int DOOR_ITEM_MAX = 19;
    private static final int DUCK_REDUCTION_PERCENT = 60;
    private static final int RESTORE_STEPS = 10;
    private static final long RESTORE_STEP_DELAY_MS = 100L;

    private final Context context;
    private final Object stateLock = new Object();
    private final Set<Integer> openDoorItems = new HashSet<>();

    private HandlerThread watchThread;
    private Handler watchHandler;
    private IVDBusNotify.Stub notifyListener;
    private VDEvent subscribeEvent;
    private AudioManager audio;

    private volatile boolean stopped;

    private boolean ducked;
    private int savedVolume;
    private int duckedVolume;
    private int restoreExpectedVolume;
    private int restoreGeneration;

    public AudioDuckFeature(Context context) {
        this.context = context.getApplicationContext();
    }

    public synchronized void start() {
        if (watchThread != null) return;
        stopped = false;
        audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        watchThread = new HandlerThread("J7VolumeDuck");
        watchThread.start();
        watchHandler = new Handler(watchThread.getLooper());
        watchHandler.post(this::setupVdb);
    }

    public synchronized void stop() {
        HandlerThread thread = watchThread;
        if (thread == null) return;
        Handler handler = watchHandler;
        IVDBusNotify.Stub listener = notifyListener;
        VDEvent subscription = subscribeEvent;
        // Capture the AudioManager for the posted cleanup: the field is nulled
        // by whichever thread runs stop(), so the cleanup must not read it.
        final AudioManager am = audio;
        watchHandler = null;
        watchThread = null;
        notifyListener = null;
        subscribeEvent = null;
        // Block late door callbacks and pending restore ramp steps before
        // draining the queue; volatile write is visible to binder threads.
        stopped = true;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.post(() -> {
                synchronized (stateLock) {
                    if (ducked && am != null) {
                        try {
                            int current = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                            if (current == duckedVolume) {
                                am.setStreamVolume(AudioManager.STREAM_MUSIC, savedVolume, 0);
                            }
                        } catch (Throwable ignored) {
                        }
                    }
                    ducked = false;
                    openDoorItems.clear();
                }
                if (listener != null && subscription != null) {
                    try {
                        VDBus.getDefault().unsubscribe(subscription, listener);
                    } catch (Throwable ignored) {
                    }
                }
                try {
                    VDBus.getDefault().release();
                } catch (Throwable ignored) {
                }
                audio = null;
                thread.quitSafely();
            });
        } else {
            audio = null;
            thread.quitSafely();
        }
    }

    private void setupVdb() {
        try {
            VDBus vdb = VDBus.getDefault();
            vdb.init(context);
            vdb.registerVDBindListener(new VDBindListener() {
                @Override
                public void onVDConnected(VDServiceDef.ServiceType serviceType) {
                    if (serviceType == VDServiceDef.ServiceType.CAR_INFO) {
                        Handler handler = watchHandler;
                        if (handler != null) handler.post(() -> readInitialDoorStates(vdb));
                    }
                }

                @Override
                public void onVDDisconnected(VDServiceDef.ServiceType serviceType) {
                    log("audio duck disconnected: " + serviceType);
                }
            });
            IVDBusNotify.Stub listener = new IVDBusNotify.Stub() {
                @Override
                public void onVDBusNotify(VDEvent event) throws android.os.RemoteException {
                    Bundle payload = event == null ? null : event.getPayload();
                    int item = payload == null ? -1 : payload.getInt("CMD_ID", -1);
                    int[] values = payload == null ? null : payload.getIntArray("VALUE");
                    if (event == null || event.getId() != VDEventCarInfo.MODULE_READONLY_INFO
                            || values == null || values.length == 0
                            || (item < DOOR_ITEM_MIN || item > DOOR_ITEM_MAX)) return;
                    boolean open = values[0] != 0;
                    Handler handler = watchHandler;
                    if (handler != null) handler.post(() -> updateDoorState(item, open));
                }
            };
            notifyListener = listener;
            Bundle filter = new Bundle();
            filter.putIntArray("CMD_ID_ARRAY", new int[]{15, 16, 17, 18, 19});
            VDEvent subscription = new VDEvent(VDEventCarInfo.MODULE_READONLY_INFO, filter);
            subscribeEvent = subscription;
            vdb.subscribe(subscription, listener);
            boolean bound = vdb.bindService(VDServiceDef.ServiceType.CAR_INFO);
            log("audio duck subscribed to CAR_INFO door items; bind=" + bound);
        } catch (Throwable t) {
            log("audio duck setup failed: " + t);
        }
    }

    private void readInitialDoorStates(VDBus vdb) {
        for (int item = DOOR_ITEM_MIN; item <= DOOR_ITEM_MAX; item++) {
            try {
                Bundle request = new Bundle();
                request.putInt("CMD_ID", item);
                VDEvent result = vdb.getOnce(new VDEvent(VDEventCarInfo.MODULE_READONLY_INFO, request));
                Bundle payload = result == null ? null : result.getPayload();
                int[] values = payload == null ? null : payload.getIntArray("VALUE");
                if (values != null && values.length > 0) updateDoorState(item, values[0] != 0);
            } catch (Throwable t) {
                log("audio duck initial item " + item + " failed: " + t);
            }
        }
    }

    private void updateDoorState(int item, boolean open) {
        if (stopped) return;
        synchronized (stateLock) {
            if (open) {
                openDoorItems.add(item);
                restoreGeneration++;
                if (!ducked) {
                    try {
                        int current = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
                        int min = audio.getStreamMinVolume(AudioManager.STREAM_MUSIC);
                        // Keep (100 - DUCK_REDUCTION_PERCENT)% of the user volume.
                        float keep = 1.0f - DUCK_REDUCTION_PERCENT / 100.0f;
                        int target = Math.max(min, Math.round(current * keep));
                        savedVolume = current;
                        audio.setStreamVolume(AudioManager.STREAM_MUSIC, target, 0);
                        int immediate = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
                        // The HU applies volume changes asynchronously; track the command,
                        // not the stale readback returned immediately after setStreamVolume.
                        duckedVolume = target;
                        restoreExpectedVolume = target;
                        ducked = true;
                        log("audio duck: item=" + item + " saved=" + current
                                + " target=" + target + " actual=" + immediate);
                    } catch (Throwable t) {
                        log("audio duck failed: " + t);
                    }
                }
            } else {
                openDoorItems.remove(item);
                if (openDoorItems.isEmpty() && ducked) {
                    scheduleRestore(++restoreGeneration);
                }
            }
        }
    }

    private void scheduleRestore(int generation) {
        Handler handler = watchHandler;
        if (handler == null || audio == null) return;
        final int current = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
        if (current != duckedVolume) {
            log("door volume changed; leaving user value " + current
                    + " instead of restoring " + savedVolume);
            ducked = false;
            return;
        }
        final int from = current;
        final int target = savedVolume;
        restoreExpectedVolume = from;
        for (int step = 1; step <= RESTORE_STEPS; step++) {
            final int currentStep = step;
            handler.postDelayed(() -> {
                synchronized (stateLock) {
                    if (stopped) return;
                    if (generation != restoreGeneration || !openDoorItems.isEmpty() || !ducked) return;
                    int actual = audio.getStreamVolume(AudioManager.STREAM_MUSIC);
                    if (actual != restoreExpectedVolume) {
                        log("door volume changed; leaving user value " + actual + " during restore");
                        ducked = false;
                        return;
                    }
                    int value = from + Math.round((target - from) * (currentStep / (float) RESTORE_STEPS));
                    try {
                        audio.setStreamVolume(AudioManager.STREAM_MUSIC, value, 0);
                        restoreExpectedVolume = value;
                        if (currentStep == RESTORE_STEPS) {
                            ducked = false;
                            log("audio restore complete: " + audio.getStreamVolume(AudioManager.STREAM_MUSIC));
                        }
                    } catch (Throwable t) {
                        log("audio restore failed: " + t);
                        ducked = false;
                    }
                }
            }, currentStep * RESTORE_STEP_DELAY_MS);
        }
    }

    private static void log(String s) {
        Log.i(TAG, s);
    }
}
