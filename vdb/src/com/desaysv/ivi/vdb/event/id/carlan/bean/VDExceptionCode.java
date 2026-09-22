package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDExceptionCode implements Parcelable {
    public static final Parcelable.Creator<VDExceptionCode> CREATOR = new Parcelable.Creator<VDExceptionCode>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDExceptionCode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDExceptionCode createFromParcel(Parcel parcel) {
            return new VDExceptionCode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDExceptionCode[] newArray(int i2) {
            return new VDExceptionCode[i2];
        }
    };
    private String exception_code;
    private String exception_time;
    private String exception_type;
    private String isException;

    public VDExceptionCode() {
    }

    public static VDEvent createEvent(int i2, VDExceptionCode vDExceptionCode) {
        return new VDEvent(i2, createPayload(vDExceptionCode));
    }

    public static Bundle createPayload(VDExceptionCode vDExceptionCode) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDExceptionCode.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDExceptionCode);
        return bundle;
    }

    public static VDExceptionCode getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDExceptionCode.class.getClassLoader());
        return (VDExceptionCode) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getException_code() {
        return this.exception_code;
    }

    public String getException_time() {
        return this.exception_time;
    }

    public String getException_type() {
        return this.exception_type;
    }

    public String getIsException() {
        return this.isException;
    }

    public void setException_code(String str) {
        this.exception_code = str;
    }

    public void setException_time(String str) {
        this.exception_time = str;
    }

    public void setException_type(String str) {
        this.exception_type = str;
    }

    public void setIsException(String str) {
        this.isException = str;
    }

    public String toString() {
        return "VDExceptionCode{exception_time='" + this.exception_time + "', exception_code='" + this.exception_code + "', isException='" + this.isException + "', exception_type='" + this.exception_type + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.exception_time);
        parcel.writeString(this.exception_code);
        parcel.writeString(this.isException);
        parcel.writeString(this.exception_type);
    }

    protected VDExceptionCode(Parcel parcel) {
        this.exception_time = parcel.readString();
        this.exception_code = parcel.readString();
        this.isException = parcel.readString();
        this.exception_type = parcel.readString();
    }
}
