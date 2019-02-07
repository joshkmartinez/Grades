package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.util.HashSet;

public final class zzi {
    private static Logger zzer = new Logger("GoogleSignInCommon", new String[0]);

    @Nullable
    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount")) {
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
                Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
                if (googleSignInAccount != null) {
                    status = Status.RESULT_SUCCESS;
                }
                return new GoogleSignInResult(googleSignInAccount, status);
            }
        }
        return null;
    }

    public static Intent zzd(Context context, GoogleSignInOptions googleSignInOptions) {
        zzer.m45d("getSignInIntent()", new Object[0]);
        Parcelable signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static OptionalPendingResult<GoogleSignInResult> zzd(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions, boolean z) {
        Result googleSignInResult;
        zzer.m45d("silentSignIn()", new Object[0]);
        zzer.m45d("getEligibleSavedSignInResult()", new Object[0]);
        Preconditions.checkNotNull(googleSignInOptions);
        GoogleSignInOptions zzp = zzq.zze(context).zzp();
        if (zzp != null) {
            Account account = zzp.getAccount();
            Account account2 = googleSignInOptions.getAccount();
            boolean equals = account == null ? account2 == null : account.equals(account2);
            if (equals && !googleSignInOptions.isServerAuthCodeRequested() && ((!googleSignInOptions.isIdTokenRequested() || (zzp.isIdTokenRequested() && googleSignInOptions.getServerClientId().equals(zzp.getServerClientId()))) && new HashSet(zzp.getScopes()).containsAll(new HashSet(googleSignInOptions.getScopes())))) {
                GoogleSignInAccount zzo = zzq.zze(context).zzo();
                if (!(zzo == null || zzo.isExpired())) {
                    googleSignInResult = new GoogleSignInResult(zzo, Status.RESULT_SUCCESS);
                    if (googleSignInResult != null) {
                        zzer.m45d("Eligible saved sign in result found", new Object[0]);
                        return PendingResults.immediatePendingResult(googleSignInResult, googleApiClient);
                    } else if (z) {
                        return PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), googleApiClient);
                    } else {
                        zzer.m45d("trySilentSignIn()", new Object[0]);
                        return new OptionalPendingResultImpl(googleApiClient.enqueue(new zzj(googleApiClient, context, googleSignInOptions)));
                    }
                }
            }
        }
        googleSignInResult = null;
        if (googleSignInResult != null) {
            zzer.m45d("Eligible saved sign in result found", new Object[0]);
            return PendingResults.immediatePendingResult(googleSignInResult, googleApiClient);
        } else if (z) {
            return PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), googleApiClient);
        } else {
            zzer.m45d("trySilentSignIn()", new Object[0]);
            return new OptionalPendingResultImpl(googleApiClient.enqueue(new zzj(googleApiClient, context, googleSignInOptions)));
        }
    }

    public static PendingResult<Status> zzd(GoogleApiClient googleApiClient, Context context, boolean z) {
        zzer.m45d("Signing out", new Object[0]);
        zzd(context);
        return z ? PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient) : googleApiClient.execute(new zzl(googleApiClient));
    }

    private static void zzd(Context context) {
        zzq.zze(context).clear();
        for (GoogleApiClient maybeSignOut : GoogleApiClient.getAllClients()) {
            maybeSignOut.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
    }

    public static Intent zze(Context context, GoogleSignInOptions googleSignInOptions) {
        zzer.m45d("getFallbackSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return zzd;
    }

    public static PendingResult<Status> zze(GoogleApiClient googleApiClient, Context context, boolean z) {
        zzer.m45d("Revoking access", new Object[0]);
        String savedRefreshToken = Storage.getInstance(context).getSavedRefreshToken();
        zzd(context);
        return z ? zze.zzg(savedRefreshToken) : googleApiClient.execute(new zzn(googleApiClient));
    }

    public static Intent zzf(Context context, GoogleSignInOptions googleSignInOptions) {
        zzer.m45d("getNoImplementationSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.NO_IMPL");
        return zzd;
    }
}
