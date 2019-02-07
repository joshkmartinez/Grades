package io.fabric.sdk.android;

public interface Logger {
    void mo2301d(String str, String str2);

    void mo2302d(String str, String str2, Throwable th);

    void mo2303e(String str, String str2);

    void mo2304e(String str, String str2, Throwable th);

    int getLogLevel();

    void mo2306i(String str, String str2);

    void mo2307i(String str, String str2, Throwable th);

    boolean isLoggable(String str, int i);

    void log(int i, String str, String str2);

    void log(int i, String str, String str2, boolean z);

    void setLogLevel(int i);

    void mo2312v(String str, String str2);

    void mo2313v(String str, String str2, Throwable th);

    void mo2314w(String str, String str2);

    void mo2315w(String str, String str2, Throwable th);
}
