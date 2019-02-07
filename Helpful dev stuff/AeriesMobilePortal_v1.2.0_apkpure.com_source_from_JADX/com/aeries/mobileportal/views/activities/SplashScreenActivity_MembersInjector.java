package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.splashscreen.SplashScreenPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SplashScreenActivity_MembersInjector implements MembersInjector<SplashScreenActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ConfigurationRepository> configurationsRepoProvider;
    private final Provider<NetworkRepo> networkRepoProvider;
    private final Provider<SplashScreenPresenter> presenterProvider;
    private final Provider<TokenRepository> tokenRepoProvider;

    public SplashScreenActivity_MembersInjector(Provider<TokenRepository> provider, Provider<SplashScreenPresenter> provider2, Provider<NetworkRepo> provider3, Provider<ConfigurationRepository> provider4) {
        this.tokenRepoProvider = provider;
        this.presenterProvider = provider2;
        this.networkRepoProvider = provider3;
        this.configurationsRepoProvider = provider4;
    }

    public static MembersInjector<SplashScreenActivity> create(Provider<TokenRepository> provider, Provider<SplashScreenPresenter> provider2, Provider<NetworkRepo> provider3, Provider<ConfigurationRepository> provider4) {
        return new SplashScreenActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(SplashScreenActivity splashScreenActivity) {
        if (splashScreenActivity != null) {
            splashScreenActivity.tokenRepo = (TokenRepository) this.tokenRepoProvider.get();
            splashScreenActivity.presenter = (SplashScreenPresenter) this.presenterProvider.get();
            splashScreenActivity.networkRepo = (NetworkRepo) this.networkRepoProvider.get();
            splashScreenActivity.configurationsRepo = (ConfigurationRepository) this.configurationsRepoProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
