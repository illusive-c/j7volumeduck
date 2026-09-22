package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTDiscoverable implements Parcelable {
    public static final Parcelable.Creator<VDBTDiscoverable> CREATOR = new Parcelable.Creator<VDBTDiscoverable>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTDiscoverable.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDiscoverable createFromParcel(Parcel parcel) {
            return new VDBTDiscoverable(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDiscoverable[] newArray(int i2) {
            return new VDBTDiscoverable[i2];
        }
    };
    private int mTimeTick = 0;
    private int mDiscoverableStatus = 1;
    private int mDiscoverableCtrl = 3;

    public VDBTDiscoverable() {
    }

    public static VDEvent createEvent(int i2, VDBTDiscoverable vDBTDiscoverable) {
        return new VDEvent(i2, createPayload(vDBTDiscoverable));
    }

    public static Bundle createPayload(VDBTDiscoverable vDBTDiscoverable) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDiscoverable.class.getClassLoader());
        bundle.putParcelable("status", vDBTDiscoverable);
        return bundle;
    }

    public static VDBTDiscoverable getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDiscoverable.class.getClassLoader());
        return (VDBTDiscoverable) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mTimeTick = parcel.readInt();
        this.mDiscoverableStatus = parcel.readInt();
        this.mDiscoverableCtrl = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDiscoverableCtrl() {
        return this.mDiscoverableCtrl;
    }

    public int getDiscoverableStatus() {
        return this.mDiscoverableStatus;
    }

    public int getTimeTick() {
        return this.mTimeTick;
    }

    public void putDiscoverableCtrl(int i2) {
        this.mDiscoverableCtrl = i2;
    }

    public void putDiscoverableStatus(int i2) {
        this.mDiscoverableStatus = i2;
    }

    public void putTimeTick(int i2) {
        this.mTimeTick = i2;
    }

    public String toString() {
        return "VDBTDiscoverable{timeTick=" + this.mTimeTick + ", discoverableStatus=" + this.mDiscoverableStatus + ", discoverableCtrl=" + this.mDiscoverableCtrl + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mTimeTick);
        parcel.writeInt(this.mDiscoverableStatus);
        parcel.writeInt(this.mDiscoverableCtrl);
    }

    protected VDBTDiscoverable(Parcel parcel) {
        readFromParcel(parcel);
    }
}
