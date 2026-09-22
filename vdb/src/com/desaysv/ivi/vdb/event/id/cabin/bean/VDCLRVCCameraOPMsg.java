package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCLRVCCameraOPMsg {
    private String cameraOP = null;
    private int params;
    private boolean result;

    public static VDEvent createEvent(int i2, VDCLRVCCameraOPMsg vDCLRVCCameraOPMsg) {
        return new VDEvent(i2, createPayload(vDCLRVCCameraOPMsg));
    }

    public static Bundle createPayload(VDCLRVCCameraOPMsg vDCLRVCCameraOPMsg) {
        Bundle bundle = new Bundle();
        bundle.putString(VDValueCabinLan.CAMERA_OP, vDCLRVCCameraOPMsg.getCameraOP());
        bundle.putInt(VDValueCabinLan.CAMERA_PARAMS, vDCLRVCCameraOPMsg.getParams());
        return bundle;
    }

    public static VDCLRVCCameraOPMsg getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCLRVCCameraOPMsg vDCLRVCCameraOPMsg = new VDCLRVCCameraOPMsg();
        vDCLRVCCameraOPMsg.setResult(vDEvent.getPayload().getBoolean(VDValueCabinLan.RESULT_STATUS));
        return vDCLRVCCameraOPMsg;
    }

    public String getCameraOP() {
        return this.cameraOP;
    }

    public int getParams() {
        return this.params;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCameraOP(String str) {
        this.cameraOP = str;
    }

    public void setParams(int i2) {
        this.params = i2;
    }

    public void setResult(boolean z2) {
        this.result = z2;
    }

    public String toString() {
        return "VDCLRVCCameraOPMsg{result=" + this.result + ", cameraOP='" + this.cameraOP + "', params=" + this.params + '}';
    }
}
