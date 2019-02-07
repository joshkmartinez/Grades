package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class InteractorModule_FeedbackInteractorFactory implements Factory<FeedbackInteractor> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<FeedbackService> feedbackServiceProvider;
    private final InteractorModule module;
    private final Provider<UserRepository> userRepositoryProvider;

    public InteractorModule_FeedbackInteractorFactory(InteractorModule interactorModule, Provider<FeedbackService> provider, Provider<UserRepository> provider2) {
        this.module = interactorModule;
        this.feedbackServiceProvider = provider;
        this.userRepositoryProvider = provider2;
    }

    public FeedbackInteractor get() {
        return (FeedbackInteractor) Preconditions.checkNotNull(this.module.feedbackInteractor((FeedbackService) this.feedbackServiceProvider.get(), (UserRepository) this.userRepositoryProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<FeedbackInteractor> create(InteractorModule interactorModule, Provider<FeedbackService> provider, Provider<UserRepository> provider2) {
        return new InteractorModule_FeedbackInteractorFactory(interactorModule, provider, provider2);
    }
}
