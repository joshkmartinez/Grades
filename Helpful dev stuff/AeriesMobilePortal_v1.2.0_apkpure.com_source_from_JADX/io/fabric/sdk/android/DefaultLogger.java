package io.fabric.sdk.android;

import android.util.Log;

public class DefaultLogger implements Logger {
    private int logLevel;

    public DefaultLogger(int i) {
        this.logLevel = i;
    }

    public DefaultLogger() {
        this.logLevel = 4;
    }

    public boolean isLoggable(String str, int i) {
        return this.logLevel <= i ? true : null;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(int i) {
        this.logLevel = i;
    }

    public void mo2302d(String str, String str2, Throwable th) {
        if (isLoggable(str, 3)) {
            Log.d(str, str2, th);
        }
    }

    public void mo2313v(String str, String str2, Throwable th) {
        if (isLoggable(str, 2)) {
            Log.v(str, str2, th);
        }
    }

    public void mo2307i(String str, String str2, Throwable th) {
        if (isLoggable(str, 4)) {
            Log.i(str, str2, th);
        }
    }

    public void mo2315w(String str, String str2, Throwable th) {
        if (isLoggable(str, 5)) {
            Log.w(str, str2, th);
        }
    }

    public void mo2304e(String str, String str2, Throwable th) {
        if (isLoggable(str, 6)) {
            Log.e(str, str2, th);
        }
    }

    public void mo2301d(String str, String str2) {
        mo2302d(str, str2, null);
    }

    public void mo2312v(String str, String str2) {
        mo2313v(str, str2, null);
    }

    public void mo2306i(String str, String str2) {
        mo2307i(str, str2, null);
    }

    public void mo2314w(String str, String str2) {
        mo2315w(str, str2, null);
    }

    public void mo2303e(String str, String str2) {
        mo2304e(str, str2, null);
    }

    public void log(int i, String str, String str2) {
        log(i, str, str2, false);
    }

    public void log(int i, String str, String str2, boolean z) {
        if (z || isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }
}
