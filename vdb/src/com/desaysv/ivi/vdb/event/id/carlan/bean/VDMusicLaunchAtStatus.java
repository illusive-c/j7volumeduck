package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import com.desaysv.ivi.vdb.event.id.common.Constant;

/* loaded from: classes.dex */
public class VDMusicLaunchAtStatus implements Parcelable {
    public static final Parcelable.Creator<VDMusicLaunchAtStatus> CREATOR = new Parcelable.Creator<VDMusicLaunchAtStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicLaunchAtStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicLaunchAtStatus createFromParcel(Parcel parcel) {
            return new VDMusicLaunchAtStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicLaunchAtStatus[] newArray(int i2) {
            return new VDMusicLaunchAtStatus[i2];
        }
    };
    private int MusicAtLaunchStatus;

    public VDMusicLaunchAtStatus() {
    }

    public static VDEvent createEvent(int i2, VDMusicLaunchAtStatus vDMusicLaunchAtStatus) {
        return new VDEvent(i2, createPayload(vDMusicLaunchAtStatus));
    }

    public static Bundle createPayload(VDMusicLaunchAtStatus vDMusicLaunchAtStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicLaunchAtStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicLaunchAtStatus);
        return bundle;
    }

    public static VDMusicLaunchAtStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        boolean z2 = vDEvent.getPayload().getBoolean(Constant.MUSIC_AT_LAUNCH_STATUS);
        VDMusicLaunchAtStatus vDMusicLaunchAtStatus = new VDMusicLaunchAtStatus();
        vDMusicLaunchAtStatus.setMusicAtLaunchStatus(z2 ? 1 : 0);
        return vDMusicLaunchAtStatus;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMusicAtLaunchStatus() {
        return this.MusicAtLaunchStatus;
    }

    public void setMusicAtLaunchStatus(int i2) {
        this.MusicAtLaunchStatus = i2;
    }

    public String toString() {
        return "VDMusicLaunchAtStatus{MusicAtLaunchStatus='" + this.MusicAtLaunchStatus + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.MusicAtLaunchStatus);
    }

    protected VDMusicLaunchAtStatus(Parcel parcel) {
        this.MusicAtLaunchStatus = parcel.readInt();
    }
}
