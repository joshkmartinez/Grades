package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkr extends zzaby<zzkr> {
    public long[] zzauk;
    public long[] zzaul;

    public zzkr() {
        this.zzauk = zzach.zzbxm;
        this.zzaul = zzach.zzbxm;
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkr)) {
            return false;
        }
        zzkr com_google_android_gms_internal_measurement_zzkr = (zzkr) obj;
        if (!zzacc.equals(this.zzauk, com_google_android_gms_internal_measurement_zzkr.zzauk) || !zzacc.equals(this.zzaul, com_google_android_gms_internal_measurement_zzkr.zzaul)) {
            return false;
        }
        if (this.zzbww != null) {
            if (!this.zzbww.isEmpty()) {
                return this.zzbww.equals(com_google_android_gms_internal_measurement_zzkr.zzbww);
            }
        }
        if (com_google_android_gms_internal_measurement_zzkr.zzbww != null) {
            if (!com_google_android_gms_internal_measurement_zzkr.zzbww.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((527 + getClass().getName().hashCode()) * 31) + zzacc.hashCode(this.zzauk)) * 31) + zzacc.hashCode(this.zzaul)) * 31;
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
        int i;
        int zza = super.zza();
        int i2 = 0;
        if (this.zzauk != null && this.zzauk.length > 0) {
            i = 0;
            int i3 = i;
            while (i < this.zzauk.length) {
                i3 += zzabw.zzao(this.zzauk[i]);
                i++;
            }
            zza = (zza + i3) + (this.zzauk.length * 1);
        }
        if (this.zzaul == null || this.zzaul.length <= 0) {
            return zza;
        }
        i = 0;
        while (i2 < this.zzaul.length) {
            i += zzabw.zzao(this.zzaul[i2]);
            i2++;
        }
        return (zza + i) + (1 * this.zzaul.length);
    }

    public final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        int i = 0;
        if (this.zzauk != null && this.zzauk.length > 0) {
            for (long zza : this.zzauk) {
                com_google_android_gms_internal_measurement_zzabw.zza(1, zza);
            }
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            while (i < this.zzaul.length) {
                com_google_android_gms_internal_measurement_zzabw.zza(2, this.zzaul[i]);
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
            int position;
            Object obj;
            if (zzuw != 8) {
                int i;
                Object obj2;
                if (zzuw == 10) {
                    zzuw = com_google_android_gms_internal_measurement_zzabv.zzaf(com_google_android_gms_internal_measurement_zzabv.zzuy());
                    position = com_google_android_gms_internal_measurement_zzabv.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_measurement_zzabv.zzvc() > 0) {
                        com_google_android_gms_internal_measurement_zzabv.zzuz();
                        i++;
                    }
                    com_google_android_gms_internal_measurement_zzabv.zzam(position);
                    position = this.zzauk == null ? 0 : this.zzauk.length;
                    obj2 = new long[(i + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzauk, 0, obj2, 0, position);
                    }
                    while (position < obj2.length) {
                        obj2[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                        position++;
                    }
                    this.zzauk = obj2;
                } else if (zzuw == 16) {
                    zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 16);
                    position = this.zzaul == null ? 0 : this.zzaul.length;
                    obj = new long[(zzuw + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzaul, 0, obj, 0, position);
                    }
                    while (position < obj.length - 1) {
                        obj[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                        com_google_android_gms_internal_measurement_zzabv.zzuw();
                        position++;
                    }
                    obj[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                    this.zzaul = obj;
                } else if (zzuw == 18) {
                    zzuw = com_google_android_gms_internal_measurement_zzabv.zzaf(com_google_android_gms_internal_measurement_zzabv.zzuy());
                    position = com_google_android_gms_internal_measurement_zzabv.getPosition();
                    i = 0;
                    while (com_google_android_gms_internal_measurement_zzabv.zzvc() > 0) {
                        com_google_android_gms_internal_measurement_zzabv.zzuz();
                        i++;
                    }
                    com_google_android_gms_internal_measurement_zzabv.zzam(position);
                    position = this.zzaul == null ? 0 : this.zzaul.length;
                    obj2 = new long[(i + position)];
                    if (position != 0) {
                        System.arraycopy(this.zzaul, 0, obj2, 0, position);
                    }
                    while (position < obj2.length) {
                        obj2[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                        position++;
                    }
                    this.zzaul = obj2;
                } else if (!super.zza(com_google_android_gms_internal_measurement_zzabv, zzuw)) {
                    return this;
                }
                com_google_android_gms_internal_measurement_zzabv.zzal(zzuw);
            } else {
                zzuw = zzach.zzb(com_google_android_gms_internal_measurement_zzabv, 8);
                position = this.zzauk == null ? 0 : this.zzauk.length;
                obj = new long[(zzuw + position)];
                if (position != 0) {
                    System.arraycopy(this.zzauk, 0, obj, 0, position);
                }
                while (position < obj.length - 1) {
                    obj[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                    com_google_android_gms_internal_measurement_zzabv.zzuw();
                    position++;
                }
                obj[position] = com_google_android_gms_internal_measurement_zzabv.zzuz();
                this.zzauk = obj;
            }
        }
    }
}
