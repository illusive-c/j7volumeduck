package com.desaysv.ivi.vdb.event.id.tuner.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDFmAmPlay implements Parcelable {
    public static final Parcelable.Creator<VDFmAmPlay> CREATOR = new Parcelable.Creator<VDFmAmPlay>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.VDFmAmPlay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDFmAmPlay createFromParcel(Parcel parcel) {
            return new VDFmAmPlay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDFmAmPlay[] newArray(int i2) {
            return new VDFmAmPlay[i2];
        }
    };
    private int mPlayAction;
    private int mPlayStatus;
    private VDFmAmPlayActionInfo playActionInfo;
    private int searchStatus;

    public VDFmAmPlay() {
    }

    public static VDEvent createEvent(int i2, VDFmAmPlay vDFmAmPlay) {
        return new VDEvent(i2, createPayload(vDFmAmPlay));
    }

    public static Bundle createPayload(VDFmAmPlay vDFmAmPlay) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDFmAmPlay.class.getClassLoader());
        bundle.putParcelable("status", vDFmAmPlay);
        return bundle;
    }

    public static VDFmAmPlay getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDFmAmPlay.class.getClassLoader());
        return (VDFmAmPlay) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mPlayStatus = parcel.readInt();
        this.mPlayAction = parcel.readInt();
        this.searchStatus = parcel.readInt();
        this.playActionInfo = (VDFmAmPlayActionInfo) parcel.readParcelable(VDFmAmPlayActionInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPlayAction() {
        return this.mPlayAction;
    }

    public VDFmAmPlayActionInfo getPlayActionInfo() {
        return this.playActionInfo;
    }

    public int getPlayStatus() {
        return this.mPlayStatus;
    }

    public int getSearchStatus() {
        return this.searchStatus;
    }

    public void putPlayAction(int i2) {
        this.mPlayAction = i2;
    }

    public void putPlayActionInfo(VDFmAmPlayActionInfo vDFmAmPlayActionInfo) {
        this.playActionInfo = vDFmAmPlayActionInfo;
    }

    public void putPlayStatus(int i2) {
        this.mPlayStatus = i2;
    }

    public void putSearchStatus(int i2) {
        this.searchStatus = i2;
    }

    public String toString() {
        return "VDFmAmPlay{playStatus = " + this.mPlayStatus + ", mPlayAction = " + this.mPlayAction + ", searchStatus = " + this.searchStatus + ", playActionInfo = " + this.playActionInfo + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mPlayStatus);
        parcel.writeInt(this.mPlayAction);
        parcel.writeInt(this.searchStatus);
        parcel.writeParcelable(this.playActionInfo, i2);
    }

    protected VDFmAmPlay(Parcel parcel) {
        readFromParcel(parcel);
    }
}
