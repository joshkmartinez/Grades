package com.google.android.gms.internal.measurement;

public class zzzy {
    private static final zzzi zzbsw = zzzi.zzte();
    private zzyw zzbsx;
    private volatile zzaal zzbsy;
    private volatile zzyw zzbsz;

    private final com.google.android.gms.internal.measurement.zzaal zzb(com.google.android.gms.internal.measurement.zzaal r2) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        r0 = r1.zzbsy;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.zzbsy;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.zzbsy = r2;	 Catch:{ zzzt -> 0x0012 }
        r0 = com.google.android.gms.internal.measurement.zzyw.zzbqx;	 Catch:{ zzzt -> 0x0012 }
        r1.zzbsz = r0;	 Catch:{ zzzt -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.zzbsy = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.measurement.zzyw.zzbqx;	 Catch:{ all -> 0x0019 }
        r1.zzbsz = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.zzbsy;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzzy.zzb(com.google.android.gms.internal.measurement.zzaal):com.google.android.gms.internal.measurement.zzaal");
    }

    private final zzyw zztp() {
        if (this.zzbsz != null) {
            return this.zzbsz;
        }
        synchronized (this) {
            if (this.zzbsz != null) {
                zzyw com_google_android_gms_internal_measurement_zzyw = this.zzbsz;
                return com_google_android_gms_internal_measurement_zzyw;
            }
            this.zzbsz = this.zzbsy == null ? zzyw.zzbqx : this.zzbsy.zztp();
            com_google_android_gms_internal_measurement_zzyw = this.zzbsz;
            return com_google_android_gms_internal_measurement_zzyw;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzy)) {
            return false;
        }
        zzzy com_google_android_gms_internal_measurement_zzzy = (zzzy) obj;
        zzaal com_google_android_gms_internal_measurement_zzaal = this.zzbsy;
        zzaal com_google_android_gms_internal_measurement_zzaal2 = com_google_android_gms_internal_measurement_zzzy.zzbsy;
        return (com_google_android_gms_internal_measurement_zzaal == null && com_google_android_gms_internal_measurement_zzaal2 == null) ? zztp().equals(com_google_android_gms_internal_measurement_zzzy.zztp()) : (com_google_android_gms_internal_measurement_zzaal == null || com_google_android_gms_internal_measurement_zzaal2 == null) ? com_google_android_gms_internal_measurement_zzaal != null ? com_google_android_gms_internal_measurement_zzaal.equals(com_google_android_gms_internal_measurement_zzzy.zzb(com_google_android_gms_internal_measurement_zzaal.zztz())) : zzb(com_google_android_gms_internal_measurement_zzaal2.zztz()).equals(com_google_android_gms_internal_measurement_zzaal2) : com_google_android_gms_internal_measurement_zzaal.equals(com_google_android_gms_internal_measurement_zzaal2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzaal zzc(zzaal com_google_android_gms_internal_measurement_zzaal) {
        zzaal com_google_android_gms_internal_measurement_zzaal2 = this.zzbsy;
        this.zzbsx = null;
        this.zzbsz = null;
        this.zzbsy = com_google_android_gms_internal_measurement_zzaal;
        return com_google_android_gms_internal_measurement_zzaal2;
    }
}
