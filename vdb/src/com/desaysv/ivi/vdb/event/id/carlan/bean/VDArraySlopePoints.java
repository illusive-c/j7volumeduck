package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDArraySlopePoints implements Parcelable {
    public static final Parcelable.Creator<VDArraySlopePoints> CREATOR = new Parcelable.Creator<VDArraySlopePoints>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDArraySlopePoints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArraySlopePoints createFromParcel(Parcel parcel) {
            return new VDArraySlopePoints(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArraySlopePoints[] newArray(int i2) {
            return new VDArraySlopePoints[i2];
        }
    };
    private VDStructSlopePoint[] points;

    public VDArraySlopePoints() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDStructSlopePoint[] getPoints() {
        return this.points;
    }

    public void setPoints(VDStructSlopePoint[] vDStructSlopePointArr) {
        this.points = vDStructSlopePointArr;
    }

    public String toString() {
        return "VDArraySlopePoints{points=" + Arrays.toString(this.points) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.points, i2);
    }

    protected VDArraySlopePoints(Parcel parcel) {
        this.points = (VDStructSlopePoint[]) parcel.createTypedArray(VDStructSlopePoint.CREATOR);
    }
}
