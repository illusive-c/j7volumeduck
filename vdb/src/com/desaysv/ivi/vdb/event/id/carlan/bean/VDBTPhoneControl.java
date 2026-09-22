package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTPhoneControl implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneControl> CREATOR = new Parcelable.Creator<VDBTPhoneControl>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneControl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneControl createFromParcel(Parcel parcel) {
            return new VDBTPhoneControl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneControl[] newArray(int i2) {
            return new VDBTPhoneControl[i2];
        }
    };
    private int Index;
    private int OperateType;

    public VDBTPhoneControl() {
    }

    public static VDEvent createEvent(int i2, VDBTPhoneControl vDBTPhoneControl) {
        return new VDEvent(i2, createPayload(vDBTPhoneControl));
    }

    public static Bundle createPayload(VDBTPhoneControl vDBTPhoneControl) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneControl.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneControl);
        return bundle;
    }

    public static VDBTPhoneControl getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneControl.class.getClassLoader());
        return (VDBTPhoneControl) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getIndex() {
        return this.Index;
    }

    public int getOperateType() {
        return this.OperateType;
    }

    public void setIndex(int i2) {
        this.Index = i2;
    }

    public void setOperateType(int i2) {
        this.OperateType = i2;
    }

    public String toString() {
        return "VDBTPhoneControl{OperateType=" + this.OperateType + ", Index=" + this.Index + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.OperateType);
        parcel.writeInt(this.Index);
    }

    protected VDBTPhoneControl(Parcel parcel) {
        this.OperateType = parcel.readInt();
        this.Index = parcel.readInt();
    }
}
