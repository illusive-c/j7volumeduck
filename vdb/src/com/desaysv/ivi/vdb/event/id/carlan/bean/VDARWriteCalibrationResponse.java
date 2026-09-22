package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARWriteCalibrationResponse implements Parcelable {
    public static final Parcelable.Creator<VDARWriteCalibrationResponse> CREATOR = new Parcelable.Creator<VDARWriteCalibrationResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARWriteCalibrationResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARWriteCalibrationResponse createFromParcel(Parcel parcel) {
            return new VDARWriteCalibrationResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARWriteCalibrationResponse[] newArray(int i2) {
            return new VDARWriteCalibrationResponse[i2];
        }
    };
    private int WriteCalibrationToDmcReq;

    public VDARWriteCalibrationResponse() {
        this.WriteCalibrationToDmcReq = 0;
    }

    public static VDEvent createEvent(int i2, VDARWriteCalibrationResponse vDARWriteCalibrationResponse) {
        return new VDEvent(i2, createPayload(vDARWriteCalibrationResponse));
    }

    public static Bundle createPayload(VDARWriteCalibrationResponse vDARWriteCalibrationResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARWriteCalibrationResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARWriteCalibrationResponse);
        return bundle;
    }

    public static VDARWriteCalibrationResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARWriteCalibrationResponse.class.getClassLoader());
        return (VDARWriteCalibrationResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getWriteCalibrationToDmcReq() {
        return this.WriteCalibrationToDmcReq;
    }

    public void setWriteCalibrationToDmcReq(int i2) {
        this.WriteCalibrationToDmcReq = i2;
    }

    public String toString() {
        return "VDARWriteCalibrationResponse{WriteCalibrationToDmcReq=" + this.WriteCalibrationToDmcReq + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.WriteCalibrationToDmcReq);
    }

    protected VDARWriteCalibrationResponse(Parcel parcel) {
        this.WriteCalibrationToDmcReq = 0;
        this.WriteCalibrationToDmcReq = parcel.readInt();
    }
}
