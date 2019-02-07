package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class zzws<T> {
    private static final Object zzbnc = new Object();
    private static boolean zzbnd = false;
    private static volatile Boolean zzbne;
    private static volatile Boolean zzbnf;
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzqx;
    private final zzxc zzbng;
    final String zzbnh;
    private final String zzbni;
    private final T zzbnj;
    private T zzbnk;
    private volatile zzwp zzbnl;
    private volatile SharedPreferences zzbnm;

    private zzws(zzxc com_google_android_gms_internal_measurement_zzxc, String str, T t) {
        this.zzbnk = null;
        this.zzbnl = null;
        this.zzbnm = null;
        if (com_google_android_gms_internal_measurement_zzxc.zzbns != null) {
            this.zzbng = com_google_android_gms_internal_measurement_zzxc;
            String valueOf = String.valueOf(com_google_android_gms_internal_measurement_zzxc.zzbnt);
            String valueOf2 = String.valueOf(str);
            this.zzbni = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(com_google_android_gms_internal_measurement_zzxc.zzbnu);
            str = String.valueOf(str);
            this.zzbnh = str.length() != 0 ? valueOf3.concat(str) : new String(valueOf3);
            this.zzbnj = t;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public static void init(Context context) {
        synchronized (zzbnc) {
            if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    context = applicationContext;
                }
            }
            if (zzqx != context) {
                zzbne = null;
            }
            zzqx = context;
        }
        zzbnd = false;
    }

    private static zzws<Double> zza(zzxc com_google_android_gms_internal_measurement_zzxc, String str, double d) {
        return new zzwz(com_google_android_gms_internal_measurement_zzxc, str, Double.valueOf(d));
    }

    private static zzws<Integer> zza(zzxc com_google_android_gms_internal_measurement_zzxc, String str, int i) {
        return new zzwx(com_google_android_gms_internal_measurement_zzxc, str, Integer.valueOf(i));
    }

    private static zzws<Long> zza(zzxc com_google_android_gms_internal_measurement_zzxc, String str, long j) {
        return new zzww(com_google_android_gms_internal_measurement_zzxc, str, Long.valueOf(j));
    }

    private static zzws<String> zza(zzxc com_google_android_gms_internal_measurement_zzxc, String str, String str2) {
        return new zzxa(com_google_android_gms_internal_measurement_zzxc, str, str2);
    }

    private static zzws<Boolean> zza(zzxc com_google_android_gms_internal_measurement_zzxc, String str, boolean z) {
        return new zzwy(com_google_android_gms_internal_measurement_zzxc, str, Boolean.valueOf(z));
    }

    private static <V> V zza(com.google.android.gms.internal.measurement.zzxb<V> r2) {
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
        r0 = r2.zzsc();	 Catch:{ SecurityException -> 0x0006 }
        r2 = r0;
        goto L_0x0011;
    L_0x0006:
        r0 = android.os.Binder.clearCallingIdentity();
        r2 = r2.zzsc();	 Catch:{ all -> 0x0012 }
        android.os.Binder.restoreCallingIdentity(r0);
    L_0x0011:
        return r2;
    L_0x0012:
        r2 = move-exception;
        android.os.Binder.restoreCallingIdentity(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzws.zza(com.google.android.gms.internal.measurement.zzxb):V");
    }

    static boolean zzd(String str, boolean z) {
        try {
            return zzsa() ? ((Boolean) zza(new zzwv(str, false))).booleanValue() : false;
        } catch (Throwable e) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e);
            return false;
        }
    }

    @TargetApi(24)
    @Nullable
    private final T zzry() {
        String str;
        if (zzd("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            str = "PhenotypeFlag";
            String str2 = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.zzbnh);
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (this.zzbng.zzbns != null) {
            if (this.zzbnl == null) {
                this.zzbnl = zzwp.zza(zzqx.getContentResolver(), this.zzbng.zzbns);
            }
            str = (String) zza(new zzwt(this, this.zzbnl));
            if (str != null) {
                return zzey(str);
            }
        } else {
            zzxc com_google_android_gms_internal_measurement_zzxc = this.zzbng;
        }
        return null;
    }

    @Nullable
    private final T zzrz() {
        zzxc com_google_android_gms_internal_measurement_zzxc = this.zzbng;
        if (zzsa()) {
            try {
                String str = (String) zza(new zzwu(this));
                if (str != null) {
                    return zzey(str);
                }
            } catch (Throwable e) {
                String str2 = "PhenotypeFlag";
                String str3 = "Unable to read GServices for flag: ";
                String valueOf = String.valueOf(this.zzbnh);
                Log.e(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3), e);
            }
        }
        return null;
    }

    private static boolean zzsa() {
        if (zzbne == null) {
            boolean z = false;
            if (zzqx == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(zzqx, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzbne = Boolean.valueOf(z);
        }
        return zzbne.booleanValue();
    }

    public final T get() {
        if (zzqx != null) {
            zzxc com_google_android_gms_internal_measurement_zzxc = this.zzbng;
            T zzry = zzry();
            if (zzry != null) {
                return zzry;
            }
            zzry = zzrz();
            return zzry != null ? zzry : this.zzbnj;
        } else {
            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
        }
    }

    protected abstract T zzey(String str);

    final /* synthetic */ String zzsb() {
        return zzwn.zza(zzqx.getContentResolver(), this.zzbni, null);
    }
}
