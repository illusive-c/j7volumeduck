package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARSettingsInfo implements Parcelable {
    public static final Parcelable.Creator<VDARSettingsInfo> CREATOR = new Parcelable.Creator<VDARSettingsInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARSettingsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARSettingsInfo createFromParcel(Parcel parcel) {
            return new VDARSettingsInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARSettingsInfo[] newArray(int i2) {
            return new VDARSettingsInfo[i2];
        }
    };
    private int AdasDisplaySwitch;
    private int DisplaySwitch;
    private int Language;
    private int ManualSetBrightnessValue;
    private int ManualSetHeightValue;
    private int NaviDisplaySwitch;
    private int PhoneDisplaySwitch;
    private int ProjectID;
    private int ThemeMode;
    private int UserID;

    public VDARSettingsInfo() {
        this.DisplaySwitch = 0;
        this.ThemeMode = 0;
        this.PhoneDisplaySwitch = 0;
        this.NaviDisplaySwitch = 0;
        this.AdasDisplaySwitch = 0;
        this.Language = 0;
        this.ProjectID = 1;
    }

    public static VDEvent createEvent(int i2, VDARSettingsInfo vDARSettingsInfo) {
        return new VDEvent(i2, createPayload(vDARSettingsInfo));
    }

    public static Bundle createPayload(VDARSettingsInfo vDARSettingsInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARSettingsInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARSettingsInfo);
        return bundle;
    }

    public static VDARSettingsInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARSettingsInfo.class.getClassLoader());
        return (VDARSettingsInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAdasDisplaySwitch() {
        return this.AdasDisplaySwitch;
    }

    public int getDisplaySwitch() {
        return this.DisplaySwitch;
    }

    public int getLanguage() {
        return this.Language;
    }

    public int getManualSetBrightnessValue() {
        return this.ManualSetBrightnessValue;
    }

    public int getManualSetHeightValue() {
        return this.ManualSetHeightValue;
    }

    public int getNaviDisplaySwitch() {
        return this.NaviDisplaySwitch;
    }

    public int getPhoneDisplaySwitch() {
        return this.PhoneDisplaySwitch;
    }

    public int getProjectID() {
        return this.ProjectID;
    }

    public int getThemeMode() {
        return this.ThemeMode;
    }

    public int getUserID() {
        return this.UserID;
    }

    public void setAdasDisplaySwitch(int i2) {
        this.AdasDisplaySwitch = i2;
    }

    public void setDisplaySwitch(int i2) {
        this.DisplaySwitch = i2;
    }

    public void setLanguage(int i2) {
        this.Language = i2;
    }

    public void setManualSetBrightnessValue(int i2) {
        this.ManualSetBrightnessValue = i2;
    }

    public void setManualSetHeightValue(int i2) {
        this.ManualSetHeightValue = i2;
    }

    public void setNaviDisplaySwitch(int i2) {
        this.NaviDisplaySwitch = i2;
    }

    public void setPhoneDisplaySwitch(int i2) {
        this.PhoneDisplaySwitch = i2;
    }

    public void setProjectID(int i2) {
        this.ProjectID = i2;
    }

    public void setThemeMode(int i2) {
        this.ThemeMode = i2;
    }

    public void setUserID(int i2) {
        this.UserID = i2;
    }

    public String toString() {
        return "VDARSettingsInfo{DisplaySwitch=" + this.DisplaySwitch + ", ManualSetBrightnessValue=" + this.ManualSetBrightnessValue + ", ManualSetHeightValue=" + this.ManualSetHeightValue + ", ThemeMode=" + this.ThemeMode + ", PhoneDisplaySwitch=" + this.PhoneDisplaySwitch + ", NaviDisplaySwitch=" + this.NaviDisplaySwitch + ", AdasDisplaySwitch=" + this.AdasDisplaySwitch + ", Language=" + this.Language + ", UserID=" + this.UserID + ", ProjectID=" + this.ProjectID + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.DisplaySwitch);
        parcel.writeInt(this.ManualSetBrightnessValue);
        parcel.writeInt(this.ManualSetHeightValue);
        parcel.writeInt(this.ThemeMode);
        parcel.writeInt(this.PhoneDisplaySwitch);
        parcel.writeInt(this.NaviDisplaySwitch);
        parcel.writeInt(this.AdasDisplaySwitch);
        parcel.writeInt(this.Language);
        parcel.writeInt(this.UserID);
        parcel.writeInt(this.ProjectID);
    }

    protected VDARSettingsInfo(Parcel parcel) {
        this.DisplaySwitch = 0;
        this.ThemeMode = 0;
        this.PhoneDisplaySwitch = 0;
        this.NaviDisplaySwitch = 0;
        this.AdasDisplaySwitch = 0;
        this.Language = 0;
        this.ProjectID = 1;
        this.DisplaySwitch = parcel.readInt();
        this.ManualSetBrightnessValue = parcel.readInt();
        this.ManualSetHeightValue = parcel.readInt();
        this.ThemeMode = parcel.readInt();
        this.PhoneDisplaySwitch = parcel.readInt();
        this.NaviDisplaySwitch = parcel.readInt();
        this.AdasDisplaySwitch = parcel.readInt();
        this.Language = parcel.readInt();
        this.UserID = parcel.readInt();
        this.ProjectID = parcel.readInt();
    }
}
