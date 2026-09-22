package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDUsbUpgrade implements Parcelable {
    public static final Parcelable.Creator<VDUsbUpgrade> CREATOR = new Parcelable.Creator<VDUsbUpgrade>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDUsbUpgrade.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDUsbUpgrade createFromParcel(Parcel parcel) {
            return new VDUsbUpgrade(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDUsbUpgrade[] newArray(int i2) {
            return new VDUsbUpgrade[i2];
        }
    };
    private int ack;
    private int checkMethod;
    private String checkSumCode;
    private String commandType;
    private int ecuId;
    private String fileName;
    private long fileSize;
    private byte[] messageID;
    private int model;
    private long taskId;

    public VDUsbUpgrade() {
    }

    public static VDEvent createEvent(int i2, VDUsbUpgrade vDUsbUpgrade) {
        return new VDEvent(i2, createPayload(vDUsbUpgrade));
    }

    public static Bundle createPayload(VDUsbUpgrade vDUsbUpgrade) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDUsbUpgrade.class.getClassLoader());
        bundle.putParcelable("info", vDUsbUpgrade);
        return bundle;
    }

    public static VDUsbUpgrade getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDUsbUpgrade.class.getClassLoader());
        return (VDUsbUpgrade) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAck() {
        return this.ack;
    }

    public int getCheckMethod() {
        return this.checkMethod;
    }

    public String getCheckSumCode() {
        return this.checkSumCode;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public int getEcuId() {
        return this.ecuId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public byte[] getMessageID() {
        return this.messageID;
    }

    public int getModel() {
        return this.model;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setAck(int i2) {
        this.ack = i2;
    }

    public void setCheckMethod(int i2) {
        this.checkMethod = i2;
    }

    public void setCheckSumCode(String str) {
        this.checkSumCode = str;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setEcuId(int i2) {
        this.ecuId = i2;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j2) {
        this.fileSize = j2;
    }

    public void setMessageID(byte[] bArr) {
        this.messageID = bArr;
    }

    public void setModel(int i2) {
        this.model = i2;
    }

    public void setTaskId(long j2) {
        this.taskId = j2;
    }

    public String toString() {
        return "VDUsbUpgrade{commandType='" + this.commandType + "', ack=" + this.ack + ", messageID=" + Arrays.toString(this.messageID) + ", taskId=" + this.taskId + ", model=" + this.model + ", fileName='" + this.fileName + "', fileSize=" + this.fileSize + ", ecuId=" + this.ecuId + ", checkMethod=" + this.checkMethod + ", checkSumCode=" + this.checkSumCode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.commandType);
        parcel.writeInt(this.ack);
        parcel.writeByteArray(this.messageID);
        parcel.writeLong(this.taskId);
        parcel.writeInt(this.model);
        parcel.writeString(this.fileName);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.ecuId);
        parcel.writeInt(this.checkMethod);
        parcel.writeString(this.checkSumCode);
    }

    protected VDUsbUpgrade(Parcel parcel) {
        this.commandType = parcel.readString();
        this.ack = parcel.readInt();
        this.messageID = parcel.createByteArray();
        this.taskId = parcel.readLong();
        this.model = parcel.readInt();
        this.fileName = parcel.readString();
        this.fileSize = parcel.readLong();
        this.ecuId = parcel.readInt();
        this.checkMethod = parcel.readInt();
        this.checkSumCode = parcel.readString();
    }
}
