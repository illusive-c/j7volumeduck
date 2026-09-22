package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDADSStateTipsInfo implements Parcelable {
    public static final Parcelable.Creator<VDADSStateTipsInfo> CREATOR = new Parcelable.Creator<VDADSStateTipsInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDADSStateTipsInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSStateTipsInfo createFromParcel(Parcel parcel) {
            return new VDADSStateTipsInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDADSStateTipsInfo[] newArray(int i2) {
            return new VDADSStateTipsInfo[i2];
        }
    };
    private long timestamp;
    private int tips;
    private int value;

    public VDADSStateTipsInfo() {
    }

    public static VDEvent createEvent(int i2, VDADSStateTipsInfo vDADSStateTipsInfo) {
        return new VDEvent(i2, createPayload(vDADSStateTipsInfo));
    }

    public static Bundle createPayload(VDADSStateTipsInfo vDADSStateTipsInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDADSStateTipsInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDADSStateTipsInfo);
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getTips() {
        return this.tips;
    }

    public int getValue() {
        return this.value;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public void setTips(int i2) {
        this.tips = i2;
    }

    public void setValue(int i2) {
        this.value = i2;
    }

    public String toString() {
        return "VDADSStateTipsInfo{timestamp=" + this.timestamp + ", tips=" + this.tips + ", value=" + this.value + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.tips);
        parcel.writeInt(this.value);
    }

    protected VDADSStateTipsInfo(Parcel parcel) {
        this.timestamp = parcel.readLong();
        this.tips = parcel.readInt();
        this.value = parcel.readInt();
    }

    public static VDADSStateTipsInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDADSStateTipsInfo.class.getClassLoader());
        return (VDADSStateTipsInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }
}
