package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class zzan {
    private static zzan zzcl;
    @GuardedBy("serviceClassNames")
    private final SimpleArrayMap<String, String> zzcm = new SimpleArrayMap();
    private Boolean zzcn = null;
    @VisibleForTesting
    final Queue<Intent> zzco = new ArrayDeque();
    @VisibleForTesting
    private final Queue<Intent> zzcp = new ArrayDeque();

    private zzan() {
    }

    public static PendingIntent zza(Context context, int i, Intent intent, int i2) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i, intent2, ErrorDialogData.SUPPRESSED);
    }

    public static synchronized zzan zzad() {
        zzan com_google_firebase_iid_zzan;
        synchronized (zzan.class) {
            if (zzcl == null) {
                zzcl = new zzan();
            }
            com_google_firebase_iid_zzan = zzcl;
        }
        return com_google_firebase_iid_zzan;
    }

    private final int zzb(Context context, Intent intent) {
        String str;
        ComponentName startWakefulService;
        synchronized (this.zzcm) {
            str = (String) this.zzcm.get(intent.getAction());
        }
        boolean z = false;
        if (str == null) {
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                if (resolveService.serviceInfo != null) {
                    ServiceInfo serviceInfo = resolveService.serviceInfo;
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        if (serviceInfo.name != null) {
                            str = serviceInfo.name;
                            if (str.startsWith(".")) {
                                String valueOf = String.valueOf(context.getPackageName());
                                str = String.valueOf(str);
                                str = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
                            }
                            synchronized (this.zzcm) {
                                this.zzcm.put(intent.getAction(), str);
                            }
                        }
                    }
                    String str2 = serviceInfo.packageName;
                    str = serviceInfo.name;
                    StringBuilder stringBuilder = new StringBuilder((94 + String.valueOf(str2).length()) + String.valueOf(str).length());
                    stringBuilder.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                    stringBuilder.append(str2);
                    stringBuilder.append("/");
                    stringBuilder.append(str);
                    Log.e("FirebaseInstanceId", stringBuilder.toString());
                    if (this.zzcn == null) {
                        if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                            z = true;
                        }
                        this.zzcn = Boolean.valueOf(z);
                    }
                    if (this.zzcn.booleanValue()) {
                        startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
                    } else {
                        startWakefulService = context.startService(intent);
                        Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                    }
                    if (startWakefulService == null) {
                        return -1;
                    }
                    Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                    return HttpStatus.HTTP_NOT_FOUND;
                }
            }
            Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
            if (this.zzcn == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.zzcn = Boolean.valueOf(z);
            }
            if (this.zzcn.booleanValue()) {
                startWakefulService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            } else {
                startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            }
            if (startWakefulService == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            str2 = "Restricting intent to a specific service: ";
            String valueOf2 = String.valueOf(str);
            Log.d(valueOf, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
        intent.setClassName(context.getPackageName(), str);
        try {
            if (this.zzcn == null) {
                if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                    z = true;
                }
                this.zzcn = Boolean.valueOf(z);
            }
            if (this.zzcn.booleanValue()) {
                startWakefulService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                startWakefulService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startWakefulService == null) {
                return -1;
            }
            Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
            return HttpStatus.HTTP_NOT_FOUND;
        } catch (Throwable e) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e);
            return 401;
        } catch (IllegalStateException e2) {
            String valueOf3 = String.valueOf(e2);
            StringBuilder stringBuilder2 = new StringBuilder(45 + String.valueOf(valueOf3).length());
            stringBuilder2.append("Failed to start service while in background: ");
            stringBuilder2.append(valueOf3);
            Log.e("FirebaseInstanceId", stringBuilder2.toString());
            return 402;
        }
    }

    public final int zza(Context context, String str, Intent intent) {
        Object obj;
        Queue queue;
        String str2;
        String str3;
        int hashCode = str.hashCode();
        if (hashCode != -842411455) {
            if (hashCode == 41532704) {
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            queue = this.zzco;
                            break;
                        case 1:
                            queue = this.zzcp;
                            break;
                        default:
                            str2 = "FirebaseInstanceId";
                            str3 = "Unknown service action: ";
                            str = String.valueOf(str);
                            Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
                            return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
                    }
                    queue.offer(intent);
                    intent = new Intent(str);
                    intent.setPackage(context.getPackageName());
                    return zzb(context, intent);
                }
            }
        } else if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            obj = null;
            switch (obj) {
                case null:
                    queue = this.zzco;
                    break;
                case 1:
                    queue = this.zzcp;
                    break;
                default:
                    str2 = "FirebaseInstanceId";
                    str3 = "Unknown service action: ";
                    str = String.valueOf(str);
                    if (str.length() != 0) {
                    }
                    Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
                    return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
            }
            queue.offer(intent);
            intent = new Intent(str);
            intent.setPackage(context.getPackageName());
            return zzb(context, intent);
        }
        obj = -1;
        switch (obj) {
            case null:
                queue = this.zzco;
                break;
            case 1:
                queue = this.zzcp;
                break;
            default:
                str2 = "FirebaseInstanceId";
                str3 = "Unknown service action: ";
                str = String.valueOf(str);
                if (str.length() != 0) {
                }
                Log.w(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
                return HttpStatus.HTTP_INTERNAL_SERVER_ERROR;
        }
        queue.offer(intent);
        intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        return zzb(context, intent);
    }

    public final Intent zzae() {
        return (Intent) this.zzcp.poll();
    }
}
