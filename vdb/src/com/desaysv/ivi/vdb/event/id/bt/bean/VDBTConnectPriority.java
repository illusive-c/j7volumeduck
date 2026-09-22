package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTConnectPriority implements Parcelable {
    public static final Parcelable.Creator<VDBTConnectPriority> CREATOR = new Parcelable.Creator<VDBTConnectPriority>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTConnectPriority.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTConnectPriority createFromParcel(Parcel parcel) {
            return new VDBTConnectPriority(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTConnectPriority[] newArray(int i2) {
            return new VDBTConnectPriority[i2];
        }
    };
    private String mMac = null;
    private int mProfile = 16;
    private int mPriority = -1;

    public VDBTConnectPriority() {
    }

    public static VDEvent createEvent(int i2, VDBTConnectPriority vDBTConnectPriority) {
        return new VDEvent(i2, createPayload(vDBTConnectPriority));
    }

    public static Bundle createPayload(VDBTConnectPriority vDBTConnectPriority) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTConnectPriority.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTConnectPriority);
        return bundle;
    }

    public static VDBTConnectPriority getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTConnectPriority.class.getClassLoader());
        return (VDBTConnectPriority) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mProfile = parcel.readInt();
        this.mPriority = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMac() {
        return this.mMac;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int getProfile() {
        return this.mProfile;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public void putPriority(int i2) {
        this.mPriority = i2;
    }

    public void putProfile(int i2) {
        this.mProfile = i2;
    }

    public String toString() {
        return "VDBTConnectPriority{mac=" + this.mMac + ", profile=" + this.mProfile + ", priority=" + this.mPriority + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeInt(this.mProfile);
        parcel.writeInt(this.mPriority);
    }

    protected VDBTConnectPriority(Parcel parcel) {
        readFromParcel(parcel);
    }
}
