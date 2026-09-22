package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviDisplayCluster implements Parcelable {
    public static final Parcelable.Creator<VDNaviDisplayCluster> CREATOR = new Parcelable.Creator<VDNaviDisplayCluster>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviDisplayCluster.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDisplayCluster createFromParcel(Parcel parcel) {
            return new VDNaviDisplayCluster(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDisplayCluster[] newArray(int i2) {
            return new VDNaviDisplayCluster[i2];
        }
    };
    private String DisplayCluster;
    private String NaviFrontDeskStatus;
    private int Perspective;
    private String PerspectiveResult;
    private String RequestDisplayNaviArea;

    public VDNaviDisplayCluster() {
        this.Perspective = 0;
    }

    public static VDEvent createEvent(int i2, VDNaviDisplayCluster vDNaviDisplayCluster) {
        return new VDEvent(i2, createPayload(vDNaviDisplayCluster));
    }

    public static Bundle createPayload(VDNaviDisplayCluster vDNaviDisplayCluster) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviDisplayCluster.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviDisplayCluster);
        return bundle;
    }

    public static VDNaviDisplayCluster getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviDisplayCluster.class.getClassLoader());
        return (VDNaviDisplayCluster) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisplayCluster() {
        return this.DisplayCluster;
    }

    public String getNaviFrontDeskStatus() {
        return this.NaviFrontDeskStatus;
    }

    public int getPerspective() {
        return this.Perspective;
    }

    public String getPerspectiveResult() {
        return this.PerspectiveResult;
    }

    public String getRequestDisplayNaviArea() {
        return this.RequestDisplayNaviArea;
    }

    public void setDisplayCluster(String str) {
        this.DisplayCluster = str;
    }

    public void setNaviFrontDeskStatus(String str) {
        this.NaviFrontDeskStatus = str;
    }

    public void setPerspective(int i2) {
        this.Perspective = i2;
    }

    public void setPerspectiveResult(String str) {
        this.PerspectiveResult = str;
    }

    public void setRequestDisplayNaviArea(String str) {
        this.RequestDisplayNaviArea = str;
    }

    public String toString() {
        return "VDNaviDisplayCluster{NaviFrontDeskStatus='" + this.NaviFrontDeskStatus + "', DisplayCluster='" + this.DisplayCluster + "', Perspective=" + this.Perspective + ", PerspectiveResult='" + this.PerspectiveResult + "', RequestDisplayNaviArea='" + this.RequestDisplayNaviArea + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.NaviFrontDeskStatus);
        parcel.writeString(this.DisplayCluster);
        parcel.writeInt(this.Perspective);
        parcel.writeString(this.PerspectiveResult);
        parcel.writeString(this.RequestDisplayNaviArea);
    }

    protected VDNaviDisplayCluster(Parcel parcel) {
        this.Perspective = 0;
        this.NaviFrontDeskStatus = parcel.readString();
        this.DisplayCluster = parcel.readString();
        this.Perspective = parcel.readInt();
        this.PerspectiveResult = parcel.readString();
        this.RequestDisplayNaviArea = parcel.readString();
    }
}
