package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzy;

final class zzj extends zze<DeviceMetaData> {
    private final /* synthetic */ zzy zzbc;

    zzj(AccountTransferClient accountTransferClient, zzy com_google_android_gms_internal_auth_zzy) {
        this.zzbc = com_google_android_gms_internal_auth_zzy;
        super();
    }

    protected final void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException {
        com_google_android_gms_internal_auth_zzac.zzd(new zzk(this, this), this.zzbc);
    }
}
