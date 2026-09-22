package com.desaysv.ivi.vdb.event.id.dsp.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import com.desaysv.ivi.vdb.event.base.VDValue;

/* loaded from: classes.dex */
public class VDDspSoundField implements Parcelable {
    public static final Parcelable.Creator<VDDspSoundField> CREATOR = new Parcelable.Creator<VDDspSoundField>() { // from class: com.desaysv.ivi.vdb.event.id.dsp.bean.VDDspSoundField.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspSoundField createFromParcel(Parcel parcel) {
            return new VDDspSoundField(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspSoundField[] newArray(int i2) {
            return new VDDspSoundField[i2];
        }
    };
    private int mDspSoundFieldType = 0;
    private int mDspSoundFieldValue = VDValue.INVALID_INT;

    public VDDspSoundField() {
    }

    public static VDEvent createEvent(int i2, VDDspSoundField vDDspSoundField) {
        return new VDEvent(i2, createPayload(vDDspSoundField));
    }

    public static VDEvent createGetParam(int i2, int i3) {
        VDDspSoundField vDDspSoundField = new VDDspSoundField();
        vDDspSoundField.putDspSoundFieldType(i3);
        return createEvent(i2, vDDspSoundField);
    }

    public static Bundle createPayload(VDDspSoundField vDDspSoundField) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(VDKey.DATA, vDDspSoundField);
        return bundle;
    }

    public static VDDspSoundField getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        return (VDDspSoundField) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mDspSoundFieldType = parcel.readInt();
        this.mDspSoundFieldValue = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDspSoundFieldType() {
        return this.mDspSoundFieldType;
    }

    public int getDspSoundFieldValue() {
        return this.mDspSoundFieldValue;
    }

    public void putDspSoundFieldType(int i2) {
        this.mDspSoundFieldType = i2;
    }

    public void putDspSoundFieldValue(int i2) {
        this.mDspSoundFieldValue = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mDspSoundFieldType);
        parcel.writeInt(this.mDspSoundFieldValue);
    }

    protected VDDspSoundField(Parcel parcel) {
        readFromParcel(parcel);
    }
}
