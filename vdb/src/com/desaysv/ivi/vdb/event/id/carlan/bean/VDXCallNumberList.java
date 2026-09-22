package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import com.desaysv.ivi.vdb.event.id.carlan.VDValueCarLan;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDXCallNumberList implements Parcelable {
    public static final Parcelable.Creator<VDXCallNumberList> CREATOR = new Parcelable.Creator<VDXCallNumberList>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDXCallNumberList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDXCallNumberList createFromParcel(Parcel parcel) {
            return new VDXCallNumberList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDXCallNumberList[] newArray(int i2) {
            return new VDXCallNumberList[i2];
        }
    };
    private ArrayList<CallNumber> callNumberList;

    public VDXCallNumberList() {
    }

    public static VDEvent createEvent(int i2, VDXCallNumberList vDXCallNumberList) {
        return new VDEvent(i2, createPayload(vDXCallNumberList));
    }

    public static Bundle createPayload(VDXCallNumberList vDXCallNumberList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDXCallNumberList.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDXCallNumberList);
        return bundle;
    }

    public static ArrayList<VDXCallNumberList> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDXCallNumberList.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDXCallNumberList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDXCallNumberList.class.getClassLoader());
        return (VDXCallNumberList) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<CallNumber> getCallNumberList() {
        return this.callNumberList;
    }

    public void setCallNumberList(ArrayList<CallNumber> arrayList) {
        this.callNumberList = arrayList;
    }

    public String toString() {
        return "VDXCallNumberList{callNumberList=" + this.callNumberList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.callNumberList);
    }

    public static class CallNumber implements Parcelable {
        public static final Parcelable.Creator<CallNumber> CREATOR = new Parcelable.Creator<CallNumber>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDXCallNumberList.CallNumber.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CallNumber createFromParcel(Parcel parcel) {
                return new CallNumber(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CallNumber[] newArray(int i2) {
                return new CallNumber[i2];
            }
        };
        private String callType;
        private String phoneNumber;

        public CallNumber() {
            this.callType = VDValueCarLan.XCallType.B_CALL;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCallType() {
            return this.callType;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        public void setCallType(String str) {
            this.callType = str;
        }

        public void setPhoneNumber(String str) {
            this.phoneNumber = str;
        }

        public String toString() {
            return "CallNumber{callType='" + this.callType + "', phoneNumber='" + this.phoneNumber + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.callType);
            parcel.writeString(this.phoneNumber);
        }

        protected CallNumber(Parcel parcel) {
            this.callType = VDValueCarLan.XCallType.B_CALL;
            this.callType = parcel.readString();
            this.phoneNumber = parcel.readString();
        }
    }

    protected VDXCallNumberList(Parcel parcel) {
        this.callNumberList = parcel.createTypedArrayList(CallNumber.CREATOR);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDXCallNumberList> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDXCallNumberList> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDXCallNumberList.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }
}
