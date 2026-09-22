package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTConnect implements Parcelable {
    public static final Parcelable.Creator<VDBTConnect> CREATOR = new Parcelable.Creator<VDBTConnect>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTConnect.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTConnect createFromParcel(Parcel parcel) {
            return new VDBTConnect(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTConnect[] newArray(int i2) {
            return new VDBTConnect[i2];
        }
    };
    private String mMac = null;
    private int mConnectStatus = 1;
    private int mConnectCtrl = 1;

    public VDBTConnect() {
    }

    public static VDEvent createEvent(int i2, VDBTConnect vDBTConnect) {
        return new VDEvent(i2, createPayload(vDBTConnect));
    }

    public static Bundle createPayload(VDBTConnect vDBTConnect) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTConnect.class.getClassLoader());
        bundle.putParcelable("status", vDBTConnect);
        return bundle;
    }

    public static VDBTConnect getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTConnect.class.getClassLoader());
        return (VDBTConnect) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mConnectStatus = parcel.readInt();
        this.mConnectCtrl = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectCtrl() {
        return this.mConnectCtrl;
    }

    public int getConnectStatus() {
        return this.mConnectStatus;
    }

    public String getMac() {
        return this.mMac;
    }

    public void putConnectCtrl(int i2) {
        this.mConnectCtrl = i2;
    }

    public void putConnectStatus(int i2) {
        this.mConnectStatus = i2;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public String toString() {
        return "VDBTConnect{mac=" + this.mMac + ", connectStatus=" + this.mConnectStatus + ", connectCtrl=" + this.mConnectCtrl + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeInt(this.mConnectStatus);
        parcel.writeInt(this.mConnectCtrl);
    }

    protected VDBTConnect(Parcel parcel) {
        readFromParcel(parcel);
    }
}
