package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

final class zzi implements zzm<Void> {
    private final /* synthetic */ Bundle val$extras;
    private final /* synthetic */ String zzt;

    zzi(String str, Bundle bundle) {
        this.zzt = str;
        this.val$extras = bundle;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzg.zzd(com.google.android.gms.internal.auth.zzi.zzd(iBinder).zzd(this.zzt, this.val$extras));
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
