package com.desaysv.ivi.vdb.event.id.bt.bean;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDBTMessage implements Parcelable {
    public static final Parcelable.Creator<VDBTMessage> CREATOR = new Parcelable.Creator<VDBTMessage>() { // from class: com.desaysv.ivi.vdb.event.id.bt.bean.VDBTMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMessage createFromParcel(Parcel parcel) {
            return new VDBTMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDBTMessage[] newArray(int i2) {
            return new VDBTMessage[i2];
        }
    };
    private String mId = null;
    private String mName = null;
    private String mNumber = null;
    private String mAddress = null;
    private String mContent = null;
    private long mDateTime = 0;
    private Uri[] mContacts = null;
    private PendingIntent mSentIntent = null;
    private PendingIntent mDeliveredIntent = null;

    public VDBTMessage() {
    }

    public static VDEvent createEvent(int i2, VDBTMessage vDBTMessage) {
        return new VDEvent(i2, createPayload(vDBTMessage));
    }

    public static Bundle createPayload(VDBTMessage vDBTMessage) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMessage.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDBTMessage);
        return bundle;
    }

    public static ArrayList<VDBTMessage> getList(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMessage.class.getClassLoader());
        return vDEvent.getPayload().getParcelableArrayList(VDKey.DATA);
    }

    public static VDBTMessage getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDBTMessage.class.getClassLoader());
        return (VDBTMessage) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    private void readFromParcel(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mNumber = parcel.readString();
        this.mAddress = parcel.readString();
        this.mContent = parcel.readString();
        this.mDateTime = parcel.readLong();
        this.mContacts = (Uri[]) parcel.createTypedArray(Uri.CREATOR);
        this.mSentIntent = (PendingIntent) parcel.readParcelable(getClass().getClassLoader());
        this.mDeliveredIntent = (PendingIntent) parcel.readParcelable(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public Uri[] getContacts() {
        return this.mContacts;
    }

    public String getContent() {
        return this.mContent;
    }

    public long getDateTime() {
        return this.mDateTime;
    }

    public PendingIntent getDeliveredIntent() {
        return this.mDeliveredIntent;
    }

    public String getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public PendingIntent getSentIntent() {
        return this.mSentIntent;
    }

    public void putAddress(String str) {
        this.mAddress = str;
    }

    public void putContacts(Uri[] uriArr) {
        this.mContacts = uriArr;
    }

    public void putContent(String str) {
        this.mContent = str;
    }

    public void putDateTime(long j2) {
        this.mDateTime = j2;
    }

    public void putDeliveredIntent(PendingIntent pendingIntent) {
        this.mDeliveredIntent = pendingIntent;
    }

    public void putId(String str) {
        this.mId = str;
    }

    public void putName(String str) {
        this.mName = str;
    }

    public void putNumber(String str) {
        this.mNumber = str;
    }

    public void putSentIntent(PendingIntent pendingIntent) {
        this.mSentIntent = pendingIntent;
    }

    public String toString() {
        return "VDBTMessage{id=" + this.mId + ", name=" + this.mName + ", number=" + this.mNumber + ", address=" + this.mAddress + ", dateTime=" + this.mDateTime + ", content=" + this.mContent + ", contacts=" + this.mContacts + ", sentIntent=" + this.mSentIntent + ", deliveredIntent=" + this.mDeliveredIntent + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mNumber);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mContent);
        parcel.writeLong(this.mDateTime);
        parcel.writeTypedArray(this.mContacts, i2);
        parcel.writeParcelable(this.mSentIntent, i2);
        parcel.writeParcelable(this.mDeliveredIntent, i2);
    }

    public static VDEvent createEvent(int i2, ArrayList<VDBTMessage> arrayList) {
        return new VDEvent(i2, createPayload(arrayList));
    }

    public static Bundle createPayload(ArrayList<VDBTMessage> arrayList) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDBTMessage.class.getClassLoader());
        bundle.putParcelableArrayList(VDKey.DATA, arrayList);
        return bundle;
    }

    protected VDBTMessage(Parcel parcel) {
        readFromParcel(parcel);
    }
}
