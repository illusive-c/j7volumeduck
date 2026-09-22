package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTDialInfo implements Parcelable {
    public static final Parcelable.Creator<VDBTDialInfo> CREATOR = new Parcelable.Creator<VDBTDialInfo>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTDialInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDialInfo createFromParcel(Parcel parcel) {
            return new VDBTDialInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTDialInfo[] newArray(int i2) {
            return new VDBTDialInfo[i2];
        }
    };
    private boolean mInBandRing;
    private boolean mMultiParty;
    private boolean mOutGoing;
    private String mName = null;
    private String mNumber = null;
    private String mAddress = null;
    private long mTime = 0;
    private String mUUID = null;
    private int mId = 0;
    private int mState = 0;
    private int mRecordType = 0;
    private int mNumberType = 1;
    private byte[] mPortrait = null;

    public VDBTDialInfo() {
    }

    public static VDEvent createEvent(int i2, VDBTDialInfo vDBTDialInfo) {
        return new VDEvent(i2, createPayload(vDBTDialInfo));
    }

    public static Bundle createPayload(VDBTDialInfo vDBTDialInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDialInfo.class.getClassLoader());
        bundle.putParcelable("info", vDBTDialInfo);
        return bundle;
    }

    public static ArrayList<VDBTDialInfo> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDialInfo.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTDialInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTDialInfo.class.getClassLoader());
        return (VDBTDialInfo) vDEvent.getPayload().getParcelable("info");
    }

    private void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
        this.mNumber = parcel.readString();
        this.mAddress = parcel.readString();
        this.mTime = parcel.readLong();
        this.mUUID = parcel.readString();
        this.mId = parcel.readInt();
        this.mState = parcel.readInt();
        this.mRecordType = parcel.readInt();
        this.mNumberType = parcel.readInt();
        this.mPortrait = parcel.createByteArray();
        this.mInBandRing = parcel.readByte() != 0;
        this.mMultiParty = parcel.readByte() != 0;
        this.mOutGoing = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public int getNumberType() {
        return this.mNumberType;
    }

    public byte[] getPortrait() {
        return this.mPortrait;
    }

    public int getRecordType() {
        return this.mRecordType;
    }

    public int getState() {
        return this.mState;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getUUID() {
        return this.mUUID;
    }

    public boolean isInBandRing() {
        return this.mInBandRing;
    }

    public boolean isMultiParty() {
        return this.mMultiParty;
    }

    public boolean isOutGoing() {
        return this.mOutGoing;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putId(int i2) {
        this.mId = i2;
    }

    public void putName(String str) {
        this.mName = str;
    }

    public void putNumber(String str) {
        this.mNumber = str;
    }

    public void putNumberType(int i2) {
        this.mNumberType = i2;
    }

    public void putPortrait(byte[] bArr) {
        this.mPortrait = bArr;
    }

    public void putRecordType(int i2) {
        this.mRecordType = i2;
    }

    public void putState(int i2) {
        this.mState = i2;
    }

    public void putTime(long j2) {
        this.mTime = j2;
    }

    public void putUUID(String str) {
        this.mUUID = str;
    }

    public void setInBandRing(boolean z2) {
        this.mInBandRing = z2;
    }

    public void setMultiParty(boolean z2) {
        this.mMultiParty = z2;
    }

    public void setOutGoing(boolean z2) {
        this.mOutGoing = z2;
    }

    public String toString() {
        return "VDBTDialInfo{name=" + this.mName + ", number=" + this.mNumber + ", address=" + this.mAddress + ", time=" + this.mTime + ", uuid=" + this.mUUID + ", id=" + this.mId + ", state=" + this.mState + ", recordType=" + this.mRecordType + ", numberType=" + this.mNumberType + ", portrait=" + this.mPortrait + ", inBandRing=" + this.mInBandRing + ", multiParty=" + this.mMultiParty + ", outGoing=" + this.mOutGoing + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mAddress);
        parcel.writeLong(this.mTime);
        parcel.writeString(this.mUUID);
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mRecordType);
        parcel.writeInt(this.mNumberType);
        parcel.writeByteArray(this.mPortrait);
        parcel.writeByte(this.mInBandRing ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mMultiParty ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mOutGoing ? (byte) 1 : (byte) 0);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTDialInfo> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTDialInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTDialInfo.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTDialInfo(Parcel parcel) {
        readFromParcel(parcel);
    }
}
