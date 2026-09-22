package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.cabin.VDValueCabinLan;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDCabinLanRawData {
    private static final String BUNDLE_KEY_MSG_DATA = "CabinLanRawData_MsgData";
    private static final String BUNDLE_KEY_MSG_ID = "CabinLanRawData_MsgID";
    private static final String PREFIX_CLASS_NAME = "CabinLanRawData_";
    private static final String TAG = VDCabinLanMessage.class.getSimpleName();
    public static VDCabinLanRawData rawDataMessage = new VDCabinLanRawData();
    private int msgID;
    private int msgResult = 0;
    private byte[] rawData;

    public static VDEvent createEvent(int i2, VDCabinLanRawData vDCabinLanRawData) {
        return new VDEvent(i2, createPayload(vDCabinLanRawData));
    }

    public static VDEvent createGetEvent(int i2, VDCabinLanRawData vDCabinLanRawData) {
        return createEvent(i2, vDCabinLanRawData);
    }

    public static Bundle createPayload(VDCabinLanRawData vDCabinLanRawData) {
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY_MSG_ID, vDCabinLanRawData.getMsgID());
        bundle.putByteArray(BUNDLE_KEY_MSG_DATA, vDCabinLanRawData.getRawData());
        return bundle;
    }

    public static VDCabinLanRawData getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCabinLanRawData vDCabinLanRawData = new VDCabinLanRawData();
        vDCabinLanRawData.setMsgResult(vDEvent.getPayload().getInt(VDValueCabinLan.RESULT_TYPE));
        vDCabinLanRawData.setMsgID(vDEvent.getPayload().getInt(BUNDLE_KEY_MSG_ID));
        vDCabinLanRawData.setRawData(vDEvent.getPayload().getByteArray(BUNDLE_KEY_MSG_DATA));
        return vDCabinLanRawData;
    }

    public int getMsgID() {
        return this.msgID;
    }

    public int getMsgResult() {
        return this.msgResult;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public void setMsgID(int i2) {
        this.msgID = i2;
    }

    public void setMsgResult(int i2) {
        this.msgResult = i2;
    }

    public void setRawData(byte[] bArr) {
        this.rawData = bArr;
    }

    public String toString() {
        return "VDCabinLanRawData{msgResult=" + this.msgResult + ", msgID=" + this.msgID + ", rawData=" + Arrays.toString(this.rawData) + '}';
    }
}
