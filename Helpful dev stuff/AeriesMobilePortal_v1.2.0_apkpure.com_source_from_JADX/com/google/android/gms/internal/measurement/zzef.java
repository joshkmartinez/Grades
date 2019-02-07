package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzhg {
    @NonNull
    private zzeh zzaet = zzeg.zzaeu;
    private Boolean zzxz;

    zzef(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    public static long zzhh() {
        return ((Long) zzew.zzahl.get()).longValue();
    }

    public static long zzhi() {
        return ((Long) zzew.zzagl.get()).longValue();
    }

    public static boolean zzhk() {
        return ((Boolean) zzew.zzagh.get()).booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @android.support.annotation.WorkerThread
    public final long zza(java.lang.String r3, @android.support.annotation.NonNull com.google.android.gms.internal.measurement.zzex<java.lang.Long> r4) {
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
        r2 = this;
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.get();
        r3 = (java.lang.Long) r3;
        r3 = r3.longValue();
        return r3;
    L_0x000d:
        r0 = r2.zzaet;
        r1 = r4.getKey();
        r3 = r0.zze(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.get(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Long) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.longValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzef.zza(java.lang.String, com.google.android.gms.internal.measurement.zzex):long");
    }

    final void zza(@NonNull zzeh com_google_android_gms_internal_measurement_zzeh) {
        this.zzaet = com_google_android_gms_internal_measurement_zzeh;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    @WorkerThread
    public final int zzar(@Size(min = 1) String str) {
        return zzb(str, zzew.zzagw);
    }

    @Nullable
    @VisibleForTesting
    final Boolean zzas(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().zzim().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData != null) {
                return !applicationInfo.metaData.containsKey(str) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
                return null;
            }
        } catch (NameNotFoundException e) {
            zzge().zzim().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzaet.zze(str, "gaia_collection_enabled"));
    }

    public final boolean zzau(String str) {
        return "1".equals(this.zzaet.zze(str, "measurement.event_sampling_enabled"));
    }

    @WorkerThread
    final boolean zzav(String str) {
        return zzd(str, zzew.zzahu);
    }

    @WorkerThread
    final boolean zzaw(String str) {
        return zzd(str, zzew.zzahw);
    }

    @WorkerThread
    final boolean zzax(String str) {
        return zzd(str, zzew.zzahx);
    }

    final boolean zzay(String str) {
        return zzd(str, zzew.zzahy);
    }

    @WorkerThread
    final boolean zzaz(String str) {
        return zzd(str, zzew.zzahz);
    }

    @android.support.annotation.WorkerThread
    public final int zzb(java.lang.String r3, @android.support.annotation.NonNull com.google.android.gms.internal.measurement.zzex<java.lang.Integer> r4) {
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
        r2 = this;
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.get();
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        return r3;
    L_0x000d:
        r0 = r2.zzaet;
        r1 = r4.getKey();
        r3 = r0.zze(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.get(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Integer) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r3.intValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzef.zzb(java.lang.String, com.google.android.gms.internal.measurement.zzex):int");
    }

    @WorkerThread
    final boolean zzba(String str) {
        return zzd(str, zzew.zzaic);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    @android.support.annotation.WorkerThread
    public final double zzc(java.lang.String r3, @android.support.annotation.NonNull com.google.android.gms.internal.measurement.zzex<java.lang.Double> r4) {
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
        r2 = this;
        if (r3 != 0) goto L_0x000d;
    L_0x0002:
        r3 = r4.get();
        r3 = (java.lang.Double) r3;
        r3 = r3.doubleValue();
        return r3;
    L_0x000d:
        r0 = r2.zzaet;
        r1 = r4.getKey();
        r3 = r0.zze(r3, r1);
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        goto L_0x0002;
    L_0x001e:
        r0 = java.lang.Double.parseDouble(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = java.lang.Double.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = r4.get(r3);	 Catch:{ NumberFormatException -> 0x0002 }
        r3 = (java.lang.Double) r3;	 Catch:{ NumberFormatException -> 0x0002 }
        r0 = r3.doubleValue();	 Catch:{ NumberFormatException -> 0x0002 }
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzef.zzc(java.lang.String, com.google.android.gms.internal.measurement.zzex):double");
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzex<Boolean> com_google_android_gms_internal_measurement_zzex_java_lang_Boolean) {
        Object zze;
        if (str != null) {
            zze = this.zzaet.zze(str, com_google_android_gms_internal_measurement_zzex_java_lang_Boolean.getKey());
            if (!TextUtils.isEmpty(zze)) {
                zze = com_google_android_gms_internal_measurement_zzex_java_lang_Boolean.get(Boolean.valueOf(Boolean.parseBoolean(zze)));
                return ((Boolean) zze).booleanValue();
            }
        }
        zze = com_google_android_gms_internal_measurement_zzex_java_lang_Boolean.get();
        return ((Boolean) zze).booleanValue();
    }

    public final boolean zzds() {
        if (this.zzxz == null) {
            synchronized (this) {
                if (this.zzxz == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        boolean z = str != null && str.equals(myProcessName);
                        this.zzxz = Boolean.valueOf(z);
                    }
                    if (this.zzxz == null) {
                        this.zzxz = Boolean.TRUE;
                        zzge().zzim().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzxz.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    public final boolean zzhg() {
        Boolean zzas = zzas("firebase_analytics_collection_deactivated");
        return zzas != null && zzas.booleanValue();
    }

    public final String zzhj() {
        Object e;
        zzfi zzim;
        String str;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e2) {
            e = e2;
            zzim = zzge().zzim();
            str = "Could not find SystemProperties class";
            zzim.zzg(str, e);
            return "";
        } catch (NoSuchMethodException e3) {
            e = e3;
            zzim = zzge().zzim();
            str = "Could not find SystemProperties.get() method";
            zzim.zzg(str, e);
            return "";
        } catch (IllegalAccessException e4) {
            e = e4;
            zzim = zzge().zzim();
            str = "Could not access SystemProperties.get()";
            zzim.zzg(str, e);
            return "";
        } catch (InvocationTargetException e5) {
            e = e5;
            zzim = zzge().zzim();
            str = "SystemProperties.get() threw an exception";
            zzim.zzg(str, e);
            return "";
        }
    }

    @WorkerThread
    final boolean zzhl() {
        return zzd(zzfv().zzah(), zzew.zzahp);
    }

    @WorkerThread
    final String zzhm() {
        String zzah = zzfv().zzah();
        zzex com_google_android_gms_internal_measurement_zzex = zzew.zzahq;
        return (String) (zzah == null ? com_google_android_gms_internal_measurement_zzex.get() : com_google_android_gms_internal_measurement_zzex.get(this.zzaet.zze(zzah, com_google_android_gms_internal_measurement_zzex.getKey())));
    }
}
