package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTLoopConnect implements Parcelable {
    public static final Parcelable.Creator<VDBTLoopConnect> CREATOR = new Parcelable.Creator<VDBTLoopConnect>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTLoopConnect.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTLoopConnect createFromParcel(Parcel parcel) {
            return new VDBTLoopConnect(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTLoopConnect[] newArray(int i2) {
            return new VDBTLoopConnect[i2];
        }
    };
    private String mMac = null;
    private boolean mIsRemoveConnectTask = false;
    private boolean mIsConnectWhenOtherConnected = false;
    private long mIntervalSecond = 0;
    private long mTimeOutSecond = 0;

    public VDBTLoopConnect() {
    }

    public static VDEvent createEvent(int i2, VDBTLoopConnect vDBTLoopConnect) {
        return new VDEvent(i2, createPayload(vDBTLoopConnect));
    }

    public static Bundle createPayload(VDBTLoopConnect vDBTLoopConnect) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTLoopConnect.class.getClassLoader());
        bundle.putParcelable("status", vDBTLoopConnect);
        return bundle;
    }

    public static VDBTLoopConnect getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTLoopConnect.class.getClassLoader());
        return (VDBTLoopConnect) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mIsRemoveConnectTask = parcel.readBoolean();
        this.mIsConnectWhenOtherConnected = parcel.readBoolean();
        this.mIntervalSecond = parcel.readLong();
        this.mTimeOutSecond = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getIntervalSecond() {
        return this.mIntervalSecond;
    }

    public boolean getIsConnectWhenOtherConnected() {
        return this.mIsConnectWhenOtherConnected;
    }

    public boolean getIsRemoveConnectTask() {
        return this.mIsRemoveConnectTask;
    }

    public String getMac() {
        return this.mMac;
    }

    public long getTimeOutSecond() {
        return this.mTimeOutSecond;
    }

    public void putIntervalSecond(long j2) {
        this.mIntervalSecond = j2;
    }

    public void putIsConnectWhenOtherConnected(boolean z2) {
        this.mIsConnectWhenOtherConnected = z2;
    }

    public void putIsRemoveConnectTask(boolean z2) {
        this.mIsRemoveConnectTask = z2;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public void putTimeOutSecond(long j2) {
        this.mTimeOutSecond = j2;
    }

    public String toString() {
        return "VDBTLoopConnect{mac=" + this.mMac + ", isRemoveConnectTask=" + this.mIsRemoveConnectTask + ", isConnectWhenOtherConnected=" + this.mIsConnectWhenOtherConnected + ", intervalSecond=" + this.mIntervalSecond + ", timeOutSecond=" + this.mTimeOutSecond + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeBoolean(this.mIsRemoveConnectTask);
        parcel.writeBoolean(this.mIsConnectWhenOtherConnected);
        parcel.writeLong(this.mIntervalSecond);
        parcel.writeLong(this.mTimeOutSecond);
    }

    protected VDBTLoopConnect(Parcel parcel) {
        readFromParcel(parcel);
    }
}
