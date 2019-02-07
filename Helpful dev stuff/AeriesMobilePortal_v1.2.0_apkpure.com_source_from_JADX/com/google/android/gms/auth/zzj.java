package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzi;
import java.io.IOException;
import java.util.List;

final class zzj implements zzm<List<AccountChangeEvent>> {
    private final /* synthetic */ String zzu;
    private final /* synthetic */ int zzv;

    zzj(String str, int i) {
        this.zzu = str;
        this.zzv = i;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        return ((AccountChangeEventsResponse) zzg.zzd(zzi.zzd(iBinder).zzd(new AccountChangeEventsRequest().setAccountName(this.zzu).setEventIndex(this.zzv)))).getEvents();
    }
}
