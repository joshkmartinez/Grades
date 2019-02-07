package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class GoogleSignInModule_GoogleSignInOptionsFactory implements Factory<GoogleSignInOptions> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final GoogleSignInModule module;

    public GoogleSignInModule_GoogleSignInOptionsFactory(GoogleSignInModule googleSignInModule, Provider<Context> provider) {
        this.module = googleSignInModule;
        this.contextProvider = provider;
    }

    public GoogleSignInOptions get() {
        return (GoogleSignInOptions) Preconditions.checkNotNull(this.module.googleSignInOptions((Context) this.contextProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<GoogleSignInOptions> create(GoogleSignInModule googleSignInModule, Provider<Context> provider) {
        return new GoogleSignInModule_GoogleSignInOptionsFactory(googleSignInModule, provider);
    }
}
