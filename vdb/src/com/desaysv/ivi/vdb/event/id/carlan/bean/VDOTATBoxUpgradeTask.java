package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDOTATBoxUpgradeTask implements Parcelable {
    public static final Parcelable.Creator<VDOTATBoxUpgradeTask> CREATOR = new Parcelable.Creator<VDOTATBoxUpgradeTask>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDOTATBoxUpgradeTask.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDOTATBoxUpgradeTask createFromParcel(Parcel parcel) {
            return new VDOTATBoxUpgradeTask(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDOTATBoxUpgradeTask[] newArray(int i2) {
            return new VDOTATBoxUpgradeTask[i2];
        }
    };
    private int otaAPPTSecs;
    private String scheduleID;

    public VDOTATBoxUpgradeTask() {
    }

    public static VDEvent createEvent(int i2, VDOTATBoxUpgradeTask vDOTATBoxUpgradeTask) {
        return new VDEvent(i2, createPayload(vDOTATBoxUpgradeTask));
    }

    public static Bundle createPayload(VDOTATBoxUpgradeTask vDOTATBoxUpgradeTask) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDOTATBoxUpgradeTask.class.getClassLoader());
        bundle.putParcelable("info", vDOTATBoxUpgradeTask);
        return bundle;
    }

    public static VDOTATBoxUpgradeTask getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDOTATBoxUpgradeTask.class.getClassLoader());
        return (VDOTATBoxUpgradeTask) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getOtaAPPTSecs() {
        return this.otaAPPTSecs;
    }

    public String getScheduleID() {
        return this.scheduleID;
    }

    public void setOtaAPPTSecs(int i2) {
        this.otaAPPTSecs = i2;
    }

    public void setScheduleID(String str) {
        this.scheduleID = str;
    }

    public String toString() {
        return "VDOTATBoxUpgradeTask{scheduleID='" + this.scheduleID + "', otaAPPTSecs=" + this.otaAPPTSecs + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.scheduleID);
        parcel.writeInt(this.otaAPPTSecs);
    }

    protected VDOTATBoxUpgradeTask(Parcel parcel) {
        this.scheduleID = parcel.readString();
        this.otaAPPTSecs = parcel.readInt();
    }
}
