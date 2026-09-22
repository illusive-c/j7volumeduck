package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDTBoxOTARemoteAppTSet implements Parcelable {
    public static final Parcelable.Creator<VDTBoxOTARemoteAppTSet> CREATOR = new Parcelable.Creator<VDTBoxOTARemoteAppTSet>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTBoxOTARemoteAppTSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxOTARemoteAppTSet createFromParcel(Parcel parcel) {
            return new VDTBoxOTARemoteAppTSet(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxOTARemoteAppTSet[] newArray(int i2) {
            return new VDTBoxOTARemoteAppTSet[i2];
        }
    };
    public int oTAAPPTSecs;
    public String scheduleID;

    public VDTBoxOTARemoteAppTSet() {
    }

    public static VDEvent createEvent(int i2, VDTBoxOTARemoteAppTSet vDTBoxOTARemoteAppTSet) {
        return new VDEvent(i2, createPayload(vDTBoxOTARemoteAppTSet));
    }

    public static Bundle createPayload(VDTBoxOTARemoteAppTSet vDTBoxOTARemoteAppTSet) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTBoxOTARemoteAppTSet.class.getClassLoader());
        bundle.putParcelable("info", vDTBoxOTARemoteAppTSet);
        return bundle;
    }

    public static VDTBoxOTARemoteAppTSet getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTBoxOTARemoteAppTSet.class.getClassLoader());
        return (VDTBoxOTARemoteAppTSet) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getScheduleID() {
        return this.scheduleID;
    }

    public int getoTAAPPTSecs() {
        return this.oTAAPPTSecs;
    }

    public void setScheduleID(String str) {
        this.scheduleID = str;
    }

    public void setoTAAPPTSecs(int i2) {
        this.oTAAPPTSecs = i2;
    }

    public String toString() {
        return "VDTBoxOTARemoteAppTSet{scheduleID='" + this.scheduleID + "', oTAAPPTSecs=" + this.oTAAPPTSecs + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.scheduleID);
        parcel.writeInt(this.oTAAPPTSecs);
    }

    protected VDTBoxOTARemoteAppTSet(Parcel parcel) {
        this.scheduleID = parcel.readString();
        this.oTAAPPTSecs = parcel.readInt();
    }
}
