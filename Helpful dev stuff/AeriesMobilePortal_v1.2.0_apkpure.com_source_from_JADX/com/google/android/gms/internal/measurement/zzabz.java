package com.google.android.gms.internal.measurement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzabz<M extends zzaby<M>, T> {
    public final int tag;
    private final int type;
    protected final Class<T> zzbwx;
    protected final boolean zzbwy;
    private final zzzq<?, ?> zzbwz;

    private zzabz(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, null, 810, false);
    }

    private zzabz(int i, Class<T> cls, zzzq<?, ?> com_google_android_gms_internal_measurement_zzzq___, int i2, boolean z) {
        this.type = i;
        this.zzbwx = cls;
        this.tag = i2;
        this.zzbwy = false;
        this.zzbwz = null;
    }

    public static <M extends zzaby<M>, T extends zzace> zzabz<M, T> zza(int i, Class<T> cls, long j) {
        return new zzabz(11, cls, 810, false);
    }

    private final Object zzf(zzabv com_google_android_gms_internal_measurement_zzabv) {
        String valueOf;
        StringBuilder stringBuilder;
        Class componentType = this.zzbwy ? this.zzbwx.getComponentType() : this.zzbwx;
        try {
            zzace com_google_android_gms_internal_measurement_zzace;
            switch (this.type) {
                case 10:
                    com_google_android_gms_internal_measurement_zzace = (zzace) componentType.newInstance();
                    com_google_android_gms_internal_measurement_zzabv.zza(com_google_android_gms_internal_measurement_zzace, this.tag >>> 3);
                    return com_google_android_gms_internal_measurement_zzace;
                case 11:
                    com_google_android_gms_internal_measurement_zzace = (zzace) componentType.newInstance();
                    com_google_android_gms_internal_measurement_zzabv.zza(com_google_android_gms_internal_measurement_zzace);
                    return com_google_android_gms_internal_measurement_zzace;
                default:
                    int i = this.type;
                    StringBuilder stringBuilder2 = new StringBuilder(24);
                    stringBuilder2.append("Unknown type ");
                    stringBuilder2.append(i);
                    throw new IllegalArgumentException(stringBuilder2.toString());
            }
        } catch (Throwable e) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(33 + String.valueOf(valueOf).length());
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        } catch (Throwable e2) {
            valueOf = String.valueOf(componentType);
            stringBuilder = new StringBuilder(33 + String.valueOf(valueOf).length());
            stringBuilder.append("Error creating instance of class ");
            stringBuilder.append(valueOf);
            throw new IllegalArgumentException(stringBuilder.toString(), e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzabz)) {
            return false;
        }
        zzabz com_google_android_gms_internal_measurement_zzabz = (zzabz) obj;
        return this.type == com_google_android_gms_internal_measurement_zzabz.type && this.zzbwx == com_google_android_gms_internal_measurement_zzabz.zzbwx && this.tag == com_google_android_gms_internal_measurement_zzabz.tag && this.zzbwy == com_google_android_gms_internal_measurement_zzabz.zzbwy;
    }

    public final int hashCode() {
        return ((((((1147 + this.type) * 31) + this.zzbwx.hashCode()) * 31) + this.tag) * 31) + this.zzbwy;
    }

    protected final void zza(Object obj, zzabw com_google_android_gms_internal_measurement_zzabw) {
        try {
            com_google_android_gms_internal_measurement_zzabw.zzar(this.tag);
            switch (this.type) {
                case 10:
                    int i = this.tag >>> 3;
                    ((zzace) obj).zza(com_google_android_gms_internal_measurement_zzabw);
                    com_google_android_gms_internal_measurement_zzabw.zzg(i, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_measurement_zzabw.zzb((zzace) obj);
                    return;
                default:
                    int i2 = this.type;
                    StringBuilder stringBuilder = new StringBuilder(24);
                    stringBuilder.append("Unknown type ");
                    stringBuilder.append(i2);
                    throw new IllegalArgumentException(stringBuilder.toString());
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    final T zzi(List<zzacg> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbwy) {
            List arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzacg com_google_android_gms_internal_measurement_zzacg = (zzacg) list.get(i2);
                if (com_google_android_gms_internal_measurement_zzacg.zzbrc.length != 0) {
                    arrayList.add(zzf(zzabv.zzi(com_google_android_gms_internal_measurement_zzacg.zzbrc)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.zzbwx.cast(Array.newInstance(this.zzbwx.getComponentType(), size));
            while (i < size) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzbwx.cast(zzf(zzabv.zzi(((zzacg) list.get(list.size() - 1)).zzbrc)));
        }
    }

    protected final int zzv(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzabw.zzaq(i) << 1) + ((zzace) obj).zzvm();
            case 11:
                return zzabw.zzb(i, (zzace) obj);
            default:
                i = this.type;
                StringBuilder stringBuilder = new StringBuilder(24);
                stringBuilder.append("Unknown type ");
                stringBuilder.append(i);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
