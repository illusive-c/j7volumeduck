package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDHudSystemStatusResponse implements Parcelable {
    public static final Parcelable.Creator<VDHudSystemStatusResponse> CREATOR = new Parcelable.Creator<VDHudSystemStatusResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDHudSystemStatusResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDHudSystemStatusResponse createFromParcel(Parcel parcel) {
            return new VDHudSystemStatusResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDHudSystemStatusResponse[] newArray(int i2) {
            return new VDHudSystemStatusResponse[i2];
        }
    };
    private int Errordata;
    private int HudSysSts;

    public VDHudSystemStatusResponse() {
        this.HudSysSts = 0;
    }

    public static VDEvent createEvent(int i2, VDHudSystemStatusResponse vDHudSystemStatusResponse) {
        return new VDEvent(i2, createPayload(vDHudSystemStatusResponse));
    }

    public static Bundle createPayload(VDHudSystemStatusResponse vDHudSystemStatusResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDHudSystemStatusResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDHudSystemStatusResponse);
        return bundle;
    }

    public static VDHudSystemStatusResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDHudSystemStatusResponse.class.getClassLoader());
        return (VDHudSystemStatusResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrordata() {
        return this.Errordata;
    }

    public int getHudSysSts() {
        return this.HudSysSts;
    }

    public void setErrordata(int i2) {
        this.Errordata = i2;
    }

    public void setHudSysSts(int i2) {
        this.HudSysSts = i2;
    }

    public String toString() {
        return "VDHudSystemStatusResponse{HudSysSts=" + this.HudSysSts + ", Errordata=" + this.Errordata + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.HudSysSts);
        parcel.writeInt(this.Errordata);
    }

    protected VDHudSystemStatusResponse(Parcel parcel) {
        this.HudSysSts = 0;
        this.HudSysSts = parcel.readInt();
        this.Errordata = parcel.readInt();
    }
}
