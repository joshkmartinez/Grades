package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import org.jetbrains.anko.DimensionsKt;

final class zzfj extends zzfg {
    zzfj() {
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzff.zzam(i);
            case 1:
                return zzff.zzp(i, zzfd.zza(bArr, j));
            case 2:
                return zzff.zzd(i, zzfd.zza(bArr, j), zzfd.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final int zzb(int r12, byte[] r13, int r14, int r15) {
        /*
        r11 = this;
        r12 = r14 | r15;
        r0 = 2;
        r1 = 3;
        r2 = 0;
        r3 = r13.length;
        r3 = r3 - r15;
        r12 = r12 | r3;
        if (r12 < 0) goto L_0x00b5;
    L_0x000a:
        r3 = (long) r14;
        r14 = (long) r15;
        r5 = r14 - r3;
        r12 = (int) r5;
        r14 = 16;
        r5 = 1;
        if (r12 >= r14) goto L_0x0017;
    L_0x0015:
        r14 = r2;
        goto L_0x0029;
    L_0x0017:
        r14 = r2;
        r7 = r3;
    L_0x0019:
        if (r14 >= r12) goto L_0x0028;
    L_0x001b:
        r9 = r7 + r5;
        r15 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r7);
        if (r15 >= 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0029;
    L_0x0024:
        r14 = r14 + 1;
        r7 = r9;
        goto L_0x0019;
    L_0x0028:
        r14 = r12;
    L_0x0029:
        r12 = r12 - r14;
        r14 = (long) r14;
        r7 = r3 + r14;
    L_0x002d:
        r14 = r2;
    L_0x002e:
        if (r12 <= 0) goto L_0x003f;
    L_0x0030:
        r14 = r7 + r5;
        r3 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r7);
        if (r3 < 0) goto L_0x003d;
    L_0x0038:
        r12 = r12 + -1;
        r7 = r14;
        r14 = r3;
        goto L_0x002e;
    L_0x003d:
        r7 = r14;
        r14 = r3;
    L_0x003f:
        if (r12 != 0) goto L_0x0042;
    L_0x0041:
        return r2;
    L_0x0042:
        r12 = r12 + -1;
        r15 = -32;
        r3 = -65;
        r4 = -1;
        if (r14 >= r15) goto L_0x0060;
    L_0x004b:
        if (r12 != 0) goto L_0x004e;
    L_0x004d:
        return r14;
    L_0x004e:
        r12 = r12 + -1;
        r15 = -62;
        if (r14 < r15) goto L_0x005f;
    L_0x0054:
        r14 = r7 + r5;
        r7 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r7);
        if (r7 <= r3) goto L_0x005d;
    L_0x005c:
        goto L_0x005f;
    L_0x005d:
        r7 = r14;
        goto L_0x002d;
    L_0x005f:
        return r4;
    L_0x0060:
        r9 = -16;
        if (r14 >= r9) goto L_0x008a;
    L_0x0064:
        if (r12 >= r0) goto L_0x006b;
    L_0x0066:
        r12 = zza(r13, r14, r7, r12);
        return r12;
    L_0x006b:
        r12 = r12 + -2;
        r9 = r7 + r5;
        r7 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r7);
        if (r7 > r3) goto L_0x0089;
    L_0x0075:
        r8 = -96;
        if (r14 != r15) goto L_0x007b;
    L_0x0079:
        if (r7 < r8) goto L_0x0089;
    L_0x007b:
        r15 = -19;
        if (r14 != r15) goto L_0x0081;
    L_0x007f:
        if (r7 >= r8) goto L_0x0089;
    L_0x0081:
        r7 = r9 + r5;
        r14 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r9);
        if (r14 <= r3) goto L_0x002d;
    L_0x0089:
        return r4;
    L_0x008a:
        if (r12 >= r1) goto L_0x0091;
    L_0x008c:
        r12 = zza(r13, r14, r7, r12);
        return r12;
    L_0x0091:
        r12 = r12 + -3;
        r9 = r7 + r5;
        r15 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r7);
        if (r15 > r3) goto L_0x00b4;
    L_0x009b:
        r14 = r14 << 28;
        r15 = r15 + 112;
        r14 = r14 + r15;
        r14 = r14 >> 30;
        if (r14 != 0) goto L_0x00b4;
    L_0x00a4:
        r14 = r9 + r5;
        r7 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r9);
        if (r7 > r3) goto L_0x00b4;
    L_0x00ac:
        r7 = r14 + r5;
        r14 = com.google.android.gms.internal.clearcut.zzfd.zza(r13, r14);
        if (r14 <= r3) goto L_0x002d;
    L_0x00b4:
        return r4;
    L_0x00b5:
        r12 = new java.lang.ArrayIndexOutOfBoundsException;
        r1 = new java.lang.Object[r1];
        r3 = 1;
        r4 = "Array length=%d, index=%d, limit=%d";
        r13 = r13.length;
        r13 = java.lang.Integer.valueOf(r13);
        r1[r2] = r13;
        r13 = java.lang.Integer.valueOf(r14);
        r1[r3] = r13;
        r13 = java.lang.Integer.valueOf(r15);
        r1[r0] = r13;
        r13 = java.lang.String.format(r4, r1);
        r12.<init>(r13);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfj.zzb(int, byte[], int, int):int");
    }

    final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j = (long) i3;
        long j2 = j + ((long) i4);
        int length = charSequence.length();
        if (length > i4 || bArr2.length - i4 < i3) {
            char charAt = charSequence2.charAt(length - 1);
            i3 += i4;
            StringBuilder stringBuilder = new StringBuilder(37);
            stringBuilder.append("Failed writing ");
            stringBuilder.append(charAt);
            stringBuilder.append(" at index ");
            stringBuilder.append(i3);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        i3 = 0;
        while (i3 < length) {
            char charAt2 = charSequence2.charAt(i3);
            if (charAt2 >= '') {
                break;
            }
            long j3 = j + 1;
            zzfd.zza(bArr2, j, (byte) charAt2);
            i3++;
            j = j3;
        }
        if (i3 == length) {
            return (int) j;
        }
        while (i3 < length) {
            charAt2 = charSequence2.charAt(i3);
            if (charAt2 < '' && j < j2) {
                j3 = j + 1;
                zzfd.zza(bArr2, j, (byte) charAt2);
                j = j3;
            } else if (charAt2 < 'ࠀ' && j <= j2 - 2) {
                r14 = j + 1;
                zzfd.zza(bArr2, j, (byte) (960 | (charAt2 >>> 6)));
                j = r14 + 1;
                zzfd.zza(bArr2, r14, (byte) ((charAt2 & 63) | 128));
            } else if ((charAt2 < '?' || '?' < charAt2) && j <= j2 - 3) {
                r14 = j + 1;
                zzfd.zza(bArr2, j, (byte) (DimensionsKt.XXHDPI | (charAt2 >>> 12)));
                j = r14 + 1;
                zzfd.zza(bArr2, r14, (byte) (((charAt2 >>> 6) & 63) | 128));
                r14 = j + 1;
                zzfd.zza(bArr2, j, (byte) ((charAt2 & 63) | 128));
                j = r14;
            } else if (j <= j2 - 4) {
                int i5 = i3 + 1;
                if (i5 != length) {
                    char charAt3 = charSequence2.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        r14 = j + 1;
                        zzfd.zza(bArr2, j, (byte) (DimensionsKt.HDPI | (i3 >>> 18)));
                        j = r14 + 1;
                        zzfd.zza(bArr2, r14, (byte) (((i3 >>> 12) & 63) | 128));
                        r14 = j + 1;
                        zzfd.zza(bArr2, j, (byte) (((i3 >>> 6) & 63) | 128));
                        j = r14 + 1;
                        zzfd.zza(bArr2, r14, (byte) ((i3 & 63) | 128));
                        i3 = i5;
                    }
                } else {
                    i5 = i3;
                }
                throw new zzfi(i5 - 1, length);
            } else {
                if ('?' <= charAt2 && charAt2 <= '?') {
                    int i6 = i3 + 1;
                    if (i6 == length || !Character.isSurrogatePair(charAt2, charSequence2.charAt(i6))) {
                        throw new zzfi(i3, length);
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder(46);
                stringBuilder2.append("Failed writing ");
                stringBuilder2.append(charAt2);
                stringBuilder2.append(" at index ");
                stringBuilder2.append(j);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            i3++;
        }
        return (int) j;
    }

    final void zzb(CharSequence charSequence, ByteBuffer byteBuffer) {
        CharSequence charSequence2 = charSequence;
        ByteBuffer byteBuffer2 = byteBuffer;
        long zzb = zzfd.zzb(byteBuffer);
        long position = zzb + ((long) byteBuffer.position());
        long limit = zzb + ((long) byteBuffer.limit());
        int length = charSequence.length();
        int i;
        if (((long) length) <= limit - position) {
            char charAt;
            long j;
            int i2;
            int i3 = 0;
            while (i3 < length) {
                charAt = charSequence2.charAt(i3);
                if (charAt >= '') {
                    break;
                }
                j = position + 1;
                zzfd.zza(position, (byte) charAt);
                i3++;
                position = j;
            }
            if (i3 == length) {
                i2 = (int) (position - zzb);
            } else {
                while (i3 < length) {
                    long j2;
                    charAt = charSequence2.charAt(i3);
                    if (charAt < '' && position < limit) {
                        j = position + 1;
                        zzfd.zza(position, (byte) charAt);
                        j2 = zzb;
                        position = j;
                    } else if (charAt >= 'ࠀ' || position > limit - 2) {
                        j2 = zzb;
                        if ((charAt < '?' || '?' < charAt) && position <= limit - 3) {
                            r1 = position + 1;
                            zzfd.zza(position, (byte) (DimensionsKt.XXHDPI | (charAt >>> 12)));
                            position = r1 + 1;
                            zzfd.zza(r1, (byte) (((charAt >>> 6) & 63) | 128));
                            r1 = position + 1;
                            zzfd.zza(position, (byte) ((63 & charAt) | 128));
                            position = r1;
                        } else if (position <= limit - 4) {
                            i = i3 + 1;
                            if (i != length) {
                                char charAt2 = charSequence2.charAt(i);
                                if (Character.isSurrogatePair(charAt, charAt2)) {
                                    int toCodePoint = Character.toCodePoint(charAt, charAt2);
                                    long j3 = position + 1;
                                    zzfd.zza(position, (byte) (DimensionsKt.HDPI | (toCodePoint >>> 18)));
                                    long j4 = j3 + 1;
                                    zzfd.zza(j3, (byte) (((toCodePoint >>> 12) & 63) | 128));
                                    j3 = j4 + 1;
                                    zzfd.zza(j4, (byte) (((toCodePoint >>> 6) & 63) | 128));
                                    j4 = j3 + 1;
                                    zzfd.zza(j3, (byte) ((toCodePoint & 63) | 128));
                                    position = j4;
                                    i3 = i;
                                }
                            } else {
                                i = i3;
                            }
                            throw new zzfi(i - 1, length);
                        } else {
                            if ('?' <= charAt && charAt <= '?') {
                                i = i3 + 1;
                                if (i == length || !Character.isSurrogatePair(charAt, charSequence2.charAt(i))) {
                                    throw new zzfi(i3, length);
                                }
                            }
                            StringBuilder stringBuilder = new StringBuilder(46);
                            stringBuilder.append("Failed writing ");
                            stringBuilder.append(charAt);
                            stringBuilder.append(" at index ");
                            stringBuilder.append(position);
                            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                        }
                    } else {
                        j2 = zzb;
                        r1 = position + 1;
                        zzfd.zza(position, (byte) (960 | (charAt >>> 6)));
                        position = r1 + 1;
                        zzfd.zza(r1, (byte) ((63 & charAt) | 128));
                    }
                    i3++;
                    zzb = j2;
                    byteBuffer2 = byteBuffer;
                }
                i2 = (int) (position - zzb);
                byteBuffer2 = byteBuffer;
            }
            byteBuffer2.position(i2);
            return;
        }
        char charAt3 = charSequence2.charAt(length - 1);
        i = byteBuffer.limit();
        StringBuilder stringBuilder2 = new StringBuilder(37);
        stringBuilder2.append("Failed writing ");
        stringBuilder2.append(charAt3);
        stringBuilder2.append(" at index ");
        stringBuilder2.append(i);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }
}
