package com.google.android.gms.common.config;

import android.content.Context;

final class zzb extends GservicesValue<Long> {
    zzb(String str, Long l) {
        super(str, l);
    }

    private static java.lang.Long zza(android.content.Context r2, java.lang.String r3, java.lang.Long r4) {
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
        r0 = "gservices-direboot-cache";
        r1 = 0;
        r2 = r2.getSharedPreferences(r0, r1);
        r0 = 0;
        r2 = r2.getString(r3, r0);
        if (r2 == 0) goto L_0x0017;
    L_0x000e:
        r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x0017 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ NumberFormatException -> 0x0017 }
        return r2;
    L_0x0017:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.config.zzb.zza(android.content.Context, java.lang.String, java.lang.Long):java.lang.Long");
    }

    protected final /* synthetic */ Object retrieve(String str) {
        return GservicesValue.zzmu.getLong(this.mKey, (Long) this.mDefaultValue);
    }

    protected final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        return zza(context, str, (Long) obj);
    }
}
