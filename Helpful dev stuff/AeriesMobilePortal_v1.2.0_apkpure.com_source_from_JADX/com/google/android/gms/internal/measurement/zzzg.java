package com.google.android.gms.internal.measurement;

final class zzzg extends zzze {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzbrh;
    private int zzbri;
    private int zzbrj;
    private int zzbrk;

    private zzzg(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzbrk = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzbrj = this.pos;
        this.zzbrh = z;
    }

    private final void zzta() {
        this.limit += this.zzbri;
        int i = this.limit - this.zzbrj;
        if (i > this.zzbrk) {
            this.zzbri = i - this.zzbrk;
            this.limit -= this.zzbri;
            return;
        }
        this.zzbri = 0;
    }

    public final int zzaf(int i) throws zzzt {
        if (i >= 0) {
            i += zzsz();
            int i2 = this.zzbrk;
            if (i <= i2) {
                this.zzbrk = i;
                zzta();
                return i2;
            }
            throw zzzt.zztm();
        }
        throw zzzt.zztn();
    }

    public final int zzsz() {
        return this.pos - this.zzbrj;
    }
}
