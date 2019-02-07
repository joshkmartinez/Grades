package com.aeries.mobileportal.interactors.supplementan_attendance;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.CheckInOutRequest;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010&\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u000e\u0010'\u001a\u00020 2\u0006\u0010#\u001a\u00020$J'\u0010(\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010#\u001a\u00020$¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020 J\u0006\u0010/\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00060"}, d2 = {"Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/web_services/TokenProvider;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getSupplementalAttendanceService", "()Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "checkIn", "", "session", "Lcom/aeries/mobileportal/models/Session;", "callback", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInCallback;", "checkOut", "getSessions", "getStatus", "scanCheckIn", "schoolCode", "", "room", "", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInCallback;)V", "sendAnalytics", "sendSuccessAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassCheckInInteractor.kt */
public final class ClassCheckInInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final StudentRepo studentRepo;
    @NotNull
    private final SupplementalAttendanceService supplementalAttendanceService;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final SupplementalAttendanceService getSupplementalAttendanceService() {
        return this.supplementalAttendanceService;
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

    public ClassCheckInInteractor(@NotNull AnalyticsService analyticsService, @NotNull SupplementalAttendanceService supplementalAttendanceService, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceService, "supplementalAttendanceService");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        this.analyticsService = analyticsService;
        this.supplementalAttendanceService = supplementalAttendanceService;
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

    public final void getStatus(@NotNull ClassCheckInCallback classCheckInCallback) {
        Intrinsics.checkParameterIsNotNull(classCheckInCallback, "callback");
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student == null) {
            Intrinsics.throwNpe();
        }
        this.tokenProvider.performAuthCall(new ClassCheckInInteractor$getStatus$1(this, student, classCheckInCallback));
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String class_check_in_screen = AnalyticsScreenNames.Companion.getCLASS_CHECK_IN_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getCLASS_CHECK_IN_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendAnalytics$1.INSTANCE, ClassCheckInInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendAnalytics$1.INSTANCE, ClassCheckInInteractor$sendAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendAnalytics$1.INSTANCE, ClassCheckInInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendAnalytics$1.INSTANCE, ClassCheckInInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
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
        String class_check_in_success = AnalyticsScreenNames.Companion.getCLASS_CHECK_IN_SUCCESS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getCLASS_CHECK_IN_SUCCESS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendSuccessAnalytics$1.INSTANCE, ClassCheckInInteractor$sendSuccessAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendSuccessAnalytics$1.INSTANCE, ClassCheckInInteractor$sendSuccessAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendSuccessAnalytics$1.INSTANCE, ClassCheckInInteractor$sendSuccessAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), class_check_in_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ClassCheckInInteractor$sendSuccessAnalytics$1.INSTANCE, ClassCheckInInteractor$sendSuccessAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void getSessions(@NotNull ClassCheckInCallback classCheckInCallback) {
        Intrinsics.checkParameterIsNotNull(classCheckInCallback, "callback");
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student == null) {
            Intrinsics.throwNpe();
        }
        this.tokenProvider.performAuthCall(new ClassCheckInInteractor$getSessions$1(this, student, classCheckInCallback));
    }

    public final void checkIn(@NotNull Session session, @NotNull ClassCheckInCallback classCheckInCallback) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        Intrinsics.checkParameterIsNotNull(classCheckInCallback, "callback");
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student == null) {
            Intrinsics.throwNpe();
        }
        this.tokenProvider.performAuthCall(new ClassCheckInInteractor$checkIn$1(this, new CheckInOutRequest(Integer.valueOf(student.getStudentID()), Integer.valueOf(student.getDemographics().getSchoolCode()), null, session.getSessionId()), session, classCheckInCallback));
    }

    public final void scanCheckIn(@Nullable Integer num, @Nullable String str, @NotNull ClassCheckInCallback classCheckInCallback) {
        Intrinsics.checkParameterIsNotNull(classCheckInCallback, "callback");
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student == null) {
            Intrinsics.throwNpe();
        }
        this.tokenProvider.performAuthCall((Function1) new ClassCheckInInteractor$scanCheckIn$1(this, new CheckInOutRequest(Integer.valueOf(student.getStudentID()), num, str, null), classCheckInCallback));
    }

    public final void checkOut(@NotNull Session session, @NotNull ClassCheckInCallback classCheckInCallback) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        Intrinsics.checkParameterIsNotNull(classCheckInCallback, "callback");
        Student student = this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
        if (student == null) {
            Intrinsics.throwNpe();
        }
        this.tokenProvider.performAuthCall(new ClassCheckInInteractor$checkOut$1(this, new CheckInOutRequest(Integer.valueOf(student.getStudentID()), Integer.valueOf(student.getDemographics().getSchoolCode()), session.getRoom(), session.getSessionId()), classCheckInCallback));
    }
}
