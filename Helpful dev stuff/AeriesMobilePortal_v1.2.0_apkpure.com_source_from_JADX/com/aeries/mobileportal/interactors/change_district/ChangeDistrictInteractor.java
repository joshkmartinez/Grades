package com.aeries.mobileportal.interactors.change_district;

import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0016\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020 2\u0006\u0010#\u001a\u00020$J\u0016\u0010*\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "(Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/web_services/services/ApplicationService;)V", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getNetworkRepository", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "checkAccountSettings", "", "school", "Lcom/aeries/mobileportal/models/School;", "callback", "Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictCallback;", "checkSchoolAvailability", "deleteDistrict", "getCurrentDistrict", "", "getSchools", "setNewBaseURL", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangeDistrictInteractor.kt */
public final class ChangeDistrictInteractor extends BaseInteractor {
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final NetworkRepo networkRepository;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final StudentRepo studentRepo;
    @NotNull
    private final TokenRepository tokenRepository;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final NetworkRepo getNetworkRepository() {
        return this.networkRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final TokenRepository getTokenRepository() {
        return this.tokenRepository;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    @NotNull
    public final StudentRepo getStudentRepo() {
        return this.studentRepo;
    }

    public ChangeDistrictInteractor(@NotNull NetworkRepo networkRepo, @NotNull UserRepository userRepository, @NotNull TokenRepository tokenRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull ApplicationService applicationService) {
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        this.networkRepository = networkRepo;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.configurationRepository = configurationRepository;
        this.schoolRepo = schoolRepo;
        this.studentRepo = studentRepo;
        this.applicationService = applicationService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    public final void getSchools(@NotNull ChangeDistrictCallback changeDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(changeDistrictCallback, "callback");
        Collection arrayList = new ArrayList();
        for (Object next : this.schoolRepo.getSchools()) {
            if ((Intrinsics.areEqual(((School) next).getCDS(), this.configurationRepository.getSelectedSchoolCDS()) ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        changeDistrictCallback.onSchoolsRetrieved((List) arrayList);
    }

    public final void checkSchoolAvailability(@NotNull School school, @NotNull ChangeDistrictCallback changeDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(changeDistrictCallback, "callback");
        ApplicationService applicationService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("aeriesappstatus/");
        school = applicationService.checkIfAppActive(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new ChangeDistrictInteractor$checkSchoolAvailability$1(changeDistrictCallback, school), (Consumer) new ChangeDistrictInteractor$checkSchoolAvailability$2(changeDistrictCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void checkAccountSettings(@NotNull School school, @NotNull ChangeDistrictCallback changeDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(changeDistrictCallback, "callback");
        ApplicationService applicationService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("accountsettings/");
        school = applicationService.checkAppSettings(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new ChangeDistrictInteractor$checkAccountSettings$1(this, changeDistrictCallback, school), (Consumer) new ChangeDistrictInteractor$checkAccountSettings$2(changeDistrictCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void setNewBaseURL(@NotNull School school, @NotNull ChangeDistrictCallback changeDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(changeDistrictCallback, "callback");
        this.networkRepository.setCurrentBaseURL(school.getAeriesAppParentURL());
        this.configurationRepository.setSelectedSchoolCDS(school.getCDS());
        this.studentRepo.deleteStudents();
        this.userRepository.deleteAll();
        this.tokenRepository.deleteTokens();
        changeDistrictCallback.onURLChanged();
    }

    public final void deleteDistrict(@NotNull School school, @NotNull ChangeDistrictCallback changeDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(changeDistrictCallback, "callback");
        if (this.schoolRepo.deleteSchool(school.getCDS())) {
            changeDistrictCallback.onDistrictDeleted(school);
        } else {
            changeDistrictCallback.onDistrictDeletedError();
        }
    }

    @NotNull
    public final String getCurrentDistrict() {
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        if (school != null) {
            String schoolName = school.getSchoolName();
            if (schoolName != null) {
                return schoolName;
            }
        }
        return "";
    }
}
