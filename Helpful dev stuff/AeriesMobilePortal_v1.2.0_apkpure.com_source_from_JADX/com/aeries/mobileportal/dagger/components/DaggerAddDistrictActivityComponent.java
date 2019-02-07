package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.AddDistrictPresenterModule;
import com.aeries.mobileportal.dagger.modules.AddDistrictPresenterModule_AddDistrictPresenterFactory;
import com.aeries.mobileportal.dagger.modules.AddDistrictPresenterModule_AddDistrictViewModelFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_AddDistrictInteractorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.presenters.add_district.AddDistrictPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.AddDistrictActivity;
import com.aeries.mobileportal.views.activities.AddDistrictActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAddDistrictActivityComponent implements AddDistrictActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<AddDistrictActivity> addDistrictActivityMembersInjector;
    private Provider<AddDistrictInteractor> addDistrictInteractorProvider;
    private Provider<AddDistrictPresenter> addDistrictPresenterProvider;
    private Provider<AddDistrictViewModel> addDistrictViewModelProvider;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<ServicesProvider> servicesProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenRepository> tokenRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private AddDistrictPresenterModule addDistrictPresenterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public AddDistrictActivityComponent build() {
            if (this.addDistrictPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerAddDistrictActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(AddDistrictPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder addDistrictPresenterModule(AddDistrictPresenterModule addDistrictPresenterModule) {
            this.addDistrictPresenterModule = (AddDistrictPresenterModule) Preconditions.checkNotNull(addDistrictPresenterModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        @Deprecated
        public Builder schoolSearchNetworkModule(SchoolSearchNetworkModule schoolSearchNetworkModule) {
            Preconditions.checkNotNull(schoolSearchNetworkModule);
            return this;
        }

        @Deprecated
        public Builder networkUtilsSchoolModule(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
            Preconditions.checkNotNull(networkUtilsSchoolModule);
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

    private static class C0616x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0616x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0617x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0617x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0618x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0618x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0619xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0619xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0620xcf3a6871 implements Provider<ServicesProvider> {
        private final PSPComponent pSPComponent;

        C0620xcf3a6871(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ServicesProvider get() {
            return (ServicesProvider) Preconditions.checkNotNull(this.pSPComponent.servicesProvider(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo implements Provider<TokenRepository> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public TokenRepository get() {
            return (TokenRepository) Preconditions.checkNotNull(this.pSPComponent.tokenRepo(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerAddDistrictActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.addDistrictViewModelProvider = DoubleCheck.provider(AddDistrictPresenterModule_AddDistrictViewModelFactory.create(builder.addDistrictPresenterModule));
        this.analyticsServiceProvider = new C0616x70a50c51(builder.pSPComponent);
        this.networkRepoProvider = new C0619xbc4e3d7e(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0618x2fda2dc6(builder.pSPComponent);
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.checkApplicationServiceProvider = new C0617x81c4dc2b(builder.pSPComponent);
        this.servicesProvider = new C0620xcf3a6871(builder.pSPComponent);
        this.addDistrictInteractorProvider = DoubleCheck.provider(InteractorModule_AddDistrictInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.networkRepoProvider, this.userRepoProvider, this.configurationRepoProvider, this.tokenRepoProvider, this.schoolRepoProvider, this.studentRepoProvider, this.checkApplicationServiceProvider, this.servicesProvider));
        this.addDistrictPresenterProvider = DoubleCheck.provider(AddDistrictPresenterModule_AddDistrictPresenterFactory.create(builder.addDistrictPresenterModule, this.addDistrictViewModelProvider, this.addDistrictInteractorProvider));
        this.addDistrictActivityMembersInjector = AddDistrictActivity_MembersInjector.create(this.addDistrictPresenterProvider);
    }

    public void inject(AddDistrictActivity addDistrictActivity) {
        this.addDistrictActivityMembersInjector.injectMembers(addDistrictActivity);
    }
}
