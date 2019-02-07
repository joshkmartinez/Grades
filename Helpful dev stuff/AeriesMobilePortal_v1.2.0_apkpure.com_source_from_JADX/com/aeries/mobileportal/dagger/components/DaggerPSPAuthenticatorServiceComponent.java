package com.aeries.mobileportal.dagger.components;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.PSPAuthenticator;
import com.aeries.mobileportal.PSPAuthenticator.PSPAuthenticatorListener;
import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_LoginInteractorFactory;
import com.aeries.mobileportal.dagger.modules.PSPAuthenticatorModule;
import com.aeries.mobileportal.dagger.modules.PSPAuthenticatorModule_AuthServicePresenterFactory;
import com.aeries.mobileportal.dagger.modules.PSPAuthenticatorModule_PspAuthenticatorFactory;
import com.aeries.mobileportal.dagger.modules.PSPAuthenticatorModule_PspAuthenticatorListenerFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule_StudentRepoFactory;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.AuthServicePresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.services.PSPAuthenticatorService;
import com.aeries.mobileportal.services.PSPAuthenticatorService_MembersInjector;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerPSPAuthenticatorServiceComponent implements PSPAuthenticatorServiceComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AccountManager> accountManagerProvider;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<AuthServicePresenter> authServicePresenterProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Context> contextProvider;
    private Provider<GoogleApiClient> googleApiClientProvider;
    private Provider<GoogleSignInClient> googleSignInClientProvider;
    private Provider<LoginInteractor> loginInteractorProvider;
    private Provider<LoginService> loginServiceProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private MembersInjector<PSPAuthenticatorService> pSPAuthenticatorServiceMembersInjector;
    private Provider<PSPAuthenticatorListener> pspAuthenticatorListenerProvider;
    private Provider<PSPAuthenticator> pspAuthenticatorProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private Provider<ServicesProvider> servicesProvider;
    private Provider<StudentRepo> studentRepoProvider;
    private Provider<TokenRepository> tokenRepoProvider;
    private Provider<UserRepository> userRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPAuthenticatorModule pSPAuthenticatorModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;

        private Builder() {
        }

        public PSPAuthenticatorServiceComponent build() {
            if (this.pSPAuthenticatorModule != null) {
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerPSPAuthenticatorServiceComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(PSPAuthenticatorModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder pSPAuthenticatorModule(PSPAuthenticatorModule pSPAuthenticatorModule) {
            this.pSPAuthenticatorModule = (PSPAuthenticatorModule) Preconditions.checkNotNull(pSPAuthenticatorModule);
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

    private static class C0709xd5c90542 implements Provider<AccountManager> {
        private final PSPComponent pSPComponent;

        C0709xd5c90542(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AccountManager get() {
            return (AccountManager) Preconditions.checkNotNull(this.pSPComponent.accountManager(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0710x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0710x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0711x81c4dc2b implements Provider<ApplicationService> {
        private final PSPComponent pSPComponent;

        C0711x81c4dc2b(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ApplicationService get() {
            return (ApplicationService) Preconditions.checkNotNull(this.pSPComponent.checkApplicationService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0712x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0712x2fda2dc6(PSPComponent pSPComponent) {
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

    private static class C0713xbb6ddc0a implements Provider<GoogleApiClient> {
        private final PSPComponent pSPComponent;

        C0713xbb6ddc0a(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleApiClient get() {
            return (GoogleApiClient) Preconditions.checkNotNull(this.pSPComponent.googleApiClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0714x67334a88 implements Provider<GoogleSignInClient> {
        private final PSPComponent pSPComponent;

        C0714x67334a88(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public GoogleSignInClient get() {
            return (GoogleSignInClient) Preconditions.checkNotNull(this.pSPComponent.googleSignInClient(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0715x3357740e implements Provider<LoginService> {
        private final PSPComponent pSPComponent;

        C0715x3357740e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public LoginService get() {
            return (LoginService) Preconditions.checkNotNull(this.pSPComponent.loginService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0716xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0716xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0717xcf3a6871 implements Provider<ServicesProvider> {
        private final PSPComponent pSPComponent;

        C0717xcf3a6871(PSPComponent pSPComponent) {
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

    private DaggerPSPAuthenticatorServiceComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.contextProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_context(builder.pSPComponent);
        this.pspAuthenticatorListenerProvider = DoubleCheck.provider(PSPAuthenticatorModule_PspAuthenticatorListenerFactory.create(builder.pSPAuthenticatorModule));
        this.pspAuthenticatorProvider = DoubleCheck.provider(PSPAuthenticatorModule_PspAuthenticatorFactory.create(builder.pSPAuthenticatorModule, this.contextProvider, this.pspAuthenticatorListenerProvider));
        this.analyticsServiceProvider = new C0710x70a50c51(builder.pSPComponent);
        this.loginServiceProvider = new C0715x3357740e(builder.pSPComponent);
        this.checkApplicationServiceProvider = new C0711x81c4dc2b(builder.pSPComponent);
        this.userRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_userRepo(builder.pSPComponent);
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.configurationRepoProvider = new C0712x2fda2dc6(builder.pSPComponent);
        this.networkRepoProvider = new C0716xbc4e3d7e(builder.pSPComponent);
        this.servicesProvider = new C0717xcf3a6871(builder.pSPComponent);
        this.studentRepoProvider = RepoModule_StudentRepoFactory.create(builder.repoModule);
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.accountManagerProvider = new C0709xd5c90542(builder.pSPComponent);
        this.googleSignInClientProvider = new C0714x67334a88(builder.pSPComponent);
        this.googleApiClientProvider = new C0713xbb6ddc0a(builder.pSPComponent);
        this.loginInteractorProvider = InteractorModule_LoginInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.loginServiceProvider, this.checkApplicationServiceProvider, this.userRepoProvider, this.tokenRepoProvider, this.configurationRepoProvider, this.networkRepoProvider, this.servicesProvider, this.studentRepoProvider, this.schoolRepoProvider, this.accountManagerProvider, this.contextProvider, this.googleSignInClientProvider, this.googleApiClientProvider);
        this.authServicePresenterProvider = DoubleCheck.provider(PSPAuthenticatorModule_AuthServicePresenterFactory.create(builder.pSPAuthenticatorModule, this.loginInteractorProvider));
        this.pSPAuthenticatorServiceMembersInjector = PSPAuthenticatorService_MembersInjector.create(this.pspAuthenticatorProvider, this.authServicePresenterProvider);
    }

    public void inject(PSPAuthenticatorService pSPAuthenticatorService) {
        this.pSPAuthenticatorServiceMembersInjector.injectMembers(pSPAuthenticatorService);
    }
}
