package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzak;

final class zzl extends zzf {
    private final /* synthetic */ zzak zzbe;

    zzl(AccountTransferClient accountTransferClient, zzak com_google_android_gms_internal_auth_zzak) {
        this.zzbe = com_google_android_gms_internal_auth_zzak;
        super();
    }

    protected final void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException {
        com_google_android_gms_internal_auth_zzac.zzd(this.zzbi, this.zzbe);
    }
}
