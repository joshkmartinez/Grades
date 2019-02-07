package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_SplashScreenInteractorFactory;
import com.aeries.mobileportal.dagger.modules.SplashScreenPresenterModule;
import com.aeries.mobileportal.dagger.modules.SplashScreenPresenterModule_SplashScreenPresenterFactory;
import com.aeries.mobileportal.interactors.splashscreen.SplashScreenInteractor;
import com.aeries.mobileportal.presenters.splashscreen.SplashScreenPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.views.activities.SplashScreenActivity;
import com.aeries.mobileportal.views.activities.SplashScreenActivity_MembersInjector;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerSplashScreenActivityComponent implements SplashScreenActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private MembersInjector<SplashScreenActivity> splashScreenActivityMembersInjector;
    private Provider<SplashScreenInteractor> splashScreenInteractorProvider;
    private Provider<SplashScreenPresenter> splashScreenPresenterProvider;
    private Provider<TokenRepository> tokenRepoProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private PSPComponent pSPComponent;
        private SplashScreenPresenterModule splashScreenPresenterModule;

        private Builder() {
        }

        public SplashScreenActivityComponent build() {
            if (this.interactorModule == null) {
                this.interactorModule = new InteractorModule();
            }
            StringBuilder stringBuilder;
            if (this.splashScreenPresenterModule == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(SplashScreenPresenterModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.pSPComponent != null) {
                return new DaggerSplashScreenActivityComponent();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        public Builder splashScreenPresenterModule(SplashScreenPresenterModule splashScreenPresenterModule) {
            this.splashScreenPresenterModule = (SplashScreenPresenterModule) Preconditions.checkNotNull(splashScreenPresenterModule);
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

    private static class C0724x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0724x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0725x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0725x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0726xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0726xbc4e3d7e(PSPComponent pSPComponent) {
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

    private DaggerSplashScreenActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.tokenRepoProvider = new com_aeries_mobileportal_dagger_components_PSPComponent_tokenRepo(builder.pSPComponent);
        this.analyticsServiceProvider = new C0724x70a50c51(builder.pSPComponent);
        this.splashScreenInteractorProvider = DoubleCheck.provider(InteractorModule_SplashScreenInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider));
        this.splashScreenPresenterProvider = DoubleCheck.provider(SplashScreenPresenterModule_SplashScreenPresenterFactory.create(builder.splashScreenPresenterModule, this.splashScreenInteractorProvider));
        this.networkRepoProvider = new C0726xbc4e3d7e(builder.pSPComponent);
        this.configurationRepoProvider = new C0725x2fda2dc6(builder.pSPComponent);
        this.splashScreenActivityMembersInjector = SplashScreenActivity_MembersInjector.create(this.tokenRepoProvider, this.splashScreenPresenterProvider, this.networkRepoProvider, this.configurationRepoProvider);
    }

    public void inject(SplashScreenActivity splashScreenActivity) {
        this.splashScreenActivityMembersInjector.injectMembers(splashScreenActivity);
    }
}
