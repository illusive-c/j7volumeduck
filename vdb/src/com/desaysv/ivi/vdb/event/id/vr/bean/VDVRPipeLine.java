package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes2.dex */
public class VDVRPipeLine implements Parcelable {
    public static final Parcelable.Creator<VDVRPipeLine> CREATOR = new Parcelable.Creator<VDVRPipeLine>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDVRPipeLine.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVRPipeLine createFromParcel(Parcel parcel) {
            return new VDVRPipeLine(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDVRPipeLine[] newArray(int i2) {
            return new VDVRPipeLine[i2];
        }
    };
    private boolean isFlowRecognize;
    private boolean isMulti;
    private boolean isTtsForbid;
    private String key;
    private String pkgName;
    private String recognizeReceipt;
    private int resultCode;
    private String unique;
    private String value;
    private int voiceRole;

    public VDVRPipeLine() {
    }

    public static VDEvent createEvent(int i2, VDVRPipeLine vDVRPipeLine) {
        return new VDEvent(i2, createPayload(vDVRPipeLine));
    }

    public static Bundle createPayload(VDVRPipeLine vDVRPipeLine) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDVRPipeLine.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDVRPipeLine);
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getKey() {
        return this.key;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getRecognizeReceipt() {
        return this.recognizeReceipt;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getUnique() {
        return this.unique;
    }

    public String getValue() {
        return this.value;
    }

    public int getVoiceRole() {
        return this.voiceRole;
    }

    public boolean isFlowRecognize() {
        return this.isFlowRecognize;
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public boolean isTtsForbid() {
        return this.isTtsForbid;
    }

    public void setFlowRecognize(boolean z2) {
        this.isFlowRecognize = z2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMulti(boolean z2) {
        this.isMulti = z2;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setRecognizeReceipt(String str) {
        this.recognizeReceipt = str;
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public void setTtsForbid(boolean z2) {
        this.isTtsForbid = z2;
    }

    public void setUnique(String str) {
        this.unique = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setVoiceRole(int i2) {
        this.voiceRole = i2;
    }

    public String toString() {
        return "VDVRPipeLine{pkgName='" + this.pkgName + "', unique='" + this.unique + "', key='" + this.key + "', value='" + this.value + "', resultCode=" + this.resultCode + ", voiceRole=" + this.voiceRole + ", isMulti=" + this.isMulti + ", isFlowRecognize=" + this.isFlowRecognize + ", isTtsForbid=" + this.isTtsForbid + ", recognizeReceipt='" + this.recognizeReceipt + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.pkgName);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeInt(this.resultCode);
        parcel.writeInt(this.voiceRole);
        parcel.writeBoolean(this.isMulti);
        parcel.writeBoolean(this.isFlowRecognize);
        parcel.writeString(this.recognizeReceipt);
        parcel.writeString(this.unique);
        parcel.writeBoolean(this.isTtsForbid);
    }

    public VDVRPipeLine(Parcel parcel) {
        this.pkgName = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.resultCode = parcel.readInt();
        this.voiceRole = parcel.readInt();
        this.isMulti = parcel.readBoolean();
        this.isFlowRecognize = parcel.readBoolean();
        this.recognizeReceipt = parcel.readString();
        this.unique = parcel.readString();
        this.isTtsForbid = parcel.readBoolean();
    }

    public static VDVRPipeLine getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDVRPipeLine.class.getClassLoader());
        return (VDVRPipeLine) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }
}
