package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.concurrent.GuardedBy;

public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private static boolean zzat = false;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static zzh zzau;
    @GuardedBy("FirebaseInstanceIdReceiver.class")
    private static zzh zzav;

    private static synchronized zzh zza(Context context, String str) {
        synchronized (FirebaseInstanceIdReceiver.class) {
            if ("com.google.firebase.MESSAGING_EVENT".equals(str)) {
                if (zzav == null) {
                    zzav = new zzh(context, str);
                }
                zzh com_google_firebase_iid_zzh = zzav;
                return com_google_firebase_iid_zzh;
            }
            if (zzau == null) {
                zzau = new zzh(context, str);
            }
            com_google_firebase_iid_zzh = zzau;
            return com_google_firebase_iid_zzh;
        }
    }

    private final void zza(Context context, Intent intent, String str) {
        int i;
        String str2 = null;
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        int i2 = 0;
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        if (!"google.com/iid".equals(intent.getStringExtra("from"))) {
            if (!"com.google.firebase.INSTANCE_ID_EVENT".equals(str)) {
                if (!"com.google.android.c2dm.intent.RECEIVE".equals(str)) {
                    if (!"com.google.firebase.MESSAGING_EVENT".equals(str)) {
                        Log.d("FirebaseInstanceId", "Unexpected intent");
                        i = -1;
                        if (str2 != null) {
                            if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
                                i2 = 1;
                            }
                            if (i2 != 0) {
                                if (isOrderedBroadcast()) {
                                    setResultCode(-1);
                                }
                                zza(context, str2).zza(intent, goAsync());
                            } else {
                                i = zzan.zzad().zza(context, str2, intent);
                            }
                        }
                        if (!isOrderedBroadcast()) {
                            setResultCode(i);
                        }
                    }
                }
                str2 = "com.google.firebase.MESSAGING_EVENT";
                i = -1;
                if (str2 != null) {
                    i2 = 1;
                    if (i2 != 0) {
                        i = zzan.zzad().zza(context, str2, intent);
                    } else {
                        if (isOrderedBroadcast()) {
                            setResultCode(-1);
                        }
                        zza(context, str2).zza(intent, goAsync());
                    }
                }
                if (!isOrderedBroadcast()) {
                    setResultCode(i);
                }
            }
        }
        str2 = "com.google.firebase.INSTANCE_ID_EVENT";
        i = -1;
        if (str2 != null) {
            i2 = 1;
            if (i2 != 0) {
                if (isOrderedBroadcast()) {
                    setResultCode(-1);
                }
                zza(context, str2).zza(intent, goAsync());
            } else {
                i = zzan.zzad().zza(context, str2, intent);
            }
        }
        if (!isOrderedBroadcast()) {
            setResultCode(i);
        }
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            if (parcelableExtra instanceof Intent) {
                zza(context, (Intent) parcelableExtra, intent.getAction());
            } else {
                zza(context, intent, intent.getAction());
            }
        }
    }
}
