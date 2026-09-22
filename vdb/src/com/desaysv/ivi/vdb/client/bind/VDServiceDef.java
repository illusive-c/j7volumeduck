package com.desaysv.ivi.vdb.client.bind;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.desaysv.ivi.vdb.event.id.bt.VDEventBT;
import com.desaysv.ivi.vdb.event.id.cabin.VDEventCabinLan;
import com.desaysv.ivi.vdb.event.id.carinfo.VDEventCarInfo;
import com.desaysv.ivi.vdb.event.id.carlan.VDEventCarLan;
import com.desaysv.ivi.vdb.event.id.carstate.VDEventCarState;
import com.desaysv.ivi.vdb.event.id.device.VDEventVehicleDevice;
import com.desaysv.ivi.vdb.event.id.engineering.VDEventEngineering;
import com.desaysv.ivi.vdb.event.id.log.VDEventLog;
import com.desaysv.ivi.vdb.event.id.media.VDEventMedia;
import com.desaysv.ivi.vdb.event.id.navi.VDEventNavi;
import com.desaysv.ivi.vdb.event.id.permission.VDEventPermission;
import com.desaysv.ivi.vdb.event.id.phonelink.VDEventPhoneLink;
import com.desaysv.ivi.vdb.event.id.projection.VDEventProjection;
import com.desaysv.ivi.vdb.event.id.rvc.VDEventRvc;
import com.desaysv.ivi.vdb.event.id.setting.VDEventSetting;
import com.desaysv.ivi.vdb.event.id.sms.VDEventSms;
import com.desaysv.ivi.vdb.event.id.tsp.VDEventTsp;
import com.desaysv.ivi.vdb.event.id.tuner.VDEventTuner;
import com.desaysv.ivi.vdb.event.id.upgrade.VDEventUpgrade;
import com.desaysv.ivi.vdb.event.id.vr.VDEventVR;
import com.desaysv.ivi.vdb.event.id.watchdog.VDEventWatchdog;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import com.limpoxe.fairy.manager.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class VDServiceDef {
    public static final String BT_PKG_NAME = "com.desaysv.ivi.vds.bt";
    public static final String BT_SERVICE_ACTION = "action.desaysv.ivi.vds.bt.SERVICE";
    public static final String BT_SERVICE_NAME = "com.desaysv.ivi.vds.bt.service.BTService";
    public static final String BT_SERVICE_REBOOT = "action.desaysv.ivi.vds.bt.REBOOT";
    public static final boolean BT_SYSTEM_SERVICE = false;
    public static final String CABIN_LAN_PKG_NAME = "android.hardware.cabinlan@1.0-service";
    public static final String CABIN_LAN_SERVICE_ACTION = "";
    public static final String CABIN_LAN_SERVICE_NAME = "com.desaysv.ivi.vds.cabinlan.service.CabinLanService";
    public static final String CABIN_LAN_SERVICE_REBOOT = "";
    public static final boolean CABIN_LAN_SYSTEM_SERVICE = true;
    public static final String CAR_INFO_PKG_NAME = "com.desaysv.ivi.vds.carinfo";
    public static final String CAR_INFO_SERVICE_ACTION = "action.desaysv.ivi.vds.carinfo.SERVICE";
    public static final String CAR_INFO_SERVICE_NAME = "com.desaysv.ivi.vds.carinfo.service.CarInfoService";
    public static final String CAR_INFO_SERVICE_REBOOT = "action.desaysv.ivi.vds.carinfo.REBOOT";
    public static final boolean CAR_INFO_SYSTEM_SERVICE = false;
    public static final String CAR_LAN_PKG_NAME = "com.desaysv.ivi.vds.carlan";
    public static final String CAR_LAN_SERVICE_ACTION = "action.desaysv.ivi.vds.carlan.SERVICE";
    public static final String CAR_LAN_SERVICE_NAME = "com.desaysv.ivi.vds.carlan.service.CarLanService";
    public static final String CAR_LAN_SERVICE_REBOOT = "action.desaysv.ivi.vds.carlan.REBOOT";
    public static final boolean CAR_LAN_SYSTEM_SERVICE = false;
    public static final String CAR_STATE_PKG_NAME = "com.desaysv.ivi.vds.carstate";
    public static final String CAR_STATE_SERVICE_ACTION = "action.desaysv.ivi.vds.carstate.SERVICE";
    public static final String CAR_STATE_SERVICE_NAME = "com.desaysv.ivi.vds.carstate.service.CarStateService";
    public static final String CAR_STATE_SERVICE_REBOOT = "action.desaysv.ivi.vds.carstate.REBOOT";
    public static final boolean CAR_STATE_SYSTEM_SERVICE = false;
    public static final String DSP_PKG_NAME = "android.hardware.dsp@1.0-service";
    public static final String DSP_SERVICE_ACTION = "";
    public static final String DSP_SERVICE_NAME = "com.desaysv.ivi.vds.dsp.service.DspService";
    public static final String DSP_SERVICE_REBOOT = "";
    public static final boolean DSP_SYSTEM_SERVICE = true;
    public static final String ENGINEERING_PKG_NAME = "com.desaysv.ivi.engineering@1.0-service";
    public static final String ENGINEERING_SERVICE_ACTION = "";
    public static final String ENGINEERING_SERVICE_NAME = "com.desaysv.ivi.vds.engineering.service.EngineeringService";
    public static final String ENGINEERING_SERVICE_REBOOT = "";
    public static final boolean ENGINEERING_SYSTEM_SERVICE = true;
    public static final String LOG_PKG_NAME = "com.desaysv.ivi.vds.log";
    public static final String LOG_SERVICE_ACTION = "action.desaysv.ivi.vds.log.SERVICE";
    public static final String LOG_SERVICE_NAME = "com.desaysv.ivi.vds.log.service.LogService";
    public static final String LOG_SERVICE_REBOOT = "action.desaysv.ivi.vds.log.REBOOT";
    public static final boolean LOG_SYSTEM_SERVICE = false;
    public static final String MEDIA_PKG_NAME = "com.desaysv.ivi.vds.media";
    public static final String MEDIA_SERVICE_ACTION = "action.desaysv.ivi.vds.media.SERVICE";
    public static final String MEDIA_SERVICE_NAME = "com.desaysv.ivi.vds.media.service.MediaService";
    public static final String MEDIA_SERVICE_REBOOT = "action.desaysv.ivi.vds.media.REBOOT";
    public static final boolean MEDIA_SYSTEM_SERVICE = false;
    public static final String NAVI_PKG_NAME = "com.desaysv.ivi.vds.navi";
    public static final String NAVI_SERVICE_ACTION = "action.desaysv.ivi.vds.navi.SERVICE";
    public static final String NAVI_SERVICE_NAME = "com.desaysv.ivi.vds.navi.service.NaviService";
    public static final String NAVI_SERVICE_REBOOT = "action.desaysv.ivi.vds.navi.REBOOT";
    public static final boolean NAVI_SYSTEM_SERVICE = false;
    public static final String PERMISSION_PKG_NAME = "com.desaysv.ivi.vds.permission";
    public static final String PERMISSION_SERVICE_ACTION = "action.desaysv.ivi.vds.permission.SERVICE";
    public static final String PERMISSION_SERVICE_NAME = "com.desaysv.ivi.vds.permission.service.PermissionService";
    public static final String PERMISSION_SERVICE_REBOOT = "action.desaysv.ivi.vds.permission.REBOOT";
    public static final boolean PERMISSION_SYSTEM_SERVICE = false;
    public static final String PHONELINK_PKG_NAME = "com.desaysv.service.link";
    public static final String PHONELINK_SERVICE_ACTION = "com.desaysv.service.link.phonelink.SERVICE";
    public static final String PHONELINK_SERVICE_NAME = "com.desaysv.service.link.vds.PhoneLinkVDService";
    public static final String PHONELINK_SERVICE_REBOOT = "com.desaysv.service.link.phonelink.REBOOT";
    public static final boolean PHONELINK_SYSTEM_SERVICE = false;
    public static final String PREFIX_PKG_NAME = "com.desaysv.ivi.vds.";
    public static final String PREFIX_SERVICE_ACTION = "action.desaysv.ivi.vds.";
    public static final String PREFIX_SERVICE_NAME = "com.desaysv.ivi.vds.";
    public static final String PREFIX_SERVICE_REBOOT = "action.desaysv.ivi.vds.";
    public static final String PROJECTION_PKG_NAME = "com.desaysv.ivi.vds.projection";
    public static final String PROJECTION_SERVICE_ACTION = "action.desaysv.ivi.vds.projection.SERVICE";
    public static final String PROJECTION_SERVICE_NAME = "com.desaysv.ivi.vds.projection.service.ProjectionService";
    public static final String PROJECTION_SERVICE_REBOOT = "action.desaysv.ivi.vds.projection.REBOOT";
    public static final boolean PROJECTION_SYSTEM_SERVICE = false;
    public static final String RVC_PKG_NAME = "com.desaysv.ivi.vds.rvc";
    public static final String RVC_SERVICE_ACTION = "action.desaysv.ivi.vds.rvc.SERVICE";
    public static final String RVC_SERVICE_NAME = "com.desaysv.ivi.vds.rvc.service.RvcService";
    public static final String RVC_SERVICE_REBOOT = "action.desaysv.ivi.vds.rvc.REBOOT";
    public static final boolean RVC_SYSTEM_SERVICE = false;
    public static final String SETTING_PKG_NAME = "com.desaysv.ivi.vds.setting";
    public static final String SETTING_SERVICE_ACTION = "action.desaysv.ivi.vds.setting.SERVICE";
    public static final String SETTING_SERVICE_NAME = "com.desaysv.ivi.vds.setting.service.SettingService";
    public static final String SETTING_SERVICE_REBOOT = "action.desaysv.ivi.vds.setting.REBOOT";
    public static final boolean SETTING_SYSTEM_SERVICE = false;
    public static final String SMS_PKG_NAME = "com.desaysv.ivi.vds.sms";
    public static final String SMS_SERVICE_ACTION = "action.desaysv.ivi.vds.sms.SERVICE";
    public static final String SMS_SERVICE_NAME = "com.desaysv.ivi.vds.sms.service.SmsService";
    public static final String SMS_SERVICE_REBOOT = "action.desaysv.ivi.vds.sms.REBOOT";
    public static final boolean SMS_SYSTEM_SERVICE = false;
    public static final String SUFFIX_USER_APP_BROADCAST = "USER";
    public static final String TSP_PKG_NAME = "com.desaysv.ivi.vds.tsp";
    public static final String TSP_SERVICE_ACTION = "action.desaysv.ivi.vds.tsp.SERVICE";
    public static final String TSP_SERVICE_NAME = "com.desaysv.ivi.vds.tsp.service.TspService";
    public static final String TSP_SERVICE_REBOOT = "action.desaysv.ivi.vds.tsp.REBOOT";
    public static final boolean TSP_SYSTEM_SERVICE = false;
    public static final String TUNER_PKG_NAME = "com.desaysv.ivi.vds.tuner";
    public static final String TUNER_SERVICE_ACTION = "action.desaysv.ivi.vds.tuner.SERVICE";
    public static final String TUNER_SERVICE_NAME = "com.desaysv.ivi.vds.tuner.service.TunerService";
    public static final String TUNER_SERVICE_REBOOT = "action.desaysv.ivi.vds.tuner.REBOOT";
    public static final boolean TUNER_SYSTEM_SERVICE = false;
    public static final String UPGRADE_PKG_NAME = "com.desaysv.ivi.vds.upgrade";
    public static final String UPGRADE_SERVICE_ACTION = "action.desaysv.ivi.vds.upgrade.SERVICE";
    public static final String UPGRADE_SERVICE_NAME = "com.desaysv.ivi.vds.upgrade.service.UpgradeService";
    public static final String UPGRADE_SERVICE_REBOOT = "action.desaysv.ivi.vds.upgrade.REBOOT";
    public static final boolean UPGRADE_SYSTEM_SERVICE = false;
    public static final String VEHICLE_DEVICE_PKG_NAME = "com.desaysv.ivi.vds.vdev";
    public static final String VEHICLE_DEVICE_SERVICE_ACTION = "";
    public static final String VEHICLE_DEVICE_SERVICE_NAME = "com.desaysv.ivi.vds.vdev.service.VehicleDevice";
    public static final String VEHICLE_DEVICE_SERVICE_REBOOT = "";
    public static final boolean VEHICLE_DEVICE_SYSTEM_SERVICE = true;
    public static final String VEHICLE_HAL_PKG_NAME = "android.hardware.automotive.vehicle@2.0-service";
    public static final String VEHICLE_HAL_SERVICE_ACTION = "";
    public static final String VEHICLE_HAL_SERVICE_NAME = "com.desaysv.ivi.vds.vehicle.service.VehicleService";
    public static final String VEHICLE_HAL_SERVICE_REBOOT = "";
    public static final boolean VEHICLE_HAL_SYSTEM_SERVICE = true;
    public static final String VR_PKG_NAME = "com.desaysv.ivi.vds.vr";
    public static final String VR_SERVICE_ACTION = "action.desaysv.ivi.vds.vr.SERVICE";
    public static final String VR_SERVICE_NAME = "com.desaysv.ivi.vds.vr.service.VRService";
    public static final String VR_SERVICE_REBOOT = "action.desaysv.ivi.vds.vr.REBOOT";
    public static final boolean VR_SYSTEM_SERVICE = false;
    public static final String WATCHDOG_PKG_NAME = "com.desaysv.ivi.watchdog@1.0-service";
    public static final String WATCHDOG_SERVICE_ACTION = "";
    public static final String WATCHDOG_SERVICE_NAME = "com.desaysv.ivi.vds.watchdog.service.WatchdogService";
    public static final String WATCHDOG_SERVICE_REBOOT = "";
    public static final boolean WATCHDOG_SYSTEM_SERVICE = true;
    private static ArrayList<ServiceInfo> mServiceList = new ArrayList<>();

    public enum ServiceType {
        VEHICLE_HAL(0),
        SMS(1),
        SETTING(2),
        CAR_STATE(3),
        BT(4),
        CAR_INFO(5),
        MEDIA(6),
        TSP(7),
        VR(8),
        NAVI(9),
        UPGRADE(10),
        CAR_LAN(11),
        RVC(12),
        PHONELINK(13),
        VEHICLE_DEVICE(14),
        DSP(15),
        TUNER(16),
        CABIN_LAN(17),
        ENGINEERING(18),
        WATCHDOG(19),
        LOG(20),
        PROJECTION(21),
        CLUSTER_VEHICLE(22),
        CLUSTER_CABIN_LAN(23),
        CLUSTER_UCM(24),
        CLUSTER_PER(25),
        CLUSTER_LOG(26),
        CLUSTER_PHM(27),
        CLUSTER_THERMAL(28),
        PERMISSION(29);

        private final int value;

        ServiceType(int i2) {
            this.value = i2;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static ArrayList<ServiceInfo> createServiceList(Context context) {
        VDLogUtil.i(c.f7663i);
        ArrayList<ServiceInfo> arrayList = new ArrayList<>();
        arrayList.add(new ServiceInfo(ServiceType.VEHICLE_HAL, 0, 65535, true, VEHICLE_HAL_PKG_NAME, VEHICLE_HAL_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.SMS, 65536, VDEventSms.MAX, false, SMS_PKG_NAME, SMS_SERVICE_NAME, SMS_SERVICE_ACTION, SMS_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.SETTING, 131072, VDEventSetting.MAX, false, SETTING_PKG_NAME, SETTING_SERVICE_NAME, SETTING_SERVICE_ACTION, SETTING_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.CAR_STATE, VDEventCarState.MIN, VDEventCarState.MAX, false, CAR_STATE_PKG_NAME, CAR_STATE_SERVICE_NAME, CAR_STATE_SERVICE_ACTION, CAR_STATE_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.BT, 262144, VDEventBT.MAX, false, BT_PKG_NAME, BT_SERVICE_NAME, BT_SERVICE_ACTION, BT_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.CAR_INFO, VDEventCarInfo.MIN, VDEventCarInfo.MAX, false, CAR_INFO_PKG_NAME, CAR_INFO_SERVICE_NAME, CAR_INFO_SERVICE_ACTION, CAR_INFO_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.MEDIA, 393216, VDEventMedia.MAX, false, MEDIA_PKG_NAME, MEDIA_SERVICE_NAME, MEDIA_SERVICE_ACTION, MEDIA_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.TSP, VDEventTsp.MIN, VDEventTsp.MAX, false, TSP_PKG_NAME, TSP_SERVICE_NAME, TSP_SERVICE_ACTION, TSP_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.VR, 524288, VDEventVR.MAX, false, VR_PKG_NAME, VR_SERVICE_NAME, VR_SERVICE_ACTION, VR_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.NAVI, VDEventNavi.MIN, VDEventNavi.MAX, false, NAVI_PKG_NAME, NAVI_SERVICE_NAME, NAVI_SERVICE_ACTION, NAVI_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.UPGRADE, VDEventUpgrade.MIN, VDEventUpgrade.MAX, false, UPGRADE_PKG_NAME, UPGRADE_SERVICE_NAME, UPGRADE_SERVICE_ACTION, UPGRADE_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.CAR_LAN, 720896, VDEventCarLan.MAX, false, CAR_LAN_PKG_NAME, CAR_LAN_SERVICE_NAME, CAR_LAN_SERVICE_ACTION, CAR_LAN_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.RVC, 786432, VDEventRvc.MAX, false, RVC_PKG_NAME, RVC_SERVICE_NAME, RVC_SERVICE_ACTION, RVC_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.PHONELINK, VDEventPhoneLink.MIN, VDEventPhoneLink.MAX, false, PHONELINK_PKG_NAME, PHONELINK_SERVICE_NAME, PHONELINK_SERVICE_ACTION, PHONELINK_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.VEHICLE_DEVICE, 917504, VDEventVehicleDevice.MAX, true, VEHICLE_DEVICE_PKG_NAME, VEHICLE_DEVICE_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.DSP, 983040, 1048575, true, DSP_PKG_NAME, DSP_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.TUNER, 1048576, VDEventTuner.MAX, false, TUNER_PKG_NAME, TUNER_SERVICE_NAME, TUNER_SERVICE_ACTION, TUNER_SERVICE_REBOOT));
        arrayList.add(new ServiceInfo(ServiceType.CABIN_LAN, 1114112, VDEventCabinLan.MAX, true, CABIN_LAN_PKG_NAME, CABIN_LAN_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.ENGINEERING, VDEventEngineering.MIN, VDEventEngineering.MAX, true, ENGINEERING_PKG_NAME, ENGINEERING_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.WATCHDOG, VDEventWatchdog.MIN, VDEventWatchdog.MAX, true, WATCHDOG_PKG_NAME, WATCHDOG_SERVICE_NAME, "", "", true));
        arrayList.add(new ServiceInfo(ServiceType.LOG, VDEventLog.MIN, VDEventLog.MAX, false, LOG_PKG_NAME, LOG_SERVICE_NAME, LOG_SERVICE_ACTION, LOG_SERVICE_REBOOT, false));
        arrayList.add(new ServiceInfo(ServiceType.PROJECTION, VDEventProjection.MIN, VDEventProjection.MAX, false, PROJECTION_PKG_NAME, PROJECTION_SERVICE_NAME, PROJECTION_SERVICE_ACTION, PROJECTION_SERVICE_REBOOT, false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_VEHICLE, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_CABIN_LAN, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_UCM, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_PER, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_LOG, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_PHM, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.CLUSTER_THERMAL, 0, 0, false, "", "", "", "", false));
        arrayList.add(new ServiceInfo(ServiceType.PERMISSION, VDEventPermission.MIN, VDEventPermission.MAX, false, PERMISSION_PKG_NAME, PERMISSION_SERVICE_NAME, PERMISSION_SERVICE_ACTION, PERMISSION_SERVICE_REBOOT, false));
        mServiceList = arrayList;
        scanPackage(context);
        VDLogUtil.i("end");
        return arrayList;
    }

    private static int getProperty(String str, int i2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getMethod("get", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i2))).intValue();
        } catch (Exception e2) {
            VDLogUtil.e("error=" + e2.getMessage());
            e2.printStackTrace();
            return i2;
        }
    }

    public static ServiceInfo getServiceInfo(String str) {
        VDLogUtil.i("pkgName=" + str);
        VDLogUtil.i("service list len=" + mServiceList.size());
        Iterator<ServiceInfo> it = mServiceList.iterator();
        while (it.hasNext()) {
            ServiceInfo next = it.next();
            if (next.getPackageName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private static void scanPackage(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = (ArrayList) mServiceList.clone();
        for (PackageInfo packageInfo : installedPackages) {
            if (packageInfo.packageName.startsWith("com.desaysv.ivi.vds.") || packageInfo.packageName.equals(PHONELINK_PKG_NAME)) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = (ServiceInfo) it.next();
                    if (serviceInfo.getPackageName().equals(packageInfo.packageName)) {
                        VDLogUtil.i("exist packageName=" + packageInfo.packageName);
                        serviceInfo.setExist(true);
                        arrayList.remove(serviceInfo);
                        break;
                    }
                }
            }
        }
        VDLogUtil.i("service list len=" + mServiceList.size());
    }

    private static void setProperty(String str, int i2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            cls.getMethod("set", String.class, Integer.TYPE).invoke(cls, str, Integer.valueOf(i2));
        } catch (Exception e2) {
            VDLogUtil.e("error=" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public static class ServiceInfo {
        private boolean mIsExist;
        private boolean mIsSystemService;
        private int mMax;
        private int mMin;
        private String mPackageName;
        private String mServiceAction;
        private String mServiceName;
        private String mServiceReboot;
        private ServiceType mServiceType;

        public ServiceInfo(ServiceType serviceType, int i2, int i3, boolean z2, String str, String str2, String str3, String str4) {
            this.mIsExist = false;
            this.mServiceType = serviceType;
            this.mMin = i2;
            this.mMax = i3;
            this.mIsSystemService = z2;
            this.mPackageName = str;
            this.mServiceName = str2;
            this.mServiceAction = str3;
            this.mServiceReboot = str4;
        }

        public int getMax() {
            return this.mMax;
        }

        public int getMin() {
            return this.mMin;
        }

        public String getPackageName() {
            return this.mPackageName;
        }

        public String getServiceAction() {
            return this.mServiceAction;
        }

        public String getServiceName() {
            return this.mServiceName;
        }

        public String getServiceReboot() {
            return this.mServiceReboot;
        }

        public ServiceType getServiceType() {
            return this.mServiceType;
        }

        public boolean isExist() {
            return this.mIsExist;
        }

        public boolean isSystemService() {
            return this.mIsSystemService;
        }

        public void setExist(boolean z2) {
            this.mIsExist = z2;
        }

        public ServiceInfo(ServiceType serviceType, int i2, int i3, boolean z2, String str, String str2, String str3, String str4, boolean z3) {
            this.mIsExist = false;
            this.mServiceType = serviceType;
            this.mMin = i2;
            this.mMax = i3;
            this.mIsSystemService = z2;
            this.mPackageName = str;
            this.mServiceName = str2;
            this.mServiceAction = str3;
            this.mServiceReboot = str4;
            this.mIsExist = z3;
        }
    }
}
