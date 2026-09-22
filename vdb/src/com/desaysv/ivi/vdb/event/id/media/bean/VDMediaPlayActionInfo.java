package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDMediaPlayActionInfo implements Parcelable {
    public static final Parcelable.Creator<VDMediaPlayActionInfo> CREATOR = new Parcelable.Creator<VDMediaPlayActionInfo>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaPlayActionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlayActionInfo createFromParcel(Parcel parcel) {
            return new VDMediaPlayActionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlayActionInfo[] newArray(int i2) {
            return new VDMediaPlayActionInfo[i2];
        }
    };
    private int collectStatus;
    private int cyclicMode;
    private int mDisPlayView;
    private int mIntent;
    private int mReason;
    private int mSeekPosition = 0;
    private int mSeekStatus;

    public VDMediaPlayActionInfo() {
    }

    private void readFromParcel(Parcel parcel) {
        this.mSeekPosition = parcel.readInt();
        this.mSeekStatus = parcel.readInt();
        this.mDisPlayView = parcel.readInt();
        this.mReason = parcel.readInt();
        this.mIntent = parcel.readInt();
        this.cyclicMode = parcel.readInt();
        this.collectStatus = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCollectStatus() {
        return this.collectStatus;
    }

    public int getCyclicMode() {
        return this.cyclicMode;
    }

    public int getDisPlayView() {
        return this.mDisPlayView;
    }

    public int getIntent() {
        return this.mIntent;
    }

    public int getReason() {
        return this.mReason;
    }

    public int getSeekPosition() {
        return this.mSeekPosition;
    }

    public int getSeekStatus() {
        return this.mSeekStatus;
    }

    public void putCollectStatus(int i2) {
        this.collectStatus = i2;
    }

    public void putCyclicMode(int i2) {
        this.cyclicMode = i2;
    }

    public void putDisPlayView(int i2) {
        this.mDisPlayView = i2;
    }

    public void putIntent(int i2) {
        this.mIntent = i2;
    }

    public void putReason(int i2) {
        this.mReason = i2;
    }

    public void putSeekPosition(int i2) {
        this.mSeekPosition = i2;
    }

    public void putSeekStatus(int i2) {
        this.mSeekStatus = i2;
    }

    public String toString() {
        return "VDMediaPlayActionInfo{mSeekPosition = " + this.mSeekPosition + ", mSeekStatus = " + this.mSeekStatus + ", mDisPlayView = " + this.mDisPlayView + ", mOpenReason = " + this.mReason + ", mIntent = " + this.mIntent + ", cyclicMode = " + this.cyclicMode + ", collectStatus = " + this.collectStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mSeekPosition);
        parcel.writeInt(this.mSeekStatus);
        parcel.writeInt(this.mDisPlayView);
        parcel.writeInt(this.mReason);
        parcel.writeInt(this.mIntent);
        parcel.writeInt(this.cyclicMode);
        parcel.writeInt(this.collectStatus);
    }

    protected VDMediaPlayActionInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
