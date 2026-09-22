package com.desaysv.ivi.vdb.utils;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public class VDLogUtil {
    public static void d() {
    }

    public static void d(String str) {
    }

    public static void d(String str, String str2) {
    }

    public static void d(String str, String str2, String str3) {
    }

    public static void e() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            printE("", "", "", 0);
            return;
        }
        String fileName = stackTrace[3].getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        } else {
            int lastIndexOf = fileName.lastIndexOf(46);
            if (lastIndexOf > -1 && lastIndexOf < fileName.length()) {
                fileName = fileName.substring(0, lastIndexOf);
            }
        }
        printE(fileName, stackTrace[3].getMethodName(), "", stackTrace[3].getLineNumber());
    }

    private static String getMsg(String str, String str2, int i2) {
        String str3 = ("[" + str + "]") + "(" + i2 + ")";
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        return str3 + str2;
    }

    public static void i() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length < 4) {
            printI("", "", "", 0);
            return;
        }
        String fileName = stackTrace[3].getFileName();
        if (TextUtils.isEmpty(fileName)) {
            fileName = "";
        } else {
            int lastIndexOf = fileName.lastIndexOf(46);
            if (lastIndexOf > -1 && lastIndexOf < fileName.length()) {
                fileName = fileName.substring(0, lastIndexOf);
            }
        }
        printI(fileName, stackTrace[3].getMethodName(), "", stackTrace[3].getLineNumber());
    }

    private static void printD(String str, String str2, String str3, int i2) {
        Log.d(str, getMsg(str2, str3, i2));
    }

    private static void printE(String str, String str2, String str3, int i2) {
        Log.e(str, getMsg(str2, str3, i2));
    }

    private static void printI(String str, String str2, String str3, int i2) {
        Log.i(str, getMsg(str2, str3, i2));
    }

    public static void e(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str2 = "";
        if (stackTrace != null && stackTrace.length >= 4) {
            String fileName = stackTrace[3].getFileName();
            if (!TextUtils.isEmpty(fileName)) {
                int lastIndexOf = fileName.lastIndexOf(46);
                str2 = (lastIndexOf <= -1 || lastIndexOf >= fileName.length()) ? fileName : fileName.substring(0, lastIndexOf);
            }
            printE(str2, stackTrace[3].getMethodName(), str, stackTrace[3].getLineNumber());
            return;
        }
        printE("", "", str, 0);
    }

    public static void i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str2 = "";
        if (stackTrace != null && stackTrace.length >= 4) {
            String fileName = stackTrace[3].getFileName();
            if (!TextUtils.isEmpty(fileName)) {
                int lastIndexOf = fileName.lastIndexOf(46);
                str2 = (lastIndexOf <= -1 || lastIndexOf >= fileName.length()) ? fileName : fileName.substring(0, lastIndexOf);
            }
            printI(str2, stackTrace[3].getMethodName(), str, stackTrace[3].getLineNumber());
            return;
        }
        printI("", "", str, 0);
    }

    public static void e(String str, String str2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str3 = "";
        if (stackTrace != null && stackTrace.length >= 4) {
            String fileName = stackTrace[3].getFileName();
            if (!TextUtils.isEmpty(fileName)) {
                int lastIndexOf = fileName.lastIndexOf(46);
                str3 = (lastIndexOf <= -1 || lastIndexOf >= fileName.length()) ? fileName : fileName.substring(0, lastIndexOf);
            }
            printE(str3, str, str2, stackTrace[3].getLineNumber());
            return;
        }
        printE("", str, str2, 0);
    }

    public static void i(String str, String str2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String str3 = "";
        if (stackTrace != null && stackTrace.length >= 4) {
            String fileName = stackTrace[3].getFileName();
            if (!TextUtils.isEmpty(fileName)) {
                int lastIndexOf = fileName.lastIndexOf(46);
                str3 = (lastIndexOf <= -1 || lastIndexOf >= fileName.length()) ? fileName : fileName.substring(0, lastIndexOf);
            }
            printI(str3, str, str2, stackTrace[3].getLineNumber());
            return;
        }
        printI("", str, str2, 0);
    }

    public static void e(String str, String str2, String str3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length >= 4) {
            printE(str, str2, str3, stackTrace[3].getLineNumber());
        } else {
            printE(str, str2, str3, 0);
        }
    }

    public static void i(String str, String str2, String str3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length >= 4) {
            printI(str, str2, str3, stackTrace[3].getLineNumber());
        } else {
            printI(str, str2, str3, 0);
        }
    }
}
