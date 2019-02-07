package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzea {
    private static final zzea zznc = new zzea();
    private final zzeg zznd;
    private final ConcurrentMap<Class<?>, zzef<?>> zzne = new ConcurrentHashMap();

    private zzea() {
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzeg com_google_android_gms_internal_clearcut_zzeg = null;
        for (int i = 0; i <= 0; i++) {
            com_google_android_gms_internal_clearcut_zzeg = zzk(strArr[0]);
            if (com_google_android_gms_internal_clearcut_zzeg != null) {
                break;
            }
        }
        if (com_google_android_gms_internal_clearcut_zzeg == null) {
            com_google_android_gms_internal_clearcut_zzeg = new zzdd();
        }
        this.zznd = com_google_android_gms_internal_clearcut_zzeg;
    }

    public static zzea zzcm() {
        return zznc;
    }

    private static com.google.android.gms.internal.clearcut.zzeg zzk(java.lang.String r2) {
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
        r2 = (com.google.android.gms.internal.clearcut.zzeg) r2;	 Catch:{ Throwable -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzea.zzk(java.lang.String):com.google.android.gms.internal.clearcut.zzeg");
    }

    public final <T> zzef<T> zze(Class<T> cls) {
        zzci.zza((Object) cls, "messageType");
        zzef<T> com_google_android_gms_internal_clearcut_zzef_T = (zzef) this.zzne.get(cls);
        if (com_google_android_gms_internal_clearcut_zzef_T != null) {
            return com_google_android_gms_internal_clearcut_zzef_T;
        }
        Object zzd = this.zznd.zzd(cls);
        zzci.zza((Object) cls, "messageType");
        zzci.zza(zzd, "schema");
        zzef<T> com_google_android_gms_internal_clearcut_zzef_T2 = (zzef) this.zzne.putIfAbsent(cls, zzd);
        return com_google_android_gms_internal_clearcut_zzef_T2 != null ? com_google_android_gms_internal_clearcut_zzef_T2 : zzd;
    }

    public final <T> zzef<T> zzp(T t) {
        return zze(t.getClass());
    }
}
