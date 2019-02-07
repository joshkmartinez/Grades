package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzas extends zzav<Status> {
    private final /* synthetic */ Credential zzdt;

    zzas(zzao com_google_android_gms_internal_auth_zzao, GoogleApiClient googleApiClient, Credential credential) {
        this.zzdt = credential;
        super(googleApiClient);
    }

    protected final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    protected final void zzd(Context context, zzbc com_google_android_gms_internal_auth_zzbc) throws RemoteException {
        com_google_android_gms_internal_auth_zzbc.zzd(new zzau(this), new zzay(this.zzdt));
    }
}
