package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkn extends zzaby<zzkn> {
    private static volatile zzkn[] zzasz;
    public Integer count;
    public String name;
    public zzko[] zzata;
    public Long zzatb;
    public Long zzatc;

    public zzkn() {
        this.zzata = zzko.zzlm();
        this.name = null;
        this.zzatb = null;
        this.zzatc = null;
        this.count = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkn[] zzll() {
        if (zzasz == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasz == null) {
                    zzasz = new zzkn[0];
                }
            }
        }
        return zzasz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkn)) {
            return false;
        }
        zzkn com_google_android_gms_internal_measurement_zzkn = (zzkn) obj;
        if (!zzacc.equals(this.zzata, com_google_android_gms_internal_measurement_zzkn.zzata)) {
            return false;
        }
        if (this.name == null) {
            if (com_google_android_gms_internal_measurement_zzkn.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_google_android_gms_internal_measurement_zzkn.name)) {
            return false;
        }
        if (this.zzatb == null) {
            if (com_google_android_gms_internal_measurement_zzkn.zzatb != null) {
                return false;
            }
        } else if (!this.zzatb.equals(com_google_android_gms_internal_measurement_zzkn.zzatb)) {
            return false;
        }
        if (this.zzatc == null) {
            if (com_google_android_gms_internal_measurement_zzkn.zzatc != null) {
                return false;
            }
        } else if (!this.zzatc.equals(com_google_android_gms_internal_measurement_zzkn.zzatc)) {
            return false;
        }
        if (this.count == null) {
            if (com_google_android_gms_internal_measurement_zzkn.count != null) {
                return false;
            }
        } else if (!this.count.equals(com_google_android_gms_internal_measurement_zzkn.count)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkn.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkn.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkn.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((527 + getClass().getName().hashCode()) * 31) + zzacc.hashCode(this.zzata)) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzatb == null ? 0 : this.zzatb.hashCode())) * 31) + (this.zzatc == null ? 0 : this.zzatc.hashCode())) * 31) + (this.count == null ? 0 : this.count.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzata) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    zza += zzabw.zzb(1, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzatb != null) {
            zza += zzabw.zzc(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zza += zzabw.zzc(4, this.zzatc.longValue());
        }
        return this.count != null ? zza + zzabw.zzf(5, this.count.intValue()) : zza;
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzace com_google_android_gms_internal_measurement_zzace : this.zzata) {
                if (com_google_android_gms_internal_measurement_zzace != null) {
                    com_google_android_gms_internal_measurement_zzabw.zza(1, com_google_android_gms_internal_measurement_zzace);
                }
            }
        }
        if (this.name != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(2, this.name);
        }
        if (this.zzatb != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            com_google_android_gms_internal_measurement_zzabw.zze(5, this.count.intValue());
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
                int length = this.zzata == null ? 0 : this.zzata.length;
                Object obj = new zzko[(zzuw + length)];
                if (length != 0) {
                    System.arraycopy(this.zzata, 0, obj, 0, length);
                }
                while (length < obj.length - 1) {
                    obj[length] = new zzko();
                    com_google_android_gms_internal_measurement_zzabv.zza(obj[length]);
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    length++;
                }
                obj[length] = new zzko();
                com_google_android_gms_internal_measurement_zzabv.zza(obj[length]);
                this.zzata = obj;
            } else if (zzuw == 18) {
                this.name = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 24) {
                this.zzatb = Long.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuz());
            } else if (zzuw == 32) {
                this.zzatc = Long.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuz());
            } else if (zzuw == 40) {
                this.count = Integer.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuy());
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
