package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDBTSearch implements Parcelable {
    public static final Parcelable.Creator<VDBTSearch> CREATOR = new Parcelable.Creator<VDBTSearch>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTSearch.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTSearch createFromParcel(Parcel parcel) {
            return new VDBTSearch(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTSearch[] newArray(int i2) {
            return new VDBTSearch[i2];
        }
    };
    private int mSearchStatus = 1;
    private int mSearchCtrl = 1;

    public VDBTSearch() {
    }

    public static VDEvent createEvent(int i2, VDBTSearch vDBTSearch) {
        return new VDEvent(i2, createPayload(vDBTSearch));
    }

    public static Bundle createPayload(VDBTSearch vDBTSearch) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTSearch.class.getClassLoader());
        bundle.putParcelable("status", vDBTSearch);
        return bundle;
    }

    public static VDBTSearch getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTSearch.class.getClassLoader());
        return (VDBTSearch) vDEvent.getPayload().getParcelable("status");
    }

    private void readFromParcel(Parcel parcel) {
        this.mSearchStatus = parcel.readInt();
        this.mSearchCtrl = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getSearchCtrl() {
        return this.mSearchCtrl;
    }

    public int getSearchStatus() {
        return this.mSearchStatus;
    }

    public void putSearchCtrl(int i2) {
        this.mSearchCtrl = i2;
    }

    public void putSearchStatus(int i2) {
        this.mSearchStatus = i2;
    }

    public String toString() {
        return "VDBTSearch{searchStatus=" + this.mSearchStatus + ", searchCtrl=" + this.mSearchCtrl + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mSearchStatus);
        parcel.writeInt(this.mSearchCtrl);
    }

    protected VDBTSearch(Parcel parcel) {
        readFromParcel(parcel);
    }
}
