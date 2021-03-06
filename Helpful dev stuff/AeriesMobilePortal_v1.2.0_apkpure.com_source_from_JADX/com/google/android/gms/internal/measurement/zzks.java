package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzks extends zzaby<zzks> {
    private static volatile zzks[] zzaum;
    public String name;
    public String zzajf;
    private Float zzarb;
    public Double zzarc;
    public Long zzate;
    public Long zzaun;

    public zzks() {
        this.zzaun = null;
        this.name = null;
        this.zzajf = null;
        this.zzate = null;
        this.zzarb = null;
        this.zzarc = null;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzks[] zzlo() {
        if (zzaum == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaum == null) {
                    zzaum = new zzks[0];
                }
            }
        }
        return zzaum;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzks)) {
            return false;
        }
        zzks com_google_android_gms_internal_measurement_zzks = (zzks) obj;
        if (this.zzaun == null) {
            if (com_google_android_gms_internal_measurement_zzks.zzaun != null) {
                return false;
            }
        } else if (!this.zzaun.equals(com_google_android_gms_internal_measurement_zzks.zzaun)) {
            return false;
        }
        if (this.name == null) {
            if (com_google_android_gms_internal_measurement_zzks.name != null) {
                return false;
            }
        } else if (!this.name.equals(com_google_android_gms_internal_measurement_zzks.name)) {
            return false;
        }
        if (this.zzajf == null) {
            if (com_google_android_gms_internal_measurement_zzks.zzajf != null) {
                return false;
            }
        } else if (!this.zzajf.equals(com_google_android_gms_internal_measurement_zzks.zzajf)) {
            return false;
        }
        if (this.zzate == null) {
            if (com_google_android_gms_internal_measurement_zzks.zzate != null) {
                return false;
            }
        } else if (!this.zzate.equals(com_google_android_gms_internal_measurement_zzks.zzate)) {
            return false;
        }
        if (this.zzarb == null) {
            if (com_google_android_gms_internal_measurement_zzks.zzarb != null) {
                return false;
            }
        } else if (!this.zzarb.equals(com_google_android_gms_internal_measurement_zzks.zzarb)) {
            return false;
        }
        if (this.zzarc == null) {
            if (com_google_android_gms_internal_measurement_zzks.zzarc != null) {
                return false;
            }
        } else if (!this.zzarc.equals(com_google_android_gms_internal_measurement_zzks.zzarc)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzks.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzks.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzks.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((((((((((527 + getClass().getName().hashCode()) * 31) + (this.zzaun == null ? 0 : this.zzaun.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.zzajf == null ? 0 : this.zzajf.hashCode())) * 31) + (this.zzate == null ? 0 : this.zzate.hashCode())) * 31) + (this.zzarb == null ? 0 : this.zzarb.hashCode())) * 31) + (this.zzarc == null ? 0 : this.zzarc.hashCode())) * 31;
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                i = this.zzbww.hashCode();
            }
        }
        return hashCode + i;
    }

    protected final int zza() {
        int zza = super.zza();
        if (this.zzaun != null) {
            zza += zzabw.zzc(1, this.zzaun.longValue());
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzajf != null) {
            zza += zzabw.zzc(3, this.zzajf);
        }
        if (this.zzate != null) {
            zza += zzabw.zzc(4, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            this.zzarb.floatValue();
            zza += zzabw.zzaq(5) + 4;
        }
        if (this.zzarc == null) {
            return zza;
        }
        this.zzarc.doubleValue();
        return zza + (zzabw.zzaq(6) + 8);
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.zzaun != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(1, this.zzaun.longValue());
        }
        if (this.name != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(2, this.name);
        }
        if (this.zzajf != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(3, this.zzajf);
        }
        if (this.zzate != null) {
            com_google_android_gms_internal_measurement_zzabw.zzb(4, this.zzate.longValue());
        }
        if (this.zzarb != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(5, this.zzarb.floatValue());
        }
        if (this.zzarc != null) {
            com_google_android_gms_internal_measurement_zzabw.zza(6, this.zzarc.doubleValue());
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
                this.zzaun = Long.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuz());
            } else if (zzuw == 18) {
                this.name = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 26) {
                this.zzajf = com_google_android_gms_internal_measurement_zzabv.readString();
            } else if (zzuw == 32) {
                this.zzate = Long.valueOf(com_google_android_gms_internal_measurement_zzabv.zzuz());
            } else if (zzuw == 45) {
                this.zzarb = Float.valueOf(Float.intBitsToFloat(com_google_android_gms_internal_measurement_zzabv.zzva()));
            } else if (zzuw == 49) {
                this.zzarc = Double.valueOf(Double.longBitsToDouble(com_google_android_gms_internal_measurement_zzabv.zzvb()));
            } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                return this;
            }
        }
    }
}
