package com.desaysv.ivi.vdb.service.bind;

import android.os.IBinder;
import android.os.RemoteException;
import com.desaysv.ivi.vdb.IVDBus;
import com.desaysv.ivi.vdb.IVDBusCallback;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDValue;
import com.desaysv.ivi.vdb.service.base.VDService;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import com.desaysv.ivi.vdb.utils.VDServiceUtil;
import com.limpoxe.fairy.manager.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class VDBinder extends IVDBus.Stub {
    private VDService mVDService;
    private final int MAX_HISTORY_NUM = 10;
    private Map<Integer, ArrayList<VDClient>> mEventMap = new HashMap();
    private Map<IBinder, int[]> mBinderMap = new HashMap();
    private ArrayList<VDEvent> mHistoryEventList = new ArrayList<>();
    private ArrayList<CustomizedClientDeath> mCustomizedClientDeathList = new ArrayList<>();

    private class ClientDeath implements IBinder.DeathRecipient {
        private IVDBusCallback mVDBusCallback;

        public ClientDeath(IVDBusCallback iVDBusCallback) {
            this.mVDBusCallback = null;
            this.mVDBusCallback = iVDBusCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            VDLogUtil.i(c.f7663i);
            VDBinder.this.removeClientNode(this.mVDBusCallback);
            VDLogUtil.i("end");
        }
    }

    private class CustomizedClientDeath implements IBinder.DeathRecipient {
        private IVDBusNotify mCallback;
        private ArrayList<Integer> mEventList = new ArrayList<>();

        public CustomizedClientDeath(IVDBusNotify iVDBusNotify) {
            this.mCallback = iVDBusNotify;
        }

        private int findEvent(int i2) {
            for (int i3 = 0; i3 < this.mEventList.size(); i3++) {
                if (this.mEventList.get(i3).intValue() == i2) {
                    return i3;
                }
            }
            return -1;
        }

        public void addEvent(int i2) {
            int findEvent = findEvent(i2);
            VDLogUtil.i("index=" + findEvent + ", eventId=" + i2);
            if (findEvent >= 0) {
                return;
            }
            this.mEventList.add(Integer.valueOf(i2));
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (VDBinder.this.mCustomizedClientDeathList) {
                Iterator it = VDBinder.this.mCustomizedClientDeathList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CustomizedClientDeath customizedClientDeath = (CustomizedClientDeath) it.next();
                    if (customizedClientDeath.getCallback().asBinder() == this.mCallback.asBinder()) {
                        VDLogUtil.i("client exist");
                        this.mEventList.clear();
                        VDBinder.this.mCustomizedClientDeathList.remove(customizedClientDeath);
                        VDBinder.this.mVDService.onCustomizedClientDeath(this.mCallback.asBinder());
                        break;
                    }
                }
            }
        }

        public void clearEvent() {
            this.mEventList.clear();
        }

        public int eventSize() {
            return this.mEventList.size();
        }

        public IVDBusNotify getCallback() {
            return this.mCallback;
        }

        public void removeEvent(int i2) {
            int findEvent = findEvent(i2);
            VDLogUtil.i("index=" + findEvent + ", eventId=" + i2);
            if (findEvent >= 0) {
                this.mEventList.remove(findEvent);
            }
        }
    }

    public VDBinder(VDService vDService) {
        this.mVDService = null;
        this.mVDService = vDService;
        VDLogUtil.i("pkgName=" + this.mVDService.getPackageName());
        VDServiceDef.ServiceInfo serviceInfo = VDServiceDef.getServiceInfo(this.mVDService.getPackageName());
        if (serviceInfo == null || !serviceInfo.isSystemService()) {
            return;
        }
        VDServiceUtil.addServiceToServiceManager(this, serviceInfo.getServiceName());
    }

    private void addClientNode(int[] iArr, int i2, String str, IVDBusCallback iVDBusCallback) {
        ArrayList<VDClient> arrayList;
        VDLogUtil.i("pid=" + i2 + ", packageName=" + str + ", service package=" + this.mVDService.getPackageName());
        IBinder asBinder = iVDBusCallback.asBinder();
        StringBuilder sb = new StringBuilder();
        sb.append("binder=");
        sb.append(asBinder);
        VDLogUtil.i(sb.toString());
        removeBinder(asBinder);
        synchronized (this.mBinderMap) {
            this.mBinderMap.put(asBinder, iArr);
        }
        synchronized (this.mEventMap) {
            for (int i3 : iArr) {
                if (this.mEventMap.containsKey(Integer.valueOf(i3))) {
                    arrayList = this.mEventMap.get(Integer.valueOf(i3));
                } else {
                    arrayList = new ArrayList<>();
                    this.mEventMap.put(Integer.valueOf(i3), arrayList);
                }
                arrayList.add(new VDClient(new VDEvent(i3), i2, str, iVDBusCallback));
            }
        }
    }

    private boolean dealHistoryEvent(VDEvent vDEvent) {
        synchronized (this.mHistoryEventList) {
            Iterator<VDEvent> it = this.mHistoryEventList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VDEvent next = it.next();
                if (next.getId() == vDEvent.getId()) {
                    if (next.getTimeMillis() > vDEvent.getTimeMillis()) {
                        VDLogUtil.e("catch an obsolete event=" + vDEvent.getId() + ", time=" + vDEvent.getTimeMillis());
                        return false;
                    }
                    this.mHistoryEventList.remove(next);
                }
            }
            this.mHistoryEventList.add(0, vDEvent);
            if (this.mHistoryEventList.size() > 10) {
                this.mHistoryEventList.remove(10);
            }
            return true;
        }
    }

    private void removeBinder(IBinder iBinder) {
        synchronized (this.mEventMap) {
            synchronized (this.mBinderMap) {
                int[] iArr = this.mBinderMap.get(iBinder);
                if (iArr != null) {
                    VDLogUtil.i("has event list");
                    for (int i2 : iArr) {
                        ArrayList<VDClient> arrayList = this.mEventMap.get(Integer.valueOf(i2));
                        Iterator<VDClient> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            VDClient next = it.next();
                            if (next.getCallback().asBinder() == iBinder) {
                                VDLogUtil.i("remove client! event=" + i2);
                                arrayList.remove(next);
                                break;
                            }
                        }
                        if (arrayList.size() <= 0) {
                            VDLogUtil.i("no client now");
                            this.mEventMap.remove(Integer.valueOf(i2));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeClientNode(IVDBusCallback iVDBusCallback) {
        VDLogUtil.i("service package=" + this.mVDService.getPackageName());
        IBinder asBinder = iVDBusCallback.asBinder();
        VDLogUtil.i("binder=" + asBinder);
        removeBinder(asBinder);
        synchronized (this.mBinderMap) {
            this.mBinderMap.remove(asBinder);
        }
    }

    public void callback(VDEvent vDEvent) {
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        synchronized (this.mEventMap) {
            ArrayList<VDClient> arrayList = this.mEventMap.get(Integer.valueOf(vDEvent.getId()));
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    VDClient vDClient = arrayList.get(i2);
                    try {
                        VDEvent subscribeEvent = vDClient.getSubscribeEvent();
                        subscribeEvent.setPayload(vDEvent.getPayload());
                        vDClient.getCallback().onVDBusCallback(subscribeEvent);
                    } catch (RemoteException e2) {
                        VDLogUtil.e("client remote exception");
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        VDLogUtil.e(e3.getMessage());
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.desaysv.ivi.vdb.IVDBus
    public VDEvent get(VDEvent vDEvent) throws RemoteException {
        if (vDEvent.getPayload() != null) {
            vDEvent.getPayload().setClassLoader(VDEvent.class.getClassLoader());
        }
        vDEvent.setPayload(this.mVDService.onGet(vDEvent));
        return vDEvent;
    }

    public void publish(VDEvent vDEvent) {
        VDLogUtil.i("service package=" + this.mVDService.getPackageName());
        if (VDValue.isNullEvent(vDEvent)) {
            VDLogUtil.e("invalid event");
            return;
        }
        synchronized (this.mEventMap) {
            ArrayList<VDClient> arrayList = this.mEventMap.get(Integer.valueOf(vDEvent.getId()));
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    VDClient vDClient = arrayList.get(i2);
                    try {
                        VDEvent subscribeEvent = vDClient.getSubscribeEvent();
                        subscribeEvent.setPayload(vDEvent.getPayload());
                        VDLogUtil.d("event=" + subscribeEvent.getId() + ", pid=" + vDClient.getPid());
                        vDClient.getCallback().onVDBusNotify(subscribeEvent);
                    } catch (RemoteException e2) {
                        VDLogUtil.e("client remote exception");
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        VDLogUtil.e(e3.getMessage());
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    @Override // com.desaysv.ivi.vdb.IVDBus
    public void set(VDEvent vDEvent) throws RemoteException {
        if (this.mVDService.getServiceInfo().getMin() != vDEvent.getId()) {
            if (dealHistoryEvent(vDEvent)) {
                if (vDEvent.getPayload() != null) {
                    vDEvent.getPayload().setClassLoader(VDEvent.class.getClassLoader());
                }
                this.mVDService.onSet(vDEvent);
                return;
            }
            return;
        }
        VDLogUtil.i("inject event! service package=" + this.mVDService.getPackageName());
        int i2 = vDEvent.getPayload().getInt("InjectEventID");
        VDLogUtil.i("inject event=" + i2);
        publish(new VDEvent(i2, vDEvent.getPayload()));
    }

    @Override // com.desaysv.ivi.vdb.IVDBus
    public void subscribe(int[] iArr, int i2, String str, IVDBusCallback iVDBusCallback) throws RemoteException {
        VDLogUtil.i("start! service package=" + this.mVDService.getPackageName());
        if (iArr.length > 0) {
            addClientNode(iArr, i2, str, iVDBusCallback);
        } else {
            removeClientNode(iVDBusCallback);
        }
        try {
            iVDBusCallback.asBinder().linkToDeath(new ClientDeath(iVDBusCallback), 0);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        VDLogUtil.i("end");
    }

    @Override // com.desaysv.ivi.vdb.IVDBus
    public void subscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException {
        CustomizedClientDeath customizedClientDeath;
        boolean z2;
        try {
            synchronized (this.mCustomizedClientDeathList) {
                Iterator<CustomizedClientDeath> it = this.mCustomizedClientDeathList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        customizedClientDeath = null;
                        z2 = false;
                        break;
                    } else {
                        customizedClientDeath = it.next();
                        if (customizedClientDeath.getCallback().asBinder() == iVDBusNotify.asBinder()) {
                            VDLogUtil.i("client exist");
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    customizedClientDeath.addEvent(vDEvent.getId());
                } else {
                    CustomizedClientDeath customizedClientDeath2 = new CustomizedClientDeath(iVDBusNotify);
                    customizedClientDeath2.addEvent(vDEvent.getId());
                    this.mCustomizedClientDeathList.add(customizedClientDeath2);
                    iVDBusNotify.asBinder().linkToDeath(customizedClientDeath2, 0);
                }
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        if (vDEvent.getPayload() != null) {
            vDEvent.getPayload().setClassLoader(VDEvent.class.getClassLoader());
        }
        this.mVDService.onSubscribeCustomizedEvent(vDEvent, iVDBusNotify);
    }

    @Override // com.desaysv.ivi.vdb.IVDBus
    public void unsubscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) throws RemoteException {
        synchronized (this.mCustomizedClientDeathList) {
            Iterator<CustomizedClientDeath> it = this.mCustomizedClientDeathList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CustomizedClientDeath next = it.next();
                if (next.getCallback().asBinder() == iVDBusNotify.asBinder()) {
                    VDLogUtil.i("client exist! event=" + vDEvent);
                    if (vDEvent != null) {
                        next.removeEvent(vDEvent.getId());
                    } else {
                        next.clearEvent();
                    }
                    if (next.eventSize() == 0) {
                        VDLogUtil.i("client remove");
                        iVDBusNotify.asBinder().unlinkToDeath(next, 0);
                        this.mCustomizedClientDeathList.remove(next);
                    }
                    this.mVDService.onUnsubscribeCustomizedEvent(vDEvent, iVDBusNotify);
                }
            }
        }
    }
}
