package com.desaysv.ivi.vdb.event.id.tuner.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDTunerExtData implements Parcelable {
    public static final Parcelable.Creator<VDTunerExtData> CREATOR = new Parcelable.Creator<VDTunerExtData>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.VDTunerExtData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTunerExtData createFromParcel(Parcel parcel) {
            return new VDTunerExtData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTunerExtData[] newArray(int i2) {
            return new VDTunerExtData[i2];
        }
    };
    private String tunerData;

    public VDTunerExtData() {
    }

    public static VDEvent createEvent(int i2, VDTunerExtData vDTunerExtData) {
        return new VDEvent(i2, createPayload(vDTunerExtData));
    }

    public static Bundle createPayload(VDTunerExtData vDTunerExtData) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTunerExtData.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDTunerExtData);
        return bundle;
    }

    public static VDTunerExtData getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTunerExtData.class.getClassLoader());
        return (VDTunerExtData) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.tunerData = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getTunerData() {
        return this.tunerData;
    }

    public void putTunerData(String str) {
        this.tunerData = str;
    }

    public String toString() {
        return "VDTunerExtData{tunerData = " + this.tunerData + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.tunerData);
    }

    protected VDTunerExtData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
