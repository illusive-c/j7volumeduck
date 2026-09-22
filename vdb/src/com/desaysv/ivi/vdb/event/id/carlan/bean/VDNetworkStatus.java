package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;

/* loaded from: classes.dex */
public class VDNetworkStatus implements Parcelable {
    public static final Parcelable.Creator<VDNetworkStatus> CREATOR = new Parcelable.Creator<VDNetworkStatus>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDNetworkStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNetworkStatus createFromParcel(Parcel parcel) {
            return new VDNetworkStatus(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDNetworkStatus[] newArray(int i2) {
            return new VDNetworkStatus[i2];
        }
    };
    private String addressVPNIp;
    private String commandType;
    private boolean dataConnection;
    private String mobileNetworkType;
    private int networkCommandResp;
    private int networkStateReq;
    private int reportCycle;
    private boolean roaming;
    private String routerIPAddress;
    private int signalStrength;
    private boolean simCardRegistraionStatus;

    public VDNetworkStatus() {
    }

    public static VDEvent createEvent(int i2, VDNetworkStatus vDNetworkStatus) {
        return new VDEvent(i2, createPayload(vDNetworkStatus));
    }

    public static Bundle createPayload(VDNetworkStatus vDNetworkStatus) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDNetworkStatus.class.getClassLoader());
        bundle.putParcelable("info", vDNetworkStatus);
        return bundle;
    }

    public static VDNetworkStatus getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDNetworkStatus.class.getClassLoader());
        return (VDNetworkStatus) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddressVPNIp() {
        return this.addressVPNIp;
    }

    public String getCommandType() {
        return this.commandType;
    }

    public String getMobileNetworkType() {
        return this.mobileNetworkType;
    }

    public int getNetworkCommandResp() {
        return this.networkCommandResp;
    }

    public int getNetworkStateReq() {
        return this.networkStateReq;
    }

    public int getReportCycle() {
        return this.reportCycle;
    }

    public String getRouterIPAddress() {
        return this.routerIPAddress;
    }

    public int getSignalStrength() {
        return this.signalStrength;
    }

    public boolean isDataConnection() {
        return this.dataConnection;
    }

    public boolean isRoaming() {
        return this.roaming;
    }

    public boolean isSimCardRegistraionStatus() {
        return this.simCardRegistraionStatus;
    }

    public void setAddressVPNIp(String str) {
        this.addressVPNIp = str;
    }

    public void setCommandType(String str) {
        this.commandType = str;
    }

    public void setDataConnection(boolean z2) {
        this.dataConnection = z2;
    }

    public void setMobileNetworkType(String str) {
        this.mobileNetworkType = str;
    }

    public void setNetworkCommandResp(int i2) {
        this.networkCommandResp = i2;
    }

    public void setNetworkStateReq(int i2) {
        this.networkStateReq = i2;
    }

    public void setReportCycle(int i2) {
        this.reportCycle = i2;
    }

    public void setRoaming(boolean z2) {
        this.roaming = z2;
    }

    public void setRouterIPAddress(String str) {
        this.routerIPAddress = str;
    }

    public void setSignalStrength(int i2) {
        this.signalStrength = i2;
    }

    public void setSimCardRegistraionStatus(boolean z2) {
        this.simCardRegistraionStatus = z2;
    }

    public String toString() {
        return "VDNetworkStatus{dataConnection=" + this.dataConnection + ", simCardRegistraionStatus=" + this.simCardRegistraionStatus + ", mobileNetworkType='" + this.mobileNetworkType + "', roaming=" + this.roaming + ", signalStrength=" + this.signalStrength + ", routerIPAddress='" + this.routerIPAddress + "', addressVPNIp='" + this.addressVPNIp + "', commandType='" + this.commandType + "', networkCommandResp=" + this.networkCommandResp + ", networkStateReq=" + this.networkStateReq + ", reportCycle=" + this.reportCycle + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.dataConnection ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.simCardRegistraionStatus ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mobileNetworkType);
        parcel.writeByte(this.roaming ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.signalStrength);
        parcel.writeString(this.routerIPAddress);
        parcel.writeString(this.addressVPNIp);
        parcel.writeString(this.commandType);
        parcel.writeInt(this.networkCommandResp);
        parcel.writeInt(this.networkStateReq);
        parcel.writeInt(this.reportCycle);
    }

    protected VDNetworkStatus(Parcel parcel) {
        this.dataConnection = parcel.readByte() != 0;
        this.simCardRegistraionStatus = parcel.readByte() != 0;
        this.mobileNetworkType = parcel.readString();
        this.roaming = parcel.readByte() != 0;
        this.signalStrength = parcel.readInt();
        this.routerIPAddress = parcel.readString();
        this.addressVPNIp = parcel.readString();
        this.commandType = parcel.readString();
        this.networkCommandResp = parcel.readInt();
        this.networkStateReq = parcel.readInt();
        this.reportCycle = parcel.readInt();
    }
}
