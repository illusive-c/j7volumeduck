package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsHealthResult implements Parcelable {
    public static final Parcelable.Creator<VDDmsHealthResult> CREATOR = new Parcelable.Creator<VDDmsHealthResult>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsHealthResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsHealthResult createFromParcel(Parcel parcel) {
            return new VDDmsHealthResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsHealthResult[] newArray(int i2) {
            return new VDDmsHealthResult[i2];
        }
    };
    private int bloodOxygenResult;
    private int diastolicPressure;
    private float heartRateResult;
    private float heartRateVarResult;
    private int respiratoryRateResult;
    private int systolicPressure;

    public VDDmsHealthResult() {
    }

    public static VDEvent createEvent(int i2, VDDmsHealthResult vDDmsHealthResult) {
        return new VDEvent(i2, createPayload(vDDmsHealthResult));
    }

    public static Bundle createPayload(VDDmsHealthResult vDDmsHealthResult) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsHealthResult.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsHealthResult);
        return bundle;
    }

    public static VDDmsHealthResult getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsHealthResult.class.getClassLoader());
        return (VDDmsHealthResult) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBloodOxygenResult() {
        return this.bloodOxygenResult;
    }

    public int getDiastolicPressure() {
        return this.diastolicPressure;
    }

    public float getHeartRateResult() {
        return this.heartRateResult;
    }

    public float getHeartRateVarResult() {
        return this.heartRateVarResult;
    }

    public int getRespiratoryRateResult() {
        return this.respiratoryRateResult;
    }

    public int getSystolicPressure() {
        return this.systolicPressure;
    }

    public void setBloodOxygenResult(int i2) {
        this.bloodOxygenResult = i2;
    }

    public void setDiastolicPressure(int i2) {
        this.diastolicPressure = i2;
    }

    public void setHeartRateResult(float f2) {
        this.heartRateResult = f2;
    }

    public void setHeartRateVarResult(float f2) {
        this.heartRateVarResult = f2;
    }

    public void setRespiratoryRateResult(int i2) {
        this.respiratoryRateResult = i2;
    }

    public void setSystolicPressure(int i2) {
        this.systolicPressure = i2;
    }

    public String toString() {
        return "VDDmsHealthResult{heartRateResult=" + this.heartRateResult + ", heartRateVarResult=" + this.heartRateVarResult + ", respiratoryRateResult=" + this.respiratoryRateResult + ", diastolicPressure=" + this.diastolicPressure + ", systolicPressure=" + this.systolicPressure + ", bloodOxygenResult=" + this.bloodOxygenResult + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.heartRateResult);
        parcel.writeFloat(this.heartRateVarResult);
        parcel.writeInt(this.respiratoryRateResult);
        parcel.writeInt(this.diastolicPressure);
        parcel.writeInt(this.systolicPressure);
        parcel.writeInt(this.bloodOxygenResult);
    }

    protected VDDmsHealthResult(Parcel parcel) {
        this.heartRateResult = parcel.readFloat();
        this.heartRateVarResult = parcel.readFloat();
        this.respiratoryRateResult = parcel.readInt();
        this.diastolicPressure = parcel.readInt();
        this.systolicPressure = parcel.readInt();
        this.bloodOxygenResult = parcel.readInt();
    }
}
