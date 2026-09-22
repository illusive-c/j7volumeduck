package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTMusicPlay implements Parcelable {
    public static final Parcelable.Creator<VDBTMusicPlay> CREATOR = new Parcelable.Creator<VDBTMusicPlay>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTMusicPlay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicPlay createFromParcel(Parcel parcel) {
            return new VDBTMusicPlay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicPlay[] newArray(int i2) {
            return new VDBTMusicPlay[i2];
        }
    };
    private int mPlayCtrl = 1;
    private int mPlayType = 0;
    private String mQuery = null;
    private String mMediaId = null;
    private Uri mUri = null;
    private Bundle mExtras = null;

    public VDBTMusicPlay() {
    }

    public static VDEvent createEvent(int i2, VDBTMusicPlay vDBTMusicPlay) {
        return new VDEvent(i2, createPayload(vDBTMusicPlay));
    }

    public static Bundle createPayload(VDBTMusicPlay vDBTMusicPlay) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMusicPlay.class.getClassLoader());
        bundle.putParcelable("status", vDBTMusicPlay);
        return bundle;
    }

    public static VDBTMusicPlay getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMusicPlay.class.getClassLoader());
        return (VDBTMusicPlay) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mPlayCtrl = parcel.readInt();
        this.mPlayType = parcel.readInt();
        this.mQuery = parcel.readString();
        this.mMediaId = parcel.readString();
        this.mUri = Uri.parse(parcel.readString());
        this.mExtras = parcel.readBundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int getPlayCtrl() {
        return this.mPlayCtrl;
    }

    public int getPlayType() {
        return this.mPlayType;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public void putExtras(Bundle bundle) {
        this.mExtras = bundle;
    }

    public void putMediaId(String str) {
        this.mMediaId = str;
    }

    public void putPlayCtrl(int i2) {
        this.mPlayCtrl = i2;
    }

    public void putPlayType(int i2) {
        this.mPlayType = i2;
    }

    public void putQuery(String str) {
        this.mQuery = str;
    }

    public void putUri(Uri uri) {
        this.mUri = uri;
    }

    public String toString() {
        return "VDBTMusicPlay{playCtrl=" + this.mPlayCtrl + ", playType=" + this.mPlayType + ", query=" + this.mQuery + ", mediaId=" + this.mMediaId + ", uri=" + this.mUri + ", mExtras=" + this.mExtras + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mPlayCtrl);
        parcel.writeInt(this.mPlayType);
        parcel.writeString(this.mQuery);
        parcel.writeString(this.mMediaId);
        parcel.writeString(String.valueOf(this.mUri));
        parcel.writeBundle(this.mExtras);
    }

    protected VDBTMusicPlay(Parcel parcel) {
        readFromParcel(parcel);
    }
}
