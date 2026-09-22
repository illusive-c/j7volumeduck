package com.desaysv.ivi.vdb.event.id.tuner.bean.dab;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class VDDABHeadlineMessage implements Parcelable {
    public static final Parcelable.Creator<VDDABHeadlineMessage> CREATOR = new Parcelable.Creator<VDDABHeadlineMessage>() { // from class: com.desaysv.ivi.vdb.event.id.tuner.bean.dab.VDDABHeadlineMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadlineMessage createFromParcel(Parcel parcel) {
            return new VDDABHeadlineMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDDABHeadlineMessage[] newArray(int i2) {
            return new VDDABHeadlineMessage[i2];
        }
    };
    private List<String> bodyList;
    private String title;
    private int type;

    public VDDABHeadlineMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<String> getBodyList() {
        return this.bodyList;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public void putBodyList(List<String> list) {
        this.bodyList = list;
    }

    public void putTitle(String str) {
        this.title = str;
    }

    public void putType(int i2) {
        this.type = i2;
    }

    public String toString() {
        return "VDDABHeadlineMessage{title='" + this.title + "', type=" + this.type + ", bodyList=" + this.bodyList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.title);
        parcel.writeInt(this.type);
        parcel.writeStringList(this.bodyList);
    }

    protected VDDABHeadlineMessage(Parcel parcel) {
        this.title = parcel.readString();
        this.type = parcel.readInt();
        this.bodyList = parcel.createStringArrayList();
    }
}
