package com.google.android.gms.internal.clearcut;

import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.google.android.gms.internal.clearcut.zzcg.zzg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo com_google_android_gms_internal_clearcut_zzdo, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw com_google_android_gms_internal_clearcut_zzdw, zzcy com_google_android_gms_internal_clearcut_zzcy, zzex<?, ?> com_google_android_gms_internal_clearcut_zzex___, zzbu<?> com_google_android_gms_internal_clearcut_zzbu_, zzdj com_google_android_gms_internal_clearcut_zzdj) {
        zzdo com_google_android_gms_internal_clearcut_zzdo2 = com_google_android_gms_internal_clearcut_zzdo;
        zzbu<?> com_google_android_gms_internal_clearcut_zzbu_2 = com_google_android_gms_internal_clearcut_zzbu_;
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = com_google_android_gms_internal_clearcut_zzdo2 instanceof zzcg;
        this.zzmq = z;
        boolean z3 = com_google_android_gms_internal_clearcut_zzbu_2 != null && com_google_android_gms_internal_clearcut_zzbu_2.zze(com_google_android_gms_internal_clearcut_zzdo2);
        r0.zzmo = z3;
        r0.zzmr = false;
        r0.zzms = iArr2;
        r0.zzmt = iArr3;
        r0.zzmu = iArr4;
        r0.zzmv = com_google_android_gms_internal_clearcut_zzdw;
        r0.zzmw = com_google_android_gms_internal_clearcut_zzcy;
        r0.zzmx = com_google_android_gms_internal_clearcut_zzex___;
        r0.zzmy = com_google_android_gms_internal_clearcut_zzbu_2;
        r0.zzmn = com_google_android_gms_internal_clearcut_zzdo2;
        r0.zzmz = com_google_android_gms_internal_clearcut_zzdj;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay com_google_android_gms_internal_clearcut_zzay) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), com_google_android_gms_internal_clearcut_zzay);
    }

    private static int zza(zzef<?> com_google_android_gms_internal_clearcut_zzef_, int i, byte[] bArr, int i2, int i3, zzcn<?> com_google_android_gms_internal_clearcut_zzcn_, zzay com_google_android_gms_internal_clearcut_zzay) throws IOException {
        i2 = zza((zzef) com_google_android_gms_internal_clearcut_zzef_, bArr, i2, i3, com_google_android_gms_internal_clearcut_zzay);
        while (true) {
            com_google_android_gms_internal_clearcut_zzcn_.add(com_google_android_gms_internal_clearcut_zzay.zzff);
            if (i2 >= i3) {
                break;
            }
            int zza = zzax.zza(bArr, i2, com_google_android_gms_internal_clearcut_zzay);
            if (i != com_google_android_gms_internal_clearcut_zzay.zzfd) {
                break;
            }
            i2 = zza((zzef) com_google_android_gms_internal_clearcut_zzef_, bArr, zza, i3, com_google_android_gms_internal_clearcut_zzay);
        }
        return i2;
    }

    private static int zza(zzef com_google_android_gms_internal_clearcut_zzef, byte[] bArr, int i, int i2, int i3, zzay com_google_android_gms_internal_clearcut_zzay) throws IOException {
        zzds com_google_android_gms_internal_clearcut_zzds = (zzds) com_google_android_gms_internal_clearcut_zzef;
        Object newInstance = com_google_android_gms_internal_clearcut_zzds.newInstance();
        int zza = com_google_android_gms_internal_clearcut_zzds.zza(newInstance, bArr, i, i2, i3, com_google_android_gms_internal_clearcut_zzay);
        com_google_android_gms_internal_clearcut_zzds.zzc(newInstance);
        com_google_android_gms_internal_clearcut_zzay.zzff = newInstance;
        return zza;
    }

    private static int zza(zzef com_google_android_gms_internal_clearcut_zzef, byte[] bArr, int i, int i2, zzay com_google_android_gms_internal_clearcut_zzay) throws IOException {
        int i3 = i + 1;
        i = bArr[i];
        if (i < 0) {
            i3 = zzax.zza(i, bArr, i3, com_google_android_gms_internal_clearcut_zzay);
            i = com_google_android_gms_internal_clearcut_zzay.zzfd;
        }
        int i4 = i3;
        if (i < 0 || i > i2 - i4) {
            throw zzco.zzbl();
        }
        Object newInstance = com_google_android_gms_internal_clearcut_zzef.newInstance();
        i += i4;
        com_google_android_gms_internal_clearcut_zzef.zza(newInstance, bArr, i4, i, com_google_android_gms_internal_clearcut_zzay);
        com_google_android_gms_internal_clearcut_zzef.zzc(newInstance);
        com_google_android_gms_internal_clearcut_zzay.zzff = newInstance;
        return i;
    }

    private static <UT, UB> int zza(zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB, T t) {
        return com_google_android_gms_internal_clearcut_zzex_UT__UB.zzm(com_google_android_gms_internal_clearcut_zzex_UT__UB.zzq(t));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r18, byte[] r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, long r27, int r29, com.google.android.gms.internal.clearcut.zzay r30) throws java.io.IOException {
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r3 = r19;
        r4 = r20;
        r2 = r22;
        r8 = r23;
        r5 = r24;
        r9 = r27;
        r6 = r29;
        r11 = r30;
        r12 = zzmh;
        r7 = r0.zzmi;
        r13 = r6 + 2;
        r7 = r7[r13];
        r13 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r7 = r7 & r13;
        r13 = (long) r7;
        r7 = 5;
        r15 = 2;
        switch(r26) {
            case 51: goto L_0x0168;
            case 52: goto L_0x0158;
            case 53: goto L_0x0148;
            case 54: goto L_0x0148;
            case 55: goto L_0x013b;
            case 56: goto L_0x012f;
            case 57: goto L_0x0124;
            case 58: goto L_0x010e;
            case 59: goto L_0x00e2;
            case 60: goto L_0x00bc;
            case 61: goto L_0x00a4;
            case 62: goto L_0x013b;
            case 63: goto L_0x0076;
            case 64: goto L_0x0124;
            case 65: goto L_0x012f;
            case 66: goto L_0x0068;
            case 67: goto L_0x005a;
            case 68: goto L_0x0028;
            default: goto L_0x0026;
        };
    L_0x0026:
        goto L_0x017c;
    L_0x0028:
        r7 = 3;
        if (r5 != r7) goto L_0x017c;
    L_0x002b:
        r2 = r2 & -8;
        r7 = r2 | 4;
        r2 = r0.zzad(r6);
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r6 = r7;
        r7 = r30;
        r2 = zza(r2, r3, r4, r5, r6, r7);
        r3 = r12.getInt(r1, r13);
        if (r3 != r8) goto L_0x004b;
    L_0x0046:
        r15 = r12.getObject(r1, r9);
        goto L_0x004c;
    L_0x004b:
        r15 = 0;
    L_0x004c:
        if (r15 != 0) goto L_0x0052;
    L_0x004e:
        r3 = r11.zzff;
        goto L_0x0154;
    L_0x0052:
        r3 = r11.zzff;
        r3 = com.google.android.gms.internal.clearcut.zzci.zza(r15, r3);
        goto L_0x0154;
    L_0x005a:
        if (r5 != 0) goto L_0x017c;
    L_0x005c:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11);
        r3 = r11.zzfe;
        r3 = com.google.android.gms.internal.clearcut.zzbk.zza(r3);
        goto L_0x0150;
    L_0x0068:
        if (r5 != 0) goto L_0x017c;
    L_0x006a:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11);
        r3 = r11.zzfd;
        r3 = com.google.android.gms.internal.clearcut.zzbk.zzm(r3);
        goto L_0x0143;
    L_0x0076:
        if (r5 != 0) goto L_0x017c;
    L_0x0078:
        r3 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11);
        r4 = r11.zzfd;
        r5 = r0.zzaf(r6);
        if (r5 == 0) goto L_0x009a;
    L_0x0084:
        r5 = r5.zzb(r4);
        if (r5 == 0) goto L_0x008b;
    L_0x008a:
        goto L_0x009a;
    L_0x008b:
        r1 = zzn(r18);
        r4 = (long) r4;
        r4 = java.lang.Long.valueOf(r4);
        r1.zzb(r2, r4);
        r2 = r3;
        goto L_0x017d;
    L_0x009a:
        r2 = java.lang.Integer.valueOf(r4);
        r12.putObject(r1, r9, r2);
        r2 = r3;
        goto L_0x0178;
    L_0x00a4:
        if (r5 != r15) goto L_0x017c;
    L_0x00a6:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11);
        r4 = r11.zzfd;
        if (r4 != 0) goto L_0x00b2;
    L_0x00ae:
        r3 = com.google.android.gms.internal.clearcut.zzbb.zzfi;
        goto L_0x0154;
    L_0x00b2:
        r3 = com.google.android.gms.internal.clearcut.zzbb.zzb(r3, r2, r4);
        r12.putObject(r1, r9, r3);
    L_0x00b9:
        r2 = r2 + r4;
        goto L_0x0178;
    L_0x00bc:
        if (r5 != r15) goto L_0x017c;
    L_0x00be:
        r2 = r0.zzad(r6);
        r5 = r21;
        r2 = zza(r2, r3, r4, r5, r11);
        r3 = r12.getInt(r1, r13);
        if (r3 != r8) goto L_0x00d3;
    L_0x00ce:
        r15 = r12.getObject(r1, r9);
        goto L_0x00d4;
    L_0x00d3:
        r15 = 0;
    L_0x00d4:
        if (r15 != 0) goto L_0x00da;
    L_0x00d6:
        r3 = r11.zzff;
        goto L_0x0154;
    L_0x00da:
        r3 = r11.zzff;
        r3 = com.google.android.gms.internal.clearcut.zzci.zza(r15, r3);
        goto L_0x0154;
    L_0x00e2:
        if (r5 != r15) goto L_0x017c;
    L_0x00e4:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11);
        r4 = r11.zzfd;
        if (r4 != 0) goto L_0x00ef;
    L_0x00ec:
        r3 = "";
        goto L_0x0154;
    L_0x00ef:
        r5 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r5 = r25 & r5;
        if (r5 == 0) goto L_0x0103;
    L_0x00f5:
        r5 = r2 + r4;
        r5 = com.google.android.gms.internal.clearcut.zzff.zze(r3, r2, r5);
        if (r5 == 0) goto L_0x00fe;
    L_0x00fd:
        goto L_0x0103;
    L_0x00fe:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbp();
        throw r1;
    L_0x0103:
        r5 = new java.lang.String;
        r6 = com.google.android.gms.internal.clearcut.zzci.UTF_8;
        r5.<init>(r3, r2, r4, r6);
        r12.putObject(r1, r9, r5);
        goto L_0x00b9;
    L_0x010e:
        if (r5 != 0) goto L_0x017c;
    L_0x0110:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11);
        r3 = r11.zzfe;
        r5 = 0;
        r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r7 == 0) goto L_0x011e;
    L_0x011c:
        r15 = 1;
        goto L_0x011f;
    L_0x011e:
        r15 = 0;
    L_0x011f:
        r3 = java.lang.Boolean.valueOf(r15);
        goto L_0x0154;
    L_0x0124:
        if (r5 != r7) goto L_0x017c;
    L_0x0126:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzc(r19, r20);
        r2 = java.lang.Integer.valueOf(r2);
        goto L_0x0162;
    L_0x012f:
        r2 = 1;
        if (r5 != r2) goto L_0x017c;
    L_0x0132:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzd(r19, r20);
        r2 = java.lang.Long.valueOf(r2);
        goto L_0x0173;
    L_0x013b:
        if (r5 != 0) goto L_0x017c;
    L_0x013d:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11);
        r3 = r11.zzfd;
    L_0x0143:
        r3 = java.lang.Integer.valueOf(r3);
        goto L_0x0154;
    L_0x0148:
        if (r5 != 0) goto L_0x017c;
    L_0x014a:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r11);
        r3 = r11.zzfe;
    L_0x0150:
        r3 = java.lang.Long.valueOf(r3);
    L_0x0154:
        r12.putObject(r1, r9, r3);
        goto L_0x0178;
    L_0x0158:
        if (r5 != r7) goto L_0x017c;
    L_0x015a:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzf(r19, r20);
        r2 = java.lang.Float.valueOf(r2);
    L_0x0162:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
        goto L_0x0178;
    L_0x0168:
        r2 = 1;
        if (r5 != r2) goto L_0x017c;
    L_0x016b:
        r2 = com.google.android.gms.internal.clearcut.zzax.zze(r19, r20);
        r2 = java.lang.Double.valueOf(r2);
    L_0x0173:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
    L_0x0178:
        r12.putInt(r1, r13, r8);
        goto L_0x017d;
    L_0x017c:
        r2 = r4;
    L_0x017d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    private final int zza(T r18, byte[] r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, long r29, com.google.android.gms.internal.clearcut.zzay r31) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r17 = this;
        r0 = r17;
        r1 = r18;
        r7 = r19;
        r4 = r20;
        r8 = r21;
        r9 = r22;
        r2 = r24;
        r10 = r25;
        r5 = r29;
        r11 = r31;
        r3 = zzmh;
        r3 = r3.getObject(r1, r5);
        r3 = (com.google.android.gms.internal.clearcut.zzcn) r3;
        r12 = r3.zzu();
        r13 = 1;
        if (r12 != 0) goto L_0x0036;
    L_0x0023:
        r12 = r3.size();
        if (r12 != 0) goto L_0x002c;
    L_0x0029:
        r12 = 10;
        goto L_0x002d;
    L_0x002c:
        r12 = r12 << r13;
    L_0x002d:
        r3 = r3.zzi(r12);
        r12 = zzmh;
        r12.putObject(r1, r5, r3);
    L_0x0036:
        r12 = r3;
        r3 = 5;
        r5 = 0;
        r14 = 2;
        switch(r28) {
            case 18: goto L_0x0365;
            case 19: goto L_0x0325;
            case 20: goto L_0x02e9;
            case 21: goto L_0x02e9;
            case 22: goto L_0x02ce;
            case 23: goto L_0x028d;
            case 24: goto L_0x024c;
            case 25: goto L_0x01fb;
            case 26: goto L_0x016e;
            case 27: goto L_0x0157;
            case 28: goto L_0x012c;
            case 29: goto L_0x02ce;
            case 30: goto L_0x00f4;
            case 31: goto L_0x024c;
            case 32: goto L_0x028d;
            case 33: goto L_0x00b0;
            case 34: goto L_0x006c;
            case 35: goto L_0x0365;
            case 36: goto L_0x0325;
            case 37: goto L_0x02e9;
            case 38: goto L_0x02e9;
            case 39: goto L_0x02ce;
            case 40: goto L_0x028d;
            case 41: goto L_0x024c;
            case 42: goto L_0x01fb;
            case 43: goto L_0x02ce;
            case 44: goto L_0x00f4;
            case 45: goto L_0x024c;
            case 46: goto L_0x028d;
            case 47: goto L_0x00b0;
            case 48: goto L_0x006c;
            case 49: goto L_0x0040;
            default: goto L_0x003e;
        };
    L_0x003e:
        goto L_0x03a5;
    L_0x0040:
        r1 = 3;
        if (r2 != r1) goto L_0x03a5;
    L_0x0043:
        r10 = r0.zzad(r10);
        r1 = r9 & -8;
        r13 = r1 | 4;
        r1 = r10;
        r2 = r19;
        r3 = r20;
    L_0x0050:
        r4 = r21;
        r5 = r13;
        r6 = r31;
        r1 = zza(r1, r2, r3, r4, r5, r6);
        r2 = r11.zzff;
        r12.add(r2);
        if (r1 >= r8) goto L_0x03a6;
    L_0x0060:
        r3 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r2 = r11.zzfd;
        if (r9 != r2) goto L_0x03a6;
    L_0x0068:
        r1 = r10;
        r2 = r19;
        goto L_0x0050;
    L_0x006c:
        if (r2 != r14) goto L_0x0090;
    L_0x006e:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x0077:
        if (r1 >= r2) goto L_0x0087;
    L_0x0079:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r1, r11);
        r3 = r11.zzfe;
        r3 = com.google.android.gms.internal.clearcut.zzbk.zza(r3);
        r12.zzm(r3);
        goto L_0x0077;
    L_0x0087:
        if (r1 != r2) goto L_0x008b;
    L_0x0089:
        goto L_0x03a6;
    L_0x008b:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x0090:
        if (r2 != 0) goto L_0x03a5;
    L_0x0092:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r4, r11);
    L_0x0098:
        r2 = r11.zzfe;
        r2 = com.google.android.gms.internal.clearcut.zzbk.zza(r2);
        r12.zzm(r2);
        if (r1 >= r8) goto L_0x03a6;
    L_0x00a3:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x00ab:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r2, r11);
        goto L_0x0098;
    L_0x00b0:
        if (r2 != r14) goto L_0x00d4;
    L_0x00b2:
        r12 = (com.google.android.gms.internal.clearcut.zzch) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x00bb:
        if (r1 >= r2) goto L_0x00cb;
    L_0x00bd:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        r3 = com.google.android.gms.internal.clearcut.zzbk.zzm(r3);
        r12.zzac(r3);
        goto L_0x00bb;
    L_0x00cb:
        if (r1 != r2) goto L_0x00cf;
    L_0x00cd:
        goto L_0x03a6;
    L_0x00cf:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x00d4:
        if (r2 != 0) goto L_0x03a5;
    L_0x00d6:
        r12 = (com.google.android.gms.internal.clearcut.zzch) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
    L_0x00dc:
        r2 = r11.zzfd;
        r2 = com.google.android.gms.internal.clearcut.zzbk.zzm(r2);
        r12.zzac(r2);
        if (r1 >= r8) goto L_0x03a6;
    L_0x00e7:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x00ef:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r2, r11);
        goto L_0x00dc;
    L_0x00f4:
        if (r2 != r14) goto L_0x00fb;
    L_0x00f6:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r12, r11);
        goto L_0x010c;
    L_0x00fb:
        if (r2 != 0) goto L_0x03a5;
    L_0x00fd:
        r2 = r22;
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r6 = r12;
        r7 = r31;
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r2, r3, r4, r5, r6, r7);
    L_0x010c:
        r1 = (com.google.android.gms.internal.clearcut.zzcg) r1;
        r3 = r1.zzjp;
        r4 = com.google.android.gms.internal.clearcut.zzey.zzea();
        if (r3 != r4) goto L_0x0117;
    L_0x0116:
        r3 = 0;
    L_0x0117:
        r4 = r0.zzaf(r10);
        r5 = r0.zzmx;
        r6 = r23;
        r3 = com.google.android.gms.internal.clearcut.zzeh.zza(r6, r12, r4, r3, r5);
        r3 = (com.google.android.gms.internal.clearcut.zzey) r3;
        if (r3 == 0) goto L_0x0129;
    L_0x0127:
        r1.zzjp = r3;
    L_0x0129:
        r1 = r2;
        goto L_0x03a6;
    L_0x012c:
        if (r2 != r14) goto L_0x03a5;
    L_0x012e:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x013c;
    L_0x0136:
        r2 = com.google.android.gms.internal.clearcut.zzbb.zzfi;
        r12.add(r2);
        goto L_0x0144;
    L_0x013c:
        r3 = com.google.android.gms.internal.clearcut.zzbb.zzb(r7, r1, r2);
        r12.add(r3);
        r1 = r1 + r2;
    L_0x0144:
        if (r1 >= r8) goto L_0x03a6;
    L_0x0146:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x014e:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r2, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x013c;
    L_0x0156:
        goto L_0x0136;
    L_0x0157:
        if (r2 != r14) goto L_0x03a5;
    L_0x0159:
        r1 = r0.zzad(r10);
        r2 = r22;
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r6 = r12;
        r7 = r31;
        r1 = zza(r1, r2, r3, r4, r5, r6, r7);
        goto L_0x03a6;
    L_0x016e:
        if (r2 != r14) goto L_0x03a5;
    L_0x0170:
        r1 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r15 = r26 & r1;
        r1 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1));
        if (r1 != 0) goto L_0x01ad;
    L_0x0179:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x0187;
    L_0x0181:
        r2 = "";
        r12.add(r2);
        goto L_0x0192;
    L_0x0187:
        r3 = new java.lang.String;
        r4 = com.google.android.gms.internal.clearcut.zzci.UTF_8;
        r3.<init>(r7, r1, r2, r4);
    L_0x018e:
        r12.add(r3);
        r1 = r1 + r2;
    L_0x0192:
        if (r1 >= r8) goto L_0x03a6;
    L_0x0194:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x019c:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r2, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x01a5;
    L_0x01a4:
        goto L_0x0181;
    L_0x01a5:
        r3 = new java.lang.String;
        r4 = com.google.android.gms.internal.clearcut.zzci.UTF_8;
        r3.<init>(r7, r1, r2, r4);
        goto L_0x018e;
    L_0x01ad:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x01bb;
    L_0x01b5:
        r2 = "";
        r12.add(r2);
        goto L_0x01ce;
    L_0x01bb:
        r3 = r1 + r2;
        r4 = com.google.android.gms.internal.clearcut.zzff.zze(r7, r1, r3);
        if (r4 == 0) goto L_0x01f6;
    L_0x01c3:
        r4 = new java.lang.String;
        r5 = com.google.android.gms.internal.clearcut.zzci.UTF_8;
        r4.<init>(r7, r1, r2, r5);
    L_0x01ca:
        r12.add(r4);
        r1 = r3;
    L_0x01ce:
        if (r1 >= r8) goto L_0x03a6;
    L_0x01d0:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x01d8:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r2, r11);
        r2 = r11.zzfd;
        if (r2 != 0) goto L_0x01e1;
    L_0x01e0:
        goto L_0x01b5;
    L_0x01e1:
        r3 = r1 + r2;
        r4 = com.google.android.gms.internal.clearcut.zzff.zze(r7, r1, r3);
        if (r4 == 0) goto L_0x01f1;
    L_0x01e9:
        r4 = new java.lang.String;
        r5 = com.google.android.gms.internal.clearcut.zzci.UTF_8;
        r4.<init>(r7, r1, r2, r5);
        goto L_0x01ca;
    L_0x01f1:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbp();
        throw r1;
    L_0x01f6:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbp();
        throw r1;
    L_0x01fb:
        r1 = 0;
        if (r2 != r14) goto L_0x0223;
    L_0x01fe:
        r12 = (com.google.android.gms.internal.clearcut.zzaz) r12;
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r3 = r11.zzfd;
        r3 = r3 + r2;
    L_0x0207:
        if (r2 >= r3) goto L_0x021a;
    L_0x0209:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r2, r11);
        r8 = r11.zzfe;
        r4 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1));
        if (r4 == 0) goto L_0x0215;
    L_0x0213:
        r4 = r13;
        goto L_0x0216;
    L_0x0215:
        r4 = r1;
    L_0x0216:
        r12.addBoolean(r4);
        goto L_0x0207;
    L_0x021a:
        if (r2 != r3) goto L_0x021e;
    L_0x021c:
        goto L_0x0129;
    L_0x021e:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x0223:
        if (r2 != 0) goto L_0x03a5;
    L_0x0225:
        r12 = (com.google.android.gms.internal.clearcut.zzaz) r12;
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r4, r11);
        r3 = r11.zzfe;
        r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r10 == 0) goto L_0x0233;
    L_0x0231:
        r3 = r13;
        goto L_0x0234;
    L_0x0233:
        r3 = r1;
    L_0x0234:
        r12.addBoolean(r3);
        if (r2 >= r8) goto L_0x0129;
    L_0x0239:
        r3 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r2, r11);
        r4 = r11.zzfd;
        if (r9 != r4) goto L_0x0129;
    L_0x0241:
        r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r3, r11);
        r3 = r11.zzfe;
        r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r10 == 0) goto L_0x0233;
    L_0x024b:
        goto L_0x0231;
    L_0x024c:
        if (r2 != r14) goto L_0x026c;
    L_0x024e:
        r12 = (com.google.android.gms.internal.clearcut.zzch) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x0257:
        if (r1 >= r2) goto L_0x0263;
    L_0x0259:
        r3 = com.google.android.gms.internal.clearcut.zzax.zzc(r7, r1);
        r12.zzac(r3);
        r1 = r1 + 4;
        goto L_0x0257;
    L_0x0263:
        if (r1 != r2) goto L_0x0267;
    L_0x0265:
        goto L_0x03a6;
    L_0x0267:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x026c:
        if (r2 != r3) goto L_0x03a5;
    L_0x026e:
        r12 = (com.google.android.gms.internal.clearcut.zzch) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r19, r20);
        r12.zzac(r1);
        r1 = r4 + 4;
    L_0x0279:
        if (r1 >= r8) goto L_0x03a6;
    L_0x027b:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x0283:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r7, r2);
        r12.zzac(r1);
        r1 = r2 + 4;
        goto L_0x0279;
    L_0x028d:
        if (r2 != r14) goto L_0x02ad;
    L_0x028f:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x0298:
        if (r1 >= r2) goto L_0x02a4;
    L_0x029a:
        r3 = com.google.android.gms.internal.clearcut.zzax.zzd(r7, r1);
        r12.zzm(r3);
        r1 = r1 + 8;
        goto L_0x0298;
    L_0x02a4:
        if (r1 != r2) goto L_0x02a8;
    L_0x02a6:
        goto L_0x03a6;
    L_0x02a8:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x02ad:
        if (r2 != r13) goto L_0x03a5;
    L_0x02af:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zzd(r19, r20);
        r12.zzm(r1);
        r1 = r4 + 8;
    L_0x02ba:
        if (r1 >= r8) goto L_0x03a6;
    L_0x02bc:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x02c4:
        r3 = com.google.android.gms.internal.clearcut.zzax.zzd(r7, r2);
        r12.zzm(r3);
        r1 = r2 + 8;
        goto L_0x02ba;
    L_0x02ce:
        if (r2 != r14) goto L_0x02d6;
    L_0x02d0:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r12, r11);
        goto L_0x03a6;
    L_0x02d6:
        if (r2 != 0) goto L_0x03a5;
    L_0x02d8:
        r1 = r22;
        r2 = r19;
        r3 = r20;
        r4 = r21;
        r5 = r12;
        r6 = r31;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r1, r2, r3, r4, r5, r6);
        goto L_0x03a6;
    L_0x02e9:
        if (r2 != r14) goto L_0x0309;
    L_0x02eb:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x02f4:
        if (r1 >= r2) goto L_0x0300;
    L_0x02f6:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r1, r11);
        r3 = r11.zzfe;
        r12.zzm(r3);
        goto L_0x02f4;
    L_0x0300:
        if (r1 != r2) goto L_0x0304;
    L_0x0302:
        goto L_0x03a6;
    L_0x0304:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x0309:
        if (r2 != 0) goto L_0x03a5;
    L_0x030b:
        r12 = (com.google.android.gms.internal.clearcut.zzdc) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r4, r11);
    L_0x0311:
        r2 = r11.zzfe;
        r12.zzm(r2);
        if (r1 >= r8) goto L_0x03a6;
    L_0x0318:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x0320:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r7, r2, r11);
        goto L_0x0311;
    L_0x0325:
        if (r2 != r14) goto L_0x0344;
    L_0x0327:
        r12 = (com.google.android.gms.internal.clearcut.zzce) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x0330:
        if (r1 >= r2) goto L_0x033c;
    L_0x0332:
        r3 = com.google.android.gms.internal.clearcut.zzax.zzf(r7, r1);
        r12.zzc(r3);
        r1 = r1 + 4;
        goto L_0x0330;
    L_0x033c:
        if (r1 != r2) goto L_0x033f;
    L_0x033e:
        goto L_0x03a6;
    L_0x033f:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x0344:
        if (r2 != r3) goto L_0x03a5;
    L_0x0346:
        r12 = (com.google.android.gms.internal.clearcut.zzce) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r19, r20);
        r12.zzc(r1);
        r1 = r4 + 4;
    L_0x0351:
        if (r1 >= r8) goto L_0x03a6;
    L_0x0353:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x035b:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r7, r2);
        r12.zzc(r1);
        r1 = r2 + 4;
        goto L_0x0351;
    L_0x0365:
        if (r2 != r14) goto L_0x0384;
    L_0x0367:
        r12 = (com.google.android.gms.internal.clearcut.zzbq) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r4, r11);
        r2 = r11.zzfd;
        r2 = r2 + r1;
    L_0x0370:
        if (r1 >= r2) goto L_0x037c;
    L_0x0372:
        r3 = com.google.android.gms.internal.clearcut.zzax.zze(r7, r1);
        r12.zzc(r3);
        r1 = r1 + 8;
        goto L_0x0370;
    L_0x037c:
        if (r1 != r2) goto L_0x037f;
    L_0x037e:
        goto L_0x03a6;
    L_0x037f:
        r1 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r1;
    L_0x0384:
        if (r2 != r13) goto L_0x03a5;
    L_0x0386:
        r12 = (com.google.android.gms.internal.clearcut.zzbq) r12;
        r1 = com.google.android.gms.internal.clearcut.zzax.zze(r19, r20);
        r12.zzc(r1);
        r1 = r4 + 8;
    L_0x0391:
        if (r1 >= r8) goto L_0x03a6;
    L_0x0393:
        r2 = com.google.android.gms.internal.clearcut.zzax.zza(r7, r1, r11);
        r3 = r11.zzfd;
        if (r9 != r3) goto L_0x03a6;
    L_0x039b:
        r3 = com.google.android.gms.internal.clearcut.zzax.zze(r7, r2);
        r12.zzc(r3);
        r1 = r2 + 8;
        goto L_0x0391;
    L_0x03a5:
        r1 = r4;
    L_0x03a6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r7, byte[] r8, int r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.clearcut.zzay r15) throws java.io.IOException {
        /*
        r6 = this;
        r12 = zzmh;
        r11 = r6.zzae(r11);
        r0 = r12.getObject(r7, r13);
        r1 = r6.zzmz;
        r1 = r1.zzi(r0);
        if (r1 == 0) goto L_0x0021;
    L_0x0012:
        r1 = r6.zzmz;
        r1 = r1.zzk(r11);
        r2 = r6.zzmz;
        r2.zzb(r1, r0);
        r12.putObject(r7, r13, r1);
        r0 = r1;
    L_0x0021:
        r7 = r6.zzmz;
        r7 = r7.zzl(r11);
        r11 = r6.zzmz;
        r11 = r11.zzg(r0);
        r9 = com.google.android.gms.internal.clearcut.zzax.zza(r8, r9, r15);
        r12 = r15.zzfd;
        if (r12 < 0) goto L_0x0094;
    L_0x0035:
        r13 = r10 - r9;
        if (r12 > r13) goto L_0x0094;
    L_0x0039:
        r12 = r12 + r9;
        r13 = r7.zzmc;
        r14 = r7.zzdu;
    L_0x003e:
        if (r9 >= r12) goto L_0x0089;
    L_0x0040:
        r0 = r9 + 1;
        r9 = r8[r9];
        if (r9 >= 0) goto L_0x004c;
    L_0x0046:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r9, r8, r0, r15);
        r9 = r15.zzfd;
    L_0x004c:
        r1 = r0;
        r0 = r9 >>> 3;
        r2 = r9 & 7;
        switch(r0) {
            case 1: goto L_0x006f;
            case 2: goto L_0x0055;
            default: goto L_0x0054;
        };
    L_0x0054:
        goto L_0x0084;
    L_0x0055:
        r0 = r7.zzmd;
        r0 = r0.zzel();
        if (r2 != r0) goto L_0x0084;
    L_0x005d:
        r3 = r7.zzmd;
        r9 = r7.zzdu;
        r4 = r9.getClass();
        r0 = r8;
        r2 = r10;
        r5 = r15;
        r9 = zza(r0, r1, r2, r3, r4, r5);
        r14 = r15.zzff;
        goto L_0x003e;
    L_0x006f:
        r0 = r7.zzmb;
        r0 = r0.zzel();
        if (r2 != r0) goto L_0x0084;
    L_0x0077:
        r3 = r7.zzmb;
        r4 = 0;
        r0 = r8;
        r2 = r10;
        r5 = r15;
        r9 = zza(r0, r1, r2, r3, r4, r5);
        r13 = r15.zzff;
        goto L_0x003e;
    L_0x0084:
        r9 = com.google.android.gms.internal.clearcut.zzax.zza(r9, r8, r1, r10, r15);
        goto L_0x003e;
    L_0x0089:
        if (r9 != r12) goto L_0x008f;
    L_0x008b:
        r11.put(r13, r14);
        return r12;
    L_0x008f:
        r7 = com.google.android.gms.internal.clearcut.zzco.zzbo();
        throw r7;
    L_0x0094:
        r7 = com.google.android.gms.internal.clearcut.zzco.zzbl();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, long, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r32, byte[] r33, int r34, int r35, int r36, com.google.android.gms.internal.clearcut.zzay r37) throws java.io.IOException {
        /*
        r31 = this;
        r15 = r31;
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r11 = r36;
        r9 = r37;
        r10 = zzmh;
        r16 = 0;
        r8 = -1;
        r0 = r34;
        r7 = r8;
        r1 = r16;
        r6 = r1;
    L_0x0017:
        r17 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        if (r0 >= r13) goto L_0x038d;
    L_0x001c:
        r1 = r0 + 1;
        r0 = r12[r0];
        if (r0 >= 0) goto L_0x002b;
    L_0x0022:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r0, r12, r1, r9);
        r1 = r9.zzfd;
        r4 = r0;
        r5 = r1;
        goto L_0x002d;
    L_0x002b:
        r5 = r0;
        r4 = r1;
    L_0x002d:
        r3 = r5 >>> 3;
        r2 = r5 & 7;
        r1 = r15.zzai(r3);
        if (r1 == r8) goto L_0x0350;
    L_0x0037:
        r0 = r15.zzmi;
        r18 = r1 + 1;
        r0 = r0[r18];
        r18 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r18 = r0 & r18;
        r8 = r18 >>> 20;
        r20 = r5;
        r5 = r0 & r17;
        r21 = r4;
        r4 = (long) r5;
        r22 = r4;
        r4 = 17;
        if (r8 > r4) goto L_0x0241;
    L_0x0050:
        r4 = r15.zzmi;
        r18 = r1 + 2;
        r4 = r4[r18];
        r18 = r4 >>> 20;
        r5 = 1;
        r18 = r5 << r18;
        r4 = r4 & r17;
        if (r4 == r7) goto L_0x006c;
    L_0x005f:
        r11 = -1;
        if (r7 == r11) goto L_0x0066;
    L_0x0062:
        r11 = (long) r7;
        r10.putInt(r14, r11, r6);
    L_0x0066:
        r6 = (long) r4;
        r6 = r10.getInt(r14, r6);
        r7 = r4;
    L_0x006c:
        r4 = 5;
        switch(r8) {
            case 0: goto L_0x0219;
            case 1: goto L_0x0203;
            case 2: goto L_0x01e4;
            case 3: goto L_0x01e4;
            case 4: goto L_0x01ce;
            case 5: goto L_0x01ac;
            case 6: goto L_0x0195;
            case 7: goto L_0x0175;
            case 8: goto L_0x0159;
            case 9: goto L_0x0132;
            case 10: goto L_0x011a;
            case 11: goto L_0x01ce;
            case 12: goto L_0x00e8;
            case 13: goto L_0x0195;
            case 14: goto L_0x01ac;
            case 15: goto L_0x00d0;
            case 16: goto L_0x00b4;
            case 17: goto L_0x007a;
            default: goto L_0x0070;
        };
    L_0x0070:
        r24 = r7;
        r11 = r20;
        r0 = r21;
        r12 = r33;
        goto L_0x0238;
    L_0x007a:
        r0 = 3;
        if (r2 != r0) goto L_0x00ad;
    L_0x007d:
        r0 = r3 << 3;
        r4 = r0 | 4;
        r0 = r15.zzad(r1);
        r12 = r33;
        r1 = r33;
        r2 = r21;
        r3 = r35;
        r24 = r7;
        r7 = r22;
        r11 = r20;
        r5 = r37;
        r0 = zza(r0, r1, r2, r3, r4, r5);
        r1 = r6 & r18;
        if (r1 != 0) goto L_0x00a1;
    L_0x009d:
        r1 = r9.zzff;
        goto L_0x012d;
    L_0x00a1:
        r1 = r10.getObject(r14, r7);
        r2 = r9.zzff;
        r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r2);
        goto L_0x012d;
    L_0x00ad:
        r24 = r7;
        r11 = r20;
        r12 = r33;
        goto L_0x00cc;
    L_0x00b4:
        r24 = r7;
        r11 = r20;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x00cc;
    L_0x00be:
        r3 = r21;
        r17 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r3, r9);
        r0 = r9.zzfe;
        r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0);
        goto L_0x01f6;
    L_0x00cc:
        r0 = r21;
        goto L_0x0238;
    L_0x00d0:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x01cb;
    L_0x00dc:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r3, r9);
        r1 = r9.zzfd;
        r1 = com.google.android.gms.internal.clearcut.zzbk.zzm(r1);
        goto L_0x01e0;
    L_0x00e8:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x01cb;
    L_0x00f4:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r3, r9);
        r2 = r9.zzfd;
        r1 = r15.zzaf(r1);
        if (r1 == 0) goto L_0x0115;
    L_0x0100:
        r1 = r1.zzb(r2);
        if (r1 == 0) goto L_0x0107;
    L_0x0106:
        goto L_0x0115;
    L_0x0107:
        r1 = zzn(r32);
        r2 = (long) r2;
        r2 = java.lang.Long.valueOf(r2);
        r1.zzb(r11, r2);
        goto L_0x0230;
    L_0x0115:
        r10.putInt(r14, r7, r2);
        goto L_0x022e;
    L_0x011a:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r0 = 2;
        r12 = r33;
        if (r2 != r0) goto L_0x01cb;
    L_0x0127:
        r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r3, r9);
    L_0x012b:
        r1 = r9.zzff;
    L_0x012d:
        r10.putObject(r14, r7, r1);
        goto L_0x022e;
    L_0x0132:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r0 = 2;
        r12 = r33;
        if (r2 != r0) goto L_0x01cb;
    L_0x013f:
        r0 = r15.zzad(r1);
        r0 = zza(r0, r12, r3, r13, r9);
        r1 = r6 & r18;
        if (r1 != 0) goto L_0x014e;
    L_0x014b:
        r1 = r9.zzff;
        goto L_0x012d;
    L_0x014e:
        r1 = r10.getObject(r14, r7);
        r2 = r9.zzff;
        r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r2);
        goto L_0x012d;
    L_0x0159:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r1 = 2;
        r12 = r33;
        if (r2 != r1) goto L_0x01cb;
    L_0x0166:
        r1 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r0 = r0 & r1;
        if (r0 != 0) goto L_0x0170;
    L_0x016b:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r3, r9);
        goto L_0x012b;
    L_0x0170:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r3, r9);
        goto L_0x012b;
    L_0x0175:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x01cb;
    L_0x0181:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r3, r9);
        r1 = r9.zzfe;
        r3 = 0;
        r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r17 == 0) goto L_0x018e;
    L_0x018d:
        goto L_0x0190;
    L_0x018e:
        r5 = r16;
    L_0x0190:
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r5);
        goto L_0x022e;
    L_0x0195:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != r4) goto L_0x01cb;
    L_0x01a1:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r3);
        r10.putInt(r14, r7, r0);
        r0 = r3 + 4;
        goto L_0x022e;
    L_0x01ac:
        r24 = r7;
        r11 = r20;
        r3 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != r5) goto L_0x01cb;
    L_0x01b8:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r3);
        r0 = r10;
        r1 = r32;
        r17 = r3;
        r2 = r7;
        r7 = r17;
        r0.putLong(r1, r2, r4);
        r0 = r7 + 8;
        goto L_0x022e;
    L_0x01cb:
        r0 = r3;
        goto L_0x0238;
    L_0x01ce:
        r24 = r7;
        r11 = r20;
        r0 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x0238;
    L_0x01da:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r0, r9);
        r1 = r9.zzfd;
    L_0x01e0:
        r10.putInt(r14, r7, r1);
        goto L_0x022e;
    L_0x01e4:
        r24 = r7;
        r11 = r20;
        r0 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != 0) goto L_0x0238;
    L_0x01f0:
        r17 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r0, r9);
        r4 = r9.zzfe;
    L_0x01f6:
        r0 = r10;
        r1 = r32;
        r2 = r7;
        r0.putLong(r1, r2, r4);
        r6 = r6 | r18;
        r1 = r11;
        r0 = r17;
        goto L_0x0231;
    L_0x0203:
        r24 = r7;
        r11 = r20;
        r0 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != r4) goto L_0x0238;
    L_0x020f:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r0);
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r1);
        r0 = r0 + 4;
        goto L_0x022e;
    L_0x0219:
        r24 = r7;
        r11 = r20;
        r0 = r21;
        r7 = r22;
        r12 = r33;
        if (r2 != r5) goto L_0x0238;
    L_0x0225:
        r1 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r0);
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r1);
        r0 = r0 + 8;
    L_0x022e:
        r6 = r6 | r18;
    L_0x0230:
        r1 = r11;
    L_0x0231:
        r7 = r24;
        r8 = -1;
        r11 = r36;
        goto L_0x0017;
    L_0x0238:
        r2 = r0;
        r18 = r6;
        r29 = r10;
        r6 = r11;
        r14 = r15;
        goto L_0x035d;
    L_0x0241:
        r25 = r3;
        r24 = r7;
        r5 = r8;
        r11 = r20;
        r4 = r21;
        r7 = r22;
        r3 = 27;
        if (r5 != r3) goto L_0x028f;
    L_0x0250:
        r3 = 2;
        if (r2 != r3) goto L_0x0287;
    L_0x0253:
        r0 = r10.getObject(r14, r7);
        r0 = (com.google.android.gms.internal.clearcut.zzcn) r0;
        r2 = r0.zzu();
        if (r2 != 0) goto L_0x0271;
    L_0x025f:
        r2 = r0.size();
        if (r2 != 0) goto L_0x0268;
    L_0x0265:
        r2 = 10;
        goto L_0x026a;
    L_0x0268:
        r2 = r2 << 1;
    L_0x026a:
        r0 = r0.zzi(r2);
        r10.putObject(r14, r7, r0);
    L_0x0271:
        r5 = r0;
        r0 = r15.zzad(r1);
        r1 = r11;
        r2 = r33;
        r3 = r4;
        r4 = r35;
        r18 = r6;
        r6 = r37;
        r0 = zza(r0, r1, r2, r3, r4, r5, r6);
        r6 = r18;
        goto L_0x0231;
    L_0x0287:
        r18 = r6;
        r29 = r10;
        r30 = r11;
        goto L_0x0358;
    L_0x028f:
        r18 = r6;
        r3 = 49;
        if (r5 > r3) goto L_0x02e6;
    L_0x0295:
        r26 = r10;
        r9 = (long) r0;
        r0 = r31;
        r19 = r1;
        r1 = r32;
        r6 = r2;
        r2 = r33;
        r20 = r25;
        r3 = r4;
        r15 = r4;
        r4 = r35;
        r21 = r5;
        r5 = r11;
        r27 = r6;
        r6 = r20;
        r22 = r7;
        r7 = r27;
        r28 = r21;
        r8 = r19;
        r29 = r26;
        r30 = r11;
        r11 = r28;
        r12 = r22;
        r14 = r37;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14);
        if (r0 != r15) goto L_0x02cf;
    L_0x02c6:
        r2 = r0;
        r6 = r30;
        r7 = r36;
        r14 = r31;
        goto L_0x035f;
    L_0x02cf:
        r14 = r32;
        r12 = r33;
        r13 = r35;
        r9 = r37;
        r6 = r18;
        r7 = r24;
        r10 = r29;
        r1 = r30;
        r8 = -1;
        r11 = r36;
        r15 = r31;
        goto L_0x0017;
    L_0x02e6:
        r19 = r1;
        r27 = r2;
        r15 = r4;
        r28 = r5;
        r22 = r7;
        r29 = r10;
        r30 = r11;
        r20 = r25;
        r1 = 50;
        r9 = r28;
        if (r9 != r1) goto L_0x031d;
    L_0x02fb:
        r7 = r27;
        r1 = 2;
        if (r7 != r1) goto L_0x031a;
    L_0x0300:
        r14 = r31;
        r0 = r31;
        r1 = r32;
        r2 = r33;
        r3 = r15;
        r4 = r35;
        r5 = r19;
        r6 = r20;
        r7 = r22;
        r9 = r37;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9);
        if (r0 != r15) goto L_0x033d;
    L_0x0319:
        goto L_0x033b;
    L_0x031a:
        r14 = r31;
        goto L_0x035a;
    L_0x031d:
        r8 = r0;
        r7 = r27;
        r14 = r31;
        r0 = r31;
        r1 = r32;
        r2 = r33;
        r3 = r15;
        r4 = r35;
        r5 = r30;
        r6 = r20;
        r10 = r22;
        r12 = r19;
        r13 = r37;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13);
        if (r0 != r15) goto L_0x033d;
    L_0x033b:
        r2 = r0;
        goto L_0x035b;
    L_0x033d:
        r12 = r33;
        r13 = r35;
        r9 = r37;
        r15 = r14;
        r6 = r18;
        r7 = r24;
        r10 = r29;
        r1 = r30;
        r8 = -1;
        r11 = r36;
        goto L_0x0389;
    L_0x0350:
        r30 = r5;
        r18 = r6;
        r24 = r7;
        r29 = r10;
    L_0x0358:
        r14 = r15;
        r15 = r4;
    L_0x035a:
        r2 = r15;
    L_0x035b:
        r6 = r30;
    L_0x035d:
        r7 = r36;
    L_0x035f:
        if (r6 != r7) goto L_0x036c;
    L_0x0361:
        if (r7 != 0) goto L_0x0364;
    L_0x0363:
        goto L_0x036c;
    L_0x0364:
        r8 = r2;
        r9 = r6;
        r1 = r18;
        r0 = r24;
        r2 = -1;
        goto L_0x039c;
    L_0x036c:
        r0 = r6;
        r1 = r33;
        r3 = r35;
        r4 = r32;
        r5 = r37;
        r0 = zza(r0, r1, r2, r3, r4, r5);
        r12 = r33;
        r13 = r35;
        r9 = r37;
        r1 = r6;
        r11 = r7;
        r15 = r14;
        r6 = r18;
        r7 = r24;
        r10 = r29;
        r8 = -1;
    L_0x0389:
        r14 = r32;
        goto L_0x0017;
    L_0x038d:
        r18 = r6;
        r24 = r7;
        r29 = r10;
        r7 = r11;
        r14 = r15;
        r9 = r1;
        r2 = r8;
        r1 = r18;
        r8 = r0;
        r0 = r24;
    L_0x039c:
        if (r0 == r2) goto L_0x03a7;
    L_0x039e:
        r2 = (long) r0;
        r10 = r32;
        r0 = r29;
        r0.putInt(r10, r2, r1);
        goto L_0x03a9;
    L_0x03a7:
        r10 = r32;
    L_0x03a9:
        r0 = r14.zzmt;
        if (r0 == 0) goto L_0x03eb;
    L_0x03ad:
        r0 = 0;
        r11 = r14.zzmt;
        r12 = r11.length;
        r5 = r0;
        r13 = r16;
    L_0x03b4:
        if (r13 >= r12) goto L_0x03e4;
    L_0x03b6:
        r1 = r11[r13];
        r6 = r14.zzmx;
        r0 = r14.zzmi;
        r2 = r0[r1];
        r0 = r14.zzag(r1);
        r0 = r0 & r17;
        r3 = (long) r0;
        r0 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r3);
        if (r0 != 0) goto L_0x03cc;
    L_0x03cb:
        goto L_0x03df;
    L_0x03cc:
        r4 = r14.zzaf(r1);
        if (r4 != 0) goto L_0x03d3;
    L_0x03d2:
        goto L_0x03df;
    L_0x03d3:
        r3 = r14.zzmz;
        r3 = r3.zzg(r0);
        r0 = r31;
        r5 = r0.zza(r1, r2, r3, r4, r5, r6);
    L_0x03df:
        r5 = (com.google.android.gms.internal.clearcut.zzey) r5;
        r13 = r13 + 1;
        goto L_0x03b4;
    L_0x03e4:
        if (r5 == 0) goto L_0x03eb;
    L_0x03e6:
        r0 = r14.zzmx;
        r0.zzf(r10, r5);
    L_0x03eb:
        if (r7 != 0) goto L_0x03f7;
    L_0x03ed:
        r0 = r35;
        if (r8 != r0) goto L_0x03f2;
    L_0x03f1:
        goto L_0x03fd;
    L_0x03f2:
        r0 = com.google.android.gms.internal.clearcut.zzco.zzbo();
        throw r0;
    L_0x03f7:
        r0 = r35;
        if (r8 > r0) goto L_0x03fe;
    L_0x03fb:
        if (r9 != r7) goto L_0x03fe;
    L_0x03fd:
        return r8;
    L_0x03fe:
        r0 = com.google.android.gms.internal.clearcut.zzco.zzbo();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.clearcut.zzfl r4, java.lang.Class<?> r5, com.google.android.gms.internal.clearcut.zzay r6) throws java.io.IOException {
        /*
        r0 = com.google.android.gms.internal.clearcut.zzdt.zzgq;
        r4 = r4.ordinal();
        r4 = r0[r4];
        switch(r4) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0080;
            case 3: goto L_0x0073;
            case 4: goto L_0x0066;
            case 5: goto L_0x0066;
            case 6: goto L_0x005d;
            case 7: goto L_0x005d;
            case 8: goto L_0x0054;
            case 9: goto L_0x0047;
            case 10: goto L_0x0047;
            case 11: goto L_0x0047;
            case 12: goto L_0x003c;
            case 13: goto L_0x003c;
            case 14: goto L_0x002f;
            case 15: goto L_0x0024;
            case 16: goto L_0x0019;
            case 17: goto L_0x0013;
            default: goto L_0x000b;
        };
    L_0x000b:
        r1 = new java.lang.RuntimeException;
        r2 = "unsupported field type.";
        r1.<init>(r2);
        throw r1;
    L_0x0013:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzd(r1, r2, r6);
        goto L_0x0099;
    L_0x0019:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6);
        r2 = r6.zzfe;
        r2 = com.google.android.gms.internal.clearcut.zzbk.zza(r2);
        goto L_0x0042;
    L_0x0024:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r1, r2, r6);
        r2 = r6.zzfd;
        r2 = com.google.android.gms.internal.clearcut.zzbk.zzm(r2);
        goto L_0x004d;
    L_0x002f:
        r4 = com.google.android.gms.internal.clearcut.zzea.zzcm();
        r4 = r4.zze(r5);
        r1 = zza(r4, r1, r2, r3, r6);
        goto L_0x0099;
    L_0x003c:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6);
        r2 = r6.zzfe;
    L_0x0042:
        r2 = java.lang.Long.valueOf(r2);
        goto L_0x0051;
    L_0x0047:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r1, r2, r6);
        r2 = r6.zzfd;
    L_0x004d:
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0051:
        r6.zzff = r2;
        goto L_0x0099;
    L_0x0054:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r1, r2);
        r1 = java.lang.Float.valueOf(r1);
        goto L_0x006e;
    L_0x005d:
        r3 = com.google.android.gms.internal.clearcut.zzax.zzd(r1, r2);
        r1 = java.lang.Long.valueOf(r3);
        goto L_0x007b;
    L_0x0066:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r1, r2);
        r1 = java.lang.Integer.valueOf(r1);
    L_0x006e:
        r6.zzff = r1;
        r1 = r2 + 4;
        goto L_0x0099;
    L_0x0073:
        r3 = com.google.android.gms.internal.clearcut.zzax.zze(r1, r2);
        r1 = java.lang.Double.valueOf(r3);
    L_0x007b:
        r6.zzff = r1;
        r1 = r2 + 8;
        goto L_0x0099;
    L_0x0080:
        r1 = com.google.android.gms.internal.clearcut.zzax.zze(r1, r2, r6);
        goto L_0x0099;
    L_0x0085:
        r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r1, r2, r6);
        r2 = r6.zzfe;
        r4 = 0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x0093;
    L_0x0091:
        r2 = 1;
        goto L_0x0094;
    L_0x0093:
        r2 = 0;
    L_0x0094:
        r2 = java.lang.Boolean.valueOf(r2);
        goto L_0x0051;
    L_0x0099:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(byte[], int, int, com.google.android.gms.internal.clearcut.zzfl, java.lang.Class, com.google.android.gms.internal.clearcut.zzay):int");
    }

    static <T> zzds<T> zza(Class<T> cls, zzdm com_google_android_gms_internal_clearcut_zzdm, zzdw com_google_android_gms_internal_clearcut_zzdw, zzcy com_google_android_gms_internal_clearcut_zzcy, zzex<?, ?> com_google_android_gms_internal_clearcut_zzex___, zzbu<?> com_google_android_gms_internal_clearcut_zzbu_, zzdj com_google_android_gms_internal_clearcut_zzdj) {
        zzdm com_google_android_gms_internal_clearcut_zzdm2 = com_google_android_gms_internal_clearcut_zzdm;
        if (com_google_android_gms_internal_clearcut_zzdm2 instanceof zzec) {
            int i;
            int i2;
            int i3;
            int zzcq;
            zzec com_google_android_gms_internal_clearcut_zzec = (zzec) com_google_android_gms_internal_clearcut_zzdm2;
            boolean z = com_google_android_gms_internal_clearcut_zzec.zzcf() == zzg.zzkm;
            if (com_google_android_gms_internal_clearcut_zzec.getFieldCount() == 0) {
                i = 0;
                i2 = i;
                i3 = i2;
            } else {
                int zzcp = com_google_android_gms_internal_clearcut_zzec.zzcp();
                zzcq = com_google_android_gms_internal_clearcut_zzec.zzcq();
                i = com_google_android_gms_internal_clearcut_zzec.zzcu();
                i2 = zzcp;
                i3 = zzcq;
            }
            int[] iArr = new int[(i << 2)];
            Object[] objArr = new Object[(i << 1)];
            int[] iArr2 = com_google_android_gms_internal_clearcut_zzec.zzcr() > 0 ? new int[com_google_android_gms_internal_clearcut_zzec.zzcr()] : null;
            int[] iArr3 = com_google_android_gms_internal_clearcut_zzec.zzcs() > 0 ? new int[com_google_android_gms_internal_clearcut_zzec.zzcs()] : null;
            zzed zzco = com_google_android_gms_internal_clearcut_zzec.zzco();
            if (zzco.next()) {
                zzcq = zzco.zzcx();
                i = 0;
                int i4 = i;
                int i5 = i4;
                while (true) {
                    int zza;
                    if (zzcq >= com_google_android_gms_internal_clearcut_zzec.zzcv() || i >= ((zzcq - i2) << 2)) {
                        int i6;
                        if (zzco.zzda()) {
                            zzcq = (int) zzfd.zza(zzco.zzdb());
                            zza = (int) zzfd.zza(zzco.zzdc());
                            i6 = 0;
                        } else {
                            zzcq = (int) zzfd.zza(zzco.zzdd());
                            if (zzco.zzde()) {
                                zza = (int) zzfd.zza(zzco.zzdf());
                                i6 = zzco.zzdg();
                            } else {
                                zza = 0;
                                i6 = zza;
                            }
                        }
                        iArr[i] = zzco.zzcx();
                        int i7 = i + 1;
                        iArr[i7] = (((zzco.zzdi() ? ErrorDialogData.DYNAMITE_CRASH : 0) | (zzco.zzdh() ? ErrorDialogData.BINDER_CRASH : 0)) | (zzco.zzcy() << 20)) | zzcq;
                        iArr[i + 2] = zza | (i6 << 20);
                        if (zzco.zzdl() != null) {
                            zzcq = (i / 4) << 1;
                            objArr[zzcq] = zzco.zzdl();
                            if (zzco.zzdj() != null) {
                                objArr[zzcq + 1] = zzco.zzdj();
                            } else if (zzco.zzdk() != null) {
                                objArr[zzcq + 1] = zzco.zzdk();
                            }
                        } else if (zzco.zzdj() != null) {
                            objArr[((i / 4) << 1) + 1] = zzco.zzdj();
                        } else if (zzco.zzdk() != null) {
                            objArr[((i / 4) << 1) + 1] = zzco.zzdk();
                        }
                        zzcq = zzco.zzcy();
                        if (zzcq == zzcb.MAP.ordinal()) {
                            zzcq = i4 + 1;
                            iArr2[i4] = i;
                            i4 = zzcq;
                        } else if (zzcq >= 18 && zzcq <= 49) {
                            zzcq = i5 + 1;
                            iArr3[i5] = iArr[i7] & 1048575;
                            i5 = zzcq;
                        }
                        if (!zzco.next()) {
                            break;
                        }
                        zzcq = zzco.zzcx();
                    } else {
                        for (zza = 0; zza < 4; zza++) {
                            iArr[i + zza] = -1;
                        }
                    }
                    i += 4;
                }
            }
            return new zzds(iArr, objArr, i2, i3, com_google_android_gms_internal_clearcut_zzec.zzcv(), com_google_android_gms_internal_clearcut_zzec.zzch(), z, false, com_google_android_gms_internal_clearcut_zzec.zzct(), iArr2, iArr3, com_google_android_gms_internal_clearcut_zzdw, com_google_android_gms_internal_clearcut_zzcy, com_google_android_gms_internal_clearcut_zzex___, com_google_android_gms_internal_clearcut_zzbu_, com_google_android_gms_internal_clearcut_zzdj);
        }
        ((zzes) com_google_android_gms_internal_clearcut_zzdm2).zzcf();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> com_google_android_gms_internal_clearcut_zzck_, UB ub, zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB) {
        zzdh zzl = this.zzmz.zzl(zzae(i));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (com_google_android_gms_internal_clearcut_zzck_.zzb(((Integer) entry.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = com_google_android_gms_internal_clearcut_zzex_UT__UB.zzdz();
                }
                zzbg zzk = zzbb.zzk(zzdg.zza(zzl, entry.getKey(), entry.getValue()));
                try {
                    zzdg.zza(zzk.zzae(), zzl, entry.getKey(), entry.getValue());
                    com_google_android_gms_internal_clearcut_zzex_UT__UB.zza((Object) ub, i2, zzk.zzad());
                    it.remove();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr com_google_android_gms_internal_clearcut_zzfr) throws IOException {
        if (obj instanceof String) {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, (String) obj);
        } else {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> com_google_android_gms_internal_clearcut_zzex_UT__UB, T t, zzfr com_google_android_gms_internal_clearcut_zzfr) throws IOException {
        com_google_android_gms_internal_clearcut_zzex_UT__UB.zza(com_google_android_gms_internal_clearcut_zzex_UT__UB.zzq(t), com_google_android_gms_internal_clearcut_zzfr);
    }

    private final <K, V> void zza(zzfr com_google_android_gms_internal_clearcut_zzfr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            com_google_android_gms_internal_clearcut_zzfr.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza((Object) t2, i)) {
            Object zzo = zzfd.zzo(t, zzag);
            Object zzo2 = zzfd.zzo(t2, zzag);
            if (zzo == null || zzo2 == null) {
                if (zzo2 != null) {
                    zzfd.zza((Object) t, zzag, zzo2);
                    zzb((Object) t, i);
                }
                return;
            }
            zzfd.zza((Object) t, zzag, zzci.zza(zzo, zzo2));
            zzb((Object) t, i);
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzmq) {
            i = zzag(i);
            long j = (long) (i & 1048575);
            switch ((i & 267386880) >>> 20) {
                case 0:
                    return zzfd.zzn(t, j) != 0.0d;
                case 1:
                    return zzfd.zzm(t, j) != 0.0f;
                case 2:
                    return zzfd.zzk(t, j) != 0;
                case 3:
                    return zzfd.zzk(t, j) != 0;
                case 4:
                    return zzfd.zzj(t, j) != 0;
                case 5:
                    return zzfd.zzk(t, j) != 0;
                case 6:
                    return zzfd.zzj(t, j) != 0;
                case 7:
                    return zzfd.zzl(t, j);
                case 8:
                    Object zzo = zzfd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    } else {
                        if (zzo instanceof zzbb) {
                            return !zzbb.zzfi.equals(zzo);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    }
                case 9:
                    return zzfd.zzo(t, j) != null;
                case 10:
                    return !zzbb.zzfi.equals(zzfd.zzo(t, j));
                case 11:
                    return zzfd.zzj(t, j) != 0;
                case 12:
                    return zzfd.zzj(t, j) != 0;
                case 13:
                    return zzfd.zzj(t, j) != 0;
                case 14:
                    return zzfd.zzk(t, j) != 0;
                case 15:
                    return zzfd.zzj(t, j) != 0;
                case 16:
                    return zzfd.zzk(t, j) != 0;
                case 17:
                    return zzfd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        i = zzah(i);
        return (zzfd.zzj(t, (long) (i & 1048575)) & (1 << (i >>> 20))) != 0;
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza((Object) t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzef com_google_android_gms_internal_clearcut_zzef) {
        return com_google_android_gms_internal_clearcut_zzef.zzo(zzfd.zzo(obj, (long) (i & 1048575)));
    }

    private final zzef zzad(int i) {
        i = (i / 4) << 1;
        zzef com_google_android_gms_internal_clearcut_zzef = (zzef) this.zzmj[i];
        if (com_google_android_gms_internal_clearcut_zzef != null) {
            return com_google_android_gms_internal_clearcut_zzef;
        }
        com_google_android_gms_internal_clearcut_zzef = zzea.zzcm().zze((Class) this.zzmj[i + 1]);
        this.zzmj[i] = com_google_android_gms_internal_clearcut_zzef;
        return com_google_android_gms_internal_clearcut_zzef;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        if (i >= this.zzmk) {
            int i2;
            if (i < this.zzmm) {
                i2 = (i - this.zzmk) << 2;
                return this.zzmi[i2] == i ? i2 : -1;
            } else if (i <= this.zzml) {
                i2 = this.zzmm - this.zzmk;
                int length = (this.zzmi.length / 4) - 1;
                while (i2 <= length) {
                    int i3 = (length + i2) >>> 1;
                    int i4 = i3 << 2;
                    int i5 = this.zzmi[i4];
                    if (i == i5) {
                        return i4;
                    }
                    if (i < i5) {
                        length = i3 - 1;
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (!this.zzmq) {
            i = zzah(i);
            long j = (long) (i & 1048575);
            zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (i >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r21, com.google.android.gms.internal.clearcut.zzfr r22) throws java.io.IOException {
        /*
        r20 = this;
        r0 = r20;
        r1 = r21;
        r2 = r22;
        r3 = r0.zzmo;
        if (r3 == 0) goto L_0x0021;
    L_0x000a:
        r3 = r0.zzmy;
        r3 = r3.zza(r1);
        r5 = r3.isEmpty();
        if (r5 != 0) goto L_0x0021;
    L_0x0016:
        r3 = r3.iterator();
        r5 = r3.next();
        r5 = (java.util.Map.Entry) r5;
        goto L_0x0023;
    L_0x0021:
        r3 = 0;
        r5 = 0;
    L_0x0023:
        r6 = -1;
        r7 = r0.zzmi;
        r7 = r7.length;
        r9 = zzmh;
        r10 = r5;
        r5 = 0;
        r11 = 0;
    L_0x002c:
        if (r5 >= r7) goto L_0x0521;
    L_0x002e:
        r12 = r0.zzag(r5);
        r13 = r0.zzmi;
        r13 = r13[r5];
        r14 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r14 = r14 & r12;
        r14 = r14 >>> 20;
        r15 = r0.zzmq;
        r16 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        if (r15 != 0) goto L_0x0061;
    L_0x0042:
        r15 = 17;
        if (r14 > r15) goto L_0x0061;
    L_0x0046:
        r15 = r0.zzmi;
        r17 = r5 + 2;
        r15 = r15[r17];
        r8 = r15 & r16;
        if (r8 == r6) goto L_0x0059;
    L_0x0050:
        r18 = r5;
        r4 = (long) r8;
        r11 = r9.getInt(r1, r4);
        r6 = r8;
        goto L_0x005b;
    L_0x0059:
        r18 = r5;
    L_0x005b:
        r4 = r15 >>> 20;
        r5 = 1;
        r8 = r5 << r4;
        goto L_0x0064;
    L_0x0061:
        r18 = r5;
        r8 = 0;
    L_0x0064:
        if (r10 == 0) goto L_0x0083;
    L_0x0066:
        r4 = r0.zzmy;
        r4 = r4.zza(r10);
        if (r4 > r13) goto L_0x0083;
    L_0x006e:
        r4 = r0.zzmy;
        r4.zza(r2, r10);
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0081;
    L_0x0079:
        r4 = r3.next();
        r4 = (java.util.Map.Entry) r4;
        r10 = r4;
        goto L_0x0064;
    L_0x0081:
        r10 = 0;
        goto L_0x0064;
    L_0x0083:
        r4 = r12 & r16;
        r4 = (long) r4;
        switch(r14) {
            case 0: goto L_0x0510;
            case 1: goto L_0x0502;
            case 2: goto L_0x04f4;
            case 3: goto L_0x04e6;
            case 4: goto L_0x04d8;
            case 5: goto L_0x04ca;
            case 6: goto L_0x04bc;
            case 7: goto L_0x04ae;
            case 8: goto L_0x049f;
            case 9: goto L_0x048c;
            case 10: goto L_0x047b;
            case 11: goto L_0x046c;
            case 12: goto L_0x045d;
            case 13: goto L_0x044e;
            case 14: goto L_0x043f;
            case 15: goto L_0x0430;
            case 16: goto L_0x0421;
            case 17: goto L_0x040e;
            case 18: goto L_0x03fc;
            case 19: goto L_0x03ea;
            case 20: goto L_0x03d8;
            case 21: goto L_0x03c6;
            case 22: goto L_0x03b4;
            case 23: goto L_0x03a2;
            case 24: goto L_0x0390;
            case 25: goto L_0x037e;
            case 26: goto L_0x036d;
            case 27: goto L_0x0358;
            case 28: goto L_0x0347;
            case 29: goto L_0x0334;
            case 30: goto L_0x0323;
            case 31: goto L_0x0312;
            case 32: goto L_0x0301;
            case 33: goto L_0x02f0;
            case 34: goto L_0x02df;
            case 35: goto L_0x02cd;
            case 36: goto L_0x02bb;
            case 37: goto L_0x02a9;
            case 38: goto L_0x0297;
            case 39: goto L_0x0285;
            case 40: goto L_0x0273;
            case 41: goto L_0x0261;
            case 42: goto L_0x024f;
            case 43: goto L_0x023d;
            case 44: goto L_0x022b;
            case 45: goto L_0x0219;
            case 46: goto L_0x0207;
            case 47: goto L_0x01f5;
            case 48: goto L_0x01e3;
            case 49: goto L_0x01ce;
            case 50: goto L_0x01c3;
            case 51: goto L_0x01b2;
            case 52: goto L_0x01a1;
            case 53: goto L_0x0190;
            case 54: goto L_0x017f;
            case 55: goto L_0x016e;
            case 56: goto L_0x015d;
            case 57: goto L_0x014c;
            case 58: goto L_0x013b;
            case 59: goto L_0x012a;
            case 60: goto L_0x0115;
            case 61: goto L_0x0102;
            case 62: goto L_0x00f2;
            case 63: goto L_0x00e2;
            case 64: goto L_0x00d2;
            case 65: goto L_0x00c2;
            case 66: goto L_0x00b2;
            case 67: goto L_0x00a2;
            case 68: goto L_0x008e;
            default: goto L_0x0089;
        };
    L_0x0089:
        r12 = r18;
    L_0x008b:
        r14 = 0;
        goto L_0x051d;
    L_0x008e:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0096:
        r4 = r9.getObject(r1, r4);
        r5 = r0.zzad(r12);
        r2.zzb(r13, r4, r5);
        goto L_0x008b;
    L_0x00a2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00aa:
        r4 = zzh(r1, r4);
        r2.zzb(r13, r4);
        goto L_0x008b;
    L_0x00b2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00ba:
        r4 = zzg(r1, r4);
        r2.zze(r13, r4);
        goto L_0x008b;
    L_0x00c2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00ca:
        r4 = zzh(r1, r4);
        r2.zzj(r13, r4);
        goto L_0x008b;
    L_0x00d2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00da:
        r4 = zzg(r1, r4);
        r2.zzm(r13, r4);
        goto L_0x008b;
    L_0x00e2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00ea:
        r4 = zzg(r1, r4);
        r2.zzn(r13, r4);
        goto L_0x008b;
    L_0x00f2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x00fa:
        r4 = zzg(r1, r4);
        r2.zzd(r13, r4);
        goto L_0x008b;
    L_0x0102:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x010a:
        r4 = r9.getObject(r1, r4);
        r4 = (com.google.android.gms.internal.clearcut.zzbb) r4;
        r2.zza(r13, r4);
        goto L_0x008b;
    L_0x0115:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x011d:
        r4 = r9.getObject(r1, r4);
        r5 = r0.zzad(r12);
        r2.zza(r13, r4, r5);
        goto L_0x008b;
    L_0x012a:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0132:
        r4 = r9.getObject(r1, r4);
        zza(r13, r4, r2);
        goto L_0x008b;
    L_0x013b:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0143:
        r4 = zzi(r1, r4);
        r2.zzb(r13, r4);
        goto L_0x008b;
    L_0x014c:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0154:
        r4 = zzg(r1, r4);
        r2.zzf(r13, r4);
        goto L_0x008b;
    L_0x015d:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0165:
        r4 = zzh(r1, r4);
        r2.zzc(r13, r4);
        goto L_0x008b;
    L_0x016e:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0176:
        r4 = zzg(r1, r4);
        r2.zzc(r13, r4);
        goto L_0x008b;
    L_0x017f:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0187:
        r4 = zzh(r1, r4);
        r2.zza(r13, r4);
        goto L_0x008b;
    L_0x0190:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x0198:
        r4 = zzh(r1, r4);
        r2.zzi(r13, r4);
        goto L_0x008b;
    L_0x01a1:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x01a9:
        r4 = zzf(r1, r4);
        r2.zza(r13, r4);
        goto L_0x008b;
    L_0x01b2:
        r12 = r18;
        r8 = r0.zza(r1, r13, r12);
        if (r8 == 0) goto L_0x008b;
    L_0x01ba:
        r4 = zze(r1, r4);
        r2.zza(r13, r4);
        goto L_0x008b;
    L_0x01c3:
        r12 = r18;
        r4 = r9.getObject(r1, r4);
        r0.zza(r2, r13, r4, r12);
        goto L_0x008b;
    L_0x01ce:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r5 = r0.zzad(r12);
        com.google.android.gms.internal.clearcut.zzeh.zzb(r8, r4, r2, r5);
        goto L_0x008b;
    L_0x01e3:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r13 = 1;
        com.google.android.gms.internal.clearcut.zzeh.zze(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x01f5:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0207:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0219:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x022b:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x023d:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x024f:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0261:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0273:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0285:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x0297:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x02a9:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x02bb:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x02cd:
        r12 = r18;
        r13 = 1;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zza(r8, r4, r2, r13);
        goto L_0x008b;
    L_0x02df:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r13 = 0;
        com.google.android.gms.internal.clearcut.zzeh.zze(r8, r4, r2, r13);
        goto L_0x0344;
    L_0x02f0:
        r12 = r18;
        r13 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r8, r4, r2, r13);
        goto L_0x0344;
    L_0x0301:
        r12 = r18;
        r13 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r8, r4, r2, r13);
        goto L_0x0344;
    L_0x0312:
        r12 = r18;
        r13 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r8, r4, r2, r13);
        goto L_0x0344;
    L_0x0323:
        r12 = r18;
        r13 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r8, r4, r2, r13);
        goto L_0x0344;
    L_0x0334:
        r12 = r18;
        r13 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r8, r4, r2, r13);
    L_0x0344:
        r14 = r13;
        goto L_0x051d;
    L_0x0347:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r8, r4, r2);
        goto L_0x008b;
    L_0x0358:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r5 = r0.zzad(r12);
        com.google.android.gms.internal.clearcut.zzeh.zza(r8, r4, r2, r5);
        goto L_0x008b;
    L_0x036d:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zza(r8, r4, r2);
        goto L_0x008b;
    L_0x037e:
        r12 = r18;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        r14 = 0;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x0390:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03a2:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03b4:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03c6:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03d8:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03ea:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x03fc:
        r12 = r18;
        r14 = 0;
        r8 = r0.zzmi;
        r8 = r8[r12];
        r4 = r9.getObject(r1, r4);
        r4 = (java.util.List) r4;
        com.google.android.gms.internal.clearcut.zzeh.zza(r8, r4, r2, r14);
        goto L_0x051d;
    L_0x040e:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0414:
        r4 = r9.getObject(r1, r4);
        r5 = r0.zzad(r12);
        r2.zzb(r13, r4, r5);
        goto L_0x051d;
    L_0x0421:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0427:
        r4 = r9.getLong(r1, r4);
        r2.zzb(r13, r4);
        goto L_0x051d;
    L_0x0430:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0436:
        r4 = r9.getInt(r1, r4);
        r2.zze(r13, r4);
        goto L_0x051d;
    L_0x043f:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0445:
        r4 = r9.getLong(r1, r4);
        r2.zzj(r13, r4);
        goto L_0x051d;
    L_0x044e:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0454:
        r4 = r9.getInt(r1, r4);
        r2.zzm(r13, r4);
        goto L_0x051d;
    L_0x045d:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0463:
        r4 = r9.getInt(r1, r4);
        r2.zzn(r13, r4);
        goto L_0x051d;
    L_0x046c:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0472:
        r4 = r9.getInt(r1, r4);
        r2.zzd(r13, r4);
        goto L_0x051d;
    L_0x047b:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0481:
        r4 = r9.getObject(r1, r4);
        r4 = (com.google.android.gms.internal.clearcut.zzbb) r4;
        r2.zza(r13, r4);
        goto L_0x051d;
    L_0x048c:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0492:
        r4 = r9.getObject(r1, r4);
        r5 = r0.zzad(r12);
        r2.zza(r13, r4, r5);
        goto L_0x051d;
    L_0x049f:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04a5:
        r4 = r9.getObject(r1, r4);
        zza(r13, r4, r2);
        goto L_0x051d;
    L_0x04ae:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04b4:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r1, r4);
        r2.zzb(r13, r4);
        goto L_0x051d;
    L_0x04bc:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04c2:
        r4 = r9.getInt(r1, r4);
        r2.zzf(r13, r4);
        goto L_0x051d;
    L_0x04ca:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04d0:
        r4 = r9.getLong(r1, r4);
        r2.zzc(r13, r4);
        goto L_0x051d;
    L_0x04d8:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04de:
        r4 = r9.getInt(r1, r4);
        r2.zzc(r13, r4);
        goto L_0x051d;
    L_0x04e6:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04ec:
        r4 = r9.getLong(r1, r4);
        r2.zza(r13, r4);
        goto L_0x051d;
    L_0x04f4:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x04fa:
        r4 = r9.getLong(r1, r4);
        r2.zzi(r13, r4);
        goto L_0x051d;
    L_0x0502:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0508:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzm(r1, r4);
        r2.zza(r13, r4);
        goto L_0x051d;
    L_0x0510:
        r12 = r18;
        r14 = 0;
        r8 = r8 & r11;
        if (r8 == 0) goto L_0x051d;
    L_0x0516:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzn(r1, r4);
        r2.zza(r13, r4);
    L_0x051d:
        r5 = r12 + 4;
        goto L_0x002c;
    L_0x0521:
        if (r10 == 0) goto L_0x0538;
    L_0x0523:
        r4 = r0.zzmy;
        r4.zza(r2, r10);
        r4 = r3.hasNext();
        if (r4 == 0) goto L_0x0536;
    L_0x052e:
        r4 = r3.next();
        r4 = (java.util.Map.Entry) r4;
        r10 = r4;
        goto L_0x0521;
    L_0x0536:
        r10 = 0;
        goto L_0x0521;
    L_0x0538:
        r3 = r0.zzmx;
        zza(r3, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzb(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = (long) (zzag & 1048575);
        if (zza((Object) t2, i2, i)) {
            Object zzo = zzfd.zzo(t, j);
            Object zzo2 = zzfd.zzo(t2, j);
            if (zzo == null || zzo2 == null) {
                if (zzo2 != null) {
                    zzfd.zza((Object) t, j, zzo2);
                    zzb((Object) t, i2, i);
                }
                return;
            }
            zzfd.zza((Object) t, j, zzci.zza(zzo, zzo2));
            zzb((Object) t, i2, i);
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza((Object) t, i) == zza((Object) t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg com_google_android_gms_internal_clearcut_zzcg = (zzcg) obj;
        zzey com_google_android_gms_internal_clearcut_zzey = com_google_android_gms_internal_clearcut_zzcg.zzjp;
        if (com_google_android_gms_internal_clearcut_zzey != zzey.zzea()) {
            return com_google_android_gms_internal_clearcut_zzey;
        }
        com_google_android_gms_internal_clearcut_zzey = zzey.zzeb();
        com_google_android_gms_internal_clearcut_zzcg.zzjp = com_google_android_gms_internal_clearcut_zzey;
        return com_google_android_gms_internal_clearcut_zzey;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
        r9 = this;
        r0 = r9.zzmi;
        r1 = 0;
        r0 = r0.length;
        r2 = r1;
    L_0x0005:
        r3 = 1;
        if (r2 >= r0) goto L_0x01aa;
    L_0x0008:
        r4 = r9.zzag(r2);
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r6 = r4 & r5;
        r6 = (long) r6;
        r8 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = r4 & r8;
        r4 = r4 >>> 20;
        switch(r4) {
            case 0: goto L_0x0190;
            case 1: goto L_0x017f;
            case 2: goto L_0x016c;
            case 3: goto L_0x0159;
            case 4: goto L_0x0148;
            case 5: goto L_0x0135;
            case 6: goto L_0x0124;
            case 7: goto L_0x0112;
            case 8: goto L_0x00fc;
            case 9: goto L_0x00e6;
            case 10: goto L_0x00d0;
            case 11: goto L_0x00be;
            case 12: goto L_0x00ac;
            case 13: goto L_0x009a;
            case 14: goto L_0x0086;
            case 15: goto L_0x0074;
            case 16: goto L_0x0060;
            case 17: goto L_0x004a;
            case 18: goto L_0x003c;
            case 19: goto L_0x003c;
            case 20: goto L_0x003c;
            case 21: goto L_0x003c;
            case 22: goto L_0x003c;
            case 23: goto L_0x003c;
            case 24: goto L_0x003c;
            case 25: goto L_0x003c;
            case 26: goto L_0x003c;
            case 27: goto L_0x003c;
            case 28: goto L_0x003c;
            case 29: goto L_0x003c;
            case 30: goto L_0x003c;
            case 31: goto L_0x003c;
            case 32: goto L_0x003c;
            case 33: goto L_0x003c;
            case 34: goto L_0x003c;
            case 35: goto L_0x003c;
            case 36: goto L_0x003c;
            case 37: goto L_0x003c;
            case 38: goto L_0x003c;
            case 39: goto L_0x003c;
            case 40: goto L_0x003c;
            case 41: goto L_0x003c;
            case 42: goto L_0x003c;
            case 43: goto L_0x003c;
            case 44: goto L_0x003c;
            case 45: goto L_0x003c;
            case 46: goto L_0x003c;
            case 47: goto L_0x003c;
            case 48: goto L_0x003c;
            case 49: goto L_0x003c;
            case 50: goto L_0x003c;
            case 51: goto L_0x001c;
            case 52: goto L_0x001c;
            case 53: goto L_0x001c;
            case 54: goto L_0x001c;
            case 55: goto L_0x001c;
            case 56: goto L_0x001c;
            case 57: goto L_0x001c;
            case 58: goto L_0x001c;
            case 59: goto L_0x001c;
            case 60: goto L_0x001c;
            case 61: goto L_0x001c;
            case 62: goto L_0x001c;
            case 63: goto L_0x001c;
            case 64: goto L_0x001c;
            case 65: goto L_0x001c;
            case 66: goto L_0x001c;
            case 67: goto L_0x001c;
            case 68: goto L_0x001c;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x01a3;
    L_0x001c:
        r4 = r9.zzah(r2);
        r4 = r4 & r5;
        r4 = (long) r4;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r4);
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r4);
        if (r8 != r4) goto L_0x01a2;
    L_0x002c:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x003a:
        goto L_0x018f;
    L_0x003c:
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r4);
        goto L_0x01a3;
    L_0x004a:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0050:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x005e:
        goto L_0x01a2;
    L_0x0060:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0066:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x0072:
        goto L_0x018f;
    L_0x0074:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x007a:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0084:
        goto L_0x01a2;
    L_0x0086:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x008c:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x0098:
        goto L_0x018f;
    L_0x009a:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00a0:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00aa:
        goto L_0x01a2;
    L_0x00ac:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00b2:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00bc:
        goto L_0x018f;
    L_0x00be:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00c4:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x00ce:
        goto L_0x01a2;
    L_0x00d0:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00d6:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x00e4:
        goto L_0x018f;
    L_0x00e6:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x00ec:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x00fa:
        goto L_0x01a2;
    L_0x00fc:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0102:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5);
        if (r4 != 0) goto L_0x01a3;
    L_0x0110:
        goto L_0x018f;
    L_0x0112:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0118:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0122:
        goto L_0x01a2;
    L_0x0124:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x012a:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0134:
        goto L_0x018f;
    L_0x0135:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x013b:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x0147:
        goto L_0x01a2;
    L_0x0148:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x014e:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x0158:
        goto L_0x018f;
    L_0x0159:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x015f:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x016b:
        goto L_0x01a2;
    L_0x016c:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0172:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x017e:
        goto L_0x018f;
    L_0x017f:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0185:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6);
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6);
        if (r4 == r5) goto L_0x01a3;
    L_0x018f:
        goto L_0x01a2;
    L_0x0190:
        r4 = r9.zzc(r10, r11, r2);
        if (r4 == 0) goto L_0x01a2;
    L_0x0196:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6);
        r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6);
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x01a3;
    L_0x01a2:
        r3 = r1;
    L_0x01a3:
        if (r3 != 0) goto L_0x01a6;
    L_0x01a5:
        return r1;
    L_0x01a6:
        r2 = r2 + 4;
        goto L_0x0005;
    L_0x01aa:
        r0 = r9.zzmx;
        r0 = r0.zzq(r10);
        r2 = r9.zzmx;
        r2 = r2.zzq(r11);
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x01bd;
    L_0x01bc:
        return r1;
    L_0x01bd:
        r0 = r9.zzmo;
        if (r0 == 0) goto L_0x01d2;
    L_0x01c1:
        r0 = r9.zzmy;
        r10 = r0.zza(r10);
        r0 = r9.zzmy;
        r11 = r0.zza(r11);
        r10 = r10.equals(r11);
        return r10;
    L_0x01d2:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
        r8 = this;
        r0 = r8.zzmi;
        r1 = 0;
        r0 = r0.length;
        r2 = r1;
    L_0x0005:
        if (r1 >= r0) goto L_0x012e;
    L_0x0007:
        r3 = r8.zzag(r1);
        r4 = r8.zzmi;
        r4 = r4[r1];
        r5 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r5 = r5 & r3;
        r5 = (long) r5;
        r7 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r3 = r3 & r7;
        r3 = r3 >>> 20;
        r7 = 37;
        switch(r3) {
            case 0: goto L_0x011b;
            case 1: goto L_0x0110;
            case 2: goto L_0x0109;
            case 3: goto L_0x0109;
            case 4: goto L_0x0102;
            case 5: goto L_0x0109;
            case 6: goto L_0x0102;
            case 7: goto L_0x00f7;
            case 8: goto L_0x00ea;
            case 9: goto L_0x00dc;
            case 10: goto L_0x00d1;
            case 11: goto L_0x0102;
            case 12: goto L_0x0102;
            case 13: goto L_0x0102;
            case 14: goto L_0x0109;
            case 15: goto L_0x0102;
            case 16: goto L_0x0109;
            case 17: goto L_0x00ca;
            case 18: goto L_0x00d1;
            case 19: goto L_0x00d1;
            case 20: goto L_0x00d1;
            case 21: goto L_0x00d1;
            case 22: goto L_0x00d1;
            case 23: goto L_0x00d1;
            case 24: goto L_0x00d1;
            case 25: goto L_0x00d1;
            case 26: goto L_0x00d1;
            case 27: goto L_0x00d1;
            case 28: goto L_0x00d1;
            case 29: goto L_0x00d1;
            case 30: goto L_0x00d1;
            case 31: goto L_0x00d1;
            case 32: goto L_0x00d1;
            case 33: goto L_0x00d1;
            case 34: goto L_0x00d1;
            case 35: goto L_0x00d1;
            case 36: goto L_0x00d1;
            case 37: goto L_0x00d1;
            case 38: goto L_0x00d1;
            case 39: goto L_0x00d1;
            case 40: goto L_0x00d1;
            case 41: goto L_0x00d1;
            case 42: goto L_0x00d1;
            case 43: goto L_0x00d1;
            case 44: goto L_0x00d1;
            case 45: goto L_0x00d1;
            case 46: goto L_0x00d1;
            case 47: goto L_0x00d1;
            case 48: goto L_0x00d1;
            case 49: goto L_0x00d1;
            case 50: goto L_0x00d1;
            case 51: goto L_0x00bd;
            case 52: goto L_0x00b0;
            case 53: goto L_0x00a2;
            case 54: goto L_0x009b;
            case 55: goto L_0x008d;
            case 56: goto L_0x0086;
            case 57: goto L_0x007f;
            case 58: goto L_0x0071;
            case 59: goto L_0x0069;
            case 60: goto L_0x005b;
            case 61: goto L_0x0053;
            case 62: goto L_0x004c;
            case 63: goto L_0x0045;
            case 64: goto L_0x003e;
            case 65: goto L_0x0036;
            case 66: goto L_0x002f;
            case 67: goto L_0x0027;
            case 68: goto L_0x0020;
            default: goto L_0x001e;
        };
    L_0x001e:
        goto L_0x012a;
    L_0x0020:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0026:
        goto L_0x0061;
    L_0x0027:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x002d:
        goto L_0x00a8;
    L_0x002f:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0035:
        goto L_0x004b;
    L_0x0036:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x003c:
        goto L_0x00a8;
    L_0x003e:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0044:
        goto L_0x004b;
    L_0x0045:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x004b:
        goto L_0x0093;
    L_0x004c:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0052:
        goto L_0x0093;
    L_0x0053:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0059:
        goto L_0x00d1;
    L_0x005b:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0061:
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
        r2 = r2 * 53;
        goto L_0x00d7;
    L_0x0069:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x006f:
        goto L_0x00ea;
    L_0x0071:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0077:
        r2 = r2 * 53;
        r3 = zzi(r9, r5);
        goto L_0x00fd;
    L_0x007f:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0085:
        goto L_0x0093;
    L_0x0086:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x008c:
        goto L_0x00a8;
    L_0x008d:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x0093:
        r2 = r2 * 53;
        r3 = zzg(r9, r5);
        goto L_0x0129;
    L_0x009b:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00a1:
        goto L_0x00a8;
    L_0x00a2:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00a8:
        r2 = r2 * 53;
        r3 = zzh(r9, r5);
        goto L_0x0125;
    L_0x00b0:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00b6:
        r2 = r2 * 53;
        r3 = zzf(r9, r5);
        goto L_0x0116;
    L_0x00bd:
        r3 = r8.zza(r9, r4, r1);
        if (r3 == 0) goto L_0x012a;
    L_0x00c3:
        r2 = r2 * 53;
        r3 = zze(r9, r5);
        goto L_0x0121;
    L_0x00ca:
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
        if (r3 == 0) goto L_0x00e6;
    L_0x00d0:
        goto L_0x00e2;
    L_0x00d1:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
    L_0x00d7:
        r3 = r3.hashCode();
        goto L_0x0129;
    L_0x00dc:
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
        if (r3 == 0) goto L_0x00e6;
    L_0x00e2:
        r7 = r3.hashCode();
    L_0x00e6:
        r2 = r2 * 53;
        r2 = r2 + r7;
        goto L_0x012a;
    L_0x00ea:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5);
        r3 = (java.lang.String) r3;
        r3 = r3.hashCode();
        goto L_0x0129;
    L_0x00f7:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzl(r9, r5);
    L_0x00fd:
        r3 = com.google.android.gms.internal.clearcut.zzci.zzc(r3);
        goto L_0x0129;
    L_0x0102:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzj(r9, r5);
        goto L_0x0129;
    L_0x0109:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzk(r9, r5);
        goto L_0x0125;
    L_0x0110:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzm(r9, r5);
    L_0x0116:
        r3 = java.lang.Float.floatToIntBits(r3);
        goto L_0x0129;
    L_0x011b:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zzn(r9, r5);
    L_0x0121:
        r3 = java.lang.Double.doubleToLongBits(r3);
    L_0x0125:
        r3 = com.google.android.gms.internal.clearcut.zzci.zzl(r3);
    L_0x0129:
        r2 = r2 + r3;
    L_0x012a:
        r1 = r1 + 4;
        goto L_0x0005;
    L_0x012e:
        r2 = r2 * 53;
        r0 = r8.zzmx;
        r0 = r0.zzq(r9);
        r0 = r0.hashCode();
        r2 = r2 + r0;
        r0 = r8.zzmo;
        if (r0 == 0) goto L_0x014c;
    L_0x013f:
        r2 = r2 * 53;
        r0 = r8.zzmy;
        r9 = r0.zza(r9);
        r9 = r9.hashCode();
        r2 = r2 + r9;
    L_0x014c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzmv.newInstance(this.zzmn);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.clearcut.zzfr r15) throws java.io.IOException {
        /*
        r13 = this;
        r0 = r15.zzaj();
        r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkp;
        r2 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        r6 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        if (r0 != r1) goto L_0x04cf;
    L_0x0010:
        r0 = r13.zzmx;
        zza(r0, r14, r15);
        r0 = r13.zzmo;
        if (r0 == 0) goto L_0x0030;
    L_0x0019:
        r0 = r13.zzmy;
        r0 = r0.zza(r14);
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x0030;
    L_0x0025:
        r0 = r0.descendingIterator();
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x0032;
    L_0x0030:
        r0 = r3;
        r1 = r0;
    L_0x0032:
        r7 = r13.zzmi;
        r7 = r7.length;
        r7 = r7 + -4;
    L_0x0037:
        if (r7 < 0) goto L_0x04b7;
    L_0x0039:
        r8 = r13.zzag(r7);
        r9 = r13.zzmi;
        r9 = r9[r7];
    L_0x0041:
        if (r1 == 0) goto L_0x005f;
    L_0x0043:
        r10 = r13.zzmy;
        r10 = r10.zza(r1);
        if (r10 <= r9) goto L_0x005f;
    L_0x004b:
        r10 = r13.zzmy;
        r10.zza(r15, r1);
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x005d;
    L_0x0056:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x0041;
    L_0x005d:
        r1 = r3;
        goto L_0x0041;
    L_0x005f:
        r10 = r8 & r2;
        r10 = r10 >>> 20;
        switch(r10) {
            case 0: goto L_0x04a4;
            case 1: goto L_0x0494;
            case 2: goto L_0x0484;
            case 3: goto L_0x0474;
            case 4: goto L_0x0464;
            case 5: goto L_0x0454;
            case 6: goto L_0x0444;
            case 7: goto L_0x0433;
            case 8: goto L_0x0422;
            case 9: goto L_0x040d;
            case 10: goto L_0x03fa;
            case 11: goto L_0x03e9;
            case 12: goto L_0x03d8;
            case 13: goto L_0x03c7;
            case 14: goto L_0x03b6;
            case 15: goto L_0x03a5;
            case 16: goto L_0x0394;
            case 17: goto L_0x037f;
            case 18: goto L_0x036e;
            case 19: goto L_0x035d;
            case 20: goto L_0x034c;
            case 21: goto L_0x033b;
            case 22: goto L_0x032a;
            case 23: goto L_0x0319;
            case 24: goto L_0x0308;
            case 25: goto L_0x02f7;
            case 26: goto L_0x02e6;
            case 27: goto L_0x02d1;
            case 28: goto L_0x02c0;
            case 29: goto L_0x02af;
            case 30: goto L_0x029e;
            case 31: goto L_0x028d;
            case 32: goto L_0x027c;
            case 33: goto L_0x026b;
            case 34: goto L_0x025a;
            case 35: goto L_0x0249;
            case 36: goto L_0x0238;
            case 37: goto L_0x0227;
            case 38: goto L_0x0216;
            case 39: goto L_0x0205;
            case 40: goto L_0x01f4;
            case 41: goto L_0x01e3;
            case 42: goto L_0x01d2;
            case 43: goto L_0x01c1;
            case 44: goto L_0x01b0;
            case 45: goto L_0x019f;
            case 46: goto L_0x018e;
            case 47: goto L_0x017d;
            case 48: goto L_0x016c;
            case 49: goto L_0x0157;
            case 50: goto L_0x014c;
            case 51: goto L_0x013e;
            case 52: goto L_0x0130;
            case 53: goto L_0x0122;
            case 54: goto L_0x0114;
            case 55: goto L_0x0106;
            case 56: goto L_0x00f8;
            case 57: goto L_0x00ea;
            case 58: goto L_0x00dc;
            case 59: goto L_0x00d4;
            case 60: goto L_0x00cc;
            case 61: goto L_0x00c4;
            case 62: goto L_0x00b6;
            case 63: goto L_0x00a8;
            case 64: goto L_0x009a;
            case 65: goto L_0x008c;
            case 66: goto L_0x007e;
            case 67: goto L_0x0070;
            case 68: goto L_0x0068;
            default: goto L_0x0066;
        };
    L_0x0066:
        goto L_0x04b3;
    L_0x0068:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x006e:
        goto L_0x0385;
    L_0x0070:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0076:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zzh(r14, r10);
        goto L_0x03a0;
    L_0x007e:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0084:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x03b1;
    L_0x008c:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0092:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zzh(r14, r10);
        goto L_0x03c2;
    L_0x009a:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00a0:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x03d3;
    L_0x00a8:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00ae:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x03e4;
    L_0x00b6:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00bc:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x03f5;
    L_0x00c4:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00ca:
        goto L_0x0400;
    L_0x00cc:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00d2:
        goto L_0x0413;
    L_0x00d4:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00da:
        goto L_0x0428;
    L_0x00dc:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00e2:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzi(r14, r10);
        goto L_0x043f;
    L_0x00ea:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00f0:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x0450;
    L_0x00f8:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x00fe:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zzh(r14, r10);
        goto L_0x0460;
    L_0x0106:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x010c:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzg(r14, r10);
        goto L_0x0470;
    L_0x0114:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x011a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zzh(r14, r10);
        goto L_0x0480;
    L_0x0122:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0128:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zzh(r14, r10);
        goto L_0x0490;
    L_0x0130:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0136:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = zzf(r14, r10);
        goto L_0x04a0;
    L_0x013e:
        r10 = r13.zza(r14, r9, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0144:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = zze(r14, r10);
        goto L_0x04b0;
    L_0x014c:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r13.zza(r15, r9, r8, r7);
        goto L_0x04b3;
    L_0x0157:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        r10 = r13.zzad(r7);
        com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r10);
        goto L_0x04b3;
    L_0x016c:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x017d:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x018e:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x019f:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01b0:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01c1:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01d2:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01e3:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x01f4:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0205:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0216:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0227:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0238:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x0249:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r4);
        goto L_0x04b3;
    L_0x025a:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x026b:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x027c:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x028d:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x029e:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x02af:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x02c0:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15);
        goto L_0x04b3;
    L_0x02d1:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        r10 = r13.zzad(r7);
        com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r10);
        goto L_0x04b3;
    L_0x02e6:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15);
        goto L_0x04b3;
    L_0x02f7:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x0308:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x0319:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x032a:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x033b:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x034c:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x035d:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x036e:
        r9 = r13.zzmi;
        r9 = r9[r7];
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (java.util.List) r8;
        com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r5);
        goto L_0x04b3;
    L_0x037f:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0385:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r10 = r13.zzad(r7);
        r15.zzb(r9, r8, r10);
        goto L_0x04b3;
    L_0x0394:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x039a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10);
    L_0x03a0:
        r15.zzb(r9, r10);
        goto L_0x04b3;
    L_0x03a5:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03ab:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x03b1:
        r15.zze(r9, r8);
        goto L_0x04b3;
    L_0x03b6:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03bc:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10);
    L_0x03c2:
        r15.zzj(r9, r10);
        goto L_0x04b3;
    L_0x03c7:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03cd:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x03d3:
        r15.zzm(r9, r8);
        goto L_0x04b3;
    L_0x03d8:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03de:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x03e4:
        r15.zzn(r9, r8);
        goto L_0x04b3;
    L_0x03e9:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x03ef:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x03f5:
        r15.zzd(r9, r8);
        goto L_0x04b3;
    L_0x03fa:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0400:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r8 = (com.google.android.gms.internal.clearcut.zzbb) r8;
        r15.zza(r9, r8);
        goto L_0x04b3;
    L_0x040d:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0413:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        r10 = r13.zzad(r7);
        r15.zza(r9, r8, r10);
        goto L_0x04b3;
    L_0x0422:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0428:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10);
        zza(r9, r8, r15);
        goto L_0x04b3;
    L_0x0433:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x0439:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r10);
    L_0x043f:
        r15.zzb(r9, r8);
        goto L_0x04b3;
    L_0x0444:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x044a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x0450:
        r15.zzf(r9, r8);
        goto L_0x04b3;
    L_0x0454:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x045a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10);
    L_0x0460:
        r15.zzc(r9, r10);
        goto L_0x04b3;
    L_0x0464:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x046a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10);
    L_0x0470:
        r15.zzc(r9, r8);
        goto L_0x04b3;
    L_0x0474:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x047a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10);
    L_0x0480:
        r15.zza(r9, r10);
        goto L_0x04b3;
    L_0x0484:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x048a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10);
    L_0x0490:
        r15.zzi(r9, r10);
        goto L_0x04b3;
    L_0x0494:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x049a:
        r8 = r8 & r6;
        r10 = (long) r8;
        r8 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r10);
    L_0x04a0:
        r15.zza(r9, r8);
        goto L_0x04b3;
    L_0x04a4:
        r10 = r13.zza(r14, r7);
        if (r10 == 0) goto L_0x04b3;
    L_0x04aa:
        r8 = r8 & r6;
        r10 = (long) r8;
        r10 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r10);
    L_0x04b0:
        r15.zza(r9, r10);
    L_0x04b3:
        r7 = r7 + -4;
        goto L_0x0037;
    L_0x04b7:
        if (r1 == 0) goto L_0x04ce;
    L_0x04b9:
        r14 = r13.zzmy;
        r14.zza(r15, r1);
        r14 = r0.hasNext();
        if (r14 == 0) goto L_0x04cc;
    L_0x04c4:
        r14 = r0.next();
        r14 = (java.util.Map.Entry) r14;
        r1 = r14;
        goto L_0x04b7;
    L_0x04cc:
        r1 = r3;
        goto L_0x04b7;
    L_0x04ce:
        return;
    L_0x04cf:
        r0 = r13.zzmq;
        if (r0 == 0) goto L_0x0992;
    L_0x04d3:
        r0 = r13.zzmo;
        if (r0 == 0) goto L_0x04ee;
    L_0x04d7:
        r0 = r13.zzmy;
        r0 = r0.zza(r14);
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x04ee;
    L_0x04e3:
        r0 = r0.iterator();
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        goto L_0x04f0;
    L_0x04ee:
        r0 = r3;
        r1 = r0;
    L_0x04f0:
        r7 = r13.zzmi;
        r7 = r7.length;
        r8 = r1;
        r1 = r5;
    L_0x04f5:
        if (r1 >= r7) goto L_0x0975;
    L_0x04f7:
        r9 = r13.zzag(r1);
        r10 = r13.zzmi;
        r10 = r10[r1];
    L_0x04ff:
        if (r8 == 0) goto L_0x051d;
    L_0x0501:
        r11 = r13.zzmy;
        r11 = r11.zza(r8);
        if (r11 > r10) goto L_0x051d;
    L_0x0509:
        r11 = r13.zzmy;
        r11.zza(r15, r8);
        r8 = r0.hasNext();
        if (r8 == 0) goto L_0x051b;
    L_0x0514:
        r8 = r0.next();
        r8 = (java.util.Map.Entry) r8;
        goto L_0x04ff;
    L_0x051b:
        r8 = r3;
        goto L_0x04ff;
    L_0x051d:
        r11 = r9 & r2;
        r11 = r11 >>> 20;
        switch(r11) {
            case 0: goto L_0x0962;
            case 1: goto L_0x0952;
            case 2: goto L_0x0942;
            case 3: goto L_0x0932;
            case 4: goto L_0x0922;
            case 5: goto L_0x0912;
            case 6: goto L_0x0902;
            case 7: goto L_0x08f1;
            case 8: goto L_0x08e0;
            case 9: goto L_0x08cb;
            case 10: goto L_0x08b8;
            case 11: goto L_0x08a7;
            case 12: goto L_0x0896;
            case 13: goto L_0x0885;
            case 14: goto L_0x0874;
            case 15: goto L_0x0863;
            case 16: goto L_0x0852;
            case 17: goto L_0x083d;
            case 18: goto L_0x082c;
            case 19: goto L_0x081b;
            case 20: goto L_0x080a;
            case 21: goto L_0x07f9;
            case 22: goto L_0x07e8;
            case 23: goto L_0x07d7;
            case 24: goto L_0x07c6;
            case 25: goto L_0x07b5;
            case 26: goto L_0x07a4;
            case 27: goto L_0x078f;
            case 28: goto L_0x077e;
            case 29: goto L_0x076d;
            case 30: goto L_0x075c;
            case 31: goto L_0x074b;
            case 32: goto L_0x073a;
            case 33: goto L_0x0729;
            case 34: goto L_0x0718;
            case 35: goto L_0x0707;
            case 36: goto L_0x06f6;
            case 37: goto L_0x06e5;
            case 38: goto L_0x06d4;
            case 39: goto L_0x06c3;
            case 40: goto L_0x06b2;
            case 41: goto L_0x06a1;
            case 42: goto L_0x0690;
            case 43: goto L_0x067f;
            case 44: goto L_0x066e;
            case 45: goto L_0x065d;
            case 46: goto L_0x064c;
            case 47: goto L_0x063b;
            case 48: goto L_0x062a;
            case 49: goto L_0x0615;
            case 50: goto L_0x060a;
            case 51: goto L_0x05fc;
            case 52: goto L_0x05ee;
            case 53: goto L_0x05e0;
            case 54: goto L_0x05d2;
            case 55: goto L_0x05c4;
            case 56: goto L_0x05b6;
            case 57: goto L_0x05a8;
            case 58: goto L_0x059a;
            case 59: goto L_0x0592;
            case 60: goto L_0x058a;
            case 61: goto L_0x0582;
            case 62: goto L_0x0574;
            case 63: goto L_0x0566;
            case 64: goto L_0x0558;
            case 65: goto L_0x054a;
            case 66: goto L_0x053c;
            case 67: goto L_0x052e;
            case 68: goto L_0x0526;
            default: goto L_0x0524;
        };
    L_0x0524:
        goto L_0x0971;
    L_0x0526:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x052c:
        goto L_0x0843;
    L_0x052e:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0534:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zzh(r14, r11);
        goto L_0x085e;
    L_0x053c:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0542:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x086f;
    L_0x054a:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0550:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zzh(r14, r11);
        goto L_0x0880;
    L_0x0558:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x055e:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x0891;
    L_0x0566:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x056c:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x08a2;
    L_0x0574:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x057a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x08b3;
    L_0x0582:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0588:
        goto L_0x08be;
    L_0x058a:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0590:
        goto L_0x08d1;
    L_0x0592:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0598:
        goto L_0x08e6;
    L_0x059a:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05a0:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzi(r14, r11);
        goto L_0x08fd;
    L_0x05a8:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05ae:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x090e;
    L_0x05b6:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05bc:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zzh(r14, r11);
        goto L_0x091e;
    L_0x05c4:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05ca:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzg(r14, r11);
        goto L_0x092e;
    L_0x05d2:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05d8:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zzh(r14, r11);
        goto L_0x093e;
    L_0x05e0:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05e6:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zzh(r14, r11);
        goto L_0x094e;
    L_0x05ee:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x05f4:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = zzf(r14, r11);
        goto L_0x095e;
    L_0x05fc:
        r11 = r13.zza(r14, r10, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0602:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = zze(r14, r11);
        goto L_0x096e;
    L_0x060a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r13.zza(r15, r10, r9, r1);
        goto L_0x0971;
    L_0x0615:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        r11 = r13.zzad(r1);
        com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r11);
        goto L_0x0971;
    L_0x062a:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x063b:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x064c:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x065d:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x066e:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x067f:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0690:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06a1:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06b2:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06c3:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06d4:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06e5:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x06f6:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0707:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r4);
        goto L_0x0971;
    L_0x0718:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x0729:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x073a:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x074b:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x075c:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x076d:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x077e:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15);
        goto L_0x0971;
    L_0x078f:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        r11 = r13.zzad(r1);
        com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r11);
        goto L_0x0971;
    L_0x07a4:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15);
        goto L_0x0971;
    L_0x07b5:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07c6:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07d7:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07e8:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x07f9:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x080a:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x081b:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x082c:
        r10 = r13.zzmi;
        r10 = r10[r1];
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (java.util.List) r9;
        com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r5);
        goto L_0x0971;
    L_0x083d:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0843:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r11 = r13.zzad(r1);
        r15.zzb(r10, r9, r11);
        goto L_0x0971;
    L_0x0852:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0858:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11);
    L_0x085e:
        r15.zzb(r10, r11);
        goto L_0x0971;
    L_0x0863:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0869:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x086f:
        r15.zze(r10, r9);
        goto L_0x0971;
    L_0x0874:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x087a:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11);
    L_0x0880:
        r15.zzj(r10, r11);
        goto L_0x0971;
    L_0x0885:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x088b:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x0891:
        r15.zzm(r10, r9);
        goto L_0x0971;
    L_0x0896:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x089c:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x08a2:
        r15.zzn(r10, r9);
        goto L_0x0971;
    L_0x08a7:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08ad:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x08b3:
        r15.zzd(r10, r9);
        goto L_0x0971;
    L_0x08b8:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08be:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r9 = (com.google.android.gms.internal.clearcut.zzbb) r9;
        r15.zza(r10, r9);
        goto L_0x0971;
    L_0x08cb:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08d1:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        r11 = r13.zzad(r1);
        r15.zza(r10, r9, r11);
        goto L_0x0971;
    L_0x08e0:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08e6:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11);
        zza(r10, r9, r15);
        goto L_0x0971;
    L_0x08f1:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x08f7:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r11);
    L_0x08fd:
        r15.zzb(r10, r9);
        goto L_0x0971;
    L_0x0902:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0908:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x090e:
        r15.zzf(r10, r9);
        goto L_0x0971;
    L_0x0912:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0918:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11);
    L_0x091e:
        r15.zzc(r10, r11);
        goto L_0x0971;
    L_0x0922:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0928:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11);
    L_0x092e:
        r15.zzc(r10, r9);
        goto L_0x0971;
    L_0x0932:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0938:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11);
    L_0x093e:
        r15.zza(r10, r11);
        goto L_0x0971;
    L_0x0942:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0948:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11);
    L_0x094e:
        r15.zzi(r10, r11);
        goto L_0x0971;
    L_0x0952:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0958:
        r9 = r9 & r6;
        r11 = (long) r9;
        r9 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r11);
    L_0x095e:
        r15.zza(r10, r9);
        goto L_0x0971;
    L_0x0962:
        r11 = r13.zza(r14, r1);
        if (r11 == 0) goto L_0x0971;
    L_0x0968:
        r9 = r9 & r6;
        r11 = (long) r9;
        r11 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r11);
    L_0x096e:
        r15.zza(r10, r11);
    L_0x0971:
        r1 = r1 + 4;
        goto L_0x04f5;
    L_0x0975:
        if (r8 == 0) goto L_0x098c;
    L_0x0977:
        r1 = r13.zzmy;
        r1.zza(r15, r8);
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x098a;
    L_0x0982:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r8 = r1;
        goto L_0x0975;
    L_0x098a:
        r8 = r3;
        goto L_0x0975;
    L_0x098c:
        r0 = r13.zzmx;
        zza(r0, r14, r15);
        return;
    L_0x0992:
        r13.zzb(r14, r15);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r25, byte[] r26, int r27, int r28, com.google.android.gms.internal.clearcut.zzay r29) throws java.io.IOException {
        /*
        r24 = this;
        r15 = r24;
        r14 = r25;
        r12 = r26;
        r13 = r28;
        r11 = r29;
        r0 = r15.zzmq;
        if (r0 == 0) goto L_0x01e1;
    L_0x000e:
        r9 = zzmh;
        r0 = r27;
    L_0x0012:
        if (r0 >= r13) goto L_0x01d8;
    L_0x0014:
        r1 = r0 + 1;
        r0 = r12[r0];
        if (r0 >= 0) goto L_0x0024;
    L_0x001a:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r0, r12, r1, r11);
        r1 = r11.zzfd;
        r10 = r0;
        r16 = r1;
        goto L_0x0027;
    L_0x0024:
        r16 = r0;
        r10 = r1;
    L_0x0027:
        r6 = r16 >>> 3;
        r7 = r16 & 7;
        r8 = r15.zzai(r6);
        if (r8 < 0) goto L_0x01b8;
    L_0x0031:
        r0 = r15.zzmi;
        r1 = r8 + 1;
        r5 = r0[r1];
        r0 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r0 = r0 & r5;
        r4 = r0 >>> 20;
        r0 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r0 = r0 & r5;
        r2 = (long) r0;
        r0 = 17;
        r1 = 2;
        if (r4 > r0) goto L_0x0106;
    L_0x0046:
        r0 = 5;
        r6 = 1;
        switch(r4) {
            case 0: goto L_0x00f9;
            case 1: goto L_0x00ec;
            case 2: goto L_0x00db;
            case 3: goto L_0x00db;
            case 4: goto L_0x00ce;
            case 5: goto L_0x00c1;
            case 6: goto L_0x00b7;
            case 7: goto L_0x00a2;
            case 8: goto L_0x0091;
            case 9: goto L_0x0079;
            case 10: goto L_0x006d;
            case 11: goto L_0x00ce;
            case 12: goto L_0x0069;
            case 13: goto L_0x00b7;
            case 14: goto L_0x00c1;
            case 15: goto L_0x005b;
            case 16: goto L_0x004d;
            default: goto L_0x004b;
        };
    L_0x004b:
        goto L_0x01b8;
    L_0x004d:
        if (r7 != 0) goto L_0x01b8;
    L_0x004f:
        r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11);
        r0 = r11.zzfe;
        r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0);
        goto L_0x00e3;
    L_0x005b:
        if (r7 != 0) goto L_0x01b8;
    L_0x005d:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
        r1 = com.google.android.gms.internal.clearcut.zzbk.zzm(r1);
        goto L_0x00d6;
    L_0x0069:
        if (r7 != 0) goto L_0x01b8;
    L_0x006b:
        goto L_0x00d0;
    L_0x006d:
        if (r7 != r1) goto L_0x01b8;
    L_0x006f:
        r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10, r11);
    L_0x0073:
        r1 = r11.zzff;
    L_0x0075:
        r9.putObject(r14, r2, r1);
        goto L_0x0012;
    L_0x0079:
        if (r7 != r1) goto L_0x01b8;
    L_0x007b:
        r0 = r15.zzad(r8);
        r0 = zza(r0, r12, r10, r13, r11);
        r1 = r9.getObject(r14, r2);
        if (r1 != 0) goto L_0x008a;
    L_0x0089:
        goto L_0x0073;
    L_0x008a:
        r4 = r11.zzff;
        r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r4);
        goto L_0x0075;
    L_0x0091:
        if (r7 != r1) goto L_0x01b8;
    L_0x0093:
        r0 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
        r0 = r0 & r5;
        if (r0 != 0) goto L_0x009d;
    L_0x0098:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10, r11);
        goto L_0x0073;
    L_0x009d:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10, r11);
        goto L_0x0073;
    L_0x00a2:
        if (r7 != 0) goto L_0x01b8;
    L_0x00a4:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11);
        r4 = r11.zzfe;
        r7 = 0;
        r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1));
        if (r1 == 0) goto L_0x00b1;
    L_0x00b0:
        goto L_0x00b2;
    L_0x00b1:
        r6 = 0;
    L_0x00b2:
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r6);
        goto L_0x0012;
    L_0x00b7:
        if (r7 != r0) goto L_0x01b8;
    L_0x00b9:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10);
        r9.putInt(r14, r2, r0);
        goto L_0x00f5;
    L_0x00c1:
        if (r7 != r6) goto L_0x01b8;
    L_0x00c3:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10);
        r0 = r9;
        r1 = r25;
        r0.putLong(r1, r2, r4);
        goto L_0x0102;
    L_0x00ce:
        if (r7 != 0) goto L_0x01b8;
    L_0x00d0:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
    L_0x00d6:
        r9.putInt(r14, r2, r1);
        goto L_0x0012;
    L_0x00db:
        if (r7 != 0) goto L_0x01b8;
    L_0x00dd:
        r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11);
        r4 = r11.zzfe;
    L_0x00e3:
        r0 = r9;
        r1 = r25;
        r0.putLong(r1, r2, r4);
        r0 = r6;
        goto L_0x0012;
    L_0x00ec:
        if (r7 != r0) goto L_0x01b8;
    L_0x00ee:
        r0 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r10);
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r0);
    L_0x00f5:
        r0 = r10 + 4;
        goto L_0x0012;
    L_0x00f9:
        if (r7 != r6) goto L_0x01b8;
    L_0x00fb:
        r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10);
        com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r0);
    L_0x0102:
        r0 = r10 + 8;
        goto L_0x0012;
    L_0x0106:
        r0 = 27;
        if (r4 != r0) goto L_0x013e;
    L_0x010a:
        if (r7 != r1) goto L_0x01b8;
    L_0x010c:
        r0 = r9.getObject(r14, r2);
        r0 = (com.google.android.gms.internal.clearcut.zzcn) r0;
        r1 = r0.zzu();
        if (r1 != 0) goto L_0x012a;
    L_0x0118:
        r1 = r0.size();
        if (r1 != 0) goto L_0x0121;
    L_0x011e:
        r1 = 10;
        goto L_0x0123;
    L_0x0121:
        r1 = r1 << 1;
    L_0x0123:
        r0 = r0.zzi(r1);
        r9.putObject(r14, r2, r0);
    L_0x012a:
        r5 = r0;
        r0 = r15.zzad(r8);
        r1 = r16;
        r2 = r26;
        r3 = r10;
        r4 = r28;
        r6 = r29;
        r0 = zza(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0012;
    L_0x013e:
        r0 = 49;
        if (r4 > r0) goto L_0x0177;
    L_0x0142:
        r0 = (long) r5;
        r17 = r0;
        r0 = r24;
        r1 = r25;
        r19 = r2;
        r2 = r26;
        r3 = r10;
        r5 = r4;
        r4 = r28;
        r21 = r5;
        r5 = r16;
        r22 = r9;
        r15 = r10;
        r9 = r17;
        r11 = r21;
        r12 = r19;
        r14 = r29;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14);
        if (r0 != r15) goto L_0x0169;
    L_0x0166:
        r2 = r0;
        goto L_0x01bc;
    L_0x0169:
        r14 = r25;
        r12 = r26;
        r13 = r28;
        r11 = r29;
        r9 = r22;
        r15 = r24;
        goto L_0x0012;
    L_0x0177:
        r19 = r2;
        r21 = r4;
        r22 = r9;
        r15 = r10;
        r0 = 50;
        r9 = r21;
        if (r9 != r0) goto L_0x019e;
    L_0x0184:
        if (r7 != r1) goto L_0x019c;
    L_0x0186:
        r14 = r15;
        r0 = r24;
        r1 = r25;
        r2 = r26;
        r3 = r14;
        r4 = r28;
        r5 = r8;
        r7 = r19;
        r9 = r29;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9);
        if (r0 != r14) goto L_0x01ca;
    L_0x019b:
        goto L_0x0166;
    L_0x019c:
        r14 = r15;
        goto L_0x01bb;
    L_0x019e:
        r14 = r15;
        r0 = r24;
        r1 = r25;
        r2 = r26;
        r3 = r14;
        r4 = r28;
        r10 = r5;
        r5 = r16;
        r12 = r8;
        r8 = r10;
        r10 = r19;
        r13 = r29;
        r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13);
        if (r0 != r14) goto L_0x01ca;
    L_0x01b7:
        goto L_0x0166;
    L_0x01b8:
        r22 = r9;
        r14 = r10;
    L_0x01bb:
        r2 = r14;
    L_0x01bc:
        r0 = r16;
        r1 = r26;
        r3 = r28;
        r4 = r25;
        r5 = r29;
        r0 = zza(r0, r1, r2, r3, r4, r5);
    L_0x01ca:
        r15 = r24;
        r14 = r25;
        r12 = r26;
        r13 = r28;
        r11 = r29;
        r9 = r22;
        goto L_0x0012;
    L_0x01d8:
        r4 = r13;
        if (r0 != r4) goto L_0x01dc;
    L_0x01db:
        return;
    L_0x01dc:
        r0 = com.google.android.gms.internal.clearcut.zzco.zzbo();
        throw r0;
    L_0x01e1:
        r4 = r13;
        r5 = 0;
        r0 = r24;
        r1 = r25;
        r2 = r26;
        r3 = r27;
        r4 = r28;
        r6 = r29;
        r0.zza(r1, r2, r3, r4, r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):void");
    }

    public final void zzc(T t) {
        int length;
        int i = 0;
        if (this.zzmt != null) {
            for (int zzag : this.zzmt) {
                long zzag2 = (long) (zzag(zzag) & 1048575);
                Object zzo = zzfd.zzo(t, zzag2);
                if (zzo != null) {
                    zzfd.zza((Object) t, zzag2, this.zzmz.zzj(zzo));
                }
            }
        }
        if (this.zzmu != null) {
            int[] iArr = this.zzmu;
            length = iArr.length;
            while (i < length) {
                this.zzmw.zza(t, (long) iArr[i]);
                i++;
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(T r7, T r8) {
        /*
        r6 = this;
        if (r8 == 0) goto L_0x0105;
    L_0x0002:
        r0 = 0;
    L_0x0003:
        r1 = r6.zzmi;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x00f2;
    L_0x0008:
        r1 = r6.zzag(r0);
        r2 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r2 = r2 & r1;
        r2 = (long) r2;
        r4 = r6.zzmi;
        r4 = r4[r0];
        r5 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r1 = r1 & r5;
        r1 = r1 >>> 20;
        switch(r1) {
            case 0: goto L_0x00de;
            case 1: goto L_0x00d0;
            case 2: goto L_0x00c2;
            case 3: goto L_0x00bb;
            case 4: goto L_0x00ad;
            case 5: goto L_0x00a6;
            case 6: goto L_0x009f;
            case 7: goto L_0x0091;
            case 8: goto L_0x0083;
            case 9: goto L_0x007e;
            case 10: goto L_0x0077;
            case 11: goto L_0x0070;
            case 12: goto L_0x0069;
            case 13: goto L_0x0062;
            case 14: goto L_0x005a;
            case 15: goto L_0x0053;
            case 16: goto L_0x004b;
            case 17: goto L_0x007e;
            case 18: goto L_0x0044;
            case 19: goto L_0x0044;
            case 20: goto L_0x0044;
            case 21: goto L_0x0044;
            case 22: goto L_0x0044;
            case 23: goto L_0x0044;
            case 24: goto L_0x0044;
            case 25: goto L_0x0044;
            case 26: goto L_0x0044;
            case 27: goto L_0x0044;
            case 28: goto L_0x0044;
            case 29: goto L_0x0044;
            case 30: goto L_0x0044;
            case 31: goto L_0x0044;
            case 32: goto L_0x0044;
            case 33: goto L_0x0044;
            case 34: goto L_0x0044;
            case 35: goto L_0x0044;
            case 36: goto L_0x0044;
            case 37: goto L_0x0044;
            case 38: goto L_0x0044;
            case 39: goto L_0x0044;
            case 40: goto L_0x0044;
            case 41: goto L_0x0044;
            case 42: goto L_0x0044;
            case 43: goto L_0x0044;
            case 44: goto L_0x0044;
            case 45: goto L_0x0044;
            case 46: goto L_0x0044;
            case 47: goto L_0x0044;
            case 48: goto L_0x0044;
            case 49: goto L_0x0044;
            case 50: goto L_0x003d;
            case 51: goto L_0x002b;
            case 52: goto L_0x002b;
            case 53: goto L_0x002b;
            case 54: goto L_0x002b;
            case 55: goto L_0x002b;
            case 56: goto L_0x002b;
            case 57: goto L_0x002b;
            case 58: goto L_0x002b;
            case 59: goto L_0x002b;
            case 60: goto L_0x0026;
            case 61: goto L_0x001f;
            case 62: goto L_0x001f;
            case 63: goto L_0x001f;
            case 64: goto L_0x001f;
            case 65: goto L_0x001f;
            case 66: goto L_0x001f;
            case 67: goto L_0x001f;
            case 68: goto L_0x0026;
            default: goto L_0x001d;
        };
    L_0x001d:
        goto L_0x00ee;
    L_0x001f:
        r1 = r6.zza(r8, r4, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0025:
        goto L_0x0031;
    L_0x0026:
        r6.zzb(r7, r8, r0);
        goto L_0x00ee;
    L_0x002b:
        r1 = r6.zza(r8, r4, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0031:
        r1 = com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r1);
        r6.zzb(r7, r4, r0);
        goto L_0x00ee;
    L_0x003d:
        r1 = r6.zzmz;
        com.google.android.gms.internal.clearcut.zzeh.zza(r1, r7, r8, r2);
        goto L_0x00ee;
    L_0x0044:
        r1 = r6.zzmw;
        r1.zza(r7, r8, r2);
        goto L_0x00ee;
    L_0x004b:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0051:
        goto L_0x00c8;
    L_0x0053:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0059:
        goto L_0x006f;
    L_0x005a:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0060:
        goto L_0x00c8;
    L_0x0062:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0068:
        goto L_0x006f;
    L_0x0069:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x006f:
        goto L_0x00b3;
    L_0x0070:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0076:
        goto L_0x00b3;
    L_0x0077:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x007d:
        goto L_0x0089;
    L_0x007e:
        r6.zza(r7, r8, r0);
        goto L_0x00ee;
    L_0x0083:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0089:
        r1 = com.google.android.gms.internal.clearcut.zzfd.zzo(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r1);
        goto L_0x00eb;
    L_0x0091:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x0097:
        r1 = com.google.android.gms.internal.clearcut.zzfd.zzl(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r1);
        goto L_0x00eb;
    L_0x009f:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00a5:
        goto L_0x00b3;
    L_0x00a6:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00ac:
        goto L_0x00c8;
    L_0x00ad:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00b3:
        r1 = com.google.android.gms.internal.clearcut.zzfd.zzj(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r1);
        goto L_0x00eb;
    L_0x00bb:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00c1:
        goto L_0x00c8;
    L_0x00c2:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00c8:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r4);
        goto L_0x00eb;
    L_0x00d0:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00d6:
        r1 = com.google.android.gms.internal.clearcut.zzfd.zzm(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r1);
        goto L_0x00eb;
    L_0x00de:
        r1 = r6.zza(r8, r0);
        if (r1 == 0) goto L_0x00ee;
    L_0x00e4:
        r4 = com.google.android.gms.internal.clearcut.zzfd.zzn(r8, r2);
        com.google.android.gms.internal.clearcut.zzfd.zza(r7, r2, r4);
    L_0x00eb:
        r6.zzb(r7, r0);
    L_0x00ee:
        r0 = r0 + 4;
        goto L_0x0003;
    L_0x00f2:
        r0 = r6.zzmq;
        if (r0 != 0) goto L_0x0104;
    L_0x00f6:
        r0 = r6.zzmx;
        com.google.android.gms.internal.clearcut.zzeh.zza(r0, r7, r8);
        r0 = r6.zzmo;
        if (r0 == 0) goto L_0x0104;
    L_0x00ff:
        r0 = r6.zzmy;
        com.google.android.gms.internal.clearcut.zzeh.zza(r0, r7, r8);
    L_0x0104:
        return;
    L_0x0105:
        r7 = new java.lang.NullPointerException;
        r7.<init>();
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzc(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzm(T r22) {
        /*
        r21 = this;
        r0 = r21;
        r1 = r22;
        r2 = r0.zzmq;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r4 = 0;
        r7 = 1;
        r8 = 1048575; // 0xfffff float:1.469367E-39 double:5.18065E-318;
        r9 = 0;
        r11 = 0;
        if (r2 == 0) goto L_0x03b8;
    L_0x0012:
        r2 = zzmh;
        r12 = r11;
        r13 = r12;
    L_0x0016:
        r14 = r0.zzmi;
        r14 = r14.length;
        if (r12 >= r14) goto L_0x03b0;
    L_0x001b:
        r14 = r0.zzag(r12);
        r15 = r14 & r3;
        r15 = r15 >>> 20;
        r3 = r0.zzmi;
        r3 = r3[r12];
        r14 = r14 & r8;
        r5 = (long) r14;
        r14 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED;
        r14 = r14.id();
        if (r15 < r14) goto L_0x0041;
    L_0x0031:
        r14 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED;
        r14 = r14.id();
        if (r15 > r14) goto L_0x0041;
    L_0x0039:
        r14 = r0.zzmi;
        r17 = r12 + 2;
        r14 = r14[r17];
        r14 = r14 & r8;
        goto L_0x0042;
    L_0x0041:
        r14 = r11;
    L_0x0042:
        switch(r15) {
            case 0: goto L_0x039c;
            case 1: goto L_0x0390;
            case 2: goto L_0x0380;
            case 3: goto L_0x0370;
            case 4: goto L_0x0360;
            case 5: goto L_0x0354;
            case 6: goto L_0x0348;
            case 7: goto L_0x033c;
            case 8: goto L_0x0325;
            case 9: goto L_0x0311;
            case 10: goto L_0x0300;
            case 11: goto L_0x02f1;
            case 12: goto L_0x02e2;
            case 13: goto L_0x02d7;
            case 14: goto L_0x02cc;
            case 15: goto L_0x02bd;
            case 16: goto L_0x02ae;
            case 17: goto L_0x0299;
            case 18: goto L_0x028e;
            case 19: goto L_0x0285;
            case 20: goto L_0x027c;
            case 21: goto L_0x0273;
            case 22: goto L_0x026a;
            case 23: goto L_0x028e;
            case 24: goto L_0x0285;
            case 25: goto L_0x0261;
            case 26: goto L_0x0258;
            case 27: goto L_0x024b;
            case 28: goto L_0x0242;
            case 29: goto L_0x0239;
            case 30: goto L_0x0230;
            case 31: goto L_0x0285;
            case 32: goto L_0x028e;
            case 33: goto L_0x0227;
            case 34: goto L_0x021d;
            case 35: goto L_0x01fd;
            case 36: goto L_0x01ec;
            case 37: goto L_0x01db;
            case 38: goto L_0x01ca;
            case 39: goto L_0x01b9;
            case 40: goto L_0x01a8;
            case 41: goto L_0x0197;
            case 42: goto L_0x0185;
            case 43: goto L_0x0173;
            case 44: goto L_0x0161;
            case 45: goto L_0x014f;
            case 46: goto L_0x013d;
            case 47: goto L_0x012b;
            case 48: goto L_0x0119;
            case 49: goto L_0x010b;
            case 50: goto L_0x00fb;
            case 51: goto L_0x00f3;
            case 52: goto L_0x00eb;
            case 53: goto L_0x00df;
            case 54: goto L_0x00d3;
            case 55: goto L_0x00c7;
            case 56: goto L_0x00bf;
            case 57: goto L_0x00b7;
            case 58: goto L_0x00af;
            case 59: goto L_0x009f;
            case 60: goto L_0x0097;
            case 61: goto L_0x008f;
            case 62: goto L_0x0083;
            case 63: goto L_0x0077;
            case 64: goto L_0x006f;
            case 65: goto L_0x0067;
            case 66: goto L_0x005b;
            case 67: goto L_0x004f;
            case 68: goto L_0x0047;
            default: goto L_0x0045;
        };
    L_0x0045:
        goto L_0x03aa;
    L_0x0047:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x004d:
        goto L_0x029f;
    L_0x004f:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0055:
        r5 = zzh(r1, r5);
        goto L_0x02b8;
    L_0x005b:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0061:
        r5 = zzg(r1, r5);
        goto L_0x02c7;
    L_0x0067:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x006d:
        goto L_0x02d2;
    L_0x006f:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0075:
        goto L_0x02dd;
    L_0x0077:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x007d:
        r5 = zzg(r1, r5);
        goto L_0x02ec;
    L_0x0083:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0089:
        r5 = zzg(r1, r5);
        goto L_0x02fb;
    L_0x008f:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0095:
        goto L_0x0306;
    L_0x0097:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x009d:
        goto L_0x0317;
    L_0x009f:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00a5:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.clearcut.zzbb;
        if (r6 == 0) goto L_0x0334;
    L_0x00ad:
        goto L_0x0333;
    L_0x00af:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00b5:
        goto L_0x0342;
    L_0x00b7:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00bd:
        goto L_0x034e;
    L_0x00bf:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00c5:
        goto L_0x035a;
    L_0x00c7:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00cd:
        r5 = zzg(r1, r5);
        goto L_0x036a;
    L_0x00d3:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00d9:
        r5 = zzh(r1, r5);
        goto L_0x037a;
    L_0x00df:
        r14 = r0.zza(r1, r3, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x00e5:
        r5 = zzh(r1, r5);
        goto L_0x038a;
    L_0x00eb:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00f1:
        goto L_0x0396;
    L_0x00f3:
        r5 = r0.zza(r1, r3, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x00f9:
        goto L_0x03a2;
    L_0x00fb:
        r14 = r0.zzmz;
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
        r6 = r0.zzae(r12);
        r3 = r14.zzb(r3, r5, r6);
        goto L_0x0296;
    L_0x010b:
        r5 = zzd(r1, r5);
        r6 = r0.zzad(r12);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r5, r6);
        goto L_0x0296;
    L_0x0119:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzc(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0125:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x0129:
        goto L_0x020d;
    L_0x012b:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzg(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0137:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x013b:
        goto L_0x020d;
    L_0x013d:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0149:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x014d:
        goto L_0x020d;
    L_0x014f:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x015b:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x015f:
        goto L_0x020d;
    L_0x0161:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzd(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x016d:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x0171:
        goto L_0x020d;
    L_0x0173:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzf(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x017f:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x0183:
        goto L_0x020d;
    L_0x0185:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzj(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0191:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x0195:
        goto L_0x020d;
    L_0x0197:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01a3:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01a7:
        goto L_0x020d;
    L_0x01a8:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01b4:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01b8:
        goto L_0x020d;
    L_0x01b9:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zze(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01c5:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01c9:
        goto L_0x020d;
    L_0x01ca:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzb(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01d6:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01da:
        goto L_0x020d;
    L_0x01db:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zza(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01e7:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01eb:
        goto L_0x020d;
    L_0x01ec:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x01f8:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x01fc:
        goto L_0x020d;
    L_0x01fd:
        r5 = r2.getObject(r1, r5);
        r5 = (java.util.List) r5;
        r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5);
        if (r5 <= 0) goto L_0x03aa;
    L_0x0209:
        r6 = r0.zzmr;
        if (r6 == 0) goto L_0x0211;
    L_0x020d:
        r14 = (long) r14;
        r2.putInt(r1, r14, r5);
    L_0x0211:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzr(r3);
        r6 = com.google.android.gms.internal.clearcut.zzbn.zzt(r5);
        r3 = r3 + r6;
        r3 = r3 + r5;
        goto L_0x0296;
    L_0x021d:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzq(r3, r5, r11);
        goto L_0x0296;
    L_0x0227:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzu(r3, r5, r11);
        goto L_0x0296;
    L_0x0230:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzr(r3, r5, r11);
        goto L_0x0296;
    L_0x0239:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzt(r3, r5, r11);
        goto L_0x0296;
    L_0x0242:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r5);
        goto L_0x0296;
    L_0x024b:
        r5 = zzd(r1, r5);
        r6 = r0.zzad(r12);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5, r6);
        goto L_0x0296;
    L_0x0258:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5);
        goto L_0x0296;
    L_0x0261:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzx(r3, r5, r11);
        goto L_0x0296;
    L_0x026a:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzs(r3, r5, r11);
        goto L_0x0296;
    L_0x0273:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzp(r3, r5, r11);
        goto L_0x0296;
    L_0x027c:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzo(r3, r5, r11);
        goto L_0x0296;
    L_0x0285:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzv(r3, r5, r11);
        goto L_0x0296;
    L_0x028e:
        r5 = zzd(r1, r5);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzw(r3, r5, r11);
    L_0x0296:
        r13 = r13 + r3;
        goto L_0x03aa;
    L_0x0299:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x029f:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
        r5 = (com.google.android.gms.internal.clearcut.zzdo) r5;
        r6 = r0.zzad(r12);
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r5, r6);
        goto L_0x0296;
    L_0x02ae:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02b4:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5);
    L_0x02b8:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzf(r3, r5);
        goto L_0x0296;
    L_0x02bd:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02c3:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5);
    L_0x02c7:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzi(r3, r5);
        goto L_0x0296;
    L_0x02cc:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x02d2:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, r9);
        goto L_0x0296;
    L_0x02d7:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x02dd:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzk(r3, r11);
        goto L_0x0296;
    L_0x02e2:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02e8:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5);
    L_0x02ec:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzl(r3, r5);
        goto L_0x0296;
    L_0x02f1:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x02f7:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5);
    L_0x02fb:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, r5);
        goto L_0x0296;
    L_0x0300:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0306:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
    L_0x030a:
        r5 = (com.google.android.gms.internal.clearcut.zzbb) r5;
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r5);
        goto L_0x0296;
    L_0x0311:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0317:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
        r6 = r0.zzad(r12);
        r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5, r6);
        goto L_0x0296;
    L_0x0325:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x032b:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5);
        r6 = r5 instanceof com.google.android.gms.internal.clearcut.zzbb;
        if (r6 == 0) goto L_0x0334;
    L_0x0333:
        goto L_0x030a;
    L_0x0334:
        r5 = (java.lang.String) r5;
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r5);
        goto L_0x0296;
    L_0x033c:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0342:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r7);
        goto L_0x0296;
    L_0x0348:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x034e:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzj(r3, r11);
        goto L_0x0296;
    L_0x0354:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x035a:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, r9);
        goto L_0x0296;
    L_0x0360:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0366:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5);
    L_0x036a:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, r5);
        goto L_0x0296;
    L_0x0370:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0376:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5);
    L_0x037a:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zze(r3, r5);
        goto L_0x0296;
    L_0x0380:
        r14 = r0.zza(r1, r12);
        if (r14 == 0) goto L_0x03aa;
    L_0x0386:
        r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5);
    L_0x038a:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzd(r3, r5);
        goto L_0x0296;
    L_0x0390:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x0396:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r4);
        goto L_0x0296;
    L_0x039c:
        r5 = r0.zza(r1, r12);
        if (r5 == 0) goto L_0x03aa;
    L_0x03a2:
        r5 = 0;
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r5);
        goto L_0x0296;
    L_0x03aa:
        r12 = r12 + 4;
        r3 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        goto L_0x0016;
    L_0x03b0:
        r2 = r0.zzmx;
        r1 = zza(r2, r1);
        r13 = r13 + r1;
        return r13;
    L_0x03b8:
        r2 = zzmh;
        r3 = -1;
        r6 = r3;
        r3 = r11;
        r5 = r3;
        r12 = r5;
    L_0x03bf:
        r13 = r0.zzmi;
        r13 = r13.length;
        if (r3 >= r13) goto L_0x07d7;
    L_0x03c4:
        r13 = r0.zzag(r3);
        r14 = r0.zzmi;
        r14 = r14[r3];
        r15 = 267386880; // 0xff00000 float:2.3665827E-29 double:1.321066716E-315;
        r16 = r13 & r15;
        r15 = r16 >>> 20;
        r4 = 17;
        if (r15 > r4) goto L_0x03eb;
    L_0x03d6:
        r4 = r0.zzmi;
        r16 = r3 + 2;
        r4 = r4[r16];
        r11 = r4 & r8;
        r16 = r4 >>> 20;
        r16 = r7 << r16;
        if (r11 == r6) goto L_0x040c;
    L_0x03e4:
        r9 = (long) r11;
        r12 = r2.getInt(r1, r9);
        r6 = r11;
        goto L_0x040c;
    L_0x03eb:
        r4 = r0.zzmr;
        if (r4 == 0) goto L_0x0409;
    L_0x03ef:
        r4 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED;
        r4 = r4.id();
        if (r15 < r4) goto L_0x0409;
    L_0x03f7:
        r4 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED;
        r4 = r4.id();
        if (r15 > r4) goto L_0x0409;
    L_0x03ff:
        r4 = r0.zzmi;
        r9 = r3 + 2;
        r4 = r4[r9];
        r11 = r4 & r8;
        r4 = r11;
        goto L_0x040a;
    L_0x0409:
        r4 = 0;
    L_0x040a:
        r16 = 0;
    L_0x040c:
        r9 = r13 & r8;
        r9 = (long) r9;
        switch(r15) {
            case 0: goto L_0x07c0;
            case 1: goto L_0x07b0;
            case 2: goto L_0x079e;
            case 3: goto L_0x078e;
            case 4: goto L_0x077e;
            case 5: goto L_0x076f;
            case 6: goto L_0x0763;
            case 7: goto L_0x0759;
            case 8: goto L_0x0744;
            case 9: goto L_0x0732;
            case 10: goto L_0x0723;
            case 11: goto L_0x0716;
            case 12: goto L_0x0709;
            case 13: goto L_0x06fe;
            case 14: goto L_0x06f3;
            case 15: goto L_0x06e6;
            case 16: goto L_0x06d9;
            case 17: goto L_0x06c6;
            case 18: goto L_0x06b2;
            case 19: goto L_0x06a4;
            case 20: goto L_0x0698;
            case 21: goto L_0x068c;
            case 22: goto L_0x0680;
            case 23: goto L_0x0674;
            case 24: goto L_0x06a4;
            case 25: goto L_0x0668;
            case 26: goto L_0x065d;
            case 27: goto L_0x064e;
            case 28: goto L_0x0642;
            case 29: goto L_0x0635;
            case 30: goto L_0x0628;
            case 31: goto L_0x06a4;
            case 32: goto L_0x0674;
            case 33: goto L_0x061b;
            case 34: goto L_0x060e;
            case 35: goto L_0x05ee;
            case 36: goto L_0x05dd;
            case 37: goto L_0x05cc;
            case 38: goto L_0x05bb;
            case 39: goto L_0x05aa;
            case 40: goto L_0x0599;
            case 41: goto L_0x0588;
            case 42: goto L_0x0576;
            case 43: goto L_0x0564;
            case 44: goto L_0x0552;
            case 45: goto L_0x0540;
            case 46: goto L_0x052e;
            case 47: goto L_0x051c;
            case 48: goto L_0x050a;
            case 49: goto L_0x04fa;
            case 50: goto L_0x04ea;
            case 51: goto L_0x04dc;
            case 52: goto L_0x04cf;
            case 53: goto L_0x04bf;
            case 54: goto L_0x04af;
            case 55: goto L_0x049f;
            case 56: goto L_0x0491;
            case 57: goto L_0x0484;
            case 58: goto L_0x047c;
            case 59: goto L_0x046c;
            case 60: goto L_0x0464;
            case 61: goto L_0x045c;
            case 62: goto L_0x0450;
            case 63: goto L_0x0444;
            case 64: goto L_0x043c;
            case 65: goto L_0x0434;
            case 66: goto L_0x0428;
            case 67: goto L_0x041c;
            case 68: goto L_0x0414;
            default: goto L_0x0412;
        };
    L_0x0412:
        goto L_0x06be;
    L_0x0414:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x041a:
        goto L_0x06ca;
    L_0x041c:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0422:
        r9 = zzh(r1, r9);
        goto L_0x06e1;
    L_0x0428:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x042e:
        r4 = zzg(r1, r9);
        goto L_0x06ee;
    L_0x0434:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x043a:
        goto L_0x06f7;
    L_0x043c:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0442:
        goto L_0x0702;
    L_0x0444:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x044a:
        r4 = zzg(r1, r9);
        goto L_0x0711;
    L_0x0450:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0456:
        r4 = zzg(r1, r9);
        goto L_0x071e;
    L_0x045c:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0462:
        goto L_0x0727;
    L_0x0464:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x046a:
        goto L_0x0736;
    L_0x046c:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0472:
        r4 = r2.getObject(r1, r9);
        r9 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb;
        if (r9 == 0) goto L_0x0751;
    L_0x047a:
        goto L_0x0750;
    L_0x047c:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0482:
        goto L_0x075d;
    L_0x0484:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x048a:
        r4 = 0;
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r14, r4);
        goto L_0x0707;
    L_0x0491:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x0497:
        r9 = 0;
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzg(r14, r9);
        goto L_0x06bd;
    L_0x049f:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x04a5:
        r4 = zzg(r1, r9);
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzg(r14, r4);
        goto L_0x06bd;
    L_0x04af:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x04b5:
        r9 = zzh(r1, r9);
        r4 = com.google.android.gms.internal.clearcut.zzbn.zze(r14, r9);
        goto L_0x06bd;
    L_0x04bf:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x04c5:
        r9 = zzh(r1, r9);
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzd(r14, r9);
        goto L_0x06bd;
    L_0x04cf:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x04d5:
        r4 = 0;
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzb(r14, r4);
        goto L_0x0707;
    L_0x04dc:
        r4 = r0.zza(r1, r14, r3);
        if (r4 == 0) goto L_0x06be;
    L_0x04e2:
        r9 = 0;
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r14, r9);
        goto L_0x06bd;
    L_0x04ea:
        r4 = r0.zzmz;
        r9 = r2.getObject(r1, r9);
        r10 = r0.zzae(r3);
        r4 = r4.zzb(r14, r9, r10);
        goto L_0x06bd;
    L_0x04fa:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r9 = r0.zzad(r3);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r14, r4, r9);
        goto L_0x06bd;
    L_0x050a:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzc(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x0516:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x051a:
        goto L_0x05fe;
    L_0x051c:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzg(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x0528:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x052c:
        goto L_0x05fe;
    L_0x052e:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzi(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x053a:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x053e:
        goto L_0x05fe;
    L_0x0540:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzh(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x054c:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x0550:
        goto L_0x05fe;
    L_0x0552:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzd(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x055e:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x0562:
        goto L_0x05fe;
    L_0x0564:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzf(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x0570:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x0574:
        goto L_0x05fe;
    L_0x0576:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzj(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x0582:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x0586:
        goto L_0x05fe;
    L_0x0588:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzh(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x0594:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x0598:
        goto L_0x05fe;
    L_0x0599:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzi(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05a5:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05a9:
        goto L_0x05fe;
    L_0x05aa:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zze(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05b6:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05ba:
        goto L_0x05fe;
    L_0x05bb:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzb(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05c7:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05cb:
        goto L_0x05fe;
    L_0x05cc:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zza(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05d8:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05dc:
        goto L_0x05fe;
    L_0x05dd:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzh(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05e9:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05ed:
        goto L_0x05fe;
    L_0x05ee:
        r9 = r2.getObject(r1, r9);
        r9 = (java.util.List) r9;
        r9 = com.google.android.gms.internal.clearcut.zzeh.zzi(r9);
        if (r9 <= 0) goto L_0x06be;
    L_0x05fa:
        r10 = r0.zzmr;
        if (r10 == 0) goto L_0x0602;
    L_0x05fe:
        r10 = (long) r4;
        r2.putInt(r1, r10, r9);
    L_0x0602:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzr(r14);
        r10 = com.google.android.gms.internal.clearcut.zzbn.zzt(r9);
        r4 = r4 + r10;
        r4 = r4 + r9;
        goto L_0x06bd;
    L_0x060e:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r11 = 0;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzq(r14, r4, r11);
        goto L_0x06af;
    L_0x061b:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzu(r14, r4, r11);
        goto L_0x06af;
    L_0x0628:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzr(r14, r4, r11);
        goto L_0x06af;
    L_0x0635:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzt(r14, r4, r11);
        goto L_0x06bd;
    L_0x0642:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r14, r4);
        goto L_0x06bd;
    L_0x064e:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r9 = r0.zzad(r3);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r14, r4, r9);
        goto L_0x06bd;
    L_0x065d:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r14, r4);
        goto L_0x06bd;
    L_0x0668:
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r11 = 0;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzx(r14, r4, r11);
        goto L_0x06af;
    L_0x0674:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzw(r14, r4, r11);
        goto L_0x06af;
    L_0x0680:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzs(r14, r4, r11);
        goto L_0x06af;
    L_0x068c:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzp(r14, r4, r11);
        goto L_0x06af;
    L_0x0698:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzo(r14, r4, r11);
        goto L_0x06af;
    L_0x06a4:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzv(r14, r4, r11);
    L_0x06af:
        r5 = r5 + r4;
        r4 = r11;
        goto L_0x06bf;
    L_0x06b2:
        r11 = 0;
        r4 = r2.getObject(r1, r9);
        r4 = (java.util.List) r4;
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzw(r14, r4, r11);
    L_0x06bd:
        r5 = r5 + r4;
    L_0x06be:
        r4 = 0;
    L_0x06bf:
        r9 = 0;
        r10 = 0;
        r18 = 0;
        goto L_0x07cf;
    L_0x06c6:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x06ca:
        r4 = r2.getObject(r1, r9);
        r4 = (com.google.android.gms.internal.clearcut.zzdo) r4;
        r9 = r0.zzad(r3);
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r14, r4, r9);
        goto L_0x06bd;
    L_0x06d9:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x06dd:
        r9 = r2.getLong(r1, r9);
    L_0x06e1:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzf(r14, r9);
        goto L_0x06bd;
    L_0x06e6:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x06ea:
        r4 = r2.getInt(r1, r9);
    L_0x06ee:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzi(r14, r4);
        goto L_0x06bd;
    L_0x06f3:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x06f7:
        r9 = 0;
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r14, r9);
        goto L_0x06bd;
    L_0x06fe:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x0702:
        r4 = 0;
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r14, r4);
    L_0x0707:
        r5 = r5 + r9;
        goto L_0x06be;
    L_0x0709:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x070d:
        r4 = r2.getInt(r1, r9);
    L_0x0711:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzl(r14, r4);
        goto L_0x06bd;
    L_0x0716:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x071a:
        r4 = r2.getInt(r1, r9);
    L_0x071e:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r14, r4);
        goto L_0x06bd;
    L_0x0723:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x0727:
        r4 = r2.getObject(r1, r9);
    L_0x072b:
        r4 = (com.google.android.gms.internal.clearcut.zzbb) r4;
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r14, r4);
        goto L_0x06bd;
    L_0x0732:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x0736:
        r4 = r2.getObject(r1, r9);
        r9 = r0.zzad(r3);
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r14, r4, r9);
        goto L_0x06bd;
    L_0x0744:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x0748:
        r4 = r2.getObject(r1, r9);
        r9 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb;
        if (r9 == 0) goto L_0x0751;
    L_0x0750:
        goto L_0x072b;
    L_0x0751:
        r4 = (java.lang.String) r4;
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r14, r4);
        goto L_0x06bd;
    L_0x0759:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x075d:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r14, r7);
        goto L_0x06bd;
    L_0x0763:
        r4 = r12 & r16;
        if (r4 == 0) goto L_0x06be;
    L_0x0767:
        r4 = 0;
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r14, r4);
        r5 = r5 + r9;
        goto L_0x06bf;
    L_0x076f:
        r4 = 0;
        r9 = r12 & r16;
        if (r9 == 0) goto L_0x06bf;
    L_0x0774:
        r9 = 0;
        r11 = com.google.android.gms.internal.clearcut.zzbn.zzg(r14, r9);
        r5 = r5 + r11;
        r18 = r9;
        goto L_0x07ae;
    L_0x077e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x07ae;
    L_0x0785:
        r9 = r2.getInt(r1, r9);
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzg(r14, r9);
        goto L_0x07ad;
    L_0x078e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x07ae;
    L_0x0795:
        r9 = r2.getLong(r1, r9);
        r9 = com.google.android.gms.internal.clearcut.zzbn.zze(r14, r9);
        goto L_0x07ad;
    L_0x079e:
        r4 = 0;
        r18 = 0;
        r11 = r12 & r16;
        if (r11 == 0) goto L_0x07ae;
    L_0x07a5:
        r9 = r2.getLong(r1, r9);
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzd(r14, r9);
    L_0x07ad:
        r5 = r5 + r9;
    L_0x07ae:
        r9 = 0;
        goto L_0x07bd;
    L_0x07b0:
        r4 = 0;
        r18 = 0;
        r9 = r12 & r16;
        if (r9 == 0) goto L_0x07ae;
    L_0x07b7:
        r9 = 0;
        r10 = com.google.android.gms.internal.clearcut.zzbn.zzb(r14, r9);
        r5 = r5 + r10;
    L_0x07bd:
        r10 = 0;
        goto L_0x07cf;
    L_0x07c0:
        r4 = 0;
        r9 = 0;
        r18 = 0;
        r10 = r12 & r16;
        if (r10 == 0) goto L_0x07bd;
    L_0x07c8:
        r10 = 0;
        r13 = com.google.android.gms.internal.clearcut.zzbn.zzb(r14, r10);
        r5 = r5 + r13;
    L_0x07cf:
        r3 = r3 + 4;
        r11 = r4;
        r4 = r9;
        r9 = r18;
        goto L_0x03bf;
    L_0x07d7:
        r2 = r0.zzmx;
        r2 = zza(r2, r1);
        r5 = r5 + r2;
        r2 = r0.zzmo;
        if (r2 == 0) goto L_0x07ed;
    L_0x07e2:
        r2 = r0.zzmy;
        r1 = r2.zza(r1);
        r1 = r1.zzas();
        r5 = r5 + r1;
    L_0x07ed:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzm(java.lang.Object):int");
    }

    public final boolean zzo(T t) {
        Object obj = t;
        int i = 1;
        if (this.zzms != null) {
            if (r0.zzms.length != 0) {
                int[] iArr = r0.zzms;
                int length = iArr.length;
                int i2 = -1;
                int i3 = 0;
                int i4 = i3;
                while (i3 < length) {
                    int[] iArr2;
                    int i5;
                    int i6 = iArr[i3];
                    int zzai = zzai(i6);
                    int zzag = zzag(zzai);
                    if (r0.zzmq) {
                        iArr2 = iArr;
                        i5 = 0;
                    } else {
                        i5 = r0.zzmi[zzai + 2];
                        int i7 = i5 & 1048575;
                        i5 = i << (i5 >>> 20);
                        if (i7 != i2) {
                            iArr2 = iArr;
                            i4 = zzmh.getInt(obj, (long) i7);
                            i2 = i7;
                        } else {
                            iArr2 = iArr;
                        }
                    }
                    if (((ErrorDialogData.BINDER_CRASH & zzag) != 0) && !zza(obj, zzai, i4, i5)) {
                        return false;
                    }
                    i = (267386880 & zzag) >>> 20;
                    if (i != 9 && i != 17) {
                        zzef com_google_android_gms_internal_clearcut_zzef;
                        boolean z;
                        if (i != 27) {
                            if (i != 60 && i != 68) {
                                switch (i) {
                                    case 49:
                                        break;
                                    case 50:
                                        Map zzh = r0.zzmz.zzh(zzfd.zzo(obj, (long) (zzag & 1048575)));
                                        if (!zzh.isEmpty()) {
                                            if (r0.zzmz.zzl(zzae(zzai)).zzmd.zzek() == zzfq.MESSAGE) {
                                                com_google_android_gms_internal_clearcut_zzef = null;
                                                for (Object next : zzh.values()) {
                                                    if (com_google_android_gms_internal_clearcut_zzef == null) {
                                                        com_google_android_gms_internal_clearcut_zzef = zzea.zzcm().zze(next.getClass());
                                                    }
                                                    if (!com_google_android_gms_internal_clearcut_zzef.zzo(next)) {
                                                        z = false;
                                                        if (!z) {
                                                            return false;
                                                        }
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                        z = true;
                                        if (!z) {
                                            return false;
                                        }
                                        continue;
                                    default:
                                        continue;
                                }
                            } else if (zza(obj, i6, zzai) && !zza(obj, zzag, zzad(zzai))) {
                                return false;
                            }
                        }
                        List list = (List) zzfd.zzo(obj, (long) (zzag & 1048575));
                        if (!list.isEmpty()) {
                            com_google_android_gms_internal_clearcut_zzef = zzad(zzai);
                            i6 = 0;
                            while (i6 < list.size()) {
                                if (com_google_android_gms_internal_clearcut_zzef.zzo(list.get(i6))) {
                                    i6++;
                                } else {
                                    z = false;
                                    if (!z) {
                                        return false;
                                    }
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                            return false;
                        }
                    } else if (zza(obj, zzai, i4, i5) && !zza(obj, zzag, zzad(zzai))) {
                        return false;
                    }
                    i3++;
                    iArr = iArr2;
                    i = 1;
                }
                return !r0.zzmo || r0.zzmy.zza(obj).isInitialized();
            }
        }
        return true;
    }
}
