package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.CommunicationsPresenterModule;
import com.aeries.mobileportal.dagger.modules.CommunicationsPresenterModule_CommunicationsPresenterFactory;
import com.aeries.mobileportal.dagger.modules.CommunicationsPresenterModule_CommunicationsViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_CommunicationsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.communications.CommunicationsInteractor;
import com.aeries.mobileportal.presenters.communications.CommunicationsPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.CommunicationsActivity;
import com.aeries.mobileportal.views.activities.CommunicationsActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.SignalKitService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerCommunicationsActivityComponent implements CommunicationsActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<CommunicationsActivity> communicationsActivityMembersInjector;
    private Provider<CommunicationsInteractor> communicationsInteractorProvider;
    private Provider<CommunicationsPresenter> communicationsPresenterProvider;
    private Provider<CommunicationsViewModel> communicationsViewModelProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<SignalKitService> signalKitServiceProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private CommunicationsPresenterModule communicationsPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public CommunicationsActivityComponent build() {
            if (this.communicationsPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerCommunicationsActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(CommunicationsPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder communicationsPresenterModule(CommunicationsPresenterModule communicationsPresenterModule) {
            this.communicationsPresenterModule = (CommunicationsPresenterModule) Preconditions.checkNotNull(communicationsPresenterModule);
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

    private static class C0645x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0645x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0646x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0646x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0647x94e9c7c9 implements Provider<SignalKitService> {
        private final PSPComponent pSPComponent;

        C0647x94e9c7c9(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public SignalKitService get() {
            return (SignalKitService) Preconditions.checkNotNull(this.pSPComponent.signalKitService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0648xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0648xa10b3e48(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenProvider get() {
            return (TokenProvider) Preconditions.checkNotNull(this.pSPComponent.tokenProvider(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerCommunicationsActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.communicationsViewModelProvider = DoubleCheck.provider(CommunicationsPresenterModule_CommunicationsViewModelFactory.create(builder.communicationsPresenterModule));
        this.analyticsServiceProvider = new C0645x70a50c51(builder.pSPComponent);
        this.signalKitServiceProvider = new C0647x94e9c7c9(builder.pSPComponent);
        this.tokenProvider = new C0648xa10b3e48(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0646x2fda2dc6(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.communicationsInteractorProvider = DoubleCheck.provider(InteractorModule_CommunicationsInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.signalKitServiceProvider, this.tokenProvider, this.userRepoProvider, this.configurationRepoProvider, this.studentRepoProvider, this.schoolRepoProvider));
        this.communicationsPresenterProvider = DoubleCheck.provider(CommunicationsPresenterModule_CommunicationsPresenterFactory.create(builder.communicationsPresenterModule, this.communicationsViewModelProvider, this.communicationsInteractorProvider));
        this.communicationsActivityMembersInjector = CommunicationsActivity_MembersInjector.create(this.communicationsPresenterProvider);
    }

    public void inject(CommunicationsActivity communicationsActivity) {
        this.communicationsActivityMembersInjector.injectMembers(communicationsActivity);
    }
}