package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTPhoneDuration implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneDuration> CREATOR = new Parcelable.Creator<VDBTPhoneDuration>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneDuration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneDuration createFromParcel(Parcel parcel) {
            return new VDBTPhoneDuration(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneDuration[] newArray(int i2) {
            return new VDBTPhoneDuration[i2];
        }
    };
    private int CallDuration;

    public VDBTPhoneDuration() {
    }

    public static VDEvent createEvent(int i2, VDBTPhoneDuration vDBTPhoneDuration) {
        return new VDEvent(i2, createPayload(vDBTPhoneDuration));
    }

    public static Bundle createPayload(VDBTPhoneDuration vDBTPhoneDuration) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneDuration.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneDuration);
        return bundle;
    }

    public static VDBTPhoneDuration getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneDuration.class.getClassLoader());
        return (VDBTPhoneDuration) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCallDuration() {
        return this.CallDuration;
    }

    public void setCallDuration(int i2) {
        this.CallDuration = i2;
    }

    public String toString() {
        return "VDBTPhoneDuration{CallDuration=" + this.CallDuration + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.CallDuration);
    }

    protected VDBTPhoneDuration(Parcel parcel) {
        this.CallDuration = parcel.readInt();
    }
}
