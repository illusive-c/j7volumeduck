package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviAreaDisplay implements Parcelable {
    public static final Parcelable.Creator<VDNaviAreaDisplay> CREATOR = new Parcelable.Creator<VDNaviAreaDisplay>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviAreaDisplay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviAreaDisplay createFromParcel(Parcel parcel) {
            return new VDNaviAreaDisplay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviAreaDisplay[] newArray(int i2) {
            return new VDNaviAreaDisplay[i2];
        }
    };
    private int RequestNaviAreaDisplay;

    public VDNaviAreaDisplay() {
        this.RequestNaviAreaDisplay = 0;
    }

    public static VDEvent createEvent(int i2, VDNaviAreaDisplay vDNaviAreaDisplay) {
        return new VDEvent(i2, createPayload(vDNaviAreaDisplay));
    }

    public static Bundle createPayload(VDNaviAreaDisplay vDNaviAreaDisplay) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviAreaDisplay.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviAreaDisplay);
        return bundle;
    }

    public static VDNaviAreaDisplay getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviAreaDisplay.class.getClassLoader());
        return (VDNaviAreaDisplay) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRequestNaviAreaDisplay() {
        return this.RequestNaviAreaDisplay;
    }

    public void setRequestNaviAreaDisplay(int i2) {
        this.RequestNaviAreaDisplay = i2;
    }

    public String toString() {
        return "VDNaviAreaDisplay{RequestNaviAreaDisplay=" + this.RequestNaviAreaDisplay + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.RequestNaviAreaDisplay);
    }

    protected VDNaviAreaDisplay(Parcel parcel) {
        this.RequestNaviAreaDisplay = 0;
        this.RequestNaviAreaDisplay = parcel.readInt();
    }
}
