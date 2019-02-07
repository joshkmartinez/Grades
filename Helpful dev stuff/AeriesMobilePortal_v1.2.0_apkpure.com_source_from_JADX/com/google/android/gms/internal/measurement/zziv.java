package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zziv implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ boolean zzanz;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zziv(zzii com_google_android_gms_internal_measurement_zzii, AtomicReference atomicReference, zzdz com_google_android_gms_internal_measurement_zzdz, boolean z) {
        this.zzape = com_google_android_gms_internal_measurement_zzii;
        this.zzapf = atomicReference;
        this.zzane = com_google_android_gms_internal_measurement_zzdz;
        this.zzanz = z;
    }

    public final void run() {
        synchronized (this.zzapf) {
            Object obj;
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().log("Failed to get user properties");
                    this.zzapf.notify();
                    return;
                }
                this.zzapf.set(zzd.zza(this.zzane, this.zzanz));
                this.zzape.zzcu();
                obj = this.zzapf;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzape.zzge().zzim().zzg("Failed to get user properties", e);
                    obj = this.zzapf;
                } catch (Throwable th) {
                    this.zzapf.notify();
                }
            }
        }
    }
}
