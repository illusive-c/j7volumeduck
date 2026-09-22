package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTAGEvent implements Parcelable {
    public static final Parcelable.Creator<VDBTAGEvent> CREATOR = new Parcelable.Creator<VDBTAGEvent>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTAGEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTAGEvent createFromParcel(Parcel parcel) {
            return new VDBTAGEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTAGEvent[] newArray(int i2) {
            return new VDBTAGEvent[i2];
        }
    };
    private String mMac = null;
    private String mOperator = null;
    private String mSubscriberInfo = null;
    private String mManufacturer = null;
    private int mNetworkState = -1;
    private int mSignal = -1;
    private int mNetworkRoaming = -1;
    private int mBatteryLevel = -1;

    public VDBTAGEvent() {
    }

    public static VDEvent createEvent(int i2, VDBTAGEvent vDBTAGEvent) {
        return new VDEvent(i2, createPayload(vDBTAGEvent));
    }

    public static Bundle createPayload(VDBTAGEvent vDBTAGEvent) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTAGEvent.class.getClassLoader());
        bundle.putParcelable("value", vDBTAGEvent);
        return bundle;
    }

    public static VDBTAGEvent getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTAGEvent.class.getClassLoader());
        return (VDBTAGEvent) vDEvent.getPayload().getParcelable("value");
    }

    private void readFromParcel(Parcel parcel) {
        this.mMac = parcel.readString();
        this.mOperator = parcel.readString();
        this.mSubscriberInfo = parcel.readString();
        this.mManufacturer = parcel.readString();
        this.mNetworkState = parcel.readInt();
        this.mSignal = parcel.readInt();
        this.mNetworkRoaming = parcel.readInt();
        this.mBatteryLevel = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBatteryLevel() {
        return this.mBatteryLevel;
    }

    public String getMac() {
        return this.mMac;
    }

    public String getManufacturer() {
        return this.mManufacturer;
    }

    public int getNetworkRoaming() {
        return this.mNetworkRoaming;
    }

    public int getNetworkState() {
        return this.mNetworkState;
    }

    public String getOperator() {
        return this.mOperator;
    }

    public int getSignal() {
        return this.mSignal;
    }

    public String getSubscriberInfo() {
        return this.mSubscriberInfo;
    }

    public void putBatteryLevel(int i2) {
        this.mBatteryLevel = i2;
    }

    public void putMac(String str) {
        this.mMac = str;
    }

    public void putManufacturer(String str) {
        this.mManufacturer = str;
    }

    public void putNetworkRoaming(int i2) {
        this.mNetworkRoaming = i2;
    }

    public void putNetworkState(int i2) {
        this.mNetworkState = i2;
    }

    public void putOperator(String str) {
        this.mOperator = str;
    }

    public void putSignal(int i2) {
        this.mSignal = i2;
    }

    public void putSubscriberInfo(String str) {
        this.mSubscriberInfo = str;
    }

    public String toString() {
        return "VDBTAGEvent{mac=" + this.mMac + ", operator=" + this.mOperator + ", subscriberInfo=" + this.mSubscriberInfo + ", manufacturer=" + this.mManufacturer + ", networkState=" + this.mNetworkState + ", signal=" + this.mSignal + ", networkRoaming=" + this.mNetworkRoaming + ", batteryLevel=" + this.mBatteryLevel + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mMac);
        parcel.writeString(this.mOperator);
        parcel.writeString(this.mSubscriberInfo);
        parcel.writeString(this.mManufacturer);
        parcel.writeInt(this.mNetworkState);
        parcel.writeInt(this.mSignal);
        parcel.writeInt(this.mNetworkRoaming);
        parcel.writeInt(this.mBatteryLevel);
    }

    protected VDBTAGEvent(Parcel parcel) {
        readFromParcel(parcel);
    }
}
