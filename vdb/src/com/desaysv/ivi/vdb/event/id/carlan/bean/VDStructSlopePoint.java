package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDStructSlopePoint implements Parcelable {
    public static final Parcelable.Creator<VDStructSlopePoint> CREATOR = new Parcelable.Creator<VDStructSlopePoint>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDStructSlopePoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructSlopePoint createFromParcel(Parcel parcel) {
            return new VDStructSlopePoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructSlopePoint[] newArray(int i2) {
            return new VDStructSlopePoint[i2];
        }
    };
    public VDStructGeoPos2D point;
    public double slope;

    public VDStructSlopePoint() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDStructGeoPos2D getPoint() {
        return this.point;
    }

    public double getSlope() {
        return this.slope;
    }

    public void setPoint(VDStructGeoPos2D vDStructGeoPos2D) {
        this.point = vDStructGeoPos2D;
    }

    public void setSlope(double d2) {
        this.slope = d2;
    }

    public String toString() {
        return "VDStructSlopePoint{point=" + this.point + ", slope=" + this.slope + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.point, i2);
        parcel.writeDouble(this.slope);
    }

    protected VDStructSlopePoint(Parcel parcel) {
        this.point = (VDStructGeoPos2D) parcel.readParcelable(VDStructGeoPos2D.class.getClassLoader());
        this.slope = parcel.readDouble();
    }
}
