package com.desaysv.ivi.vdb.service.base;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import com.desaysv.ivi.vdb.IVDBusNotify;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.service.bind.VDBinder;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import com.desaysv.ivi.vdb.utils.VDServiceUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class VDService extends Service {
    public static final int RECEIVER_EXPORTED = 2;
    private VDBinder mBinder = null;
    private ArrayList<VDDispatcher> mDispatcherList = new ArrayList<>();
    private CheckBootReceiver mCheckBootReceiver = null;
    private VDServiceDef.ServiceInfo mServiceInfo = null;

    private class CheckBootReceiver extends BroadcastReceiver {
        private CheckBootReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("client");
            VDLogUtil.i("service package=" + VDService.this.getPackageName());
            VDLogUtil.i("action=" + action);
            VDLogUtil.i("client=" + stringExtra);
            Intent intent2 = new Intent();
            intent2.setAction(VDService.this.mServiceInfo.getServiceReboot());
            intent2.setPackage(stringExtra);
            VDService.this.sendBroadcast(intent2);
        }
    }

    public VDServiceDef.ServiceInfo getServiceInfo() {
        return this.mServiceInfo;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        VDLogUtil.i("service package=" + getPackageName());
        VDServiceUtil.startForeground(this);
        this.mBinder = new VDBinder(this);
        VDServiceDef.ServiceInfo serviceInfo = VDServiceDef.getServiceInfo(getPackageName());
        this.mServiceInfo = serviceInfo;
        if (serviceInfo != null) {
            VDLogUtil.i("send boot broadcast");
            Intent intent = new Intent();
            intent.setAction(this.mServiceInfo.getServiceReboot());
            sendBroadcast(intent);
            VDLogUtil.i("register check boot broadcast action=" + this.mServiceInfo.getServiceAction());
            if (this.mCheckBootReceiver == null) {
                this.mCheckBootReceiver = new CheckBootReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(this.mServiceInfo.getServiceAction());
                intentFilter.addAction(this.mServiceInfo.getServiceAction() + VDServiceDef.SUFFIX_USER_APP_BROADCAST);
                if (Build.VERSION.SDK_INT >= 34) {
                    registerReceiver(this.mCheckBootReceiver, intentFilter, 2);
                } else {
                    registerReceiver(this.mCheckBootReceiver, intentFilter);
                }
            }
        }
    }

    public void onCustomizedClientDeath(IBinder iBinder) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        VDLogUtil.i();
        CheckBootReceiver checkBootReceiver = this.mCheckBootReceiver;
        if (checkBootReceiver != null) {
            unregisterReceiver(checkBootReceiver);
            this.mCheckBootReceiver = null;
        }
    }

    public Bundle onGet(VDEvent vDEvent) {
        Bundle onGet;
        synchronized (this.mDispatcherList) {
            Iterator<VDDispatcher> it = this.mDispatcherList.iterator();
            while (it.hasNext()) {
                VDDispatcher next = it.next();
                if (next.isInsideEvent(vDEvent) && (onGet = next.onGet(vDEvent)) != null) {
                    return onGet;
                }
            }
            return null;
        }
    }

    public void onSet(VDEvent vDEvent) {
        synchronized (this.mDispatcherList) {
            Iterator<VDDispatcher> it = this.mDispatcherList.iterator();
            while (it.hasNext()) {
                VDDispatcher next = it.next();
                if (next.isInsideEvent(vDEvent)) {
                    next.onSet(vDEvent);
                }
            }
        }
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public int onStartCommand(Intent intent, int i2, int i3) {
        VDLogUtil.i("service package=" + getPackageName());
        return super.onStartCommand(intent, 1, i3);
    }

    public void onSubscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) {
    }

    public void onUnsubscribeCustomizedEvent(VDEvent vDEvent, IVDBusNotify iVDBusNotify) {
    }

    public void publish(VDEvent vDEvent) {
        this.mBinder.publish(vDEvent);
    }

    public void registerDispatcher(VDDispatcher vDDispatcher) {
        synchronized (this.mDispatcherList) {
            if (!this.mDispatcherList.contains(vDDispatcher)) {
                this.mDispatcherList.add(vDDispatcher);
            }
        }
    }

    public void unregisterDispatcher(VDDispatcher vDDispatcher) {
        synchronized (this.mDispatcherList) {
            this.mDispatcherList.remove(vDDispatcher);
        }
    }
}
