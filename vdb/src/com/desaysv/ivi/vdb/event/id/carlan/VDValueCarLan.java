package com.desaysv.ivi.vdb.event.id.carlan;

/* loaded from: classes.dex */
public class VDValueCarLan {
    public static final int SOURCE_ESE = 201;

    public static class ADSDBServiceKey {
        public static final String ARRAY_DATA_key = "arrayData";
        public static final String LENGTH_KEY = "length";
    }

    public static class ARHUDCalibrationSts {
        public static final int CALIBRATION_FAILED = 3;
        public static final int CALIBRATION_INVALID = 0;
        public static final int CALIBRATION_NOT = 4;
        public static final int CALIBRATION_STATUS = 1;
        public static final int CALIBRATION_WITHOUT = 2;
    }

    public static class AdasDisplaySwitch {
        public static final int ADAS_DISPLAY_SWITCH_CLOSE = 1;
        public static final int ADAS_DISPLAY_SWITCH_INVALID = 0;
        public static final int ADAS_DISPLAY_SWITCH_OPEN = 2;
    }

    public static class AdasLaneInfoColor {
        public static final int LANE_INFO_COLOR_NONE = 0;
        public static final int LANE_INFO_COLOR_RESERVED = 3;
        public static final int LANE_INFO_COLOR_WHITE = 1;
        public static final int LANE_INFO_COLOR_YELLOW = 2;
    }

    public static class AdasLaneInfoPosition {
        public static final String EGO_LEFT = "Ego left";
        public static final String EGO_RIGHT = "Ego right";
        public static final String LEFT_ADJACENT_LEFT = "Left adjacent left";
        public static final String LEFT_ADJACENT_RIGHT = "Left adjacent right";
        public static final String LEFT_ROAD_EDGE = "Left road edge";
        public static final String POSITION_UNKNOWN = "Unknown";
        public static final String RIGHT_ADJACENT_LEFT = "Right adjacent left";
        public static final String RIGHT_ADJACENT_RIGHT = "Right adjacent right";
        public static final String RIGHT_ROAD_EDGE = "Right road edge";
    }

    public static class AdasLaneInfoQuality {
        public static final int QUALITY_LEVEL_0 = 0;
        public static final int QUALITY_LEVEL_1 = 1;
        public static final int QUALITY_LEVEL_2 = 2;
        public static final int QUALITY_LEVEL_3 = 3;
    }

    public static class AdasLaneInfoType {
        public static final int TYPE_DASHED = 2;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_RESERVED = 3;
        public static final int TYPE_SOLID = 1;
    }

    public static class AdasObjectLane {
        public static final String LANE_CUT_IN = "cut-in";
        public static final String LANE_CUT_OUT = "cut-out";
        public static final String LANE_EGO = "ego lane";
        public static final String LANE_LEFT = "left lane";
        public static final String LANE_NONE = "none";
        public static final String LANE_RIGHT = "right lane";
        public static final String LEFT_LANE_CLOSE_LANE = "left lane close lane";
        public static final String RIGHT_LANE_CLOSE_LANE = "right lane close lane";
    }

    public static class AdasObjectType {
        public static final int TYPE_BUS = 3;
        public static final int TYPE_CAR = 1;
        public static final int TYPE_CONICAL_TUBE = 7;
        public static final int TYPE_MOTO_BICYCLE = 5;
        public static final int TYPE_NONE = 0;
        public static final int TYPE_PED = 4;
        public static final int TYPE_TRICYLE = 6;
        public static final int TYPE_TRUCK = 2;
    }

    public static class AdasPlanningPathConfidence {
        public static final int CONFIDENCE_LEVEL_HIGH = 3;
        public static final int CONFIDENCE_LEVEL_LOW = 1;
        public static final int CONFIDENCE_LEVEL_MEDIUM = 2;
        public static final int CONFIDENCE_LEVEL_NONE = 0;
    }

    public static class CommandResult {
        public static final int FAILED = 0;
        public static final int SUCCESS = 1;
    }

    public static class ConnectStatus {
        public static final int CONNECTED = 1;
        public static final int DISCONNECTED = 0;
    }

    public static class DisplaySwitch {
        public static final int DISPLAY_SWITCH_CLOSE = 1;
        public static final int DISPLAY_SWITCH_INVALID = 0;
        public static final int DISPLAY_SWITCH_OPEN = 2;
    }

    public static class DistanceUnit {
        public static final int KILOMETER = 2;
        public static final int METER = 1;
        public static final int MILE = 3;
        public static final int NOT_USE = 0;
    }

    public static class FotaCommand {
        public static final String HU_FOTA_STATE_DISPLAY_ACK = "FotaStateDisplayAck";
        public static final String HU_FOTA_USER_COMFIRM_RESPONSE = "FotaUserComfirmResponse";
        public static final String HU_OTA_SUB_NODE_REFRESH_NOW_RESPONSE = "OtaSubNodeRefreshNowResponse";
        public static final String HU_OTA_SUB_NODE_REQ_ACK = "OtaSubNodeReqAck";
        public static final String HU_OTA_SUB_NODE_STATE_REPORT = "OtaSubNodeStateReport";
        public static final String TBOX_CANCEL_FOTA_ACK = "CancelFotaACK";
        public static final String TBOX_CANCEL_FOTA_REQ = "CancelFotaReq";
        public static final String TBOX_FOTA_STATE_DISPLAY_REQ = "FotaStateDisplayReq";
        public static final String TBOX_FOTA_USER_COMFIRM_REQ = "FotaUserComfirmReq";
        public static final String TBOX_OTA_SUB_NODE_REFRESH_NOW_REQ = "OtaSubNodeRefreshNowReq";
        public static final String TBOX_OTA_SUB_NODE_REQ = "OtaSubNodeReq";
        public static final String TBOX_OTA_SUB_NODE_STATE_REPORT_ACK = "OtaSubNodeStateReportAck";
    }

    public static class HudRecoveryDefault {
        public static final int HUD_NOTHING = 0;
        public static final int HUD_RECOVERY = 1;
    }

    public static class HudSettingEnable {
        public static final int HIGH = 1;
        public static final int LOW = 0;
    }

    public static class HudSysSts {
        public static final int HUD_SYSTEM_ERROR1 = 1;
        public static final int HUD_SYSTEM_ERROR2 = 2;
        public static final int HUD_SYSTEM_ERROR3 = 3;
        public static final int HUD_SYSTEM_NORMAL = 0;
        public static final int HUD_SYSTEM_PREPARING = 4;
        public static final int HUD_SYSTEM_STANDBY = 5;
    }

    public static class KEY {
        public static final String INFO1 = "info1";
        public static final String INFO2 = "info2";
        public static final String INFO3 = "info3";
        public static final String INFO4 = "info4";
        public static final String INFO5 = "info5";
        public static final String INFO6 = "info6";
        public static final String INFO7 = "info7";
        public static final String INFO8 = "info8";
        public static final String INFO_ARRAY = "infoArray";
    }

    public static class KeyCallState {
        public static final int CALLING = 3;
        public static final int CALL_END = 4;
        public static final int DIALING = 2;
        public static final int HOLD = 6;
        public static final int INCOMING = 1;
        public static final int MISS_CALL = 5;
        public static final int NORMAL = 0;
    }

    public static class LanguageSettings {
        public static final int LANGUAGE_SETTINGS_ENG = 2;
        public static final int LANGUAGE_SETTINGS_INVALID = 0;
        public static final int LANGUAGE_SETTINGS_ZH = 1;
    }

    public static class MediaType {
        public static final int BT_MUSIC = 0;
        public static final int ONLINE_MUSIC = 2;
        public static final int ONLINE_RADIO = 3;
        public static final int USB_MUSIC = 1;
    }

    public static class MobileNetworkType {
        public static final String CONNECTING = "Connecting";
        public static final String NO_NETWORK = "NoNetwork";
        public static final String TYPE_2G = "2G";
        public static final String TYPE_3G = "3G";
        public static final String TYPE_4G = "4G";
        public static final String TYPE_5G = "5G";
    }

    public static class MusicSource {
        public static final int ANDROID_AUTO = 16;
        public static final int BEEP_TUNES_MUSIC = 24;
        public static final int BT_MUSIC = 6;
        public static final int CARLIFE = 14;
        public static final int CARLINK_MUSIC = 25;
        public static final int CARPLAY = 13;
        public static final int DAB = 19;
        public static final int HICAR = 17;
        public static final int INTERN_MUSIC_STORAGE = 1;
        public static final int IPOD2 = 5;
        public static final int LOCAL_RADIO = 8;
        public static final int NAPSTER_MUSIC = 23;
        public static final int NEWS = 10;
        public static final int NO_SOURCE = 0;
        public static final int ONLINE_MUSIC = 7;
        public static final int ONLINE_RADIO = 4;
        public static final int ONLINE_VOICE = 9;
        public static final int QQ_MUSIC = 18;
        public static final int SCREEN = 15;
        public static final int USB1 = 2;
        public static final int USB1_VIDEO = 11;
        public static final int USB2 = 3;
        public static final int USB2_VIDEO = 12;
        public static final int VK_MUSIC = 22;
        public static final int VK_PODCAST = 21;
        public static final int WANG_YI_MUSIC = 20;
    }

    public static class NaviDisplayArea {
        public static final int CLOSE_CAST_SCREEN = 0;
        public static final int LEFT_FIRST_THEME = 2;
        public static final int MIDDLE_FIRST_THEME = 1;
        public static final int SECOND_THEME = 3;
        public static final int THIRD_THEME = 4;
    }

    public static class NaviDisplaySwitch {
        public static final int NAVI_DISPLAY_SWITCH_CLOSE = 1;
        public static final int NAVI_DISPLAY_SWITCH_INVALID = 0;
        public static final int NAVI_DISPLAY_SWITCH_OPEN = 2;
    }

    public static class NetworkType {
        public static final String CHINA_MOBILE = "CMCC";
        public static final String CHINA_TELECOM = "China Telecom";
        public static final String CHINA_UNICOM = "China Unicom";
        public static final String UNKNOWN = "Unknown";
    }

    public static class OperateAudioFocus {
        public static final int PLAY = 1;
        public static final int RELEASE = 0;
    }

    public static class OtaDisplaySwitch {
        public static final int OTA_NORMAL = 1;
        public static final int OTA_STATUS = 0;
    }

    public static class PKICommand {
        public static final String HU_CERTIFICATE_STATUS_RESP = "CertificateStatusResp";
        public static final String HU_DOWNLOAD_CERTIFICATE_RLT_REPORT = "DownloadCertificateRltReport";
        public static final String HU_GET_CERT_REQ = "HuGetCertReq";
        public static final String HU_GET_CERT_RESP = "HuGetCertResp";
        public static final String TBOX_CERTIFICATE_STATUS_REQ = "CertificateStatusReq";
        public static final String TBOX_DOWNLOAD_CERTIFICATE_RLT_ACK = "DownloadCertificateRltAck";
    }

    public static class Perspective {
        public static final int HEAD_UP_2D = 0;
        public static final int HEAD_UP_3D = 2;
        public static final int NORTH_UP_2D = 1;
        public static final int VIEW_ALTERNATELY = 3;
    }

    public static class PhoneDisplaySwitch {
        public static final int PHONE_DISPLAY_SWITCH_CLOSE = 1;
        public static final int PHONE_DISPLAY_SWITCH_INVALID = 0;
        public static final int PHONE_DISPLAY_SWITCH_OPEN = 2;
    }

    public static class PhoneType {
        public static final int BCALL = 3;
        public static final int BT_PHONE = 1;
        public static final int ECALL = 2;
        public static final int NOT_ACTIVE = 0;
    }

    public static class PlayAction {
        public static final int PAUSE = 0;
        public static final int PLAY = 1;
    }

    public static class ProjectID {
        public static final int T18 = 0;
        public static final int T22 = 1;
        public static final int T26 = 2;
    }

    public static class QuickKeySts {
        public static final int QUICK_KEY_CLOSE = 0;
        public static final int QUICK_KEY_ENABLE = 1;
    }

    public static class RPACommand {
        public static final String HU_RPA_REPORT = "RPAReport";
        public static final String HU_RPA_RESP = "RPAResp";
        public static final String HU_SLOT_REPORT_1 = "SlotReport1";
        public static final String HU_SLOT_REPORT_2 = "SlotReport2";
        public static final String TBOX_HEARTBEAT_RESP = "HeartBeatResp";
        public static final String TBOX_RPA_REQ = "RPAReq";
    }

    public static class RemoteControlCommand {
        public static final String HU_CHARGE_RESERVE_SET_REQ = "ChargeReserveSetReq";
        public static final String HU_PHONE_CHARGE_RESERVE_STATU_REPORT = "PhoneChargeReserveStatuReport";
        public static final String HU_PHONE_CHARGE_RESERVE_STATU_REPORT_RESP = "PhoneChargeReserveStatuReportResp";
        public static final String HU_PHONE_CHARGE_RESERVE_SYNC_RESP = "PhoneChargeReserveSyncResp";
        public static final String HU_REPORT_DID = "ReportDid";
        public static final String HU_SUB_NODE_GET_DIAG_REQ = "SubNodeGetDiagReq";
        public static final String HU_SUB_NODE_SEND_GET_LOG_RESULT = "SubNodeSendGetLogResult";
        public static final String HU_TBOX_INQUIRE_CHARGE_RESERVE = "InquireChargeReserve";
        public static final String HU_TBOX_LIGHT_SHOW_CTRL_RESP = "LightShowCtrlResp";
        public static final String TBOX_CALL_COMMAND_ACK = "CallCommandAck";
        public static final String TBOX_CHARGE_RESERVE_SET_RESP = "ChargeReserveSetResp";
        public static final String TBOX_GET_HU_DID = "GetHuDid";
        public static final String TBOX_HU_INQUIRE_CHARGE_RESERVE_RESP = "InquireChargeReserveResp";
        public static final String TBOX_HU_LIGHT_SHOW_CTRL_REQ = "LightShowCtrlReq";
        public static final String TBOX_PHONE_CHARGE_RESERVE_SYNC_REQ = "PhoneChargeReserveSyncReq";
        public static final String TBOX_REMOTE_HU_AWK_REQ = "RemoteHuAwkReq";
        public static final String TBOX_SUB_NODE_SEND_DIAG_RESULT = "SubNodeSendDiagResult";
        public static final String TBOX_SUB_NODE_SEND_GET_LOG_REQ = "SubNodeSendGetLogReq";
    }

    public static class RequestFocusType {
        public static final int AUDIO_FOCUS_GAIN = 1;
        public static final int AUDIO_FOCUS_GAIN_TRANSIENT = 2;
        public static final int AUDIO_FOCUS_GAIN_TRANSIENT_EXCLUSIVE = 4;
        public static final int AUDIO_FOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
        public static final int AUDIO_FOCUS_NONE = 0;
    }

    public static class RoadType {
        public static final int CITY_EXPRESSWAY = 6;
        public static final int COUNTY_COUNTRY_ROAD = 5;
        public static final int COUNTY_ROAD = 3;
        public static final int HIGHWAY = 0;
        public static final int MAIN_ROAD = 7;
        public static final int NATIONAL_HIGHWAY = 1;
        public static final int NORMAL_ROAD = 9;
        public static final int NOT_NAVI = 10;
        public static final int PROVINCIAL_ROAD = 2;
        public static final int SECONDARY_ROAD = 8;
        public static final int TOWNSHIP_HIGHWAY = 4;
    }

    public static class TBoxOTAAPPTCancelResult {
        public static final int CANCEL_FAIL = 0;
        public static final int CANCEL_SUCCESS = 1;
    }

    public static class TBoxOTAAPPTInstallResult {
        public static final int OTA_APPT_INSTALL_NOT_RESPONSE = 0;
        public static final int OTA_APPT_INSTALL_RESPONSE = 1;
    }

    public static class TBoxOTAAPPTSetResult {
        public static final int SET_FAIL = 0;
        public static final int SET_SUCCESS = 1;
    }

    public static class TBoxOTAStateResult {
        public static final int NOT_RESPONSE = 0;
        public static final int RESPONSE_OK = 1;
    }

    public static class TBoxReadyStatus {
        public static final int TBOX_NOT_READY = 0;
        public static final int TBOX_READY = 1;
    }

    public static class TboxCommand {
        public static final String ACK = "Ack";
        public static final String REPORT = "Report";
        public static final String REQ = "Req";
        public static final String RESP = "Resp";
    }

    public static class ThemeMode {
        public static final int THEME_MODE_INVALID = 0;
        public static final int THEME_MODE_NORMAL = 1;
        public static final int THEME_MODE_SNOW = 2;
    }

    public static class UpdateHudReq {
        public static final int UPDATE_HUD_CANCEL = 2;
        public static final int UPDATE_HUD_NONE = 0;
        public static final int UPDATE_HUD_REQUEST = 1;
    }

    public static class UpdateHudResponse {
        public static final int UPDATE_HUD_FAILED = 2;
        public static final int UPDATE_HUD_NONE = 0;
        public static final int UPDATE_HUD_SUCCESS = 1;
        public static final int UPDATE_HUD_UPGRADING = 3;
    }

    public static class UsbUpgradeCommand {
        public static final String SUB_NODE_ENTER_FACTORY = "SubNodeEnterFactory";
        public static final String SUB_NODE_ENTER_FACTORY_ACK = "SubNodeEnterFactoryAck";
        public static final String SUB_NODE_START_FACTORY = "SubNodeStartFactory";
        public static final String SUB_NODE_START_FACTORY_ACK = "SubNodeStartFactoryAck";
    }

    public static class VDExceptionCodeType {
        public static final String IDCU_COMMUNICATION_LOST = "IDCU_COMMUNICATION_LOST";
        public static final String IDCU_SERVICE_STOP = "IDCU_SERVICE_STOP";
        public static final String TBOX_COMMUNICATION_LOST = "TBOX_COMMUNICATION_LOST";
        public static final String TBOX_SERVICE_STOP = "TBOX_SERVICE_STOP";
    }

    public static class WriteCalibrationToDmcReq {
        public static final int CALIBRATION_NO_ACTION = 0;
        public static final int CALIBRATION_REQUEST = 1;
    }

    public static class XCallCtrl {
        public static final int ACCEPT = 3;
        public static final int DIAL = 1;
        public static final int HOLD = 5;
        public static final int REJECT = 4;
        public static final int TERMINATE = 2;
    }

    public static class XCallStatus {
        public static final String ACTIVE = "Active";
        public static final String CALL_FAILED = "CallFailed";
        public static final String DIALING = "Dialing";
        public static final String FAULT = "Fault";
        public static final String IDLE = "Idle";
        public static final String RINGING = "Ringing";
    }

    public static class XCallType {
        public static final String B_CALL = "B-Call";
        public static final String EMERGENCY_CONTACT = "Contact";
        public static final String E_CALL = "E-Call";
        public static final String I_CALL = "I-Call";
    }
}
