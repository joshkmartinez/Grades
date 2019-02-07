package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;

final class zzn extends zzq {
    private final /* synthetic */ zzm zzah;

    zzn(zzm com_google_android_gms_internal_auth_zzm) {
        this.zzah = com_google_android_gms_internal_auth_zzm;
    }

    public final void zzf(Account account) {
        this.zzah.setResult(new zzr(account != null ? Status.RESULT_SUCCESS : zzk.zzaf, account));
    }
}
