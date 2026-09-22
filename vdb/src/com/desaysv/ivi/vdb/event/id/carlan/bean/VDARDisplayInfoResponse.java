package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDARDisplayInfoResponse implements Parcelable {
    public static final Parcelable.Creator<VDARDisplayInfoResponse> CREATOR = new Parcelable.Creator<VDARDisplayInfoResponse>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDARDisplayInfoResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARDisplayInfoResponse createFromParcel(Parcel parcel) {
            return new VDARDisplayInfoResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDARDisplayInfoResponse[] newArray(int i2) {
            return new VDARDisplayInfoResponse[i2];
        }
    };
    private int ARHUD_Calibration_Sts;
    private int AdasDisplaySwitchFeedback;
    private int AutoSetBrightnessFeedback;
    private int DisplaySwitchFeedback;
    private int LanguageFeedback;
    private int ManualSetBrightnessFeedback;
    private int ManualSetHeightFeedback;
    private int NaviDisplaySwitchFeedback;
    private int PhoneDisplaySwitchFeedback;
    private int ThemeModeFeedback;

    protected VDARDisplayInfoResponse(Parcel parcel) {
        this.DisplaySwitchFeedback = 0;
        this.ThemeModeFeedback = 0;
        this.PhoneDisplaySwitchFeedback = 0;
        this.NaviDisplaySwitchFeedback = 0;
        this.AdasDisplaySwitchFeedback = 0;
        this.LanguageFeedback = 0;
        this.ARHUD_Calibration_Sts = 0;
        this.DisplaySwitchFeedback = parcel.readInt();
        this.ManualSetBrightnessFeedback = parcel.readInt();
        this.AutoSetBrightnessFeedback = parcel.readInt();
        this.ManualSetHeightFeedback = parcel.readInt();
        this.ThemeModeFeedback = parcel.readInt();
        this.PhoneDisplaySwitchFeedback = parcel.readInt();
        this.NaviDisplaySwitchFeedback = parcel.readInt();
        this.AdasDisplaySwitchFeedback = parcel.readInt();
        this.LanguageFeedback = parcel.readInt();
        this.ARHUD_Calibration_Sts = parcel.readInt();
    }

    public static VDEvent createEvent(int i2, VDARDisplayInfoResponse vDARDisplayInfoResponse) {
        return new VDEvent(i2, createPayload(vDARDisplayInfoResponse));
    }

    public static Bundle createPayload(VDARDisplayInfoResponse vDARDisplayInfoResponse) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDARDisplayInfoResponse.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDARDisplayInfoResponse);
        return bundle;
    }

    public static VDARDisplayInfoResponse getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDARDisplayInfoResponse.class.getClassLoader());
        return (VDARDisplayInfoResponse) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getARHUD_Calibration_Sts() {
        return this.ARHUD_Calibration_Sts;
    }

    public int getAdasDisplaySwitchFeedback() {
        return this.AdasDisplaySwitchFeedback;
    }

    public int getAutoSetBrightnessFeedback() {
        return this.AutoSetBrightnessFeedback;
    }

    public int getDisplaySwitchFeedback() {
        return this.DisplaySwitchFeedback;
    }

    public int getLanguageFeedback() {
        return this.LanguageFeedback;
    }

    public int getManualSetBrightnessFeedback() {
        return this.ManualSetBrightnessFeedback;
    }

    public int getManualSetHeightFeedback() {
        return this.ManualSetHeightFeedback;
    }

    public int getNaviDisplaySwitchFeedback() {
        return this.NaviDisplaySwitchFeedback;
    }

    public int getPhoneDisplaySwitchFeedback() {
        return this.PhoneDisplaySwitchFeedback;
    }

    public int getThemeModeFeedback() {
        return this.ThemeModeFeedback;
    }

    public void setARHUD_Calibration_Sts(int i2) {
        this.ARHUD_Calibration_Sts = i2;
    }

    public void setAdasDisplaySwitchFeedback(int i2) {
        this.AdasDisplaySwitchFeedback = i2;
    }

    public void setAutoSetBrightnessFeedback(int i2) {
        this.AutoSetBrightnessFeedback = i2;
    }

    public void setDisplaySwitchFeedback(int i2) {
        this.DisplaySwitchFeedback = i2;
    }

    public void setLanguageFeedback(int i2) {
        this.LanguageFeedback = i2;
    }

    public void setManualSetBrightnessFeedback(int i2) {
        this.ManualSetBrightnessFeedback = i2;
    }

    public void setManualSetHeightFeedback(int i2) {
        this.ManualSetHeightFeedback = i2;
    }

    public void setNaviDisplaySwitchFeedback(int i2) {
        this.NaviDisplaySwitchFeedback = i2;
    }

    public void setPhoneDisplaySwitchFeedback(int i2) {
        this.PhoneDisplaySwitchFeedback = i2;
    }

    public void setThemeModeFeedback(int i2) {
        this.ThemeModeFeedback = i2;
    }

    public String toString() {
        return "VDARDisplayInfo{DisplaySwitchFeedback=" + this.DisplaySwitchFeedback + ", ManualSetBrightnessFeedback=" + this.ManualSetBrightnessFeedback + ", AutoSetBrightnessFeedback=" + this.AutoSetBrightnessFeedback + ", ManualSetHeightFeedback=" + this.ManualSetHeightFeedback + ", ThemeModeFeedback=" + this.ThemeModeFeedback + ", PhoneDisplaySwitchFeedback=" + this.PhoneDisplaySwitchFeedback + ", NaviDisplaySwitchFeedback=" + this.NaviDisplaySwitchFeedback + ", AdasDisplaySwitchFeedback=" + this.AdasDisplaySwitchFeedback + ", LanguageFeedback=" + this.LanguageFeedback + ", ARHUD_Calibration_Sts=" + this.ARHUD_Calibration_Sts + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.DisplaySwitchFeedback);
        parcel.writeInt(this.ManualSetBrightnessFeedback);
        parcel.writeInt(this.AutoSetBrightnessFeedback);
        parcel.writeInt(this.ManualSetHeightFeedback);
        parcel.writeInt(this.ThemeModeFeedback);
        parcel.writeInt(this.PhoneDisplaySwitchFeedback);
        parcel.writeInt(this.NaviDisplaySwitchFeedback);
        parcel.writeInt(this.AdasDisplaySwitchFeedback);
        parcel.writeInt(this.LanguageFeedback);
        parcel.writeInt(this.ARHUD_Calibration_Sts);
    }
}
