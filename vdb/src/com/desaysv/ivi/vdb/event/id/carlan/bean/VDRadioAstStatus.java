package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDRadioAstStatus implements Parcelable {
    public static final Parcelable.Creator<VDRadioAstStatus> CREATOR = new Parcelable.Creator<VDRadioAstStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioAstStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioAstStatus createFromParcel(Parcel parcel) {
            return new VDRadioAstStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioAstStatus[] newArray(int i2) {
            return new VDRadioAstStatus[i2];
        }
    };
    private String AstState;

    public VDRadioAstStatus() {
    }

    public static VDEvent createEvent(int i2, VDRadioAstStatus vDRadioAstStatus) {
        return new VDEvent(i2, createPayload(vDRadioAstStatus));
    }

    public static Bundle createPayload(VDRadioAstStatus vDRadioAstStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioAstStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioAstStatus);
        return bundle;
    }

    public static VDRadioAstStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioAstStatus.class.getClassLoader());
        return (VDRadioAstStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAstState() {
        return this.AstState;
    }

    public void setAstState(String str) {
        this.AstState = str;
    }

    public String toString() {
        return "VDRadioAstStatus{AstState='" + this.AstState + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.AstState);
    }

    protected VDRadioAstStatus(Parcel parcel) {
        this.AstState = parcel.readString();
    }
}
