package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSLaneChangingResult implements Parcelable {
    public static final Parcelable.Creator<VDADSLaneChangingResult> CREATOR = new Parcelable.Creator<VDADSLaneChangingResult>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSLaneChangingResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneChangingResult createFromParcel(Parcel parcel) {
            return new VDADSLaneChangingResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneChangingResult[] newArray(int i2) {
            return new VDADSLaneChangingResult[i2];
        }
    };
    private byte result;
    private byte status;
    private long timestamp;

    public VDADSLaneChangingResult() {
    }

    public static VDEvent createEvent(int i2, VDADSLaneChangingResult vDADSLaneChangingResult) {
        return new VDEvent(i2, createPayload(vDADSLaneChangingResult));
    }

    public static Bundle createPayload(VDADSLaneChangingResult vDADSLaneChangingResult) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSLaneChangingResult.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSLaneChangingResult);
        return bundle;
    }

    public static VDADSLaneChangingResult getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSLaneChangingResult.class.getClassLoader());
        return (VDADSLaneChangingResult) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte getResult() {
        return this.result;
    }

    public byte getStatus() {
        return this.status;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setResult(byte b2) {
        this.result = b2;
    }

    public void setStatus(byte b2) {
        this.status = b2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        return "VDADSLaneChangingResult{timestamp=" + this.timestamp + ", result=" + ((int) this.result) + ", status=" + ((int) this.status) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeByte(this.result);
        parcel.writeByte(this.status);
    }

    protected VDADSLaneChangingResult(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.result = parcel.readByte();
        this.status = parcel.readByte();
    }
}
