package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.GuardedBy;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class zzao {
    private final SharedPreferences zzcq;
    private final zzp zzcr;
    @GuardedBy("this")
    private final Map<String, zzq> zzcs;
    private final Context zzz;

    public zzao(Context context) {
        this(context, new zzp());
    }

    private zzao(Context context, zzp com_google_firebase_iid_zzp) {
        this.zzcs = new ArrayMap();
        this.zzz = context;
        this.zzcq = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzcr = com_google_firebase_iid_zzp;
        File file = new File(ContextCompat.getNoBackupFilesDir(this.zzz), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    zzag();
                    FirebaseInstanceId.getInstance().zzk();
                }
            } catch (IOException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String str = "FirebaseInstanceId";
                    String str2 = "Error creating file in no backup dir: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.d(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
    }

    private final synchronized boolean isEmpty() {
        return this.zzcq.getAll().isEmpty();
    }

    private static String zza(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(((4 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(str3).length());
        stringBuilder.append(str);
        stringBuilder.append("|T|");
        stringBuilder.append(str2);
        stringBuilder.append("|");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    static String zzd(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder((3 + String.valueOf(str).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append("|S|");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final synchronized void zza(String str) {
        String string = this.zzcq.getString("topic_operaion_queue", "");
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(string).length()) + String.valueOf(str).length());
        stringBuilder.append(string);
        stringBuilder.append(",");
        stringBuilder.append(str);
        this.zzcq.edit().putString("topic_operaion_queue", stringBuilder.toString()).apply();
    }

    public final synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        str4 = zzap.zza(str4, str5, System.currentTimeMillis());
        if (str4 != null) {
            Editor edit = this.zzcq.edit();
            edit.putString(zza(str, str2, str3), str4);
            edit.commit();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    public final synchronized java.lang.String zzaf() {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.zzcq;	 Catch:{ all -> 0x0024 }
        r1 = "topic_operaion_queue";
        r2 = 0;
        r0 = r0.getString(r1, r2);	 Catch:{ all -> 0x0024 }
        if (r0 == 0) goto L_0x0022;
    L_0x000c:
        r1 = ",";
        r0 = r0.split(r1);	 Catch:{ all -> 0x0024 }
        r1 = r0.length;	 Catch:{ all -> 0x0024 }
        r3 = 1;
        if (r1 <= r3) goto L_0x0022;
    L_0x0016:
        r1 = r0[r3];	 Catch:{ all -> 0x0024 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0024 }
        if (r1 != 0) goto L_0x0022;
    L_0x001e:
        r0 = r0[r3];	 Catch:{ all -> 0x0024 }
        monitor-exit(r4);
        return r0;
    L_0x0022:
        monitor-exit(r4);
        return r2;
    L_0x0024:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzao.zzaf():java.lang.String");
    }

    public final synchronized void zzag() {
        this.zzcs.clear();
        zzp.zza(this.zzz);
        this.zzcq.edit().clear().commit();
    }

    public final synchronized zzap zzb(String str, String str2, String str3) {
        return zzap.zzi(this.zzcq.getString(zza(str, str2, str3), null));
    }

    public final synchronized void zzc(String str, String str2, String str3) {
        str = zza(str, str2, str3);
        Editor edit = this.zzcq.edit();
        edit.remove(str);
        edit.commit();
    }

    public final synchronized boolean zzf(String str) {
        boolean z;
        String string = this.zzcq.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            valueOf = String.valueOf(",");
            str = String.valueOf(str);
            this.zzcq.edit().putString("topic_operaion_queue", string.substring((str.length() != 0 ? valueOf.concat(str) : new String(valueOf)).length())).apply();
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized com.google.firebase.iid.zzq zzg(java.lang.String r3) {
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
        monitor-enter(r2);
        r0 = r2.zzcs;	 Catch:{ all -> 0x0033 }
        r0 = r0.get(r3);	 Catch:{ all -> 0x0033 }
        r0 = (com.google.firebase.iid.zzq) r0;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r2);
        return r0;
    L_0x000d:
        r0 = r2.zzcr;	 Catch:{ zzr -> 0x0016 }
        r1 = r2.zzz;	 Catch:{ zzr -> 0x0016 }
        r0 = r0.zzb(r1, r3);	 Catch:{ zzr -> 0x0016 }
        goto L_0x002c;
    L_0x0016:
        r0 = "FirebaseInstanceId";	 Catch:{ all -> 0x0033 }
        r1 = "Stored data is corrupt, generating new identity";	 Catch:{ all -> 0x0033 }
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x0033 }
        r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance();	 Catch:{ all -> 0x0033 }
        r0.zzk();	 Catch:{ all -> 0x0033 }
        r0 = r2.zzcr;	 Catch:{ all -> 0x0033 }
        r1 = r2.zzz;	 Catch:{ all -> 0x0033 }
        r0 = r0.zzc(r1, r3);	 Catch:{ all -> 0x0033 }
    L_0x002c:
        r1 = r2.zzcs;	 Catch:{ all -> 0x0033 }
        r1.put(r3, r0);	 Catch:{ all -> 0x0033 }
        monitor-exit(r2);
        return r0;
    L_0x0033:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzao.zzg(java.lang.String):com.google.firebase.iid.zzq");
    }

    public final synchronized void zzh(String str) {
        str = String.valueOf(str).concat("|T|");
        Editor edit = this.zzcq.edit();
        for (String str2 : this.zzcq.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }
}
