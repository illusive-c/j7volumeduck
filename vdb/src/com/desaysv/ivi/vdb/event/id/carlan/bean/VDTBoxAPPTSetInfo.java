package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDTBoxAPPTSetInfo implements Parcelable {
    public static final Parcelable.Creator<VDTBoxAPPTSetInfo> CREATOR = new Parcelable.Creator<VDTBoxAPPTSetInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTBoxAPPTSetInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxAPPTSetInfo createFromParcel(Parcel parcel) {
            return new VDTBoxAPPTSetInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxAPPTSetInfo[] newArray(int i2) {
            return new VDTBoxAPPTSetInfo[i2];
        }
    };
    private int OTAAPPTSecs;
    private int result;
    private String scheduleID;

    public VDTBoxAPPTSetInfo() {
        this.result = 0;
    }

    public static VDEvent createEvent(int i2, VDTBoxAPPTSetInfo vDTBoxAPPTSetInfo) {
        return new VDEvent(i2, createPayload(vDTBoxAPPTSetInfo));
    }

    public static Bundle createPayload(VDTBoxAPPTSetInfo vDTBoxAPPTSetInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTBoxAPPTSetInfo.class.getClassLoader());
        bundle.putParcelable("info", vDTBoxAPPTSetInfo);
        return bundle;
    }

    public static VDTBoxAPPTSetInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTBoxAPPTSetInfo.class.getClassLoader());
        return (VDTBoxAPPTSetInfo) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getOTAAPPTSecs() {
        return this.OTAAPPTSecs;
    }

    public int getResult() {
        return this.result;
    }

    public String getScheduleID() {
        return this.scheduleID;
    }

    public void setOTAAPPTSecs(int i2) {
        this.OTAAPPTSecs = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setScheduleID(String str) {
        this.scheduleID = str;
    }

    public String toString() {
        return "VDTBoxAPPTSetInfoSetInfo{scheduleID='" + this.scheduleID + "', OTAAPPTSecs=" + this.OTAAPPTSecs + ", result=" + this.result + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.scheduleID);
        parcel.writeInt(this.OTAAPPTSecs);
        parcel.writeInt(this.result);
    }

    protected VDTBoxAPPTSetInfo(Parcel parcel) {
        this.result = 0;
        this.scheduleID = parcel.readString();
        this.OTAAPPTSecs = parcel.readInt();
        this.result = parcel.readInt();
    }
}
