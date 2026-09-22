package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTPair implements Parcelable {
    public static final Parcelable.Creator<VDBTPair> CREATOR = new Parcelable.Creator<VDBTPair>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTPair.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPair createFromParcel(Parcel parcel) {
            return new VDBTPair(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPair[] newArray(int i2) {
            return new VDBTPair[i2];
        }
    };
    private int mPin;
    private String mMac = null;
    private String mName = null;
    private int mPairStatus = 1;
    private int mPairCtrl = 1;
    private int mDeviceType = 0;

    public VDBTPair() {
    }

    public static VDEvent createEvent(int i2, VDBTPair vDBTPair) {
        return new VDEvent(i2, createPayload(vDBTPair));
    }

    public static Bundle createPayload(VDBTPair vDBTPair) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPair.class.getClassLoader());
        bundle.putParcelable("status", vDBTPair);
        return bundle;
    }

    public static VDBTPair getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPair.class.getClassLoader());
        return (VDBTPair) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mName = parcel.readString();
        this.mPin = parcel.readInt();
        this.mPairStatus = parcel.readInt();
        this.mPairCtrl = parcel.readInt();
        this.mDeviceType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public String getMac() {
        return this.mMac;
    }

    public String getName() {
        return this.mName;
    }

    public int getPairCtrl() {
        return this.mPairCtrl;
    }

    public int getPairStatus() {
        return this.mPairStatus;
    }

    public int getPin() {
        return this.mPin;
    }

    public void putDeviceType(int i2) {
        this.mDeviceType = i2;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public void putName(String str) {
        this.mName = str;
    }

    public void putPairCtrl(int i2) {
        this.mPairCtrl = i2;
    }

    public void putPairStatus(int i2) {
        this.mPairStatus = i2;
    }

    public void putPin(int i2) {
        this.mPin = i2;
    }

    public String toString() {
        return "VDBTPair{mac=" + this.mMac + ", mName=" + this.mName + ", pin=" + this.mPin + ", pairStatus=" + this.mPairStatus + ", pairCtrl=" + this.mPairCtrl + ", deviceType=" + this.mDeviceType + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mPin);
        parcel.writeInt(this.mPairStatus);
        parcel.writeInt(this.mPairCtrl);
        parcel.writeInt(this.mDeviceType);
    }

    protected VDBTPair(Parcel parcel) {
        readFromParcel(parcel);
    }
}
