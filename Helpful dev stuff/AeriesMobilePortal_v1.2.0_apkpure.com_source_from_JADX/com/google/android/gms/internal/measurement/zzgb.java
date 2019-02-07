package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzgb {
    private final zzge zzala;

    public zzgb(zzge com_google_android_gms_internal_measurement_zzge) {
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzge);
        this.zzala = com_google_android_gms_internal_measurement_zzge;
    }

    public static boolean zza(android.content.Context r4) {
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
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r4);
        r0 = 0;
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001e }
        if (r1 != 0) goto L_0x000b;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x000a:
        return r0;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x000b:
        r2 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x001e }
        r3 = "com.google.android.gms.measurement.AppMeasurementReceiver";	 Catch:{ NameNotFoundException -> 0x001e }
        r2.<init>(r4, r3);	 Catch:{ NameNotFoundException -> 0x001e }
        r4 = r1.getReceiverInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x001e }
        if (r4 == 0) goto L_0x001e;	 Catch:{ NameNotFoundException -> 0x001e }
    L_0x0018:
        r4 = r4.enabled;	 Catch:{ NameNotFoundException -> 0x001e }
        if (r4 == 0) goto L_0x001e;
    L_0x001c:
        r4 = 1;
        return r4;
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgb.zza(android.content.Context):boolean");
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        zzjr zzg = zzgl.zzg(context);
        zzfg zzge = zzg.zzge();
        if (intent == null) {
            zzge.zzip().log("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzge.zzit().zzg("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            intent = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            intent.setAction("com.google.android.gms.measurement.UPLOAD");
            zzge.zzit().log("Starting wakeful intent.");
            this.zzala.doStartService(context, intent);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzg.zzgd().zzc(new zzgc(this, zzg, zzge));
            } catch (Exception e) {
                zzge.zzip().zzg("Install Referrer Reporter encountered a problem", e);
            }
            PendingResult doGoAsync = this.zzala.doGoAsync();
            action = intent.getStringExtra("referrer");
            if (action == null) {
                zzge.zzit().log("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                }
                return;
            }
            zzge.zzir().zzg("Install referrer extras are", action);
            if (!action.contains("?")) {
                String str = "?";
                action = String.valueOf(action);
                action = action.length() != 0 ? str.concat(action) : new String(str);
            }
            Bundle zza = zzg.zzgb().zza(Uri.parse(action));
            if (zza == null) {
                zzge.zzit().log("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzge.zzip().log("Install referrer is missing timestamp");
            }
            zzg.zzgd().zzc(new zzgd(this, zzg, longExtra, zza, context, zzge, doGoAsync));
        }
    }
}
