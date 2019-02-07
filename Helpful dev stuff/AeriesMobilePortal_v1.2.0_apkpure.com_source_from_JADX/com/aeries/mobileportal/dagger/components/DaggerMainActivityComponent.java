package com.aeries.mobileportal.dagger.components;

import android.content.Context;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_MainInteractorFactory;
import com.aeries.mobileportal.dagger.modules.MainActivityModule;
import com.aeries.mobileportal.dagger.modules.MainActivityModule_StudentDetailsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.MainPresenterModule;
import com.aeries.mobileportal.dagger.modules.MainPresenterModule_PresenterFactory;
import com.aeries.mobileportal.dagger.modules.MainPresenterModule_ViewModelFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_NotificationsRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.interactors.main.MainInteractor;
import com.aeries.mobileportal.presenters.MainPresenter;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.views.activities.MainActivity;
import com.aeries.mobileportal.views.activities.MainActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.main.MainViewModel;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerMainActivityComponent implements MainActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Context> contextProvider;
    private Provider<GoogleSignInClient> googleSignInClientProvider;
    private Provider<ImageLoader> imageLoaderProvider;
    private MembersInjector<MainActivity> mainActivityMembersInjector;
    private Provider<MainInteractor> mainInteractorProvider;
    private Provider<NotificationsRepo> notificationsRepoProvider;
    private Provider<MainPresenter> presenterProvider;
    private Provider<RestrictionService> restrictedServiceProvider;
    private Provider<RestrictionRepository> restrictionRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<StudentDetailsAdapter> studentDetailsAdapterProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<UserRepository> userRepoProvider;
    private Provider<MainViewModel> viewModelProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private MainActivityModule mainActivityModule;
        private MainPresenterModule mainPresenterModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public MainActivityComponent build() {
            StringBuilder stringBuilder;
            if (this.mainPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.mainActivityModule == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(MainActivityModule.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (this.pSPComponent != null) {
                    return new DaggerMainActivityComponent();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(PSPComponent.class.getCanonicalName());
                    stringBuilder.append(" must be set");
                    throw new IllegalStateException(stringBuilder.toString());
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(MainPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder mainPresenterModule(MainPresenterModule mainPresenterModule) {
            this.mainPresenterModule = (MainPresenterModule) Preconditions.checkNotNull(mainPresenterModule);
            return this;
        }

        public Builder mainActivityModule(MainActivityModule mainActivityModule) {
            this.mainActivityModule = (MainActivityModule) Preconditions.checkNotNull(mainActivityModule);
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

    private static class C0689x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0689x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0690x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0690x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0691x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0691x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class com_aeries_mobileportal_dagger_components_PSPComponent_context implements Provider<Context> {
        private final PSPComponent pSPComponent;

        com_aeries_mobileportal_dagger_components_PSPComponent_context(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public Context get() {
            return (Context) Preconditions.checkNotNull(this.pSPComponent.context(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0692x67334a88 implements Provider<GoogleSignInClient> {
        private final PSPComponent pSPComponent;

        C0692x67334a88(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleSignInClient get() {
            return (GoogleSignInClient) Preconditions.checkNotNull(this.pSPComponent.googleSignInClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0693xa563f00c implements Provider<ImageLoader> {
        private final PSPComponent pSPComponent;

        C0693xa563f00c(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ImageLoader get() {
            return (ImageLoader) Preconditions.checkNotNull(this.pSPComponent.imageLoader(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0694x4e709e18 implements Provider<RestrictionService> {
        private final PSPComponent pSPComponent;

        C0694x4e709e18(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public RestrictionService get() {
            return (RestrictionService) Preconditions.checkNotNull(this.pSPComponent.restrictedService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0695xcd87691c implements Provider<RestrictionRepository> {
        private final PSPComponent pSPComponent;

        C0695xcd87691c(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public RestrictionRepository get() {
            return (RestrictionRepository) Preconditions.checkNotNull(this.pSPComponent.restrictionRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0696xa10b3e48 implements Provider<TokenProvider> {
        private final PSPComponent pSPComponent;

        C0696xa10b3e48(PSPComponent pSPComponent) {
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

    private DaggerMainActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.viewModelProvider = DoubleCheck.provider(MainPresenterModule_ViewModelFactory.create(builder.mainPresenterModule));
        this.analyticsServiceProvider = new C0689x70a50c51(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0690x81c4dc2b(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.notificationsRepoProvider = RepoModule_NotificationsRepoFactory.create(builder.repoModule);
        this.configurationRepoProvider = new C0691x2fda2dc6(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.restrictionRepoProvider = new C0695xcd87691c(builder.pSPComponent);
        this.restrictedServiceProvider = new C0694x4e709e18(builder.pSPComponent);
        this.tokenProvider = new C0696xa10b3e48(builder.pSPComponent);
        this.googleSignInClientProvider = new C0692x67334a88(builder.pSPComponent);
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.mainInteractorProvider = DoubleCheck.provider(InteractorModule_MainInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.checkApplicationServiceProvider, this.studentRepoProvider, this.schoolRepoProvider, this.notificationsRepoProvider, this.configurationRepoProvider, this.userRepoProvider, this.restrictionRepoProvider, this.restrictedServiceProvider, this.tokenProvider, this.googleSignInClientProvider, this.contextProvider));
        this.presenterProvider = DoubleCheck.provider(MainPresenterModule_PresenterFactory.create(builder.mainPresenterModule, this.viewModelProvider, this.mainInteractorProvider));
        this.imageLoaderProvider = new C0693xa563f00c(builder.pSPComponent);
        this.studentDetailsAdapterProvider = DoubleCheck.provider(MainActivityModule_StudentDetailsAdapterFactory.create(builder.mainActivityModule));
        this.mainActivityMembersInjector = MainActivity_MembersInjector.create(this.presenterProvider, this.imageLoaderProvider, this.studentDetailsAdapterProvider);
    }

    public void inject(MainActivity mainActivity) {
        this.mainActivityMembersInjector.injectMembers(mainActivity);
    }
}
