package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import org.jetbrains.anko.DimensionsKt;

public final class zzfs {
    private final ByteBuffer zzgd;
    private zzbn zzrh;
    private int zzri;

    private zzfs(ByteBuffer byteBuffer) {
        this.zzgd = byteBuffer;
        this.zzgd.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzfs(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence) {
        StringBuilder stringBuilder;
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                stringBuilder = new StringBuilder(39);
                                stringBuilder.append("Unpaired surrogate at index ");
                                stringBuilder.append(i2);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 >= length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                stringBuilder = new StringBuilder(54);
                stringBuilder.append("UTF-8 length does not fit in int: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        stringBuilder = new StringBuilder(54);
        stringBuilder.append("UTF-8 length does not fit in int: ");
        stringBuilder.append(j2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private final void zzao(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzgd.hasRemaining()) {
            this.zzgd.put(b);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }

    private final void zzap(int i) throws IOException {
        while ((i & -128) != 0) {
            zzao((i & 127) | 128);
            i >>>= 7;
        }
        zzao(i);
    }

    public static int zzb(int i, zzfz com_google_android_gms_internal_clearcut_zzfz) {
        i = zzr(i);
        int zzas = com_google_android_gms_internal_clearcut_zzfz.zzas();
        return i + (zzz(zzas) + zzas);
    }

    public static int zzb(int i, String str) {
        return zzr(i) + zzh(str);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzr(i) + zzh(bArr);
    }

    public static int zzd(int i, long j) {
        return zzr(i) + zzo(j);
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        char c = 'ࠀ';
        int i = 0;
        char charAt;
        int i2;
        if (byteBuffer.hasArray()) {
            try {
                int i3;
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                int remaining = byteBuffer.remaining();
                int length = charSequence.length();
                remaining += arrayOffset;
                while (i < length) {
                    i3 = i + arrayOffset;
                    if (i3 >= remaining) {
                        break;
                    }
                    charAt = charSequence2.charAt(i);
                    if (charAt >= '') {
                        break;
                    }
                    array[i3] = (byte) charAt;
                    i++;
                }
                if (i == length) {
                    arrayOffset += length;
                } else {
                    arrayOffset += i;
                    while (i < length) {
                        charAt = charSequence2.charAt(i);
                        if (charAt < '' && arrayOffset < remaining) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) charAt;
                        } else if (charAt < c && arrayOffset <= remaining - 2) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) (960 | (charAt >>> 6));
                            i2 = i3 + 1;
                            array[i3] = (byte) ((charAt & 63) | 128);
                            arrayOffset = i2;
                            i++;
                            c = 'ࠀ';
                        } else if ((charAt < '?' || '?' < charAt) && arrayOffset <= remaining - 3) {
                            i3 = arrayOffset + 1;
                            array[arrayOffset] = (byte) ((charAt >>> 12) | DimensionsKt.XXHDPI);
                            i2 = i3 + 1;
                            array[i3] = (byte) (((charAt >>> 6) & 63) | 128);
                            i3 = i2 + 1;
                            array[i2] = (byte) ((charAt & 63) | 128);
                        } else if (arrayOffset <= remaining - 4) {
                            i3 = i + 1;
                            if (i3 != charSequence.length()) {
                                c = charSequence2.charAt(i3);
                                if (Character.isSurrogatePair(charAt, c)) {
                                    int toCodePoint = Character.toCodePoint(charAt, c);
                                    i2 = arrayOffset + 1;
                                    array[arrayOffset] = (byte) (DimensionsKt.HDPI | (toCodePoint >>> 18));
                                    i = i2 + 1;
                                    array[i2] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                                    i2 = i + 1;
                                    array[i] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                                    i = i2 + 1;
                                    array[i2] = (byte) ((toCodePoint & 63) | 128);
                                    arrayOffset = i;
                                    i = i3;
                                    i++;
                                    c = 'ࠀ';
                                }
                            } else {
                                i3 = i;
                            }
                            i3--;
                            StringBuilder stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(i3);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder(37);
                            stringBuilder2.append("Failed writing ");
                            stringBuilder2.append(charAt);
                            stringBuilder2.append(" at index ");
                            stringBuilder2.append(arrayOffset);
                            throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
                        }
                        arrayOffset = i3;
                        i++;
                        c = 'ࠀ';
                    }
                }
                byteBuffer2.position(arrayOffset - byteBuffer.arrayOffset());
                return;
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        int length2 = charSequence.length();
        while (i < length2) {
            charAt = charSequence2.charAt(i);
            if (charAt < '') {
                byteBuffer2.put((byte) charAt);
            } else if (charAt < 'ࠀ') {
                byteBuffer2.put((byte) ((charAt >>> 6) | 960));
                byteBuffer2.put((byte) ((charAt & 63) | 128));
            } else {
                if (charAt >= '?') {
                    if ('?' >= charAt) {
                        i2 = i + 1;
                        if (i2 != charSequence.length()) {
                            char charAt2 = charSequence2.charAt(i2);
                            if (Character.isSurrogatePair(charAt, charAt2)) {
                                toCodePoint = Character.toCodePoint(charAt, charAt2);
                                byteBuffer2.put((byte) ((toCodePoint >>> 18) | DimensionsKt.HDPI));
                                byteBuffer2.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                                byteBuffer2.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                                byteBuffer2.put((byte) ((toCodePoint & 63) | 128));
                                i = i2 + 1;
                            }
                        } else {
                            i2 = i;
                        }
                        i2--;
                        stringBuilder = new StringBuilder(39);
                        stringBuilder.append("Unpaired surrogate at index ");
                        stringBuilder.append(i2);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                }
                byteBuffer2.put((byte) ((charAt >>> 12) | DimensionsKt.XXHDPI));
                byteBuffer2.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer2.put((byte) ((charAt & 63) | 128));
                i2 = i;
                i = i2 + 1;
            }
            i2 = i;
            i = i2 + 1;
        }
    }

    public static zzfs zzg(byte[] bArr) {
        return zzh(bArr, 0, bArr.length);
    }

    public static int zzh(String str) {
        int zza = zza(str);
        return zzz(zza) + zza;
    }

    public static int zzh(byte[] bArr) {
        return zzz(bArr.length) + bArr.length;
    }

    public static zzfs zzh(byte[] bArr, int i, int i2) {
        return new zzfs(bArr, 0, i2);
    }

    public static long zzj(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzo(long j) {
        return (j & -128) == 0 ? 1 : (j & -16384) == 0 ? 2 : (j & -2097152) == 0 ? 3 : (j & -268435456) == 0 ? 4 : (j & -34359738368L) == 0 ? 5 : (j & -4398046511104L) == 0 ? 6 : (j & -562949953421312L) == 0 ? 7 : (j & -72057594037927936L) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int zzr(int i) {
        return zzz(i << 3);
    }

    public static int zzs(int i) {
        return i >= 0 ? zzz(i) : 10;
    }

    private static int zzz(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public final void zza(int i, zzfz com_google_android_gms_internal_clearcut_zzfz) throws IOException {
        zzb(i, 2);
        if (com_google_android_gms_internal_clearcut_zzfz.zzrs < 0) {
            com_google_android_gms_internal_clearcut_zzfz.zzas();
        }
        zzap(com_google_android_gms_internal_clearcut_zzfz.zzrs);
        com_google_android_gms_internal_clearcut_zzfz.zza(this);
    }

    public final void zza(int i, String str) throws IOException {
        zzb(i, 2);
        try {
            i = zzz(str.length());
            if (i == zzz(str.length() * 3)) {
                int position = this.zzgd.position();
                if (this.zzgd.remaining() >= i) {
                    this.zzgd.position(position + i);
                    zzd((CharSequence) str, this.zzgd);
                    int position2 = this.zzgd.position();
                    this.zzgd.position(position);
                    zzap((position2 - position) - i);
                    this.zzgd.position(position2);
                    return;
                }
                throw new zzft(position + i, this.zzgd.limit());
            }
            zzap(zza(str));
            zzd((CharSequence) str, this.zzgd);
        } catch (Throwable e) {
            zzft com_google_android_gms_internal_clearcut_zzft = new zzft(this.zzgd.position(), this.zzgd.limit());
            com_google_android_gms_internal_clearcut_zzft.initCause(e);
            throw com_google_android_gms_internal_clearcut_zzft;
        }
    }

    public final void zza(int i, byte[] bArr) throws IOException {
        zzb(i, 2);
        zzap(bArr.length);
        i = bArr.length;
        if (this.zzgd.remaining() >= i) {
            this.zzgd.put(bArr, 0, i);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }

    public final void zzb(int i, int i2) throws IOException {
        zzap((i << 3) | i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        zzb(25, 0);
        byte b = (byte) z;
        if (this.zzgd.hasRemaining()) {
            this.zzgd.put(b);
            return;
        }
        throw new zzft(this.zzgd.position(), this.zzgd.limit());
    }

    public final void zzc(int i, int i2) throws IOException {
        zzb(i, 0);
        if (i2 >= 0) {
            zzap(i2);
        } else {
            zzn((long) i2);
        }
    }

    public final void zze(int i, zzdo com_google_android_gms_internal_clearcut_zzdo) throws IOException {
        zzbn com_google_android_gms_internal_clearcut_zzbn;
        if (this.zzrh == null) {
            this.zzrh = zzbn.zza(this.zzgd);
        } else {
            if (this.zzri != this.zzgd.position()) {
                this.zzrh.write(this.zzgd.array(), this.zzri, this.zzgd.position() - this.zzri);
            }
            com_google_android_gms_internal_clearcut_zzbn = this.zzrh;
            com_google_android_gms_internal_clearcut_zzbn.zza(i, com_google_android_gms_internal_clearcut_zzdo);
            com_google_android_gms_internal_clearcut_zzbn.flush();
            this.zzri = this.zzgd.position();
        }
        this.zzri = this.zzgd.position();
        com_google_android_gms_internal_clearcut_zzbn = this.zzrh;
        com_google_android_gms_internal_clearcut_zzbn.zza(i, com_google_android_gms_internal_clearcut_zzdo);
        com_google_android_gms_internal_clearcut_zzbn.flush();
        this.zzri = this.zzgd.position();
    }

    public final void zzem() {
        if (this.zzgd.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzgd.remaining())}));
        }
    }

    public final void zzi(int i, long j) throws IOException {
        zzb(i, 0);
        zzn(j);
    }

    public final void zzn(long j) throws IOException {
        while ((j & -128) != 0) {
            zzao((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzao((int) j);
    }
}
