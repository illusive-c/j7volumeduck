package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayMode implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayMode> CREATOR = new Parcelable.Creator<VDMusicPlayMode>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayMode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayMode createFromParcel(Parcel parcel) {
            return new VDMusicPlayMode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayMode[] newArray(int i2) {
            return new VDMusicPlayMode[i2];
        }
    };
    private String MusicPlayMode;

    public VDMusicPlayMode() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayMode vDMusicPlayMode) {
        return new VDEvent(i2, createPayload(vDMusicPlayMode));
    }

    public static Bundle createPayload(VDMusicPlayMode vDMusicPlayMode) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayMode.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayMode);
        return bundle;
    }

    public static VDMusicPlayMode getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayMode.class.getClassLoader());
        return (VDMusicPlayMode) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMusicPlayMode() {
        return this.MusicPlayMode;
    }

    public void setMusicPlayMode(String str) {
        this.MusicPlayMode = str;
    }

    public String toString() {
        return "VDMusicPlayMode{MusicPlayMode='" + this.MusicPlayMode + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.MusicPlayMode);
    }

    protected VDMusicPlayMode(Parcel parcel) {
        this.MusicPlayMode = parcel.readString();
    }
}
