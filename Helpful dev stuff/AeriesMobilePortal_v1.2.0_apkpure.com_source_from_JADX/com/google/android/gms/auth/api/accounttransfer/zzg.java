package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzai;

final class zzg extends zzf {
    private final /* synthetic */ zzai zzaz;

    zzg(AccountTransferClient accountTransferClient, zzai com_google_android_gms_internal_auth_zzai) {
        this.zzaz = com_google_android_gms_internal_auth_zzai;
        super();
    }

    protected final void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException {
        com_google_android_gms_internal_auth_zzac.zzd(this.zzbi, this.zzaz);
    }
}
