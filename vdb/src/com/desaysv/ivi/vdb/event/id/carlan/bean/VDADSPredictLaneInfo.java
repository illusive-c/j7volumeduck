package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDADSPredictLaneInfo implements Parcelable {
    public static final Parcelable.Creator<VDADSPredictLaneInfo> CREATOR = new Parcelable.Creator<VDADSPredictLaneInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSPredictLaneInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSPredictLaneInfo createFromParcel(Parcel parcel) {
            return new VDADSPredictLaneInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSPredictLaneInfo[] newArray(int i2) {
            return new VDADSPredictLaneInfo[i2];
        }
    };
    private VDADSLocationRelativePoint[] adsLocationRelativePoints;
    private int predictLanePointCnt;
    private long timestamp;

    public VDADSPredictLaneInfo() {
    }

    public static VDEvent createEvent(int i2, VDADSPredictLaneInfo vDADSPredictLaneInfo) {
        return new VDEvent(i2, createPayload(vDADSPredictLaneInfo));
    }

    public static Bundle createPayload(VDADSPredictLaneInfo vDADSPredictLaneInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSPredictLaneInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSPredictLaneInfo);
        return bundle;
    }

    public static VDADSPredictLaneInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSPredictLaneInfo.class.getClassLoader());
        return (VDADSPredictLaneInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDADSLocationRelativePoint[] getAdsLocationRelativePoints() {
        return this.adsLocationRelativePoints;
    }

    public int getPredictLanePointCnt() {
        return this.predictLanePointCnt;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAdsLocationRelativePoints(VDADSLocationRelativePoint[] vDADSLocationRelativePointArr) {
        this.adsLocationRelativePoints = vDADSLocationRelativePointArr;
    }

    public void setPredictLanePointCnt(int i2) {
        this.predictLanePointCnt = i2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        return "VDADSPredictLaneInfo{timestamp=" + this.timestamp + ", predictLanePointCnt=" + this.predictLanePointCnt + ", adsLocationRelativePoints=" + Arrays.toString(this.adsLocationRelativePoints) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.predictLanePointCnt);
        parcel.writeTypedArray(this.adsLocationRelativePoints, i2);
    }

    protected VDADSPredictLaneInfo(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.predictLanePointCnt = parcel.readInt();
        this.adsLocationRelativePoints = (VDADSLocationRelativePoint[]) parcel.createTypedArray(VDADSLocationRelativePoint.CREATOR);
    }
}
