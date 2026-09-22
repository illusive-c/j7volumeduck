package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDTBoxAPPT implements Parcelable {
    public static final Parcelable.Creator<VDTBoxAPPT> CREATOR = new Parcelable.Creator<VDTBoxAPPT>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTBoxAPPT.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxAPPT createFromParcel(Parcel parcel) {
            return new VDTBoxAPPT(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxAPPT[] newArray(int i2) {
            return new VDTBoxAPPT[i2];
        }
    };
    public int chargingUtcSecs;
    public int oTAUtcSecs;
    public int tripUtcSecs;

    public VDTBoxAPPT() {
    }

    public static VDEvent createEvent(int i2, VDTBoxAPPT vDTBoxAPPT) {
        return new VDEvent(i2, createPayload(vDTBoxAPPT));
    }

    public static Bundle createPayload(VDTBoxAPPT vDTBoxAPPT) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTBoxAPPT.class.getClassLoader());
        bundle.putParcelable("info", vDTBoxAPPT);
        return bundle;
    }

    public static VDTBoxAPPT getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTBoxAPPT.class.getClassLoader());
        return (VDTBoxAPPT) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChargingUtcSecs() {
        return this.chargingUtcSecs;
    }

    public int getTripUtcSecs() {
        return this.tripUtcSecs;
    }

    public int getoTAUtcSecs() {
        return this.oTAUtcSecs;
    }

    public void setChargingUtcSecs(int i2) {
        this.chargingUtcSecs = i2;
    }

    public void setTripUtcSecs(int i2) {
        this.tripUtcSecs = i2;
    }

    public void setoTAUtcSecs(int i2) {
        this.oTAUtcSecs = i2;
    }

    public String toString() {
        return "VDTBoxAPPT{tripUtcSecs=" + this.tripUtcSecs + ", chargingUtcSecs=" + this.chargingUtcSecs + ", oTAUtcSecs=" + this.oTAUtcSecs + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.tripUtcSecs);
        parcel.writeInt(this.chargingUtcSecs);
        parcel.writeInt(this.oTAUtcSecs);
    }

    protected VDTBoxAPPT(Parcel parcel) {
        this.tripUtcSecs = parcel.readInt();
        this.chargingUtcSecs = parcel.readInt();
        this.oTAUtcSecs = parcel.readInt();
    }
}
