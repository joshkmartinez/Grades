package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq.zzb;

final class zzaad implements zzaaw {
    private static final zzaak zzbte = new zzaae();
    private final zzaak zzbtd;

    public zzaad() {
        this(new zzaaf(zzzp.zztl(), zzts()));
    }

    private zzaad(zzaak com_google_android_gms_internal_measurement_zzaak) {
        this.zzbtd = (zzaak) zzzr.zza(com_google_android_gms_internal_measurement_zzaak, "messageInfoFactory");
    }

    private static boolean zza(zzaaj com_google_android_gms_internal_measurement_zzaaj) {
        return com_google_android_gms_internal_measurement_zzaaj.zztw() == zzb.zzbsk;
    }

    private static com.google.android.gms.internal.measurement.zzaak zzts() {
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
        r0 = (com.google.android.gms.internal.measurement.zzaak) r0;	 Catch:{ Exception -> 0x0019 }
        return r0;
    L_0x0019:
        r0 = zzbte;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaad.zzts():com.google.android.gms.internal.measurement.zzaak");
    }

    public final <T> zzaav<T> zzg(Class<T> cls) {
        zzaax.zzh(cls);
        zzaaj zze = this.zzbtd.zze(cls);
        if (zze.zztx()) {
            return zzzq.class.isAssignableFrom(cls) ? zzaap.zza(zzaax.zzug(), zzzl.zztg(), zze.zzty()) : zzaap.zza(zzaax.zzue(), zzzl.zzth(), zze.zzty());
        } else {
            if (zzzq.class.isAssignableFrom(cls)) {
                if (zza(zze)) {
                    return zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), zzzl.zztg(), zzaai.zztu());
                }
                return zzaao.zza(cls, zze, zzaas.zzub(), zzzz.zztr(), zzaax.zzug(), null, zzaai.zztu());
            } else if (zza(zze)) {
                return zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzue(), zzzl.zzth(), zzaai.zztt());
            } else {
                return zzaao.zza(cls, zze, zzaas.zzua(), zzzz.zztq(), zzaax.zzuf(), null, zzaai.zztt());
            }
        }
    }
}
