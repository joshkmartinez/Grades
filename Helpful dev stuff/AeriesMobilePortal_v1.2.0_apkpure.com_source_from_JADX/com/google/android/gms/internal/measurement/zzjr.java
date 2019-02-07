package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjr implements zzec {
    private zzgl zzacw;
    zzgf zzaqa;
    zzfk zzaqb;
    private zzei zzaqc;
    private zzfp zzaqd;
    private zzjn zzaqe;
    private zzeb zzaqf;
    private boolean zzaqg;
    @VisibleForTesting
    private long zzaqh;
    private List<Runnable> zzaqi;
    private int zzaqj;
    private int zzaqk;
    private boolean zzaql;
    private boolean zzaqm;
    private boolean zzaqn;
    private FileLock zzaqo;
    private FileChannel zzaqp;
    private List<Long> zzaqq;
    private List<Long> zzaqr;
    long zzaqs;
    private boolean zzvo = false;

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzab();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                int read;
                try {
                    fileChannel.position(0);
                    read = fileChannel.read(allocate);
                    if (read != 4) {
                        if (read != -1) {
                            zzge().zzip().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                        return 0;
                    }
                    allocate.flip();
                    read = allocate.getInt();
                    return read;
                } catch (IOException e) {
                    zzge().zzim().zzg("Failed to read from channel", e);
                    read = 0;
                }
            }
        }
        zzge().zzim().log("Bad channel to read from");
        return 0;
    }

    private final com.google.android.gms.internal.measurement.zzdz zza(android.content.Context r25, java.lang.String r26, java.lang.String r27, boolean r28, boolean r29, boolean r30, long r31) {
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
        r24 = this;
        r1 = r26;
        r0 = "Unknown";
        r2 = "Unknown";
        r3 = "Unknown";
        r4 = r25.getPackageManager();
        r5 = 0;
        if (r4 != 0) goto L_0x001d;
    L_0x000f:
        r0 = r24.zzge();
        r0 = r0.zzim();
        r1 = "PackageManager is null, can not log app install information";
        r0.log(r1);
        return r5;
    L_0x001d:
        r4 = r4.getInstallerPackageName(r1);	 Catch:{ IllegalArgumentException -> 0x0023 }
        r0 = r4;
        goto L_0x0034;
    L_0x0023:
        r4 = r24.zzge();
        r4 = r4.zzim();
        r6 = "Error retrieving installer package name. appId";
        r7 = com.google.android.gms.internal.measurement.zzfg.zzbm(r26);
        r4.zzg(r6, r7);
    L_0x0034:
        if (r0 != 0) goto L_0x003a;
    L_0x0036:
        r0 = "manual_install";
    L_0x0038:
        r6 = r0;
        goto L_0x0045;
    L_0x003a:
        r4 = "com.android.vending";
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0038;
    L_0x0042:
        r0 = "";
        goto L_0x0038;
    L_0x0045:
        r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r25);	 Catch:{ NameNotFoundException -> 0x00a5 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x00a5 }
        r0 = r0.getPackageInfo(r1, r4);	 Catch:{ NameNotFoundException -> 0x00a5 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ NameNotFoundException -> 0x00a5 }
    L_0x0050:
        r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r25);	 Catch:{ NameNotFoundException -> 0x00a5 }
        r2 = r2.getApplicationLabel(r1);	 Catch:{ NameNotFoundException -> 0x00a5 }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ NameNotFoundException -> 0x00a5 }
        if (r4 != 0) goto L_0x0063;	 Catch:{ NameNotFoundException -> 0x00a5 }
    L_0x005e:
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x00a5 }
        r3 = r2;	 Catch:{ NameNotFoundException -> 0x00a5 }
    L_0x0063:
        r2 = r0.versionName;	 Catch:{ NameNotFoundException -> 0x00a5 }
        r0 = r0.versionCode;	 Catch:{ NameNotFoundException -> 0x00a5 }
        goto L_0x006a;
    L_0x0068:
        r0 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
    L_0x006a:
        r3 = r2;
        r4 = 0;
        r2 = r24.zzgg();
        r2 = r2.zzba(r1);
        if (r2 == 0) goto L_0x007a;
    L_0x0077:
        r17 = r31;
        goto L_0x007c;
    L_0x007a:
        r17 = r4;
    L_0x007c:
        r23 = new com.google.android.gms.internal.measurement.zzdz;
        r4 = (long) r0;
        r7 = 12451; // 0x30a3 float:1.7448E-41 double:6.1516E-320;
        r0 = r24.zzgb();
        r2 = r25;
        r9 = r0.zzd(r2, r1);
        r11 = 0;
        r13 = 0;
        r14 = "";
        r15 = 0;
        r19 = 0;
        r22 = 0;
        r0 = r23;
        r1 = r26;
        r2 = r27;
        r12 = r28;
        r20 = r29;
        r21 = r30;
        r0.<init>(r1, r2, r3, r4, r6, r7, r9, r11, r12, r13, r14, r15, r17, r19, r20, r21, r22);
        return r23;
    L_0x00a5:
        r0 = r24.zzge();
        r0 = r0.zzim();
        r2 = "Error retrieving newly installed package info. appId, appName";
        r1 = com.google.android.gms.internal.measurement.zzfg.zzbm(r26);
        r0.zze(r2, r1, r3);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zza(android.content.Context, java.lang.String, java.lang.String, boolean, boolean, boolean, long):com.google.android.gms.internal.measurement.zzdz");
    }

    private static void zza(zzjq com_google_android_gms_internal_measurement_zzjq) {
        if (com_google_android_gms_internal_measurement_zzjq == null) {
            throw new IllegalStateException("Upload component not created");
        } else if (!com_google_android_gms_internal_measurement_zzjq.isInitialized()) {
            String valueOf = String.valueOf(com_google_android_gms_internal_measurement_zzjq.getClass());
            StringBuilder stringBuilder = new StringBuilder(27 + String.valueOf(valueOf).length());
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append(valueOf);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzab();
        if (fileChannel != null) {
            if (fileChannel.isOpen()) {
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.putInt(i);
                allocate.flip();
                try {
                    fileChannel.truncate(0);
                    fileChannel.write(allocate);
                    fileChannel.force(true);
                    if (fileChannel.size() != 4) {
                        zzge().zzim().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
                    }
                    return true;
                } catch (IOException e) {
                    zzge().zzim().zzg("Failed to write to channel", e);
                    return false;
                }
            }
        }
        zzge().zzim().log("Bad channel to read from");
        return false;
    }

    private final boolean zza(String str, zzeu com_google_android_gms_internal_measurement_zzeu) {
        long round;
        Object string = com_google_android_gms_internal_measurement_zzeu.zzafq.getString(Param.CURRENCY);
        if (Event.ECOMMERCE_PURCHASE.equals(com_google_android_gms_internal_measurement_zzeu.name)) {
            double doubleValue = com_google_android_gms_internal_measurement_zzeu.zzafq.zzbh(Param.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) com_google_android_gms_internal_measurement_zzeu.zzafq.getLong(Param.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().zzip().zze("Data lost. Currency value is too big. appId", zzfg.zzbm(str), Double.valueOf(doubleValue));
                return false;
            }
            round = Math.round(doubleValue);
        } else {
            round = com_google_android_gms_internal_measurement_zzeu.zzafq.getLong(Param.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String toUpperCase = string.toUpperCase(Locale.US);
            if (toUpperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                toUpperCase = String.valueOf(toUpperCase);
                String concat = toUpperCase.length() != 0 ? valueOf.concat(toUpperCase) : new String(valueOf);
                zzjz zzh = zzix().zzh(str, concat);
                if (zzh != null) {
                    if (zzh.value instanceof Long) {
                        zzh = new zzjz(str, com_google_android_gms_internal_measurement_zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + round));
                        if (!zzix().zza(zzh)) {
                            zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzh.name), zzh.value);
                            zzgb().zza(str, 9, null, null, 0);
                        }
                    }
                }
                zzhg zzix = zzix();
                int zzb = zzgg().zzb(str, zzew.zzahm) - 1;
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                try {
                    zzix.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                } catch (SQLiteException e) {
                    zzix.zzge().zzim().zze("Error pruning currencies. appId", zzfg.zzbm(str), e);
                }
                zzjz com_google_android_gms_internal_measurement_zzjz = new zzjz(str, com_google_android_gms_internal_measurement_zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(round));
                if (zzix().zza(zzh)) {
                    zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzh.name), zzh.value);
                    zzgb().zza(str, 9, null, null, 0);
                }
            }
        }
        return true;
    }

    private final zzkm[] zza(String str, zzks[] com_google_android_gms_internal_measurement_zzksArr, zzkn[] com_google_android_gms_internal_measurement_zzknArr) {
        Preconditions.checkNotEmpty(str);
        return zziw().zza(str, com_google_android_gms_internal_measurement_zzknArr, com_google_android_gms_internal_measurement_zzksArr);
    }

    @android.support.annotation.WorkerThread
    private final void zzb(com.google.android.gms.internal.measurement.zzdy r11) {
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
        r10.zzab();
        r0 = r11.getGmpAppId();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x001b;
    L_0x000d:
        r2 = r11.zzah();
        r3 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r10;
        r1.zzb(r2, r3, r4, r5, r6);
        return;
    L_0x001b:
        r0 = r11.getGmpAppId();
        r1 = r11.getAppInstanceId();
        r2 = new android.net.Uri$Builder;
        r2.<init>();
        r3 = com.google.android.gms.internal.measurement.zzew.zzagm;
        r3 = r3.get();
        r3 = (java.lang.String) r3;
        r3 = r2.scheme(r3);
        r4 = com.google.android.gms.internal.measurement.zzew.zzagn;
        r4 = r4.get();
        r4 = (java.lang.String) r4;
        r3 = r3.encodedAuthority(r4);
        r4 = "config/app/";
        r0 = java.lang.String.valueOf(r0);
        r5 = r0.length();
        if (r5 == 0) goto L_0x0051;
    L_0x004c:
        r0 = r4.concat(r0);
        goto L_0x0056;
    L_0x0051:
        r0 = new java.lang.String;
        r0.<init>(r4);
    L_0x0056:
        r0 = r3.path(r0);
        r3 = "app_instance_id";
        r0 = r0.appendQueryParameter(r3, r1);
        r1 = "platform";
        r3 = "android";
        r0 = r0.appendQueryParameter(r1, r3);
        r1 = "gmp_version";
        r3 = "12451";
        r0.appendQueryParameter(r1, r3);
        r0 = r2.build();
        r0 = r0.toString();
        r4 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00e6 }
        r4.<init>(r0);	 Catch:{ MalformedURLException -> 0x00e6 }
        r1 = r10.zzge();	 Catch:{ MalformedURLException -> 0x00e6 }
        r1 = r1.zzit();	 Catch:{ MalformedURLException -> 0x00e6 }
        r2 = "Fetching remote configuration";	 Catch:{ MalformedURLException -> 0x00e6 }
        r3 = r11.zzah();	 Catch:{ MalformedURLException -> 0x00e6 }
        r1.zzg(r2, r3);	 Catch:{ MalformedURLException -> 0x00e6 }
        r1 = r10.zzkm();	 Catch:{ MalformedURLException -> 0x00e6 }
        r2 = r11.zzah();	 Catch:{ MalformedURLException -> 0x00e6 }
        r1 = r1.zzbu(r2);	 Catch:{ MalformedURLException -> 0x00e6 }
        r2 = 0;	 Catch:{ MalformedURLException -> 0x00e6 }
        r3 = r10.zzkm();	 Catch:{ MalformedURLException -> 0x00e6 }
        r5 = r11.zzah();	 Catch:{ MalformedURLException -> 0x00e6 }
        r3 = r3.zzbv(r5);	 Catch:{ MalformedURLException -> 0x00e6 }
        if (r1 == 0) goto L_0x00ba;	 Catch:{ MalformedURLException -> 0x00e6 }
    L_0x00a8:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ MalformedURLException -> 0x00e6 }
        if (r1 != 0) goto L_0x00ba;	 Catch:{ MalformedURLException -> 0x00e6 }
    L_0x00ae:
        r1 = new android.support.v4.util.ArrayMap;	 Catch:{ MalformedURLException -> 0x00e6 }
        r1.<init>();	 Catch:{ MalformedURLException -> 0x00e6 }
        r2 = "If-Modified-Since";	 Catch:{ MalformedURLException -> 0x00e6 }
        r1.put(r2, r3);	 Catch:{ MalformedURLException -> 0x00e6 }
        r6 = r1;	 Catch:{ MalformedURLException -> 0x00e6 }
        goto L_0x00bb;	 Catch:{ MalformedURLException -> 0x00e6 }
    L_0x00ba:
        r6 = r2;	 Catch:{ MalformedURLException -> 0x00e6 }
    L_0x00bb:
        r1 = 1;	 Catch:{ MalformedURLException -> 0x00e6 }
        r10.zzaql = r1;	 Catch:{ MalformedURLException -> 0x00e6 }
        r2 = r10.zzkn();	 Catch:{ MalformedURLException -> 0x00e6 }
        r3 = r11.zzah();	 Catch:{ MalformedURLException -> 0x00e6 }
        r7 = new com.google.android.gms.internal.measurement.zzjt;	 Catch:{ MalformedURLException -> 0x00e6 }
        r7.<init>(r10);	 Catch:{ MalformedURLException -> 0x00e6 }
        r2.zzab();	 Catch:{ MalformedURLException -> 0x00e6 }
        r2.zzch();	 Catch:{ MalformedURLException -> 0x00e6 }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r4);	 Catch:{ MalformedURLException -> 0x00e6 }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r7);	 Catch:{ MalformedURLException -> 0x00e6 }
        r8 = r2.zzgd();	 Catch:{ MalformedURLException -> 0x00e6 }
        r9 = new com.google.android.gms.internal.measurement.zzfo;	 Catch:{ MalformedURLException -> 0x00e6 }
        r5 = 0;	 Catch:{ MalformedURLException -> 0x00e6 }
        r1 = r9;	 Catch:{ MalformedURLException -> 0x00e6 }
        r1.<init>(r2, r3, r4, r5, r6, r7);	 Catch:{ MalformedURLException -> 0x00e6 }
        r8.zzd(r9);	 Catch:{ MalformedURLException -> 0x00e6 }
        return;
    L_0x00e6:
        r1 = r10.zzge();
        r1 = r1.zzim();
        r2 = "Failed to parse config URL. Not fetching. appId";
        r11 = r11.zzah();
        r11 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11);
        r1.zze(r2, r11, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzb(com.google.android.gms.internal.measurement.zzdy):void");
    }

    @android.support.annotation.WorkerThread
    private final java.lang.Boolean zzc(com.google.android.gms.internal.measurement.zzdy r8) {
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
        r7 = this;
        r0 = r8.zzgm();	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;	 Catch:{ NameNotFoundException -> 0x0059 }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ NameNotFoundException -> 0x0059 }
        r0 = 1;	 Catch:{ NameNotFoundException -> 0x0059 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0059 }
        if (r4 == 0) goto L_0x002d;	 Catch:{ NameNotFoundException -> 0x0059 }
    L_0x000d:
        r2 = r7.getContext();	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2);	 Catch:{ NameNotFoundException -> 0x0059 }
        r3 = r8.zzah();	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = r2.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0059 }
        r3 = r8.zzgm();	 Catch:{ NameNotFoundException -> 0x0059 }
        r5 = (long) r2;	 Catch:{ NameNotFoundException -> 0x0059 }
        r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));	 Catch:{ NameNotFoundException -> 0x0059 }
        if (r8 != 0) goto L_0x0054;	 Catch:{ NameNotFoundException -> 0x0059 }
    L_0x0028:
        r8 = java.lang.Boolean.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x0059 }
        return r8;	 Catch:{ NameNotFoundException -> 0x0059 }
    L_0x002d:
        r2 = r7.getContext();	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r2);	 Catch:{ NameNotFoundException -> 0x0059 }
        r3 = r8.zzah();	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = r2.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0059 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x0059 }
        r3 = r8.zzag();	 Catch:{ NameNotFoundException -> 0x0059 }
        if (r3 == 0) goto L_0x0054;	 Catch:{ NameNotFoundException -> 0x0059 }
    L_0x0045:
        r8 = r8.zzag();	 Catch:{ NameNotFoundException -> 0x0059 }
        r8 = r8.equals(r2);	 Catch:{ NameNotFoundException -> 0x0059 }
        if (r8 == 0) goto L_0x0054;	 Catch:{ NameNotFoundException -> 0x0059 }
    L_0x004f:
        r8 = java.lang.Boolean.valueOf(r0);	 Catch:{ NameNotFoundException -> 0x0059 }
        return r8;
    L_0x0054:
        r8 = java.lang.Boolean.valueOf(r1);
        return r8;
    L_0x0059:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzc(com.google.android.gms.internal.measurement.zzdy):java.lang.Boolean");
    }

    @WorkerThread
    private final void zzc(zzeu com_google_android_gms_internal_measurement_zzeu, zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzeu com_google_android_gms_internal_measurement_zzeu2 = com_google_android_gms_internal_measurement_zzeu;
        zzdz com_google_android_gms_internal_measurement_zzdz2 = com_google_android_gms_internal_measurement_zzdz;
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzdz2.packageName);
        long nanoTime = System.nanoTime();
        zzab();
        zzkq();
        String str = com_google_android_gms_internal_measurement_zzdz2.packageName;
        zzgb();
        if (!zzka.zzd(com_google_android_gms_internal_measurement_zzeu, com_google_android_gms_internal_measurement_zzdz)) {
            return;
        }
        if (com_google_android_gms_internal_measurement_zzdz2.zzadw) {
            Object obj = 1;
            if (zzkm().zzn(str, com_google_android_gms_internal_measurement_zzeu2.name)) {
                zzge().zzip().zze("Dropping blacklisted event. appId", zzfg.zzbm(str), zzga().zzbj(com_google_android_gms_internal_measurement_zzeu2.name));
                if (!zzkm().zzby(str)) {
                    if (!zzkm().zzbz(str)) {
                        obj = null;
                    }
                }
                if (obj == null && !"_err".equals(com_google_android_gms_internal_measurement_zzeu2.name)) {
                    zzgb().zza(str, 11, "_ev", com_google_android_gms_internal_measurement_zzeu2.name, 0);
                }
                if (obj != null) {
                    zzdy zzbc = zzix().zzbc(str);
                    if (zzbc != null) {
                        if (Math.abs(zzbt().currentTimeMillis() - Math.max(zzbc.zzgs(), zzbc.zzgr())) > ((Long) zzew.zzahh.get()).longValue()) {
                            zzge().zzis().log("Fetching config for blacklisted app");
                            zzb(zzbc);
                        }
                    }
                }
                return;
            }
            if (zzge().isLoggable(2)) {
                zzge().zzit().zzg("Logging event", zzga().zzb(com_google_android_gms_internal_measurement_zzeu2));
            }
            zzix().beginTransaction();
            zzg(com_google_android_gms_internal_measurement_zzdz2);
            if (("_iap".equals(com_google_android_gms_internal_measurement_zzeu2.name) || Event.ECOMMERCE_PURCHASE.equals(com_google_android_gms_internal_measurement_zzeu2.name)) && !zza(str, com_google_android_gms_internal_measurement_zzeu2)) {
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                return;
            }
            zzkq com_google_android_gms_internal_measurement_zzkq;
            try {
                boolean zzcc = zzka.zzcc(com_google_android_gms_internal_measurement_zzeu2.name);
                boolean equals = "_err".equals(com_google_android_gms_internal_measurement_zzeu2.name);
                zzej zza = zzix().zza(zzkr(), str, true, zzcc, false, equals, false);
                long intValue = zza.zzafe - ((long) ((Integer) zzew.zzags.get()).intValue());
                if (intValue > 0) {
                    if (intValue % 1000 == 1) {
                        zzge().zzim().zze("Data loss. Too many events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafe));
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    return;
                }
                boolean z;
                zzep zza2;
                if (zzcc) {
                    String str2 = str;
                    long intValue2 = zza.zzafd - ((long) ((Integer) zzew.zzagu.get()).intValue());
                    if (intValue2 > 0) {
                        if (intValue2 % 1000 == 1) {
                            str = str2;
                            zzge().zzim().zze("Data loss. Too many public events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafd));
                        } else {
                            str = str2;
                        }
                        zzgb().zza(str, 16, "_ev", com_google_android_gms_internal_measurement_zzeu2.name, 0);
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                    str = str2;
                }
                if (equals) {
                    z = false;
                    intValue = zza.zzafg - ((long) Math.max(0, Math.min(1000000, zzgg().zzb(com_google_android_gms_internal_measurement_zzdz2.packageName, zzew.zzagt))));
                    if (intValue > 0) {
                        if (intValue == 1) {
                            zzge().zzim().zze("Too many error events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafg));
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                }
                z = false;
                Bundle zzif = com_google_android_gms_internal_measurement_zzeu2.zzafq.zzif();
                zzgb().zza(zzif, "_o", com_google_android_gms_internal_measurement_zzeu2.origin);
                if (zzgb().zzcj(str)) {
                    zzgb().zza(zzif, "_dbg", Long.valueOf(1));
                    zzgb().zza(zzif, "_r", Long.valueOf(1));
                }
                long zzbd = zzix().zzbd(str);
                if (zzbd > 0) {
                    zzge().zzip().zze("Data lost. Too many events stored on disk, deleted. appId", zzfg.zzbm(str), Long.valueOf(zzbd));
                }
                long j = nanoTime;
                zzep com_google_android_gms_internal_measurement_zzep = r5;
                boolean z2 = z;
                zzep com_google_android_gms_internal_measurement_zzep2 = new zzep(com_google_android_gms_internal_measurement_zzjr.zzacw, com_google_android_gms_internal_measurement_zzeu2.origin, str, com_google_android_gms_internal_measurement_zzeu2.name, com_google_android_gms_internal_measurement_zzeu2.zzagb, 0, zzif);
                zzeq zzf = zzix().zzf(str, com_google_android_gms_internal_measurement_zzep.name);
                if (zzf != null) {
                    zza2 = com_google_android_gms_internal_measurement_zzep.zza(com_google_android_gms_internal_measurement_zzjr.zzacw, zzf.zzaft);
                    zzf = zzf.zzac(zza2.timestamp);
                } else if (zzix().zzbg(str) < 500 || !zzcc) {
                    zzeq com_google_android_gms_internal_measurement_zzeq = new zzeq(str, com_google_android_gms_internal_measurement_zzep.name, 0, 0, com_google_android_gms_internal_measurement_zzep.timestamp, 0, null, null, null);
                    zza2 = com_google_android_gms_internal_measurement_zzep;
                } else {
                    zzge().zzim().zzd("Too many event names used, ignoring event. appId, name, supported count", zzfg.zzbm(str), zzga().zzbj(com_google_android_gms_internal_measurement_zzep.name), Integer.valueOf(HttpStatus.HTTP_INTERNAL_SERVER_ERROR));
                    zzgb().zza(str, 8, null, null, 0);
                    zzix().endTransaction();
                    return;
                }
                zzix().zza(zzf);
                zzab();
                zzkq();
                Preconditions.checkNotNull(zza2);
                Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
                Preconditions.checkNotEmpty(zza2.zzti);
                Preconditions.checkArgument(zza2.zzti.equals(com_google_android_gms_internal_measurement_zzdz2.packageName));
                com_google_android_gms_internal_measurement_zzkq = new zzkq();
                boolean z3 = true;
                com_google_android_gms_internal_measurement_zzkq.zzath = Integer.valueOf(1);
                com_google_android_gms_internal_measurement_zzkq.zzatp = AbstractSpiCall.ANDROID_CLIENT_TYPE;
                com_google_android_gms_internal_measurement_zzkq.zzti = com_google_android_gms_internal_measurement_zzdz2.packageName;
                com_google_android_gms_internal_measurement_zzkq.zzadt = com_google_android_gms_internal_measurement_zzdz2.zzadt;
                com_google_android_gms_internal_measurement_zzkq.zzth = com_google_android_gms_internal_measurement_zzdz2.zzth;
                com_google_android_gms_internal_measurement_zzkq.zzaub = com_google_android_gms_internal_measurement_zzdz2.zzads == -2147483648L ? null : Integer.valueOf((int) com_google_android_gms_internal_measurement_zzdz2.zzads);
                com_google_android_gms_internal_measurement_zzkq.zzatt = Long.valueOf(com_google_android_gms_internal_measurement_zzdz2.zzadu);
                com_google_android_gms_internal_measurement_zzkq.zzadm = com_google_android_gms_internal_measurement_zzdz2.zzadm;
                com_google_android_gms_internal_measurement_zzkq.zzatx = com_google_android_gms_internal_measurement_zzdz2.zzadv == 0 ? null : Long.valueOf(com_google_android_gms_internal_measurement_zzdz2.zzadv);
                Pair zzbo = zzgf().zzbo(com_google_android_gms_internal_measurement_zzdz2.packageName);
                if (zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    if (!zzfw().zzf(getContext()) && com_google_android_gms_internal_measurement_zzdz2.zzadz) {
                        String string = Secure.getString(getContext().getContentResolver(), "android_id");
                        if (string == null) {
                            zzge().zzip().zzg("null secure ID. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti));
                            string = "null";
                        } else if (string.isEmpty()) {
                            zzge().zzip().zzg("empty secure ID. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti));
                        }
                        com_google_android_gms_internal_measurement_zzkq.zzaue = string;
                    }
                } else if (com_google_android_gms_internal_measurement_zzdz2.zzady) {
                    com_google_android_gms_internal_measurement_zzkq.zzatv = (String) zzbo.first;
                    com_google_android_gms_internal_measurement_zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                com_google_android_gms_internal_measurement_zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                com_google_android_gms_internal_measurement_zzkq.zzatq = VERSION.RELEASE;
                com_google_android_gms_internal_measurement_zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                com_google_android_gms_internal_measurement_zzkq.zzafn = zzfw().zzid();
                com_google_android_gms_internal_measurement_zzkq.zzatu = null;
                com_google_android_gms_internal_measurement_zzkq.zzatk = null;
                com_google_android_gms_internal_measurement_zzkq.zzatl = null;
                com_google_android_gms_internal_measurement_zzkq.zzatm = null;
                com_google_android_gms_internal_measurement_zzkq.zzaug = Long.valueOf(com_google_android_gms_internal_measurement_zzdz2.zzadx);
                if (com_google_android_gms_internal_measurement_zzjr.zzacw.isEnabled() && zzef.zzhk()) {
                    com_google_android_gms_internal_measurement_zzkq.zzauh = null;
                }
                zzdy zzbc2 = zzix().zzbc(com_google_android_gms_internal_measurement_zzdz2.packageName);
                if (zzbc2 == null) {
                    zzbc2 = new zzdy(com_google_android_gms_internal_measurement_zzjr.zzacw, com_google_android_gms_internal_measurement_zzdz2.packageName);
                    zzbc2.zzal(com_google_android_gms_internal_measurement_zzjr.zzacw.zzfv().zzii());
                    zzbc2.zzao(com_google_android_gms_internal_measurement_zzdz2.zzado);
                    zzbc2.zzam(com_google_android_gms_internal_measurement_zzdz2.zzadm);
                    zzbc2.zzan(zzgf().zzbp(com_google_android_gms_internal_measurement_zzdz2.packageName));
                    zzbc2.zzr(0);
                    zzbc2.zzm(0);
                    zzbc2.zzn(0);
                    zzbc2.setAppVersion(com_google_android_gms_internal_measurement_zzdz2.zzth);
                    zzbc2.zzo(com_google_android_gms_internal_measurement_zzdz2.zzads);
                    zzbc2.zzap(com_google_android_gms_internal_measurement_zzdz2.zzadt);
                    zzbc2.zzp(com_google_android_gms_internal_measurement_zzdz2.zzadu);
                    zzbc2.zzq(com_google_android_gms_internal_measurement_zzdz2.zzadv);
                    zzbc2.setMeasurementEnabled(com_google_android_gms_internal_measurement_zzdz2.zzadw);
                    zzbc2.zzaa(com_google_android_gms_internal_measurement_zzdz2.zzadx);
                    zzix().zza(zzbc2);
                }
                com_google_android_gms_internal_measurement_zzkq.zzadl = zzbc2.getAppInstanceId();
                com_google_android_gms_internal_measurement_zzkq.zzado = zzbc2.zzgj();
                List zzbb = zzix().zzbb(com_google_android_gms_internal_measurement_zzdz2.packageName);
                com_google_android_gms_internal_measurement_zzkq.zzatj = new zzks[zzbb.size()];
                for (int i = z2; i < zzbb.size(); i++) {
                    zzks com_google_android_gms_internal_measurement_zzks = new zzks();
                    com_google_android_gms_internal_measurement_zzkq.zzatj[i] = com_google_android_gms_internal_measurement_zzks;
                    com_google_android_gms_internal_measurement_zzks.name = ((zzjz) zzbb.get(i)).name;
                    com_google_android_gms_internal_measurement_zzks.zzaun = Long.valueOf(((zzjz) zzbb.get(i)).zzaqz);
                    zzgb().zza(com_google_android_gms_internal_measurement_zzks, ((zzjz) zzbb.get(i)).value);
                }
                zzbd = zzix().zza(com_google_android_gms_internal_measurement_zzkq);
                zzei zzix = zzix();
                if (zza2.zzafq != null) {
                    Iterator it = zza2.zzafq.iterator();
                    while (it.hasNext()) {
                        if ("_r".equals((String) it.next())) {
                            break;
                        }
                    }
                    boolean zzo = zzkm().zzo(zza2.zzti, zza2.name);
                    zzej zza3 = zzix().zza(zzkr(), zza2.zzti, false, false, false, false, false);
                    if (zzo && zza3.zzafh < ((long) zzgg().zzar(zza2.zzti))) {
                        if (zzix.zza(zza2, zzbd, z3)) {
                            com_google_android_gms_internal_measurement_zzjr.zzaqh = 0;
                        }
                        zzix().setTransactionSuccessful();
                        if (zzge().isLoggable(2)) {
                            zzge().zzit().zzg("Event recorded", zzga().zza(zza2));
                        }
                        zzix().endTransaction();
                        zzku();
                        zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
                    }
                }
                z3 = z2;
                if (zzix.zza(zza2, zzbd, z3)) {
                    com_google_android_gms_internal_measurement_zzjr.zzaqh = 0;
                }
                zzix().setTransactionSuccessful();
                if (zzge().isLoggable(2)) {
                    zzge().zzit().zzg("Event recorded", zzga().zza(zza2));
                }
                zzix().endTransaction();
                zzku();
                zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j) + 500000) / 1000000));
            } catch (IOException e) {
                zzge().zzim().zze("Data loss. Failed to insert raw event metadata. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzkq.zzti), e);
            } catch (Throwable th) {
                zzix().endTransaction();
            }
        } else {
            zzg(com_google_android_gms_internal_measurement_zzdz2);
        }
    }

    @android.support.annotation.WorkerThread
    private final boolean zzd(java.lang.String r51, long r52) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.google.android.gms.internal.measurement.zzjr.zzd(java.lang.String, long):boolean. bs: [B:21:0x007e, B:52:0x00e4]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
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
        r50 = this;
        r1 = r50;
        r0 = r50.zzix();
        r0.beginTransaction();
        r2 = new com.google.android.gms.internal.measurement.zzjv;	 Catch:{ all -> 0x0afb }
        r3 = 0;	 Catch:{ all -> 0x0afb }
        r2.<init>(r1);	 Catch:{ all -> 0x0afb }
        r4 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r5 = r1.zzaqs;	 Catch:{ all -> 0x0afb }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r2);	 Catch:{ all -> 0x0afb }
        r4.zzab();	 Catch:{ all -> 0x0afb }
        r4.zzch();	 Catch:{ all -> 0x0afb }
        r7 = -1;
        r9 = 2;
        r10 = 0;
        r11 = 1;
        r0 = r4.getWritableDatabase();	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r12 = android.text.TextUtils.isEmpty(r3);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        if (r12 == 0) goto L_0x00a3;
    L_0x002d:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x0048;
    L_0x0031:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r52);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x0050;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0040:
        r0 = move-exception;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r9 = r3;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x0af5;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0044:
        r0 = move-exception;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r9 = r3;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x025c;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0048:
        r12 = new java.lang.String[r11];	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r52);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12[r10] = r13;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0050:
        r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        if (r13 == 0) goto L_0x0057;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0054:
        r13 = "rowid <= ? and ";	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x0059;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0057:
        r13 = "";	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
    L_0x0059:
        r14 = 148; // 0x94 float:2.07E-43 double:7.3E-322;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15 = r15.length();	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r14 = r14 + r15;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15.<init>(r14);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r14 = "select app_id, metadata_fingerprint from raw_events where ";	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15.append(r14);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15.append(r13);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;";	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r15.append(r13);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = r15.toString();	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12 = r0.rawQuery(r13, r12);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x009f, all -> 0x024d }
        if (r13 != 0) goto L_0x008b;
    L_0x0084:
        if (r12 == 0) goto L_0x0270;
    L_0x0086:
        r12.close();	 Catch:{ all -> 0x0afb }
        goto L_0x0270;
    L_0x008b:
        r13 = r12.getString(r10);	 Catch:{ SQLiteException -> 0x009f, all -> 0x024d }
        r14 = r12.getString(r11);	 Catch:{ SQLiteException -> 0x009a, all -> 0x024d }
        r12.close();	 Catch:{ SQLiteException -> 0x009a, all -> 0x024d }
        r22 = r12;
        r15 = r13;
        goto L_0x00f7;
    L_0x009a:
        r0 = move-exception;
        r9 = r12;
        r3 = r13;
        goto L_0x025c;
    L_0x009f:
        r0 = move-exception;
        r9 = r12;
        goto L_0x025c;
    L_0x00a3:
        r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r12 == 0) goto L_0x00b2;
    L_0x00a7:
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r13 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        r12[r11] = r13;	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x00b6;
    L_0x00b2:
        r12 = new java.lang.String[]{r3};	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
    L_0x00b6:
        r13 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r13 == 0) goto L_0x00bd;
    L_0x00ba:
        r13 = " and rowid <= ?";	 Catch:{ SQLiteException -> 0x0044, all -> 0x0040 }
        goto L_0x00bf;
    L_0x00bd:
        r13 = "";	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
    L_0x00bf:
        r14 = 84;	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15 = java.lang.String.valueOf(r13);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15 = r15.length();	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r14 = r14 + r15;	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15 = new java.lang.StringBuilder;	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15.<init>(r14);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r14 = "select metadata_fingerprint from raw_events where app_id = ?";	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15.append(r14);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15.append(r13);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r13 = " order by rowid limit 1;";	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r15.append(r13);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r13 = r15.toString();	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r12 = r0.rawQuery(r13, r12);	 Catch:{ SQLiteException -> 0x0259, all -> 0x0255 }
        r13 = r12.moveToFirst();	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
        if (r13 != 0) goto L_0x00ed;	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
    L_0x00ea:
        if (r12 == 0) goto L_0x0270;	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
    L_0x00ec:
        goto L_0x0086;	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
    L_0x00ed:
        r14 = r12.getString(r10);	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
        r12.close();	 Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
        r15 = r3;
        r22 = r12;
    L_0x00f7:
        r21 = r14;
        r13 = "raw_events_metadata";	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r12 = "metadata";	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r14 = new java.lang.String[]{r12};	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r16 = "app_id = ? and metadata_fingerprint = ?";	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r12 = new java.lang.String[r9];	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r12[r10] = r15;	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r17 = 0;	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r18 = 0;	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r19 = "rowid";	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r20 = "2";	 Catch:{ SQLiteException -> 0x0248, all -> 0x0243 }
        r23 = r12;
        r12 = r0;
        r3 = r15;
        r15 = r16;
        r16 = r23;
        r15 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0241, all -> 0x0243 }
        r12 = r15.moveToFirst();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        if (r12 != 0) goto L_0x013b;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x0123:
        r0 = r4.zzge();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r0 = r0.zzim();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r5 = "Raw event metadata record is missing. appId";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r0.zzg(r5, r6);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        if (r15 == 0) goto L_0x0270;
    L_0x0136:
        r15.close();	 Catch:{ all -> 0x0afb }
        goto L_0x0270;
    L_0x013b:
        r12 = r15.getBlob(r10);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r13 = r12.length;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12 = com.google.android.gms.internal.measurement.zzabv.zza(r12, r10, r13);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r13 = new com.google.android.gms.internal.measurement.zzkq;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r13.<init>();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r13.zzb(r12);	 Catch:{ IOException -> 0x021e }
        r12 = r15.moveToNext();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        if (r12 == 0) goto L_0x0163;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x0152:
        r12 = r4.zzge();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12 = r12.zzip();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r14 = "Get multiple raw event metadata records, expected one. appId";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12.zzg(r14, r9);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x0163:
        r15.close();	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r2.zzb(r13);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r14 = 3;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        if (r9 == 0) goto L_0x0181;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x016e:
        r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12 = new java.lang.String[r14];	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12[r10] = r3;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12[r11] = r21;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r6 = 2;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12[r6] = r5;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r5 = r9;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r16 = r12;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        goto L_0x018c;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x0181:
        r5 = "app_id = ? and metadata_fingerprint = ?";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r6 = 2;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9 = new java.lang.String[r6];	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9[r10] = r3;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9[r11] = r21;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r16 = r9;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
    L_0x018c:
        r13 = "raw_events";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r6 = "rowid";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r9 = "name";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r12 = "timestamp";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r14 = "data";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r14 = new java.lang.String[]{r6, r9, r12, r14};	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r17 = 0;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r18 = 0;	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r19 = "rowid";	 Catch:{ SQLiteException -> 0x023e, all -> 0x023a }
        r20 = 0;
        r12 = r0;
        r6 = 3;
        r9 = r15;
        r15 = r5;
        r5 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ SQLiteException -> 0x0238 }
        r0 = r5.moveToFirst();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        if (r0 != 0) goto L_0x01c8;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
    L_0x01b0:
        r0 = r4.zzge();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0 = r0.zzip();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r6 = "Raw event data disappeared while in transaction. appId";	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0.zzg(r6, r9);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        if (r5 == 0) goto L_0x0270;
    L_0x01c3:
        r5.close();	 Catch:{ all -> 0x0afb }
        goto L_0x0270;
    L_0x01c8:
        r12 = r5.getLong(r10);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0 = r5.getBlob(r6);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9 = r0.length;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0 = com.google.android.gms.internal.measurement.zzabv.zza(r0, r10, r9);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9 = new com.google.android.gms.internal.measurement.zzkn;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9.<init>();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9.zzb(r0);	 Catch:{ IOException -> 0x01f7 }
        r0 = r5.getString(r11);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9.name = r0;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r14 = 2;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r6 = r5.getLong(r14);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9.zzatb = r0;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r0 = r2.zza(r12, r9);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        if (r0 != 0) goto L_0x020a;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
    L_0x01f4:
        if (r5 == 0) goto L_0x0270;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
    L_0x01f6:
        goto L_0x01c3;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
    L_0x01f7:
        r0 = move-exception;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r6 = r4.zzge();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r6 = r6.zzim();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r7 = "Data loss. Failed to merge raw event. appId";	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r9 = r0;	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        r6.zze(r7, r8, r9);	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
    L_0x020a:
        r0 = r5.moveToNext();	 Catch:{ SQLiteException -> 0x021b, all -> 0x0217 }
        if (r0 != 0) goto L_0x0213;
    L_0x0210:
        if (r5 == 0) goto L_0x0270;
    L_0x0212:
        goto L_0x01c3;
    L_0x0213:
        r6 = 3;
        r7 = -1;
        goto L_0x01c8;
    L_0x0217:
        r0 = move-exception;
        r9 = r5;
        goto L_0x0af5;
    L_0x021b:
        r0 = move-exception;
        r9 = r5;
        goto L_0x025c;
    L_0x021e:
        r0 = move-exception;
        r9 = r15;
        r5 = r4.zzge();	 Catch:{ SQLiteException -> 0x0238 }
        r5 = r5.zzim();	 Catch:{ SQLiteException -> 0x0238 }
        r6 = "Data loss. Failed to merge raw event metadata. appId";	 Catch:{ SQLiteException -> 0x0238 }
        r7 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ SQLiteException -> 0x0238 }
        r8 = r0;	 Catch:{ SQLiteException -> 0x0238 }
        r5.zze(r6, r7, r8);	 Catch:{ SQLiteException -> 0x0238 }
        if (r9 == 0) goto L_0x0270;
    L_0x0234:
        r9.close();	 Catch:{ all -> 0x0afb }
        goto L_0x0270;
    L_0x0238:
        r0 = move-exception;
        goto L_0x025c;
    L_0x023a:
        r0 = move-exception;
        r9 = r15;
        goto L_0x0af5;
    L_0x023e:
        r0 = move-exception;
        r9 = r15;
        goto L_0x025c;
    L_0x0241:
        r0 = move-exception;
        goto L_0x024a;
    L_0x0243:
        r0 = move-exception;
        r9 = r22;
        goto L_0x0af5;
    L_0x0248:
        r0 = move-exception;
        r3 = r15;
    L_0x024a:
        r9 = r22;
        goto L_0x025c;
    L_0x024d:
        r0 = move-exception;
        r9 = r12;
        goto L_0x0af5;
    L_0x0251:
        r0 = move-exception;
        r9 = r12;
        r3 = 0;
        goto L_0x025c;
    L_0x0255:
        r0 = move-exception;
        r9 = 0;
        goto L_0x0af5;
    L_0x0259:
        r0 = move-exception;
        r3 = 0;
        r9 = 0;
    L_0x025c:
        r4 = r4.zzge();	 Catch:{ all -> 0x0af4 }
        r4 = r4.zzim();	 Catch:{ all -> 0x0af4 }
        r5 = "Data loss. Error selecting raw event. appId";	 Catch:{ all -> 0x0af4 }
        r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ all -> 0x0af4 }
        r4.zze(r5, r3, r0);	 Catch:{ all -> 0x0af4 }
        if (r9 == 0) goto L_0x0270;
    L_0x026f:
        goto L_0x0234;
    L_0x0270:
        r0 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        if (r0 == 0) goto L_0x027f;	 Catch:{ all -> 0x0afb }
    L_0x0274:
        r0 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0afb }
        if (r0 == 0) goto L_0x027d;	 Catch:{ all -> 0x0afb }
    L_0x027c:
        goto L_0x027f;	 Catch:{ all -> 0x0afb }
    L_0x027d:
        r0 = r10;	 Catch:{ all -> 0x0afb }
        goto L_0x0280;	 Catch:{ all -> 0x0afb }
    L_0x027f:
        r0 = r11;	 Catch:{ all -> 0x0afb }
    L_0x0280:
        if (r0 != 0) goto L_0x0ae4;	 Catch:{ all -> 0x0afb }
    L_0x0282:
        r0 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r3 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        r3 = r3.size();	 Catch:{ all -> 0x0afb }
        r3 = new com.google.android.gms.internal.measurement.zzkn[r3];	 Catch:{ all -> 0x0afb }
        r0.zzati = r3;	 Catch:{ all -> 0x0afb }
        r3 = r50.zzgg();	 Catch:{ all -> 0x0afb }
        r4 = r0.zzti;	 Catch:{ all -> 0x0afb }
        r3 = r3.zzav(r4);	 Catch:{ all -> 0x0afb }
        r6 = r10;	 Catch:{ all -> 0x0afb }
        r7 = r6;	 Catch:{ all -> 0x0afb }
        r8 = r7;	 Catch:{ all -> 0x0afb }
        r12 = 0;	 Catch:{ all -> 0x0afb }
    L_0x029d:
        r9 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        r9 = r9.size();	 Catch:{ all -> 0x0afb }
        if (r6 >= r9) goto L_0x0582;	 Catch:{ all -> 0x0afb }
    L_0x02a5:
        r9 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        r9 = r9.get(r6);	 Catch:{ all -> 0x0afb }
        r9 = (com.google.android.gms.internal.measurement.zzkn) r9;	 Catch:{ all -> 0x0afb }
        r4 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r11 = r9.name;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzn(r5, r11);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x0321;	 Catch:{ all -> 0x0afb }
    L_0x02bd:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzip();	 Catch:{ all -> 0x0afb }
        r5 = "Dropping blacklisted raw event. appId";	 Catch:{ all -> 0x0afb }
        r11 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r11 = r11.zzti;	 Catch:{ all -> 0x0afb }
        r11 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11);	 Catch:{ all -> 0x0afb }
        r14 = r50.zzga();	 Catch:{ all -> 0x0afb }
        r15 = r9.name;	 Catch:{ all -> 0x0afb }
        r14 = r14.zzbj(r15);	 Catch:{ all -> 0x0afb }
        r4.zze(r5, r11, r14);	 Catch:{ all -> 0x0afb }
        r4 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzby(r5);	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x02fb;	 Catch:{ all -> 0x0afb }
    L_0x02ea:
        r4 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzbz(r5);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x02f9;	 Catch:{ all -> 0x0afb }
    L_0x02f8:
        goto L_0x02fb;	 Catch:{ all -> 0x0afb }
    L_0x02f9:
        r4 = r10;	 Catch:{ all -> 0x0afb }
        goto L_0x02fc;	 Catch:{ all -> 0x0afb }
    L_0x02fb:
        r4 = 1;	 Catch:{ all -> 0x0afb }
    L_0x02fc:
        if (r4 != 0) goto L_0x031d;	 Catch:{ all -> 0x0afb }
    L_0x02fe:
        r4 = "_err";	 Catch:{ all -> 0x0afb }
        r5 = r9.name;	 Catch:{ all -> 0x0afb }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x031d;	 Catch:{ all -> 0x0afb }
    L_0x0308:
        r14 = r50.zzgb();	 Catch:{ all -> 0x0afb }
        r4 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r15 = r4.zzti;	 Catch:{ all -> 0x0afb }
        r16 = 11;	 Catch:{ all -> 0x0afb }
        r17 = "_ev";	 Catch:{ all -> 0x0afb }
        r4 = r9.name;	 Catch:{ all -> 0x0afb }
        r19 = 0;	 Catch:{ all -> 0x0afb }
        r18 = r4;	 Catch:{ all -> 0x0afb }
        r14.zza(r15, r16, r17, r18, r19);	 Catch:{ all -> 0x0afb }
    L_0x031d:
        r25 = r6;	 Catch:{ all -> 0x0afb }
        goto L_0x057c;	 Catch:{ all -> 0x0afb }
    L_0x0321:
        r4 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r11 = r9.name;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzo(r5, r11);	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x0341;	 Catch:{ all -> 0x0afb }
    L_0x0331:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r5 = r9.name;	 Catch:{ all -> 0x0afb }
        r5 = com.google.android.gms.internal.measurement.zzka.zzcl(r5);	 Catch:{ all -> 0x0afb }
        if (r5 == 0) goto L_0x033d;	 Catch:{ all -> 0x0afb }
    L_0x033c:
        goto L_0x0341;	 Catch:{ all -> 0x0afb }
    L_0x033d:
        r25 = r6;	 Catch:{ all -> 0x0afb }
        goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x0341:
        r5 = r9.zzata;	 Catch:{ all -> 0x0afb }
        if (r5 != 0) goto L_0x0349;	 Catch:{ all -> 0x0afb }
    L_0x0345:
        r5 = new com.google.android.gms.internal.measurement.zzko[r10];	 Catch:{ all -> 0x0afb }
        r9.zzata = r5;	 Catch:{ all -> 0x0afb }
    L_0x0349:
        r5 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r11 = r5.length;	 Catch:{ all -> 0x0afb }
        r16 = r10;	 Catch:{ all -> 0x0afb }
        r17 = r16;	 Catch:{ all -> 0x0afb }
    L_0x0350:
        if (r10 >= r11) goto L_0x038a;	 Catch:{ all -> 0x0afb }
    L_0x0352:
        r14 = r5[r10];	 Catch:{ all -> 0x0afb }
        r15 = "_c";	 Catch:{ all -> 0x0afb }
        r24 = r5;	 Catch:{ all -> 0x0afb }
        r5 = r14.name;	 Catch:{ all -> 0x0afb }
        r5 = r15.equals(r5);	 Catch:{ all -> 0x0afb }
        if (r5 == 0) goto L_0x036d;	 Catch:{ all -> 0x0afb }
    L_0x0360:
        r25 = r6;	 Catch:{ all -> 0x0afb }
        r5 = 1;	 Catch:{ all -> 0x0afb }
        r15 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r14.zzate = r15;	 Catch:{ all -> 0x0afb }
        r16 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0383;	 Catch:{ all -> 0x0afb }
    L_0x036d:
        r25 = r6;	 Catch:{ all -> 0x0afb }
        r5 = "_r";	 Catch:{ all -> 0x0afb }
        r6 = r14.name;	 Catch:{ all -> 0x0afb }
        r5 = r5.equals(r6);	 Catch:{ all -> 0x0afb }
        if (r5 == 0) goto L_0x0383;	 Catch:{ all -> 0x0afb }
    L_0x0379:
        r5 = 1;	 Catch:{ all -> 0x0afb }
        r15 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r14.zzate = r15;	 Catch:{ all -> 0x0afb }
        r17 = 1;	 Catch:{ all -> 0x0afb }
    L_0x0383:
        r10 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r5 = r24;	 Catch:{ all -> 0x0afb }
        r6 = r25;	 Catch:{ all -> 0x0afb }
        goto L_0x0350;	 Catch:{ all -> 0x0afb }
    L_0x038a:
        r25 = r6;	 Catch:{ all -> 0x0afb }
        if (r16 != 0) goto L_0x03cc;	 Catch:{ all -> 0x0afb }
    L_0x038e:
        if (r4 == 0) goto L_0x03cc;	 Catch:{ all -> 0x0afb }
    L_0x0390:
        r5 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r5 = r5.zzit();	 Catch:{ all -> 0x0afb }
        r6 = "Marking event as conversion";	 Catch:{ all -> 0x0afb }
        r10 = r50.zzga();	 Catch:{ all -> 0x0afb }
        r11 = r9.name;	 Catch:{ all -> 0x0afb }
        r10 = r10.zzbj(r11);	 Catch:{ all -> 0x0afb }
        r5.zzg(r6, r10);	 Catch:{ all -> 0x0afb }
        r5 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        r10 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r6 + r10;	 Catch:{ all -> 0x0afb }
        r5 = java.util.Arrays.copyOf(r5, r6);	 Catch:{ all -> 0x0afb }
        r5 = (com.google.android.gms.internal.measurement.zzko[]) r5;	 Catch:{ all -> 0x0afb }
        r6 = new com.google.android.gms.internal.measurement.zzko;	 Catch:{ all -> 0x0afb }
        r6.<init>();	 Catch:{ all -> 0x0afb }
        r10 = "_c";	 Catch:{ all -> 0x0afb }
        r6.name = r10;	 Catch:{ all -> 0x0afb }
        r10 = 1;	 Catch:{ all -> 0x0afb }
        r14 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0afb }
        r6.zzate = r14;	 Catch:{ all -> 0x0afb }
        r10 = r5.length;	 Catch:{ all -> 0x0afb }
        r11 = 1;	 Catch:{ all -> 0x0afb }
        r10 = r10 - r11;	 Catch:{ all -> 0x0afb }
        r5[r10] = r6;	 Catch:{ all -> 0x0afb }
        r9.zzata = r5;	 Catch:{ all -> 0x0afb }
    L_0x03cc:
        if (r17 != 0) goto L_0x040a;	 Catch:{ all -> 0x0afb }
    L_0x03ce:
        r5 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r5 = r5.zzit();	 Catch:{ all -> 0x0afb }
        r6 = "Marking event as real-time";	 Catch:{ all -> 0x0afb }
        r10 = r50.zzga();	 Catch:{ all -> 0x0afb }
        r11 = r9.name;	 Catch:{ all -> 0x0afb }
        r10 = r10.zzbj(r11);	 Catch:{ all -> 0x0afb }
        r5.zzg(r6, r10);	 Catch:{ all -> 0x0afb }
        r5 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        r10 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r6 + r10;	 Catch:{ all -> 0x0afb }
        r5 = java.util.Arrays.copyOf(r5, r6);	 Catch:{ all -> 0x0afb }
        r5 = (com.google.android.gms.internal.measurement.zzko[]) r5;	 Catch:{ all -> 0x0afb }
        r6 = new com.google.android.gms.internal.measurement.zzko;	 Catch:{ all -> 0x0afb }
        r6.<init>();	 Catch:{ all -> 0x0afb }
        r10 = "_r";	 Catch:{ all -> 0x0afb }
        r6.name = r10;	 Catch:{ all -> 0x0afb }
        r10 = 1;	 Catch:{ all -> 0x0afb }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x0afb }
        r6.zzate = r10;	 Catch:{ all -> 0x0afb }
        r10 = r5.length;	 Catch:{ all -> 0x0afb }
        r11 = 1;	 Catch:{ all -> 0x0afb }
        r10 = r10 - r11;	 Catch:{ all -> 0x0afb }
        r5[r10] = r6;	 Catch:{ all -> 0x0afb }
        r9.zzata = r5;	 Catch:{ all -> 0x0afb }
    L_0x040a:
        r14 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r15 = r50.zzkr();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r18 = 0;	 Catch:{ all -> 0x0afb }
        r19 = 0;	 Catch:{ all -> 0x0afb }
        r20 = 0;	 Catch:{ all -> 0x0afb }
        r21 = 0;	 Catch:{ all -> 0x0afb }
        r22 = 1;	 Catch:{ all -> 0x0afb }
        r17 = r5;	 Catch:{ all -> 0x0afb }
        r5 = r14.zza(r15, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x0afb }
        r5 = r5.zzafh;	 Catch:{ all -> 0x0afb }
        r10 = r50.zzgg();	 Catch:{ all -> 0x0afb }
        r11 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r11 = r11.zzti;	 Catch:{ all -> 0x0afb }
        r10 = r10.zzar(r11);	 Catch:{ all -> 0x0afb }
        r10 = (long) r10;	 Catch:{ all -> 0x0afb }
        r14 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r14 <= 0) goto L_0x046e;	 Catch:{ all -> 0x0afb }
    L_0x0439:
        r5 = 0;	 Catch:{ all -> 0x0afb }
    L_0x043a:
        r6 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        if (r5 >= r6) goto L_0x046f;	 Catch:{ all -> 0x0afb }
    L_0x043f:
        r6 = "_r";	 Catch:{ all -> 0x0afb }
        r10 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r10 = r10[r5];	 Catch:{ all -> 0x0afb }
        r10 = r10.name;	 Catch:{ all -> 0x0afb }
        r6 = r6.equals(r10);	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x046b;	 Catch:{ all -> 0x0afb }
    L_0x044d:
        r6 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        r10 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r6 - r10;	 Catch:{ all -> 0x0afb }
        r6 = new com.google.android.gms.internal.measurement.zzko[r6];	 Catch:{ all -> 0x0afb }
        if (r5 <= 0) goto L_0x045c;	 Catch:{ all -> 0x0afb }
    L_0x0456:
        r10 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r11 = 0;	 Catch:{ all -> 0x0afb }
        java.lang.System.arraycopy(r10, r11, r6, r11, r5);	 Catch:{ all -> 0x0afb }
    L_0x045c:
        r10 = r6.length;	 Catch:{ all -> 0x0afb }
        if (r5 >= r10) goto L_0x0468;	 Catch:{ all -> 0x0afb }
    L_0x045f:
        r10 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r11 = r5 + 1;	 Catch:{ all -> 0x0afb }
        r14 = r6.length;	 Catch:{ all -> 0x0afb }
        r14 = r14 - r5;	 Catch:{ all -> 0x0afb }
        java.lang.System.arraycopy(r10, r11, r6, r5, r14);	 Catch:{ all -> 0x0afb }
    L_0x0468:
        r9.zzata = r6;	 Catch:{ all -> 0x0afb }
        goto L_0x046f;	 Catch:{ all -> 0x0afb }
    L_0x046b:
        r5 = r5 + 1;	 Catch:{ all -> 0x0afb }
        goto L_0x043a;	 Catch:{ all -> 0x0afb }
    L_0x046e:
        r7 = 1;	 Catch:{ all -> 0x0afb }
    L_0x046f:
        r5 = r9.name;	 Catch:{ all -> 0x0afb }
        r5 = com.google.android.gms.internal.measurement.zzka.zzcc(r5);	 Catch:{ all -> 0x0afb }
        if (r5 == 0) goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x0477:
        if (r4 == 0) goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x0479:
        r14 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r15 = r50.zzkr();	 Catch:{ all -> 0x0afb }
        r4 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzti;	 Catch:{ all -> 0x0afb }
        r18 = 0;	 Catch:{ all -> 0x0afb }
        r19 = 0;	 Catch:{ all -> 0x0afb }
        r20 = 1;	 Catch:{ all -> 0x0afb }
        r21 = 0;	 Catch:{ all -> 0x0afb }
        r22 = 0;	 Catch:{ all -> 0x0afb }
        r17 = r4;	 Catch:{ all -> 0x0afb }
        r4 = r14.zza(r15, r17, r18, r19, r20, r21, r22);	 Catch:{ all -> 0x0afb }
        r4 = r4.zzaff;	 Catch:{ all -> 0x0afb }
        r6 = r50.zzgg();	 Catch:{ all -> 0x0afb }
        r10 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r10 = r10.zzti;	 Catch:{ all -> 0x0afb }
        r11 = com.google.android.gms.internal.measurement.zzew.zzagv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzb(r10, r11);	 Catch:{ all -> 0x0afb }
        r10 = (long) r6;	 Catch:{ all -> 0x0afb }
        r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r6 <= 0) goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x04aa:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzip();	 Catch:{ all -> 0x0afb }
        r5 = "Too many conversions. Not logging as conversion. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
        r4.zzg(r5, r6);	 Catch:{ all -> 0x0afb }
        r4 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r5 = r4.length;	 Catch:{ all -> 0x0afb }
        r6 = 0;	 Catch:{ all -> 0x0afb }
        r10 = 0;	 Catch:{ all -> 0x0afb }
        r11 = 0;	 Catch:{ all -> 0x0afb }
    L_0x04c5:
        if (r6 >= r5) goto L_0x04e7;	 Catch:{ all -> 0x0afb }
    L_0x04c7:
        r14 = r4[r6];	 Catch:{ all -> 0x0afb }
        r15 = "_c";	 Catch:{ all -> 0x0afb }
        r26 = r4;	 Catch:{ all -> 0x0afb }
        r4 = r14.name;	 Catch:{ all -> 0x0afb }
        r4 = r15.equals(r4);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x04d7;	 Catch:{ all -> 0x0afb }
    L_0x04d5:
        r11 = r14;	 Catch:{ all -> 0x0afb }
        goto L_0x04e2;	 Catch:{ all -> 0x0afb }
    L_0x04d7:
        r4 = "_err";	 Catch:{ all -> 0x0afb }
        r14 = r14.name;	 Catch:{ all -> 0x0afb }
        r4 = r4.equals(r14);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x04e2;	 Catch:{ all -> 0x0afb }
    L_0x04e1:
        r10 = 1;	 Catch:{ all -> 0x0afb }
    L_0x04e2:
        r6 = r6 + 1;	 Catch:{ all -> 0x0afb }
        r4 = r26;	 Catch:{ all -> 0x0afb }
        goto L_0x04c5;	 Catch:{ all -> 0x0afb }
    L_0x04e7:
        if (r10 == 0) goto L_0x04fc;	 Catch:{ all -> 0x0afb }
    L_0x04e9:
        if (r11 == 0) goto L_0x04fc;	 Catch:{ all -> 0x0afb }
    L_0x04eb:
        r4 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r5 = 1;	 Catch:{ all -> 0x0afb }
        r6 = new com.google.android.gms.internal.measurement.zzko[r5];	 Catch:{ all -> 0x0afb }
        r5 = 0;	 Catch:{ all -> 0x0afb }
        r6[r5] = r11;	 Catch:{ all -> 0x0afb }
        r4 = com.google.android.gms.common.util.ArrayUtils.removeAll(r4, r6);	 Catch:{ all -> 0x0afb }
        r4 = (com.google.android.gms.internal.measurement.zzko[]) r4;	 Catch:{ all -> 0x0afb }
        r9.zzata = r4;	 Catch:{ all -> 0x0afb }
        goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x04fc:
        if (r11 == 0) goto L_0x050b;	 Catch:{ all -> 0x0afb }
    L_0x04fe:
        r4 = "_err";	 Catch:{ all -> 0x0afb }
        r11.name = r4;	 Catch:{ all -> 0x0afb }
        r4 = 10;	 Catch:{ all -> 0x0afb }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0afb }
        r11.zzate = r4;	 Catch:{ all -> 0x0afb }
        goto L_0x0520;	 Catch:{ all -> 0x0afb }
    L_0x050b:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzim();	 Catch:{ all -> 0x0afb }
        r5 = "Did not find conversion parameter. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
        r4.zzg(r5, r6);	 Catch:{ all -> 0x0afb }
    L_0x0520:
        if (r3 == 0) goto L_0x0573;	 Catch:{ all -> 0x0afb }
    L_0x0522:
        r4 = "_e";	 Catch:{ all -> 0x0afb }
        r5 = r9.name;	 Catch:{ all -> 0x0afb }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x0573;	 Catch:{ all -> 0x0afb }
    L_0x052c:
        r4 = r9.zzata;	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x0560;	 Catch:{ all -> 0x0afb }
    L_0x0530:
        r4 = r9.zzata;	 Catch:{ all -> 0x0afb }
        r4 = r4.length;	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x0536;	 Catch:{ all -> 0x0afb }
    L_0x0535:
        goto L_0x0560;	 Catch:{ all -> 0x0afb }
    L_0x0536:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r4 = "_et";	 Catch:{ all -> 0x0afb }
        r4 = com.google.android.gms.internal.measurement.zzka.zzb(r9, r4);	 Catch:{ all -> 0x0afb }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x0559;	 Catch:{ all -> 0x0afb }
    L_0x0543:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzip();	 Catch:{ all -> 0x0afb }
        r5 = "Engagement event does not include duration. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
    L_0x0555:
        r4.zzg(r5, r6);	 Catch:{ all -> 0x0afb }
        goto L_0x0573;	 Catch:{ all -> 0x0afb }
    L_0x0559:
        r4 = r4.longValue();	 Catch:{ all -> 0x0afb }
        r10 = r12 + r4;	 Catch:{ all -> 0x0afb }
        goto L_0x0574;	 Catch:{ all -> 0x0afb }
    L_0x0560:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzip();	 Catch:{ all -> 0x0afb }
        r5 = "Engagement event does not contain any parameters. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
        goto L_0x0555;	 Catch:{ all -> 0x0afb }
    L_0x0573:
        r10 = r12;	 Catch:{ all -> 0x0afb }
    L_0x0574:
        r4 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r5 = r8 + 1;	 Catch:{ all -> 0x0afb }
        r4[r8] = r9;	 Catch:{ all -> 0x0afb }
        r8 = r5;	 Catch:{ all -> 0x0afb }
        r12 = r10;	 Catch:{ all -> 0x0afb }
    L_0x057c:
        r6 = r25 + 1;	 Catch:{ all -> 0x0afb }
        r10 = 0;	 Catch:{ all -> 0x0afb }
        r11 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x029d;	 Catch:{ all -> 0x0afb }
    L_0x0582:
        r4 = r2.zzaqx;	 Catch:{ all -> 0x0afb }
        r4 = r4.size();	 Catch:{ all -> 0x0afb }
        if (r8 >= r4) goto L_0x0594;	 Catch:{ all -> 0x0afb }
    L_0x058a:
        r4 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r4 = java.util.Arrays.copyOf(r4, r8);	 Catch:{ all -> 0x0afb }
        r4 = (com.google.android.gms.internal.measurement.zzkn[]) r4;	 Catch:{ all -> 0x0afb }
        r0.zzati = r4;	 Catch:{ all -> 0x0afb }
    L_0x0594:
        if (r3 == 0) goto L_0x065b;	 Catch:{ all -> 0x0afb }
    L_0x0596:
        r3 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r4 = r0.zzti;	 Catch:{ all -> 0x0afb }
        r5 = "_lte";	 Catch:{ all -> 0x0afb }
        r3 = r3.zzh(r4, r5);	 Catch:{ all -> 0x0afb }
        if (r3 == 0) goto L_0x05cd;	 Catch:{ all -> 0x0afb }
    L_0x05a4:
        r4 = r3.value;	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x05a9;	 Catch:{ all -> 0x0afb }
    L_0x05a8:
        goto L_0x05cd;	 Catch:{ all -> 0x0afb }
    L_0x05a9:
        r4 = new com.google.android.gms.internal.measurement.zzjz;	 Catch:{ all -> 0x0afb }
        r15 = r0.zzti;	 Catch:{ all -> 0x0afb }
        r16 = "auto";	 Catch:{ all -> 0x0afb }
        r17 = "_lte";	 Catch:{ all -> 0x0afb }
        r5 = r50.zzbt();	 Catch:{ all -> 0x0afb }
        r18 = r5.currentTimeMillis();	 Catch:{ all -> 0x0afb }
        r3 = r3.value;	 Catch:{ all -> 0x0afb }
        r3 = (java.lang.Long) r3;	 Catch:{ all -> 0x0afb }
        r5 = r3.longValue();	 Catch:{ all -> 0x0afb }
        r8 = r5 + r12;	 Catch:{ all -> 0x0afb }
        r20 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x0afb }
        r14 = r4;	 Catch:{ all -> 0x0afb }
        r14.<init>(r15, r16, r17, r18, r20);	 Catch:{ all -> 0x0afb }
        r3 = r4;	 Catch:{ all -> 0x0afb }
        goto L_0x05e8;	 Catch:{ all -> 0x0afb }
    L_0x05cd:
        r3 = new com.google.android.gms.internal.measurement.zzjz;	 Catch:{ all -> 0x0afb }
        r4 = r0.zzti;	 Catch:{ all -> 0x0afb }
        r26 = "auto";	 Catch:{ all -> 0x0afb }
        r27 = "_lte";	 Catch:{ all -> 0x0afb }
        r5 = r50.zzbt();	 Catch:{ all -> 0x0afb }
        r28 = r5.currentTimeMillis();	 Catch:{ all -> 0x0afb }
        r30 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0afb }
        r24 = r3;	 Catch:{ all -> 0x0afb }
        r25 = r4;	 Catch:{ all -> 0x0afb }
        r24.<init>(r25, r26, r27, r28, r30);	 Catch:{ all -> 0x0afb }
    L_0x05e8:
        r4 = new com.google.android.gms.internal.measurement.zzks;	 Catch:{ all -> 0x0afb }
        r4.<init>();	 Catch:{ all -> 0x0afb }
        r5 = "_lte";	 Catch:{ all -> 0x0afb }
        r4.name = r5;	 Catch:{ all -> 0x0afb }
        r5 = r50.zzbt();	 Catch:{ all -> 0x0afb }
        r5 = r5.currentTimeMillis();	 Catch:{ all -> 0x0afb }
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r4.zzaun = r5;	 Catch:{ all -> 0x0afb }
        r5 = r3.value;	 Catch:{ all -> 0x0afb }
        r5 = (java.lang.Long) r5;	 Catch:{ all -> 0x0afb }
        r4.zzate = r5;	 Catch:{ all -> 0x0afb }
        r5 = 0;	 Catch:{ all -> 0x0afb }
    L_0x0606:
        r6 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        if (r5 >= r6) goto L_0x0622;	 Catch:{ all -> 0x0afb }
    L_0x060b:
        r6 = "_lte";	 Catch:{ all -> 0x0afb }
        r8 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r8 = r8[r5];	 Catch:{ all -> 0x0afb }
        r8 = r8.name;	 Catch:{ all -> 0x0afb }
        r6 = r6.equals(r8);	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x061f;	 Catch:{ all -> 0x0afb }
    L_0x0619:
        r6 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r6[r5] = r4;	 Catch:{ all -> 0x0afb }
        r5 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0623;	 Catch:{ all -> 0x0afb }
    L_0x061f:
        r5 = r5 + 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0606;	 Catch:{ all -> 0x0afb }
    L_0x0622:
        r5 = 0;	 Catch:{ all -> 0x0afb }
    L_0x0623:
        if (r5 != 0) goto L_0x063f;	 Catch:{ all -> 0x0afb }
    L_0x0625:
        r5 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r6 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        r8 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r6 + r8;	 Catch:{ all -> 0x0afb }
        r5 = java.util.Arrays.copyOf(r5, r6);	 Catch:{ all -> 0x0afb }
        r5 = (com.google.android.gms.internal.measurement.zzks[]) r5;	 Catch:{ all -> 0x0afb }
        r0.zzatj = r5;	 Catch:{ all -> 0x0afb }
        r5 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzatj;	 Catch:{ all -> 0x0afb }
        r6 = r6.length;	 Catch:{ all -> 0x0afb }
        r8 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r6 - r8;	 Catch:{ all -> 0x0afb }
        r5[r6] = r4;	 Catch:{ all -> 0x0afb }
    L_0x063f:
        r4 = 0;	 Catch:{ all -> 0x0afb }
        r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r6 <= 0) goto L_0x065b;	 Catch:{ all -> 0x0afb }
    L_0x0645:
        r4 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r4.zza(r3);	 Catch:{ all -> 0x0afb }
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzis();	 Catch:{ all -> 0x0afb }
        r5 = "Updated lifetime engagement user property with value. Value";	 Catch:{ all -> 0x0afb }
        r3 = r3.value;	 Catch:{ all -> 0x0afb }
        r4.zzg(r5, r3);	 Catch:{ all -> 0x0afb }
    L_0x065b:
        r3 = r0.zzti;	 Catch:{ all -> 0x0afb }
        r4 = r0.zzatj;	 Catch:{ all -> 0x0afb }
        r5 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r3 = r1.zza(r3, r4, r5);	 Catch:{ all -> 0x0afb }
        r0.zzaua = r3;	 Catch:{ all -> 0x0afb }
        r3 = r50.zzgg();	 Catch:{ all -> 0x0afb }
        r4 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzti;	 Catch:{ all -> 0x0afb }
        r3 = r3.zzau(r4);	 Catch:{ all -> 0x0afb }
        if (r3 == 0) goto L_0x092e;	 Catch:{ all -> 0x0afb }
    L_0x0675:
        r3 = new java.util.HashMap;	 Catch:{ all -> 0x0afb }
        r3.<init>();	 Catch:{ all -> 0x0afb }
        r4 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r4 = r4.length;	 Catch:{ all -> 0x0afb }
        r4 = new com.google.android.gms.internal.measurement.zzkn[r4];	 Catch:{ all -> 0x0afb }
        r5 = r50.zzgb();	 Catch:{ all -> 0x0afb }
        r5 = r5.zzlc();	 Catch:{ all -> 0x0afb }
        r6 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r8 = r6.length;	 Catch:{ all -> 0x0afb }
        r9 = 0;	 Catch:{ all -> 0x0afb }
        r10 = 0;	 Catch:{ all -> 0x0afb }
    L_0x068c:
        if (r9 >= r8) goto L_0x08fc;	 Catch:{ all -> 0x0afb }
    L_0x068e:
        r11 = r6[r9];	 Catch:{ all -> 0x0afb }
        r12 = r11.name;	 Catch:{ all -> 0x0afb }
        r13 = "_ep";	 Catch:{ all -> 0x0afb }
        r12 = r12.equals(r13);	 Catch:{ all -> 0x0afb }
        if (r12 == 0) goto L_0x0717;	 Catch:{ all -> 0x0afb }
    L_0x069a:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r12 = "_en";	 Catch:{ all -> 0x0afb }
        r12 = com.google.android.gms.internal.measurement.zzka.zzb(r11, r12);	 Catch:{ all -> 0x0afb }
        r12 = (java.lang.String) r12;	 Catch:{ all -> 0x0afb }
        r13 = r3.get(r12);	 Catch:{ all -> 0x0afb }
        r13 = (com.google.android.gms.internal.measurement.zzeq) r13;	 Catch:{ all -> 0x0afb }
        if (r13 != 0) goto L_0x06bc;	 Catch:{ all -> 0x0afb }
    L_0x06ad:
        r13 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r14 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r14 = r14.zzti;	 Catch:{ all -> 0x0afb }
        r13 = r13.zzf(r14, r12);	 Catch:{ all -> 0x0afb }
        r3.put(r12, r13);	 Catch:{ all -> 0x0afb }
    L_0x06bc:
        r12 = r13.zzafv;	 Catch:{ all -> 0x0afb }
        if (r12 != 0) goto L_0x070c;	 Catch:{ all -> 0x0afb }
    L_0x06c0:
        r12 = r13.zzafw;	 Catch:{ all -> 0x0afb }
        r14 = r12.longValue();	 Catch:{ all -> 0x0afb }
        r16 = 1;	 Catch:{ all -> 0x0afb }
        r12 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r12 <= 0) goto L_0x06db;	 Catch:{ all -> 0x0afb }
    L_0x06cc:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r12 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r14 = "_sr";	 Catch:{ all -> 0x0afb }
        r15 = r13.zzafw;	 Catch:{ all -> 0x0afb }
        r12 = com.google.android.gms.internal.measurement.zzka.zza(r12, r14, r15);	 Catch:{ all -> 0x0afb }
        r11.zzata = r12;	 Catch:{ all -> 0x0afb }
    L_0x06db:
        r12 = r13.zzafx;	 Catch:{ all -> 0x0afb }
        if (r12 == 0) goto L_0x06fd;	 Catch:{ all -> 0x0afb }
    L_0x06df:
        r12 = r13.zzafx;	 Catch:{ all -> 0x0afb }
        r12 = r12.booleanValue();	 Catch:{ all -> 0x0afb }
        if (r12 == 0) goto L_0x06fd;	 Catch:{ all -> 0x0afb }
    L_0x06e7:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r12 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r13 = "_efs";	 Catch:{ all -> 0x0afb }
        r31 = r6;	 Catch:{ all -> 0x0afb }
        r14 = 1;	 Catch:{ all -> 0x0afb }
        r6 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzka.zza(r12, r13, r6);	 Catch:{ all -> 0x0afb }
        r11.zzata = r6;	 Catch:{ all -> 0x0afb }
        goto L_0x06ff;	 Catch:{ all -> 0x0afb }
    L_0x06fd:
        r31 = r6;	 Catch:{ all -> 0x0afb }
    L_0x06ff:
        r6 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r4[r10] = r11;	 Catch:{ all -> 0x0afb }
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r47 = r5;	 Catch:{ all -> 0x0afb }
        r10 = r6;	 Catch:{ all -> 0x0afb }
        r32 = r8;	 Catch:{ all -> 0x0afb }
        goto L_0x079e;	 Catch:{ all -> 0x0afb }
    L_0x070c:
        r31 = r6;	 Catch:{ all -> 0x0afb }
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r6 = r3;	 Catch:{ all -> 0x0afb }
        r47 = r5;	 Catch:{ all -> 0x0afb }
        r32 = r8;	 Catch:{ all -> 0x0afb }
        goto L_0x086c;	 Catch:{ all -> 0x0afb }
    L_0x0717:
        r31 = r6;	 Catch:{ all -> 0x0afb }
        r6 = "_dbg";	 Catch:{ all -> 0x0afb }
        r12 = 1;	 Catch:{ all -> 0x0afb }
        r14 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0afb }
        r12 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0afb }
        if (r12 != 0) goto L_0x076b;	 Catch:{ all -> 0x0afb }
    L_0x0727:
        if (r14 != 0) goto L_0x072a;	 Catch:{ all -> 0x0afb }
    L_0x0729:
        goto L_0x076b;	 Catch:{ all -> 0x0afb }
    L_0x072a:
        r12 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r13 = r12.length;	 Catch:{ all -> 0x0afb }
        r15 = 0;	 Catch:{ all -> 0x0afb }
    L_0x072e:
        if (r15 >= r13) goto L_0x076b;	 Catch:{ all -> 0x0afb }
    L_0x0730:
        r32 = r8;	 Catch:{ all -> 0x0afb }
        r8 = r12[r15];	 Catch:{ all -> 0x0afb }
        r33 = r12;	 Catch:{ all -> 0x0afb }
        r12 = r8.name;	 Catch:{ all -> 0x0afb }
        r12 = r6.equals(r12);	 Catch:{ all -> 0x0afb }
        if (r12 == 0) goto L_0x0764;	 Catch:{ all -> 0x0afb }
    L_0x073e:
        r6 = r14 instanceof java.lang.Long;	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x074a;	 Catch:{ all -> 0x0afb }
    L_0x0742:
        r6 = r8.zzate;	 Catch:{ all -> 0x0afb }
        r6 = r14.equals(r6);	 Catch:{ all -> 0x0afb }
        if (r6 != 0) goto L_0x0762;	 Catch:{ all -> 0x0afb }
    L_0x074a:
        r6 = r14 instanceof java.lang.String;	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x0756;	 Catch:{ all -> 0x0afb }
    L_0x074e:
        r6 = r8.zzajf;	 Catch:{ all -> 0x0afb }
        r6 = r14.equals(r6);	 Catch:{ all -> 0x0afb }
        if (r6 != 0) goto L_0x0762;	 Catch:{ all -> 0x0afb }
    L_0x0756:
        r6 = r14 instanceof java.lang.Double;	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x076d;	 Catch:{ all -> 0x0afb }
    L_0x075a:
        r6 = r8.zzarc;	 Catch:{ all -> 0x0afb }
        r6 = r14.equals(r6);	 Catch:{ all -> 0x0afb }
        if (r6 == 0) goto L_0x076d;	 Catch:{ all -> 0x0afb }
    L_0x0762:
        r6 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x076e;	 Catch:{ all -> 0x0afb }
    L_0x0764:
        r15 = r15 + 1;	 Catch:{ all -> 0x0afb }
        r8 = r32;	 Catch:{ all -> 0x0afb }
        r12 = r33;	 Catch:{ all -> 0x0afb }
        goto L_0x072e;	 Catch:{ all -> 0x0afb }
    L_0x076b:
        r32 = r8;	 Catch:{ all -> 0x0afb }
    L_0x076d:
        r6 = 0;	 Catch:{ all -> 0x0afb }
    L_0x076e:
        if (r6 != 0) goto L_0x077f;	 Catch:{ all -> 0x0afb }
    L_0x0770:
        r6 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r8 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r8 = r8.zzti;	 Catch:{ all -> 0x0afb }
        r12 = r11.name;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzp(r8, r12);	 Catch:{ all -> 0x0afb }
        goto L_0x0780;	 Catch:{ all -> 0x0afb }
    L_0x077f:
        r6 = 1;	 Catch:{ all -> 0x0afb }
    L_0x0780:
        if (r6 > 0) goto L_0x07a3;	 Catch:{ all -> 0x0afb }
    L_0x0782:
        r8 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r8 = r8.zzip();	 Catch:{ all -> 0x0afb }
        r12 = "Sample rate must be positive. event, rate";	 Catch:{ all -> 0x0afb }
        r13 = r11.name;	 Catch:{ all -> 0x0afb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x0afb }
        r8.zze(r12, r13, r6);	 Catch:{ all -> 0x0afb }
        r6 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r4[r10] = r11;	 Catch:{ all -> 0x0afb }
    L_0x0799:
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r47 = r5;	 Catch:{ all -> 0x0afb }
        r10 = r6;	 Catch:{ all -> 0x0afb }
    L_0x079e:
        r14 = 1;	 Catch:{ all -> 0x0afb }
        r6 = r3;	 Catch:{ all -> 0x0afb }
        goto L_0x08ef;	 Catch:{ all -> 0x0afb }
    L_0x07a3:
        r8 = r11.name;	 Catch:{ all -> 0x0afb }
        r8 = r3.get(r8);	 Catch:{ all -> 0x0afb }
        r8 = (com.google.android.gms.internal.measurement.zzeq) r8;	 Catch:{ all -> 0x0afb }
        if (r8 != 0) goto L_0x07f3;	 Catch:{ all -> 0x0afb }
    L_0x07ad:
        r8 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r12 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r12 = r12.zzti;	 Catch:{ all -> 0x0afb }
        r13 = r11.name;	 Catch:{ all -> 0x0afb }
        r8 = r8.zzf(r12, r13);	 Catch:{ all -> 0x0afb }
        if (r8 != 0) goto L_0x07f3;	 Catch:{ all -> 0x0afb }
    L_0x07bd:
        r8 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r8 = r8.zzip();	 Catch:{ all -> 0x0afb }
        r12 = "Event being bundled has no eventAggregate. appId, eventName";	 Catch:{ all -> 0x0afb }
        r13 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r13 = r13.zzti;	 Catch:{ all -> 0x0afb }
        r14 = r11.name;	 Catch:{ all -> 0x0afb }
        r8.zze(r12, r13, r14);	 Catch:{ all -> 0x0afb }
        r8 = new com.google.android.gms.internal.measurement.zzeq;	 Catch:{ all -> 0x0afb }
        r12 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r12 = r12.zzti;	 Catch:{ all -> 0x0afb }
        r13 = r11.name;	 Catch:{ all -> 0x0afb }
        r36 = 1;	 Catch:{ all -> 0x0afb }
        r38 = 1;	 Catch:{ all -> 0x0afb }
        r14 = r11.zzatb;	 Catch:{ all -> 0x0afb }
        r40 = r14.longValue();	 Catch:{ all -> 0x0afb }
        r42 = 0;	 Catch:{ all -> 0x0afb }
        r44 = 0;	 Catch:{ all -> 0x0afb }
        r45 = 0;	 Catch:{ all -> 0x0afb }
        r46 = 0;	 Catch:{ all -> 0x0afb }
        r33 = r8;	 Catch:{ all -> 0x0afb }
        r34 = r12;	 Catch:{ all -> 0x0afb }
        r35 = r13;	 Catch:{ all -> 0x0afb }
        r33.<init>(r34, r35, r36, r38, r40, r42, r44, r45, r46);	 Catch:{ all -> 0x0afb }
    L_0x07f3:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r12 = "_eid";	 Catch:{ all -> 0x0afb }
        r12 = com.google.android.gms.internal.measurement.zzka.zzb(r11, r12);	 Catch:{ all -> 0x0afb }
        r12 = (java.lang.Long) r12;	 Catch:{ all -> 0x0afb }
        if (r12 == 0) goto L_0x0802;	 Catch:{ all -> 0x0afb }
    L_0x0800:
        r13 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0803;	 Catch:{ all -> 0x0afb }
    L_0x0802:
        r13 = 0;	 Catch:{ all -> 0x0afb }
    L_0x0803:
        r13 = java.lang.Boolean.valueOf(r13);	 Catch:{ all -> 0x0afb }
        r14 = 1;	 Catch:{ all -> 0x0afb }
        if (r6 != r14) goto L_0x082c;	 Catch:{ all -> 0x0afb }
    L_0x080a:
        r6 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r4[r10] = r11;	 Catch:{ all -> 0x0afb }
        r10 = r13.booleanValue();	 Catch:{ all -> 0x0afb }
        if (r10 == 0) goto L_0x0799;	 Catch:{ all -> 0x0afb }
    L_0x0814:
        r10 = r8.zzafv;	 Catch:{ all -> 0x0afb }
        if (r10 != 0) goto L_0x0820;	 Catch:{ all -> 0x0afb }
    L_0x0818:
        r10 = r8.zzafw;	 Catch:{ all -> 0x0afb }
        if (r10 != 0) goto L_0x0820;	 Catch:{ all -> 0x0afb }
    L_0x081c:
        r10 = r8.zzafx;	 Catch:{ all -> 0x0afb }
        if (r10 == 0) goto L_0x0799;	 Catch:{ all -> 0x0afb }
    L_0x0820:
        r10 = 0;	 Catch:{ all -> 0x0afb }
        r8 = r8.zza(r10, r10, r10);	 Catch:{ all -> 0x0afb }
        r10 = r11.name;	 Catch:{ all -> 0x0afb }
        r3.put(r10, r8);	 Catch:{ all -> 0x0afb }
        goto L_0x0799;	 Catch:{ all -> 0x0afb }
    L_0x082c:
        r14 = r5.nextInt(r6);	 Catch:{ all -> 0x0afb }
        if (r14 != 0) goto L_0x0870;	 Catch:{ all -> 0x0afb }
    L_0x0832:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r12 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r14 = "_sr";	 Catch:{ all -> 0x0afb }
        r47 = r5;	 Catch:{ all -> 0x0afb }
        r5 = (long) r6;	 Catch:{ all -> 0x0afb }
        r15 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r12 = com.google.android.gms.internal.measurement.zzka.zza(r12, r14, r15);	 Catch:{ all -> 0x0afb }
        r11.zzata = r12;	 Catch:{ all -> 0x0afb }
        r12 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r4[r10] = r11;	 Catch:{ all -> 0x0afb }
        r10 = r13.booleanValue();	 Catch:{ all -> 0x0afb }
        if (r10 == 0) goto L_0x0859;	 Catch:{ all -> 0x0afb }
    L_0x0850:
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r6 = 0;	 Catch:{ all -> 0x0afb }
        r8 = r8.zza(r6, r5, r6);	 Catch:{ all -> 0x0afb }
    L_0x0859:
        r5 = r11.name;	 Catch:{ all -> 0x0afb }
        r6 = r11.zzatb;	 Catch:{ all -> 0x0afb }
        r10 = r6.longValue();	 Catch:{ all -> 0x0afb }
        r6 = r8.zzad(r10);	 Catch:{ all -> 0x0afb }
        r3.put(r5, r6);	 Catch:{ all -> 0x0afb }
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r6 = r3;	 Catch:{ all -> 0x0afb }
        r10 = r12;	 Catch:{ all -> 0x0afb }
    L_0x086c:
        r14 = 1;	 Catch:{ all -> 0x0afb }
        goto L_0x08ef;	 Catch:{ all -> 0x0afb }
    L_0x0870:
        r47 = r5;	 Catch:{ all -> 0x0afb }
        r14 = r8.zzafu;	 Catch:{ all -> 0x0afb }
        r5 = r11.zzatb;	 Catch:{ all -> 0x0afb }
        r16 = r5.longValue();	 Catch:{ all -> 0x0afb }
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r49 = r3;	 Catch:{ all -> 0x0afb }
        r2 = r16 - r14;	 Catch:{ all -> 0x0afb }
        r2 = java.lang.Math.abs(r2);	 Catch:{ all -> 0x0afb }
        r14 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ all -> 0x0afb }
        r5 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r5 < 0) goto L_0x08db;	 Catch:{ all -> 0x0afb }
    L_0x088b:
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r2 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r3 = "_efs";	 Catch:{ all -> 0x0afb }
        r14 = 1;	 Catch:{ all -> 0x0afb }
        r5 = java.lang.Long.valueOf(r14);	 Catch:{ all -> 0x0afb }
        r2 = com.google.android.gms.internal.measurement.zzka.zza(r2, r3, r5);	 Catch:{ all -> 0x0afb }
        r11.zzata = r2;	 Catch:{ all -> 0x0afb }
        r50.zzgb();	 Catch:{ all -> 0x0afb }
        r2 = r11.zzata;	 Catch:{ all -> 0x0afb }
        r3 = "_sr";	 Catch:{ all -> 0x0afb }
        r5 = (long) r6;	 Catch:{ all -> 0x0afb }
        r12 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r2 = com.google.android.gms.internal.measurement.zzka.zza(r2, r3, r12);	 Catch:{ all -> 0x0afb }
        r11.zzata = r2;	 Catch:{ all -> 0x0afb }
        r2 = r10 + 1;	 Catch:{ all -> 0x0afb }
        r4[r10] = r11;	 Catch:{ all -> 0x0afb }
        r3 = r13.booleanValue();	 Catch:{ all -> 0x0afb }
        if (r3 == 0) goto L_0x08c8;	 Catch:{ all -> 0x0afb }
    L_0x08ba:
        r3 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r5 = 1;	 Catch:{ all -> 0x0afb }
        r6 = java.lang.Boolean.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r5 = 0;	 Catch:{ all -> 0x0afb }
        r8 = r8.zza(r5, r3, r6);	 Catch:{ all -> 0x0afb }
    L_0x08c8:
        r3 = r11.name;	 Catch:{ all -> 0x0afb }
        r5 = r11.zzatb;	 Catch:{ all -> 0x0afb }
        r5 = r5.longValue();	 Catch:{ all -> 0x0afb }
        r5 = r8.zzad(r5);	 Catch:{ all -> 0x0afb }
        r6 = r49;	 Catch:{ all -> 0x0afb }
        r6.put(r3, r5);	 Catch:{ all -> 0x0afb }
        r10 = r2;	 Catch:{ all -> 0x0afb }
        goto L_0x08ef;	 Catch:{ all -> 0x0afb }
    L_0x08db:
        r6 = r49;	 Catch:{ all -> 0x0afb }
        r14 = 1;	 Catch:{ all -> 0x0afb }
        r2 = r13.booleanValue();	 Catch:{ all -> 0x0afb }
        if (r2 == 0) goto L_0x08ef;	 Catch:{ all -> 0x0afb }
    L_0x08e5:
        r2 = r11.name;	 Catch:{ all -> 0x0afb }
        r3 = 0;	 Catch:{ all -> 0x0afb }
        r5 = r8.zza(r12, r3, r3);	 Catch:{ all -> 0x0afb }
        r6.put(r2, r5);	 Catch:{ all -> 0x0afb }
    L_0x08ef:
        r9 = r9 + 1;	 Catch:{ all -> 0x0afb }
        r3 = r6;	 Catch:{ all -> 0x0afb }
        r6 = r31;	 Catch:{ all -> 0x0afb }
        r8 = r32;	 Catch:{ all -> 0x0afb }
        r5 = r47;	 Catch:{ all -> 0x0afb }
        r2 = r48;	 Catch:{ all -> 0x0afb }
        goto L_0x068c;	 Catch:{ all -> 0x0afb }
    L_0x08fc:
        r48 = r2;	 Catch:{ all -> 0x0afb }
        r6 = r3;	 Catch:{ all -> 0x0afb }
        r2 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r2 = r2.length;	 Catch:{ all -> 0x0afb }
        if (r10 >= r2) goto L_0x090c;	 Catch:{ all -> 0x0afb }
    L_0x0904:
        r2 = java.util.Arrays.copyOf(r4, r10);	 Catch:{ all -> 0x0afb }
        r2 = (com.google.android.gms.internal.measurement.zzkn[]) r2;	 Catch:{ all -> 0x0afb }
        r0.zzati = r2;	 Catch:{ all -> 0x0afb }
    L_0x090c:
        r2 = r6.entrySet();	 Catch:{ all -> 0x0afb }
        r2 = r2.iterator();	 Catch:{ all -> 0x0afb }
    L_0x0914:
        r3 = r2.hasNext();	 Catch:{ all -> 0x0afb }
        if (r3 == 0) goto L_0x0930;	 Catch:{ all -> 0x0afb }
    L_0x091a:
        r3 = r2.next();	 Catch:{ all -> 0x0afb }
        r3 = (java.util.Map.Entry) r3;	 Catch:{ all -> 0x0afb }
        r4 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r3 = r3.getValue();	 Catch:{ all -> 0x0afb }
        r3 = (com.google.android.gms.internal.measurement.zzeq) r3;	 Catch:{ all -> 0x0afb }
        r4.zza(r3);	 Catch:{ all -> 0x0afb }
        goto L_0x0914;	 Catch:{ all -> 0x0afb }
    L_0x092e:
        r48 = r2;	 Catch:{ all -> 0x0afb }
    L_0x0930:
        r2 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;	 Catch:{ all -> 0x0afb }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0afb }
        r0.zzatl = r2;	 Catch:{ all -> 0x0afb }
        r2 = -9223372036854775808;	 Catch:{ all -> 0x0afb }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0afb }
        r0.zzatm = r2;	 Catch:{ all -> 0x0afb }
        r2 = 0;	 Catch:{ all -> 0x0afb }
    L_0x0944:
        r3 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r3 = r3.length;	 Catch:{ all -> 0x0afb }
        if (r2 >= r3) goto L_0x0978;	 Catch:{ all -> 0x0afb }
    L_0x0949:
        r3 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r3 = r3[r2];	 Catch:{ all -> 0x0afb }
        r4 = r3.zzatb;	 Catch:{ all -> 0x0afb }
        r4 = r4.longValue();	 Catch:{ all -> 0x0afb }
        r6 = r0.zzatl;	 Catch:{ all -> 0x0afb }
        r8 = r6.longValue();	 Catch:{ all -> 0x0afb }
        r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r6 >= 0) goto L_0x0961;	 Catch:{ all -> 0x0afb }
    L_0x095d:
        r4 = r3.zzatb;	 Catch:{ all -> 0x0afb }
        r0.zzatl = r4;	 Catch:{ all -> 0x0afb }
    L_0x0961:
        r4 = r3.zzatb;	 Catch:{ all -> 0x0afb }
        r4 = r4.longValue();	 Catch:{ all -> 0x0afb }
        r6 = r0.zzatm;	 Catch:{ all -> 0x0afb }
        r8 = r6.longValue();	 Catch:{ all -> 0x0afb }
        r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r6 <= 0) goto L_0x0975;	 Catch:{ all -> 0x0afb }
    L_0x0971:
        r3 = r3.zzatb;	 Catch:{ all -> 0x0afb }
        r0.zzatm = r3;	 Catch:{ all -> 0x0afb }
    L_0x0975:
        r2 = r2 + 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0944;	 Catch:{ all -> 0x0afb }
    L_0x0978:
        r2 = r48;	 Catch:{ all -> 0x0afb }
        r3 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r3 = r3.zzti;	 Catch:{ all -> 0x0afb }
        r4 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzbc(r3);	 Catch:{ all -> 0x0afb }
        if (r4 != 0) goto L_0x099e;	 Catch:{ all -> 0x0afb }
    L_0x0988:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzim();	 Catch:{ all -> 0x0afb }
        r5 = "Bundling raw events w/o app info. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
        r4.zzg(r5, r6);	 Catch:{ all -> 0x0afb }
        goto L_0x09fa;	 Catch:{ all -> 0x0afb }
    L_0x099e:
        r5 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r5 = r5.length;	 Catch:{ all -> 0x0afb }
        if (r5 <= 0) goto L_0x09fa;	 Catch:{ all -> 0x0afb }
    L_0x09a3:
        r5 = r4.zzgl();	 Catch:{ all -> 0x0afb }
        r8 = 0;	 Catch:{ all -> 0x0afb }
        r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r10 == 0) goto L_0x09b2;	 Catch:{ all -> 0x0afb }
    L_0x09ad:
        r8 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        goto L_0x09b3;	 Catch:{ all -> 0x0afb }
    L_0x09b2:
        r8 = 0;	 Catch:{ all -> 0x0afb }
    L_0x09b3:
        r0.zzato = r8;	 Catch:{ all -> 0x0afb }
        r8 = r4.zzgk();	 Catch:{ all -> 0x0afb }
        r10 = 0;	 Catch:{ all -> 0x0afb }
        r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r12 != 0) goto L_0x09c0;	 Catch:{ all -> 0x0afb }
    L_0x09bf:
        goto L_0x09c1;	 Catch:{ all -> 0x0afb }
    L_0x09c0:
        r5 = r8;	 Catch:{ all -> 0x0afb }
    L_0x09c1:
        r8 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1));	 Catch:{ all -> 0x0afb }
        if (r8 == 0) goto L_0x09ca;	 Catch:{ all -> 0x0afb }
    L_0x09c5:
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ all -> 0x0afb }
        goto L_0x09cb;	 Catch:{ all -> 0x0afb }
    L_0x09ca:
        r5 = 0;	 Catch:{ all -> 0x0afb }
    L_0x09cb:
        r0.zzatn = r5;	 Catch:{ all -> 0x0afb }
        r4.zzgt();	 Catch:{ all -> 0x0afb }
        r5 = r4.zzgq();	 Catch:{ all -> 0x0afb }
        r5 = (int) r5;	 Catch:{ all -> 0x0afb }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0afb }
        r0.zzaty = r5;	 Catch:{ all -> 0x0afb }
        r5 = r0.zzatl;	 Catch:{ all -> 0x0afb }
        r5 = r5.longValue();	 Catch:{ all -> 0x0afb }
        r4.zzm(r5);	 Catch:{ all -> 0x0afb }
        r5 = r0.zzatm;	 Catch:{ all -> 0x0afb }
        r5 = r5.longValue();	 Catch:{ all -> 0x0afb }
        r4.zzn(r5);	 Catch:{ all -> 0x0afb }
        r5 = r4.zzhb();	 Catch:{ all -> 0x0afb }
        r0.zzaek = r5;	 Catch:{ all -> 0x0afb }
        r5 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r5.zza(r4);	 Catch:{ all -> 0x0afb }
    L_0x09fa:
        r4 = r0.zzati;	 Catch:{ all -> 0x0afb }
        r4 = r4.length;	 Catch:{ all -> 0x0afb }
        if (r4 <= 0) goto L_0x0a44;	 Catch:{ all -> 0x0afb }
    L_0x09ff:
        r4 = r50.zzkm();	 Catch:{ all -> 0x0afb }
        r5 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r5 = r5.zzti;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzbu(r5);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x0a17;	 Catch:{ all -> 0x0afb }
    L_0x0a0d:
        r5 = r4.zzasp;	 Catch:{ all -> 0x0afb }
        if (r5 != 0) goto L_0x0a12;	 Catch:{ all -> 0x0afb }
    L_0x0a11:
        goto L_0x0a17;	 Catch:{ all -> 0x0afb }
    L_0x0a12:
        r4 = r4.zzasp;	 Catch:{ all -> 0x0afb }
    L_0x0a14:
        r0.zzauf = r4;	 Catch:{ all -> 0x0afb }
        goto L_0x0a3d;	 Catch:{ all -> 0x0afb }
    L_0x0a17:
        r4 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r4 = r4.zzadm;	 Catch:{ all -> 0x0afb }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0afb }
        if (r4 == 0) goto L_0x0a28;	 Catch:{ all -> 0x0afb }
    L_0x0a21:
        r4 = -1;	 Catch:{ all -> 0x0afb }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0afb }
        goto L_0x0a14;	 Catch:{ all -> 0x0afb }
    L_0x0a28:
        r4 = r50.zzge();	 Catch:{ all -> 0x0afb }
        r4 = r4.zzip();	 Catch:{ all -> 0x0afb }
        r5 = "Did not find measurement config or missing version info. appId";	 Catch:{ all -> 0x0afb }
        r6 = r2.zzaqv;	 Catch:{ all -> 0x0afb }
        r6 = r6.zzti;	 Catch:{ all -> 0x0afb }
        r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6);	 Catch:{ all -> 0x0afb }
        r4.zzg(r5, r6);	 Catch:{ all -> 0x0afb }
    L_0x0a3d:
        r4 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r4.zza(r0, r7);	 Catch:{ all -> 0x0afb }
    L_0x0a44:
        r0 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r2 = r2.zzaqw;	 Catch:{ all -> 0x0afb }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r2);	 Catch:{ all -> 0x0afb }
        r0.zzab();	 Catch:{ all -> 0x0afb }
        r0.zzch();	 Catch:{ all -> 0x0afb }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0afb }
        r5 = "rowid in (";	 Catch:{ all -> 0x0afb }
        r4.<init>(r5);	 Catch:{ all -> 0x0afb }
        r5 = 0;	 Catch:{ all -> 0x0afb }
    L_0x0a5b:
        r6 = r2.size();	 Catch:{ all -> 0x0afb }
        if (r5 >= r6) goto L_0x0a78;	 Catch:{ all -> 0x0afb }
    L_0x0a61:
        if (r5 == 0) goto L_0x0a68;	 Catch:{ all -> 0x0afb }
    L_0x0a63:
        r6 = ",";	 Catch:{ all -> 0x0afb }
        r4.append(r6);	 Catch:{ all -> 0x0afb }
    L_0x0a68:
        r6 = r2.get(r5);	 Catch:{ all -> 0x0afb }
        r6 = (java.lang.Long) r6;	 Catch:{ all -> 0x0afb }
        r6 = r6.longValue();	 Catch:{ all -> 0x0afb }
        r4.append(r6);	 Catch:{ all -> 0x0afb }
        r5 = r5 + 1;	 Catch:{ all -> 0x0afb }
        goto L_0x0a5b;	 Catch:{ all -> 0x0afb }
    L_0x0a78:
        r5 = ")";	 Catch:{ all -> 0x0afb }
        r4.append(r5);	 Catch:{ all -> 0x0afb }
        r5 = r0.getWritableDatabase();	 Catch:{ all -> 0x0afb }
        r6 = "raw_events";	 Catch:{ all -> 0x0afb }
        r4 = r4.toString();	 Catch:{ all -> 0x0afb }
        r7 = 0;	 Catch:{ all -> 0x0afb }
        r4 = r5.delete(r6, r4, r7);	 Catch:{ all -> 0x0afb }
        r5 = r2.size();	 Catch:{ all -> 0x0afb }
        if (r4 == r5) goto L_0x0aab;	 Catch:{ all -> 0x0afb }
    L_0x0a92:
        r0 = r0.zzge();	 Catch:{ all -> 0x0afb }
        r0 = r0.zzim();	 Catch:{ all -> 0x0afb }
        r5 = "Deleted fewer rows from raw events table than expected";	 Catch:{ all -> 0x0afb }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x0afb }
        r2 = r2.size();	 Catch:{ all -> 0x0afb }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0afb }
        r0.zze(r5, r4, r2);	 Catch:{ all -> 0x0afb }
    L_0x0aab:
        r2 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r0 = r2.getWritableDatabase();	 Catch:{ all -> 0x0afb }
        r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)";	 Catch:{ SQLiteException -> 0x0ac2 }
        r5 = 2;	 Catch:{ SQLiteException -> 0x0ac2 }
        r5 = new java.lang.String[r5];	 Catch:{ SQLiteException -> 0x0ac2 }
        r6 = 0;	 Catch:{ SQLiteException -> 0x0ac2 }
        r5[r6] = r3;	 Catch:{ SQLiteException -> 0x0ac2 }
        r6 = 1;	 Catch:{ SQLiteException -> 0x0ac2 }
        r5[r6] = r3;	 Catch:{ SQLiteException -> 0x0ac2 }
        r0.execSQL(r4, r5);	 Catch:{ SQLiteException -> 0x0ac2 }
        goto L_0x0ad4;
    L_0x0ac2:
        r0 = move-exception;
        r2 = r2.zzge();	 Catch:{ all -> 0x0afb }
        r2 = r2.zzim();	 Catch:{ all -> 0x0afb }
        r4 = "Failed to remove unused event metadata. appId";	 Catch:{ all -> 0x0afb }
        r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r3);	 Catch:{ all -> 0x0afb }
        r2.zze(r4, r3, r0);	 Catch:{ all -> 0x0afb }
    L_0x0ad4:
        r0 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0afb }
        r0 = r50.zzix();
        r0.endTransaction();
        r2 = 1;
        return r2;
    L_0x0ae4:
        r0 = r50.zzix();	 Catch:{ all -> 0x0afb }
        r0.setTransactionSuccessful();	 Catch:{ all -> 0x0afb }
        r0 = r50.zzix();
        r0.endTransaction();
        r2 = 0;
        return r2;
    L_0x0af4:
        r0 = move-exception;
    L_0x0af5:
        if (r9 == 0) goto L_0x0afa;
    L_0x0af7:
        r9.close();	 Catch:{ all -> 0x0afb }
    L_0x0afa:
        throw r0;	 Catch:{ all -> 0x0afb }
    L_0x0afb:
        r0 = move-exception;
        r2 = r50.zzix();
        r2.endTransaction();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzd(java.lang.String, long):boolean");
    }

    @WorkerThread
    private final zzdy zzg(zzdz com_google_android_gms_internal_measurement_zzdz) {
        Object obj;
        zzab();
        zzkq();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzdz.packageName);
        zzdy zzbc = zzix().zzbc(com_google_android_gms_internal_measurement_zzdz.packageName);
        String zzbp = zzgf().zzbp(com_google_android_gms_internal_measurement_zzdz.packageName);
        if (zzbc == null) {
            zzbc = new zzdy(this.zzacw, com_google_android_gms_internal_measurement_zzdz.packageName);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            zzbc.zzan(zzbp);
        } else if (zzbp.equals(zzbc.zzgi())) {
            obj = null;
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm) || com_google_android_gms_internal_measurement_zzdz.zzadm.equals(zzbc.getGmpAppId()))) {
                zzbc.zzam(com_google_android_gms_internal_measurement_zzdz.zzadm);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzado) || com_google_android_gms_internal_measurement_zzdz.zzado.equals(zzbc.zzgj()))) {
                zzbc.zzao(com_google_android_gms_internal_measurement_zzdz.zzado);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_measurement_zzdz.zzadu == 0 || com_google_android_gms_internal_measurement_zzdz.zzadu == zzbc.zzgo())) {
                zzbc.zzp(com_google_android_gms_internal_measurement_zzdz.zzadu);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzth) || com_google_android_gms_internal_measurement_zzdz.zzth.equals(zzbc.zzag()))) {
                zzbc.setAppVersion(com_google_android_gms_internal_measurement_zzdz.zzth);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzads != zzbc.zzgm()) {
                zzbc.zzo(com_google_android_gms_internal_measurement_zzdz.zzads);
                obj = 1;
            }
            if (!(com_google_android_gms_internal_measurement_zzdz.zzadt == null || com_google_android_gms_internal_measurement_zzdz.zzadt.equals(zzbc.zzgn()))) {
                zzbc.zzap(com_google_android_gms_internal_measurement_zzdz.zzadt);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzadv != zzbc.zzgp()) {
                zzbc.zzq(com_google_android_gms_internal_measurement_zzdz.zzadv);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzadw != zzbc.isMeasurementEnabled()) {
                zzbc.setMeasurementEnabled(com_google_android_gms_internal_measurement_zzdz.zzadw);
                obj = 1;
            }
            if (!(TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzaek) || com_google_android_gms_internal_measurement_zzdz.zzaek.equals(zzbc.zzha()))) {
                zzbc.zzaq(com_google_android_gms_internal_measurement_zzdz.zzaek);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzadx != zzbc.zzhc()) {
                zzbc.zzaa(com_google_android_gms_internal_measurement_zzdz.zzadx);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzady != zzbc.zzhd()) {
                zzbc.zzd(com_google_android_gms_internal_measurement_zzdz.zzady);
                obj = 1;
            }
            if (com_google_android_gms_internal_measurement_zzdz.zzadz != zzbc.zzhe()) {
                zzbc.zze(com_google_android_gms_internal_measurement_zzdz.zzadz);
                obj = 1;
            }
            if (obj != null) {
                zzix().zza(zzbc);
            }
            return zzbc;
        } else {
            zzbc.zzan(zzbp);
            zzbc.zzal(this.zzacw.zzfv().zzii());
        }
        obj = 1;
        zzbc.zzam(com_google_android_gms_internal_measurement_zzdz.zzadm);
        obj = 1;
        zzbc.zzao(com_google_android_gms_internal_measurement_zzdz.zzado);
        obj = 1;
        zzbc.zzp(com_google_android_gms_internal_measurement_zzdz.zzadu);
        obj = 1;
        zzbc.setAppVersion(com_google_android_gms_internal_measurement_zzdz.zzth);
        obj = 1;
        if (com_google_android_gms_internal_measurement_zzdz.zzads != zzbc.zzgm()) {
            zzbc.zzo(com_google_android_gms_internal_measurement_zzdz.zzads);
            obj = 1;
        }
        zzbc.zzap(com_google_android_gms_internal_measurement_zzdz.zzadt);
        obj = 1;
        if (com_google_android_gms_internal_measurement_zzdz.zzadv != zzbc.zzgp()) {
            zzbc.zzq(com_google_android_gms_internal_measurement_zzdz.zzadv);
            obj = 1;
        }
        if (com_google_android_gms_internal_measurement_zzdz.zzadw != zzbc.isMeasurementEnabled()) {
            zzbc.setMeasurementEnabled(com_google_android_gms_internal_measurement_zzdz.zzadw);
            obj = 1;
        }
        zzbc.zzaq(com_google_android_gms_internal_measurement_zzdz.zzaek);
        obj = 1;
        if (com_google_android_gms_internal_measurement_zzdz.zzadx != zzbc.zzhc()) {
            zzbc.zzaa(com_google_android_gms_internal_measurement_zzdz.zzadx);
            obj = 1;
        }
        if (com_google_android_gms_internal_measurement_zzdz.zzady != zzbc.zzhd()) {
            zzbc.zzd(com_google_android_gms_internal_measurement_zzdz.zzady);
            obj = 1;
        }
        if (com_google_android_gms_internal_measurement_zzdz.zzadz != zzbc.zzhe()) {
            zzbc.zze(com_google_android_gms_internal_measurement_zzdz.zzadz);
            obj = 1;
        }
        if (obj != null) {
            zzix().zza(zzbc);
        }
        return zzbc;
    }

    private final zzgf zzkm() {
        zza(this.zzaqa);
        return this.zzaqa;
    }

    private final zzfp zzko() {
        if (this.zzaqd != null) {
            return this.zzaqd;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjn zzkp() {
        zza(this.zzaqe);
        return this.zzaqe;
    }

    private final long zzkr() {
        long currentTimeMillis = zzbt().currentTimeMillis();
        zzhg zzgf = zzgf();
        zzgf.zzch();
        zzgf.zzab();
        long j = zzgf.zzajy.get();
        if (j == 0) {
            long nextInt = 1 + ((long) zzgf.zzgb().zzlc().nextInt(86400000));
            zzgf.zzajy.set(nextInt);
            j = nextInt;
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzkt() {
        zzab();
        zzkq();
        if (!zzix().zzhs()) {
            if (TextUtils.isEmpty(zzix().zzhn())) {
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    private final void zzku() {
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzab();
        zzkq();
        if (zzky()) {
            long abs;
            if (com_google_android_gms_internal_measurement_zzjr.zzaqh > 0) {
                abs = 3600000 - Math.abs(zzbt().elapsedRealtime() - com_google_android_gms_internal_measurement_zzjr.zzaqh);
                if (abs > 0) {
                    zzge().zzit().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzko().unregister();
                    zzkp().cancel();
                    return;
                }
                com_google_android_gms_internal_measurement_zzjr.zzaqh = 0;
            }
            if (com_google_android_gms_internal_measurement_zzjr.zzacw.zzjv()) {
                if (zzkt()) {
                    Object obj;
                    CharSequence zzhj;
                    zzex com_google_android_gms_internal_measurement_zzex;
                    long max;
                    long j;
                    long j2;
                    long j3;
                    long j4;
                    long abs2;
                    long abs3;
                    long j5;
                    int i;
                    long currentTimeMillis = zzbt().currentTimeMillis();
                    long max2 = Math.max(0, ((Long) zzew.zzahi.get()).longValue());
                    if (!zzix().zzht()) {
                        if (!zzix().zzho()) {
                            obj = null;
                            if (obj == null) {
                                zzhj = zzgg().zzhj();
                                com_google_android_gms_internal_measurement_zzex = (TextUtils.isEmpty(zzhj) || ".none.".equals(zzhj)) ? zzew.zzahc : zzew.zzahd;
                            } else {
                                com_google_android_gms_internal_measurement_zzex = zzew.zzahb;
                            }
                            max = Math.max(0, ((Long) com_google_android_gms_internal_measurement_zzex.get()).longValue());
                            j = zzgf().zzaju.get();
                            j2 = zzgf().zzajv.get();
                            j3 = max;
                            j4 = max2;
                            max2 = Math.max(zzix().zzhq(), zzix().zzhr());
                            if (max2 != 0) {
                                abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                                abs3 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                                currentTimeMillis = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs3);
                                max2 = abs2 + j4;
                                if (obj != null && currentTimeMillis > 0) {
                                    max2 = Math.min(abs2, currentTimeMillis) + j3;
                                }
                                j5 = j3;
                                if (!zzgb().zza(currentTimeMillis, j5)) {
                                    max2 = currentTimeMillis + j5;
                                }
                                if (abs3 != 0 && abs3 >= abs2) {
                                    i = 0;
                                    while (i < Math.min(20, Math.max(0, ((Integer) zzew.zzahk.get()).intValue()))) {
                                        max = max2 + (Math.max(0, ((Long) zzew.zzahj.get()).longValue()) * (1 << i));
                                        if (max > abs3) {
                                            max2 = max;
                                            break;
                                        } else {
                                            i++;
                                            max2 = max;
                                        }
                                    }
                                }
                                if (max2 != 0) {
                                    zzge().zzit().log("Next upload time is 0");
                                    zzko().unregister();
                                    zzkp().cancel();
                                    return;
                                } else if (zzkn().zzex()) {
                                    currentTimeMillis = zzgf().zzajw.get();
                                    abs = Math.max(0, ((Long) zzew.zzagz.get()).longValue());
                                    if (!zzgb().zza(currentTimeMillis, abs)) {
                                        max2 = Math.max(max2, currentTimeMillis + abs);
                                    }
                                    zzko().unregister();
                                    abs = max2 - zzbt().currentTimeMillis();
                                    if (abs <= 0) {
                                        abs = Math.max(0, ((Long) zzew.zzahe.get()).longValue());
                                        zzgf().zzaju.set(zzbt().currentTimeMillis());
                                    }
                                    zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(abs));
                                    zzkp().zzh(abs);
                                    return;
                                } else {
                                    zzge().zzit().log("No network");
                                    zzko().zzeu();
                                    zzkp().cancel();
                                    return;
                                }
                            }
                            max2 = 0;
                            if (max2 != 0) {
                                zzge().zzit().log("Next upload time is 0");
                                zzko().unregister();
                                zzkp().cancel();
                                return;
                            } else if (zzkn().zzex()) {
                                currentTimeMillis = zzgf().zzajw.get();
                                abs = Math.max(0, ((Long) zzew.zzagz.get()).longValue());
                                if (zzgb().zza(currentTimeMillis, abs)) {
                                    max2 = Math.max(max2, currentTimeMillis + abs);
                                }
                                zzko().unregister();
                                abs = max2 - zzbt().currentTimeMillis();
                                if (abs <= 0) {
                                    abs = Math.max(0, ((Long) zzew.zzahe.get()).longValue());
                                    zzgf().zzaju.set(zzbt().currentTimeMillis());
                                }
                                zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(abs));
                                zzkp().zzh(abs);
                                return;
                            } else {
                                zzge().zzit().log("No network");
                                zzko().zzeu();
                                zzkp().cancel();
                                return;
                            }
                        }
                    }
                    obj = 1;
                    if (obj == null) {
                        com_google_android_gms_internal_measurement_zzex = zzew.zzahb;
                    } else {
                        zzhj = zzgg().zzhj();
                        if (!TextUtils.isEmpty(zzhj)) {
                        }
                    }
                    max = Math.max(0, ((Long) com_google_android_gms_internal_measurement_zzex.get()).longValue());
                    j = zzgf().zzaju.get();
                    j2 = zzgf().zzajv.get();
                    j3 = max;
                    j4 = max2;
                    max2 = Math.max(zzix().zzhq(), zzix().zzhr());
                    if (max2 != 0) {
                        abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                        abs3 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                        currentTimeMillis = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs3);
                        max2 = abs2 + j4;
                        max2 = Math.min(abs2, currentTimeMillis) + j3;
                        j5 = j3;
                        if (zzgb().zza(currentTimeMillis, j5)) {
                            max2 = currentTimeMillis + j5;
                        }
                        i = 0;
                        while (i < Math.min(20, Math.max(0, ((Integer) zzew.zzahk.get()).intValue()))) {
                            max = max2 + (Math.max(0, ((Long) zzew.zzahj.get()).longValue()) * (1 << i));
                            if (max > abs3) {
                                max2 = max;
                                break;
                            } else {
                                i++;
                                max2 = max;
                            }
                        }
                    }
                    max2 = 0;
                    if (max2 != 0) {
                        zzge().zzit().log("Next upload time is 0");
                        zzko().unregister();
                        zzkp().cancel();
                        return;
                    } else if (zzkn().zzex()) {
                        zzge().zzit().log("No network");
                        zzko().zzeu();
                        zzkp().cancel();
                        return;
                    } else {
                        currentTimeMillis = zzgf().zzajw.get();
                        abs = Math.max(0, ((Long) zzew.zzagz.get()).longValue());
                        if (zzgb().zza(currentTimeMillis, abs)) {
                            max2 = Math.max(max2, currentTimeMillis + abs);
                        }
                        zzko().unregister();
                        abs = max2 - zzbt().currentTimeMillis();
                        if (abs <= 0) {
                            abs = Math.max(0, ((Long) zzew.zzahe.get()).longValue());
                            zzgf().zzaju.set(zzbt().currentTimeMillis());
                        }
                        zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(abs));
                        zzkp().zzh(abs);
                        return;
                    }
                }
            }
            zzge().zzit().log("Nothing to upload or uploading impossible");
            zzko().unregister();
            zzkp().cancel();
        }
    }

    @WorkerThread
    private final void zzkv() {
        zzab();
        if (!(this.zzaql || this.zzaqm)) {
            if (!this.zzaqn) {
                zzge().zzit().log("Stopping uploading service(s)");
                if (this.zzaqi != null) {
                    for (Runnable run : this.zzaqi) {
                        run.run();
                    }
                    this.zzaqi.clear();
                    return;
                }
                return;
            }
        }
        zzge().zzit().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaql), Boolean.valueOf(this.zzaqm), Boolean.valueOf(this.zzaqn));
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzkw() {
        Object e;
        zzfi zzim;
        String str;
        zzab();
        try {
            this.zzaqp = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqo = this.zzaqp.tryLock();
            if (this.zzaqo != null) {
                zzge().zzit().log("Storage concurrent access okay");
                return true;
            }
            zzge().zzim().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            e = e2;
            zzim = zzge().zzim();
            str = "Failed to acquire storage lock";
            zzim.zzg(str, e);
            return false;
        } catch (IOException e3) {
            e = e3;
            zzim = zzge().zzim();
            str = "Failed to access storage lock file";
            zzim.zzg(str, e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zzky() {
        zzab();
        zzkq();
        return this.zzaqg;
    }

    public Context getContext() {
        return this.zzacw.getContext();
    }

    @WorkerThread
    protected void start() {
        zzab();
        zzix().zzhp();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        zzku();
    }

    @WorkerThread
    @VisibleForTesting
    protected final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzhg zzix;
        zzab();
        zzkq();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqm = false;
                zzkv();
            }
        }
        List<Long> list = this.zzaqq;
        this.zzaqq = null;
        int i2 = 1;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzgf().zzaju.set(zzbt().currentTimeMillis());
                zzgf().zzajv.set(0);
                zzku();
                zzge().zzit().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzix().beginTransaction();
                try {
                    for (Long l : list) {
                        try {
                            zzix = zzix();
                            long longValue = l.longValue();
                            zzix.zzab();
                            zzix.zzch();
                            if (zzix.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzix.zzge().zzim().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzaqr == null || !this.zzaqr.contains(l)) {
                                throw e2;
                            }
                        }
                    }
                    zzix().setTransactionSuccessful();
                    this.zzaqr = null;
                    if (zzkn().zzex() && zzkt()) {
                        zzks();
                    } else {
                        this.zzaqs = -1;
                        zzku();
                    }
                    this.zzaqh = 0;
                } finally {
                    zzix().endTransaction();
                }
            } catch (SQLiteException e3) {
                zzge().zzim().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzaqh = zzbt().elapsedRealtime();
                zzge().zzit().zzg("Disable upload, time", Long.valueOf(this.zzaqh));
            }
        } else {
            zzge().zzit().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            if (zzgg().zzax(str)) {
                zzix().zzc(list);
            }
            zzku();
        }
        this.zzaqm = false;
        zzkv();
    }

    final void zza(zzgl com_google_android_gms_internal_measurement_zzgl) {
        this.zzacw = com_google_android_gms_internal_measurement_zzgl;
    }

    @WorkerThread
    final void zza(zzjw com_google_android_gms_internal_measurement_zzjw) {
        zzab();
        zzjq com_google_android_gms_internal_measurement_zzei = new zzei(this.zzacw);
        com_google_android_gms_internal_measurement_zzei.zzm();
        this.zzaqc = com_google_android_gms_internal_measurement_zzei;
        zzgg().zza(this.zzaqa);
        com_google_android_gms_internal_measurement_zzei = new zzeb(this.zzacw);
        com_google_android_gms_internal_measurement_zzei.zzm();
        this.zzaqf = com_google_android_gms_internal_measurement_zzei;
        com_google_android_gms_internal_measurement_zzei = new zzjn(this.zzacw);
        com_google_android_gms_internal_measurement_zzei.zzm();
        this.zzaqe = com_google_android_gms_internal_measurement_zzei;
        this.zzaqd = new zzfp(this.zzacw);
        if (this.zzaqj != this.zzaqk) {
            zzge().zzim().zze("Not all upload components initialized", Integer.valueOf(this.zzaqj), Integer.valueOf(this.zzaqk));
        }
        this.zzvo = true;
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzeu com_google_android_gms_internal_measurement_zzeu, @Size(min = 1) String str) {
        byte[] bArr;
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzeu com_google_android_gms_internal_measurement_zzeu2 = com_google_android_gms_internal_measurement_zzeu;
        String str2 = str;
        zzkq();
        zzab();
        zzgl.zzfr();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzeu);
        Preconditions.checkNotEmpty(str);
        zzace com_google_android_gms_internal_measurement_zzkp = new zzkp();
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str2);
            if (zzbc == null) {
                zzge().zzis().zzg("Log and bundle not available. package_name", str2);
            } else if (zzbc.isMeasurementEnabled()) {
                zzjz com_google_android_gms_internal_measurement_zzjz;
                long j;
                Bundle bundle;
                zzkq com_google_android_gms_internal_measurement_zzkq;
                zzdy com_google_android_gms_internal_measurement_zzdy;
                zzace com_google_android_gms_internal_measurement_zzace;
                long j2;
                if (("_iap".equals(com_google_android_gms_internal_measurement_zzeu2.name) || Event.ECOMMERCE_PURCHASE.equals(com_google_android_gms_internal_measurement_zzeu2.name)) && !zza(str2, com_google_android_gms_internal_measurement_zzeu2)) {
                    zzge().zzip().zzg("Failed to handle purchase event at single event bundle creation. appId", zzfg.zzbm(str));
                }
                boolean zzav = zzgg().zzav(str2);
                Long valueOf = Long.valueOf(0);
                if (zzav && "_e".equals(com_google_android_gms_internal_measurement_zzeu2.name)) {
                    zzfi zzip;
                    String str3;
                    Object zzbm;
                    if (com_google_android_gms_internal_measurement_zzeu2.zzafq != null) {
                        if (com_google_android_gms_internal_measurement_zzeu2.zzafq.size() != 0) {
                            if (com_google_android_gms_internal_measurement_zzeu2.zzafq.getLong("_et") == null) {
                                zzip = zzge().zzip();
                                str3 = "The engagement event does not include duration. appId";
                                zzbm = zzfg.zzbm(str);
                                zzip.zzg(str3, zzbm);
                            } else {
                                valueOf = com_google_android_gms_internal_measurement_zzeu2.zzafq.getLong("_et");
                            }
                        }
                    }
                    zzip = zzge().zzip();
                    str3 = "The engagement event does not contain any parameters. appId";
                    zzbm = zzfg.zzbm(str);
                    zzip.zzg(str3, zzbm);
                }
                zzkq com_google_android_gms_internal_measurement_zzkq2 = new zzkq();
                com_google_android_gms_internal_measurement_zzkp.zzatf = new zzkq[]{com_google_android_gms_internal_measurement_zzkq2};
                com_google_android_gms_internal_measurement_zzkq2.zzath = Integer.valueOf(1);
                com_google_android_gms_internal_measurement_zzkq2.zzatp = AbstractSpiCall.ANDROID_CLIENT_TYPE;
                com_google_android_gms_internal_measurement_zzkq2.zzti = zzbc.zzah();
                com_google_android_gms_internal_measurement_zzkq2.zzadt = zzbc.zzgn();
                com_google_android_gms_internal_measurement_zzkq2.zzth = zzbc.zzag();
                long zzgm = zzbc.zzgm();
                com_google_android_gms_internal_measurement_zzkq2.zzaub = zzgm == -2147483648L ? null : Integer.valueOf((int) zzgm);
                com_google_android_gms_internal_measurement_zzkq2.zzatt = Long.valueOf(zzbc.zzgo());
                com_google_android_gms_internal_measurement_zzkq2.zzadm = zzbc.getGmpAppId();
                com_google_android_gms_internal_measurement_zzkq2.zzatx = Long.valueOf(zzbc.zzgp());
                if (com_google_android_gms_internal_measurement_zzjr.zzacw.isEnabled() && zzef.zzhk() && zzgg().zzat(com_google_android_gms_internal_measurement_zzkq2.zzti)) {
                    com_google_android_gms_internal_measurement_zzkq2.zzauh = null;
                }
                Pair zzbo = zzgf().zzbo(zzbc.zzah());
                if (!(!zzbc.zzhd() || zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first))) {
                    com_google_android_gms_internal_measurement_zzkq2.zzatv = (String) zzbo.first;
                    com_google_android_gms_internal_measurement_zzkq2.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                com_google_android_gms_internal_measurement_zzkq2.zzatr = Build.MODEL;
                zzfw().zzch();
                com_google_android_gms_internal_measurement_zzkq2.zzatq = VERSION.RELEASE;
                com_google_android_gms_internal_measurement_zzkq2.zzats = Integer.valueOf((int) zzfw().zzic());
                com_google_android_gms_internal_measurement_zzkq2.zzafn = zzfw().zzid();
                com_google_android_gms_internal_measurement_zzkq2.zzadl = zzbc.getAppInstanceId();
                com_google_android_gms_internal_measurement_zzkq2.zzado = zzbc.zzgj();
                List zzbb = zzix().zzbb(zzbc.zzah());
                com_google_android_gms_internal_measurement_zzkq2.zzatj = new zzks[zzbb.size()];
                if (zzav) {
                    zzjz zzh = zzix().zzh(com_google_android_gms_internal_measurement_zzkq2.zzti, "_lte");
                    if (zzh != null) {
                        if (zzh.value != null) {
                            if (valueOf.longValue() > 0) {
                                zzjz com_google_android_gms_internal_measurement_zzjz2 = new zzjz(com_google_android_gms_internal_measurement_zzkq2.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + valueOf.longValue()));
                            } else {
                                com_google_android_gms_internal_measurement_zzjz = zzh;
                            }
                        }
                    }
                    zzjz com_google_android_gms_internal_measurement_zzjz3 = new zzjz(com_google_android_gms_internal_measurement_zzkq2.zzti, "auto", "_lte", zzbt().currentTimeMillis(), valueOf);
                } else {
                    com_google_android_gms_internal_measurement_zzjz = null;
                }
                zzks com_google_android_gms_internal_measurement_zzks = null;
                for (int i = 0; i < zzbb.size(); i++) {
                    zzks com_google_android_gms_internal_measurement_zzks2 = new zzks();
                    com_google_android_gms_internal_measurement_zzkq2.zzatj[i] = com_google_android_gms_internal_measurement_zzks2;
                    com_google_android_gms_internal_measurement_zzks2.name = ((zzjz) zzbb.get(i)).name;
                    com_google_android_gms_internal_measurement_zzks2.zzaun = Long.valueOf(((zzjz) zzbb.get(i)).zzaqz);
                    zzgb().zza(com_google_android_gms_internal_measurement_zzks2, ((zzjz) zzbb.get(i)).value);
                    if (zzav && "_lte".equals(com_google_android_gms_internal_measurement_zzks2.name)) {
                        com_google_android_gms_internal_measurement_zzks2.zzate = (Long) com_google_android_gms_internal_measurement_zzjz.value;
                        com_google_android_gms_internal_measurement_zzks2.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                        com_google_android_gms_internal_measurement_zzks = com_google_android_gms_internal_measurement_zzks2;
                    }
                }
                if (zzav && r8 == null) {
                    zzks com_google_android_gms_internal_measurement_zzks3 = new zzks();
                    com_google_android_gms_internal_measurement_zzks3.name = "_lte";
                    com_google_android_gms_internal_measurement_zzks3.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                    com_google_android_gms_internal_measurement_zzks3.zzate = (Long) com_google_android_gms_internal_measurement_zzjz.value;
                    com_google_android_gms_internal_measurement_zzkq2.zzatj = (zzks[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkq2.zzatj, com_google_android_gms_internal_measurement_zzkq2.zzatj.length + 1);
                    com_google_android_gms_internal_measurement_zzkq2.zzatj[com_google_android_gms_internal_measurement_zzkq2.zzatj.length - 1] = com_google_android_gms_internal_measurement_zzks3;
                }
                if (valueOf.longValue() > 0) {
                    zzix().zza(com_google_android_gms_internal_measurement_zzjz);
                }
                Bundle zzif = com_google_android_gms_internal_measurement_zzeu2.zzafq.zzif();
                if ("_iap".equals(com_google_android_gms_internal_measurement_zzeu2.name)) {
                    zzif.putLong("_c", 1);
                    zzge().zzis().log("Marking in-app purchase as real-time");
                    zzif.putLong("_r", 1);
                }
                zzif.putString("_o", com_google_android_gms_internal_measurement_zzeu2.origin);
                if (zzgb().zzcj(com_google_android_gms_internal_measurement_zzkq2.zzti)) {
                    zzgb().zza(zzif, "_dbg", Long.valueOf(1));
                    zzgb().zza(zzif, "_r", Long.valueOf(1));
                }
                zzeq zzf = zzix().zzf(str2, com_google_android_gms_internal_measurement_zzeu2.name);
                if (zzf == null) {
                    zzeq com_google_android_gms_internal_measurement_zzeq = zzf;
                    bArr = null;
                    j = 0;
                    bundle = zzif;
                    com_google_android_gms_internal_measurement_zzkq = com_google_android_gms_internal_measurement_zzkq2;
                    com_google_android_gms_internal_measurement_zzdy = zzbc;
                    com_google_android_gms_internal_measurement_zzace = com_google_android_gms_internal_measurement_zzkp;
                    zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzeu2.name, 1, 0, com_google_android_gms_internal_measurement_zzeu2.zzagb, 0, null, null, null);
                    zzix().zza(com_google_android_gms_internal_measurement_zzeq);
                    j2 = j;
                } else {
                    j = 0;
                    bundle = zzif;
                    com_google_android_gms_internal_measurement_zzkq = com_google_android_gms_internal_measurement_zzkq2;
                    com_google_android_gms_internal_measurement_zzdy = zzbc;
                    com_google_android_gms_internal_measurement_zzace = com_google_android_gms_internal_measurement_zzkp;
                    bArr = null;
                    long j3 = zzf.zzaft;
                    zzix().zza(zzf.zzac(com_google_android_gms_internal_measurement_zzeu2.zzagb).zzie());
                    j2 = j3;
                }
                zzep com_google_android_gms_internal_measurement_zzep = new zzep(com_google_android_gms_internal_measurement_zzjr.zzacw, com_google_android_gms_internal_measurement_zzeu2.origin, str, com_google_android_gms_internal_measurement_zzeu2.name, com_google_android_gms_internal_measurement_zzeu2.zzagb, j2, bundle);
                zzkn com_google_android_gms_internal_measurement_zzkn = new zzkn();
                zzkq com_google_android_gms_internal_measurement_zzkq3 = com_google_android_gms_internal_measurement_zzkq;
                com_google_android_gms_internal_measurement_zzkq3.zzati = new zzkn[]{com_google_android_gms_internal_measurement_zzkn};
                com_google_android_gms_internal_measurement_zzkn.zzatb = Long.valueOf(com_google_android_gms_internal_measurement_zzep.timestamp);
                com_google_android_gms_internal_measurement_zzkn.name = com_google_android_gms_internal_measurement_zzep.name;
                com_google_android_gms_internal_measurement_zzkn.zzatc = Long.valueOf(com_google_android_gms_internal_measurement_zzep.zzafp);
                com_google_android_gms_internal_measurement_zzkn.zzata = new zzko[com_google_android_gms_internal_measurement_zzep.zzafq.size()];
                Iterator it = com_google_android_gms_internal_measurement_zzep.zzafq.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    zzko com_google_android_gms_internal_measurement_zzko = new zzko();
                    int i3 = i2 + 1;
                    com_google_android_gms_internal_measurement_zzkn.zzata[i2] = com_google_android_gms_internal_measurement_zzko;
                    com_google_android_gms_internal_measurement_zzko.name = str4;
                    zzgb().zza(com_google_android_gms_internal_measurement_zzko, com_google_android_gms_internal_measurement_zzep.zzafq.get(str4));
                    i2 = i3;
                }
                zzdy com_google_android_gms_internal_measurement_zzdy2 = com_google_android_gms_internal_measurement_zzdy;
                com_google_android_gms_internal_measurement_zzkq3.zzaua = zza(com_google_android_gms_internal_measurement_zzdy2.zzah(), com_google_android_gms_internal_measurement_zzkq3.zzatj, com_google_android_gms_internal_measurement_zzkq3.zzati);
                com_google_android_gms_internal_measurement_zzkq3.zzatl = com_google_android_gms_internal_measurement_zzkn.zzatb;
                com_google_android_gms_internal_measurement_zzkq3.zzatm = com_google_android_gms_internal_measurement_zzkn.zzatb;
                long zzgl = com_google_android_gms_internal_measurement_zzdy2.zzgl();
                com_google_android_gms_internal_measurement_zzkq3.zzato = zzgl != j ? Long.valueOf(zzgl) : bArr;
                long zzgk = com_google_android_gms_internal_measurement_zzdy2.zzgk();
                if (zzgk != j) {
                    zzgl = zzgk;
                }
                com_google_android_gms_internal_measurement_zzkq3.zzatn = zzgl != j ? Long.valueOf(zzgl) : bArr;
                com_google_android_gms_internal_measurement_zzdy2.zzgt();
                com_google_android_gms_internal_measurement_zzkq3.zzaty = Integer.valueOf((int) com_google_android_gms_internal_measurement_zzdy2.zzgq());
                com_google_android_gms_internal_measurement_zzkq3.zzatu = Long.valueOf(12451);
                com_google_android_gms_internal_measurement_zzkq3.zzatk = Long.valueOf(zzbt().currentTimeMillis());
                com_google_android_gms_internal_measurement_zzkq3.zzatz = Boolean.TRUE;
                com_google_android_gms_internal_measurement_zzdy2.zzm(com_google_android_gms_internal_measurement_zzkq3.zzatl.longValue());
                com_google_android_gms_internal_measurement_zzdy2.zzn(com_google_android_gms_internal_measurement_zzkq3.zzatm.longValue());
                zzix().zza(com_google_android_gms_internal_measurement_zzdy2);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                zzace com_google_android_gms_internal_measurement_zzace2 = com_google_android_gms_internal_measurement_zzace;
                try {
                    byte[] bArr2 = new byte[com_google_android_gms_internal_measurement_zzace2.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr2, 0, bArr2.length);
                    com_google_android_gms_internal_measurement_zzace2.zza(zzb);
                    zzb.zzve();
                    return zzgb().zza(bArr2);
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to bundle and serialize. appId", zzfg.zzbm(str), e);
                    return bArr;
                }
            } else {
                zzge().zzis().zzg("Log and bundle disabled. package_name", str2);
            }
            byte[] bArr3 = new byte[0];
            return bArr3;
        } finally {
            zzix().endTransaction();
        }
    }

    @WorkerThread
    public void zzab() {
        zzgd().zzab();
    }

    @WorkerThread
    final void zzb(zzed com_google_android_gms_internal_measurement_zzed, zzdz com_google_android_gms_internal_measurement_zzdz) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzed.packageName);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed.origin);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed.zzaep);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm)) {
            if (com_google_android_gms_internal_measurement_zzdz.zzadw) {
                zzed com_google_android_gms_internal_measurement_zzed2 = new zzed(com_google_android_gms_internal_measurement_zzed);
                boolean z = false;
                com_google_android_gms_internal_measurement_zzed2.active = false;
                zzix().beginTransaction();
                try {
                    zzfi zzis;
                    String str;
                    Object obj;
                    Object zzbl;
                    Object value;
                    zzed zzi = zzix().zzi(com_google_android_gms_internal_measurement_zzed2.packageName, com_google_android_gms_internal_measurement_zzed2.zzaep.name);
                    if (!(zzi == null || zzi.origin.equals(com_google_android_gms_internal_measurement_zzed2.origin))) {
                        zzge().zzip().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzga().zzbl(com_google_android_gms_internal_measurement_zzed2.zzaep.name), com_google_android_gms_internal_measurement_zzed2.origin, zzi.origin);
                    }
                    if (zzi != null && zzi.active) {
                        com_google_android_gms_internal_measurement_zzed2.origin = zzi.origin;
                        com_google_android_gms_internal_measurement_zzed2.creationTimestamp = zzi.creationTimestamp;
                        com_google_android_gms_internal_measurement_zzed2.triggerTimeout = zzi.triggerTimeout;
                        com_google_android_gms_internal_measurement_zzed2.triggerEventName = zzi.triggerEventName;
                        com_google_android_gms_internal_measurement_zzed2.zzaer = zzi.zzaer;
                        com_google_android_gms_internal_measurement_zzed2.active = zzi.active;
                        com_google_android_gms_internal_measurement_zzed2.zzaep = new zzjx(com_google_android_gms_internal_measurement_zzed2.zzaep.name, zzi.zzaep.zzaqz, com_google_android_gms_internal_measurement_zzed2.zzaep.getValue(), zzi.zzaep.origin);
                    } else if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzed2.triggerEventName)) {
                        com_google_android_gms_internal_measurement_zzed2.zzaep = new zzjx(com_google_android_gms_internal_measurement_zzed2.zzaep.name, com_google_android_gms_internal_measurement_zzed2.creationTimestamp, com_google_android_gms_internal_measurement_zzed2.zzaep.getValue(), com_google_android_gms_internal_measurement_zzed2.zzaep.origin);
                        com_google_android_gms_internal_measurement_zzed2.active = true;
                        z = true;
                    }
                    if (com_google_android_gms_internal_measurement_zzed2.active) {
                        zzfi zzis2;
                        String str2;
                        Object obj2;
                        Object zzbl2;
                        Object obj3;
                        zzjx com_google_android_gms_internal_measurement_zzjx = com_google_android_gms_internal_measurement_zzed2.zzaep;
                        zzjz com_google_android_gms_internal_measurement_zzjz = new zzjz(com_google_android_gms_internal_measurement_zzed2.packageName, com_google_android_gms_internal_measurement_zzed2.origin, com_google_android_gms_internal_measurement_zzjx.name, com_google_android_gms_internal_measurement_zzjx.zzaqz, com_google_android_gms_internal_measurement_zzjx.getValue());
                        if (zzix().zza(com_google_android_gms_internal_measurement_zzjz)) {
                            zzis2 = zzge().zzis();
                            str2 = "User property updated immediately";
                            obj2 = com_google_android_gms_internal_measurement_zzed2.packageName;
                            zzbl2 = zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name);
                            obj3 = com_google_android_gms_internal_measurement_zzjz.value;
                        } else {
                            zzis2 = zzge().zzim();
                            str2 = "(2)Too many active user properties, ignoring";
                            obj2 = zzfg.zzbm(com_google_android_gms_internal_measurement_zzed2.packageName);
                            zzbl2 = zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name);
                            obj3 = com_google_android_gms_internal_measurement_zzjz.value;
                        }
                        zzis2.zzd(str2, obj2, zzbl2, obj3);
                        if (z && com_google_android_gms_internal_measurement_zzed2.zzaer != null) {
                            zzc(new zzeu(com_google_android_gms_internal_measurement_zzed2.zzaer, com_google_android_gms_internal_measurement_zzed2.creationTimestamp), com_google_android_gms_internal_measurement_zzdz);
                        }
                    }
                    if (zzix().zza(com_google_android_gms_internal_measurement_zzed2)) {
                        zzis = zzge().zzis();
                        str = "Conditional property added";
                        obj = com_google_android_gms_internal_measurement_zzed2.packageName;
                        zzbl = zzga().zzbl(com_google_android_gms_internal_measurement_zzed2.zzaep.name);
                        value = com_google_android_gms_internal_measurement_zzed2.zzaep.getValue();
                    } else {
                        zzis = zzge().zzim();
                        str = "Too many conditional properties, ignoring";
                        obj = zzfg.zzbm(com_google_android_gms_internal_measurement_zzed2.packageName);
                        zzbl = zzga().zzbl(com_google_android_gms_internal_measurement_zzed2.zzaep.name);
                        value = com_google_android_gms_internal_measurement_zzed2.zzaep.getValue();
                    }
                    zzis.zzd(str, obj, zzbl, value);
                    zzix().setTransactionSuccessful();
                } finally {
                    zzix().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_measurement_zzdz);
            }
        }
    }

    @WorkerThread
    final void zzb(zzeu com_google_android_gms_internal_measurement_zzeu, zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzeu com_google_android_gms_internal_measurement_zzeu2 = com_google_android_gms_internal_measurement_zzeu;
        zzdz com_google_android_gms_internal_measurement_zzdz2 = com_google_android_gms_internal_measurement_zzdz;
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzdz2.packageName);
        zzab();
        zzkq();
        String str = com_google_android_gms_internal_measurement_zzdz2.packageName;
        long j = com_google_android_gms_internal_measurement_zzeu2.zzagb;
        zzgb();
        if (!zzka.zzd(com_google_android_gms_internal_measurement_zzeu, com_google_android_gms_internal_measurement_zzdz)) {
            return;
        }
        if (com_google_android_gms_internal_measurement_zzdz2.zzadw) {
            zzix().beginTransaction();
            try {
                List emptyList;
                zzhg zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying timed out conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzix.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzed com_google_android_gms_internal_measurement_zzed : r4) {
                    if (com_google_android_gms_internal_measurement_zzed != null) {
                        zzge().zzis().zzd("User property timed out", com_google_android_gms_internal_measurement_zzed.packageName, zzga().zzbl(com_google_android_gms_internal_measurement_zzed.zzaep.name), com_google_android_gms_internal_measurement_zzed.zzaep.getValue());
                        if (com_google_android_gms_internal_measurement_zzed.zzaeq != null) {
                            zzc(new zzeu(com_google_android_gms_internal_measurement_zzed.zzaeq, j), com_google_android_gms_internal_measurement_zzdz2);
                        }
                        zzix().zzj(str, com_google_android_gms_internal_measurement_zzed.zzaep.name);
                    }
                }
                zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying expired conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    emptyList = Collections.emptyList();
                } else {
                    emptyList = zzix.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                List arrayList = new ArrayList(r4.size());
                for (zzed com_google_android_gms_internal_measurement_zzed2 : r4) {
                    if (com_google_android_gms_internal_measurement_zzed2 != null) {
                        zzge().zzis().zzd("User property expired", com_google_android_gms_internal_measurement_zzed2.packageName, zzga().zzbl(com_google_android_gms_internal_measurement_zzed2.zzaep.name), com_google_android_gms_internal_measurement_zzed2.zzaep.getValue());
                        zzix().zzg(str, com_google_android_gms_internal_measurement_zzed2.zzaep.name);
                        if (com_google_android_gms_internal_measurement_zzed2.zzaes != null) {
                            arrayList.add(com_google_android_gms_internal_measurement_zzed2.zzaes);
                        }
                        zzix().zzj(str, com_google_android_gms_internal_measurement_zzed2.zzaep.name);
                    }
                }
                ArrayList arrayList2 = (ArrayList) arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzc(new zzeu((zzeu) obj, j), com_google_android_gms_internal_measurement_zzdz2);
                }
                zzix = zzix();
                String str2 = com_google_android_gms_internal_measurement_zzeu2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzix.zzab();
                zzix.zzch();
                List emptyList2;
                if (j < 0) {
                    zzix.zzge().zzip().zzd("Invalid time querying triggered conditional properties", zzfg.zzbm(str), zzix.zzga().zzbj(str2), Long.valueOf(j));
                    emptyList2 = Collections.emptyList();
                } else {
                    emptyList2 = zzix.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                List arrayList3 = new ArrayList(r3.size());
                for (zzed com_google_android_gms_internal_measurement_zzed3 : r3) {
                    if (com_google_android_gms_internal_measurement_zzed3 != null) {
                        zzfi zzis;
                        String str3;
                        Object obj2;
                        Object zzbl;
                        Object obj3;
                        zzjx com_google_android_gms_internal_measurement_zzjx = com_google_android_gms_internal_measurement_zzed3.zzaep;
                        zzjz com_google_android_gms_internal_measurement_zzjz = r4;
                        zzjz com_google_android_gms_internal_measurement_zzjz2 = new zzjz(com_google_android_gms_internal_measurement_zzed3.packageName, com_google_android_gms_internal_measurement_zzed3.origin, com_google_android_gms_internal_measurement_zzjx.name, j, com_google_android_gms_internal_measurement_zzjx.getValue());
                        if (zzix().zza(com_google_android_gms_internal_measurement_zzjz)) {
                            zzis = zzge().zzis();
                            str3 = "User property triggered";
                            obj2 = com_google_android_gms_internal_measurement_zzed3.packageName;
                            zzbl = zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name);
                            obj3 = com_google_android_gms_internal_measurement_zzjz.value;
                        } else {
                            zzis = zzge().zzim();
                            str3 = "Too many active user properties, ignoring";
                            obj2 = zzfg.zzbm(com_google_android_gms_internal_measurement_zzed3.packageName);
                            zzbl = zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name);
                            obj3 = com_google_android_gms_internal_measurement_zzjz.value;
                        }
                        zzis.zzd(str3, obj2, zzbl, obj3);
                        if (com_google_android_gms_internal_measurement_zzed3.zzaer != null) {
                            arrayList3.add(com_google_android_gms_internal_measurement_zzed3.zzaer);
                        }
                        com_google_android_gms_internal_measurement_zzed3.zzaep = new zzjx(com_google_android_gms_internal_measurement_zzjz);
                        com_google_android_gms_internal_measurement_zzed3.active = true;
                        zzix().zza(com_google_android_gms_internal_measurement_zzed3);
                    }
                }
                zzc(com_google_android_gms_internal_measurement_zzeu, com_google_android_gms_internal_measurement_zzdz);
                ArrayList arrayList4 = (ArrayList) arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj4 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzeu((zzeu) obj4, j), com_google_android_gms_internal_measurement_zzdz2);
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        } else {
            zzg(com_google_android_gms_internal_measurement_zzdz2);
        }
    }

    final void zzb(zzjq com_google_android_gms_internal_measurement_zzjq) {
        this.zzaqj++;
    }

    @WorkerThread
    final void zzb(zzjx com_google_android_gms_internal_measurement_zzjx, zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm)) {
            if (com_google_android_gms_internal_measurement_zzdz.zzadw) {
                int zzcf = zzgb().zzcf(com_google_android_gms_internal_measurement_zzjx.name);
                int i = 0;
                if (zzcf != 0) {
                    zzgb();
                    zzgb().zza(com_google_android_gms_internal_measurement_zzdz.packageName, zzcf, "_ev", zzka.zza(com_google_android_gms_internal_measurement_zzjx.name, 24, true), com_google_android_gms_internal_measurement_zzjx.name != null ? com_google_android_gms_internal_measurement_zzjx.name.length() : 0);
                    return;
                }
                int zzi = zzgb().zzi(com_google_android_gms_internal_measurement_zzjx.name, com_google_android_gms_internal_measurement_zzjx.getValue());
                if (zzi != 0) {
                    zzgb();
                    String zza = zzka.zza(com_google_android_gms_internal_measurement_zzjx.name, 24, true);
                    Object value = com_google_android_gms_internal_measurement_zzjx.getValue();
                    if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                        i = String.valueOf(value).length();
                    }
                    zzgb().zza(com_google_android_gms_internal_measurement_zzdz.packageName, zzi, "_ev", zza, i);
                    return;
                }
                Object zzj = zzgb().zzj(com_google_android_gms_internal_measurement_zzjx.name, com_google_android_gms_internal_measurement_zzjx.getValue());
                if (zzj != null) {
                    zzjz com_google_android_gms_internal_measurement_zzjz = new zzjz(com_google_android_gms_internal_measurement_zzdz.packageName, com_google_android_gms_internal_measurement_zzjx.origin, com_google_android_gms_internal_measurement_zzjx.name, com_google_android_gms_internal_measurement_zzjx.zzaqz, zzj);
                    zzge().zzis().zze("Setting user property", zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name), zzj);
                    zzix().beginTransaction();
                    try {
                        zzg(com_google_android_gms_internal_measurement_zzdz);
                        boolean zza2 = zzix().zza(com_google_android_gms_internal_measurement_zzjz);
                        zzix().setTransactionSuccessful();
                        if (zza2) {
                            zzge().zzis().zze("User property set", zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name), com_google_android_gms_internal_measurement_zzjz.value);
                        } else {
                            zzge().zzim().zze("Too many unique user properties are set. Ignoring user property", zzga().zzbl(com_google_android_gms_internal_measurement_zzjz.name), com_google_android_gms_internal_measurement_zzjz.value);
                            zzgb().zza(com_google_android_gms_internal_measurement_zzdz.packageName, 9, null, null, 0);
                        }
                        zzix().endTransaction();
                        return;
                    } catch (Throwable th) {
                        zzix().endTransaction();
                    }
                } else {
                    return;
                }
            }
            zzg(com_google_android_gms_internal_measurement_zzdz);
        }
    }

    @WorkerThread
    @VisibleForTesting
    final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        zzei zzix;
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaql = false;
                zzkv();
            }
        }
        zzge().zzit().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzix().beginTransaction();
        zzdy zzbc = zzix().zzbc(str);
        boolean z = true;
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zzbc == null) {
            zzge().zzip().zzg("App does not exist in onConfigFetched. appId", zzfg.zzbm(str));
            zzix().setTransactionSuccessful();
            zzix = zzix();
        } else {
            if (!z2) {
                if (i != HttpStatus.HTTP_NOT_FOUND) {
                    zzbc.zzt(zzbt().currentTimeMillis());
                    zzix().zza(zzbc);
                    zzge().zzit().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                    zzkm().zzbw(str);
                    zzgf().zzajv.set(zzbt().currentTimeMillis());
                    if (i != 503) {
                        if (i != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        zzgf().zzajw.set(zzbt().currentTimeMillis());
                    }
                    zzku();
                    zzix().setTransactionSuccessful();
                    zzix = zzix();
                }
            }
            List list = map != null ? (List) map.get(HttpRequest.HEADER_LAST_MODIFIED) : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                if (i != 304) {
                    if (!zzkm().zza(str, bArr, str2)) {
                        zzix = zzix();
                    }
                    zzbc.zzs(zzbt().currentTimeMillis());
                    zzix().zza(zzbc);
                    if (i != HttpStatus.HTTP_NOT_FOUND) {
                        zzge().zziq().zzg("Config not found. Using empty config. appId", str);
                    } else {
                        zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    }
                    if (zzkn().zzex() && zzkt()) {
                        zzks();
                        zzix().setTransactionSuccessful();
                        zzix = zzix();
                    }
                    zzku();
                    zzix().setTransactionSuccessful();
                    zzix = zzix();
                }
            }
            if (zzkm().zzbu(str) == null && !zzkm().zza(str, null, null)) {
                zzix = zzix();
            }
            zzbc.zzs(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            if (i != HttpStatus.HTTP_NOT_FOUND) {
                zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            } else {
                zzge().zziq().zzg("Config not found. Using empty config. appId", str);
            }
            zzks();
            zzix().setTransactionSuccessful();
            zzix = zzix();
        }
        zzix.endTransaction();
        this.zzaql = false;
        zzkv();
    }

    public Clock zzbt() {
        return this.zzacw.zzbt();
    }

    @WorkerThread
    final void zzc(zzed com_google_android_gms_internal_measurement_zzed, zzdz com_google_android_gms_internal_measurement_zzdz) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzed.packageName);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzed.zzaep);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm)) {
            if (com_google_android_gms_internal_measurement_zzdz.zzadw) {
                zzix().beginTransaction();
                try {
                    zzg(com_google_android_gms_internal_measurement_zzdz);
                    zzed zzi = zzix().zzi(com_google_android_gms_internal_measurement_zzed.packageName, com_google_android_gms_internal_measurement_zzed.zzaep.name);
                    if (zzi != null) {
                        zzge().zzis().zze("Removing conditional user property", com_google_android_gms_internal_measurement_zzed.packageName, zzga().zzbl(com_google_android_gms_internal_measurement_zzed.zzaep.name));
                        zzix().zzj(com_google_android_gms_internal_measurement_zzed.packageName, com_google_android_gms_internal_measurement_zzed.zzaep.name);
                        if (zzi.active) {
                            zzix().zzg(com_google_android_gms_internal_measurement_zzed.packageName, com_google_android_gms_internal_measurement_zzed.zzaep.name);
                        }
                        if (com_google_android_gms_internal_measurement_zzed.zzaes != null) {
                            Bundle bundle = null;
                            if (com_google_android_gms_internal_measurement_zzed.zzaes.zzafq != null) {
                                bundle = com_google_android_gms_internal_measurement_zzed.zzaes.zzafq.zzif();
                            }
                            Bundle bundle2 = bundle;
                            zzc(zzgb().zza(com_google_android_gms_internal_measurement_zzed.zzaes.name, bundle2, zzi.origin, com_google_android_gms_internal_measurement_zzed.zzaes.zzagb, true, false), com_google_android_gms_internal_measurement_zzdz);
                        }
                    } else {
                        zzge().zzip().zze("Conditional user property doesn't exist", zzfg.zzbm(com_google_android_gms_internal_measurement_zzed.packageName), zzga().zzbl(com_google_android_gms_internal_measurement_zzed.zzaep.name));
                    }
                    zzix().setTransactionSuccessful();
                } finally {
                    zzix().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_measurement_zzdz);
            }
        }
    }

    @WorkerThread
    final void zzc(zzeu com_google_android_gms_internal_measurement_zzeu, String str) {
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzeu com_google_android_gms_internal_measurement_zzeu2 = com_google_android_gms_internal_measurement_zzeu;
        String str2 = str;
        zzdy zzbc = zzix().zzbc(str2);
        if (zzbc != null) {
            if (!TextUtils.isEmpty(zzbc.zzag())) {
                Boolean zzc = zzc(zzbc);
                if (zzc == null) {
                    if (!"_ui".equals(com_google_android_gms_internal_measurement_zzeu2.name)) {
                        zzge().zzip().zzg("Could not find package. appId", zzfg.zzbm(str));
                    }
                } else if (!zzc.booleanValue()) {
                    zzge().zzim().zzg("App version does not match; dropping event. appId", zzfg.zzbm(str));
                    return;
                }
                zzdz com_google_android_gms_internal_measurement_zzdz = r2;
                zzdz com_google_android_gms_internal_measurement_zzdz2 = new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false);
                zzb(com_google_android_gms_internal_measurement_zzeu2, com_google_android_gms_internal_measurement_zzdz);
                return;
            }
        }
        zzge().zzis().zzg("No app data available; dropping event", str2);
    }

    @WorkerThread
    final void zzc(zzjx com_google_android_gms_internal_measurement_zzjx, zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm)) {
            if (com_google_android_gms_internal_measurement_zzdz.zzadw) {
                zzge().zzis().zzg("Removing user property", zzga().zzbl(com_google_android_gms_internal_measurement_zzjx.name));
                zzix().beginTransaction();
                try {
                    zzg(com_google_android_gms_internal_measurement_zzdz);
                    zzix().zzg(com_google_android_gms_internal_measurement_zzdz.packageName, com_google_android_gms_internal_measurement_zzjx.name);
                    zzix().setTransactionSuccessful();
                    zzge().zzis().zzg("User property removed", zzga().zzbl(com_google_android_gms_internal_measurement_zzjx.name));
                } finally {
                    zzix().endTransaction();
                }
            } else {
                zzg(com_google_android_gms_internal_measurement_zzdz);
            }
        }
    }

    @WorkerThread
    final zzdz zzcb(String str) {
        zzfi zzim;
        String str2;
        Object obj = str;
        zzdy zzbc = zzix().zzbc(obj);
        if (zzbc != null) {
            if (!TextUtils.isEmpty(zzbc.zzag())) {
                Boolean zzc = zzc(zzbc);
                if (zzc == null || zzc.booleanValue()) {
                    return new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false);
                }
                zzim = zzge().zzim();
                str2 = "App version does not match; dropping. appId";
                obj = zzfg.zzbm(str);
                zzim.zzg(str2, obj);
                return null;
            }
        }
        zzim = zzge().zzis();
        str2 = "No app data available; dropping";
        zzim.zzg(str2, obj);
        return null;
    }

    @WorkerThread
    @VisibleForTesting
    final void zzd(zzdz com_google_android_gms_internal_measurement_zzdz) {
        if (this.zzaqq != null) {
            this.zzaqr = new ArrayList();
            this.zzaqr.addAll(this.zzaqq);
        }
        zzhg zzix = zzix();
        String str = com_google_android_gms_internal_measurement_zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        try {
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            String[] strArr = new String[]{str};
            int delete = ((((((((0 + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("events", "app_id=?", strArr)) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("queue", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr)) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzix.zzge().zzit().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzix.zzge().zzim().zze("Error resetting analytics data. appId, error", zzfg.zzbm(str), e);
        }
        zzdz zza = zza(getContext(), com_google_android_gms_internal_measurement_zzdz.packageName, com_google_android_gms_internal_measurement_zzdz.zzadm, com_google_android_gms_internal_measurement_zzdz.zzadw, com_google_android_gms_internal_measurement_zzdz.zzady, com_google_android_gms_internal_measurement_zzdz.zzadz, com_google_android_gms_internal_measurement_zzdz.zzaem);
        if (!zzgg().zzaz(com_google_android_gms_internal_measurement_zzdz.packageName) || com_google_android_gms_internal_measurement_zzdz.zzadw) {
            zzf(zza);
        }
    }

    final void zze(zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzdz.packageName);
        zzg(com_google_android_gms_internal_measurement_zzdz);
    }

    @WorkerThread
    public final void zzf(zzdz com_google_android_gms_internal_measurement_zzdz) {
        zzjr com_google_android_gms_internal_measurement_zzjr = this;
        zzdz com_google_android_gms_internal_measurement_zzdz2 = com_google_android_gms_internal_measurement_zzdz;
        zzab();
        zzkq();
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
        Preconditions.checkNotEmpty(com_google_android_gms_internal_measurement_zzdz2.packageName);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz2.zzadm)) {
            zzdy zzbc = zzix().zzbc(com_google_android_gms_internal_measurement_zzdz2.packageName);
            if (!(zzbc == null || !TextUtils.isEmpty(zzbc.getGmpAppId()) || TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz2.zzadm))) {
                zzbc.zzs(0);
                zzix().zza(zzbc);
                zzkm().zzbx(com_google_android_gms_internal_measurement_zzdz2.packageName);
            }
            if (com_google_android_gms_internal_measurement_zzdz2.zzadw) {
                int i;
                String zzah;
                zzeu com_google_android_gms_internal_measurement_zzeu;
                zzei zzix;
                String str;
                zzeq com_google_android_gms_internal_measurement_zzeq;
                long j;
                long j2;
                Bundle bundle;
                PackageInfo packageInfo;
                Object obj;
                zzjx com_google_android_gms_internal_measurement_zzjx;
                zzjx com_google_android_gms_internal_measurement_zzjx2;
                ApplicationInfo applicationInfo;
                zzhg zzix2;
                String str2;
                long zzm;
                Bundle bundle2;
                long j3 = com_google_android_gms_internal_measurement_zzdz2.zzaem;
                if (j3 == 0) {
                    j3 = zzbt().currentTimeMillis();
                }
                int i2 = com_google_android_gms_internal_measurement_zzdz2.zzaen;
                if (i2 == 0 || i2 == 1) {
                    i = i2;
                } else {
                    zzge().zzip().zze("Incorrect app type, assuming installed app. appId, appType", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz2.packageName), Integer.valueOf(i2));
                    i = 0;
                }
                zzix().beginTransaction();
                zzhg zzix3;
                try {
                    zzbc = zzix().zzbc(com_google_android_gms_internal_measurement_zzdz2.packageName);
                    if (!(zzbc == null || zzbc.getGmpAppId() == null || zzbc.getGmpAppId().equals(com_google_android_gms_internal_measurement_zzdz2.zzadm))) {
                        zzge().zzip().zzg("New GMP App Id passed in. Removing cached database data. appId", zzfg.zzbm(zzbc.zzah()));
                        zzix3 = zzix();
                        zzah = zzbc.zzah();
                        zzix3.zzch();
                        zzix3.zzab();
                        Preconditions.checkNotEmpty(zzah);
                        SQLiteDatabase writableDatabase = zzix3.getWritableDatabase();
                        String[] strArr = new String[]{zzah};
                        int delete = ((((((((writableDatabase.delete("events", "app_id=?", strArr) + 0) + writableDatabase.delete("user_attributes", "app_id=?", strArr)) + writableDatabase.delete("conditional_properties", "app_id=?", strArr)) + writableDatabase.delete("apps", "app_id=?", strArr)) + writableDatabase.delete("raw_events", "app_id=?", strArr)) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr)) + writableDatabase.delete("event_filters", "app_id=?", strArr)) + writableDatabase.delete("property_filters", "app_id=?", strArr)) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzix3.zzge().zzit().zze("Deleted application data. app, records", zzah, Integer.valueOf(delete));
                        }
                        zzbc = null;
                    }
                } catch (SQLiteException e) {
                    zzix3.zzge().zzim().zze("Error deleting application data. appId, error", zzfg.zzbm(zzah), e);
                } catch (Throwable th) {
                    zzix().endTransaction();
                }
                if (zzbc != null) {
                    Bundle bundle3;
                    if (zzbc.zzgm() != -2147483648L) {
                        if (zzbc.zzgm() != com_google_android_gms_internal_measurement_zzdz2.zzads) {
                            bundle3 = new Bundle();
                            bundle3.putString("_pv", zzbc.zzag());
                            com_google_android_gms_internal_measurement_zzeu = new zzeu("_au", new zzer(bundle3), "auto", j3);
                        }
                    } else if (!(zzbc.zzag() == null || zzbc.zzag().equals(com_google_android_gms_internal_measurement_zzdz2.zzth))) {
                        bundle3 = new Bundle();
                        bundle3.putString("_pv", zzbc.zzag());
                        com_google_android_gms_internal_measurement_zzeu = new zzeu("_au", new zzer(bundle3), "auto", j3);
                    }
                    zzb(r0, com_google_android_gms_internal_measurement_zzdz2);
                }
                zzg(com_google_android_gms_internal_measurement_zzdz);
                if (i == 0) {
                    zzix = zzix();
                    str = com_google_android_gms_internal_measurement_zzdz2.packageName;
                    zzah = "_f";
                } else if (i == 1) {
                    zzix = zzix();
                    str = com_google_android_gms_internal_measurement_zzdz2.packageName;
                    zzah = "_v";
                } else {
                    com_google_android_gms_internal_measurement_zzeq = null;
                    if (com_google_android_gms_internal_measurement_zzeq != null) {
                        j = 3600000 * (1 + (j3 / 3600000));
                        if (i != 0) {
                            j2 = 1;
                            zzb(new zzjx("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_measurement_zzdz2);
                            zzab();
                            zzkq();
                            bundle = new Bundle();
                            bundle.putLong("_c", j2);
                            bundle.putLong("_r", j2);
                            bundle.putLong("_uwa", 0);
                            bundle.putLong("_pfo", 0);
                            bundle.putLong("_sys", 0);
                            bundle.putLong("_sysu", 0);
                            if (zzgg().zzaz(com_google_android_gms_internal_measurement_zzdz2.packageName) && com_google_android_gms_internal_measurement_zzdz2.zzaeo) {
                                bundle.putLong("_dac", j2);
                            }
                            if (getContext().getPackageManager() != null) {
                                zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz2.packageName));
                            } else {
                                try {
                                    packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(com_google_android_gms_internal_measurement_zzdz2.packageName, 0);
                                } catch (NameNotFoundException e2) {
                                    zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz2.packageName), e2);
                                    packageInfo = null;
                                }
                                if (!(packageInfo == null || packageInfo.firstInstallTime == 0)) {
                                    if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                                        bundle.putLong("_uwa", j2);
                                        obj = null;
                                    } else {
                                        obj = 1;
                                    }
                                    com_google_android_gms_internal_measurement_zzjx = com_google_android_gms_internal_measurement_zzjx2;
                                    com_google_android_gms_internal_measurement_zzjx2 = new zzjx("_fi", j3, Long.valueOf(obj == null ? j2 : 0), "auto");
                                    zzb(com_google_android_gms_internal_measurement_zzjx, com_google_android_gms_internal_measurement_zzdz2);
                                }
                                try {
                                    applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(com_google_android_gms_internal_measurement_zzdz2.packageName, 0);
                                } catch (NameNotFoundException e22) {
                                    zzge().zzim().zze("Application info is null, first open report might be inaccurate. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz2.packageName), e22);
                                    applicationInfo = null;
                                }
                                if (applicationInfo != null) {
                                    if ((applicationInfo.flags & 1) != 0) {
                                        bundle.putLong("_sys", j2);
                                    }
                                    if ((applicationInfo.flags & 128) != 0) {
                                        bundle.putLong("_sysu", j2);
                                    }
                                }
                            }
                            zzix2 = zzix();
                            str2 = com_google_android_gms_internal_measurement_zzdz2.packageName;
                            Preconditions.checkNotEmpty(str2);
                            zzix2.zzab();
                            zzix2.zzch();
                            zzm = zzix2.zzm(str2, "first_open_count");
                            if (zzm >= 0) {
                                bundle.putLong("_pfo", zzm);
                            }
                            zzb(new zzeu("_f", new zzer(bundle), "auto", j3), com_google_android_gms_internal_measurement_zzdz2);
                        } else {
                            j2 = 1;
                            if (i == 1) {
                                zzb(new zzjx("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_measurement_zzdz2);
                                zzab();
                                zzkq();
                                bundle2 = new Bundle();
                                bundle2.putLong("_c", j2);
                                bundle2.putLong("_r", j2);
                                if (zzgg().zzaz(com_google_android_gms_internal_measurement_zzdz2.packageName) && com_google_android_gms_internal_measurement_zzdz2.zzaeo) {
                                    bundle2.putLong("_dac", j2);
                                }
                                zzb(new zzeu("_v", new zzer(bundle2), "auto", j3), com_google_android_gms_internal_measurement_zzdz2);
                            }
                        }
                        bundle2 = new Bundle();
                        bundle2.putLong("_et", j2);
                        com_google_android_gms_internal_measurement_zzeu = new zzeu("_e", new zzer(bundle2), "auto", j3);
                    } else {
                        if (com_google_android_gms_internal_measurement_zzdz2.zzael) {
                            com_google_android_gms_internal_measurement_zzeu = new zzeu("_cd", new zzer(new Bundle()), "auto", j3);
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                    zzb(r3, com_google_android_gms_internal_measurement_zzdz2);
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    return;
                }
                com_google_android_gms_internal_measurement_zzeq = zzix.zzf(str, zzah);
                if (com_google_android_gms_internal_measurement_zzeq != null) {
                    if (com_google_android_gms_internal_measurement_zzdz2.zzael) {
                        com_google_android_gms_internal_measurement_zzeu = new zzeu("_cd", new zzer(new Bundle()), "auto", j3);
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    return;
                }
                j = 3600000 * (1 + (j3 / 3600000));
                if (i != 0) {
                    j2 = 1;
                    if (i == 1) {
                        zzb(new zzjx("_fvt", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_measurement_zzdz2);
                        zzab();
                        zzkq();
                        bundle2 = new Bundle();
                        bundle2.putLong("_c", j2);
                        bundle2.putLong("_r", j2);
                        bundle2.putLong("_dac", j2);
                        zzb(new zzeu("_v", new zzer(bundle2), "auto", j3), com_google_android_gms_internal_measurement_zzdz2);
                    }
                } else {
                    j2 = 1;
                    zzb(new zzjx("_fot", j3, Long.valueOf(j), "auto"), com_google_android_gms_internal_measurement_zzdz2);
                    zzab();
                    zzkq();
                    bundle = new Bundle();
                    bundle.putLong("_c", j2);
                    bundle.putLong("_r", j2);
                    bundle.putLong("_uwa", 0);
                    bundle.putLong("_pfo", 0);
                    bundle.putLong("_sys", 0);
                    bundle.putLong("_sysu", 0);
                    bundle.putLong("_dac", j2);
                    if (getContext().getPackageManager() != null) {
                        packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(com_google_android_gms_internal_measurement_zzdz2.packageName, 0);
                        if (packageInfo.firstInstallTime == packageInfo.lastUpdateTime) {
                            obj = 1;
                        } else {
                            bundle.putLong("_uwa", j2);
                            obj = null;
                        }
                        if (obj == null) {
                        }
                        com_google_android_gms_internal_measurement_zzjx = com_google_android_gms_internal_measurement_zzjx2;
                        com_google_android_gms_internal_measurement_zzjx2 = new zzjx("_fi", j3, Long.valueOf(obj == null ? j2 : 0), "auto");
                        zzb(com_google_android_gms_internal_measurement_zzjx, com_google_android_gms_internal_measurement_zzdz2);
                        applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(com_google_android_gms_internal_measurement_zzdz2.packageName, 0);
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle.putLong("_sys", j2);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle.putLong("_sysu", j2);
                            }
                        }
                    } else {
                        zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz2.packageName));
                    }
                    zzix2 = zzix();
                    str2 = com_google_android_gms_internal_measurement_zzdz2.packageName;
                    Preconditions.checkNotEmpty(str2);
                    zzix2.zzab();
                    zzix2.zzch();
                    zzm = zzix2.zzm(str2, "first_open_count");
                    if (zzm >= 0) {
                        bundle.putLong("_pfo", zzm);
                    }
                    zzb(new zzeu("_f", new zzer(bundle), "auto", j3), com_google_android_gms_internal_measurement_zzdz2);
                }
                bundle2 = new Bundle();
                bundle2.putLong("_et", j2);
                com_google_android_gms_internal_measurement_zzeu = new zzeu("_e", new zzer(bundle2), "auto", j3);
                zzb(r3, com_google_android_gms_internal_measurement_zzdz2);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                return;
            }
            zzg(com_google_android_gms_internal_measurement_zzdz);
        }
    }

    public zzeo zzfw() {
        return this.zzacw.zzfw();
    }

    @WorkerThread
    final void zzg(Runnable runnable) {
        zzab();
        if (this.zzaqi == null) {
            this.zzaqi = new ArrayList();
        }
        this.zzaqi.add(runnable);
    }

    public zzfe zzga() {
        return this.zzacw.zzga();
    }

    public zzka zzgb() {
        return this.zzacw.zzgb();
    }

    public zzgg zzgd() {
        return this.zzacw.zzgd();
    }

    public zzfg zzge() {
        return this.zzacw.zzge();
    }

    public zzfr zzgf() {
        return this.zzacw.zzgf();
    }

    public zzef zzgg() {
        return this.zzacw.zzgg();
    }

    public final String zzh(zzdz com_google_android_gms_internal_measurement_zzdz) {
        try {
            return (String) zzgd().zzb(new zzju(this, com_google_android_gms_internal_measurement_zzdz)).get(30000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            zzge().zzim().zze("Failed to get app instance id. appId", zzfg.zzbm(com_google_android_gms_internal_measurement_zzdz.packageName), e);
            return null;
        }
    }

    public final zzeb zziw() {
        zza(this.zzaqf);
        return this.zzaqf;
    }

    public final zzei zzix() {
        zza(this.zzaqc);
        return this.zzaqc;
    }

    public final zzfk zzkn() {
        zza(this.zzaqb);
        return this.zzaqb;
    }

    final void zzkq() {
        if (!this.zzvo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @android.support.annotation.WorkerThread
    public final void zzks() {
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
        r14 = this;
        r14.zzab();
        r14.zzkq();
        r0 = 1;
        r14.zzaqn = r0;
        r1 = 0;
        r2 = r14.zzacw;	 Catch:{ all -> 0x0286 }
        r2 = r2.zzfx();	 Catch:{ all -> 0x0286 }
        r2 = r2.zzkf();	 Catch:{ all -> 0x0286 }
        if (r2 != 0) goto L_0x0029;	 Catch:{ all -> 0x0286 }
    L_0x0016:
        r0 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r0 = r0.zzip();	 Catch:{ all -> 0x0286 }
        r2 = "Upload data called on the client side before use of service was decided";	 Catch:{ all -> 0x0286 }
    L_0x0020:
        r0.log(r2);	 Catch:{ all -> 0x0286 }
    L_0x0023:
        r14.zzaqn = r1;
        r14.zzkv();
        return;
    L_0x0029:
        r2 = r2.booleanValue();	 Catch:{ all -> 0x0286 }
        if (r2 == 0) goto L_0x003a;	 Catch:{ all -> 0x0286 }
    L_0x002f:
        r0 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r0 = r0.zzim();	 Catch:{ all -> 0x0286 }
        r2 = "Upload called in the client side when service should be used";	 Catch:{ all -> 0x0286 }
        goto L_0x0020;	 Catch:{ all -> 0x0286 }
    L_0x003a:
        r2 = r14.zzaqh;	 Catch:{ all -> 0x0286 }
        r4 = 0;	 Catch:{ all -> 0x0286 }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ all -> 0x0286 }
        if (r6 <= 0) goto L_0x0046;	 Catch:{ all -> 0x0286 }
    L_0x0042:
        r14.zzku();	 Catch:{ all -> 0x0286 }
        goto L_0x0023;	 Catch:{ all -> 0x0286 }
    L_0x0046:
        r14.zzab();	 Catch:{ all -> 0x0286 }
        r2 = r14.zzaqq;	 Catch:{ all -> 0x0286 }
        if (r2 == 0) goto L_0x004f;	 Catch:{ all -> 0x0286 }
    L_0x004d:
        r2 = r0;	 Catch:{ all -> 0x0286 }
        goto L_0x0050;	 Catch:{ all -> 0x0286 }
    L_0x004f:
        r2 = r1;	 Catch:{ all -> 0x0286 }
    L_0x0050:
        if (r2 == 0) goto L_0x005d;	 Catch:{ all -> 0x0286 }
    L_0x0052:
        r0 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r0 = r0.zzit();	 Catch:{ all -> 0x0286 }
        r2 = "Uploading requested multiple times";	 Catch:{ all -> 0x0286 }
        goto L_0x0020;	 Catch:{ all -> 0x0286 }
    L_0x005d:
        r2 = r14.zzkn();	 Catch:{ all -> 0x0286 }
        r2 = r2.zzex();	 Catch:{ all -> 0x0286 }
        if (r2 != 0) goto L_0x0075;	 Catch:{ all -> 0x0286 }
    L_0x0067:
        r0 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r0 = r0.zzit();	 Catch:{ all -> 0x0286 }
        r2 = "Network not connected, ignoring upload request";	 Catch:{ all -> 0x0286 }
        r0.log(r2);	 Catch:{ all -> 0x0286 }
        goto L_0x0042;	 Catch:{ all -> 0x0286 }
    L_0x0075:
        r2 = r14.zzbt();	 Catch:{ all -> 0x0286 }
        r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0286 }
        r6 = com.google.android.gms.internal.measurement.zzef.zzhi();	 Catch:{ all -> 0x0286 }
        r8 = r2 - r6;	 Catch:{ all -> 0x0286 }
        r6 = 0;	 Catch:{ all -> 0x0286 }
        r14.zzd(r6, r8);	 Catch:{ all -> 0x0286 }
        r7 = r14.zzgf();	 Catch:{ all -> 0x0286 }
        r7 = r7.zzaju;	 Catch:{ all -> 0x0286 }
        r7 = r7.get();	 Catch:{ all -> 0x0286 }
        r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1));	 Catch:{ all -> 0x0286 }
        if (r9 == 0) goto L_0x00ac;	 Catch:{ all -> 0x0286 }
    L_0x0095:
        r4 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r4 = r4.zzis();	 Catch:{ all -> 0x0286 }
        r5 = "Uploading events. Elapsed time since last upload attempt (ms)";	 Catch:{ all -> 0x0286 }
        r9 = r2 - r7;	 Catch:{ all -> 0x0286 }
        r7 = java.lang.Math.abs(r9);	 Catch:{ all -> 0x0286 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ all -> 0x0286 }
        r4.zzg(r5, r7);	 Catch:{ all -> 0x0286 }
    L_0x00ac:
        r4 = r14.zzix();	 Catch:{ all -> 0x0286 }
        r4 = r4.zzhn();	 Catch:{ all -> 0x0286 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0286 }
        r7 = -1;	 Catch:{ all -> 0x0286 }
        if (r5 != 0) goto L_0x0261;	 Catch:{ all -> 0x0286 }
    L_0x00bc:
        r9 = r14.zzaqs;	 Catch:{ all -> 0x0286 }
        r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1));	 Catch:{ all -> 0x0286 }
        if (r5 != 0) goto L_0x00cc;	 Catch:{ all -> 0x0286 }
    L_0x00c2:
        r5 = r14.zzix();	 Catch:{ all -> 0x0286 }
        r7 = r5.zzhu();	 Catch:{ all -> 0x0286 }
        r14.zzaqs = r7;	 Catch:{ all -> 0x0286 }
    L_0x00cc:
        r5 = r14.zzgg();	 Catch:{ all -> 0x0286 }
        r7 = com.google.android.gms.internal.measurement.zzew.zzago;	 Catch:{ all -> 0x0286 }
        r5 = r5.zzb(r4, r7);	 Catch:{ all -> 0x0286 }
        r7 = r14.zzgg();	 Catch:{ all -> 0x0286 }
        r8 = com.google.android.gms.internal.measurement.zzew.zzagp;	 Catch:{ all -> 0x0286 }
        r7 = r7.zzb(r4, r8);	 Catch:{ all -> 0x0286 }
        r7 = java.lang.Math.max(r1, r7);	 Catch:{ all -> 0x0286 }
        r8 = r14.zzix();	 Catch:{ all -> 0x0286 }
        r5 = r8.zzb(r4, r5, r7);	 Catch:{ all -> 0x0286 }
        r7 = r5.isEmpty();	 Catch:{ all -> 0x0286 }
        if (r7 != 0) goto L_0x0023;	 Catch:{ all -> 0x0286 }
    L_0x00f2:
        r7 = r5.iterator();	 Catch:{ all -> 0x0286 }
    L_0x00f6:
        r8 = r7.hasNext();	 Catch:{ all -> 0x0286 }
        if (r8 == 0) goto L_0x0111;	 Catch:{ all -> 0x0286 }
    L_0x00fc:
        r8 = r7.next();	 Catch:{ all -> 0x0286 }
        r8 = (android.util.Pair) r8;	 Catch:{ all -> 0x0286 }
        r8 = r8.first;	 Catch:{ all -> 0x0286 }
        r8 = (com.google.android.gms.internal.measurement.zzkq) r8;	 Catch:{ all -> 0x0286 }
        r9 = r8.zzatv;	 Catch:{ all -> 0x0286 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x0286 }
        if (r9 != 0) goto L_0x00f6;	 Catch:{ all -> 0x0286 }
    L_0x010e:
        r7 = r8.zzatv;	 Catch:{ all -> 0x0286 }
        goto L_0x0112;	 Catch:{ all -> 0x0286 }
    L_0x0111:
        r7 = r6;	 Catch:{ all -> 0x0286 }
    L_0x0112:
        if (r7 == 0) goto L_0x013d;	 Catch:{ all -> 0x0286 }
    L_0x0114:
        r8 = r1;	 Catch:{ all -> 0x0286 }
    L_0x0115:
        r9 = r5.size();	 Catch:{ all -> 0x0286 }
        if (r8 >= r9) goto L_0x013d;	 Catch:{ all -> 0x0286 }
    L_0x011b:
        r9 = r5.get(r8);	 Catch:{ all -> 0x0286 }
        r9 = (android.util.Pair) r9;	 Catch:{ all -> 0x0286 }
        r9 = r9.first;	 Catch:{ all -> 0x0286 }
        r9 = (com.google.android.gms.internal.measurement.zzkq) r9;	 Catch:{ all -> 0x0286 }
        r10 = r9.zzatv;	 Catch:{ all -> 0x0286 }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x0286 }
        if (r10 != 0) goto L_0x013a;	 Catch:{ all -> 0x0286 }
    L_0x012d:
        r9 = r9.zzatv;	 Catch:{ all -> 0x0286 }
        r9 = r9.equals(r7);	 Catch:{ all -> 0x0286 }
        if (r9 != 0) goto L_0x013a;	 Catch:{ all -> 0x0286 }
    L_0x0135:
        r5 = r5.subList(r1, r8);	 Catch:{ all -> 0x0286 }
        goto L_0x013d;	 Catch:{ all -> 0x0286 }
    L_0x013a:
        r8 = r8 + 1;	 Catch:{ all -> 0x0286 }
        goto L_0x0115;	 Catch:{ all -> 0x0286 }
    L_0x013d:
        r7 = new com.google.android.gms.internal.measurement.zzkp;	 Catch:{ all -> 0x0286 }
        r7.<init>();	 Catch:{ all -> 0x0286 }
        r8 = r5.size();	 Catch:{ all -> 0x0286 }
        r8 = new com.google.android.gms.internal.measurement.zzkq[r8];	 Catch:{ all -> 0x0286 }
        r7.zzatf = r8;	 Catch:{ all -> 0x0286 }
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x0286 }
        r9 = r5.size();	 Catch:{ all -> 0x0286 }
        r8.<init>(r9);	 Catch:{ all -> 0x0286 }
        r9 = com.google.android.gms.internal.measurement.zzef.zzhk();	 Catch:{ all -> 0x0286 }
        if (r9 == 0) goto L_0x0165;	 Catch:{ all -> 0x0286 }
    L_0x0159:
        r9 = r14.zzgg();	 Catch:{ all -> 0x0286 }
        r9 = r9.zzat(r4);	 Catch:{ all -> 0x0286 }
        if (r9 == 0) goto L_0x0165;	 Catch:{ all -> 0x0286 }
    L_0x0163:
        r9 = r0;	 Catch:{ all -> 0x0286 }
        goto L_0x0166;	 Catch:{ all -> 0x0286 }
    L_0x0165:
        r9 = r1;	 Catch:{ all -> 0x0286 }
    L_0x0166:
        r10 = r1;	 Catch:{ all -> 0x0286 }
    L_0x0167:
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r11 = r11.length;	 Catch:{ all -> 0x0286 }
        if (r10 >= r11) goto L_0x01b2;	 Catch:{ all -> 0x0286 }
    L_0x016c:
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r12 = r5.get(r10);	 Catch:{ all -> 0x0286 }
        r12 = (android.util.Pair) r12;	 Catch:{ all -> 0x0286 }
        r12 = r12.first;	 Catch:{ all -> 0x0286 }
        r12 = (com.google.android.gms.internal.measurement.zzkq) r12;	 Catch:{ all -> 0x0286 }
        r11[r10] = r12;	 Catch:{ all -> 0x0286 }
        r11 = r5.get(r10);	 Catch:{ all -> 0x0286 }
        r11 = (android.util.Pair) r11;	 Catch:{ all -> 0x0286 }
        r11 = r11.second;	 Catch:{ all -> 0x0286 }
        r11 = (java.lang.Long) r11;	 Catch:{ all -> 0x0286 }
        r8.add(r11);	 Catch:{ all -> 0x0286 }
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r11 = r11[r10];	 Catch:{ all -> 0x0286 }
        r12 = 12451; // 0x30a3 float:1.7448E-41 double:6.1516E-320;	 Catch:{ all -> 0x0286 }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0286 }
        r11.zzatu = r12;	 Catch:{ all -> 0x0286 }
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r11 = r11[r10];	 Catch:{ all -> 0x0286 }
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x0286 }
        r11.zzatk = r12;	 Catch:{ all -> 0x0286 }
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r11 = r11[r10];	 Catch:{ all -> 0x0286 }
        r12 = java.lang.Boolean.valueOf(r1);	 Catch:{ all -> 0x0286 }
        r11.zzatz = r12;	 Catch:{ all -> 0x0286 }
        if (r9 != 0) goto L_0x01af;	 Catch:{ all -> 0x0286 }
    L_0x01a9:
        r11 = r7.zzatf;	 Catch:{ all -> 0x0286 }
        r11 = r11[r10];	 Catch:{ all -> 0x0286 }
        r11.zzauh = r6;	 Catch:{ all -> 0x0286 }
    L_0x01af:
        r10 = r10 + 1;	 Catch:{ all -> 0x0286 }
        goto L_0x0167;	 Catch:{ all -> 0x0286 }
    L_0x01b2:
        r5 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r9 = 2;	 Catch:{ all -> 0x0286 }
        r5 = r5.isLoggable(r9);	 Catch:{ all -> 0x0286 }
        if (r5 == 0) goto L_0x01c5;	 Catch:{ all -> 0x0286 }
    L_0x01bd:
        r5 = r14.zzga();	 Catch:{ all -> 0x0286 }
        r6 = r5.zza(r7);	 Catch:{ all -> 0x0286 }
    L_0x01c5:
        r5 = r14.zzgb();	 Catch:{ all -> 0x0286 }
        r11 = r5.zzb(r7);	 Catch:{ all -> 0x0286 }
        r5 = com.google.android.gms.internal.measurement.zzew.zzagy;	 Catch:{ all -> 0x0286 }
        r5 = r5.get();	 Catch:{ all -> 0x0286 }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x0286 }
        r10 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x024e }
        r10.<init>(r5);	 Catch:{ MalformedURLException -> 0x024e }
        r9 = r8.isEmpty();	 Catch:{ MalformedURLException -> 0x024e }
        r9 = r9 ^ r0;	 Catch:{ MalformedURLException -> 0x024e }
        com.google.android.gms.common.internal.Preconditions.checkArgument(r9);	 Catch:{ MalformedURLException -> 0x024e }
        r9 = r14.zzaqq;	 Catch:{ MalformedURLException -> 0x024e }
        if (r9 == 0) goto L_0x01f4;	 Catch:{ MalformedURLException -> 0x024e }
    L_0x01e6:
        r8 = r14.zzge();	 Catch:{ MalformedURLException -> 0x024e }
        r8 = r8.zzim();	 Catch:{ MalformedURLException -> 0x024e }
        r9 = "Set uploading progress before finishing the previous upload";	 Catch:{ MalformedURLException -> 0x024e }
        r8.log(r9);	 Catch:{ MalformedURLException -> 0x024e }
        goto L_0x01fb;	 Catch:{ MalformedURLException -> 0x024e }
    L_0x01f4:
        r9 = new java.util.ArrayList;	 Catch:{ MalformedURLException -> 0x024e }
        r9.<init>(r8);	 Catch:{ MalformedURLException -> 0x024e }
        r14.zzaqq = r9;	 Catch:{ MalformedURLException -> 0x024e }
    L_0x01fb:
        r8 = r14.zzgf();	 Catch:{ MalformedURLException -> 0x024e }
        r8 = r8.zzajv;	 Catch:{ MalformedURLException -> 0x024e }
        r8.set(r2);	 Catch:{ MalformedURLException -> 0x024e }
        r2 = "?";	 Catch:{ MalformedURLException -> 0x024e }
        r3 = r7.zzatf;	 Catch:{ MalformedURLException -> 0x024e }
        r3 = r3.length;	 Catch:{ MalformedURLException -> 0x024e }
        if (r3 <= 0) goto L_0x0211;	 Catch:{ MalformedURLException -> 0x024e }
    L_0x020b:
        r2 = r7.zzatf;	 Catch:{ MalformedURLException -> 0x024e }
        r2 = r2[r1];	 Catch:{ MalformedURLException -> 0x024e }
        r2 = r2.zzti;	 Catch:{ MalformedURLException -> 0x024e }
    L_0x0211:
        r3 = r14.zzge();	 Catch:{ MalformedURLException -> 0x024e }
        r3 = r3.zzit();	 Catch:{ MalformedURLException -> 0x024e }
        r7 = "Uploading data. app, uncompressed size, data";	 Catch:{ MalformedURLException -> 0x024e }
        r8 = r11.length;	 Catch:{ MalformedURLException -> 0x024e }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ MalformedURLException -> 0x024e }
        r3.zzd(r7, r2, r8, r6);	 Catch:{ MalformedURLException -> 0x024e }
        r14.zzaqm = r0;	 Catch:{ MalformedURLException -> 0x024e }
        r8 = r14.zzkn();	 Catch:{ MalformedURLException -> 0x024e }
        r13 = new com.google.android.gms.internal.measurement.zzjs;	 Catch:{ MalformedURLException -> 0x024e }
        r13.<init>(r14, r4);	 Catch:{ MalformedURLException -> 0x024e }
        r8.zzab();	 Catch:{ MalformedURLException -> 0x024e }
        r8.zzch();	 Catch:{ MalformedURLException -> 0x024e }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r10);	 Catch:{ MalformedURLException -> 0x024e }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);	 Catch:{ MalformedURLException -> 0x024e }
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r13);	 Catch:{ MalformedURLException -> 0x024e }
        r0 = r8.zzgd();	 Catch:{ MalformedURLException -> 0x024e }
        r2 = new com.google.android.gms.internal.measurement.zzfo;	 Catch:{ MalformedURLException -> 0x024e }
        r12 = 0;	 Catch:{ MalformedURLException -> 0x024e }
        r7 = r2;	 Catch:{ MalformedURLException -> 0x024e }
        r9 = r4;	 Catch:{ MalformedURLException -> 0x024e }
        r7.<init>(r8, r9, r10, r11, r12, r13);	 Catch:{ MalformedURLException -> 0x024e }
        r0.zzd(r2);	 Catch:{ MalformedURLException -> 0x024e }
        goto L_0x0023;
    L_0x024e:
        r0 = r14.zzge();	 Catch:{ all -> 0x0286 }
        r0 = r0.zzim();	 Catch:{ all -> 0x0286 }
        r2 = "Failed to parse upload URL. Not uploading. appId";	 Catch:{ all -> 0x0286 }
        r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4);	 Catch:{ all -> 0x0286 }
        r0.zze(r2, r3, r5);	 Catch:{ all -> 0x0286 }
        goto L_0x0023;	 Catch:{ all -> 0x0286 }
    L_0x0261:
        r14.zzaqs = r7;	 Catch:{ all -> 0x0286 }
        r0 = r14.zzix();	 Catch:{ all -> 0x0286 }
        r4 = com.google.android.gms.internal.measurement.zzef.zzhi();	 Catch:{ all -> 0x0286 }
        r6 = r2 - r4;	 Catch:{ all -> 0x0286 }
        r0 = r0.zzab(r6);	 Catch:{ all -> 0x0286 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0286 }
        if (r2 != 0) goto L_0x0023;	 Catch:{ all -> 0x0286 }
    L_0x0277:
        r2 = r14.zzix();	 Catch:{ all -> 0x0286 }
        r0 = r2.zzbc(r0);	 Catch:{ all -> 0x0286 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ all -> 0x0286 }
    L_0x0281:
        r14.zzb(r0);	 Catch:{ all -> 0x0286 }
        goto L_0x0023;
    L_0x0286:
        r0 = move-exception;
        r14.zzaqn = r1;
        r14.zzkv();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzks():void");
    }

    @WorkerThread
    final void zzkx() {
        zzab();
        zzkq();
        if (!this.zzaqg) {
            zzge().zzir().log("This instance being marked as an uploader");
            zzab();
            zzkq();
            if (zzky() && zzkw()) {
                zzfi zzim;
                String str;
                int zza = zza(this.zzaqp);
                int zzij = this.zzacw.zzfv().zzij();
                zzab();
                if (zza > zzij) {
                    zzim = zzge().zzim();
                    str = "Panic: can't downgrade version. Previous, current version";
                } else if (zza < zzij) {
                    if (zza(zzij, this.zzaqp)) {
                        zzim = zzge().zzit();
                        str = "Storage version upgraded. Previous, current version";
                    } else {
                        zzim = zzge().zzim();
                        str = "Storage version upgrade failed. Previous, current version";
                    }
                }
                zzim.zze(str, Integer.valueOf(zza), Integer.valueOf(zzij));
            }
            this.zzaqg = true;
            zzku();
        }
    }

    final void zzkz() {
        this.zzaqk++;
    }

    final zzgl zzla() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        zzku();
    }
}
