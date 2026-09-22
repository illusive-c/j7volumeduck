package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviTotalInfo2 implements Parcelable {
    public static final Parcelable.Creator<VDNaviTotalInfo2> CREATOR = new Parcelable.Creator<VDNaviTotalInfo2>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviTotalInfo2.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviTotalInfo2 createFromParcel(Parcel parcel) {
            return new VDNaviTotalInfo2(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviTotalInfo2[] newArray(int i2) {
            return new VDNaviTotalInfo2[i2];
        }
    };
    private String ArrivalTime;
    private String DistanceUint;
    private String RemDistance;
    private String RemDistanceUint;
    private int TimeLeft;
    private String TotalDistance;

    public VDNaviTotalInfo2() {
    }

    public static VDEvent createEvent(int i2, VDNaviTotalInfo2 vDNaviTotalInfo2) {
        return new VDEvent(i2, createPayload(vDNaviTotalInfo2));
    }

    public static Bundle createPayload(VDNaviTotalInfo2 vDNaviTotalInfo2) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviTotalInfo2.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviTotalInfo2);
        return bundle;
    }

    public static VDNaviTotalInfo2 getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviTotalInfo2.class.getClassLoader());
        return (VDNaviTotalInfo2) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getArrivalTime() {
        return this.ArrivalTime;
    }

    public String getDistanceUint() {
        return this.DistanceUint;
    }

    public String getRemDistance() {
        return this.RemDistance;
    }

    public String getRemDistanceUint() {
        return this.RemDistanceUint;
    }

    public int getTimeLeft() {
        return this.TimeLeft;
    }

    public String getTotalDistance() {
        return this.TotalDistance;
    }

    public void setArrivalTime(String str) {
        this.ArrivalTime = str;
    }

    public void setDistanceUint(String str) {
        this.DistanceUint = str;
    }

    public void setRemDistance(String str) {
        this.RemDistance = str;
    }

    public void setRemDistanceUint(String str) {
        this.RemDistanceUint = str;
    }

    public void setTimeLeft(int i2) {
        this.TimeLeft = i2;
    }

    public void setTotalDistance(String str) {
        this.TotalDistance = str;
    }

    public String toString() {
        return "VDNaviTotalInfo2{TotalDistance='" + this.TotalDistance + "', DistanceUint='" + this.DistanceUint + "', RemDistance='" + this.RemDistance + "', RemDistanceUint='" + this.RemDistanceUint + "', TimeLeft=" + this.TimeLeft + ", ArrivalTime='" + this.ArrivalTime + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.TotalDistance);
        parcel.writeString(this.DistanceUint);
        parcel.writeString(this.RemDistance);
        parcel.writeString(this.RemDistanceUint);
        parcel.writeInt(this.TimeLeft);
        parcel.writeString(this.ArrivalTime);
    }

    protected VDNaviTotalInfo2(Parcel parcel) {
        this.TotalDistance = parcel.readString();
        this.DistanceUint = parcel.readString();
        this.RemDistance = parcel.readString();
        this.RemDistanceUint = parcel.readString();
        this.TimeLeft = parcel.readInt();
        this.ArrivalTime = parcel.readString();
    }
}
