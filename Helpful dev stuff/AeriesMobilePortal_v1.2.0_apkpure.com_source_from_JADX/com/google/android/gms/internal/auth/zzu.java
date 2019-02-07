package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.account.zzf;
import com.google.android.gms.auth.account.zzg;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import org.jetbrains.anko.DimensionsKt;

public final class zzu extends GmsClient<zzf> {
    public zzu(Context context, Looper looper, ClientSettings clientSettings, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, DimensionsKt.LDPI, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        return zzg.zzf(iBinder);
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.auth.account.IWorkAccountService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.auth.account.workaccount.START";
    }
}
