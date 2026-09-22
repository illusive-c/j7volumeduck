package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTMusicProgress implements Parcelable {
    public static final Parcelable.Creator<VDBTMusicProgress> CREATOR = new Parcelable.Creator<VDBTMusicProgress>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTMusicProgress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicProgress createFromParcel(Parcel parcel) {
            return new VDBTMusicProgress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicProgress[] newArray(int i2) {
            return new VDBTMusicProgress[i2];
        }
    };
    private long mPosition = 0;
    private long mDuration = 0;

    public VDBTMusicProgress() {
    }

    public static VDEvent createEvent(int i2, VDBTMusicProgress vDBTMusicProgress) {
        return new VDEvent(i2, createPayload(vDBTMusicProgress));
    }

    public static Bundle createPayload(VDBTMusicProgress vDBTMusicProgress) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMusicProgress.class.getClassLoader());
        bundle.putParcelable("info", vDBTMusicProgress);
        return bundle;
    }

    public static VDBTMusicProgress getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMusicProgress.class.getClassLoader());
        return (VDBTMusicProgress) vDEvent.getPayload().getParcelable("info");
    }

    private void readFromParcel(Parcel parcel) {
        this.mPosition = parcel.readLong();
        this.mDuration = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public void setDuration(long j2) {
        this.mDuration = j2;
    }

    public void setPosition(long j2) {
        this.mPosition = j2;
    }

    public String toString() {
        return "VDBTMusicProgress{position=" + this.mPosition + ", duration=" + this.mDuration + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mPosition);
        parcel.writeLong(this.mDuration);
    }

    protected VDBTMusicProgress(Parcel parcel) {
        readFromParcel(parcel);
    }
}
