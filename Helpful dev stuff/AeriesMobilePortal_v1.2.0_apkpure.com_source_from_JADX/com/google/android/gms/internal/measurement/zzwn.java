package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzwn {
    private static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbmh = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbmi = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbmj = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbmk = new AtomicBoolean();
    private static HashMap<String, String> zzbml;
    private static final HashMap<String, Boolean> zzbmm = new HashMap();
    private static final HashMap<String, Integer> zzbmn = new HashMap();
    private static final HashMap<String, Long> zzbmo = new HashMap();
    private static final HashMap<String, Float> zzbmp = new HashMap();
    private static Object zzbmq;
    private static boolean zzbmr;
    private static String[] zzbms = new String[0];

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
        r0 = com.google.android.gms.internal.measurement.zzwn.class;
        monitor-enter(r0);
        r1 = r2.containsKey(r3);	 Catch:{ all -> 0x0016 }
        if (r1 == 0) goto L_0x0013;
    L_0x0009:
        r2 = r2.get(r3);	 Catch:{ all -> 0x0016 }
        if (r2 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0011;
    L_0x0010:
        r2 = r4;
    L_0x0011:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        return r2;
    L_0x0013:
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        r2 = 0;
        return r2;
    L_0x0016:
        r2 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0016 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwn.zza(java.util.HashMap, java.lang.String, java.lang.Object):T");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r13, java.lang.String r14, java.lang.String r15) {
        /*
        r15 = com.google.android.gms.internal.measurement.zzwn.class;
        monitor-enter(r15);
        zza(r13);	 Catch:{ all -> 0x00a6 }
        r0 = zzbmq;	 Catch:{ all -> 0x00a6 }
        r1 = zzbml;	 Catch:{ all -> 0x00a6 }
        r1 = r1.containsKey(r14);	 Catch:{ all -> 0x00a6 }
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0011:
        r13 = zzbml;	 Catch:{ all -> 0x00a6 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a6 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x001c;
    L_0x001b:
        goto L_0x001d;
    L_0x001c:
        r13 = r2;
    L_0x001d:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r13;
    L_0x001f:
        r1 = zzbms;	 Catch:{ all -> 0x00a6 }
        r3 = r1.length;	 Catch:{ all -> 0x00a6 }
        r4 = 0;
        r5 = r4;
    L_0x0024:
        r6 = 1;
        if (r5 >= r3) goto L_0x0063;
    L_0x0027:
        r7 = r1[r5];	 Catch:{ all -> 0x00a6 }
        r7 = r14.startsWith(r7);	 Catch:{ all -> 0x00a6 }
        if (r7 == 0) goto L_0x0060;
    L_0x002f:
        r0 = zzbmr;	 Catch:{ all -> 0x00a6 }
        if (r0 == 0) goto L_0x003b;
    L_0x0033:
        r0 = zzbml;	 Catch:{ all -> 0x00a6 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x00a6 }
        if (r0 == 0) goto L_0x005e;
    L_0x003b:
        r0 = zzbms;	 Catch:{ all -> 0x00a6 }
        r1 = zzbml;	 Catch:{ all -> 0x00a6 }
        r13 = zza(r13, r0);	 Catch:{ all -> 0x00a6 }
        r1.putAll(r13);	 Catch:{ all -> 0x00a6 }
        zzbmr = r6;	 Catch:{ all -> 0x00a6 }
        r13 = zzbml;	 Catch:{ all -> 0x00a6 }
        r13 = r13.containsKey(r14);	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x005e;
    L_0x0050:
        r13 = zzbml;	 Catch:{ all -> 0x00a6 }
        r13 = r13.get(r14);	 Catch:{ all -> 0x00a6 }
        r13 = (java.lang.String) r13;	 Catch:{ all -> 0x00a6 }
        if (r13 == 0) goto L_0x005b;
    L_0x005a:
        goto L_0x005c;
    L_0x005b:
        r13 = r2;
    L_0x005c:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r13;
    L_0x005e:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        return r2;
    L_0x0060:
        r5 = r5 + 1;
        goto L_0x0024;
    L_0x0063:
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        r8 = CONTENT_URI;
        r9 = 0;
        r10 = 0;
        r11 = new java.lang.String[r6];
        r11[r4] = r14;
        r12 = 0;
        r7 = r13;
        r13 = r7.query(r8, r9, r10, r11, r12);
        if (r13 == 0) goto L_0x0097;
    L_0x0074:
        r15 = r13.moveToFirst();	 Catch:{ all -> 0x0095 }
        if (r15 != 0) goto L_0x007b;
    L_0x007a:
        goto L_0x0097;
    L_0x007b:
        r15 = r13.getString(r6);	 Catch:{ all -> 0x0095 }
        if (r15 == 0) goto L_0x0088;
    L_0x0081:
        r1 = r15.equals(r2);	 Catch:{ all -> 0x0095 }
        if (r1 == 0) goto L_0x0088;
    L_0x0087:
        r15 = r2;
    L_0x0088:
        zza(r0, r14, r15);	 Catch:{ all -> 0x0095 }
        if (r15 == 0) goto L_0x008e;
    L_0x008d:
        goto L_0x008f;
    L_0x008e:
        r15 = r2;
    L_0x008f:
        if (r13 == 0) goto L_0x0094;
    L_0x0091:
        r13.close();
    L_0x0094:
        return r15;
    L_0x0095:
        r14 = move-exception;
        goto L_0x00a0;
    L_0x0097:
        zza(r0, r14, r2);	 Catch:{ all -> 0x0095 }
        if (r13 == 0) goto L_0x009f;
    L_0x009c:
        r13.close();
    L_0x009f:
        return r2;
    L_0x00a0:
        if (r13 == 0) goto L_0x00a5;
    L_0x00a2:
        r13.close();
    L_0x00a5:
        throw r14;
    L_0x00a6:
        r13 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x00a6 }
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzwn.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbmh, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzbml == null) {
            zzbmk.set(false);
            zzbml = new HashMap();
            zzbmq = new Object();
            zzbmr = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzwo(null));
            return;
        }
        if (zzbmk.getAndSet(false)) {
            zzbml.clear();
            zzbmm.clear();
            zzbmn.clear();
            zzbmo.clear();
            zzbmp.clear();
            zzbmq = new Object();
            zzbmr = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzwn.class) {
            if (obj == zzbmq) {
                zzbml.put(str, str2);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzbmm, str, Boolean.valueOf(z));
        if (obj != null) {
            return obj.booleanValue();
        }
        Object zza = zza(contentResolver, str, null);
        if (zza != null) {
            if (!zza.equals("")) {
                if (zzbmi.matcher(zza).matches()) {
                    obj = Boolean.valueOf(true);
                    z = true;
                } else if (zzbmj.matcher(zza).matches()) {
                    obj = Boolean.valueOf(false);
                    z = false;
                } else {
                    StringBuilder stringBuilder = new StringBuilder("attempt to read gservices key ");
                    stringBuilder.append(str);
                    stringBuilder.append(" (value \"");
                    stringBuilder.append(zza);
                    stringBuilder.append("\") as boolean");
                    Log.w("Gservices", stringBuilder.toString());
                }
            }
        }
        HashMap hashMap = zzbmm;
        synchronized (zzwn.class) {
            if (zzb == zzbmq) {
                hashMap.put(str, obj);
                zzbml.remove(str);
            }
        }
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzwn.class) {
            zza(contentResolver);
            obj = zzbmq;
        }
        return obj;
    }
}
