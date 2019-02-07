package com.google.android.gms.internal.measurement;

final class zzaax {
    private static final Class<?> zzbtt = zzuh();
    private static final zzabj<?, ?> zzbtu = zzu(false);
    private static final zzabj<?, ?> zzbtv = zzu(true);
    private static final zzabj<?, ?> zzbtw = new zzabl();

    public static void zzh(Class<?> cls) {
        if (!zzzq.class.isAssignableFrom(cls) && zzbtt != null) {
            if (!zzbtt.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
            }
        }
    }

    private static com.google.android.gms.internal.measurement.zzabj<?, ?> zzu(boolean r6) {
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
        r0 = 0;
        r1 = zzui();	 Catch:{ Throwable -> 0x0023 }
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
        r6 = (com.google.android.gms.internal.measurement.zzabj) r6;	 Catch:{ Throwable -> 0x0023 }
        return r6;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaax.zzu(boolean):com.google.android.gms.internal.measurement.zzabj<?, ?>");
    }

    public static zzabj<?, ?> zzue() {
        return zzbtu;
    }

    public static zzabj<?, ?> zzuf() {
        return zzbtv;
    }

    public static zzabj<?, ?> zzug() {
        return zzbtw;
    }

    private static java.lang.Class<?> zzuh() {
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
        r0 = "com.google.protobuf.GeneratedMessage";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaax.zzuh():java.lang.Class<?>");
    }

    private static java.lang.Class<?> zzui() {
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
        r0 = "com.google.protobuf.UnknownFieldSetSchema";	 Catch:{ Throwable -> 0x0007 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaax.zzui():java.lang.Class<?>");
    }
}
