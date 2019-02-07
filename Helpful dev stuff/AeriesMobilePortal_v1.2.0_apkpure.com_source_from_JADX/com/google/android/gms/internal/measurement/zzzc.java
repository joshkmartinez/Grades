package com.google.android.gms.internal.measurement;

class zzzc extends zzzb {
    protected final byte[] zzbrc;

    zzzc(byte[] bArr) {
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyw) || size() != ((zzyw) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzzc)) {
            return obj.equals(this);
        }
        zzzc com_google_android_gms_internal_measurement_zzzc = (zzzc) obj;
        int zzsx = zzsx();
        int zzsx2 = com_google_android_gms_internal_measurement_zzzc.zzsx();
        return (zzsx == 0 || zzsx2 == 0 || zzsx == zzsx2) ? zza(com_google_android_gms_internal_measurement_zzzc, 0, size()) : false;
    }

    public int size() {
        return this.zzbrc.length;
    }

    protected final int zza(int i, int i2, int i3) {
        return zzzr.zza(i, this.zzbrc, zzsy(), i3);
    }

    final boolean zza(zzyw com_google_android_gms_internal_measurement_zzyw, int i, int i2) {
        StringBuilder stringBuilder;
        if (i2 > com_google_android_gms_internal_measurement_zzyw.size()) {
            i = size();
            stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 > com_google_android_gms_internal_measurement_zzyw.size()) {
            r6 = com_google_android_gms_internal_measurement_zzyw.size();
            stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(r6);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!(com_google_android_gms_internal_measurement_zzyw instanceof zzzc)) {
            return com_google_android_gms_internal_measurement_zzyw.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzzc com_google_android_gms_internal_measurement_zzzc = (zzzc) com_google_android_gms_internal_measurement_zzyw;
            byte[] bArr = this.zzbrc;
            byte[] bArr2 = com_google_android_gms_internal_measurement_zzzc.zzbrc;
            int zzsy = zzsy() + i2;
            i2 = zzsy();
            r6 = com_google_android_gms_internal_measurement_zzzc.zzsy();
            while (i2 < zzsy) {
                if (bArr[i2] != bArr2[r6]) {
                    return false;
                }
                i2++;
                r6++;
            }
            return true;
        }
    }

    public byte zzae(int i) {
        return this.zzbrc[i];
    }

    public final zzyw zzb(int i, int i2) {
        i = zzyw.zzb(0, i2, size());
        return i == 0 ? zzyw.zzbqx : new zzyz(this.zzbrc, zzsy(), i);
    }

    protected int zzsy() {
        return 0;
    }
}
