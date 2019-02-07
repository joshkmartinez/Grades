package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzag;

final class zzh extends zze<byte[]> {
    private final /* synthetic */ zzag zzba;

    zzh(AccountTransferClient accountTransferClient, zzag com_google_android_gms_internal_auth_zzag) {
        this.zzba = com_google_android_gms_internal_auth_zzag;
        super();
    }

    protected final void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException {
        com_google_android_gms_internal_auth_zzac.zzd(new zzi(this, this), this.zzba);
    }
}
