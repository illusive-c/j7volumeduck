package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDADSLaneConRelCalResult implements Parcelable {
    public static final Parcelable.Creator<VDADSLaneConRelCalResult> CREATOR = new Parcelable.Creator<VDADSLaneConRelCalResult>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSLaneConRelCalResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneConRelCalResult createFromParcel(Parcel parcel) {
            return new VDADSLaneConRelCalResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneConRelCalResult[] newArray(int i2) {
            return new VDADSLaneConRelCalResult[i2];
        }
    };
    private int LaneConRelCalInfoCnt;
    private VDADSLaneConRelCalInfo[] adsLaneConRelCalInfos;
    private long timestamp;

    public VDADSLaneConRelCalResult() {
    }

    public static VDEvent createEvent(int i2, VDADSLaneConRelCalResult vDADSLaneConRelCalResult) {
        return new VDEvent(i2, createPayload(vDADSLaneConRelCalResult));
    }

    public static Bundle createPayload(VDADSLaneConRelCalResult vDADSLaneConRelCalResult) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSLaneConRelCalResult.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSLaneConRelCalResult);
        return bundle;
    }

    public static VDADSLaneConRelCalResult getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSLaneConRelCalResult.class.getClassLoader());
        return (VDADSLaneConRelCalResult) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDADSLaneConRelCalInfo[] getAdsLaneConRelCalInfos() {
        return this.adsLaneConRelCalInfos;
    }

    public int getLaneConRelCalInfoCnt() {
        return this.LaneConRelCalInfoCnt;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAdsLaneConRelCalInfos(VDADSLaneConRelCalInfo[] vDADSLaneConRelCalInfoArr) {
        this.adsLaneConRelCalInfos = vDADSLaneConRelCalInfoArr;
    }

    public void setLaneConRelCalInfoCnt(int i2) {
        this.LaneConRelCalInfoCnt = i2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        return "VDADSLaneConRelCalResult{timestamp=" + this.timestamp + ", LaneConRelCalInfoCnt=" + this.LaneConRelCalInfoCnt + ", adsLaneConRelCalInfos=" + Arrays.toString(this.adsLaneConRelCalInfos) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.LaneConRelCalInfoCnt);
        parcel.writeTypedArray(this.adsLaneConRelCalInfos, i2);
    }

    protected VDADSLaneConRelCalResult(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.LaneConRelCalInfoCnt = parcel.readInt();
        this.adsLaneConRelCalInfos = (VDADSLaneConRelCalInfo[]) parcel.createTypedArray(VDADSLaneConRelCalInfo.CREATOR);
    }
}
