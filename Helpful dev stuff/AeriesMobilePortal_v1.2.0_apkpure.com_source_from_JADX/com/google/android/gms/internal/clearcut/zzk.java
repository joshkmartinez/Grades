package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk {
    private static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private static long zza(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        j4 = (j2 ^ (j4 ^ (j4 >>> 47))) * j3;
        return (j4 ^ (j4 >>> 47)) * j3;
    }

    public static long zza(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 0 || length > bArr2.length) {
            StringBuilder stringBuilder = new StringBuilder(67);
            stringBuilder.append("Out of bound index with offput: 0 and length: ");
            stringBuilder.append(length);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        int i = 0;
        long j;
        long zzb;
        long zzb2;
        long zzb3;
        if (length <= 32) {
            if (length > 16) {
                j = -7286425919675154353L + ((long) (length << 1));
                zzb = zzb(bArr2, 0) * -5435081209227447693L;
                zzb2 = zzb(bArr2, 8);
                length += 0;
                zzb3 = zzb(bArr2, length - 8) * j;
                return zza((Long.rotateRight(zzb + zzb2, 43) + Long.rotateRight(zzb3, 30)) + (zzb(bArr2, length - 16) * -7286425919675154353L), (zzb + Long.rotateRight(zzb2 - 7286425919675154353L, 18)) + zzb3, j);
            } else if (length >= 8) {
                j = -7286425919675154353L + ((long) (length << 1));
                long zzb4 = zzb(bArr2, 0) - 7286425919675154353L;
                long zzb5 = zzb(bArr2, (length + 0) - 8);
                return zza((Long.rotateRight(zzb5, 37) * j) + zzb4, (Long.rotateRight(zzb4, 25) + zzb5) * j, j);
            } else if (length >= 4) {
                return zza(((long) length) + ((((long) zza(bArr2, 0)) & 4294967295L) << 3), ((long) zza(bArr2, (length + 0) - 4)) & 4294967295L, -7286425919675154353L + ((long) (length << 1)));
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                zzb2 = (((long) ((bArr2[0] & 255) + ((bArr2[(length >> 1) + 0] & 255) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr2[0 + (length - 1)] & 255) << 2))) * -4348849565147123417L);
                return (zzb2 ^ (zzb2 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            zzb3 = -7286425919675154353L + ((long) (length << 1));
            zzb = zzb(bArr2, 0) * -7286425919675154353L;
            zzb2 = zzb(bArr2, 8);
            length += 0;
            long zzb6 = zzb(bArr2, length - 8) * zzb3;
            long rotateRight = (Long.rotateRight(zzb + zzb2, 43) + Long.rotateRight(zzb6, 30)) + (zzb(bArr2, length - 16) * -7286425919675154353L);
            long j2 = zzb3;
            j = j2;
            zzb2 = zza(rotateRight, (zzb + Long.rotateRight(zzb2 - 7286425919675154353L, 18)) + zzb6, j);
            bArr2 = bArr;
            zzb3 = zzb(bArr2, 16) * j2;
            long zzb7 = zzb(bArr2, 24);
            rotateRight = (rotateRight + zzb(bArr2, length - 32)) * j2;
            return zza((Long.rotateRight(zzb3 + zzb7, 43) + Long.rotateRight(rotateRight, 30)) + ((zzb2 + zzb(bArr2, length - 24)) * j2), (zzb3 + Long.rotateRight(zzb7 + zzb, 18)) + rotateRight, j);
        } else {
            long j3 = 2480279821605975764L;
            long j4 = 1390051526045402406L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long zzb8 = 95310865018149119L + zzb(bArr2, 0);
            int i2 = 1;
            length--;
            int i3 = 0 + ((length / 64) << 6);
            int i4 = length & 63;
            int i5 = (i3 + i4) - 63;
            int i6 = 0;
            while (true) {
                long rotateRight2 = (Long.rotateRight(((zzb8 + j3) + jArr[i]) + zzb(bArr2, i6 + 8), 37) * -5435081209227447693L) ^ jArr2[1];
                long rotateRight3 = (Long.rotateRight((j3 + jArr[i2]) + zzb(bArr2, i6 + 48), 42) * -5435081209227447693L) + (jArr[0] + zzb(bArr2, i6 + 40));
                zzb8 = Long.rotateRight(j4 + jArr2[0], 33) * -5435081209227447693L;
                int i7 = i4;
                i = i3;
                zza(bArr, i6, jArr[1] * -5435081209227447693L, rotateRight2 + jArr2[0], jArr);
                zza(bArr, i6 + 32, zzb8 + jArr2[1], rotateRight3 + zzb(bArr2, i6 + 16), jArr2);
                length = i6 + 64;
                if (length == i) {
                    long j5 = -5435081209227447693L + ((rotateRight2 & 255) << 1);
                    jArr2[0] = jArr2[0] + ((long) i7);
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    zzb3 = (Long.rotateRight(((zzb8 + rotateRight3) + jArr[0]) + zzb(bArr2, i5 + 8), 37) * j5) ^ (jArr2[1] * 9);
                    long rotateRight4 = (Long.rotateRight((rotateRight3 + jArr[1]) + zzb(bArr2, i5 + 48), 42) * j5) + ((jArr[0] * 9) + zzb(bArr2, i5 + 40));
                    long rotateRight5 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j5;
                    zza(bArr, i5, jArr[1] * j5, zzb3 + jArr2[0], jArr);
                    zza(bArr, i5 + 32, rotateRight5 + jArr2[1], rotateRight4 + zzb(bArr2, i5 + 16), jArr2);
                    long j6 = j5;
                    return zza((zza(jArr[0], jArr2[0], j6) + ((rotateRight4 ^ (rotateRight4 >>> 47)) * -4348849565147123417L)) + zzb3, zza(jArr[1], jArr2[1], j6) + rotateRight5, j6);
                }
                i6 = length;
                i3 = i;
                j4 = rotateRight2;
                j3 = rotateRight3;
                i2 = 1;
                i = 0;
                int i8 = i7;
                i7 = 64;
                i4 = i8;
            }
        }
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long zzb = zzb(bArr, i);
        long zzb2 = zzb(bArr, i + 8);
        long zzb3 = zzb(bArr, i + 16);
        long zzb4 = zzb(bArr, i + 24);
        long j3 = j + zzb;
        zzb = (j3 + zzb2) + zzb3;
        zzb2 = Long.rotateRight((j2 + j3) + zzb4, 21) + Long.rotateRight(zzb, 44);
        jArr[0] = zzb + zzb4;
        jArr[1] = zzb2 + j3;
    }

    private static long zzb(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
