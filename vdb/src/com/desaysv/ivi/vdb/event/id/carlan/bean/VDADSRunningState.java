package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSRunningState implements Parcelable {
    public static final Parcelable.Creator<VDADSRunningState> CREATOR = new Parcelable.Creator<VDADSRunningState>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSRunningState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSRunningState createFromParcel(Parcel parcel) {
            return new VDADSRunningState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSRunningState[] newArray(int i2) {
            return new VDADSRunningState[i2];
        }
    };
    private int runningStateInfo;
    private int runningStateValue;
    private int runningStatus;
    private long timestamp;
    private long warning;

    public VDADSRunningState() {
    }

    public static VDEvent createEvent(int i2, VDADSRunningState vDADSRunningState) {
        return new VDEvent(i2, createPayload(vDADSRunningState));
    }

    public static Bundle createPayload(VDADSRunningState vDADSRunningState) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSRunningState.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSRunningState);
        return bundle;
    }

    public static VDADSRunningState getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSRunningState.class.getClassLoader());
        return (VDADSRunningState) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRunningStateInfo() {
        return this.runningStateInfo;
    }

    public int getRunningStateValue() {
        return this.runningStateValue;
    }

    public int getRunningStatus() {
        return this.runningStatus;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getWarning() {
        return this.warning;
    }

    public void setRunningStateInfo(int i2) {
        this.runningStateInfo = i2;
    }

    public void setRunningStateValue(int i2) {
        this.runningStateValue = i2;
    }

    public void setRunningStatus(int i2) {
        this.runningStatus = i2;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public void setWarning(long j2) {
        this.warning = j2;
    }

    public String toString() {
        return "VDADSRunningState{timestamp=" + this.timestamp + ", runningStatus=" + this.runningStatus + ", warning=" + this.warning + ", runningStateInfo=" + this.runningStateInfo + ", runningStateValue=" + this.runningStateValue + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.runningStatus);
        parcel.writeLong(this.warning);
        parcel.writeInt(this.runningStateInfo);
        parcel.writeInt(this.runningStateValue);
    }

    protected VDADSRunningState(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.runningStatus = parcel.readInt();
        this.warning = parcel.readLong();
        this.runningStateInfo = parcel.readInt();
        this.runningStateValue = parcel.readInt();
    }
}
