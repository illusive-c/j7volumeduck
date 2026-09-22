package com.desaysv.ivi.vdb.event.id.dsp;

/* loaded from: classes.dex */
public class VDValueDsp {

    public static class DspArkamysType {
        public static final int ARKAMYS_CINEMA = 3;
        public static final int ARKAMYS_DYNAMIC = 2;
        public static final int ARKAMYS_NATURAL = 1;
        public static final int ARKAMYS_OFF = 0;
        public static final int ARKAMYS_VOCAL = 4;
    }

    public static class DspBmtType {
        public static final int BMT_BASS = 1;
        public static final int BMT_MIDDLE = 3;
        public static final int BMT_MIDDLE_BASS = 2;
        public static final int BMT_MIDDLE_TREBLE = 4;
        public static final int BMT_TREBLE = 5;
        public static final int BMT_ULTRA_BASS = 0;
    }

    public static class DspChannelType {
        public static final int CHANNEL_ALARM = 11;
        public static final int CHANNEL_AMP = 12;
        public static final int CHANNEL_BEEP = 7;
        public static final int CHANNEL_CENTER_AMP = 15;
        public static final int CHANNEL_ESE = 14;
        public static final int CHANNEL_KTV = 13;
        public static final int CHANNEL_MAX_DEFAULT_VOLUME = 10;
        public static final int CHANNEL_MEDIA_A2DP = 2;
        public static final int CHANNEL_MEDIA_AM = 19;
        public static final int CHANNEL_MEDIA_FM = 18;
        public static final int CHANNEL_MEDIA_MUSIC = 0;
        public static final int CHANNEL_MEDIA_TUNER = 1;
        public static final int CHANNEL_NAVI = 3;
        public static final int CHANNEL_NULL = 20;
        public static final int CHANNEL_PHONE = 5;
        public static final int CHANNEL_RING = 6;
        public static final int CHANNEL_TBOX = 8;
        public static final int CHANNEL_TONE = 17;
        public static final int CHANNEL_TTS = 9;
        public static final int CHANNEL_VR = 4;
        public static final int CHANNEL_WELCOME = 16;
    }

    public static class DspDesaySoundEnableFlag {
        public static final int DESAY_SOUND_DISABLE = 0;
        public static final int DESAY_SOUND_ENABLE = 1;
    }

    public static class DspDesaySoundListeningPosition {
        public static final int DESAY_SOUND_ALL_SEAT = 0;
        public static final int DESAY_SOUND_DRIVER_SEAT = 1;
        public static final int DESAY_SOUND_PASSENGER_SEAT = 2;
        public static final int DESAY_SOUND_REAR_SEAT = 3;
    }

    public static class DspDesaySoundMode {
        public static final int DESAY_SOUND_BASS_BOOST = 3;
        public static final int DESAY_SOUND_CONCERT_HALL = 5;
        public static final int DESAY_SOUND_MOVIE_THEATER = 6;
        public static final int DESAY_SOUND_NATURE = 1;
        public static final int DESAY_SOUND_PARTY_LIVE = 4;
        public static final int DESAY_SOUND_PASS_THRU = 0;
        public static final int DESAY_SOUND_VOICE_ENHANCE = 2;
    }

    public static class DspEcnrType {
        public static final int DSP_ECNR_OFF = 0;
        public static final int DSP_ECNR_PHONE_ON = 1;
        public static final int DSP_ECNR_VR_ON = 1;
    }

    public static class DspEffectType {
        public static final int DSP_EFFECT_ADVANCED_SOUND = 2;
        public static final int DSP_EFFECT_ARKAMYS_SOUND = 16;
        public static final int DSP_EFFECT_CSAUTO = 6;
        public static final int DSP_EFFECT_DESAY_SOUND = 20;
        public static final int DSP_EFFECT_DTS_SOUND = 9;
        public static final int DSP_EFFECT_ECNR = 10;
        public static final int DSP_EFFECT_ENC = 18;
        public static final int DSP_EFFECT_ENC_TEST = 19;
        public static final int DSP_EFFECT_HEADREST_SPEAKER_MODE = 11;
        public static final int DSP_EFFECT_LOUDNESS = 0;
        public static final int DSP_EFFECT_MEDIA_OUTSIDE_THE_CAR = 17;
        public static final int DSP_EFFECT_NOISE_REDUCE = 8;
        public static final int DSP_EFFECT_ORDINARY_SOUND = 3;
        public static final int DSP_EFFECT_RESTORE_FACTORY = 23;
        public static final int DSP_EFFECT_REVERT_SOUND = 7;
        public static final int DSP_EFFECT_SONY = 12;
        public static final int DSP_EFFECT_SOUND_WAVE = 4;
        public static final int DSP_EFFECT_SURROUND = 1;
        public static final int DSP_EFFECT_SV_SOUND_EFFECT = 13;
        public static final int DSP_EFFECT_SV_SOUND_EFFECT_HIFI = 14;
        public static final int DSP_EFFECT_SWITCH = 21;
        public static final int DSP_EFFECT_VIRTUAL_LIVE_SOUND = 22;
        public static final int DSP_EFFECT_VIRTUAL_WOOFER = 5;
        public static final int DSP_EFFECT_YGC_DTS_SOUND = 15;
    }

    public static class DspEncType {
        public static final int DSP_ENC_OFF = 0;
        public static final int DSP_ENC_ON = 1;
    }

    public static class DspMediaOutsideType {
        public static final int DSP_MediaOutside_OFF = 0;
        public static final int DSP_MediaOutside_ON = 1;
    }

    public static class DspMode {
        public static final int MODE_BT_PHONE = 1;
        public static final int MODE_CAR_PHONE = 2;
        public static final int MODE_MEDIA = 0;
        public static final int RECORD_MEDIA = 3;
    }

    public static class DspRestoreFactoryType {
        public static final int DSP_RESTORE_FACTORY_INVALID = 0;
        public static final int DSP_RESTORE_FACTORY_OFF = 2;
        public static final int DSP_RESTORE_FACTORY_ON = 1;
    }

    public static class DspSonyType {
        public static final int DSP_SONY_OFF = 0;
        public static final int DSP_SONY_ON = 1;
    }

    public static class DspSpeakerType {
        public static final int FADER_FL = 0;
        public static final int FADER_FR = 1;
        public static final int FADER_RL = 2;
        public static final int FADER_RR = 3;
    }

    public static class DspSwitchType {
        public static final int DSP_EFFECT_SWITCH_OFF = 0;
        public static final int DSP_EFFECT_SWITCH_ON = 1;
    }

    public static class DspYgcDtsType {
        public static final int DTS_ALL_SEAT_BASS = 7;
        public static final int DTS_ALL_SEAT_NATURE = 5;
        public static final int DTS_ALL_SEAT_REST = 8;
        public static final int DTS_ALL_SEAT_VOICE = 6;
        public static final int DTS_DRIVER_SEAT_BASS = 3;
        public static final int DTS_DRIVER_SEAT_NATURE = 1;
        public static final int DTS_DRIVER_SEAT_REST = 4;
        public static final int DTS_DRIVER_SEAT_VOICE = 2;
        public static final int DTS_OFF = 0;
    }

    public static class EngVolumeCalibrationSourceType {
        public static final int VOLUME_SOURCE_TYPE_BEEP = 7;
        public static final int VOLUME_SOURCE_TYPE_BTMEDIA = 2;
        public static final int VOLUME_SOURCE_TYPE_MEDIA = 0;
        public static final int VOLUME_SOURCE_TYPE_NAVI = 3;
        public static final int VOLUME_SOURCE_TYPE_PHONE = 5;
        public static final int VOLUME_SOURCE_TYPE_TBOX = 8;
        public static final int VOLUME_SOURCE_TYPE_TTS = 4;
    }

    public static class ExtAMPHeadrestSpeakerMode {
        public static final int HEADREST_SPEAKER_DRIVE_MODE = 2;
        public static final int HEADREST_SPEAKER_NOT_ACTIVE = 0;
        public static final int HEADREST_SPEAKER_PRIVATE_MODE = 3;
        public static final int HEADREST_SPEAKER_SHARED_MODE = 1;
    }

    public static class ExtAMPSoundEffectType {
        public static final int SOUND_EFFECT_CLASSIC_DEFINED_MODE = 5;
        public static final int SOUND_EFFECT_CUSTOMER_DEFINED_MODE = 1;
        public static final int SOUND_EFFECT_JAZZ_DEFINED_MODE = 4;
        public static final int SOUND_EFFECT_NOT_ACTIVE = 0;
        public static final int SOUND_EFFECT_POPULAR_MODE = 3;
        public static final int SOUND_EFFECT_ROCK_DEFINED_MODE = 6;
        public static final int SOUND_EFFECT_RURAL_DEFINED_MODE = 8;
        public static final int SOUND_EFFECT_STANDARD_MODE = 2;
        public static final int SOUND_EFFECT_VOCALS_DEFINED_MODE = 7;
    }

    public static class ExtAMPSoundFieldType {
        public static final int SOUND_FIELD_ALL_PASSENGER = 2;
        public static final int SOUND_FIELD_BABY_MODE = 6;
        public static final int SOUND_FIELD_BOSS = 7;
        public static final int SOUND_FIELD_CUSTOMIZED = 1;
        public static final int SOUND_FIELD_DRIVER = 3;
        public static final int SOUND_FIELD_FRONT = 4;
        public static final int SOUND_FIELD_NOT_ACTIVE = 0;
        public static final int SOUND_FIELD_REAR = 5;
    }

    public static class ExtAmpSdvcLevel {
        public static final int SDVC_LEVEL_HIGH = 3;
        public static final int SDVC_LEVEL_LOW = 1;
        public static final int SDVC_LEVEL_MID = 2;
        public static final int SDVC_LEVEL_OFF = 0;
    }

    public static class ProductTestType {
        public static final int TEST_TYPE_DSP_GAIN = 2;
        public static final int TEST_TYPE_MIC = 0;
        public static final int TEST_TYPE_SPEAKER = 1;
    }

    public static class ProductTest_MicType {
        public static final int MIC_EXTERNAL = 1;
        public static final int MIC_NORMAL = 0;
        public static final int MIC_TO_SPEAKER = 2;
    }

    public static class Result {
        public static final int INVALID_ARGUMENTS = 2;
        public static final int INVALID_STATE = 3;
        public static final int NOT_INITIALIZED = 1;
        public static final int OK = 0;
        public static final int TIMEOUT = 4;
    }

    public static class SuppressionMediaMode {
        public static final int AVM_MODE = 1;
        public static final int NAVI_MODE = 0;
    }

    public static class VirtualLiveSoundType {
        public static final int VIRTUAL_LIVE_SOUND_CONCERT_HAL = 2;
        public static final int VIRTUAL_LIVE_SOUND_NOT_ACTIVE = 0;
        public static final int VIRTUAL_LIVE_SOUND_OFF = 3;
        public static final int VIRTUAL_LIVE_SOUND_VOCAL_CONCERT = 1;
    }
}
