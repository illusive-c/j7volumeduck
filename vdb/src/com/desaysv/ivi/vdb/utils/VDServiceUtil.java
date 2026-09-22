package com.desaysv.ivi.vdb.utils;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;
import android.os.Process;
import java.util.List;

/* loaded from: classes2.dex */
public class VDServiceUtil {
    public static void addServiceToServiceManager(IBinder iBinder, String str) {
        VDLogUtil.i("binder=" + iBinder + ", name=" + str);
        try {
            Class.forName("android.os.ServiceManager").getMethod("addService", String.class, IBinder.class).invoke(new Object(), str, iBinder);
        } catch (Exception e2) {
            VDLogUtil.e(e2.getMessage());
            e2.printStackTrace();
        }
    }

    private static Notification getNotification(Context context, String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return null;
        }
        ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(new NotificationChannel(str, str, 0));
        Notification build = new Notification.Builder(context, i2 >= 26 ? str : null).setContentTitle(str).setContentText(str).setTicker(str).setPriority(2).setWhen(System.currentTimeMillis()).setDefaults(2).build();
        build.flags = 16;
        return build;
    }

    public static IBinder getServiceFromServiceManager(String str) {
        try {
            return (IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(new Object(), str);
        } catch (Exception e2) {
            VDLogUtil.e(e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isServiceStarted(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(1000);
        for (int i2 = 0; i2 < runningServices.size(); i2++) {
            if (runningServices.get(i2).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void startForeground(Service service) {
        String simpleName = service.getClass().getSimpleName();
        VDLogUtil.i("name=" + simpleName);
        if (Build.VERSION.SDK_INT >= 26) {
            service.startForeground(Process.myPid(), getNotification(service, simpleName));
        }
    }
}
