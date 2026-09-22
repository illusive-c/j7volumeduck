package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTDial implements Parcelable {
    public static final Parcelable.Creator<VDBTDial> CREATOR = new Parcelable.Creator<VDBTDial>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTDial.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDial createFromParcel(Parcel parcel) {
            return new VDBTDial(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDial[] newArray(int i2) {
            return new VDBTDial[i2];
        }
    };
    private String mNumber = null;
    private String mAddress = null;
    private int mDialStatus = 0;
    private int mDialCtrl = 1;
    private int mAcceptCallType = 1;
    private int mRedialType = 0;
    private String mUuid = null;

    public VDBTDial() {
    }

    public static VDEvent createEvent(int i2, VDBTDial vDBTDial) {
        return new VDEvent(i2, createPayload(vDBTDial));
    }

    public static Bundle createPayload(VDBTDial vDBTDial) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDial.class.getClassLoader());
        bundle.putParcelable("status", vDBTDial);
        return bundle;
    }

    public static VDBTDial getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDial.class.getClassLoader());
        return (VDBTDial) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mNumber = parcel.readString();
        this.mAddress = parcel.readString();
        this.mDialStatus = parcel.readInt();
        this.mDialCtrl = parcel.readInt();
        this.mAcceptCallType = parcel.readInt();
        this.mRedialType = parcel.readInt();
        this.mUuid = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAcceptCallType() {
        return this.mAcceptCallType;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getDialCtrl() {
        return this.mDialCtrl;
    }

    public int getDialStatus() {
        return this.mDialStatus;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public int getRedialType() {
        return this.mRedialType;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public void putAcceptCallType(int i2) {
        this.mAcceptCallType = i2;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putDialCtrl(int i2) {
        this.mDialCtrl = i2;
    }

    public void putDialStatus(int i2) {
        this.mDialStatus = i2;
    }

    public void putNumber(String str) {
        this.mNumber = str;
    }

    public void putRedialType(int i2) {
        this.mRedialType = i2;
    }

    public void putUuid(String str) {
        this.mUuid = str;
    }

    public String toString() {
        return "VDBTDial{number=" + this.mNumber + ", address=" + this.mAddress + ", dialStatus=" + this.mDialStatus + ", dialCtrl=" + this.mDialCtrl + ", acceptCallType=" + this.mAcceptCallType + ", redialType=" + this.mRedialType + ", uuid=" + this.mUuid + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mDialStatus);
        parcel.writeInt(this.mDialCtrl);
        parcel.writeInt(this.mAcceptCallType);
        parcel.writeInt(this.mRedialType);
        parcel.writeString(this.mUuid);
    }

    protected VDBTDial(Parcel parcel) {
        readFromParcel(parcel);
    }
}
