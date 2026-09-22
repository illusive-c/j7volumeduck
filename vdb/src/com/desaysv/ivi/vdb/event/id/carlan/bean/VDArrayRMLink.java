package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDArrayRMLink implements Parcelable {
    public static final Parcelable.Creator<VDArrayRMLink> CREATOR = new Parcelable.Creator<VDArrayRMLink>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDArrayRMLink.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayRMLink createFromParcel(Parcel parcel) {
            return new VDArrayRMLink(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDArrayRMLink[] newArray(int i2) {
            return new VDArrayRMLink[i2];
        }
    };
    private VDStructRMLink[] data_buffer;

    public VDArrayRMLink() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VDStructRMLink[] getData_buffer() {
        return this.data_buffer;
    }

    public void setData_buffer(VDStructRMLink[] vDStructRMLinkArr) {
        this.data_buffer = vDStructRMLinkArr;
    }

    public String toString() {
        return "VDArrayRMLink{data_buffer=" + Arrays.toString(this.data_buffer) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.data_buffer, i2);
    }

    protected VDArrayRMLink(Parcel parcel) {
        this.data_buffer = (VDStructRMLink[]) parcel.createTypedArray(VDStructRMLink.CREATOR);
    }
}
