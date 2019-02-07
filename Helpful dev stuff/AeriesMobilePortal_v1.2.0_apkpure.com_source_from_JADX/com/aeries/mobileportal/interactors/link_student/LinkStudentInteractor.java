package com.aeries.mobileportal.interactors.link_student;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.AddStudentRequest;
import com.aeries.mobileportal.models.AuthenticationData;
import com.aeries.mobileportal.models.LinkContact;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.UpdateStudentContactRequest;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.anko.DimensionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J&\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020(J\u0006\u00101\u001a\u00020(J\u000e\u00102\u001a\u00020(2\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u000207J\u0016\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020:2\u0006\u0010-\u001a\u00020.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006;"}, d2 = {"Lcom/aeries/mobileportal/interactors/link_student/LinkStudentInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "linkStudentService", "Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/web_services/TokenProvider;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;Lcom/aeries/mobileportal/web_services/services/LinkStudentService;Lcom/aeries/mobileportal/web_services/services/ApplicationService;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getLinkStudentService", "()Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "addStudent", "", "studentID", "", "studentPhone", "verificationCode", "callback", "Lcom/aeries/mobileportal/interactors/link_student/LinkStudentCallback;", "deleteAll", "sendAnalytics", "sendSuccessAnalytics", "setLinkingStudent", "boolean", "", "updateAuthData", "authData", "Lcom/aeries/mobileportal/models/AuthenticationData;", "updateContact", "linkContact", "Lcom/aeries/mobileportal/models/LinkContact;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkStudentInteractor.kt */
public final class LinkStudentInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final GoogleSignInClient googleSignInClient;
    @NotNull
    private final LinkStudentService linkStudentService;
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
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
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
    public final GoogleSignInClient getGoogleSignInClient() {
        return this.googleSignInClient;
    }

    @NotNull
    public final LinkStudentService getLinkStudentService() {
        return this.linkStudentService;
    }

    public LinkStudentInteractor(@NotNull AnalyticsService analyticsService, @NotNull UserRepository userRepository, @NotNull TokenProvider tokenProvider, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull GoogleSignInClient googleSignInClient, @NotNull LinkStudentService linkStudentService, @NotNull ApplicationService applicationService) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(googleSignInClient, "googleSignInClient");
        Intrinsics.checkParameterIsNotNull(linkStudentService, "linkStudentService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        this.analyticsService = analyticsService;
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.configurationRepository = configurationRepository;
        this.studentRepo = studentRepo;
        this.schoolRepo = schoolRepo;
        this.googleSignInClient = googleSignInClient;
        this.linkStudentService = linkStudentService;
        this.applicationService = applicationService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String link_student_screen = AnalyticsScreenNames.Companion.getLINK_STUDENT_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getLINK_STUDENT_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendAnalytics$1.INSTANCE, LinkStudentInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendAnalytics$1.INSTANCE, LinkStudentInteractor$sendAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendAnalytics$1.INSTANCE, LinkStudentInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendAnalytics$1.INSTANCE, LinkStudentInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void sendSuccessAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String link_student_success = AnalyticsScreenNames.Companion.getLINK_STUDENT_SUCCESS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getLINK_STUDENT_SUCCESS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendSuccessAnalytics$1.INSTANCE, LinkStudentInteractor$sendSuccessAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendSuccessAnalytics$1.INSTANCE, LinkStudentInteractor$sendSuccessAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendSuccessAnalytics$1.INSTANCE, LinkStudentInteractor$sendSuccessAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_student_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(LinkStudentInteractor$sendSuccessAnalytics$1.INSTANCE, LinkStudentInteractor$sendSuccessAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void addStudent(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull LinkStudentCallback linkStudentCallback) {
        LinkStudentCallback linkStudentCallback2 = linkStudentCallback;
        String str4 = str;
        Intrinsics.checkParameterIsNotNull(str4, "studentID");
        String str5 = str2;
        Intrinsics.checkParameterIsNotNull(str5, "studentPhone");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "verificationCode");
        Intrinsics.checkParameterIsNotNull(linkStudentCallback2, "callback");
        this.tokenProvider.performAuthCall(new LinkStudentInteractor$addStudent$1(this, new AddStudentRequest(str4, str5, str6, this.userRepository.getUserType(), null, null, null, null, DimensionsKt.HDPI, null), linkStudentCallback2));
    }

    public final void updateContact(@NotNull LinkContact linkContact, @NotNull LinkStudentCallback linkStudentCallback) {
        Intrinsics.checkParameterIsNotNull(linkContact, "linkContact");
        Intrinsics.checkParameterIsNotNull(linkStudentCallback, "callback");
        this.tokenProvider.performAuthCall(new LinkStudentInteractor$updateContact$1(this, new UpdateStudentContactRequest(linkContact.getStudentID(), linkContact.getSequenceNumber()), linkStudentCallback));
    }

    public final void updateAuthData(@NotNull AuthenticationData authenticationData) {
        Intrinsics.checkParameterIsNotNull(authenticationData, "authData");
        this.tokenProvider.invalidateToken();
        ConfigurationRepository configurationRepository = this.configurationRepository;
        Integer defaultStudentId = authenticationData.getDefaultStudentId();
        configurationRepository.setDefaultStudent(defaultStudentId != null ? defaultStudentId.intValue() : 0);
        StudentRepo studentRepo = this.studentRepo;
        authenticationData = authenticationData.getStudents();
        if (authenticationData == null) {
            authenticationData = CollectionsKt.emptyList();
        }
        studentRepo.updateStudents(authenticationData);
    }

    public final void setLinkingStudent(boolean z) {
        this.configurationRepository.setLinkingStudent(z);
    }

    public final void deleteAll() {
        this.tokenProvider.invalidateToken();
        this.configurationRepository.setLinkingStudent(false);
        this.userRepository.deleteAll();
        this.googleSignInClient.signOut();
    }
}
