package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.presenters.feedback.FeedbackPresenter;
import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FeedbackPresenterModule_FeedbackPresenterFactory implements Factory<FeedbackPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<FeedbackInteractor> interactorProvider;
    private final FeedbackPresenterModule module;
    private final Provider<FeedbackViewModel> viewModelProvider;

    public FeedbackPresenterModule_FeedbackPresenterFactory(FeedbackPresenterModule feedbackPresenterModule, Provider<FeedbackViewModel> provider, Provider<FeedbackInteractor> provider2) {
        this.module = feedbackPresenterModule;
        this.viewModelProvider = provider;
        this.interactorProvider = provider2;
    }

    public FeedbackPresenter get() {
        return (FeedbackPresenter) Preconditions.checkNotNull(this.module.feedbackPresenter((FeedbackViewModel) this.viewModelProvider.get(), (FeedbackInteractor) this.interactorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<FeedbackPresenter> create(FeedbackPresenterModule feedbackPresenterModule, Provider<FeedbackViewModel> provider, Provider<FeedbackInteractor> provider2) {
        return new FeedbackPresenterModule_FeedbackPresenterFactory(feedbackPresenterModule, provider, provider2);
    }
}
