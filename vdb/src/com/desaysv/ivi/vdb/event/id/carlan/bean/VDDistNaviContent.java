package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDDistNaviContent implements Parcelable {
    public static final Parcelable.Creator<VDDistNaviContent> CREATOR = new Parcelable.Creator<VDDistNaviContent>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDDistNaviContent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDistNaviContent createFromParcel(Parcel parcel) {
            return new VDDistNaviContent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDistNaviContent[] newArray(int i2) {
            return new VDDistNaviContent[i2];
        }
    };
    private int DistNaviContent;

    public VDDistNaviContent() {
    }

    public static VDEvent createEvent(int i2, VDDistNaviContent vDDistNaviContent) {
        return new VDEvent(i2, createPayload(vDDistNaviContent));
    }

    public static Bundle createPayload(VDDistNaviContent vDDistNaviContent) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDDistNaviContent.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDDistNaviContent);
        return bundle;
    }

    public static VDDistNaviContent getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDDistNaviContent.class.getClassLoader());
        return (VDDistNaviContent) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDistNaviContent() {
        return this.DistNaviContent;
    }

    public void setDistNaviContent(int i2) {
        this.DistNaviContent = i2;
    }

    public String toString() {
        return "VDDistNaviContent{DistNaviContent=" + this.DistNaviContent + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.DistNaviContent);
    }

    protected VDDistNaviContent(Parcel parcel) {
        this.DistNaviContent = parcel.readInt();
    }
}
