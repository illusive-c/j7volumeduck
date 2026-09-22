package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDSysAvmLicencePlate implements Parcelable {
    public static final Parcelable.Creator<VDSysAvmLicencePlate> CREATOR = new Parcelable.Creator<VDSysAvmLicencePlate>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDSysAvmLicencePlate.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSysAvmLicencePlate createFromParcel(Parcel parcel) {
            return new VDSysAvmLicencePlate(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSysAvmLicencePlate[] newArray(int i2) {
            return new VDSysAvmLicencePlate[i2];
        }
    };
    private String AVMLicencePlate;

    public VDSysAvmLicencePlate() {
    }

    public static VDEvent createEvent(int i2, VDSysAvmLicencePlate vDSysAvmLicencePlate) {
        return new VDEvent(i2, createPayload(vDSysAvmLicencePlate));
    }

    public static Bundle createPayload(VDSysAvmLicencePlate vDSysAvmLicencePlate) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDSysAvmLicencePlate.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDSysAvmLicencePlate);
        return bundle;
    }

    public static VDSysAvmLicencePlate getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDSysAvmLicencePlate.class.getClassLoader());
        return (VDSysAvmLicencePlate) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAVMLicencePlate() {
        return this.AVMLicencePlate;
    }

    public void setAVMLicencePlate(String str) {
        this.AVMLicencePlate = str;
    }

    public String toString() {
        return "VDSysAvmLicencePlate{AVMLicencePlate='" + this.AVMLicencePlate + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.AVMLicencePlate);
    }

    protected VDSysAvmLicencePlate(Parcel parcel) {
        this.AVMLicencePlate = parcel.readString();
    }
}
