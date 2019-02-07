package com.aeries.mobileportal.interactors.forgot_password;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.models.ForgotPasswordRequest;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.PasswordService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0014J\u0006\u0010\u001d\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "passwordService", "Lcom/aeries/mobileportal/web_services/services/PasswordService;", "schoolsRealmRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/PasswordService;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getPasswordService", "()Lcom/aeries/mobileportal/web_services/services/PasswordService;", "getSchoolsRealmRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "changePassword", "", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "callback", "Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordCallback;", "requestForgotPassword", "email", "", "sendAnalytics", "sendCompletedAnalytics", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordInteractor.kt */
public final class ForgotPasswordInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final PasswordService passwordService;
    @NotNull
    private final SchoolRepo schoolsRealmRepo;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final PasswordService getPasswordService() {
        return this.passwordService;
    }

    @NotNull
    public final SchoolRepo getSchoolsRealmRepo() {
        return this.schoolsRealmRepo;
    }

    public ForgotPasswordInteractor(@NotNull AnalyticsService analyticsService, @NotNull PasswordService passwordService, @NotNull SchoolRepo schoolRepo, @NotNull ConfigurationRepository configurationRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(passwordService, "passwordService");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolsRealmRepo");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        this.analyticsService = analyticsService;
        this.passwordService = passwordService;
        this.schoolsRealmRepo = schoolRepo;
        this.configurationRepository = configurationRepository;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        Disposable subscribe;
        School school = this.schoolsRealmRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String forgot_password = AnalyticsScreenNames.Companion.getFORGOT_PASSWORD();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getFORGOT_PASSWORD());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolsRealmRepo.getSchools().size(), schoolName, str, null, forgot_password, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolsRealmRepo.getSchools().size(), schoolName, str, null, forgot_password, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolsRealmRepo.getSchools().size(), schoolName, str, null, forgot_password, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolsRealmRepo.getSchools().size(), schoolName, str, null, forgot_password, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void sendCompletedAnalytics() {
        String districtName;
        String str;
        String schoolName;
        Disposable subscribe;
        School school = this.schoolsRealmRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String forgot_password_success = AnalyticsScreenNames.Companion.getFORGOT_PASSWORD_SUCCESS();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getFORGOT_PASSWORD_SUCCESS());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, forgot_password_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendCompletedAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendCompletedAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, forgot_password_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendCompletedAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendCompletedAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, forgot_password_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendCompletedAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendCompletedAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, 0, schoolName, str, null, forgot_password_success, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261279, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(ForgotPasswordInteractor$sendCompletedAnalytics$1.INSTANCE, ForgotPasswordInteractor$sendCompletedAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void requestForgotPassword(@NotNull String str, @NotNull ForgotPasswordCallback forgotPasswordCallback) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(forgotPasswordCallback, "callback");
        str = this.passwordService.forgotPassword(new ForgotPasswordRequest(str)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ForgotPasswordInteractor$requestForgotPassword$1(forgotPasswordCallback), new ForgotPasswordInteractor$requestForgotPassword$2(forgotPasswordCallback));
        Intrinsics.checkExpressionValueIsNotNull(str, "passwordService.forgotPa…      }\n                )");
        addToCompositeDisposable(str);
    }

    public final void changePassword(@NotNull ChangePasswordRequest changePasswordRequest, @NotNull ForgotPasswordCallback forgotPasswordCallback) {
        Intrinsics.checkParameterIsNotNull(changePasswordRequest, "changePasswordRequest");
        Intrinsics.checkParameterIsNotNull(forgotPasswordCallback, "callback");
        changePasswordRequest = this.passwordService.changePassword(changePasswordRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new ForgotPasswordInteractor$changePassword$1(forgotPasswordCallback), new ForgotPasswordInteractor$changePassword$2(forgotPasswordCallback));
        Intrinsics.checkExpressionValueIsNotNull(changePasswordRequest, "passwordService.changePa…      }\n                )");
        addToCompositeDisposable(changePasswordRequest);
    }
}
