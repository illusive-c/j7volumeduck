package com.desaysv.ivi.vdb.event.id.log;

/* loaded from: classes.dex */
public class VDValueLog {

    public static class LogAction {
        public static final int DIALOGS = 2;
        public static final int SILENT = 1;
    }

    public static class LogData {
        public static final int ALL = 2;
        public static final int EXTRA = 1;
    }

    public static class LogStatus {
        public static final int IDLE = 5;
        public static final int IN_PROGRESS = 2;
        public static final int NO_LOG_DISK = 6;
        public static final int OUT_OF_SPACE = 3;
        public static final int SUCCESS = 1;
        public static final int TIMEOUT = 4;
    }

    public static class LogType {
        public static final int ALL = 3;
        public static final int ANDROID = 2;
        public static final int QNX = 1;
    }

    public static class Priority {
        public static final int D = 3;
        public static final int E = 6;
        public static final int F = 7;
        public static final int I = 4;
        public static final int V = 2;
        public static final int W = 5;
    }
}
