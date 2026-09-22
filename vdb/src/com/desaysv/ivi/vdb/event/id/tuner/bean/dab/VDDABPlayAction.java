package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDDABPlayAction implements Parcelable {
    public static final Parcelable.Creator<VDDABPlayAction> CREATOR = new Parcelable.Creator<VDDABPlayAction>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABPlayAction.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlayAction createFromParcel(Parcel parcel) {
            return new VDDABPlayAction(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABPlayAction[] newArray(int i2) {
            return new VDDABPlayAction[i2];
        }
    };
    private int disPlayView;
    private int intent;
    private int openReason;
    private int playAction;
    private VDDABInfo vddabInfo;

    public VDDABPlayAction() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDDABInfo getDABInfo() {
        return this.vddabInfo;
    }

    public int getDisPlayView() {
        return this.disPlayView;
    }

    public int getIntent() {
        return this.intent;
    }

    public int getOpenReason() {
        return this.openReason;
    }

    public int getPlayAction() {
        return this.playAction;
    }

    public void putDABInfo(VDDABInfo vDDABInfo) {
        this.vddabInfo = vDDABInfo;
    }

    public void putDisPlayView(int i2) {
        this.disPlayView = i2;
    }

    public void putIntent(int i2) {
        this.intent = i2;
    }

    public void putOpenReason(int i2) {
        this.openReason = i2;
    }

    public void putPlayAction(int i2) {
        this.playAction = i2;
    }

    public String toString() {
        return "VDDABPlayAction{playAction=" + this.playAction + ", vddabInfo=" + this.vddabInfo + ", openReason=" + this.openReason + ", intent=" + this.intent + ", disPlayView=" + this.disPlayView + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.playAction);
        parcel.writeParcelable(this.vddabInfo, i2);
        parcel.writeInt(this.openReason);
        parcel.writeInt(this.intent);
        parcel.writeInt(this.disPlayView);
    }

    protected VDDABPlayAction(Parcel parcel) {
        this.playAction = parcel.readInt();
        this.vddabInfo = (VDDABInfo) parcel.readParcelable(VDDABInfo.class.getClassLoader());
        this.openReason = parcel.readInt();
        this.intent = parcel.readInt();
        this.disPlayView = parcel.readInt();
    }
}
