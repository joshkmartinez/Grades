package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzhj extends zzjw {
    final Context zzqx;

    @VisibleForTesting
    public zzhj(Context context) {
        Preconditions.checkNotNull(context);
        context = context.getApplicationContext();
        Preconditions.checkNotNull(context);
        this.zzqx = context;
    }
}
