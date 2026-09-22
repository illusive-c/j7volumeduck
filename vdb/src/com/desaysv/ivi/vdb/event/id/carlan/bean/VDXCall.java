package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.carlan.VDValueCarLan;

/* loaded from: classes.dex */
public class VDXCall implements Parcelable {
    public static final Parcelable.Creator<VDXCall> CREATOR = new Parcelable.Creator<VDXCall>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDXCall.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDXCall createFromParcel(Parcel parcel) {
            return new VDXCall(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDXCall[] newArray(int i2) {
            return new VDXCall[i2];
        }
    };
    private int callCommandAck;
    private int callCommandResp;
    private int callErrorCode;
    private String callType;
    private String commandType;
    private int millisecond;
    private String phoneNumber;
    private String state;

    public VDXCall() {
        this.callType = VDValueCarLan.XCallType.B_CALL;
        this.state = VDValueCarLan.XCallStatus.IDLE;
    }

    public static VDEvent createEvent(int i2, VDXCall vDXCall) {
        return new VDEvent(i2, createPayload(vDXCall));
    }

    public static Bundle createPayload(VDXCall vDXCall) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDXCall.class.getClassLoader());
        bundle.putParcelable("status", vDXCall);
        return bundle;
    }

    public static VDXCall getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDXCall.class.getClassLoader());
        return (VDXCall) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCallCommandAck() {
        return this.callCommandAck;
    }

    public int getCallCommandResp() {
        return this.callCommandResp;
    }

    public int getCallErrorCode() {
        return this.callErrorCode;
    }

    public String getCallType() {
        return this.callType;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public int getMillisecond() {
        return this.millisecond;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getState() {
        return this.state;
    }

    public void setCallCommandAck(int i2) {
        this.callCommandAck = i2;
    }

    public void setCallCommandResp(int i2) {
        this.callCommandResp = i2;
    }

    public void setCallErrorCode(int i2) {
        this.callErrorCode = i2;
    }

    public void setCallType(String str) {
        this.callType = str;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setMillisecond(int i2) {
        this.millisecond = i2;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "VDXCall{callType='" + this.callType + "', phoneNumber='" + this.phoneNumber + "', state='" + this.state + "', millisecond=" + this.millisecond + ", commandType='" + this.commandType + "', callCommandResp=" + this.callCommandResp + ", callCommandAck=" + this.callCommandAck + ", callErrorCode=" + this.callErrorCode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.callType);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.state);
        parcel.writeInt(this.millisecond);
        parcel.writeString(this.commandType);
        parcel.writeInt(this.callCommandResp);
        parcel.writeInt(this.callCommandAck);
        parcel.writeInt(this.callErrorCode);
    }

    protected VDXCall(Parcel parcel) {
        this.callType = VDValueCarLan.XCallType.B_CALL;
        this.state = VDValueCarLan.XCallStatus.IDLE;
        this.callType = parcel.readString();
        this.phoneNumber = parcel.readString();
        this.state = parcel.readString();
        this.millisecond = parcel.readInt();
        this.commandType = parcel.readString();
        this.callCommandResp = parcel.readInt();
        this.callCommandAck = parcel.readInt();
        this.callErrorCode = parcel.readInt();
    }
}
