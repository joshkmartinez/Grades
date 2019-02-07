package com.google.android.gms.stats;

import com.google.android.gms.stats.WakeLock.Configuration;
import kotlin.jvm.internal.LongCompanionObject;

final class zza implements Configuration {
    zza() {
    }

    public final long getMaximumTimeout(String str, String str2) {
        return LongCompanionObject.MAX_VALUE;
    }

    public final boolean isWorkChainsEnabled() {
        return false;
    }
}
