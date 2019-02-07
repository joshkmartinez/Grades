package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.auth.api.zzh;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzbh extends GmsClient<zzbk> {
    private final Bundle zzcf;

    public zzbh(Context context, Looper looper, ClientSettings clientSettings, zzh com_google_android_gms_auth_api_zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, clientSettings, connectionCallbacks, onConnectionFailedListener);
        if (com_google_android_gms_auth_api_zzh == null) {
            this.zzcf = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzbk ? (zzbk) queryLocalInterface : new zzbl(iBinder);
    }

    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.zzcf;
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean requiresSignIn() {
        ClientSettings clientSettings = getClientSettings();
        return (TextUtils.isEmpty(clientSettings.getAccountName()) || clientSettings.getApplicableScopes(zzf.API).isEmpty()) ? false : true;
    }
}
