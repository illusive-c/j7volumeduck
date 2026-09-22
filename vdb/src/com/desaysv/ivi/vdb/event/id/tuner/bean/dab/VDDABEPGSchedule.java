package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDDABEPGSchedule implements Parcelable {
    public static final Parcelable.Creator<VDDABEPGSchedule> CREATOR = new Parcelable.Creator<VDDABEPGSchedule>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABEPGSchedule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABEPGSchedule createFromParcel(Parcel parcel) {
            return new VDDABEPGSchedule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABEPGSchedule[] newArray(int i2) {
            return new VDDABEPGSchedule[i2];
        }
    };
    private String day;
    private String hour;
    private String min;
    private String month;
    private String programName;
    private String sec;
    private String year;

    public VDDABEPGSchedule() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDay() {
        return this.day;
    }

    public String getHour() {
        return this.hour;
    }

    public String getMin() {
        return this.min;
    }

    public String getMonth() {
        return this.month;
    }

    public String getProgramName() {
        return this.programName;
    }

    public String getSec() {
        return this.sec;
    }

    public String getYear() {
        return this.year;
    }

    public void putDay(String str) {
        this.day = str;
    }

    public void putHour(String str) {
        this.hour = str;
    }

    public void putMin(String str) {
        this.min = str;
    }

    public void putMonth(String str) {
        this.month = str;
    }

    public void putProgramName(String str) {
        this.programName = str;
    }

    public void putSec(String str) {
        this.sec = str;
    }

    public void putYear(String str) {
        this.year = str;
    }

    public String toString() {
        return "VDDABEPGSchedule{programName='" + this.programName + "', year='" + this.year + "', month='" + this.month + "', day='" + this.day + "', hour='" + this.hour + "', min='" + this.min + "', sec='" + this.sec + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.programName);
        parcel.writeString(this.year);
        parcel.writeString(this.month);
        parcel.writeString(this.day);
        parcel.writeString(this.hour);
        parcel.writeString(this.min);
        parcel.writeString(this.sec);
    }

    protected VDDABEPGSchedule(Parcel parcel) {
        this.programName = parcel.readString();
        this.year = parcel.readString();
        this.month = parcel.readString();
        this.day = parcel.readString();
        this.hour = parcel.readString();
        this.min = parcel.readString();
        this.sec = parcel.readString();
    }
}
