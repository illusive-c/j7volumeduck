package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTDevice implements Parcelable {
    public static final Parcelable.Creator<VDBTDevice> CREATOR = new Parcelable.Creator<VDBTDevice>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDevice createFromParcel(Parcel parcel) {
            return new VDBTDevice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDevice[] newArray(int i2) {
            return new VDBTDevice[i2];
        }
    };
    private String mMac = null;
    private String mName = null;
    private int mDeviceType = 0;
    private int mPairStatus = 1;
    private int mConnectStatus = 1;
    private int mHfpStatus = 1;
    private int mA2dpStatus = 1;
    private int mAvrcpStatus = 1;
    private int mPbapStatus = 1;
    private int mMapStatus = 1;
    private int mDeviceClass = 0;

    public VDBTDevice() {
    }

    public static VDEvent createEvent(int i2, VDBTDevice vDBTDevice) {
        return new VDEvent(i2, createPayload(vDBTDevice));
    }

    public static Bundle createPayload(VDBTDevice vDBTDevice) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDevice.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTDevice);
        return bundle;
    }

    public static ArrayList<VDBTDevice> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDevice.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTDevice getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDevice.class.getClassLoader());
        return (VDBTDevice) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mName = parcel.readString();
        this.mDeviceType = parcel.readInt();
        this.mPairStatus = parcel.readInt();
        this.mConnectStatus = parcel.readInt();
        this.mHfpStatus = parcel.readInt();
        this.mA2dpStatus = parcel.readInt();
        this.mAvrcpStatus = parcel.readInt();
        this.mPbapStatus = parcel.readInt();
        this.mMapStatus = parcel.readInt();
        this.mDeviceClass = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getA2dpStatus() {
        return this.mA2dpStatus;
    }

    public int getAvrcpStatus() {
        return this.mAvrcpStatus;
    }

    public int getConnectStatus() {
        return this.mConnectStatus;
    }

    public int getDeviceClass() {
        return this.mDeviceClass;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public int getHfpStatus() {
        return this.mHfpStatus;
    }

    public String getMac() {
        return this.mMac;
    }

    public int getMapStatus() {
        return this.mMapStatus;
    }

    public String getName() {
        return this.mName;
    }

    public int getPairStatus() {
        return this.mPairStatus;
    }

    public int getPbapStatus() {
        return this.mPbapStatus;
    }

    public void putA2dpStatus(int i2) {
        this.mA2dpStatus = i2;
    }

    public void putAvrcpStatus(int i2) {
        this.mAvrcpStatus = i2;
    }

    public void putConnectStatus(int i2) {
        this.mConnectStatus = i2;
    }

    public void putDeviceType(int i2) {
        this.mDeviceType = i2;
    }

    public void putHfpStatus(int i2) {
        this.mHfpStatus = i2;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public void putMapStatus(int i2) {
        this.mMapStatus = i2;
    }

    public void putName(String str) {
        this.mName = str;
    }

    public void putPairStatus(int i2) {
        this.mPairStatus = i2;
    }

    public void putPbapStatus(int i2) {
        this.mPbapStatus = i2;
    }

    public void setDeviceClass(int i2) {
        this.mDeviceClass = i2;
    }

    public String toString() {
        return "VDBTDevice{mac=" + this.mMac + ", name=" + this.mName + ", deviceType=" + this.mDeviceType + ", pairStatus=" + this.mPairStatus + ", connectStatus=" + this.mConnectStatus + ", hfpStatus=" + this.mHfpStatus + ", a2dpStatus=" + this.mA2dpStatus + ", avrcpStatus=" + this.mAvrcpStatus + ", pbapStatus=" + this.mPbapStatus + ", mapStatus=" + this.mMapStatus + ", deviceClass=" + this.mDeviceClass + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mDeviceType);
        parcel.writeInt(this.mPairStatus);
        parcel.writeInt(this.mConnectStatus);
        parcel.writeInt(this.mHfpStatus);
        parcel.writeInt(this.mA2dpStatus);
        parcel.writeInt(this.mAvrcpStatus);
        parcel.writeInt(this.mPbapStatus);
        parcel.writeInt(this.mMapStatus);
        parcel.writeInt(this.mDeviceClass);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTDevice> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTDevice> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDevice.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTDevice(Parcel parcel) {
        readFromParcel(parcel);
    }
}
