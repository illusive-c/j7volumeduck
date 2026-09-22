package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes2.dex */
public class VDVRUpload implements Parcelable {
    public static final Parcelable.Creator<VDVRUpload> CREATOR = new Parcelable.Creator<VDVRUpload>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDVRUpload.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVRUpload createFromParcel(Parcel parcel) {
            return new VDVRUpload(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVRUpload[] newArray(int i2) {
            return new VDVRUpload[i2];
        }
    };
    private String data;
    private String key;
    private String pkgName;
    private int resultCode;

    public VDVRUpload() {
        this.resultCode = 4;
    }

    public static VDEvent createEvent(int i2, VDVRUpload vDVRUpload) {
        return new VDEvent(i2, createPayload(vDVRUpload));
    }

    public static Bundle createPayload(VDVRUpload vDVRUpload) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDVRUpload.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDVRUpload);
        return bundle;
    }

    public static VDVRUpload getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDVRUpload.class.getClassLoader());
        return (VDVRUpload) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getData() {
        return this.data;
    }

    public String getKey() {
        return this.key;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public String toString() {
        return "VDVRUpload{pkgName='" + this.pkgName + "', key='" + this.key + "', data='" + this.data + "', resultCode=" + this.resultCode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.pkgName);
        parcel.writeString(this.key);
        parcel.writeString(this.data);
        parcel.writeInt(this.resultCode);
    }

    protected VDVRUpload(Parcel parcel) {
        this.resultCode = 4;
        this.pkgName = parcel.readString();
        this.key = parcel.readString();
        this.data = parcel.readString();
        this.resultCode = parcel.readInt();
    }
}
