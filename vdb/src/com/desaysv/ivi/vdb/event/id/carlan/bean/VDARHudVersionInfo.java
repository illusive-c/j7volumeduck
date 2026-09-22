package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudVersionInfo implements Parcelable {
    public static final Parcelable.Creator<VDARHudVersionInfo> CREATOR = new Parcelable.Creator<VDARHudVersionInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudVersionInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudVersionInfo createFromParcel(Parcel parcel) {
            return new VDARHudVersionInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudVersionInfo[] newArray(int i2) {
            return new VDARHudVersionInfo[i2];
        }
    };
    private int GetArHudVersionInfo;

    public VDARHudVersionInfo() {
    }

    public static VDEvent createEvent(int i2, VDARHudVersionInfo vDARHudVersionInfo) {
        return new VDEvent(i2, createPayload(vDARHudVersionInfo));
    }

    public static Bundle createPayload(VDARHudVersionInfo vDARHudVersionInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudVersionInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudVersionInfo);
        return bundle;
    }

    public static VDARHudVersionInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudVersionInfo.class.getClassLoader());
        return (VDARHudVersionInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGetArHudVersionInfo() {
        return this.GetArHudVersionInfo;
    }

    public void setGetArHudVersionInfo(int i2) {
        this.GetArHudVersionInfo = i2;
    }

    public String toString() {
        return "VDARHudInfo{GetArHudVersionInfo=" + this.GetArHudVersionInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.GetArHudVersionInfo);
    }

    protected VDARHudVersionInfo(Parcel parcel) {
        this.GetArHudVersionInfo = parcel.readInt();
    }
}
