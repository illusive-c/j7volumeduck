package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDDABAlbumImage implements Parcelable {
    public static final Parcelable.Creator<VDDABAlbumImage> CREATOR = new Parcelable.Creator<VDDABAlbumImage>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABAlbumImage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAlbumImage createFromParcel(Parcel parcel) {
            return new VDDABAlbumImage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAlbumImage[] newArray(int i2) {
            return new VDDABAlbumImage[i2];
        }
    };
    private int frequency;
    private int serviceComponentId;
    private int serviceId;
    private byte[] slsDataList;
    private int slsLen;

    public VDDABAlbumImage() {
    }

    public static VDEvent createEvent(int i2, VDDABAlbumImage vDDABAlbumImage) {
        return new VDEvent(i2, createPayload(vDDABAlbumImage));
    }

    public static Bundle createPayload(VDDABAlbumImage vDDABAlbumImage) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABAlbumImage.class.getClassLoader());
        bundle.putParcelable("value", vDDABAlbumImage);
        return bundle;
    }

    public static VDDABAlbumImage getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABAlbumImage.class.getClassLoader());
        return (VDDABAlbumImage) vDEvent.getPayload().getParcelable("value");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getServiceComponentId() {
        return this.serviceComponentId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public byte[] getSlsDataList() {
        return this.slsDataList;
    }

    public int getSlsLen() {
        return this.slsLen;
    }

    public void putFrequency(int i2) {
        this.frequency = i2;
    }

    public void putServiceComponentId(int i2) {
        this.serviceComponentId = i2;
    }

    public void putServiceId(int i2) {
        this.serviceId = i2;
    }

    public void putSlsDataList(byte[] bArr) {
        this.slsDataList = bArr;
    }

    public void putSlsLen(int i2) {
        this.slsLen = i2;
    }

    public String toString() {
        return "VDDABAlbumImage{frequency=" + this.frequency + ", serviceId=" + this.serviceId + ", serviceComponentId=" + this.serviceComponentId + ", slsLen=" + this.slsLen + ", slsDataList=" + Arrays.toString(this.slsDataList) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.frequency);
        parcel.writeInt(this.serviceId);
        parcel.writeInt(this.serviceComponentId);
        parcel.writeInt(this.slsLen);
        parcel.writeByteArray(this.slsDataList);
    }

    protected VDDABAlbumImage(Parcel parcel) {
        this.frequency = parcel.readInt();
        this.serviceId = parcel.readInt();
        this.serviceComponentId = parcel.readInt();
        this.slsLen = parcel.readInt();
        this.slsDataList = parcel.createByteArray();
    }
}
