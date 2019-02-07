package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zzd zzef = new zzd();
    @VisibleForTesting
    private static int zzeg = zze.zzei;

    @VisibleForTesting
    enum zze {
        public static final int zzei = 1;
        public static final int zzej = 2;
        public static final int zzek = 3;
        public static final int zzel = 4;
        private static final /* synthetic */ int[] zzem = new int[]{zzei, zzej, zzek, zzel};

        public static int[] m33xd6228de2() {
            return (int[]) zzem.clone();
        }
    }

    private static class zzd implements ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private zzd() {
        }

        public final /* synthetic */ Object convert(Result result) {
            return ((GoogleSignInResult) result).getSignInAccount();
        }
    }

    GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new ApiExceptionMapper());
    }

    GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new ApiExceptionMapper());
    }

    private final synchronized int zzl() {
        if (zzeg == zze.zzei) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            int i = isGooglePlayServicesAvailable == 0 ? zze.zzel : (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) ? zze.zzej : zze.zzek;
            zzeg = i;
        }
        return zzeg;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        switch (zzd.zzeh[zzl() - 1]) {
            case 1:
                return zzi.zze(applicationContext, (GoogleSignInOptions) getApiOptions());
            case 2:
                return zzi.zzd(applicationContext, (GoogleSignInOptions) getApiOptions());
            default:
                return zzi.zzf(applicationContext, (GoogleSignInOptions) getApiOptions());
        }
    }

    public Task<Void> revokeAccess() {
        return PendingResultUtil.toVoidTask(zzi.zze(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
    }

    public Task<Void> signOut() {
        return PendingResultUtil.toVoidTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return PendingResultUtil.toTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), zzl() == zze.zzek), zzef);
    }
}
