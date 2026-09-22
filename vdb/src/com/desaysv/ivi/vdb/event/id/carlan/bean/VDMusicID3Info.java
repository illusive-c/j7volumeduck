package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicID3Info implements Parcelable {
    public static final Parcelable.Creator<VDMusicID3Info> CREATOR = new Parcelable.Creator<VDMusicID3Info>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicID3Info.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicID3Info createFromParcel(Parcel parcel) {
            return new VDMusicID3Info(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicID3Info[] newArray(int i2) {
            return new VDMusicID3Info[i2];
        }
    };
    public String IsChangeAlbumPic;
    public int Origin;
    public String SongAges;
    public String SongAlbum;
    public String SongAlbumPicture;
    public String SongArtist;
    public int SongIndex;
    public String SongName;
    public String SongSchools;

    public VDMusicID3Info() {
        this.Origin = 0;
    }

    public static VDEvent createEvent(int i2, VDMusicID3Info vDMusicID3Info) {
        return new VDEvent(i2, createPayload(vDMusicID3Info));
    }

    public static Bundle createPayload(VDMusicID3Info vDMusicID3Info) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicID3Info.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicID3Info);
        return bundle;
    }

    public static VDMusicID3Info getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicID3Info.class.getClassLoader());
        return (VDMusicID3Info) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getIsChangeAlbumPic() {
        return this.IsChangeAlbumPic;
    }

    public int getOrigin() {
        return this.Origin;
    }

    public String getSongAges() {
        return this.SongAges;
    }

    public String getSongAlbum() {
        return this.SongAlbum;
    }

    public String getSongAlbumPicture() {
        return this.SongAlbumPicture;
    }

    public String getSongArtist() {
        return this.SongArtist;
    }

    public int getSongIndex() {
        return this.SongIndex;
    }

    public String getSongName() {
        return this.SongName;
    }

    public String getSongSchools() {
        return this.SongSchools;
    }

    public void setIsChangeAlbumPic(String str) {
        this.IsChangeAlbumPic = str;
    }

    public void setOrigin(int i2) {
        this.Origin = i2;
    }

    public void setSongAges(String str) {
        this.SongAges = str;
    }

    public void setSongAlbum(String str) {
        this.SongAlbum = str;
    }

    public void setSongAlbumPicture(String str) {
        this.SongAlbumPicture = str;
    }

    public void setSongArtist(String str) {
        this.SongArtist = str;
    }

    public void setSongIndex(int i2) {
        this.SongIndex = i2;
    }

    public void setSongName(String str) {
        this.SongName = str;
    }

    public void setSongSchools(String str) {
        this.SongSchools = str;
    }

    public String toString() {
        return "VDMusicID3Info{Origin=" + this.Origin + ", SongIndex=" + this.SongIndex + ", SongName='" + this.SongName + "', SongArtist='" + this.SongArtist + "', SongAlbum='" + this.SongAlbum + "', SongSchools='" + this.SongSchools + "', SongAges='" + this.SongAges + "', IsChangeAlbumPic='" + this.IsChangeAlbumPic + "', SongAlbumPicture='" + this.SongAlbumPicture + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Origin);
        parcel.writeInt(this.SongIndex);
        parcel.writeString(this.SongName);
        parcel.writeString(this.SongArtist);
        parcel.writeString(this.SongAlbum);
        parcel.writeString(this.SongSchools);
        parcel.writeString(this.SongAges);
        parcel.writeString(this.IsChangeAlbumPic);
        parcel.writeString(this.SongAlbumPicture);
    }

    protected VDMusicID3Info(Parcel parcel) {
        this.Origin = 0;
        this.Origin = parcel.readInt();
        this.SongIndex = parcel.readInt();
        this.SongName = parcel.readString();
        this.SongArtist = parcel.readString();
        this.SongAlbum = parcel.readString();
        this.SongSchools = parcel.readString();
        this.SongAges = parcel.readString();
        this.IsChangeAlbumPic = parcel.readString();
        this.SongAlbumPicture = parcel.readString();
    }
}
