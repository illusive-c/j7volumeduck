package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDCLDisplayRequestInfo {
    int reqExtend;
    int displayId = -1;
    int requesterId = -1;

    public static VDEvent createEvent(int i2, VDCLDisplayRequestInfo vDCLDisplayRequestInfo) {
        return new VDEvent(i2, createPayload(vDCLDisplayRequestInfo));
    }

    public static VDEvent createGetEvent(int i2, VDCLDisplayRequestInfo vDCLDisplayRequestInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", vDCLDisplayRequestInfo.getDisplayId());
        return new VDEvent(i2, bundle);
    }

    public static Bundle createPayload(VDCLDisplayRequestInfo vDCLDisplayRequestInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", vDCLDisplayRequestInfo.getDisplayId());
        return bundle;
    }

    public int getDisplayId() {
        return this.displayId;
    }

    public int getReqExtend() {
        return this.reqExtend;
    }

    public int getRequesterId() {
        return this.requesterId;
    }

    public void setDisplayId(int i2) {
        this.displayId = i2;
    }

    public void setReqExtend(int i2) {
        this.reqExtend = i2;
    }

    public void setRequesterId(int i2) {
        this.requesterId = i2;
    }

    public String toString() {
        return "VDCLDisplayRequestInfo{displayId=" + this.displayId + ", requesterId=" + this.requesterId + ", reqExtend=" + this.reqExtend + '}';
    }
}
