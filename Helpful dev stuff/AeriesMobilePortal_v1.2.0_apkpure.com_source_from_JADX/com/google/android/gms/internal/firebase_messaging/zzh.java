package com.google.android.gms.internal.firebase_messaging;

import java.io.PrintStream;

public final class zzh {
    private static final zzi zze;
    private static final int zzf;

    static final class zza extends zzi {
        zza() {
        }

        public final void zza(Throwable th, Throwable th2) {
        }
    }

    static {
        Integer zza;
        zzi com_google_android_gms_internal_firebase_messaging_zzm;
        Throwable th;
        PrintStream printStream;
        String name;
        StringBuilder stringBuilder;
        int i = 1;
        try {
            zza = zza();
            if (zza != null) {
                try {
                    if (zza.intValue() >= 19) {
                        com_google_android_gms_internal_firebase_messaging_zzm = new zzm();
                        zze = com_google_android_gms_internal_firebase_messaging_zzm;
                        if (zza != null) {
                            i = zza.intValue();
                        }
                        zzf = i;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printStream = System.err;
                    name = zza.class.getName();
                    stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
                    stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
                    stringBuilder.append(name);
                    stringBuilder.append("will be used. The error is: ");
                    printStream.println(stringBuilder.toString());
                    th.printStackTrace(System.err);
                    com_google_android_gms_internal_firebase_messaging_zzm = new zza();
                    zze = com_google_android_gms_internal_firebase_messaging_zzm;
                    if (zza != null) {
                        i = zza.intValue();
                    }
                    zzf = i;
                }
            }
            com_google_android_gms_internal_firebase_messaging_zzm = (Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ 1) != 0 ? new zzl() : new zza();
        } catch (Throwable th3) {
            th = th3;
            zza = null;
            printStream = System.err;
            name = zza.class.getName();
            stringBuilder = new StringBuilder(132 + String.valueOf(name).length());
            stringBuilder.append("An error has occured when initializing the try-with-resources desuguring strategy. The default strategy ");
            stringBuilder.append(name);
            stringBuilder.append("will be used. The error is: ");
            printStream.println(stringBuilder.toString());
            th.printStackTrace(System.err);
            com_google_android_gms_internal_firebase_messaging_zzm = new zza();
            zze = com_google_android_gms_internal_firebase_messaging_zzm;
            if (zza != null) {
                i = zza.intValue();
            }
            zzf = i;
        }
        zze = com_google_android_gms_internal_firebase_messaging_zzm;
        if (zza != null) {
            i = zza.intValue();
        }
        zzf = i;
    }

    private static Integer zza() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        zze.zza(th, th2);
    }
}
