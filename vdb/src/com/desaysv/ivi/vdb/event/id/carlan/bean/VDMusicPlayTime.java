package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayTime implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayTime> CREATOR = new Parcelable.Creator<VDMusicPlayTime>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayTime.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayTime createFromParcel(Parcel parcel) {
            return new VDMusicPlayTime(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayTime[] newArray(int i2) {
            return new VDMusicPlayTime[i2];
        }
    };
    private int CurrentPlayingTime;
    private int TotalPlayTime;

    public VDMusicPlayTime() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayTime vDMusicPlayTime) {
        return new VDEvent(i2, createPayload(vDMusicPlayTime));
    }

    public static Bundle createPayload(VDMusicPlayTime vDMusicPlayTime) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayTime.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayTime);
        return bundle;
    }

    public static VDMusicPlayTime getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayTime.class.getClassLoader());
        return (VDMusicPlayTime) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentPlayingTime() {
        return this.CurrentPlayingTime;
    }

    public int getTotalPlayTime() {
        return this.TotalPlayTime;
    }

    public void setCurrentPlayingTime(int i2) {
        this.CurrentPlayingTime = i2;
    }

    public void setTotalPlayTime(int i2) {
        this.TotalPlayTime = i2;
    }

    public String toString() {
        return "VDMusicPlayTime{CurrentPlayingTime=" + this.CurrentPlayingTime + ", TotalPlayTime=" + this.TotalPlayTime + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.CurrentPlayingTime);
        parcel.writeInt(this.TotalPlayTime);
    }

    protected VDMusicPlayTime(Parcel parcel) {
        this.CurrentPlayingTime = parcel.readInt();
        this.TotalPlayTime = parcel.readInt();
    }
}
