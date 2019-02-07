package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.DemographicsPresenterModule;
import com.aeries.mobileportal.dagger.modules.DemographicsPresenterModule_DemographicsPresenterFactory;
import com.aeries.mobileportal.dagger.modules.DemographicsPresenterModule_DemographicsViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_DemographicsInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.presenters.demographics.DemographicsPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.DemographicsActivity;
import com.aeries.mobileportal.views.activities.DemographicsActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerDemographicsActivityComponent implements DemographicsActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private MembersInjector<DemographicsActivity> demographicsActivityMembersInjector;
    private Provider<DemographicsInteractor> demographicsInteractorProvider;
    private Provider<DemographicsPresenter> demographicsPresenterProvider;
    private Provider<DemographicsViewModel> demographicsViewModelProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private DemographicsPresenterModule demographicsPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public DemographicsActivityComponent build() {
            if (this.demographicsPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerDemographicsActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(DemographicsPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder demographicsPresenterModule(DemographicsPresenterModule demographicsPresenterModule) {
            this.demographicsPresenterModule = (DemographicsPresenterModule) Preconditions.checkNotNull(demographicsPresenterModule);
            return this;
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
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

    private static class C0661x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0661x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0662x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0662x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0663xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0663xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerDemographicsActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.demographicsViewModelProvider = DoubleCheck.provider(DemographicsPresenterModule_DemographicsViewModelFactory.create(builder.demographicsPresenterModule));
        this.analyticsServiceProvider = new C0661x70a50c51(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0662x2fda2dc6(builder.pSPComponent);
        this.networkRepoProvider = new C0663xbc4e3d7e(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.demographicsInteractorProvider = DoubleCheck.provider(InteractorModule_DemographicsInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.userRepoProvider, this.configurationRepoProvider, this.networkRepoProvider, this.studentRepoProvider, this.schoolRepoProvider));
        this.demographicsPresenterProvider = DoubleCheck.provider(DemographicsPresenterModule_DemographicsPresenterFactory.create(builder.demographicsPresenterModule, this.demographicsViewModelProvider, this.demographicsInteractorProvider));
        this.demographicsActivityMembersInjector = DemographicsActivity_MembersInjector.create(this.demographicsPresenterProvider);
    }

    public void inject(DemographicsActivity demographicsActivity) {
        this.demographicsActivityMembersInjector.injectMembers(demographicsActivity);
    }
}
