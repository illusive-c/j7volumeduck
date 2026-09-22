package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDTboxPKIInfo implements Parcelable {
    public static final Parcelable.Creator<VDTboxPKIInfo> CREATOR = new Parcelable.Creator<VDTboxPKIInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTboxPKIInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTboxPKIInfo createFromParcel(Parcel parcel) {
            return new VDTboxPKIInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTboxPKIInfo[] newArray(int i2) {
            return new VDTboxPKIInfo[i2];
        }
    };
    private int ack;
    private int certificateStatus;
    private String commandType;
    private byte[] messageID;
    private int result;

    public VDTboxPKIInfo() {
    }

    public static VDEvent createEvent(int i2, VDTboxPKIInfo vDTboxPKIInfo) {
        return new VDEvent(i2, createPayload(vDTboxPKIInfo));
    }

    public static Bundle createPayload(VDTboxPKIInfo vDTboxPKIInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTboxPKIInfo.class.getClassLoader());
        bundle.putParcelable("info", vDTboxPKIInfo);
        return bundle;
    }

    public static VDTboxPKIInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTboxPKIInfo.class.getClassLoader());
        return (VDTboxPKIInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAck() {
        return this.ack;
    }

    public int getCertificateStatus() {
        return this.certificateStatus;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public byte[] getMessageID() {
        return this.messageID;
    }

    public int getResult() {
        return this.result;
    }

    public void setAck(int i2) {
        this.ack = i2;
    }

    public void setCertificateStatus(int i2) {
        this.certificateStatus = i2;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setMessageID(byte[] bArr) {
        this.messageID = bArr;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public String toString() {
        return "VDTboxPKIInfo{commandType='" + this.commandType + "', ack=" + this.ack + ", result=" + this.result + ", certificateStatus=" + this.certificateStatus + ", messageID=" + Arrays.toString(this.messageID) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.commandType);
        parcel.writeInt(this.ack);
        parcel.writeInt(this.result);
        parcel.writeInt(this.certificateStatus);
        parcel.writeByteArray(this.messageID);
    }

    protected VDTboxPKIInfo(Parcel parcel) {
        this.commandType = parcel.readString();
        this.ack = parcel.readInt();
        this.result = parcel.readInt();
        this.certificateStatus = parcel.readInt();
        this.messageID = parcel.createByteArray();
    }
}
