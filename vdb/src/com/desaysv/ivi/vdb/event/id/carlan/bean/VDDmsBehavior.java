package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsBehavior implements Parcelable {
    public static final Parcelable.Creator<VDDmsBehavior> CREATOR = new Parcelable.Creator<VDDmsBehavior>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsBehavior.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsBehavior createFromParcel(Parcel parcel) {
            return new VDDmsBehavior(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsBehavior[] newArray(int i2) {
            return new VDDmsBehavior[i2];
        }
    };
    private int behavior;
    private float score;

    public VDDmsBehavior() {
    }

    public static VDEvent createEvent(int i2, VDDmsBehavior vDDmsBehavior) {
        return new VDEvent(i2, createPayload(vDDmsBehavior));
    }

    public static Bundle createPayload(VDDmsBehavior vDDmsBehavior) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsBehavior.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsBehavior);
        return bundle;
    }

    public static VDDmsBehavior getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsBehavior.class.getClassLoader());
        return (VDDmsBehavior) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBehavior() {
        return this.behavior;
    }

    public float getScore() {
        return this.score;
    }

    public void setBehavior(int i2) {
        this.behavior = i2;
    }

    public void setScore(float f2) {
        this.score = f2;
    }

    public String toString() {
        return "VDDmsBehavior{behavior=" + this.behavior + ", score=" + this.score + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.behavior);
        parcel.writeFloat(this.score);
    }

    protected VDDmsBehavior(Parcel parcel) {
        this.behavior = parcel.readInt();
        this.score = parcel.readFloat();
    }
}
