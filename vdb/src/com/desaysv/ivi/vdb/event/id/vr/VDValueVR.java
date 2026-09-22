package com.desaysv.ivi.vdb.event.id.vr;

/* loaded from: classes2.dex */
public class VDValueVR {

    public static class AsrCtrl {
        public static final int AUTO_RELEASE_FIVE_SECOND = 5;
        public static final int EXIT = 2;
        public static final int RELEASE = 4;
        public static final int SEIZE = 3;
        public static final int WAKE_UP = 1;
    }

    public static class AsrStatus {
        public static final int ACTIVE = 1000;
        public static final int INACTIVE = 1003;
        public static final int LISTENING = 1001;
        public static final int RECOGNIZING = 1002;
    }

    public static class SR_TYPE {
        public static final int SR_DEFAULT = 0;
        public static final int SR_KTV = 5;
        public static final int SR_LION = 4;
        public static final int SR_OTA = 1;
        public static final int SR_POWER = 2;
        public static final int SR_STR = 3;
        public static final int SR_TENCENT = 6;
    }

    public static class VRPosition {
        public static final String VR_EXCEPTION = "NULL";
        public static final String VR_POSITION_ALL = "ALL";
        public static final String VR_POSITION_B = "B";
        public static final String VR_POSITION_F = "F";
        public static final String VR_POSITION_L = "L";
        public static final String VR_POSITION_LB = "LB";
        public static final String VR_POSITION_LF = "LF";
        public static final String VR_POSITION_R = "R";
        public static final String VR_POSITION_RB = "RB";
        public static final String VR_POSITION_RF = "RF";
        public static final String VR_POSITION_T = "T";
    }

    public static class VRSemanticKey {
        public static final String VR_CONTROL_RESPONSE = "onResponse";
    }

    public static class VRSettingsCustomResult {
        public static final String VR_WAKE_UP = "WAKEUP";
        public static final String VR_WELCOME = "WELCOME";
    }

    public static class VRStatusKey {
        public static final String STATUS_KEY_RECORDER = "controlRecorder";
    }

    public static class VRTtsStatus {
        public static final String TTS_PLAYING = "ttsIsPlaying";
        public static final String TTS_PLAY_BEGIN = "ttsPlayBegin";
        public static final String TTS_PLAY_COMPLETE = "ttsPlayComplete";
        public static final String TTS_PLAY_ERROR = "ttsPlayError";
        public static final String TTS_PLAY_INTERRUPTED = "ttsPlayInterrupted";
        public static final String TTS_PROGRESS = "onProgressReturn";
    }

    public static class VRTtsSupplier {
        public static final String TTS_IFLYTEK = "iflytek";
        public static final String TTS_SPEECH = "speech";
    }

    public static class VRUploadBTStatus {
        public static final String VR_BT_CALLLOG_RESPONSE = "notifyCallLogInfo";
        public static final String VR_BT_CALL_STATUS_RESPONSE = "notifyTelCallStatus";
        public static final String VR_BT_CONNECT_STATUS_RESPONSE = "notifyConnectStatus";
        public static final String VR_BT_CONTRACT_RESPONSE = "notifyContractInfo";
    }

    public static class VRUploadMusicStatus {
        public static final String VR_MUSIC_A2DP_RESPONSE = "notifyA2dpStatus";
        public static final String VR_MUSIC_INFO_RESPONSE = "notifyPlayMusicInfo";
        public static final String VR_MUSIC_LIST_RESPONSE = "notifyMusicList";
        public static final String VR_MUSIC_PLAY_RESPONSE = "notifyPlayStatus";
        public static final String VR_MUSIC_SOURCE_RESPONSE = "notifySourceStatus";
        public static final String VR_MUSIC_STATUS_RESPONSE = "notifyMusicStatus";
        public static final String VR_MUSIC_USB_RESPONSE = "notifyUsbStatus";
    }

    public static class VRUploadRadioStatus {
        public static final String VR_RADIO_COLLECT_LIST_RESPONSE = "notifyRadioCollectList";
        public static final String VR_RADIO_PLAY_RESPONSE = "notifyRadioPlayInfo";
        public static final String VR_RADIO_SCAN_RESPONSE = "notifyRadioScanStatus";
        public static final String VR_RADIO_SEEK_RESPONSE = "notifyRadioSeekStatus";
    }

    public static class VRUploadVideoStatus {
        public static final String VR_PLAY_VIDEO_RESPONSE = "playVideoStatus";
    }

    public static class VRUserType {
        public static final String VR_USER_ALL = "ALL";
        public static final String VR_USER_LB = "LB";
        public static final String VR_USER_LF = "LF";
        public static final String VR_USER_MB = "MB";
        public static final String VR_USER_RB = "RB";
        public static final String VR_USER_RF = "RF";
    }

    public static class VRVoiceRole {
        public static final int SPEAKER_DEFAULT = 0;
        public static final int VR_SPEAKER_1 = 1;
        public static final int VR_SPEAKER_10 = 10;
        public static final int VR_SPEAKER_11 = 11;
        public static final int VR_SPEAKER_12 = 12;
        public static final int VR_SPEAKER_2 = 2;
        public static final int VR_SPEAKER_3 = 3;
        public static final int VR_SPEAKER_4 = 4;
        public static final int VR_SPEAKER_5 = 5;
        public static final int VR_SPEAKER_6 = 6;
        public static final int VR_SPEAKER_7 = 7;
        public static final int VR_SPEAKER_8 = 8;
        public static final int VR_SPEAKER_9 = 9;
    }

    public static class VR_CONTROL_TYPE {
    }

    public static class VR_EXEC_RESULT {
        public static final int VR_ALREADY_EXPECT = 5;
        public static final int VR_CALLBACK_FAIL = 9;
        public static final int VR_CALLBACK_SUCCESS = 8;
        public static final int VR_EXCEPTION = 7;
        public static final int VR_FAIL = 1;
        public static final int VR_NOT_CONDITION = 4;
        public static final int VR_NOT_SUCH_CONFIG = 3;
        public static final int VR_NOT_SUCH_FUNC = 2;
        public static final int VR_SUCCESS = 0;
        public static final int VR_UN_KNOW_FAULT = 6;
    }

    public static class VR_LAUNCHER_STATUS {
        public static final int VR_LAUNCHAPP_CLOSE_FAILED = 4;
        public static final int VR_LAUNCHAPP_CLOSE_SUCCEED = 2;
        public static final int VR_LAUNCHAPP_OPEN_FAILED = 3;
        public static final int VR_LAUNCHAPP_OPEN_SUCCEED = 1;
        public static final int VR_LAUNCHAPP_TTS_IGNORED = 5;
        public static final int VR_LAUNCHAPP_UNKNOWN_STATUS = 0;
    }

    public static class VR_RESPONSE_STATUS {
        public static final int RESPONSE_CODE_APP_REQUEST = 5;
        public static final int RESPONSE_CODE_FAIL = 1;
        public static final int RESPONSE_CODE_FAIL_AND_TTS = 3;
        public static final int RESPONSE_CODE_NOTIFY = 4;
        public static final int RESPONSE_CODE_SUCCEED_AND_TTS = 2;
        public static final int RESPONSE_CODE_SUCCESS = 0;
    }
}
