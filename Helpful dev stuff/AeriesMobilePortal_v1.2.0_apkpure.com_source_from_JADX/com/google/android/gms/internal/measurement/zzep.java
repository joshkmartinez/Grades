package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

public final class zzep {
    final String name;
    private final String origin;
    final long timestamp;
    final long zzafp;
    final zzer zzafq;
    final String zzti;

    zzep(zzgl com_google_android_gms_internal_measurement_zzgl, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzer com_google_android_gms_internal_measurement_zzer;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zzti = str2;
        this.name = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.origin = str;
        this.timestamp = j;
        this.zzafp = j2;
        if (this.zzafp != 0 && this.zzafp > this.timestamp) {
            com_google_android_gms_internal_measurement_zzgl.zzge().zzip().zzg("Event created with reverse previous/current timestamps. appId", zzfg.zzbm(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            com_google_android_gms_internal_measurement_zzer = new zzer(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                str3 = (String) it.next();
                if (str3 == null) {
                    com_google_android_gms_internal_measurement_zzgl.zzge().zzim().log("Param name can't be null");
                } else {
                    Object zzh = com_google_android_gms_internal_measurement_zzgl.zzgb().zzh(str3, bundle2.get(str3));
                    if (zzh == null) {
                        com_google_android_gms_internal_measurement_zzgl.zzge().zzip().zzg("Param value can't be null", com_google_android_gms_internal_measurement_zzgl.zzga().zzbk(str3));
                    } else {
                        com_google_android_gms_internal_measurement_zzgl.zzgb().zza(bundle2, str3, zzh);
                    }
                }
                it.remove();
            }
            com_google_android_gms_internal_measurement_zzer = new zzer(bundle2);
        }
        this.zzafq = com_google_android_gms_internal_measurement_zzer;
    }

    private zzep(zzgl com_google_android_gms_internal_measurement_zzgl, String str, String str2, String str3, long j, long j2, zzer com_google_android_gms_internal_measurement_zzer) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(com_google_android_gms_internal_measurement_zzer);
        this.zzti = str2;
        this.name = str3;
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.origin = str;
        this.timestamp = j;
        this.zzafp = j2;
        if (this.zzafp != 0 && this.zzafp > this.timestamp) {
            com_google_android_gms_internal_measurement_zzgl.zzge().zzip().zze("Event created with reverse previous/current timestamps. appId, name", zzfg.zzbm(str2), zzfg.zzbm(str3));
        }
        this.zzafq = com_google_android_gms_internal_measurement_zzer;
    }

    public final String toString() {
        String str = this.zzti;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        StringBuilder stringBuilder = new StringBuilder(((33 + String.valueOf(str).length()) + String.valueOf(str2).length()) + String.valueOf(valueOf).length());
        stringBuilder.append("Event{appId='");
        stringBuilder.append(str);
        stringBuilder.append("', name='");
        stringBuilder.append(str2);
        stringBuilder.append("', params=");
        stringBuilder.append(valueOf);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    final zzep zza(zzgl com_google_android_gms_internal_measurement_zzgl, long j) {
        return new zzep(com_google_android_gms_internal_measurement_zzgl, this.origin, this.zzti, this.name, this.timestamp, j, this.zzafq);
    }
}
