package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

final class zzeb extends zzjq {
    zzeb(zzjr com_google_android_gms_internal_measurement_zzjr) {
        super(com_google_android_gms_internal_measurement_zzjr);
    }

    private final java.lang.Boolean zza(double r2, com.google.android.gms.internal.measurement.zzkg r4) {
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
        r1 = this;
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000e }
        r0.<init>(r2);	 Catch:{ NumberFormatException -> 0x000e }
        r2 = java.lang.Math.ulp(r2);	 Catch:{ NumberFormatException -> 0x000e }
        r2 = zza(r0, r4, r2);	 Catch:{ NumberFormatException -> 0x000e }
        return r2;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(double, com.google.android.gms.internal.measurement.zzkg):java.lang.Boolean");
    }

    private final java.lang.Boolean zza(long r2, com.google.android.gms.internal.measurement.zzkg r4) {
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
        r1 = this;
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x000c }
        r0.<init>(r2);	 Catch:{ NumberFormatException -> 0x000c }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x000c }
        r2 = zza(r0, r4, r2);	 Catch:{ NumberFormatException -> 0x000c }
        return r2;
    L_0x000c:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(long, com.google.android.gms.internal.measurement.zzkg):java.lang.Boolean");
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final java.lang.Boolean zza(java.lang.String r3, int r4, boolean r5, java.lang.String r6, java.util.List<java.lang.String> r7, java.lang.String r8) {
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
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 6;
        if (r4 != r1) goto L_0x0010;
    L_0x0007:
        if (r7 == 0) goto L_0x000f;
    L_0x0009:
        r1 = r7.size();
        if (r1 != 0) goto L_0x0013;
    L_0x000f:
        return r0;
    L_0x0010:
        if (r6 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        if (r5 != 0) goto L_0x001f;
    L_0x0015:
        r1 = 1;
        if (r4 != r1) goto L_0x0019;
    L_0x0018:
        goto L_0x001f;
    L_0x0019:
        r1 = java.util.Locale.ENGLISH;
        r3 = r3.toUpperCase(r1);
    L_0x001f:
        switch(r4) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003b;
            case 3: goto L_0x0036;
            case 4: goto L_0x0031;
            case 5: goto L_0x002c;
            case 6: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        return r0;
    L_0x0023:
        r3 = r7.contains(r3);
    L_0x0027:
        r3 = java.lang.Boolean.valueOf(r3);
        return r3;
    L_0x002c:
        r3 = r3.equals(r6);
        goto L_0x0027;
    L_0x0031:
        r3 = r3.contains(r6);
        goto L_0x0027;
    L_0x0036:
        r3 = r3.endsWith(r6);
        goto L_0x0027;
    L_0x003b:
        r3 = r3.startsWith(r6);
        goto L_0x0027;
    L_0x0040:
        if (r5 == 0) goto L_0x0044;
    L_0x0042:
        r4 = 0;
        goto L_0x0046;
    L_0x0044:
        r4 = 66;
    L_0x0046:
        r4 = java.util.regex.Pattern.compile(r8, r4);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r4.matcher(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = r3.matches();	 Catch:{ PatternSyntaxException -> 0x0057 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ PatternSyntaxException -> 0x0057 }
        return r3;
    L_0x0057:
        r3 = r2.zzge();
        r3 = r3.zzip();
        r4 = "Invalid regular expression in REGEXP audience filter. expression";
        r3.zzg(r4, r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.lang.String, int, boolean, java.lang.String, java.util.List, java.lang.String):java.lang.Boolean");
    }

    private final java.lang.Boolean zza(java.lang.String r5, com.google.android.gms.internal.measurement.zzkg r6) {
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
        r4 = this;
        r0 = com.google.android.gms.internal.measurement.zzka.zzck(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0014 }
        r0.<init>(r5);	 Catch:{ NumberFormatException -> 0x0014 }
        r2 = 0;	 Catch:{ NumberFormatException -> 0x0014 }
        r5 = zza(r0, r6, r2);	 Catch:{ NumberFormatException -> 0x0014 }
        return r5;
    L_0x0014:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzkg):java.lang.Boolean");
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzki com_google_android_gms_internal_measurement_zzki) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzki);
        if (!(str == null || com_google_android_gms_internal_measurement_zzki.zzash == null)) {
            if (com_google_android_gms_internal_measurement_zzki.zzash.intValue() != 0) {
                String toUpperCase;
                String str2;
                List list;
                String[] strArr;
                List arrayList;
                int length;
                if (com_google_android_gms_internal_measurement_zzki.zzash.intValue() == 6) {
                    if (com_google_android_gms_internal_measurement_zzki.zzask == null || com_google_android_gms_internal_measurement_zzki.zzask.length == 0) {
                        return null;
                    }
                } else if (com_google_android_gms_internal_measurement_zzki.zzasi == null) {
                    return null;
                }
                int intValue = com_google_android_gms_internal_measurement_zzki.zzash.intValue();
                int i = 0;
                boolean z = com_google_android_gms_internal_measurement_zzki.zzasj != null && com_google_android_gms_internal_measurement_zzki.zzasj.booleanValue();
                if (!(z || intValue == 1)) {
                    if (intValue != 6) {
                        toUpperCase = com_google_android_gms_internal_measurement_zzki.zzasi.toUpperCase(Locale.ENGLISH);
                        str2 = toUpperCase;
                        if (com_google_android_gms_internal_measurement_zzki.zzask != null) {
                            list = null;
                        } else {
                            strArr = com_google_android_gms_internal_measurement_zzki.zzask;
                            if (z) {
                                arrayList = new ArrayList();
                                length = strArr.length;
                                while (i < length) {
                                    arrayList.add(strArr[i].toUpperCase(Locale.ENGLISH));
                                    i++;
                                }
                                list = arrayList;
                            } else {
                                list = Arrays.asList(strArr);
                            }
                        }
                        return zza(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
                    }
                }
                toUpperCase = com_google_android_gms_internal_measurement_zzki.zzasi;
                str2 = toUpperCase;
                if (com_google_android_gms_internal_measurement_zzki.zzask != null) {
                    strArr = com_google_android_gms_internal_measurement_zzki.zzask;
                    if (z) {
                        arrayList = new ArrayList();
                        length = strArr.length;
                        while (i < length) {
                            arrayList.add(strArr[i].toUpperCase(Locale.ENGLISH));
                            i++;
                        }
                        list = arrayList;
                    } else {
                        list = Arrays.asList(strArr);
                    }
                } else {
                    list = null;
                }
                if (intValue != 1) {
                }
                return zza(str, intValue, z, str2, list, intValue != 1 ? str2 : null);
            }
        }
        return null;
    }

    @com.google.android.gms.common.util.VisibleForTesting
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzkg r8, double r9) {
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
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r8);
        r0 = r8.zzarz;
        r1 = 0;
        if (r0 == 0) goto L_0x00ee;
    L_0x0008:
        r0 = r8.zzarz;
        r0 = r0.intValue();
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x00ee;
    L_0x0012:
        r0 = r8.zzarz;
        r0 = r0.intValue();
        r2 = 4;
        if (r0 != r2) goto L_0x0024;
    L_0x001b:
        r0 = r8.zzasc;
        if (r0 == 0) goto L_0x0023;
    L_0x001f:
        r0 = r8.zzasd;
        if (r0 != 0) goto L_0x0029;
    L_0x0023:
        return r1;
    L_0x0024:
        r0 = r8.zzasb;
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r0 = r8.zzarz;
        r0 = r0.intValue();
        r3 = r8.zzarz;
        r3 = r3.intValue();
        if (r3 != r2) goto L_0x005a;
    L_0x0037:
        r3 = r8.zzasc;
        r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3);
        if (r3 == 0) goto L_0x0059;
    L_0x003f:
        r3 = r8.zzasd;
        r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3);
        if (r3 != 0) goto L_0x0048;
    L_0x0047:
        goto L_0x0059;
    L_0x0048:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0059 }
        r4 = r8.zzasc;	 Catch:{ NumberFormatException -> 0x0059 }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x0059 }
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0059 }
        r8 = r8.zzasd;	 Catch:{ NumberFormatException -> 0x0059 }
        r4.<init>(r8);	 Catch:{ NumberFormatException -> 0x0059 }
        r8 = r3;
        r3 = r1;
        goto L_0x006c;
    L_0x0059:
        return r1;
    L_0x005a:
        r3 = r8.zzasb;
        r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3);
        if (r3 != 0) goto L_0x0063;
    L_0x0062:
        return r1;
    L_0x0063:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x00ee }
        r8 = r8.zzasb;	 Catch:{ NumberFormatException -> 0x00ee }
        r3.<init>(r8);	 Catch:{ NumberFormatException -> 0x00ee }
        r8 = r1;
        r4 = r8;
    L_0x006c:
        if (r0 != r2) goto L_0x0071;
    L_0x006e:
        if (r8 != 0) goto L_0x0073;
    L_0x0070:
        return r1;
    L_0x0071:
        if (r3 == 0) goto L_0x00ee;
    L_0x0073:
        r2 = -1;
        r5 = 0;
        r6 = 1;
        switch(r0) {
            case 1: goto L_0x00e2;
            case 2: goto L_0x00d6;
            case 3: goto L_0x008d;
            case 4: goto L_0x007b;
            default: goto L_0x0079;
        };
    L_0x0079:
        goto L_0x00ee;
    L_0x007b:
        r8 = r7.compareTo(r8);
        if (r8 == r2) goto L_0x0088;
    L_0x0081:
        r7 = r7.compareTo(r4);
        if (r7 == r6) goto L_0x0088;
    L_0x0087:
        r5 = r6;
    L_0x0088:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x008d:
        r0 = 0;
        r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r8 == 0) goto L_0x00ca;
    L_0x0093:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r0 = new java.math.BigDecimal;
        r1 = 2;
        r0.<init>(r1);
        r8 = r8.multiply(r0);
        r8 = r3.subtract(r8);
        r8 = r7.compareTo(r8);
        if (r8 != r6) goto L_0x00c5;
    L_0x00ac:
        r8 = new java.math.BigDecimal;
        r8.<init>(r9);
        r9 = new java.math.BigDecimal;
        r9.<init>(r1);
        r8 = r8.multiply(r9);
        r8 = r3.add(r8);
        r7 = r7.compareTo(r8);
        if (r7 != r2) goto L_0x00c5;
    L_0x00c4:
        r5 = r6;
    L_0x00c5:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00ca:
        r7 = r7.compareTo(r3);
        if (r7 != 0) goto L_0x00d1;
    L_0x00d0:
        r5 = r6;
    L_0x00d1:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00d6:
        r7 = r7.compareTo(r3);
        if (r7 != r6) goto L_0x00dd;
    L_0x00dc:
        r5 = r6;
    L_0x00dd:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00e2:
        r7 = r7.compareTo(r3);
        if (r7 != r2) goto L_0x00e9;
    L_0x00e8:
        r5 = r6;
    L_0x00e9:
        r7 = java.lang.Boolean.valueOf(r5);
        return r7;
    L_0x00ee:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzkg, double):java.lang.Boolean");
    }

    @WorkerThread
    final zzkm[] zza(String str, zzkn[] com_google_android_gms_internal_measurement_zzknArr, zzks[] com_google_android_gms_internal_measurement_zzksArr) {
        int intValue;
        int i;
        Map map;
        Object obj;
        Object obj2;
        Long l;
        zzkn com_google_android_gms_internal_measurement_zzkn;
        int i2;
        int i3;
        Object e;
        ArrayMap arrayMap;
        int i4;
        zzko[] com_google_android_gms_internal_measurement_zzkoArr;
        int i5;
        zzkn com_google_android_gms_internal_measurement_zzkn2;
        HashSet hashSet;
        zzko[] com_google_android_gms_internal_measurement_zzkoArr2;
        int i6;
        long j;
        Map map2;
        Map map3;
        String str2;
        int intValue2;
        Map map4;
        Map map5;
        BitSet bitSet;
        Map map6;
        zzkm com_google_android_gms_internal_measurement_zzkm;
        BitSet bitSet2;
        Iterator it;
        Map map7;
        Map map8;
        Iterator it2;
        Iterator it3;
        Map map9;
        Map map10;
        Map map11;
        long j2;
        int i7;
        zzko com_google_android_gms_internal_measurement_zzko;
        zzfi zzip;
        Object zzbj;
        Object zzbk;
        zzkf[] com_google_android_gms_internal_measurement_zzkfArr;
        Boolean zza;
        boolean z;
        String str3;
        ArrayMap arrayMap2;
        Set set;
        zzks[] com_google_android_gms_internal_measurement_zzksArr2;
        Map map12;
        Map map13;
        Map map14;
        zzfi zzim;
        String str4;
        zzeb com_google_android_gms_internal_measurement_zzeb = this;
        String str5 = str;
        zzkn[] com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
        zzks[] com_google_android_gms_internal_measurement_zzksArr3 = com_google_android_gms_internal_measurement_zzksArr;
        Preconditions.checkNotEmpty(str);
        HashSet hashSet2 = new HashSet();
        Map arrayMap3 = new ArrayMap();
        Map arrayMap4 = new ArrayMap();
        Map arrayMap5 = new ArrayMap();
        Map zzbf = zzix().zzbf(str5);
        if (zzbf != null) {
            Iterator it4 = zzbf.keySet().iterator();
            while (it4.hasNext()) {
                Map map15;
                Iterator it5;
                intValue = ((Integer) it4.next()).intValue();
                zzkr com_google_android_gms_internal_measurement_zzkr = (zzkr) zzbf.get(Integer.valueOf(intValue));
                BitSet bitSet3 = (BitSet) arrayMap4.get(Integer.valueOf(intValue));
                BitSet bitSet4 = (BitSet) arrayMap5.get(Integer.valueOf(intValue));
                if (bitSet3 == null) {
                    bitSet3 = new BitSet();
                    arrayMap4.put(Integer.valueOf(intValue), bitSet3);
                    bitSet4 = new BitSet();
                    arrayMap5.put(Integer.valueOf(intValue), bitSet4);
                }
                i = 0;
                while (i < (com_google_android_gms_internal_measurement_zzkr.zzauk.length << 6)) {
                    if (zzka.zza(com_google_android_gms_internal_measurement_zzkr.zzauk, i)) {
                        map15 = zzbf;
                        it5 = it4;
                        map = arrayMap4;
                        zzge().zzit().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet4.set(i);
                        if (zzka.zza(com_google_android_gms_internal_measurement_zzkr.zzaul, i)) {
                            bitSet3.set(i);
                        }
                    } else {
                        map15 = zzbf;
                        it5 = it4;
                        map = arrayMap4;
                    }
                    i++;
                    zzbf = map15;
                    it4 = it5;
                    arrayMap4 = map;
                }
                map15 = zzbf;
                it5 = it4;
                map = arrayMap4;
                zzkm com_google_android_gms_internal_measurement_zzkm2 = new zzkm();
                arrayMap3.put(Integer.valueOf(intValue), com_google_android_gms_internal_measurement_zzkm2);
                com_google_android_gms_internal_measurement_zzkm2.zzasy = Boolean.valueOf(false);
                com_google_android_gms_internal_measurement_zzkm2.zzasx = com_google_android_gms_internal_measurement_zzkr;
                com_google_android_gms_internal_measurement_zzkm2.zzasw = new zzkr();
                com_google_android_gms_internal_measurement_zzkm2.zzasw.zzaul = zzka.zza(bitSet3);
                com_google_android_gms_internal_measurement_zzkm2.zzasw.zzauk = zzka.zza(bitSet4);
                zzbf = map15;
                it4 = it5;
            }
        }
        map = arrayMap4;
        if (com_google_android_gms_internal_measurement_zzknArr2 != null) {
            ArrayMap arrayMap6 = new ArrayMap();
            int length = com_google_android_gms_internal_measurement_zzknArr2.length;
            zzkn com_google_android_gms_internal_measurement_zzkn3 = null;
            Long l2 = null;
            int i8 = 0;
            long j3 = 0;
            while (i8 < length) {
                long j4;
                String str6;
                int i9;
                zzko[] com_google_android_gms_internal_measurement_zzkoArr3;
                String str7;
                long j5;
                zzeq zzf;
                Map map16;
                Map map17;
                Map map18;
                long j6;
                Iterator it6;
                HashSet hashSet3;
                BitSet bitSet5;
                zzke com_google_android_gms_internal_measurement_zzke;
                Boolean zza2;
                Set hashSet4;
                int i10;
                zzkf com_google_android_gms_internal_measurement_zzkf;
                boolean equals;
                zzkf[] com_google_android_gms_internal_measurement_zzkfArr2;
                int i11;
                zzkn com_google_android_gms_internal_measurement_zzkn4 = com_google_android_gms_internal_measurement_zzknArr2[i8];
                String str8 = com_google_android_gms_internal_measurement_zzkn4.name;
                zzko[] com_google_android_gms_internal_measurement_zzkoArr4 = com_google_android_gms_internal_measurement_zzkn4.zzata;
                if (zzgg().zzd(str5, zzew.zzahv)) {
                    int i12;
                    zzkn com_google_android_gms_internal_measurement_zzkn5;
                    zzhg zzix;
                    SQLiteDatabase writableDatabase;
                    String[] strArr;
                    int i13;
                    zzkn com_google_android_gms_internal_measurement_zzkn6;
                    zzko[] com_google_android_gms_internal_measurement_zzkoArr5;
                    zzko[] com_google_android_gms_internal_measurement_zzkoArr6;
                    int i14;
                    zzko com_google_android_gms_internal_measurement_zzko2;
                    long j7;
                    zzkn com_google_android_gms_internal_measurement_zzkn7;
                    Pair zza3;
                    Long valueOf;
                    Long l3;
                    zzgb();
                    Long l4 = (Long) zzka.zzb(com_google_android_gms_internal_measurement_zzkn4, "_eid");
                    obj = l4 != null ? 1 : null;
                    if (obj != null) {
                        i12 = length;
                        if (str8.equals("_ep")) {
                            obj2 = 1;
                            if (obj2 == null) {
                                zzgb();
                                str8 = (String) zzka.zzb(com_google_android_gms_internal_measurement_zzkn4, "_en");
                                if (!TextUtils.isEmpty(str8)) {
                                    if (!(com_google_android_gms_internal_measurement_zzkn3 == null || l2 == null)) {
                                        if (l4.longValue() != l2.longValue()) {
                                            l = l2;
                                            com_google_android_gms_internal_measurement_zzkn5 = com_google_android_gms_internal_measurement_zzkn3;
                                            j4 = j3 - 1;
                                            if (j4 > 0) {
                                                zzix = zzix();
                                                zzix.zzab();
                                                zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str5);
                                                try {
                                                    writableDatabase = zzix.getWritableDatabase();
                                                    str6 = "delete from main_event_params where app_id=?";
                                                    com_google_android_gms_internal_measurement_zzkn = com_google_android_gms_internal_measurement_zzkn5;
                                                    i2 = 1;
                                                    try {
                                                        strArr = new String[1];
                                                        i3 = 0;
                                                        try {
                                                            strArr[0] = str5;
                                                            writableDatabase.execSQL(str6, strArr);
                                                        } catch (SQLiteException e2) {
                                                            e = e2;
                                                            zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                                            i13 = i2;
                                                            arrayMap = arrayMap6;
                                                            i9 = i8;
                                                            i4 = i12;
                                                            com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                                            com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                                            com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                                            i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                                            i5 = i3;
                                                            i14 = i5;
                                                            while (i5 < i2) {
                                                                com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                                                zzgb();
                                                                if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                                                    i13 = i14 + 1;
                                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                                                    i14 = i13;
                                                                }
                                                                i5++;
                                                            }
                                                            if (i14 > 0) {
                                                                intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                                i2 = i3;
                                                                while (i2 < intValue) {
                                                                    i = i14 + 1;
                                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                                                    i2++;
                                                                    i14 = i;
                                                                }
                                                                if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                                                    com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                                                }
                                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                                                str7 = str8;
                                                            } else {
                                                                zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                                str7 = str8;
                                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                                            }
                                                            j5 = 0;
                                                            zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                                                            if (zzf != null) {
                                                                map16 = arrayMap5;
                                                                hashSet = hashSet2;
                                                                map17 = arrayMap3;
                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                                map18 = map;
                                                                j6 = j5;
                                                                i3 = i9;
                                                                zzf = zzf.zzie();
                                                            } else {
                                                                zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                                                                i6 = i3;
                                                                map16 = arrayMap5;
                                                                map18 = map;
                                                                hashSet = hashSet2;
                                                                map17 = arrayMap3;
                                                                j6 = j5;
                                                                i3 = i9;
                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                                zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                                                            }
                                                            zzix().zza(zzf);
                                                            j = zzf.zzafr;
                                                            map2 = arrayMap;
                                                            map3 = (Map) map2.get(str7);
                                                            if (map3 != null) {
                                                                str2 = str;
                                                            } else {
                                                                str2 = str;
                                                                map3 = zzix().zzk(str2, str7);
                                                                if (map3 == null) {
                                                                    map3 = new ArrayMap();
                                                                }
                                                                map2.put(str7, map3);
                                                            }
                                                            it6 = map3.keySet().iterator();
                                                            while (it6.hasNext()) {
                                                                intValue2 = ((Integer) it6.next()).intValue();
                                                                hashSet3 = hashSet;
                                                                if (hashSet3.contains(Integer.valueOf(intValue2))) {
                                                                    zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                                    hashSet = hashSet3;
                                                                } else {
                                                                    map4 = map17;
                                                                    map5 = map18;
                                                                    bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                                                                    map6 = map16;
                                                                    bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                                                                    if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                                                                        com_google_android_gms_internal_measurement_zzkm = new zzkm();
                                                                        map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                                                                        com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                                                                        bitSet2 = new BitSet();
                                                                        map5.put(Integer.valueOf(intValue2), bitSet2);
                                                                        bitSet5 = new BitSet();
                                                                        map6.put(Integer.valueOf(intValue2), bitSet5);
                                                                        bitSet = bitSet2;
                                                                    }
                                                                    it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                                                                    while (it.hasNext()) {
                                                                        map7 = map2;
                                                                        com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                                                                        map8 = map3;
                                                                        it2 = it6;
                                                                        if (zzge().isLoggable(2)) {
                                                                            it3 = it;
                                                                            map9 = map6;
                                                                            map10 = map5;
                                                                            map11 = map4;
                                                                            zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                                                            zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                                                                        } else {
                                                                            it3 = it;
                                                                            map11 = map4;
                                                                            map10 = map5;
                                                                            map9 = map6;
                                                                        }
                                                                        if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                                                            if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                                                                if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                                                                    zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                                                                    map2 = map7;
                                                                                    map3 = map8;
                                                                                    it6 = it2;
                                                                                    it = it3;
                                                                                    map6 = map9;
                                                                                    map5 = map10;
                                                                                    map4 = map11;
                                                                                } else {
                                                                                    if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                                                                        zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                                                                        if (zza2 != null) {
                                                                                            if (!zza2.booleanValue()) {
                                                                                                j2 = j;
                                                                                                zza2 = Boolean.valueOf(false);
                                                                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                                zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                                if (zza2 != null) {
                                                                                                    bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                                    if (zza2.booleanValue()) {
                                                                                                        bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                                    }
                                                                                                } else {
                                                                                                    hashSet3.add(Integer.valueOf(intValue2));
                                                                                                }
                                                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                                map2 = map7;
                                                                                                map3 = map8;
                                                                                                it6 = it2;
                                                                                                it = it3;
                                                                                                map6 = map9;
                                                                                                map5 = map10;
                                                                                                map4 = map11;
                                                                                                j = j2;
                                                                                            }
                                                                                        }
                                                                                        j2 = j;
                                                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                        zza2 = null;
                                                                                        if (zza2 != null) {
                                                                                        }
                                                                                        zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                        if (zza2 != null) {
                                                                                            hashSet3.add(Integer.valueOf(intValue2));
                                                                                        } else {
                                                                                            bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                            if (zza2.booleanValue()) {
                                                                                                bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                            }
                                                                                        }
                                                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                        map2 = map7;
                                                                                        map3 = map8;
                                                                                        it6 = it2;
                                                                                        it = it3;
                                                                                        map6 = map9;
                                                                                        map5 = map10;
                                                                                        map4 = map11;
                                                                                        j = j2;
                                                                                    }
                                                                                    hashSet4 = new HashSet();
                                                                                    for (zzkf com_google_android_gms_internal_measurement_zzkf2 : com_google_android_gms_internal_measurement_zzke.zzarr) {
                                                                                        if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                                                            zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                                                            j2 = j;
                                                                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                            break;
                                                                                        }
                                                                                        hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                                                                    }
                                                                                    map3 = new ArrayMap();
                                                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                    i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                                                    i10 = 0;
                                                                                    while (i10 < i) {
                                                                                        com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                                                                        j2 = j;
                                                                                        if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                                                            if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                                obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                                                            } else if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                                obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                                                            } else if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "Unknown value for param. event, param";
                                                                                                zzbj = zzga().zzbj(str7);
                                                                                                zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                                                                break;
                                                                                            } else {
                                                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                                obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                                                            }
                                                                                            map3.put(obj2, obj);
                                                                                        }
                                                                                        i10++;
                                                                                        j = j2;
                                                                                    }
                                                                                    j2 = j;
                                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                                                                    intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                                                                    i = 0;
                                                                                    while (i < intValue) {
                                                                                        com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                                                                        equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                                                                        str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                                                                        if (TextUtils.isEmpty(str5)) {
                                                                                            zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                                                                        } else {
                                                                                            com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                                                            obj2 = map3.get(str5);
                                                                                            i11 = intValue;
                                                                                            if (obj2 instanceof Long) {
                                                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                                    zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                    if (zza == null) {
                                                                                                        if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                            z = false;
                                                                                                            break;
                                                                                                        }
                                                                                                        i++;
                                                                                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                        intValue = i11;
                                                                                                    }
                                                                                                } else {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "No number filter for long param. event, param";
                                                                                                }
                                                                                            } else if (obj2 instanceof Double) {
                                                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                                    zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                    if (zza == null) {
                                                                                                        if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                            z = false;
                                                                                                            break;
                                                                                                        }
                                                                                                        i++;
                                                                                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                        intValue = i11;
                                                                                                    }
                                                                                                } else {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "No number filter for double param. event, param";
                                                                                                }
                                                                                            } else if (!(obj2 instanceof String)) {
                                                                                                if (obj2 == null) {
                                                                                                    zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                                                                    z = false;
                                                                                                    break;
                                                                                                }
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "Unknown param type. event, param";
                                                                                            } else {
                                                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                                                                    zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                                                                } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "No filter for String param. event, param";
                                                                                                } else {
                                                                                                    str3 = (String) obj2;
                                                                                                    if (zzka.zzck(str3)) {
                                                                                                        zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                    } else {
                                                                                                        zzip = zzge().zzip();
                                                                                                        str6 = "Invalid param value for number filter. event, param";
                                                                                                    }
                                                                                                }
                                                                                                if (zza == null) {
                                                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                        z = false;
                                                                                                        break;
                                                                                                    }
                                                                                                    i++;
                                                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                    intValue = i11;
                                                                                                }
                                                                                            }
                                                                                            zzbj = zzga().zzbj(str7);
                                                                                            zzbk = zzga().zzbk(str5);
                                                                                            zzip.zze(str6, zzbj, zzbk);
                                                                                        }
                                                                                        zza2 = null;
                                                                                    }
                                                                                    z = true;
                                                                                    zza2 = Boolean.valueOf(z);
                                                                                    if (zza2 != null) {
                                                                                    }
                                                                                    zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                    if (zza2 != null) {
                                                                                        bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                        if (zza2.booleanValue()) {
                                                                                            bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                        }
                                                                                    } else {
                                                                                        hashSet3.add(Integer.valueOf(intValue2));
                                                                                    }
                                                                                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                    map2 = map7;
                                                                                    map3 = map8;
                                                                                    it6 = it2;
                                                                                    it = it3;
                                                                                    map6 = map9;
                                                                                    map5 = map10;
                                                                                    map4 = map11;
                                                                                    j = j2;
                                                                                }
                                                                            }
                                                                        }
                                                                        j2 = j;
                                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                        zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                        map2 = map7;
                                                                        map3 = map8;
                                                                        it6 = it2;
                                                                        it = it3;
                                                                        map6 = map9;
                                                                        map5 = map10;
                                                                        map4 = map11;
                                                                        j = j2;
                                                                    }
                                                                    hashSet = hashSet3;
                                                                    map17 = map4;
                                                                    map16 = map6;
                                                                    map18 = map5;
                                                                }
                                                            }
                                                            arrayMap2 = map2;
                                                            map10 = map18;
                                                            map9 = map16;
                                                            hashSet3 = hashSet;
                                                            map11 = map17;
                                                            com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                                                            l2 = l;
                                                            j3 = j4;
                                                            i8 = i3 + 1;
                                                            com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                                                            str5 = str2;
                                                            hashSet2 = hashSet3;
                                                            length = i4;
                                                            arrayMap6 = arrayMap2;
                                                            arrayMap5 = map9;
                                                            map = map10;
                                                            arrayMap3 = map11;
                                                        }
                                                    } catch (SQLiteException e3) {
                                                        e = e3;
                                                        i3 = 0;
                                                        zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                                        i13 = i2;
                                                        arrayMap = arrayMap6;
                                                        i9 = i8;
                                                        i4 = i12;
                                                        com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                                        com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                                        com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                                        i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                                        i5 = i3;
                                                        i14 = i5;
                                                        while (i5 < i2) {
                                                            com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                                            zzgb();
                                                            if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                                                i13 = i14 + 1;
                                                                com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                                                i14 = i13;
                                                            }
                                                            i5++;
                                                        }
                                                        if (i14 > 0) {
                                                            zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                                            com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                            str7 = str8;
                                                            com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                                        } else {
                                                            intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                            i2 = i3;
                                                            while (i2 < intValue) {
                                                                i = i14 + 1;
                                                                com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                                                i2++;
                                                                i14 = i;
                                                            }
                                                            if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                                                com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                                            }
                                                            com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                            com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                                            str7 = str8;
                                                        }
                                                        j5 = 0;
                                                        zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                                                        if (zzf != null) {
                                                            zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                                                            i6 = i3;
                                                            map16 = arrayMap5;
                                                            map18 = map;
                                                            hashSet = hashSet2;
                                                            map17 = arrayMap3;
                                                            j6 = j5;
                                                            i3 = i9;
                                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                            zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                                                        } else {
                                                            map16 = arrayMap5;
                                                            hashSet = hashSet2;
                                                            map17 = arrayMap3;
                                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                            map18 = map;
                                                            j6 = j5;
                                                            i3 = i9;
                                                            zzf = zzf.zzie();
                                                        }
                                                        zzix().zza(zzf);
                                                        j = zzf.zzafr;
                                                        map2 = arrayMap;
                                                        map3 = (Map) map2.get(str7);
                                                        if (map3 != null) {
                                                            str2 = str;
                                                            map3 = zzix().zzk(str2, str7);
                                                            if (map3 == null) {
                                                                map3 = new ArrayMap();
                                                            }
                                                            map2.put(str7, map3);
                                                        } else {
                                                            str2 = str;
                                                        }
                                                        it6 = map3.keySet().iterator();
                                                        while (it6.hasNext()) {
                                                            intValue2 = ((Integer) it6.next()).intValue();
                                                            hashSet3 = hashSet;
                                                            if (hashSet3.contains(Integer.valueOf(intValue2))) {
                                                                zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                                hashSet = hashSet3;
                                                            } else {
                                                                map4 = map17;
                                                                map5 = map18;
                                                                bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                                                                map6 = map16;
                                                                bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                                                                if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                                                                    com_google_android_gms_internal_measurement_zzkm = new zzkm();
                                                                    map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                                                                    com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                                                                    bitSet2 = new BitSet();
                                                                    map5.put(Integer.valueOf(intValue2), bitSet2);
                                                                    bitSet5 = new BitSet();
                                                                    map6.put(Integer.valueOf(intValue2), bitSet5);
                                                                    bitSet = bitSet2;
                                                                }
                                                                it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                                                                while (it.hasNext()) {
                                                                    map7 = map2;
                                                                    com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                                                                    map8 = map3;
                                                                    it2 = it6;
                                                                    if (zzge().isLoggable(2)) {
                                                                        it3 = it;
                                                                        map9 = map6;
                                                                        map10 = map5;
                                                                        map11 = map4;
                                                                        zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                                                        zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                                                                    } else {
                                                                        it3 = it;
                                                                        map11 = map4;
                                                                        map10 = map5;
                                                                        map9 = map6;
                                                                    }
                                                                    if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                                                        if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                                                            if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                                                                zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                                                                map2 = map7;
                                                                                map3 = map8;
                                                                                it6 = it2;
                                                                                it = it3;
                                                                                map6 = map9;
                                                                                map5 = map10;
                                                                                map4 = map11;
                                                                            } else {
                                                                                if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                                                                    zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                                                                    if (zza2 != null) {
                                                                                        if (zza2.booleanValue()) {
                                                                                            j2 = j;
                                                                                            zza2 = Boolean.valueOf(false);
                                                                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                            if (zza2 != null) {
                                                                                            }
                                                                                            zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                            if (zza2 != null) {
                                                                                                hashSet3.add(Integer.valueOf(intValue2));
                                                                                            } else {
                                                                                                bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                                if (zza2.booleanValue()) {
                                                                                                    bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                                }
                                                                                            }
                                                                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                            map2 = map7;
                                                                                            map3 = map8;
                                                                                            it6 = it2;
                                                                                            it = it3;
                                                                                            map6 = map9;
                                                                                            map5 = map10;
                                                                                            map4 = map11;
                                                                                            j = j2;
                                                                                        }
                                                                                    }
                                                                                    j2 = j;
                                                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                    zza2 = null;
                                                                                    if (zza2 != null) {
                                                                                    }
                                                                                    zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                    if (zza2 != null) {
                                                                                        bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                        if (zza2.booleanValue()) {
                                                                                            bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                        }
                                                                                    } else {
                                                                                        hashSet3.add(Integer.valueOf(intValue2));
                                                                                    }
                                                                                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                    map2 = map7;
                                                                                    map3 = map8;
                                                                                    it6 = it2;
                                                                                    it = it3;
                                                                                    map6 = map9;
                                                                                    map5 = map10;
                                                                                    map4 = map11;
                                                                                    j = j2;
                                                                                }
                                                                                hashSet4 = new HashSet();
                                                                                for (i7 = 0; i7 < i8; i7++) {
                                                                                    if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                                                        zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                                                        j2 = j;
                                                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                        break;
                                                                                    }
                                                                                    hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                                                                }
                                                                                map3 = new ArrayMap();
                                                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                                                i10 = 0;
                                                                                while (i10 < i) {
                                                                                    com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                                                                    j2 = j;
                                                                                    if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                                                        if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                                                            if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                                                                if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "Unknown value for param. event, param";
                                                                                                    zzbj = zzga().zzbj(str7);
                                                                                                    zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                                                                    break;
                                                                                                }
                                                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                                obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                                                            } else {
                                                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                                obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                                                            }
                                                                                        } else {
                                                                                            obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                            obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                                                        }
                                                                                        map3.put(obj2, obj);
                                                                                    }
                                                                                    i10++;
                                                                                    j = j2;
                                                                                }
                                                                                j2 = j;
                                                                                com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                                                                intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                                                                i = 0;
                                                                                while (i < intValue) {
                                                                                    com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                                                                    equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                                                                    str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                                                                    if (TextUtils.isEmpty(str5)) {
                                                                                        zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                                                                    } else {
                                                                                        com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                                                        obj2 = map3.get(str5);
                                                                                        i11 = intValue;
                                                                                        if (obj2 instanceof Long) {
                                                                                            if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "No number filter for long param. event, param";
                                                                                            } else {
                                                                                                zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                if (zza == null) {
                                                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                        z = false;
                                                                                                        break;
                                                                                                    }
                                                                                                    i++;
                                                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                    intValue = i11;
                                                                                                }
                                                                                            }
                                                                                        } else if (obj2 instanceof Double) {
                                                                                            if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "No number filter for double param. event, param";
                                                                                            } else {
                                                                                                zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                if (zza == null) {
                                                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                        z = false;
                                                                                                        break;
                                                                                                    }
                                                                                                    i++;
                                                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                    intValue = i11;
                                                                                                }
                                                                                            }
                                                                                        } else if (!(obj2 instanceof String)) {
                                                                                            if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                                                                zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                                                            } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                                                                str3 = (String) obj2;
                                                                                                if (zzka.zzck(str3)) {
                                                                                                    zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                } else {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "Invalid param value for number filter. event, param";
                                                                                                }
                                                                                            } else {
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "No filter for String param. event, param";
                                                                                            }
                                                                                            if (zza == null) {
                                                                                                if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                    z = false;
                                                                                                    break;
                                                                                                }
                                                                                                i++;
                                                                                                com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                intValue = i11;
                                                                                            }
                                                                                        } else if (obj2 == null) {
                                                                                            zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                                                            z = false;
                                                                                            break;
                                                                                        } else {
                                                                                            zzip = zzge().zzip();
                                                                                            str6 = "Unknown param type. event, param";
                                                                                        }
                                                                                        zzbj = zzga().zzbj(str7);
                                                                                        zzbk = zzga().zzbk(str5);
                                                                                        zzip.zze(str6, zzbj, zzbk);
                                                                                    }
                                                                                    zza2 = null;
                                                                                }
                                                                                z = true;
                                                                                zza2 = Boolean.valueOf(z);
                                                                                if (zza2 != null) {
                                                                                }
                                                                                zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                if (zza2 != null) {
                                                                                    hashSet3.add(Integer.valueOf(intValue2));
                                                                                } else {
                                                                                    bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                    if (zza2.booleanValue()) {
                                                                                        bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                    }
                                                                                }
                                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                map2 = map7;
                                                                                map3 = map8;
                                                                                it6 = it2;
                                                                                it = it3;
                                                                                map6 = map9;
                                                                                map5 = map10;
                                                                                map4 = map11;
                                                                                j = j2;
                                                                            }
                                                                        }
                                                                    }
                                                                    j2 = j;
                                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                    zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                                                                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                    map2 = map7;
                                                                    map3 = map8;
                                                                    it6 = it2;
                                                                    it = it3;
                                                                    map6 = map9;
                                                                    map5 = map10;
                                                                    map4 = map11;
                                                                    j = j2;
                                                                }
                                                                hashSet = hashSet3;
                                                                map17 = map4;
                                                                map16 = map6;
                                                                map18 = map5;
                                                            }
                                                        }
                                                        arrayMap2 = map2;
                                                        map10 = map18;
                                                        map9 = map16;
                                                        hashSet3 = hashSet;
                                                        map11 = map17;
                                                        com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                                                        l2 = l;
                                                        j3 = j4;
                                                        i8 = i3 + 1;
                                                        com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                                                        str5 = str2;
                                                        hashSet2 = hashSet3;
                                                        length = i4;
                                                        arrayMap6 = arrayMap2;
                                                        arrayMap5 = map9;
                                                        map = map10;
                                                        arrayMap3 = map11;
                                                    }
                                                } catch (SQLiteException e4) {
                                                    e = e4;
                                                    com_google_android_gms_internal_measurement_zzkn = com_google_android_gms_internal_measurement_zzkn5;
                                                    i2 = 1;
                                                    i3 = 0;
                                                    zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                                    i13 = i2;
                                                    arrayMap = arrayMap6;
                                                    i9 = i8;
                                                    i4 = i12;
                                                    com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                                    com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                                    com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                                    i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                                    i5 = i3;
                                                    i14 = i5;
                                                    while (i5 < i2) {
                                                        com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                                        zzgb();
                                                        if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                                            i13 = i14 + 1;
                                                            com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                                            i14 = i13;
                                                        }
                                                        i5++;
                                                    }
                                                    if (i14 > 0) {
                                                        intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                        i2 = i3;
                                                        while (i2 < intValue) {
                                                            i = i14 + 1;
                                                            com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                                            i2++;
                                                            i14 = i;
                                                        }
                                                        if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                                            com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                                        }
                                                        com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                        com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                                        str7 = str8;
                                                    } else {
                                                        zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                                        com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                        str7 = str8;
                                                        com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                                    }
                                                    j5 = 0;
                                                    zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                                                    if (zzf != null) {
                                                        map16 = arrayMap5;
                                                        hashSet = hashSet2;
                                                        map17 = arrayMap3;
                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                        map18 = map;
                                                        j6 = j5;
                                                        i3 = i9;
                                                        zzf = zzf.zzie();
                                                    } else {
                                                        zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                                                        i6 = i3;
                                                        map16 = arrayMap5;
                                                        map18 = map;
                                                        hashSet = hashSet2;
                                                        map17 = arrayMap3;
                                                        j6 = j5;
                                                        i3 = i9;
                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                                        zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                                                    }
                                                    zzix().zza(zzf);
                                                    j = zzf.zzafr;
                                                    map2 = arrayMap;
                                                    map3 = (Map) map2.get(str7);
                                                    if (map3 != null) {
                                                        str2 = str;
                                                    } else {
                                                        str2 = str;
                                                        map3 = zzix().zzk(str2, str7);
                                                        if (map3 == null) {
                                                            map3 = new ArrayMap();
                                                        }
                                                        map2.put(str7, map3);
                                                    }
                                                    it6 = map3.keySet().iterator();
                                                    while (it6.hasNext()) {
                                                        intValue2 = ((Integer) it6.next()).intValue();
                                                        hashSet3 = hashSet;
                                                        if (hashSet3.contains(Integer.valueOf(intValue2))) {
                                                            map4 = map17;
                                                            map5 = map18;
                                                            bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                                                            map6 = map16;
                                                            bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                                                            if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                                                                com_google_android_gms_internal_measurement_zzkm = new zzkm();
                                                                map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                                                                com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                                                                bitSet2 = new BitSet();
                                                                map5.put(Integer.valueOf(intValue2), bitSet2);
                                                                bitSet5 = new BitSet();
                                                                map6.put(Integer.valueOf(intValue2), bitSet5);
                                                                bitSet = bitSet2;
                                                            }
                                                            it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                                                            while (it.hasNext()) {
                                                                map7 = map2;
                                                                com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                                                                map8 = map3;
                                                                it2 = it6;
                                                                if (zzge().isLoggable(2)) {
                                                                    it3 = it;
                                                                    map11 = map4;
                                                                    map10 = map5;
                                                                    map9 = map6;
                                                                } else {
                                                                    it3 = it;
                                                                    map9 = map6;
                                                                    map10 = map5;
                                                                    map11 = map4;
                                                                    zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                                                    zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                                                                }
                                                                if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                                                    if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                                                        if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                                                            if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                                                                zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                                                                if (zza2 != null) {
                                                                                    if (zza2.booleanValue()) {
                                                                                        j2 = j;
                                                                                        zza2 = Boolean.valueOf(false);
                                                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                        if (zza2 != null) {
                                                                                        }
                                                                                        zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                        if (zza2 != null) {
                                                                                            bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                            if (zza2.booleanValue()) {
                                                                                                bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                            }
                                                                                        } else {
                                                                                            hashSet3.add(Integer.valueOf(intValue2));
                                                                                        }
                                                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                        map2 = map7;
                                                                                        map3 = map8;
                                                                                        it6 = it2;
                                                                                        it = it3;
                                                                                        map6 = map9;
                                                                                        map5 = map10;
                                                                                        map4 = map11;
                                                                                        j = j2;
                                                                                    }
                                                                                }
                                                                                j2 = j;
                                                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                zza2 = null;
                                                                                if (zza2 != null) {
                                                                                }
                                                                                zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                                if (zza2 != null) {
                                                                                    hashSet3.add(Integer.valueOf(intValue2));
                                                                                } else {
                                                                                    bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                    if (zza2.booleanValue()) {
                                                                                        bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                    }
                                                                                }
                                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                                map2 = map7;
                                                                                map3 = map8;
                                                                                it6 = it2;
                                                                                it = it3;
                                                                                map6 = map9;
                                                                                map5 = map10;
                                                                                map4 = map11;
                                                                                j = j2;
                                                                            }
                                                                            hashSet4 = new HashSet();
                                                                            for (i7 = 0; i7 < i8; i7++) {
                                                                                if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                                                    zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                                                    j2 = j;
                                                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                                    break;
                                                                                }
                                                                                hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                                                            }
                                                                            map3 = new ArrayMap();
                                                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                            i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                                            i10 = 0;
                                                                            while (i10 < i) {
                                                                                com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                                                                j2 = j;
                                                                                if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                                                    if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                        obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                                                    } else if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                        obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                                                    } else if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                                                        zzip = zzge().zzip();
                                                                                        str6 = "Unknown value for param. event, param";
                                                                                        zzbj = zzga().zzbj(str7);
                                                                                        zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                                                        break;
                                                                                    } else {
                                                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                                        obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                                                    }
                                                                                    map3.put(obj2, obj);
                                                                                }
                                                                                i10++;
                                                                                j = j2;
                                                                            }
                                                                            j2 = j;
                                                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                                                            intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                                                            i = 0;
                                                                            while (i < intValue) {
                                                                                com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                                                                equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                                                                str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                                                                if (TextUtils.isEmpty(str5)) {
                                                                                    com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                                                    obj2 = map3.get(str5);
                                                                                    i11 = intValue;
                                                                                    if (obj2 instanceof Long) {
                                                                                        if (obj2 instanceof Double) {
                                                                                            if (!(obj2 instanceof String)) {
                                                                                                if (obj2 == null) {
                                                                                                    zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                                                                    z = false;
                                                                                                    break;
                                                                                                }
                                                                                                zzip = zzge().zzip();
                                                                                                str6 = "Unknown param type. event, param";
                                                                                            } else {
                                                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                                                                    zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                                                                } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                                                                    zzip = zzge().zzip();
                                                                                                    str6 = "No filter for String param. event, param";
                                                                                                } else {
                                                                                                    str3 = (String) obj2;
                                                                                                    if (zzka.zzck(str3)) {
                                                                                                        zzip = zzge().zzip();
                                                                                                        str6 = "Invalid param value for number filter. event, param";
                                                                                                    } else {
                                                                                                        zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                                    }
                                                                                                }
                                                                                                if (zza == null) {
                                                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                        z = false;
                                                                                                        break;
                                                                                                    }
                                                                                                    i++;
                                                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                    intValue = i11;
                                                                                                }
                                                                                            }
                                                                                        } else if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                            zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                            if (zza == null) {
                                                                                                if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                    z = false;
                                                                                                    break;
                                                                                                }
                                                                                                i++;
                                                                                                com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                                intValue = i11;
                                                                                            }
                                                                                        } else {
                                                                                            zzip = zzge().zzip();
                                                                                            str6 = "No number filter for double param. event, param";
                                                                                        }
                                                                                    } else if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                                        zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                                        if (zza == null) {
                                                                                            if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                                                z = false;
                                                                                                break;
                                                                                            }
                                                                                            i++;
                                                                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                                            intValue = i11;
                                                                                        }
                                                                                    } else {
                                                                                        zzip = zzge().zzip();
                                                                                        str6 = "No number filter for long param. event, param";
                                                                                    }
                                                                                    zzbj = zzga().zzbj(str7);
                                                                                    zzbk = zzga().zzbk(str5);
                                                                                    zzip.zze(str6, zzbj, zzbk);
                                                                                } else {
                                                                                    zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                                                                }
                                                                                zza2 = null;
                                                                            }
                                                                            z = true;
                                                                            zza2 = Boolean.valueOf(z);
                                                                            if (zza2 != null) {
                                                                            }
                                                                            zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                            if (zza2 != null) {
                                                                                bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                if (zza2.booleanValue()) {
                                                                                    bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                                }
                                                                            } else {
                                                                                hashSet3.add(Integer.valueOf(intValue2));
                                                                            }
                                                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                            map2 = map7;
                                                                            map3 = map8;
                                                                            it6 = it2;
                                                                            it = it3;
                                                                            map6 = map9;
                                                                            map5 = map10;
                                                                            map4 = map11;
                                                                            j = j2;
                                                                        } else {
                                                                            zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                                                            map2 = map7;
                                                                            map3 = map8;
                                                                            it6 = it2;
                                                                            it = it3;
                                                                            map6 = map9;
                                                                            map5 = map10;
                                                                            map4 = map11;
                                                                        }
                                                                    }
                                                                }
                                                                j2 = j;
                                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                map2 = map7;
                                                                map3 = map8;
                                                                it6 = it2;
                                                                it = it3;
                                                                map6 = map9;
                                                                map5 = map10;
                                                                map4 = map11;
                                                                j = j2;
                                                            }
                                                            hashSet = hashSet3;
                                                            map17 = map4;
                                                            map16 = map6;
                                                            map18 = map5;
                                                        } else {
                                                            zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                                                            hashSet = hashSet3;
                                                        }
                                                    }
                                                    arrayMap2 = map2;
                                                    map10 = map18;
                                                    map9 = map16;
                                                    hashSet3 = hashSet;
                                                    map11 = map17;
                                                    com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                                                    l2 = l;
                                                    j3 = j4;
                                                    i8 = i3 + 1;
                                                    com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                                                    str5 = str2;
                                                    hashSet2 = hashSet3;
                                                    length = i4;
                                                    arrayMap6 = arrayMap2;
                                                    arrayMap5 = map9;
                                                    map = map10;
                                                    arrayMap3 = map11;
                                                }
                                                i13 = i2;
                                                arrayMap = arrayMap6;
                                                i9 = i8;
                                                i4 = i12;
                                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                            } else {
                                                i3 = 0;
                                                i4 = i12;
                                                i9 = i8;
                                                j7 = 0;
                                                arrayMap = arrayMap6;
                                                com_google_android_gms_internal_measurement_zzkn7 = com_google_android_gms_internal_measurement_zzkn5;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                                i13 = 1;
                                                zzix().zza(str, l4, j4, com_google_android_gms_internal_measurement_zzkn7);
                                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn7;
                                            }
                                            com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                            com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                            i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                            i5 = i3;
                                            i14 = i5;
                                            while (i5 < i2) {
                                                com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                                zzgb();
                                                if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                                    i13 = i14 + 1;
                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                                    i14 = i13;
                                                }
                                                i5++;
                                            }
                                            if (i14 > 0) {
                                                intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                i2 = i3;
                                                while (i2 < intValue) {
                                                    i = i14 + 1;
                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                                    i2++;
                                                    i14 = i;
                                                }
                                                if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                                    com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                                }
                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                                str7 = str8;
                                            } else {
                                                zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                str7 = str8;
                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                            }
                                            j5 = 0;
                                        }
                                    }
                                    zza3 = zzix().zza(str5, l4);
                                    if (zza3 != null) {
                                        if (zza3.first == null) {
                                            com_google_android_gms_internal_measurement_zzkn3 = (zzkn) zza3.first;
                                            j3 = ((Long) zza3.second).longValue();
                                            zzgb();
                                            com_google_android_gms_internal_measurement_zzkn5 = com_google_android_gms_internal_measurement_zzkn3;
                                            l = (Long) zzka.zzb(com_google_android_gms_internal_measurement_zzkn3, "_eid");
                                            j4 = j3 - 1;
                                            if (j4 > 0) {
                                                i3 = 0;
                                                i4 = i12;
                                                i9 = i8;
                                                j7 = 0;
                                                arrayMap = arrayMap6;
                                                com_google_android_gms_internal_measurement_zzkn7 = com_google_android_gms_internal_measurement_zzkn5;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                                i13 = 1;
                                                zzix().zza(str, l4, j4, com_google_android_gms_internal_measurement_zzkn7);
                                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn7;
                                            } else {
                                                zzix = zzix();
                                                zzix.zzab();
                                                zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str5);
                                                writableDatabase = zzix.getWritableDatabase();
                                                str6 = "delete from main_event_params where app_id=?";
                                                com_google_android_gms_internal_measurement_zzkn = com_google_android_gms_internal_measurement_zzkn5;
                                                i2 = 1;
                                                strArr = new String[1];
                                                i3 = 0;
                                                strArr[0] = str5;
                                                writableDatabase.execSQL(str6, strArr);
                                                i13 = i2;
                                                arrayMap = arrayMap6;
                                                i9 = i8;
                                                i4 = i12;
                                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                            }
                                            com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                            com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                            i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                            i5 = i3;
                                            i14 = i5;
                                            while (i5 < i2) {
                                                com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                                zzgb();
                                                if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                                    i13 = i14 + 1;
                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                                    i14 = i13;
                                                }
                                                i5++;
                                            }
                                            if (i14 > 0) {
                                                zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                str7 = str8;
                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                            } else {
                                                intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                i2 = i3;
                                                while (i2 < intValue) {
                                                    i = i14 + 1;
                                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                                    i2++;
                                                    i14 = i;
                                                }
                                                if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                                    com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                                }
                                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                                str7 = str8;
                                            }
                                            j5 = 0;
                                        }
                                    }
                                    arrayMap = arrayMap6;
                                    i9 = i8;
                                    i4 = i12;
                                    zzge().zzim().zze("Extra parameter without existing main event. eventName, eventId", str8, l4);
                                } else {
                                    zzge().zzim().zzg("Extra parameter without an event name. eventId", l4);
                                    arrayMap = arrayMap6;
                                    i9 = i8;
                                    i4 = i12;
                                }
                                map9 = arrayMap5;
                                hashSet3 = hashSet2;
                                map11 = arrayMap3;
                                str2 = str5;
                                map10 = map;
                                i3 = i9;
                                arrayMap2 = arrayMap;
                                i8 = i3 + 1;
                                com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                                str5 = str2;
                                hashSet2 = hashSet3;
                                length = i4;
                                arrayMap6 = arrayMap2;
                                arrayMap5 = map9;
                                map = map10;
                                arrayMap3 = map11;
                            } else {
                                arrayMap = arrayMap6;
                                i9 = i8;
                                i4 = i12;
                                i3 = 0;
                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                if (obj == null) {
                                    zzgb();
                                    valueOf = Long.valueOf(0);
                                    e = zzka.zzb(com_google_android_gms_internal_measurement_zzkn4, "_epc");
                                    if (e == null) {
                                        e = valueOf;
                                    }
                                    j3 = ((Long) e).longValue();
                                    if (j3 > 0) {
                                        zzge().zzip().zzg("Complex event with zero extra param count. eventName", str8);
                                        l3 = l4;
                                        j5 = 0;
                                    } else {
                                        l3 = l4;
                                        j5 = 0;
                                        zzix().zza(str, l4, j3, com_google_android_gms_internal_measurement_zzkn4);
                                    }
                                    l = l3;
                                    str7 = str8;
                                    com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                    j4 = j3;
                                    com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn4;
                                } else {
                                    j5 = 0;
                                }
                            }
                            zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                            if (zzf != null) {
                                zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                                i6 = i3;
                                map16 = arrayMap5;
                                map18 = map;
                                hashSet = hashSet2;
                                map17 = arrayMap3;
                                j6 = j5;
                                i3 = i9;
                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                            } else {
                                map16 = arrayMap5;
                                hashSet = hashSet2;
                                map17 = arrayMap3;
                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                                map18 = map;
                                j6 = j5;
                                i3 = i9;
                                zzf = zzf.zzie();
                            }
                            zzix().zza(zzf);
                            j = zzf.zzafr;
                            map2 = arrayMap;
                            map3 = (Map) map2.get(str7);
                            if (map3 != null) {
                                str2 = str;
                                map3 = zzix().zzk(str2, str7);
                                if (map3 == null) {
                                    map3 = new ArrayMap();
                                }
                                map2.put(str7, map3);
                            } else {
                                str2 = str;
                            }
                            it6 = map3.keySet().iterator();
                            while (it6.hasNext()) {
                                intValue2 = ((Integer) it6.next()).intValue();
                                hashSet3 = hashSet;
                                if (hashSet3.contains(Integer.valueOf(intValue2))) {
                                    zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                                    hashSet = hashSet3;
                                } else {
                                    map4 = map17;
                                    map5 = map18;
                                    bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                                    map6 = map16;
                                    bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                                    if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                                        com_google_android_gms_internal_measurement_zzkm = new zzkm();
                                        map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                                        com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                                        bitSet2 = new BitSet();
                                        map5.put(Integer.valueOf(intValue2), bitSet2);
                                        bitSet5 = new BitSet();
                                        map6.put(Integer.valueOf(intValue2), bitSet5);
                                        bitSet = bitSet2;
                                    }
                                    it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                                    while (it.hasNext()) {
                                        map7 = map2;
                                        com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                                        map8 = map3;
                                        it2 = it6;
                                        if (zzge().isLoggable(2)) {
                                            it3 = it;
                                            map9 = map6;
                                            map10 = map5;
                                            map11 = map4;
                                            zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                            zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                                        } else {
                                            it3 = it;
                                            map11 = map4;
                                            map10 = map5;
                                            map9 = map6;
                                        }
                                        if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                            if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                                if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                                    zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                                    map2 = map7;
                                                    map3 = map8;
                                                    it6 = it2;
                                                    it = it3;
                                                    map6 = map9;
                                                    map5 = map10;
                                                    map4 = map11;
                                                } else {
                                                    if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                                        zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                                        if (zza2 != null) {
                                                            if (zza2.booleanValue()) {
                                                                j2 = j;
                                                                zza2 = Boolean.valueOf(false);
                                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                                if (zza2 != null) {
                                                                }
                                                                zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                                if (zza2 != null) {
                                                                    hashSet3.add(Integer.valueOf(intValue2));
                                                                } else {
                                                                    bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                    if (zza2.booleanValue()) {
                                                                        bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                                    }
                                                                }
                                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                                map2 = map7;
                                                                map3 = map8;
                                                                it6 = it2;
                                                                it = it3;
                                                                map6 = map9;
                                                                map5 = map10;
                                                                map4 = map11;
                                                                j = j2;
                                                            }
                                                        }
                                                        j2 = j;
                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                        zza2 = null;
                                                        if (zza2 != null) {
                                                        }
                                                        zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                        if (zza2 != null) {
                                                            bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                            if (zza2.booleanValue()) {
                                                                bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                            }
                                                        } else {
                                                            hashSet3.add(Integer.valueOf(intValue2));
                                                        }
                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                        map2 = map7;
                                                        map3 = map8;
                                                        it6 = it2;
                                                        it = it3;
                                                        map6 = map9;
                                                        map5 = map10;
                                                        map4 = map11;
                                                        j = j2;
                                                    }
                                                    hashSet4 = new HashSet();
                                                    for (i7 = 0; i7 < i8; i7++) {
                                                        if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                            zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                            j2 = j;
                                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                            break;
                                                        }
                                                        hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                                    }
                                                    map3 = new ArrayMap();
                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                    i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                                    i10 = 0;
                                                    while (i10 < i) {
                                                        com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                                        j2 = j;
                                                        if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                            if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                                if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                                    if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                                        zzip = zzge().zzip();
                                                                        str6 = "Unknown value for param. event, param";
                                                                        zzbj = zzga().zzbj(str7);
                                                                        zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                                        break;
                                                                    }
                                                                    obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                    obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                                } else {
                                                                    obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                    obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                                }
                                                            } else {
                                                                obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                                obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                            }
                                                            map3.put(obj2, obj);
                                                        }
                                                        i10++;
                                                        j = j2;
                                                    }
                                                    j2 = j;
                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                                    intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                                    i = 0;
                                                    while (i < intValue) {
                                                        com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                                        equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                                        str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                                        if (TextUtils.isEmpty(str5)) {
                                                            zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                                        } else {
                                                            com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                            obj2 = map3.get(str5);
                                                            i11 = intValue;
                                                            if (obj2 instanceof Long) {
                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                    zzip = zzge().zzip();
                                                                    str6 = "No number filter for long param. event, param";
                                                                } else {
                                                                    zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                    if (zza == null) {
                                                                        if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                            z = false;
                                                                            break;
                                                                        }
                                                                        i++;
                                                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                        intValue = i11;
                                                                    }
                                                                }
                                                            } else if (obj2 instanceof Double) {
                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                                    zzip = zzge().zzip();
                                                                    str6 = "No number filter for double param. event, param";
                                                                } else {
                                                                    zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                    if (zza == null) {
                                                                        if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                            z = false;
                                                                            break;
                                                                        }
                                                                        i++;
                                                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                        intValue = i11;
                                                                    }
                                                                }
                                                            } else if (!(obj2 instanceof String)) {
                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                                    zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                                } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                                    str3 = (String) obj2;
                                                                    if (zzka.zzck(str3)) {
                                                                        zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                    } else {
                                                                        zzip = zzge().zzip();
                                                                        str6 = "Invalid param value for number filter. event, param";
                                                                    }
                                                                } else {
                                                                    zzip = zzge().zzip();
                                                                    str6 = "No filter for String param. event, param";
                                                                }
                                                                if (zza == null) {
                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                        z = false;
                                                                        break;
                                                                    }
                                                                    i++;
                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                    intValue = i11;
                                                                }
                                                            } else if (obj2 == null) {
                                                                zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                                z = false;
                                                                break;
                                                            } else {
                                                                zzip = zzge().zzip();
                                                                str6 = "Unknown param type. event, param";
                                                            }
                                                            zzbj = zzga().zzbj(str7);
                                                            zzbk = zzga().zzbk(str5);
                                                            zzip.zze(str6, zzbj, zzbk);
                                                        }
                                                        zza2 = null;
                                                    }
                                                    z = true;
                                                    zza2 = Boolean.valueOf(z);
                                                    if (zza2 != null) {
                                                    }
                                                    zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                    if (zza2 != null) {
                                                        hashSet3.add(Integer.valueOf(intValue2));
                                                    } else {
                                                        bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                        if (zza2.booleanValue()) {
                                                            bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                        }
                                                    }
                                                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                    map2 = map7;
                                                    map3 = map8;
                                                    it6 = it2;
                                                    it = it3;
                                                    map6 = map9;
                                                    map5 = map10;
                                                    map4 = map11;
                                                    j = j2;
                                                }
                                            }
                                        }
                                        j2 = j;
                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                        zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                        map2 = map7;
                                        map3 = map8;
                                        it6 = it2;
                                        it = it3;
                                        map6 = map9;
                                        map5 = map10;
                                        map4 = map11;
                                        j = j2;
                                    }
                                    hashSet = hashSet3;
                                    map17 = map4;
                                    map16 = map6;
                                    map18 = map5;
                                }
                            }
                            arrayMap2 = map2;
                            map10 = map18;
                            map9 = map16;
                            hashSet3 = hashSet;
                            map11 = map17;
                            com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                            l2 = l;
                            j3 = j4;
                            i8 = i3 + 1;
                            com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                            str5 = str2;
                            hashSet2 = hashSet3;
                            length = i4;
                            arrayMap6 = arrayMap2;
                            arrayMap5 = map9;
                            map = map10;
                            arrayMap3 = map11;
                        }
                    } else {
                        i12 = length;
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        arrayMap = arrayMap6;
                        i9 = i8;
                        i4 = i12;
                        i3 = 0;
                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                        if (obj == null) {
                            j5 = 0;
                        } else {
                            zzgb();
                            valueOf = Long.valueOf(0);
                            e = zzka.zzb(com_google_android_gms_internal_measurement_zzkn4, "_epc");
                            if (e == null) {
                                e = valueOf;
                            }
                            j3 = ((Long) e).longValue();
                            if (j3 > 0) {
                                l3 = l4;
                                j5 = 0;
                                zzix().zza(str, l4, j3, com_google_android_gms_internal_measurement_zzkn4);
                            } else {
                                zzge().zzip().zzg("Complex event with zero extra param count. eventName", str8);
                                l3 = l4;
                                j5 = 0;
                            }
                            l = l3;
                            str7 = str8;
                            com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                            j4 = j3;
                            com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn4;
                        }
                    } else {
                        zzgb();
                        str8 = (String) zzka.zzb(com_google_android_gms_internal_measurement_zzkn4, "_en");
                        if (!TextUtils.isEmpty(str8)) {
                            zzge().zzim().zzg("Extra parameter without an event name. eventId", l4);
                            arrayMap = arrayMap6;
                            i9 = i8;
                            i4 = i12;
                        } else if (l4.longValue() != l2.longValue()) {
                            l = l2;
                            com_google_android_gms_internal_measurement_zzkn5 = com_google_android_gms_internal_measurement_zzkn3;
                            j4 = j3 - 1;
                            if (j4 > 0) {
                                zzix = zzix();
                                zzix.zzab();
                                zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str5);
                                writableDatabase = zzix.getWritableDatabase();
                                str6 = "delete from main_event_params where app_id=?";
                                com_google_android_gms_internal_measurement_zzkn = com_google_android_gms_internal_measurement_zzkn5;
                                i2 = 1;
                                strArr = new String[1];
                                i3 = 0;
                                strArr[0] = str5;
                                writableDatabase.execSQL(str6, strArr);
                                i13 = i2;
                                arrayMap = arrayMap6;
                                i9 = i8;
                                i4 = i12;
                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                            } else {
                                i3 = 0;
                                i4 = i12;
                                i9 = i8;
                                j7 = 0;
                                arrayMap = arrayMap6;
                                com_google_android_gms_internal_measurement_zzkn7 = com_google_android_gms_internal_measurement_zzkn5;
                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                i13 = 1;
                                zzix().zza(str, l4, j4, com_google_android_gms_internal_measurement_zzkn7);
                                com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn7;
                            }
                            com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                            com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                            i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                            i5 = i3;
                            i14 = i5;
                            while (i5 < i2) {
                                com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                zzgb();
                                if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                    i13 = i14 + 1;
                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                    i14 = i13;
                                }
                                i5++;
                            }
                            if (i14 > 0) {
                                intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                i2 = i3;
                                while (i2 < intValue) {
                                    i = i14 + 1;
                                    com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                    i2++;
                                    i14 = i;
                                }
                                if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                    com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                }
                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                str7 = str8;
                            } else {
                                zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                str7 = str8;
                                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                            }
                            j5 = 0;
                        } else {
                            zza3 = zzix().zza(str5, l4);
                            if (zza3 != null) {
                                if (zza3.first == null) {
                                    com_google_android_gms_internal_measurement_zzkn3 = (zzkn) zza3.first;
                                    j3 = ((Long) zza3.second).longValue();
                                    zzgb();
                                    com_google_android_gms_internal_measurement_zzkn5 = com_google_android_gms_internal_measurement_zzkn3;
                                    l = (Long) zzka.zzb(com_google_android_gms_internal_measurement_zzkn3, "_eid");
                                    j4 = j3 - 1;
                                    if (j4 > 0) {
                                        i3 = 0;
                                        i4 = i12;
                                        i9 = i8;
                                        j7 = 0;
                                        arrayMap = arrayMap6;
                                        com_google_android_gms_internal_measurement_zzkn7 = com_google_android_gms_internal_measurement_zzkn5;
                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                        i13 = 1;
                                        zzix().zza(str, l4, j4, com_google_android_gms_internal_measurement_zzkn7);
                                        com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn7;
                                    } else {
                                        zzix = zzix();
                                        zzix.zzab();
                                        zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str5);
                                        writableDatabase = zzix.getWritableDatabase();
                                        str6 = "delete from main_event_params where app_id=?";
                                        com_google_android_gms_internal_measurement_zzkn = com_google_android_gms_internal_measurement_zzkn5;
                                        i2 = 1;
                                        strArr = new String[1];
                                        i3 = 0;
                                        strArr[0] = str5;
                                        writableDatabase.execSQL(str6, strArr);
                                        i13 = i2;
                                        arrayMap = arrayMap6;
                                        i9 = i8;
                                        i4 = i12;
                                        com_google_android_gms_internal_measurement_zzkn6 = com_google_android_gms_internal_measurement_zzkn;
                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                                    }
                                    com_google_android_gms_internal_measurement_zzkoArr5 = new zzko[(com_google_android_gms_internal_measurement_zzkn6.zzata.length + com_google_android_gms_internal_measurement_zzkoArr.length)];
                                    com_google_android_gms_internal_measurement_zzkoArr6 = com_google_android_gms_internal_measurement_zzkn6.zzata;
                                    i2 = com_google_android_gms_internal_measurement_zzkoArr6.length;
                                    i5 = i3;
                                    i14 = i5;
                                    while (i5 < i2) {
                                        com_google_android_gms_internal_measurement_zzko2 = com_google_android_gms_internal_measurement_zzkoArr6[i5];
                                        zzgb();
                                        if (zzka.zza(com_google_android_gms_internal_measurement_zzkn4, com_google_android_gms_internal_measurement_zzko2.name) != null) {
                                            i13 = i14 + 1;
                                            com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzko2;
                                            i14 = i13;
                                        }
                                        i5++;
                                    }
                                    if (i14 > 0) {
                                        zzge().zzip().zzg("No unique parameters in main event. eventName", str8);
                                        com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                        str7 = str8;
                                        com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                                    } else {
                                        intValue = com_google_android_gms_internal_measurement_zzkoArr.length;
                                        i2 = i3;
                                        while (i2 < intValue) {
                                            i = i14 + 1;
                                            com_google_android_gms_internal_measurement_zzkoArr5[i14] = com_google_android_gms_internal_measurement_zzkoArr[i2];
                                            i2++;
                                            i14 = i;
                                        }
                                        if (i14 != com_google_android_gms_internal_measurement_zzkoArr5.length) {
                                            com_google_android_gms_internal_measurement_zzkoArr5 = (zzko[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkoArr5, i14);
                                        }
                                        com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn6;
                                        com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr5;
                                        str7 = str8;
                                    }
                                    j5 = 0;
                                }
                            }
                            arrayMap = arrayMap6;
                            i9 = i8;
                            i4 = i12;
                            zzge().zzim().zze("Extra parameter without existing main event. eventName, eventId", str8, l4);
                        }
                        map9 = arrayMap5;
                        hashSet3 = hashSet2;
                        map11 = arrayMap3;
                        str2 = str5;
                        map10 = map;
                        i3 = i9;
                        arrayMap2 = arrayMap;
                        i8 = i3 + 1;
                        com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                        str5 = str2;
                        hashSet2 = hashSet3;
                        length = i4;
                        arrayMap6 = arrayMap2;
                        arrayMap5 = map9;
                        map = map10;
                        arrayMap3 = map11;
                    }
                    zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                    if (zzf != null) {
                        map16 = arrayMap5;
                        hashSet = hashSet2;
                        map17 = arrayMap3;
                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                        map18 = map;
                        j6 = j5;
                        i3 = i9;
                        zzf = zzf.zzie();
                    } else {
                        zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                        i6 = i3;
                        map16 = arrayMap5;
                        map18 = map;
                        hashSet = hashSet2;
                        map17 = arrayMap3;
                        j6 = j5;
                        i3 = i9;
                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                        zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                    }
                    zzix().zza(zzf);
                    j = zzf.zzafr;
                    map2 = arrayMap;
                    map3 = (Map) map2.get(str7);
                    if (map3 != null) {
                        str2 = str;
                    } else {
                        str2 = str;
                        map3 = zzix().zzk(str2, str7);
                        if (map3 == null) {
                            map3 = new ArrayMap();
                        }
                        map2.put(str7, map3);
                    }
                    it6 = map3.keySet().iterator();
                    while (it6.hasNext()) {
                        intValue2 = ((Integer) it6.next()).intValue();
                        hashSet3 = hashSet;
                        if (hashSet3.contains(Integer.valueOf(intValue2))) {
                            map4 = map17;
                            map5 = map18;
                            bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                            map6 = map16;
                            bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                            if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                                com_google_android_gms_internal_measurement_zzkm = new zzkm();
                                map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                                com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                                bitSet2 = new BitSet();
                                map5.put(Integer.valueOf(intValue2), bitSet2);
                                bitSet5 = new BitSet();
                                map6.put(Integer.valueOf(intValue2), bitSet5);
                                bitSet = bitSet2;
                            }
                            it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                            while (it.hasNext()) {
                                map7 = map2;
                                com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                                map8 = map3;
                                it2 = it6;
                                if (zzge().isLoggable(2)) {
                                    it3 = it;
                                    map11 = map4;
                                    map10 = map5;
                                    map9 = map6;
                                } else {
                                    it3 = it;
                                    map9 = map6;
                                    map10 = map5;
                                    map11 = map4;
                                    zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                    zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                                }
                                if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                    if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                        if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                            if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                                zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                                if (zza2 != null) {
                                                    if (zza2.booleanValue()) {
                                                        j2 = j;
                                                        zza2 = Boolean.valueOf(false);
                                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                        if (zza2 != null) {
                                                        }
                                                        zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                        if (zza2 != null) {
                                                            bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                            if (zza2.booleanValue()) {
                                                                bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                            }
                                                        } else {
                                                            hashSet3.add(Integer.valueOf(intValue2));
                                                        }
                                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                        map2 = map7;
                                                        map3 = map8;
                                                        it6 = it2;
                                                        it = it3;
                                                        map6 = map9;
                                                        map5 = map10;
                                                        map4 = map11;
                                                        j = j2;
                                                    }
                                                }
                                                j2 = j;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                zza2 = null;
                                                if (zza2 != null) {
                                                }
                                                zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                if (zza2 != null) {
                                                    hashSet3.add(Integer.valueOf(intValue2));
                                                } else {
                                                    bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                    if (zza2.booleanValue()) {
                                                        bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                    }
                                                }
                                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                map2 = map7;
                                                map3 = map8;
                                                it6 = it2;
                                                it = it3;
                                                map6 = map9;
                                                map5 = map10;
                                                map4 = map11;
                                                j = j2;
                                            }
                                            hashSet4 = new HashSet();
                                            for (i7 = 0; i7 < i8; i7++) {
                                                if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                    zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                    j2 = j;
                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                    break;
                                                }
                                                hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                            }
                                            map3 = new ArrayMap();
                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                            i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                            i10 = 0;
                                            while (i10 < i) {
                                                com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                                j2 = j;
                                                if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                    if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                        obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                    } else if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                        obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                    } else if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                        zzip = zzge().zzip();
                                                        str6 = "Unknown value for param. event, param";
                                                        zzbj = zzga().zzbj(str7);
                                                        zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                        break;
                                                    } else {
                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                        obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                    }
                                                    map3.put(obj2, obj);
                                                }
                                                i10++;
                                                j = j2;
                                            }
                                            j2 = j;
                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                            intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                            i = 0;
                                            while (i < intValue) {
                                                com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                                equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                                str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                                if (TextUtils.isEmpty(str5)) {
                                                    com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                    obj2 = map3.get(str5);
                                                    i11 = intValue;
                                                    if (obj2 instanceof Long) {
                                                        if (obj2 instanceof Double) {
                                                            if (!(obj2 instanceof String)) {
                                                                if (obj2 == null) {
                                                                    zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                                    z = false;
                                                                    break;
                                                                }
                                                                zzip = zzge().zzip();
                                                                str6 = "Unknown param type. event, param";
                                                            } else {
                                                                if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                                    zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                                } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                                    zzip = zzge().zzip();
                                                                    str6 = "No filter for String param. event, param";
                                                                } else {
                                                                    str3 = (String) obj2;
                                                                    if (zzka.zzck(str3)) {
                                                                        zzip = zzge().zzip();
                                                                        str6 = "Invalid param value for number filter. event, param";
                                                                    } else {
                                                                        zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                                    }
                                                                }
                                                                if (zza == null) {
                                                                    if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                        z = false;
                                                                        break;
                                                                    }
                                                                    i++;
                                                                    com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                    intValue = i11;
                                                                }
                                                            }
                                                        } else if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                            zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                            if (zza == null) {
                                                                if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                    z = false;
                                                                    break;
                                                                }
                                                                i++;
                                                                com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                                intValue = i11;
                                                            }
                                                        } else {
                                                            zzip = zzge().zzip();
                                                            str6 = "No number filter for double param. event, param";
                                                        }
                                                    } else if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                        zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                        if (zza == null) {
                                                            if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                z = false;
                                                                break;
                                                            }
                                                            i++;
                                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                            intValue = i11;
                                                        }
                                                    } else {
                                                        zzip = zzge().zzip();
                                                        str6 = "No number filter for long param. event, param";
                                                    }
                                                    zzbj = zzga().zzbj(str7);
                                                    zzbk = zzga().zzbk(str5);
                                                    zzip.zze(str6, zzbj, zzbk);
                                                } else {
                                                    zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                                }
                                                zza2 = null;
                                            }
                                            z = true;
                                            zza2 = Boolean.valueOf(z);
                                            if (zza2 != null) {
                                            }
                                            zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                            if (zza2 != null) {
                                                bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                if (zza2.booleanValue()) {
                                                    bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                }
                                            } else {
                                                hashSet3.add(Integer.valueOf(intValue2));
                                            }
                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                            map2 = map7;
                                            map3 = map8;
                                            it6 = it2;
                                            it = it3;
                                            map6 = map9;
                                            map5 = map10;
                                            map4 = map11;
                                            j = j2;
                                        } else {
                                            zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                            map2 = map7;
                                            map3 = map8;
                                            it6 = it2;
                                            it = it3;
                                            map6 = map9;
                                            map5 = map10;
                                            map4 = map11;
                                        }
                                    }
                                }
                                j2 = j;
                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                                com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                map2 = map7;
                                map3 = map8;
                                it6 = it2;
                                it = it3;
                                map6 = map9;
                                map5 = map10;
                                map4 = map11;
                                j = j2;
                            }
                            hashSet = hashSet3;
                            map17 = map4;
                            map16 = map6;
                            map18 = map5;
                        } else {
                            zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                            hashSet = hashSet3;
                        }
                    }
                    arrayMap2 = map2;
                    map10 = map18;
                    map9 = map16;
                    hashSet3 = hashSet;
                    map11 = map17;
                    com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                    l2 = l;
                    j3 = j4;
                    i8 = i3 + 1;
                    com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                    str5 = str2;
                    hashSet2 = hashSet3;
                    length = i4;
                    arrayMap6 = arrayMap2;
                    arrayMap5 = map9;
                    map = map10;
                    arrayMap3 = map11;
                } else {
                    i4 = length;
                    arrayMap = arrayMap6;
                    i9 = i8;
                    i3 = 0;
                    j5 = 0;
                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr4;
                }
                l = l2;
                com_google_android_gms_internal_measurement_zzkoArr3 = com_google_android_gms_internal_measurement_zzkoArr;
                j4 = j3;
                com_google_android_gms_internal_measurement_zzkn2 = com_google_android_gms_internal_measurement_zzkn3;
                str7 = str8;
                zzf = zzix().zzf(str5, com_google_android_gms_internal_measurement_zzkn4.name);
                if (zzf != null) {
                    zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str7));
                    i6 = i3;
                    map16 = arrayMap5;
                    map18 = map;
                    hashSet = hashSet2;
                    map17 = arrayMap3;
                    j6 = j5;
                    i3 = i9;
                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                    zzf = new zzeq(str, com_google_android_gms_internal_measurement_zzkn4.name, 1, 1, com_google_android_gms_internal_measurement_zzkn4.zzatb.longValue(), 0, null, null, null);
                } else {
                    map16 = arrayMap5;
                    hashSet = hashSet2;
                    map17 = arrayMap3;
                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr3;
                    map18 = map;
                    j6 = j5;
                    i3 = i9;
                    zzf = zzf.zzie();
                }
                zzix().zza(zzf);
                j = zzf.zzafr;
                map2 = arrayMap;
                map3 = (Map) map2.get(str7);
                if (map3 != null) {
                    str2 = str;
                    map3 = zzix().zzk(str2, str7);
                    if (map3 == null) {
                        map3 = new ArrayMap();
                    }
                    map2.put(str7, map3);
                } else {
                    str2 = str;
                }
                it6 = map3.keySet().iterator();
                while (it6.hasNext()) {
                    intValue2 = ((Integer) it6.next()).intValue();
                    hashSet3 = hashSet;
                    if (hashSet3.contains(Integer.valueOf(intValue2))) {
                        zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(intValue2));
                        hashSet = hashSet3;
                    } else {
                        map4 = map17;
                        map5 = map18;
                        bitSet = (BitSet) map5.get(Integer.valueOf(intValue2));
                        map6 = map16;
                        bitSet5 = (BitSet) map6.get(Integer.valueOf(intValue2));
                        if (((zzkm) map4.get(Integer.valueOf(intValue2))) == null) {
                            com_google_android_gms_internal_measurement_zzkm = new zzkm();
                            map4.put(Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzkm);
                            com_google_android_gms_internal_measurement_zzkm.zzasy = Boolean.valueOf(true);
                            bitSet2 = new BitSet();
                            map5.put(Integer.valueOf(intValue2), bitSet2);
                            bitSet5 = new BitSet();
                            map6.put(Integer.valueOf(intValue2), bitSet5);
                            bitSet = bitSet2;
                        }
                        it = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                        while (it.hasNext()) {
                            map7 = map2;
                            com_google_android_gms_internal_measurement_zzke = (zzke) it.next();
                            map8 = map3;
                            it2 = it6;
                            if (zzge().isLoggable(2)) {
                                it3 = it;
                                map9 = map6;
                                map10 = map5;
                                map11 = map4;
                                zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp, zzga().zzbj(com_google_android_gms_internal_measurement_zzke.zzarq));
                                zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzke));
                            } else {
                                it3 = it;
                                map11 = map4;
                                map10 = map5;
                                map9 = map6;
                            }
                            if (com_google_android_gms_internal_measurement_zzke.zzarp != null) {
                                if (com_google_android_gms_internal_measurement_zzke.zzarp.intValue() > 256) {
                                    if (bitSet.get(com_google_android_gms_internal_measurement_zzke.zzarp.intValue())) {
                                        zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), com_google_android_gms_internal_measurement_zzke.zzarp);
                                        map2 = map7;
                                        map3 = map8;
                                        it6 = it2;
                                        it = it3;
                                        map6 = map9;
                                        map5 = map10;
                                        map4 = map11;
                                    } else {
                                        if (com_google_android_gms_internal_measurement_zzke.zzart != null) {
                                            zza2 = zza(j, com_google_android_gms_internal_measurement_zzke.zzart);
                                            if (zza2 != null) {
                                                if (zza2.booleanValue()) {
                                                    j2 = j;
                                                    zza2 = Boolean.valueOf(false);
                                                    com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                    if (zza2 != null) {
                                                    }
                                                    zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                                    if (zza2 != null) {
                                                        hashSet3.add(Integer.valueOf(intValue2));
                                                    } else {
                                                        bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                        if (zza2.booleanValue()) {
                                                            bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                        }
                                                    }
                                                    com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                                    map2 = map7;
                                                    map3 = map8;
                                                    it6 = it2;
                                                    it = it3;
                                                    map6 = map9;
                                                    map5 = map10;
                                                    map4 = map11;
                                                    j = j2;
                                                }
                                            }
                                            j2 = j;
                                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                            zza2 = null;
                                            if (zza2 != null) {
                                            }
                                            zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                            if (zza2 != null) {
                                                bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                if (zza2.booleanValue()) {
                                                    bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                                }
                                            } else {
                                                hashSet3.add(Integer.valueOf(intValue2));
                                            }
                                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                            map2 = map7;
                                            map3 = map8;
                                            it6 = it2;
                                            it = it3;
                                            map6 = map9;
                                            map5 = map10;
                                            map4 = map11;
                                            j = j2;
                                        }
                                        hashSet4 = new HashSet();
                                        for (i7 = 0; i7 < i8; i7++) {
                                            if (TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzkf2.zzary)) {
                                                zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str7));
                                                j2 = j;
                                                com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                                break;
                                            }
                                            hashSet4.add(com_google_android_gms_internal_measurement_zzkf2.zzary);
                                        }
                                        map3 = new ArrayMap();
                                        com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                                        i = com_google_android_gms_internal_measurement_zzkoArr.length;
                                        i10 = 0;
                                        while (i10 < i) {
                                            com_google_android_gms_internal_measurement_zzko = com_google_android_gms_internal_measurement_zzkoArr[i10];
                                            j2 = j;
                                            if (!hashSet4.contains(com_google_android_gms_internal_measurement_zzko.name)) {
                                                if (com_google_android_gms_internal_measurement_zzko.zzate == null) {
                                                    if (com_google_android_gms_internal_measurement_zzko.zzarc == null) {
                                                        if (com_google_android_gms_internal_measurement_zzko.zzajf != null) {
                                                            zzip = zzge().zzip();
                                                            str6 = "Unknown value for param. event, param";
                                                            zzbj = zzga().zzbj(str7);
                                                            zzbk = zzga().zzbk(com_google_android_gms_internal_measurement_zzko.name);
                                                            break;
                                                        }
                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                        obj = com_google_android_gms_internal_measurement_zzko.zzajf;
                                                    } else {
                                                        obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                        obj = com_google_android_gms_internal_measurement_zzko.zzarc;
                                                    }
                                                } else {
                                                    obj2 = com_google_android_gms_internal_measurement_zzko.name;
                                                    obj = com_google_android_gms_internal_measurement_zzko.zzate;
                                                }
                                                map3.put(obj2, obj);
                                            }
                                            i10++;
                                            j = j2;
                                        }
                                        j2 = j;
                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzke.zzarr;
                                        intValue = com_google_android_gms_internal_measurement_zzkfArr.length;
                                        i = 0;
                                        while (i < intValue) {
                                            com_google_android_gms_internal_measurement_zzkf = com_google_android_gms_internal_measurement_zzkfArr[i];
                                            equals = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf.zzarx);
                                            str5 = com_google_android_gms_internal_measurement_zzkf.zzary;
                                            if (TextUtils.isEmpty(str5)) {
                                                zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str7));
                                            } else {
                                                com_google_android_gms_internal_measurement_zzkfArr2 = com_google_android_gms_internal_measurement_zzkfArr;
                                                obj2 = map3.get(str5);
                                                i11 = intValue;
                                                if (obj2 instanceof Long) {
                                                    if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                        zzip = zzge().zzip();
                                                        str6 = "No number filter for long param. event, param";
                                                    } else {
                                                        zza = zza(((Long) obj2).longValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                        if (zza == null) {
                                                            if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                z = false;
                                                                break;
                                                            }
                                                            i++;
                                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                            intValue = i11;
                                                        }
                                                    }
                                                } else if (obj2 instanceof Double) {
                                                    if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                                                        zzip = zzge().zzip();
                                                        str6 = "No number filter for double param. event, param";
                                                    } else {
                                                        zza = zza(((Double) obj2).doubleValue(), com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                        if (zza == null) {
                                                            if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                                z = false;
                                                                break;
                                                            }
                                                            i++;
                                                            com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                            intValue = i11;
                                                        }
                                                    }
                                                } else if (!(obj2 instanceof String)) {
                                                    if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                                                        zza = zza((String) obj2, com_google_android_gms_internal_measurement_zzkf.zzarv);
                                                    } else if (com_google_android_gms_internal_measurement_zzkf.zzarw == null) {
                                                        str3 = (String) obj2;
                                                        if (zzka.zzck(str3)) {
                                                            zza = zza(str3, com_google_android_gms_internal_measurement_zzkf.zzarw);
                                                        } else {
                                                            zzip = zzge().zzip();
                                                            str6 = "Invalid param value for number filter. event, param";
                                                        }
                                                    } else {
                                                        zzip = zzge().zzip();
                                                        str6 = "No filter for String param. event, param";
                                                    }
                                                    if (zza == null) {
                                                        if (((zza.booleanValue() ^ 1) ^ equals) != 0) {
                                                            z = false;
                                                            break;
                                                        }
                                                        i++;
                                                        com_google_android_gms_internal_measurement_zzkfArr = com_google_android_gms_internal_measurement_zzkfArr2;
                                                        intValue = i11;
                                                    }
                                                } else if (obj2 == null) {
                                                    zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str7), zzga().zzbk(str5));
                                                    z = false;
                                                    break;
                                                } else {
                                                    zzip = zzge().zzip();
                                                    str6 = "Unknown param type. event, param";
                                                }
                                                zzbj = zzga().zzbj(str7);
                                                zzbk = zzga().zzbk(str5);
                                                zzip.zze(str6, zzbj, zzbk);
                                            }
                                            zza2 = null;
                                        }
                                        z = true;
                                        zza2 = Boolean.valueOf(z);
                                        if (zza2 != null) {
                                        }
                                        zzge().zzit().zzg("Event filter result", zza2 != null ? zza2 : "null");
                                        if (zza2 != null) {
                                            hashSet3.add(Integer.valueOf(intValue2));
                                        } else {
                                            bitSet5.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                            if (zza2.booleanValue()) {
                                                bitSet.set(com_google_android_gms_internal_measurement_zzke.zzarp.intValue());
                                            }
                                        }
                                        com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                                        map2 = map7;
                                        map3 = map8;
                                        it6 = it2;
                                        it = it3;
                                        map6 = map9;
                                        map5 = map10;
                                        map4 = map11;
                                        j = j2;
                                    }
                                }
                            }
                            j2 = j;
                            com_google_android_gms_internal_measurement_zzkoArr = com_google_android_gms_internal_measurement_zzkoArr2;
                            zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzke.zzarp));
                            com_google_android_gms_internal_measurement_zzkoArr2 = com_google_android_gms_internal_measurement_zzkoArr;
                            map2 = map7;
                            map3 = map8;
                            it6 = it2;
                            it = it3;
                            map6 = map9;
                            map5 = map10;
                            map4 = map11;
                            j = j2;
                        }
                        hashSet = hashSet3;
                        map17 = map4;
                        map16 = map6;
                        map18 = map5;
                    }
                }
                arrayMap2 = map2;
                map10 = map18;
                map9 = map16;
                hashSet3 = hashSet;
                map11 = map17;
                com_google_android_gms_internal_measurement_zzkn3 = com_google_android_gms_internal_measurement_zzkn2;
                l2 = l;
                j3 = j4;
                i8 = i3 + 1;
                com_google_android_gms_internal_measurement_zzknArr2 = com_google_android_gms_internal_measurement_zzknArr;
                str5 = str2;
                hashSet2 = hashSet3;
                length = i4;
                arrayMap6 = arrayMap2;
                arrayMap5 = map9;
                map = map10;
                arrayMap3 = map11;
            }
            map9 = arrayMap5;
            set = hashSet2;
            map11 = arrayMap3;
            str2 = str5;
            map10 = map;
            com_google_android_gms_internal_measurement_zzksArr2 = com_google_android_gms_internal_measurement_zzksArr;
        } else {
            map9 = arrayMap5;
            set = hashSet2;
            map11 = arrayMap3;
            str2 = str5;
            map10 = map;
            com_google_android_gms_internal_measurement_zzksArr2 = com_google_android_gms_internal_measurement_zzksArr3;
        }
        if (com_google_android_gms_internal_measurement_zzksArr2 != null) {
            zzbf = new ArrayMap();
            intValue = com_google_android_gms_internal_measurement_zzksArr2.length;
            i2 = 0;
            while (i2 < intValue) {
                Map map19;
                zzks com_google_android_gms_internal_measurement_zzks = com_google_android_gms_internal_measurement_zzksArr2[i2];
                Map map20 = (Map) zzbf.get(com_google_android_gms_internal_measurement_zzks.name);
                if (map20 == null) {
                    map20 = zzix().zzl(str2, com_google_android_gms_internal_measurement_zzks.name);
                    if (map20 == null) {
                        map20 = new ArrayMap();
                    }
                    zzbf.put(com_google_android_gms_internal_measurement_zzks.name, map20);
                }
                Iterator it7 = map20.keySet().iterator();
                while (it7.hasNext()) {
                    i6 = ((Integer) it7.next()).intValue();
                    if (set.contains(Integer.valueOf(i6))) {
                        zzge().zzit().zzg("Skipping failed audience ID", Integer.valueOf(i6));
                    } else {
                        int i15;
                        arrayMap3 = map11;
                        map12 = map10;
                        BitSet bitSet6 = (BitSet) map12.get(Integer.valueOf(i6));
                        Map map21 = map9;
                        BitSet bitSet7 = (BitSet) map21.get(Integer.valueOf(i6));
                        if (((zzkm) arrayMap3.get(Integer.valueOf(i6))) == null) {
                            zzkm com_google_android_gms_internal_measurement_zzkm3 = new zzkm();
                            arrayMap3.put(Integer.valueOf(i6), com_google_android_gms_internal_measurement_zzkm3);
                            com_google_android_gms_internal_measurement_zzkm3.zzasy = Boolean.valueOf(true);
                            BitSet bitSet8 = new BitSet();
                            map12.put(Integer.valueOf(i6), bitSet8);
                            bitSet7 = new BitSet();
                            map21.put(Integer.valueOf(i6), bitSet7);
                            bitSet6 = bitSet8;
                        }
                        Iterator it8 = ((List) map20.get(Integer.valueOf(i6))).iterator();
                        while (it8.hasNext()) {
                            Iterator it9;
                            Iterator it10;
                            map19 = zzbf;
                            zzkh com_google_android_gms_internal_measurement_zzkh = (zzkh) it8.next();
                            i15 = intValue;
                            Map map22 = map20;
                            if (zzge().isLoggable(2)) {
                                it9 = it7;
                                it10 = it8;
                                map13 = map21;
                                map14 = arrayMap3;
                                zzge().zzit().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(i6), com_google_android_gms_internal_measurement_zzkh.zzarp, zzga().zzbl(com_google_android_gms_internal_measurement_zzkh.zzasf));
                                zzge().zzit().zzg("Filter definition", zzga().zza(com_google_android_gms_internal_measurement_zzkh));
                            } else {
                                map13 = map21;
                                it9 = it7;
                                it10 = it8;
                                map14 = arrayMap3;
                            }
                            if (com_google_android_gms_internal_measurement_zzkh.zzarp != null) {
                                if (com_google_android_gms_internal_measurement_zzkh.zzarp.intValue() <= 256) {
                                    if (bitSet6.get(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue())) {
                                        zzge().zzit().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(i6), com_google_android_gms_internal_measurement_zzkh.zzarp);
                                    } else {
                                        String str9;
                                        zzkf com_google_android_gms_internal_measurement_zzkf3 = com_google_android_gms_internal_measurement_zzkh.zzasg;
                                        if (com_google_android_gms_internal_measurement_zzkf3 == null) {
                                            zzip = zzge().zzip();
                                            str9 = "Missing property filter. property";
                                        } else {
                                            boolean equals2 = Boolean.TRUE.equals(com_google_android_gms_internal_measurement_zzkf3.zzarx);
                                            if (com_google_android_gms_internal_measurement_zzks.zzate != null) {
                                                if (com_google_android_gms_internal_measurement_zzkf3.zzarw == null) {
                                                    zzip = zzge().zzip();
                                                    str9 = "No number filter for long property. property";
                                                } else {
                                                    zza = zza(com_google_android_gms_internal_measurement_zzks.zzate.longValue(), com_google_android_gms_internal_measurement_zzkf3.zzarw);
                                                }
                                            } else if (com_google_android_gms_internal_measurement_zzks.zzarc != null) {
                                                if (com_google_android_gms_internal_measurement_zzkf3.zzarw == null) {
                                                    zzip = zzge().zzip();
                                                    str9 = "No number filter for double property. property";
                                                } else {
                                                    zza = zza(com_google_android_gms_internal_measurement_zzks.zzarc.doubleValue(), com_google_android_gms_internal_measurement_zzkf3.zzarw);
                                                }
                                            } else if (com_google_android_gms_internal_measurement_zzks.zzajf == null) {
                                                zzip = zzge().zzip();
                                                str9 = "User property has no value, property";
                                            } else if (com_google_android_gms_internal_measurement_zzkf3.zzarv != null) {
                                                zza = zza(com_google_android_gms_internal_measurement_zzks.zzajf, com_google_android_gms_internal_measurement_zzkf3.zzarv);
                                            } else if (com_google_android_gms_internal_measurement_zzkf3.zzarw == null) {
                                                zzip = zzge().zzip();
                                                str9 = "No string or number filter defined. property";
                                            } else if (zzka.zzck(com_google_android_gms_internal_measurement_zzks.zzajf)) {
                                                zza = zza(com_google_android_gms_internal_measurement_zzks.zzajf, com_google_android_gms_internal_measurement_zzkf3.zzarw);
                                            } else {
                                                zzge().zzip().zze("Invalid user property value for Numeric number filter. property, value", zzga().zzbl(com_google_android_gms_internal_measurement_zzks.name), com_google_android_gms_internal_measurement_zzks.zzajf);
                                                zza = null;
                                                zzge().zzit().zzg("Property filter result", zza == null ? "null" : zza);
                                                if (zza == null) {
                                                    set.add(Integer.valueOf(i6));
                                                } else {
                                                    bitSet7.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                                    if (!zza.booleanValue()) {
                                                        bitSet6.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                                    }
                                                }
                                            }
                                            zza = zza(zza, equals2);
                                            if (zza == null) {
                                            }
                                            zzge().zzit().zzg("Property filter result", zza == null ? "null" : zza);
                                            if (zza == null) {
                                                bitSet7.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                                if (!zza.booleanValue()) {
                                                    bitSet6.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                                }
                                            } else {
                                                set.add(Integer.valueOf(i6));
                                            }
                                        }
                                        zzip.zzg(str9, zzga().zzbl(com_google_android_gms_internal_measurement_zzks.name));
                                        zza = null;
                                        if (zza == null) {
                                        }
                                        zzge().zzit().zzg("Property filter result", zza == null ? "null" : zza);
                                        if (zza == null) {
                                            set.add(Integer.valueOf(i6));
                                        } else {
                                            bitSet7.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                            if (!zza.booleanValue()) {
                                                bitSet6.set(com_google_android_gms_internal_measurement_zzkh.zzarp.intValue());
                                            }
                                        }
                                    }
                                    zzbf = map19;
                                    intValue = i15;
                                    map20 = map22;
                                    it7 = it9;
                                    it8 = it10;
                                    map21 = map13;
                                    arrayMap3 = map14;
                                }
                            }
                            zzge().zzip().zze("Invalid property filter ID. appId, id", zzfg.zzbm(str), String.valueOf(com_google_android_gms_internal_measurement_zzkh.zzarp));
                            set.add(Integer.valueOf(i6));
                            map10 = map12;
                            zzbf = map19;
                            intValue = i15;
                            map20 = map22;
                            it7 = it9;
                            map9 = map13;
                            map11 = map14;
                        }
                        i15 = intValue;
                        map9 = map21;
                        map11 = arrayMap3;
                        map10 = map12;
                        com_google_android_gms_internal_measurement_zzksArr2 = com_google_android_gms_internal_measurement_zzksArr;
                    }
                }
                map19 = zzbf;
                map13 = map9;
                map12 = map10;
                map14 = map11;
                i2++;
                intValue = intValue;
                com_google_android_gms_internal_measurement_zzksArr2 = com_google_android_gms_internal_measurement_zzksArr;
            }
        }
        map13 = map9;
        map12 = map10;
        map14 = map11;
        zzkm[] com_google_android_gms_internal_measurement_zzkmArr = new zzkm[map12.size()];
        intValue2 = 0;
        for (Integer intValue3 : map12.keySet()) {
            int intValue4 = intValue3.intValue();
            if (!set.contains(Integer.valueOf(intValue4))) {
                map3 = map14;
                zzkm com_google_android_gms_internal_measurement_zzkm4 = (zzkm) map3.get(Integer.valueOf(intValue4));
                if (com_google_android_gms_internal_measurement_zzkm4 == null) {
                    com_google_android_gms_internal_measurement_zzkm4 = new zzkm();
                }
                i = intValue2 + 1;
                com_google_android_gms_internal_measurement_zzkmArr[intValue2] = com_google_android_gms_internal_measurement_zzkm4;
                com_google_android_gms_internal_measurement_zzkm4.zzarl = Integer.valueOf(intValue4);
                com_google_android_gms_internal_measurement_zzkm4.zzasw = new zzkr();
                com_google_android_gms_internal_measurement_zzkm4.zzasw.zzaul = zzka.zza((BitSet) map12.get(Integer.valueOf(intValue4)));
                map4 = map13;
                com_google_android_gms_internal_measurement_zzkm4.zzasw.zzauk = zzka.zza((BitSet) map4.get(Integer.valueOf(intValue4)));
                zzhg zzix2 = zzix();
                zzace com_google_android_gms_internal_measurement_zzace = com_google_android_gms_internal_measurement_zzkm4.zzasw;
                zzix2.zzch();
                zzix2.zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzace);
                try {
                    ContentValues contentValues;
                    byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzace.zzvm()];
                    try {
                        zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
                        com_google_android_gms_internal_measurement_zzace.zza(zzb);
                        zzb.zzve();
                        contentValues = new ContentValues();
                        contentValues.put("app_id", str2);
                        contentValues.put("audience_id", Integer.valueOf(intValue4));
                        contentValues.put("current_results", bArr);
                        try {
                        } catch (SQLiteException e5) {
                            e = e5;
                            zzim = zzix2.zzge().zzim();
                            str4 = "Error storing filter results. appId";
                            zzim.zze(str4, zzfg.zzbm(str), e);
                            map14 = map3;
                            intValue2 = i;
                            map13 = map4;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        zzim = zzix2.zzge().zzim();
                        str4 = "Configuration loss. Failed to serialize filter results. appId";
                        zzim.zze(str4, zzfg.zzbm(str), e);
                        map14 = map3;
                        intValue2 = i;
                        map13 = map4;
                    }
                    try {
                        if (zzix2.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzix2.zzge().zzim().zzg("Failed to insert filter results (got -1). appId", zzfg.zzbm(str));
                        }
                    } catch (SQLiteException e7) {
                        e = e7;
                        zzim = zzix2.zzge().zzim();
                        str4 = "Error storing filter results. appId";
                        zzim.zze(str4, zzfg.zzbm(str), e);
                        map14 = map3;
                        intValue2 = i;
                        map13 = map4;
                    }
                } catch (IOException e8) {
                    e = e8;
                    zzim = zzix2.zzge().zzim();
                    str4 = "Configuration loss. Failed to serialize filter results. appId";
                    zzim.zze(str4, zzfg.zzbm(str), e);
                    map14 = map3;
                    intValue2 = i;
                    map13 = map4;
                }
                map14 = map3;
                intValue2 = i;
                map13 = map4;
            }
        }
        return (zzkm[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzkmArr, intValue2);
    }

    protected final boolean zzhf() {
        return false;
    }
}
