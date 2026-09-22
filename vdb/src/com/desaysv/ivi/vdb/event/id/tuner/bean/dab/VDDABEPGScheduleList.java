package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.List;

/* loaded from: classes.dex */
public class VDDABEPGScheduleList implements Parcelable {
    public static final Parcelable.Creator<VDDABEPGScheduleList> CREATOR = new Parcelable.Creator<VDDABEPGScheduleList>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABEPGScheduleList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABEPGScheduleList createFromParcel(Parcel parcel) {
            return new VDDABEPGScheduleList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABEPGScheduleList[] newArray(int i2) {
            return new VDDABEPGScheduleList[i2];
        }
    };
    private List<VDDABEPGSchedule> epgScheduleList;
    private int serviceId;

    public VDDABEPGScheduleList() {
    }

    public static VDEvent createEvent(int i2, VDDABEPGScheduleList vDDABEPGScheduleList) {
        return new VDEvent(i2, createPayload(vDDABEPGScheduleList));
    }

    public static Bundle createPayload(VDDABEPGScheduleList vDDABEPGScheduleList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABEPGScheduleList.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDABEPGScheduleList);
        return bundle;
    }

    public static VDDABEPGScheduleList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABEPGScheduleList.class.getClassLoader());
        return (VDDABEPGScheduleList) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<VDDABEPGSchedule> getEpgScheduleList() {
        return this.epgScheduleList;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public void putEpgScheduleList(List<VDDABEPGSchedule> list) {
        this.epgScheduleList = list;
    }

    public void putServiceId(int i2) {
        this.serviceId = i2;
    }

    public String toString() {
        return "VDDABEPGScheduleList{serviceId=" + this.serviceId + ", epgScheduleList=" + this.epgScheduleList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.serviceId);
        parcel.writeTypedList(this.epgScheduleList);
    }

    protected VDDABEPGScheduleList(Parcel parcel) {
        this.serviceId = parcel.readInt();
        this.epgScheduleList = parcel.createTypedArrayList(VDDABEPGSchedule.CREATOR);
    }
}
