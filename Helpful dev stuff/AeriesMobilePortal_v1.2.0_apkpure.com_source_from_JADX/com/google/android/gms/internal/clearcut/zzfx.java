package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzfx implements Cloneable {
    private Object value;
    private zzfv<?, ?> zzrp;
    private List<Object> zzrq = new ArrayList();

    zzfx() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzen()];
        zza(zzfs.zzg(bArr));
        return bArr;
    }

    private final zzfx zzeq() {
        zzfx com_google_android_gms_internal_clearcut_zzfx = new zzfx();
        try {
            com_google_android_gms_internal_clearcut_zzfx.zzrp = this.zzrp;
            if (this.zzrq == null) {
                com_google_android_gms_internal_clearcut_zzfx.zzrq = null;
            } else {
                com_google_android_gms_internal_clearcut_zzfx.zzrq.addAll(this.zzrq);
            }
            if (this.value != null) {
                Object obj;
                if (this.value instanceof zzfz) {
                    obj = (zzfz) ((zzfz) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    obj = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    Object obj2;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        obj2 = new byte[bArr.length][];
                        com_google_android_gms_internal_clearcut_zzfx.value = obj2;
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
                    } else if (this.value instanceof zzfz[]) {
                        zzfz[] com_google_android_gms_internal_clearcut_zzfzArr = (zzfz[]) this.value;
                        obj2 = new zzfz[com_google_android_gms_internal_clearcut_zzfzArr.length];
                        com_google_android_gms_internal_clearcut_zzfx.value = obj2;
                        while (i < com_google_android_gms_internal_clearcut_zzfzArr.length) {
                            obj2[i] = (zzfz) com_google_android_gms_internal_clearcut_zzfzArr[i].clone();
                            i++;
                        }
                    }
                }
                com_google_android_gms_internal_clearcut_zzfx.value = obj;
            }
            return com_google_android_gms_internal_clearcut_zzfx;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzeq();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx com_google_android_gms_internal_clearcut_zzfx = (zzfx) obj;
        if (this.value != null && com_google_android_gms_internal_clearcut_zzfx.value != null) {
            return this.zzrp != com_google_android_gms_internal_clearcut_zzfx.zzrp ? false : !this.zzrp.zzrk.isArray() ? this.value.equals(com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) com_google_android_gms_internal_clearcut_zzfx.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) com_google_android_gms_internal_clearcut_zzfx.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) com_google_android_gms_internal_clearcut_zzfx.value);
        } else {
            if (this.zzrq != null && com_google_android_gms_internal_clearcut_zzfx.zzrq != null) {
                return this.zzrq.equals(com_google_android_gms_internal_clearcut_zzfx.zzrq);
            }
            try {
                return Arrays.equals(toByteArray(), com_google_android_gms_internal_clearcut_zzfx.toByteArray());
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

    final void zza(zzfs com_google_android_gms_internal_clearcut_zzfs) throws IOException {
        if (this.value == null) {
            Iterator it = this.zzrq.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    final int zzen() {
        if (this.value == null) {
            Iterator it = this.zzrq.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }
}
