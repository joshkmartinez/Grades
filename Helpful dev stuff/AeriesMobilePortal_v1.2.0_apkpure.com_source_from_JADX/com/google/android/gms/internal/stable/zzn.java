package com.google.android.gms.internal.stable;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzn extends WeakReference<Throwable> {
    private final int zzahl;

    public zzn(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzahl = System.identityHashCode(th);
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
                zzn com_google_android_gms_internal_stable_zzn = (zzn) obj;
                return this.zzahl == com_google_android_gms_internal_stable_zzn.zzahl && get() == com_google_android_gms_internal_stable_zzn.get();
            }
        }
    }

    public final int hashCode() {
        return this.zzahl;
    }
}
