package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzaat {
    private static final zzaat zzbtq = new zzaat();
    private final zzaaw zzbtr;
    private final ConcurrentMap<Class<?>, zzaav<?>> zzbts = new ConcurrentHashMap();

    private zzaat() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzaaw com_google_android_gms_internal_measurement_zzaaw = null;
        for (int i = 0; i <= 0; i++) {
            com_google_android_gms_internal_measurement_zzaaw = zzfl(strArr[0]);
            if (com_google_android_gms_internal_measurement_zzaaw != null) {
                break;
            }
        }
        if (com_google_android_gms_internal_measurement_zzaaw == null) {
            com_google_android_gms_internal_measurement_zzaaw = new zzaad();
        }
        this.zzbtr = com_google_android_gms_internal_measurement_zzaaw;
    }

    private static com.google.android.gms.internal.measurement.zzaaw zzfl(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0014 }
        r0 = 0;	 Catch:{ Throwable -> 0x0014 }
        r1 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getConstructor(r1);	 Catch:{ Throwable -> 0x0014 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.newInstance(r0);	 Catch:{ Throwable -> 0x0014 }
        r2 = (com.google.android.gms.internal.measurement.zzaaw) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaat.zzfl(java.lang.String):com.google.android.gms.internal.measurement.zzaaw");
    }

    public static zzaat zzud() {
        return zzbtq;
    }

    public final <T> zzaav<T> zzt(T t) {
        Class cls = t.getClass();
        zzzr.zza(cls, "messageType");
        zzaav<T> com_google_android_gms_internal_measurement_zzaav_T = (zzaav) this.zzbts.get(cls);
        if (com_google_android_gms_internal_measurement_zzaav_T != null) {
            return com_google_android_gms_internal_measurement_zzaav_T;
        }
        com_google_android_gms_internal_measurement_zzaav_T = this.zzbtr.zzg(cls);
        zzzr.zza(cls, "messageType");
        zzzr.zza(com_google_android_gms_internal_measurement_zzaav_T, "schema");
        zzaav<T> com_google_android_gms_internal_measurement_zzaav_T2 = (zzaav) this.zzbts.putIfAbsent(cls, com_google_android_gms_internal_measurement_zzaav_T);
        return com_google_android_gms_internal_measurement_zzaav_T2 != null ? com_google_android_gms_internal_measurement_zzaav_T2 : com_google_android_gms_internal_measurement_zzaav_T;
    }
}
