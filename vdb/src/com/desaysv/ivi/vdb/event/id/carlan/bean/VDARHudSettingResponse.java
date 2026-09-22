package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudSettingResponse implements Parcelable {
    public static final Parcelable.Creator<VDARHudSettingResponse> CREATOR = new Parcelable.Creator<VDARHudSettingResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudSettingResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudSettingResponse createFromParcel(Parcel parcel) {
            return new VDARHudSettingResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudSettingResponse[] newArray(int i2) {
            return new VDARHudSettingResponse[i2];
        }
    };
    private int Hud_EnPinFeedback;

    public VDARHudSettingResponse() {
        this.Hud_EnPinFeedback = 0;
    }

    public static VDEvent createEvent(int i2, VDARHudSettingResponse vDARHudSettingResponse) {
        return new VDEvent(i2, createPayload(vDARHudSettingResponse));
    }

    public static Bundle createPayload(VDARHudSettingResponse vDARHudSettingResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudSettingResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudSettingResponse);
        return bundle;
    }

    public static VDARHudSettingResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudSettingResponse.class.getClassLoader());
        return (VDARHudSettingResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHud_EnPinFeedback() {
        return this.Hud_EnPinFeedback;
    }

    public void setHud_EnPinFeedback(int i2) {
        this.Hud_EnPinFeedback = i2;
    }

    public String toString() {
        return "VDARHudSettingResponse{Hud_EnPinFeedback=" + this.Hud_EnPinFeedback + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Hud_EnPinFeedback);
    }

    protected VDARHudSettingResponse(Parcel parcel) {
        this.Hud_EnPinFeedback = 0;
        this.Hud_EnPinFeedback = parcel.readInt();
    }
}
