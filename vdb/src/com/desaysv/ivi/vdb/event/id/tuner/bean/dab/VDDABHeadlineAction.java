package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VDDABHeadlineAction implements Parcelable {
    public static final Parcelable.Creator<VDDABHeadlineAction> CREATOR = new Parcelable.Creator<VDDABHeadlineAction>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABHeadlineAction.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadlineAction createFromParcel(Parcel parcel) {
            return new VDDABHeadlineAction(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadlineAction[] newArray(int i2) {
            return new VDDABHeadlineAction[i2];
        }
    };
    private int action;
    private int bodyOption;
    private int dataSid;

    public VDDABHeadlineAction() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.action;
    }

    public int getBodyOption() {
        return this.bodyOption;
    }

    public int getDataSid() {
        return this.dataSid;
    }

    public void putAction(int i2) {
        this.action = i2;
    }

    public void putBodyOption(int i2) {
        this.bodyOption = i2;
    }

    public void putDataSid(int i2) {
        this.dataSid = i2;
    }

    public String toString() {
        return "VDDABHeadlineAction{action=" + this.action + ", bodyOption=" + this.bodyOption + ", dataSid=" + this.dataSid + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.action);
        parcel.writeInt(this.bodyOption);
        parcel.writeInt(this.dataSid);
    }

    protected VDDABHeadlineAction(Parcel parcel) {
        this.action = parcel.readInt();
        this.bodyOption = parcel.readInt();
        this.dataSid = parcel.readInt();
    }
}
