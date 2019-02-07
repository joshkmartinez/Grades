package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.commons.cli.HelpFormatter;

public final class zzeo extends zzhh {
    private long zzafm;
    private String zzafn;
    private Boolean zzafo;

    zzeo(zzgl com_google_android_gms_internal_measurement_zzgl) {
        super(com_google_android_gms_internal_measurement_zzgl);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final boolean zzf(android.content.Context r3) {
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
        r2 = this;
        r0 = r2.zzafo;
        if (r0 != 0) goto L_0x001f;
    L_0x0004:
        r0 = 0;
        r0 = java.lang.Boolean.valueOf(r0);
        r2.zzafo = r0;
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001f }
        if (r3 == 0) goto L_0x001f;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x0011:
        r0 = "com.google.android.gms";	 Catch:{ NameNotFoundException -> 0x001f }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x001f }
        r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x001f }
        r3 = 1;	 Catch:{ NameNotFoundException -> 0x001f }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ NameNotFoundException -> 0x001f }
        r2.zzafo = r3;	 Catch:{ NameNotFoundException -> 0x001f }
    L_0x001f:
        r3 = r2.zzafo;
        r3 = r3.booleanValue();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeo.zzf(android.content.Context):boolean");
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
        Calendar instance = Calendar.getInstance();
        this.zzafm = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String toLowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String toLowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(toLowerCase).length()) + String.valueOf(toLowerCase2).length());
        stringBuilder.append(toLowerCase);
        stringBuilder.append(HelpFormatter.DEFAULT_OPT_PREFIX);
        stringBuilder.append(toLowerCase2);
        this.zzafn = stringBuilder.toString();
        return false;
    }

    public final long zzic() {
        zzch();
        return this.zzafm;
    }

    public final String zzid() {
        zzch();
        return this.zzafn;
    }
}
