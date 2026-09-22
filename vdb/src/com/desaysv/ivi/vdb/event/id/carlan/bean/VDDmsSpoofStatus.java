package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsSpoofStatus implements Parcelable {
    public static final Parcelable.Creator<VDDmsSpoofStatus> CREATOR = new Parcelable.Creator<VDDmsSpoofStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsSpoofStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsSpoofStatus createFromParcel(Parcel parcel) {
            return new VDDmsSpoofStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsSpoofStatus[] newArray(int i2) {
            return new VDDmsSpoofStatus[i2];
        }
    };
    private int id;
    private float score;
    private int status;

    public VDDmsSpoofStatus() {
    }

    public static VDEvent createEvent(int i2, VDDmsSpoofStatus vDDmsSpoofStatus) {
        return new VDEvent(i2, createPayload(vDDmsSpoofStatus));
    }

    public static Bundle createPayload(VDDmsSpoofStatus vDDmsSpoofStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsSpoofStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsSpoofStatus);
        return bundle;
    }

    public static VDDmsSpoofStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsSpoofStatus.class.getClassLoader());
        return (VDDmsSpoofStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.id;
    }

    public float getScore() {
        return this.score;
    }

    public int getStatus() {
        return this.status;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setScore(float f2) {
        this.score = f2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "VDDmsSpoofStatus{status=" + this.status + ", score=" + this.score + ", id=" + this.id + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.status);
        parcel.writeFloat(this.score);
        parcel.writeInt(this.id);
    }

    protected VDDmsSpoofStatus(Parcel parcel) {
        this.status = parcel.readInt();
        this.score = parcel.readFloat();
        this.id = parcel.readInt();
    }
}
