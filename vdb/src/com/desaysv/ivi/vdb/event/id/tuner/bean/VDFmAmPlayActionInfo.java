package com.desaysv.ivi.vdb.event.id.tuner.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDFmAmPlayActionInfo implements Parcelable {
    public static final Parcelable.Creator<VDFmAmPlayActionInfo> CREATOR = new Parcelable.Creator<VDFmAmPlayActionInfo>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.VDFmAmPlayActionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDFmAmPlayActionInfo createFromParcel(Parcel parcel) {
            return new VDFmAmPlayActionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDFmAmPlayActionInfo[] newArray(int i2) {
            return new VDFmAmPlayActionInfo[i2];
        }
    };
    private int band;
    private int collectStatus;
    private int disPlayView;
    private int frequency;
    private int intent;
    private int openReason;

    public VDFmAmPlayActionInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.band;
    }

    public int getCollectStatus() {
        return this.collectStatus;
    }

    public int getDisPlayView() {
        return this.disPlayView;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getIntent() {
        return this.intent;
    }

    public int getOpenReason() {
        return this.openReason;
    }

    public void putBand(int i2) {
        this.band = i2;
    }

    public void putDisPlayView(int i2) {
        this.disPlayView = i2;
    }

    public void putFrequency(int i2) {
        this.frequency = i2;
    }

    public void putIntent(int i2) {
        this.intent = i2;
    }

    public void putOpenReason(int i2) {
        this.openReason = i2;
    }

    public void setCollectStatus(int i2) {
        this.collectStatus = i2;
    }

    public String toString() {
        return "VDFmAmPlayActionInfo{frequency = " + this.frequency + ", band = " + this.band + ", openReason = " + this.openReason + ", intent = " + this.intent + ", disPlayView = " + this.disPlayView + ", collectStatus = " + this.collectStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.frequency);
        parcel.writeInt(this.band);
        parcel.writeInt(this.openReason);
        parcel.writeInt(this.intent);
        parcel.writeInt(this.disPlayView);
        parcel.writeInt(this.collectStatus);
    }

    protected VDFmAmPlayActionInfo(Parcel parcel) {
        this.frequency = parcel.readInt();
        this.band = parcel.readInt();
        this.openReason = parcel.readInt();
        this.intent = parcel.readInt();
        this.disPlayView = parcel.readInt();
        this.collectStatus = parcel.readInt();
    }
}
