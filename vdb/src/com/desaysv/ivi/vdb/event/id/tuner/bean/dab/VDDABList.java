package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.List;

/* loaded from: classes.dex */
public class VDDABList implements Parcelable {
    public static final Parcelable.Creator<VDDABList> CREATOR = new Parcelable.Creator<VDDABList>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABList createFromParcel(Parcel parcel) {
            return new VDDABList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABList[] newArray(int i2) {
            return new VDDABList[i2];
        }
    };
    private List<VDDABInfo> infoList;
    private int listType;

    public VDDABList() {
    }

    public static VDEvent createEvent(int i2, VDDABList vDDABList) {
        return new VDEvent(i2, createPayload(vDDABList));
    }

    public static Bundle createPayload(VDDABList vDDABList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABList.class.getClassLoader());
        bundle.putParcelable("info", vDDABList);
        return bundle;
    }

    public static VDDABList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABList.class.getClassLoader());
        return (VDDABList) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<VDDABInfo> getInfoList() {
        return this.infoList;
    }

    public int getListType() {
        return this.listType;
    }

    public void putInfoList(List<VDDABInfo> list) {
        this.infoList = list;
    }

    public void putListType(int i2) {
        this.listType = i2;
    }

    public String toString() {
        return "VDDABList{listType=" + this.listType + ", infoList=" + this.infoList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.listType);
        parcel.writeTypedList(this.infoList);
    }

    protected VDDABList(Parcel parcel) {
        this.listType = parcel.readInt();
        this.infoList = parcel.createTypedArrayList(VDDABInfo.CREATOR);
    }
}
