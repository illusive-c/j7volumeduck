package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDCallParameter implements Parcelable {
    public static final Parcelable.Creator<VDCallParameter> CREATOR = new Parcelable.Creator<VDCallParameter>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDCallParameter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDCallParameter createFromParcel(Parcel parcel) {
            return new VDCallParameter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDCallParameter[] newArray(int i2) {
            return new VDCallParameter[i2];
        }
    };
    private String callType;
    private int cmd;
    private String phoneNumber;

    public VDCallParameter() {
    }

    public static VDEvent createEvent(int i2, VDCallParameter vDCallParameter) {
        return new VDEvent(i2, createPayload(vDCallParameter));
    }

    public static Bundle createPayload(VDCallParameter vDCallParameter) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDCallParameter.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDCallParameter);
        return bundle;
    }

    public static VDCallParameter getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDCallParameter.class.getClassLoader());
        return (VDCallParameter) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallType() {
        return this.callType;
    }

    public int getCmd() {
        return this.cmd;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setCallType(String str) {
        this.callType = str;
    }

    public void setCmd(int i2) {
        this.cmd = i2;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String toString() {
        return "VDCallParameter{cmd=" + this.cmd + ", callType='" + this.callType + "', phoneNumber='" + this.phoneNumber + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.cmd);
        parcel.writeString(this.callType);
        parcel.writeString(this.phoneNumber);
    }

    protected VDCallParameter(Parcel parcel) {
        this.cmd = parcel.readInt();
        this.callType = parcel.readString();
        this.phoneNumber = parcel.readString();
    }
}
