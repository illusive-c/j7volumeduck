package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTPhoneSyncStatus implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneSyncStatus> CREATOR = new Parcelable.Creator<VDBTPhoneSyncStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneSyncStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneSyncStatus createFromParcel(Parcel parcel) {
            return new VDBTPhoneSyncStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneSyncStatus[] newArray(int i2) {
            return new VDBTPhoneSyncStatus[i2];
        }
    };
    private String CallLogSyncState;

    public VDBTPhoneSyncStatus() {
    }

    public static VDEvent createEvent(int i2, VDBTPhoneSyncStatus vDBTPhoneSyncStatus) {
        return new VDEvent(i2, createPayload(vDBTPhoneSyncStatus));
    }

    public static Bundle createPayload(VDBTPhoneSyncStatus vDBTPhoneSyncStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneSyncStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneSyncStatus);
        return bundle;
    }

    public static VDBTPhoneSyncStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneSyncStatus.class.getClassLoader());
        return (VDBTPhoneSyncStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallLogSyncState() {
        return this.CallLogSyncState;
    }

    public void setCallLogSyncState(String str) {
        this.CallLogSyncState = str;
    }

    public String toString() {
        return "VDBTPhoneSyncStatus{CallLogSyncState='" + this.CallLogSyncState + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.CallLogSyncState);
    }

    protected VDBTPhoneSyncStatus(Parcel parcel) {
        this.CallLogSyncState = parcel.readString();
    }
}
