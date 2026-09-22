package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicLyricsInfo implements Parcelable {
    public static final Parcelable.Creator<VDMusicLyricsInfo> CREATOR = new Parcelable.Creator<VDMusicLyricsInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicLyricsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicLyricsInfo createFromParcel(Parcel parcel) {
            return new VDMusicLyricsInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicLyricsInfo[] newArray(int i2) {
            return new VDMusicLyricsInfo[i2];
        }
    };
    public String lyrics;

    public VDMusicLyricsInfo() {
    }

    public static VDEvent createEvent(int i2, VDMusicLyricsInfo vDMusicLyricsInfo) {
        return new VDEvent(i2, createPayload(vDMusicLyricsInfo));
    }

    public static Bundle createPayload(VDMusicLyricsInfo vDMusicLyricsInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicLyricsInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicLyricsInfo);
        return bundle;
    }

    public static VDMusicLyricsInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicLyricsInfo.class.getClassLoader());
        return (VDMusicLyricsInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public void setLyrics(String str) {
        this.lyrics = str;
    }

    public String toString() {
        return "VDMusicLyricsInfo{lyrics='" + this.lyrics + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.lyrics);
    }

    protected VDMusicLyricsInfo(Parcel parcel) {
        this.lyrics = parcel.readString();
    }
}
