package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;

/* loaded from: classes.dex */
public class VDCabinLanMessage {
    private static final String BUNDLE_KEY_MSG_DATA = "CabinLanMessage_MsgData";
    private static final String BUNDLE_KEY_MSG_ID = "CabinLanMessage_MsgID";
    private static final String PREFIX_CLASS_NAME = "CabinLanMessage_";
    private static final String TAG = "VDCabinLanMessage";
    public static VDCabinLanMessage cabinLanMessage = new VDCabinLanMessage();
    private int msgID;
    private int msgResult = 0;
    private String msg = null;

    public static VDEvent createEvent(int i2, VDCabinLanMessage vDCabinLanMessage) {
        return new VDEvent(i2, createPayload(vDCabinLanMessage));
    }

    public static VDEvent createGetEvent(int i2, VDCabinLanMessage vDCabinLanMessage) {
        return createEvent(i2, vDCabinLanMessage);
    }

    public static Bundle createPayload(VDCabinLanMessage vDCabinLanMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY_MSG_ID, vDCabinLanMessage.getMsgID());
        bundle.putString(BUNDLE_KEY_MSG_DATA, vDCabinLanMessage.getMsg());
        return bundle;
    }

    public static VDCabinLanMessage getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        cabinLanMessage.setMsgResult(vDEvent.getPayload().getInt(VDValueCabinLan.RESULT_TYPE));
        cabinLanMessage.setMsgID(vDEvent.getPayload().getInt(BUNDLE_KEY_MSG_ID));
        cabinLanMessage.setMsg(vDEvent.getPayload().getString(BUNDLE_KEY_MSG_DATA));
        return cabinLanMessage;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getMsgID() {
        return this.msgID;
    }

    public int getMsgResult() {
        return this.msgResult;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setMsgID(int i2) {
        this.msgID = i2;
    }

    public void setMsgResult(int i2) {
        this.msgResult = i2;
    }

    public String toString() {
        return "VDCabinLanMessage{msgResult=" + this.msgResult + ", msgID=" + this.msgID + ", msg='" + this.msg + "'}";
    }
}
