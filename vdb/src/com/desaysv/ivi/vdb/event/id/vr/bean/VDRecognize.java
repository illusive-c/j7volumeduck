package com.desaysv.ivi.vdb.event.id.vr.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes2.dex */
public class VDRecognize implements Parcelable {
    public static final Parcelable.Creator<VDRecognize> CREATOR = new Parcelable.Creator<VDRecognize>() { // from class: com.desaysv.ivi.vdb.event.id.vr.bean.VDRecognize.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRecognize createFromParcel(Parcel parcel) {
            return new VDRecognize(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDRecognize[] newArray(int i2) {
            return new VDRecognize[i2];
        }
    };
    private String content;
    private String pkgName;
    private int textType;

    public VDRecognize() {
    }

    public static VDEvent createEvent(int i2, VDRecognize vDRecognize) {
        return new VDEvent(i2, createPayload(vDRecognize));
    }

    public static Bundle createPayload(VDRecognize vDRecognize) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDRecognize.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDRecognize);
        return bundle;
    }

    public static VDRecognize getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDRecognize.class.getClassLoader());
        return (VDRecognize) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.content;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public int getTextType() {
        return this.textType;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setTextType(int i2) {
        this.textType = i2;
    }

    public String toString() {
        return "VDRecoText{pkgName='" + this.pkgName + "', textType=" + this.textType + ", content='" + this.content + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.pkgName);
        parcel.writeInt(this.textType);
        parcel.writeString(this.content);
    }

    public VDRecognize(Parcel parcel) {
        this.pkgName = parcel.readString();
        this.textType = parcel.readInt();
        this.content = parcel.readString();
    }
}
