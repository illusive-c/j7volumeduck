package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDBTPhoneRecordList implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneRecordList> CREATOR = new Parcelable.Creator<VDBTPhoneRecordList>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneRecordList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneRecordList createFromParcel(Parcel parcel) {
            return new VDBTPhoneRecordList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneRecordList[] newArray(int i2) {
            return new VDBTPhoneRecordList[i2];
        }
    };
    private int EndIndex;
    private int StartIndex;

    public VDBTPhoneRecordList() {
    }

    public static VDEvent createEvent(int i2, VDBTPhoneRecordList vDBTPhoneRecordList) {
        return new VDEvent(i2, createPayload(vDBTPhoneRecordList));
    }

    public static Bundle createPayload(VDBTPhoneRecordList vDBTPhoneRecordList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneRecordList.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneRecordList);
        return bundle;
    }

    public static VDBTPhoneRecordList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneRecordList.class.getClassLoader());
        return (VDBTPhoneRecordList) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndIndex() {
        return this.EndIndex;
    }

    public int getStartIndex() {
        return this.StartIndex;
    }

    public void setEndIndex(int i2) {
        this.EndIndex = i2;
    }

    public void setStartIndex(int i2) {
        this.StartIndex = i2;
    }

    public String toString() {
        return "VDBTPhoneRecordList{StartIndex=" + this.StartIndex + ", EndIndex=" + this.EndIndex + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.StartIndex);
        parcel.writeInt(this.EndIndex);
    }

    protected VDBTPhoneRecordList(Parcel parcel) {
        this.StartIndex = parcel.readInt();
        this.EndIndex = parcel.readInt();
    }
}
