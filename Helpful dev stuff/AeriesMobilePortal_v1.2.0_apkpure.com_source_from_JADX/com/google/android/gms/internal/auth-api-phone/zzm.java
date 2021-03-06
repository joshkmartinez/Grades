package com.google.android.gms.internal.auth-api-phone;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzm extends TaskApiCall<zzi, Void> {
    private TaskCompletionSource<Void> zzf;

    private zzm() {
    }

    protected /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzi com_google_android_gms_internal_auth-api-phone_zzi = (zzi) anyClient;
        this.zzf = taskCompletionSource;
        zza((zze) com_google_android_gms_internal_auth-api-phone_zzi.getService());
    }

    protected abstract void zza(zze com_google_android_gms_internal_auth-api-phone_zze) throws RemoteException;

    protected final void zzb(Status status) {
        TaskUtil.setResultOrApiException(status, this.zzf);
    }
}
