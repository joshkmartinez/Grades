package com.aeries.mobileportal.interactors.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.RestrictionRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u000208J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u000204J\u000e\u0010<\u001a\u0002042\u0006\u00107\u001a\u000208J\b\u0010=\u001a\u0004\u0018\u00010>J\u000e\u0010?\u001a\u0002042\u0006\u0010@\u001a\u000208J\u0006\u0010A\u001a\u00020>J\u0006\u0010B\u001a\u000204J\u000e\u0010C\u001a\u0002042\u0006\u0010@\u001a\u000208J\u000e\u0010D\u001a\u0002042\u0006\u0010@\u001a\u000208J\u0006\u0010E\u001a\u000204J\u0006\u0010F\u001a\u000204J\u0006\u0010G\u001a\u000204J\u000e\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020:J\u000e\u0010J\u001a\u0002042\u0006\u0010K\u001a\u00020:J\u000e\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u000204R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u00102¨\u0006P"}, d2 = {"Lcom/aeries/mobileportal/interactors/main/MainInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "notificationsRepo", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "restrictionRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "restrictionService", "Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "context", "Landroid/content/Context;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;Lcom/aeries/mobileportal/web_services/services/RestrictionService;Lcom/aeries/mobileportal/web_services/TokenProvider;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;Landroid/content/Context;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getContext", "()Landroid/content/Context;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getNotificationsRepo", "()Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "getRestrictionRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/RestrictionRepository;", "getRestrictionService", "()Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "deleteNotifications", "", "deletePortalVersion", "deleteTokens", "callback", "Lcom/aeries/mobileportal/interactors/main/MainCallback;", "getLogoutForPortalVersion", "", "getPortalVersion", "getRestrictions", "getSavedPortalVersion", "", "getSelectedStudent", "mainCallback", "getUserType", "goToParentPortal", "invalidateAccessToken", "invalidateRefreshToken", "sendAccountSettingsAnalytics", "sendAnalytics", "sendStudentSelectAnalytics", "setMessageShown", "b", "setRestriction", "isRestricted", "setSelectedStudent", "student", "Lcom/aeries/mobileportal/models/Student;", "signOutFromGoogle", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainInteractor.kt */
public final class MainInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final GoogleSignInClient googleSignInClient;
    @NotNull
    private final NotificationsRepo notificationsRepo;
    @NotNull
    private final RestrictionRepository restrictionRepository;
    @NotNull
    private final RestrictionService restrictionService;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final StudentRepo studentRepo;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final StudentRepo getStudentRepo() {
        return this.studentRepo;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    @NotNull
    public final NotificationsRepo getNotificationsRepo() {
        return this.notificationsRepo;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final RestrictionRepository getRestrictionRepository() {
        return this.restrictionRepository;
    }

    @NotNull
    public final RestrictionService getRestrictionService() {
        return this.restrictionService;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    @NotNull
    public final GoogleSignInClient getGoogleSignInClient() {
        return this.googleSignInClient;
    }

    public MainInteractor(@NotNull AnalyticsService analyticsService, @NotNull ApplicationService applicationService, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull NotificationsRepo notificationsRepo, @NotNull ConfigurationRepository configurationRepository, @NotNull UserRepository userRepository, @NotNull RestrictionRepository restrictionRepository, @NotNull RestrictionService restrictionService, @NotNull TokenProvider tokenProvider, @NotNull GoogleSignInClient googleSignInClient, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(restrictionRepository, "restrictionRepository");
        Intrinsics.checkParameterIsNotNull(restrictionService, "restrictionService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(googleSignInClient, "googleSignInClient");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.analyticsService = analyticsService;
        this.applicationService = applicationService;
        this.studentRepo = studentRepo;
        this.schoolRepo = schoolRepo;
        this.notificationsRepo = notificationsRepo;
        this.configurationRepository = configurationRepository;
        this.userRepository = userRepository;
        this.restrictionRepository = restrictionRepository;
        this.restrictionService = restrictionService;
        this.tokenProvider = tokenProvider;
        this.googleSignInClient = googleSignInClient;
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String main_screen = AnalyticsScreenNames.Companion.getMAIN_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getMAIN_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), main_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAnalytics$1.INSTANCE, MainInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), main_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAnalytics$1.INSTANCE, MainInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), main_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAnalytics$1.INSTANCE, MainInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), main_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAnalytics$1.INSTANCE, MainInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void sendStudentSelectAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String pulldown_switch_student = AnalyticsScreenNames.Companion.getPULLDOWN_SWITCH_STUDENT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getPULLDOWN_SWITCH_STUDENT());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), pulldown_switch_student, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendStudentSelectAnalytics$1.INSTANCE, MainInteractor$sendStudentSelectAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), pulldown_switch_student, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendStudentSelectAnalytics$1.INSTANCE, MainInteractor$sendStudentSelectAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), pulldown_switch_student, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendStudentSelectAnalytics$1.INSTANCE, MainInteractor$sendStudentSelectAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), pulldown_switch_student, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendStudentSelectAnalytics$1.INSTANCE, MainInteractor$sendStudentSelectAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void sendAccountSettingsAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String account_settings = AnalyticsScreenNames.Companion.getACCOUNT_SETTINGS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getACCOUNT_SETTINGS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), account_settings, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAccountSettingsAnalytics$1.INSTANCE, MainInteractor$sendAccountSettingsAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), account_settings, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAccountSettingsAnalytics$1.INSTANCE, MainInteractor$sendAccountSettingsAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), account_settings, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAccountSettingsAnalytics$1.INSTANCE, MainInteractor$sendAccountSettingsAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), account_settings, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(MainInteractor$sendAccountSettingsAnalytics$1.INSTANCE, MainInteractor$sendAccountSettingsAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void setRestriction(boolean z) {
        this.restrictionRepository.storeStudentRestriction(this.configurationRepository.getSelectedStudent(), z);
    }

    public final void getRestrictions(@NotNull MainCallback mainCallback) {
        Intrinsics.checkParameterIsNotNull(mainCallback, "callback");
        int selectedStudent = this.configurationRepository.getSelectedStudent();
        this.tokenProvider.performAuthCall(new MainInteractor$getRestrictions$1(this, this.studentRepo.getStudent(selectedStudent), selectedStudent, mainCallback));
    }

    public final void getPortalVersion() {
        this.tokenProvider.performAuthCall(new MainInteractor$getPortalVersion$1(this));
    }

    public final void setSelectedStudent(@NotNull Student student) {
        Intrinsics.checkParameterIsNotNull(student, "student");
        if (this.configurationRepository.isFeedbackEnabled()) {
            this.studentRepo.addFeedbackPermission(student.getStudentID());
        }
        this.configurationRepository.setSelectedStudent(student.getDemographics().getStudentId());
    }

    public final void getSelectedStudent(@NotNull MainCallback mainCallback) {
        Intrinsics.checkParameterIsNotNull(mainCallback, "mainCallback");
        int selectedStudent = this.configurationRepository.getSelectedStudent();
        if (this.configurationRepository.isFeedbackEnabled()) {
            this.studentRepo.addFeedbackPermission(selectedStudent);
        }
        mainCallback.onSelectedStudentRetrieved(this.studentRepo.getStudent(selectedStudent));
    }

    public final void invalidateAccessToken(@NotNull MainCallback mainCallback) {
        Intrinsics.checkParameterIsNotNull(mainCallback, "mainCallback");
        this.tokenProvider.invalidateToken();
        mainCallback.onTokenInvalidated();
    }

    public final void invalidateRefreshToken(@NotNull MainCallback mainCallback) {
        Intrinsics.checkParameterIsNotNull(mainCallback, "mainCallback");
        mainCallback.onTokenInvalidated();
    }

    public final void deleteTokens(@NotNull MainCallback mainCallback) {
        Intrinsics.checkParameterIsNotNull(mainCallback, "callback");
        this.tokenProvider.invalidateToken();
        this.userRepository.deleteAll();
        this.configurationRepository.deleteAll();
        this.studentRepo.deleteStudents();
        mainCallback.onAllDeleted();
    }

    public final void signOutFromGoogle() {
        this.googleSignInClient.signOut();
    }

    @NotNull
    public final String getUserType() {
        return this.userRepository.getUserType();
    }

    public final void setMessageShown(boolean z) {
        this.configurationRepository.setMessageShown(z);
    }

    @Nullable
    public final String getSavedPortalVersion() {
        return this.configurationRepository.getPortalVersion();
    }

    public final void goToParentPortal() {
        Intent intent = new Intent("android.intent.action.VIEW");
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        intent.setData(Uri.parse(Intrinsics.stringPlus(school != null ? school.getAeriesAppParentURL() : null, "/loginparent.aspx")));
        intent.addFlags(ErrorDialogData.BINDER_CRASH);
        this.context.startActivity(intent);
    }

    public final void deleteNotifications() {
        this.notificationsRepo.deleteNotifications();
    }

    public final void deletePortalVersion() {
        this.configurationRepository.setPortalVersion(null);
    }

    public final boolean getLogoutForPortalVersion() {
        return this.configurationRepository.getForceLogoutForPortalVersion();
    }
}
