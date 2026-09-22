package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDRadioListRequest implements Parcelable {
    public static final Parcelable.Creator<VDRadioListRequest> CREATOR = new Parcelable.Creator<VDRadioListRequest>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioListRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioListRequest createFromParcel(Parcel parcel) {
            return new VDRadioListRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioListRequest[] newArray(int i2) {
            return new VDRadioListRequest[i2];
        }
    };
    private int Band;
    private int EnEndIndex;
    private int StartIndex;

    public VDRadioListRequest() {
    }

    public static VDEvent createEvent(int i2, VDRadioListRequest vDRadioListRequest) {
        return new VDEvent(i2, createPayload(vDRadioListRequest));
    }

    public static Bundle createPayload(VDRadioListRequest vDRadioListRequest) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioListRequest.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioListRequest);
        return bundle;
    }

    public static VDRadioListRequest getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioListRequest.class.getClassLoader());
        return (VDRadioListRequest) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.Band;
    }

    public int getEnEndIndex() {
        return this.EnEndIndex;
    }

    public int getStartIndex() {
        return this.StartIndex;
    }

    public void setBand(int i2) {
        this.Band = i2;
    }

    public void setEnEndIndex(int i2) {
        this.EnEndIndex = i2;
    }

    public void setStartIndex(int i2) {
        this.StartIndex = i2;
    }

    public String toString() {
        return "VDRadioListRequest{Band=" + this.Band + ", StartIndex=" + this.StartIndex + ", EnEndIndex=" + this.EnEndIndex + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Band);
        parcel.writeInt(this.StartIndex);
        parcel.writeInt(this.EnEndIndex);
    }

    protected VDRadioListRequest(Parcel parcel) {
        this.Band = parcel.readInt();
        this.StartIndex = parcel.readInt();
        this.EnEndIndex = parcel.readInt();
    }
}
