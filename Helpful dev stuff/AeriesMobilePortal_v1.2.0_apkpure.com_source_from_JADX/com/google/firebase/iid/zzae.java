package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public final class zzae {
    @GuardedBy("this")
    private String zzbu;
    @GuardedBy("this")
    private String zzbv;
    @GuardedBy("this")
    private int zzbw;
    @GuardedBy("this")
    private int zzbx = 0;
    private final Context zzz;

    public zzae(Context context) {
        this.zzz = context;
    }

    public static String zza(FirebaseApp firebaseApp) {
        String gcmSenderId = firebaseApp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = firebaseApp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        applicationId = split[1];
        return applicationId.isEmpty() ? null : applicationId;
    }

    public static java.lang.String zza(java.security.KeyPair r4) {
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
        r4 = r4.getPublic();
        r4 = r4.getEncoded();
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4 = r0.digest(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = r4[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r3 = 15;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = r1 & r3;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = r2 + r1;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = (byte) r2;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4[r0] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = 11;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4 = android.util.Base64.encodeToString(r4, r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        return r4;
    L_0x0027:
        r4 = "FirebaseInstanceId";
        r0 = "Unexpected error, device missing required algorithms";
        android.util.Log.w(r4, r0);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzae.zza(java.security.KeyPair):java.lang.String");
    }

    private final synchronized void zzab() {
        PackageInfo zze = zze(this.zzz.getPackageName());
        if (zze != null) {
            this.zzbu = Integer.toString(zze.versionCode);
            this.zzbv = zze.versionName;
        }
    }

    private final PackageInfo zze(String str) {
        try {
            return this.zzz.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(str).length());
            stringBuilder.append("Failed to find package ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    public final synchronized int zzaa() {
        if (this.zzbw == 0) {
            PackageInfo zze = zze("com.google.android.gms");
            if (zze != null) {
                this.zzbw = zze.versionCode;
            }
        }
        return this.zzbw;
    }

    public final synchronized int zzx() {
        if (this.zzbx != 0) {
            return this.zzbx;
        }
        PackageManager packageManager = this.zzz.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        Intent intent;
        if (!PlatformVersion.isAtLeastO()) {
            intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.zzbx = 1;
                return this.zzbx;
            }
        }
        intent = new Intent("com.google.iid.TOKEN_REQUEST");
        intent.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.zzbx = 2;
            } else {
                this.zzbx = 1;
            }
            return this.zzbx;
        }
        this.zzbx = 2;
        return this.zzbx;
    }

    public final synchronized String zzy() {
        if (this.zzbu == null) {
            zzab();
        }
        return this.zzbu;
    }

    public final synchronized String zzz() {
        if (this.zzbv == null) {
            zzab();
        }
        return this.zzbv;
    }
}
