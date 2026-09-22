package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTMusicListSync implements Parcelable {
    public static final Parcelable.Creator<VDBTMusicListSync> CREATOR = new Parcelable.Creator<VDBTMusicListSync>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTMusicListSync.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicListSync createFromParcel(Parcel parcel) {
            return new VDBTMusicListSync(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMusicListSync[] newArray(int i2) {
            return new VDBTMusicListSync[i2];
        }
    };
    private String mSyncAddress = null;
    private int mSyncType = 0;
    private int mSyncStatus = 20;
    private int mSyncCtrl = 1;
    private String mSyncKey = null;

    public VDBTMusicListSync() {
    }

    public static VDEvent createEvent(int i2, VDBTMusicListSync vDBTMusicListSync) {
        return new VDEvent(i2, createPayload(vDBTMusicListSync));
    }

    public static Bundle createPayload(VDBTMusicListSync vDBTMusicListSync) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMusicListSync.class.getClassLoader());
        bundle.putParcelable("status", vDBTMusicListSync);
        return bundle;
    }

    public static VDBTMusicListSync getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMusicListSync.class.getClassLoader());
        return (VDBTMusicListSync) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mSyncAddress = parcel.readString();
        this.mSyncType = parcel.readInt();
        this.mSyncStatus = parcel.readInt();
        this.mSyncCtrl = parcel.readInt();
        this.mSyncKey = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getSyncAddress() {
        return this.mSyncAddress;
    }

    public int getSyncCtrl() {
        return this.mSyncCtrl;
    }

    public String getSyncKey() {
        return this.mSyncKey;
    }

    public int getSyncStatus() {
        return this.mSyncStatus;
    }

    public int getSyncType() {
        return this.mSyncType;
    }

    public void putSyncAddress(String str) {
        this.mSyncAddress = str;
    }

    public void putSyncCtrl(int i2) {
        this.mSyncCtrl = i2;
    }

    public void putSyncKey(String str) {
        this.mSyncKey = str;
    }

    public void putSyncStatus(int i2) {
        this.mSyncStatus = i2;
    }

    public void putSyncType(int i2) {
        this.mSyncType = i2;
    }

    public String toString() {
        return "VDBTMusicListSync{mSyncAddress=" + this.mSyncAddress + "syncType=" + this.mSyncType + ", syncStatus=" + this.mSyncStatus + ", syncCtrl=" + this.mSyncCtrl + ", syncKey=" + this.mSyncKey + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mSyncAddress);
        parcel.writeInt(this.mSyncType);
        parcel.writeInt(this.mSyncStatus);
        parcel.writeInt(this.mSyncCtrl);
        parcel.writeString(this.mSyncKey);
    }

    protected VDBTMusicListSync(Parcel parcel) {
        readFromParcel(parcel);
    }
}
