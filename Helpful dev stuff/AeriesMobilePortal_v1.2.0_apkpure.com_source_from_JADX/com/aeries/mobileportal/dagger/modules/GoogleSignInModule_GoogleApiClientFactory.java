package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoogleSignInModule_GoogleApiClientFactory implements Factory<GoogleApiClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final Provider<GoogleSignInOptions> gsoProvider;
    private final GoogleSignInModule module;

    public GoogleSignInModule_GoogleApiClientFactory(GoogleSignInModule googleSignInModule, Provider<Context> provider, Provider<GoogleSignInOptions> provider2) {
        this.module = googleSignInModule;
        this.contextProvider = provider;
        this.gsoProvider = provider2;
    }

    public GoogleApiClient get() {
        return (GoogleApiClient) Preconditions.checkNotNull(this.module.googleApiClient((Context) this.contextProvider.get(), (GoogleSignInOptions) this.gsoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GoogleApiClient> create(GoogleSignInModule googleSignInModule, Provider<Context> provider, Provider<GoogleSignInOptions> provider2) {
        return new GoogleSignInModule_GoogleApiClientFactory(googleSignInModule, provider, provider2);
    }
}
