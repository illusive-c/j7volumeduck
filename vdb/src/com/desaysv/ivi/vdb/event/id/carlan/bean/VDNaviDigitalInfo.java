package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviDigitalInfo implements Parcelable {
    public static final Parcelable.Creator<VDNaviDigitalInfo> CREATOR = new Parcelable.Creator<VDNaviDigitalInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviDigitalInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDigitalInfo createFromParcel(Parcel parcel) {
            return new VDNaviDigitalInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDigitalInfo[] newArray(int i2) {
            return new VDNaviDigitalInfo[i2];
        }
    };
    private int CameraType;
    private int NaviStatus;
    private int SpeedingInfo;
    private int WarningMessage;

    public VDNaviDigitalInfo() {
    }

    public static VDEvent createEvent(int i2, VDNaviDigitalInfo vDNaviDigitalInfo) {
        return new VDEvent(i2, createPayload(vDNaviDigitalInfo));
    }

    public static Bundle createPayload(VDNaviDigitalInfo vDNaviDigitalInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviDigitalInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviDigitalInfo);
        return bundle;
    }

    public static VDNaviDigitalInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviDigitalInfo.class.getClassLoader());
        return (VDNaviDigitalInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCameraType() {
        return this.CameraType;
    }

    public int getNaviStatus() {
        return this.NaviStatus;
    }

    public int getSpeedingInfo() {
        return this.SpeedingInfo;
    }

    public int getWarningMessage() {
        return this.WarningMessage;
    }

    public void setCameraType(int i2) {
        this.CameraType = i2;
    }

    public void setNaviStatus(int i2) {
        this.NaviStatus = i2;
    }

    public void setSpeedingInfo(int i2) {
        this.SpeedingInfo = i2;
    }

    public void setWarningMessage(int i2) {
        this.WarningMessage = i2;
    }

    public String toString() {
        return "VDNaviDigitalInfo{NaviStatus=" + this.NaviStatus + ", SpeedingInfo=" + this.SpeedingInfo + ", CameraType=" + this.CameraType + ", WarningMessage=" + this.WarningMessage + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.NaviStatus);
        parcel.writeInt(this.SpeedingInfo);
        parcel.writeInt(this.CameraType);
        parcel.writeInt(this.WarningMessage);
    }

    protected VDNaviDigitalInfo(Parcel parcel) {
        this.NaviStatus = parcel.readInt();
        this.SpeedingInfo = parcel.readInt();
        this.CameraType = parcel.readInt();
        this.WarningMessage = parcel.readInt();
    }
}
