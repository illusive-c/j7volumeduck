package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDDABLogoImage implements Parcelable {
    public static final Parcelable.Creator<VDDABLogoImage> CREATOR = new Parcelable.Creator<VDDABLogoImage>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABLogoImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABLogoImage createFromParcel(Parcel parcel) {
            return new VDDABLogoImage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABLogoImage[] newArray(int i2) {
            return new VDDABLogoImage[i2];
        }
    };
    private int frequency;
    private byte[] logoDataList;
    private int logoLen;
    private int serviceComponentId;
    private int serviceId;

    public VDDABLogoImage() {
    }

    public static VDEvent createEvent(int i2, VDDABLogoImage vDDABLogoImage) {
        return new VDEvent(i2, createPayload(vDDABLogoImage));
    }

    public static Bundle createPayload(VDDABLogoImage vDDABLogoImage) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABLogoImage.class.getClassLoader());
        bundle.putParcelable("value", vDDABLogoImage);
        return bundle;
    }

    public static VDDABLogoImage getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABLogoImage.class.getClassLoader());
        return (VDDABLogoImage) vDEvent.getPayload().getParcelable("value");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public byte[] getLogoDataList() {
        return this.logoDataList;
    }

    public int getLogoLen() {
        return this.logoLen;
    }

    public int getServiceComponentId() {
        return this.serviceComponentId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public void putFrequency(int i2) {
        this.frequency = i2;
    }

    public void putLogoDataList(byte[] bArr) {
        this.logoDataList = bArr;
    }

    public void putLogoLen(int i2) {
        this.logoLen = i2;
    }

    public void putServiceComponentId(int i2) {
        this.serviceComponentId = i2;
    }

    public void putServiceId(int i2) {
        this.serviceId = i2;
    }

    public String toString() {
        return "VDDABLogoImage{frequency=" + this.frequency + ", serviceId=" + this.serviceId + ", serviceComponentId=" + this.serviceComponentId + ", logoLen=" + this.logoLen + ", logoDataList=" + Arrays.toString(this.logoDataList) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.frequency);
        parcel.writeInt(this.serviceId);
        parcel.writeInt(this.serviceComponentId);
        parcel.writeInt(this.logoLen);
        parcel.writeByteArray(this.logoDataList);
    }

    protected VDDABLogoImage(Parcel parcel) {
        this.frequency = parcel.readInt();
        this.serviceId = parcel.readInt();
        this.serviceComponentId = parcel.readInt();
        this.logoLen = parcel.readInt();
        this.logoDataList = parcel.createByteArray();
    }
}
