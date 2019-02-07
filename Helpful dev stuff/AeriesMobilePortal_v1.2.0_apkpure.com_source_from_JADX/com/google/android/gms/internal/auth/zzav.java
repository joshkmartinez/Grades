package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzav<R extends Result> extends ApiMethodImpl<R, zzax> {
    zzav(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    protected /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzax com_google_android_gms_internal_auth_zzax = (zzax) anyClient;
        zzd(com_google_android_gms_internal_auth_zzax.getContext(), (zzbc) com_google_android_gms_internal_auth_zzax.getService());
    }

    protected abstract void zzd(Context context, zzbc com_google_android_gms_internal_auth_zzbc) throws DeadObjectException, RemoteException;
}
