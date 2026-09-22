package com.desaysv.ivi.vdb.event.id.tuner.bean.rds;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDRDSRadioText implements Parcelable {
    public static final Parcelable.Creator<VDRDSRadioText> CREATOR = new Parcelable.Creator<VDRDSRadioText>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.rds.VDRDSRadioText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRDSRadioText createFromParcel(Parcel parcel) {
            return new VDRDSRadioText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRDSRadioText[] newArray(int i2) {
            return new VDRDSRadioText[i2];
        }
    };
    private int frequency;
    private String programStationName;
    private int programType;
    private String radioText;

    public VDRDSRadioText() {
    }

    public static VDEvent createEvent(int i2, VDRDSRadioText vDRDSRadioText) {
        return new VDEvent(i2, createPayload(vDRDSRadioText));
    }

    public static Bundle createPayload(VDRDSRadioText vDRDSRadioText) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRDSRadioText.class.getClassLoader());
        bundle.putParcelable("status", vDRDSRadioText);
        return bundle;
    }

    public static VDRDSRadioText getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRDSRadioText.class.getClassLoader());
        return (VDRDSRadioText) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public String getProgramStationName() {
        return this.programStationName;
    }

    public int getProgramType() {
        return this.programType;
    }

    public String getRadioText() {
        return this.radioText;
    }

    public void putFrequency(int i2) {
        this.frequency = i2;
    }

    public void putProgramStationName(String str) {
        this.programStationName = str;
    }

    public void putProgramType(int i2) {
        this.programType = i2;
    }

    public void putRadioText(String str) {
        this.radioText = str;
    }

    public String toString() {
        return "VDRDSRadioText{frequency=" + this.frequency + ", programStationName='" + this.programStationName + "', programType=" + this.programType + ", radioText='" + this.radioText + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.frequency);
        parcel.writeString(this.programStationName);
        parcel.writeInt(this.programType);
        parcel.writeString(this.radioText);
    }

    protected VDRDSRadioText(Parcel parcel) {
        this.frequency = parcel.readInt();
        this.programStationName = parcel.readString();
        this.programType = parcel.readInt();
        this.radioText = parcel.readString();
    }
}
