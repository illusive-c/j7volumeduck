package com.desaysv.ivi.vdb.client.bind;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.desaysv.ivi.vdb.IVDBus;
import com.desaysv.ivi.vdb.IVDBusCallback;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.client.listener.VDBindListener;
import com.desaysv.ivi.vdb.client.listener.VDCallbackListener;
import com.desaysv.ivi.vdb.client.listener.VDGetListener;
import com.desaysv.ivi.vdb.client.listener.VDNotifyListener;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDValue;
import com.desaysv.ivi.vdb.event.id.vr.VDVRFunctionID;
import com.desaysv.ivi.vdb.utils.VDConfigUtil;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import com.desaysv.ivi.vdb.utils.VDServiceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public class VDConnector {
    public static final int RECEIVER_EXPORTED = 2;
    private Handler mChildThreadHandler;
    private Context mContext;
    private HandlerThread mDispatchEventThread;
    private IVDBusCallback.Stub mICallback;
    private VDServiceDef.ServiceInfo mServiceInfo;
    private ThreadPoolExecutor mThreadPoolExecutor;
    private final int RECONNECT_TOTAL = 10;
    private final int RECONNECT_SPACE = 3000;
    private final int MSG_RECONNECT_SERVICE = 1000;
    private final int MSG_DISPATCH_EVENT = VDVRFunctionID.VehicleSetting.VEHICLE_STOP_SLID_SUNROOF;
    private final int MSG_DISPATCH_GET_EVENT = 3000;
    private int mPid = Process.myPid();
    private IVDBus mIVDBus = null;
    private BinderDeathRecipient mDeathRecipient = new BinderDeathRecipient();
    private RebootReceiver mRebootReceiver = null;
    private int mReconnectCount = 0;
    private boolean mKeepBind = false;
    private boolean mIsSubscribeModified = false;
    private ArrayList<VDNotifyListener> mVDNotifyListenerList = new ArrayList<>();
    private ArrayList<VDCallbackListener> mVDCallbackListenerList = new ArrayList<>();
    private ArrayList<VDBindListener> mVDBindListenerList = new ArrayList<>();
    private ArrayList<VDEvent> mSetBuffer = new ArrayList<>();
    private ArrayList<VDEvent> mGetBuffer = new ArrayList<>();
    private ArrayList<VDEvent> mSubscribeBuffer = new ArrayList<>();
    private ArrayList<VDEvent> mThreadSubscribeBuffer = new ArrayList<>();
    private ArrayList<LocalCallback> mLocalCallbackList = new ArrayList<>();
    private Map<Integer, ArrayList<GetListenerInfo>> mGetMap = new HashMap();

    @SuppressLint({"HandlerLeak"})
    private Handler mMainThreadHandler = new Handler() { // from class: com.desaysv.ivi.vdb.client.bind.VDConnector.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1000) {
                VDLogUtil.i("MSG_RECONNECT_SERVICE count=" + VDConnector.this.mReconnectCount);
                if (VDConnector.this.mReconnectCount >= 10) {
                    VDConnector.this.mReconnectCount = 0;
                    return;
                } else {
                    VDConnector.access$108(VDConnector.this);
                    VDConnector.this.bindService();
                    return;
                }
            }
            if (i2 == 2000) {
                VDLogUtil.d("MSG_DISPATCH_EVENT");
                VDConnector.this.dispatchEvent((VDEvent) message.obj, VDThreadType.MAIN_THREAD);
            } else {
                if (i2 != 3000) {
                    return;
                }
                VDLogUtil.d("MSG_DISPATCH_GET_EVENT");
                Iterator it = ((Map) message.obj).entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ((VDGetListener) entry.getKey()).onVDGet((VDEvent) entry.getValue(), VDThreadType.MAIN_THREAD);
                }
            }
        }
    };
    private ServiceConnection mServiceConn = new ServiceConnection() { // from class: com.desaysv.ivi.vdb.client.bind.VDConnector.4
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            VDLogUtil.i("service=" + VDConnector.this.mServiceInfo.getServiceName() + ", client=" + VDConnector.this.mContext.getPackageName());
            try {
                iBinder.linkToDeath(VDConnector.this.mDeathRecipient, 0);
                VDConnector.this.mIVDBus = IVDBus.Stub.asInterface(iBinder);
                VDLogUtil.i("bind success! client=" + VDConnector.this.mContext.getPackageName());
                VDConnector.this.stopReconnect();
                VDConnector.this.onVDBusConnected();
            } catch (Exception e2) {
                VDLogUtil.e(e2.getMessage());
                e2.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            VDLogUtil.i("service=" + VDConnector.this.mServiceInfo.getServiceName() + ", client=" + VDConnector.this.mContext.getPackageName());
            VDConnector.this.mIVDBus = null;
        }
    };

    private class BinderDeathRecipient implements IBinder.DeathRecipient {
        private BinderDeathRecipient() {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            VDLogUtil.i("service=" + VDConnector.this.mServiceInfo.getServiceName() + ", client=" + VDConnector.this.mContext.getPackageName());
            if (VDConnector.this.mIVDBus != null) {
                VDConnector.this.mIVDBus.asBinder().unlinkToDeath(VDConnector.this.mDeathRecipient, 0);
                VDConnector.this.mIVDBus = null;
            }
            VDConnector.this.onVDBusDisconnected();
            if (!VDConnector.this.mServiceInfo.isSystemService()) {
                if (VDConnector.this.mKeepBind) {
                    VDLogUtil.i("keep bind service");
                    VDConnector.this.startReconnect();
                    return;
                }
                return;
            }
            VDLogUtil.i("system service! name=" + VDConnector.this.mServiceInfo.getServiceName());
            VDConnector.this.startReconnect();
        }
    }

    private class GetListenerInfo {
        public VDGetListener listener;
        public int threadType;

        public GetListenerInfo(VDGetListener vDGetListener, int i2) {
            this.listener = vDGetListener;
            this.threadType = i2;
        }
    }

    private class LocalCallback {
        private IVDBusNotify.Stub mCallback;
        private VDEvent mEvent;

        public LocalCallback(VDEvent vDEvent, IVDBusNotify.Stub stub) {
            this.mEvent = vDEvent;
            this.mCallback = stub;
        }

        public IVDBusNotify.Stub getCallback() {
            return this.mCallback;
        }

        public VDEvent getEvent() {
            return this.mEvent;
        }
    }

    private class RebootReceiver extends BroadcastReceiver {
        private RebootReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int size;
            int size2;
            int size3;
            int size4;
            VDLogUtil.i("action=" + intent.getAction() + ", client=" + VDConnector.this.mContext.getPackageName());
            if (VDConnector.this.mIVDBus != null) {
                VDLogUtil.i("service has bond!");
                return;
            }
            synchronized (VDConnector.this.mSubscribeBuffer) {
                size = VDConnector.this.mSubscribeBuffer.size();
                VDLogUtil.i("subscribe size=" + size);
            }
            synchronized (VDConnector.this.mLocalCallbackList) {
                size2 = VDConnector.this.mLocalCallbackList.size();
                VDLogUtil.i("localCallback size=" + size2);
            }
            synchronized (VDConnector.this.mSetBuffer) {
                size3 = VDConnector.this.mSetBuffer.size();
                VDLogUtil.i("set size=" + size3);
            }
            synchronized (VDConnector.this.mGetBuffer) {
                size4 = VDConnector.this.mGetBuffer.size();
                VDLogUtil.i("get size=" + size4);
            }
            if (size > 0 || size2 > 0 || size3 > 0 || size4 > 0) {
                VDConnector.this.bindService();
            }
        }
    }

    public VDConnector(Context context, VDServiceDef.ServiceInfo serviceInfo, ThreadPoolExecutor threadPoolExecutor) {
        this.mContext = null;
        this.mServiceInfo = null;
        this.mICallback = null;
        this.mContext = context;
        this.mServiceInfo = serviceInfo;
        this.mThreadPoolExecutor = threadPoolExecutor;
        this.mICallback = new IVDBusCallback.Stub() { // from class: com.desaysv.ivi.vdb.client.bind.VDConnector.3
            @Override // com.desaysv.ivi.vdb.IVDBusCallback
            public void onVDBusCallback(VDEvent vDEvent) throws RemoteException {
                if (vDEvent.getPayload() != null) {
                    vDEvent.getPayload().setClassLoader(VDEvent.class.getClassLoader());
                }
                synchronized (VDConnector.this.mVDCallbackListenerList) {
                    for (int i2 = 0; i2 < VDConnector.this.mVDCallbackListenerList.size(); i2++) {
                        VDCallbackListener vDCallbackListener = (VDCallbackListener) VDConnector.this.mVDCallbackListenerList.get(i2);
                        if (vDCallbackListener != null) {
                            vDCallbackListener.onVDCallback(vDEvent);
                        }
                    }
                }
            }

            @Override // com.desaysv.ivi.vdb.IVDBusCallback
            public void onVDBusNotify(VDEvent vDEvent) throws RemoteException {
                if (vDEvent.getPayload() != null) {
                    vDEvent.getPayload().setClassLoader(VDEvent.class.getClassLoader());
                }
                if (VDConfigUtil.UNIT_TEST_MODE) {
                    VDConnector.this.dispatchEvent(vDEvent, VDThreadType.MAIN_THREAD);
                    return;
                }
                int i2 = VDThreadType.MAIN_THREAD;
                synchronized (VDConnector.this.mThreadSubscribeBuffer) {
                    Iterator it = VDConnector.this.mThreadSubscribeBuffer.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        VDEvent vDEvent2 = (VDEvent) it.next();
                        if (vDEvent.getId() == vDEvent2.getId()) {
                            i2 = vDEvent2.getThreadType();
                            break;
                        }
                    }
                }
                if (i2 == VDThreadType.MAIN_THREAD || i2 == VDThreadType.MAIN_AND_CHILD_THREAD) {
                    Message obtainMessage = VDConnector.this.mMainThreadHandler.obtainMessage();
                    obtainMessage.what = VDVRFunctionID.VehicleSetting.VEHICLE_STOP_SLID_SUNROOF;
                    obtainMessage.obj = vDEvent;
                    VDConnector.this.mMainThreadHandler.sendMessage(obtainMessage);
                }
                if (i2 == VDThreadType.CHILD_THREAD || i2 == VDThreadType.MAIN_AND_CHILD_THREAD) {
                    Message obtainMessage2 = VDConnector.this.mChildThreadHandler.obtainMessage();
                    obtainMessage2.what = VDVRFunctionID.VehicleSetting.VEHICLE_STOP_SLID_SUNROOF;
                    obtainMessage2.obj = vDEvent;
                    VDConnector.this.mChildThreadHandler.sendMessage(obtainMessage2);
                }
            }
        };
        registerReceiver();
    }

    static /* synthetic */ int access$108(VDConnector vDConnector) {
        int i2 = vDConnector.mReconnectCount;
        vDConnector.mReconnectCount = i2 + 1;
        return i2;
    }

    private void callbackGet(final VDEvent vDEvent, int i2, final VDGetListener vDGetListener) {
        if (i2 == -1) {
            VDLogUtil.d("current thread");
            vDGetListener.onVDGet(vDEvent, i2);
            return;
        }
        if (i2 == VDThreadType.MAIN_THREAD || i2 == VDThreadType.MAIN_AND_CHILD_THREAD) {
            if (isMainThread()) {
                VDLogUtil.d("main thread");
                vDGetListener.onVDGet(vDEvent, VDThreadType.MAIN_THREAD);
            } else {
                VDLogUtil.d("child thread");
                HashMap hashMap = new HashMap();
                hashMap.put(vDGetListener, vDEvent);
                if (VDConfigUtil.UNIT_TEST_MODE) {
                    vDGetListener.onVDGet(vDEvent, VDThreadType.MAIN_THREAD);
                } else {
                    Message obtainMessage = this.mMainThreadHandler.obtainMessage();
                    obtainMessage.what = 3000;
                    obtainMessage.obj = hashMap;
                    this.mMainThreadHandler.sendMessage(obtainMessage);
                }
            }
        }
        if (i2 == VDThreadType.CHILD_THREAD || i2 == VDThreadType.MAIN_AND_CHILD_THREAD) {
            this.mThreadPoolExecutor.execute(new Runnable() { // from class: com.desaysv.ivi.vdb.client.bind.VDConnector.5
                @Override // java.lang.Runnable
                public void run() {
                    if (vDEvent == null) {
                        VDLogUtil.d("new thread");
                    } else {
                        VDLogUtil.d("new thread event=" + vDEvent.getId());
                    }
                    vDGetListener.onVDGet(vDEvent, VDThreadType.CHILD_THREAD);
                }
            });
        }
    }

    private int[] changeSubscribeBuffer(ArrayList<VDEvent> arrayList) {
        int i2 = 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[arrayList.size()];
        Iterator<VDEvent> it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i2] = it.next().getId();
            i2++;
        }
        return iArr;
    }

    private void createDispatchEventThread() {
        if (this.mDispatchEventThread == null) {
            VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
            HandlerThread handlerThread = new HandlerThread("VDBus_DISPATCH");
            this.mDispatchEventThread = handlerThread;
            handlerThread.start();
            this.mChildThreadHandler = new Handler(this.mDispatchEventThread.getLooper()) { // from class: com.desaysv.ivi.vdb.client.bind.VDConnector.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what != 2000) {
                        return;
                    }
                    VDLogUtil.d("MSG_DISPATCH_EVENT in thread");
                    VDConnector.this.dispatchEvent((VDEvent) message.obj, VDThreadType.CHILD_THREAD);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchEvent(VDEvent vDEvent, int i2) {
        VDLogUtil.d("event=" + vDEvent.getId());
        synchronized (this.mVDNotifyListenerList) {
            for (int i3 = 0; i3 < this.mVDNotifyListenerList.size(); i3++) {
                VDNotifyListener vDNotifyListener = this.mVDNotifyListenerList.get(i3);
                if (vDNotifyListener != null) {
                    vDNotifyListener.onVDNotify(vDEvent, i2);
                }
            }
        }
    }

    private void dispatchGet(VDEvent vDEvent, VDEvent vDEvent2) {
        if (VDValue.isNullEvent(vDEvent2)) {
            VDLogUtil.e("invalid event");
            vDEvent2 = null;
        } else if (vDEvent2.getPayload() != null) {
            vDEvent2.getPayload().setClassLoader(VDEvent.class.getClassLoader());
        }
        VDLogUtil.d("event=" + vDEvent.getId());
        ArrayList<GetListenerInfo> arrayList = this.mGetMap.get(Integer.valueOf(vDEvent.getId()));
        if (arrayList != null) {
            Iterator<GetListenerInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                GetListenerInfo next = it.next();
                callbackGet(vDEvent2, next.threadType, next.listener);
            }
            this.mGetMap.remove(Integer.valueOf(vDEvent.getId()));
        }
    }

    private boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private boolean isSystemApp() {
        boolean r2 = false;
        String packageName = this.mContext.getPackageName();
        PackageManager packageManager = this.mContext.getPackageManager();
        VDLogUtil.i("client=" + packageName);
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            VDLogUtil.i("client flags=" + applicationInfo.flags);
            r2 = (applicationInfo.flags & 1) > 0;
            VDLogUtil.i("client system flag=" + r2);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return r2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVDBusConnected() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mSubscribeBuffer) {
            VDLogUtil.i("subscribeBuffer size=" + this.mSubscribeBuffer.size());
            try {
                this.mIVDBus.subscribe(changeSubscribeBuffer(this.mSubscribeBuffer), this.mPid, this.mContext.getPackageName(), this.mICallback);
            } catch (RemoteException e2) {
                VDLogUtil.e("VDBus unbind error!!!");
                e2.printStackTrace();
            }
        }
        synchronized (this.mSetBuffer) {
            VDLogUtil.i("setBuffer size=" + this.mSetBuffer.size());
            try {
                Iterator<VDEvent> it = this.mSetBuffer.iterator();
                while (it.hasNext()) {
                    this.mIVDBus.set(it.next());
                }
            } catch (RemoteException e3) {
                VDLogUtil.e("VDBus unbind error!!!");
                e3.printStackTrace();
            }
            this.mSetBuffer.clear();
        }
        synchronized (this.mGetBuffer) {
            VDLogUtil.i("getBuffer size=" + this.mGetBuffer.size());
            try {
                Iterator<VDEvent> it2 = this.mGetBuffer.iterator();
                while (it2.hasNext()) {
                    VDEvent next = it2.next();
                    dispatchGet(next, this.mIVDBus.get(next));
                }
            } catch (RemoteException e4) {
                VDLogUtil.e("VDBus unbind error!!!");
                e4.printStackTrace();
            }
            this.mGetBuffer.clear();
        }
        synchronized (this.mVDBindListenerList) {
            Iterator<VDBindListener> it3 = this.mVDBindListenerList.iterator();
            while (it3.hasNext()) {
                VDBindListener next2 = it3.next();
                if (next2 != null) {
                    next2.onVDConnected(this.mServiceInfo.getServiceType());
                }
            }
        }
        synchronized (this.mLocalCallbackList) {
            VDLogUtil.i("localCallbackList size=" + this.mLocalCallbackList.size());
            try {
                Iterator<LocalCallback> it4 = this.mLocalCallbackList.iterator();
                while (it4.hasNext()) {
                    LocalCallback next3 = it4.next();
                    this.mIVDBus.subscribeCustomizedEvent(next3.getEvent(), next3.getCallback());
                }
            } catch (RemoteException e5) {
                VDLogUtil.e("VDBus unbind error!!!");
                e5.printStackTrace();
            }
            this.mLocalCallbackList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVDBusDisconnected() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDBindListenerList) {
            Iterator<VDBindListener> it = this.mVDBindListenerList.iterator();
            while (it.hasNext()) {
                VDBindListener next = it.next();
                if (next != null) {
                    next.onVDDisconnected(this.mServiceInfo.getServiceType());
                }
            }
        }
    }

    private void registerReceiver() {
        VDLogUtil.d("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        if (TextUtils.isEmpty(this.mServiceInfo.getServiceReboot()) || this.mRebootReceiver != null) {
            return;
        }
        this.mRebootReceiver = new RebootReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.mServiceInfo.getServiceReboot());
        if (Build.VERSION.SDK_INT >= 34) {
            this.mContext.registerReceiver(this.mRebootReceiver, intentFilter, 2);
        } else {
            this.mContext.registerReceiver(this.mRebootReceiver, intentFilter);
        }
    }

    private void sendCheckBootBroadcast() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName() + ", action=" + this.mServiceInfo.getServiceAction() + ", service pkg=" + this.mServiceInfo.getPackageName());
        String serviceAction = this.mServiceInfo.getServiceAction();
        if (!isSystemApp()) {
            serviceAction = serviceAction + VDServiceDef.SUFFIX_USER_APP_BROADCAST;
        }
        VDLogUtil.i("action=" + serviceAction);
        Intent intent = new Intent();
        intent.setAction(serviceAction);
        intent.setPackage(this.mServiceInfo.getPackageName());
        intent.putExtra("client", this.mContext.getPackageName());
        this.mContext.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReconnect() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        this.mMainThreadHandler.removeMessages(1000);
        this.mMainThreadHandler.sendEmptyMessageDelayed(1000, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopReconnect() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        this.mReconnectCount = 0;
        this.mMainThreadHandler.removeMessages(1000);
    }

    private void unregisterReceiver() {
        VDLogUtil.d("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        RebootReceiver rebootReceiver = this.mRebootReceiver;
        if (rebootReceiver == null) {
            return;
        }
        this.mContext.unregisterReceiver(rebootReceiver);
        this.mRebootReceiver = null;
    }

    public void addSubscribe(VDEvent vDEvent) {
        VDLogUtil.i("event=" + vDEvent.getId());
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        synchronized (this.mSubscribeBuffer) {
            Iterator<VDEvent> it = this.mSubscribeBuffer.iterator();
            while (it.hasNext()) {
                if (vDEvent.getId() == it.next().getId()) {
                    return;
                }
            }
            this.mSubscribeBuffer.add(vDEvent);
            this.mIsSubscribeModified = true;
            synchronized (this.mThreadSubscribeBuffer) {
                if (vDEvent.getThreadType() == VDThreadType.CHILD_THREAD || vDEvent.getThreadType() == VDThreadType.MAIN_AND_CHILD_THREAD) {
                    this.mThreadSubscribeBuffer.add(vDEvent);
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public boolean bindService() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        if (this.mIVDBus != null) {
            VDLogUtil.i("service has bond!");
            return true;
        }
        VDLogUtil.i("service pkg=" + this.mServiceInfo.getPackageName());
        startReconnect();
        if (this.mServiceInfo.isSystemService()) {
            VDLogUtil.i("system service");
            IBinder serviceFromServiceManager = VDServiceUtil.getServiceFromServiceManager(this.mServiceInfo.getServiceName());
            try {
                if (serviceFromServiceManager == null) {
                    VDLogUtil.e("binder is null");
                    return false;
                }
                serviceFromServiceManager.linkToDeath(this.mDeathRecipient, 0);
                try {
                    this.mIVDBus = IVDBus.Stub.asInterface(serviceFromServiceManager);
                    VDLogUtil.i("bind success! client=" + this.mContext.getPackageName());
                    stopReconnect();
                    onVDBusConnected();
                } catch (Exception e2) {
                    VDLogUtil.e(e2.getMessage());
                    e2.printStackTrace();
                    return false;
                }
            } catch (Exception e3) {
                VDLogUtil.e(e3.getMessage());
                e3.printStackTrace();
                return false;
            }
        } else {
            VDLogUtil.i("normal service");
            Intent intent = new Intent();
            intent.setAction(this.mServiceInfo.getServiceAction());
            intent.setPackage(this.mServiceInfo.getPackageName());
            // J7Recon: startForegroundService() on another app's service crashes the
            // CALLER (RemoteServiceException) if the target never calls
            // startForeground(). Plain startService is safe from a foreground app.
            VDLogUtil.i("startService");
            this.mContext.startService(intent);
            this.mContext.bindService(intent, this.mServiceConn, 1);
        }
        return true;
    }

    public void get(VDEvent vDEvent, int i2, VDGetListener vDGetListener) {
        ArrayList<GetListenerInfo> arrayList;
        VDEvent vDEvent2 = null;
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            callbackGet(null, i2, vDGetListener);
            return;
        }
        if (this.mIVDBus == null) {
            VDLogUtil.i("service unbind");
            bindService();
        }
        boolean z2 = false;
        boolean z3 = true;
        try {
            IVDBus iVDBus = this.mIVDBus;
            if (iVDBus != null) {
                VDEvent vDEvent3 = iVDBus.get(vDEvent);
                if (VDValue.isNullEvent(vDEvent3)) {
                    VDLogUtil.e("invalid event");
                } else {
                    if (vDEvent3.getPayload() != null) {
                        vDEvent3.getPayload().setClassLoader(VDEvent.class.getClassLoader());
                    }
                    vDEvent2 = vDEvent3;
                }
                callbackGet(vDEvent2, i2, vDGetListener);
            } else {
                z2 = true;
            }
            z3 = z2;
        } catch (RemoteException e2) {
            VDLogUtil.e("VDBus unbind error!!!");
            e2.printStackTrace();
        }
        if (z3) {
            synchronized (this.mGetBuffer) {
                if (this.mGetMap.containsKey(Integer.valueOf(vDEvent.getId()))) {
                    arrayList = this.mGetMap.get(Integer.valueOf(vDEvent.getId()));
                } else {
                    arrayList = new ArrayList<>();
                    this.mGetMap.put(Integer.valueOf(vDEvent.getId()), arrayList);
                }
                arrayList.add(new GetListenerInfo(vDGetListener, i2));
                Iterator<VDEvent> it = this.mGetBuffer.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VDEvent next = it.next();
                    if (vDEvent.getId() == next.getId()) {
                        this.mGetBuffer.remove(next);
                        break;
                    }
                }
                this.mGetBuffer.add(vDEvent);
            }
            bindService();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.desaysv.ivi.vdb.event.VDEvent getOnce(com.desaysv.ivi.vdb.event.VDEvent r5) {
        /*
            r4 = this;
            com.desaysv.ivi.vdb.client.bind.VDServiceDef$ServiceInfo r0 = r4.mServiceInfo
            boolean r0 = r0.isExist()
            r1 = 0
            if (r0 != 0) goto L24
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "service not install! name="
            r5.append(r0)
            com.desaysv.ivi.vdb.client.bind.VDServiceDef$ServiceInfo r0 = r4.mServiceInfo
            java.lang.String r0 = r0.getServiceName()
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            com.desaysv.ivi.vdb.utils.VDLogUtil.e(r5)
            return r1
        L24:
            com.desaysv.ivi.vdb.IVDBus r0 = r4.mIVDBus
            if (r0 != 0) goto L30
            java.lang.String r0 = "service unbind"
            com.desaysv.ivi.vdb.utils.VDLogUtil.i(r0)
            r4.bindService()
        L30:
            r0 = 0
            r2 = 1
            com.desaysv.ivi.vdb.IVDBus r3 = r4.mIVDBus     // Catch: android.os.RemoteException -> L61
            if (r3 == 0) goto L5e
            com.desaysv.ivi.vdb.event.VDEvent r5 = r3.get(r5)     // Catch: android.os.RemoteException -> L61
            boolean r3 = com.desaysv.ivi.vdb.event.base.VDValue.isNullEvent(r5)     // Catch: android.os.RemoteException -> L5b
            if (r3 == 0) goto L46
            java.lang.String r0 = "invalid event"
            com.desaysv.ivi.vdb.utils.VDLogUtil.e(r0)     // Catch: android.os.RemoteException -> L5b
            return r1
        L46:
            android.os.Bundle r1 = r5.getPayload()     // Catch: android.os.RemoteException -> L5b
            if (r1 == 0) goto L59
            android.os.Bundle r1 = r5.getPayload()     // Catch: android.os.RemoteException -> L5b
            java.lang.Class<com.desaysv.ivi.vdb.event.VDEvent> r3 = com.desaysv.ivi.vdb.event.VDEvent.class
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch: android.os.RemoteException -> L5b
            r1.setClassLoader(r3)     // Catch: android.os.RemoteException -> L5b
        L59:
            r1 = r5
            goto L5f
        L5b:
            r0 = move-exception
            r1 = r5
            goto L62
        L5e:
            r0 = r2
        L5f:
            r2 = r0
            goto L6a
        L61:
            r0 = move-exception
        L62:
            java.lang.String r5 = "VDBus unbind error!!!"
            com.desaysv.ivi.vdb.utils.VDLogUtil.e(r5)
            r0.printStackTrace()
        L6a:
            if (r2 == 0) goto L6f
            r4.bindService()
        L6f:
            return r1
        */
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return null;
        }
        if (this.mIVDBus == null) {
            VDLogUtil.i("service unbind");
            bindService();
        }
        VDEvent result = null;
        boolean needBind = false;
        try {
            IVDBus bus = this.mIVDBus;
            if (bus != null) {
                result = bus.get(r5);
                if (VDValue.isNullEvent(result)) {
                    VDLogUtil.e("invalid event");
                    return null;
                }
                if (result.getPayload() != null) {
                    result.getPayload().setClassLoader(VDEvent.class.getClassLoader());
                }
            } else {
                needBind = true;
            }
        } catch (RemoteException e) {
            VDLogUtil.e("VDBus unbind error!!!");
            e.printStackTrace();
        }
        if (needBind) bindService();
        return result;
    }

    VDServiceDef.ServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    public boolean isServiceConnected() {
        return this.mIVDBus != null;
    }

    public void keepBind(boolean z2) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        this.mKeepBind = z2;
    }

    public void registerVDBindListener(VDBindListener vDBindListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDBindListenerList) {
            if (!this.mVDBindListenerList.contains(vDBindListener)) {
                this.mVDBindListenerList.add(vDBindListener);
            }
        }
    }

    public void registerVDCallbackListener(VDCallbackListener vDCallbackListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDCallbackListenerList) {
            if (!this.mVDCallbackListenerList.contains(vDCallbackListener)) {
                this.mVDCallbackListenerList.add(vDCallbackListener);
            }
        }
    }

    public void registerVDNotifyListener(VDNotifyListener vDNotifyListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDNotifyListenerList) {
            if (!this.mVDNotifyListenerList.contains(vDNotifyListener)) {
                this.mVDNotifyListenerList.add(vDNotifyListener);
            }
        }
    }

    public void release() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        HandlerThread handlerThread = this.mDispatchEventThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        unregisterReceiver();
    }

    public void removeSubscribe(VDEvent vDEvent) {
        VDLogUtil.i("event=" + vDEvent.getId());
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        synchronized (this.mSubscribeBuffer) {
            Iterator<VDEvent> it = this.mSubscribeBuffer.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VDEvent next = it.next();
                if (vDEvent.getId() == next.getId()) {
                    this.mSubscribeBuffer.remove(next);
                    this.mIsSubscribeModified = true;
                    break;
                }
            }
        }
        synchronized (this.mThreadSubscribeBuffer) {
            Iterator<VDEvent> it2 = this.mThreadSubscribeBuffer.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                VDEvent next2 = it2.next();
                if (vDEvent.getId() == next2.getId()) {
                    this.mThreadSubscribeBuffer.remove(next2);
                    break;
                }
            }
        }
    }

    public void set(VDEvent vDEvent) {
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        if (this.mIVDBus == null) {
            VDLogUtil.i("service unbind");
            bindService();
        }
        boolean z2 = false;
        boolean z3 = true;
        try {
            IVDBus iVDBus = this.mIVDBus;
            if (iVDBus != null) {
                iVDBus.set(vDEvent);
            } else {
                z2 = true;
            }
            z3 = z2;
        } catch (RemoteException e2) {
            VDLogUtil.e("VDBus unbind error!!!");
            e2.printStackTrace();
        }
        if (z3) {
            synchronized (this.mSetBuffer) {
                Iterator<VDEvent> it = this.mSetBuffer.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VDEvent next = it.next();
                    if (vDEvent.getId() == next.getId()) {
                        this.mSetBuffer.remove(next);
                        break;
                    }
                }
                this.mSetBuffer.add(vDEvent);
            }
            bindService();
        }
    }

    public void setOnce(VDEvent vDEvent) {
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        if (this.mIVDBus == null) {
            VDLogUtil.i("service unbind");
            bindService();
        }
        boolean z2 = false;
        boolean z3 = true;
        try {
            IVDBus iVDBus = this.mIVDBus;
            if (iVDBus != null) {
                iVDBus.set(vDEvent);
            } else {
                z2 = true;
            }
            z3 = z2;
        } catch (RemoteException e2) {
            VDLogUtil.e("VDBus unbind error!!!");
            e2.printStackTrace();
        }
        if (z3) {
            bindService();
        }
    }

    public void subscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        if (this.mIVDBus == null) {
            VDLogUtil.i("service unbind");
            if (this.mServiceInfo.isSystemService()) {
                VDLogUtil.i("system service! name=" + this.mServiceInfo.getServiceName());
                bindService();
            } else {
                sendCheckBootBroadcast();
            }
        }
        boolean z2 = false;
        boolean z3 = true;
        try {
            IVDBus iVDBus = this.mIVDBus;
            if (iVDBus != null) {
                iVDBus.subscribeCustomizedEvent(vDEvent, stub);
            } else {
                z2 = true;
            }
            z3 = z2;
        } catch (RemoteException e2) {
            VDLogUtil.e("VDBus unbind error!!!");
            e2.printStackTrace();
        }
        if (z3) {
            synchronized (this.mLocalCallbackList) {
                Iterator<LocalCallback> it = this.mLocalCallbackList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LocalCallback next = it.next();
                    if (vDEvent == next.getEvent() && stub == next.getCallback()) {
                        this.mLocalCallbackList.remove(next);
                        break;
                    }
                }
                this.mLocalCallbackList.add(new LocalCallback(vDEvent, stub));
            }
        }
    }

    public void subscribeCommit() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        synchronized (this.mSubscribeBuffer) {
            if (this.mIsSubscribeModified) {
                VDLogUtil.i("subscribe buffer has changed");
                this.mIsSubscribeModified = false;
                createDispatchEventThread();
                if (this.mIVDBus == null) {
                    VDLogUtil.i("service unbind");
                    if (this.mServiceInfo.isSystemService()) {
                        VDLogUtil.i("system service! name=" + this.mServiceInfo.getServiceName());
                        bindService();
                    } else {
                        sendCheckBootBroadcast();
                    }
                }
                try {
                    IVDBus iVDBus = this.mIVDBus;
                    if (iVDBus != null) {
                        iVDBus.subscribe(changeSubscribeBuffer(this.mSubscribeBuffer), this.mPid, this.mContext.getPackageName(), this.mICallback);
                    }
                } catch (RemoteException e2) {
                    VDLogUtil.e("VDBus unbind error!!!");
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean unbindService() {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        try {
            if (this.mIVDBus != null) {
                synchronized (this.mSubscribeBuffer) {
                    this.mSubscribeBuffer.clear();
                    this.mIVDBus.subscribe(changeSubscribeBuffer(this.mSubscribeBuffer), this.mPid, this.mContext.getPackageName(), this.mICallback);
                }
                synchronized (this.mThreadSubscribeBuffer) {
                    this.mThreadSubscribeBuffer.clear();
                }
                this.mIVDBus = null;
            }
            if (this.mServiceInfo.isSystemService()) {
                return true;
            }
            this.mContext.unbindService(this.mServiceConn);
            return true;
        } catch (Exception e2) {
            VDLogUtil.e(e2.getMessage());
            e2.printStackTrace();
            return false;
        }
    }

    public void unregisterVDBindListener(VDBindListener vDBindListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDBindListenerList) {
            this.mVDBindListenerList.remove(vDBindListener);
        }
    }

    public void unregisterVDCallbackListener(VDCallbackListener vDCallbackListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDCallbackListenerList) {
            this.mVDCallbackListenerList.remove(vDCallbackListener);
        }
    }

    public void unregisterVDNotifyListener(VDNotifyListener vDNotifyListener) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        synchronized (this.mVDNotifyListenerList) {
            this.mVDNotifyListenerList.remove(vDNotifyListener);
        }
    }

    public void unsubscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        VDLogUtil.i("service=" + this.mServiceInfo.getServiceName() + ", client=" + this.mContext.getPackageName());
        if (!this.mServiceInfo.isExist()) {
            VDLogUtil.e("service not install! name=" + this.mServiceInfo.getServiceName());
            return;
        }
        try {
            IVDBus iVDBus = this.mIVDBus;
            if (iVDBus != null) {
                iVDBus.unsubscribeCustomizedEvent(vDEvent, stub);
            }
        } catch (RemoteException e2) {
            VDLogUtil.e("VDBus unbind error!!!");
            e2.printStackTrace();
        }
    }
}
