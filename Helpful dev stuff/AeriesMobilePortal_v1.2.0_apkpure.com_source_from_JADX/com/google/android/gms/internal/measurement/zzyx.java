package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzyx implements Iterator {
    private final int limit = this.zzbqz.size();
    private int position = 0;
    private final /* synthetic */ zzyw zzbqz;

    zzyx(zzyw com_google_android_gms_internal_measurement_zzyw) {
        this.zzbqz = com_google_android_gms_internal_measurement_zzyw;
    }

    private final byte nextByte() {
        try {
            zzyw com_google_android_gms_internal_measurement_zzyw = this.zzbqz;
            int i = this.position;
            this.position = i + 1;
            return com_google_android_gms_internal_measurement_zzyw.zzae(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
