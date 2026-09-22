package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSAomMMSt implements Parcelable {
    public static final Parcelable.Creator<VDADSAomMMSt> CREATOR = new Parcelable.Creator<VDADSAomMMSt>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSAomMMSt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSAomMMSt createFromParcel(Parcel parcel) {
            return new VDADSAomMMSt(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSAomMMSt[] newArray(int i2) {
            return new VDADSAomMMSt[i2];
        }
    };
    private float heading;
    private long laneGroupId;
    private int laneNo;
    private float length;
    private long linkId;
    private int mode;
    private float offset;
    private float offsetLateral;
    private long timestamp;
    private byte validType;

    public VDADSAomMMSt() {
    }

    public static VDEvent createEvent(int i2, VDADSAomMMSt vDADSAomMMSt) {
        return new VDEvent(i2, createPayload(vDADSAomMMSt));
    }

    public static Bundle createPayload(VDADSAomMMSt vDADSAomMMSt) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSAomMMSt.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSAomMMSt);
        return bundle;
    }

    public static VDADSAomMMSt getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSAomMMSt.class.getClassLoader());
        return (VDADSAomMMSt) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getHeading() {
        return this.heading;
    }

    public long getLaneGroupId() {
        return this.laneGroupId;
    }

    public int getLaneNo() {
        return this.laneNo;
    }

    public float getLength() {
        return this.length;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public int getMode() {
        return this.mode;
    }

    public float getOffset() {
        return this.offset;
    }

    public float getOffsetLateral() {
        return this.offsetLateral;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public byte getValidType() {
        return this.validType;
    }

    public void setHeading(float f2) {
        this.heading = f2;
    }

    public void setLaneGroupId(long j2) {
        this.laneGroupId = j2;
    }

    public void setLaneNo(int i2) {
        this.laneNo = i2;
    }

    public void setLength(float f2) {
        this.length = f2;
    }

    public void setLinkId(long j2) {
        this.linkId = j2;
    }

    public void setMode(int i2) {
        this.mode = i2;
    }

    public void setOffset(float f2) {
        this.offset = f2;
    }

    public void setOffsetLateral(float f2) {
        this.offsetLateral = f2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public void setValidType(byte b2) {
        this.validType = b2;
    }

    public String toString() {
        return "VDADSAomMMSt{validType=" + ((int) this.validType) + ", linkId=" + this.linkId + ", laneGroupId=" + this.laneGroupId + ", length=" + this.length + ", offset=" + this.offset + ", offsetLateral=" + this.offsetLateral + ", heading=" + this.heading + ", laneNo=" + this.laneNo + ", mode=" + this.mode + ", timestamp=" + this.timestamp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.validType);
        parcel.writeLong(this.linkId);
        parcel.writeLong(this.laneGroupId);
        parcel.writeFloat(this.length);
        parcel.writeFloat(this.offset);
        parcel.writeFloat(this.offsetLateral);
        parcel.writeFloat(this.heading);
        parcel.writeInt(this.laneNo);
        parcel.writeInt(this.mode);
        parcel.writeLong(this.timestamp);
    }

    protected VDADSAomMMSt(Parcel parcel) {
        this.validType = parcel.readByte();
        this.linkId = parcel.readLong();
        this.laneGroupId = parcel.readLong();
        this.length = parcel.readFloat();
        this.offset = parcel.readFloat();
        this.offsetLateral = parcel.readFloat();
        this.heading = parcel.readFloat();
        this.laneNo = parcel.readInt();
        this.mode = parcel.readInt();
        this.timestamp = parcel.readLong();
    }
}
