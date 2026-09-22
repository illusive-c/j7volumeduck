package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudIdResponse implements Parcelable {
    public static final Parcelable.Creator<VDARHudIdResponse> CREATOR = new Parcelable.Creator<VDARHudIdResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudIdResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudIdResponse createFromParcel(Parcel parcel) {
            return new VDARHudIdResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudIdResponse[] newArray(int i2) {
            return new VDARHudIdResponse[i2];
        }
    };
    private int CheckHudUserID;

    public VDARHudIdResponse() {
    }

    public static VDEvent createEvent(int i2, VDARHudIdResponse vDARHudIdResponse) {
        return new VDEvent(i2, createPayload(vDARHudIdResponse));
    }

    public static Bundle createPayload(VDARHudIdResponse vDARHudIdResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudIdResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudIdResponse);
        return bundle;
    }

    public static VDARHudIdResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudIdResponse.class.getClassLoader());
        return (VDARHudIdResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCheckHudUserID() {
        return this.CheckHudUserID;
    }

    public void setCheckHudUserID(int i2) {
        this.CheckHudUserID = i2;
    }

    public String toString() {
        return "VDARHudId{CheckHudUserID=" + this.CheckHudUserID + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.CheckHudUserID);
    }

    protected VDARHudIdResponse(Parcel parcel) {
        this.CheckHudUserID = parcel.readInt();
    }
}
