package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.iid.zzi.zza;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class zzal {
    private static int zzbr;
    private static PendingIntent zzcf;
    private final zzae zzal;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcg = new SimpleArrayMap();
    private Messenger zzch;
    private Messenger zzci;
    private zzi zzcj;
    private final Context zzz;

    public zzal(Context context, zzae com_google_firebase_iid_zzae) {
        this.zzz = context;
        this.zzal = com_google_firebase_iid_zzae;
        this.zzch = new Messenger(new zzam(this, Looper.getMainLooper()));
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzal.class) {
            if (zzcf == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcf = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(SettingsJsonConstants.APP_KEY, zzcf);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcg) {
            TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zzcg.remove(str);
            if (taskCompletionSource == null) {
                String str2 = "FirebaseInstanceId";
                String str3 = "Missing callback for ";
                str = String.valueOf(str);
                Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
                return;
            }
            taskCompletionSource.setResult(bundle);
        }
    }

    private static synchronized String zzac() {
        String num;
        synchronized (zzal.class) {
            int i = zzbr;
            zzbr = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private final void zzb(Message message) {
        String str;
        String str2;
        if (message == null || !(message.obj instanceof Intent)) {
            str = "FirebaseInstanceId";
            str2 = "Dropping invalid message";
        } else {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new zza());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzi) {
                    this.zzcj = (zzi) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzci = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            str2 = intent2.getAction();
            String str3;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(str2)) {
                CharSequence stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra == null) {
                    str2 = intent2.getStringExtra("error");
                    if (str2 == null) {
                        str = String.valueOf(intent2.getExtras());
                        StringBuilder stringBuilder = new StringBuilder(49 + String.valueOf(str).length());
                        stringBuilder.append("Unexpected response, no error or registration id ");
                        stringBuilder.append(str);
                        Log.w("FirebaseInstanceId", stringBuilder.toString());
                    } else {
                        if (Log.isLoggable("FirebaseInstanceId", 3)) {
                            String str4 = "FirebaseInstanceId";
                            String str5 = "Received InstanceID error ";
                            String valueOf = String.valueOf(str2);
                            Log.d(str4, valueOf.length() != 0 ? str5.concat(valueOf) : new String(str5));
                        }
                        if (str2.startsWith("|")) {
                            String[] split = str2.split("\\|");
                            if (split.length > 2) {
                                if ("ID".equals(split[1])) {
                                    str2 = split[2];
                                    str3 = split[3];
                                    if (str3.startsWith(":")) {
                                        str3 = str3.substring(1);
                                    }
                                    zza(str2, intent2.putExtra("error", str3).getExtras());
                                }
                            }
                            str = "FirebaseInstanceId";
                            str3 = "Unexpected structured response ";
                            str2 = String.valueOf(str2);
                            str2 = str2.length() != 0 ? str3.concat(str2) : new String(str3);
                        } else {
                            synchronized (this.zzcg) {
                                for (int i = 0; i < this.zzcg.size(); i++) {
                                    zza((String) this.zzcg.keyAt(i), intent2.getExtras());
                                }
                            }
                        }
                    }
                }
                Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
                if (matcher.matches()) {
                    str2 = matcher.group(1);
                    str3 = matcher.group(2);
                    Bundle extras = intent2.getExtras();
                    extras.putString("registration_id", str3);
                    zza(str2, extras);
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str = "FirebaseInstanceId";
                    str3 = "Unexpected response string: ";
                    str2 = String.valueOf(stringExtra);
                    Log.d(str, str2.length() != 0 ? str3.concat(str2) : new String(str3));
                }
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                str = "FirebaseInstanceId";
                str3 = "Unexpected response action: ";
                str2 = String.valueOf(str2);
                Log.d(str, str2.length() != 0 ? str3.concat(str2) : new String(str3));
            }
            return;
        }
        Log.w(str, str2);
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        zze = zze(bundle);
        return (zze == null || !zze.containsKey("google.messenger")) ? zze : null;
    }

    private final android.os.Bundle zze(android.os.Bundle r9) throws java.io.IOException {
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
        r8 = this;
        r0 = zzac();
        r1 = new com.google.android.gms.tasks.TaskCompletionSource;
        r1.<init>();
        r2 = r8.zzcg;
        monitor-enter(r2);
        r3 = r8.zzcg;	 Catch:{ all -> 0x0124 }
        r3.put(r0, r1);	 Catch:{ all -> 0x0124 }
        monitor-exit(r2);	 Catch:{ all -> 0x0124 }
        r2 = r8.zzal;
        r2 = r2.zzx();
        if (r2 == 0) goto L_0x011c;
    L_0x001a:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r8.zzal;
        r3 = r3.zzx();
        r4 = 2;
        if (r3 != r4) goto L_0x0033;
    L_0x002d:
        r3 = "com.google.iid.TOKEN_REQUEST";
    L_0x002f:
        r2.setAction(r3);
        goto L_0x0036;
    L_0x0033:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        goto L_0x002f;
    L_0x0036:
        r2.putExtras(r9);
        r9 = r8.zzz;
        zza(r9, r2);
        r9 = "kid";
        r3 = 5;
        r5 = java.lang.String.valueOf(r0);
        r5 = r5.length();
        r3 = r3 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r3);
        r3 = "|ID|";
        r5.append(r3);
        r5.append(r0);
        r3 = "|";
        r5.append(r3);
        r3 = r5.toString();
        r2.putExtra(r9, r3);
        r9 = "FirebaseInstanceId";
        r3 = 3;
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x0095;
    L_0x006c:
        r9 = "FirebaseInstanceId";
        r5 = r2.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = 8;
        r7 = java.lang.String.valueOf(r5);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Sending ";
        r7.append(r6);
        r7.append(r5);
        r5 = r7.toString();
        android.util.Log.d(r9, r5);
    L_0x0095:
        r9 = "google.messenger";
        r5 = r8.zzch;
        r2.putExtra(r9, r5);
        r9 = r8.zzci;
        if (r9 != 0) goto L_0x00a4;
    L_0x00a0:
        r9 = r8.zzcj;
        if (r9 == 0) goto L_0x00c9;
    L_0x00a4:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r5 = r8.zzci;	 Catch:{ RemoteException -> 0x00ba }
        if (r5 == 0) goto L_0x00b4;	 Catch:{ RemoteException -> 0x00ba }
    L_0x00ae:
        r5 = r8.zzci;	 Catch:{ RemoteException -> 0x00ba }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00ba }
        goto L_0x00dc;	 Catch:{ RemoteException -> 0x00ba }
    L_0x00b4:
        r5 = r8.zzcj;	 Catch:{ RemoteException -> 0x00ba }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00ba }
        goto L_0x00dc;
    L_0x00ba:
        r9 = "FirebaseInstanceId";
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x00c9;
    L_0x00c2:
        r9 = "FirebaseInstanceId";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x00c9:
        r9 = r8.zzal;
        r9 = r9.zzx();
        if (r9 != r4) goto L_0x00d7;
    L_0x00d1:
        r9 = r8.zzz;
        r9.sendBroadcast(r2);
        goto L_0x00dc;
    L_0x00d7:
        r9 = r8.zzz;
        r9.startService(r2);
    L_0x00dc:
        r9 = r1.getTask();	 Catch:{ InterruptedException -> 0x0100, InterruptedException -> 0x0100, ExecutionException -> 0x00f9 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;	 Catch:{ InterruptedException -> 0x0100, InterruptedException -> 0x0100, ExecutionException -> 0x00f9 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0100, InterruptedException -> 0x0100, ExecutionException -> 0x00f9 }
        r9 = com.google.android.gms.tasks.Tasks.await(r9, r1, r3);	 Catch:{ InterruptedException -> 0x0100, InterruptedException -> 0x0100, ExecutionException -> 0x00f9 }
        r9 = (android.os.Bundle) r9;	 Catch:{ InterruptedException -> 0x0100, InterruptedException -> 0x0100, ExecutionException -> 0x00f9 }
        r1 = r8.zzcg;
        monitor-enter(r1);
        r2 = r8.zzcg;	 Catch:{ all -> 0x00f4 }
        r2.remove(r0);	 Catch:{ all -> 0x00f4 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f4 }
        return r9;	 Catch:{ all -> 0x00f4 }
    L_0x00f4:
        r9 = move-exception;	 Catch:{ all -> 0x00f4 }
        monitor-exit(r1);	 Catch:{ all -> 0x00f4 }
        throw r9;
    L_0x00f7:
        r9 = move-exception;
        goto L_0x010f;
    L_0x00f9:
        r9 = move-exception;
        r1 = new java.io.IOException;	 Catch:{ all -> 0x00f7 }
        r1.<init>(r9);	 Catch:{ all -> 0x00f7 }
        throw r1;	 Catch:{ all -> 0x00f7 }
    L_0x0100:
        r9 = "FirebaseInstanceId";	 Catch:{ all -> 0x00f7 }
        r1 = "No response";	 Catch:{ all -> 0x00f7 }
        android.util.Log.w(r9, r1);	 Catch:{ all -> 0x00f7 }
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00f7 }
        r1 = "TIMEOUT";	 Catch:{ all -> 0x00f7 }
        r9.<init>(r1);	 Catch:{ all -> 0x00f7 }
        throw r9;	 Catch:{ all -> 0x00f7 }
    L_0x010f:
        r1 = r8.zzcg;
        monitor-enter(r1);
        r2 = r8.zzcg;	 Catch:{ all -> 0x0119 }
        r2.remove(r0);	 Catch:{ all -> 0x0119 }
        monitor-exit(r1);	 Catch:{ all -> 0x0119 }
        throw r9;
    L_0x0119:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0119 }
        throw r9;
    L_0x011c:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x0124:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0124 }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzal.zze(android.os.Bundle):android.os.Bundle");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final android.os.Bundle zzc(android.os.Bundle r6) throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.zzal;
        r0 = r0.zzaa();
        r1 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r1) goto L_0x0068;
    L_0x000b:
        r0 = r5.zzz;
        r0 = com.google.firebase.iid.zzs.zzc(r0);
        r1 = 1;
        r0 = r0.zzb(r1, r6);
        r0 = com.google.android.gms.tasks.Tasks.await(r0);	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x004c;
    L_0x0027:
        r1 = "FirebaseInstanceId";
        r2 = java.lang.String.valueOf(r0);
        r3 = 22;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Error making request: ";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        android.util.Log.d(r1, r2);
    L_0x004c:
        r1 = r0.getCause();
        r1 = r1 instanceof com.google.firebase.iid.zzac;
        if (r1 == 0) goto L_0x0066;
    L_0x0054:
        r0 = r0.getCause();
        r0 = (com.google.firebase.iid.zzac) r0;
        r0 = r0.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x0066;
    L_0x0061:
        r6 = r5.zzd(r6);
        return r6;
    L_0x0066:
        r6 = 0;
        return r6;
    L_0x0068:
        r6 = r5.zzd(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzal.zzc(android.os.Bundle):android.os.Bundle");
    }
}
