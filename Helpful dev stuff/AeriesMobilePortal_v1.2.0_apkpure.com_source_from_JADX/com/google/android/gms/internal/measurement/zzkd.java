package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkd extends zzaby<zzkd> {
    private static volatile zzkd[] zzark;
    public Integer zzarl;
    public zzkh[] zzarm;
    public zzke[] zzarn;

    public zzkd() {
        this.zzarl = null;
        this.zzarm = zzkh.zzlh();
        this.zzarn = zzke.zzlf();
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkd[] zzle() {
        if (zzark == null) {
            synchronized (zzacc.zzbxg) {
                if (zzark == null) {
                    zzark = new zzkd[0];
                }
            }
        }
        return zzark;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkd)) {
            return false;
        }
        zzkd com_google_android_gms_internal_measurement_zzkd = (zzkd) obj;
        if (this.zzarl == null) {
            if (com_google_android_gms_internal_measurement_zzkd.zzarl != null) {
                return false;
            }
        } else if (!this.zzarl.equals(com_google_android_gms_internal_measurement_zzkd.zzarl)) {
            return false;
        }
        if (!zzacc.equals(this.zzarm, com_google_android_gms_internal_measurement_zzkd.zzarm) || !zzacc.equals(this.zzarn, com_google_android_gms_internal_measurement_zzkd.zzarn)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkd.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkd.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkd.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((527 + getClass().getName().hashCode()) * 31) + (this.zzarl == null ? 0 : this.zzarl.hashCode())) * 31) + zzacc.hashCode(this.zzarm)) * 31) + zzacc.hashCode(this.zzarn)) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        int i = 0;
        if (this.zzarm != null && this.zzarm.length > 0) {
            int i2 = zza;
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzarm) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    i2 += zzabw.zzb(2, com_google_android_gms_internal_measurement_zzace);
                }
            }
            zza = i2;
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            while (i < this.zzarn.length) {
                zzace com_google_android_gms_internal_measurement_zzace2 = this.zzarn[i];
                if (com_google_android_gms_internal_measurement_zzace2 != null) {
                    zza += zzabw.zzb(3, com_google_android_gms_internal_measurement_zzace2);
                }
                i++;
            }
        }
        return zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzarl != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(1, this.zzarl.intValue());
        }
        int i = 0;
        if (this.zzarm != null && this.zzarm.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzarm) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(2, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        if (this.zzarn != null && this.zzarn.length > 0) {
            while (i < this.zzarn.length) {
                zzace com_google_android_gms_internal_measurement_zzace2 = this.zzarn[i];
                if (com_google_android_gms_internal_measurement_zzace2 != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(3, com_google_android_gms_internal_measurement_zzace2);
                }
                i++;
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
            if (zzuw == 8) {
                this.zzarl = Integer.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuy());
            } else if (zzuw == 18) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 18);
                r1 = this.zzarm == null ? 0 : this.zzarm.length;
                r0 = new zzkh[(zzuw + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.zzarm, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzkh();
                    com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    r1++;
                }
                r0[r1] = new zzkh();
                com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                this.zzarm = r0;
            } else if (zzuw == 26) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 26);
                r1 = this.zzarn == null ? 0 : this.zzarn.length;
                r0 = new zzke[(zzuw + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.zzarn, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzke();
                    com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    r1++;
                }
                r0[r1] = new zzke();
                com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                this.zzarn = r0;
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
