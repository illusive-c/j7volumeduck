package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDDABPlayStatus implements Parcelable {
    public static final Parcelable.Creator<VDDABPlayStatus> CREATOR = new Parcelable.Creator<VDDABPlayStatus>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABPlayStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlayStatus createFromParcel(Parcel parcel) {
            return new VDDABPlayStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlayStatus[] newArray(int i2) {
            return new VDDABPlayStatus[i2];
        }
    };
    private int playStatus;
    private int searchStatus;

    public VDDABPlayStatus() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPlayStatus() {
        return this.playStatus;
    }

    public int getSearchStatus() {
        return this.searchStatus;
    }

    public void putPlayStatus(int i2) {
        this.playStatus = i2;
    }

    public void putSearchStatus(int i2) {
        this.searchStatus = i2;
    }

    public String toString() {
        return "VDDABPlayStatus{playStatus=" + this.playStatus + ", searchStatus=" + this.searchStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.playStatus);
        parcel.writeInt(this.searchStatus);
    }

    protected VDDABPlayStatus(Parcel parcel) {
        this.playStatus = parcel.readInt();
        this.searchStatus = parcel.readInt();
    }
}
