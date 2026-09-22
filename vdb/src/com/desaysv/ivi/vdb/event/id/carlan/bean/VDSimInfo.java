package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDSimInfo implements Parcelable {
    public static final Parcelable.Creator<VDSimInfo> CREATOR = new Parcelable.Creator<VDSimInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDSimInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSimInfo createFromParcel(Parcel parcel) {
            return new VDSimInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSimInfo[] newArray(int i2) {
            return new VDSimInfo[i2];
        }
    };
    private String iccId;
    private String imsi;
    private String msisdn;
    private String netWork;

    public VDSimInfo() {
    }

    public static VDEvent createEvent(int i2, VDSimInfo vDSimInfo) {
        return new VDEvent(i2, createPayload(vDSimInfo));
    }

    public static Bundle createPayload(VDSimInfo vDSimInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDSimInfo.class.getClassLoader());
        bundle.putParcelable("info", vDSimInfo);
        return bundle;
    }

    public static VDSimInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDSimInfo.class.getClassLoader());
        return (VDSimInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIccId() {
        return this.iccId;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getMsisdn() {
        return this.msisdn;
    }

    public String getNetWork() {
        return this.netWork;
    }

    public void setIccId(String str) {
        this.iccId = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setMsisdn(String str) {
        this.msisdn = str;
    }

    public void setNetWork(String str) {
        this.netWork = str;
    }

    public String toString() {
        return "VDSimInfo{netWork='" + this.netWork + "', iccId='" + this.iccId + "', imsi='" + this.imsi + "', msisdn='" + this.msisdn + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.netWork);
        parcel.writeString(this.iccId);
        parcel.writeString(this.imsi);
        parcel.writeString(this.msisdn);
    }

    protected VDSimInfo(Parcel parcel) {
        this.netWork = parcel.readString();
        this.iccId = parcel.readString();
        this.imsi = parcel.readString();
        this.msisdn = parcel.readString();
    }
}
