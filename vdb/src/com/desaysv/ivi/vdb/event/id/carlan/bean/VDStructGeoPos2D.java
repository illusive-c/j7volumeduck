package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDStructGeoPos2D implements Parcelable {
    public static final Parcelable.Creator<VDStructGeoPos2D> CREATOR = new Parcelable.Creator<VDStructGeoPos2D>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDStructGeoPos2D.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructGeoPos2D createFromParcel(Parcel parcel) {
            return new VDStructGeoPos2D(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDStructGeoPos2D[] newArray(int i2) {
            return new VDStructGeoPos2D[i2];
        }
    };
    private int lat;
    private int lon;

    protected VDStructGeoPos2D(Parcel parcel) {
        this.lon = parcel.readInt();
        this.lat = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getLat() {
        return this.lat;
    }

    public int getLon() {
        return this.lon;
    }

    public void setLat(int i2) {
        this.lat = i2;
    }

    public void setLon(int i2) {
        this.lon = i2;
    }

    public String toString() {
        return "VDStructGeoPos2D{lon=" + this.lon + ", lat=" + this.lat + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.lon);
        parcel.writeInt(this.lat);
    }
}
