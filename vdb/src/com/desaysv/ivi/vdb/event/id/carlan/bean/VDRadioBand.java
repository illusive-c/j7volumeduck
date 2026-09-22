package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDRadioBand implements Parcelable {
    public static final Parcelable.Creator<VDRadioBand> CREATOR = new Parcelable.Creator<VDRadioBand>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioBand.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioBand createFromParcel(Parcel parcel) {
            return new VDRadioBand(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioBand[] newArray(int i2) {
            return new VDRadioBand[i2];
        }
    };
    private int Band;

    public VDRadioBand() {
    }

    public static VDEvent createEvent(int i2, VDRadioBand vDRadioBand) {
        return new VDEvent(i2, createPayload(vDRadioBand));
    }

    public static Bundle createPayload(VDRadioBand vDRadioBand) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioBand.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioBand);
        return bundle;
    }

    public static VDRadioBand getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioBand.class.getClassLoader());
        return (VDRadioBand) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.Band;
    }

    public void setBand(int i2) {
        this.Band = i2;
    }

    public String toString() {
        return "VDRadioBand{Band=" + this.Band + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Band);
    }

    protected VDRadioBand(Parcel parcel) {
        this.Band = parcel.readInt();
    }
}
