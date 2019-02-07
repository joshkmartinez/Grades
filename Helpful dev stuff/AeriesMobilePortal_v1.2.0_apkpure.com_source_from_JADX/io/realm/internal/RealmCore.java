package io.realm.internal;

import android.content.Context;
import com.getkeepsafe.relinker.ReLinker;
import io.realm.BuildConfig;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Locale;

public class RealmCore {
    private static final String BINARIES_PATH;
    private static final String FILE_SEP = File.separator;
    private static final String JAVA_LIBRARY_PATH = "java.library.path";
    private static final String PATH_SEP = File.pathSeparator;
    private static volatile boolean libraryIsLoaded = false;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lib");
        stringBuilder.append(PATH_SEP);
        stringBuilder.append("..");
        stringBuilder.append(FILE_SEP);
        stringBuilder.append("lib");
        BINARIES_PATH = stringBuilder.toString();
    }

    public static boolean osIsWindows() {
        return System.getProperty("os.name").toLowerCase(Locale.getDefault()).contains("win");
    }

    public static synchronized void loadLibrary(Context context) {
        synchronized (RealmCore.class) {
            if (libraryIsLoaded) {
                return;
            }
            ReLinker.loadLibrary(context, "realm-jni", BuildConfig.VERSION_NAME);
            libraryIsLoaded = true;
        }
    }

    private static java.lang.String loadLibraryWindows() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = BINARIES_PATH;	 Catch:{ Throwable -> 0x0008 }
        addNativeLibraryPath(r0);	 Catch:{ Throwable -> 0x0008 }
        resetLibraryPath();	 Catch:{ Throwable -> 0x0008 }
    L_0x0008:
        r0 = "realm_jni32d";
        r1 = "realm_jni64d";
        r0 = new java.lang.String[]{r0, r1};
        r0 = loadCorrectLibrary(r0);
        if (r0 == 0) goto L_0x001e;
    L_0x0016:
        r1 = java.lang.System.out;
        r2 = "!!! Realm debug version loaded. !!!\n";
        r1.println(r2);
        goto L_0x002c;
    L_0x001e:
        r0 = "realm_jni32";
        r1 = "realm_jni64";
        r0 = new java.lang.String[]{r0, r1};
        r0 = loadCorrectLibrary(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x002c:
        return r0;
    L_0x002d:
        r0 = java.lang.System.err;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Searched java.library.path=";
        r1.append(r2);
        r2 = "java.library.path";
        r2 = java.lang.System.getProperty(r2);
        r1.append(r2);
        r1 = r1.toString();
        r0.println(r1);
        r0 = new java.lang.RuntimeException;
        r1 = "Couldn't load the Realm JNI library 'realm_jni32.dll or realm_jni64.dll'. Please include the directory to the library in java.library.path.";
        r0.<init>(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.RealmCore.loadLibraryWindows():java.lang.String");
    }

    private static java.lang.String loadCorrectLibrary(java.lang.String... r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r3.length;
    L_0x0002:
        if (r0 >= r1) goto L_0x000d;
    L_0x0004:
        r2 = r3[r0];
        java.lang.System.loadLibrary(r2);	 Catch:{ Throwable -> 0x000a }
        return r2;
    L_0x000a:
        r0 = r0 + 1;
        goto L_0x0002;
    L_0x000d:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.internal.RealmCore.loadCorrectLibrary(java.lang.String[]):java.lang.String");
    }

    public static void addNativeLibraryPath(String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(System.getProperty(JAVA_LIBRARY_PATH));
            stringBuilder.append(PATH_SEP);
            stringBuilder.append(str);
            stringBuilder.append(PATH_SEP);
            System.setProperty(JAVA_LIBRARY_PATH, stringBuilder.toString());
        } catch (String str2) {
            throw new RuntimeException("Cannot set the library path!", str2);
        }
    }

    private static void resetLibraryPath() {
        try {
            Field declaredField = ClassLoader.class.getDeclaredField("sys_paths");
            declaredField.setAccessible(true);
            declaredField.set(null, null);
        } catch (Throwable e) {
            throw new RuntimeException("Cannot reset the library path!", e);
        }
    }
}
