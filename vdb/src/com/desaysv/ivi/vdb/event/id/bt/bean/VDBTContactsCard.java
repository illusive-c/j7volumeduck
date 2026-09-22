package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDBTContactsCard implements Parcelable {
    public static final Parcelable.Creator<VDBTContactsCard> CREATOR = new Parcelable.Creator<VDBTContactsCard>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTContactsCard.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContactsCard createFromParcel(Parcel parcel) {
            return new VDBTContactsCard(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContactsCard[] newArray(int i2) {
            return new VDBTContactsCard[i2];
        }
    };
    private int mNumberType = 1;
    private String mNumber = null;
    private String mId = null;

    public VDBTContactsCard() {
    }

    private void readFromParcel(Parcel parcel) {
        this.mNumberType = parcel.readInt();
        this.mNumber = parcel.readString();
        this.mId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.mId;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public int getNumberType() {
        return this.mNumberType;
    }

    public void putId(String str) {
        this.mId = str;
    }

    public void putNumber(String str) {
        this.mNumber = str;
    }

    public void putNumberType(int i2) {
        this.mNumberType = i2;
    }

    public String toString() {
        return "VDBTContactsCard{numberType=" + this.mNumberType + ", number=" + this.mNumber + ", id=" + this.mId + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mNumberType);
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mId);
    }

    protected VDBTContactsCard(Parcel parcel) {
        readFromParcel(parcel);
    }
}
