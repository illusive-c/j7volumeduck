package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTEnable implements Parcelable {
    public static final Parcelable.Creator<VDBTEnable> CREATOR = new Parcelable.Creator<VDBTEnable>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTEnable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTEnable createFromParcel(Parcel parcel) {
            return new VDBTEnable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTEnable[] newArray(int i2) {
            return new VDBTEnable[i2];
        }
    };
    private int mEnableStatus = 1;
    private int mEnableCtrl = 2;

    public VDBTEnable() {
    }

    public static VDEvent createEvent(int i2, VDBTEnable vDBTEnable) {
        return new VDEvent(i2, createPayload(vDBTEnable));
    }

    public static Bundle createPayload(VDBTEnable vDBTEnable) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTEnable.class.getClassLoader());
        bundle.putParcelable(VDKey.ENABLE, vDBTEnable);
        return bundle;
    }

    public static VDBTEnable getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTEnable.class.getClassLoader());
        return (VDBTEnable) vDEvent.getPayload().getParcelable(VDKey.ENABLE);
    }

    private void readFromParcel(Parcel parcel) {
        this.mEnableStatus = parcel.readInt();
        this.mEnableCtrl = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEnableCtrl() {
        return this.mEnableCtrl;
    }

    public int getEnableStatus() {
        return this.mEnableStatus;
    }

    public void putEnableCtrl(int i2) {
        this.mEnableCtrl = i2;
    }

    public void putEnableStatus(int i2) {
        this.mEnableStatus = i2;
    }

    public String toString() {
        return "VDBTEnable{enableStatus=" + this.mEnableStatus + ", enableCtrl=" + this.mEnableCtrl + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mEnableStatus);
        parcel.writeInt(this.mEnableCtrl);
    }

    protected VDBTEnable(Parcel parcel) {
        readFromParcel(parcel);
    }
}
