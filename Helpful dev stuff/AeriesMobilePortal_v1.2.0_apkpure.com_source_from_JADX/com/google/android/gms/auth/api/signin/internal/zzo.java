package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzo extends zzd {
    private final /* synthetic */ zzn zzez;

    zzo(zzn com_google_android_gms_auth_api_signin_internal_zzn) {
        this.zzez = com_google_android_gms_auth_api_signin_internal_zzn;
    }

    public final void zzh(Status status) throws RemoteException {
        this.zzez.setResult(status);
    }
}
