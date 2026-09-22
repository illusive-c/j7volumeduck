package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTInfo implements Parcelable {
    public static final Parcelable.Creator<VDBTInfo> CREATOR = new Parcelable.Creator<VDBTInfo>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTInfo createFromParcel(Parcel parcel) {
            return new VDBTInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTInfo[] newArray(int i2) {
            return new VDBTInfo[i2];
        }
    };
    private String mLocalMac = null;
    private String mVersion = null;

    public VDBTInfo() {
    }

    public static VDEvent createEvent(int i2, VDBTInfo vDBTInfo) {
        return new VDEvent(i2, createPayload(vDBTInfo));
    }

    public static Bundle createPayload(VDBTInfo vDBTInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTInfo.class.getClassLoader());
        bundle.putParcelable("info", vDBTInfo);
        return bundle;
    }

    public static VDBTInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTInfo.class.getClassLoader());
        return (VDBTInfo) vDEvent.getPayload().getParcelable("info");
    }

    private void readFromParcel(Parcel parcel) {
        this.mLocalMac = parcel.readString();
        this.mVersion = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLocalMac() {
        return this.mLocalMac;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void putLocalMac(String str) {
        this.mLocalMac = str;
    }

    public void putVersion(String str) {
        this.mVersion = str;
    }

    public String toString() {
        return "VDBTInfo{localMac=" + this.mLocalMac + ", version=" + this.mVersion + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mLocalMac);
        parcel.writeString(this.mVersion);
    }

    protected VDBTInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
