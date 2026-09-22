package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABInfo implements Parcelable {
    public static final Parcelable.Creator<VDDABInfo> CREATOR = new Parcelable.Creator<VDDABInfo>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABInfo createFromParcel(Parcel parcel) {
            return new VDDABInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABInfo[] newArray(int i2) {
            return new VDDABInfo[i2];
        }
    };
    private int collectStatus;
    private int ensembleId;
    private String ensembleLabel;
    private int ensembleLableFlag;
    private int frequency;
    private int proStaNameFlag;
    private String programStationName;
    private int programType;
    private int serviceComponentId;
    private int serviceId;
    private int subServiceFlag;

    public VDDABInfo() {
    }

    public static VDEvent createEvent(int i2, VDDABInfo vDDABInfo) {
        return new VDEvent(i2, createPayload(vDDABInfo));
    }

    public static Bundle createPayload(VDDABInfo vDDABInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABInfo.class.getClassLoader());
        bundle.putParcelable("status", vDDABInfo);
        return bundle;
    }

    public static VDDABInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABInfo.class.getClassLoader());
        return (VDDABInfo) vDEvent.getPayload().getParcelable("status");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCollectStatus() {
        return this.collectStatus;
    }

    public int getEnsembleId() {
        return this.ensembleId;
    }

    public String getEnsembleLabel() {
        return this.ensembleLabel;
    }

    public int getEnsembleLableFlag() {
        return this.ensembleLableFlag;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getProStaNameFlag() {
        return this.proStaNameFlag;
    }

    public String getProgramStationName() {
        return this.programStationName;
    }

    public int getProgramType() {
        return this.programType;
    }

    public int getServiceComponentId() {
        return this.serviceComponentId;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public int getSubServiceFlag() {
        return this.subServiceFlag;
    }

    public void putCollectStatus(int i2) {
        this.collectStatus = i2;
    }

    public void putEnsembleId(int i2) {
        this.ensembleId = i2;
    }

    public void putEnsembleLabel(String str) {
        this.ensembleLabel = str;
    }

    public void putEnsembleLableFlag(int i2) {
        this.ensembleLableFlag = i2;
    }

    public void putFrequency(int i2) {
        this.frequency = i2;
    }

    public void putProStaNameFlag(int i2) {
        this.proStaNameFlag = i2;
    }

    public void putProgramStationName(String str) {
        this.programStationName = str;
    }

    public void putProgramType(int i2) {
        this.programType = i2;
    }

    public void putServiceComponentId(int i2) {
        this.serviceComponentId = i2;
    }

    public void putServiceId(int i2) {
        this.serviceId = i2;
    }

    public void putSubServiceFlag(int i2) {
        this.subServiceFlag = i2;
    }

    public String toString() {
        return "VDDABInfo{frequency=" + this.frequency + ", programStationName='" + this.programStationName + "', ensembleLabel='" + this.ensembleLabel + "', programType=" + this.programType + ", serviceId=" + this.serviceId + ", serviceComponentId=" + this.serviceComponentId + ", ensembleId=" + this.ensembleId + ", ensembleLableFlag=" + this.ensembleLableFlag + ", proStaNameFlag=" + this.proStaNameFlag + ", subServiceFlag=" + this.subServiceFlag + ", collectStatus=" + this.collectStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.frequency);
        parcel.writeString(this.programStationName);
        parcel.writeString(this.ensembleLabel);
        parcel.writeInt(this.programType);
        parcel.writeInt(this.serviceId);
        parcel.writeInt(this.serviceComponentId);
        parcel.writeInt(this.ensembleId);
        parcel.writeInt(this.ensembleLableFlag);
        parcel.writeInt(this.proStaNameFlag);
        parcel.writeInt(this.subServiceFlag);
        parcel.writeInt(this.collectStatus);
    }

    protected VDDABInfo(Parcel parcel) {
        this.frequency = parcel.readInt();
        this.programStationName = parcel.readString();
        this.ensembleLabel = parcel.readString();
        this.programType = parcel.readInt();
        this.serviceId = parcel.readInt();
        this.serviceComponentId = parcel.readInt();
        this.ensembleId = parcel.readInt();
        this.ensembleLableFlag = parcel.readInt();
        this.proStaNameFlag = parcel.readInt();
        this.subServiceFlag = parcel.readInt();
        this.collectStatus = parcel.readInt();
    }
}
