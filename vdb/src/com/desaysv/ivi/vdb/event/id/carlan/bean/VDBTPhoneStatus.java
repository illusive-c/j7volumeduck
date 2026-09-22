package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTPhoneStatus implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneStatus> CREATOR = new Parcelable.Creator<VDBTPhoneStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneStatus createFromParcel(Parcel parcel) {
            return new VDBTPhoneStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneStatus[] newArray(int i2) {
            return new VDBTPhoneStatus[i2];
        }
    };
    private int CallState;
    private String ContactPicture;
    private String Name;
    private String Number;
    private int PhoneType;

    public VDBTPhoneStatus() {
        this.PhoneType = 1;
        this.CallState = 0;
    }

    public static VDEvent createEvent(int i2, VDBTPhoneStatus vDBTPhoneStatus) {
        return new VDEvent(i2, createPayload(vDBTPhoneStatus));
    }

    public static Bundle createPayload(VDBTPhoneStatus vDBTPhoneStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneStatus);
        return bundle;
    }

    public static VDBTPhoneStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneStatus.class.getClassLoader());
        return (VDBTPhoneStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCallState() {
        return this.CallState;
    }

    public String getContactPicture() {
        return this.ContactPicture;
    }

    public String getName() {
        return this.Name;
    }

    public String getNumber() {
        return this.Number;
    }

    public int getPhoneType() {
        return this.PhoneType;
    }

    public void setCallState(int i2) {
        this.CallState = i2;
    }

    public void setContactPicture(String str) {
        this.ContactPicture = str;
    }

    public void setName(String str) {
        this.Name = str;
    }

    public void setNumber(String str) {
        this.Number = str;
    }

    public void setPhoneType(int i2) {
        this.PhoneType = i2;
    }

    public String toString() {
        return "VDBTPhoneStatus{PhoneType=" + this.PhoneType + ", Name='" + this.Name + "', Number='" + this.Number + "', CallState=" + this.CallState + ", ContactPicture='" + this.ContactPicture + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.PhoneType);
        parcel.writeString(this.Name);
        parcel.writeString(this.Number);
        parcel.writeInt(this.CallState);
        parcel.writeString(this.ContactPicture);
    }

    protected VDBTPhoneStatus(Parcel parcel) {
        this.PhoneType = 1;
        this.CallState = 0;
        this.PhoneType = parcel.readInt();
        this.Name = parcel.readString();
        this.Number = parcel.readString();
        this.CallState = parcel.readInt();
        this.ContactPicture = parcel.readString();
    }
}
