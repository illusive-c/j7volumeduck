package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudUpdateResponse implements Parcelable {
    public static final Parcelable.Creator<VDARHudUpdateResponse> CREATOR = new Parcelable.Creator<VDARHudUpdateResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudUpdateResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudUpdateResponse createFromParcel(Parcel parcel) {
            return new VDARHudUpdateResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudUpdateResponse[] newArray(int i2) {
            return new VDARHudUpdateResponse[i2];
        }
    };
    private int UpdateHudReq_fb;

    protected VDARHudUpdateResponse(Parcel parcel) {
        this.UpdateHudReq_fb = 0;
        this.UpdateHudReq_fb = parcel.readInt();
    }

    public static VDEvent createEvent(int i2, VDARHudUpdateResponse vDARHudUpdateResponse) {
        return new VDEvent(i2, createPayload(vDARHudUpdateResponse));
    }

    public static Bundle createPayload(VDARHudUpdateResponse vDARHudUpdateResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudUpdateResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudUpdateResponse);
        return bundle;
    }

    public static VDARHudUpdateResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudUpdateResponse.class.getClassLoader());
        return (VDARHudUpdateResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getUpdateHudReq_fb() {
        return this.UpdateHudReq_fb;
    }

    public void setUpdateHudReq_fb(int i2) {
        this.UpdateHudReq_fb = i2;
    }

    public String toString() {
        return "VDARHudUpdateResponse{UpdateHudReq_fb=" + this.UpdateHudReq_fb + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.UpdateHudReq_fb);
    }
}
