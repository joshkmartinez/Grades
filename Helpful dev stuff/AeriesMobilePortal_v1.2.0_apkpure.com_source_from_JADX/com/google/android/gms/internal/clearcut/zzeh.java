package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzeh {
    private static final Class<?> zzoh = zzdp();
    private static final zzex<?, ?> zzoi = zzd(false);
    private static final zzex<?, ?> zzoj = zzd(true);
    private static final zzex<?, ?> zzok = new zzez();

    static int zza(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzdc) {
            zzdc com_google_android_gms_internal_clearcut_zzdc = (zzdc) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zze(com_google_android_gms_internal_clearcut_zzdc.getLong(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zze(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    private static <UT, UB> UB zza(int i, int i2, UB ub, zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB) {
        Object zzdz;
        if (ub == null) {
            zzdz = com_google_android_gms_internal_clearcut_zzex_UT__UB.zzdz();
        }
        com_google_android_gms_internal_clearcut_zzex_UT__UB.zza(zzdz, i, (long) i2);
        return zzdz;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzck<?> com_google_android_gms_internal_clearcut_zzck_, UB ub, zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB) {
        if (com_google_android_gms_internal_clearcut_zzck_ == null) {
            return ub;
        }
        UB ub2;
        int intValue;
        if (!(list instanceof RandomAccess)) {
            Iterator it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    intValue = ((Integer) it.next()).intValue();
                    if (com_google_android_gms_internal_clearcut_zzck_.zzb(intValue) == null) {
                        ub = zza(i, intValue, (Object) ub2, (zzex) com_google_android_gms_internal_clearcut_zzex_UT__UB);
                        it.remove();
                    }
                }
                break loop1;
            }
        }
        int size = list.size();
        int i2 = 0;
        ub2 = ub;
        intValue = 0;
        while (i2 < size) {
            int intValue2 = ((Integer) list.get(i2)).intValue();
            if (com_google_android_gms_internal_clearcut_zzck_.zzb(intValue2) != null) {
                if (i2 != intValue) {
                    list.set(intValue, Integer.valueOf(intValue2));
                }
                intValue++;
            } else {
                ub2 = zza(i, intValue2, (Object) ub2, (zzex) com_google_android_gms_internal_clearcut_zzex_UT__UB);
            }
            i2++;
        }
        if (intValue != size) {
            list.subList(intValue, size).clear();
        }
        return ub2;
    }

    public static void zza(int i, List<String> list, zzfr com_google_android_gms_internal_clearcut_zzfr) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, (List) list);
        }
    }

    public static void zza(int i, List<?> list, zzfr com_google_android_gms_internal_clearcut_zzfr, zzef com_google_android_gms_internal_clearcut_zzef) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, (List) list, com_google_android_gms_internal_clearcut_zzef);
        }
    }

    public static void zza(int i, List<Double> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzg(i, list, z);
        }
    }

    static <T, FT extends zzca<FT>> void zza(zzbu<FT> com_google_android_gms_internal_clearcut_zzbu_FT, T t, T t2) {
        zzby zza = com_google_android_gms_internal_clearcut_zzbu_FT.zza((Object) t2);
        if (!zza.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzbu_FT.zzb(t).zza(zza);
        }
    }

    static <T> void zza(zzdj com_google_android_gms_internal_clearcut_zzdj, T t, T t2, long j) {
        zzfd.zza((Object) t, j, com_google_android_gms_internal_clearcut_zzdj.zzb(zzfd.zzo(t, j), zzfd.zzo(t2, j)));
    }

    static <T, UT, UB> void zza(zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB, T t, T t2) {
        com_google_android_gms_internal_clearcut_zzex_UT__UB.zze(t, com_google_android_gms_internal_clearcut_zzex_UT__UB.zzg(com_google_android_gms_internal_clearcut_zzex_UT__UB.zzq(t), com_google_android_gms_internal_clearcut_zzex_UT__UB.zzq(t2)));
    }

    static int zzb(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzdc) {
            zzdc com_google_android_gms_internal_clearcut_zzdc = (zzdc) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzf(com_google_android_gms_internal_clearcut_zzdc.getLong(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzf(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    public static void zzb(int i, List<zzbb> list, zzfr com_google_android_gms_internal_clearcut_zzfr) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzb(i, (List) list);
        }
    }

    public static void zzb(int i, List<?> list, zzfr com_google_android_gms_internal_clearcut_zzfr, zzef com_google_android_gms_internal_clearcut_zzef) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzb(i, (List) list, com_google_android_gms_internal_clearcut_zzef);
        }
    }

    public static void zzb(int i, List<Float> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzf(i, list, z);
        }
    }

    static int zzc(int i, Object obj, zzef com_google_android_gms_internal_clearcut_zzef) {
        return obj instanceof zzcv ? zzbn.zza(i, (zzcv) obj) : zzbn.zzb(i, (zzdo) obj, com_google_android_gms_internal_clearcut_zzef);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = zzbn.zzr(i) * size;
        Object raw;
        if (list instanceof zzcx) {
            zzcx com_google_android_gms_internal_clearcut_zzcx = (zzcx) list;
            while (i2 < size) {
                raw = com_google_android_gms_internal_clearcut_zzcx.getRaw(i2);
                i += raw instanceof zzbb ? zzbn.zzb((zzbb) raw) : zzbn.zzh((String) raw);
                i2++;
            }
        } else {
            while (i2 < size) {
                raw = list.get(i2);
                i += raw instanceof zzbb ? zzbn.zzb((zzbb) raw) : zzbn.zzh((String) raw);
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<?> list, zzef com_google_android_gms_internal_clearcut_zzef) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        i = zzbn.zzr(i) * size;
        while (i2 < size) {
            Object obj = list.get(i2);
            i += obj instanceof zzcv ? zzbn.zza((zzcv) obj) : zzbn.zzb((zzdo) obj, com_google_android_gms_internal_clearcut_zzef);
            i2++;
        }
        return i;
    }

    static int zzc(List<Long> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzdc) {
            zzdc com_google_android_gms_internal_clearcut_zzdc = (zzdc) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzg(com_google_android_gms_internal_clearcut_zzdc.getLong(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzg(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return i2;
    }

    public static void zzc(int i, List<Long> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzc(i, list, z);
        }
    }

    public static boolean zzc(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = (long) i3;
        return ((((long) i2) - ((long) i)) + 1) + 9 <= (3 + (2 * j)) + (3 * (3 + j));
    }

    static int zzd(int i, List<zzbb> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        size *= zzbn.zzr(i);
        while (i2 < list.size()) {
            size += zzbn.zzb((zzbb) list.get(i2));
            i2++;
        }
        return size;
    }

    static int zzd(int i, List<zzdo> list, zzef com_google_android_gms_internal_clearcut_zzef) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        while (i2 < size) {
            i3 += zzbn.zzc(i, (zzdo) list.get(i2), com_google_android_gms_internal_clearcut_zzef);
            i2++;
        }
        return i3;
    }

    static int zzd(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzch) {
            zzch com_google_android_gms_internal_clearcut_zzch = (zzch) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzx(com_google_android_gms_internal_clearcut_zzch.getInt(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzx(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    private static com.google.android.gms.internal.clearcut.zzex<?, ?> zzd(boolean r6) {
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
        r0 = 0;
        r1 = zzdq();	 Catch:{ Throwable -> 0x0023 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ Throwable -> 0x0023 }
    L_0x0007:
        return r0;	 Catch:{ Throwable -> 0x0023 }
    L_0x0008:
        r2 = 1;	 Catch:{ Throwable -> 0x0023 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0023 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0023 }
        r5 = 0;	 Catch:{ Throwable -> 0x0023 }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x0023 }
        r1 = r1.getConstructor(r3);	 Catch:{ Throwable -> 0x0023 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0023 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x0023 }
        r2[r5] = r6;	 Catch:{ Throwable -> 0x0023 }
        r6 = r1.newInstance(r2);	 Catch:{ Throwable -> 0x0023 }
        r6 = (com.google.android.gms.internal.clearcut.zzex) r6;	 Catch:{ Throwable -> 0x0023 }
        return r6;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzeh.zzd(boolean):com.google.android.gms.internal.clearcut.zzex<?, ?>");
    }

    public static void zzd(int i, List<Long> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzd(i, list, z);
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public static zzex<?, ?> zzdm() {
        return zzoi;
    }

    public static zzex<?, ?> zzdn() {
        return zzoj;
    }

    public static zzex<?, ?> zzdo() {
        return zzok;
    }

    private static java.lang.Class<?> zzdp() {
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
        r0 = "com.google.protobuf.GeneratedMessage";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzeh.zzdp():java.lang.Class<?>");
    }

    private static java.lang.Class<?> zzdq() {
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
        r0 = "com.google.protobuf.UnknownFieldSetSchema";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzeh.zzdq():java.lang.Class<?>");
    }

    static int zze(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzch) {
            zzch com_google_android_gms_internal_clearcut_zzch = (zzch) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzs(com_google_android_gms_internal_clearcut_zzch.getInt(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzs(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    public static void zze(int i, List<Long> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzn(i, list, z);
        }
    }

    static int zzf(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzch) {
            zzch com_google_android_gms_internal_clearcut_zzch = (zzch) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzt(com_google_android_gms_internal_clearcut_zzch.getInt(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzt(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    public static void zzf(int i, List<Long> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zze(i, list, z);
        }
    }

    public static void zzf(Class<?> cls) {
        if (!zzcg.class.isAssignableFrom(cls) && zzoh != null) {
            if (!zzoh.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    static int zzg(List<Integer> list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int i2;
        if (list instanceof zzch) {
            zzch com_google_android_gms_internal_clearcut_zzch = (zzch) list;
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzu(com_google_android_gms_internal_clearcut_zzch.getInt(i));
                i++;
            }
        } else {
            i2 = 0;
            while (i < size) {
                i2 += zzbn.zzu(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return i2;
    }

    public static void zzg(int i, List<Long> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzl(i, list, z);
        }
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static void zzh(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, (List) list, z);
        }
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static void zzi(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzj(i, list, z);
        }
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzj(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzb(i, (List) list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzfr com_google_android_gms_internal_clearcut_zzfr, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            com_google_android_gms_internal_clearcut_zzfr.zzi(i, list, z);
        }
    }

    static int zzo(int i, List<Long> list, boolean z) {
        return list.size() == 0 ? 0 : zza(list) + (list.size() * zzbn.zzr(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzb(list) + (size * zzbn.zzr(i));
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzc(list) + (size * zzbn.zzr(i));
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzd((List) list) + (size * zzbn.zzr(i));
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zze(list) + (size * zzbn.zzr(i));
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzf((List) list) + (size * zzbn.zzr(i));
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : zzg(list) + (size * zzbn.zzr(i));
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * zzbn.zzj(i, 0);
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * zzbn.zzg(i, 0);
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        return size == 0 ? 0 : size * zzbn.zzc(i, true);
    }
}
