package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.utils.VDLogUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class VDMediaInfo implements Parcelable {
    public static final Parcelable.Creator<VDMediaInfo> CREATOR = new Parcelable.Creator<VDMediaInfo>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaInfo createFromParcel(Parcel parcel) {
            return new VDMediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaInfo[] newArray(int i2) {
            return new VDMediaInfo[i2];
        }
    };
    private String album;
    private byte[] albumBuffer;
    private String albumImgUrl;
    private String artist;
    private int collectStatus;
    private String composer;
    private HashMap extras = new HashMap();
    private String fileName;
    private String fileUrl;
    private String genre;
    private int id;
    private int infoType;
    private String lyrics;
    private int mediaType;
    private String programType;
    private String title;

    public VDMediaInfo() {
    }

    public static VDEvent createEvent(int i2, VDMediaInfo vDMediaInfo) {
        return new VDEvent(i2, createPayload(vDMediaInfo));
    }

    public static Bundle createPayload(VDMediaInfo vDMediaInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaInfo.class.getClassLoader());
        bundle.putParcelable("info", vDMediaInfo);
        return bundle;
    }

    public static VDMediaInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaInfo.class.getClassLoader());
        return (VDMediaInfo) vDEvent.getPayload().getParcelable("info");
    }

    private void readFromParcel(Parcel parcel) {
        this.id = parcel.readInt();
        this.mediaType = parcel.readInt();
        this.collectStatus = parcel.readInt();
        this.infoType = parcel.readInt();
        this.title = parcel.readString();
        this.artist = parcel.readString();
        this.album = parcel.readString();
        this.composer = parcel.readString();
        this.genre = parcel.readString();
        this.albumImgUrl = parcel.readString();
        this.fileName = parcel.readString();
        this.fileUrl = parcel.readString();
        this.albumBuffer = parcel.createByteArray();
        this.lyrics = parcel.readString();
        this.programType = parcel.readString();
        try {
            this.extras = parcel.readHashMap(getClass().getClassLoader());
        } catch (Exception e2) {
            VDLogUtil.i("VDMediaInfo readFromParcel=" + e2.getMessage());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbum() {
        return this.album;
    }

    public byte[] getAlbumBuffer() {
        return this.albumBuffer;
    }

    public String getAlbumImgUrl() {
        return this.albumImgUrl;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getCollectStatus() {
        return this.collectStatus;
    }

    public String getComposer() {
        return this.composer;
    }

    public Object getExtra(String str) {
        return this.extras.get(str);
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getId() {
        return this.id;
    }

    public int getInfoType() {
        return this.infoType;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getProgramType() {
        return this.programType;
    }

    public String getTitle() {
        return this.title;
    }

    public void putAlbum(String str) {
        this.album = str;
    }

    public void putAlbumImgUrl(String str) {
        this.albumImgUrl = str;
    }

    public void putArtist(String str) {
        this.artist = str;
    }

    public void putCollectStatus(int i2) {
        this.collectStatus = i2;
    }

    public void putComposer(String str) {
        this.composer = str;
    }

    public void putExtra(String str, String str2) {
        this.extras.put(str, str2);
    }

    public void putFileName(String str) {
        this.fileName = str;
    }

    public void putFileUrl(String str) {
        this.fileUrl = str;
    }

    public void putGenre(String str) {
        this.genre = str;
    }

    public void putId(int i2) {
        this.id = i2;
    }

    public void putInfoType(int i2) {
        this.infoType = i2;
    }

    public void putLyrics(String str) {
        this.lyrics = str;
    }

    public void putMediaType(int i2) {
        this.mediaType = i2;
    }

    public void putProgramType(String str) {
        this.programType = str;
    }

    public void putTitle(String str) {
        this.title = str;
    }

    public void setAlbumBuffer(byte[] bArr) {
        this.albumBuffer = bArr;
    }

    public void setExtras(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        this.extras = hashMap;
    }

    public String toString() {
        return "VDMediaInfo{id=" + this.id + ", mediaType = " + this.mediaType + ", collectStatus = " + this.collectStatus + ", title = " + this.title + ", artist = " + this.artist + ", album = " + this.album + ", composer = " + this.composer + ", genre = " + this.genre + ", albumImgUrl = " + this.albumImgUrl + ", fileName = " + this.fileName + ", fileUrl = " + this.fileUrl + ", infoType = " + this.infoType + ", programType = " + this.programType + ", lyrics = " + this.lyrics + ", extras = " + this.extras.toString() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.mediaType);
        parcel.writeInt(this.collectStatus);
        parcel.writeInt(this.infoType);
        parcel.writeString(this.title);
        parcel.writeString(this.artist);
        parcel.writeString(this.album);
        parcel.writeString(this.composer);
        parcel.writeString(this.genre);
        parcel.writeString(this.albumImgUrl);
        parcel.writeString(this.fileName);
        parcel.writeString(this.fileUrl);
        parcel.writeByteArray(this.albumBuffer);
        parcel.writeString(this.lyrics);
        parcel.writeString(this.programType);
        parcel.writeMap(this.extras);
    }

    protected VDMediaInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
