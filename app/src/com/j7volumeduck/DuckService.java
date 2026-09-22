package com.j7volumeduck;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.j7volumeduck.audio.AudioDuckFeature;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DuckService extends Service {

    private static final String TAG = "J7VolumeDuck";
    private static final String CHANNEL_ID = "volume_duck";
    private static final int NOTIFICATION_ID = 1;
    private static volatile boolean crashHandlerInstalled;

    private AudioDuckFeature audioDuck;

    public static void start(Context context) {
        Intent intent = new Intent(context, DuckService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        installCrashHandler();
        startInForeground();
        if (audioDuck == null) {
            audioDuck = new AudioDuckFeature(this);
        }
        audioDuck.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (audioDuck != null) {
            audioDuck.stop();
        }
        super.onDestroy();
    }

    private void startInForeground() {
        NotificationManager manager = getSystemService(NotificationManager.class);
        if (manager != null) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    getString(R.string.notification_channel_name),
                    NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channel);
        }
        Notification notification = new Notification.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_menu_manage)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .setOngoing(true)
                .build();
        startForeground(NOTIFICATION_ID, notification);
    }

    private void installCrashHandler() {
        if (crashHandlerInstalled) {
            return;
        }
        crashHandlerInstalled = true;
        final Context app = getApplicationContext();
        final Thread.UncaughtExceptionHandler previous =
                Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                try {
                    StringWriter buffer = new StringWriter();
                    throwable.printStackTrace(new PrintWriter(buffer));
                    Writer writer = new OutputStreamWriter(new FileOutputStream(
                            new File(app.getFilesDir(), "crash.txt"), true), "UTF-8");
                    writer.write("==== " + timestamp() + " thread=" + thread.getName()
                            + " version=" + app.getPackageName() + " ====\n");
                    writer.write(buffer.toString());
                    writer.write("\n");
                    writer.close();
                } catch (Throwable ignored) {
                }
                if (previous != null) {
                    previous.uncaughtException(thread, throwable);
                }
            }
        });
    }

    private static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)
                .format(new java.util.Date());
    }
}
