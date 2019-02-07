package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoogleSignInModule_GoogleSignInClientFactory implements Factory<GoogleSignInClient> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final Provider<GoogleSignInOptions> gsoProvider;
    private final GoogleSignInModule module;

    public GoogleSignInModule_GoogleSignInClientFactory(GoogleSignInModule googleSignInModule, Provider<Context> provider, Provider<GoogleSignInOptions> provider2) {
        this.module = googleSignInModule;
        this.contextProvider = provider;
        this.gsoProvider = provider2;
    }

    public GoogleSignInClient get() {
        return (GoogleSignInClient) Preconditions.checkNotNull(this.module.googleSignInClient((Context) this.contextProvider.get(), (GoogleSignInOptions) this.gsoProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GoogleSignInClient> create(GoogleSignInModule googleSignInModule, Provider<Context> provider, Provider<GoogleSignInOptions> provider2) {
        return new GoogleSignInModule_GoogleSignInClientFactory(googleSignInModule, provider, provider2);
    }
}
