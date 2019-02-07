package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_AuthErrorInteractorFactory implements Factory<AuthErrorInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final InteractorModule module;
    private final Provider<TokenRepository> tokenRepositoryProvider;

    public InteractorModule_AuthErrorInteractorFactory(InteractorModule interactorModule, Provider<TokenRepository> provider) {
        this.module = interactorModule;
        this.tokenRepositoryProvider = provider;
    }

    public AuthErrorInteractor get() {
        return (AuthErrorInteractor) Preconditions.checkNotNull(this.module.authErrorInteractor((TokenRepository) this.tokenRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AuthErrorInteractor> create(InteractorModule interactorModule, Provider<TokenRepository> provider) {
        return new InteractorModule_AuthErrorInteractorFactory(interactorModule, provider);
    }
}
