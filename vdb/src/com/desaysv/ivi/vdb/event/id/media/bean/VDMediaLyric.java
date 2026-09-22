package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes.dex */
public class VDMediaLyric<T extends Serializable> implements Parcelable {
    public static final Parcelable.Creator<VDMediaLyric<?>> CREATOR = new Parcelable.Creator<VDMediaLyric<?>>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaLyric.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaLyric<?> createFromParcel(Parcel parcel) {
            return new VDMediaLyric<>(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaLyric<?>[] newArray(int i2) {
            return new VDMediaLyric[i2];
        }
    };
    private T extraData;
    private String lyric;
    private long time;

    public VDMediaLyric() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public T getExtraData() {
        return this.extraData;
    }

    public String getLyric() {
        return this.lyric;
    }

    public long getTime() {
        return this.time;
    }

    public void setExtraData(T t2) {
        this.extraData = t2;
    }

    public void setLyric(String str) {
        this.lyric = str;
    }

    public void setTime(long j2) {
        this.time = j2;
    }

    public String toString() {
        return "VDMediaLyric{time=" + this.time + ", lyric='" + this.lyric + "', extraData=" + this.extraData + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.time);
        parcel.writeString(this.lyric);
        parcel.writeSerializable(this.extraData);
    }

    public VDMediaLyric(long j2, String str) {
        this(j2, str, null);
    }

    public VDMediaLyric(long j2, String str, T t2) {
        this.time = j2;
        this.lyric = str;
        this.extraData = t2;
    }

    protected VDMediaLyric(Parcel parcel) {
        this.time = parcel.readLong();
        this.lyric = parcel.readString();
        this.extraData = (T) parcel.readSerializable();
    }
}
