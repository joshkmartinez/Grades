package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public final class zzc {
    private static final Object sLock = new Object();
    @GuardedBy("sLock")
    private static int zzas;
    @GuardedBy("sLock")
    private SparseArray<Integer> zzat = new SparseArray();
    @GuardedBy("sLock")
    private SparseArray<Integer> zzau = new SparseArray();

    public final int zzb(int i) {
        synchronized (sLock) {
            Integer num = (Integer) this.zzat.get(i);
            if (num != null) {
                i = num.intValue();
                return i;
            }
            int i2 = zzas;
            zzas++;
            this.zzat.append(i, Integer.valueOf(i2));
            this.zzau.append(i2, Integer.valueOf(i));
            return i2;
        }
    }

    public final int zzc(int i) {
        synchronized (sLock) {
            i = ((Integer) this.zzau.get(i)).intValue();
        }
        return i;
    }
}
