package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.dagger.modules.InteractorModule;
import com.aeries.mobileportal.dagger.modules.InteractorModule_SchoolSearchInteractorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_GsonFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_LoggingInterceptorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsSchoolModule_OkHttpClientFactory;
import com.aeries.mobileportal.dagger.modules.RepoModule;
import com.aeries.mobileportal.dagger.modules.RepoModule_SchoolRepoFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule_ApplicationServiceFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchNetworkModule_SchoolSearchRetrofitFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchPresenterModule;
import com.aeries.mobileportal.dagger.modules.SchoolSearchPresenterModule_SchoolSearchPresenterFactory;
import com.aeries.mobileportal.dagger.modules.SchoolSearchPresenterModule_SchoolSearchViewModelFactory;
import com.aeries.mobileportal.interactors.school.select.SchoolSearchInteractor;
import com.aeries.mobileportal.presenters.school.select.SchoolSearchPresenter;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.views.activities.SchoolSearchActivity;
import com.aeries.mobileportal.views.activities.SchoolSearchActivity_MembersInjector;
import com.aeries.mobileportal.views.viewmodels.school_select.SchoolSearchViewModel;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import com.google.gson.Gson;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

public final class DaggerSchoolSearchActivityComponent implements SchoolSearchActivityComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<ApplicationStartupService> applicationServiceProvider;
    private Provider<ConfigurationRepository> configurationRepoProvider;
    private Provider<Gson> gsonProvider;
    private Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private Provider<NetworkRepo> networkRepoProvider;
    private Provider<OkHttpClient> okHttpClientProvider;
    private Provider<SchoolRepo> schoolRepoProvider;
    private MembersInjector<SchoolSearchActivity> schoolSearchActivityMembersInjector;
    private Provider<SchoolSearchInteractor> schoolSearchInteractorProvider;
    private Provider<SchoolSearchPresenter> schoolSearchPresenterProvider;
    private Provider<Retrofit> schoolSearchRetrofitProvider;
    private Provider<SchoolSearchViewModel> schoolSearchViewModelProvider;

    public static final class Builder {
        private InteractorModule interactorModule;
        private NetworkUtilsSchoolModule networkUtilsSchoolModule;
        private PSPComponent pSPComponent;
        private RepoModule repoModule;
        private SchoolSearchNetworkModule schoolSearchNetworkModule;
        private SchoolSearchPresenterModule schoolSearchPresenterModule;

        private Builder() {
        }

        public SchoolSearchActivityComponent build() {
            if (this.schoolSearchPresenterModule != null) {
                if (this.networkUtilsSchoolModule == null) {
                    this.networkUtilsSchoolModule = new NetworkUtilsSchoolModule();
                }
                if (this.schoolSearchNetworkModule == null) {
                    this.schoolSearchNetworkModule = new SchoolSearchNetworkModule();
                }
                if (this.repoModule == null) {
                    this.repoModule = new RepoModule();
                }
                if (this.interactorModule == null) {
                    this.interactorModule = new InteractorModule();
                }
                if (this.pSPComponent != null) {
                    return new DaggerSchoolSearchActivityComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(PSPComponent.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(SchoolSearchPresenterModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder schoolSearchPresenterModule(SchoolSearchPresenterModule schoolSearchPresenterModule) {
            this.schoolSearchPresenterModule = (SchoolSearchPresenterModule) Preconditions.checkNotNull(schoolSearchPresenterModule);
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

        public Builder schoolSearchNetworkModule(SchoolSearchNetworkModule schoolSearchNetworkModule) {
            this.schoolSearchNetworkModule = (SchoolSearchNetworkModule) Preconditions.checkNotNull(schoolSearchNetworkModule);
            return this;
        }

        public Builder networkUtilsSchoolModule(NetworkUtilsSchoolModule networkUtilsSchoolModule) {
            this.networkUtilsSchoolModule = (NetworkUtilsSchoolModule) Preconditions.checkNotNull(networkUtilsSchoolModule);
            return this;
        }

        public Builder pSPComponent(PSPComponent pSPComponent) {
            this.pSPComponent = (PSPComponent) Preconditions.checkNotNull(pSPComponent);
            return this;
        }
    }

    private static class C0721x70a50c51 implements Provider<AnalyticsService> {
        private final PSPComponent pSPComponent;

        C0721x70a50c51(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public AnalyticsService get() {
            return (AnalyticsService) Preconditions.checkNotNull(this.pSPComponent.analyticsService(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0722x2fda2dc6 implements Provider<ConfigurationRepository> {
        private final PSPComponent pSPComponent;

        C0722x2fda2dc6(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public ConfigurationRepository get() {
            return (ConfigurationRepository) Preconditions.checkNotNull(this.pSPComponent.configurationRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private static class C0723xbc4e3d7e implements Provider<NetworkRepo> {
        private final PSPComponent pSPComponent;

        C0723xbc4e3d7e(PSPComponent pSPComponent) {
            this.pSPComponent = pSPComponent;
        }

        public NetworkRepo get() {
            return (NetworkRepo) Preconditions.checkNotNull(this.pSPComponent.networkRepo(), "Cannot return null from a non-@Nullable component method");
        }
    }

    private DaggerSchoolSearchActivityComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.schoolSearchViewModelProvider = DoubleCheck.provider(SchoolSearchPresenterModule_SchoolSearchViewModelFactory.create(builder.schoolSearchPresenterModule));
        this.analyticsServiceProvider = new C0721x70a50c51(builder.pSPComponent);
        this.gsonProvider = NetworkUtilsSchoolModule_GsonFactory.create(builder.networkUtilsSchoolModule);
        this.loggingInterceptorProvider = NetworkUtilsSchoolModule_LoggingInterceptorFactory.create(builder.networkUtilsSchoolModule);
        this.okHttpClientProvider = NetworkUtilsSchoolModule_OkHttpClientFactory.create(builder.networkUtilsSchoolModule, this.loggingInterceptorProvider);
        this.schoolSearchRetrofitProvider = SchoolSearchNetworkModule_SchoolSearchRetrofitFactory.create(builder.schoolSearchNetworkModule, this.gsonProvider, this.okHttpClientProvider);
        this.applicationServiceProvider = DoubleCheck.provider(SchoolSearchNetworkModule_ApplicationServiceFactory.create(builder.schoolSearchNetworkModule, this.schoolSearchRetrofitProvider));
        this.schoolRepoProvider = RepoModule_SchoolRepoFactory.create(builder.repoModule);
        this.networkRepoProvider = new C0723xbc4e3d7e(builder.pSPComponent);
        this.configurationRepoProvider = new C0722x2fda2dc6(builder.pSPComponent);
        this.schoolSearchInteractorProvider = DoubleCheck.provider(InteractorModule_SchoolSearchInteractorFactory.create(builder.interactorModule, this.analyticsServiceProvider, this.applicationServiceProvider, this.schoolRepoProvider, this.networkRepoProvider, this.configurationRepoProvider));
        this.schoolSearchPresenterProvider = DoubleCheck.provider(SchoolSearchPresenterModule_SchoolSearchPresenterFactory.create(builder.schoolSearchPresenterModule, this.schoolSearchViewModelProvider, this.schoolSearchInteractorProvider));
        this.schoolSearchActivityMembersInjector = SchoolSearchActivity_MembersInjector.create(this.schoolSearchPresenterProvider);
    }

    public void inject(SchoolSearchActivity schoolSearchActivity) {
        this.schoolSearchActivityMembersInjector.injectMembers(schoolSearchActivity);
    }
}
