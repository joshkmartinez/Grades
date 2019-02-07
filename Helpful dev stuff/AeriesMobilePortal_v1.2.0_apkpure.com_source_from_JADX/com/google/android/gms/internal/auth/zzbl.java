package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

public final class zzbl extends zzd implements zzbk {
    zzbl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zzd(zzbi com_google_android_gms_internal_auth_zzbi, ProxyRequest proxyRequest) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) com_google_android_gms_internal_auth_zzbi);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) proxyRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
    }
}
