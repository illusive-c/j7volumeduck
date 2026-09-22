package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDADSPerceptionResult implements Parcelable {
    public static final Parcelable.Creator<VDADSPerceptionResult> CREATOR = new Parcelable.Creator<VDADSPerceptionResult>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSPerceptionResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSPerceptionResult createFromParcel(Parcel parcel) {
            return new VDADSPerceptionResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSPerceptionResult[] newArray(int i2) {
            return new VDADSPerceptionResult[i2];
        }
    };
    private VDADSDynamicObjectInfo[] adsDynamicObjectInfo;
    private VDADSPredictLaneInfo adsPredictLaneInfo;
    private int objectCnt;
    private long timestamp;

    public VDADSPerceptionResult() {
    }

    public static VDEvent createEvent(int i2, VDADSPerceptionResult vDADSPerceptionResult) {
        return new VDEvent(i2, createPayload(vDADSPerceptionResult));
    }

    public static Bundle createPayload(VDADSPerceptionResult vDADSPerceptionResult) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSPerceptionResult.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSPerceptionResult);
        return bundle;
    }

    public static VDADSPerceptionResult getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSPerceptionResult.class.getClassLoader());
        return (VDADSPerceptionResult) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDADSDynamicObjectInfo[] getAdsDynamicObjectInfo() {
        return this.adsDynamicObjectInfo;
    }

    public VDADSPredictLaneInfo getAdsPredictLaneInfo() {
        return this.adsPredictLaneInfo;
    }

    public int getObjectCnt() {
        return this.objectCnt;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAdsDynamicObjectInfo(VDADSDynamicObjectInfo[] vDADSDynamicObjectInfoArr) {
        this.adsDynamicObjectInfo = vDADSDynamicObjectInfoArr;
    }

    public void setAdsPredictLaneInfo(VDADSPredictLaneInfo vDADSPredictLaneInfo) {
        this.adsPredictLaneInfo = vDADSPredictLaneInfo;
    }

    public void setObjectCnt(int i2) {
        this.objectCnt = i2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        return "VDADSPerceptionResult{timestamp=" + this.timestamp + ", objectCnt=" + this.objectCnt + ", adsDynamicObjectInfo=" + Arrays.toString(this.adsDynamicObjectInfo) + ", adsPredictLaneInfo=" + this.adsPredictLaneInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.objectCnt);
        parcel.writeTypedArray(this.adsDynamicObjectInfo, i2);
        parcel.writeParcelable(this.adsPredictLaneInfo, i2);
    }

    protected VDADSPerceptionResult(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.objectCnt = parcel.readInt();
        this.adsDynamicObjectInfo = (VDADSDynamicObjectInfo[]) parcel.createTypedArray(VDADSDynamicObjectInfo.CREATOR);
        this.adsPredictLaneInfo = (VDADSPredictLaneInfo) parcel.readParcelable(VDADSPredictLaneInfo.class.getClassLoader());
    }
}
