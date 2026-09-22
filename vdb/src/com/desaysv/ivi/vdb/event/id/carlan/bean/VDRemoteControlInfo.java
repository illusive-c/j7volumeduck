package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDRemoteControlInfo implements Parcelable {
    public static final Parcelable.Creator<VDRemoteControlInfo> CREATOR = new Parcelable.Creator<VDRemoteControlInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRemoteControlInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRemoteControlInfo createFromParcel(Parcel parcel) {
            return new VDRemoteControlInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRemoteControlInfo[] newArray(int i2) {
            return new VDRemoteControlInfo[i2];
        }
    };
    private int ChargeTimeEnd;
    private int ChargeTimeEndMin;
    private int ack;
    private int chargeSOC;
    private int chargeState;
    private int chargeTaskId;
    private int chargeTimeBegin;
    private int chargeTimeBeginMin;
    private int chargeType;
    private String commandType;
    private int diagType;
    private String dtcResult;
    private int dtcResultValid;
    private int ecuId;
    private int ecuSum;
    private long endTime;
    private int errorCode;
    private int hardVerValid;
    private String hardVersions;
    private int lightShowCtrlResult;
    private int lightShowModel;
    private byte[] messageID;
    private long messageId;
    private boolean moduleAndroid;
    private boolean moduleMCU;
    private boolean moduleQNX;
    private String partNum;
    private String repeatType;
    private int reqEcuDid;
    private int reserveType;
    private String roomId;
    private int softVerValid;
    private String softVersions;
    private long startTime;
    private String supplierId;
    private String upLogUrl;

    public VDRemoteControlInfo() {
    }

    public static VDEvent createEvent(int i2, VDRemoteControlInfo vDRemoteControlInfo) {
        return new VDEvent(i2, createPayload(vDRemoteControlInfo));
    }

    public static Bundle createPayload(VDRemoteControlInfo vDRemoteControlInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRemoteControlInfo.class.getClassLoader());
        bundle.putParcelable("info", vDRemoteControlInfo);
        return bundle;
    }

    public static VDRemoteControlInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRemoteControlInfo.class.getClassLoader());
        return (VDRemoteControlInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAck() {
        return this.ack;
    }

    public int getChargeSOC() {
        return this.chargeSOC;
    }

    public int getChargeState() {
        return this.chargeState;
    }

    public int getChargeTaskId() {
        return this.chargeTaskId;
    }

    public int getChargeTimeBegin() {
        return this.chargeTimeBegin;
    }

    public int getChargeTimeBeginMin() {
        return this.chargeTimeBeginMin;
    }

    public int getChargeTimeEnd() {
        return this.ChargeTimeEnd;
    }

    public int getChargeTimeEndMin() {
        return this.ChargeTimeEndMin;
    }

    public int getChargeType() {
        return this.chargeType;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public int getDiagType() {
        return this.diagType;
    }

    public String getDtcResult() {
        return this.dtcResult;
    }

    public int getDtcResultValid() {
        return this.dtcResultValid;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public int getEcuSum() {
        return this.ecuSum;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getHardVerValid() {
        return this.hardVerValid;
    }

    public String getHardVersions() {
        return this.hardVersions;
    }

    public int getLightShowCtrlResult() {
        return this.lightShowCtrlResult;
    }

    public int getLightShowModel() {
        return this.lightShowModel;
    }

    public byte[] getMessageID() {
        return this.messageID;
    }

    public long getMessageId() {
        return this.messageId;
    }

    public String getPartNum() {
        return this.partNum;
    }

    public String getRepeatType() {
        return this.repeatType;
    }

    public int getReqEcuDid() {
        return this.reqEcuDid;
    }

    public int getReserveType() {
        return this.reserveType;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public int getSoftVerValid() {
        return this.softVerValid;
    }

    public String getSoftVersions() {
        return this.softVersions;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getSupplierId() {
        return this.supplierId;
    }

    public String getUpLogUrl() {
        return this.upLogUrl;
    }

    public boolean isModuleAndroid() {
        return this.moduleAndroid;
    }

    public boolean isModuleMCU() {
        return this.moduleMCU;
    }

    public boolean isModuleQNX() {
        return this.moduleQNX;
    }

    public void setAck(int i2) {
        this.ack = i2;
    }

    public void setChargeSOC(int i2) {
        this.chargeSOC = i2;
    }

    public void setChargeState(int i2) {
        this.chargeState = i2;
    }

    public void setChargeTaskId(int i2) {
        this.chargeTaskId = i2;
    }

    public void setChargeTimeBegin(int i2) {
        this.chargeTimeBegin = i2;
    }

    public void setChargeTimeBeginMin(int i2) {
        this.chargeTimeBeginMin = i2;
    }

    public void setChargeTimeEnd(int i2) {
        this.ChargeTimeEnd = i2;
    }

    public void setChargeTimeEndMin(int i2) {
        this.ChargeTimeEndMin = i2;
    }

    public void setChargeType(int i2) {
        this.chargeType = i2;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setDiagType(int i2) {
        this.diagType = i2;
    }

    public void setDtcResult(String str) {
        this.dtcResult = str;
    }

    public void setDtcResultValid(int i2) {
        this.dtcResultValid = i2;
    }

    public void setEcuId(int i2) {
        this.ecuId = i2;
    }

    public void setEcuSum(int i2) {
        this.ecuSum = i2;
    }

    public void setEndTime(long j2) {
        this.endTime = j2;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setHardVerValid(int i2) {
        this.hardVerValid = i2;
    }

    public void setHardVersions(String str) {
        this.hardVersions = str;
    }

    public void setLightShowCtrlResult(int i2) {
        this.lightShowCtrlResult = i2;
    }

    public void setLightShowModel(int i2) {
        this.lightShowModel = i2;
    }

    public void setMessageID(byte[] bArr) {
        this.messageID = bArr;
    }

    public void setMessageId(long j2) {
        this.messageId = j2;
    }

    public void setModuleAndroid(boolean z2) {
        this.moduleAndroid = z2;
    }

    public void setModuleMCU(boolean z2) {
        this.moduleMCU = z2;
    }

    public void setModuleQNX(boolean z2) {
        this.moduleQNX = z2;
    }

    public void setPartNum(String str) {
        this.partNum = str;
    }

    public void setRepeatType(String str) {
        this.repeatType = str;
    }

    public void setReqEcuDid(int i2) {
        this.reqEcuDid = i2;
    }

    public void setReserveType(int i2) {
        this.reserveType = i2;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSoftVerValid(int i2) {
        this.softVerValid = i2;
    }

    public void setSoftVersions(String str) {
        this.softVersions = str;
    }

    public void setStartTime(long j2) {
        this.startTime = j2;
    }

    public void setSupplierId(String str) {
        this.supplierId = str;
    }

    public void setUpLogUrl(String str) {
        this.upLogUrl = str;
    }

    public String toString() {
        return "VDRemoteControlInfo{commandType='" + this.commandType + "', ack=" + this.ack + ", messageID=" + Arrays.toString(this.messageID) + ", roomId='" + this.roomId + "', chargeType=" + this.chargeType + ", reserveType=" + this.reserveType + ", chargeTaskId=" + this.chargeTaskId + ", chargeSOC=" + this.chargeSOC + ", chargeTimeBegin=" + this.chargeTimeBegin + ", chargeTimeBeginMin=" + this.chargeTimeBeginMin + ", ChargeTimeEnd=" + this.ChargeTimeEnd + ", ChargeTimeEndMin=" + this.ChargeTimeEndMin + ", repeatType='" + this.repeatType + "', chargeState=" + this.chargeState + ", lightShowModel=" + this.lightShowModel + ", lightShowCtrlResult=" + this.lightShowCtrlResult + ", errorCode=" + this.errorCode + ", upLogUrl='" + this.upLogUrl + "', messageId=" + this.messageId + ", diagType=" + this.diagType + ", ecuSum=" + this.ecuSum + ", ecuId=" + this.ecuId + ", softVerValid=" + this.softVerValid + ", softVersions='" + this.softVersions + "', hardVerValid=" + this.hardVerValid + ", hardVersions='" + this.hardVersions + "', dtcResultValid=" + this.dtcResultValid + ", dtcResult='" + this.dtcResult + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", moduleAndroid=" + this.moduleAndroid + ", moduleQNX=" + this.moduleQNX + ", moduleMCU=" + this.moduleMCU + ", reqEcuDid=" + this.reqEcuDid + ", partNum=" + this.partNum + ", supplierId=" + this.supplierId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.commandType);
        parcel.writeInt(this.ack);
        parcel.writeByteArray(this.messageID);
        parcel.writeString(this.roomId);
        parcel.writeInt(this.chargeType);
        parcel.writeInt(this.reserveType);
        parcel.writeInt(this.chargeTaskId);
        parcel.writeInt(this.chargeSOC);
        parcel.writeInt(this.chargeTimeBegin);
        parcel.writeInt(this.chargeTimeBeginMin);
        parcel.writeInt(this.ChargeTimeEnd);
        parcel.writeInt(this.ChargeTimeEndMin);
        parcel.writeString(this.repeatType);
        parcel.writeInt(this.chargeState);
        parcel.writeInt(this.lightShowModel);
        parcel.writeInt(this.lightShowCtrlResult);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.upLogUrl);
        parcel.writeLong(this.messageId);
        parcel.writeInt(this.diagType);
        parcel.writeInt(this.ecuSum);
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.softVerValid);
        parcel.writeString(this.softVersions);
        parcel.writeInt(this.hardVerValid);
        parcel.writeString(this.hardVersions);
        parcel.writeInt(this.dtcResultValid);
        parcel.writeString(this.dtcResult);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeBoolean(this.moduleAndroid);
        parcel.writeBoolean(this.moduleQNX);
        parcel.writeBoolean(this.moduleMCU);
        parcel.writeInt(this.reqEcuDid);
        parcel.writeString(this.partNum);
        parcel.writeString(this.supplierId);
    }

    protected VDRemoteControlInfo(Parcel parcel) {
        this.commandType = parcel.readString();
        this.ack = parcel.readInt();
        this.messageID = parcel.createByteArray();
        this.roomId = parcel.readString();
        this.chargeType = parcel.readInt();
        this.reserveType = parcel.readInt();
        this.chargeTaskId = parcel.readInt();
        this.chargeSOC = parcel.readInt();
        this.chargeTimeBegin = parcel.readInt();
        this.chargeTimeBeginMin = parcel.readInt();
        this.ChargeTimeEnd = parcel.readInt();
        this.ChargeTimeEndMin = parcel.readInt();
        this.repeatType = parcel.readString();
        this.chargeState = parcel.readInt();
        this.lightShowModel = parcel.readInt();
        this.lightShowCtrlResult = parcel.readInt();
        this.errorCode = parcel.readInt();
        this.upLogUrl = parcel.readString();
        this.messageId = parcel.readLong();
        this.diagType = parcel.readInt();
        this.ecuSum = parcel.readInt();
        this.ecuId = parcel.readInt();
        this.softVerValid = parcel.readInt();
        this.softVersions = parcel.readString();
        this.hardVerValid = parcel.readInt();
        this.hardVersions = parcel.readString();
        this.dtcResultValid = parcel.readInt();
        this.dtcResult = parcel.readString();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.moduleAndroid = parcel.readBoolean();
        this.moduleQNX = parcel.readBoolean();
        this.moduleMCU = parcel.readBoolean();
        this.reqEcuDid = parcel.readInt();
        this.partNum = parcel.readString();
        this.supplierId = parcel.readString();
    }
}
