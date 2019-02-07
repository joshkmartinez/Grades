package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import org.jetbrains.anko.DimensionsKt;

public final class zzabw {
    private final ByteBuffer zzbwv;

    private zzabw(ByteBuffer byteBuffer) {
        this.zzbwv = byteBuffer;
        this.zzbwv.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzabw(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            StringBuilder stringBuilder;
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

    private static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
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

    private final void zzan(long j) throws IOException {
        while ((j & -128) != 0) {
            zzap((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzap((int) j);
    }

    public static int zzao(int i) {
        return i >= 0 ? zzas(i) : 10;
    }

    public static int zzao(long j) {
        return (j & -128) == 0 ? 1 : (j & -16384) == 0 ? 2 : (j & -2097152) == 0 ? 3 : (j & -268435456) == 0 ? 4 : (j & -34359738368L) == 0 ? 5 : (j & -4398046511104L) == 0 ? 6 : (j & -562949953421312L) == 0 ? 7 : (j & -72057594037927936L) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private final void zzap(int i) throws IOException {
        byte b = (byte) i;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public static int zzaq(int i) {
        return zzas(i << 3);
    }

    public static int zzas(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzb(int i, zzace com_google_android_gms_internal_measurement_zzace) {
        i = zzaq(i);
        int zzvm = com_google_android_gms_internal_measurement_zzace.zzvm();
        return i + (zzas(zzvm) + zzvm);
    }

    public static zzabw zzb(byte[] bArr, int i, int i2) {
        return new zzabw(bArr, 0, i2);
    }

    public static int zzc(int i, long j) {
        return zzaq(i) + zzao(j);
    }

    public static int zzc(int i, String str) {
        return zzaq(i) + zzfm(str);
    }

    public static int zzf(int i, int i2) {
        return zzaq(i) + zzao(i2);
    }

    public static int zzfm(String str) {
        int zza = zza(str);
        return zzas(zza) + zza;
    }

    public static zzabw zzj(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public final void zza(int i, double d) throws IOException {
        zzg(i, 1);
        long doubleToLongBits = Double.doubleToLongBits(d);
        if (this.zzbwv.remaining() >= 8) {
            this.zzbwv.putLong(doubleToLongBits);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zza(int i, float f) throws IOException {
        zzg(i, 5);
        i = Float.floatToIntBits(f);
        if (this.zzbwv.remaining() >= 4) {
            this.zzbwv.putInt(i);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zza(int i, long j) throws IOException {
        zzg(i, 0);
        zzan(j);
    }

    public final void zza(int i, zzace com_google_android_gms_internal_measurement_zzace) throws IOException {
        zzg(i, 2);
        zzb(com_google_android_gms_internal_measurement_zzace);
    }

    public final void zza(int i, boolean z) throws IOException {
        zzg(i, 0);
        byte b = (byte) z;
        if (this.zzbwv.hasRemaining()) {
            this.zzbwv.put(b);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zzar(int i) throws IOException {
        while ((i & -128) != 0) {
            zzap((i & 127) | 128);
            i >>>= 7;
        }
        zzap(i);
    }

    public final void zzb(int i, long j) throws IOException {
        zzg(i, 0);
        zzan(j);
    }

    public final void zzb(int i, String str) throws IOException {
        zzg(i, 2);
        try {
            i = zzas(str.length());
            if (i == zzas(str.length() * 3)) {
                int position = this.zzbwv.position();
                if (this.zzbwv.remaining() >= i) {
                    this.zzbwv.position(position + i);
                    zza((CharSequence) str, this.zzbwv);
                    int position2 = this.zzbwv.position();
                    this.zzbwv.position(position);
                    zzar((position2 - position) - i);
                    this.zzbwv.position(position2);
                    return;
                }
                throw new zzabx(position + i, this.zzbwv.limit());
            }
            zzar(zza(str));
            zza((CharSequence) str, this.zzbwv);
        } catch (Throwable e) {
            zzabx com_google_android_gms_internal_measurement_zzabx = new zzabx(this.zzbwv.position(), this.zzbwv.limit());
            com_google_android_gms_internal_measurement_zzabx.initCause(e);
            throw com_google_android_gms_internal_measurement_zzabx;
        }
    }

    public final void zzb(zzace com_google_android_gms_internal_measurement_zzace) throws IOException {
        zzar(com_google_android_gms_internal_measurement_zzace.zzvl());
        com_google_android_gms_internal_measurement_zzace.zza(this);
    }

    public final void zze(int i, int i2) throws IOException {
        zzg(i, 0);
        if (i2 >= 0) {
            zzar(i2);
        } else {
            zzan((long) i2);
        }
    }

    public final void zzg(int i, int i2) throws IOException {
        zzar((i << 3) | i2);
    }

    public final void zzk(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzbwv.remaining() >= length) {
            this.zzbwv.put(bArr, 0, length);
            return;
        }
        throw new zzabx(this.zzbwv.position(), this.zzbwv.limit());
    }

    public final void zzve() {
        if (this.zzbwv.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzbwv.remaining())}));
        }
    }
}
