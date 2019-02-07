package com.aeries.mobileportal.interactors.add_district;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.dagger.modules.ServicesProvider;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.adapters.StudentRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.TokenRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0016\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0016\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010.\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0016\u00100\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00061"}, d2 = {"Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "tokenRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "studentRepo", "Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "servicesProvider", "Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/adapters/StudentRepo;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getNetworkRepository", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getServicesProvider", "()Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "getStudentRepo", "()Lcom/aeries/mobileportal/repos/adapters/StudentRepo;", "getTokenRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/TokenRepository;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "checkAccountSettings", "", "school", "Lcom/aeries/mobileportal/models/School;", "callback", "Lcom/aeries/mobileportal/interactors/add_district/AddDistrictCallback;", "checkAppStatus", "sendAnalytics", "sendSuccessAnalytics", "updateSelectedURL", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AddDistrictInteractor.kt */
public final class AddDistrictInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final NetworkRepo networkRepository;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final ServicesProvider servicesProvider;
    @NotNull
    private final StudentRepo studentRepo;
    @NotNull
    private final TokenRepository tokenRepository;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final NetworkRepo getNetworkRepository() {
        return this.networkRepository;
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
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    @NotNull
    public final StudentRepo getStudentRepo() {
        return this.studentRepo;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    public AddDistrictInteractor(@NotNull AnalyticsService analyticsService, @NotNull NetworkRepo networkRepo, @NotNull UserRepository userRepository, @NotNull ConfigurationRepository configurationRepository, @NotNull TokenRepository tokenRepository, @NotNull SchoolRepo schoolRepo, @NotNull StudentRepo studentRepo, @NotNull ApplicationService applicationService, @NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(tokenRepository, "tokenRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(studentRepo, "studentRepo");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        this.analyticsService = analyticsService;
        this.networkRepository = networkRepo;
        this.userRepository = userRepository;
        this.configurationRepository = configurationRepository;
        this.tokenRepository = tokenRepository;
        this.schoolRepo = schoolRepo;
        this.studentRepo = studentRepo;
        this.applicationService = applicationService;
        this.servicesProvider = servicesProvider;
    }

    @NotNull
    public final ServicesProvider getServicesProvider() {
        return this.servicesProvider;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        String str2;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String link_district_screen = AnalyticsScreenNames.Companion.getLINK_DISTRICT_SCREEN();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getLINK_DISTRICT_SCREEN());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendAnalytics$1.INSTANCE, AddDistrictInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendAnalytics$1.INSTANCE, AddDistrictInteractor$sendAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendAnalytics$1.INSTANCE, AddDistrictInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_screen, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendAnalytics$1.INSTANCE, AddDistrictInteractor$sendAnalytics$2.INSTANCE);
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
        String link_district_success = AnalyticsScreenNames.Companion.getLINK_DISTRICT_SUCCESS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getLINK_DISTRICT_SUCCESS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        str2 = schoolName;
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendSuccessAnalytics$1.INSTANCE, AddDistrictInteractor$sendSuccessAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                str2 = schoolName;
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendSuccessAnalytics$1.INSTANCE, AddDistrictInteractor$sendSuccessAnalytics$2.INSTANCE);
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
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendSuccessAnalytics$1.INSTANCE, AddDistrictInteractor$sendSuccessAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        str2 = schoolName;
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, r0.studentRepo.getStudents().size(), null, r0.schoolRepo.getSchools().size(), str2, str, r0.userRepository.getUserType(), link_district_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261131, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(AddDistrictInteractor$sendSuccessAnalytics$1.INSTANCE, AddDistrictInteractor$sendSuccessAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void checkAppStatus(@NotNull School school, @NotNull AddDistrictCallback addDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(addDistrictCallback, "callback");
        ApplicationService applicationService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("aeriesappstatus/");
        school = applicationService.checkIfAppActive(stringBuilder.toString()).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new AddDistrictInteractor$checkAppStatus$1(this, school, addDistrictCallback), (Consumer) new AddDistrictInteractor$checkAppStatus$2(addDistrictCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void checkAccountSettings(@NotNull School school, @NotNull AddDistrictCallback addDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(addDistrictCallback, "callback");
        ApplicationService applicationService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("accountsettings/");
        school = applicationService.checkAppSettings(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new AddDistrictInteractor$checkAccountSettings$1(this, addDistrictCallback, school), (Consumer) new AddDistrictInteractor$checkAccountSettings$2(addDistrictCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void updateSelectedURL(@NotNull School school, @NotNull AddDistrictCallback addDistrictCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(addDistrictCallback, "callback");
        ServicesProvider servicesProvider = this.servicesProvider;
        String aeriesAppParentURL = school.getAeriesAppParentURL();
        if (aeriesAppParentURL == null) {
            aeriesAppParentURL = "";
        }
        servicesProvider.setBaseURL(aeriesAppParentURL);
        this.configurationRepository.setSelectedSchoolCDS(school.getCDS());
        this.studentRepo.deleteStudents();
        this.userRepository.deleteAll();
        this.tokenRepository.deleteTokens();
        addDistrictCallback.onURLUpdated();
    }
}
