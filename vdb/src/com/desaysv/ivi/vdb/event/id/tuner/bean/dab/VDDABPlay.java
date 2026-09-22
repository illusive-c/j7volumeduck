package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABPlay implements Parcelable {
    public static final Parcelable.Creator<VDDABPlay> CREATOR = new Parcelable.Creator<VDDABPlay>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABPlay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlay createFromParcel(Parcel parcel) {
            return new VDDABPlay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlay[] newArray(int i2) {
            return new VDDABPlay[i2];
        }
    };
    private VDDABPlayAction playAction;
    private VDDABPlayStatus playStatus;

    public VDDABPlay() {
    }

    public static VDEvent createEvent(int i2, VDDABPlay vDDABPlay) {
        return new VDEvent(i2, createPayload(vDDABPlay));
    }

    public static Bundle createPayload(VDDABPlay vDDABPlay) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABPlay.class.getClassLoader());
        bundle.putParcelable("action", vDDABPlay);
        return bundle;
    }

    public static VDDABPlay getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABPlay.class.getClassLoader());
        return (VDDABPlay) vDEvent.getPayload().getParcelable("action");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDDABPlayAction getPlayAction() {
        return this.playAction;
    }

    public VDDABPlayStatus getPlayStatus() {
        return this.playStatus;
    }

    public void putPlayAction(VDDABPlayAction vDDABPlayAction) {
        this.playAction = vDDABPlayAction;
    }

    public void putPlayStatus(VDDABPlayStatus vDDABPlayStatus) {
        this.playStatus = vDDABPlayStatus;
    }

    public String toString() {
        return "VDDABPlay{playAction=" + this.playAction + ", playStatus=" + this.playStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.playAction, i2);
        parcel.writeParcelable(this.playStatus, i2);
    }

    protected VDDABPlay(Parcel parcel) {
        this.playAction = (VDDABPlayAction) parcel.readParcelable(VDDABPlayAction.class.getClassLoader());
        this.playStatus = (VDDABPlayStatus) parcel.readParcelable(VDDABPlayStatus.class.getClassLoader());
    }
}
