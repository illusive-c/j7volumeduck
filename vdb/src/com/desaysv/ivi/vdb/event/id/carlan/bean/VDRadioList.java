package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDRadioList implements Parcelable {
    public static final Parcelable.Creator<VDRadioList> CREATOR = new Parcelable.Creator<VDRadioList>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioList createFromParcel(Parcel parcel) {
            return new VDRadioList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRadioList[] newArray(int i2) {
            return new VDRadioList[i2];
        }
    };
    private int Band;
    private ArrayList<RadioInfo> RadioList;
    private int TotalNum;

    public static class RadioInfo implements Parcelable {
        public static final Parcelable.Creator<RadioInfo> CREATOR = new Parcelable.Creator<RadioInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDRadioList.RadioInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RadioInfo createFromParcel(Parcel parcel) {
                return new RadioInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RadioInfo[] newArray(int i2) {
                return new RadioInfo[i2];
            }
        };
        private int Freq;
        private int Index;
        private String StationName;

        public RadioInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getFreq() {
            return this.Freq;
        }

        public int getIndex() {
            return this.Index;
        }

        public String getStationName() {
            return this.StationName;
        }

        public void setFreq(int i2) {
            this.Freq = i2;
        }

        public void setIndex(int i2) {
            this.Index = i2;
        }

        public void setStationName(String str) {
            this.StationName = str;
        }

        public String toString() {
            return "RadioInfo{Index=" + this.Index + ", Freq=" + this.Freq + ", StationName='" + this.StationName + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.Index);
            parcel.writeInt(this.Freq);
            parcel.writeString(this.StationName);
        }

        protected RadioInfo(Parcel parcel) {
            this.Index = parcel.readInt();
            this.Freq = parcel.readInt();
            this.StationName = parcel.readString();
        }
    }

    public VDRadioList() {
    }

    public static VDEvent createEvent(int i2, VDRadioList vDRadioList) {
        return new VDEvent(i2, createPayload(vDRadioList));
    }

    public static Bundle createPayload(VDRadioList vDRadioList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRadioList.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRadioList);
        return bundle;
    }

    public static VDRadioList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRadioList.class.getClassLoader());
        return (VDRadioList) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getBand() {
        return this.Band;
    }

    public ArrayList<RadioInfo> getRadioList() {
        return this.RadioList;
    }

    public int getTotalNum() {
        return this.TotalNum;
    }

    public void setBand(int i2) {
        this.Band = i2;
    }

    public void setRadioList(ArrayList<RadioInfo> arrayList) {
        this.RadioList = arrayList;
    }

    public void setTotalNum(int i2) {
        this.TotalNum = i2;
    }

    public String toString() {
        return "VDRadioList{Band=" + this.Band + ", TotalNum=" + this.TotalNum + ", RadioList=" + this.RadioList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.Band);
        parcel.writeInt(this.TotalNum);
        parcel.writeTypedList(this.RadioList);
    }

    protected VDRadioList(Parcel parcel) {
        this.Band = parcel.readInt();
        this.TotalNum = parcel.readInt();
        this.RadioList = parcel.createTypedArrayList(RadioInfo.CREATOR);
    }
}
