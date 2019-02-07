package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;

final class zzl extends ApiMethodImpl<Result, zzu> {
    private final /* synthetic */ boolean zzag;

    zzl(zzk com_google_android_gms_internal_auth_zzk, Api api, GoogleApiClient googleApiClient, boolean z) {
        this.zzag = z;
        super(api, googleApiClient);
    }

    protected final Result createFailedResult(Status status) {
        return new zzs(status);
    }

    protected final /* synthetic */ void doExecute(AnyClient anyClient) throws RemoteException {
        ((zzf) ((zzu) anyClient).getService()).zze(this.zzag);
        setResult(new zzs(Status.RESULT_SUCCESS));
    }
}
