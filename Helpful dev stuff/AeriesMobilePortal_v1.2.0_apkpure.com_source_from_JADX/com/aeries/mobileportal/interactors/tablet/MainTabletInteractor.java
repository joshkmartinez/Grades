package com.aeries.mobileportal.interactors.tablet;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.Student;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.utils.SettingsUtils;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.GradesService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/aeries/mobileportal/interactors/tablet/MainTabletInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "(Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/web_services/services/GradesService;)V", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getGradesService", "()Lcom/aeries/mobileportal/web_services/services/GradesService;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getAeriesVersion", "", "callback", "Lcom/aeries/mobileportal/interactors/tablet/MainTabletCallback;", "getSelectedStudent", "Lcom/aeries/mobileportal/models/Student;", "getSettingsType", "getStudentCourses", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainTabletInteractor.kt */
public final class MainTabletInteractor extends BaseInteractor {
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
    private final TokenRepository tokenRepository;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final StudentRepo getStudentRepo() {
        return this.studentRepo;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
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
    public final TokenRepository getTokenRepository() {
        return this.tokenRepository;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    public MainTabletInteractor(@NotNull StudentRepo studentRepo, @NotNull SchoolRepo schoolRepo, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenRepository tokenRepository, @NotNull ApplicationService applicationService, @NotNull GradesService gradesService) {
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(gradesService, "gradesService");
        this.studentRepo = studentRepo;
        this.schoolRepo = schoolRepo;
        this.userRepository = userRepository;
        this.configurationRepository = configurationRepository;
        this.tokenRepository = tokenRepository;
        this.applicationService = applicationService;
        this.gradesService = gradesService;
    }

    @NotNull
    public final GradesService getGradesService() {
        return this.gradesService;
    }

    @Nullable
    public final Student getSelectedStudent() {
        return this.studentRepo.getStudent(this.configurationRepository.getSelectedStudent());
    }

    public final void getSettingsType(@NotNull MainTabletCallback mainTabletCallback) {
        Intrinsics.checkParameterIsNotNull(mainTabletCallback, "callback");
        Object userType = this.userRepository.getUserType();
        if (Intrinsics.areEqual(userType, (Object) "Parent")) {
            mainTabletCallback.displaySettingsParent(SettingsUtils.Companion.getSettings(this.configurationRepository, this.schoolRepo), this.studentRepo.getStudents());
        } else if (Intrinsics.areEqual(userType, (Object) "Student")) {
            mainTabletCallback.displaySettingsStudent(SettingsUtils.Companion.getSettings(this.configurationRepository, this.schoolRepo));
        }
    }

    public final void getAeriesVersion(@NotNull MainTabletCallback mainTabletCallback) {
        Intrinsics.checkParameterIsNotNull(mainTabletCallback, "callback");
        mainTabletCallback = this.applicationService.getServerInfo(this.tokenRepository.getAccessToken()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MainTabletInteractor$getAeriesVersion$1(mainTabletCallback), (Consumer) MainTabletInteractor$getAeriesVersion$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(mainTabletCallback, "applicationService.getSe…      }\n                )");
        addToCompositeDisposable(mainTabletCallback);
    }

    public final void getStudentCourses(@NotNull MainTabletCallback mainTabletCallback) {
        Intrinsics.checkParameterIsNotNull(mainTabletCallback, "callback");
        mainTabletCallback = this.gradesService.getClassSummary(Integer.valueOf(this.configurationRepository.getSelectedStudent()), this.tokenRepository.getAccessToken()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new MainTabletInteractor$getStudentCourses$1(mainTabletCallback), new MainTabletInteractor$getStudentCourses$2(mainTabletCallback));
        Intrinsics.checkExpressionValueIsNotNull(mainTabletCallback, "gradesService.getClassSu…      }\n                )");
        addToCompositeDisposable(mainTabletCallback);
    }
}
