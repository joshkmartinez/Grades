package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzf extends Binder {
    private final zzb zzw;

    zzf(zzb com_google_firebase_iid_zzb) {
        this.zzw = com_google_firebase_iid_zzb;
    }

    public final void zza(zzd com_google_firebase_iid_zzd) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "service received new intent via bind strategy");
            }
            if (this.zzw.zzc(com_google_firebase_iid_zzd.intent)) {
                com_google_firebase_iid_zzd.finish();
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "intent being queued for bg execution");
            }
            this.zzw.zzl.execute(new zzg(this, com_google_firebase_iid_zzd));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
