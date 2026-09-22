package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCLDmsMessage {
    private int dmsResult = 0;
    private String msg = null;
    private int msgType;

    public static VDEvent createEvent(int i2, VDCLDmsMessage vDCLDmsMessage) {
        return new VDEvent(i2, createPayload(vDCLDmsMessage));
    }

    public static VDEvent createGetEvent(int i2, VDCLDmsMessage vDCLDmsMessage) {
        return createEvent(i2, vDCLDmsMessage);
    }

    public static Bundle createPayload(VDCLDmsMessage vDCLDmsMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(VDValueCabinLan.MSG_TYPE, vDCLDmsMessage.getMsgType());
        bundle.putString(VDValueCabinLan.MSG_DATA, vDCLDmsMessage.getMsg());
        return bundle;
    }

    public static VDCLDmsMessage getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCLDmsMessage vDCLDmsMessage = new VDCLDmsMessage();
        vDCLDmsMessage.setDmsResult(vDEvent.getPayload().getInt(VDValueCabinLan.RESULT_TYPE));
        vDCLDmsMessage.setMsg(vDEvent.getPayload().getString(VDValueCabinLan.MSG_DATA));
        return vDCLDmsMessage;
    }

    public int getDmsResult() {
        return this.dmsResult;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setDmsResult(int i2) {
        this.dmsResult = i2;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setMsgType(int i2) {
        this.msgType = i2;
    }

    public String toString() {
        return "VDCLDmsMessage{dmsResult=" + this.dmsResult + ", msgType=" + this.msgType + ", msg='" + this.msg + "'}";
    }
}
