package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABRadioText implements Parcelable {
    public static final Parcelable.Creator<VDDABRadioText> CREATOR = new Parcelable.Creator<VDDABRadioText>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABRadioText.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABRadioText createFromParcel(Parcel parcel) {
            return new VDDABRadioText(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABRadioText[] newArray(int i2) {
            return new VDDABRadioText[i2];
        }
    };
    private String dynamicLabel;
    private String dynamicPlusLabel;

    public VDDABRadioText() {
    }

    public static VDEvent createEvent(int i2, VDDABRadioText vDDABRadioText) {
        return new VDEvent(i2, createPayload(vDDABRadioText));
    }

    public static Bundle createPayload(VDDABRadioText vDDABRadioText) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABRadioText.class.getClassLoader());
        bundle.putParcelable("status", vDDABRadioText);
        return bundle;
    }

    public static VDDABRadioText getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABRadioText.class.getClassLoader());
        return (VDDABRadioText) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDynamicLabel() {
        return this.dynamicLabel;
    }

    public String getDynamicPlusLabel() {
        return this.dynamicPlusLabel;
    }

    public void putDynamicLabel(String str) {
        this.dynamicLabel = str;
    }

    public void putDynamicPlusLabel(String str) {
        this.dynamicPlusLabel = str;
    }

    public String toString() {
        return "VDDABRadioText{dynamicLabel='" + this.dynamicLabel + "', dynamicPlusLabel='" + this.dynamicPlusLabel + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.dynamicLabel);
        parcel.writeString(this.dynamicPlusLabel);
    }

    protected VDDABRadioText(Parcel parcel) {
        this.dynamicLabel = parcel.readString();
        this.dynamicPlusLabel = parcel.readString();
    }
}
