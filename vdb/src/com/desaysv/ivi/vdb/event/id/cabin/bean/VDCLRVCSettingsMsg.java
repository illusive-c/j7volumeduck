package com.desaysv.ivi.vdb.event.id.cabin.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDCLRVCSettingsMsg {
    private boolean result;
    private String settingId = null;
    private String settingValue = null;

    public static VDEvent createEvent(int i2, VDCLRVCSettingsMsg vDCLRVCSettingsMsg) {
        return new VDEvent(i2, createPayload(vDCLRVCSettingsMsg));
    }

    public static VDEvent createGetEvent(int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str);
        return new VDEvent(i2, bundle);
    }

    public static Bundle createPayload(VDCLRVCSettingsMsg vDCLRVCSettingsMsg) {
        Bundle bundle = new Bundle();
        bundle.putString("id", vDCLRVCSettingsMsg.getSettingId());
        bundle.putString("value", vDCLRVCSettingsMsg.getSettingValue());
        return bundle;
    }

    public static VDCLRVCSettingsMsg getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDCLRVCSettingsMsg vDCLRVCSettingsMsg = new VDCLRVCSettingsMsg();
        vDCLRVCSettingsMsg.setSettingValue(vDEvent.getPayload().getString("value"));
        return vDCLRVCSettingsMsg;
    }

    public String getSettingId() {
        return this.settingId;
    }

    public String getSettingValue() {
        return this.settingValue;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean z2) {
        this.result = z2;
    }

    public void setSettingId(String str) {
        this.settingId = str;
    }

    public void setSettingValue(String str) {
        this.settingValue = str;
    }

    public String toString() {
        return "VDCLRVCSettingsMsg{result=" + this.result + ", settingId='" + this.settingId + "', settingValue='" + this.settingValue + "'}";
    }
}
