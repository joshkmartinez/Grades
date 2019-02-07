package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;

final class zzeq {
    final String name;
    final long zzafr;
    final long zzafs;
    final long zzaft;
    final long zzafu;
    final Long zzafv;
    final Long zzafw;
    final Boolean zzafx;
    final String zzti;

    zzeq(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        zzeq com_google_android_gms_internal_measurement_zzeq = this;
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z = false;
        Preconditions.checkArgument(j5 >= 0);
        Preconditions.checkArgument(j6 >= 0);
        if (j7 >= 0) {
            z = true;
        }
        Preconditions.checkArgument(z);
        com_google_android_gms_internal_measurement_zzeq.zzti = str;
        com_google_android_gms_internal_measurement_zzeq.name = str2;
        com_google_android_gms_internal_measurement_zzeq.zzafr = j5;
        com_google_android_gms_internal_measurement_zzeq.zzafs = j6;
        com_google_android_gms_internal_measurement_zzeq.zzaft = j3;
        com_google_android_gms_internal_measurement_zzeq.zzafu = j7;
        com_google_android_gms_internal_measurement_zzeq.zzafv = l;
        com_google_android_gms_internal_measurement_zzeq.zzafw = l2;
        com_google_android_gms_internal_measurement_zzeq.zzafx = bool;
    }

    final zzeq zza(Long l, Long l2, Boolean bool) {
        zzeq com_google_android_gms_internal_measurement_zzeq = this;
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        return new zzeq(com_google_android_gms_internal_measurement_zzeq.zzti, com_google_android_gms_internal_measurement_zzeq.name, com_google_android_gms_internal_measurement_zzeq.zzafr, com_google_android_gms_internal_measurement_zzeq.zzafs, com_google_android_gms_internal_measurement_zzeq.zzaft, com_google_android_gms_internal_measurement_zzeq.zzafu, l, l2, bool2);
    }

    final zzeq zzac(long j) {
        return new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, j, this.zzafu, this.zzafv, this.zzafw, this.zzafx);
    }

    final zzeq zzad(long j) {
        return new zzeq(this.zzti, this.name, this.zzafr, this.zzafs, this.zzaft, j, this.zzafv, this.zzafw, this.zzafx);
    }

    final zzeq zzie() {
        String str = this.zzti;
        String str2 = this.name;
        long j = this.zzafr + 1;
        long j2 = this.zzafs + 1;
        long j3 = this.zzaft;
        long j4 = this.zzafu;
        return new zzeq(str, str2, j, j2, j3, j4, this.zzafv, this.zzafw, this.zzafx);
    }
}
