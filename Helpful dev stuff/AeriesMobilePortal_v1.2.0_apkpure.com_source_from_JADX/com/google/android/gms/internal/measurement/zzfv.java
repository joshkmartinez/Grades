package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import kotlin.jvm.internal.LongCompanionObject;

public final class zzfv {
    private final long zzabj;
    private final /* synthetic */ zzfr zzakq;
    @VisibleForTesting
    private final String zzaks;
    private final String zzakt;
    private final String zzaku;

    private zzfv(zzfr com_google_android_gms_internal_measurement_zzfr, String str, long j) {
        this.zzakq = com_google_android_gms_internal_measurement_zzfr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkArgument(j > 0);
        this.zzaks = String.valueOf(str).concat(":start");
        this.zzakt = String.valueOf(str).concat(":count");
        this.zzaku = String.valueOf(str).concat(":value");
        this.zzabj = j;
    }

    @WorkerThread
    private final void zzfh() {
        this.zzakq.zzab();
        long currentTimeMillis = this.zzakq.zzbt().currentTimeMillis();
        Editor edit = this.zzakq.zziy().edit();
        edit.remove(this.zzakt);
        edit.remove(this.zzaku);
        edit.putLong(this.zzaks, currentTimeMillis);
        edit.apply();
    }

    @WorkerThread
    private final long zzfj() {
        return this.zzakq.zziy().getLong(this.zzaks, 0);
    }

    @WorkerThread
    public final void zzc(String str, long j) {
        this.zzakq.zzab();
        if (zzfj() == 0) {
            zzfh();
        }
        if (str == null) {
            str = "";
        }
        j = this.zzakq.zziy().getLong(this.zzakt, 0);
        if (j <= 0) {
            Editor edit = this.zzakq.zziy().edit();
            edit.putString(this.zzaku, str);
            edit.putLong(this.zzakt, 1);
            edit.apply();
            return;
        }
        long j2 = j + 1;
        Object obj = (this.zzakq.zzgb().zzlc().nextLong() & LongCompanionObject.MAX_VALUE) < LongCompanionObject.MAX_VALUE / j2 ? 1 : null;
        Editor edit2 = this.zzakq.zziy().edit();
        if (obj != null) {
            edit2.putString(this.zzaku, str);
        }
        edit2.putLong(this.zzakt, j2);
        edit2.apply();
    }

    @WorkerThread
    public final Pair<String, Long> zzfi() {
        this.zzakq.zzab();
        this.zzakq.zzab();
        long zzfj = zzfj();
        if (zzfj == 0) {
            zzfh();
            zzfj = 0;
        } else {
            zzfj = Math.abs(zzfj - this.zzakq.zzbt().currentTimeMillis());
        }
        if (zzfj < this.zzabj) {
            return null;
        }
        if (zzfj > (this.zzabj << 1)) {
            zzfh();
            return null;
        }
        String string = this.zzakq.zziy().getString(this.zzaku, null);
        long j = this.zzakq.zziy().getLong(this.zzakt, 0);
        zzfh();
        if (string != null) {
            if (j > 0) {
                return new Pair(string, Long.valueOf(j));
            }
        }
        return zzfr.zzajs;
    }
}
