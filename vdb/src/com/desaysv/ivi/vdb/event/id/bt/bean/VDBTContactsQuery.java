package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTContactsQuery implements Parcelable {
    public static final Parcelable.Creator<VDBTContactsQuery> CREATOR = new Parcelable.Creator<VDBTContactsQuery>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTContactsQuery.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContactsQuery createFromParcel(Parcel parcel) {
            return new VDBTContactsQuery(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTContactsQuery[] newArray(int i2) {
            return new VDBTContactsQuery[i2];
        }
    };
    private ArrayList<VDBTContacts> mContactsList;
    private String mQueryKey = null;
    private boolean mIsQuerying = false;

    public VDBTContactsQuery() {
    }

    public static VDEvent createEvent(int i2, VDBTContactsQuery vDBTContactsQuery) {
        return new VDEvent(i2, createPayload(vDBTContactsQuery));
    }

    public static Bundle createPayload(VDBTContactsQuery vDBTContactsQuery) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTContactsQuery.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTContactsQuery);
        return bundle;
    }

    public static VDBTContactsQuery getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTContactsQuery.class.getClassLoader());
        return (VDBTContactsQuery) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mQueryKey = parcel.readString();
        this.mContactsList = parcel.readArrayList(VDBTContacts.class.getClassLoader());
        this.mIsQuerying = parcel.readBoolean();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<VDBTContacts> getContactsList() {
        return this.mContactsList;
    }

    public boolean getIsQuerying() {
        return this.mIsQuerying;
    }

    public String getQueryKey() {
        return this.mQueryKey;
    }

    public void putContactsList(ArrayList<VDBTContacts> arrayList) {
        this.mContactsList = arrayList;
    }

    public void putIsQuerying(boolean z2) {
        this.mIsQuerying = z2;
    }

    public void putQueryKey(String str) {
        this.mQueryKey = str;
    }

    public String toString() {
        return "VDBTContactsQuery{queryKey=" + this.mQueryKey + ", contactsList=" + this.mContactsList + ", isQuerying=" + this.mIsQuerying + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mQueryKey);
        parcel.writeList(this.mContactsList);
        parcel.writeBoolean(this.mIsQuerying);
    }

    protected VDBTContactsQuery(Parcel parcel) {
        readFromParcel(parcel);
    }
}
