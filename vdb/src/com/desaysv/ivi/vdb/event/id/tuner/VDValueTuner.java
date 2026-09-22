package com.desaysv.ivi.vdb.event.id.tuner;

/* loaded from: classes.dex */
public class VDValueTuner {

    public static class FmAmBand {
        public static final int AM = 5;
        public static final int AM2 = 6;
        public static final int AM_ONLINE = 7;
        public static final int FM = 1;
        public static final int FM2 = 2;
        public static final int FM3 = 3;
        public static final int FM_ONLINE = 4;
    }

    public static class FmAmCollectStatus {
        public static final int COLLECTED = 2;
        public static final int UNCOLLECTED = 3;
        public static final int WITHOUT_COLLECT = 1;
    }

    public static class FmAmListType {
        public static final int AM_ALL = 6;
        public static final int AM_AST = 5;
        public static final int AM_COLLECT = 4;
        public static final int FM_ALL = 3;
        public static final int FM_AST = 2;
        public static final int FM_COLLECT = 1;
    }

    public static class FmAmPlayAction {
        public static final int CANCEL_SCAN = 5;
        public static final int COLLECT = 10;
        public static final int ERROR = 100;
        public static final int NEXT_CHANNEL = 7;
        public static final int NEXT_FREQUENCY = 9;
        public static final int OPEN = 1;
        public static final int PLAY = 2;
        public static final int PREV_CHANNEL = 6;
        public static final int PREV_FREQUENCY = 8;
        public static final int SCAN = 4;
        public static final int STOP = 3;
        public static final int UNCOLLECT = 11;
    }

    public static class FmAmPlayStatus {
        public static final int ERROR = 100;
        public static final int PLAYING = 1;
        public static final int STOPPED = 2;
    }

    public static class FmAmSearchStatus {
        public static final int SCANNING = 2;
        public static final int SEARCH_STOP = 1;
        public static final int SEEKING = 3;
        public static final int SEEKING_BACKWARD = 5;
        public static final int SEEKING_FORWARD = 4;
    }

    public static class VDValueDAB {

        public static class AnnouncementStatus {
            public static final int HIDE = 0;
            public static final int SHOW = 1;
        }

        public static class AnnouncementType {
            public static final int ALARM = 1;
            public static final int INVALID = 0;
            public static final int OTHER = 3;
            public static final int TRAFFIC = 2;
        }

        public static class CollectStatus {
            public static final int COLLECTED = 2;
            public static final int UNCOLLECTED = 3;
            public static final int WITHOUT_COLLECT = 1;
        }

        public static class HeadlineAction {
            public static final int FIRST_PAGE = 0;
            public static final int NEXT_PAGE = 1;
            public static final int PRE_PAGE = 2;
            public static final int STOP_GET = 3;
        }

        public static class HeadlineType {
            public static final int CONTENT = 2;
            public static final int INVALID = 3;
            public static final int MENU_HAS_CHILD = 1;
            public static final int MENU_NO_CHILD = 4;
        }

        public static class ListType {
            public static final int DAB_ALL = 3;
            public static final int DAB_AST = 2;
            public static final int DAB_COLLECT = 1;
        }

        public static class PlayAction {
            public static final int CANCEL_SCAN = 5;
            public static final int COLLECT = 8;
            public static final int NEXT_CHANNEL = 7;
            public static final int OPEN = 1;
            public static final int PLAY = 2;
            public static final int PREV_CHANNEL = 6;
            public static final int SCAN = 4;
            public static final int STOP = 3;
        }

        public static class PlayStatus {
            public static final int ERROR = 100;
            public static final int PLAYING = 1;
            public static final int STOPPED = 2;
        }

        public static class SearchStatus {
            public static final int SCANNING = 2;
            public static final int SEARCH_STOP = 1;
        }

        public static class SubServiceFlag {
            public static final int NO_SUB = 0;
            public static final int SUB = 1;
        }

        public static class SwitchStatus {
            public static final int SWITCH_INVALID = -1;
            public static final int SWITCH_OFF = 0;
            public static final int SWITCH_ON = 1;
        }

        public static class TimeStatus {
            public static final int INVALID = 0;
            public static final int VALID = 1;
        }
    }

    public static class VDValueRDS {

        public static class ProgramType {
            public static final int ALARM = 31;
            public static final int ALARM_TEST = 30;
            public static final int CHILDREN_PROGRAMMES = 18;
            public static final int COUNTRY_MUSIC = 25;
            public static final int CULTURE = 7;
            public static final int CURRENT_AFFAIRS = 2;
            public static final int DOCUMENTARY = 29;
            public static final int DRAMA = 6;
            public static final int EASY_LISTENING_MUSIC = 12;
            public static final int EDUCATION = 5;
            public static final int FINANCE = 17;
            public static final int FOLK_MUSIC = 28;
            public static final int INFORMATION = 3;
            public static final int JAZZ_MUSIC = 24;
            public static final int LEISURE = 23;
            public static final int LIGHT_CLASSICAL = 13;
            public static final int NATIONAL_MUSIC = 26;
            public static final int NEWS = 1;
            public static final int NO_TYPE_OR_UNDEFINED = 0;
            public static final int OLDIES_MUSIC = 27;
            public static final int OTHER_MUSIC = 15;
            public static final int PHONE_IN = 21;
            public static final int POP_MUSIC = 10;
            public static final int RELIGION = 20;
            public static final int ROCK_MUSIC = 11;
            public static final int SCIENCE = 8;
            public static final int SERIOUS_CLASSICAL = 14;
            public static final int SOCIAL_AFFAIRS = 19;
            public static final int SPORT = 4;
            public static final int TRAVEL = 22;
            public static final int VARIED = 9;
            public static final int WEATHER = 16;
        }

        public static class SwitchStatus {
            public static final int SWITCH_INVALID = -1;
            public static final int SWITCH_OFF = 0;
            public static final int SWITCH_ON = 1;
        }
    }
}
