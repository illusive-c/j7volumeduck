package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDRPAInfo implements Parcelable {
    public static final Parcelable.Creator<VDRPAInfo> CREATOR = new Parcelable.Creator<VDRPAInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRPAInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRPAInfo createFromParcel(Parcel parcel) {
            return new VDRPAInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRPAInfo[] newArray(int i2) {
            return new VDRPAInfo[i2];
        }
    };
    private int ack;
    private byte apaFeedback;
    private String commandType;
    private int confirmHeartbeat;
    private byte[] messageID;
    private byte messageType;
    private byte parkingSlotList1;
    private byte parkingSlotList2;
    private byte rpaCommand;

    public VDRPAInfo() {
    }

    public static VDEvent createEvent(int i2, VDRPAInfo vDRPAInfo) {
        return new VDEvent(i2, createPayload(vDRPAInfo));
    }

    public static Bundle createPayload(VDRPAInfo vDRPAInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRPAInfo.class.getClassLoader());
        bundle.putParcelable("info", vDRPAInfo);
        return bundle;
    }

    public static VDRPAInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRPAInfo.class.getClassLoader());
        return (VDRPAInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAck() {
        return this.ack;
    }

    public byte getApaFeedback() {
        return this.apaFeedback;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public int getConfirmHeartbeat() {
        return this.confirmHeartbeat;
    }

    public byte[] getMessageID() {
        return this.messageID;
    }

    public byte getMessageType() {
        return this.messageType;
    }

    public byte getParkingSlotList1() {
        return this.parkingSlotList1;
    }

    public byte getParkingSlotList2() {
        return this.parkingSlotList2;
    }

    public byte getRpaCommand() {
        return this.rpaCommand;
    }

    public void setAck(int i2) {
        this.ack = i2;
    }

    public void setApaFeedback(byte b2) {
        this.apaFeedback = b2;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setConfirmHeartbeat(int i2) {
        this.confirmHeartbeat = i2;
    }

    public void setMessageID(byte[] bArr) {
        this.messageID = bArr;
    }

    public void setMessageType(byte b2) {
        this.messageType = b2;
    }

    public void setParkingSlotList1(byte b2) {
        this.parkingSlotList1 = b2;
    }

    public void setParkingSlotList2(byte b2) {
        this.parkingSlotList2 = b2;
    }

    public void setRpaCommand(byte b2) {
        this.rpaCommand = b2;
    }

    public String toString() {
        return "VDRPAInfo{commandType='" + this.commandType + "', ack=" + this.ack + ", messageID=" + Arrays.toString(this.messageID) + ", messageType=" + ((int) this.messageType) + ", rpaCommand=" + ((int) this.rpaCommand) + ", apaFeedback=" + ((int) this.apaFeedback) + ", parkingSlotList1=" + ((int) this.parkingSlotList1) + ", parkingSlotList2=" + ((int) this.parkingSlotList2) + ", confirmHeartbeat=" + this.confirmHeartbeat + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.commandType);
        parcel.writeInt(this.ack);
        parcel.writeByteArray(this.messageID);
        parcel.writeByte(this.messageType);
        parcel.writeByte(this.rpaCommand);
        parcel.writeByte(this.apaFeedback);
        parcel.writeByte(this.parkingSlotList1);
        parcel.writeByte(this.parkingSlotList2);
        parcel.writeInt(this.confirmHeartbeat);
    }

    protected VDRPAInfo(Parcel parcel) {
        this.commandType = parcel.readString();
        this.ack = parcel.readInt();
        this.messageID = parcel.createByteArray();
        this.messageType = parcel.readByte();
        this.rpaCommand = parcel.readByte();
        this.apaFeedback = parcel.readByte();
        this.parkingSlotList1 = parcel.readByte();
        this.parkingSlotList2 = parcel.readByte();
        this.confirmHeartbeat = parcel.readInt();
    }
}
