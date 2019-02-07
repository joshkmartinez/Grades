package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzgy extends zzfu<zzgy> implements Cloneable {
    private String[] zzbiw;
    private String[] zzbix;
    private int[] zzbiy;
    private long[] zzbiz;
    private long[] zzbja;

    public zzgy() {
        this.zzbiw = zzgb.zzsc;
        this.zzbix = zzgb.zzsc;
        this.zzbiy = zzgb.zzrx;
        this.zzbiz = zzgb.zzry;
        this.zzbja = zzgb.zzry;
        this.zzrj = null;
        this.zzrs = -1;
    }

    private final zzgy zzgb() {
        try {
            zzgy com_google_android_gms_internal_clearcut_zzgy = (zzgy) super.zzeo();
            if (this.zzbiw != null && this.zzbiw.length > 0) {
                com_google_android_gms_internal_clearcut_zzgy.zzbiw = (String[]) this.zzbiw.clone();
            }
            if (this.zzbix != null && this.zzbix.length > 0) {
                com_google_android_gms_internal_clearcut_zzgy.zzbix = (String[]) this.zzbix.clone();
            }
            if (this.zzbiy != null && this.zzbiy.length > 0) {
                com_google_android_gms_internal_clearcut_zzgy.zzbiy = (int[]) this.zzbiy.clone();
            }
            if (this.zzbiz != null && this.zzbiz.length > 0) {
                com_google_android_gms_internal_clearcut_zzgy.zzbiz = (long[]) this.zzbiz.clone();
            }
            if (this.zzbja != null && this.zzbja.length > 0) {
                com_google_android_gms_internal_clearcut_zzgy.zzbja = (long[]) this.zzbja.clone();
            }
            return com_google_android_gms_internal_clearcut_zzgy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzgb();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgy)) {
            return false;
        }
        zzgy com_google_android_gms_internal_clearcut_zzgy = (zzgy) obj;
        if (!zzfy.equals(this.zzbiw, com_google_android_gms_internal_clearcut_zzgy.zzbiw) || !zzfy.equals(this.zzbix, com_google_android_gms_internal_clearcut_zzgy.zzbix) || !zzfy.equals(this.zzbiy, com_google_android_gms_internal_clearcut_zzgy.zzbiy) || !zzfy.equals(this.zzbiz, com_google_android_gms_internal_clearcut_zzgy.zzbiz) || !zzfy.equals(this.zzbja, com_google_android_gms_internal_clearcut_zzgy.zzbja)) {
            return false;
        }
        if (this.zzrj != null) {
            if (!this.zzrj.isEmpty()) {
                return this.zzrj.equals(com_google_android_gms_internal_clearcut_zzgy.zzrj);
            }
        }
        if (com_google_android_gms_internal_clearcut_zzgy.zzrj != null) {
            if (!com_google_android_gms_internal_clearcut_zzgy.zzrj.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (((((((((((527 + getClass().getName().hashCode()) * 31) + zzfy.hashCode(this.zzbiw)) * 31) + zzfy.hashCode(this.zzbix)) * 31) + zzfy.hashCode(this.zzbiy)) * 31) + zzfy.hashCode(this.zzbiz)) * 31) + zzfy.hashCode(this.zzbja)) * 31;
        if (this.zzrj != null) {
            if (!this.zzrj.isEmpty()) {
                hashCode = this.zzrj.hashCode();
                return hashCode2 + hashCode;
            }
        }
        hashCode = 0;
        return hashCode2 + hashCode;
    }

    public final void zza(zzfs com_google_android_gms_internal_clearcut_zzfs) throws IOException {
        int i = 0;
        if (this.zzbiw != null && this.zzbiw.length > 0) {
            for (String str : this.zzbiw) {
                if (str != null) {
                    com_google_android_gms_internal_clearcut_zzfs.zza(1, str);
                }
            }
        }
        if (this.zzbix != null && this.zzbix.length > 0) {
            for (String str2 : this.zzbix) {
                if (str2 != null) {
                    com_google_android_gms_internal_clearcut_zzfs.zza(2, str2);
                }
            }
        }
        if (this.zzbiy != null && this.zzbiy.length > 0) {
            for (int zzc : this.zzbiy) {
                com_google_android_gms_internal_clearcut_zzfs.zzc(3, zzc);
            }
        }
        if (this.zzbiz != null && this.zzbiz.length > 0) {
            for (long zzi : this.zzbiz) {
                com_google_android_gms_internal_clearcut_zzfs.zzi(4, zzi);
            }
        }
        if (this.zzbja != null && this.zzbja.length > 0) {
            while (i < this.zzbja.length) {
                com_google_android_gms_internal_clearcut_zzfs.zzi(5, this.zzbja[i]);
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_clearcut_zzfs);
    }

    protected final int zzen() {
        int i;
        int i2;
        int i3;
        String str;
        int zzen = super.zzen();
        int i4 = 0;
        if (this.zzbiw != null && this.zzbiw.length > 0) {
            i = 0;
            i2 = i;
            i3 = i2;
            while (i < this.zzbiw.length) {
                str = this.zzbiw[i];
                if (str != null) {
                    i3++;
                    i2 += zzfs.zzh(str);
                }
                i++;
            }
            zzen = (zzen + i2) + (i3 * 1);
        }
        if (this.zzbix != null && this.zzbix.length > 0) {
            i = 0;
            i2 = i;
            i3 = i2;
            while (i < this.zzbix.length) {
                str = this.zzbix[i];
                if (str != null) {
                    i3++;
                    i2 += zzfs.zzh(str);
                }
                i++;
            }
            zzen = (zzen + i2) + (i3 * 1);
        }
        if (this.zzbiy != null && this.zzbiy.length > 0) {
            i = 0;
            i2 = i;
            while (i < this.zzbiy.length) {
                i2 += zzfs.zzs(this.zzbiy[i]);
                i++;
            }
            zzen = (zzen + i2) + (this.zzbiy.length * 1);
        }
        if (this.zzbiz != null && this.zzbiz.length > 0) {
            i = 0;
            i2 = i;
            while (i < this.zzbiz.length) {
                i2 += zzfs.zzo(this.zzbiz[i]);
                i++;
            }
            zzen = (zzen + i2) + (this.zzbiz.length * 1);
        }
        if (this.zzbja == null || this.zzbja.length <= 0) {
            return zzen;
        }
        i = 0;
        while (i4 < this.zzbja.length) {
            i += zzfs.zzo(this.zzbja[i4]);
            i4++;
        }
        return (zzen + i) + (1 * this.zzbja.length);
    }

    public final /* synthetic */ zzfu zzeo() throws CloneNotSupportedException {
        return (zzgy) clone();
    }

    public final /* synthetic */ zzfz zzep() throws CloneNotSupportedException {
        return (zzgy) clone();
    }
}
