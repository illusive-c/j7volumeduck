package com.desaysv.ivi.vdb.event.id.tuner.bean.rds;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDRDSSettingsSwitch implements Parcelable {
    public static final Parcelable.Creator<VDRDSSettingsSwitch> CREATOR = new Parcelable.Creator<VDRDSSettingsSwitch>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.rds.VDRDSSettingsSwitch.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRDSSettingsSwitch createFromParcel(Parcel parcel) {
            return new VDRDSSettingsSwitch(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRDSSettingsSwitch[] newArray(int i2) {
            return new VDRDSSettingsSwitch[i2];
        }
    };
    private int af;
    private int eon;
    private int pty;
    private int rds;
    private int req;
    private int ta;

    public VDRDSSettingsSwitch() {
        this.rds = -1;
        this.ta = -1;
        this.af = -1;
        this.pty = -1;
        this.req = -1;
        this.eon = -1;
    }

    public static VDEvent createEvent(int i2, VDRDSSettingsSwitch vDRDSSettingsSwitch) {
        return new VDEvent(i2, createPayload(vDRDSSettingsSwitch));
    }

    public static Bundle createPayload(VDRDSSettingsSwitch vDRDSSettingsSwitch) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRDSSettingsSwitch.class.getClassLoader());
        bundle.putParcelable("status", vDRDSSettingsSwitch);
        return bundle;
    }

    public static VDRDSSettingsSwitch getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRDSSettingsSwitch.class.getClassLoader());
        return (VDRDSSettingsSwitch) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAf() {
        return this.af;
    }

    public int getEon() {
        return this.eon;
    }

    public int getPty() {
        return this.pty;
    }

    public int getRds() {
        return this.rds;
    }

    public int getReq() {
        return this.req;
    }

    public int getTa() {
        return this.ta;
    }

    public void putAf(int i2) {
        this.af = i2;
    }

    public void putEon(int i2) {
        this.eon = i2;
    }

    public void putPty(int i2) {
        this.pty = i2;
    }

    public void putRds(int i2) {
        this.rds = i2;
    }

    public void putReq(int i2) {
        this.req = i2;
    }

    public void putTa(int i2) {
        this.ta = i2;
    }

    public String toString() {
        return "VDRDSSettingsSwitch{rds=" + this.rds + ", ta=" + this.ta + ", af=" + this.af + ", pty=" + this.pty + ", req=" + this.req + ", eon=" + this.eon + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.rds);
        parcel.writeInt(this.ta);
        parcel.writeInt(this.af);
        parcel.writeInt(this.pty);
        parcel.writeInt(this.req);
        parcel.writeInt(this.eon);
    }

    protected VDRDSSettingsSwitch(Parcel parcel) {
        this.rds = -1;
        this.ta = -1;
        this.af = -1;
        this.pty = -1;
        this.req = -1;
        this.eon = -1;
        this.rds = parcel.readInt();
        this.ta = parcel.readInt();
        this.af = parcel.readInt();
        this.pty = parcel.readInt();
        this.req = parcel.readInt();
        this.eon = parcel.readInt();
    }
}
