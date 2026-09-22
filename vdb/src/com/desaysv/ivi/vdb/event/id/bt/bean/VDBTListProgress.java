package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTListProgress implements Parcelable {
    public static final Parcelable.Creator<VDBTListProgress> CREATOR = new Parcelable.Creator<VDBTListProgress>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTListProgress.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTListProgress createFromParcel(Parcel parcel) {
            return new VDBTListProgress(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTListProgress[] newArray(int i2) {
            return new VDBTListProgress[i2];
        }
    };
    private int mIndex;
    private int mTotal;
    private String mAddress = null;
    private String mKey = null;

    public VDBTListProgress() {
    }

    public static VDEvent createEvent(int i2, VDBTListProgress vDBTListProgress) {
        return new VDEvent(i2, createPayload(vDBTListProgress));
    }

    public static Bundle createPayload(VDBTListProgress vDBTListProgress) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTListProgress.class.getClassLoader());
        bundle.putParcelable("status", vDBTListProgress);
        return bundle;
    }

    public static VDBTListProgress getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTListProgress.class.getClassLoader());
        return (VDBTListProgress) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mAddress = parcel.readString();
        this.mIndex = parcel.readInt();
        this.mTotal = parcel.readInt();
        this.mKey = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getKey() {
        return this.mKey;
    }

    public int getTotal() {
        return this.mTotal;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putIndex(int i2) {
        this.mIndex = i2;
    }

    public void putKey(String str) {
        this.mKey = str;
    }

    public void putTotal(int i2) {
        this.mTotal = i2;
    }

    public String toString() {
        return "VDBTListProgress{mAddress=" + this.mAddress + "index=" + this.mIndex + ", total=" + this.mTotal + ", key=" + this.mKey + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.mTotal);
        parcel.writeString(this.mKey);
    }

    protected VDBTListProgress(Parcel parcel) {
        readFromParcel(parcel);
    }
}
