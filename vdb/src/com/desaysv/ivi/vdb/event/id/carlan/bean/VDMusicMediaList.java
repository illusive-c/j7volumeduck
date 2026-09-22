package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicMediaList implements Parcelable {
    public static final Parcelable.Creator<VDMusicMediaList> CREATOR = new Parcelable.Creator<VDMusicMediaList>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicMediaList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicMediaList createFromParcel(Parcel parcel) {
            return new VDMusicMediaList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicMediaList[] newArray(int i2) {
            return new VDMusicMediaList[i2];
        }
    };
    private int EndIndex;
    private int StartIndex;

    public VDMusicMediaList() {
    }

    public static VDEvent createEvent(int i2, VDMusicMediaList vDMusicMediaList) {
        return new VDEvent(i2, createPayload(vDMusicMediaList));
    }

    public static Bundle createPayload(VDMusicMediaList vDMusicMediaList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicMediaList.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicMediaList);
        return bundle;
    }

    public static VDMusicMediaList getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicMediaList.class.getClassLoader());
        return (VDMusicMediaList) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEndIndex() {
        return this.EndIndex;
    }

    public int getStartIndex() {
        return this.StartIndex;
    }

    public void setEndIndex(int i2) {
        this.EndIndex = i2;
    }

    public void setStartIndex(int i2) {
        this.StartIndex = i2;
    }

    public String toString() {
        return "VDMusicMediaList{StartIndex=" + this.StartIndex + ", EndIndex=" + this.EndIndex + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.StartIndex);
        parcel.writeInt(this.EndIndex);
    }

    protected VDMusicMediaList(Parcel parcel) {
        this.StartIndex = parcel.readInt();
        this.EndIndex = parcel.readInt();
    }
}
