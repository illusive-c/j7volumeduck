package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSLaneChangingInfo implements Parcelable {
    public static final Parcelable.Creator<VDADSLaneChangingInfo> CREATOR = new Parcelable.Creator<VDADSLaneChangingInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSLaneChangingInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneChangingInfo createFromParcel(Parcel parcel) {
            return new VDADSLaneChangingInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneChangingInfo[] newArray(int i2) {
            return new VDADSLaneChangingInfo[i2];
        }
    };
    private int currentLaneId;
    private long currentLinkId;
    private float currentOffsetLink;
    private long currentSectionId;
    private int destLaneId;
    private long destLinkId;
    private float destOffsetLink;
    private long destSectionId;
    private long timeStamp;
    private byte validType;

    public VDADSLaneChangingInfo() {
    }

    public static VDEvent createEvent(int i2, VDADSLaneChangingInfo vDADSLaneChangingInfo) {
        return new VDEvent(i2, createPayload(vDADSLaneChangingInfo));
    }

    public static Bundle createPayload(VDADSLaneChangingInfo vDADSLaneChangingInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSLaneChangingInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSLaneChangingInfo);
        return bundle;
    }

    public static VDADSLaneChangingInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSLaneChangingInfo.class.getClassLoader());
        return (VDADSLaneChangingInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentLaneId() {
        return this.currentLaneId;
    }

    public long getCurrentLinkId() {
        return this.currentLinkId;
    }

    public float getCurrentOffsetLink() {
        return this.currentOffsetLink;
    }

    public long getCurrentSectionId() {
        return this.currentSectionId;
    }

    public int getDestLaneId() {
        return this.destLaneId;
    }

    public long getDestLinkId() {
        return this.destLinkId;
    }

    public float getDestOffsetLink() {
        return this.destOffsetLink;
    }

    public long getDestSectionId() {
        return this.destSectionId;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public byte getValidType() {
        return this.validType;
    }

    public void setCurrentLaneId(int i2) {
        this.currentLaneId = i2;
    }

    public void setCurrentLinkId(long j2) {
        this.currentLinkId = j2;
    }

    public void setCurrentOffsetLink(float f2) {
        this.currentOffsetLink = f2;
    }

    public void setCurrentSectionId(long j2) {
        this.currentSectionId = j2;
    }

    public void setDestLaneId(int i2) {
        this.destLaneId = i2;
    }

    public void setDestLinkId(long j2) {
        this.destLinkId = j2;
    }

    public void setDestOffsetLink(float f2) {
        this.destOffsetLink = f2;
    }

    public void setDestSectionId(long j2) {
        this.destSectionId = j2;
    }

    public void setTimeStamp(long j2) {
        this.timeStamp = j2;
    }

    public void setValidType(byte b2) {
        this.validType = b2;
    }

    public String toString() {
        return "VDADSLaneChangingInfo{timeStamp=" + this.timeStamp + ", validType=" + ((int) this.validType) + ", currentSectionId=" + this.currentSectionId + ", currentLinkId=" + this.currentLinkId + ", currentOffsetLink=" + this.currentOffsetLink + ", currentLaneId=" + this.currentLaneId + ", destSectionId=" + this.destSectionId + ", destLinkId=" + this.destLinkId + ", destOffsetLink=" + this.destOffsetLink + ", destLaneId=" + this.destLaneId + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timeStamp);
        parcel.writeByte(this.validType);
        parcel.writeLong(this.currentSectionId);
        parcel.writeLong(this.currentLinkId);
        parcel.writeFloat(this.currentOffsetLink);
        parcel.writeInt(this.currentLaneId);
        parcel.writeLong(this.destSectionId);
        parcel.writeLong(this.destLinkId);
        parcel.writeFloat(this.destOffsetLink);
        parcel.writeInt(this.destLaneId);
    }

    protected VDADSLaneChangingInfo(Parcel parcel) {
        this.timeStamp = parcel.readLong();
        this.validType = parcel.readByte();
        this.currentSectionId = parcel.readLong();
        this.currentLinkId = parcel.readLong();
        this.currentOffsetLink = parcel.readFloat();
        this.currentLaneId = parcel.readInt();
        this.destSectionId = parcel.readLong();
        this.destLinkId = parcel.readLong();
        this.destOffsetLink = parcel.readFloat();
        this.destLaneId = parcel.readInt();
    }
}
