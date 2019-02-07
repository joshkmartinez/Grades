package com.aeries.mobileportal.dagger.components;

import android.accounts.AccountManager;
import android.content.Context;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.DaggerComponent;
import com.aeries.mobileportal.dagger.modules.AuthModule;
import com.aeries.mobileportal.dagger.modules.ContextModule;
import com.aeries.mobileportal.dagger.modules.GoogleSignInModule;
import com.aeries.mobileportal.dagger.modules.ImageModule;
import com.aeries.mobileportal.dagger.modules.NetworkModule;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.dagger.modules.SharedPreferencesModule;
import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.ImageLoader;
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
import com.google.android.gms.common.api.GoogleApiClient;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020'H&J\b\u0010(\u001a\u00020)H&J\b\u0010*\u001a\u00020+H&J\b\u0010,\u001a\u00020-H&J\b\u0010.\u001a\u00020/H&J\b\u00100\u001a\u000201H&J\b\u00102\u001a\u000203H&J\b\u00104\u001a\u000205H&J\b\u00106\u001a\u000207H&J\b\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020;H&J\b\u0010<\u001a\u00020=H&¨\u0006>"}, d2 = {"Lcom/aeries/mobileportal/dagger/components/PSPComponent;", "Lcom/aeries/mobileportal/dagger/DaggerComponent;", "accountManager", "Landroid/accounts/AccountManager;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "attendanceService", "Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "checkApplicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "configurationRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "contactsService", "Lcom/aeries/mobileportal/web_services/services/ContactsService;", "context", "Landroid/content/Context;", "createAccountService", "Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "feedbackService", "Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "imageLoader", "Lcom/aeries/mobileportal/utils/ImageLoader;", "inject", "", "application", "Lcom/aeries/mobileportal/PSPApplication;", "linkStudentService", "Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "loginService", "Lcom/aeries/mobileportal/web_services/services/LoginService;", "networkRepo", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "passwordService", "Lcom/aeries/mobileportal/web_services/services/PasswordService;", "reportCardService", "Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "restrictedService", "Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "restrictionRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "servicesProvider", "Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "signalKitService", "Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "tokenRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "userRepo", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "whatIfService", "Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "app_release"}, k = 1, mv = {1, 1, 10})
@PSPApplicationScope
@Component(modules = {NetworkModule.class, SharedPreferencesModule.class, ContextModule.class, AuthModule.class, GoogleSignInModule.class, ImageModule.class})
/* compiled from: PSPComponent.kt */
public interface PSPComponent extends DaggerComponent {
    @NotNull
    AccountManager accountManager();

    @NotNull
    AnalyticsService analyticsService();

    @NotNull
    AttendanceService attendanceService();

    @NotNull
    ApplicationService checkApplicationService();

    @NotNull
    ConfigurationRepository configurationRepo();

    @NotNull
    ContactsService contactsService();

    @NotNull
    Context context();

    @NotNull
    CreateAccountService createAccountService();

    @NotNull
    FeedbackService feedbackService();

    @NotNull
    GoogleApiClient googleApiClient();

    @NotNull
    GoogleSignInClient googleSignInClient();

    @NotNull
    GradesService gradesService();

    @NotNull
    ImageLoader imageLoader();

    void inject(@NotNull PSPApplication pSPApplication);

    @NotNull
    LinkStudentService linkStudentService();

    @NotNull
    LoginService loginService();

    @NotNull
    NetworkRepo networkRepo();

    @NotNull
    NotificationService notificationService();

    @NotNull
    PasswordService passwordService();

    @NotNull
    ReportCardService reportCardService();

    @NotNull
    RestrictionService restrictedService();

    @NotNull
    RestrictionRepository restrictionRepo();

    @NotNull
    ServicesProvider servicesProvider();

    @NotNull
    SignalKitService signalKitService();

    @NotNull
    SupplementalAttendanceService supplementalAttendanceService();

    @NotNull
    TokenProvider tokenProvider();

    @NotNull
    TokenRepository tokenRepo();

    @NotNull
    UserRepository userRepo();

    @NotNull
    WhatIfService whatIfService();
}
