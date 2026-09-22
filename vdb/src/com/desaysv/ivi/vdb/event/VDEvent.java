package com.desaysv.ivi.vdb.event;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.desaysv.ivi.vdb.client.bind.VDThreadType;

/* loaded from: classes.dex */
public class VDEvent implements Parcelable {
    public static final Parcelable.Creator<VDEvent> CREATOR = new Parcelable.Creator<VDEvent>() { // from class: com.desaysv.ivi.vdb.event.VDEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDEvent createFromParcel(Parcel parcel) {
            return new VDEvent(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDEvent[] newArray(int i2) {
            return new VDEvent[i2];
        }
    };
    private int mId;
    private Bundle mPayload;
    private int mThreadType;
    private long mTimeMillis;

    public VDEvent(int i2) {
        this.mId = 0;
        this.mThreadType = VDThreadType.MAIN_THREAD;
        this.mId = i2;
    }

    public void createTimeMillis() {
        this.mTimeMillis = SystemClock.elapsedRealtime();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public Bundle getPayload() {
        return this.mPayload;
    }

    public int getThreadType() {
        return this.mThreadType;
    }

    public long getTimeMillis() {
        return this.mTimeMillis;
    }

    public void setPayload(Bundle bundle) {
        this.mPayload = bundle;
    }

    public void setThreadType(int i2) {
        this.mThreadType = i2;
    }

    public String toString() {
        return "VDEvent{id=" + this.mId + ", payload=" + this.mPayload + ", threadType=" + this.mThreadType + ", timeMillis=" + this.mTimeMillis + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mId);
        parcel.writeBundle(this.mPayload);
        parcel.writeInt(this.mThreadType);
        parcel.writeLong(this.mTimeMillis);
    }

    public VDEvent(int i2, Bundle bundle) {
        this.mId = 0;
        this.mThreadType = VDThreadType.MAIN_THREAD;
        this.mId = i2;
        this.mPayload = bundle;
    }

    protected VDEvent(Parcel parcel) {
        this.mId = 0;
        this.mThreadType = VDThreadType.MAIN_THREAD;
        this.mId = parcel.readInt();
        this.mPayload = parcel.readBundle();
        this.mThreadType = parcel.readInt();
        this.mTimeMillis = parcel.readLong();
    }
}
