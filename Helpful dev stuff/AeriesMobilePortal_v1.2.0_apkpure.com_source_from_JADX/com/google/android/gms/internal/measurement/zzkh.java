package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkh extends zzaby<zzkh> {
    private static volatile zzkh[] zzase;
    public Integer zzarp;
    public String zzasf;
    public zzkf zzasg;

    public zzkh() {
        this.zzarp = null;
        this.zzasf = null;
        this.zzasg = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkh[] zzlh() {
        if (zzase == null) {
            synchronized (zzacc.zzbxg) {
                if (zzase == null) {
                    zzase = new zzkh[0];
                }
            }
        }
        return zzase;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return false;
        }
        zzkh com_google_android_gms_internal_measurement_zzkh = (zzkh) obj;
        if (this.zzarp == null) {
            if (com_google_android_gms_internal_measurement_zzkh.zzarp != null) {
                return false;
            }
        } else if (!this.zzarp.equals(com_google_android_gms_internal_measurement_zzkh.zzarp)) {
            return false;
        }
        if (this.zzasf == null) {
            if (com_google_android_gms_internal_measurement_zzkh.zzasf != null) {
                return false;
            }
        } else if (!this.zzasf.equals(com_google_android_gms_internal_measurement_zzkh.zzasf)) {
            return false;
        }
        if (this.zzasg == null) {
            if (com_google_android_gms_internal_measurement_zzkh.zzasg != null) {
                return false;
            }
        } else if (!this.zzasg.equals(com_google_android_gms_internal_measurement_zzkh.zzasg)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkh.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkh.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkh.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((527 + getClass().getName().hashCode()) * 31) + (this.zzarp == null ? 0 : this.zzarp.hashCode())) * 31) + (this.zzasf == null ? 0 : this.zzasf.hashCode());
        zzkf com_google_android_gms_internal_measurement_zzkf = this.zzasg;
        hashCode = ((hashCode * 31) + (com_google_android_gms_internal_measurement_zzkf == null ? 0 : com_google_android_gms_internal_measurement_zzkf.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzarp != null) {
            zza += zzabw.zzf(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            zza += zzabw.zzc(2, this.zzasf);
        }
        return this.zzasg != null ? zza + zzabw.zzb(3, this.zzasg) : zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzarp != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(1, this.zzarp.intValue());
        }
        if (this.zzasf != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(2, this.zzasf);
        }
        if (this.zzasg != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(3, this.zzasg);
        }
        super.zza(com_google_android_gms_internal_measurement_zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv com_google_android_gms_internal_measurement_zzabv) throws IOException {
        while (true) {
            int zzuw = com_google_android_gms_internal_measurement_zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            if (zzuw == 8) {
                this.zzarp = Integer.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuy());
            } else if (zzuw == 18) {
                this.zzasf = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 26) {
                if (this.zzasg == null) {
                    this.zzasg = new zzkf();
                }
                com_google_android_gms_internal_measurement_zzabv.zza(this.zzasg);
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
