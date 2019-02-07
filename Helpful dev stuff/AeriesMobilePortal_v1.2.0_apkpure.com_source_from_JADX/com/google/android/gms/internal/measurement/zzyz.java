package com.google.android.gms.internal.measurement;

final class zzyz extends zzzc {
    private final int zzbra;
    private final int zzbrb;

    zzyz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzyw.zzb(i, i + i2, bArr.length);
        this.zzbra = i;
        this.zzbrb = i2;
    }

    public final int size() {
        return this.zzbrb;
    }

    public final byte zzae(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbrc[this.zzbra + i];
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder(40);
        stringBuilder2.append("Index > length: ");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder2.append(size);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }

    protected final int zzsy() {
        return this.zzbra;
    }
}
