package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDArrayWayPointInfo implements Parcelable {
    public static final Parcelable.Creator<VDArrayWayPointInfo> CREATOR = new Parcelable.Creator<VDArrayWayPointInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDArrayWayPointInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayWayPointInfo createFromParcel(Parcel parcel) {
            return new VDArrayWayPointInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayWayPointInfo[] newArray(int i2) {
            return new VDArrayWayPointInfo[i2];
        }
    };
    public VDStructWayPointInfo[] info;

    public VDArrayWayPointInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDStructWayPointInfo[] getInfo() {
        return this.info;
    }

    public void setInfo(VDStructWayPointInfo[] vDStructWayPointInfoArr) {
        this.info = vDStructWayPointInfoArr;
    }

    public String toString() {
        return "VDArrayWayPointInfo{info=" + Arrays.toString(this.info) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    protected VDArrayWayPointInfo(Parcel parcel) {
    }
}
