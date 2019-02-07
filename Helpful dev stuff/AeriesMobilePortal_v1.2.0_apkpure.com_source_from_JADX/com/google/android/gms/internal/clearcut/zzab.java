package com.google.android.gms.internal.clearcut;

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

public final class zzab {
    private static final ConcurrentHashMap<Uri, zzab> zzde = new ConcurrentHashMap();
    private static final String[] zzdl = new String[]{"key", Param.VALUE};
    private final Uri uri;
    private final ContentResolver zzdf;
    private final ContentObserver zzdg;
    private final Object zzdh = new Object();
    private volatile Map<String, String> zzdi;
    private final Object zzdj = new Object();
    @GuardedBy("listenersLock")
    private final List<zzad> zzdk = new ArrayList();

    private zzab(ContentResolver contentResolver, Uri uri) {
        this.zzdf = contentResolver;
        this.uri = uri;
        this.zzdg = new zzac(this, null);
    }

    public static zzab zza(ContentResolver contentResolver, Uri uri) {
        zzab com_google_android_gms_internal_clearcut_zzab = (zzab) zzde.get(uri);
        if (com_google_android_gms_internal_clearcut_zzab != null) {
            return com_google_android_gms_internal_clearcut_zzab;
        }
        com_google_android_gms_internal_clearcut_zzab = new zzab(contentResolver, uri);
        zzab com_google_android_gms_internal_clearcut_zzab2 = (zzab) zzde.putIfAbsent(uri, com_google_android_gms_internal_clearcut_zzab);
        if (com_google_android_gms_internal_clearcut_zzab2 != null) {
            return com_google_android_gms_internal_clearcut_zzab2;
        }
        com_google_android_gms_internal_clearcut_zzab.zzdf.registerContentObserver(com_google_android_gms_internal_clearcut_zzab.uri, false, com_google_android_gms_internal_clearcut_zzab.zzdg);
        return com_google_android_gms_internal_clearcut_zzab;
    }

    private final java.util.Map<java.lang.String, java.lang.String> zzi() {
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
        r1 = r7.zzdf;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r2 = r7.uri;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
        r3 = zzdl;	 Catch:{ SecurityException -> 0x0032, SecurityException -> 0x0032 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzab.zzi():java.util.Map<java.lang.String, java.lang.String>");
    }

    private final void zzj() {
        synchronized (this.zzdj) {
            for (zzad zzk : this.zzdk) {
                zzk.zzk();
            }
        }
    }

    public final Map<String, String> zzg() {
        Map<String, String> zzi = zzae.zza("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzi() : this.zzdi;
        if (zzi == null) {
            synchronized (this.zzdh) {
                zzi = this.zzdi;
                if (zzi == null) {
                    zzi = zzi();
                    this.zzdi = zzi;
                }
            }
        }
        return zzi != null ? zzi : Collections.emptyMap();
    }

    public final void zzh() {
        synchronized (this.zzdh) {
            this.zzdi = null;
        }
    }
}
