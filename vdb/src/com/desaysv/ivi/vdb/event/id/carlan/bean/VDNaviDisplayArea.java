package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviDisplayArea implements Parcelable {
    public static final Parcelable.Creator<VDNaviDisplayArea> CREATOR = new Parcelable.Creator<VDNaviDisplayArea>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviDisplayArea.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDisplayArea createFromParcel(Parcel parcel) {
            return new VDNaviDisplayArea(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviDisplayArea[] newArray(int i2) {
            return new VDNaviDisplayArea[i2];
        }
    };
    private int NaviDisplayArea;
    private String NaviDisplayAreaResult;

    public VDNaviDisplayArea() {
    }

    public static VDEvent createEvent(int i2, VDNaviDisplayArea vDNaviDisplayArea) {
        return new VDEvent(i2, createPayload(vDNaviDisplayArea));
    }

    public static Bundle createPayload(VDNaviDisplayArea vDNaviDisplayArea) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviDisplayArea.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviDisplayArea);
        return bundle;
    }

    public static VDNaviDisplayArea getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviDisplayArea.class.getClassLoader());
        return (VDNaviDisplayArea) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getNaviDisplayArea() {
        return this.NaviDisplayArea;
    }

    public String getNaviDisplayAreaResult() {
        return this.NaviDisplayAreaResult;
    }

    public void setNaviDisplayArea(int i2) {
        this.NaviDisplayArea = i2;
    }

    public void setNaviDisplayAreaResult(String str) {
        this.NaviDisplayAreaResult = str;
    }

    public String toString() {
        return "VDNaviDisplayArea{NaviDisplayArea=" + this.NaviDisplayArea + ", NaviDisplayAreaResult='" + this.NaviDisplayAreaResult + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.NaviDisplayArea);
        parcel.writeString(this.NaviDisplayAreaResult);
    }

    protected VDNaviDisplayArea(Parcel parcel) {
        this.NaviDisplayArea = parcel.readInt();
        this.NaviDisplayAreaResult = parcel.readString();
    }
}
