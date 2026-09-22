package com.desaysv.ivi.vdb.event.id.carlan.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.desaysv.ivi.vdb.event.VDEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
public class VDTboxOtaReq implements Parcelable {
    public static final Parcelable.Creator<VDTboxOtaReq> CREATOR = new Parcelable.Creator<VDTboxOtaReq>() { // from class: com.desaysv.ivi.vdb.event.id.carlan.bean.VDTboxOtaReq.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTboxOtaReq createFromParcel(Parcel parcel) {
            return new VDTboxOtaReq(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VDTboxOtaReq[] newArray(int i2) {
            return new VDTboxOtaReq[i2];
        }
    };
    private int mAck;
    private String mAfterVersion;
    private String mApnName;
    private String mCheckSumCode;
    private int mCheckmethod;
    private String mCommandType;
    private int mConfirmType;
    private int mDiffType;
    private int mEcuId;
    private String mEcuName;
    private int mEcuNumber;
    private int mErrorCode;
    private int mEstimateUpgradeTime;
    private long mEventTime;
    private long mFileSize;
    private int mFileType;
    private int mForceUpdate;
    private String mHardwareAfterVersion;
    private String mHardwareBeforeVersion;
    private String mHardwareversion;
    private byte[] mMessageID;
    private int mNeedUploadLog;
    private int mOrderTime;
    private int mOtaModel;
    private String mPartNum;
    private byte[] mPreconditionList;
    private int mProgress;
    private String mReleaseNote;
    private String mReleaseNote1;
    private String mRollbackFileDownloadAddr;
    private String mRollbackTargetVersion;
    private String mSessionId;
    private String mSid;
    private String mSoftwareAfterVersion;
    private String mSoftwareBeforeVersion;
    private String mTargetUdsAddress;
    private String mTargetVersion;
    private long mTaskId;
    private int mUpdateModel;
    private int mUpdateResult;
    private String mUpdateSourceVersion;
    private int mUpdateState;
    private String mUpgradeUrl;
    private String mUserDisclaimer;

    public VDTboxOtaReq() {
    }

    public static VDEvent createEvent(int i2, VDTboxOtaReq vDTboxOtaReq) {
        return new VDEvent(i2, createPayload(vDTboxOtaReq));
    }

    public static Bundle createPayload(VDTboxOtaReq vDTboxOtaReq) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(VDTboxOtaReq.class.getClassLoader());
        bundle.putParcelable("info", vDTboxOtaReq);
        return bundle;
    }

    public static VDTboxOtaReq getValue(VDEvent vDEvent) {
        if (vDEvent == null || vDEvent.getPayload() == null) {
            return null;
        }
        vDEvent.getPayload().setClassLoader(VDTboxOtaReq.class.getClassLoader());
        return (VDTboxOtaReq) vDEvent.getPayload().getParcelable("info");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAck() {
        return this.mAck;
    }

    public String getAfterVersion() {
        return this.mAfterVersion;
    }

    public String getApnName() {
        return this.mApnName;
    }

    public String getCheckSumCode() {
        return this.mCheckSumCode;
    }

    public int getCheckmethod() {
        return this.mCheckmethod;
    }

    public String getCommandType() {
        return this.mCommandType;
    }

    public int getConfirmType() {
        return this.mConfirmType;
    }

    public int getDiffType() {
        return this.mDiffType;
    }

    public int getEcuId() {
        return this.mEcuId;
    }

    public String getEcuName() {
        return this.mEcuName;
    }

    public int getEcuNumber() {
        return this.mEcuNumber;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public int getEstimateUpgradeTime() {
        return this.mEstimateUpgradeTime;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public long getFileSize() {
        return this.mFileSize;
    }

    public int getFileType() {
        return this.mFileType;
    }

    public int getForceUpdate() {
        return this.mForceUpdate;
    }

    public String getHardwareAfterVersion() {
        return this.mHardwareAfterVersion;
    }

    public String getHardwareBeforeVersion() {
        return this.mHardwareBeforeVersion;
    }

    public String getHardwareversion() {
        return this.mHardwareversion;
    }

    public byte[] getMessageID() {
        return this.mMessageID;
    }

    public int getNeedUploadLog() {
        return this.mNeedUploadLog;
    }

    public int getOrderTime() {
        return this.mOrderTime;
    }

    public int getOtaModel() {
        return this.mOtaModel;
    }

    public String getPartNum() {
        return this.mPartNum;
    }

    public byte[] getPreconditionList() {
        return this.mPreconditionList;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public String getReleaseNote() {
        return this.mReleaseNote;
    }

    public String getReleaseNote1() {
        return this.mReleaseNote1;
    }

    public String getRollbackFileDownloadAddr() {
        return this.mRollbackFileDownloadAddr;
    }

    public String getRollbackTargetVersion() {
        return this.mRollbackTargetVersion;
    }

    public String getSessionId() {
        return this.mSessionId;
    }

    public String getSid() {
        return this.mSid;
    }

    public String getSoftwareAfterVersion() {
        return this.mSoftwareAfterVersion;
    }

    public String getSoftwareBeforeVersion() {
        return this.mSoftwareBeforeVersion;
    }

    public String getTargetUdsAddress() {
        return this.mTargetUdsAddress;
    }

    public String getTargetVersion() {
        return this.mTargetVersion;
    }

    public long getTaskId() {
        return this.mTaskId;
    }

    public int getUpdateModel() {
        return this.mUpdateModel;
    }

    public int getUpdateResult() {
        return this.mUpdateResult;
    }

    public String getUpdateSourceVersion() {
        return this.mUpdateSourceVersion;
    }

    public int getUpdateState() {
        return this.mUpdateState;
    }

    public String getUpgradeUrl() {
        return this.mUpgradeUrl;
    }

    public String getUserDisclaimer() {
        return this.mUserDisclaimer;
    }

    public void setAck(int i2) {
        this.mAck = i2;
    }

    public void setAfterVersion(String str) {
        this.mAfterVersion = str;
    }

    public void setApnName(String str) {
        this.mApnName = str;
    }

    public void setCheckSumCode(String str) {
        this.mCheckSumCode = str;
    }

    public void setCheckmethod(int i2) {
        this.mCheckmethod = i2;
    }

    public void setCommandType(String str) {
        this.mCommandType = str;
    }

    public void setConfirmType(int i2) {
        this.mConfirmType = i2;
    }

    public void setDiffType(int i2) {
        this.mDiffType = i2;
    }

    public void setEcuId(int i2) {
        this.mEcuId = i2;
    }

    public void setEcuName(String str) {
        this.mEcuName = str;
    }

    public void setEcuNumber(int i2) {
        this.mEcuNumber = i2;
    }

    public void setErrorCode(int i2) {
        this.mErrorCode = i2;
    }

    public void setEstimateUpgradeTime(int i2) {
        this.mEstimateUpgradeTime = i2;
    }

    public void setEventTime(long j2) {
        this.mEventTime = j2;
    }

    public void setFileSize(long j2) {
        this.mFileSize = j2;
    }

    public void setFileType(int i2) {
        this.mFileType = i2;
    }

    public void setForceUpdate(int i2) {
        this.mForceUpdate = i2;
    }

    public void setHardwareAfterVersion(String str) {
        this.mHardwareAfterVersion = str;
    }

    public void setHardwareBeforeVersion(String str) {
        this.mHardwareBeforeVersion = str;
    }

    public void setHardwareversion(String str) {
        this.mHardwareversion = str;
    }

    public void setMessageID(byte[] bArr) {
        this.mMessageID = bArr;
    }

    public void setNeedUploadLog(int i2) {
        this.mNeedUploadLog = i2;
    }

    public void setOrderTime(int i2) {
        this.mOrderTime = i2;
    }

    public void setOtaModel(int i2) {
        this.mOtaModel = i2;
    }

    public void setPartNum(String str) {
        this.mPartNum = str;
    }

    public void setPreconditionList(byte[] bArr) {
        this.mPreconditionList = bArr;
    }

    public void setProgress(int i2) {
        this.mProgress = i2;
    }

    public void setReleaseNote(String str) {
        this.mReleaseNote = str;
    }

    public void setReleaseNote1(String str) {
        this.mReleaseNote1 = str;
    }

    public void setRollbackFileDownloadAddr(String str) {
        this.mRollbackFileDownloadAddr = str;
    }

    public void setRollbackTargetVersion(String str) {
        this.mRollbackTargetVersion = str;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public void setSid(String str) {
        this.mSid = str;
    }

    public void setSoftwareAfterVersion(String str) {
        this.mSoftwareAfterVersion = str;
    }

    public void setSoftwareBeforeVersion(String str) {
        this.mSoftwareBeforeVersion = str;
    }

    public void setTargetUdsAddress(String str) {
        this.mTargetUdsAddress = str;
    }

    public void setTargetVersion(String str) {
        this.mTargetVersion = str;
    }

    public void setTaskId(long j2) {
        this.mTaskId = j2;
    }

    public void setUpdateModel(int i2) {
        this.mUpdateModel = i2;
    }

    public void setUpdateResult(int i2) {
        this.mUpdateResult = i2;
    }

    public void setUpdateSourceVersion(String str) {
        this.mUpdateSourceVersion = str;
    }

    public void setUpdateState(int i2) {
        this.mUpdateState = i2;
    }

    public void setUpgradeUrl(String str) {
        this.mUpgradeUrl = str;
    }

    public void setUserDisclaimer(String str) {
        this.mUserDisclaimer = str;
    }

    public String toString() {
        return "VDTboxOtaReq{mCommandType='" + this.mCommandType + "', mAck=" + this.mAck + ", mUpdateModel=" + this.mUpdateModel + ", mTargetVersion='" + this.mTargetVersion + "', mUpgradeUrl='" + this.mUpgradeUrl + "', mCheckmethod=" + this.mCheckmethod + ", mCheckSumCode='" + this.mCheckSumCode + "', mApnName='" + this.mApnName + "', mFileSize=" + this.mFileSize + ", mForceUpdate=" + this.mForceUpdate + ", mFileType=" + this.mFileType + ", mDiffType=" + this.mDiffType + ", mTaskId=" + this.mTaskId + ", mOtaModel=" + this.mOtaModel + ", mEstimateUpgradeTime=" + this.mEstimateUpgradeTime + ", mHardwareversion='" + this.mHardwareversion + "', mSid='" + this.mSid + "', mUpdateSourceVersion='" + this.mUpdateSourceVersion + "', mPreconditionList=" + Arrays.toString(this.mPreconditionList) + ", mTargetUdsAddress='" + this.mTargetUdsAddress + "', mSessionId='" + this.mSessionId + "', mNeedUploadLog=" + this.mNeedUploadLog + ", mRollbackTargetVersion='" + this.mRollbackTargetVersion + "', mRollbackFileDownloadAddr='" + this.mRollbackFileDownloadAddr + "', mPartNum='" + this.mPartNum + "', mReleaseNote='" + this.mReleaseNote + "', mEcuId=" + this.mEcuId + ", mEcuNumber=" + this.mEcuNumber + ", mProgress=" + this.mProgress + ", mUpdateResult=" + this.mUpdateResult + ", mErrorCode=" + this.mErrorCode + ", mAfterVersion='" + this.mAfterVersion + "', mEcuName='" + this.mEcuName + "', mUpdateState=" + this.mUpdateState + ", mHardwareBeforeVersion='" + this.mHardwareBeforeVersion + "', mSoftwareBeforeVersion='" + this.mSoftwareBeforeVersion + "', mHardwareAfterVersion='" + this.mHardwareAfterVersion + "', mSoftwareAfterVersion='" + this.mSoftwareAfterVersion + "', mConfirmType=" + this.mConfirmType + ", mOrderTime=" + this.mOrderTime + ", mEventTime=" + this.mEventTime + ", mMessageID=" + Arrays.toString(this.mMessageID) + ", mUserDisclaimer='" + this.mUserDisclaimer + "', mReleaseNote1='" + this.mReleaseNote1 + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mCommandType);
        parcel.writeInt(this.mAck);
        parcel.writeInt(this.mUpdateModel);
        parcel.writeString(this.mTargetVersion);
        parcel.writeString(this.mUpgradeUrl);
        parcel.writeInt(this.mCheckmethod);
        parcel.writeString(this.mCheckSumCode);
        parcel.writeString(this.mApnName);
        parcel.writeLong(this.mFileSize);
        parcel.writeInt(this.mForceUpdate);
        parcel.writeInt(this.mFileType);
        parcel.writeInt(this.mDiffType);
        parcel.writeLong(this.mTaskId);
        parcel.writeInt(this.mOtaModel);
        parcel.writeInt(this.mEstimateUpgradeTime);
        parcel.writeString(this.mHardwareversion);
        parcel.writeString(this.mSid);
        parcel.writeString(this.mUpdateSourceVersion);
        parcel.writeByteArray(this.mPreconditionList);
        parcel.writeString(this.mTargetUdsAddress);
        parcel.writeString(this.mSessionId);
        parcel.writeInt(this.mNeedUploadLog);
        parcel.writeString(this.mRollbackTargetVersion);
        parcel.writeString(this.mRollbackFileDownloadAddr);
        parcel.writeString(this.mPartNum);
        parcel.writeString(this.mReleaseNote);
        parcel.writeInt(this.mEcuId);
        parcel.writeInt(this.mEcuNumber);
        parcel.writeInt(this.mProgress);
        parcel.writeInt(this.mUpdateResult);
        parcel.writeInt(this.mErrorCode);
        parcel.writeString(this.mAfterVersion);
        parcel.writeString(this.mEcuName);
        parcel.writeInt(this.mUpdateState);
        parcel.writeString(this.mHardwareBeforeVersion);
        parcel.writeString(this.mSoftwareBeforeVersion);
        parcel.writeString(this.mHardwareAfterVersion);
        parcel.writeString(this.mSoftwareAfterVersion);
        parcel.writeInt(this.mConfirmType);
        parcel.writeInt(this.mOrderTime);
        parcel.writeLong(this.mEventTime);
        parcel.writeByteArray(this.mMessageID);
        parcel.writeString(this.mUserDisclaimer);
        parcel.writeString(this.mReleaseNote1);
    }

    protected VDTboxOtaReq(Parcel parcel) {
        this.mCommandType = parcel.readString();
        this.mAck = parcel.readInt();
        this.mUpdateModel = parcel.readInt();
        this.mTargetVersion = parcel.readString();
        this.mUpgradeUrl = parcel.readString();
        this.mCheckmethod = parcel.readInt();
        this.mCheckSumCode = parcel.readString();
        this.mApnName = parcel.readString();
        this.mFileSize = parcel.readLong();
        this.mForceUpdate = parcel.readInt();
        this.mFileType = parcel.readInt();
        this.mDiffType = parcel.readInt();
        this.mTaskId = parcel.readLong();
        this.mOtaModel = parcel.readInt();
        this.mEstimateUpgradeTime = parcel.readInt();
        this.mHardwareversion = parcel.readString();
        this.mSid = parcel.readString();
        this.mUpdateSourceVersion = parcel.readString();
        this.mPreconditionList = parcel.createByteArray();
        this.mTargetUdsAddress = parcel.readString();
        this.mSessionId = parcel.readString();
        this.mNeedUploadLog = parcel.readInt();
        this.mRollbackTargetVersion = parcel.readString();
        this.mRollbackFileDownloadAddr = parcel.readString();
        this.mPartNum = parcel.readString();
        this.mReleaseNote = parcel.readString();
        this.mEcuId = parcel.readInt();
        this.mEcuNumber = parcel.readInt();
        this.mProgress = parcel.readInt();
        this.mUpdateResult = parcel.readInt();
        this.mErrorCode = parcel.readInt();
        this.mAfterVersion = parcel.readString();
        this.mEcuName = parcel.readString();
        this.mUpdateState = parcel.readInt();
        this.mHardwareBeforeVersion = parcel.readString();
        this.mSoftwareBeforeVersion = parcel.readString();
        this.mHardwareAfterVersion = parcel.readString();
        this.mSoftwareAfterVersion = parcel.readString();
        this.mConfirmType = parcel.readInt();
        this.mOrderTime = parcel.readInt();
        this.mEventTime = parcel.readLong();
        this.mMessageID = parcel.createByteArray();
        this.mUserDisclaimer = parcel.readString();
        this.mReleaseNote1 = parcel.readString();
    }
}
