package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDMediaPlayTime implements Parcelable {
    public static final Parcelable.Creator<VDMediaPlayTime> CREATOR = new Parcelable.Creator<VDMediaPlayTime>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaPlayTime.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlayTime createFromParcel(Parcel parcel) {
            return new VDMediaPlayTime(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaPlayTime[] newArray(int i2) {
            return new VDMediaPlayTime[i2];
        }
    };
    private int duration;
    private int mediaType;
    private int position;

    public VDMediaPlayTime() {
    }

    public static VDEvent createEvent(int i2, VDMediaPlayTime vDMediaPlayTime) {
        return new VDEvent(i2, createPayload(vDMediaPlayTime));
    }

    public static Bundle createPayload(VDMediaPlayTime vDMediaPlayTime) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaPlayTime.class.getClassLoader());
        bundle.putParcelable("value", vDMediaPlayTime);
        return bundle;
    }

    public static VDMediaPlayTime getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaPlayTime.class.getClassLoader());
        return (VDMediaPlayTime) vDEvent.getPayload().getParcelable("value");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public int getPosition() {
        return this.position;
    }

    public void putDuration(int i2) {
        this.duration = i2;
    }

    public void putMediaType(int i2) {
        this.mediaType = i2;
    }

    public void putPosition(int i2) {
        this.position = i2;
    }

    public String toString() {
        return "VDMediaPlayTime{position=" + this.position + ", duration=" + this.duration + ", mediaType=" + this.mediaType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.position);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.mediaType);
    }

    protected VDMediaPlayTime(Parcel parcel) {
        this.position = parcel.readInt();
        this.duration = parcel.readInt();
        this.mediaType = parcel.readInt();
    }
}
