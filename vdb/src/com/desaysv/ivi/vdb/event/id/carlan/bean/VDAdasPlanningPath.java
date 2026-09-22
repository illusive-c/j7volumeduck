package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDAdasPlanningPath implements Parcelable {
    public static final Parcelable.Creator<VDAdasPlanningPath> CREATOR = new Parcelable.Creator<VDAdasPlanningPath>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDAdasPlanningPath.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasPlanningPath createFromParcel(Parcel parcel) {
            return new VDAdasPlanningPath(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDAdasPlanningPath[] newArray(int i2) {
            return new VDAdasPlanningPath[i2];
        }
    };
    private int PlanPathConfidence;
    private float PlanPathCurvatureParam1;
    private float PlanPathCurvatureParam2;
    private float PlanPathCurvatureParam3;
    private float PlanPathCurvatureParam4;
    private int PlanPathDelayTime;
    private int PlanPathDisplayLength;

    public VDAdasPlanningPath() {
        this.PlanPathConfidence = 0;
    }

    public static VDEvent createEvent(int i2, VDAdasPlanningPath vDAdasPlanningPath) {
        return new VDEvent(i2, createPayload(vDAdasPlanningPath));
    }

    public static Bundle createPayload(VDAdasPlanningPath vDAdasPlanningPath) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDAdasPlanningPath.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDAdasPlanningPath);
        return bundle;
    }

    public static VDAdasPlanningPath getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDAdasPlanningPath.class.getClassLoader());
        return (VDAdasPlanningPath) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getPlanPathConfidence() {
        return this.PlanPathConfidence;
    }

    public float getPlanPathCurvatureParam1() {
        return this.PlanPathCurvatureParam1;
    }

    public float getPlanPathCurvatureParam2() {
        return this.PlanPathCurvatureParam2;
    }

    public float getPlanPathCurvatureParam3() {
        return this.PlanPathCurvatureParam3;
    }

    public float getPlanPathCurvatureParam4() {
        return this.PlanPathCurvatureParam4;
    }

    public int getPlanPathDelayTime() {
        return this.PlanPathDelayTime;
    }

    public int getPlanPathDisplayLength() {
        return this.PlanPathDisplayLength;
    }

    public void setPlanPathConfidence(int i2) {
        this.PlanPathConfidence = i2;
    }

    public void setPlanPathCurvatureParam1(float f2) {
        this.PlanPathCurvatureParam1 = f2;
    }

    public void setPlanPathCurvatureParam2(float f2) {
        this.PlanPathCurvatureParam2 = f2;
    }

    public void setPlanPathCurvatureParam3(float f2) {
        this.PlanPathCurvatureParam3 = f2;
    }

    public void setPlanPathCurvatureParam4(float f2) {
        this.PlanPathCurvatureParam4 = f2;
    }

    public void setPlanPathDelayTime(int i2) {
        this.PlanPathDelayTime = i2;
    }

    public void setPlanPathDisplayLength(int i2) {
        this.PlanPathDisplayLength = i2;
    }

    public String toString() {
        return "VDAdasPlanningPath{PlanPathConfidence=" + this.PlanPathConfidence + ", PlanPathDisplayLength=" + this.PlanPathDisplayLength + ", PlanPathDelayTime=" + this.PlanPathDelayTime + ", PlanPathCurvatureParam1=" + this.PlanPathCurvatureParam1 + ", PlanPathCurvatureParam2=" + this.PlanPathCurvatureParam2 + ", PlanPathCurvatureParam3=" + this.PlanPathCurvatureParam3 + ", PlanPathCurvatureParam4=" + this.PlanPathCurvatureParam4 + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.PlanPathConfidence);
        parcel.writeInt(this.PlanPathDisplayLength);
        parcel.writeInt(this.PlanPathDelayTime);
        parcel.writeFloat(this.PlanPathCurvatureParam1);
        parcel.writeFloat(this.PlanPathCurvatureParam2);
        parcel.writeFloat(this.PlanPathCurvatureParam3);
        parcel.writeFloat(this.PlanPathCurvatureParam4);
    }

    protected VDAdasPlanningPath(Parcel parcel) {
        this.PlanPathConfidence = 0;
        this.PlanPathConfidence = parcel.readInt();
        this.PlanPathDisplayLength = parcel.readInt();
        this.PlanPathDelayTime = parcel.readInt();
        this.PlanPathCurvatureParam1 = parcel.readFloat();
        this.PlanPathCurvatureParam2 = parcel.readFloat();
        this.PlanPathCurvatureParam3 = parcel.readFloat();
        this.PlanPathCurvatureParam4 = parcel.readFloat();
    }
}
