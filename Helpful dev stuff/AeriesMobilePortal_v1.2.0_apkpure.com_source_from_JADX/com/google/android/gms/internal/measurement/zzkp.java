package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkp extends zzaby<zzkp> {
    public zzkq[] zzatf;

    public zzkp() {
        this.zzatf = zzkq.zzln();
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzkp com_google_android_gms_internal_measurement_zzkp = (zzkp) obj;
        if (!zzacc.equals(this.zzatf, com_google_android_gms_internal_measurement_zzkp.zzatf)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkp.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkp.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkp.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((527 + getClass().getName().hashCode()) * 31) + zzacc.hashCode(this.zzatf)) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                hashCode = this.zzbww.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzatf) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    zza += zzabw.zzb(1, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        return zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzatf != null && this.zzatf.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzatf) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(1, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        super.zza(com_google_android_gms_internal_measurement_zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv com_google_android_gms_internal_measurement_zzabv) throws IOException {
        while (true) {
            int zzuw = com_google_android_gms_internal_measurement_zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 10) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 10);
                int length = this.zzatf == null ? 0 : this.zzatf.length;
                Object obj = new zzkq[(zzuw + length)];
                if (length != 0) {
                    System.arraycopy(this.zzatf, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzkq();
                    com_google_android_gms_internal_measurement_zzabv.zza(obj[length]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    length++;
                }
                obj[length] = new zzkq();
                com_google_android_gms_internal_measurement_zzabv.zza(obj[length]);
                this.zzatf = obj;
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
