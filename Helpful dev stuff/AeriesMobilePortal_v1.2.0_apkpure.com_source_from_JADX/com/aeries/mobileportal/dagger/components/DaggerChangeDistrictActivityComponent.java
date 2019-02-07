package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.DistrictsAdapter;
import com.aeries.mobileportal.adapters.DistrictsAdapter.DistrictsListener;
import com.aeries.mobileportal.dagger.modules.ChangeDistrictPresenterModule;
import com.aeries.mobileportal.dagger.modules.ChangeDistrictPresenterModule_ChangeDistrictPresenterFactory;
import com.aeries.mobileportal.dagger.modules.ChangeDistrictPresenterModule_ChangeDistrictViewModelFactory;
import com.aeries.mobileportal.dagger.modules.DistrictsAdapterModule;
import com.aeries.mobileportal.dagger.modules.DistrictsAdapterModule_DistrictsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.DistrictsAdapterModule_DistrictsListenerFactory;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_ChangeDistrictInteractorFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.presenters.change_district.ChangeDistrictPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.ChangeDistrictActivity;
import com.aeries.mobileportal.views.activities.ChangeDistrictActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerChangeDistrictActivityComponent implements ChangeDistrictActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<ChangeDistrictActivity> changeDistrictActivityMembersInjector;
    private Provider<ChangeDistrictInteractor> changeDistrictInteractorProvider;
    private Provider<ChangeDistrictPresenter> changeDistrictPresenterProvider;
    private Provider<ChangeDistrictViewModel> changeDistrictViewModelProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<DistrictsAdapter> districtsAdapterProvider;
    private Provider<DistrictsListener> districtsListenerProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenRepository> tokenRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private ChangeDistrictPresenterModule changeDistrictPresenterModule;
        private DistrictsAdapterModule districtsAdapterModule;
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public ChangeDistrictActivityComponent build() {
            StringBuilder stringBuilder;
            if (this.changeDistrictPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.districtsAdapterModule == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(DistrictsAdapterModule.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (this.pSPComponent != null) {
                    return new DaggerChangeDistrictActivityComponent();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(PSPComponent.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(ChangeDistrictPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder changeDistrictPresenterModule(ChangeDistrictPresenterModule changeDistrictPresenterModule) {
            this.changeDistrictPresenterModule = (ChangeDistrictPresenterModule) Preconditions.checkNotNull(changeDistrictPresenterModule);
            return this;
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
            return this;
        }

        public Builder districtsAdapterModule(DistrictsAdapterModule districtsAdapterModule) {
            this.districtsAdapterModule = (DistrictsAdapterModule) Preconditions.checkNotNull(districtsAdapterModule);
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

    private static class C0633x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0633x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0634x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0634x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0635xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0635xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerChangeDistrictActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.changeDistrictViewModelProvider = DoubleCheck.provider(ChangeDistrictPresenterModule_ChangeDistrictViewModelFactory.create(builder.changeDistrictPresenterModule));
        this.networkRepoProvider = new C0635xbc4e3d7e(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0634x2fda2dc6(builder.pSPComponent);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.checkApplicationServiceProvider = new C0633x81c4dc2b(builder.pSPComponent);
        this.changeDistrictInteractorProvider = DoubleCheck.provider(InteractorModule_ChangeDistrictInteractorFactory.create(builder.interactorModule, this.networkRepoProvider, this.userRepoProvider, this.tokenRepoProvider, this.configurationRepoProvider, this.schoolRepoProvider, this.studentRepoProvider, this.checkApplicationServiceProvider));
        this.changeDistrictPresenterProvider = DoubleCheck.provider(ChangeDistrictPresenterModule_ChangeDistrictPresenterFactory.create(builder.changeDistrictPresenterModule, this.changeDistrictViewModelProvider, this.changeDistrictInteractorProvider));
        this.districtsListenerProvider = DoubleCheck.provider(DistrictsAdapterModule_DistrictsListenerFactory.create(builder.districtsAdapterModule));
        this.districtsAdapterProvider = DoubleCheck.provider(DistrictsAdapterModule_DistrictsAdapterFactory.create(builder.districtsAdapterModule, this.districtsListenerProvider));
        this.changeDistrictActivityMembersInjector = ChangeDistrictActivity_MembersInjector.create(this.changeDistrictPresenterProvider, this.districtsAdapterProvider);
    }

    public void inject(ChangeDistrictActivity changeDistrictActivity) {
        this.changeDistrictActivityMembersInjector.injectMembers(changeDistrictActivity);
    }
}
