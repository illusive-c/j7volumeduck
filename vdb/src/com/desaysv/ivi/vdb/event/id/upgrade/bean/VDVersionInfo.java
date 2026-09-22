package com.desaysv.ivi.vdb.event.id.upgrade.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDVersionInfo implements Parcelable {
    public static final int APA_VERSION = 5;
    public static final int CLUSTER_DISPLAY_VERSION = 7;
    public static final Parcelable.Creator<VDVersionInfo> CREATOR = new Parcelable.Creator<VDVersionInfo>() { // from class: com.desaysv.ivi.vdb.event.id.upgrade.bean.VDVersionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVersionInfo createFromParcel(Parcel parcel) {
            return new VDVersionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVersionInfo[] newArray(int i2) {
            return new VDVersionInfo[i2];
        }
    };
    public static final int DISPLAY_SUPPLIER_CODE = 4;
    public static final int DISPLAY_VERSION = 3;
    public static final int IVI_DISPLAY_VERSION = 6;
    public static final int SOC_HARDWARE_VERSION = 8;
    public static final int SOC_VERSION = 1;
    public static final int SUPPLIER_CODE = 2;
    private int type;
    private String version;

    protected VDVersionInfo(Parcel parcel) {
        this.type = parcel.readInt();
        this.version = parcel.readString();
    }

    public static VDEvent createEvent(int i2, VDVersionInfo vDVersionInfo) {
        return new VDEvent(i2, createPayload(vDVersionInfo));
    }

    public static Bundle createPayload(VDVersionInfo vDVersionInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDVersionInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDVersionInfo);
        return bundle;
    }

    public static VDVersionInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDVersionInfo.class.getClassLoader());
        return (VDVersionInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getType() {
        return this.type;
    }

    public String getVersion() {
        return this.version;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "VDVersionInfo{type=" + this.type + ", version='" + this.version + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.type);
        parcel.writeString(this.version);
    }

    public VDVersionInfo() {
    }

    public VDVersionInfo(int i2, String str) {
        this.type = i2;
        this.version = str;
    }
}
