package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDSoundEncData implements Parcelable {
    public static final Parcelable.Creator<VDSoundEncData> CREATOR = new Parcelable.Creator<VDSoundEncData>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDSoundEncData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundEncData createFromParcel(Parcel parcel) {
            return new VDSoundEncData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundEncData[] newArray(int i2) {
            return new VDSoundEncData[i2];
        }
    };
    private String ENC_param_buffer;
    private String ENC_param_idx;
    private String ENC_param_type;

    public VDSoundEncData() {
        this.ENC_param_type = "";
        this.ENC_param_idx = "";
        this.ENC_param_buffer = "";
    }

    public static VDEvent createEvent(int i2, VDSoundEncData vDSoundEncData) {
        return new VDEvent(i2, createPayload(vDSoundEncData));
    }

    public static Bundle createPayload(VDSoundEncData vDSoundEncData) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDSoundEncData.class.getClassLoader());
        bundle.putParcelable("info", vDSoundEncData);
        return bundle;
    }

    public static VDSoundEncData getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDSoundEncData.class.getClassLoader());
        return (VDSoundEncData) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getENC_param_buffer() {
        return this.ENC_param_buffer;
    }

    public String getENC_param_idx() {
        return this.ENC_param_idx;
    }

    public String getENC_param_type() {
        return this.ENC_param_type;
    }

    public void setENC_param_buffer(String str) {
        this.ENC_param_buffer = str;
    }

    public void setENC_param_idx(String str) {
        this.ENC_param_idx = str;
    }

    public void setENC_param_type(String str) {
        this.ENC_param_type = str;
    }

    public String toString() {
        return "VDSoundEncData{ENC_param_type=" + this.ENC_param_type + ", ENC_param_idx=" + this.ENC_param_idx + ", ENC_param_buffer='" + this.ENC_param_buffer + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.ENC_param_type);
        parcel.writeString(this.ENC_param_idx);
        parcel.writeString(this.ENC_param_buffer);
    }

    protected VDSoundEncData(Parcel parcel) {
        this.ENC_param_type = "";
        this.ENC_param_idx = "";
        this.ENC_param_buffer = "";
        this.ENC_param_type = parcel.readString();
        this.ENC_param_idx = parcel.readString();
        this.ENC_param_buffer = parcel.readString();
    }
}
