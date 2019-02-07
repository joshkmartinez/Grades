package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

final class zzaaz extends zzaay<FieldDescriptorType, Object> {
    zzaaz(int i) {
        super(i);
    }

    public final void zzrg() {
        if (!isImmutable()) {
            Entry zzah;
            for (int i = 0; i < zzuj(); i++) {
                zzah = zzah(i);
                if (((zzzo) zzah.getKey()).zztk()) {
                    zzah.setValue(Collections.unmodifiableList((List) zzah.getValue()));
                }
            }
            for (Entry zzah2 : zzuk()) {
                if (((zzzo) zzah2.getKey()).zztk()) {
                    zzah2.setValue(Collections.unmodifiableList((List) zzah2.getValue()));
                }
            }
        }
        super.zzrg();
    }
}
