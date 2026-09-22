package com.desaysv.ivi.vdb.event.id.dsp.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import com.desaysv.ivi.vdb.event.base.VDValue;

/* loaded from: classes.dex */
public class VDDspBmt implements Parcelable {
    public static final Parcelable.Creator<VDDspBmt> CREATOR = new Parcelable.Creator<VDDspBmt>() { // from class: com.desaysv.ivi.vdb.event.id.dsp.bean.VDDspBmt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspBmt createFromParcel(Parcel parcel) {
            return new VDDspBmt(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspBmt[] newArray(int i2) {
            return new VDDspBmt[i2];
        }
    };
    private int mDspBmtType = 1;
    private int mDspBmtValue = VDValue.INVALID_INT;

    public VDDspBmt() {
    }

    public static VDEvent createEvent(int i2, VDDspBmt vDDspBmt) {
        return new VDEvent(i2, createPayload(vDDspBmt));
    }

    public static VDEvent createGetParam(int i2, int i3) {
        VDDspBmt vDDspBmt = new VDDspBmt();
        vDDspBmt.putDspBmtType(i3);
        return createEvent(i2, vDDspBmt);
    }

    public static Bundle createPayload(VDDspBmt vDDspBmt) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(VDKey.DATA, vDDspBmt);
        return bundle;
    }

    public static VDDspBmt getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        return (VDDspBmt) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mDspBmtType = parcel.readInt();
        this.mDspBmtValue = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDspBmtType() {
        return this.mDspBmtType;
    }

    public int getDspBmtValue() {
        return this.mDspBmtValue;
    }

    public void putDspBmtType(int i2) {
        this.mDspBmtType = i2;
    }

    public void putDspBmtValue(int i2) {
        this.mDspBmtValue = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mDspBmtType);
        parcel.writeInt(this.mDspBmtValue);
    }

    protected VDDspBmt(Parcel parcel) {
        readFromParcel(parcel);
    }
}
