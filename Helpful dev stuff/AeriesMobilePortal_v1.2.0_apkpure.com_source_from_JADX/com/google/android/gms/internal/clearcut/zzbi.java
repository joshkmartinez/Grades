package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

class zzbi extends zzbh {
    protected final byte[] zzfp;

    zzbi(byte[] bArr) {
        this.zzfp = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbb) || size() != ((zzbb) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzbi)) {
            return obj.equals(this);
        }
        zzbi com_google_android_gms_internal_clearcut_zzbi = (zzbi) obj;
        int zzab = zzab();
        int zzab2 = com_google_android_gms_internal_clearcut_zzbi.zzab();
        return (zzab == 0 || zzab2 == 0 || zzab == zzab2) ? zza(com_google_android_gms_internal_clearcut_zzbi, 0, size()) : false;
    }

    public int size() {
        return this.zzfp.length;
    }

    protected final int zza(int i, int i2, int i3) {
        return zzci.zza(i, this.zzfp, zzac(), i3);
    }

    public final zzbb zza(int i, int i2) {
        i = zzbb.zzb(0, i2, size());
        return i == 0 ? zzbb.zzfi : new zzbe(this.zzfp, zzac(), i);
    }

    protected final String zza(Charset charset) {
        return new String(this.zzfp, zzac(), size(), charset);
    }

    final void zza(zzba com_google_android_gms_internal_clearcut_zzba) throws IOException {
        com_google_android_gms_internal_clearcut_zzba.zza(this.zzfp, zzac(), size());
    }

    final boolean zza(zzbb com_google_android_gms_internal_clearcut_zzbb, int i, int i2) {
        StringBuilder stringBuilder;
        if (i2 > com_google_android_gms_internal_clearcut_zzbb.size()) {
            i = size();
            stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i2);
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 > com_google_android_gms_internal_clearcut_zzbb.size()) {
            r6 = com_google_android_gms_internal_clearcut_zzbb.size();
            stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(i2);
            stringBuilder.append(", ");
            stringBuilder.append(r6);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!(com_google_android_gms_internal_clearcut_zzbb instanceof zzbi)) {
            return com_google_android_gms_internal_clearcut_zzbb.zza(0, i2).equals(zza(0, i2));
        } else {
            zzbi com_google_android_gms_internal_clearcut_zzbi = (zzbi) com_google_android_gms_internal_clearcut_zzbb;
            byte[] bArr = this.zzfp;
            byte[] bArr2 = com_google_android_gms_internal_clearcut_zzbi.zzfp;
            int zzac = zzac() + i2;
            i2 = zzac();
            r6 = com_google_android_gms_internal_clearcut_zzbi.zzac();
            while (i2 < zzac) {
                if (bArr[i2] != bArr2[r6]) {
                    return false;
                }
                i2++;
                r6++;
            }
            return true;
        }
    }

    public final boolean zzaa() {
        int zzac = zzac();
        return zzff.zze(this.zzfp, zzac, size() + zzac);
    }

    protected int zzac() {
        return 0;
    }

    public byte zzj(int i) {
        return this.zzfp[i];
    }
}
