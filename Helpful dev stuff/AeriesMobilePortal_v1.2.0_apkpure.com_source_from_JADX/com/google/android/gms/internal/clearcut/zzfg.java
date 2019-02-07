package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;

abstract class zzfg {
    zzfg() {
    }

    static void zzc(java.lang.CharSequence r9, java.nio.ByteBuffer r10) {
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
        r0 = r9.length();
        r1 = r10.position();
        r2 = 0;
    L_0x0009:
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r2 >= r0) goto L_0x001c;
    L_0x000d:
        r4 = r9.charAt(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        if (r4 >= r3) goto L_0x001c;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x0013:
        r3 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r10.put(r3, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r2 = r2 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        goto L_0x0009;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x001c:
        if (r2 != r0) goto L_0x0024;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x001e:
        r0 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r10.position(r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        return;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x0024:
        r1 = r1 + r2;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x0025:
        if (r2 >= r0) goto L_0x00c4;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x0027:
        r4 = r9.charAt(r2);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        if (r4 >= r3) goto L_0x0033;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x002d:
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r10.put(r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        goto L_0x00be;
    L_0x0033:
        r5 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r6 = 63;
        if (r4 >= r5) goto L_0x0051;
    L_0x0039:
        r5 = r1 + 1;
        r7 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
        r8 = r4 >>> 6;
        r7 = r7 | r8;
        r7 = (byte) r7;
        r10.put(r1, r7);	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r1 = r6 & r4;	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r1 = r1 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r1 = (byte) r1;	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r10.put(r5, r1);	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r1 = r5;
        goto L_0x00be;
    L_0x004e:
        r1 = r5;
        goto L_0x00c8;
    L_0x0051:
        r5 = 55296; // 0xd800 float:7.7486E-41 double:2.732E-319;
        if (r4 < r5) goto L_0x00a3;
    L_0x0056:
        r5 = 57343; // 0xdfff float:8.0355E-41 double:2.8331E-319;
        if (r5 >= r4) goto L_0x005c;
    L_0x005b:
        goto L_0x00a3;
    L_0x005c:
        r5 = r2 + 1;
        if (r5 == r0) goto L_0x009d;
    L_0x0060:
        r2 = r9.charAt(r5);	 Catch:{ IndexOutOfBoundsException -> 0x009b }
        r7 = java.lang.Character.isSurrogatePair(r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x009b }
        if (r7 == 0) goto L_0x0099;	 Catch:{ IndexOutOfBoundsException -> 0x009b }
    L_0x006a:
        r2 = java.lang.Character.toCodePoint(r4, r2);	 Catch:{ IndexOutOfBoundsException -> 0x009b }
        r4 = r1 + 1;
        r7 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
        r8 = r2 >>> 18;
        r7 = r7 | r8;
        r7 = (byte) r7;
        r10.put(r1, r7);	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r1 = r4 + 1;
        r7 = r2 >>> 12;
        r7 = r7 & r6;
        r7 = r7 | r3;
        r7 = (byte) r7;
        r10.put(r4, r7);	 Catch:{ IndexOutOfBoundsException -> 0x009b }
        r4 = r1 + 1;
        r7 = r2 >>> 6;
        r7 = r7 & r6;
        r7 = r7 | r3;
        r7 = (byte) r7;
        r10.put(r1, r7);	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r1 = r6 & r2;	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r1 = r1 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r1 = (byte) r1;	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r10.put(r4, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0097 }
        r1 = r4;
        r2 = r5;
        goto L_0x00be;
    L_0x0097:
        r1 = r4;
        goto L_0x009b;
    L_0x0099:
        r2 = r5;
        goto L_0x009d;
    L_0x009b:
        r2 = r5;
        goto L_0x00c8;
    L_0x009d:
        r3 = new com.google.android.gms.internal.clearcut.zzfi;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r3.<init>(r2, r0);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        throw r3;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x00a3:
        r5 = r1 + 1;
        r7 = 224; // 0xe0 float:3.14E-43 double:1.107E-321;
        r8 = r4 >>> 12;
        r7 = r7 | r8;
        r7 = (byte) r7;
        r10.put(r1, r7);	 Catch:{ IndexOutOfBoundsException -> 0x004e }
        r1 = r5 + 1;
        r7 = r4 >>> 6;
        r7 = r7 & r6;
        r7 = r7 | r3;
        r7 = (byte) r7;
        r10.put(r5, r7);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r4 = r4 & r6;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r4 = r4 | r3;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r4 = (byte) r4;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r10.put(r1, r4);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x00be:
        r2 = r2 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        r1 = r1 + 1;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        goto L_0x0025;	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
    L_0x00c4:
        r10.position(r1);	 Catch:{ IndexOutOfBoundsException -> 0x00c8 }
        return;
    L_0x00c8:
        r0 = r10.position();
        r10 = r10.position();
        r1 = r1 - r10;
        r1 = r1 + 1;
        r10 = java.lang.Math.max(r2, r1);
        r0 = r0 + r10;
        r10 = new java.lang.ArrayIndexOutOfBoundsException;
        r9 = r9.charAt(r2);
        r1 = 37;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Failed writing ";
        r2.append(r1);
        r2.append(r9);
        r9 = " at index ";
        r2.append(r9);
        r2.append(r0);
        r9 = r2.toString();
        r10.<init>(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfg.zzc(java.lang.CharSequence, java.nio.ByteBuffer):void");
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract void zzb(CharSequence charSequence, ByteBuffer byteBuffer);

    final boolean zze(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }
}
