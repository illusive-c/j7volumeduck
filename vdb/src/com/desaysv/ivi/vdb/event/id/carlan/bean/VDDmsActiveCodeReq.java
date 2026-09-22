package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsActiveCodeReq implements Parcelable {
    public static final Parcelable.Creator<VDDmsActiveCodeReq> CREATOR = new Parcelable.Creator<VDDmsActiveCodeReq>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsActiveCodeReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveCodeReq createFromParcel(Parcel parcel) {
            return new VDDmsActiveCodeReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveCodeReq[] newArray(int i2) {
            return new VDDmsActiveCodeReq[i2];
        }
    };
    private int dmsActiveCodeRequest;
    private String licenceString;

    public VDDmsActiveCodeReq() {
    }

    public static VDEvent createEvent(int i2, VDDmsActiveCodeReq vDDmsActiveCodeReq) {
        return new VDEvent(i2, createPayload(vDDmsActiveCodeReq));
    }

    public static Bundle createPayload(VDDmsActiveCodeReq vDDmsActiveCodeReq) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsActiveCodeReq.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsActiveCodeReq);
        return bundle;
    }

    public static VDDmsActiveCodeReq getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsActiveCodeReq.class.getClassLoader());
        return (VDDmsActiveCodeReq) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDmsActiveCodeRequest() {
        return this.dmsActiveCodeRequest;
    }

    public String getLicenceString() {
        return this.licenceString;
    }

    public void setDmsActiveCodeRequest(int i2) {
        this.dmsActiveCodeRequest = i2;
    }

    public void setLicenceString(String str) {
        this.licenceString = str;
    }

    public String toString() {
        return "VDDmsActiveCodeReq{dmsActiveCodeRequest=" + this.dmsActiveCodeRequest + ", licenceString='" + this.licenceString + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.dmsActiveCodeRequest);
        parcel.writeString(this.licenceString);
    }

    protected VDDmsActiveCodeReq(Parcel parcel) {
        this.dmsActiveCodeRequest = parcel.readInt();
        this.licenceString = parcel.readString();
    }
}
