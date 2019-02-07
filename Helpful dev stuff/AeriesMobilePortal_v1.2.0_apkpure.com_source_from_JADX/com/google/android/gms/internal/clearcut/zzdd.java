package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg.zzg;

final class zzdd implements zzeg {
    private static final zzdn zzlz = new zzde();
    private final zzdn zzly;

    public zzdd() {
        this(new zzdf(zzcf.zzay(), zzby()));
    }

    private zzdd(zzdn com_google_android_gms_internal_clearcut_zzdn) {
        this.zzly = (zzdn) zzci.zza((Object) com_google_android_gms_internal_clearcut_zzdn, "messageInfoFactory");
    }

    private static boolean zza(zzdm com_google_android_gms_internal_clearcut_zzdm) {
        return com_google_android_gms_internal_clearcut_zzdm.zzcf() == zzg.zzkl;
    }

    private static com.google.android.gms.internal.clearcut.zzdn zzby() {
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
        r0 = "com.google.protobuf.DescriptorMessageInfoFactory";	 Catch:{ Exception -> 0x0019 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0019 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0019 }
        r2 = 0;	 Catch:{ Exception -> 0x0019 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0019 }
        r1 = 0;	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0019 }
        r0 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0019 }
        r0 = (com.google.android.gms.internal.clearcut.zzdn) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = zzlz;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzdd.zzby():com.google.android.gms.internal.clearcut.zzdn");
    }

    public final <T> zzef<T> zzd(Class<T> cls) {
        zzeh.zzf((Class) cls);
        zzdm zzb = this.zzly.zzb(cls);
        if (zzb.zzcg()) {
            return zzcg.class.isAssignableFrom(cls) ? zzdu.zza(zzeh.zzdo(), zzbx.zzap(), zzb.zzch()) : zzdu.zza(zzeh.zzdm(), zzbx.zzaq(), zzb.zzch());
        } else {
            if (zzcg.class.isAssignableFrom(cls)) {
                if (zza(zzb)) {
                    return zzds.zza((Class) cls, zzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), zzbx.zzap(), zzdl.zzcd());
                }
                return zzds.zza((Class) cls, zzb, zzdy.zzck(), zzcy.zzbw(), zzeh.zzdo(), null, zzdl.zzcd());
            } else if (zza(zzb)) {
                return zzds.zza((Class) cls, zzb, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdm(), zzbx.zzaq(), zzdl.zzcc());
            } else {
                return zzds.zza((Class) cls, zzb, zzdy.zzcj(), zzcy.zzbv(), zzeh.zzdn(), null, zzdl.zzcc());
            }
        }
    }
}
