package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTRecord implements Parcelable {
    public static final Parcelable.Creator<VDBTRecord> CREATOR = new Parcelable.Creator<VDBTRecord>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTRecord createFromParcel(Parcel parcel) {
            return new VDBTRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTRecord[] newArray(int i2) {
            return new VDBTRecord[i2];
        }
    };
    private int mRecordType = 1;
    private String mId = null;
    private String mName = null;
    private String mNumber = null;
    private String mDateTime = null;
    private String mDuration = null;
    private String mAddress = null;
    private String mFirstLetter = null;
    private String mQuanPin = null;
    private String mJianPin = null;

    public VDBTRecord() {
    }

    public static VDEvent createEvent(int i2, VDBTRecord vDBTRecord) {
        return new VDEvent(i2, createPayload(vDBTRecord));
    }

    public static Bundle createPayload(VDBTRecord vDBTRecord) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTRecord.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTRecord);
        return bundle;
    }

    public static ArrayList<VDBTRecord> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTRecord.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTRecord getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTRecord.class.getClassLoader());
        return (VDBTRecord) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mRecordType = parcel.readInt();
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mNumber = parcel.readString();
        this.mDateTime = parcel.readString();
        this.mDuration = parcel.readString();
        this.mAddress = parcel.readString();
        this.mFirstLetter = parcel.readString();
        this.mQuanPin = parcel.readString();
        this.mJianPin = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public String getDateTime() {
        return this.mDateTime;
    }

    public String getDuration() {
        return this.mDuration;
    }

    public String getFirstLetter() {
        return this.mFirstLetter;
    }

    public String getId() {
        return this.mId;
    }

    public String getJianPin() {
        return this.mJianPin;
    }

    public String getName() {
        return this.mName;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public String getQuanPin() {
        return this.mQuanPin;
    }

    public int getRecordType() {
        return this.mRecordType;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putDateTime(String str) {
        this.mDateTime = str;
    }

    public void putDuration(String str) {
        this.mDuration = str;
    }

    public void putFirstLetter(String str) {
        this.mFirstLetter = str;
    }

    public void putId(String str) {
        this.mId = str;
    }

    public void putJianPin(String str) {
        this.mJianPin = str;
    }

    public void putName(String str) {
        this.mName = str;
    }

    public void putNumber(String str) {
        this.mNumber = str;
    }

    public void putQuanPin(String str) {
        this.mQuanPin = str;
    }

    public void putRecordType(int i2) {
        this.mRecordType = i2;
    }

    public String toString() {
        return "VDBTRecord{recordType=" + this.mRecordType + ", id=" + this.mId + ", name=" + this.mName + ", number=" + this.mNumber + ", dateTime=" + this.mDateTime + ", duration=" + this.mDuration + ", address=" + this.mAddress + ", firstLetter=" + this.mFirstLetter + ", quanPin=" + this.mQuanPin + ", jianPin=" + this.mJianPin + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mRecordType);
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mDateTime);
        parcel.writeString(this.mDuration);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mFirstLetter);
        parcel.writeString(this.mQuanPin);
        parcel.writeString(this.mJianPin);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTRecord> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTRecord> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTRecord.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTRecord(Parcel parcel) {
        readFromParcel(parcel);
    }
}
