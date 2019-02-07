package com.aeries.mobileportal.interactors.school.select;

import android.location.Location;
import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.ApplicationStartupService;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0016\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationStartupService;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/ApplicationStartupService;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationStartupService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getNetworkRepository", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "checkAccountSettings", "", "school", "Lcom/aeries/mobileportal/models/School;", "callback", "Lcom/aeries/mobileportal/interactors/school/select/SchoolSearchCallback;", "checkSchoolAvailability", "postAnalytics", "searchSchoolByLocation", "location", "Landroid/location/Location;", "selectSchool", "schoolSearchCallback", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SchoolSearchInteractor.kt */
public final class SchoolSearchInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ApplicationStartupService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final NetworkRepo networkRepository;
    @NotNull
    private final SchoolRepo schoolRepo;

    public final void searchSchoolByLocation(@NotNull Location location, @NotNull SchoolSearchCallback schoolSearchCallback) {
        Intrinsics.checkParameterIsNotNull(location, Param.LOCATION);
        Intrinsics.checkParameterIsNotNull(schoolSearchCallback, "callback");
    }

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final ApplicationStartupService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    @NotNull
    public final NetworkRepo getNetworkRepository() {
        return this.networkRepository;
    }

    public SchoolSearchInteractor(@NotNull AnalyticsService analyticsService, @NotNull ApplicationStartupService applicationStartupService, @NotNull SchoolRepo schoolRepo, @NotNull NetworkRepo networkRepo, @NotNull ConfigurationRepository configurationRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(applicationStartupService, "applicationService");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        this.analyticsService = analyticsService;
        this.applicationService = applicationStartupService;
        this.schoolRepo = schoolRepo;
        this.networkRepository = networkRepo;
        this.configurationRepository = configurationRepository;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    public final void postAnalytics() {
        AnalyticsService analyticsService = this.analyticsService;
        String district_select = AnalyticsScreenNames.Companion.getDISTRICT_SELECT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getDISTRICT_SELECT());
        Disposable subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, null, null, null, district_select, stringBuilder.toString(), 0, 0, 0, 0, 0, 0, 0, null, 261375, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(SchoolSearchInteractor$postAnalytics$1.INSTANCE, SchoolSearchInteractor$postAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…{ it.printStackTrace() })");
        addToCompositeDisposable(subscribe);
    }

    public final void checkSchoolAvailability(@NotNull School school, @NotNull SchoolSearchCallback schoolSearchCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(schoolSearchCallback, "callback");
        ApplicationStartupService applicationStartupService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("aeriesappstatus/");
        school = applicationStartupService.checkIfAppActive(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new SchoolSearchInteractor$checkSchoolAvailability$1(schoolSearchCallback), new SchoolSearchInteractor$checkSchoolAvailability$2(schoolSearchCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void checkAccountSettings(@NotNull School school, @NotNull SchoolSearchCallback schoolSearchCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(schoolSearchCallback, "callback");
        ApplicationStartupService applicationStartupService = this.applicationService;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(school.getAeriesAppParentURL());
        stringBuilder.append(AppConstants.Companion.getURL_EXTENSION());
        stringBuilder.append("accountsettings/");
        school = applicationStartupService.checkAppSettings(stringBuilder.toString()).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread()).subscribe(new SchoolSearchInteractor$checkAccountSettings$1(this, schoolSearchCallback), new SchoolSearchInteractor$checkAccountSettings$2(schoolSearchCallback));
        Intrinsics.checkExpressionValueIsNotNull(school, "applicationService.check…      }\n                )");
        addToCompositeDisposable(school);
    }

    public final void selectSchool(@NotNull School school, @NotNull SchoolSearchCallback schoolSearchCallback) {
        Intrinsics.checkParameterIsNotNull(school, "school");
        Intrinsics.checkParameterIsNotNull(schoolSearchCallback, "schoolSearchCallback");
        this.networkRepository.setCurrentBaseURL(school.getAeriesAppParentURL());
        this.configurationRepository.setSelectedSchoolCDS(school.getCDS());
        this.schoolRepo.addSchool(school);
        schoolSearchCallback.onURLStored();
    }
}
