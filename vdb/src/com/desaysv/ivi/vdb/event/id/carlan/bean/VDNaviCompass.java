package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviCompass implements Parcelable {
    public static final Parcelable.Creator<VDNaviCompass> CREATOR = new Parcelable.Creator<VDNaviCompass>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviCompass.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviCompass createFromParcel(Parcel parcel) {
            return new VDNaviCompass(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviCompass[] newArray(int i2) {
            return new VDNaviCompass[i2];
        }
    };
    private int Angle;

    public VDNaviCompass() {
    }

    public static VDEvent createEvent(int i2, VDNaviCompass vDNaviCompass) {
        return new VDEvent(i2, createPayload(vDNaviCompass));
    }

    public static Bundle createPayload(VDNaviCompass vDNaviCompass) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviCompass.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviCompass);
        return bundle;
    }

    public static VDNaviCompass getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviCompass.class.getClassLoader());
        return (VDNaviCompass) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAngle() {
        return this.Angle;
    }

    public void setAngle(int i2) {
        this.Angle = i2;
    }

    public String toString() {
        return "VDNaviCompass{Angle=" + this.Angle + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Angle);
    }

    protected VDNaviCompass(Parcel parcel) {
        this.Angle = parcel.readInt();
    }
}
