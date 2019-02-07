package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement.Event;
import com.google.android.gms.measurement.AppMeasurement.UserProperty;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzka extends zzhh {
    private static final String[] zzard = new String[]{"firebase_", "google_", "ga_"};
    private SecureRandom zzare;
    private final AtomicLong zzarf = new AtomicLong(0);
    private int zzarg;
    private Integer zzarh = null;

    zzka(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    static java.security.MessageDigest getMessageDigest(java.lang.String r2) {
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
    L_0x0001:
        r1 = 2;
        if (r0 >= r1) goto L_0x000e;
    L_0x0004:
        r1 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NoSuchAlgorithmException -> 0x000b }
        if (r1 == 0) goto L_0x000b;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r0 + 1;
        goto L_0x0001;
    L_0x000e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.getMessageDigest(java.lang.String):java.security.MessageDigest");
    }

    public static zzko zza(zzkn com_google_android_gms_internal_measurement_zzkn, String str) {
        for (zzko com_google_android_gms_internal_measurement_zzko : com_google_android_gms_internal_measurement_zzkn.zzata) {
            if (com_google_android_gms_internal_measurement_zzko.name.equals(str)) {
                return com_google_android_gms_internal_measurement_zzko;
            }
        }
        return null;
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Long)) {
            if (!(obj instanceof Double)) {
                if (obj instanceof Integer) {
                    return Long.valueOf((long) ((Integer) obj).intValue());
                }
                if (obj instanceof Byte) {
                    return Long.valueOf((long) ((Byte) obj).byteValue());
                }
                if (obj instanceof Short) {
                    return Long.valueOf((long) ((Short) obj).shortValue());
                }
                if (obj instanceof Boolean) {
                    return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                } else if (obj instanceof Float) {
                    return Double.valueOf(((Float) obj).doubleValue());
                } else {
                    if (!((obj instanceof String) || (obj instanceof Character))) {
                        if (!(obj instanceof CharSequence)) {
                            return null;
                        }
                    }
                    return zza(String.valueOf(obj), i, z);
                }
            }
        }
        return obj;
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) > i) {
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
            }
            str = null;
        }
        return str;
    }

    @Nullable
    public static String zza(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzs(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void zza(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static boolean zza(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (!(obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean))) {
            if (!(obj instanceof Double)) {
                if (!((obj instanceof String) || (obj instanceof Character))) {
                    if (!(obj instanceof CharSequence)) {
                        if ((obj instanceof Bundle) && z) {
                            return true;
                        }
                        int length;
                        Object obj2;
                        if ((obj instanceof Parcelable[]) && z) {
                            Parcelable[] parcelableArr = (Parcelable[]) obj;
                            length = parcelableArr.length;
                            i = 0;
                            while (i < length) {
                                obj2 = parcelableArr[i];
                                if (obj2 instanceof Bundle) {
                                    i++;
                                } else {
                                    zzge().zzip().zze("All Parcelable[] elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                                    return false;
                                }
                            }
                            return true;
                        } else if (!(obj instanceof ArrayList) || !z) {
                            return false;
                        } else {
                            ArrayList arrayList = (ArrayList) obj;
                            length = arrayList.size();
                            i = 0;
                            while (i < length) {
                                obj2 = arrayList.get(i);
                                i++;
                                if (!(obj2 instanceof Bundle)) {
                                    zzge().zzip().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                                    return false;
                                }
                            }
                            return true;
                        }
                    }
                }
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i) {
                    zzge().zzip().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            byte[] marshall = obtain.marshall();
            return marshall;
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    static zzko[] zza(zzko[] com_google_android_gms_internal_measurement_zzkoArr, String str, Object obj) {
        for (zzko com_google_android_gms_internal_measurement_zzko : com_google_android_gms_internal_measurement_zzkoArr) {
            if (str.equals(com_google_android_gms_internal_measurement_zzko.name)) {
                com_google_android_gms_internal_measurement_zzko.zzate = null;
                com_google_android_gms_internal_measurement_zzko.zzajf = null;
                com_google_android_gms_internal_measurement_zzko.zzarc = null;
                if (obj instanceof Long) {
                    com_google_android_gms_internal_measurement_zzko.zzate = (Long) obj;
                } else if (obj instanceof String) {
                    com_google_android_gms_internal_measurement_zzko.zzajf = (String) obj;
                } else if (obj instanceof Double) {
                    com_google_android_gms_internal_measurement_zzko.zzarc = (Double) obj;
                }
                return com_google_android_gms_internal_measurement_zzkoArr;
            }
        }
        Object obj2 = new zzko[(com_google_android_gms_internal_measurement_zzkoArr.length + 1)];
        System.arraycopy(com_google_android_gms_internal_measurement_zzkoArr, 0, obj2, 0, com_google_android_gms_internal_measurement_zzkoArr.length);
        zzko com_google_android_gms_internal_measurement_zzko2 = new zzko();
        com_google_android_gms_internal_measurement_zzko2.name = str;
        if (obj instanceof Long) {
            com_google_android_gms_internal_measurement_zzko2.zzate = (Long) obj;
        } else if (obj instanceof String) {
            com_google_android_gms_internal_measurement_zzko2.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_measurement_zzko2.zzarc = (Double) obj;
        }
        obj2[com_google_android_gms_internal_measurement_zzkoArr.length] = com_google_android_gms_internal_measurement_zzko2;
        return obj2;
    }

    public static Object zzb(zzkn com_google_android_gms_internal_measurement_zzkn, String str) {
        zzko zza = zza(com_google_android_gms_internal_measurement_zzkn, str);
        if (zza != null) {
            if (zza.zzajf != null) {
                return zza.zzajf;
            }
            if (zza.zzate != null) {
                return zza.zzate;
            }
            if (zza.zzarc != null) {
                return zza.zzarc;
            }
        }
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        long j = null;
        Preconditions.checkState(bArr.length > 0);
        long j2 = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += 8;
            length--;
            j2 += (((long) bArr[length]) & 255) << j;
        }
        return j2;
    }

    public static boolean zzc(android.content.Context r3, java.lang.String r4) {
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
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0007:
        return r0;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0008:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0019 }
        r2.<init>(r3, r4);	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r1.getServiceInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 == 0) goto L_0x0019;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0013:
        r3 = r3.enabled;	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 == 0) goto L_0x0019;
    L_0x0017:
        r3 = 1;
        return r3;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzc(android.content.Context, java.lang.String):boolean");
    }

    static boolean zzcc(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) == '_') {
            if (!str.equals("_ep")) {
                return false;
            }
        }
        return true;
    }

    private static int zzch(String str) {
        return "_ldl".equals(str) ? 2048 : "_id".equals(str) ? 256 : 36;
    }

    public static boolean zzci(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
    }

    static boolean zzck(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @WorkerThread
    static boolean zzcl(String str) {
        boolean z;
        Preconditions.checkNotEmpty(str);
        int hashCode = str.hashCode();
        if (hashCode != 94660) {
            if (hashCode != 95025) {
                if (hashCode == 95027) {
                    if (str.equals("_ui")) {
                        z = true;
                        switch (z) {
                            case false:
                            case true:
                            case true:
                                return true;
                            default:
                                return false;
                        }
                    }
                }
            } else if (str.equals("_ug")) {
                z = true;
                switch (z) {
                    case false:
                    case true:
                    case true:
                        return true;
                    default:
                        return false;
                }
            }
        } else if (str.equals("_in")) {
            z = false;
            switch (z) {
                case false:
                case true:
                case true:
                    return true;
                default:
                    return false;
            }
        }
        z = true;
        switch (z) {
            case false:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzd(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (!("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra))) {
            if (!"android-app://com.google.appcrawler".equals(stringExtra)) {
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    static boolean zzd(zzeu com_google_android_gms_internal_measurement_zzeu, zzdz com_google_android_gms_internal_measurement_zzdz) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzeu);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzdz);
        return !TextUtils.isEmpty(com_google_android_gms_internal_measurement_zzdz.zzadm);
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        Object e;
        zzfi zzim;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (!(packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0)) {
                return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
            }
        } catch (CertificateException e2) {
            e = e2;
            zzim = zzge().zzim();
            str2 = "Error obtaining certificate";
            zzim.zzg(str2, e);
            return true;
        } catch (NameNotFoundException e3) {
            e = e3;
            zzim = zzge().zzim();
            str2 = "Package name not found";
            zzim.zzg(str2, e);
            return true;
        }
        return true;
    }

    public static Bundle[] zze(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        Object[] copyOf;
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            copyOf = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            copyOf = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) copyOf;
    }

    public static java.lang.Object zzf(java.lang.Object r4) {
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
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = new java.io.ObjectOutputStream;	 Catch:{ all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ all -> 0x0032 }
        r2.writeObject(r4);	 Catch:{ all -> 0x002f }
        r2.flush();	 Catch:{ all -> 0x002f }
        r4 = new java.io.ObjectInputStream;	 Catch:{ all -> 0x002f }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x002f }
        r1 = r1.toByteArray();	 Catch:{ all -> 0x002f }
        r3.<init>(r1);	 Catch:{ all -> 0x002f }
        r4.<init>(r3);	 Catch:{ all -> 0x002f }
        r1 = r4.readObject();	 Catch:{ all -> 0x002d }
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        return r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002d:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x002f:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        goto L_0x0035;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0032:
        r1 = move-exception;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r4 = r0;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
        r2 = r4;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0035:
        if (r2 == 0) goto L_0x003a;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003a:
        if (r4 == 0) goto L_0x003f;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003c:
        r4.close();	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x003f:
        throw r1;	 Catch:{ IOException -> 0x0040, IOException -> 0x0040 }
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zzf(java.lang.Object):java.lang.Object");
    }

    private final boolean zzr(String str, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzge().zzim().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzs(String str, String str2) {
        return (str == null && str2 == null) ? true : str == null ? false : str.equals(str2);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(@NonNull Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            Object queryParameter;
            Object queryParameter2;
            Object queryParameter3;
            Object queryParameter4;
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
            } else {
                queryParameter = null;
                queryParameter2 = queryParameter;
                queryParameter3 = queryParameter2;
                queryParameter4 = queryParameter3;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3)) {
                if (TextUtils.isEmpty(queryParameter4)) {
                    return null;
                }
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CAMPAIGN, queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(Param.SOURCE, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(Param.MEDIUM, queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.TERM, queryParameter);
            }
            queryParameter = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CONTENT, queryParameter);
            }
            queryParameter = uri.getQueryParameter(Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.ACLID, queryParameter);
            }
            queryParameter = uri.getQueryParameter(Param.CP1);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(Param.CP1, queryParameter);
            }
            Object queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzge().zzip().zzg("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z, boolean z2) {
        zzka com_google_android_gms_internal_measurement_zzka = this;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        String[] strArr = null;
        if (bundle2 == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle2);
        int i = 0;
        for (String str2 : bundle.keySet()) {
            int i2;
            Object obj;
            String str3;
            boolean z3;
            int i3;
            boolean z4;
            StringBuilder stringBuilder;
            String str4;
            String str5;
            int i4;
            zzka com_google_android_gms_internal_measurement_zzka2;
            String str6;
            int i5;
            if (list2 != null) {
                if (!list2.contains(str2)) {
                }
                i2 = 0;
                if (i2 == 0) {
                    if (zza(bundle3, i2)) {
                        bundle3.putString("_ev", zza(str2, 40, true));
                        if (i2 == 3) {
                            zza(bundle3, (Object) str2);
                        }
                    }
                    bundle3.remove(str2);
                } else {
                    obj = bundle2.get(str2);
                    zzab();
                    if (z2) {
                        str3 = "param";
                        if (obj instanceof Parcelable[]) {
                            if (obj instanceof ArrayList) {
                                i2 = ((ArrayList) obj).size();
                            }
                            z3 = true;
                            if (!z3) {
                                i3 = 17;
                                z4 = true;
                                if (i3 != 0 || "_ev".equals(str2)) {
                                    if (zzcc(str2)) {
                                        i++;
                                        if (i > 25) {
                                            stringBuilder = new StringBuilder(48);
                                            stringBuilder.append("Event can't contain more than 25 params");
                                            zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                            zza(bundle3, 5);
                                            bundle3.remove(str2);
                                        }
                                    }
                                    str4 = str;
                                } else {
                                    if (zza(bundle3, i3)) {
                                        bundle3.putString("_ev", zza(str2, 40, z4));
                                        zza(bundle3, bundle2.get(str2));
                                    }
                                    bundle3.remove(str2);
                                }
                            }
                        } else {
                            i2 = ((Parcelable[]) obj).length;
                        }
                        if (i2 > 1000) {
                            zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", str3, str2, Integer.valueOf(i2));
                            z3 = false;
                            if (z3) {
                                i3 = 17;
                                z4 = true;
                                if (i3 != 0) {
                                }
                                if (zzcc(str2)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                        zza(bundle3, 5);
                                        bundle3.remove(str2);
                                    }
                                }
                                str4 = str;
                            }
                        }
                        z3 = true;
                        if (z3) {
                            i3 = 17;
                            z4 = true;
                            if (i3 != 0) {
                            }
                            if (zzcc(str2)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                    zza(bundle3, 5);
                                    bundle3.remove(str2);
                                }
                            }
                            str4 = str;
                        }
                    }
                    if ((zzgg().zzaw(zzfv().zzah()) || !zzci(str)) && !zzci(str2)) {
                        z4 = true;
                        str5 = "param";
                        i4 = 100;
                        com_google_android_gms_internal_measurement_zzka2 = this;
                        str6 = str2;
                    } else {
                        str5 = "param";
                        i4 = 256;
                        com_google_android_gms_internal_measurement_zzka2 = this;
                        str6 = str2;
                        z4 = true;
                    }
                    i3 = com_google_android_gms_internal_measurement_zzka2.zza(str5, str6, i4, obj, z2) ? 0 : 4;
                    if (i3 != 0) {
                    }
                    if (zzcc(str2)) {
                        i++;
                        if (i > 25) {
                            stringBuilder = new StringBuilder(48);
                            stringBuilder.append("Event can't contain more than 25 params");
                            zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                            zza(bundle3, 5);
                            bundle3.remove(str2);
                        }
                    }
                    str4 = str;
                }
                strArr = null;
            }
            i2 = 14;
            if (z) {
                if (zzq("event param", str2)) {
                    if (!zza("event param", strArr, str2)) {
                        i5 = 14;
                        if (i5 == 0) {
                            if (zzr("event param", str2)) {
                                if (!zza("event param", strArr, str2)) {
                                    if (!zza("event param", 40, str2)) {
                                    }
                                    i2 = 0;
                                }
                            }
                            i2 = 3;
                        } else {
                            i2 = i5;
                        }
                        if (i2 == 0) {
                            obj = bundle2.get(str2);
                            zzab();
                            if (z2) {
                                str3 = "param";
                                if (obj instanceof Parcelable[]) {
                                    if (obj instanceof ArrayList) {
                                        i2 = ((ArrayList) obj).size();
                                    }
                                    z3 = true;
                                    if (z3) {
                                        i3 = 17;
                                        z4 = true;
                                        if (i3 != 0) {
                                        }
                                        if (zzcc(str2)) {
                                            i++;
                                            if (i > 25) {
                                                stringBuilder = new StringBuilder(48);
                                                stringBuilder.append("Event can't contain more than 25 params");
                                                zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                                zza(bundle3, 5);
                                                bundle3.remove(str2);
                                            }
                                        }
                                        str4 = str;
                                    }
                                } else {
                                    i2 = ((Parcelable[]) obj).length;
                                }
                                if (i2 > 1000) {
                                    zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", str3, str2, Integer.valueOf(i2));
                                    z3 = false;
                                    if (z3) {
                                        i3 = 17;
                                        z4 = true;
                                        if (i3 != 0) {
                                        }
                                        if (zzcc(str2)) {
                                            i++;
                                            if (i > 25) {
                                                stringBuilder = new StringBuilder(48);
                                                stringBuilder.append("Event can't contain more than 25 params");
                                                zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                                zza(bundle3, 5);
                                                bundle3.remove(str2);
                                            }
                                        }
                                        str4 = str;
                                    }
                                }
                                z3 = true;
                                if (z3) {
                                    i3 = 17;
                                    z4 = true;
                                    if (i3 != 0) {
                                    }
                                    if (zzcc(str2)) {
                                        i++;
                                        if (i > 25) {
                                            stringBuilder = new StringBuilder(48);
                                            stringBuilder.append("Event can't contain more than 25 params");
                                            zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                            zza(bundle3, 5);
                                            bundle3.remove(str2);
                                        }
                                    }
                                    str4 = str;
                                }
                            }
                            if (zzgg().zzaw(zzfv().zzah())) {
                            }
                            z4 = true;
                            str5 = "param";
                            i4 = 100;
                            com_google_android_gms_internal_measurement_zzka2 = this;
                            str6 = str2;
                            if (com_google_android_gms_internal_measurement_zzka2.zza(str5, str6, i4, obj, z2)) {
                            }
                            if (i3 != 0) {
                            }
                            if (zzcc(str2)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                    zza(bundle3, 5);
                                    bundle3.remove(str2);
                                }
                            }
                            str4 = str;
                        } else {
                            if (zza(bundle3, i2)) {
                                bundle3.putString("_ev", zza(str2, 40, true));
                                if (i2 == 3) {
                                    zza(bundle3, (Object) str2);
                                }
                            }
                            bundle3.remove(str2);
                        }
                        strArr = null;
                    } else if (!zza("event param", 40, str2)) {
                    }
                }
                i5 = 3;
                if (i5 == 0) {
                    i2 = i5;
                } else {
                    if (zzr("event param", str2)) {
                        if (!zza("event param", strArr, str2)) {
                            if (zza("event param", 40, str2)) {
                            }
                            i2 = 0;
                        }
                    }
                    i2 = 3;
                }
                if (i2 == 0) {
                    if (zza(bundle3, i2)) {
                        bundle3.putString("_ev", zza(str2, 40, true));
                        if (i2 == 3) {
                            zza(bundle3, (Object) str2);
                        }
                    }
                    bundle3.remove(str2);
                } else {
                    obj = bundle2.get(str2);
                    zzab();
                    if (z2) {
                        str3 = "param";
                        if (obj instanceof Parcelable[]) {
                            i2 = ((Parcelable[]) obj).length;
                        } else {
                            if (obj instanceof ArrayList) {
                                i2 = ((ArrayList) obj).size();
                            }
                            z3 = true;
                            if (z3) {
                                i3 = 17;
                                z4 = true;
                                if (i3 != 0) {
                                }
                                if (zzcc(str2)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                        zza(bundle3, 5);
                                        bundle3.remove(str2);
                                    }
                                }
                                str4 = str;
                            }
                        }
                        if (i2 > 1000) {
                            zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", str3, str2, Integer.valueOf(i2));
                            z3 = false;
                            if (z3) {
                                i3 = 17;
                                z4 = true;
                                if (i3 != 0) {
                                }
                                if (zzcc(str2)) {
                                    i++;
                                    if (i > 25) {
                                        stringBuilder = new StringBuilder(48);
                                        stringBuilder.append("Event can't contain more than 25 params");
                                        zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                        zza(bundle3, 5);
                                        bundle3.remove(str2);
                                    }
                                }
                                str4 = str;
                            }
                        }
                        z3 = true;
                        if (z3) {
                            i3 = 17;
                            z4 = true;
                            if (i3 != 0) {
                            }
                            if (zzcc(str2)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                    zza(bundle3, 5);
                                    bundle3.remove(str2);
                                }
                            }
                            str4 = str;
                        }
                    }
                    if (zzgg().zzaw(zzfv().zzah())) {
                    }
                    z4 = true;
                    str5 = "param";
                    i4 = 100;
                    com_google_android_gms_internal_measurement_zzka2 = this;
                    str6 = str2;
                    if (com_google_android_gms_internal_measurement_zzka2.zza(str5, str6, i4, obj, z2)) {
                    }
                    if (i3 != 0) {
                    }
                    if (zzcc(str2)) {
                        i++;
                        if (i > 25) {
                            stringBuilder = new StringBuilder(48);
                            stringBuilder.append("Event can't contain more than 25 params");
                            zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                            zza(bundle3, 5);
                            bundle3.remove(str2);
                        }
                    }
                    str4 = str;
                }
                strArr = null;
            }
            i5 = 0;
            if (i5 == 0) {
                if (zzr("event param", str2)) {
                    if (!zza("event param", strArr, str2)) {
                        if (zza("event param", 40, str2)) {
                        }
                        i2 = 0;
                    }
                }
                i2 = 3;
            } else {
                i2 = i5;
            }
            if (i2 == 0) {
                obj = bundle2.get(str2);
                zzab();
                if (z2) {
                    str3 = "param";
                    if (obj instanceof Parcelable[]) {
                        if (obj instanceof ArrayList) {
                            i2 = ((ArrayList) obj).size();
                        }
                        z3 = true;
                        if (z3) {
                            i3 = 17;
                            z4 = true;
                            if (i3 != 0) {
                            }
                            if (zzcc(str2)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                    zza(bundle3, 5);
                                    bundle3.remove(str2);
                                }
                            }
                            str4 = str;
                        }
                    } else {
                        i2 = ((Parcelable[]) obj).length;
                    }
                    if (i2 > 1000) {
                        zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", str3, str2, Integer.valueOf(i2));
                        z3 = false;
                        if (z3) {
                            i3 = 17;
                            z4 = true;
                            if (i3 != 0) {
                            }
                            if (zzcc(str2)) {
                                i++;
                                if (i > 25) {
                                    stringBuilder = new StringBuilder(48);
                                    stringBuilder.append("Event can't contain more than 25 params");
                                    zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                    zza(bundle3, 5);
                                    bundle3.remove(str2);
                                }
                            }
                            str4 = str;
                        }
                    }
                    z3 = true;
                    if (z3) {
                        i3 = 17;
                        z4 = true;
                        if (i3 != 0) {
                        }
                        if (zzcc(str2)) {
                            i++;
                            if (i > 25) {
                                stringBuilder = new StringBuilder(48);
                                stringBuilder.append("Event can't contain more than 25 params");
                                zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                zza(bundle3, 5);
                                bundle3.remove(str2);
                            }
                        }
                        str4 = str;
                    }
                }
                if (zzgg().zzaw(zzfv().zzah())) {
                }
                z4 = true;
                str5 = "param";
                i4 = 100;
                com_google_android_gms_internal_measurement_zzka2 = this;
                str6 = str2;
                if (com_google_android_gms_internal_measurement_zzka2.zza(str5, str6, i4, obj, z2)) {
                }
                if (i3 != 0) {
                }
                if (zzcc(str2)) {
                    i++;
                    if (i > 25) {
                        stringBuilder = new StringBuilder(48);
                        stringBuilder.append("Event can't contain more than 25 params");
                        zzge().zzim().zze(stringBuilder.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                        zza(bundle3, 5);
                        bundle3.remove(str2);
                    }
                }
                str4 = str;
            } else {
                if (zza(bundle3, i2)) {
                    bundle3.putString("_ev", zza(str2, 40, true));
                    if (i2 == 3) {
                        zza(bundle3, (Object) str2);
                    }
                }
                bundle3.remove(str2);
            }
            strArr = null;
        }
        return bundle3;
    }

    final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
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
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.Parcel.obtain();
        r2 = r5.length;	 Catch:{ ParseException -> 0x001c }
        r3 = 0;	 Catch:{ ParseException -> 0x001c }
        r1.unmarshall(r5, r3, r2);	 Catch:{ ParseException -> 0x001c }
        r1.setDataPosition(r3);	 Catch:{ ParseException -> 0x001c }
        r5 = r6.createFromParcel(r1);	 Catch:{ ParseException -> 0x001c }
        r5 = (android.os.Parcelable) r5;	 Catch:{ ParseException -> 0x001c }
        r1.recycle();
        return r5;
    L_0x001a:
        r5 = move-exception;
        goto L_0x002d;
    L_0x001c:
        r5 = r4.zzge();	 Catch:{ all -> 0x001a }
        r5 = r5.zzim();	 Catch:{ all -> 0x001a }
        r6 = "Failed to load parcelable from buffer";	 Catch:{ all -> 0x001a }
        r5.log(r6);	 Catch:{ all -> 0x001a }
        r1.recycle();
        return r0;
    L_0x002d:
        r1.recycle();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzka.zza(byte[], android.os.Parcelable$Creator):T");
    }

    final zzeu zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzcd(str) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str2);
            String str3 = str;
            return new zzeu(str3, new zzer(zzd(zza(str3, bundle2, CollectionUtils.listOf((Object) "_o"), false, false))), str2, j);
        }
        zzge().zzim().zzg("Invalid conditional property event name", zzga().zzbl(str));
        throw new IllegalArgumentException();
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza(null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else {
                if (str != null) {
                    zzge().zziq().zze("Not putting event parameter. Invalid value type. name, type", zzga().zzbk(str), obj != null ? obj.getClass().getSimpleName() : null);
                }
            }
        }
    }

    public final void zza(zzko com_google_android_gms_internal_measurement_zzko, Object obj) {
        Preconditions.checkNotNull(obj);
        com_google_android_gms_internal_measurement_zzko.zzajf = null;
        com_google_android_gms_internal_measurement_zzko.zzate = null;
        com_google_android_gms_internal_measurement_zzko.zzarc = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_measurement_zzko.zzajf = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_measurement_zzko.zzate = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_measurement_zzko.zzarc = (Double) obj;
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzks com_google_android_gms_internal_measurement_zzks, Object obj) {
        Preconditions.checkNotNull(obj);
        com_google_android_gms_internal_measurement_zzks.zzajf = null;
        com_google_android_gms_internal_measurement_zzks.zzate = null;
        com_google_android_gms_internal_measurement_zzks.zzarc = null;
        if (obj instanceof String) {
            com_google_android_gms_internal_measurement_zzks.zzajf = (String) obj;
        } else if (obj instanceof Long) {
            com_google_android_gms_internal_measurement_zzks.zzate = (Long) obj;
        } else if (obj instanceof Double) {
            com_google_android_gms_internal_measurement_zzks.zzarc = (Double) obj;
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzacw.zzfu().logEvent("auto", "_err", bundle);
    }

    public final boolean zza(long j, long j2) {
        if (j != 0) {
            if (j2 > 0) {
                return Math.abs(zzbt().currentTimeMillis() - j) > j2;
            }
        }
        return true;
    }

    final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzge().zzim().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    final boolean zza(String str, String[] strArr, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        }
        boolean z;
        Preconditions.checkNotNull(str2);
        for (String startsWith : zzard) {
            if (str2.startsWith(startsWith)) {
                z = true;
                break;
            }
        }
        z = false;
        if (z) {
            zzge().zzim().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            boolean z2;
            Preconditions.checkNotNull(strArr);
            for (String startsWith2 : strArr) {
                if (zzs(str2, startsWith2)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
            if (z2) {
                zzge().zzim().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final byte[] zza(byte[] bArr) throws IOException {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final byte[] zzb(zzkp com_google_android_gms_internal_measurement_zzkp) {
        try {
            byte[] bArr = new byte[com_google_android_gms_internal_measurement_zzkp.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            com_google_android_gms_internal_measurement_zzkp.zza(zzb);
            zzb.zzve();
            return bArr;
        } catch (IOException e) {
            zzge().zzim().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final int zzcd(String str) {
        return !zzr(NotificationCompat.CATEGORY_EVENT, str) ? 2 : !zza(NotificationCompat.CATEGORY_EVENT, Event.zzacx, str) ? 13 : !zza(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
    }

    public final int zzce(String str) {
        return !zzq("user property", str) ? 6 : !zza("user property", UserProperty.zzadb, str) ? 15 : !zza("user property", 24, str) ? 6 : 0;
    }

    public final int zzcf(String str) {
        return !zzr("user property", str) ? 6 : !zza("user property", UserProperty.zzadb, str) ? 15 : !zza("user property", 24, str) ? 6 : 0;
    }

    public final boolean zzcg(String str) {
        if (TextUtils.isEmpty(str)) {
            zzge().zzim().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzge().zzim().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzcj(String str) {
        return TextUtils.isEmpty(str) ? false : zzgg().zzhj().equals(str);
    }

    @WorkerThread
    final long zzd(Context context, String str) {
        zzab();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest("MD5");
        if (messageDigest == null) {
            zzge().zzim().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zze(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzge().zzip().log("Could not get signatures");
                    return -1;
                }
            } catch (NameNotFoundException e) {
                zzge().zzim().zzg("Package name not found", e);
            }
        }
        return 0;
    }

    final Bundle zzd(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzh = zzh(str, bundle.get(str));
                if (zzh == null) {
                    zzge().zzip().zzg("Param value can't be null", zzga().zzbk(str));
                } else {
                    zza(bundle2, str, zzh);
                }
            }
        }
        return bundle2;
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

    public final Object zzh(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!zzci(str)) {
                i = 100;
            }
            z = false;
        }
        return zza(i, obj, z);
    }

    protected final boolean zzhf() {
        return true;
    }

    public final int zzi(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzch(str), obj, false) : zza("user property", str, zzch(str), obj, false) ? 0 : 7;
    }

    @WorkerThread
    protected final void zzih() {
        zzab();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzge().zzip().log("Utils falling back to Random for random id");
            }
        }
        this.zzarf.set(nextLong);
    }

    public final Object zzj(String str, Object obj) {
        int zzch;
        boolean z;
        if ("_ldl".equals(str)) {
            zzch = zzch(str);
            z = true;
        } else {
            zzch = zzch(str);
            z = false;
        }
        return zza(zzch, obj, z);
    }

    public final long zzlb() {
        if (this.zzarf.get() == 0) {
            long j;
            synchronized (this.zzarf) {
                long nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                int i = this.zzarg + 1;
                this.zzarg = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzarf) {
            this.zzarf.compareAndSet(-1, 1);
            nextLong = this.zzarf.getAndIncrement();
        }
        return nextLong;
    }

    @WorkerThread
    final SecureRandom zzlc() {
        zzab();
        if (this.zzare == null) {
            this.zzare = new SecureRandom();
        }
        return this.zzare;
    }

    public final int zzld() {
        if (this.zzarh == null) {
            this.zzarh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.zzarh.intValue();
    }

    final boolean zzq(String str, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt)) {
                int length = str2.length();
                codePointAt = Character.charCount(codePointAt);
                while (codePointAt < length) {
                    int codePointAt2 = str2.codePointAt(codePointAt);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        codePointAt += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzge().zzim().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        }
    }

    @WorkerThread
    public final boolean zzx(String str) {
        zzab();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzge().zzis().zzg("Permission not granted", str);
        return false;
    }
}
