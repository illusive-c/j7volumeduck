package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDArrayShapePoints implements Parcelable {
    public static final Parcelable.Creator<VDArrayShapePoints> CREATOR = new Parcelable.Creator<VDArrayShapePoints>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDArrayShapePoints.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayShapePoints createFromParcel(Parcel parcel) {
            return new VDArrayShapePoints(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayShapePoints[] newArray(int i2) {
            return new VDArrayShapePoints[i2];
        }
    };
    private VDStructGeoPos2D[] points;

    public VDArrayShapePoints() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDStructGeoPos2D[] getPoints() {
        return this.points;
    }

    public void setPoints(VDStructGeoPos2D[] vDStructGeoPos2DArr) {
        this.points = vDStructGeoPos2DArr;
    }

    public String toString() {
        return "VDArrayShapePoints{points=" + Arrays.toString(this.points) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.points, i2);
    }

    protected VDArrayShapePoints(Parcel parcel) {
        this.points = (VDStructGeoPos2D[]) parcel.createTypedArray(VDStructGeoPos2D.CREATOR);
    }
}
