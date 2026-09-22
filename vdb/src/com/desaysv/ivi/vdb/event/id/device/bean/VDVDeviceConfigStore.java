package com.desaysv.ivi.vdb.event.id.device.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDBundleParcelable;

/* loaded from: classes.dex */
public class VDVDeviceConfigStore extends VDBundleParcelable {
    private String key = null;
    private String value = null;

    public static VDEvent createEvent(int i2, VDVDeviceConfigStore vDVDeviceConfigStore) {
        return new VDEvent(i2, createPayload(vDVDeviceConfigStore));
    }

    public static VDEvent createGetEvent(int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        return new VDEvent(i2, bundle);
    }

    public static Bundle createPayload(VDVDeviceConfigStore vDVDeviceConfigStore) {
        Bundle bundle = new Bundle();
        vDVDeviceConfigStore.writeToBundle(bundle);
        return bundle;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    @Override // com.desaysv.ivi.vdb.event.base.VDBundleParcelable
    public void readFromBundle(Bundle bundle) {
        setKey(bundle.getString("type"));
        setValue(bundle.getString("value"));
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    @Override // com.desaysv.ivi.vdb.event.base.VDBundleParcelable
    public void writeToBundle(Bundle bundle) {
        bundle.putString("type", getKey());
        bundle.putString("value", getValue());
    }

    public static VDVDeviceConfigStore getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDVDeviceConfigStore vDVDeviceConfigStore = new VDVDeviceConfigStore();
        vDVDeviceConfigStore.readFromBundle(vDEvent.getPayload());
        return vDVDeviceConfigStore;
    }
}
