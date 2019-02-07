package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>> {
    private static final zzzm zzbru = new zzzm(true);
    private boolean zzbls;
    private final zzaay<FieldDescriptorType, Object> zzbrs = zzaay.zzag(16);
    private boolean zzbrt = false;

    private zzzm() {
    }

    private zzzm(boolean z) {
        if (!this.zzbls) {
            this.zzbrs.zzrg();
            this.zzbls = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzabp r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.measurement.zzzr.checkNotNull(r3);
        r0 = com.google.android.gms.internal.measurement.zzzn.zzbrv;
        r2 = r2.zzuv();
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003d;
            case 3: goto L_0x003a;
            case 4: goto L_0x0037;
            case 5: goto L_0x0034;
            case 6: goto L_0x0031;
            case 7: goto L_0x0028;
            case 8: goto L_0x001e;
            case 9: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0043;
    L_0x0015:
        r2 = r3 instanceof com.google.android.gms.internal.measurement.zzaal;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.measurement.zzzu;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.measurement.zzzs;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = r0;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.measurement.zzyw;
        if (r2 != 0) goto L_0x0026;
    L_0x002c:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0043;
    L_0x0030:
        goto L_0x0026;
    L_0x0031:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0026;
    L_0x0034:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0026;
    L_0x0037:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0026;
    L_0x003a:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0026;
    L_0x003d:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0026;
    L_0x0040:
        r0 = r3 instanceof java.lang.Integer;
        goto L_0x0026;
    L_0x0043:
        if (r1 == 0) goto L_0x0046;
    L_0x0045:
        return;
    L_0x0046:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzzm.zza(com.google.android.gms.internal.measurement.zzabp, java.lang.Object):void");
    }

    private final void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.zztk()) {
            zza(fieldDescriptorType.zztj(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fieldDescriptorType.zztj(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzzu) {
            this.zzbrt = true;
        }
        this.zzbrs.zza((Comparable) fieldDescriptorType, obj);
    }

    public static <T extends zzzo<T>> zzzm<T> zzti() {
        return zzbru;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzm com_google_android_gms_internal_measurement_zzzm = new zzzm();
        for (int i = 0; i < this.zzbrs.zzuj(); i++) {
            Entry zzah = this.zzbrs.zzah(i);
            com_google_android_gms_internal_measurement_zzzm.zza((zzzo) zzah.getKey(), zzah.getValue());
        }
        for (Entry zzah2 : this.zzbrs.zzuk()) {
            com_google_android_gms_internal_measurement_zzzm.zza((zzzo) zzah2.getKey(), zzah2.getValue());
        }
        com_google_android_gms_internal_measurement_zzzm.zzbrt = this.zzbrt;
        return com_google_android_gms_internal_measurement_zzzm;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzm)) {
            return false;
        }
        return this.zzbrs.equals(((zzzm) obj).zzbrs);
    }

    public final int hashCode() {
        return this.zzbrs.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzbrt ? new zzzx(this.zzbrs.entrySet().iterator()) : this.zzbrs.entrySet().iterator();
    }
}
