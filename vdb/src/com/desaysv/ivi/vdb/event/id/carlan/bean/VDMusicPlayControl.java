package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayControl implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayControl> CREATOR = new Parcelable.Creator<VDMusicPlayControl>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayControl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayControl createFromParcel(Parcel parcel) {
            return new VDMusicPlayControl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayControl[] newArray(int i2) {
            return new VDMusicPlayControl[i2];
        }
    };
    private int Index;
    private int MediaType;

    public VDMusicPlayControl() {
        this.MediaType = 0;
    }

    public static VDEvent createEvent(int i2, VDMusicPlayControl vDMusicPlayControl) {
        return new VDEvent(i2, createPayload(vDMusicPlayControl));
    }

    public static Bundle createPayload(VDMusicPlayControl vDMusicPlayControl) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayControl.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayControl);
        return bundle;
    }

    public static VDMusicPlayControl getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayControl.class.getClassLoader());
        return (VDMusicPlayControl) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIndex() {
        return this.Index;
    }

    public int getMediaType() {
        return this.MediaType;
    }

    public void setIndex(int i2) {
        this.Index = i2;
    }

    public void setMediaType(int i2) {
        this.MediaType = i2;
    }

    public String toString() {
        return "VDMusicPlayControl{MediaType=" + this.MediaType + ", Index=" + this.Index + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.MediaType);
        parcel.writeInt(this.Index);
    }

    protected VDMusicPlayControl(Parcel parcel) {
        this.MediaType = 0;
        this.MediaType = parcel.readInt();
        this.Index = parcel.readInt();
    }
}
