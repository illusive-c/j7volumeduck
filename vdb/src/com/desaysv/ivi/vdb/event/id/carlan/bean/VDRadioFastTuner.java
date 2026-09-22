package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDRadioFastTuner implements Parcelable {
    public static final Parcelable.Creator<VDRadioFastTuner> CREATOR = new Parcelable.Creator<VDRadioFastTuner>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioFastTuner.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioFastTuner createFromParcel(Parcel parcel) {
            return new VDRadioFastTuner(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioFastTuner[] newArray(int i2) {
            return new VDRadioFastTuner[i2];
        }
    };
    private int Band;
    private int CurrentFreq;
    private int HasFocus;
    private int Index;
    private int MediaVolume;
    private String StationName;

    public VDRadioFastTuner() {
    }

    public static VDEvent createEvent(int i2, VDRadioFastTuner vDRadioFastTuner) {
        return new VDEvent(i2, createPayload(vDRadioFastTuner));
    }

    public static Bundle createPayload(VDRadioFastTuner vDRadioFastTuner) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioFastTuner.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioFastTuner);
        return bundle;
    }

    public static VDRadioFastTuner getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioFastTuner.class.getClassLoader());
        return (VDRadioFastTuner) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.Band;
    }

    public int getCurrentFreq() {
        return this.CurrentFreq;
    }

    public int getHasFocus() {
        return this.HasFocus;
    }

    public int getIndex() {
        return this.Index;
    }

    public int getMediaVolume() {
        return this.MediaVolume;
    }

    public String getStationName() {
        return this.StationName;
    }

    public void setBand(int i2) {
        this.Band = i2;
    }

    public void setCurrentFreq(int i2) {
        this.CurrentFreq = i2;
    }

    public void setHasFocus(int i2) {
        this.HasFocus = i2;
    }

    public void setIndex(int i2) {
        this.Index = i2;
    }

    public void setMediaVolume(int i2) {
        this.MediaVolume = i2;
    }

    public void setStationName(String str) {
        this.StationName = str;
    }

    public String toString() {
        return "VDRadioFastTuner{CurrentFreq=" + this.CurrentFreq + ", StationName='" + this.StationName + "', HasFocus=" + this.HasFocus + ", MediaVolume=" + this.MediaVolume + ", Band=" + this.Band + ", Index=" + this.Index + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.CurrentFreq);
        parcel.writeString(this.StationName);
        parcel.writeInt(this.HasFocus);
        parcel.writeInt(this.MediaVolume);
        parcel.writeInt(this.Band);
        parcel.writeInt(this.Index);
    }

    protected VDRadioFastTuner(Parcel parcel) {
        this.CurrentFreq = parcel.readInt();
        this.StationName = parcel.readString();
        this.HasFocus = parcel.readInt();
        this.MediaVolume = parcel.readInt();
        this.Band = parcel.readInt();
        this.Index = parcel.readInt();
    }
}
