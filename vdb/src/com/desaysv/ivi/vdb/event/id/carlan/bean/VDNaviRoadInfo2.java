package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviRoadInfo2 implements Parcelable {
    public static final Parcelable.Creator<VDNaviRoadInfo2> CREATOR = new Parcelable.Creator<VDNaviRoadInfo2>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviRoadInfo2.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviRoadInfo2 createFromParcel(Parcel parcel) {
            return new VDNaviRoadInfo2(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviRoadInfo2[] newArray(int i2) {
            return new VDNaviRoadInfo2[i2];
        }
    };
    private int IntersectionZoomStatus;
    private int NextNaviActiion;
    private int NextNaviActionProgbar;
    private String NextRoadName;
    private int RoadIcon;
    private String RoadName;
    private int RoadType;
    private String SegRemainDis;
    private String SegRemainDisUnit;

    public VDNaviRoadInfo2() {
    }

    public static VDEvent createEvent(int i2, VDNaviRoadInfo2 vDNaviRoadInfo2) {
        return new VDEvent(i2, createPayload(vDNaviRoadInfo2));
    }

    public static Bundle createPayload(VDNaviRoadInfo2 vDNaviRoadInfo2) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviRoadInfo2.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviRoadInfo2);
        return bundle;
    }

    public static VDNaviRoadInfo2 getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviRoadInfo2.class.getClassLoader());
        return (VDNaviRoadInfo2) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIntersectionZoomStatus() {
        return this.IntersectionZoomStatus;
    }

    public int getNextNaviActiion() {
        return this.NextNaviActiion;
    }

    public int getNextNaviActionProgbar() {
        return this.NextNaviActionProgbar;
    }

    public String getNextRoadName() {
        return this.NextRoadName;
    }

    public int getRoadIcon() {
        return this.RoadIcon;
    }

    public String getRoadName() {
        return this.RoadName;
    }

    public int getRoadType() {
        return this.RoadType;
    }

    public String getSegRemainDis() {
        return this.SegRemainDis;
    }

    public String getSegRemainDisUnit() {
        return this.SegRemainDisUnit;
    }

    public void setIntersectionZoomStatus(int i2) {
        this.IntersectionZoomStatus = i2;
    }

    public void setNextNaviActiion(int i2) {
        this.NextNaviActiion = i2;
    }

    public void setNextNaviActionProgbar(int i2) {
        this.NextNaviActionProgbar = i2;
    }

    public void setNextRoadName(String str) {
        this.NextRoadName = str;
    }

    public void setRoadIcon(int i2) {
        this.RoadIcon = i2;
    }

    public void setRoadName(String str) {
        this.RoadName = str;
    }

    public void setRoadType(int i2) {
        this.RoadType = i2;
    }

    public void setSegRemainDis(String str) {
        this.SegRemainDis = str;
    }

    public void setSegRemainDisUnit(String str) {
        this.SegRemainDisUnit = str;
    }

    public String toString() {
        return "VDNaviRoadInfo2{SegRemainDis='" + this.SegRemainDis + "', SegRemainDisUnit='" + this.SegRemainDisUnit + "', RoadType=" + this.RoadType + ", RoadIcon=" + this.RoadIcon + ", RoadName='" + this.RoadName + "', NextRoadName='" + this.NextRoadName + "', NextNaviActionProgbar=" + this.NextNaviActionProgbar + ", NextNaviActiion=" + this.NextNaviActiion + ", IntersectionZoomStatus=" + this.IntersectionZoomStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.SegRemainDis);
        parcel.writeString(this.SegRemainDisUnit);
        parcel.writeInt(this.RoadType);
        parcel.writeInt(this.RoadIcon);
        parcel.writeString(this.RoadName);
        parcel.writeString(this.NextRoadName);
        parcel.writeInt(this.NextNaviActionProgbar);
        parcel.writeInt(this.NextNaviActiion);
        parcel.writeInt(this.IntersectionZoomStatus);
    }

    protected VDNaviRoadInfo2(Parcel parcel) {
        this.SegRemainDis = parcel.readString();
        this.SegRemainDisUnit = parcel.readString();
        this.RoadType = parcel.readInt();
        this.RoadIcon = parcel.readInt();
        this.RoadName = parcel.readString();
        this.NextRoadName = parcel.readString();
        this.NextNaviActionProgbar = parcel.readInt();
        this.NextNaviActiion = parcel.readInt();
        this.IntersectionZoomStatus = parcel.readInt();
    }
}
