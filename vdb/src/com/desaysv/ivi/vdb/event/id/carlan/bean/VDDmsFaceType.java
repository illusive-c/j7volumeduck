package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsFaceType implements Parcelable {
    public static final Parcelable.Creator<VDDmsFaceType> CREATOR = new Parcelable.Creator<VDDmsFaceType>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsFaceType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsFaceType createFromParcel(Parcel parcel) {
            return new VDDmsFaceType(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsFaceType[] newArray(int i2) {
            return new VDDmsFaceType[i2];
        }
    };
    private int faceType;

    public VDDmsFaceType() {
    }

    public static VDEvent createEvent(int i2, VDDmsFaceType vDDmsFaceType) {
        return new VDEvent(i2, createPayload(vDDmsFaceType));
    }

    public static Bundle createPayload(VDDmsFaceType vDDmsFaceType) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsFaceType.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsFaceType);
        return bundle;
    }

    public static VDDmsFaceType getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsFaceType.class.getClassLoader());
        return (VDDmsFaceType) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFaceType() {
        return this.faceType;
    }

    public void setFaceType(int i2) {
        this.faceType = i2;
    }

    public String toString() {
        return "VDDmsFaceType{faceType=" + this.faceType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.faceType);
    }

    protected VDDmsFaceType(Parcel parcel) {
        this.faceType = parcel.readInt();
    }
}
