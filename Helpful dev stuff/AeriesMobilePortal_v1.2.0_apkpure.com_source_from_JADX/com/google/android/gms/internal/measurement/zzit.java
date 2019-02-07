package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzit implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ String zzanh;
    private final /* synthetic */ String zzani;
    private final /* synthetic */ String zzanj;
    private final /* synthetic */ boolean zzanz;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zzit(zzii com_google_android_gms_internal_measurement_zzii, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzdz com_google_android_gms_internal_measurement_zzdz) {
        this.zzape = com_google_android_gms_internal_measurement_zzii;
        this.zzapf = atomicReference;
        this.zzanj = str;
        this.zzanh = str2;
        this.zzani = str3;
        this.zzanz = z;
        this.zzane = com_google_android_gms_internal_measurement_zzdz;
    }

    public final void run() {
        synchronized (this.zzapf) {
            Object zza;
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, this.zzani);
                    this.zzapf.set(Collections.emptyList());
                    this.zzapf.notify();
                    return;
                }
                AtomicReference atomicReference;
                if (TextUtils.isEmpty(this.zzanj)) {
                    atomicReference = this.zzapf;
                    zza = zzd.zza(this.zzanh, this.zzani, this.zzanz, this.zzane);
                } else {
                    atomicReference = this.zzapf;
                    zza = zzd.zza(this.zzanj, this.zzanh, this.zzani, this.zzanz);
                }
                atomicReference.set(zza);
                this.zzape.zzcu();
                zza = this.zzapf;
                zza.notify();
            } catch (RemoteException e) {
                try {
                    this.zzape.zzge().zzim().zzd("Failed to get user properties", zzfg.zzbm(this.zzanj), this.zzanh, e);
                    this.zzapf.set(Collections.emptyList());
                    zza = this.zzapf;
                } catch (Throwable th) {
                    this.zzapf.notify();
                }
            }
        }
    }
}
