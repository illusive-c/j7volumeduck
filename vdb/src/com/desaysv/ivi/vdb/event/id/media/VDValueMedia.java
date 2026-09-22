package com.desaysv.ivi.vdb.event.id.media;

/* loaded from: classes.dex */
public class VDValueMedia {

    public static class InfoType {
        public static final int ALBUM = 3;
        public static final int ALL = 0;
        public static final int COLLECTION = 2;
        public static final int COLLECTION_ALBUM = 6;
        public static final int ID3 = 1;
        public static final int ID3_ALBUM = 5;
        public static final int ID3_COLLECTION = 4;
        public static final int LYRICS = 7;
    }

    public static class MediaCollectStatus {
        public static final int COLLECTED = 2;
        public static final int UNCOLLECTED = 3;
        public static final int WITHOUT_COLLECT = 1;
    }

    public static class MediaConnectState {
        public static final int CONNECTED_SEARCHED = 3;
        public static final int CONNECTED_SEARCHING = 2;
        public static final int DISCONNECTED = 1;
    }

    public static class MediaCyclicMode {
        public static final int LOOP_ALL = 3;
        public static final int LOOP_ONCE = 2;
        public static final int RANDOM = 5;
        public static final int SINGLE = 4;
        public static final int WITHOUT_CYCLIC_MODE = 1;
    }

    public static class MediaDisPlayView {
        public static final int BACKGROUND = 2;
        public static final int FOREGROUND = 1;
    }

    public static class MediaIntent {

        public static class IntentAction {
            public static final int INTENT_DEFAULT = 4;
            public static final int INTENT_KEY_DOWN = 5;
            public static final int INTENT_KEY_UP = 6;
            public static final int INTENT_LONG_KEY_PRESS = 7;
        }

        public static class IntentView {
            public static final int INTENT_DEFAULT_VIEW = 1;
            public static final int INTENT_MAIN_VIEW = 2;
            public static final int INTENT_ONE_THIRD_VIEW = 7;
            public static final int INTENT_PLAY_VIEW = 3;
            public static final int INTENT_SOURCE_LAST_VIEW = 8;
            public static final int INTENT_WANG_YI_YUN_MUSIC_VIEW = 4;
            public static final int INTENT_YOU_SHENG_SHU_VIEW = 5;
            public static final int INTENT_YUN_TING_VIEW = 6;
        }
    }

    public static class MediaPlayAction {
        public static final int COLLECT = 11;
        public static final int CYCLIC_MODE = 10;
        public static final int NEXT = 5;
        public static final int OPEN_SOURCE = 6;
        public static final int PAUSE = 2;
        public static final int PLAY = 1;
        public static final int PREV = 4;
        public static final int SEEK = 9;
        public static final int SEEK_BACKWARD = 8;
        public static final int SEEK_FORWARD = 7;
        public static final int STOP = 3;
    }

    public static class MediaPlayStatus {
        public static final int ERROR = 100;
        public static final int LOADING = 4;
        public static final int PAUSED = 2;
        public static final int PLAYING = 1;
        public static final int STOPPED = 3;
    }

    public static class MediaReason {

        public static class ActionReason {
            public static final int REASON_DEFAULT = 9;
            public static final int REASON_KEY_DOWN = 10;
            public static final int REASON_KEY_UP = 11;
            public static final int REASON_LONG_KEY_PRESS = 12;
            public static final int REASON_LONG_KEY_UP = 13;
        }

        public static class OpenReason {
            public static final int REASON_BOOT = 6;
            public static final int REASON_CARDS = 8;
            public static final int REASON_DEFAULT = 1;
            public static final int REASON_MENU_ICON = 12;
            public static final int REASON_MODE = 2;
            public static final int REASON_MODE_KEY_DOWN = 3;
            public static final int REASON_MODE_KEY_UP = 4;
            public static final int REASON_MODE_LONG_KEY_PRESS = 5;
            public static final int REASON_MODE_LONG_KEY_UP = 9;
            public static final int REASON_RESUME = 7;
            public static final int REASON_SOURCE_LIST = 13;
            public static final int REASON_SYSTEM_NAV_BAR = 11;
            public static final int REASON_SYSTEM_STATUS_BAR = 10;
        }
    }

    public static class MediaSearchStatus {

        public static class FmAmSearchStatus {
            public static final int SCANNING = 2;
            public static final int SEARCH_STOP = 1;
            public static final int SEEKING = 3;
            public static final int SEEKING_BACKWARD = 5;
            public static final int SEEKING_FORWARD = 4;
        }

        public static class MusicSearchStatus {
            public static final int NO_DATA = 1;
            public static final int SEARCHED_HAVE_DATA = 1;
            public static final int SEARCHING = 1;
            public static final int SEARCHING_HAVE_DATA = 1;
        }
    }

    public static class MediaSeekStatus {
        public static final int SEEK_BEGIN = 1;
        public static final int SEEK_END = 2;
    }

    public static class MediaType {
        public static final int AM = 10;
        public static final int AM_ONLINE = 12;
        public static final int ANDROID_AUTO = 20;
        public static final int BEEP_MUSIC = 29;
        public static final int BT_MUSIC = 13;
        public static final int CARLIFE = 17;
        public static final int CARLINK_MUSIC = 30;
        public static final int CARPLAY = 18;
        public static final int DAB_RADIO = 24;
        public static final int FM = 9;
        public static final int FM_AM = 8;
        public static final int FM_ONLINE = 11;
        public static final int HICAR = 19;
        public static final int LOCAL_MUSIC = 2;
        public static final int LOCAL_MUSIC_USB0 = 3;
        public static final int LOCAL_MUSIC_USB1 = 4;
        public static final int LOCAL_VIDEO = 5;
        public static final int LOCAL_VIDEO_USB0 = 6;
        public static final int LOCAL_VIDEO_USB1 = 7;
        public static final int NAPSTER_MUSIC = 28;
        public static final int NETEASE_CLOUD_MUSIC = 25;
        public static final int ONLINE_MUSIC = 14;
        public static final int ONLINE_NEWS = 21;
        public static final int ONLINE_RADIO = 16;
        public static final int ONLINE_SOUND = 22;
        public static final int ONLINE_VIDEO = 15;
        public static final int QQ_MUSIC = 23;
        public static final int SPOTIFY_MUSIC = 32;
        public static final int UNKNOWN = 1;
        public static final int UNSUPPORTED_SOURCE = 31;
        public static final int VK_MUSIC = 26;
        public static final int VK_PODCAST = 27;
    }
}
