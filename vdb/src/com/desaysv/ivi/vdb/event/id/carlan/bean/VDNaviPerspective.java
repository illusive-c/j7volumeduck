package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDNaviPerspective implements Parcelable {
    public static final Parcelable.Creator<VDNaviPerspective> CREATOR = new Parcelable.Creator<VDNaviPerspective>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNaviPerspective.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviPerspective createFromParcel(Parcel parcel) {
            return new VDNaviPerspective(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNaviPerspective[] newArray(int i2) {
            return new VDNaviPerspective[i2];
        }
    };
    private int RequestPerspective;

    public VDNaviPerspective() {
        this.RequestPerspective = 0;
    }

    public static VDEvent createEvent(int i2, VDNaviPerspective vDNaviPerspective) {
        return new VDEvent(i2, createPayload(vDNaviPerspective));
    }

    public static Bundle createPayload(VDNaviPerspective vDNaviPerspective) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNaviPerspective.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDNaviPerspective);
        return bundle;
    }

    public static VDNaviPerspective getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNaviPerspective.class.getClassLoader());
        return (VDNaviPerspective) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRequestPerspective() {
        return this.RequestPerspective;
    }

    public void setRequestPerspective(int i2) {
        this.RequestPerspective = i2;
    }

    public String toString() {
        return "VDNaviPerspective{RequestPerspective=" + this.RequestPerspective + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.RequestPerspective);
    }

    protected VDNaviPerspective(Parcel parcel) {
        this.RequestPerspective = 0;
        this.RequestPerspective = parcel.readInt();
    }
}
