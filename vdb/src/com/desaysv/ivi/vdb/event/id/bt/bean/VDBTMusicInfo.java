package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTMusicInfo implements Parcelable {
    public static final Parcelable.Creator<VDBTMusicInfo> CREATOR = new Parcelable.Creator<VDBTMusicInfo>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTMusicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicInfo createFromParcel(Parcel parcel) {
            return new VDBTMusicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicInfo[] newArray(int i2) {
            return new VDBTMusicInfo[i2];
        }
    };
    private Bitmap mAlbumCoverArt;
    private String mAlbumCoverArtUri;
    private String mDescription;
    private Bundle mExtras;
    private String mGenre;
    private Bitmap mIcon;
    private Uri mIconUri;
    private String mMediaId;
    private Uri mMediaUri;
    private int mPlayState;
    private String mSubtitle;
    private long mTotalTrackNumber;
    private long mTrackNumber;
    private String mTitle = null;
    private String mArtist = null;
    private String mAlbum = null;
    private long mPosition = 0;
    private long mDuration = 0;

    public VDBTMusicInfo() {
    }

    public static VDEvent createEvent(int i2, VDBTMusicInfo vDBTMusicInfo) {
        return new VDEvent(i2, createPayload(vDBTMusicInfo));
    }

    public static Bundle createPayload(VDBTMusicInfo vDBTMusicInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMusicInfo.class.getClassLoader());
        bundle.putParcelable("info", vDBTMusicInfo);
        return bundle;
    }

    public static ArrayList<VDBTMusicInfo> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMusicInfo.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTMusicInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMusicInfo.class.getClassLoader());
        return (VDBTMusicInfo) vDEvent.getPayload().getParcelable("info");
    }

    private void readFromParcel(Parcel parcel) {
        this.mTitle = parcel.readString();
        this.mArtist = parcel.readString();
        this.mAlbum = parcel.readString();
        this.mPosition = parcel.readLong();
        this.mDuration = parcel.readLong();
        this.mPlayState = parcel.readInt();
        this.mMediaId = parcel.readString();
        this.mSubtitle = parcel.readString();
        this.mDescription = parcel.readString();
        this.mExtras = parcel.readBundle();
        this.mIconUri = Uri.parse(parcel.readString());
        this.mMediaUri = Uri.parse(parcel.readString());
        byte[] createByteArray = parcel.createByteArray();
        if (createByteArray != null) {
            this.mIcon = BitmapFactory.decodeByteArray(createByteArray, 0, createByteArray.length);
        }
        this.mAlbumCoverArtUri = parcel.readString();
        this.mGenre = parcel.readString();
        this.mTotalTrackNumber = parcel.readLong();
        this.mTrackNumber = parcel.readLong();
        byte[] createByteArray2 = parcel.createByteArray();
        if (createByteArray2 != null) {
            this.mAlbumCoverArt = BitmapFactory.decodeByteArray(createByteArray2, 0, createByteArray2.length);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public Bitmap getAlbumCoverArt() {
        return this.mAlbumCoverArt;
    }

    public String getAlbumCoverArtUri() {
        return this.mAlbumCoverArtUri;
    }

    public String getArtist() {
        return this.mArtist;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getGenre() {
        return this.mGenre;
    }

    public Bitmap getIcon() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public int getPlayState() {
        return this.mPlayState;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public String getSubtitle() {
        return this.mSubtitle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getTotalTrackNumber() {
        return this.mTotalTrackNumber;
    }

    public long getTrackNumber() {
        return this.mTrackNumber;
    }

    public void setAlbum(String str) {
        this.mAlbum = str;
    }

    public void setAlbumCoverArt(Bitmap bitmap) {
        this.mAlbumCoverArt = bitmap;
    }

    public void setAlbumCoverArtUri(String str) {
        this.mAlbumCoverArtUri = str;
    }

    public void setArtist(String str) {
        this.mArtist = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setDuration(long j2) {
        this.mDuration = j2;
    }

    public void setExtras(Bundle bundle) {
        this.mExtras = bundle;
    }

    public void setGenre(String str) {
        this.mGenre = str;
    }

    public void setIcon(Bitmap bitmap) {
        this.mIcon = bitmap;
    }

    public void setIconUri(Uri uri) {
        this.mIconUri = uri;
    }

    public void setMediaId(String str) {
        this.mMediaId = str;
    }

    public void setMediaUri(Uri uri) {
        this.mMediaUri = uri;
    }

    public void setPlayState(int i2) {
        this.mPlayState = i2;
    }

    public void setPosition(long j2) {
        this.mPosition = j2;
    }

    public void setSubtitle(String str) {
        this.mSubtitle = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTotalTrackNumber(long j2) {
        this.mTotalTrackNumber = j2;
    }

    public void setTrackNumber(long j2) {
        this.mTrackNumber = j2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VDBTMusicInfo{");
        sb.append("title=");
        sb.append(this.mTitle);
        sb.append(", artist=");
        sb.append(this.mArtist);
        sb.append(", album=");
        sb.append(this.mAlbum);
        sb.append(", position=");
        sb.append(this.mPosition);
        sb.append(", duration=");
        sb.append(this.mDuration);
        sb.append(", playState=");
        sb.append(this.mPlayState);
        sb.append(", mediaId=");
        sb.append(this.mMediaId);
        sb.append(", subtitle=");
        sb.append(this.mSubtitle);
        sb.append(", description=");
        sb.append(this.mDescription);
        sb.append(", extras=");
        sb.append(this.mExtras);
        sb.append(", iconUri=");
        sb.append(this.mIconUri);
        sb.append(", mediaUri=");
        sb.append(this.mMediaUri);
        sb.append(", icon.getByteCount=");
        Bitmap bitmap = this.mIcon;
        sb.append(bitmap == null ? "null!" : Integer.valueOf(bitmap.getByteCount()));
        sb.append(", albumCoverArtUri=");
        sb.append(this.mAlbumCoverArtUri);
        sb.append(", genre=");
        sb.append(this.mGenre);
        sb.append(", totalTrackNumber=");
        sb.append(this.mTotalTrackNumber);
        sb.append(", trackNumber=");
        sb.append(this.mTrackNumber);
        sb.append(", albumCoverArt=");
        Bitmap bitmap2 = this.mAlbumCoverArt;
        sb.append(bitmap2 != null ? Integer.valueOf(bitmap2.getByteCount()) : "null!");
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mArtist);
        parcel.writeString(this.mAlbum);
        parcel.writeLong(this.mPosition);
        parcel.writeLong(this.mDuration);
        parcel.writeInt(this.mPlayState);
        parcel.writeString(this.mMediaId);
        parcel.writeString(this.mSubtitle);
        parcel.writeString(this.mDescription);
        parcel.writeBundle(this.mExtras);
        parcel.writeString(String.valueOf(this.mIconUri));
        parcel.writeString(String.valueOf(this.mMediaUri));
        if (this.mIcon == null) {
            parcel.writeByteArray(null);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.mIcon.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            parcel.writeByteArray(byteArrayOutputStream.toByteArray());
        }
        parcel.writeString(this.mAlbumCoverArtUri);
        parcel.writeString(this.mGenre);
        parcel.writeLong(this.mTotalTrackNumber);
        parcel.writeLong(this.mTrackNumber);
        if (this.mAlbumCoverArt == null) {
            parcel.writeByteArray(null);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        this.mAlbumCoverArt.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
        parcel.writeByteArray(byteArrayOutputStream2.toByteArray());
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTMusicInfo> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTMusicInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMusicInfo.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTMusicInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
