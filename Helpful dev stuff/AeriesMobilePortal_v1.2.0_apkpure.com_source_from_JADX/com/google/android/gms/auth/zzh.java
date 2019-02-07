package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import java.io.IOException;

final class zzh implements zzm<TokenData> {
    private final /* synthetic */ Bundle val$options;
    private final /* synthetic */ Account zzr;
    private final /* synthetic */ String zzs;

    zzh(Account account, String str, Bundle bundle) {
        this.zzr = account;
        this.zzs = str;
        this.val$options = bundle;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzg.zzd(zzi.zzd(iBinder).zzd(this.zzr, this.zzs, this.val$options));
        TokenData zzd = TokenData.zzd(bundle, "tokenDetails");
        if (zzd != null) {
            return zzd;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        int i = 0;
        if (zzbr.zzd(zzh)) {
            Logger zzd2 = zzg.zzq;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzh);
            StringBuilder stringBuilder = new StringBuilder(31 + String.valueOf(valueOf).length());
            stringBuilder.append("isUserRecoverableError status: ");
            stringBuilder.append(valueOf);
            objArr[0] = stringBuilder.toString();
            zzd2.m53w("GoogleAuthUtil", objArr);
            throw new UserRecoverableAuthException(string, intent);
        }
        if (zzbr.NETWORK_ERROR.equals(zzh) || zzbr.SERVICE_UNAVAILABLE.equals(zzh)) {
            i = 1;
        }
        if (i != 0) {
            throw new IOException(string);
        }
        throw new GoogleAuthException(string);
    }
}
