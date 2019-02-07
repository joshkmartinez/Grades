package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.auth.zzf;

public abstract class zze extends com.google.android.gms.internal.auth.zze implements zzd {
    public zze() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzf((Account) zzf.zzd(parcel, Account.CREATOR));
                break;
            case 2:
                zzd(zzf.zzd(parcel));
                break;
            default:
                return false;
        }
        return true;
    }
}
