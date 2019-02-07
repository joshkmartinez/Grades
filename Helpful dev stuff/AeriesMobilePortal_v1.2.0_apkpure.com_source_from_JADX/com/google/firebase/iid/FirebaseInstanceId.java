package com.google.firebase.iid;

import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId {
    private static final long zzah = TimeUnit.HOURS.toSeconds(8);
    private static zzao zzai;
    @GuardedBy("FirebaseInstanceId.class")
    @VisibleForTesting
    private static ScheduledThreadPoolExecutor zzaj;
    private final FirebaseApp zzak;
    private final zzae zzal;
    private final zzo zzam;
    private final zzah zzan;
    @GuardedBy("this")
    private boolean zzao;
    @GuardedBy("this")
    private boolean zzap;

    FirebaseInstanceId(FirebaseApp firebaseApp) {
        this(firebaseApp, new zzae(firebaseApp.getApplicationContext()));
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzae com_google_firebase_iid_zzae) {
        this.zzan = new zzah();
        this.zzao = false;
        if (zzae.zza(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (zzai == null) {
                    zzai = new zzao(firebaseApp.getApplicationContext());
                }
            }
            this.zzak = firebaseApp;
            this.zzal = com_google_firebase_iid_zzae;
            this.zzam = new zzl(firebaseApp, this, com_google_firebase_iid_zzae);
            this.zzap = zzm();
            if (zzo()) {
                zzd();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = (FirebaseInstanceId) firebaseApp.get(FirebaseInstanceId.class);
        }
        return firebaseInstanceId;
    }

    private final synchronized void startSync() {
        if (!this.zzao) {
            zza(0);
        }
    }

    private static <T> T zza(com.google.android.gms.tasks.Task<T> r2) throws java.io.IOException {
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
        r2 = com.google.android.gms.tasks.Tasks.await(r2);	 Catch:{ ExecutionException -> 0x000d, InterruptedException -> 0x0005 }
        return r2;
    L_0x0005:
        r2 = new java.io.IOException;
        r0 = "SERVICE_NOT_AVAILABLE";
        r2.<init>(r0);
        throw r2;
    L_0x000d:
        r2 = move-exception;
        r0 = r2.getCause();
        r1 = r0 instanceof java.io.IOException;
        if (r1 != 0) goto L_0x0026;
    L_0x0016:
        r1 = r0 instanceof java.lang.RuntimeException;
        if (r1 == 0) goto L_0x0020;
    L_0x001a:
        r2 = new java.io.IOException;
        r2.<init>(r0);
        throw r2;
    L_0x0020:
        r0 = new java.io.IOException;
        r0.<init>(r2);
        throw r0;
    L_0x0026:
        r0 = (java.io.IOException) r0;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.zza(com.google.android.gms.tasks.Task):T");
    }

    private final String zza(String str, String str2, Bundle bundle) throws IOException {
        return ((zzl) this.zzam).zza(str, str2, bundle);
    }

    static void zza(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (zzaj == null) {
                zzaj = new ScheduledThreadPoolExecutor(1);
            }
            zzaj.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    private static String zzd(String str) {
        if (!(str.isEmpty() || str.equalsIgnoreCase(AppMeasurement.FCM_ORIGIN))) {
            if (!str.equalsIgnoreCase("gcm")) {
                return str;
            }
        }
        return "*";
    }

    private final void zzd() {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy()) || zzai.zzaf() != null) {
            startSync();
        }
    }

    static String zzf() {
        return zzae.zza(zzai.zzg("").getKeyPair());
    }

    static zzao zzi() {
        return zzai;
    }

    static boolean zzj() {
        if (!Log.isLoggable("FirebaseInstanceId", 3)) {
            if (VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseInstanceId", 3)) {
                return false;
            }
        }
        return true;
    }

    private final boolean zzm() {
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
        r3 = this;
        r0 = r3.zzak;
        r0 = r0.getApplicationContext();
        r1 = "com.google.firebase.messaging";
        r2 = 0;
        r1 = r0.getSharedPreferences(r1, r2);
        r2 = "auto_init";
        r2 = r1.contains(r2);
        if (r2 == 0) goto L_0x001d;
    L_0x0015:
        r0 = "auto_init";
        r2 = 1;
        r0 = r1.getBoolean(r0, r2);
        return r0;
    L_0x001d:
        r1 = r0.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ NameNotFoundException -> 0x0046 }
    L_0x0023:
        r0 = r0.getPackageName();	 Catch:{ NameNotFoundException -> 0x0046 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0046 }
        r0 = r1.getApplicationInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0046 }
        if (r0 == 0) goto L_0x0046;	 Catch:{ NameNotFoundException -> 0x0046 }
    L_0x002f:
        r1 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ NameNotFoundException -> 0x0046 }
    L_0x0033:
        r1 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0046 }
        r2 = "firebase_messaging_auto_init_enabled";	 Catch:{ NameNotFoundException -> 0x0046 }
        r1 = r1.containsKey(r2);	 Catch:{ NameNotFoundException -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ NameNotFoundException -> 0x0046 }
    L_0x003d:
        r0 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x0046 }
        r1 = "firebase_messaging_auto_init_enabled";	 Catch:{ NameNotFoundException -> 0x0046 }
        r0 = r0.getBoolean(r1);	 Catch:{ NameNotFoundException -> 0x0046 }
        return r0;
    L_0x0046:
        r0 = r3.zzn();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.zzm():boolean");
    }

    private final boolean zzn() {
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
        r0 = 1;
        r1 = "com.google.firebase.messaging.FirebaseMessaging";	 Catch:{ ClassNotFoundException -> 0x0007 }
        java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0007 }
        return r0;
    L_0x0007:
        r1 = r4.zzak;
        r1 = r1.getApplicationContext();
        r2 = new android.content.Intent;
        r3 = "com.google.firebase.MESSAGING_EVENT";
        r2.<init>(r3);
        r3 = r1.getPackageName();
        r2.setPackage(r3);
        r1 = r1.getPackageManager();
        r3 = 0;
        r1 = r1.resolveService(r2, r3);
        if (r1 == 0) goto L_0x002b;
    L_0x0026:
        r1 = r1.serviceInfo;
        if (r1 == 0) goto L_0x002b;
    L_0x002a:
        return r0;
    L_0x002b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceId.zzn():boolean");
    }

    @WorkerThread
    public void deleteInstanceId() throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Bundle bundle = new Bundle();
            bundle.putString("iid-operation", "delete");
            bundle.putString("delete", "1");
            zza("*", "*", bundle);
            zzk();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            str2 = zzd(str2);
            Bundle bundle = new Bundle();
            bundle.putString("delete", "1");
            zza(str, str2, bundle);
            zzai.zzc("", str, str2);
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public long getCreationTime() {
        return zzai.zzg("").getCreationTime();
    }

    @WorkerThread
    public String getId() {
        zzd();
        return zzf();
    }

    @Nullable
    public String getToken() {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            startSync();
        }
        return zzg != null ? zzg.zzcu : null;
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            str2 = zzd(str2);
            zzap zzb = zzai.zzb("", str, str2);
            return (zzb == null || zzb.zzj(this.zzal.zzy())) ? this.zzan.zza(str, str2, new zzk(this, str, str2)) : zzb.zzcu;
        } else {
            throw new IOException("MAIN_THREAD");
        }
    }

    final /* synthetic */ String zza(String str, String str2) throws IOException {
        String str3 = (String) zza(this.zzam.zzb(str, str2));
        zzai.zza("", str, str2, str3, this.zzal.zzy());
        return str3;
    }

    final synchronized void zza(long j) {
        zza(new zzaq(this, this.zzal, Math.min(Math.max(30, j << 1), zzah)), j);
        this.zzao = true;
    }

    public final synchronized void zza(String str) {
        zzai.zza(str);
        startSync();
    }

    final synchronized void zza(boolean z) {
        this.zzao = z;
    }

    final void zzb(String str) throws IOException {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        String str3 = zzg.zzcu;
        str2 = String.valueOf("/topics/");
        str = String.valueOf(str);
        zza(str3, str.length() != 0 ? str2.concat(str) : new String(str2), bundle);
    }

    @VisibleForTesting
    public final synchronized void zzb(boolean z) {
        Editor edit = this.zzak.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        edit.putBoolean("auto_init", z);
        edit.apply();
        if (!this.zzap && z) {
            zzd();
        }
        this.zzap = z;
    }

    final void zzc(String str) throws IOException {
        zzap zzg = zzg();
        if (zzg == null || zzg.zzj(this.zzal.zzy())) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String str2 = "gcm.topic";
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString(str2, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        bundle.putString("delete", "1");
        String str3 = zzg.zzcu;
        str2 = String.valueOf("/topics/");
        str = String.valueOf(str);
        zza(str3, str.length() != 0 ? str2.concat(str) : new String(str2), bundle);
    }

    final FirebaseApp zze() {
        return this.zzak;
    }

    @Nullable
    final zzap zzg() {
        return zzai.zzb("", zzae.zza(this.zzak), "*");
    }

    final String zzh() throws IOException {
        return getToken(zzae.zza(this.zzak), "*");
    }

    final synchronized void zzk() {
        zzai.zzag();
        if (zzo()) {
            startSync();
        }
    }

    final void zzl() {
        zzai.zzh("");
        startSync();
    }

    @VisibleForTesting
    public final synchronized boolean zzo() {
        return this.zzap;
    }
}
