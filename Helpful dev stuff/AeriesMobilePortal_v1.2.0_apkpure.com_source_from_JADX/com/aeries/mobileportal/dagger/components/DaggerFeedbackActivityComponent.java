package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.FeedbackPresenterModule;
import com.aeries.mobileportal.dagger.modules.FeedbackPresenterModule_FeedbackPresenterFactory;
import com.aeries.mobileportal.dagger.modules.FeedbackPresenterModule_FeedbackViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_FeedbackInteractorFactory;
import com.aeries.mobileportal.interactors.feedback.FeedbackInteractor;
import com.aeries.mobileportal.presenters.feedback.FeedbackPresenter;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.FeedbackActivity;
import com.aeries.mobileportal.views.activities.FeedbackActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.feedback.FeedbackViewModel;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerFeedbackActivityComponent implements FeedbackActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<FeedbackActivity> feedbackActivityMembersInjector;
    private Provider<FeedbackInteractor> feedbackInteractorProvider;
    private Provider<FeedbackPresenter> feedbackPresenterProvider;
    private Provider<FeedbackService> feedbackServiceProvider;
    private Provider<FeedbackViewModel> feedbackViewModelProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private FeedbackPresenterModule feedbackPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;

        private Builder() {
        }

        public FeedbackActivityComponent build() {
            if (this.feedbackPresenterModule != null) {
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerFeedbackActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(FeedbackPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder feedbackPresenterModule(FeedbackPresenterModule feedbackPresenterModule) {
            this.feedbackPresenterModule = (FeedbackPresenterModule) Preconditions.checkNotNull(feedbackPresenterModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class C0664xdce7af2e implements Provider<FeedbackService> {
        private final PSPComponent pSPComponent;

        C0664xdce7af2e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public FeedbackService get() {
            return (FeedbackService) Preconditions.checkNotNull(this.pSPComponent.feedbackService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_userRepo implements Provider<UserRepository> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public UserRepository get() {
            return (UserRepository) Preconditions.checkNotNull(this.pSPComponent.userRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerFeedbackActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.feedbackViewModelProvider = DoubleCheck.provider(FeedbackPresenterModule_FeedbackViewModelFactory.create(builder.feedbackPresenterModule));
        this.feedbackServiceProvider = new C0664xdce7af2e(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.feedbackInteractorProvider = DoubleCheck.provider(InteractorModule_FeedbackInteractorFactory.create(builder.interactorModule, this.feedbackServiceProvider, this.userRepoProvider));
        this.feedbackPresenterProvider = DoubleCheck.provider(FeedbackPresenterModule_FeedbackPresenterFactory.create(builder.feedbackPresenterModule, this.feedbackViewModelProvider, this.feedbackInteractorProvider));
        this.feedbackActivityMembersInjector = FeedbackActivity_MembersInjector.create(this.feedbackPresenterProvider);
    }

    public void inject(FeedbackActivity feedbackActivity) {
        this.feedbackActivityMembersInjector.injectMembers(feedbackActivity);
    }
}
