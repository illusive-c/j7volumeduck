package com.desaysv.ivi.vdb.event.id.cabin.bean;

import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCLRVCInfo {
    int rvcMsg = 1;
    boolean status = false;
    String type = null;
    String value = null;

    public int getRvcMsg() {
        return this.rvcMsg;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setRvcMsg(int i2) {
        this.rvcMsg = i2;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public static VDCLRVCInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCLRVCInfo vDCLRVCInfo = new VDCLRVCInfo();
        vDCLRVCInfo.setRvcMsg(vDEvent.getPayload().getInt(VDValueCabinLan.MSG_TYPE));
        vDCLRVCInfo.setStatus(vDEvent.getPayload().getBoolean("status"));
        vDCLRVCInfo.setType(vDEvent.getPayload().getString("type"));
        vDCLRVCInfo.setValue(vDEvent.getPayload().getString("value"));
        return vDCLRVCInfo;
    }
}
