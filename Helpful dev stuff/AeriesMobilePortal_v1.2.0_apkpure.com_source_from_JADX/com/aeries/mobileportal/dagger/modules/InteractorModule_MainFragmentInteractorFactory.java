package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_MainFragmentInteractorFactory implements Factory<MainFragmentInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ApplicationService> applicationServiceProvider;
    private final Provider<ConfigurationRepository> configurationRepositoryProvider;
    private final InteractorModule module;
    private final Provider<NotificationService> notificationServiceProvider;
    private final Provider<NotificationsRepo> notificationsRepoProvider;
    private final Provider<TokenProvider> tokenProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_MainFragmentInteractorFactory(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<NotificationsRepo> provider2, Provider<UserRepository> provider3, Provider<NotificationService> provider4, Provider<ApplicationService> provider5, Provider<TokenProvider> provider6) {
        this.module = interactorModule;
        this.configurationRepositoryProvider = provider;
        this.notificationsRepoProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.notificationServiceProvider = provider4;
        this.applicationServiceProvider = provider5;
        this.tokenProvider = provider6;
    }

    public MainFragmentInteractor get() {
        return (MainFragmentInteractor) Preconditions.checkNotNull(this.module.mainFragmentInteractor((ConfigurationRepository) this.configurationRepositoryProvider.get(), (NotificationsRepo) this.notificationsRepoProvider.get(), (UserRepository) this.userRepositoryProvider.get(), (NotificationService) this.notificationServiceProvider.get(), (ApplicationService) this.applicationServiceProvider.get(), (TokenProvider) this.tokenProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<MainFragmentInteractor> create(InteractorModule interactorModule, Provider<ConfigurationRepository> provider, Provider<NotificationsRepo> provider2, Provider<UserRepository> provider3, Provider<NotificationService> provider4, Provider<ApplicationService> provider5, Provider<TokenProvider> provider6) {
        return new InteractorModule_MainFragmentInteractorFactory(interactorModule, provider, provider2, provider3, provider4, provider5, provider6);
    }
}
