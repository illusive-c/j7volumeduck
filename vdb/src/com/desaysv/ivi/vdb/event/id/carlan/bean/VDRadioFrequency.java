package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDRadioFrequency implements Parcelable {
    public static final Parcelable.Creator<VDRadioFrequency> CREATOR = new Parcelable.Creator<VDRadioFrequency>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioFrequency.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioFrequency createFromParcel(Parcel parcel) {
            return new VDRadioFrequency(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioFrequency[] newArray(int i2) {
            return new VDRadioFrequency[i2];
        }
    };
    private int Band;
    private int Index;

    public VDRadioFrequency() {
    }

    public static VDEvent createEvent(int i2, VDRadioFrequency vDRadioFrequency) {
        return new VDEvent(i2, createPayload(vDRadioFrequency));
    }

    public static Bundle createPayload(VDRadioFrequency vDRadioFrequency) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioFrequency.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioFrequency);
        return bundle;
    }

    public static VDRadioFrequency getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioFrequency.class.getClassLoader());
        return (VDRadioFrequency) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.Band;
    }

    public int getIndex() {
        return this.Index;
    }

    public void setBand(int i2) {
        this.Band = i2;
    }

    public void setIndex(int i2) {
        this.Index = i2;
    }

    public String toString() {
        return "VDRadioFrequence{Band=" + this.Band + ", Index=" + this.Index + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Band);
        parcel.writeInt(this.Index);
    }

    protected VDRadioFrequency(Parcel parcel) {
        this.Band = parcel.readInt();
        this.Index = parcel.readInt();
    }
}
