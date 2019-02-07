package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.ForgotPasswordPresenterModule;
import com.aeries.mobileportal.dagger.modules.ForgotPasswordPresenterModule_ForgotPasswordPresenterFactory;
import com.aeries.mobileportal.dagger.modules.ForgotPasswordPresenterModule_ForgotPasswordViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ForgotPasswordInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.presenters.forgot_password.ForgotPasswordPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.views.activities.ForgotPasswordActivity;
import com.aeries.mobileportal.views.activities.ForgotPasswordActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerForgotPasswordActivityComponent implements ForgotPasswordActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private MembersInjector<ForgotPasswordActivity> forgotPasswordActivityMembersInjector;
    private Provider<ForgotPasswordInteractor> forgotPasswordInteractorProvider;
    private Provider<ForgotPasswordPresenter> forgotPasswordPresenterProvider;
    private Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;
    private Provider<PasswordService> passwordServiceProvider;
    private Provider<SchoolRepo> schoolRepoProvider;

    public static final class Builder {
        private ForgotPasswordPresenterModule forgotPasswordPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public ForgotPasswordActivityComponent build() {
            if (this.forgotPasswordPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerForgotPasswordActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(ForgotPasswordPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder forgotPasswordPresenterModule(ForgotPasswordPresenterModule forgotPasswordPresenterModule) {
            this.forgotPasswordPresenterModule = (ForgotPasswordPresenterModule) Preconditions.checkNotNull(forgotPasswordPresenterModule);
            return this;
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class C0665x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0665x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0666x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0666x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0667xc236db58 implements Provider<PasswordService> {
        private final PSPComponent pSPComponent;

        C0667xc236db58(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public PasswordService get() {
            return (PasswordService) Preconditions.checkNotNull(this.pSPComponent.passwordService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerForgotPasswordActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.forgotPasswordViewModelProvider = DoubleCheck.provider(ForgotPasswordPresenterModule_ForgotPasswordViewModelFactory.create(builder.forgotPasswordPresenterModule));
        this.analyticsServiceProvider = new C0665x70a50c51(builder.pSPComponent);
        this.passwordServiceProvider = new C0667xc236db58(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.configurationRepoProvider = new C0666x2fda2dc6(builder.pSPComponent);
        this.forgotPasswordInteractorProvider = DoubleCheck.provider(InteractorModule_ForgotPasswordInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.passwordServiceProvider, this.schoolRepoProvider, this.configurationRepoProvider));
        this.forgotPasswordPresenterProvider = DoubleCheck.provider(ForgotPasswordPresenterModule_ForgotPasswordPresenterFactory.create(builder.forgotPasswordPresenterModule, this.forgotPasswordViewModelProvider, this.forgotPasswordInteractorProvider));
        this.forgotPasswordActivityMembersInjector = ForgotPasswordActivity_MembersInjector.create(this.forgotPasswordPresenterProvider);
    }

    public void inject(ForgotPasswordActivity forgotPasswordActivity) {
        this.forgotPasswordActivityMembersInjector.injectMembers(forgotPasswordActivity);
    }
}
