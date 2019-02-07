package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzbr;
import com.google.android.gms.internal.auth.zzi;
import java.io.IOException;

final class zzl implements zzm<Boolean> {
    private final /* synthetic */ String zzw;

    zzl(String str) {
        this.zzw = str;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzg.zzd(zzi.zzd(iBinder).zzd(this.zzw));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzbr zzh = zzbr.zzh(string);
        if (zzbr.SUCCESS.equals(zzh)) {
            return Boolean.valueOf(true);
        }
        if (zzbr.zzd(zzh)) {
            Logger zzd = zzg.zzq;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzh);
            StringBuilder stringBuilder = new StringBuilder(31 + String.valueOf(valueOf).length());
            stringBuilder.append("isUserRecoverableError status: ");
            stringBuilder.append(valueOf);
            objArr[0] = stringBuilder.toString();
            zzd.m53w("GoogleAuthUtil", objArr);
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
