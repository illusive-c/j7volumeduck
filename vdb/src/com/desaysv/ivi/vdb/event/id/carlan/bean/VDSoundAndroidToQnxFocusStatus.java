package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDSoundAndroidToQnxFocusStatus implements Parcelable {
    public static final Parcelable.Creator<VDSoundAndroidToQnxFocusStatus> CREATOR = new Parcelable.Creator<VDSoundAndroidToQnxFocusStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDSoundAndroidToQnxFocusStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundAndroidToQnxFocusStatus createFromParcel(Parcel parcel) {
            return new VDSoundAndroidToQnxFocusStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundAndroidToQnxFocusStatus[] newArray(int i2) {
            return new VDSoundAndroidToQnxFocusStatus[i2];
        }
    };
    private int audioSourceID;
    private int playAction;

    public VDSoundAndroidToQnxFocusStatus() {
        this.playAction = 0;
        this.audioSourceID = 201;
    }

    public static VDEvent createEvent(int i2, VDSoundAndroidToQnxFocusStatus vDSoundAndroidToQnxFocusStatus) {
        return new VDEvent(i2, createPayload(vDSoundAndroidToQnxFocusStatus));
    }

    public static Bundle createPayload(VDSoundAndroidToQnxFocusStatus vDSoundAndroidToQnxFocusStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDSoundAndroidToQnxFocusStatus.class.getClassLoader());
        bundle.putParcelable("info", vDSoundAndroidToQnxFocusStatus);
        return bundle;
    }

    public static VDSoundAndroidToQnxFocusStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDSoundAndroidToQnxFocusStatus.class.getClassLoader());
        return (VDSoundAndroidToQnxFocusStatus) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAudioSourceID() {
        return this.audioSourceID;
    }

    public int getPlayAction() {
        return this.playAction;
    }

    public void setAudioSourceID(int i2) {
        this.audioSourceID = i2;
    }

    public void setPlayAction(int i2) {
        this.playAction = i2;
    }

    public String toString() {
        return "VDSoundAndroidToQnxFocusStatus{playAction=" + this.playAction + ", audioSourceID=" + this.audioSourceID + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.playAction);
        parcel.writeInt(this.audioSourceID);
    }

    protected VDSoundAndroidToQnxFocusStatus(Parcel parcel) {
        this.playAction = 0;
        this.audioSourceID = 201;
        this.playAction = parcel.readInt();
        this.audioSourceID = parcel.readInt();
    }
}
