package com.aeries.mobileportal.interactors.attendance;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/interactors/attendance/AttendanceInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "attendanceService", "Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/AttendanceService;Lcom/aeries/mobileportal/web_services/TokenProvider;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getAttendanceService", "()Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getCurrentStudentYearlyAttendance", "", "callback", "Lcom/aeries/mobileportal/interactors/attendance/AttendanceCallback;", "sendAnalytics", "sendDetailsAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceInteractor.kt */
public final class AttendanceInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final AttendanceService attendanceService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
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
    public final AttendanceService getAttendanceService() {
        return this.attendanceService;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
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

    public AttendanceInteractor(@NotNull AnalyticsService analyticsService, @NotNull AttendanceService attendanceService, @NotNull TokenProvider tokenProvider, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(attendanceService, "attendanceService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        this.analyticsService = analyticsService;
        this.attendanceService = attendanceService;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.configurationRepository = configurationRepository;
        this.studentRepo = studentRepo;
        this.schoolRepo = schoolRepo;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String attendance_screen = AnalyticsScreenNames.Companion.getATTENDANCE_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getATTENDANCE_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendAnalytics$1.INSTANCE, AttendanceInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendAnalytics$1.INSTANCE, AttendanceInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendAnalytics$1.INSTANCE, AttendanceInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendAnalytics$1.INSTANCE, AttendanceInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void sendDetailsAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String attendance_details = AnalyticsScreenNames.Companion.getATTENDANCE_DETAILS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getATTENDANCE_DETAILS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendDetailsAnalytics$1.INSTANCE, AttendanceInteractor$sendDetailsAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendDetailsAnalytics$1.INSTANCE, AttendanceInteractor$sendDetailsAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendDetailsAnalytics$1.INSTANCE, AttendanceInteractor$sendDetailsAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), attendance_details, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AttendanceInteractor$sendDetailsAnalytics$1.INSTANCE, AttendanceInteractor$sendDetailsAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void getCurrentStudentYearlyAttendance(@NotNull AttendanceCallback attendanceCallback) {
        Intrinsics.checkParameterIsNotNull(attendanceCallback, "callback");
        int selectedStudent = this.configurationRepository.getSelectedStudent();
        this.tokenProvider.performAuthCall(new AttendanceInteractor$getCurrentStudentYearlyAttendance$1(this, this.studentRepo.getStudent(selectedStudent), selectedStudent, attendanceCallback));
    }
}
