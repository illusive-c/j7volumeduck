package com.desaysv.ivi.vdb.event.id.dsp.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import com.desaysv.ivi.vdb.event.base.VDValue;

/* loaded from: classes.dex */
public class VDDspChannel implements Parcelable {
    public static final Parcelable.Creator<VDDspChannel> CREATOR = new Parcelable.Creator<VDDspChannel>() { // from class: com.desaysv.ivi.vdb.event.id.dsp.bean.VDDspChannel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspChannel createFromParcel(Parcel parcel) {
            return new VDDspChannel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDspChannel[] newArray(int i2) {
            return new VDDspChannel[i2];
        }
    };
    private int mDspChannelType = 20;
    private int mDspChannelValue = VDValue.INVALID_INT;

    public VDDspChannel() {
    }

    public static VDEvent createEvent(int i2, VDDspChannel vDDspChannel) {
        return new VDEvent(i2, createPayload(vDDspChannel));
    }

    public static VDEvent createGetParam(int i2, int i3) {
        VDDspChannel vDDspChannel = new VDDspChannel();
        vDDspChannel.putDspChannelType(i3);
        return createEvent(i2, vDDspChannel);
    }

    public static Bundle createPayload(VDDspChannel vDDspChannel) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(VDKey.DATA, vDDspChannel);
        return bundle;
    }

    public static VDDspChannel getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        return (VDDspChannel) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mDspChannelType = parcel.readInt();
        this.mDspChannelValue = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDspChannelType() {
        return this.mDspChannelType;
    }

    public int getDspChannelValue() {
        return this.mDspChannelValue;
    }

    public void putDspChannelType(int i2) {
        this.mDspChannelType = i2;
    }

    public void putDspChannelValue(int i2) {
        this.mDspChannelValue = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mDspChannelType);
        parcel.writeInt(this.mDspChannelValue);
    }

    protected VDDspChannel(Parcel parcel) {
        readFromParcel(parcel);
    }
}
