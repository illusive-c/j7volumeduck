package com.desaysv.ivi.vdb.event.id.media.bean;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDMediaExtInfo implements Parcelable {
    public static final Parcelable.Creator<VDMediaExtInfo> CREATOR = new Parcelable.Creator<VDMediaExtInfo>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaExtInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaExtInfo createFromParcel(Parcel parcel) {
            return new VDMediaExtInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaExtInfo[] newArray(int i2) {
            return new VDMediaExtInfo[i2];
        }
    };
    private int connectState;
    private int cyclicMode;
    private Uri mediaList;
    private int mediaType;

    public VDMediaExtInfo() {
    }

    public static VDEvent createEvent(int i2, VDMediaExtInfo vDMediaExtInfo) {
        return new VDEvent(i2, createPayload(vDMediaExtInfo));
    }

    public static Bundle createPayload(VDMediaExtInfo vDMediaExtInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaExtInfo.class.getClassLoader());
        bundle.putParcelable("info", vDMediaExtInfo);
        return bundle;
    }

    public static VDMediaExtInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaExtInfo.class.getClassLoader());
        return (VDMediaExtInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getConnectState() {
        return this.connectState;
    }

    public int getCyclicMode() {
        return this.cyclicMode;
    }

    public Uri getMediaList() {
        return this.mediaList;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public void putConnectState(int i2) {
        this.connectState = i2;
    }

    public void putCyclicMode(int i2) {
        this.cyclicMode = i2;
    }

    public void putMediaList(Uri uri) {
        this.mediaList = uri;
    }

    public void putMediaType(int i2) {
        this.mediaType = i2;
    }

    public String toString() {
        return "VDMediaExtInfo{mediaType=" + this.mediaType + ", cyclicMode=" + this.cyclicMode + ", connectState=" + this.connectState + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mediaType);
        parcel.writeInt(this.cyclicMode);
        parcel.writeInt(this.connectState);
        parcel.writeParcelable(this.mediaList, i2);
    }

    protected VDMediaExtInfo(Parcel parcel) {
        this.mediaType = parcel.readInt();
        this.cyclicMode = parcel.readInt();
        this.connectState = parcel.readInt();
        this.mediaList = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }
}
