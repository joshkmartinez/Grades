package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzj {
    private final ConcurrentHashMap<zzk, List<Throwable>> zzh = new ConcurrentHashMap(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzi = new ReferenceQueue();

    zzj() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        while (true) {
            Reference poll = this.zzi.poll();
            if (poll == null) {
                break;
            }
            this.zzh.remove(poll);
        }
        List<Throwable> list = (List) this.zzh.get(new zzk(th, null));
        if (list != null) {
            return list;
        }
        List vector = new Vector(2);
        List<Throwable> list2 = (List) this.zzh.putIfAbsent(new zzk(th, this.zzi), vector);
        return list2 == null ? vector : list2;
    }
}
