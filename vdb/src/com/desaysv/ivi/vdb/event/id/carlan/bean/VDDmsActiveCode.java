package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsActiveCode implements Parcelable {
    public static final Parcelable.Creator<VDDmsActiveCode> CREATOR = new Parcelable.Creator<VDDmsActiveCode>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsActiveCode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveCode createFromParcel(Parcel parcel) {
            return new VDDmsActiveCode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsActiveCode[] newArray(int i2) {
            return new VDDmsActiveCode[i2];
        }
    };
    private int dmsActiveCodeState;
    private String dmsActiveCodeString;

    public VDDmsActiveCode() {
    }

    public static VDEvent createEvent(int i2, VDDmsActiveCode vDDmsActiveCode) {
        return new VDEvent(i2, createPayload(vDDmsActiveCode));
    }

    public static Bundle createPayload(VDDmsActiveCode vDDmsActiveCode) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsActiveCode.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsActiveCode);
        return bundle;
    }

    public static VDDmsActiveCode getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsActiveCode.class.getClassLoader());
        return (VDDmsActiveCode) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDmsActiveCodeState() {
        return this.dmsActiveCodeState;
    }

    public String getDmsActiveCodeString() {
        return this.dmsActiveCodeString;
    }

    public void setDmsActiveCodeState(int i2) {
        this.dmsActiveCodeState = i2;
    }

    public void setDmsActiveCodeString(String str) {
        this.dmsActiveCodeString = str;
    }

    public String toString() {
        return "VDDmsActiveCode{dmsActiveCodeState=" + this.dmsActiveCodeState + ", dmsActiveCodeString='" + this.dmsActiveCodeString + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.dmsActiveCodeState);
        parcel.writeString(this.dmsActiveCodeString);
    }

    protected VDDmsActiveCode(Parcel parcel) {
        this.dmsActiveCodeState = parcel.readInt();
        this.dmsActiveCodeString = parcel.readString();
    }
}
