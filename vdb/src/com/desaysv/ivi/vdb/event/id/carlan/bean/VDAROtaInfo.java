package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDAROtaInfo implements Parcelable {
    public static final Parcelable.Creator<VDAROtaInfo> CREATOR = new Parcelable.Creator<VDAROtaInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDAROtaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAROtaInfo createFromParcel(Parcel parcel) {
            return new VDAROtaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAROtaInfo[] newArray(int i2) {
            return new VDAROtaInfo[i2];
        }
    };
    private int HudRecoveryDefault;
    private int OtaDisplaySwitch;
    private int QuickKeySts;
    private int UpdateHudReq;

    public VDAROtaInfo() {
        this.OtaDisplaySwitch = 0;
        this.QuickKeySts = 0;
        this.HudRecoveryDefault = 0;
        this.UpdateHudReq = 0;
    }

    public static VDEvent createEvent(int i2, VDAROtaInfo vDAROtaInfo) {
        return new VDEvent(i2, createPayload(vDAROtaInfo));
    }

    public static Bundle createPayload(VDAROtaInfo vDAROtaInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAROtaInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDAROtaInfo);
        return bundle;
    }

    public static VDAROtaInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAROtaInfo.class.getClassLoader());
        return (VDAROtaInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHudRecoveryDefault() {
        return this.HudRecoveryDefault;
    }

    public int getOtaDisplaySwitch() {
        return this.OtaDisplaySwitch;
    }

    public int getQuickKeySts() {
        return this.QuickKeySts;
    }

    public int getUpdateHudReq() {
        return this.UpdateHudReq;
    }

    public void setHudRecoveryDefault(int i2) {
        this.HudRecoveryDefault = i2;
    }

    public void setOtaDisplaySwitch(int i2) {
        this.OtaDisplaySwitch = i2;
    }

    public void setQuickKeySts(int i2) {
        this.QuickKeySts = i2;
    }

    public void setUpdateHudReq(int i2) {
        this.UpdateHudReq = i2;
    }

    public String toString() {
        return "VDAROtaInfo{OtaDisplaySwitch=" + this.OtaDisplaySwitch + ", QuickKeySts=" + this.QuickKeySts + ", HudRecoveryDefault=" + this.HudRecoveryDefault + ", UpdateHudReq=" + this.UpdateHudReq + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.OtaDisplaySwitch);
        parcel.writeInt(this.QuickKeySts);
        parcel.writeInt(this.HudRecoveryDefault);
        parcel.writeInt(this.UpdateHudReq);
    }

    protected VDAROtaInfo(Parcel parcel) {
        this.OtaDisplaySwitch = 0;
        this.QuickKeySts = 0;
        this.HudRecoveryDefault = 0;
        this.UpdateHudReq = 0;
        this.OtaDisplaySwitch = parcel.readInt();
        this.QuickKeySts = parcel.readInt();
        this.HudRecoveryDefault = parcel.readInt();
        this.UpdateHudReq = parcel.readInt();
    }
}
