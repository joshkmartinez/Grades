package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzl extends zzp<Status> {
    zzl(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    protected final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    protected final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzh com_google_android_gms_auth_api_signin_internal_zzh = (zzh) anyClient;
        ((zzv) com_google_android_gms_auth_api_signin_internal_zzh.getService()).zze(new zzm(this), com_google_android_gms_auth_api_signin_internal_zzh.zzn());
    }
}
