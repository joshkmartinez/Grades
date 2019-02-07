package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzac;
import com.google.android.gms.internal.auth.zzae;
import com.google.android.gms.internal.auth.zzag;
import com.google.android.gms.internal.auth.zzai;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzx;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class AccountTransferClient extends GoogleApi<zzq> {
    private static final ClientKey<zzx> zzau = new ClientKey();
    private static final AbstractClientBuilder<zzx, zzq> zzav = new zzf();
    private static final Api<zzq> zzaw = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzav, zzau);

    private static abstract class zze<T> extends TaskApiCall<zzx, T> {
        private TaskCompletionSource<T> zzbh;

        private zze() {
        }

        protected /* synthetic */ void doExecute(AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
            zzx com_google_android_gms_internal_auth_zzx = (zzx) anyClient;
            this.zzbh = taskCompletionSource;
            zzd((zzac) com_google_android_gms_internal_auth_zzx.getService());
        }

        protected final void setResult(T t) {
            this.zzbh.setResult(t);
        }

        protected final void zzd(Status status) {
            AccountTransferClient.zzd(this.zzbh, status);
        }

        protected abstract void zzd(zzac com_google_android_gms_internal_auth_zzac) throws RemoteException;
    }

    private static abstract class zzf extends zze<Void> {
        zzab zzbi;

        private zzf() {
            super();
            this.zzbi = new zzn(this);
        }
    }

    private static class zzd<T> extends zzv {
        private zze<T> zzbg;

        public zzd(zze<T> com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zze_T) {
            this.zzbg = com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zze_T;
        }

        public final void onFailure(Status status) {
            this.zzbg.zzd(status);
        }
    }

    AccountTransferClient(@NonNull Activity activity) {
        super(activity, zzaw, null, new Builder().setMapper(new ApiExceptionMapper()).build());
    }

    AccountTransferClient(@NonNull Context context) {
        super(context, zzaw, null, new Builder().setMapper(new ApiExceptionMapper()).build());
    }

    private static void zzd(TaskCompletionSource taskCompletionSource, Status status) {
        taskCompletionSource.setException(new AccountTransferException(status));
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zzj(this, new zzy(str)));
    }

    public Task<Void> notifyCompletion(String str, int i) {
        Preconditions.checkNotNull(str);
        return doWrite(new zzm(this, new zzae(str, i)));
    }

    public Task<byte[]> retrieveData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zzh(this, new zzag(str)));
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        return doWrite(new zzg(this, new zzai(str, bArr)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new zzl(this, new zzak(str, pendingIntent)));
    }
}
