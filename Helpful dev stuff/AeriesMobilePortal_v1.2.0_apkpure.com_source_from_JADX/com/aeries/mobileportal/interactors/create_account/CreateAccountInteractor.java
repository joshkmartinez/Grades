package com.aeries.mobileportal.interactors.create_account;

import com.aeries.mobileportal.AnalyticsScreenNames;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ConfirmAccountRequest;
import com.aeries.mobileportal.models.CreateAccountRequest;
import com.aeries.mobileportal.models.School;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.AnalyticsService.DefaultImpls;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0018J\u0006\u0010$\u001a\u00020\u0018J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "createAccountService", "Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;Lcom/aeries/mobileportal/web_services/services/CreateAccountService;Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;)V", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getCreateAccountService", "()Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "checkAccountTaken", "", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "callback", "Lcom/aeries/mobileportal/interactors/create_account/CreateAccountCallback;", "confirmAccount", "confirmAccountRequest", "Lcom/aeries/mobileportal/models/ConfirmAccountRequest;", "createAccount", "createAccountRequest", "Lcom/aeries/mobileportal/models/CreateAccountRequest;", "sendAnalytics", "sendCompletedAnalytics", "setDefaultEmail", "email", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CreateAccountInteractor.kt */
public final class CreateAccountInteractor extends BaseInteractor {
    @NotNull
    private final AnalyticsService analyticsService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final CreateAccountService createAccountService;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        return this.analyticsService;
    }

    @NotNull
    public final CreateAccountService getCreateAccountService() {
        return this.createAccountService;
    }

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    public CreateAccountInteractor(@NotNull AnalyticsService analyticsService, @NotNull CreateAccountService createAccountService, @NotNull ConfigurationRepository configurationRepository, @NotNull SchoolRepo schoolRepo, @NotNull UserRepository userRepository) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "analyticsService");
        Intrinsics.checkParameterIsNotNull(createAccountService, "createAccountService");
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        this.analyticsService = analyticsService;
        this.createAccountService = createAccountService;
        this.configurationRepository = configurationRepository;
        this.schoolRepo = schoolRepo;
        this.userRepository = userRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    public final void sendAnalytics() {
        String districtName;
        String str;
        String schoolName;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String create_account = AnalyticsScreenNames.Companion.getCREATE_ACCOUNT();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getCREATE_ACCOUNT());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendAnalytics$1.INSTANCE, CreateAccountInteractor$sendAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendAnalytics$1.INSTANCE, CreateAccountInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendAnalytics$1.INSTANCE, CreateAccountInteractor$sendAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendAnalytics$1.INSTANCE, CreateAccountInteractor$sendAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void sendCompletedAnalytics() {
        String districtName;
        String str;
        String schoolName;
        Disposable subscribe;
        School school = this.schoolRepo.getSchool(this.configurationRepository.getSelectedSchoolCDS());
        AnalyticsService analyticsService = this.analyticsService;
        String create_account_succes = AnalyticsScreenNames.Companion.getCREATE_ACCOUNT_SUCCES();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppConstants.Companion.getFAKE_URL());
        stringBuilder.append(AnalyticsScreenNames.Companion.getCREATE_ACCOUNT_SUCCES());
        String stringBuilder2 = stringBuilder.toString();
        if (school != null) {
            districtName = school.getDistrictName();
            if (districtName != null) {
                str = districtName;
                if (school != null) {
                    schoolName = school.getSchoolName();
                    if (schoolName != null) {
                        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account_succes, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendCompletedAnalytics$1.INSTANCE, CreateAccountInteractor$sendCompletedAnalytics$2.INSTANCE);
                        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                        addToCompositeDisposable(subscribe);
                    }
                }
                schoolName = "";
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account_succes, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendCompletedAnalytics$1.INSTANCE, CreateAccountInteractor$sendCompletedAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        districtName = "";
        str = districtName;
        if (school != null) {
            schoolName = school.getSchoolName();
            if (schoolName != null) {
                subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account_succes, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendCompletedAnalytics$1.INSTANCE, CreateAccountInteractor$sendCompletedAnalytics$2.INSTANCE);
                Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
                addToCompositeDisposable(subscribe);
            }
        }
        schoolName = "";
        subscribe = DefaultImpls.postAnalytics$default(analyticsService, null, null, 0, null, r0.schoolRepo.getSchools().size(), schoolName, str, null, create_account_succes, stringBuilder2, 0, 0, 0, 0, 0, 0, 0, null, 261263, null).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(CreateAccountInteractor$sendCompletedAnalytics$1.INSTANCE, CreateAccountInteractor$sendCompletedAnalytics$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(subscribe, "analyticsService.postAna…},{it.printStackTrace()})");
        addToCompositeDisposable(subscribe);
    }

    public final void checkAccountTaken(@NotNull AccountTakenRequest accountTakenRequest, @NotNull CreateAccountCallback createAccountCallback) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        Intrinsics.checkParameterIsNotNull(createAccountCallback, "callback");
        accountTakenRequest = this.createAccountService.checkAccountTaken(accountTakenRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CreateAccountInteractor$checkAccountTaken$1(createAccountCallback), new CreateAccountInteractor$checkAccountTaken$2(createAccountCallback));
        Intrinsics.checkExpressionValueIsNotNull(accountTakenRequest, "createAccountService.che…      }\n                )");
        addToCompositeDisposable(accountTakenRequest);
    }

    public final void createAccount(@NotNull CreateAccountRequest createAccountRequest, @NotNull CreateAccountCallback createAccountCallback) {
        Intrinsics.checkParameterIsNotNull(createAccountRequest, "createAccountRequest");
        Intrinsics.checkParameterIsNotNull(createAccountCallback, "callback");
        createAccountRequest = this.createAccountService.createAccount(createAccountRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CreateAccountInteractor$createAccount$1(createAccountCallback), new CreateAccountInteractor$createAccount$2(createAccountCallback));
        Intrinsics.checkExpressionValueIsNotNull(createAccountRequest, "createAccountService.cre…      }\n                )");
        addToCompositeDisposable(createAccountRequest);
    }

    public final void confirmAccount(@NotNull ConfirmAccountRequest confirmAccountRequest, @NotNull CreateAccountCallback createAccountCallback) {
        Intrinsics.checkParameterIsNotNull(confirmAccountRequest, "confirmAccountRequest");
        Intrinsics.checkParameterIsNotNull(createAccountCallback, "callback");
        confirmAccountRequest = this.createAccountService.confirmAccount(confirmAccountRequest).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CreateAccountInteractor$confirmAccount$1(createAccountCallback), new CreateAccountInteractor$confirmAccount$2(createAccountCallback));
        Intrinsics.checkExpressionValueIsNotNull(confirmAccountRequest, "createAccountService.con…      }\n                )");
        addToCompositeDisposable(confirmAccountRequest);
    }

    public final void setDefaultEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        this.userRepository.setLastUserName(str);
    }
}
