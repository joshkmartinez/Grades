package com.aeries.mobileportal.interactors.grades;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.CalculateScoreRequest;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.MockGradebook;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00060"}, d2 = {"Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "whatIfService", "Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/GradesService;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/web_services/services/WhatIfService;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/web_services/TokenProvider;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getGradesService", "()Lcom/aeries/mobileportal/web_services/services/GradesService;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getWhatIfService", "()Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "getMockedGrade", "", "gradebook", "Lcom/aeries/mobileportal/models/MockGradebook;", "callback", "Lcom/aeries/mobileportal/interactors/grades/GradesCallback;", "getServerInfo", "", "sendAssignmentDetailsAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesInteractor.kt */
public final class GradesInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final GradesService gradesService;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final StudentRepo studentRepo;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;
    @NotNull
    private final WhatIfService whatIfService;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final GradesService getGradesService() {
        return this.gradesService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final WhatIfService getWhatIfService() {
        return this.whatIfService;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
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

    public GradesInteractor(@NotNull AnalyticsService analyticsService, @NotNull GradesService gradesService, @NotNull ApplicationService applicationService, @NotNull WhatIfService whatIfService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(gradesService, "gradesService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(whatIfService, "whatIfService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        this.analyticsService = analyticsService;
        this.gradesService = gradesService;
        this.applicationService = applicationService;
        this.whatIfService = whatIfService;
        this.userRepository = userRepository;
        this.configurationRepository = configurationRepository;
        this.studentRepo = studentRepo;
        this.schoolRepo = schoolRepo;
        this.tokenProvider = tokenProvider;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public final void sendAssignmentDetailsAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String assignment_details = AnalyticsScreenNames.Companion.getASSIGNMENT_DETAILS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getASSIGNMENT_DETAILS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), assignment_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(GradesInteractor$sendAssignmentDetailsAnalytics$1.INSTANCE, GradesInteractor$sendAssignmentDetailsAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), assignment_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(GradesInteractor$sendAssignmentDetailsAnalytics$1.INSTANCE, GradesInteractor$sendAssignmentDetailsAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), assignment_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(GradesInteractor$sendAssignmentDetailsAnalytics$1.INSTANCE, GradesInteractor$sendAssignmentDetailsAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), assignment_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(GradesInteractor$sendAssignmentDetailsAnalytics$1.INSTANCE, GradesInteractor$sendAssignmentDetailsAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    @NotNull
    public final String getServerInfo() {
        String nonFormattedPortalVersion = this.configurationRepository.getNonFormattedPortalVersion();
        return nonFormattedPortalVersion != null ? nonFormattedPortalVersion : "0";
    }

    public final void getMockedGrade(@NotNull MockGradebook mockGradebook, @NotNull GradesCallback gradesCallback) {
        Object valueOf;
        Intrinsics.checkParameterIsNotNull(mockGradebook, "gradebook");
        Intrinsics.checkParameterIsNotNull(gradesCallback, "callback");
        CalculateScoreRequest calculateScoreRequest = new CalculateScoreRequest();
        calculateScoreRequest.setGradebook(mockGradebook);
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        Object obj = null;
        if (student != null) {
            Demographics demographics = student.getDemographics();
            if (demographics != null) {
                valueOf = Integer.valueOf(demographics.getSchoolCode());
                calculateScoreRequest.setSchoolNumber(String.valueOf(valueOf));
                student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
                if (student != null) {
                    obj = Integer.valueOf(student.getStudentID());
                }
                calculateScoreRequest.setStudentId(String.valueOf(obj));
                this.tokenProvider.performAuthCall(new GradesInteractor$getMockedGrade$1(this, calculateScoreRequest, gradesCallback, mockGradebook));
            }
        }
        valueOf = null;
        calculateScoreRequest.setSchoolNumber(String.valueOf(valueOf));
        student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student != null) {
            obj = Integer.valueOf(student.getStudentID());
        }
        calculateScoreRequest.setStudentId(String.valueOf(obj));
        this.tokenProvider.performAuthCall(new GradesInteractor$getMockedGrade$1(this, calculateScoreRequest, gradesCallback, mockGradebook));
    }
}
