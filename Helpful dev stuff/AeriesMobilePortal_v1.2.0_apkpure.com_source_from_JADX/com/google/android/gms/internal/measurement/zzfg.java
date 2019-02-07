package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import org.apache.commons.cli.HelpFormatter;

public final class zzfg extends zzhh {
    private long zzadu = -1;
    private char zzaim = '\u0000';
    @GuardedBy("this")
    private String zzain;
    private final zzfi zzaio = new zzfi(this, 6, false, false);
    private final zzfi zzaip = new zzfi(this, 6, true, false);
    private final zzfi zzaiq = new zzfi(this, 6, false, true);
    private final zzfi zzair = new zzfi(this, 5, false, false);
    private final zzfi zzais = new zzfi(this, 5, true, false);
    private final zzfi zzait = new zzfi(this, 5, false, true);
    private final zzfi zzaiu = new zzfi(this, 4, false, false);
    private final zzfi zzaiv = new zzfi(this, 3, false, false);
    private final zzfi zzaiw = new zzfi(this, 2, false, false);

    zzfg(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i = 0;
        String valueOf;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str = String.valueOf(obj).charAt(0) == '-' ? HelpFormatter.DEFAULT_OPT_PREFIX : "";
            valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder((43 + String.valueOf(str).length()) + String.valueOf(str).length());
            stringBuilder.append(str);
            stringBuilder.append(round);
            stringBuilder.append("...");
            stringBuilder.append(str);
            stringBuilder.append(round2);
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (!(obj instanceof Throwable)) {
                return obj instanceof zzfj ? ((zzfj) obj).zzajf : z ? HelpFormatter.DEFAULT_OPT_PREFIX : String.valueOf(obj);
            } else {
                Throwable th = (Throwable) obj;
                StringBuilder stringBuilder2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                valueOf = zzbn(AppMeasurement.class.getCanonicalName());
                String zzbn = zzbn(zzgl.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (i < length) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    if (!stackTraceElement.isNativeMethod()) {
                        String className = stackTraceElement.getClassName();
                        if (className != null) {
                            className = zzbn(className);
                            if (className.equals(valueOf) || className.equals(zzbn)) {
                                stringBuilder2.append(": ");
                                stringBuilder2.append(stackTraceElement);
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                }
                return stringBuilder2.toString();
            }
        }
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        obj = zza(z, obj);
        obj2 = zza(z, obj2);
        Object zza = zza(z, obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(obj)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(obj2)) {
            stringBuilder.append(str2);
            stringBuilder.append(obj2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza)) {
            stringBuilder.append(str2);
            stringBuilder.append(zza);
        }
        return stringBuilder.toString();
    }

    protected static Object zzbm(String str) {
        return str == null ? null : new zzfj(str);
    }

    private static String zzbn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    private final String zziu() {
        String str;
        synchronized (this) {
            if (this.zzain == null) {
                this.zzain = (String) zzew.zzagi.get();
            }
            str = this.zzain;
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @VisibleForTesting
    protected final boolean isLoggable(int i) {
        return Log.isLoggable(zziu(), i);
    }

    @VisibleForTesting
    protected final void zza(int i, String str) {
        Log.println(i, zziu(), str);
    }

    protected final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            String str2;
            Preconditions.checkNotNull(str);
            zzhh zzjq = this.zzacw.zzjq();
            if (zzjq == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (zzjq.isInitialized()) {
                if (i < 0) {
                    i = 0;
                }
                if (i >= 9) {
                    i = 8;
                }
                zzjq.zzc(new zzfh(this, i, str, obj, obj2, obj3));
            } else {
                str2 = "Scheduler not initialized. Not logging error/warn";
            }
            zza(6, str2);
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
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
        return false;
    }

    public final zzfi zzim() {
        return this.zzaio;
    }

    public final zzfi zzin() {
        return this.zzaip;
    }

    public final zzfi zzio() {
        return this.zzaiq;
    }

    public final zzfi zzip() {
        return this.zzair;
    }

    public final zzfi zziq() {
        return this.zzait;
    }

    public final zzfi zzir() {
        return this.zzaiu;
    }

    public final zzfi zzis() {
        return this.zzaiv;
    }

    public final zzfi zzit() {
        return this.zzaiw;
    }

    public final String zziv() {
        Pair zzfi = zzgf().zzajt.zzfi();
        if (zzfi != null) {
            if (zzfi != zzfr.zzajs) {
                String valueOf = String.valueOf(zzfi.second);
                String str = (String) zzfi.first;
                StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(valueOf).length()) + String.valueOf(str).length());
                stringBuilder.append(valueOf);
                stringBuilder.append(":");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
