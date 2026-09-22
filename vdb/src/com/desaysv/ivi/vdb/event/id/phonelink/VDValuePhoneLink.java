package com.desaysv.ivi.vdb.event.id.phonelink;

/* loaded from: classes.dex */
public class VDValuePhoneLink {

    public static final class PhoneCallState {
        public static final int ACTIVE = 3;
        public static final int HELD = 5;
        public static final int IDLE = 0;
        public static final int INCOMING = 2;
        public static final int OUTGOING = 1;
        public static final int WAIT = 4;
    }

    public static final class PhoneStatus {
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
        public static final int DISCONNECTING = 3;
        public static final int NET_CONNECT = 4;
    }
}
