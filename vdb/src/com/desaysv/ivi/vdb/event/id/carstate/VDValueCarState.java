package com.desaysv.ivi.vdb.event.id.carstate;

/* loaded from: classes.dex */
public class VDValueCarState {

    public static class AudioPolicy {
        public static final int AUDIO_POLICY_ENERGY = 1;
        public static final int AUDIO_POLICY_FAULT = 4;
        public static final int AUDIO_POLICY_NORMAL = 0;
        public static final int AUDIO_POLICY_PA_TEMPERATURE = 8;
        public static final int AUDIO_POLICY_TRANS = 2;
    }

    public static class BackLightPolicy {
        public static final int BACKLIGHT_POLICY_ENERGY = 1;
        public static final int BACKLIGHT_POLICY_FAULT = 8;
        public static final int BACKLIGHT_POLICY_LCD_TEMPERATURE = 32;
        public static final int BACKLIGHT_POLICY_NORMAL = 0;
        public static final int BACKLIGHT_POLICY_PA_TEMPERATURE = 16;
        public static final int BACKLIGHT_POLICY_TRANS = 4;
    }

    public static class DisplayID {
        public static final int AIR_SCREEN = 32;
        public static final int BACK_SCREEN = 16;
        public static final int CMS_SCREEN = 64;
        public static final int HUD_SCREEN = 4;
        public static final int MASTER_SCREEN = 1;
        public static final int Meter_SCREEN = 8;
        public static final int SECOND_SCREEN = 2;
    }

    public static class EnergyModeLevel {
        public static final int ENERGY_MODE_NORMAL = 0;
        public static final int ENERGY_MODE_ONE = 1;
        public static final int ENERGY_MODE_TWO = 2;
    }

    public static class HighTemperatureMode {
        public static final int LCD_HIGH_TEMP = 8;
        public static final int MAINBOARD_HIGH_TEMP = 4;
        public static final int NO_HIGH_TEMP = 0;
        public static final int PA_HIGH_TEMP = 2;
        public static final int SOC_HIGH_TEMP = 1;
    }

    public static class InjectEvent {
        public static final int EVENT_ENTER_CAMPING_MODE = 13;
        public static final int EVENT_ENTER_PARKING_AIRCONDITION = 9;
        public static final int EVENT_ENTER_WARNING_MODE = 2;
        public static final int EVENT_EXIT_CAMPING_MODE = 14;
        public static final int EVENT_EXIT_PARKING_AIRCONDITION = 10;
        public static final int EVENT_EXIT_WARNING_MODE = 3;
        public static final int EVENT_HIDE_SECUREWINDOW = 6;
        public static final int EVENT_HIDE_TOD = 8;
        public static final int EVENT_RADIO_INITED = 11;
        public static final int EVENT_RADIO_UNINITED = 12;
        public static final int EVENT_SHOW_TOD = 7;
        public static final int EVENT_TURN_OFF_SCREEN = 1;
        public static final int EVENT_TURN_ON_SCREEN = 0;
        public static final int EVENT_VR_ACTIVE = 4;
        public static final int EVENT_VR_DEACTIVE = 5;
    }

    public static class InjectSource {
        public static final int SOURCE_CARSTATE = 9;
        public static final int SOURCE_FACTORY = 5;
        public static final int SOURCE_HVAC = 0;
        public static final int SOURCE_MULTI_SCREEN = 7;
        public static final int SOURCE_PERSONAL = 3;
        public static final int SOURCE_RADIO_BROADCAST = 8;
        public static final int SOURCE_RVC = 6;
        public static final int SOURCE_SETTINGS = 1;
        public static final int SOURCE_SYSTEMUI = 2;
        public static final int SOURCE_VR = 4;
    }

    public static class KeyStatus {
        public static final int ACC = 1;
        public static final int CRANK_ON = 3;
        public static final int OFF = 0;
        public static final int ON = 2;
        public static final int UNKNOWN = -1;
    }

    public static class PowerStatus {
        public static final int STATE_AVN_AVOFF = 18;
        public static final int STATE_AVN_BOOT = 24;
        public static final int STATE_AVN_DEGRADED = 27;
        public static final int STATE_AVN_FOTA = 16;
        public static final int STATE_AVN_LOCKSCREEN = 32;
        public static final int STATE_AVN_OFF = 20;
        public static final int STATE_AVN_OFF_PHONE = 21;
        public static final int STATE_AVN_RUN_ON = 17;
        public static final int STATE_AVN_SCREEN_OFF = 23;
        public static final int STATE_AVN_SLEEP = 26;
        public static final int STATE_AVN_STANDBY = 25;
        public static final int STATE_AVN_STR = 40;
        public static final int STATE_AVN_TIME_ON = 19;
        public static final int STATE_AVN_WARNING = 22;
        public static final int STATE_PARKING_AIRCONDITIONER = 28;
    }

    public static class ScreenBackLight {
        public static final int AUTO_MODE = 1;
        public static final int DARKNIGHT_MODE = 1;
        public static final int DAY_MODE = 0;
        public static final int MANUAL_MODE = 0;
    }

    public static class ScreenStatus {
        public static final int SCREEN_LIGHT_STATE_OFF = 1;
        public static final int SCREEN_LIGHT_STATE_ON = 0;
    }
}
