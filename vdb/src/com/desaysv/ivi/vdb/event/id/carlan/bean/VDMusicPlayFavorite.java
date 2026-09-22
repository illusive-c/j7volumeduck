package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayFavorite implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayFavorite> CREATOR = new Parcelable.Creator<VDMusicPlayFavorite>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayFavorite.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayFavorite createFromParcel(Parcel parcel) {
            return new VDMusicPlayFavorite(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayFavorite[] newArray(int i2) {
            return new VDMusicPlayFavorite[i2];
        }
    };
    private String MusicPlayFavorite;

    public VDMusicPlayFavorite() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayFavorite vDMusicPlayFavorite) {
        return new VDEvent(i2, createPayload(vDMusicPlayFavorite));
    }

    public static Bundle createPayload(VDMusicPlayFavorite vDMusicPlayFavorite) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayFavorite.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayFavorite);
        return bundle;
    }

    public static VDMusicPlayFavorite getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayFavorite.class.getClassLoader());
        return (VDMusicPlayFavorite) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMusicPlayFavorite() {
        return this.MusicPlayFavorite;
    }

    public void setMusicPlayFavorite(String str) {
        this.MusicPlayFavorite = str;
    }

    public String toString() {
        return "VDMusicPlayFavorite{MusicPlayFavorite='" + this.MusicPlayFavorite + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.MusicPlayFavorite);
    }

    protected VDMusicPlayFavorite(Parcel parcel) {
        this.MusicPlayFavorite = parcel.readString();
    }
}
