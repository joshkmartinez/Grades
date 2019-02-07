package com.aeries.mobileportal.dagger.components;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_LoginInteractorFactory;
import com.aeries.mobileportal.dagger.modules.LoginPresenterModule;
import com.aeries.mobileportal.dagger.modules.LoginPresenterModule_LoginPresenterFactory;
import com.aeries.mobileportal.dagger.modules.LoginPresenterModule_LoginViewModelFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.views.activities.AuthenticationActivity;
import com.aeries.mobileportal.views.activities.AuthenticationActivity_MembersInjector;
import com.aeries.mobileportal.views.activities.LoginActivity;
import com.aeries.mobileportal.views.activities.LoginActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerLoginActivityComponent implements LoginActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AccountManager> accountManagerProvider;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private MembersInjector<AuthenticationActivity> authenticationActivityMembersInjector;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Context> contextProvider;
    private Provider<GoogleApiClient> googleApiClientProvider;
    private Provider<GoogleSignInClient> googleSignInClientProvider;
    private MembersInjector<LoginActivity> loginActivityMembersInjector;
    private Provider<LoginInteractor> loginInteractorProvider;
    private Provider<LoginPresenter> loginPresenterProvider;
    private Provider<LoginService> loginServiceProvider;
    private Provider<LoginViewModel> loginViewModelProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<ServicesProvider> servicesProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenRepository> tokenRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private LoginPresenterModule loginPresenterModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public LoginActivityComponent build() {
            if (this.loginPresenterModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerLoginActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(LoginPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder interactorModule(InteractorModule interactorModule) {
            this.interactorModule = (InteractorModule) Preconditions.checkNotNull(interactorModule);
            return this;
        }

        public Builder loginPresenterModule(LoginPresenterModule loginPresenterModule) {
            this.loginPresenterModule = (LoginPresenterModule) Preconditions.checkNotNull(loginPresenterModule);
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

    private static class C0680xd5c90542 implements Provider<AccountManager> {
        private final PSPComponent pSPComponent;

        C0680xd5c90542(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AccountManager get() {
            return (AccountManager) Preconditions.checkNotNull(this.pSPComponent.accountManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0681x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0681x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0682x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0682x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0683x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0683x2fda2dc6(PSPComponent pSPComponent) {
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

    private static class C0684xbb6ddc0a implements Provider<GoogleApiClient> {
        private final PSPComponent pSPComponent;

        C0684xbb6ddc0a(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleApiClient get() {
            return (GoogleApiClient) Preconditions.checkNotNull(this.pSPComponent.googleApiClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0685x67334a88 implements Provider<GoogleSignInClient> {
        private final PSPComponent pSPComponent;

        C0685x67334a88(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleSignInClient get() {
            return (GoogleSignInClient) Preconditions.checkNotNull(this.pSPComponent.googleSignInClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0686x3357740e implements Provider<LoginService> {
        private final PSPComponent pSPComponent;

        C0686x3357740e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public LoginService get() {
            return (LoginService) Preconditions.checkNotNull(this.pSPComponent.loginService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0687xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0687xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0688xcf3a6871 implements Provider<ServicesProvider> {
        private final PSPComponent pSPComponent;

        C0688xcf3a6871(PSPComponent pSPComponent) {
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

    private DaggerLoginActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.loginViewModelProvider = DoubleCheck.provider(LoginPresenterModule_LoginViewModelFactory.create(builder.loginPresenterModule));
        this.analyticsServiceProvider = new C0681x70a50c51(builder.pSPComponent);
        this.loginServiceProvider = new C0686x3357740e(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0682x81c4dc2b(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0683x2fda2dc6(builder.pSPComponent);
        this.networkRepoProvider = new C0687xbc4e3d7e(builder.pSPComponent);
        this.servicesProvider = new C0688xcf3a6871(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.accountManagerProvider = new C0680xd5c90542(builder.pSPComponent);
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.googleSignInClientProvider = new C0685x67334a88(builder.pSPComponent);
        this.googleApiClientProvider = new C0684xbb6ddc0a(builder.pSPComponent);
        this.loginInteractorProvider = InteractorModule_LoginInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.loginServiceProvider, this.checkApplicationServiceProvider, this.userRepoProvider, this.tokenRepoProvider, this.configurationRepoProvider, this.networkRepoProvider, this.servicesProvider, this.studentRepoProvider, this.schoolRepoProvider, this.accountManagerProvider, this.contextProvider, this.googleSignInClientProvider, this.googleApiClientProvider);
        this.loginPresenterProvider = DoubleCheck.provider(LoginPresenterModule_LoginPresenterFactory.create(builder.loginPresenterModule, this.loginViewModelProvider, this.loginInteractorProvider));
        this.loginActivityMembersInjector = LoginActivity_MembersInjector.create(this.loginPresenterProvider, this.googleSignInClientProvider);
        this.authenticationActivityMembersInjector = AuthenticationActivity_MembersInjector.create(this.loginPresenterProvider);
    }

    public void inject(LoginActivity loginActivity) {
        this.loginActivityMembersInjector.injectMembers(loginActivity);
    }

    public void inject(AuthenticationActivity authenticationActivity) {
        this.authenticationActivityMembersInjector.injectMembers(authenticationActivity);
    }
}
