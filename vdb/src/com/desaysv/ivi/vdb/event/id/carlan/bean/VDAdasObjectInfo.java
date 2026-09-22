package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDAdasObjectInfo implements Parcelable {
    public static final Parcelable.Creator<VDAdasObjectInfo> CREATOR = new Parcelable.Creator<VDAdasObjectInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDAdasObjectInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasObjectInfo createFromParcel(Parcel parcel) {
            return new VDAdasObjectInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasObjectInfo[] newArray(int i2) {
            return new VDAdasObjectInfo[i2];
        }
    };
    private int TCL;
    private int TDD;
    private float THC;
    private float TLC;
    private float TRLaV;
    private float TRLoV;
    private float TTH;
    private float TTW;
    private int TV;
    private int TVT;

    public VDAdasObjectInfo() {
        this.TVT = 0;
    }

    public static VDEvent createEvent(int i2, VDAdasObjectInfo vDAdasObjectInfo) {
        return new VDEvent(i2, createPayload(vDAdasObjectInfo));
    }

    public static Bundle createPayload(VDAdasObjectInfo vDAdasObjectInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAdasObjectInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDAdasObjectInfo);
        return bundle;
    }

    public static ArrayList<VDAdasObjectInfo> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAdasObjectInfo.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDAdasObjectInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAdasObjectInfo.class.getClassLoader());
        return (VDAdasObjectInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getTCL() {
        return this.TCL;
    }

    public int getTDD() {
        return this.TDD;
    }

    public float getTHC() {
        return this.THC;
    }

    public float getTLC() {
        return this.TLC;
    }

    public float getTRLaV() {
        return this.TRLaV;
    }

    public float getTRLoV() {
        return this.TRLoV;
    }

    public float getTTH() {
        return this.TTH;
    }

    public float getTTW() {
        return this.TTW;
    }

    public int getTV() {
        return this.TV;
    }

    public int getTVT() {
        return this.TVT;
    }

    public void setTCL(int i2) {
        this.TCL = i2;
    }

    public void setTDD(int i2) {
        this.TDD = i2;
    }

    public void setTHC(float f2) {
        this.THC = f2;
    }

    public void setTLC(float f2) {
        this.TLC = f2;
    }

    public void setTRLaV(float f2) {
        this.TRLaV = f2;
    }

    public void setTRLoV(float f2) {
        this.TRLoV = f2;
    }

    public void setTTH(float f2) {
        this.TTH = f2;
    }

    public void setTTW(float f2) {
        this.TTW = f2;
    }

    public void setTV(int i2) {
        this.TV = i2;
    }

    public void setTVT(int i2) {
        this.TVT = i2;
    }

    public String toString() {
        return "VDAdasObjectInfo{TV=" + this.TV + ", TCL=" + this.TCL + ", TLC=" + this.TLC + ", THC=" + this.THC + ", TRLaV=" + this.TRLaV + ", TRLoV=" + this.TRLoV + ", TVT=" + this.TVT + ", TTW=" + this.TTW + ", TTH=" + this.TTH + ", TDD=" + this.TDD + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.TV);
        parcel.writeInt(this.TCL);
        parcel.writeFloat(this.TLC);
        parcel.writeFloat(this.THC);
        parcel.writeFloat(this.TRLaV);
        parcel.writeFloat(this.TRLoV);
        parcel.writeInt(this.TVT);
        parcel.writeFloat(this.TTW);
        parcel.writeFloat(this.TTH);
        parcel.writeInt(this.TDD);
    }

    protected VDAdasObjectInfo(Parcel parcel) {
        this.TVT = 0;
        this.TV = parcel.readInt();
        this.TCL = parcel.readInt();
        this.TLC = parcel.readFloat();
        this.THC = parcel.readFloat();
        this.TRLaV = parcel.readFloat();
        this.TRLoV = parcel.readFloat();
        this.TVT = parcel.readInt();
        this.TTW = parcel.readFloat();
        this.TTH = parcel.readFloat();
        this.TDD = parcel.readInt();
    }

    public static VDEvent createEvent(int i2, ArrayList<VDAdasObjectInfo> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDAdasObjectInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAdasObjectInfo.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }
}
