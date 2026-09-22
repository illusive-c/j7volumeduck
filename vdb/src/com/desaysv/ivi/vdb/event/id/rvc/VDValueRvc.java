package com.desaysv.ivi.vdb.event.id.rvc;

/* loaded from: classes.dex */
public class VDValueRvc {

    public static class AvmFloating {
        public static final int ERROR = 100;
        public static final int FULL = 2;
        public static final int HIDE = 1;
        public static final int NONFULL = 3;
    }

    public static class AvmIconPress {
        public static final int APPICON = 1;
        public static final int VRCLOSE = 3;
        public static final int VROPEN = 2;
    }

    public static class AvmStatus {
        public static final int CLOSE = 1;
        public static final int ERROR = 100;
        public static final int STARTUP = 2;
    }

    public static class RvcStatus {
        public static final int ERROR = 100;
        public static final int IDLE = 1;
        public static final int RVC = 2;
    }

    public static class RvcType {
        public static final int AVM = 2;
        public static final int RVC = 1;
    }
}
