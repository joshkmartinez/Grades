package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzby<FieldDescriptorType extends zzca<FieldDescriptorType>> {
    private static final zzby zzgw = new zzby(true);
    private final zzei<FieldDescriptorType, Object> zzgt = zzei.zzaj(16);
    private boolean zzgu;
    private boolean zzgv = false;

    private zzby() {
    }

    private zzby(boolean z) {
        zzv();
    }

    static int zza(zzfl com_google_android_gms_internal_clearcut_zzfl, int i, Object obj) {
        i = zzbn.zzr(i);
        if (com_google_android_gms_internal_clearcut_zzfl == zzfl.GROUP) {
            zzci.zzf((zzdo) obj);
            i <<= 1;
        }
        return i + zzb(com_google_android_gms_internal_clearcut_zzfl, obj);
    }

    private final Object zza(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.zzgt.get(fieldDescriptorType);
        return obj instanceof zzcr ? zzcr.zzbr() : obj;
    }

    static void zza(zzbn com_google_android_gms_internal_clearcut_zzbn, zzfl com_google_android_gms_internal_clearcut_zzfl, int i, Object obj) throws IOException {
        if (com_google_android_gms_internal_clearcut_zzfl == zzfl.GROUP) {
            zzdo com_google_android_gms_internal_clearcut_zzdo = (zzdo) obj;
            zzci.zzf(com_google_android_gms_internal_clearcut_zzdo);
            com_google_android_gms_internal_clearcut_zzbn.zzb(i, 3);
            com_google_android_gms_internal_clearcut_zzdo.zzb(com_google_android_gms_internal_clearcut_zzbn);
            com_google_android_gms_internal_clearcut_zzbn.zzb(i, 4);
            return;
        }
        com_google_android_gms_internal_clearcut_zzbn.zzb(i, com_google_android_gms_internal_clearcut_zzfl.zzel());
        switch (zzbz.zzgq[com_google_android_gms_internal_clearcut_zzfl.ordinal()]) {
            case 1:
                com_google_android_gms_internal_clearcut_zzbn.zza(((Double) obj).doubleValue());
                break;
            case 2:
                com_google_android_gms_internal_clearcut_zzbn.zza(((Float) obj).floatValue());
                return;
            case 3:
                com_google_android_gms_internal_clearcut_zzbn.zzb(((Long) obj).longValue());
                return;
            case 4:
                com_google_android_gms_internal_clearcut_zzbn.zzb(((Long) obj).longValue());
                return;
            case 5:
                com_google_android_gms_internal_clearcut_zzbn.zzn(((Integer) obj).intValue());
                return;
            case 6:
                com_google_android_gms_internal_clearcut_zzbn.zzd(((Long) obj).longValue());
                return;
            case 7:
                com_google_android_gms_internal_clearcut_zzbn.zzq(((Integer) obj).intValue());
                return;
            case 8:
                com_google_android_gms_internal_clearcut_zzbn.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzdo) obj).zzb(com_google_android_gms_internal_clearcut_zzbn);
                return;
            case 10:
                com_google_android_gms_internal_clearcut_zzbn.zzb((zzdo) obj);
                return;
            case 11:
                if (obj instanceof zzbb) {
                    com_google_android_gms_internal_clearcut_zzbn.zza((zzbb) obj);
                    return;
                } else {
                    com_google_android_gms_internal_clearcut_zzbn.zzg((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzbb) {
                    com_google_android_gms_internal_clearcut_zzbn.zza((zzbb) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                com_google_android_gms_internal_clearcut_zzbn.zzd(bArr, 0, bArr.length);
                return;
            case 13:
                com_google_android_gms_internal_clearcut_zzbn.zzo(((Integer) obj).intValue());
                return;
            case 14:
                com_google_android_gms_internal_clearcut_zzbn.zzq(((Integer) obj).intValue());
                return;
            case 15:
                com_google_android_gms_internal_clearcut_zzbn.zzd(((Long) obj).longValue());
                return;
            case 16:
                com_google_android_gms_internal_clearcut_zzbn.zzp(((Integer) obj).intValue());
                return;
            case 17:
                com_google_android_gms_internal_clearcut_zzbn.zzc(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof zzcj)) {
                    com_google_android_gms_internal_clearcut_zzbn.zzn(((Integer) obj).intValue());
                    break;
                } else {
                    com_google_android_gms_internal_clearcut_zzbn.zzn(((zzcj) obj).zzc());
                    return;
                }
            default:
                break;
        }
    }

    private final void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.zzaw()) {
            zza(fieldDescriptorType.zzau(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fieldDescriptorType.zzau(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzcr) {
            this.zzgv = true;
        }
        this.zzgt.zza((Comparable) fieldDescriptorType, obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.clearcut.zzfl r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.clearcut.zzci.checkNotNull(r3);
        r0 = com.google.android.gms.internal.clearcut.zzbz.zzgx;
        r2 = r2.zzek();
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
        r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzdo;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzcr;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzcj;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = r0;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.clearcut.zzbb;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzby.zza(com.google.android.gms.internal.clearcut.zzfl, java.lang.Object):void");
    }

    public static <T extends zzca<T>> zzby<T> zzar() {
        return zzgw;
    }

    private static int zzb(zzca<?> com_google_android_gms_internal_clearcut_zzca_, Object obj) {
        zzfl zzau = com_google_android_gms_internal_clearcut_zzca_.zzau();
        int zzc = com_google_android_gms_internal_clearcut_zzca_.zzc();
        if (!com_google_android_gms_internal_clearcut_zzca_.zzaw()) {
            return zza(zzau, zzc, obj);
        }
        int i = 0;
        if (com_google_android_gms_internal_clearcut_zzca_.zzax()) {
            for (Object obj2 : (List) obj2) {
                i += zzb(zzau, obj2);
            }
            return (zzbn.zzr(zzc) + i) + zzbn.zzz(i);
        }
        for (Object obj22 : (List) obj22) {
            i += zza(zzau, zzc, obj22);
        }
        return i;
    }

    private static int zzb(zzfl com_google_android_gms_internal_clearcut_zzfl, Object obj) {
        switch (zzbz.zzgq[com_google_android_gms_internal_clearcut_zzfl.ordinal()]) {
            case 1:
                return zzbn.zzb(((Double) obj).doubleValue());
            case 2:
                return zzbn.zzb(((Float) obj).floatValue());
            case 3:
                return zzbn.zze(((Long) obj).longValue());
            case 4:
                return zzbn.zzf(((Long) obj).longValue());
            case 5:
                return zzbn.zzs(((Integer) obj).intValue());
            case 6:
                return zzbn.zzh(((Long) obj).longValue());
            case 7:
                return zzbn.zzv(((Integer) obj).intValue());
            case 8:
                return zzbn.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzbn.zzd((zzdo) obj);
            case 10:
                return obj instanceof zzcr ? zzbn.zza((zzcr) obj) : zzbn.zzc((zzdo) obj);
            case 11:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
            case 12:
                return obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzd((byte[]) obj);
            case 13:
                return zzbn.zzt(((Integer) obj).intValue());
            case 14:
                return zzbn.zzw(((Integer) obj).intValue());
            case 15:
                return zzbn.zzi(((Long) obj).longValue());
            case 16:
                return zzbn.zzu(((Integer) obj).intValue());
            case 17:
                return zzbn.zzg(((Long) obj).longValue());
            case 18:
                return obj instanceof zzcj ? zzbn.zzx(((zzcj) obj).zzc()) : zzbn.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzb(Entry<FieldDescriptorType, Object> entry) {
        zzca com_google_android_gms_internal_clearcut_zzca = (zzca) entry.getKey();
        if (com_google_android_gms_internal_clearcut_zzca.zzav() == zzfq.MESSAGE) {
            if (com_google_android_gms_internal_clearcut_zzca.zzaw()) {
                for (zzdo isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof zzdo) {
                if (!((zzdo) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof zzcr) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private final void zzc(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (zzca) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzcr) {
            value = zzcr.zzbr();
        }
        Object zza;
        if (comparable.zzaw()) {
            zza = zza((zzca) comparable);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzd : (List) value) {
                ((List) zza).add(zzd(zzd));
            }
            this.zzgt.zza(comparable, zza);
        } else if (comparable.zzav() == zzfq.MESSAGE) {
            zza = zza((zzca) comparable);
            if (zza == null) {
                this.zzgt.zza(comparable, zzd(value));
            } else {
                this.zzgt.zza(comparable, zza instanceof zzdv ? comparable.zza((zzdv) zza, (zzdv) value) : comparable.zza(((zzdo) zza).zzbc(), (zzdo) value).zzbj());
            }
        } else {
            this.zzgt.zza(comparable, zzd(value));
        }
    }

    private static int zzd(Entry<FieldDescriptorType, Object> entry) {
        zzca com_google_android_gms_internal_clearcut_zzca = (zzca) entry.getKey();
        Object value = entry.getValue();
        return (com_google_android_gms_internal_clearcut_zzca.zzav() != zzfq.MESSAGE || com_google_android_gms_internal_clearcut_zzca.zzaw() || com_google_android_gms_internal_clearcut_zzca.zzax()) ? zzb(com_google_android_gms_internal_clearcut_zzca, value) : value instanceof zzcr ? zzbn.zzb(((zzca) entry.getKey()).zzc(), (zzcr) value) : zzbn.zzd(((zzca) entry.getKey()).zzc(), (zzdo) value);
    }

    private static Object zzd(Object obj) {
        if (obj instanceof zzdv) {
            return ((zzdv) obj).zzci();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzby com_google_android_gms_internal_clearcut_zzby = new zzby();
        for (int i = 0; i < this.zzgt.zzdr(); i++) {
            Entry zzak = this.zzgt.zzak(i);
            com_google_android_gms_internal_clearcut_zzby.zza((zzca) zzak.getKey(), zzak.getValue());
        }
        for (Entry zzak2 : this.zzgt.zzds()) {
            com_google_android_gms_internal_clearcut_zzby.zza((zzca) zzak2.getKey(), zzak2.getValue());
        }
        com_google_android_gms_internal_clearcut_zzby.zzgv = this.zzgv;
        return com_google_android_gms_internal_clearcut_zzby;
    }

    final Iterator<Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzgv ? new zzcu(this.zzgt.zzdt().iterator()) : this.zzgt.zzdt().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzby)) {
            return false;
        }
        return this.zzgt.equals(((zzby) obj).zzgt);
    }

    public final int hashCode() {
        return this.zzgt.hashCode();
    }

    final boolean isEmpty() {
        return this.zzgt.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zzgu;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zzgt.zzdr(); i++) {
            if (!zzb(this.zzgt.zzak(i))) {
                return false;
            }
        }
        for (Entry zzb : this.zzgt.zzds()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzgv ? new zzcu(this.zzgt.entrySet().iterator()) : this.zzgt.entrySet().iterator();
    }

    public final void zza(zzby<FieldDescriptorType> com_google_android_gms_internal_clearcut_zzby_FieldDescriptorType) {
        for (int i = 0; i < com_google_android_gms_internal_clearcut_zzby_FieldDescriptorType.zzgt.zzdr(); i++) {
            zzc(com_google_android_gms_internal_clearcut_zzby_FieldDescriptorType.zzgt.zzak(i));
        }
        for (Entry zzc : com_google_android_gms_internal_clearcut_zzby_FieldDescriptorType.zzgt.zzds()) {
            zzc(zzc);
        }
    }

    public final int zzas() {
        int i = 0;
        int i2 = 0;
        while (i < this.zzgt.zzdr()) {
            Entry zzak = this.zzgt.zzak(i);
            i2 += zzb((zzca) zzak.getKey(), zzak.getValue());
            i++;
        }
        for (Entry zzak2 : this.zzgt.zzds()) {
            i2 += zzb((zzca) zzak2.getKey(), zzak2.getValue());
        }
        return i2;
    }

    public final int zzat() {
        int i = 0;
        int i2 = 0;
        while (i < this.zzgt.zzdr()) {
            i2 += zzd(this.zzgt.zzak(i));
            i++;
        }
        for (Entry zzd : this.zzgt.zzds()) {
            i2 += zzd(zzd);
        }
        return i2;
    }

    public final void zzv() {
        if (!this.zzgu) {
            this.zzgt.zzv();
            this.zzgu = true;
        }
    }
}
