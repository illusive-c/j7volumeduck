package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDmsRecognitionStatus implements Parcelable {
    public static final Parcelable.Creator<VDDmsRecognitionStatus> CREATOR = new Parcelable.Creator<VDDmsRecognitionStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDmsRecognitionStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsRecognitionStatus createFromParcel(Parcel parcel) {
            return new VDDmsRecognitionStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDmsRecognitionStatus[] newArray(int i2) {
            return new VDDmsRecognitionStatus[i2];
        }
    };
    private float confidence;
    private float feature;
    private int id;
    private int ids;
    private String name;
    private int pose;
    private String savedFaceFeatureFilename;
    private int status;

    public VDDmsRecognitionStatus() {
    }

    public static VDEvent createEvent(int i2, VDDmsRecognitionStatus vDDmsRecognitionStatus) {
        return new VDEvent(i2, createPayload(vDDmsRecognitionStatus));
    }

    public static Bundle createPayload(VDDmsRecognitionStatus vDDmsRecognitionStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDmsRecognitionStatus.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDmsRecognitionStatus);
        return bundle;
    }

    public static VDDmsRecognitionStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDmsRecognitionStatus.class.getClassLoader());
        return (VDDmsRecognitionStatus) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getConfidence() {
        return this.confidence;
    }

    public float getFeature() {
        return this.feature;
    }

    public int getId() {
        return this.id;
    }

    public int getIds() {
        return this.ids;
    }

    public String getName() {
        return this.name;
    }

    public int getPose() {
        return this.pose;
    }

    public String getSavedFaceFeatureFilename() {
        return this.savedFaceFeatureFilename;
    }

    public int getStatus() {
        return this.status;
    }

    public void setConfidence(float f2) {
        this.confidence = f2;
    }

    public void setFeature(float f2) {
        this.feature = f2;
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setIds(int i2) {
        this.ids = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPose(int i2) {
        this.pose = i2;
    }

    public void setSavedFaceFeatureFilename(String str) {
        this.savedFaceFeatureFilename = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "VDDmsRecognitionStatus{status=" + this.status + ", pose=" + this.pose + ", id=" + this.id + ", name='" + this.name + "', confidence=" + this.confidence + ", feature=" + this.feature + ", savedFaceFeatureFilename='" + this.savedFaceFeatureFilename + "', ids=" + this.ids + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.pose);
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeFloat(this.confidence);
        parcel.writeFloat(this.feature);
        parcel.writeString(this.savedFaceFeatureFilename);
        parcel.writeInt(this.ids);
    }

    protected VDDmsRecognitionStatus(Parcel parcel) {
        this.status = parcel.readInt();
        this.pose = parcel.readInt();
        this.id = parcel.readInt();
        this.name = parcel.readString();
        this.confidence = parcel.readFloat();
        this.feature = parcel.readFloat();
        this.savedFaceFeatureFilename = parcel.readString();
        this.ids = parcel.readInt();
    }
}
