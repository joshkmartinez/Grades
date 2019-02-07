package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbo extends zzbm {
    private final /* synthetic */ ProxyRequest zzec;

    zzbo(zzbn com_google_android_gms_internal_auth_zzbn, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        this.zzec = proxyRequest;
        super(googleApiClient);
    }

    protected final void zzd(Context context, zzbk com_google_android_gms_internal_auth_zzbk) throws RemoteException {
        com_google_android_gms_internal_auth_zzbk.zzd(new zzbp(this), this.zzec);
    }
}
