package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkj extends zzaby<zzkj> {
    private static volatile zzkj[] zzasl;
    public String name;
    public Boolean zzasm;
    public Boolean zzasn;
    public Integer zzaso;

    public zzkj() {
        this.name = null;
        this.zzasm = null;
        this.zzasn = null;
        this.zzaso = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkj[] zzli() {
        if (zzasl == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasl == null) {
                    zzasl = new zzkj[0];
                }
            }
        }
        return zzasl;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkj)) {
            return false;
        }
        zzkj com_google_android_gms_internal_measurement_zzkj = (zzkj) obj;
        if (this.name == null) {
            if (com_google_android_gms_internal_measurement_zzkj.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_google_android_gms_internal_measurement_zzkj.name)) {
            return false;
        }
        if (this.zzasm == null) {
            if (com_google_android_gms_internal_measurement_zzkj.zzasm != null) {
                return false;
            }
        } else if (!this.zzasm.equals(com_google_android_gms_internal_measurement_zzkj.zzasm)) {
            return false;
        }
        if (this.zzasn == null) {
            if (com_google_android_gms_internal_measurement_zzkj.zzasn != null) {
                return false;
            }
        } else if (!this.zzasn.equals(com_google_android_gms_internal_measurement_zzkj.zzasn)) {
            return false;
        }
        if (this.zzaso == null) {
            if (com_google_android_gms_internal_measurement_zzkj.zzaso != null) {
                return false;
            }
        } else if (!this.zzaso.equals(com_google_android_gms_internal_measurement_zzkj.zzaso)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkj.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkj.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkj.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((527 + getClass().getName().hashCode()) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzasm == null ? 0 : this.zzasm.hashCode())) * 31) + (this.zzasn == null ? 0 : this.zzasn.hashCode())) * 31) + (this.zzaso == null ? 0 : this.zzaso.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.name != null) {
            zza += zzabw.zzc(1, this.name);
        }
        if (this.zzasm != null) {
            this.zzasm.booleanValue();
            zza += zzabw.zzaq(2) + 1;
        }
        if (this.zzasn != null) {
            this.zzasn.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        return this.zzaso != null ? zza + zzabw.zzf(4, this.zzaso.intValue()) : zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.name != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(1, this.name);
        }
        if (this.zzasm != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(2, this.zzasm.booleanValue());
        }
        if (this.zzasn != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(3, this.zzasn.booleanValue());
        }
        if (this.zzaso != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(4, this.zzaso.intValue());
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
                this.name = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 16) {
                this.zzasm = Boolean.valueOf(com_google_android_gms_internal_measurement_zzabv.zzux());
            } else if (zzuw == 24) {
                this.zzasn = Boolean.valueOf(com_google_android_gms_internal_measurement_zzabv.zzux());
            } else if (zzuw == 32) {
                this.zzaso = Integer.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuy());
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
