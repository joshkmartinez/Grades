package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzin implements Runnable {
    private final /* synthetic */ zzie zzaow;
    private final /* synthetic */ zzii zzape;

    zzin(zzii com_google_android_gms_internal_measurement_zzii, zzie com_google_android_gms_internal_measurement_zzie) {
        this.zzape = com_google_android_gms_internal_measurement_zzii;
        this.zzaow = com_google_android_gms_internal_measurement_zzie;
    }

    public final void run() {
        zzey zzd = this.zzape.zzaoy;
        if (zzd == null) {
            this.zzape.zzge().zzim().log("Failed to send current screen to service");
            return;
        }
        try {
            long j;
            String str;
            String str2;
            String packageName;
            if (this.zzaow == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzape.getContext().getPackageName();
            } else {
                j = this.zzaow.zzaoj;
                str = this.zzaow.zzul;
                str2 = this.zzaow.zzaoi;
                packageName = this.zzape.getContext().getPackageName();
            }
            zzd.zza(j, str, str2, packageName);
            this.zzape.zzcu();
        } catch (RemoteException e) {
            this.zzape.zzge().zzim().zzg("Failed to send current screen to the service", e);
        }
    }
}
