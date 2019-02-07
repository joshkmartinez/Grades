package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzk extends WeakReference<Throwable> {
    private final int zzj;

    public zzk(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzj = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                if (this == obj) {
                    return true;
                }
                zzk com_google_android_gms_internal_firebase_messaging_zzk = (zzk) obj;
                return this.zzj == com_google_android_gms_internal_firebase_messaging_zzk.zzj && get() == com_google_android_gms_internal_firebase_messaging_zzk.get();
            }
        }
    }

    public final int hashCode() {
        return this.zzj;
    }
}
