package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSDynamicObjectInfo implements Parcelable {
    public static final Parcelable.Creator<VDADSDynamicObjectInfo> CREATOR = new Parcelable.Creator<VDADSDynamicObjectInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSDynamicObjectInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSDynamicObjectInfo createFromParcel(Parcel parcel) {
            return new VDADSDynamicObjectInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSDynamicObjectInfo[] newArray(int i2) {
            return new VDADSDynamicObjectInfo[i2];
        }
    };
    private VDADSLocationRelativePoint adsLocationRelativePoint;
    private byte collisionRisk;
    private int dynamicObjectType;
    private double heading;
    private byte objectColor;
    private int objectId;
    private double speed;
    private long timestamp;

    public VDADSDynamicObjectInfo() {
    }

    public static VDEvent createEvent(int i2, VDADSDynamicObjectInfo vDADSDynamicObjectInfo) {
        return new VDEvent(i2, createPayload(vDADSDynamicObjectInfo));
    }

    public static Bundle createPayload(VDADSDynamicObjectInfo vDADSDynamicObjectInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSDynamicObjectInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSDynamicObjectInfo);
        return bundle;
    }

    public static VDADSDynamicObjectInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSDynamicObjectInfo.class.getClassLoader());
        return (VDADSDynamicObjectInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDADSLocationRelativePoint getAdsLocationRelativePoint() {
        return this.adsLocationRelativePoint;
    }

    public byte getCollisionRisk() {
        return this.collisionRisk;
    }

    public int getDynamicObjectType() {
        return this.dynamicObjectType;
    }

    public double getHeading() {
        return this.heading;
    }

    public byte getObjectColor() {
        return this.objectColor;
    }

    public int getObjectId() {
        return this.objectId;
    }

    public double getSpeed() {
        return this.speed;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setAdsLocationRelativePoint(VDADSLocationRelativePoint vDADSLocationRelativePoint) {
        this.adsLocationRelativePoint = vDADSLocationRelativePoint;
    }

    public void setCollisionRisk(byte b2) {
        this.collisionRisk = b2;
    }

    public void setDynamicObjectType(int i2) {
        this.dynamicObjectType = i2;
    }

    public void setHeading(double d2) {
        this.heading = d2;
    }

    public void setObjectColor(byte b2) {
        this.objectColor = b2;
    }

    public void setObjectId(int i2) {
        this.objectId = i2;
    }

    public void setSpeed(double d2) {
        this.speed = d2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public String toString() {
        return "VDADSDynamicObjectInfo{timestamp=" + this.timestamp + ", objectId=" + this.objectId + ", dynamicObjectType=" + this.dynamicObjectType + ", adsLocationRelativePoint=" + this.adsLocationRelativePoint + ", heading=" + this.heading + ", speed=" + this.speed + ", collisionRisk=" + ((int) this.collisionRisk) + ", objectColor=" + ((int) this.objectColor) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.objectId);
        parcel.writeInt(this.dynamicObjectType);
        parcel.writeParcelable(this.adsLocationRelativePoint, i2);
        parcel.writeDouble(this.heading);
        parcel.writeDouble(this.speed);
        parcel.writeByte(this.collisionRisk);
        parcel.writeByte(this.objectColor);
    }

    protected VDADSDynamicObjectInfo(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.objectId = parcel.readInt();
        this.dynamicObjectType = parcel.readInt();
        this.adsLocationRelativePoint = (VDADSLocationRelativePoint) parcel.readParcelable(VDADSLocationRelativePoint.class.getClassLoader());
        this.heading = parcel.readDouble();
        this.speed = parcel.readDouble();
        this.collisionRisk = parcel.readByte();
        this.objectColor = parcel.readByte();
    }
}
