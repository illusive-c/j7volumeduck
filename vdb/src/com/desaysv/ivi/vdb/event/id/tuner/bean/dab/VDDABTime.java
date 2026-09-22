package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDABTime implements Parcelable {
    public static final Parcelable.Creator<VDDABTime> CREATOR = new Parcelable.Creator<VDDABTime>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABTime.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABTime createFromParcel(Parcel parcel) {
            return new VDDABTime(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABTime[] newArray(int i2) {
            return new VDDABTime[i2];
        }
    };
    private int day;
    private int hour;
    private int minute;
    private int month;
    private int second;
    private int state;
    private int week;
    private int year;

    public VDDABTime() {
    }

    public static VDEvent createEvent(int i2, VDDABTime vDDABTime) {
        return new VDEvent(i2, createPayload(vDDABTime));
    }

    public static Bundle createPayload(VDDABTime vDDABTime) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABTime.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDABTime);
        return bundle;
    }

    public static VDDABTime getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABTime.class.getClassLoader());
        return (VDDABTime) vDEvent.getPayload().getParcelable("action");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getMonth() {
        return this.month;
    }

    public int getSecond() {
        return this.second;
    }

    public int getState() {
        return this.state;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public void putDay(int i2) {
        this.day = i2;
    }

    public void putHour(int i2) {
        this.hour = i2;
    }

    public void putMinute(int i2) {
        this.minute = i2;
    }

    public void putMonth(int i2) {
        this.month = i2;
    }

    public void putSecond(int i2) {
        this.second = i2;
    }

    public void putState(int i2) {
        this.state = i2;
    }

    public void putWeek(int i2) {
        this.week = i2;
    }

    public void putYear(int i2) {
        this.year = i2;
    }

    public String toString() {
        return "VDDABTime{state=" + this.state + ", year=" + this.year + ", month=" + this.month + ", day=" + this.day + ", week=" + this.week + ", hour=" + this.hour + ", minute=" + this.minute + ", second=" + this.second + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.state);
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.day);
        parcel.writeInt(this.week);
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.second);
    }

    protected VDDABTime(Parcel parcel) {
        this.state = parcel.readInt();
        this.year = parcel.readInt();
        this.month = parcel.readInt();
        this.day = parcel.readInt();
        this.week = parcel.readInt();
        this.hour = parcel.readInt();
        this.minute = parcel.readInt();
        this.second = parcel.readInt();
    }
}
