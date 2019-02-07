package com.aeries.mobileportal.interactors.login;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;
import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.AccountSettings;
import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.models.User;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.views.activities.AuthenticationActivity;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\u0018\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u000e\u0010A\u001a\u00020<2\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020<J\u0016\u0010E\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010B\u001a\u00020CJ\u000e\u0010F\u001a\u00020<2\u0006\u0010B\u001a\u00020CJ\u000e\u0010G\u001a\u00020<2\u0006\u0010B\u001a\u00020CJ\u0016\u0010H\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010B\u001a\u00020CJ\u0016\u0010I\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010J\u001a\u00020CJ\u0010\u0010I\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020KJ\b\u0010M\u001a\u00020<H\u0002J\u0006\u0010N\u001a\u00020<J\u0010\u0010O\u001a\u00020<2\u0006\u0010P\u001a\u00020QH\u0002J\u0012\u0010R\u001a\u00020<2\b\u0010S\u001a\u0004\u0018\u00010@H\u0002J\u000e\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020KJ\u0016\u0010V\u001a\u00020<2\u0006\u0010W\u001a\u00020X2\u0006\u0010B\u001a\u00020CJ\u0010\u0010Y\u001a\u00020<2\b\u0010S\u001a\u0004\u0018\u00010@J\u000e\u0010Z\u001a\u00020<2\u0006\u0010[\u001a\u00020\\J\u0010\u0010]\u001a\u00020<2\b\u0010S\u001a\u0004\u0018\u00010@J\u0010\u0010^\u001a\u00020<2\b\u0010S\u001a\u0004\u0018\u00010@J\u0010\u0010_\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0002R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:¨\u0006`"}, d2 = {"Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "loginService", "Lcom/aeries/mobileportal/web_services/services/LoginService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "userRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "servicesProvider", "Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "studentRealmRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolsRealmRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "accountManager", "Landroid/accounts/AccountManager;", "context", "Landroid/content/Context;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/LoginService;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Landroid/accounts/AccountManager;Landroid/content/Context;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;Lcom/google/android/gms/common/api/GoogleApiClient;)V", "getAccountManager", "()Landroid/accounts/AccountManager;", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getContext", "()Landroid/content/Context;", "getGoogleApiClient", "()Lcom/google/android/gms/common/api/GoogleApiClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getLoginService", "()Lcom/aeries/mobileportal/web_services/services/LoginService;", "getNetworkRepository", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "getSchoolsRealmRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getServicesProvider", "()Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "getStudentRealmRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenRepo", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getUserRepo", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "addAccountToManager", "", "user", "Lcom/aeries/mobileportal/models/User;", "it", "Lcom/aeries/mobileportal/models/AuthenticationData;", "checkCreateAccountPermission", "callback", "Lcom/aeries/mobileportal/interactors/login/LoginCallback;", "checkFeedbackFlag", "getAuthToken", "getLastUserName", "getSchools", "getServerInfo", "login", "loginCallback", "", "password", "removeAccountFomManager", "sendAnalytics", "setAccountSettings", "settings", "Lcom/aeries/mobileportal/models/AccountSettings;", "setConfigurations", "authenticationData", "setLastUserName", "lastUserName", "setNewSchool", "school", "Lcom/aeries/mobileportal/models/School;", "storeDefaultStudent", "storeSignalKitEnabled", "signalKit", "", "storeStudents", "storeTokens", "storeUserCredentials", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LoginInteractor.kt */
public final class LoginInteractor extends BaseInteractor {
    @NotNull
    private final AccountManager accountManager;
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final GoogleApiClient googleApiClient;
    @NotNull
    private final GoogleSignInClient googleSignInClient;
    @NotNull
    private final LoginService loginService;
    @NotNull
    private final NetworkRepo networkRepository;
    @NotNull
    private final SchoolRepo schoolsRealmRepo;
    @NotNull
    private final ServicesProvider servicesProvider;
    @NotNull
    private final StudentRepo studentRealmRepo;
    @NotNull
    private final TokenRepository tokenRepo;
    @NotNull
    private final UserRepository userRepo;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final LoginService getLoginService() {
        return this.loginService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final UserRepository getUserRepo() {
        return this.userRepo;
    }

    @NotNull
    public final TokenRepository getTokenRepo() {
        return this.tokenRepo;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final NetworkRepo getNetworkRepository() {
        return this.networkRepository;
    }

    @NotNull
    public final ServicesProvider getServicesProvider() {
        return this.servicesProvider;
    }

    @NotNull
    public final StudentRepo getStudentRealmRepo() {
        return this.studentRealmRepo;
    }

    @NotNull
    public final SchoolRepo getSchoolsRealmRepo() {
        return this.schoolsRealmRepo;
    }

    @NotNull
    public final AccountManager getAccountManager() {
        return this.accountManager;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final GoogleSignInClient getGoogleSignInClient() {
        return this.googleSignInClient;
    }

    public LoginInteractor(@NotNull AnalyticsService analyticsService, @NotNull LoginService loginService, @NotNull ApplicationService applicationService, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull NetworkRepo networkRepo, @NotNull ServicesProvider servicesProvider, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull AccountManager accountManager, @NotNull Context context, @NotNull GoogleSignInClient googleSignInClient, @NotNull GoogleApiClient googleApiClient) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(loginService, "loginService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepo");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepo");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRealmRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolsRealmRepo");
        Intrinsics.checkParameterIsNotNull(accountManager, "accountManager");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(googleSignInClient, "googleSignInClient");
        Intrinsics.checkParameterIsNotNull(googleApiClient, "googleApiClient");
        this.analyticsService = analyticsService;
        this.loginService = loginService;
        this.applicationService = applicationService;
        this.userRepo = userRepository;
        this.tokenRepo = tokenRepository;
        this.configurationRepository = configurationRepository;
        this.networkRepository = networkRepo;
        this.servicesProvider = servicesProvider;
        this.studentRealmRepo = studentRepo;
        this.schoolsRealmRepo = schoolRepo;
        this.accountManager = accountManager;
        this.context = context;
        this.googleSignInClient = googleSignInClient;
        this.googleApiClient = googleApiClient;
    }

    @NotNull
    public final GoogleApiClient getGoogleApiClient() {
        return this.googleApiClient;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        School school = this.schoolsRealmRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String login_screen = AnalyticsScreenNames.Companion.getLOGIN_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getLOGIN_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        getDisposables().add(DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, login_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginInteractor$sendAnalytics$disposable$1.INSTANCE, LoginInteractor$sendAnalytics$disposable$2.INSTANCE));
                    }
                }
                schoolName = "";
                getDisposables().add(DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, login_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginInteractor$sendAnalytics$disposable$1.INSTANCE, LoginInteractor$sendAnalytics$disposable$2.INSTANCE));
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                getDisposables().add(DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, login_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginInteractor$sendAnalytics$disposable$1.INSTANCE, LoginInteractor$sendAnalytics$disposable$2.INSTANCE));
            }
        }
        schoolName = "";
        getDisposables().add(DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, login_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LoginInteractor$sendAnalytics$disposable$1.INSTANCE, LoginInteractor$sendAnalytics$disposable$2.INSTANCE));
    }

    public final void checkFeedbackFlag() {
        getDisposables().add(this.loginService.isFeedbackEnabled("http://stats.aeries.com/mobile-portal-feedback/flag.php").subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginInteractor$checkFeedbackFlag$disposable$1(this), LoginInteractor$checkFeedbackFlag$disposable$2.INSTANCE));
    }

    public final void checkCreateAccountPermission(@NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        loginCallback.onCreateAccountPermissionChecked(this.configurationRepository.isCreateAccountDisabled(), this.configurationRepository.isChangePasswordParentDisabled());
    }

    public final void getSchools(@NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        ArrayList<School> arrayList = new ArrayList(this.schoolsRealmRepo.getSchools());
        for (School school : arrayList) {
            school.setSelected(Intrinsics.areEqual(school.getAeriesAppParentURL(), StringsKt.removeSuffix(this.networkRepository.getCurrentBaseURL(), AppConstants.Companion.getURL_EXTENSION())));
        }
        loginCallback.onSchoolsRetrieved(arrayList);
    }

    public final void setNewSchool(@NotNull School school, @NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        ServicesProvider servicesProvider = this.servicesProvider;
        String aeriesAppParentURL = school.getAeriesAppParentURL();
        if (aeriesAppParentURL == null) {
            aeriesAppParentURL = "";
        }
        servicesProvider.setBaseURL(aeriesAppParentURL);
        this.configurationRepository.setSelectedSchoolCDS(school.getCDS());
        ApplicationService applicationService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("accountsettings/");
        school = applicationService.checkAppSettings(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new LoginInteractor$setNewSchool$1(this, loginCallback), new LoginInteractor$setNewSchool$2(loginCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    private final void setAccountSettings(AccountSettings accountSettings) {
        ConfigurationRepository configurationRepository = this.configurationRepository;
        configurationRepository.setCreateAccountDisabled(accountSettings.getDisableCreateAccount());
        configurationRepository.setChangePasswordParentDisabled(accountSettings.getDisableParentChangePassword());
        configurationRepository.setChangePasswordStudentDisabled(accountSettings.getDisableStudentChangePassword());
    }

    public final void getServerInfo(@NotNull User user, @NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        user = this.applicationService.getServerInfo().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new LoginInteractor$getServerInfo$1(this, user, loginCallback), (Consumer) new LoginInteractor$getServerInfo$2(loginCallback));
        Intrinsics.checkExpressionValueIsNotNull(user, "applicationService.getSe…      }\n                )");
        addToCompositeDisposable(user);
    }

    public final void login(@NotNull User user, @NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(loginCallback, "loginCallback");
        String nonFormattedPortalVersion = this.configurationRepository.getNonFormattedPortalVersion();
        if (nonFormattedPortalVersion == null) {
            Intrinsics.throwNpe();
        }
        boolean z = nonFormattedPortalVersion.compareTo("08180427") < 0;
        storeUserCredentials(user);
        user = this.loginService.getAccessToken(user).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginInteractor$login$1(this, loginCallback, user), (Consumer) new LoginInteractor$login$2(this, loginCallback, z));
        Intrinsics.checkExpressionValueIsNotNull(user, "loginService.getAccessTo…                       })");
        addToCompositeDisposable(user);
    }

    private final void addAccountToManager(User user, AuthenticationData authenticationData) {
        School school = user.getSchool();
        Account account = new Account(StringUtils.Companion.getAccountName(this.userRepo), AuthenticationActivity.Companion.getACCOUNT_TYPE());
        this.accountManager.addAccountExplicitly(account, user.getPassword(), null);
        AccountManager accountManager = this.accountManager;
        String auth_type = AuthenticationActivity.Companion.getAUTH_TYPE();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Bearer ");
        stringBuilder.append(authenticationData.getAccessToken());
        accountManager.setAuthToken(account, auth_type, stringBuilder.toString());
        this.accountManager.setPassword(account, user.getPassword());
        this.accountManager.setUserData(account, AuthenticationActivity.Companion.getDISTRICT_URL(), school.getAeriesAppParentURL());
        this.accountManager.setUserData(account, AuthenticationActivity.Companion.getSCHOOL_NAME(), school.getSchoolName());
        this.accountManager.setUserData(account, AuthenticationActivity.Companion.getSCHOOL_CDS(), school.getCDS());
        this.accountManager.setUserData(account, AuthenticationActivity.Companion.getUSERNAME(), user.getUsername());
        this.accountManager.setUserData(account, AuthenticationActivity.Companion.getREFRESH_TOKEN(), authenticationData.getRefreshToken());
    }

    private final void removeAccountFomManager() {
        this.accountManager.removeAccount(new Account(StringUtils.Companion.getAccountName(this.userRepo), AuthenticationActivity.Companion.getACCOUNT_TYPE()), null, null);
    }

    @Nullable
    public final String login(@NotNull String str) {
        int i;
        ConnectionResult blockingConnect;
        GoogleSignInAccount signInAccount;
        User user;
        String nonFormattedPortalVersion;
        AuthenticationData authenticationData;
        Intrinsics.checkParameterIsNotNull(str, "password");
        String str2 = null;
        GoogleSignInResult googleSignInResult = (GoogleSignInResult) null;
        CharSequence googleAccount = this.userRepo.getGoogleAccount();
        if (googleAccount != null) {
            if (googleAccount.length() != 0) {
                i = 0;
                i ^= 1;
                blockingConnect = r1.googleApiClient.blockingConnect();
                if (i != 0) {
                    Intrinsics.checkExpressionValueIsNotNull(blockingConnect, "connectionResult");
                    if (blockingConnect.isSuccess()) {
                        Log.w("GOOGLE_SIGN_IN", blockingConnect.getErrorMessage());
                    } else {
                        googleSignInResult = (GoogleSignInResult) Auth.GoogleSignInApi.silentSignIn(r1.googleApiClient).await();
                    }
                }
                signInAccount = googleSignInResult == null ? googleSignInResult.getSignInAccount() : null;
                if (i != 0) {
                    User user2 = new User(r1.userRepo.getUserName(), str, null, null, null, null, null, null, null, null, false, 2044, null);
                } else {
                    user = new User(null, null, signInAccount == null ? signInAccount.getEmail() : null, signInAccount == null ? signInAccount.getIdToken() : null, "Google", null, null, null, null, null, false, 2019, null);
                }
                nonFormattedPortalVersion = r1.configurationRepository.getNonFormattedPortalVersion();
                if (nonFormattedPortalVersion == null) {
                    Intrinsics.throwNpe();
                }
                if (nonFormattedPortalVersion.compareTo(BuildConfig.ENCRYPTION) < 0) {
                    user.useOldKeys();
                }
                authenticationData = (AuthenticationData) r1.loginService.getAccessTokenCall(user).execute().body();
                storeTokens(authenticationData);
                if (authenticationData != null) {
                    str2 = authenticationData.getAccessToken();
                }
                r1.googleApiClient.disconnect();
                return str2;
            }
        }
        i = 1;
        i ^= 1;
        try {
            blockingConnect = r1.googleApiClient.blockingConnect();
            if (i != 0) {
                Intrinsics.checkExpressionValueIsNotNull(blockingConnect, "connectionResult");
                if (blockingConnect.isSuccess()) {
                    Log.w("GOOGLE_SIGN_IN", blockingConnect.getErrorMessage());
                } else {
                    googleSignInResult = (GoogleSignInResult) Auth.GoogleSignInApi.silentSignIn(r1.googleApiClient).await();
                }
            }
            if (googleSignInResult == null) {
            }
            if (i != 0) {
                if (signInAccount == null) {
                }
                if (signInAccount == null) {
                }
                user = new User(null, null, signInAccount == null ? signInAccount.getEmail() : null, signInAccount == null ? signInAccount.getIdToken() : null, "Google", null, null, null, null, null, false, 2019, null);
            } else {
                User user22 = new User(r1.userRepo.getUserName(), str, null, null, null, null, null, null, null, null, false, 2044, null);
            }
            nonFormattedPortalVersion = r1.configurationRepository.getNonFormattedPortalVersion();
            if (nonFormattedPortalVersion == null) {
                Intrinsics.throwNpe();
            }
            if (nonFormattedPortalVersion.compareTo(BuildConfig.ENCRYPTION) < 0) {
                user.useOldKeys();
            }
            authenticationData = (AuthenticationData) r1.loginService.getAccessTokenCall(user).execute().body();
            storeTokens(authenticationData);
            if (authenticationData != null) {
                str2 = authenticationData.getAccessToken();
            }
        } catch (ApiException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("signInResult: failed code=");
            stringBuilder.append(e.getStatusCode());
            Log.w("Google SignIn", stringBuilder.toString());
        } catch (Throwable th) {
            r1.googleApiClient.disconnect();
        }
        r1.googleApiClient.disconnect();
        return str2;
    }

    private final void storeUserCredentials(User user) {
        this.userRepo.setUserName(user.getUsername());
        this.userRepo.setPassword(user.getPassword());
        this.userRepo.setSecretKey(user.getSecretKey());
        this.userRepo.setClientID(user.getClientID());
        this.userRepo.setSchoolName(user.getSchool().getSchoolName());
        this.userRepo.setGoogleAccount(user.getGoogleAccount());
        this.userRepo.setGoogleToken(user.getGoogleToken());
    }

    private final void setConfigurations(AuthenticationData authenticationData) {
        boolean z = false;
        this.configurationRepository.setForceLogoutForPortalVersion(false);
        CharSequence googleAccount = this.userRepo.getGoogleAccount();
        if (googleAccount == null || googleAccount.length() == 0) {
            z = true;
        }
        if (!z) {
            this.configurationRepository.setChangePasswordParentDisabled(true);
            this.configurationRepository.setChangePasswordStudentDisabled(true);
        }
        ConfigurationRepository configurationRepository = this.configurationRepository;
        Object obj = null;
        if (Intrinsics.areEqual(authenticationData != null ? authenticationData.getUserType() : null, (Object) "Student") && this.configurationRepository.isChangePasswordStudentDisabled()) {
            authenticationData = AppConstants.Companion.getSTUDENT_SETTINGS_NO_CHANGE_PASSWORD();
        } else {
            if (Intrinsics.areEqual(authenticationData != null ? authenticationData.getUserType() : null, (Object) "Parent") && this.configurationRepository.isChangePasswordParentDisabled()) {
                authenticationData = AppConstants.Companion.getPARENT_SETTINGS_NO_CHANGE_PASSWORD();
            } else {
                if (!Intrinsics.areEqual(authenticationData != null ? authenticationData.getUserType() : null, (Object) "Student") || this.configurationRepository.isChangePasswordStudentDisabled()) {
                    if (authenticationData != null) {
                        obj = authenticationData.getUserType();
                    }
                    if (Intrinsics.areEqual(obj, (Object) "Parent") == null || this.configurationRepository.isChangePasswordParentDisabled() != null) {
                        authenticationData = SetsKt.emptySet();
                    } else {
                        authenticationData = AppConstants.Companion.getPARENT_SETTINGS();
                    }
                } else {
                    authenticationData = AppConstants.Companion.getSTUDENT_SETTINGS();
                }
            }
        }
        configurationRepository.setAccountSettings(authenticationData);
    }

    public final void storeTokens(@Nullable AuthenticationData authenticationData) {
        String str = null;
        this.tokenRepo.setAccessToken(authenticationData != null ? authenticationData.getAccessToken() : null);
        this.tokenRepo.setRefreshToken(authenticationData != null ? authenticationData.getRefreshToken() : null);
        UserRepository userRepository = this.userRepo;
        if (authenticationData != null) {
            str = authenticationData.getUserType();
        }
        userRepository.setUserType(str);
    }

    public final void storeDefaultStudent(@Nullable AuthenticationData authenticationData) {
        ConfigurationRepository configurationRepository = this.configurationRepository;
        if (authenticationData != null) {
            authenticationData = authenticationData.getDefaultStudentId();
            if (authenticationData != null) {
                authenticationData = authenticationData.intValue();
                configurationRepository.setDefaultStudent(authenticationData);
            }
        }
        authenticationData = null;
        configurationRepository.setDefaultStudent(authenticationData);
    }

    public final void storeSignalKitEnabled(boolean z) {
        this.configurationRepository.setSignalKitEnabled(z);
    }

    public final void storeStudents(@Nullable AuthenticationData authenticationData) {
        List students;
        if (Intrinsics.areEqual(this.userRepo.getUserType(), (Object) "Parent") && authenticationData != null) {
            List<Student> students2 = authenticationData.getStudents();
            if (students2 != null) {
                for (Student views : students2) {
                    CollectionsKt.removeAll(views.getViews(), LoginInteractor$storeStudents$1$1.INSTANCE);
                }
            }
        }
        StudentRepo studentRepo = this.studentRealmRepo;
        if (authenticationData != null) {
            students = authenticationData.getStudents();
            if (students != null) {
                studentRepo.replaceStudents(students);
                if (Intrinsics.areEqual(authenticationData == null ? authenticationData.getSignalKit() : null, Boolean.valueOf(true))) {
                    authenticationData = authenticationData.getStudents();
                    if (authenticationData != null) {
                        for (Student studentID : (Iterable) authenticationData) {
                            this.studentRealmRepo.addSignalKitPermission(studentID.getStudentID());
                        }
                    }
                }
            }
        }
        students = CollectionsKt.emptyList();
        studentRepo.replaceStudents(students);
        if (authenticationData == null) {
        }
        if (Intrinsics.areEqual(authenticationData == null ? authenticationData.getSignalKit() : null, Boolean.valueOf(true))) {
            authenticationData = authenticationData.getStudents();
            if (authenticationData != null) {
                while (authenticationData.hasNext()) {
                    this.studentRealmRepo.addSignalKitPermission(studentID.getStudentID());
                }
            }
        }
    }

    public final void getLastUserName(@NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        loginCallback.onLastUserNameRetrieved(this.userRepo.getLastUserName());
    }

    public final void setLastUserName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "lastUserName");
        this.userRepo.setLastUserName(str);
    }

    public final void getAuthToken(@NotNull User user, @NotNull LoginCallback loginCallback) {
        Intrinsics.checkParameterIsNotNull(user, "user");
        Intrinsics.checkParameterIsNotNull(loginCallback, "callback");
        storeUserCredentials(user);
        user = this.loginService.getAccessToken(user).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new LoginInteractor$getAuthToken$1(this, user, loginCallback), (Consumer) new LoginInteractor$getAuthToken$2(loginCallback));
        Intrinsics.checkExpressionValueIsNotNull(user, "loginService.getAccessTo…                       })");
        addToCompositeDisposable(user);
    }
}
