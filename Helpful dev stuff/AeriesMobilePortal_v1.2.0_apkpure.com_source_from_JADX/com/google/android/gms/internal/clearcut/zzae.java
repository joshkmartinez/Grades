package com.google.android.gms.internal.clearcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;
import javax.annotation.Nullable;

public abstract class zzae<T> {
    private static final Object zzdn = new Object();
    private static boolean zzdo = false;
    private static volatile Boolean zzdp;
    private static volatile Boolean zzdq;
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzh;
    private final zzao zzdr;
    final String zzds;
    private final String zzdt;
    private final T zzdu;
    private T zzdv;
    private volatile zzab zzdw;
    private volatile SharedPreferences zzdx;

    private zzae(zzao com_google_android_gms_internal_clearcut_zzao, String str, T t) {
        this.zzdv = null;
        this.zzdw = null;
        this.zzdx = null;
        if (com_google_android_gms_internal_clearcut_zzao.zzef == null) {
            if (com_google_android_gms_internal_clearcut_zzao.zzeg == null) {
                throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
            }
        }
        if (com_google_android_gms_internal_clearcut_zzao.zzef != null) {
            if (com_google_android_gms_internal_clearcut_zzao.zzeg != null) {
                throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
            }
        }
        this.zzdr = com_google_android_gms_internal_clearcut_zzao;
        String valueOf = String.valueOf(com_google_android_gms_internal_clearcut_zzao.zzeh);
        String valueOf2 = String.valueOf(str);
        this.zzdt = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        String valueOf3 = String.valueOf(com_google_android_gms_internal_clearcut_zzao.zzei);
        str = String.valueOf(str);
        this.zzds = str.length() != 0 ? valueOf3.concat(str) : new String(valueOf3);
        this.zzdu = t;
    }

    public static void maybeInit(Context context) {
        if (zzh == null) {
            synchronized (zzdn) {
                if (VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (zzh != context) {
                    zzdp = null;
                }
                zzh = context;
            }
            zzdo = false;
        }
    }

    private static <T> zzae<T> zza(zzao com_google_android_gms_internal_clearcut_zzao, String str, T t, zzan<T> com_google_android_gms_internal_clearcut_zzan_T) {
        return new zzal(com_google_android_gms_internal_clearcut_zzao, str, t, com_google_android_gms_internal_clearcut_zzan_T);
    }

    private static zzae<String> zza(zzao com_google_android_gms_internal_clearcut_zzao, String str, String str2) {
        return new zzak(com_google_android_gms_internal_clearcut_zzao, str, str2);
    }

    private static zzae<Boolean> zza(zzao com_google_android_gms_internal_clearcut_zzao, String str, boolean z) {
        return new zzaj(com_google_android_gms_internal_clearcut_zzao, str, Boolean.valueOf(z));
    }

    private static <V> V zza(com.google.android.gms.internal.clearcut.zzam<V> r2) {
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
        r0 = r2.zzp();	 Catch:{ SecurityException -> 0x0006 }
        r2 = r0;
        goto L_0x0011;
    L_0x0006:
        r0 = android.os.Binder.clearCallingIdentity();
        r2 = r2.zzp();	 Catch:{ all -> 0x0012 }
        android.os.Binder.restoreCallingIdentity(r0);
    L_0x0011:
        return r2;
    L_0x0012:
        r2 = move-exception;
        android.os.Binder.restoreCallingIdentity(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzae.zza(com.google.android.gms.internal.clearcut.zzam):V");
    }

    static boolean zza(String str, boolean z) {
        return zzn() ? ((Boolean) zza(new zzah(str, false))).booleanValue() : false;
    }

    @TargetApi(24)
    @Nullable
    private final T zzl() {
        String str;
        if (zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            str = "PhenotypeFlag";
            String str2 = "Bypass reading Phenotype values for flag: ";
            String valueOf = String.valueOf(this.zzds);
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        } else if (this.zzdr.zzeg != null) {
            if (this.zzdw == null) {
                this.zzdw = zzab.zza(zzh.getContentResolver(), this.zzdr.zzeg);
            }
            str = (String) zza(new zzaf(this, this.zzdw));
            if (str != null) {
                return zzb(str);
            }
        } else if (this.zzdr.zzef != null) {
            boolean z;
            if (VERSION.SDK_INT < 24 || zzh.isDeviceProtectedStorage()) {
                z = true;
            } else {
                if (zzdq == null || !zzdq.booleanValue()) {
                    zzdq = Boolean.valueOf(((UserManager) zzh.getSystemService(UserManager.class)).isUserUnlocked());
                }
                z = zzdq.booleanValue();
            }
            if (!z) {
                return null;
            }
            if (this.zzdx == null) {
                this.zzdx = zzh.getSharedPreferences(this.zzdr.zzef, 0);
            }
            SharedPreferences sharedPreferences = this.zzdx;
            if (sharedPreferences.contains(this.zzds)) {
                return zza(sharedPreferences);
            }
        }
        return null;
    }

    @Nullable
    private final T zzm() {
        if (!this.zzdr.zzej && zzn()) {
            String str = (String) zza(new zzag(this));
            if (str != null) {
                return zzb(str);
            }
        }
        return null;
    }

    private static boolean zzn() {
        if (zzdp == null) {
            boolean z = false;
            if (zzh == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(zzh, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzdp = Boolean.valueOf(z);
        }
        return zzdp.booleanValue();
    }

    public final T get() {
        if (zzh != null) {
            T zzm;
            if (this.zzdr.zzek) {
                zzm = zzm();
                if (zzm != null) {
                    return zzm;
                }
                zzm = zzl();
                if (zzm != null) {
                    return zzm;
                }
            }
            zzm = zzl();
            if (zzm != null) {
                return zzm;
            }
            zzm = zzm();
            if (zzm != null) {
                return zzm;
            }
            return this.zzdu;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    protected abstract T zzb(String str);

    final /* synthetic */ String zzo() {
        return zzy.zza(zzh.getContentResolver(), this.zzdt, null);
    }
}
