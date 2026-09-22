package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABAnnTips implements Parcelable {
    public static final Parcelable.Creator<VDDABAnnTips> CREATOR = new Parcelable.Creator<VDDABAnnTips>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABAnnTips.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAnnTips createFromParcel(Parcel parcel) {
            return new VDDABAnnTips(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAnnTips[] newArray(int i2) {
            return new VDDABAnnTips[i2];
        }
    };
    private int annouceType;
    private int status;

    public VDDABAnnTips() {
    }

    public static VDEvent createEvent(int i2, VDDABAnnTips vDDABAnnTips) {
        return new VDEvent(i2, createPayload(vDDABAnnTips));
    }

    public static Bundle createPayload(VDDABAnnTips vDDABAnnTips) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABAnnTips.class.getClassLoader());
        bundle.putParcelable("status", vDDABAnnTips);
        return bundle;
    }

    public static VDDABAnnTips getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABAnnTips.class.getClassLoader());
        return (VDDABAnnTips) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAnnouceType() {
        return this.annouceType;
    }

    public int getStatus() {
        return this.status;
    }

    public void putAnnouceType(int i2) {
        this.annouceType = i2;
    }

    public void putStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "VDDABAnnTips{status=" + this.status + ", annouceType=" + this.annouceType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.annouceType);
    }

    protected VDDABAnnTips(Parcel parcel) {
        this.status = parcel.readInt();
        this.annouceType = parcel.readInt();
    }
}
