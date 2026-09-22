package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSLocationRelativePoint implements Parcelable {
    public static final Parcelable.Creator<VDADSLocationRelativePoint> CREATOR = new Parcelable.Creator<VDADSLocationRelativePoint>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSLocationRelativePoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLocationRelativePoint createFromParcel(Parcel parcel) {
            return new VDADSLocationRelativePoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLocationRelativePoint[] newArray(int i2) {
            return new VDADSLocationRelativePoint[i2];
        }
    };
    private int laneIndex;
    private long linkId;
    private float offsetLink;
    private long sectionId;
    private byte validType;

    /* renamed from: x, reason: collision with root package name */
    private int f6481x;

    /* renamed from: y, reason: collision with root package name */
    private int f6482y;

    public VDADSLocationRelativePoint() {
    }

    public static VDEvent createEvent(int i2, VDADSLocationRelativePoint vDADSLocationRelativePoint) {
        return new VDEvent(i2, createPayload(vDADSLocationRelativePoint));
    }

    public static Bundle createPayload(VDADSLocationRelativePoint vDADSLocationRelativePoint) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSLocationRelativePoint.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSLocationRelativePoint);
        return bundle;
    }

    public static VDADSLocationRelativePoint getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSLocationRelativePoint.class.getClassLoader());
        return (VDADSLocationRelativePoint) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLaneIndex() {
        return this.laneIndex;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public float getOffsetLink() {
        return this.offsetLink;
    }

    public long getSectionId() {
        return this.sectionId;
    }

    public byte getValidType() {
        return this.validType;
    }

    public int getX() {
        return this.f6481x;
    }

    public int getY() {
        return this.f6482y;
    }

    public void setLaneIndex(int i2) {
        this.laneIndex = i2;
    }

    public void setLinkId(long j2) {
        this.linkId = j2;
    }

    public void setOffsetLink(float f2) {
        this.offsetLink = f2;
    }

    public void setSectionId(long j2) {
        this.sectionId = j2;
    }

    public void setValidType(byte b2) {
        this.validType = b2;
    }

    public void setX(int i2) {
        this.f6481x = i2;
    }

    public void setY(int i2) {
        this.f6482y = i2;
    }

    public String toString() {
        return "VDADSLocationRelativePoint{validType=" + ((int) this.validType) + ", linkId=" + this.linkId + ", offsetLink=" + this.offsetLink + ", sectionId=" + this.sectionId + ", laneIndex=" + this.laneIndex + ", x=" + this.f6481x + ", y=" + this.f6482y + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.validType);
        parcel.writeLong(this.linkId);
        parcel.writeFloat(this.offsetLink);
        parcel.writeLong(this.sectionId);
        parcel.writeInt(this.laneIndex);
        parcel.writeInt(this.f6481x);
        parcel.writeInt(this.f6482y);
    }

    protected VDADSLocationRelativePoint(Parcel parcel) {
        this.validType = parcel.readByte();
        this.linkId = parcel.readLong();
        this.offsetLink = parcel.readFloat();
        this.sectionId = parcel.readLong();
        this.laneIndex = parcel.readInt();
        this.f6481x = parcel.readInt();
        this.f6482y = parcel.readInt();
    }
}
