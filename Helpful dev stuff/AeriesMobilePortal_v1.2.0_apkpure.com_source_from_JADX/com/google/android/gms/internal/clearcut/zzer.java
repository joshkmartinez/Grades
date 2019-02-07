package com.google.android.gms.internal.clearcut;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzer extends AbstractSet<Entry<K, V>> {
    private final /* synthetic */ zzei zzos;

    private zzer(zzei com_google_android_gms_internal_clearcut_zzei) {
        this.zzos = com_google_android_gms_internal_clearcut_zzei;
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzos.zza((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzos.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzos.get(entry.getKey());
        obj = entry.getValue();
        if (obj2 != obj) {
            if (obj2 == null || !obj2.equals(obj)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzeq(this.zzos);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzos.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzos.size();
    }
}
