package com.desaysv.ivi.vdb.service.bind;

import com.desaysv.ivi.vdb.IVDBusCallback;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes2.dex */
public class VDClient {
    private IVDBusCallback mCallback;
    private String mPackageName;
    private int mPid;
    private VDEvent mSubscribeEvent;

    public VDClient(VDEvent vDEvent, int i2, String str, IVDBusCallback iVDBusCallback) {
        this.mSubscribeEvent = null;
        this.mPid = 0;
        this.mPackageName = null;
        this.mCallback = null;
        this.mSubscribeEvent = vDEvent;
        this.mPid = i2;
        this.mPackageName = str;
        this.mCallback = iVDBusCallback;
    }

    public IVDBusCallback getCallback() {
        return this.mCallback;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getPid() {
        return this.mPid;
    }

    public VDEvent getSubscribeEvent() {
        return this.mSubscribeEvent;
    }
}
