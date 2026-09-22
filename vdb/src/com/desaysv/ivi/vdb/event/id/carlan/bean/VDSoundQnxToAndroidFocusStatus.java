package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDSoundQnxToAndroidFocusStatus implements Parcelable {
    public static final Parcelable.Creator<VDSoundQnxToAndroidFocusStatus> CREATOR = new Parcelable.Creator<VDSoundQnxToAndroidFocusStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDSoundQnxToAndroidFocusStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundQnxToAndroidFocusStatus createFromParcel(Parcel parcel) {
            return new VDSoundQnxToAndroidFocusStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDSoundQnxToAndroidFocusStatus[] newArray(int i2) {
            return new VDSoundQnxToAndroidFocusStatus[i2];
        }
    };
    private int audioSourceID;
    private int operateAudioFocus;
    private int requestFocusType;

    public VDSoundQnxToAndroidFocusStatus() {
        this.operateAudioFocus = 0;
        this.audioSourceID = 201;
        this.requestFocusType = 0;
    }

    public static VDEvent createEvent(int i2, VDSoundQnxToAndroidFocusStatus vDSoundQnxToAndroidFocusStatus) {
        return new VDEvent(i2, createPayload(vDSoundQnxToAndroidFocusStatus));
    }

    public static Bundle createPayload(VDSoundQnxToAndroidFocusStatus vDSoundQnxToAndroidFocusStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDSoundQnxToAndroidFocusStatus.class.getClassLoader());
        bundle.putParcelable("info", vDSoundQnxToAndroidFocusStatus);
        return bundle;
    }

    public static VDSoundQnxToAndroidFocusStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDSoundQnxToAndroidFocusStatus.class.getClassLoader());
        return (VDSoundQnxToAndroidFocusStatus) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAudioSourceID() {
        return this.audioSourceID;
    }

    public int getOperateAudioFocus() {
        return this.operateAudioFocus;
    }

    public int getRequestFocusType() {
        return this.requestFocusType;
    }

    public void setAudioSourceID(int i2) {
        this.audioSourceID = i2;
    }

    public void setOperateAudioFocus(int i2) {
        this.operateAudioFocus = i2;
    }

    public void setRequestFocusType(int i2) {
        this.requestFocusType = i2;
    }

    public String toString() {
        return "VDSoundQnxToAndroidFocusStatus{operateAudioFocus=" + this.operateAudioFocus + ", audioSourceID=" + this.audioSourceID + ", requestFocusType=" + this.requestFocusType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.operateAudioFocus);
        parcel.writeInt(this.audioSourceID);
        parcel.writeInt(this.requestFocusType);
    }

    protected VDSoundQnxToAndroidFocusStatus(Parcel parcel) {
        this.operateAudioFocus = 0;
        this.audioSourceID = 201;
        this.requestFocusType = 0;
        this.operateAudioFocus = parcel.readInt();
        this.audioSourceID = parcel.readInt();
        this.requestFocusType = parcel.readInt();
    }
}
