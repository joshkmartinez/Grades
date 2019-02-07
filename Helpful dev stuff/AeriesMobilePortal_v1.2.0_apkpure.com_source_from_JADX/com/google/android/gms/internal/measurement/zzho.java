package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzho implements Callable<String> {
    private final /* synthetic */ zzhk zzanw;

    zzho(zzhk com_google_android_gms_internal_measurement_zzhk) {
        this.zzanw = com_google_android_gms_internal_measurement_zzhk;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zzja = this.zzanw.zzgf().zzja();
        if (zzja != null) {
            return zzja;
        }
        zzfi zzim;
        String str;
        zzhg zzfu = this.zzanw.zzfu();
        String str2 = null;
        if (zzfu.zzgd().zzjk()) {
            zzim = zzfu.zzge().zzim();
            str = "Cannot retrieve app instance id from analytics worker thread";
        } else {
            zzfu.zzgd();
            if (zzgg.isMainThread()) {
                zzim = zzfu.zzge().zzim();
                str = "Cannot retrieve app instance id from main thread";
            } else {
                long elapsedRealtime = zzfu.zzbt().elapsedRealtime();
                String zzae = zzfu.zzae(120000);
                long elapsedRealtime2 = zzfu.zzbt().elapsedRealtime() - elapsedRealtime;
                str2 = (zzae != null || elapsedRealtime2 >= 120000) ? zzae : zzfu.zzae(120000 - elapsedRealtime2);
                if (str2 == null) {
                    this.zzanw.zzgf().zzbr(str2);
                    return str2;
                }
                throw new TimeoutException();
            }
        }
        zzim.log(str);
        if (str2 == null) {
            throw new TimeoutException();
        }
        this.zzanw.zzgf().zzbr(str2);
        return str2;
    }
}
