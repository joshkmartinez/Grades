package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

abstract class zzbm extends ApiMethodImpl<ProxyResult, zzbh> {
    public zzbm(GoogleApiClient googleApiClient) {
        super(zzf.API, googleApiClient);
    }

    protected /* synthetic */ Result createFailedResult(Status status) {
        return new zzbq(status);
    }

    protected /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        zzbh com_google_android_gms_internal_auth_zzbh = (zzbh) anyClient;
        zzd(com_google_android_gms_internal_auth_zzbh.getContext(), (zzbk) com_google_android_gms_internal_auth_zzbh.getService());
    }

    protected abstract void zzd(Context context, zzbk com_google_android_gms_internal_auth_zzbk) throws RemoteException;
}
