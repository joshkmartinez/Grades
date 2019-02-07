package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzil implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzil(zzii com_google_android_gms_internal_measurement_zzii, AtomicReference atomicReference, zzdz com_google_android_gms_internal_measurement_zzdz) {
        this.zzape = com_google_android_gms_internal_measurement_zzii;
        this.zzapf = atomicReference;
        this.zzane = com_google_android_gms_internal_measurement_zzdz;
    }

    public final void run() {
        synchronized (this.zzapf) {
            Object obj;
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().log("Failed to get app instance id");
                    this.zzapf.notify();
                    return;
                }
                this.zzapf.set(zzd.zzc(this.zzane));
                String str = (String) this.zzapf.get();
                if (str != null) {
                    this.zzape.zzfu().zzbr(str);
                    this.zzape.zzgf().zzakb.zzbs(str);
                }
                this.zzape.zzcu();
                obj = this.zzapf;
                obj.notify();
            } catch (RemoteException e) {
                try {
                    this.zzape.zzge().zzim().zzg("Failed to get app instance id", e);
                    obj = this.zzapf;
                } catch (Throwable th) {
                    this.zzapf.notify();
                }
            }
        }
    }
}
