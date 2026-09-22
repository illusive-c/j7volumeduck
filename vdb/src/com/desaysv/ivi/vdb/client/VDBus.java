package com.desaysv.ivi.vdb.client;

import android.content.Context;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.bind.VDRouter;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.client.bind.VDThreadConfig;
import com.desaysv.ivi.vdb.client.bind.VDThreadType;
import com.desaysv.ivi.vdb.client.listener.VDBindListener;
import com.desaysv.ivi.vdb.client.listener.VDCallbackListener;
import com.desaysv.ivi.vdb.client.listener.VDGetListListener;
import com.desaysv.ivi.vdb.client.listener.VDGetListener;
import com.desaysv.ivi.vdb.client.listener.VDNotifyListener;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.utils.VDConfigUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBus {
    private static volatile VDBus mSelf;
    private static Object mSyncLock = new Object();
    private VDRouter mVDRouter = new VDRouter();

    private VDBus() {
    }

    public static VDBus getDefault() {
        if (mSelf == null) {
            synchronized (mSyncLock) {
                if (mSelf == null) {
                    mSelf = new VDBus();
                }
            }
        }
        return mSelf;
    }

    public void addSubscribe(int i2) {
        this.mVDRouter.addSubscribe(new VDEvent(i2), VDThreadType.MAIN_THREAD);
    }

    public boolean bindService(VDServiceDef.ServiceType serviceType) {
        return this.mVDRouter.bindService(serviceType);
    }

    public void enterUnitTestMode() {
        VDConfigUtil.UNIT_TEST_MODE = true;
    }

    public void get(int i2, int i3, VDGetListener vDGetListener) {
        this.mVDRouter.get(new VDEvent(i2), i3, vDGetListener);
    }

    public void getList(ArrayList<VDEvent> arrayList, int i2, VDGetListListener vDGetListListener) {
        this.mVDRouter.getList(arrayList, i2, vDGetListListener);
    }

    public VDEvent getOnce(int i2) {
        return this.mVDRouter.getOnce(new VDEvent(i2));
    }

    public void init(Context context) {
        this.mVDRouter.init(context, null, null);
    }

    public boolean isServiceConnected(VDServiceDef.ServiceType serviceType) {
        return this.mVDRouter.isServiceConnected(serviceType);
    }

    public void registerVDBindListener(VDBindListener vDBindListener) {
        this.mVDRouter.registerVDBindListener(vDBindListener);
    }

    public void registerVDCallbackListener(VDCallbackListener vDCallbackListener) {
        this.mVDRouter.registerVDCallbackListener(vDCallbackListener);
    }

    public void registerVDNotifyListener(VDNotifyListener vDNotifyListener) {
        this.mVDRouter.registerVDNotifyListener(vDNotifyListener);
    }

    public void release() {
        this.mVDRouter.release();
    }

    public void removeSubscribe(int i2) {
        this.mVDRouter.removeSubscribe(new VDEvent(i2));
    }

    public void set(VDEvent vDEvent, int i2) {
        this.mVDRouter.set(vDEvent, i2);
    }

    public void setOnce(VDEvent vDEvent, int i2) {
        this.mVDRouter.setOnce(vDEvent, i2);
    }

    public void subscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        this.mVDRouter.subscribe(vDEvent, stub);
    }

    public void subscribeCommit() {
        this.mVDRouter.subscribeCommit();
    }

    public boolean unbindService(VDServiceDef.ServiceType serviceType) {
        return this.mVDRouter.unbindService(serviceType);
    }

    public void unregisterVDBindListener(VDBindListener vDBindListener) {
        this.mVDRouter.unregisterVDBindListener(vDBindListener);
    }

    public void unregisterVDCallbackListener(VDCallbackListener vDCallbackListener) {
        this.mVDRouter.unregisterVDCallbackListener(vDCallbackListener);
    }

    public void unregisterVDNotifyListener(VDNotifyListener vDNotifyListener) {
        this.mVDRouter.unregisterVDNotifyListener(vDNotifyListener);
    }

    public void unsubscribe(VDEvent vDEvent, IVDBusNotify.Stub stub) {
        this.mVDRouter.unsubscribe(vDEvent, stub);
    }

    public void addSubscribe(int i2, int i3) {
        this.mVDRouter.addSubscribe(new VDEvent(i2), i3);
    }

    public void get(VDEvent vDEvent, int i2, VDGetListener vDGetListener) {
        this.mVDRouter.get(vDEvent, i2, vDGetListener);
    }

    public VDEvent getOnce(VDEvent vDEvent) {
        return this.mVDRouter.getOnce(vDEvent);
    }

    public void init(Context context, VDThreadConfig vDThreadConfig, ArrayList<String> arrayList) {
        this.mVDRouter.init(context, vDThreadConfig, arrayList);
    }

    public void set(VDEvent vDEvent) {
        this.mVDRouter.set(vDEvent, 0);
    }

    public void setOnce(VDEvent vDEvent) {
        this.mVDRouter.setOnce(vDEvent, 0);
    }
}
