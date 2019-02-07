package com.facebook.stetho.common;

import java.util.Locale;

public class LogUtil {
    private static final String TAG = "stetho";

    public static void m18e(String str, Object... objArr) {
        m17e(format(str, objArr));
    }

    public static void m20e(Throwable th, String str, Object... objArr) {
        m19e(th, format(str, objArr));
    }

    public static void m17e(String str) {
        if (isLoggable(6)) {
            LogRedirector.m5e(TAG, str);
        }
    }

    public static void m19e(Throwable th, String str) {
        if (isLoggable(6)) {
            LogRedirector.m6e(TAG, str, th);
        }
    }

    public static void m30w(String str, Object... objArr) {
        m29w(format(str, objArr));
    }

    public static void m32w(Throwable th, String str, Object... objArr) {
        m31w(th, format(str, objArr));
    }

    public static void m29w(String str) {
        if (isLoggable(5)) {
            LogRedirector.m11w(TAG, str);
        }
    }

    public static void m31w(Throwable th, String str) {
        if (isLoggable(5)) {
            LogRedirector.m12w(TAG, str, th);
        }
    }

    public static void m22i(String str, Object... objArr) {
        m21i(format(str, objArr));
    }

    public static void m24i(Throwable th, String str, Object... objArr) {
        m23i(th, format(str, objArr));
    }

    public static void m21i(String str) {
        if (isLoggable(4)) {
            LogRedirector.m7i(TAG, str);
        }
    }

    public static void m23i(Throwable th, String str) {
        if (isLoggable(4)) {
            LogRedirector.m8i(TAG, str, th);
        }
    }

    public static void m14d(String str, Object... objArr) {
        m13d(format(str, objArr));
    }

    public static void m16d(Throwable th, String str, Object... objArr) {
        m15d(th, format(str, objArr));
    }

    public static void m13d(String str) {
        if (isLoggable(3)) {
            LogRedirector.m3d(TAG, str);
        }
    }

    public static void m15d(Throwable th, String str) {
        if (isLoggable(3)) {
            LogRedirector.m4d(TAG, str, th);
        }
    }

    public static void m26v(String str, Object... objArr) {
        m25v(format(str, objArr));
    }

    public static void m28v(Throwable th, String str, Object... objArr) {
        m27v(th, format(str, objArr));
    }

    public static void m25v(String str) {
        if (isLoggable(2)) {
            LogRedirector.m9v(TAG, str);
        }
    }

    public static void m27v(Throwable th, String str) {
        if (isLoggable(2)) {
            LogRedirector.m10v(TAG, str, th);
        }
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static boolean isLoggable(int i) {
        switch (i) {
            case 5:
            case 6:
                return true;
            default:
                return LogRedirector.isLoggable(TAG, i);
        }
    }
}
