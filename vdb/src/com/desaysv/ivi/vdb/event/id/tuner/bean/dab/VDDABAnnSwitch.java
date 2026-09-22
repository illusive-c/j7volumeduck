package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABAnnSwitch implements Parcelable {
    public static final Parcelable.Creator<VDDABAnnSwitch> CREATOR = new Parcelable.Creator<VDDABAnnSwitch>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABAnnSwitch.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAnnSwitch createFromParcel(Parcel parcel) {
            return new VDDABAnnSwitch(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABAnnSwitch[] newArray(int i2) {
            return new VDDABAnnSwitch[i2];
        }
    };
    private int alarm;
    private int areaWeatherFlash;
    private int eventAnnouncement;
    private int financialReport;
    private int newsFlash;
    private int programInformation;
    private int roadTrafficFlash;
    private int serviceFollow;
    private int specialEvent;
    private int sportReport;
    private int transportFlash;
    private int warning;

    public VDDABAnnSwitch() {
        this.alarm = -1;
        this.roadTrafficFlash = -1;
        this.transportFlash = -1;
        this.warning = -1;
        this.newsFlash = -1;
        this.areaWeatherFlash = -1;
        this.eventAnnouncement = -1;
        this.specialEvent = -1;
        this.programInformation = -1;
        this.sportReport = -1;
        this.financialReport = -1;
        this.serviceFollow = -1;
    }

    public static VDEvent createEvent(int i2, VDDABAnnSwitch vDDABAnnSwitch) {
        return new VDEvent(i2, createPayload(vDDABAnnSwitch));
    }

    public static Bundle createPayload(VDDABAnnSwitch vDDABAnnSwitch) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABAnnSwitch.class.getClassLoader());
        bundle.putParcelable("status", vDDABAnnSwitch);
        return bundle;
    }

    public static VDDABAnnSwitch getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABAnnSwitch.class.getClassLoader());
        return (VDDABAnnSwitch) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlarm() {
        return this.alarm;
    }

    public int getAreaWeatherFlash() {
        return this.areaWeatherFlash;
    }

    public int getEventAnnouncement() {
        return this.eventAnnouncement;
    }

    public int getFinancialReport() {
        return this.financialReport;
    }

    public int getNewsFlash() {
        return this.newsFlash;
    }

    public int getProgramInformation() {
        return this.programInformation;
    }

    public int getRoadTrafficFlash() {
        return this.roadTrafficFlash;
    }

    public int getServiceFollow() {
        return this.serviceFollow;
    }

    public int getSpecialEvent() {
        return this.specialEvent;
    }

    public int getSportReport() {
        return this.sportReport;
    }

    public int getTransportFlash() {
        return this.transportFlash;
    }

    public int getWarning() {
        return this.warning;
    }

    public void putAlarm(int i2) {
        this.alarm = i2;
    }

    public void putAreaWeatherFlash(int i2) {
        this.areaWeatherFlash = i2;
    }

    public void putEventAnnouncement(int i2) {
        this.eventAnnouncement = i2;
    }

    public void putFinancialReport(int i2) {
        this.financialReport = i2;
    }

    public void putNewsFlash(int i2) {
        this.newsFlash = i2;
    }

    public void putProgramInformation(int i2) {
        this.programInformation = i2;
    }

    public void putRoadTrafficFlash(int i2) {
        this.roadTrafficFlash = i2;
    }

    public void putServiceFollow(int i2) {
        this.serviceFollow = i2;
    }

    public void putSpecialEvent(int i2) {
        this.specialEvent = i2;
    }

    public void putSportReport(int i2) {
        this.sportReport = i2;
    }

    public void putTransportFlash(int i2) {
        this.transportFlash = i2;
    }

    public void putWarning(int i2) {
        this.warning = i2;
    }

    public String toString() {
        return "VDDABAnnSwitch{alarm=" + this.alarm + ", roadTrafficFlash=" + this.roadTrafficFlash + ", transportFlash=" + this.transportFlash + ", warning=" + this.warning + ", newsFlash=" + this.newsFlash + ", areaWeatherFlash=" + this.areaWeatherFlash + ", eventAnnouncement=" + this.eventAnnouncement + ", specialEvent=" + this.specialEvent + ", programInformation=" + this.programInformation + ", sportReport=" + this.sportReport + ", financialReport=" + this.financialReport + ", serviceFollow=" + this.serviceFollow + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.alarm);
        parcel.writeInt(this.roadTrafficFlash);
        parcel.writeInt(this.transportFlash);
        parcel.writeInt(this.warning);
        parcel.writeInt(this.newsFlash);
        parcel.writeInt(this.areaWeatherFlash);
        parcel.writeInt(this.eventAnnouncement);
        parcel.writeInt(this.specialEvent);
        parcel.writeInt(this.programInformation);
        parcel.writeInt(this.sportReport);
        parcel.writeInt(this.financialReport);
        parcel.writeInt(this.serviceFollow);
    }

    protected VDDABAnnSwitch(Parcel parcel) {
        this.alarm = -1;
        this.roadTrafficFlash = -1;
        this.transportFlash = -1;
        this.warning = -1;
        this.newsFlash = -1;
        this.areaWeatherFlash = -1;
        this.eventAnnouncement = -1;
        this.specialEvent = -1;
        this.programInformation = -1;
        this.sportReport = -1;
        this.financialReport = -1;
        this.serviceFollow = -1;
        this.alarm = parcel.readInt();
        this.roadTrafficFlash = parcel.readInt();
        this.transportFlash = parcel.readInt();
        this.warning = parcel.readInt();
        this.newsFlash = parcel.readInt();
        this.areaWeatherFlash = parcel.readInt();
        this.eventAnnouncement = parcel.readInt();
        this.specialEvent = parcel.readInt();
        this.programInformation = parcel.readInt();
        this.sportReport = parcel.readInt();
        this.financialReport = parcel.readInt();
        this.serviceFollow = parcel.readInt();
    }
}
