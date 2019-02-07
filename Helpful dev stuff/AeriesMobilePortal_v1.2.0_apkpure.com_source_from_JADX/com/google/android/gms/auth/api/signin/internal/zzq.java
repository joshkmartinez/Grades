package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzq {
    private static zzq zzfa;
    @VisibleForTesting
    private Storage zzfb;
    @VisibleForTesting
    private GoogleSignInAccount zzfc = this.zzfb.getSavedDefaultGoogleSignInAccount();
    @VisibleForTesting
    private GoogleSignInOptions zzfd = this.zzfb.getSavedDefaultGoogleSignInOptions();

    private zzq(Context context) {
        this.zzfb = Storage.getInstance(context);
    }

    public static synchronized zzq zze(@NonNull Context context) {
        zzq zzf;
        synchronized (zzq.class) {
            zzf = zzf(context.getApplicationContext());
        }
        return zzf;
    }

    private static synchronized zzq zzf(Context context) {
        zzq com_google_android_gms_auth_api_signin_internal_zzq;
        synchronized (zzq.class) {
            if (zzfa == null) {
                zzfa = new zzq(context);
            }
            com_google_android_gms_auth_api_signin_internal_zzq = zzfa;
        }
        return com_google_android_gms_auth_api_signin_internal_zzq;
    }

    public final synchronized void clear() {
        this.zzfb.clear();
        this.zzfc = null;
        this.zzfd = null;
    }

    public final synchronized void zzd(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.zzfb.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzfc = googleSignInAccount;
        this.zzfd = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzo() {
        return this.zzfc;
    }

    public final synchronized GoogleSignInOptions zzp() {
        return this.zzfd;
    }
}
