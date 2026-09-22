package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCLUpdateMessage {
    private int moduleType = 32768;
    private String checkSum = null;

    public static VDEvent createEvent(int i2, VDCLUpdateMessage vDCLUpdateMessage) {
        return new VDEvent(i2, createPayload(vDCLUpdateMessage));
    }

    public static Bundle createPayload(VDCLUpdateMessage vDCLUpdateMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(VDValueCabinLan.MODULE_TYPE, vDCLUpdateMessage.getModuleType());
        bundle.putString(VDValueCabinLan.CHECK_SUM, vDCLUpdateMessage.getCheckSum());
        return bundle;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public int getModuleType() {
        return this.moduleType;
    }

    public void setCheckSum(String str) {
        this.checkSum = str;
    }

    public void setModuleType(int i2) {
        this.moduleType = i2;
    }

    public String toString() {
        return "VDCLUpdateMessage{moduleType=" + this.moduleType + ", checkSum='" + this.checkSum + "'}";
    }
}
