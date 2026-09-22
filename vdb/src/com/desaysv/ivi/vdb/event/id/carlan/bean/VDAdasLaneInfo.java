package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDAdasLaneInfo implements Parcelable {
    public static final Parcelable.Creator<VDAdasLaneInfo> CREATOR = new Parcelable.Creator<VDAdasLaneInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDAdasLaneInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasLaneInfo createFromParcel(Parcel parcel) {
            return new VDAdasLaneInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasLaneInfo[] newArray(int i2) {
            return new VDAdasLaneInfo[i2];
        }
    };
    private float C0;
    private float C1;
    private float C2;
    private float C3;
    private int LC;
    private int LCPx;
    private int LDD;
    private int LFPx;
    private float LMW;
    private int LP;
    private int LQ;
    private int LT;

    public VDAdasLaneInfo() {
        this.LC = 0;
        this.LT = 0;
        this.LQ = 0;
    }

    public static VDEvent createEvent(int i2, VDAdasLaneInfo vDAdasLaneInfo) {
        return new VDEvent(i2, createPayload(vDAdasLaneInfo));
    }

    public static Bundle createPayload(VDAdasLaneInfo vDAdasLaneInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAdasLaneInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDAdasLaneInfo);
        return bundle;
    }

    public static ArrayList<VDAdasLaneInfo> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAdasLaneInfo.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDAdasLaneInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAdasLaneInfo.class.getClassLoader());
        return (VDAdasLaneInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getC0() {
        return this.C0;
    }

    public float getC1() {
        return this.C1;
    }

    public float getC2() {
        return this.C2;
    }

    public float getC3() {
        return this.C3;
    }

    public int getLC() {
        return this.LC;
    }

    public int getLCPx() {
        return this.LCPx;
    }

    public int getLDD() {
        return this.LDD;
    }

    public int getLFPx() {
        return this.LFPx;
    }

    public float getLMW() {
        return this.LMW;
    }

    public int getLP() {
        return this.LP;
    }

    public int getLQ() {
        return this.LQ;
    }

    public int getLT() {
        return this.LT;
    }

    public void setC0(float f2) {
        this.C0 = f2;
    }

    public void setC1(float f2) {
        this.C1 = f2;
    }

    public void setC2(float f2) {
        this.C2 = f2;
    }

    public void setC3(float f2) {
        this.C3 = f2;
    }

    public void setLC(int i2) {
        this.LC = i2;
    }

    public void setLCPx(int i2) {
        this.LCPx = i2;
    }

    public void setLDD(int i2) {
        this.LDD = i2;
    }

    public void setLFPx(int i2) {
        this.LFPx = i2;
    }

    public void setLMW(float f2) {
        this.LMW = f2;
    }

    public void setLP(int i2) {
        this.LP = i2;
    }

    public void setLQ(int i2) {
        this.LQ = i2;
    }

    public void setLT(int i2) {
        this.LT = i2;
    }

    public String toString() {
        return "VDAdasLaneInfo{C0=" + this.C0 + ", C1=" + this.C1 + ", C2=" + this.C2 + ", C3=" + this.C3 + ", LC=" + this.LC + ", LT=" + this.LT + ", LMW=" + this.LMW + ", LQ=" + this.LQ + ", LCPx=" + this.LCPx + ", LFPx=" + this.LFPx + ", LP=" + this.LP + ", LDD=" + this.LDD + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.C0);
        parcel.writeFloat(this.C1);
        parcel.writeFloat(this.C2);
        parcel.writeFloat(this.C3);
        parcel.writeInt(this.LC);
        parcel.writeInt(this.LT);
        parcel.writeFloat(this.LMW);
        parcel.writeInt(this.LQ);
        parcel.writeInt(this.LCPx);
        parcel.writeInt(this.LFPx);
        parcel.writeInt(this.LP);
        parcel.writeInt(this.LDD);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDAdasLaneInfo> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDAdasLaneInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAdasLaneInfo.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDAdasLaneInfo(Parcel parcel) {
        this.LC = 0;
        this.LT = 0;
        this.LQ = 0;
        this.C0 = parcel.readFloat();
        this.C1 = parcel.readFloat();
        this.C2 = parcel.readFloat();
        this.C3 = parcel.readFloat();
        this.LC = parcel.readInt();
        this.LT = parcel.readInt();
        this.LMW = parcel.readFloat();
        this.LQ = parcel.readInt();
        this.LCPx = parcel.readInt();
        this.LFPx = parcel.readInt();
        this.LP = parcel.readInt();
        this.LDD = parcel.readInt();
    }
}
