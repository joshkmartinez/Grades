package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

final class zzal extends zzae<T> {
    private final Object lock = new Object();
    private String zzec;
    private T zzed;
    private final /* synthetic */ zzan zzee;

    zzal(zzao com_google_android_gms_internal_clearcut_zzao, String str, Object obj, zzan com_google_android_gms_internal_clearcut_zzan) {
        this.zzee = com_google_android_gms_internal_clearcut_zzan;
        super(com_google_android_gms_internal_clearcut_zzao, str, obj);
    }

    protected final T zza(SharedPreferences sharedPreferences) {
        try {
            return zzb(sharedPreferences.getString(this.zzds, ""));
        } catch (Throwable e) {
            String str = "PhenotypeFlag";
            String str2 = "Invalid byte[] value in SharedPreferences for ";
            String valueOf = String.valueOf(this.zzds);
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), e);
            return null;
        }
    }

    protected final T zzb(java.lang.String r5) {
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
        r4 = this;
        r0 = r4.lock;	 Catch:{ IOException -> 0x0021, IOException -> 0x0021 }
        monitor-enter(r0);	 Catch:{ IOException -> 0x0021, IOException -> 0x0021 }
        r1 = r4.zzec;	 Catch:{ all -> 0x001e }
        r1 = r5.equals(r1);	 Catch:{ all -> 0x001e }
        if (r1 != 0) goto L_0x001a;	 Catch:{ all -> 0x001e }
    L_0x000b:
        r1 = r4.zzee;	 Catch:{ all -> 0x001e }
        r2 = 3;	 Catch:{ all -> 0x001e }
        r2 = android.util.Base64.decode(r5, r2);	 Catch:{ all -> 0x001e }
        r1 = r1.zzb(r2);	 Catch:{ all -> 0x001e }
        r4.zzec = r5;	 Catch:{ all -> 0x001e }
        r4.zzed = r1;	 Catch:{ all -> 0x001e }
    L_0x001a:
        r1 = r4.zzed;	 Catch:{ all -> 0x001e }
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        return r1;	 Catch:{ all -> 0x001e }
    L_0x001e:
        r1 = move-exception;	 Catch:{ all -> 0x001e }
        monitor-exit(r0);	 Catch:{ all -> 0x001e }
        throw r1;	 Catch:{ IOException -> 0x0021, IOException -> 0x0021 }
    L_0x0021:
        r0 = "PhenotypeFlag";
        r1 = r4.zzds;
        r2 = 27;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Invalid byte[] value for ";
        r3.append(r2);
        r3.append(r1);
        r1 = ": ";
        r3.append(r1);
        r3.append(r5);
        r5 = r3.toString();
        android.util.Log.e(r0, r5);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzal.zzb(java.lang.String):T");
    }
}
