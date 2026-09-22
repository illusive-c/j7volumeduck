package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.id.vr.VDValueVR;

/* loaded from: classes2.dex */
public class VDAsr implements Parcelable {
    public static final Parcelable.Creator<VDAsr> CREATOR = new Parcelable.Creator<VDAsr>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDAsr.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAsr createFromParcel(Parcel parcel) {
            return new VDAsr(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAsr[] newArray(int i2) {
            return new VDAsr[i2];
        }
    };
    private int mAsrControl;
    private String mAsrKey;
    private String mSoundZone;
    private int mSrType;
    private String pkgName;

    public VDAsr() {
        this.mAsrKey = VDValueVR.VRStatusKey.STATUS_KEY_RECORDER;
        this.mSrType = 0;
        this.mAsrControl = 1;
        this.mSoundZone = "ALL";
    }

    public static VDEvent createEvent(int i2, VDAsr vDAsr) {
        return new VDEvent(i2, createPayload(vDAsr));
    }

    public static Bundle createPayload(VDAsr vDAsr) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAsr.class.getClassLoader());
        bundle.putParcelable("status", vDAsr);
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.mAsrKey;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSoundZone() {
        return this.mSoundZone;
    }

    public int getValue() {
        return this.mAsrControl;
    }

    public void setKey(String str) {
        this.mAsrKey = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setSoundZone(String str) {
        this.mSoundZone = str;
    }

    public void setValue(int i2) {
        this.mAsrControl = i2;
    }

    public String toString() {
        return "VDAsr{pkgName='" + this.pkgName + "', mAsrKey='" + this.mAsrKey + "', mAsrControl=" + this.mAsrControl + ", mSoundZone=" + this.mSoundZone + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mAsrKey);
        parcel.writeInt(this.mAsrControl);
        parcel.writeString(this.mSoundZone);
    }

    public static VDAsr getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAsr.class.getClassLoader());
        return (VDAsr) vDEvent.getPayload().getParcelable("status");
    }

    public VDAsr(Parcel parcel) {
        this.mAsrKey = VDValueVR.VRStatusKey.STATUS_KEY_RECORDER;
        this.mSrType = 0;
        this.mAsrControl = 1;
        this.mSoundZone = "ALL";
        this.mAsrKey = parcel.readString();
        this.mAsrControl = parcel.readInt();
        this.mSoundZone = parcel.readString();
    }
}
