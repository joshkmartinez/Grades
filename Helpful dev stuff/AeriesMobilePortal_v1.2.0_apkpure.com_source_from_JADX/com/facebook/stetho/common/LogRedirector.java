package com.facebook.stetho.common;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class LogRedirector {
    private static volatile Logger sLogger;

    public interface Logger {
        boolean isLoggable(String str, int i);

        void log(int i, String str, String str2);
    }

    public static void setLogger(Logger logger) {
        Util.throwIfNull(logger);
        Util.throwIfNotNull(sLogger);
        sLogger = logger;
    }

    public static void m6e(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m5e(str, stringBuilder.toString());
    }

    public static void m5e(String str, String str2) {
        log(6, str, str2);
    }

    public static void m12w(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m11w(str, stringBuilder.toString());
    }

    public static void m11w(String str, String str2) {
        log(5, str, str2);
    }

    public static void m8i(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m7i(str, stringBuilder.toString());
    }

    public static void m7i(String str, String str2) {
        log(4, str, str2);
    }

    public static void m4d(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m3d(str, stringBuilder.toString());
    }

    public static void m3d(String str, String str2) {
        log(3, str, str2);
    }

    public static void m10v(String str, String str2, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        stringBuilder.append(formatThrowable(th));
        m9v(str, stringBuilder.toString());
    }

    public static void m9v(String str, String str2) {
        log(2, str, str2);
    }

    private static String formatThrowable(Throwable th) {
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace();
        printWriter.flush();
        return stringWriter.toString();
    }

    private static void log(int i, String str, String str2) {
        Logger logger = sLogger;
        if (logger != null) {
            logger.log(i, str, str2);
        } else {
            Log.println(i, str, str2);
        }
    }

    public static boolean isLoggable(String str, int i) {
        Logger logger = sLogger;
        if (logger != null) {
            return logger.isLoggable(str, i);
        }
        return Log.isLoggable(str, i);
    }
}
