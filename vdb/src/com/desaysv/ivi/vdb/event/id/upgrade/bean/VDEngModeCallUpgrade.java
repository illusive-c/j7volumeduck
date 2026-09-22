package com.desaysv.ivi.vdb.event.id.upgrade.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDEngModeCallUpgrade implements Parcelable {
    public static final Parcelable.Creator<VDEngModeCallUpgrade> CREATOR = new Parcelable.Creator<VDEngModeCallUpgrade>() { // from class: com.desaysv.ivi.vdb.event.id.upgrade.bean.VDEngModeCallUpgrade.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDEngModeCallUpgrade createFromParcel(Parcel parcel) {
            return new VDEngModeCallUpgrade(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDEngModeCallUpgrade[] newArray(int i2) {
            return new VDEngModeCallUpgrade[i2];
        }
    };
    public static final int DOING = 1;
    public static final int FAILED = 2;
    public static final int FINISHED = 3;
    public static final int START_UPGRADE = 1;
    public static final int STOP_UPGRADE = 2;
    private int action;
    private String params;
    private int status;

    protected VDEngModeCallUpgrade(Parcel parcel) {
        this.action = parcel.readInt();
        this.params = parcel.readString();
        this.status = parcel.readInt();
    }

    public static VDEvent createEvent(int i2, VDEngModeCallUpgrade vDEngModeCallUpgrade) {
        return new VDEvent(i2, createPayload(vDEngModeCallUpgrade));
    }

    public static Bundle createPayload(VDEngModeCallUpgrade vDEngModeCallUpgrade) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDEngModeCallUpgrade.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDEngModeCallUpgrade);
        return bundle;
    }

    public static VDEngModeCallUpgrade getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDEngModeCallUpgrade.class.getClassLoader());
        return (VDEngModeCallUpgrade) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.action;
    }

    public String getParams() {
        return this.params;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAction(int i2) {
        this.action = i2;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public String toString() {
        return "VDEngModeCallUpgrade{action=" + this.action + ", params='" + this.params + "', status=" + this.status + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.action);
        parcel.writeString(this.params);
        parcel.writeInt(this.status);
    }

    public VDEngModeCallUpgrade() {
    }
}
