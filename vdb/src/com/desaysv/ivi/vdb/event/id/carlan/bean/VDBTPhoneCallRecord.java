package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTPhoneCallRecord implements Parcelable {
    public static final Parcelable.Creator<VDBTPhoneCallRecord> CREATOR = new Parcelable.Creator<VDBTPhoneCallRecord>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneCallRecord.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneCallRecord createFromParcel(Parcel parcel) {
            return new VDBTPhoneCallRecord(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTPhoneCallRecord[] newArray(int i2) {
            return new VDBTPhoneCallRecord[i2];
        }
    };
    private ArrayList<CallInfo> CallLog;
    private int TotalNum;

    public static class CallInfo implements Parcelable {
        public static final Parcelable.Creator<CallInfo> CREATOR = new Parcelable.Creator<CallInfo>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDBTPhoneCallRecord.CallInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CallInfo createFromParcel(Parcel parcel) {
                return new CallInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CallInfo[] newArray(int i2) {
                return new CallInfo[i2];
            }
        };
        private String Name;
        private String Number;
        private String Time;

        public CallInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getName() {
            return this.Name;
        }

        public String getNumber() {
            return this.Number;
        }

        public String getTime() {
            return this.Time;
        }

        public void setName(String str) {
            this.Name = str;
        }

        public void setNumber(String str) {
            this.Number = str;
        }

        public void setTime(String str) {
            this.Time = str;
        }

        public String toString() {
            return "CallInfo{Name='" + this.Name + "', Number='" + this.Number + "', Time='" + this.Time + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.Name);
            parcel.writeString(this.Number);
            parcel.writeString(this.Time);
        }

        protected CallInfo(Parcel parcel) {
            this.Name = parcel.readString();
            this.Number = parcel.readString();
            this.Time = parcel.readString();
        }
    }

    public VDBTPhoneCallRecord() {
    }

    public static VDEvent createEvent(int i2, VDBTPhoneCallRecord vDBTPhoneCallRecord) {
        return new VDEvent(i2, createPayload(vDBTPhoneCallRecord));
    }

    public static Bundle createPayload(VDBTPhoneCallRecord vDBTPhoneCallRecord) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTPhoneCallRecord.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTPhoneCallRecord);
        return bundle;
    }

    public static VDBTPhoneCallRecord getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTPhoneCallRecord.class.getClassLoader());
        return (VDBTPhoneCallRecord) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<CallInfo> getCallLog() {
        return this.CallLog;
    }

    public int getTotalNum() {
        return this.TotalNum;
    }

    public void setCallLog(ArrayList<CallInfo> arrayList) {
        this.CallLog = arrayList;
    }

    public void setTotalNum(int i2) {
        this.TotalNum = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.TotalNum);
        parcel.writeTypedList(this.CallLog);
    }

    protected VDBTPhoneCallRecord(Parcel parcel) {
        this.TotalNum = parcel.readInt();
        this.CallLog = parcel.createTypedArrayList(CallInfo.CREATOR);
    }
}
