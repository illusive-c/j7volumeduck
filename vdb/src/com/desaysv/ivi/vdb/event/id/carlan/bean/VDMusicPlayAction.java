package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDMusicPlayAction implements Parcelable {
    public static final Parcelable.Creator<VDMusicPlayAction> CREATOR = new Parcelable.Creator<VDMusicPlayAction>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDMusicPlayAction.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayAction createFromParcel(Parcel parcel) {
            return new VDMusicPlayAction(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDMusicPlayAction[] newArray(int i2) {
            return new VDMusicPlayAction[i2];
        }
    };
    private String MusicPlayAction;

    public VDMusicPlayAction() {
    }

    public static VDEvent createEvent(int i2, VDMusicPlayAction vDMusicPlayAction) {
        return new VDEvent(i2, createPayload(vDMusicPlayAction));
    }

    public static Bundle createPayload(VDMusicPlayAction vDMusicPlayAction) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDMusicPlayAction.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDMusicPlayAction);
        return bundle;
    }

    public static VDMusicPlayAction getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDMusicPlayAction.class.getClassLoader());
        return (VDMusicPlayAction) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMusicPlayAction() {
        return this.MusicPlayAction;
    }

    public void setMusicPlayAction(String str) {
        this.MusicPlayAction = str;
    }

    public String toString() {
        return "VDMusicPlayAction{MusicPlayAction='" + this.MusicPlayAction + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.MusicPlayAction);
    }

    protected VDMusicPlayAction(Parcel parcel) {
        this.MusicPlayAction = parcel.readString();
    }
}
