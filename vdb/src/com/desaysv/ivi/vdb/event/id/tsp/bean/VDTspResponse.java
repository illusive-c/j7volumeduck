package com.desaysv.ivi.vdb.event.id.tsp.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDTspResponse implements Parcelable {
    public static final Parcelable.Creator<VDTspResponse> CREATOR = new Parcelable.Creator<VDTspResponse>() { // from class: com.desaysv.ivi.vdb.event.id.tsp.bean.VDTspResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTspResponse createFromParcel(Parcel parcel) {
            return new VDTspResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTspResponse[] newArray(int i2) {
            return new VDTspResponse[i2];
        }
    };
    private boolean isResponse;
    private String json;

    public VDTspResponse() {
        this.isResponse = false;
    }

    public static VDEvent createEvent(int i2, VDTspResponse vDTspResponse) {
        return new VDEvent(i2, createPayload(vDTspResponse));
    }

    public static Bundle createPayload(VDTspResponse vDTspResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTspResponse.class.getClassLoader());
        bundle.putParcelable("info", vDTspResponse);
        return bundle;
    }

    public static VDTspResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTspResponse.class.getClassLoader());
        return (VDTspResponse) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getJson() {
        return this.json;
    }

    public boolean isResponse() {
        return this.isResponse;
    }

    public void setJson(String str) {
        this.json = str;
    }

    public void setResponse(boolean z2) {
        this.isResponse = z2;
    }

    public String toString() {
        return "VDTspResponse{isResponse=" + this.isResponse + ", json='" + this.json + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.isResponse ? (byte) 1 : (byte) 0);
        parcel.writeString(this.json);
    }

    protected VDTspResponse(Parcel parcel) {
        this.isResponse = false;
        this.isResponse = parcel.readByte() != 0;
        this.json = parcel.readString();
    }
}
