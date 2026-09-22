package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes2.dex */
public class VDTTS implements Parcelable {
    public static final Parcelable.Creator<VDTTS> CREATOR = new Parcelable.Creator<VDTTS>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDTTS.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTTS createFromParcel(Parcel parcel) {
            return new VDTTS(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTTS[] newArray(int i2) {
            return new VDTTS[i2];
        }
    };
    private String supplyType;
    private int ttsStatus;
    private String ttsType;

    public VDTTS() {
    }

    public static VDEvent createEvent(int i2, VDTTS vdtts) {
        return new VDEvent(i2, createPayload(vdtts));
    }

    public static Bundle createPayload(VDTTS vdtts) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTTS.class.getClassLoader());
        bundle.putParcelable("status", vdtts);
        return bundle;
    }

    public static VDTTS getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTTS.class.getClassLoader());
        return (VDTTS) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSupplyType() {
        return this.supplyType;
    }

    public int getTtsStatus() {
        return this.ttsStatus;
    }

    public String getTtsType() {
        return this.ttsType;
    }

    public void setSupplyType(String str) {
        this.supplyType = str;
    }

    public void setTtsStatus(int i2) {
        this.ttsStatus = i2;
    }

    public void setTtsType(String str) {
        this.ttsType = str;
    }

    public String toString() {
        return "VDTTS{supplyType='" + this.supplyType + "', ttsType='" + this.ttsType + "', ttsStatus=" + this.ttsStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.supplyType);
        parcel.writeString(this.ttsType);
        parcel.writeInt(this.ttsStatus);
    }

    public VDTTS(Parcel parcel) {
        this.supplyType = parcel.readString();
        this.ttsType = parcel.readString();
        this.ttsStatus = parcel.readInt();
    }
}
