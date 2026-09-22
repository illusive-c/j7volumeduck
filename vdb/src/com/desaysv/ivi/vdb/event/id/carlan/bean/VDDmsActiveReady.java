package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsActiveReady implements Parcelable {
    public static final Parcelable.Creator<VDDmsActiveReady> CREATOR = new Parcelable.Creator<VDDmsActiveReady>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsActiveReady.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveReady createFromParcel(Parcel parcel) {
            return new VDDmsActiveReady(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveReady[] newArray(int i2) {
            return new VDDmsActiveReady[i2];
        }
    };
    private int dmsActiveReady;

    public VDDmsActiveReady() {
    }

    public static VDEvent createEvent(int i2, VDDmsActiveReady vDDmsActiveReady) {
        return new VDEvent(i2, createPayload(vDDmsActiveReady));
    }

    public static Bundle createPayload(VDDmsActiveReady vDDmsActiveReady) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsActiveReady.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsActiveReady);
        return bundle;
    }

    public static VDDmsActiveReady getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsActiveReady.class.getClassLoader());
        return (VDDmsActiveReady) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDmsActiveReady() {
        return this.dmsActiveReady;
    }

    public void setDmsActiveReady(int i2) {
        this.dmsActiveReady = i2;
    }

    public String toString() {
        return "VDDmsActiveReady{dmsActiveReady=" + this.dmsActiveReady + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.dmsActiveReady);
    }

    protected VDDmsActiveReady(Parcel parcel) {
        this.dmsActiveReady = parcel.readInt();
    }
}
