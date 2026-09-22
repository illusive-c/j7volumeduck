package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDMediaPlay implements Parcelable {
    public static final Parcelable.Creator<VDMediaPlay> CREATOR = new Parcelable.Creator<VDMediaPlay>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaPlay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlay createFromParcel(Parcel parcel) {
            return new VDMediaPlay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlay[] newArray(int i2) {
            return new VDMediaPlay[i2];
        }
    };
    private VDMediaPlayActionInfo mediaPlayActionInfo;
    private int mediaType;
    private int playAction;
    private int playStatus;
    private int searchStatus;

    public VDMediaPlay() {
    }

    public static VDEvent createEvent(int i2, VDMediaPlay vDMediaPlay) {
        return new VDEvent(i2, createPayload(vDMediaPlay));
    }

    public static Bundle createPayload(VDMediaPlay vDMediaPlay) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaPlay.class.getClassLoader());
        bundle.putParcelable("status", vDMediaPlay);
        return bundle;
    }

    public static VDMediaPlay getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaPlay.class.getClassLoader());
        return (VDMediaPlay) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mediaType = parcel.readInt();
        this.playStatus = parcel.readInt();
        this.playAction = parcel.readInt();
        this.searchStatus = parcel.readInt();
        this.mediaPlayActionInfo = (VDMediaPlayActionInfo) parcel.readParcelable(VDMediaPlayActionInfo.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDMediaPlayActionInfo getMediaPlayActionInfo() {
        return this.mediaPlayActionInfo;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public int getPlayAction() {
        return this.playAction;
    }

    public int getPlayStatus() {
        return this.playStatus;
    }

    public int getSearchStatus() {
        return this.searchStatus;
    }

    public void putMediaPlayActionInfo(VDMediaPlayActionInfo vDMediaPlayActionInfo) {
        this.mediaPlayActionInfo = vDMediaPlayActionInfo;
    }

    public void putMediaType(int i2) {
        this.mediaType = i2;
    }

    public void putPlayAction(int i2) {
        this.playAction = i2;
    }

    public void putPlayStatus(int i2) {
        this.playStatus = i2;
    }

    public void putSearchStatus(int i2) {
        this.searchStatus = i2;
    }

    public String toString() {
        return "VDMediaPlay{mediaType=" + this.mediaType + ", playStatus=" + this.playStatus + ", playAction=" + this.playAction + ", searchStatus=" + this.searchStatus + ", mMediaPlayActionInfo=" + this.mediaPlayActionInfo + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mediaType);
        parcel.writeInt(this.playStatus);
        parcel.writeInt(this.playAction);
        parcel.writeInt(this.searchStatus);
        parcel.writeParcelable(this.mediaPlayActionInfo, i2);
    }

    protected VDMediaPlay(Parcel parcel) {
        readFromParcel(parcel);
    }
}
