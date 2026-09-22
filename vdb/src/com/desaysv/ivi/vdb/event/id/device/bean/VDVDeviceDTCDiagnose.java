package com.desaysv.ivi.vdb.event.id.device.bean;

import android.os.Bundle;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDBundleParcelable;

/* loaded from: classes.dex */
public class VDVDeviceDTCDiagnose extends VDBundleParcelable {
    private int micID;
    private int value;

    public static VDEvent createEvent(int i2, VDVDeviceDTCDiagnose vDVDeviceDTCDiagnose) {
        return new VDEvent(i2, createPayload(vDVDeviceDTCDiagnose));
    }

    public static VDEvent createGetEvent(int i2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i3);
        return new VDEvent(i2, bundle);
    }

    public static Bundle createPayload(VDVDeviceDTCDiagnose vDVDeviceDTCDiagnose) {
        Bundle bundle = new Bundle();
        vDVDeviceDTCDiagnose.writeToBundle(bundle);
        return bundle;
    }

    public int getMicID() {
        return this.micID;
    }

    public int getValue() {
        return this.value;
    }

    @Override // com.desaysv.ivi.vdb.event.base.VDBundleParcelable
    public void readFromBundle(Bundle bundle) {
        setMicID(bundle.getInt("type"));
        setValue(bundle.getInt("value"));
    }

    public void setMicID(int i2) {
        this.micID = i2;
    }

    public void setValue(int i2) {
        this.value = i2;
    }

    @Override // com.desaysv.ivi.vdb.event.base.VDBundleParcelable
    public void writeToBundle(Bundle bundle) {
        bundle.putInt("type", getMicID());
        bundle.putInt("value", getValue());
    }

    public static VDVDeviceDTCDiagnose getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        VDVDeviceDTCDiagnose vDVDeviceDTCDiagnose = new VDVDeviceDTCDiagnose();
        vDVDeviceDTCDiagnose.readFromBundle(vDEvent.getPayload());
        return vDVDeviceDTCDiagnose;
    }
}
