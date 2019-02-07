package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;

final class zzed {
    private final int flags;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final int[] zzms;
    private final zzee zznh;
    private Class<?> zzni;
    private final int zznj;
    private final int zznk;
    private final int zznl;
    private final int zznm;
    private final int zznn;
    private final int zzno;
    private int zznp;
    private int zznq;
    private int zznr = Integer.MAX_VALUE;
    private int zzns = Integer.MIN_VALUE;
    private int zznt = 0;
    private int zznu = 0;
    private int zznv = 0;
    private int zznw = 0;
    private int zznx = 0;
    private int zzny;
    private int zznz;
    private int zzoa;
    private int zzob;
    private int zzoc;
    private Field zzod;
    private Object zzoe;
    private Object zzof;
    private Object zzog;

    zzed(Class<?> cls, String str, Object[] objArr) {
        this.zzni = cls;
        this.zznh = new zzee(str);
        this.zzmj = objArr;
        this.flags = this.zznh.next();
        this.zznj = this.zznh.next();
        int[] iArr = null;
        if (this.zznj == 0) {
            this.zznk = 0;
            this.zznl = 0;
            this.zzmk = 0;
            this.zzml = 0;
            this.zznm = 0;
            this.zznn = 0;
            this.zzmm = 0;
            this.zzno = 0;
            this.zzms = null;
            return;
        }
        this.zznk = this.zznh.next();
        this.zznl = this.zznh.next();
        this.zzmk = this.zznh.next();
        this.zzml = this.zznh.next();
        this.zznn = this.zznh.next();
        this.zzmm = this.zznh.next();
        this.zznm = this.zznh.next();
        this.zzno = this.zznh.next();
        int next = this.zznh.next();
        if (next != 0) {
            iArr = new int[next];
        }
        this.zzms = iArr;
        this.zznp = (this.zznk << 1) + this.zznl;
    }

    private static java.lang.reflect.Field zza(java.lang.Class<?> r5, java.lang.String r6) {
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
        r0 = r5.getDeclaredField(r6);	 Catch:{ NoSuchFieldException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = r5.getDeclaredFields();
        r1 = r0.length;
        r2 = 0;
    L_0x000b:
        if (r2 >= r1) goto L_0x001d;
    L_0x000d:
        r3 = r0[r2];
        r4 = r3.getName();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x001a;
    L_0x0019:
        return r3;
    L_0x001a:
        r2 = r2 + 1;
        goto L_0x000b;
    L_0x001d:
        r1 = new java.lang.RuntimeException;
        r5 = r5.getName();
        r0 = java.util.Arrays.toString(r0);
        r2 = 40;
        r3 = java.lang.String.valueOf(r6);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r0);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Field ";
        r3.append(r2);
        r3.append(r6);
        r6 = " for ";
        r3.append(r6);
        r3.append(r5);
        r5 = " not found. Known fields are ";
        r3.append(r5);
        r3.append(r0);
        r5 = r3.toString();
        r1.<init>(r5);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzed.zza(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    private final Object zzcw() {
        Object[] objArr = this.zzmj;
        int i = this.zznp;
        this.zznp = i + 1;
        return objArr[i];
    }

    private final boolean zzcz() {
        return (this.flags & 1) == 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean next() {
        /*
        r5 = this;
        r0 = r5.zznh;
        r0 = r0.hasNext();
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = r5.zznh;
        r0 = r0.next();
        r5.zzny = r0;
        r0 = r5.zznh;
        r0 = r0.next();
        r5.zznz = r0;
        r0 = r5.zznz;
        r0 = r0 & 255;
        r5.zzoa = r0;
        r0 = r5.zzny;
        r2 = r5.zznr;
        if (r0 >= r2) goto L_0x002a;
    L_0x0026:
        r0 = r5.zzny;
        r5.zznr = r0;
    L_0x002a:
        r0 = r5.zzny;
        r2 = r5.zzns;
        if (r0 <= r2) goto L_0x0034;
    L_0x0030:
        r0 = r5.zzny;
        r5.zzns = r0;
    L_0x0034:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.MAP;
        r2 = r2.id();
        r3 = 1;
        if (r0 != r2) goto L_0x0045;
    L_0x003f:
        r0 = r5.zznt;
        r0 = r0 + r3;
        r5.zznt = r0;
        goto L_0x005e;
    L_0x0045:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST;
        r2 = r2.id();
        if (r0 < r2) goto L_0x005e;
    L_0x004f:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP_LIST;
        r2 = r2.id();
        if (r0 > r2) goto L_0x005e;
    L_0x0059:
        r0 = r5.zznu;
        r0 = r0 + r3;
        r5.zznu = r0;
    L_0x005e:
        r0 = r5.zznx;
        r0 = r0 + r3;
        r5.zznx = r0;
        r0 = r5.zznr;
        r2 = r5.zzny;
        r4 = r5.zznx;
        r0 = com.google.android.gms.internal.clearcut.zzeh.zzc(r0, r2, r4);
        if (r0 == 0) goto L_0x007c;
    L_0x006f:
        r0 = r5.zzny;
        r0 = r0 + r3;
        r5.zznw = r0;
        r0 = r5.zznw;
        r2 = r5.zznr;
        r0 = r0 - r2;
    L_0x0079:
        r5.zznv = r0;
        goto L_0x0080;
    L_0x007c:
        r0 = r5.zznv;
        r0 = r0 + r3;
        goto L_0x0079;
    L_0x0080:
        r0 = r5.zznz;
        r0 = r0 & 1024;
        if (r0 == 0) goto L_0x0088;
    L_0x0086:
        r0 = r3;
        goto L_0x0089;
    L_0x0088:
        r0 = r1;
    L_0x0089:
        if (r0 == 0) goto L_0x0097;
    L_0x008b:
        r0 = r5.zzms;
        r2 = r5.zznq;
        r4 = r2 + 1;
        r5.zznq = r4;
        r4 = r5.zzny;
        r0[r2] = r4;
    L_0x0097:
        r0 = 0;
        r5.zzoe = r0;
        r5.zzof = r0;
        r5.zzog = r0;
        r0 = r5.zzda();
        if (r0 == 0) goto L_0x00e7;
    L_0x00a4:
        r0 = r5.zznh;
        r0 = r0.next();
        r5.zzob = r0;
        r0 = r5.zzoa;
        r1 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE;
        r1 = r1.id();
        r1 = r1 + 51;
        if (r0 == r1) goto L_0x00df;
    L_0x00b8:
        r0 = r5.zzoa;
        r1 = com.google.android.gms.internal.clearcut.zzcb.GROUP;
        r1 = r1.id();
        r1 = r1 + 51;
        if (r0 != r1) goto L_0x00c5;
    L_0x00c4:
        goto L_0x00df;
    L_0x00c5:
        r0 = r5.zzoa;
        r1 = com.google.android.gms.internal.clearcut.zzcb.ENUM;
        r1 = r1.id();
        r1 = r1 + 51;
        if (r0 != r1) goto L_0x0177;
    L_0x00d1:
        r0 = r5.zzcz();
        if (r0 == 0) goto L_0x0177;
    L_0x00d7:
        r0 = r5.zzcw();
        r5.zzof = r0;
        goto L_0x0177;
    L_0x00df:
        r0 = r5.zzcw();
    L_0x00e3:
        r5.zzoe = r0;
        goto L_0x0177;
    L_0x00e7:
        r0 = r5.zzni;
        r2 = r5.zzcw();
        r2 = (java.lang.String) r2;
        r0 = zza(r0, r2);
        r5.zzod = r0;
        r0 = r5.zzde();
        if (r0 == 0) goto L_0x0103;
    L_0x00fb:
        r0 = r5.zznh;
        r0 = r0.next();
        r5.zzoc = r0;
    L_0x0103:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE;
        r2 = r2.id();
        if (r0 == r2) goto L_0x016f;
    L_0x010d:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP;
        r2 = r2.id();
        if (r0 != r2) goto L_0x0118;
    L_0x0117:
        goto L_0x016f;
    L_0x0118:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE_LIST;
        r2 = r2.id();
        if (r0 == r2) goto L_0x00df;
    L_0x0122:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP_LIST;
        r2 = r2.id();
        if (r0 != r2) goto L_0x012d;
    L_0x012c:
        goto L_0x00df;
    L_0x012d:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM;
        r2 = r2.id();
        if (r0 == r2) goto L_0x0167;
    L_0x0137:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM_LIST;
        r2 = r2.id();
        if (r0 == r2) goto L_0x0167;
    L_0x0141:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM_LIST_PACKED;
        r2 = r2.id();
        if (r0 != r2) goto L_0x014c;
    L_0x014b:
        goto L_0x0167;
    L_0x014c:
        r0 = r5.zzoa;
        r2 = com.google.android.gms.internal.clearcut.zzcb.MAP;
        r2 = r2.id();
        if (r0 != r2) goto L_0x0177;
    L_0x0156:
        r0 = r5.zzcw();
        r5.zzog = r0;
        r0 = r5.zznz;
        r0 = r0 & 2048;
        if (r0 == 0) goto L_0x0163;
    L_0x0162:
        r1 = r3;
    L_0x0163:
        if (r1 == 0) goto L_0x0177;
    L_0x0165:
        goto L_0x00d7;
    L_0x0167:
        r0 = r5.zzcz();
        if (r0 == 0) goto L_0x0177;
    L_0x016d:
        goto L_0x00d7;
    L_0x016f:
        r0 = r5.zzod;
        r0 = r0.getType();
        goto L_0x00e3;
    L_0x0177:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzed.next():boolean");
    }

    final int zzcx() {
        return this.zzny;
    }

    final int zzcy() {
        return this.zzoa;
    }

    final boolean zzda() {
        return this.zzoa > zzcb.MAP.id();
    }

    final Field zzdb() {
        int i = this.zzob << 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    final Field zzdc() {
        int i = (this.zzob << 1) + 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    final Field zzdd() {
        return this.zzod;
    }

    final boolean zzde() {
        return zzcz() && this.zzoa <= zzcb.GROUP.id();
    }

    final Field zzdf() {
        int i = (this.zznk << 1) + (this.zzoc / 32);
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    final int zzdg() {
        return this.zzoc % 32;
    }

    final boolean zzdh() {
        return (this.zznz & 256) != 0;
    }

    final boolean zzdi() {
        return (this.zznz & 512) != 0;
    }

    final Object zzdj() {
        return this.zzoe;
    }

    final Object zzdk() {
        return this.zzof;
    }

    final Object zzdl() {
        return this.zzog;
    }
}
