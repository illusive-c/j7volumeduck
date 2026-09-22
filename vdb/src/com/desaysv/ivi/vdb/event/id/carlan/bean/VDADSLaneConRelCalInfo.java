package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSLaneConRelCalInfo implements Parcelable {
    public static final Parcelable.Creator<VDADSLaneConRelCalInfo> CREATOR = new Parcelable.Creator<VDADSLaneConRelCalInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSLaneConRelCalInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneConRelCalInfo createFromParcel(Parcel parcel) {
            return new VDADSLaneConRelCalInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSLaneConRelCalInfo[] newArray(int i2) {
            return new VDADSLaneConRelCalInfo[i2];
        }
    };
    private int endWidth;
    private long laneGroupId;
    private int laneNo;
    private long linkId;
    private int startWidth;

    public VDADSLaneConRelCalInfo() {
    }

    public static VDEvent createEvent(int i2, VDADSLaneConRelCalInfo vDADSLaneConRelCalInfo) {
        return new VDEvent(i2, createPayload(vDADSLaneConRelCalInfo));
    }

    public static Bundle createPayload(VDADSLaneConRelCalInfo vDADSLaneConRelCalInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSLaneConRelCalInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSLaneConRelCalInfo);
        return bundle;
    }

    public static VDADSLaneConRelCalInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSLaneConRelCalInfo.class.getClassLoader());
        return (VDADSLaneConRelCalInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndWidth() {
        return this.endWidth;
    }

    public long getLaneGroupId() {
        return this.laneGroupId;
    }

    public int getLaneNo() {
        return this.laneNo;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public int getStartWidth() {
        return this.startWidth;
    }

    public void setEndWidth(int i2) {
        this.endWidth = i2;
    }

    public void setLaneGroupId(long j2) {
        this.laneGroupId = j2;
    }

    public void setLaneNo(int i2) {
        this.laneNo = i2;
    }

    public void setLinkId(long j2) {
        this.linkId = j2;
    }

    public void setStartWidth(int i2) {
        this.startWidth = i2;
    }

    public String toString() {
        return "VDADSLaneConRelCalInfo{linkId=" + this.linkId + ", laneGroupId=" + this.laneGroupId + ", laneNo=" + this.laneNo + ", startWidth=" + this.startWidth + ", endWidth=" + this.endWidth + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.linkId);
        parcel.writeLong(this.laneGroupId);
        parcel.writeInt(this.laneNo);
        parcel.writeInt(this.startWidth);
        parcel.writeInt(this.endWidth);
    }

    protected VDADSLaneConRelCalInfo(Parcel parcel) {
        this.linkId = parcel.readLong();
        this.laneGroupId = parcel.readLong();
        this.laneNo = parcel.readInt();
        this.startWidth = parcel.readInt();
        this.endWidth = parcel.readInt();
    }
}
