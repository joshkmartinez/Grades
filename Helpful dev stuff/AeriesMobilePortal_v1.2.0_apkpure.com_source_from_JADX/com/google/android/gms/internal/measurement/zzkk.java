package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkk extends zzaby<zzkk> {
    public String zzadm;
    public Long zzasp;
    private Integer zzasq;
    public zzkl[] zzasr;
    public zzkj[] zzass;
    public zzkd[] zzast;

    public zzkk() {
        this.zzasp = null;
        this.zzadm = null;
        this.zzasq = null;
        this.zzasr = zzkl.zzlj();
        this.zzass = zzkj.zzli();
        this.zzast = zzkd.zzle();
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkk)) {
            return false;
        }
        zzkk com_google_android_gms_internal_measurement_zzkk = (zzkk) obj;
        if (this.zzasp == null) {
            if (com_google_android_gms_internal_measurement_zzkk.zzasp != null) {
                return false;
            }
        } else if (!this.zzasp.equals(com_google_android_gms_internal_measurement_zzkk.zzasp)) {
            return false;
        }
        if (this.zzadm == null) {
            if (com_google_android_gms_internal_measurement_zzkk.zzadm != null) {
                return false;
            }
        } else if (!this.zzadm.equals(com_google_android_gms_internal_measurement_zzkk.zzadm)) {
            return false;
        }
        if (this.zzasq == null) {
            if (com_google_android_gms_internal_measurement_zzkk.zzasq != null) {
                return false;
            }
        } else if (!this.zzasq.equals(com_google_android_gms_internal_measurement_zzkk.zzasq)) {
            return false;
        }
        if (!zzacc.equals(this.zzasr, com_google_android_gms_internal_measurement_zzkk.zzasr) || !zzacc.equals(this.zzass, com_google_android_gms_internal_measurement_zzkk.zzass) || !zzacc.equals(this.zzast, com_google_android_gms_internal_measurement_zzkk.zzast)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkk.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkk.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkk.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzasp == null ? 0 : this.zzasp.hashCode())) * 31) + (this.zzadm == null ? 0 : this.zzadm.hashCode())) * 31) + (this.zzasq == null ? 0 : this.zzasq.hashCode())) * 31) + zzacc.hashCode(this.zzasr)) * 31) + zzacc.hashCode(this.zzass)) * 31) + zzacc.hashCode(this.zzast)) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int i;
        int zza = super.zza();
        if (this.zzasp != null) {
            zza += zzabw.zzc(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            zza += zzabw.zzc(2, this.zzadm);
        }
        if (this.zzasq != null) {
            zza += zzabw.zzf(3, this.zzasq.intValue());
        }
        int i2 = 0;
        if (this.zzasr != null && this.zzasr.length > 0) {
            i = zza;
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzasr) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    i += zzabw.zzb(4, com_google_android_gms_internal_measurement_zzace);
                }
            }
            zza = i;
        }
        if (this.zzass != null && this.zzass.length > 0) {
            i = zza;
            for (zzace com_google_android_gms_internal_measurement_zzace2 : this.zzass) {
                if (com_google_android_gms_internal_measurement_zzace2 != null) {
                    i += zzabw.zzb(5, com_google_android_gms_internal_measurement_zzace2);
                }
            }
            zza = i;
        }
        if (this.zzast != null && this.zzast.length > 0) {
            while (i2 < this.zzast.length) {
                zzace com_google_android_gms_internal_measurement_zzace3 = this.zzast[i2];
                if (com_google_android_gms_internal_measurement_zzace3 != null) {
                    zza += zzabw.zzb(6, com_google_android_gms_internal_measurement_zzace3);
                }
                i2++;
            }
        }
        return zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzasp != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(1, this.zzasp.longValue());
        }
        if (this.zzadm != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(2, this.zzadm);
        }
        if (this.zzasq != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(3, this.zzasq.intValue());
        }
        int i = 0;
        if (this.zzasr != null && this.zzasr.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzasr) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(4, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        if (this.zzass != null && this.zzass.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace2 : this.zzass) {
                if (com_google_android_gms_internal_measurement_zzace2 != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(5, com_google_android_gms_internal_measurement_zzace2);
                }
            }
        }
        if (this.zzast != null && this.zzast.length > 0) {
            while (i < this.zzast.length) {
                zzace com_google_android_gms_internal_measurement_zzace3 = this.zzast[i];
                if (com_google_android_gms_internal_measurement_zzace3 != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(6, com_google_android_gms_internal_measurement_zzace3);
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
                this.zzasp = Long.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuz());
            } else if (zzuw == 18) {
                this.zzadm = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 24) {
                this.zzasq = Integer.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuy());
            } else if (zzuw == 34) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 34);
                r1 = this.zzasr == null ? 0 : this.zzasr.length;
                r0 = new zzkl[(zzuw + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.zzasr, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzkl();
                    com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    r1++;
                }
                r0[r1] = new zzkl();
                com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                this.zzasr = r0;
            } else if (zzuw == 42) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 42);
                r1 = this.zzass == null ? 0 : this.zzass.length;
                r0 = new zzkj[(zzuw + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.zzass, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzkj();
                    com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    r1++;
                }
                r0[r1] = new zzkj();
                com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                this.zzass = r0;
            } else if (zzuw == 50) {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 50);
                r1 = this.zzast == null ? 0 : this.zzast.length;
                r0 = new zzkd[(zzuw + r1)];
                if (r1 != 0) {
                    System.arraycopy(this.zzast, 0, r0, 0, r1);
                }
                while (r1 < r0.length - 1) {
                    r0[r1] = new zzkd();
                    com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    r1++;
                }
                r0[r1] = new zzkd();
                com_google_android_gms_internal_measurement_zzabv.zza(r0[r1]);
                this.zzast = r0;
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
