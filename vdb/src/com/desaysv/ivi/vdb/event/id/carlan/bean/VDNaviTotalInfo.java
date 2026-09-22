package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviTotalInfo implements Parcelable {
    public static final Parcelable.Creator<VDNaviTotalInfo> CREATOR = new Parcelable.Creator<VDNaviTotalInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviTotalInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviTotalInfo createFromParcel(Parcel parcel) {
            return new VDNaviTotalInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviTotalInfo[] newArray(int i2) {
            return new VDNaviTotalInfo[i2];
        }
    };
    private String ArrivalTime;
    private int DistanceUint;
    private int RemDistance;
    private int RemDistanceUint;
    private int TimeLeft;
    private int TotalDistance;

    public VDNaviTotalInfo() {
        this.DistanceUint = 0;
    }

    public static VDEvent createEvent(int i2, VDNaviTotalInfo vDNaviTotalInfo) {
        return new VDEvent(i2, createPayload(vDNaviTotalInfo));
    }

    public static Bundle createPayload(VDNaviTotalInfo vDNaviTotalInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviTotalInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviTotalInfo);
        return bundle;
    }

    public static VDNaviTotalInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviTotalInfo.class.getClassLoader());
        return (VDNaviTotalInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArrivalTime() {
        return this.ArrivalTime;
    }

    public int getDistanceUint() {
        return this.DistanceUint;
    }

    public int getRemDistance() {
        return this.RemDistance;
    }

    public int getRemDistanceUint() {
        return this.RemDistanceUint;
    }

    public int getTimeLeft() {
        return this.TimeLeft;
    }

    public int getTotalDistance() {
        return this.TotalDistance;
    }

    public void setArrivalTime(String str) {
        this.ArrivalTime = str;
    }

    public void setDistanceUint(int i2) {
        this.DistanceUint = i2;
    }

    public void setRemDistance(int i2) {
        this.RemDistance = i2;
    }

    public void setRemDistanceUint(int i2) {
        this.RemDistanceUint = i2;
    }

    public void setTimeLeft(int i2) {
        this.TimeLeft = i2;
    }

    public void setTotalDistance(int i2) {
        this.TotalDistance = i2;
    }

    public String toString() {
        return "VDNaviTotalInfo{TotalDistance=" + this.TotalDistance + ", DistanceUint=" + this.DistanceUint + ", RemDistance=" + this.RemDistance + ", RemDistanceUint=" + this.RemDistanceUint + ", TimeLeft=" + this.TimeLeft + ", ArrivalTime='" + this.ArrivalTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.TotalDistance);
        parcel.writeInt(this.DistanceUint);
        parcel.writeInt(this.RemDistance);
        parcel.writeInt(this.RemDistanceUint);
        parcel.writeInt(this.TimeLeft);
        parcel.writeString(this.ArrivalTime);
    }

    protected VDNaviTotalInfo(Parcel parcel) {
        this.DistanceUint = 0;
        this.TotalDistance = parcel.readInt();
        this.DistanceUint = parcel.readInt();
        this.RemDistance = parcel.readInt();
        this.RemDistanceUint = parcel.readInt();
        this.TimeLeft = parcel.readInt();
        this.ArrivalTime = parcel.readString();
    }
}
