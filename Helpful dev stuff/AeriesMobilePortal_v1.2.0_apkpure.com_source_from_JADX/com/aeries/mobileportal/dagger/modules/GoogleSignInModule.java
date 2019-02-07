package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/GoogleSignInModule;", "", "()V", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "context", "Landroid/content/Context;", "gso", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInOptions", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: GoogleSignInModule.kt */
public final class GoogleSignInModule {
    @NotNull
    @PSPApplicationScope
    @Provides
    public final GoogleSignInOptions googleSignInOptions(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        context = new Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(context.getString(C0316R.string.default_web_client_id)).requestEmail().build();
        Intrinsics.checkExpressionValueIsNotNull(context, "GoogleSignInOptions.Buil…                 .build()");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final GoogleSignInClient googleSignInClient(@NotNull Context context, @NotNull GoogleSignInOptions googleSignInOptions) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(googleSignInOptions, "gso");
        context = GoogleSignIn.getClient(context, googleSignInOptions);
        Intrinsics.checkExpressionValueIsNotNull(context, "GoogleSignIn.getClient(context, gso)");
        return context;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final GoogleApiClient googleApiClient(@NotNull Context context, @NotNull GoogleSignInOptions googleSignInOptions) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(googleSignInOptions, "gso");
        context = new GoogleApiClient.Builder(context).addOnConnectionFailedListener(new GoogleSignInModule$googleApiClient$1(context)).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        Intrinsics.checkExpressionValueIsNotNull(context, "GoogleApiClient.Builder(…                 .build()");
        return context;
    }
}
