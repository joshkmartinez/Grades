package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

final class zzo extends ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ Account zzr;

    zzo(zzk com_google_android_gms_internal_auth_zzk, Api api, GoogleApiClient googleApiClient, Account account) {
        this.zzr = account;
        super(api, googleApiClient);
    }

    protected final Result createFailedResult(Status status) {
        return new zzt(status);
    }

    protected final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzf) ((zzu) anyClient).getService()).zzd(new zzp(this), this.zzr);
    }
}
