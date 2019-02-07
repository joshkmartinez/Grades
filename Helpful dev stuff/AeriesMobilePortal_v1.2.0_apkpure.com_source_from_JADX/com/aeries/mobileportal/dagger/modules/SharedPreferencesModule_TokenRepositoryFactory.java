package com.aeries.mobileportal.dagger.modules;

import android.content.SharedPreferences;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SharedPreferencesModule_TokenRepositoryFactory implements Factory<TokenRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SharedPreferencesModule module;
    private final Provider<SharedPreferences> userPreferencesProvider;

    public SharedPreferencesModule_TokenRepositoryFactory(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        this.module = sharedPreferencesModule;
        this.userPreferencesProvider = provider;
    }

    public TokenRepository get() {
        return (TokenRepository) Preconditions.checkNotNull(this.module.tokenRepository((SharedPreferences) this.userPreferencesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<TokenRepository> create(SharedPreferencesModule sharedPreferencesModule, Provider<SharedPreferences> provider) {
        return new SharedPreferencesModule_TokenRepositoryFactory(sharedPreferencesModule, provider);
    }
}
