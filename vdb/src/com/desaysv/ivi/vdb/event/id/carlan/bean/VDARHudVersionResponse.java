package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARHudVersionResponse implements Parcelable {
    public static final Parcelable.Creator<VDARHudVersionResponse> CREATOR = new Parcelable.Creator<VDARHudVersionResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARHudVersionResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudVersionResponse createFromParcel(Parcel parcel) {
            return new VDARHudVersionResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARHudVersionResponse[] newArray(int i2) {
            return new VDARHudVersionResponse[i2];
        }
    };
    private String ARHUD_ALG_Ver;
    private String ARHUD_BL_Ver;
    private String ARHUD_Hw_Ver;
    private String ARHUD_Sw_Ver;

    protected VDARHudVersionResponse(Parcel parcel) {
        this.ARHUD_BL_Ver = parcel.readString();
        this.ARHUD_Hw_Ver = parcel.readString();
        this.ARHUD_Sw_Ver = parcel.readString();
        this.ARHUD_ALG_Ver = parcel.readString();
    }

    public static VDEvent createEvent(int i2, VDARHudVersionResponse vDARHudVersionResponse) {
        return new VDEvent(i2, createPayload(vDARHudVersionResponse));
    }

    public static Bundle createPayload(VDARHudVersionResponse vDARHudVersionResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARHudVersionResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARHudVersionResponse);
        return bundle;
    }

    public static VDARHudVersionResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARHudVersionResponse.class.getClassLoader());
        return (VDARHudVersionResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getARHUD_ALG_Ver() {
        return this.ARHUD_ALG_Ver;
    }

    public String getARHUD_BL_Ver() {
        return this.ARHUD_BL_Ver;
    }

    public String getARHUD_Hw_Ver() {
        return this.ARHUD_Hw_Ver;
    }

    public String getARHUD_Sw_Ver() {
        return this.ARHUD_Sw_Ver;
    }

    public void setARHUD_ALG_Ver(String str) {
        this.ARHUD_ALG_Ver = str;
    }

    public void setARHUD_BL_Ver(String str) {
        this.ARHUD_BL_Ver = str;
    }

    public void setARHUD_Hw_Ver(String str) {
        this.ARHUD_Hw_Ver = str;
    }

    public void setARHUD_Sw_Ver(String str) {
        this.ARHUD_Sw_Ver = str;
    }

    public String toString() {
        return "VDARHudVersionControl{ARHUD_BL_Ver='" + this.ARHUD_BL_Ver + "', ARHUD_Hw_Ver='" + this.ARHUD_Hw_Ver + "', ARHUD_Sw_Ver='" + this.ARHUD_Sw_Ver + "', ARHUD_ALG_Ver='" + this.ARHUD_ALG_Ver + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.ARHUD_BL_Ver);
        parcel.writeString(this.ARHUD_Hw_Ver);
        parcel.writeString(this.ARHUD_Sw_Ver);
        parcel.writeString(this.ARHUD_ALG_Ver);
    }
}
