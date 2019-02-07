package com.google.android.gms.internal.measurement;

public final class zzaca implements Cloneable {
    private static final zzacb zzbxa = new zzacb();
    private int mSize;
    private boolean zzbxb;
    private int[] zzbxc;
    private zzacb[] zzbxd;

    zzaca() {
        this(10);
    }

    private zzaca(int i) {
        this.zzbxb = false;
        i = idealIntArraySize(i);
        this.zzbxc = new int[i];
        this.zzbxd = new zzacb[i];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        i <<= 2;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 4;
    }

    private final int zzav(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzbxc[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzaca com_google_android_gms_internal_measurement_zzaca = new zzaca(i);
        int i2 = 0;
        System.arraycopy(this.zzbxc, 0, com_google_android_gms_internal_measurement_zzaca.zzbxc, 0, i);
        while (i2 < i) {
            if (this.zzbxd[i2] != null) {
                com_google_android_gms_internal_measurement_zzaca.zzbxd[i2] = (zzacb) this.zzbxd[i2].clone();
            }
            i2++;
        }
        com_google_android_gms_internal_measurement_zzaca.mSize = i;
        return com_google_android_gms_internal_measurement_zzaca;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaca)) {
            return false;
        }
        zzaca com_google_android_gms_internal_measurement_zzaca = (zzaca) obj;
        if (this.mSize != com_google_android_gms_internal_measurement_zzaca.mSize) {
            return false;
        }
        boolean z;
        int[] iArr = this.zzbxc;
        int[] iArr2 = com_google_android_gms_internal_measurement_zzaca.zzbxc;
        int i = this.mSize;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            boolean z2;
            zzacb[] com_google_android_gms_internal_measurement_zzacbArr = this.zzbxd;
            zzacb[] com_google_android_gms_internal_measurement_zzacbArr2 = com_google_android_gms_internal_measurement_zzaca.zzbxd;
            int i3 = this.mSize;
            for (i = 0; i < i3; i++) {
                if (!com_google_android_gms_internal_measurement_zzacbArr[i].equals(com_google_android_gms_internal_measurement_zzacbArr2[i])) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbxc[i2]) * 31) + this.zzbxd[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.mSize == 0;
    }

    final int size() {
        return this.mSize;
    }

    final void zza(int i, zzacb com_google_android_gms_internal_measurement_zzacb) {
        int zzav = zzav(i);
        if (zzav >= 0) {
            this.zzbxd[zzav] = com_google_android_gms_internal_measurement_zzacb;
            return;
        }
        zzav ^= -1;
        if (zzav >= this.mSize || this.zzbxd[zzav] != zzbxa) {
            if (this.mSize >= this.zzbxc.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzacb[idealIntArraySize];
                System.arraycopy(this.zzbxc, 0, obj, 0, this.zzbxc.length);
                System.arraycopy(this.zzbxd, 0, obj2, 0, this.zzbxd.length);
                this.zzbxc = obj;
                this.zzbxd = obj2;
            }
            if (this.mSize - zzav != 0) {
                int i2 = zzav + 1;
                System.arraycopy(this.zzbxc, zzav, this.zzbxc, i2, this.mSize - zzav);
                System.arraycopy(this.zzbxd, zzav, this.zzbxd, i2, this.mSize - zzav);
            }
            this.zzbxc[zzav] = i;
            this.zzbxd[zzav] = com_google_android_gms_internal_measurement_zzacb;
            this.mSize++;
            return;
        }
        this.zzbxc[zzav] = i;
        this.zzbxd[zzav] = com_google_android_gms_internal_measurement_zzacb;
    }

    final zzacb zzat(int i) {
        i = zzav(i);
        if (i >= 0) {
            if (this.zzbxd[i] != zzbxa) {
                return this.zzbxd[i];
            }
        }
        return null;
    }

    final zzacb zzau(int i) {
        return this.zzbxd[i];
    }
}
