package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDNaviLaneInfo implements Parcelable {
    public static final Parcelable.Creator<VDNaviLaneInfo> CREATOR = new Parcelable.Creator<VDNaviLaneInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviLaneInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviLaneInfo createFromParcel(Parcel parcel) {
            return new VDNaviLaneInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviLaneInfo[] newArray(int i2) {
            return new VDNaviLaneInfo[i2];
        }
    };
    private ArrayList<LaneInfo> RoadInfo;

    public static class LaneInfo implements Parcelable {
        public static final Parcelable.Creator<LaneInfo> CREATOR = new Parcelable.Creator<LaneInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviLaneInfo.LaneInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaneInfo createFromParcel(Parcel parcel) {
                return new LaneInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LaneInfo[] newArray(int i2) {
                return new LaneInfo[i2];
            }
        };
        private int LaneIconId;
        private int LaneId;
        private int LaneInfo;

        public LaneInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getLaneIconId() {
            return this.LaneIconId;
        }

        public int getLaneId() {
            return this.LaneId;
        }

        public int getLaneInfo() {
            return this.LaneInfo;
        }

        public void setLaneIconId(int i2) {
            this.LaneIconId = i2;
        }

        public void setLaneId(int i2) {
            this.LaneId = i2;
        }

        public void setLaneInfo(int i2) {
            this.LaneInfo = i2;
        }

        public String toString() {
            return "LaneInfo{LaneInfo=" + this.LaneInfo + ", LaneId=" + this.LaneId + ", LaneIconId=" + this.LaneIconId + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.LaneInfo);
            parcel.writeInt(this.LaneId);
            parcel.writeInt(this.LaneIconId);
        }

        protected LaneInfo(Parcel parcel) {
            this.LaneInfo = parcel.readInt();
            this.LaneId = parcel.readInt();
            this.LaneIconId = parcel.readInt();
        }
    }

    public VDNaviLaneInfo() {
    }

    public static VDEvent createEvent(int i2, VDNaviLaneInfo vDNaviLaneInfo) {
        return new VDEvent(i2, createPayload(vDNaviLaneInfo));
    }

    public static Bundle createPayload(VDNaviLaneInfo vDNaviLaneInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviLaneInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviLaneInfo);
        return bundle;
    }

    public static VDNaviLaneInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviLaneInfo.class.getClassLoader());
        return (VDNaviLaneInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<LaneInfo> getRoadInfo() {
        return this.RoadInfo;
    }

    public void setRoadInfo(ArrayList<LaneInfo> arrayList) {
        this.RoadInfo = arrayList;
    }

    public String toString() {
        return "VDNaviLaneInfo{RoadInfo=" + this.RoadInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.RoadInfo);
    }

    protected VDNaviLaneInfo(Parcel parcel) {
        this.RoadInfo = parcel.createTypedArrayList(LaneInfo.CREATOR);
    }
}
