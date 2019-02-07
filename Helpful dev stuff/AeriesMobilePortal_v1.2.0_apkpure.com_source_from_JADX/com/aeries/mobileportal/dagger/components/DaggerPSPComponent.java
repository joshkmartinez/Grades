package com.aeries.mobileportal.dagger.components;

import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.PSPApplication_MembersInjector;
import com.aeries.mobileportal.dagger.modules.AuthModule;
import com.aeries.mobileportal.dagger.modules.AuthModule_AccManagerFactory;
import com.aeries.mobileportal.dagger.modules.AuthModule_TokenProviderFactory;
import com.aeries.mobileportal.dagger.modules.ContextModule;
import com.aeries.mobileportal.dagger.modules.ContextModule_ContextFactory;
import com.aeries.mobileportal.dagger.modules.GoogleSignInModule;
import com.aeries.mobileportal.dagger.modules.GoogleSignInModule_GoogleApiClientFactory;
import com.aeries.mobileportal.dagger.modules.GoogleSignInModule_GoogleSignInClientFactory;
import com.aeries.mobileportal.dagger.modules.GoogleSignInModule_GoogleSignInOptionsFactory;
import com.aeries.mobileportal.dagger.modules.ImageModule;
import com.aeries.mobileportal.dagger.modules.ImageModule_ClientFactory;
import com.aeries.mobileportal.dagger.modules.ImageModule_DownloaderFactory;
import com.aeries.mobileportal.dagger.modules.ImageModule_ImageLoaderFactory;
import com.aeries.mobileportal.dagger.modules.ImageModule_PicassoFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule;
import com.aeries.mobileportal.dagger.modules.NetworkModule_AttendanceServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_CheckApplicationServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_ContactsServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_CreateAccountServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_FeedbackServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_GradesServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_LinkStudentServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_LogInServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_NotificationServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_PasswordServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_ReportCardServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_RestrictionServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_RetrofitBuilderFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_ServiceContainerFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_SignalKitServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_SupplementalAttendanceServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkModule_WhatIfServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_AnalyticsOkHttpClientFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_AnalyticsRetrofitFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_AnalyticsServiceFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_AuthenticatorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_ConverterFactoryFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_CookieJarFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_GsonFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_LoggingInterceptorFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_OkHttpClientFactory;
import com.aeries.mobileportal.dagger.modules.NetworkUtilsModule_TokenManagerFactory;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_ConfigurationPreferencesFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_ConfigurationRepositoryFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_NetworkPreferencesFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_NetworkRepositoryFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_RestrictionPreferencesFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_RestrictionRepositoryFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_TokenPreferencesFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_TokenRepositoryFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_UserPreferencesFactory;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule_UserRepositoryFactory;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.ImageLoader;
import com.aeries.mobileportal.web_services.PSPTokenAuthenticator;
import com.aeries.mobileportal.web_services.TokenManager;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import com.aeries.mobileportal.web_services.services.ContactsService;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.aeries.mobileportal.web_services.services.SignalKitService;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

public final class DaggerPSPComponent implements PSPComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AccountManager> accManagerProvider;
    private Provider<OkHttpClient> analyticsOkHttpClientProvider;
    private Provider<Retrofit> analyticsRetrofitProvider;
    private Provider<AnalyticsService> analyticsServiceProvider;
    private Provider<AttendanceService> attendanceServiceProvider;
    private Provider<PSPTokenAuthenticator> authenticatorProvider;
    private Provider<ApplicationService> checkApplicationServiceProvider;
    private Provider<OkHttpClient> clientProvider;
    private Provider<SharedPreferences> configurationPreferencesProvider;
    private Provider<ConfigurationRepository> configurationRepositoryProvider;
    private Provider<ContactsService> contactsServiceProvider;
    private Provider<Context> contextProvider;
    private Provider<Factory> converterFactoryProvider;
    private Provider<CookieJar> cookieJarProvider;
    private Provider<CreateAccountService> createAccountServiceProvider;
    private Provider<OkHttp3Downloader> downloaderProvider;
    private Provider<FeedbackService> feedbackServiceProvider;
    private Provider<GoogleApiClient> googleApiClientProvider;
    private Provider<GoogleSignInClient> googleSignInClientProvider;
    private Provider<GoogleSignInOptions> googleSignInOptionsProvider;
    private Provider<GradesService> gradesServiceProvider;
    private Provider<Gson> gsonProvider;
    private Provider<ImageLoader> imageLoaderProvider;
    private Provider<LinkStudentService> linkStudentServiceProvider;
    private Provider<LoginService> logInServiceProvider;
    private Provider<HttpLoggingInterceptor> loggingInterceptorProvider;
    private Provider<SharedPreferences> networkPreferencesProvider;
    private Provider<NetworkRepo> networkRepositoryProvider;
    private Provider<NotificationService> notificationServiceProvider;
    private Provider<OkHttpClient> okHttpClientProvider;
    private MembersInjector<PSPApplication> pSPApplicationMembersInjector;
    private Provider<PasswordService> passwordServiceProvider;
    private Provider<Picasso> picassoProvider;
    private Provider<ReportCardService> reportCardServiceProvider;
    private Provider<SharedPreferences> restrictionPreferencesProvider;
    private Provider<RestrictionRepository> restrictionRepositoryProvider;
    private Provider<RestrictionService> restrictionServiceProvider;
    private Provider<retrofit2.Retrofit.Builder> retrofitBuilderProvider;
    private Provider<ServicesProvider> serviceContainerProvider;
    private Provider<SignalKitService> signalKitServiceProvider;
    private Provider<SupplementalAttendanceService> supplementalAttendanceServiceProvider;
    private Provider<TokenManager> tokenManagerProvider;
    private Provider<SharedPreferences> tokenPreferencesProvider;
    private Provider<TokenProvider> tokenProvider;
    private Provider<TokenRepository> tokenRepositoryProvider;
    private Provider<SharedPreferences> userPreferencesProvider;
    private Provider<UserRepository> userRepositoryProvider;
    private Provider<WhatIfService> whatIfServiceProvider;

    public static final class Builder {
        private AuthModule authModule;
        private ContextModule contextModule;
        private GoogleSignInModule googleSignInModule;
        private ImageModule imageModule;
        private NetworkModule networkModule;
        private NetworkUtilsModule networkUtilsModule;
        private SharedPreferencesModule sharedPreferencesModule;

        private Builder() {
        }

        public PSPComponent build() {
            if (this.contextModule != null) {
                if (this.sharedPreferencesModule == null) {
                    this.sharedPreferencesModule = new SharedPreferencesModule();
                }
                if (this.networkUtilsModule == null) {
                    this.networkUtilsModule = new NetworkUtilsModule();
                }
                if (this.authModule == null) {
                    this.authModule = new AuthModule();
                }
                if (this.networkModule == null) {
                    this.networkModule = new NetworkModule();
                }
                if (this.googleSignInModule == null) {
                    this.googleSignInModule = new GoogleSignInModule();
                }
                if (this.imageModule != null) {
                    return new DaggerPSPComponent();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(ImageModule.class.getCanonicalName());
                stringBuilder.append(" must be set");
                throw new IllegalStateException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(ContextModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder networkModule(NetworkModule networkModule) {
            this.networkModule = (NetworkModule) Preconditions.checkNotNull(networkModule);
            return this;
        }

        public Builder networkUtilsModule(NetworkUtilsModule networkUtilsModule) {
            this.networkUtilsModule = (NetworkUtilsModule) Preconditions.checkNotNull(networkUtilsModule);
            return this;
        }

        public Builder contextModule(ContextModule contextModule) {
            this.contextModule = (ContextModule) Preconditions.checkNotNull(contextModule);
            return this;
        }

        public Builder sharedPreferencesModule(SharedPreferencesModule sharedPreferencesModule) {
            this.sharedPreferencesModule = (SharedPreferencesModule) Preconditions.checkNotNull(sharedPreferencesModule);
            return this;
        }

        public Builder authModule(AuthModule authModule) {
            this.authModule = (AuthModule) Preconditions.checkNotNull(authModule);
            return this;
        }

        public Builder googleSignInModule(GoogleSignInModule googleSignInModule) {
            this.googleSignInModule = (GoogleSignInModule) Preconditions.checkNotNull(googleSignInModule);
            return this;
        }

        public Builder imageModule(ImageModule imageModule) {
            this.imageModule = (ImageModule) Preconditions.checkNotNull(imageModule);
            return this;
        }
    }

    private DaggerPSPComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.contextProvider = DoubleCheck.provider(ContextModule_ContextFactory.create(builder.contextModule));
        this.tokenPreferencesProvider = DoubleCheck.provider(SharedPreferencesModule_TokenPreferencesFactory.create(builder.sharedPreferencesModule, this.contextProvider));
        this.tokenRepositoryProvider = DoubleCheck.provider(SharedPreferencesModule_TokenRepositoryFactory.create(builder.sharedPreferencesModule, this.tokenPreferencesProvider));
        this.pSPApplicationMembersInjector = PSPApplication_MembersInjector.create(this.tokenRepositoryProvider);
        this.gsonProvider = DoubleCheck.provider(NetworkUtilsModule_GsonFactory.create(builder.networkUtilsModule));
        this.loggingInterceptorProvider = DoubleCheck.provider(NetworkUtilsModule_LoggingInterceptorFactory.create(builder.networkUtilsModule));
        this.userPreferencesProvider = DoubleCheck.provider(SharedPreferencesModule_UserPreferencesFactory.create(builder.sharedPreferencesModule, this.contextProvider));
        this.userRepositoryProvider = DoubleCheck.provider(SharedPreferencesModule_UserRepositoryFactory.create(builder.sharedPreferencesModule, this.userPreferencesProvider));
        this.accManagerProvider = DoubleCheck.provider(AuthModule_AccManagerFactory.create(builder.authModule, this.contextProvider));
        this.tokenProvider = DoubleCheck.provider(AuthModule_TokenProviderFactory.create(builder.authModule, this.accManagerProvider, this.userRepositoryProvider, this.tokenRepositoryProvider));
        this.tokenManagerProvider = DoubleCheck.provider(NetworkUtilsModule_TokenManagerFactory.create(builder.networkUtilsModule, this.userRepositoryProvider, this.tokenProvider, this.contextProvider));
        this.authenticatorProvider = DoubleCheck.provider(NetworkUtilsModule_AuthenticatorFactory.create(builder.networkUtilsModule, this.tokenManagerProvider));
        this.cookieJarProvider = DoubleCheck.provider(NetworkUtilsModule_CookieJarFactory.create(builder.networkUtilsModule, this.contextProvider));
        this.okHttpClientProvider = DoubleCheck.provider(NetworkUtilsModule_OkHttpClientFactory.create(builder.networkUtilsModule, this.loggingInterceptorProvider, this.authenticatorProvider, this.cookieJarProvider));
        this.retrofitBuilderProvider = DoubleCheck.provider(NetworkModule_RetrofitBuilderFactory.create(builder.networkModule, this.gsonProvider, this.okHttpClientProvider));
        this.networkPreferencesProvider = DoubleCheck.provider(SharedPreferencesModule_NetworkPreferencesFactory.create(builder.sharedPreferencesModule, this.contextProvider));
        this.networkRepositoryProvider = DoubleCheck.provider(SharedPreferencesModule_NetworkRepositoryFactory.create(builder.sharedPreferencesModule, this.networkPreferencesProvider));
        this.serviceContainerProvider = DoubleCheck.provider(NetworkModule_ServiceContainerFactory.create(builder.networkModule, this.retrofitBuilderProvider, this.networkRepositoryProvider));
        this.logInServiceProvider = NetworkModule_LogInServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.configurationPreferencesProvider = DoubleCheck.provider(SharedPreferencesModule_ConfigurationPreferencesFactory.create(builder.sharedPreferencesModule, this.contextProvider));
        this.configurationRepositoryProvider = DoubleCheck.provider(SharedPreferencesModule_ConfigurationRepositoryFactory.create(builder.sharedPreferencesModule, this.configurationPreferencesProvider));
        this.restrictionPreferencesProvider = DoubleCheck.provider(SharedPreferencesModule_RestrictionPreferencesFactory.create(builder.sharedPreferencesModule, this.contextProvider));
        this.restrictionRepositoryProvider = DoubleCheck.provider(SharedPreferencesModule_RestrictionRepositoryFactory.create(builder.sharedPreferencesModule, this.restrictionPreferencesProvider));
        this.googleSignInOptionsProvider = DoubleCheck.provider(GoogleSignInModule_GoogleSignInOptionsFactory.create(builder.googleSignInModule, this.contextProvider));
        this.googleSignInClientProvider = DoubleCheck.provider(GoogleSignInModule_GoogleSignInClientFactory.create(builder.googleSignInModule, this.contextProvider, this.googleSignInOptionsProvider));
        this.googleApiClientProvider = DoubleCheck.provider(GoogleSignInModule_GoogleApiClientFactory.create(builder.googleSignInModule, this.contextProvider, this.googleSignInOptionsProvider));
        this.gradesServiceProvider = NetworkModule_GradesServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.contactsServiceProvider = NetworkModule_ContactsServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.attendanceServiceProvider = NetworkModule_AttendanceServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.signalKitServiceProvider = NetworkModule_SignalKitServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.createAccountServiceProvider = NetworkModule_CreateAccountServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.passwordServiceProvider = NetworkModule_PasswordServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.linkStudentServiceProvider = NetworkModule_LinkStudentServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.converterFactoryProvider = DoubleCheck.provider(NetworkUtilsModule_ConverterFactoryFactory.create(builder.networkUtilsModule));
        this.analyticsOkHttpClientProvider = DoubleCheck.provider(NetworkUtilsModule_AnalyticsOkHttpClientFactory.create(builder.networkUtilsModule, this.loggingInterceptorProvider, this.cookieJarProvider));
        this.analyticsRetrofitProvider = NetworkUtilsModule_AnalyticsRetrofitFactory.create(builder.networkUtilsModule, this.gsonProvider, this.converterFactoryProvider, this.analyticsOkHttpClientProvider);
        this.analyticsServiceProvider = NetworkUtilsModule_AnalyticsServiceFactory.create(builder.networkUtilsModule, this.analyticsRetrofitProvider);
        this.supplementalAttendanceServiceProvider = NetworkModule_SupplementalAttendanceServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.checkApplicationServiceProvider = NetworkModule_CheckApplicationServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.feedbackServiceProvider = NetworkModule_FeedbackServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.restrictionServiceProvider = NetworkModule_RestrictionServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.whatIfServiceProvider = NetworkModule_WhatIfServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.reportCardServiceProvider = NetworkModule_ReportCardServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.notificationServiceProvider = NetworkModule_NotificationServiceFactory.create(builder.networkModule, this.serviceContainerProvider);
        this.clientProvider = DoubleCheck.provider(ImageModule_ClientFactory.create(builder.imageModule, this.tokenProvider));
        this.downloaderProvider = DoubleCheck.provider(ImageModule_DownloaderFactory.create(builder.imageModule, this.clientProvider));
        this.picassoProvider = DoubleCheck.provider(ImageModule_PicassoFactory.create(builder.imageModule, this.downloaderProvider));
        this.imageLoaderProvider = DoubleCheck.provider(ImageModule_ImageLoaderFactory.create(builder.imageModule, this.networkRepositoryProvider, this.picassoProvider));
    }

    public void inject(PSPApplication pSPApplication) {
        this.pSPApplicationMembersInjector.injectMembers(pSPApplication);
    }

    public LoginService loginService() {
        return (LoginService) this.logInServiceProvider.get();
    }

    public NetworkRepo networkRepo() {
        return (NetworkRepo) this.networkRepositoryProvider.get();
    }

    public TokenRepository tokenRepo() {
        return (TokenRepository) this.tokenRepositoryProvider.get();
    }

    public UserRepository userRepo() {
        return (UserRepository) this.userRepositoryProvider.get();
    }

    public ConfigurationRepository configurationRepo() {
        return (ConfigurationRepository) this.configurationRepositoryProvider.get();
    }

    public RestrictionRepository restrictionRepo() {
        return (RestrictionRepository) this.restrictionRepositoryProvider.get();
    }

    public GoogleSignInClient googleSignInClient() {
        return (GoogleSignInClient) this.googleSignInClientProvider.get();
    }

    public GoogleApiClient googleApiClient() {
        return (GoogleApiClient) this.googleApiClientProvider.get();
    }

    public GradesService gradesService() {
        return (GradesService) this.gradesServiceProvider.get();
    }

    public ContactsService contactsService() {
        return (ContactsService) this.contactsServiceProvider.get();
    }

    public AttendanceService attendanceService() {
        return (AttendanceService) this.attendanceServiceProvider.get();
    }

    public SignalKitService signalKitService() {
        return (SignalKitService) this.signalKitServiceProvider.get();
    }

    public CreateAccountService createAccountService() {
        return (CreateAccountService) this.createAccountServiceProvider.get();
    }

    public PasswordService passwordService() {
        return (PasswordService) this.passwordServiceProvider.get();
    }

    public LinkStudentService linkStudentService() {
        return (LinkStudentService) this.linkStudentServiceProvider.get();
    }

    public AnalyticsService analyticsService() {
        return (AnalyticsService) this.analyticsServiceProvider.get();
    }

    public SupplementalAttendanceService supplementalAttendanceService() {
        return (SupplementalAttendanceService) this.supplementalAttendanceServiceProvider.get();
    }

    public ApplicationService checkApplicationService() {
        return (ApplicationService) this.checkApplicationServiceProvider.get();
    }

    public FeedbackService feedbackService() {
        return (FeedbackService) this.feedbackServiceProvider.get();
    }

    public RestrictionService restrictedService() {
        return (RestrictionService) this.restrictionServiceProvider.get();
    }

    public ServicesProvider servicesProvider() {
        return (ServicesProvider) this.serviceContainerProvider.get();
    }

    public WhatIfService whatIfService() {
        return (WhatIfService) this.whatIfServiceProvider.get();
    }

    public ReportCardService reportCardService() {
        return (ReportCardService) this.reportCardServiceProvider.get();
    }

    public NotificationService notificationService() {
        return (NotificationService) this.notificationServiceProvider.get();
    }

    public Context context() {
        return (Context) this.contextProvider.get();
    }

    public AccountManager accountManager() {
        return (AccountManager) this.accManagerProvider.get();
    }

    public TokenProvider tokenProvider() {
        return (TokenProvider) this.tokenProvider.get();
    }

    public ImageLoader imageLoader() {
        return (ImageLoader) this.imageLoaderProvider.get();
    }
}
