package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.web_services.services.FeedbackService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class NetworkModule_FeedbackServiceFactory implements Factory<FeedbackService> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final NetworkModule module;
    private final Provider<ServicesProvider> servicesProvider;

    public NetworkModule_FeedbackServiceFactory(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        this.module = networkModule;
        this.servicesProvider = provider;
    }

    public FeedbackService get() {
        return (FeedbackService) Preconditions.checkNotNull(this.module.feedbackService((ServicesProvider) this.servicesProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<FeedbackService> create(NetworkModule networkModule, Provider<ServicesProvider> provider) {
        return new NetworkModule_FeedbackServiceFactory(networkModule, provider);
    }
}
