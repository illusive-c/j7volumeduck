package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDDABHeadline implements Parcelable {
    public static final Parcelable.Creator<VDDABHeadline> CREATOR = new Parcelable.Creator<VDDABHeadline>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABHeadline.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadline createFromParcel(Parcel parcel) {
            return new VDDABHeadline(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadline[] newArray(int i2) {
            return new VDDABHeadline[i2];
        }
    };
    private VDDABHeadlineAction action;
    private VDDABHeadlineMessage message;

    public VDDABHeadline() {
    }

    public static VDEvent createEvent(int i2, VDDABHeadline vDDABHeadline) {
        return new VDEvent(i2, createPayload(vDDABHeadline));
    }

    public static Bundle createPayload(VDDABHeadline vDDABHeadline) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDABHeadline.class.getClassLoader());
        bundle.putParcelable("action", vDDABHeadline);
        return bundle;
    }

    public static VDDABHeadline getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDABHeadline.class.getClassLoader());
        return (VDDABHeadline) vDEvent.getPayload().getParcelable("action");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDDABHeadlineAction getAction() {
        return this.action;
    }

    public VDDABHeadlineMessage getMessage() {
        return this.message;
    }

    public void putAction(VDDABHeadlineAction vDDABHeadlineAction) {
        this.action = vDDABHeadlineAction;
    }

    public void putMessage(VDDABHeadlineMessage vDDABHeadlineMessage) {
        this.message = vDDABHeadlineMessage;
    }

    public String toString() {
        return "VDDABHeadline{action=" + this.action + ", message=" + this.message + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    protected VDDABHeadline(Parcel parcel) {
    }
}
