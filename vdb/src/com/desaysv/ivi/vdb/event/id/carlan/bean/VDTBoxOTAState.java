package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDTBoxOTAState implements Parcelable {
    public static final Parcelable.Creator<VDTBoxOTAState> CREATOR = new Parcelable.Creator<VDTBoxOTAState>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTBoxOTAState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxOTAState createFromParcel(Parcel parcel) {
            return new VDTBoxOTAState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTBoxOTAState[] newArray(int i2) {
            return new VDTBoxOTAState[i2];
        }
    };
    private int result;
    private String scheduleID;
    private int scheduleTime;
    private String state;
    private String usid;

    public VDTBoxOTAState() {
        this.result = 0;
    }

    public static VDEvent createEvent(int i2, VDTBoxOTAState vDTBoxOTAState) {
        return new VDEvent(i2, createPayload(vDTBoxOTAState));
    }

    public static Bundle createPayload(VDTBoxOTAState vDTBoxOTAState) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTBoxOTAState.class.getClassLoader());
        bundle.putParcelable("info", vDTBoxOTAState);
        return bundle;
    }

    public static VDTBoxOTAState getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTBoxOTAState.class.getClassLoader());
        return (VDTBoxOTAState) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getResult() {
        return this.result;
    }

    public String getScheduleID() {
        return this.scheduleID;
    }

    public int getScheduleTime() {
        return this.scheduleTime;
    }

    public String getState() {
        return this.state;
    }

    public String getUsid() {
        return this.usid;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setScheduleID(String str) {
        this.scheduleID = str;
    }

    public void setScheduleTime(int i2) {
        this.scheduleTime = i2;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setUsid(String str) {
        this.usid = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.usid);
        parcel.writeString(this.scheduleID);
        parcel.writeInt(this.scheduleTime);
        parcel.writeString(this.state);
        parcel.writeInt(this.result);
    }

    protected VDTBoxOTAState(Parcel parcel) {
        this.result = 0;
        this.usid = parcel.readString();
        this.scheduleID = parcel.readString();
        this.scheduleTime = parcel.readInt();
        this.state = parcel.readString();
        this.result = parcel.readInt();
    }
}
