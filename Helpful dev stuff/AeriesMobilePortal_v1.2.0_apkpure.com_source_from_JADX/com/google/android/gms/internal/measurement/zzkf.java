package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkf extends zzaby<zzkf> {
    private static volatile zzkf[] zzaru;
    public zzki zzarv;
    public zzkg zzarw;
    public Boolean zzarx;
    public String zzary;

    public zzkf() {
        this.zzarv = null;
        this.zzarw = null;
        this.zzarx = null;
        this.zzary = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkf[] zzlg() {
        if (zzaru == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaru == null) {
                    zzaru = new zzkf[0];
                }
            }
        }
        return zzaru;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf com_google_android_gms_internal_measurement_zzkf = (zzkf) obj;
        if (this.zzarv == null) {
            if (com_google_android_gms_internal_measurement_zzkf.zzarv != null) {
                return false;
            }
        } else if (!this.zzarv.equals(com_google_android_gms_internal_measurement_zzkf.zzarv)) {
            return false;
        }
        if (this.zzarw == null) {
            if (com_google_android_gms_internal_measurement_zzkf.zzarw != null) {
                return false;
            }
        } else if (!this.zzarw.equals(com_google_android_gms_internal_measurement_zzkf.zzarw)) {
            return false;
        }
        if (this.zzarx == null) {
            if (com_google_android_gms_internal_measurement_zzkf.zzarx != null) {
                return false;
            }
        } else if (!this.zzarx.equals(com_google_android_gms_internal_measurement_zzkf.zzarx)) {
            return false;
        }
        if (this.zzary == null) {
            if (com_google_android_gms_internal_measurement_zzkf.zzary != null) {
                return false;
            }
        } else if (!this.zzary.equals(com_google_android_gms_internal_measurement_zzkf.zzary)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkf.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkf.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkf.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = 527 + getClass().getName().hashCode();
        zzki com_google_android_gms_internal_measurement_zzki = this.zzarv;
        int i = 0;
        hashCode = (hashCode * 31) + (com_google_android_gms_internal_measurement_zzki == null ? 0 : com_google_android_gms_internal_measurement_zzki.hashCode());
        zzkg com_google_android_gms_internal_measurement_zzkg = this.zzarw;
        hashCode = ((((((hashCode * 31) + (com_google_android_gms_internal_measurement_zzkg == null ? 0 : com_google_android_gms_internal_measurement_zzkg.hashCode())) * 31) + (this.zzarx == null ? 0 : this.zzarx.hashCode())) * 31) + (this.zzary == null ? 0 : this.zzary.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzarv != null) {
            zza += zzabw.zzb(1, this.zzarv);
        }
        if (this.zzarw != null) {
            zza += zzabw.zzb(2, this.zzarw);
        }
        if (this.zzarx != null) {
            this.zzarx.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        return this.zzary != null ? zza + zzabw.zzc(4, this.zzary) : zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzarv != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(1, this.zzarv);
        }
        if (this.zzarw != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(2, this.zzarw);
        }
        if (this.zzarx != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(3, this.zzarx.booleanValue());
        }
        if (this.zzary != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(4, this.zzary);
        }
        super.zza(com_google_android_gms_internal_measurement_zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv com_google_android_gms_internal_measurement_zzabv) throws IOException {
        while (true) {
            int zzuw = com_google_android_gms_internal_measurement_zzabv.zzuw();
            if (zzuw == 0) {
                return this;
            }
            zzace com_google_android_gms_internal_measurement_zzace;
            if (zzuw == 10) {
                if (this.zzarv == null) {
                    this.zzarv = new zzki();
                }
                com_google_android_gms_internal_measurement_zzace = this.zzarv;
            } else if (zzuw == 18) {
                if (this.zzarw == null) {
                    this.zzarw = new zzkg();
                }
                com_google_android_gms_internal_measurement_zzace = this.zzarw;
            } else if (zzuw == 24) {
                this.zzarx = Boolean.valueOf(com_google_android_gms_internal_measurement_zzabv.zzux());
            } else if (zzuw == 34) {
                this.zzary = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
            com_google_android_gms_internal_measurement_zzabv.zza(com_google_android_gms_internal_measurement_zzace);
        }
    }
}
