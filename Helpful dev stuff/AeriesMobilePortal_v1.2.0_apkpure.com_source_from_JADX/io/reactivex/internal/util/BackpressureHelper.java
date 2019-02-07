package io.reactivex.internal.util;

import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

public final class BackpressureHelper {
    public static long addCap(long j, long j2) {
        long j3 = j + j2;
        return j3 < 0 ? LongCompanionObject.MAX_VALUE : j3;
    }

    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long multiplyCap(long j, long j2) {
        long j3 = j * j2;
        return (((j | j2) >>> 31) == 0 || j3 / j == j2) ? j3 : LongCompanionObject.MAX_VALUE;
    }

    public static long add(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == LongCompanionObject.MAX_VALUE) {
                return LongCompanionObject.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
        return j2;
    }

    public static long addCancel(AtomicLong atomicLong, long j) {
        long j2;
        do {
            j2 = atomicLong.get();
            if (j2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j2 == LongCompanionObject.MAX_VALUE) {
                return LongCompanionObject.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
        return j2;
    }

    public static long produced(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == LongCompanionObject.MAX_VALUE) {
                return LongCompanionObject.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("More produced than requested: ");
                stringBuilder.append(j2);
                RxJavaPlugins.onError(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }

    public static long producedCancel(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j3 == LongCompanionObject.MAX_VALUE) {
                return LongCompanionObject.MAX_VALUE;
            }
            j2 = j3 - j;
            if (j2 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("More produced than requested: ");
                stringBuilder.append(j2);
                RxJavaPlugins.onError(new IllegalStateException(stringBuilder.toString()));
                j2 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j2));
        return j2;
    }
}
