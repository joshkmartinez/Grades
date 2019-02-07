package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzab<T> {
    final int what;
    final int zzbr;
    final TaskCompletionSource<T> zzbs = new TaskCompletionSource();
    final Bundle zzbt;

    zzab(int i, int i2, Bundle bundle) {
        this.zzbr = i;
        this.what = i2;
        this.zzbt = bundle;
    }

    final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder stringBuilder = new StringBuilder((16 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Finishing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.zzbs.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzbr;
        boolean zzw = zzw();
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Request { what=");
        stringBuilder.append(i);
        stringBuilder.append(" id=");
        stringBuilder.append(i2);
        stringBuilder.append(" oneWay=");
        stringBuilder.append(zzw);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    final void zza(zzac com_google_firebase_iid_zzac) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(com_google_firebase_iid_zzac);
            StringBuilder stringBuilder = new StringBuilder((14 + String.valueOf(valueOf).length()) + String.valueOf(valueOf2).length());
            stringBuilder.append("Failing ");
            stringBuilder.append(valueOf);
            stringBuilder.append(" with ");
            stringBuilder.append(valueOf2);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        this.zzbs.setException(com_google_firebase_iid_zzac);
    }

    abstract void zzb(Bundle bundle);

    abstract boolean zzw();
}
