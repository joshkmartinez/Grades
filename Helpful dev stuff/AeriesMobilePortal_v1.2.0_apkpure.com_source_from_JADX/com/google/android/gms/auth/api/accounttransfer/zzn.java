package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.auth.zzv;

final class zzn extends zzv {
    private final /* synthetic */ zzf zzbj;

    zzn(zzf com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zzf) {
        this.zzbj = com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zzf;
    }

    public final void onFailure(Status status) {
        this.zzbj.zzd(status);
    }

    public final void zzi() {
        this.zzbj.setResult(null);
    }
}
