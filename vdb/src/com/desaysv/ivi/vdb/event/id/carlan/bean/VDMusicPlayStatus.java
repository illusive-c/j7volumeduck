package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayStatus implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayStatus> CREATOR = new Parcelable.Creator<VDMusicPlayStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayStatus createFromParcel(Parcel parcel) {
            return new VDMusicPlayStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayStatus[] newArray(int i2) {
            return new VDMusicPlayStatus[i2];
        }
    };
    private String MusicPlayStatus;

    public VDMusicPlayStatus() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayStatus vDMusicPlayStatus) {
        return new VDEvent(i2, createPayload(vDMusicPlayStatus));
    }

    public static Bundle createPayload(VDMusicPlayStatus vDMusicPlayStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayStatus);
        return bundle;
    }

    public static VDMusicPlayStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayStatus.class.getClassLoader());
        return (VDMusicPlayStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMusicPlayStatus() {
        return this.MusicPlayStatus;
    }

    public void setMusicPlayStatus(String str) {
        this.MusicPlayStatus = str;
    }

    public String toString() {
        return "VDMusicPlayStatus{MusicPlayStatus='" + this.MusicPlayStatus + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.MusicPlayStatus);
    }

    protected VDMusicPlayStatus(Parcel parcel) {
        this.MusicPlayStatus = parcel.readString();
    }
}
