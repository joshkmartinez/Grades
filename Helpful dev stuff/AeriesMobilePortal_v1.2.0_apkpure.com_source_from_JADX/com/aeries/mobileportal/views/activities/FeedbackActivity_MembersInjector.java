package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.feedback.FeedbackPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FeedbackActivity_MembersInjector implements MembersInjector<FeedbackActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<FeedbackPresenter> presenterProvider;

    public FeedbackActivity_MembersInjector(Provider<FeedbackPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<FeedbackActivity> create(Provider<FeedbackPresenter> provider) {
        return new FeedbackActivity_MembersInjector(provider);
    }

    public void injectMembers(FeedbackActivity feedbackActivity) {
        if (feedbackActivity != null) {
            feedbackActivity.presenter = (FeedbackPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
