package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzacb implements Cloneable {
    private Object value;
    private zzabz<?, ?> zzbxe;
    private List<zzacg> zzbxf = new ArrayList();

    zzacb() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zza()];
        zza(zzabw.zzj(bArr));
        return bArr;
    }

    private final zzacb zzvg() {
        zzacb com_google_android_gms_internal_measurement_zzacb = new zzacb();
        try {
            com_google_android_gms_internal_measurement_zzacb.zzbxe = this.zzbxe;
            if (this.zzbxf == null) {
                com_google_android_gms_internal_measurement_zzacb.zzbxf = null;
            } else {
                com_google_android_gms_internal_measurement_zzacb.zzbxf.addAll(this.zzbxf);
            }
            if (this.value != null) {
                Object obj;
                if (this.value instanceof zzace) {
                    obj = (zzace) ((zzace) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    obj = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        obj2 = new byte[bArr.length][];
                        com_google_android_gms_internal_measurement_zzacb.value = obj2;
                        while (i < bArr.length) {
                            obj2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        obj = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        obj = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        obj = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        obj = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        obj = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzace[]) {
                        zzace[] com_google_android_gms_internal_measurement_zzaceArr = (zzace[]) this.value;
                        obj2 = new zzace[com_google_android_gms_internal_measurement_zzaceArr.length];
                        com_google_android_gms_internal_measurement_zzacb.value = obj2;
                        while (i < com_google_android_gms_internal_measurement_zzaceArr.length) {
                            obj2[i] = (zzace) com_google_android_gms_internal_measurement_zzaceArr[i].clone();
                            i++;
                        }
                    }
                }
                com_google_android_gms_internal_measurement_zzacb.value = obj;
            }
            return com_google_android_gms_internal_measurement_zzacb;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzvg();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacb)) {
            return false;
        }
        zzacb com_google_android_gms_internal_measurement_zzacb = (zzacb) obj;
        if (this.value != null && com_google_android_gms_internal_measurement_zzacb.value != null) {
            return this.zzbxe != com_google_android_gms_internal_measurement_zzacb.zzbxe ? false : !this.zzbxe.zzbwx.isArray() ? this.value.equals(com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) com_google_android_gms_internal_measurement_zzacb.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) com_google_android_gms_internal_measurement_zzacb.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) com_google_android_gms_internal_measurement_zzacb.value);
        } else {
            if (this.zzbxf != null && com_google_android_gms_internal_measurement_zzacb.zzbxf != null) {
                return this.zzbxf.equals(com_google_android_gms_internal_measurement_zzacb.zzbxf);
            }
            try {
                return Arrays.equals(toByteArray(), com_google_android_gms_internal_measurement_zzacb.toByteArray());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public final int hashCode() {
        try {
            return 527 + Arrays.hashCode(toByteArray());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final int zza() {
        int i = 0;
        int i2;
        if (this.value != null) {
            zzabz com_google_android_gms_internal_measurement_zzabz = this.zzbxe;
            Object obj = this.value;
            if (!com_google_android_gms_internal_measurement_zzabz.zzbwy) {
                return com_google_android_gms_internal_measurement_zzabz.zzv(obj);
            }
            int length = Array.getLength(obj);
            i2 = 0;
            while (i < length) {
                if (Array.get(obj, i) != null) {
                    i2 += com_google_android_gms_internal_measurement_zzabz.zzv(Array.get(obj, i));
                }
                i++;
            }
            return i2;
        }
        i2 = 0;
        for (zzacg com_google_android_gms_internal_measurement_zzacg : this.zzbxf) {
            i2 += (zzabw.zzas(com_google_android_gms_internal_measurement_zzacg.tag) + 0) + com_google_android_gms_internal_measurement_zzacg.zzbrc.length;
        }
        return i2;
    }

    final void zza(zzabw com_google_android_gms_internal_measurement_zzabw) throws IOException {
        if (this.value != null) {
            zzabz com_google_android_gms_internal_measurement_zzabz = this.zzbxe;
            Object obj = this.value;
            if (com_google_android_gms_internal_measurement_zzabz.zzbwy) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        com_google_android_gms_internal_measurement_zzabz.zza(obj2, com_google_android_gms_internal_measurement_zzabw);
                    }
                }
                return;
            }
            com_google_android_gms_internal_measurement_zzabz.zza(obj, com_google_android_gms_internal_measurement_zzabw);
            return;
        }
        for (zzacg com_google_android_gms_internal_measurement_zzacg : this.zzbxf) {
            com_google_android_gms_internal_measurement_zzabw.zzar(com_google_android_gms_internal_measurement_zzacg.tag);
            com_google_android_gms_internal_measurement_zzabw.zzk(com_google_android_gms_internal_measurement_zzacg.zzbrc);
        }
    }

    final void zza(zzacg com_google_android_gms_internal_measurement_zzacg) throws IOException {
        if (this.zzbxf != null) {
            this.zzbxf.add(com_google_android_gms_internal_measurement_zzacg);
            return;
        }
        Object zzb;
        if (this.value instanceof zzace) {
            byte[] bArr = com_google_android_gms_internal_measurement_zzacg.zzbrc;
            zzabv zza = zzabv.zza(bArr, 0, bArr.length);
            int zzuy = zza.zzuy();
            if (zzuy == bArr.length - zzabw.zzao(zzuy)) {
                zzb = ((zzace) this.value).zzb(zza);
            } else {
                throw zzacd.zzvh();
            }
        } else if (this.value instanceof zzace[]) {
            zzace[] com_google_android_gms_internal_measurement_zzaceArr = (zzace[]) this.zzbxe.zzi(Collections.singletonList(com_google_android_gms_internal_measurement_zzacg));
            zzace[] com_google_android_gms_internal_measurement_zzaceArr2 = (zzace[]) this.value;
            Object obj = (zzace[]) Arrays.copyOf(com_google_android_gms_internal_measurement_zzaceArr2, com_google_android_gms_internal_measurement_zzaceArr2.length + com_google_android_gms_internal_measurement_zzaceArr.length);
            System.arraycopy(com_google_android_gms_internal_measurement_zzaceArr, 0, obj, com_google_android_gms_internal_measurement_zzaceArr2.length, com_google_android_gms_internal_measurement_zzaceArr.length);
            zzb = obj;
        } else {
            zzb = this.zzbxe.zzi(Collections.singletonList(com_google_android_gms_internal_measurement_zzacg));
        }
        this.zzbxe = this.zzbxe;
        this.value = zzb;
        this.zzbxf = null;
    }

    final <T> T zzb(zzabz<?, T> com_google_android_gms_internal_measurement_zzabz___T) {
        if (this.value == null) {
            this.zzbxe = com_google_android_gms_internal_measurement_zzabz___T;
            this.value = com_google_android_gms_internal_measurement_zzabz___T.zzi(this.zzbxf);
            this.zzbxf = null;
        } else if (!this.zzbxe.equals(com_google_android_gms_internal_measurement_zzabz___T)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }
}
