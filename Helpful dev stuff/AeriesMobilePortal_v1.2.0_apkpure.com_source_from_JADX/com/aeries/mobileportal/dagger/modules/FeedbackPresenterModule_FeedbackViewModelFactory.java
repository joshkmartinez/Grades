package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FeedbackPresenterModule_FeedbackViewModelFactory implements Factory<FeedbackViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final FeedbackPresenterModule module;

    public FeedbackPresenterModule_FeedbackViewModelFactory(FeedbackPresenterModule feedbackPresenterModule) {
        this.module = feedbackPresenterModule;
    }

    public FeedbackViewModel get() {
        return (FeedbackViewModel) Preconditions.checkNotNull(this.module.feedbackViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<FeedbackViewModel> create(FeedbackPresenterModule feedbackPresenterModule) {
        return new FeedbackPresenterModule_FeedbackViewModelFactory(feedbackPresenterModule);
    }
}
