package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;

final class zzm extends zzf {
    private final /* synthetic */ zzae zzbf;

    zzm(AccountTransferClient accountTransferClient, zzae com_google_android_gms_internal_auth_zzae) {
        this.zzbf = com_google_android_gms_internal_auth_zzae;
        super();
    }

    protected final void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException {
        com_google_android_gms_internal_auth_zzac.zzd(this.zzbi, this.zzbf);
    }
}
