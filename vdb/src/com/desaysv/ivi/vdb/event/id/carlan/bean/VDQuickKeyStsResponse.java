package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDQuickKeyStsResponse implements Parcelable {
    public static final Parcelable.Creator<VDQuickKeyStsResponse> CREATOR = new Parcelable.Creator<VDQuickKeyStsResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDQuickKeyStsResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDQuickKeyStsResponse createFromParcel(Parcel parcel) {
            return new VDQuickKeyStsResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDQuickKeyStsResponse[] newArray(int i2) {
            return new VDQuickKeyStsResponse[i2];
        }
    };
    private int QuickKeySts;

    public VDQuickKeyStsResponse() {
        this.QuickKeySts = 0;
    }

    public static VDEvent createEvent(int i2, VDQuickKeyStsResponse vDQuickKeyStsResponse) {
        return new VDEvent(i2, createPayload(vDQuickKeyStsResponse));
    }

    public static Bundle createPayload(VDQuickKeyStsResponse vDQuickKeyStsResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDQuickKeyStsResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDQuickKeyStsResponse);
        return bundle;
    }

    public static VDQuickKeyStsResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDQuickKeyStsResponse.class.getClassLoader());
        return (VDQuickKeyStsResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getQuickKeySts() {
        return this.QuickKeySts;
    }

    public void setQuickKeySts(int i2) {
        this.QuickKeySts = i2;
    }

    public String toString() {
        return "VDQuickKeyStsResponse{QuickKeySts=" + this.QuickKeySts + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.QuickKeySts);
    }

    protected VDQuickKeyStsResponse(Parcel parcel) {
        this.QuickKeySts = 0;
        this.QuickKeySts = parcel.readInt();
    }
}
