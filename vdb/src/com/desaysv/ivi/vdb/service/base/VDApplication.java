package com.desaysv.ivi.vdb.service.base;

import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.desaysv.ivi.vdb.client.VDBus;
import com.desaysv.ivi.vdb.client.bind.VDServiceDef;
import com.desaysv.ivi.vdb.utils.VDLogUtil;

/* loaded from: classes2.dex */
public class VDApplication extends Application {
    private void printVersion() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            VDLogUtil.i("package name:" + getPackageName());
            VDLogUtil.i("version name:" + packageInfo.versionName);
            VDLogUtil.i("version code:" + packageInfo.versionCode);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        printVersion();
        VDBus.getDefault().init(this);
        VDServiceDef.ServiceInfo serviceInfo = VDServiceDef.getServiceInfo(getPackageName());
        if (serviceInfo != null) {
            Intent intent = new Intent();
            intent.setAction(serviceInfo.getServiceAction());
            intent.setPackage(serviceInfo.getPackageName());
            VDLogUtil.i("start service action=" + serviceInfo.getServiceAction());
            VDLogUtil.i("start service pkg=" + serviceInfo.getPackageName());
            if (Build.VERSION.SDK_INT >= 26) {
                VDLogUtil.i("startForegroundService");
                startForegroundService(intent);
            } else {
                VDLogUtil.i("startService");
                startService(intent);
            }
        } else {
            VDLogUtil.e("service not exist");
        }
        VDLogUtil.i("end");
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        VDLogUtil.i();
        VDBus.getDefault().release();
    }
}
