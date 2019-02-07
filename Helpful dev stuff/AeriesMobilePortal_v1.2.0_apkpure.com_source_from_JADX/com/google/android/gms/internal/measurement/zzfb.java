package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.util.Locale;

public final class zzfb extends zzhh {
    private String zzadm;
    private String zzadt;
    private long zzadx;
    private int zzaen;
    private int zzaie;
    private long zzaif;
    private String zztg;
    private String zzth;
    private String zzti;

    zzfb(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    @android.support.annotation.WorkerThread
    private final java.lang.String zzgj() {
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
        r3 = this;
        r3.zzab();
        r0 = r3.zzgg();
        r1 = r3.zzti;
        r0 = r0.zzay(r1);
        r1 = 0;
        if (r0 == 0) goto L_0x0019;
    L_0x0010:
        r0 = r3.zzacw;
        r0 = r0.isEnabled();
        if (r0 != 0) goto L_0x0019;
    L_0x0018:
        return r1;
    L_0x0019:
        r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance();	 Catch:{ IllegalStateException -> 0x0022 }
        r0 = r0.getId();	 Catch:{ IllegalStateException -> 0x0022 }
        return r0;
    L_0x0022:
        r0 = r3.zzge();
        r0 = r0.zzip();
        r2 = "Failed to retrieve Firebase Instance Id";
        r0.log(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.zzgj():java.lang.String");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    final String getGmpAppId() {
        zzch();
        return this.zzadm;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    final String zzah() {
        zzch();
        return this.zzti;
    }

    @WorkerThread
    final zzdz zzbi(String str) {
        boolean z;
        boolean booleanValue;
        zzab();
        String zzah = zzah();
        String gmpAppId = getGmpAppId();
        zzch();
        String str2 = this.zzth;
        long zzij = (long) zzij();
        zzch();
        String str3 = this.zzadt;
        zzch();
        zzab();
        if (this.zzaif == 0) {
            r0.zzaif = r0.zzacw.zzgb().zzd(getContext(), getContext().getPackageName());
        }
        long j = r0.zzaif;
        boolean isEnabled = r0.zzacw.isEnabled();
        boolean z2 = true;
        boolean z3 = zzgf().zzakn ^ 1;
        String zzgj = zzgj();
        zzch();
        long zzjt = r0.zzacw.zzjt();
        int zzik = zzik();
        Boolean zzas = zzgg().zzas("google_analytics_adid_collection_enabled");
        if (zzas != null) {
            if (!zzas.booleanValue()) {
                z = false;
                booleanValue = Boolean.valueOf(z).booleanValue();
                zzas = zzgg().zzas("google_analytics_ssaid_collection_enabled");
                if (zzas != null) {
                    if (zzas.booleanValue()) {
                        z2 = false;
                    }
                }
                return new zzdz(zzah, gmpAppId, str2, zzij, str3, 12451, j, str, isEnabled, z3, zzgj, 0, zzjt, zzik, booleanValue, Boolean.valueOf(z2).booleanValue(), zzgf().zzje());
            }
        }
        z = true;
        booleanValue = Boolean.valueOf(z).booleanValue();
        zzas = zzgg().zzas("google_analytics_ssaid_collection_enabled");
        if (zzas != null) {
            if (zzas.booleanValue()) {
                z2 = false;
            }
        }
        return new zzdz(zzah, gmpAppId, str2, zzij, str3, 12451, j, str, isEnabled, z3, zzgj, 0, zzjt, zzik, booleanValue, Boolean.valueOf(z2).booleanValue(), zzgf().zzje());
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
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

    protected final boolean zzhf() {
        return true;
    }

    protected final void zzih() {
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
        r10 = this;
        r0 = "unknown";
        r1 = "Unknown";
        r2 = "Unknown";
        r3 = r10.getContext();
        r3 = r3.getPackageName();
        r4 = r10.getContext();
        r4 = r4.getPackageManager();
        r5 = 0;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != 0) goto L_0x002d;
    L_0x001b:
        r4 = r10.zzge();
        r4 = r4.zzim();
        r7 = "PackageManager is null, app identity information might be inaccurate. appId";
        r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);
        r4.zzg(r7, r8);
        goto L_0x008b;
    L_0x002d:
        r7 = r4.getInstallerPackageName(r3);	 Catch:{ IllegalArgumentException -> 0x0033 }
        r0 = r7;
        goto L_0x0044;
    L_0x0033:
        r7 = r10.zzge();
        r7 = r7.zzim();
        r8 = "Error retrieving app installer package name. appId";
        r9 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);
        r7.zzg(r8, r9);
    L_0x0044:
        if (r0 != 0) goto L_0x0049;
    L_0x0046:
        r0 = "manual_install";
        goto L_0x0053;
    L_0x0049:
        r7 = "com.android.vending";
        r7 = r7.equals(r0);
        if (r7 == 0) goto L_0x0053;
    L_0x0051:
        r0 = "";
    L_0x0053:
        r7 = r10.getContext();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r7.getPackageName();	 Catch:{ NameNotFoundException -> 0x007a }
        r7 = r4.getPackageInfo(r7, r5);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r7 == 0) goto L_0x008b;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0061:
        r8 = r7.applicationInfo;	 Catch:{ NameNotFoundException -> 0x007a }
        r4 = r4.getApplicationLabel(r8);	 Catch:{ NameNotFoundException -> 0x007a }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ NameNotFoundException -> 0x007a }
        if (r8 != 0) goto L_0x0072;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x006d:
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x007a }
        r2 = r4;	 Catch:{ NameNotFoundException -> 0x007a }
    L_0x0072:
        r4 = r7.versionName;	 Catch:{ NameNotFoundException -> 0x007a }
        r1 = r7.versionCode;	 Catch:{ NameNotFoundException -> 0x0079 }
        r6 = r1;
        r1 = r4;
        goto L_0x008b;
    L_0x0079:
        r1 = r4;
    L_0x007a:
        r4 = r10.zzge();
        r4 = r4.zzim();
        r7 = "Error retrieving package info. appId, appName";
        r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);
        r4.zze(r7, r8, r2);
    L_0x008b:
        r10.zzti = r3;
        r10.zzadt = r0;
        r10.zzth = r1;
        r10.zzaie = r6;
        r10.zztg = r2;
        r0 = 0;
        r10.zzaif = r0;
        r2 = r10.getContext();
        r2 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r2);
        r4 = 1;
        if (r2 == 0) goto L_0x00ac;
    L_0x00a4:
        r6 = r2.isSuccess();
        if (r6 == 0) goto L_0x00ac;
    L_0x00aa:
        r6 = r4;
        goto L_0x00ad;
    L_0x00ac:
        r6 = r5;
    L_0x00ad:
        if (r6 != 0) goto L_0x00d8;
    L_0x00af:
        if (r2 != 0) goto L_0x00bf;
    L_0x00b1:
        r2 = r10.zzge();
        r2 = r2.zzim();
        r7 = "GoogleService failed to initialize (no status)";
        r2.log(r7);
        goto L_0x00d8;
    L_0x00bf:
        r7 = r10.zzge();
        r7 = r7.zzim();
        r8 = "GoogleService failed to initialize, status";
        r9 = r2.getStatusCode();
        r9 = java.lang.Integer.valueOf(r9);
        r2 = r2.getStatusMessage();
        r7.zze(r8, r9, r2);
    L_0x00d8:
        if (r6 == 0) goto L_0x0130;
    L_0x00da:
        r2 = r10.zzgg();
        r6 = "firebase_analytics_collection_enabled";
        r2 = r2.zzas(r6);
        r6 = r10.zzgg();
        r6 = r6.zzhg();
        if (r6 == 0) goto L_0x00fc;
    L_0x00ee:
        r2 = r10.zzge();
        r2 = r2.zzir();
        r4 = "Collection disabled with firebase_analytics_collection_deactivated=1";
    L_0x00f8:
        r2.log(r4);
        goto L_0x0130;
    L_0x00fc:
        if (r2 == 0) goto L_0x010f;
    L_0x00fe:
        r6 = r2.booleanValue();
        if (r6 != 0) goto L_0x010f;
    L_0x0104:
        r2 = r10.zzge();
        r2 = r2.zzir();
        r4 = "Collection disabled with firebase_analytics_collection_enabled=0";
        goto L_0x00f8;
    L_0x010f:
        if (r2 != 0) goto L_0x0122;
    L_0x0111:
        r2 = com.google.android.gms.common.api.internal.GoogleServices.isMeasurementExplicitlyDisabled();
        if (r2 == 0) goto L_0x0122;
    L_0x0117:
        r2 = r10.zzge();
        r2 = r2.zzir();
        r4 = "Collection disabled with google_app_measurement_enable=0";
        goto L_0x00f8;
    L_0x0122:
        r2 = r10.zzge();
        r2 = r2.zzit();
        r6 = "Collection enabled";
        r2.log(r6);
        goto L_0x0131;
    L_0x0130:
        r4 = r5;
    L_0x0131:
        r2 = "";
        r10.zzadm = r2;
        r10.zzadx = r0;
        r0 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IllegalStateException -> 0x0159 }
        if (r1 == 0) goto L_0x0143;	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0141:
        r0 = "";	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0143:
        r10.zzadm = r0;	 Catch:{ IllegalStateException -> 0x0159 }
        if (r4 == 0) goto L_0x016b;	 Catch:{ IllegalStateException -> 0x0159 }
    L_0x0147:
        r0 = r10.zzge();	 Catch:{ IllegalStateException -> 0x0159 }
        r0 = r0.zzit();	 Catch:{ IllegalStateException -> 0x0159 }
        r1 = "App package, google app id";	 Catch:{ IllegalStateException -> 0x0159 }
        r2 = r10.zzti;	 Catch:{ IllegalStateException -> 0x0159 }
        r4 = r10.zzadm;	 Catch:{ IllegalStateException -> 0x0159 }
        r0.zze(r1, r2, r4);	 Catch:{ IllegalStateException -> 0x0159 }
        goto L_0x016b;
    L_0x0159:
        r0 = move-exception;
        r1 = r10.zzge();
        r1 = r1.zzim();
        r2 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId";
        r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);
        r1.zze(r2, r3, r0);
    L_0x016b:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 < r1) goto L_0x017c;
    L_0x0171:
        r0 = r10.getContext();
        r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0);
        r10.zzaen = r0;
        return;
    L_0x017c:
        r10.zzaen = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfb.zzih():void");
    }

    @WorkerThread
    final String zzii() {
        zzgb().zzlc().nextBytes(new byte[16]);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, r0)});
    }

    final int zzij() {
        zzch();
        return this.zzaie;
    }

    final int zzik() {
        zzch();
        return this.zzaen;
    }
}
