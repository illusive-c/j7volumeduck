package com.desaysv.ivi.vdb.event.id.cabin.bean;

import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCLUpdateInfo {
    int updateMsg = 0;
    int module = 32768;
    int status = 0;

    public static VDCLUpdateInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCLUpdateInfo vDCLUpdateInfo = new VDCLUpdateInfo();
        vDCLUpdateInfo.setUpdateMsg(vDEvent.getPayload().getInt(VDValueCabinLan.MSG_TYPE));
        vDCLUpdateInfo.setModule(vDEvent.getPayload().getInt(VDValueCabinLan.MODULE_TYPE));
        vDCLUpdateInfo.setStatus(vDEvent.getPayload().getInt(VDValueCabinLan.RESULT_STATUS));
        return vDCLUpdateInfo;
    }

    public int getModule() {
        return this.module;
    }

    public int getStatus() {
        return this.status;
    }

    public int getUpdateMsg() {
        return this.updateMsg;
    }

    public void setModule(int i2) {
        this.module = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setUpdateMsg(int i2) {
        this.updateMsg = i2;
    }
}
