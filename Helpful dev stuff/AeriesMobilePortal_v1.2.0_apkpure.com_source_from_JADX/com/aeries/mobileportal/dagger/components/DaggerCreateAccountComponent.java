package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.CreateAccountPresenterModule;
import com.aeries.mobileportal.dagger.modules.CreateAccountPresenterModule_CreateAccountPresenterFactory;
import com.aeries.mobileportal.dagger.modules.CreateAccountPresenterModule_CreateAccountViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_CreateAccountInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.presenters.create_account.CreateAccountPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.CreateAccountActivity;
import com.aeries.mobileportal.views.activities.CreateAccountActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerCreateAccountComponent implements CreateAccountComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private MembersInjector<CreateAccountActivity> createAccountActivityMembersInjector;
    private Provider<CreateAccountInteractor> createAccountInteractorProvider;
    private Provider<CreateAccountPresenter> createAccountPresenterProvider;
    private Provider<CreateAccountService> createAccountServiceProvider;
    private Provider<CreateAccountViewModel> createAccountViewModelProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private CreateAccountPresenterModule createAccountPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public CreateAccountComponent build() {
            if (this.createAccountPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerCreateAccountComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(CreateAccountPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder createAccountPresenterModule(CreateAccountPresenterModule createAccountPresenterModule) {
            this.createAccountPresenterModule = (CreateAccountPresenterModule) Preconditions.checkNotNull(createAccountPresenterModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
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

    private static class C0658x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0658x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0659x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0659x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0660x587bd6e6 implements Provider<CreateAccountService> {
        private final PSPComponent pSPComponent;

        C0660x587bd6e6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public CreateAccountService get() {
            return (CreateAccountService) Preconditions.checkNotNull(this.pSPComponent.createAccountService(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerCreateAccountComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.createAccountViewModelProvider = DoubleCheck.provider(CreateAccountPresenterModule_CreateAccountViewModelFactory.create(builder.createAccountPresenterModule));
        this.analyticsServiceProvider = new C0658x70a50c51(builder.pSPComponent);
        this.createAccountServiceProvider = new C0660x587bd6e6(builder.pSPComponent);
        this.configurationRepoProvider = new C0659x2fda2dc6(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.createAccountInteractorProvider = DoubleCheck.provider(InteractorModule_CreateAccountInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.createAccountServiceProvider, this.configurationRepoProvider, this.schoolRepoProvider, this.userRepoProvider));
        this.createAccountPresenterProvider = DoubleCheck.provider(CreateAccountPresenterModule_CreateAccountPresenterFactory.create(builder.createAccountPresenterModule, this.createAccountViewModelProvider, this.createAccountInteractorProvider));
        this.createAccountActivityMembersInjector = CreateAccountActivity_MembersInjector.create(this.createAccountPresenterProvider);
    }

    public void inject(CreateAccountActivity createAccountActivity) {
        this.createAccountActivityMembersInjector.injectMembers(createAccountActivity);
    }
}
