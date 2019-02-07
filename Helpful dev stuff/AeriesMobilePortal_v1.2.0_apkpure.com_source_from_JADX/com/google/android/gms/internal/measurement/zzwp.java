package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.support.annotation.GuardedBy;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzwp {
    private static final ConcurrentHashMap<Uri, zzwp> zzbmt = new ConcurrentHashMap();
    private static final String[] zzbna = new String[]{"key", Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzbmu;
    private final ContentObserver zzbmv;
    private final Object zzbmw = new Object();
    private volatile Map<String, String> zzbmx;
    private final Object zzbmy = new Object();
    @GuardedBy("listenersLock")
    private final List<zzwr> zzbmz = new ArrayList();

    private zzwp(ContentResolver contentResolver, Uri uri) {
        this.zzbmu = contentResolver;
        this.uri = uri;
        this.zzbmv = new zzwq(this, null);
    }

    public static zzwp zza(ContentResolver contentResolver, Uri uri) {
        zzwp com_google_android_gms_internal_measurement_zzwp = (zzwp) zzbmt.get(uri);
        if (com_google_android_gms_internal_measurement_zzwp != null) {
            return com_google_android_gms_internal_measurement_zzwp;
        }
        com_google_android_gms_internal_measurement_zzwp = new zzwp(contentResolver, uri);
        zzwp com_google_android_gms_internal_measurement_zzwp2 = (zzwp) zzbmt.putIfAbsent(uri, com_google_android_gms_internal_measurement_zzwp);
        if (com_google_android_gms_internal_measurement_zzwp2 != null) {
            return com_google_android_gms_internal_measurement_zzwp2;
        }
        com_google_android_gms_internal_measurement_zzwp.zzbmu.registerContentObserver(com_google_android_gms_internal_measurement_zzwp.uri, false, com_google_android_gms_internal_measurement_zzwp.zzbmv);
        return com_google_android_gms_internal_measurement_zzwp;
    }

    private final java.util.Map<java.lang.String, java.lang.String> zzrv() {
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
        r7 = this;
        r0 = new java.util.HashMap;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r0.<init>();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1 = r7.zzbmu;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r2 = r7.uri;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r3 = zzbna;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r4 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r5 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r6 = 0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        if (r1 == 0) goto L_0x0031;
    L_0x0014:
        r2 = r1.moveToNext();	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x0028;	 Catch:{ all -> 0x002c }
    L_0x001a:
        r2 = 0;	 Catch:{ all -> 0x002c }
        r2 = r1.getString(r2);	 Catch:{ all -> 0x002c }
        r3 = 1;	 Catch:{ all -> 0x002c }
        r3 = r1.getString(r3);	 Catch:{ all -> 0x002c }
        r0.put(r2, r3);	 Catch:{ all -> 0x002c }
        goto L_0x0014;
    L_0x0028:
        r1.close();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        goto L_0x0031;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
    L_0x002c:
        r0 = move-exception;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r1.close();	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        throw r0;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
    L_0x0031:
        return r0;
    L_0x0032:
        r0 = "ConfigurationContentLoader";
        r1 = "PhenotypeFlag unable to load ContentProvider, using default values";
        android.util.Log.e(r0, r1);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwp.zzrv():java.util.Map<java.lang.String, java.lang.String>");
    }

    private final void zzrw() {
        synchronized (this.zzbmy) {
            for (zzwr zzrx : this.zzbmz) {
                zzrx.zzrx();
            }
        }
    }

    public final Map<String, String> zzrt() {
        Map<String, String> zzrv = zzws.zzd("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzrv() : this.zzbmx;
        if (zzrv == null) {
            synchronized (this.zzbmw) {
                zzrv = this.zzbmx;
                if (zzrv == null) {
                    zzrv = zzrv();
                    this.zzbmx = zzrv;
                }
            }
        }
        return zzrv != null ? zzrv : Collections.emptyMap();
    }

    public final void zzru() {
        synchronized (this.zzbmw) {
            this.zzbmx = null;
        }
    }
}
