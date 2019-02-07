package io.realm.internal;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.log.RealmLog;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Util {
    static native String nativeGetTablePrefix();

    public static String getTablePrefix() {
        return nativeGetTablePrefix();
    }

    public static Class<? extends RealmModel> getOriginalModelClass(Class<? extends RealmModel> cls) {
        Class<? extends RealmModel> superclass = cls.getSuperclass();
        return (superclass.equals(Object.class) || superclass.equals(RealmObject.class)) ? cls : superclass;
    }

    public static String getStackTrace(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static boolean isEmulator() {
        if (!(Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith(EnvironmentCompat.MEDIA_UNKNOWN) || Build.MODEL.contains(CommonUtils.GOOGLE_SDK) || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")))) {
            if (!CommonUtils.GOOGLE_SDK.equals(Build.PRODUCT)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmptyString(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    public static boolean deleteRealm(String str, File file, String str2) {
        boolean z;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".management");
        File file2 = new File(file, stringBuilder.toString());
        File[] listFiles = file2.listFiles();
        if (listFiles != null) {
            z = true;
            for (File delete : listFiles) {
                z = z && delete.delete();
            }
        } else {
            z = true;
        }
        boolean z2 = z && file2.delete();
        if (!z2 || deletes(str, file, str2) == null) {
            return false;
        }
        return true;
    }

    private static boolean deletes(String str, File file, String str2) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        File[] fileArr = new File[6];
        fileArr[0] = new File(file, str2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".lock");
        fileArr[1] = new File(file, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".log_a");
        fileArr[2] = new File(file, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".log_b");
        fileArr[3] = new File(file, stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(".log");
        fileArr[4] = new File(file, stringBuilder.toString());
        fileArr[5] = new File(str);
        for (File file2 : Arrays.asList(fileArr)) {
            if (file2.exists() != null && file2.delete() == null) {
                atomicBoolean.set(false);
                RealmLog.warn("Could not delete the file %s", file2);
            }
        }
        return atomicBoolean.get();
    }
}
