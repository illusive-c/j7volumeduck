package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes2.dex */
public class VDP2P implements Parcelable {
    public static final Parcelable.Creator<VDP2P> CREATOR = new Parcelable.Creator<VDP2P>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDP2P.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDP2P createFromParcel(Parcel parcel) {
            return new VDP2P(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDP2P[] newArray(int i2) {
            return new VDP2P[i2];
        }
    };
    private boolean enable;
    private int functionId;
    private String position;
    private String respondId;
    private int resultCode;
    private String semanticType;
    private String time;
    private String unique;
    private String user;
    private String value;

    public VDP2P() {
    }

    public static VDEvent createEvent(int i2, VDP2P vdp2p) {
        return new VDEvent(i2, createPayload(vdp2p));
    }

    public static Bundle createPayload(VDP2P vdp2p) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDP2P.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vdp2p);
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFunctionId() {
        return this.functionId;
    }

    public String getPosition() {
        return this.position;
    }

    public String getRespondId() {
        return this.respondId;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getSemanticType() {
        return this.semanticType;
    }

    public String getTime() {
        return this.time;
    }

    public String getUnique() {
        return this.unique;
    }

    public String getUser() {
        return this.user;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z2) {
        this.enable = z2;
    }

    public void setFunctionId(int i2) {
        this.functionId = i2;
    }

    public void setPosition(String str) {
        this.position = str;
    }

    public void setRespondId(String str) {
        this.respondId = str;
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public void setSemanticType(String str) {
        this.semanticType = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUnique(String str) {
        this.unique = str;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "VDP2P{semanticType='" + this.semanticType + "', functionId='" + this.functionId + "', value='" + this.value + "', enable=" + this.enable + ", time='" + this.time + "', resultCode=" + this.resultCode + ", respondId=" + this.respondId + ", position='" + this.position + "', user='" + this.user + "', unique='" + this.unique + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.semanticType);
        parcel.writeInt(this.functionId);
        parcel.writeString(this.value);
        parcel.writeBoolean(this.enable);
        parcel.writeString(this.time);
        parcel.writeInt(this.resultCode);
        parcel.writeString(this.respondId);
        parcel.writeString(this.position);
        parcel.writeString(this.user);
        parcel.writeString(this.unique);
    }

    public VDP2P(Parcel parcel) {
        this.semanticType = parcel.readString();
        this.functionId = parcel.readInt();
        this.value = parcel.readString();
        this.enable = parcel.readBoolean();
        this.time = parcel.readString();
        this.resultCode = parcel.readInt();
        this.respondId = parcel.readString();
        this.position = parcel.readString();
        this.user = parcel.readString();
        this.unique = parcel.readString();
    }

    public static VDP2P getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDP2P.class.getClassLoader());
        return (VDP2P) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }
}
