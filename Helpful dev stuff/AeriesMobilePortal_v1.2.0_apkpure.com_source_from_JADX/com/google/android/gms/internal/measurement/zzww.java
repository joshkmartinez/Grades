package com.google.android.gms.internal.measurement;

final class zzww extends zzws<Long> {
    zzww(zzxc com_google_android_gms_internal_measurement_zzxc, String str, Long l) {
        super(com_google_android_gms_internal_measurement_zzxc, str, l);
    }

    private final java.lang.Long zzez(java.lang.String r5) {
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
        r0 = java.lang.Long.parseLong(r5);	 Catch:{ NumberFormatException -> 0x0009 }
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = "PhenotypeFlag";
        r1 = r4.zzbnh;
        r2 = 25;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r5);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Invalid long value for ";
        r3.append(r2);
        r3.append(r1);
        r1 = ": ";
        r3.append(r1);
        r3.append(r5);
        r5 = r3.toString();
        android.util.Log.e(r0, r5);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzww.zzez(java.lang.String):java.lang.Long");
    }

    protected final /* synthetic */ Object zzey(String str) {
        return zzez(str);
    }
}
