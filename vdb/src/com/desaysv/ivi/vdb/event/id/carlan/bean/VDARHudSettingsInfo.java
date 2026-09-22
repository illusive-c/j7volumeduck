package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudSettingsInfo implements Parcelable {
    public static final Parcelable.Creator<VDARHudSettingsInfo> CREATOR = new Parcelable.Creator<VDARHudSettingsInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudSettingsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudSettingsInfo createFromParcel(Parcel parcel) {
            return new VDARHudSettingsInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudSettingsInfo[] newArray(int i2) {
            return new VDARHudSettingsInfo[i2];
        }
    };
    private int GetArHudSettingInfo;

    public VDARHudSettingsInfo() {
    }

    public static VDEvent createEvent(int i2, VDARHudSettingsInfo vDARHudSettingsInfo) {
        return new VDEvent(i2, createPayload(vDARHudSettingsInfo));
    }

    public static Bundle createPayload(VDARHudSettingsInfo vDARHudSettingsInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudSettingsInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudSettingsInfo);
        return bundle;
    }

    public static VDARHudSettingsInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudSettingsInfo.class.getClassLoader());
        return (VDARHudSettingsInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGetArHudSettingInfo() {
        return this.GetArHudSettingInfo;
    }

    public void setGetArHudSettingInfo(int i2) {
        this.GetArHudSettingInfo = i2;
    }

    public String toString() {
        return "VDARHudSettingsInfo{GetArHudSettingInfo=" + this.GetArHudSettingInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.GetArHudSettingInfo);
    }

    protected VDARHudSettingsInfo(Parcel parcel) {
        this.GetArHudSettingInfo = parcel.readInt();
    }
}
