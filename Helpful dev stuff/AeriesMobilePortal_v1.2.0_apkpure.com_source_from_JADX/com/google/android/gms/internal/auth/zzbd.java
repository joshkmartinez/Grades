package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public final class zzbd extends zzd implements zzbc {
    zzbd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zzd(zzba com_google_android_gms_internal_auth_zzba) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) com_google_android_gms_internal_auth_zzba);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
    }

    public final void zzd(zzba com_google_android_gms_internal_auth_zzba, CredentialRequest credentialRequest) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) com_google_android_gms_internal_auth_zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) credentialRequest);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
    }

    public final void zzd(zzba com_google_android_gms_internal_auth_zzba, zzay com_google_android_gms_internal_auth_zzay) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) com_google_android_gms_internal_auth_zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) com_google_android_gms_internal_auth_zzay);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
    }

    public final void zzd(zzba com_google_android_gms_internal_auth_zzba, zzbe com_google_android_gms_internal_auth_zzbe) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzd(obtainAndWriteInterfaceToken, (IInterface) com_google_android_gms_internal_auth_zzba);
        zzf.zzd(obtainAndWriteInterfaceToken, (Parcelable) com_google_android_gms_internal_auth_zzbe);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
    }
}
