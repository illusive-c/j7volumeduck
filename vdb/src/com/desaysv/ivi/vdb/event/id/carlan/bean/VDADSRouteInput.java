package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSRouteInput implements Parcelable {
    public static final Parcelable.Creator<VDADSRouteInput> CREATOR = new Parcelable.Creator<VDADSRouteInput>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSRouteInput.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSRouteInput createFromParcel(Parcel parcel) {
            return new VDADSRouteInput(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSRouteInput[] newArray(int i2) {
            return new VDADSRouteInput[i2];
        }
    };
    private int RMLink_cnt;
    private VDArrayRMLink RMLinks;
    private int wayPointCnt;
    private VDArrayWayPointInfo wayPointInfos;

    public VDADSRouteInput() {
    }

    public static VDEvent createEvent(int i2, VDADSRouteInput vDADSRouteInput) {
        return new VDEvent(i2, createPayload(vDADSRouteInput));
    }

    public static Bundle createPayload(VDADSRouteInput vDADSRouteInput) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSRouteInput.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSRouteInput);
        return bundle;
    }

    public static VDADSRouteInput getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSRouteInput.class.getClassLoader());
        return (VDADSRouteInput) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRMLink_cnt() {
        return this.RMLink_cnt;
    }

    public VDArrayRMLink getRMLinks() {
        return this.RMLinks;
    }

    public int getWayPointCnt() {
        return this.wayPointCnt;
    }

    public VDArrayWayPointInfo getWayPointInfos() {
        return this.wayPointInfos;
    }

    public void setRMLink_cnt(int i2) {
        this.RMLink_cnt = i2;
    }

    public void setRMLinks(VDArrayRMLink vDArrayRMLink) {
        this.RMLinks = vDArrayRMLink;
    }

    public void setWayPointCnt(int i2) {
        this.wayPointCnt = i2;
    }

    public void setWayPointInfos(VDArrayWayPointInfo vDArrayWayPointInfo) {
        this.wayPointInfos = vDArrayWayPointInfo;
    }

    public String toString() {
        return "VDADSRouteInput{wayPointCnt=" + this.wayPointCnt + ", wayPointInfos=" + this.wayPointInfos + ", RMLink_cnt=" + this.RMLink_cnt + ", RMLinks=" + this.RMLinks + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.wayPointCnt);
        parcel.writeInt(this.RMLink_cnt);
    }

    protected VDADSRouteInput(Parcel parcel) {
        this.wayPointCnt = parcel.readInt();
        this.RMLink_cnt = parcel.readInt();
    }
}
