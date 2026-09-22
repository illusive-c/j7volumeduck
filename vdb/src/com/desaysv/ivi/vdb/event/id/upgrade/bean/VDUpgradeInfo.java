package com.desaysv.ivi.vdb.event.id.upgrade.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import com.desaysv.ivi.vdb.event.base.VDKey;

/* loaded from: classes.dex */
public class VDUpgradeInfo implements Parcelable {
    public static final int ALL = 0;
    public static final int APA = 10;
    public static final int APA_CONFIG_ERROR = 1005;
    public static final int ARHUD = 11;
    public static final int AVM_CONFIG_ERROR = 1006;
    public static final int BIOS = 13;
    public static final int COPY = 4;
    public static final Parcelable.Creator<VDUpgradeInfo> CREATOR = new Parcelable.Creator<VDUpgradeInfo>() { // from class: com.desaysv.ivi.vdb.event.id.upgrade.bean.VDUpgradeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDUpgradeInfo createFromParcel(Parcel parcel) {
            return new VDUpgradeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDUpgradeInfo[] newArray(int i2) {
            return new VDUpgradeInfo[i2];
        }
    };
    public static final int DISPLAY = 6;
    public static final int DISPLAY_WHOLE = 8;
    public static final int DOING = 1;
    public static final int DSP = 5;
    public static final int ECU = 3;
    public static final int FAILED = 2;
    public static final int FILE_UNZIP_ERROR = 1015;
    public static final int FINISHED = 3;
    public static final int GPS = 4;
    public static final int IDCU_CONFIG_ERROR = 1007;
    public static final int MCU = 1;
    public static final int MCU_MODEL_ERROR = 1004;
    public static final int NAVI_TTS = 15;
    public static final int NO_SPACE_LEFT_ERROR = 1014;
    public static final int OTA = 7;
    public static final int PARTITION_ERROR = 1002;
    public static final int PKG_INVALID_ERROR = 1010;
    public static final int PKG_MODEL_ERROR = 1003;
    public static final int PKG_PARTNUM_ERROR = 1013;
    public static final int PKG_UNSIGN_ERROR = 1011;
    public static final int PREPARE = 0;
    public static final int QNX_COMM_TIMEOUT_ERROR = 1009;
    public static final int RADAR_CONFIG_ERROR = 1012;
    public static final int RADAR_MCU = 14;
    public static final int RVC_CONFIG_ERROR = 1008;
    public static final int SOC = 2;
    public static final int UNKNOWN = 1000;
    public static final int UNSIGN = 6;
    public static final int UNZIP = 5;
    public static final int UPDATE_FILE_COPY_EXCEPTION = 1001;
    public static final int VBF = 12;
    public static final int VR = 9;
    public static final int VR_TTS = 16;
    private int currentUpTask;
    private int errorCode;
    private String filePath;
    private int progress;
    private String signPath;
    private int status;
    private int taskIndex;
    private String taskName;

    public VDUpgradeInfo() {
    }

    public static VDEvent createEvent(int i2, VDUpgradeInfo vDUpgradeInfo) {
        return new VDEvent(i2, createPayload(vDUpgradeInfo));
    }

    public static Bundle createPayload(VDUpgradeInfo vDUpgradeInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDUpgradeInfo.class.getClassLoader());
        bundle.putParcelable(VDKey.DATA, vDUpgradeInfo);
        return bundle;
    }

    public static VDUpgradeInfo getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDUpgradeInfo.class.getClassLoader());
        return (VDUpgradeInfo) vDEvent.getPayload().getParcelable(VDKey.DATA);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentUpTask() {
        return this.currentUpTask;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public int getProgress() {
        return this.progress;
    }

    public String getSignPath() {
        return this.signPath;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTaskIndex() {
        return this.taskIndex;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setCurrentUpTask(int i2) {
        this.currentUpTask = i2;
    }

    public void setErrorCode(int i2) {
        this.errorCode = i2;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setProgress(int i2) {
        this.progress = i2;
    }

    public void setSignPath(String str) {
        this.signPath = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setTaskIndex(int i2) {
        this.taskIndex = i2;
    }

    public void setTaskName(String str) {
        this.taskName = str;
    }

    public String toString() {
        return "VDUpgradeInfo{errorCode=" + this.errorCode + ", status=" + this.status + ", currentUpTask=" + this.currentUpTask + ", progress=" + this.progress + ", filePath='" + this.filePath + "', taskIndex=" + this.taskIndex + ", taskName='" + this.taskName + "', signPath='" + this.signPath + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.progress);
        parcel.writeInt(this.currentUpTask);
        parcel.writeInt(this.status);
        parcel.writeInt(this.errorCode);
        parcel.writeString(this.filePath);
        parcel.writeInt(this.taskIndex);
        parcel.writeString(this.taskName);
        parcel.writeString(this.signPath);
    }

    protected VDUpgradeInfo(Parcel parcel) {
        this.progress = parcel.readInt();
        this.currentUpTask = parcel.readInt();
        this.status = parcel.readInt();
        this.errorCode = parcel.readInt();
        this.filePath = parcel.readString();
        this.taskIndex = parcel.readInt();
        this.taskName = parcel.readString();
        this.signPath = parcel.readString();
    }
}
