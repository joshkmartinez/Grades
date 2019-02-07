package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class Dependency {
    private final Class<?> zzam;
    private final int zzan;
    private final int zzao;

    private Dependency(Class<?> cls, int i, int i2) {
        this.zzam = (Class) zzk.zza(cls, "Null dependency interface.");
        this.zzan = i;
        this.zzao = i2;
    }

    @KeepForSdk
    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    @KeepForSdk
    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    @KeepForSdk
    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    @KeepForSdk
    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Dependency) {
            Dependency dependency = (Dependency) obj;
            if (this.zzam == dependency.zzam && this.zzan == dependency.zzan && this.zzao == dependency.zzao) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzam.hashCode() ^ 1000003) * 1000003) ^ this.zzan) * 1000003) ^ this.zzao;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dependency{interface=");
        stringBuilder.append(this.zzam);
        stringBuilder.append(", required=");
        boolean z = false;
        stringBuilder.append(this.zzan == 1);
        stringBuilder.append(", direct=");
        if (this.zzao == 0) {
            z = true;
        }
        stringBuilder.append(z);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final Class<?> zzn() {
        return this.zzam;
    }

    public final boolean zzo() {
        return this.zzan == 1;
    }

    public final boolean zzp() {
        return this.zzao == 0;
    }
}
