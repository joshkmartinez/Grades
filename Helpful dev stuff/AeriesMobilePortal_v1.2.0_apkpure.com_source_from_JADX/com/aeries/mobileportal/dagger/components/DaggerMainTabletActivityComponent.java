package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_MainTabletInteractorFactory;
import com.aeries.mobileportal.dagger.modules.MainTabletPresenterModule;
import com.aeries.mobileportal.dagger.modules.MainTabletPresenterModule_MainTabletPresenterFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.tablet.MainTabletInteractor;
import com.aeries.mobileportal.presenters.tablet.MainTabletPresenter;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.views.activities.MainTabletActivity;
import com.aeries.mobileportal.views.activities.MainTabletActivity_MembersInjector;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMainTabletActivityComponent implements MainTabletActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<ImageLoader> imageLoaderProvider;
    private MembersInjector<MainTabletActivity> mainTabletActivityMembersInjector;
    private Provider<MainTabletInteractor> mainTabletInteractorProvider;
    private Provider<MainTabletPresenter> mainTabletPresenterProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenRepository> tokenRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private MainTabletPresenterModule mainTabletPresenterModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public MainTabletActivityComponent build() {
            if (this.repoModule == null) {
                this.repoModule = new RepoModule();
            }
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.mainTabletPresenterModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(MainTabletPresenterModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerMainTabletActivityComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder repoModule(RepoModule repoModule) {
            this.repoModule = (RepoModule) Preconditions.checkNotNull(repoModule);
            return this;
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder mainTabletPresenterModule(MainTabletPresenterModule mainTabletPresenterModule) {
            this.mainTabletPresenterModule = (MainTabletPresenterModule) Preconditions.checkNotNull(mainTabletPresenterModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class C0701x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0701x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0702x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0702x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0703x5a7da2d7 implements Provider<GradesService> {
        private final PSPComponent pSPComponent;

        C0703x5a7da2d7(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GradesService get() {
            return (GradesService) Preconditions.checkNotNull(this.pSPComponent.gradesService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0704xa563f00c implements Provider<ImageLoader> {
        private final PSPComponent pSPComponent;

        C0704xa563f00c(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ImageLoader get() {
            return (ImageLoader) Preconditions.checkNotNull(this.pSPComponent.imageLoader(), "Cannot return null from a non-@Nullable component method");
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

    private DaggerMainTabletActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0702x2fda2dc6(builder.pSPComponent);
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0701x81c4dc2b(builder.pSPComponent);
        this.gradesServiceProvider = new C0703x5a7da2d7(builder.pSPComponent);
        this.mainTabletInteractorProvider = DoubleCheck.provider(InteractorModule_MainTabletInteractorFactory.create(builder.interactorModule, this.studentRepoProvider, this.schoolRepoProvider, this.userRepoProvider, this.configurationRepoProvider, this.tokenRepoProvider, this.checkApplicationServiceProvider, this.gradesServiceProvider));
        this.mainTabletPresenterProvider = DoubleCheck.provider(MainTabletPresenterModule_MainTabletPresenterFactory.create(builder.mainTabletPresenterModule, this.mainTabletInteractorProvider));
        this.imageLoaderProvider = new C0704xa563f00c(builder.pSPComponent);
        this.mainTabletActivityMembersInjector = MainTabletActivity_MembersInjector.create(this.mainTabletPresenterProvider, this.imageLoaderProvider);
    }

    public void inject(MainTabletActivity mainTabletActivity) {
        this.mainTabletActivityMembersInjector.injectMembers(mainTabletActivity);
    }
}
