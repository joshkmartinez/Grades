package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzdi<K, V> extends LinkedHashMap<K, V> {
    private static final zzdi zzme;
    private boolean zzfa = true;

    static {
        zzdi com_google_android_gms_internal_clearcut_zzdi = new zzdi();
        zzme = com_google_android_gms_internal_clearcut_zzdi;
        com_google_android_gms_internal_clearcut_zzdi.zzfa = false;
    }

    private zzdi() {
    }

    private zzdi(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzdi<K, V> zzbz() {
        return zzme;
    }

    private final void zzcb() {
        if (!this.zzfa) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzci.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzcj)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        zzcb();
        super.clear();
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            boolean z;
            obj = (Map) obj;
            if (this != obj) {
                if (size() == obj.size()) {
                    for (Entry entry : entrySet()) {
                        if (obj.containsKey(entry.getKey())) {
                            boolean equals;
                            Object value = entry.getValue();
                            Object obj2 = obj.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            } else {
                                equals = value.equals(obj2);
                                continue;
                            }
                            if (!equals) {
                            }
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            z = true;
            return z;
        }
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final boolean isMutable() {
        return this.zzfa;
    }

    public final V put(K k, V v) {
        zzcb();
        zzci.checkNotNull(k);
        zzci.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzcb();
        for (Object next : map.keySet()) {
            zzci.checkNotNull(next);
            zzci.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzcb();
        return super.remove(obj);
    }

    public final void zza(zzdi<K, V> com_google_android_gms_internal_clearcut_zzdi_K__V) {
        zzcb();
        if (!com_google_android_gms_internal_clearcut_zzdi_K__V.isEmpty()) {
            putAll(com_google_android_gms_internal_clearcut_zzdi_K__V);
        }
    }

    public final zzdi<K, V> zzca() {
        return isEmpty() ? new zzdi() : new zzdi(this);
    }

    public final void zzv() {
        this.zzfa = false;
    }
}
