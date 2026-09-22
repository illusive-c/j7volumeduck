package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTContacts implements Parcelable {
    public static final Parcelable.Creator<VDBTContacts> CREATOR = new Parcelable.Creator<VDBTContacts>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTContacts.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContacts createFromParcel(Parcel parcel) {
            return new VDBTContacts(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContacts[] newArray(int i2) {
            return new VDBTContacts[i2];
        }
    };
    private ArrayList<VDBTContactsCard> mCardList;
    private String mId = null;
    private String mName = null;
    private String mNumber = null;
    private String mAddress = null;
    private String mFirstLetter = null;
    private String mQuanPin = null;
    private String mJianPin = null;
    private int mSortType = 0;
    private int mPhoneType = 0;
    private byte[] mPortrait = null;

    public VDBTContacts() {
    }

    public static VDEvent createEvent(int i2, VDBTContacts vDBTContacts) {
        return new VDEvent(i2, createPayload(vDBTContacts));
    }

    public static Bundle createPayload(VDBTContacts vDBTContacts) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTContacts.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTContacts);
        return bundle;
    }

    public static ArrayList<VDBTContacts> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTContacts.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTContacts getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTContacts.class.getClassLoader());
        return (VDBTContacts) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mNumber = parcel.readString();
        this.mAddress = parcel.readString();
        this.mFirstLetter = parcel.readString();
        this.mQuanPin = parcel.readString();
        this.mJianPin = parcel.readString();
        this.mSortType = parcel.readInt();
        this.mPhoneType = parcel.readInt();
        this.mPortrait = parcel.createByteArray();
        this.mCardList = parcel.readArrayList(VDBTContactsCard.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public ArrayList<VDBTContactsCard> getCardList() {
        return this.mCardList;
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

    public int getPhoneType() {
        return this.mPhoneType;
    }

    public byte[] getPortrait() {
        return this.mPortrait;
    }

    public String getQuanPin() {
        return this.mQuanPin;
    }

    public int getSortType() {
        return this.mSortType;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putCardList(ArrayList<VDBTContactsCard> arrayList) {
        this.mCardList = arrayList;
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

    public void putPhoneType(int i2) {
        this.mPhoneType = i2;
    }

    public void putPortrait(byte[] bArr) {
        this.mPortrait = bArr;
    }

    public void putQuanPin(String str) {
        this.mQuanPin = str;
    }

    public void putSortType(int i2) {
        this.mSortType = i2;
    }

    public String toString() {
        return "VDBTContacts{id=" + this.mId + ", name=" + this.mName + ", number=" + this.mNumber + ", address=" + this.mAddress + ", firstLetter=" + this.mFirstLetter + ", quanPin=" + this.mQuanPin + ", jianPin=" + this.mJianPin + ", sortType=" + this.mSortType + ", phoneType=" + this.mPhoneType + ", portrait=" + this.mPortrait + ", cardList=" + this.mCardList + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mFirstLetter);
        parcel.writeString(this.mQuanPin);
        parcel.writeString(this.mJianPin);
        parcel.writeInt(this.mSortType);
        parcel.writeInt(this.mPhoneType);
        parcel.writeByteArray(this.mPortrait);
        parcel.writeList(this.mCardList);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTContacts> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTContacts> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTContacts.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTContacts(Parcel parcel) {
        readFromParcel(parcel);
    }
}
