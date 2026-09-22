package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsFaceValidity implements Parcelable {
    public static final Parcelable.Creator<VDDmsFaceValidity> CREATOR = new Parcelable.Creator<VDDmsFaceValidity>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsFaceValidity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsFaceValidity createFromParcel(Parcel parcel) {
            return new VDDmsFaceValidity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsFaceValidity[] newArray(int i2) {
            return new VDDmsFaceValidity[i2];
        }
    };
    private int isValid;

    public VDDmsFaceValidity() {
    }

    public static VDEvent createEvent(int i2, VDDmsFaceValidity vDDmsFaceValidity) {
        return new VDEvent(i2, createPayload(vDDmsFaceValidity));
    }

    public static Bundle createPayload(VDDmsFaceValidity vDDmsFaceValidity) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsFaceValidity.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsFaceValidity);
        return bundle;
    }

    public static VDDmsFaceValidity getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsFaceValidity.class.getClassLoader());
        return (VDDmsFaceValidity) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIsValid() {
        return this.isValid;
    }

    public void setIsValid(int i2) {
        this.isValid = i2;
    }

    public String toString() {
        return "VDDmsFaceValidity{isValid=" + this.isValid + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.isValid);
    }

    protected VDDmsFaceValidity(Parcel parcel) {
        this.isValid = parcel.readInt();
    }
}
