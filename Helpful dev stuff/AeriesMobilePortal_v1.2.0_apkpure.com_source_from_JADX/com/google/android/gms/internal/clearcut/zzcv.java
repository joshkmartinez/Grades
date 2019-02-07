package com.google.android.gms.internal.clearcut;

public class zzcv {
    private static final zzbt zzez = zzbt.zzan();
    private zzbb zzln;
    private volatile zzdo zzlo;
    private volatile zzbb zzlp;

    private final com.google.android.gms.internal.clearcut.zzdo zzh(com.google.android.gms.internal.clearcut.zzdo r2) {
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
        r1 = this;
        r0 = r1.zzlo;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        monitor-enter(r1);
        r0 = r1.zzlo;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x000b;	 Catch:{ all -> 0x0019 }
    L_0x0009:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x001c;
    L_0x000b:
        r1.zzlo = r2;	 Catch:{ zzco -> 0x0012 }
        r0 = com.google.android.gms.internal.clearcut.zzbb.zzfi;	 Catch:{ zzco -> 0x0012 }
        r1.zzlp = r0;	 Catch:{ zzco -> 0x0012 }
        goto L_0x0009;
    L_0x0012:
        r1.zzlo = r2;	 Catch:{ all -> 0x0019 }
        r2 = com.google.android.gms.internal.clearcut.zzbb.zzfi;	 Catch:{ all -> 0x0019 }
        r1.zzlp = r2;	 Catch:{ all -> 0x0019 }
        goto L_0x0009;	 Catch:{ all -> 0x0019 }
    L_0x0019:
        r2 = move-exception;	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r2;
    L_0x001c:
        r2 = r1.zzlo;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzcv.zzh(com.google.android.gms.internal.clearcut.zzdo):com.google.android.gms.internal.clearcut.zzdo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcv)) {
            return false;
        }
        zzcv com_google_android_gms_internal_clearcut_zzcv = (zzcv) obj;
        zzdo com_google_android_gms_internal_clearcut_zzdo = this.zzlo;
        zzdo com_google_android_gms_internal_clearcut_zzdo2 = com_google_android_gms_internal_clearcut_zzcv.zzlo;
        return (com_google_android_gms_internal_clearcut_zzdo == null && com_google_android_gms_internal_clearcut_zzdo2 == null) ? zzr().equals(com_google_android_gms_internal_clearcut_zzcv.zzr()) : (com_google_android_gms_internal_clearcut_zzdo == null || com_google_android_gms_internal_clearcut_zzdo2 == null) ? com_google_android_gms_internal_clearcut_zzdo != null ? com_google_android_gms_internal_clearcut_zzdo.equals(com_google_android_gms_internal_clearcut_zzcv.zzh(com_google_android_gms_internal_clearcut_zzdo.zzbe())) : zzh(com_google_android_gms_internal_clearcut_zzdo2.zzbe()).equals(com_google_android_gms_internal_clearcut_zzdo2) : com_google_android_gms_internal_clearcut_zzdo.equals(com_google_android_gms_internal_clearcut_zzdo2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zzas() {
        return this.zzlp != null ? this.zzlp.size() : this.zzlo != null ? this.zzlo.zzas() : 0;
    }

    public final zzdo zzi(zzdo com_google_android_gms_internal_clearcut_zzdo) {
        zzdo com_google_android_gms_internal_clearcut_zzdo2 = this.zzlo;
        this.zzln = null;
        this.zzlp = null;
        this.zzlo = com_google_android_gms_internal_clearcut_zzdo;
        return com_google_android_gms_internal_clearcut_zzdo2;
    }

    public final zzbb zzr() {
        if (this.zzlp != null) {
            return this.zzlp;
        }
        synchronized (this) {
            if (this.zzlp != null) {
                zzbb com_google_android_gms_internal_clearcut_zzbb = this.zzlp;
                return com_google_android_gms_internal_clearcut_zzbb;
            }
            this.zzlp = this.zzlo == null ? zzbb.zzfi : this.zzlo.zzr();
            com_google_android_gms_internal_clearcut_zzbb = this.zzlp;
            return com_google_android_gms_internal_clearcut_zzbb;
        }
    }
}
