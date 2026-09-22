package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDStructRMLink implements Parcelable {
    public static final Parcelable.Creator<VDStructRMLink> CREATOR = new Parcelable.Creator<VDStructRMLink>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDStructRMLink.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructRMLink createFromParcel(Parcel parcel) {
            return new VDStructRMLink(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructRMLink[] newArray(int i2) {
            return new VDStructRMLink[i2];
        }
    };
    private int averageSpeed;
    private int elevationLevel;
    private boolean isInnerRoad;
    private boolean isParkingRoad;
    private boolean isRestricting;
    private boolean isToll;
    private int length;
    private int linkType;
    private int roadClass;
    private VDUTF8 roadName;
    private int shapePoint_cnt;
    private VDArrayShapePoints shapePoints;
    private int slopePoint_cnt;
    private VDArraySlopePoints slopePoints;
    private int speedLimit;
    private int usage;

    protected VDStructRMLink(Parcel parcel) {
        this.linkType = parcel.readInt();
        this.roadClass = parcel.readInt();
        this.usage = parcel.readInt();
        this.averageSpeed = parcel.readInt();
        this.speedLimit = parcel.readInt();
        this.length = parcel.readInt();
        this.isInnerRoad = parcel.readByte() != 0;
        this.isRestricting = parcel.readByte() != 0;
        this.isParkingRoad = parcel.readByte() != 0;
        this.isToll = parcel.readByte() != 0;
        this.shapePoint_cnt = parcel.readInt();
        this.slopePoint_cnt = parcel.readInt();
        this.elevationLevel = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAverageSpeed() {
        return this.averageSpeed;
    }

    public int getElevationLevel() {
        return this.elevationLevel;
    }

    public int getLength() {
        return this.length;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public int getRoadClass() {
        return this.roadClass;
    }

    public VDUTF8 getRoadName() {
        return this.roadName;
    }

    public int getShapePoint_cnt() {
        return this.shapePoint_cnt;
    }

    public VDArrayShapePoints getShapePoints() {
        return this.shapePoints;
    }

    public int getSlopePoint_cnt() {
        return this.slopePoint_cnt;
    }

    public VDArraySlopePoints getSlopePoints() {
        return this.slopePoints;
    }

    public int getSpeedLimit() {
        return this.speedLimit;
    }

    public int getUsage() {
        return this.usage;
    }

    public boolean isInnerRoad() {
        return this.isInnerRoad;
    }

    public boolean isParkingRoad() {
        return this.isParkingRoad;
    }

    public boolean isRestricting() {
        return this.isRestricting;
    }

    public boolean isToll() {
        return this.isToll;
    }

    public void setAverageSpeed(int i2) {
        this.averageSpeed = i2;
    }

    public void setElevationLevel(int i2) {
        this.elevationLevel = i2;
    }

    public void setInnerRoad(boolean z2) {
        this.isInnerRoad = z2;
    }

    public void setLength(int i2) {
        this.length = i2;
    }

    public void setLinkType(int i2) {
        this.linkType = i2;
    }

    public void setParkingRoad(boolean z2) {
        this.isParkingRoad = z2;
    }

    public void setRestricting(boolean z2) {
        this.isRestricting = z2;
    }

    public void setRoadClass(int i2) {
        this.roadClass = i2;
    }

    public void setRoadName(VDUTF8 vdutf8) {
        this.roadName = vdutf8;
    }

    public void setShapePoint_cnt(int i2) {
        this.shapePoint_cnt = i2;
    }

    public void setShapePoints(VDArrayShapePoints vDArrayShapePoints) {
        this.shapePoints = vDArrayShapePoints;
    }

    public void setSlopePoint_cnt(int i2) {
        this.slopePoint_cnt = i2;
    }

    public void setSlopePoints(VDArraySlopePoints vDArraySlopePoints) {
        this.slopePoints = vDArraySlopePoints;
    }

    public void setSpeedLimit(int i2) {
        this.speedLimit = i2;
    }

    public void setToll(boolean z2) {
        this.isToll = z2;
    }

    public void setUsage(int i2) {
        this.usage = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.linkType);
        parcel.writeInt(this.roadClass);
        parcel.writeInt(this.usage);
        parcel.writeInt(this.averageSpeed);
        parcel.writeInt(this.speedLimit);
        parcel.writeInt(this.length);
        parcel.writeByte(this.isInnerRoad ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isRestricting ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isParkingRoad ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isToll ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.shapePoint_cnt);
        parcel.writeInt(this.slopePoint_cnt);
        parcel.writeInt(this.elevationLevel);
    }
}
