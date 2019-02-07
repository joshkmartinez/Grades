package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzi;
import java.io.IOException;

final class zzk implements zzm<Bundle> {
    private final /* synthetic */ Account zzr;

    zzk(Account account) {
        this.zzr = account;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        return (Bundle) zzg.zzd(zzi.zzd(iBinder).zzd(this.zzr));
    }
}
