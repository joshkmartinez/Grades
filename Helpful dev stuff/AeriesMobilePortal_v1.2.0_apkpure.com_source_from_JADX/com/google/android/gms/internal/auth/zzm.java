package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

final class zzm extends ApiMethodImpl<AddAccountResult, zzu> {
    private final /* synthetic */ String zzt;

    zzm(zzk com_google_android_gms_internal_auth_zzk, Api api, GoogleApiClient googleApiClient, String str) {
        this.zzt = str;
        super(api, googleApiClient);
    }

    protected final /* synthetic */ Result createFailedResult(Status status) {
        return new zzr(status, null);
    }

    protected final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzf) ((zzu) anyClient).getService()).zzd(new zzn(this), this.zzt);
    }
}
