package com.desaysv.ivi.vdb.event.id.media.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDMediaType implements Parcelable {
    public static final Parcelable.Creator<VDMediaType> CREATOR = new Parcelable.Creator<VDMediaType>() { // from class: com.desaysv.ivi.vdb.event.id.media.bean.VDMediaType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaType createFromParcel(Parcel parcel) {
            return new VDMediaType(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMediaType[] newArray(int i2) {
            return new VDMediaType[i2];
        }
    };
    private int mMediaType;

    public VDMediaType() {
    }

    public static VDEvent createEvent(int i2, VDMediaType vDMediaType) {
        return new VDEvent(i2, createPayload(vDMediaType));
    }

    public static Bundle createPayload(VDMediaType vDMediaType) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMediaType.class.getClassLoader());
        bundle.putParcelable("type", vDMediaType);
        return bundle;
    }

    public static VDMediaType getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMediaType.class.getClassLoader());
        return (VDMediaType) vDEvent.getPayload().getParcelable("type");
    }

    private void readFromParcel(Parcel parcel) {
        this.mMediaType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void putMediaType(int i2) {
        this.mMediaType = i2;
    }

    public String toString() {
        return "VDMediaType{mediaType=" + this.mMediaType + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mMediaType);
    }

    protected VDMediaType(Parcel parcel) {
        readFromParcel(parcel);
    }
}
