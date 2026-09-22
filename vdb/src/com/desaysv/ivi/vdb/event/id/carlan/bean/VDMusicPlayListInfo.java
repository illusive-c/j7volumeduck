package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDMusicPlayListInfo implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayListInfo> CREATOR = new Parcelable.Creator<VDMusicPlayListInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayListInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayListInfo createFromParcel(Parcel parcel) {
            return new VDMusicPlayListInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayListInfo[] newArray(int i2) {
            return new VDMusicPlayListInfo[i2];
        }
    };
    private ArrayList<MusicInfo> MusicListInfo;
    private int Origin;
    private int TotalNum;

    public static class MusicInfo implements Parcelable {
        public static final Parcelable.Creator<MusicInfo> CREATOR = new Parcelable.Creator<MusicInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayListInfo.MusicInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MusicInfo createFromParcel(Parcel parcel) {
                return new MusicInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MusicInfo[] newArray(int i2) {
                return new MusicInfo[i2];
            }
        };
        private String SongArtist;
        private int SongID;
        private String SongName;

        public MusicInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getSongArtist() {
            return this.SongArtist;
        }

        public int getSongID() {
            return this.SongID;
        }

        public String getSongName() {
            return this.SongName;
        }

        public void setSongArtist(String str) {
            this.SongArtist = str;
        }

        public void setSongID(int i2) {
            this.SongID = i2;
        }

        public void setSongName(String str) {
            this.SongName = str;
        }

        public String toString() {
            return "MusicInfo{SongID=" + this.SongID + ", SongName='" + this.SongName + "', SongArtist='" + this.SongArtist + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.SongID);
            parcel.writeString(this.SongName);
            parcel.writeString(this.SongArtist);
        }

        protected MusicInfo(Parcel parcel) {
            this.SongID = parcel.readInt();
            this.SongName = parcel.readString();
            this.SongArtist = parcel.readString();
        }
    }

    public VDMusicPlayListInfo() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayListInfo vDMusicPlayListInfo) {
        return new VDEvent(i2, createPayload(vDMusicPlayListInfo));
    }

    public static Bundle createPayload(VDMusicPlayListInfo vDMusicPlayListInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayListInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayListInfo);
        return bundle;
    }

    public static VDMusicPlayListInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayListInfo.class.getClassLoader());
        return (VDMusicPlayListInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<MusicInfo> getMusicListInfo() {
        return this.MusicListInfo;
    }

    public int getOrigin() {
        return this.Origin;
    }

    public int getTotalNum() {
        return this.TotalNum;
    }

    public void setMusicListInfo(ArrayList<MusicInfo> arrayList) {
        this.MusicListInfo = arrayList;
    }

    public void setOrigin(int i2) {
        this.Origin = i2;
    }

    public void setTotalNum(int i2) {
        this.TotalNum = i2;
    }

    public String toString() {
        return "VDMusicPlayListInfo{Origin=" + this.Origin + ", TotalNum=" + this.TotalNum + ", MusicListInfo=" + this.MusicListInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Origin);
        parcel.writeInt(this.TotalNum);
        parcel.writeTypedList(this.MusicListInfo);
    }

    protected VDMusicPlayListInfo(Parcel parcel) {
        this.Origin = parcel.readInt();
        this.TotalNum = parcel.readInt();
        this.MusicListInfo = parcel.createTypedArrayList(MusicInfo.CREATOR);
    }
}
