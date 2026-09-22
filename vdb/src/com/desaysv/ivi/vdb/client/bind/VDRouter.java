package com.desaysv.ivi.vdb.client.bind;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.client.listener.VDBindListener;
import com.desaysv.ivi.vdb.client.listener.VDCallbackListener;
import com.desaysv.ivi.vdb.client.listener.VDGetListListener;
import com.desaysv.ivi.vdb.client.listener.VDGetListener;
import com.desaysv.ivi.vdb.client.listener.VDNotifyListener;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDValue;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class VDRouter {
    private final int CORE_POOL_SIZE;
    private final int CPU_COUNT;
    private final int KEEP_ALIVE;
    private final int MAXIMUM_POOL_SIZE;

    @SuppressLint({"HandlerLeak"})
    private Handler mDebounceHandler;

    @SuppressLint({"HandlerLeak"})
    private Handler mMainThreadHandler;
    private ThreadPoolExecutor mThreadPoolExecutor;
    private final int MSG_DISPATCH_GET_LIST_EVENT = 1000;
    private final int MAX_DEBOUNCE_NUM = 10;
    private Context mContext = null;
    private boolean mIsInited = false;
    private ArrayList<VDConnector> mVDConnectorList = new ArrayList<>();
    private VDConnector mCurVDConnector = null;
    private Map<GetListListenerInfo, ArrayList<VDEvent>> mListenerMap = new HashMap();
    private Map<GetListListenerInfo, ArrayList<VDEvent>> mListenerMapClone = new HashMap();
    private ArrayList<VDEvent> mDebounceList = new ArrayList<>();

    private class GetListListenerInfo {
        public VDGetListListener listener;
        public int threadType;

        public GetListListenerInfo(VDGetListListener vDGetListListener, int i2) {
            this.listener = vDGetListListener;
            this.threadType = i2;
        }
    }

    public VDRouter() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.CPU_COUNT = availableProcessors;
        this.CORE_POOL_SIZE = availableProcessors + 1;
        this.MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
        this.KEEP_ALIVE = 1;
        this.mMainThreadHandler = new Handler() { // from class: com.desaysv.ivi.vdb.client.bind.VDRouter.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1000) {
                    return;
                }
                VDLogUtil.d("MSG_DISPATCH_GET_LIST_EVENT");
                Iterator it = ((Map) message.obj).entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    ((GetListListenerInfo) entry.getKey()).listener.onVDGetList((ArrayList) entry.getValue(), VDThreadType.MAIN_THREAD);
                }
            }
        };
        this.mDebounceHandler = new Handler() { // from class: com.desaysv.ivi.vdb.client.bind.VDRouter.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                VDEvent vDEvent = (VDEvent) message.obj;
                int i2 = message.arg1;
                VDLogUtil.i("debounce event=" + message.what);
                VDConnector connector = VDRouter.this.getConnector(vDEvent);
                if (connector != null) {
                    if (i2 == 0) {
                        connector.set(vDEvent);
                    } else {
                        connector.setOnce(vDEvent);
                    }
                }
            }
        };
    }

    private boolean dealDebounce(VDEvent vDEvent, int i2, int i3) {
        if (i2 <= 0) {
            return true;
        }
        synchronized (this.mDebounceList) {
            Iterator<VDEvent> it = this.mDebounceList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VDEvent next = it.next();
                if (next.getId() == vDEvent.getId()) {
                    this.mDebounceHandler.removeMessages(vDEvent.getId());
                    long j2 = i2;
                    if (Math.abs(vDEvent.getTimeMillis() - next.getTimeMillis()) < j2) {
                        VDLogUtil.e("catch a debounce event=" + vDEvent.getId() + ", time=" + vDEvent.getTimeMillis());
                        Message obtainMessage = this.mDebounceHandler.obtainMessage();
                        obtainMessage.what = vDEvent.getId();
                        obtainMessage.obj = vDEvent;
                        obtainMessage.arg1 = i3;
                        this.mDebounceHandler.sendMessageDelayed(obtainMessage, j2);
                        return false;
                    }
                    this.mDebounceList.remove(next);
                }
            }
            this.mDebounceList.add(0, vDEvent);
            if (this.mDebounceList.size() > 10) {
                this.mDebounceList.remove(10);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealGetListCallback(VDEvent vDEvent) {
        HashMap<GetListListenerInfo, ArrayList<VDEvent>> hashMap = new HashMap<>();
        synchronized (this.mListenerMap) {
            Iterator<Map.Entry<GetListListenerInfo, ArrayList<VDEvent>>> it = this.mListenerMap.entrySet().iterator();
            Iterator<Map.Entry<GetListListenerInfo, ArrayList<VDEvent>>> it2 = this.mListenerMapClone.entrySet().iterator();
            while (it2.hasNext() && it.hasNext()) {
                Map.Entry<GetListListenerInfo, ArrayList<VDEvent>> next = it.next();
                Map.Entry<GetListListenerInfo, ArrayList<VDEvent>> next2 = it2.next();
                ArrayList<VDEvent> value = next.getValue();
                ArrayList<VDEvent> value2 = next2.getValue();
                Iterator<VDEvent> it3 = value.iterator();
                while (it3.hasNext()) {
                    VDEvent next3 = it3.next();
                    if (next3.getId() == vDEvent.getId()) {
                        next3.setPayload(vDEvent.getPayload());
                    }
                }
                int i2 = 0;
                while (i2 < value2.size()) {
                    if (value2.get(i2).getId() == vDEvent.getId()) {
                        value2.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                if (value2.size() <= 0) {
                    VDLogUtil.d("no client");
                    hashMap.put(next.getKey(), value);
                    it.remove();
                    it2.remove();
                }
            }
        }
        for (java.util.Map.Entry<GetListListenerInfo, ArrayList<VDEvent>> entry : hashMap.entrySet()) {
            final GetListListenerInfo getListListenerInfo = (GetListListenerInfo) entry.getKey();
            final ArrayList<VDEvent> arrayList = (ArrayList) entry.getValue();
            int i3 = getListListenerInfo.threadType;
            if (i3 == VDThreadType.MAIN_THREAD || i3 == VDThreadType.MAIN_AND_CHILD_THREAD) {
                if (isMainThread()) {
                    VDLogUtil.d("main thread");
                    getListListenerInfo.listener.onVDGetList(arrayList, VDThreadType.MAIN_THREAD);
                } else {
                    VDLogUtil.d("child thread");
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(getListListenerInfo, arrayList);
                    Message obtainMessage = this.mMainThreadHandler.obtainMessage();
                    obtainMessage.what = 1000;
                    obtainMessage.obj = hashMap2;
                    this.mMainThreadHandler.sendMessage(obtainMessage);
                }
            }
            int i4 = getListListenerInfo.threadType;
            if (i4 == VDThreadType.CHILD_THREAD || i4 == VDThreadType.MAIN_AND_CHILD_THREAD) {
                this.mThreadPoolExecutor.execute(new Runnable() { // from class: com.desaysv.ivi.vdb.client.bind.VDRouter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        VDLogUtil.d("new thread");
                        getListListenerInfo.listener.onVDGetList(arrayList, VDThreadType.CHILD_THREAD);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VDConnector getConnector(VDEvent vDEvent) {
        int id = vDEvent.getId() >> 16;
        VDConnector vDConnector = this.mCurVDConnector;
        if (vDConnector != null && vDConnector.getServiceInfo().getServiceType().getValue() == id) {
            return this.mCurVDConnector;
        }
        if (id >= this.mVDConnectorList.size()) {
            return null;
        }
        VDConnector vDConnector2 = this.mVDConnectorList.get(id);
        this.mCurVDConnector = vDConnector2;
        return vDConnector2;
    }

    private boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public void addSubscribe(VDEvent vDEvent, int i2) {
        if (VDValue.isNullEvent(vDEvent)) {
            return;
        }
        vDEvent.setThreadType(i2);
        VDConnector connector = getConnector(vDEvent);
        if (connector != null) {
            connector.addSubscribe(vDEvent);
        }
    }

    public boolean bindService(VDServiceDef.ServiceType serviceType) {
        VDConnector connector = getConnector(serviceType);
        if (connector != null) {
            return connector.bindService();
        }
        return false;
    }

    public void get(VDEvent vDEvent, int i2, VDGetListener vDGetListener) {
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        if (vDGetListener == null) {
            VDLogUtil.e("invalid listener");
            return;
        }
        VDConnector connector = getConnector(vDEvent);
        if (connector != null) {
            connector.get(vDEvent, i2, vDGetListener);
        }
    }

    public void getList(ArrayList<VDEvent> arrayList, int i2, VDGetListListener vDGetListListener) {
        if (arrayList == null || arrayList.size() <= 0) {
            VDLogUtil.e("invalid event list");
            return;
        }
        if (vDGetListListener == null) {
            VDLogUtil.e("invalid listener");
            return;
        }
        synchronized (this.mListenerMap) {
            GetListListenerInfo getListListenerInfo = new GetListListenerInfo(vDGetListListener, i2);
            this.mListenerMap.put(getListListenerInfo, arrayList);
            this.mListenerMapClone.put(getListListenerInfo, (ArrayList) arrayList.clone());
        }
        Iterator<VDEvent> it = arrayList.iterator();
        while (it.hasNext()) {
            VDEvent next = it.next();
            VDConnector connector = getConnector(next);
            if (connector != null) {
                connector.get(next, -1, new VDGetListener() { // from class: com.desaysv.ivi.vdb.client.bind.VDRouter.2
                    @Override // com.desaysv.ivi.vdb.client.listener.VDGetListener
                    public void onVDGet(VDEvent vDEvent, int i3) {
                        VDRouter.this.dealGetListCallback(vDEvent);
                    }
                });
            }
        }
    }

    public VDEvent getOnce(VDEvent vDEvent) {
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return null;
        }
        VDConnector connector = getConnector(vDEvent);
        if (connector != null) {
            return connector.getOnce(vDEvent);
        }
        return null;
    }

    public void init(Context context, VDThreadConfig vDThreadConfig, ArrayList<String> arrayList) {
        if (context == null) {
            VDLogUtil.i("context is null");
            return;
        }
        if (this.mIsInited) {
            VDLogUtil.i("vdb has inited!");
            return;
        }
        this.mIsInited = true;
        this.mContext = context;
        VDLogUtil.i("client=" + this.mContext.getPackageName());
        if (vDThreadConfig == null) {
            VDLogUtil.i("CORE_POOL_SIZE=" + this.CORE_POOL_SIZE);
            VDLogUtil.i("MAXIMUM_POOL_SIZE=" + this.MAXIMUM_POOL_SIZE);
            this.mThreadPoolExecutor = new ThreadPoolExecutor(this.CORE_POOL_SIZE, this.MAXIMUM_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
        } else {
            VDLogUtil.i("CORE_POOL_SIZE=" + vDThreadConfig.corePoolSize);
            VDLogUtil.i("MAXIMUM_POOL_SIZE=" + vDThreadConfig.maximumPoolSize);
            this.mThreadPoolExecutor = new ThreadPoolExecutor(vDThreadConfig.corePoolSize, vDThreadConfig.maximumPoolSize, vDThreadConfig.keepAliveTime, vDThreadConfig.timeUnit, vDThreadConfig.workQueue);
        }
        Iterator<VDServiceDef.ServiceInfo> it = VDServiceDef.createServiceList(this.mContext).iterator();
        while (it.hasNext()) {
            VDServiceDef.ServiceInfo next = it.next();
            VDConnector vDConnector = new VDConnector(context, next, this.mThreadPoolExecutor);
            this.mVDConnectorList.add(vDConnector);
            if (arrayList != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i2).equals(next.getServiceName())) {
                        vDConnector.keepBind(true);
                        arrayList.remove(i2);
                        break;
                    }
                    i2++;
                }
            }
        }
    }

    public boolean isServiceConnected(VDServiceDef.ServiceType serviceType) {
        VDConnector connector = getConnector(serviceType);
        if (connector != null) {
            return connector.isServiceConnected();
        }
        return false;
    }

    public void registerVDBindListener(VDBindListener vDBindListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().registerVDBindListener(vDBindListener);
        }
    }

    public void registerVDCallbackListener(VDCallbackListener vDCallbackListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().registerVDCallbackListener(vDCallbackListener);
        }
    }

    public void registerVDNotifyListener(VDNotifyListener vDNotifyListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().registerVDNotifyListener(vDNotifyListener);
        }
    }

    public void release() {
        if (this.mContext != null) {
            VDLogUtil.i("client=" + this.mContext.getPackageName());
        } else {
            VDLogUtil.i("context is null");
        }
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            VDConnector next = it.next();
            if (next.isServiceConnected()) {
                VDLogUtil.i("connector=" + next.getServiceInfo().getServiceName());
                next.unbindService();
            }
            next.release();
        }
        this.mVDConnectorList.clear();
        this.mIsInited = false;
    }

    public void removeSubscribe(VDEvent vDEvent) {
        VDConnector connector;
        if (VDValue.isNullEvent(vDEvent) || (connector = getConnector(vDEvent)) == null) {
            return;
        }
        connector.removeSubscribe(vDEvent);
    }

    public void set(VDEvent vDEvent, int i2) {
        VDConnector connector;
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        vDEvent.createTimeMillis();
        if (!dealDebounce(vDEvent, i2, 0) || (connector = getConnector(vDEvent)) == null) {
            return;
        }
        connector.set(vDEvent);
    }

    public void setOnce(VDEvent vDEvent, int i2) {
        VDConnector connector;
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        vDEvent.createTimeMillis();
        if (!dealDebounce(vDEvent, i2, 1) || (connector = getConnector(vDEvent)) == null) {
            return;
        }
        connector.setOnce(vDEvent);
    }

    public void subscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        if (stub == null) {
            VDLogUtil.e("invalid callback");
            return;
        }
        VDConnector connector = getConnector(vDEvent);
        if (connector != null) {
            connector.subscribe(vDEvent, stub);
        }
    }

    public void subscribeCommit() {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().subscribeCommit();
        }
    }

    public boolean unbindService(VDServiceDef.ServiceType serviceType) {
        VDConnector connector = getConnector(serviceType);
        if (connector != null) {
            return connector.unbindService();
        }
        return false;
    }

    public void unregisterVDBindListener(VDBindListener vDBindListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().unregisterVDBindListener(vDBindListener);
        }
    }

    public void unregisterVDCallbackListener(VDCallbackListener vDCallbackListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().unregisterVDCallbackListener(vDCallbackListener);
        }
    }

    public void unregisterVDNotifyListener(VDNotifyListener vDNotifyListener) {
        Iterator<VDConnector> it = this.mVDConnectorList.iterator();
        while (it.hasNext()) {
            it.next().unregisterVDNotifyListener(vDNotifyListener);
        }
    }

    public void unsubscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        if (stub == null) {
            VDLogUtil.e("invalid callback");
            return;
        }
        VDConnector connector = getConnector(vDEvent);
        if (connector != null) {
            connector.unsubscribe(vDEvent, stub);
        }
    }

    private VDConnector getConnector(VDServiceDef.ServiceType serviceType) {
        VDConnector vDConnector = this.mCurVDConnector;
        if (vDConnector != null && vDConnector.getServiceInfo().getServiceType() == serviceType) {
            return this.mCurVDConnector;
        }
        int value = serviceType.getValue();
        if (value >= this.mVDConnectorList.size()) {
            return null;
        }
        VDConnector vDConnector2 = this.mVDConnectorList.get(value);
        this.mCurVDConnector = vDConnector2;
        return vDConnector2;
    }
}
