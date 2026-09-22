package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMediaExtData implements Parcelable {
    public static final Parcelable.Creator<VDMediaExtData> CREATOR = new Parcelable.Creator<VDMediaExtData>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaExtData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaExtData createFromParcel(Parcel parcel) {
            return new VDMediaExtData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaExtData[] newArray(int i2) {
            return new VDMediaExtData[i2];
        }
    };
    private String mediaData;

    public VDMediaExtData() {
    }

    public static VDEvent createEvent(int i2, VDMediaExtData vDMediaExtData) {
        return new VDEvent(i2, createPayload(vDMediaExtData));
    }

    public static Bundle createPayload(VDMediaExtData vDMediaExtData) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaExtData.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMediaExtData);
        return bundle;
    }

    public static VDMediaExtData getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaExtData.class.getClassLoader());
        return (VDMediaExtData) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mediaData = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMediaData() {
        return this.mediaData;
    }

    public void putMediaData(String str) {
        this.mediaData = str;
    }

    public String toString() {
        return "VDMediaExtData{mediaData = " + this.mediaData + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mediaData);
    }

    protected VDMediaExtData(Parcel parcel) {
        readFromParcel(parcel);
    }
}
