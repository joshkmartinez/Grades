package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
import com.aeries.mobileportal.web_services.services.AnalyticsService;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.AttendanceService;
import com.aeries.mobileportal.web_services.services.ContactsService;
import com.aeries.mobileportal.web_services.services.CreateAccountService;
import com.aeries.mobileportal.web_services.services.FeedbackService;
import com.aeries.mobileportal.web_services.services.GradesService;
import com.aeries.mobileportal.web_services.services.LinkStudentService;
import com.aeries.mobileportal.web_services.services.LoginService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import com.aeries.mobileportal.web_services.services.PasswordService;
import com.aeries.mobileportal.web_services.services.ReportCardService;
import com.aeries.mobileportal.web_services.services.RestrictionService;
import com.aeries.mobileportal.web_services.services.SignalKitService;
import com.aeries.mobileportal.web_services.services.SupplementalAttendanceService;
import com.aeries.mobileportal.web_services.services.WhatIfService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010k\u001a\u00020lH\u0002J\b\u0010m\u001a\u00020lH\u0002J\b\u0010n\u001a\u00020oH\u0002J\u000e\u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020rR\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020HX.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020NX.¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001a\u0010S\u001a\u00020TX.¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020ZX.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020`X.¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020fX.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010j¨\u0006s"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "", "builder", "Lretrofit2/Retrofit$Builder;", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "(Lretrofit2/Retrofit$Builder;Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;)V", "analyticsService", "Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "getAnalyticsService", "()Lcom/aeries/mobileportal/web_services/services/AnalyticsService;", "setAnalyticsService", "(Lcom/aeries/mobileportal/web_services/services/AnalyticsService;)V", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "setApplicationService", "(Lcom/aeries/mobileportal/web_services/services/ApplicationService;)V", "attendanceService", "Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "getAttendanceService", "()Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "setAttendanceService", "(Lcom/aeries/mobileportal/web_services/services/AttendanceService;)V", "getBuilder", "()Lretrofit2/Retrofit$Builder;", "contactsService", "Lcom/aeries/mobileportal/web_services/services/ContactsService;", "getContactsService", "()Lcom/aeries/mobileportal/web_services/services/ContactsService;", "setContactsService", "(Lcom/aeries/mobileportal/web_services/services/ContactsService;)V", "createAccountService", "Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "getCreateAccountService", "()Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "setCreateAccountService", "(Lcom/aeries/mobileportal/web_services/services/CreateAccountService;)V", "feedbackService", "Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "getFeedbackService", "()Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "setFeedbackService", "(Lcom/aeries/mobileportal/web_services/services/FeedbackService;)V", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "getGradesService", "()Lcom/aeries/mobileportal/web_services/services/GradesService;", "setGradesService", "(Lcom/aeries/mobileportal/web_services/services/GradesService;)V", "linkStudentService", "Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "getLinkStudentService", "()Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "setLinkStudentService", "(Lcom/aeries/mobileportal/web_services/services/LinkStudentService;)V", "loginService", "Lcom/aeries/mobileportal/web_services/services/LoginService;", "getLoginService", "()Lcom/aeries/mobileportal/web_services/services/LoginService;", "setLoginService", "(Lcom/aeries/mobileportal/web_services/services/LoginService;)V", "getNetworkRepository", "()Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "getNotificationService", "()Lcom/aeries/mobileportal/web_services/services/NotificationService;", "setNotificationService", "(Lcom/aeries/mobileportal/web_services/services/NotificationService;)V", "passwordService", "Lcom/aeries/mobileportal/web_services/services/PasswordService;", "getPasswordService", "()Lcom/aeries/mobileportal/web_services/services/PasswordService;", "setPasswordService", "(Lcom/aeries/mobileportal/web_services/services/PasswordService;)V", "reportCardService", "Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "getReportCardService", "()Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "setReportCardService", "(Lcom/aeries/mobileportal/web_services/services/ReportCardService;)V", "restrictionService", "Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "getRestrictionService", "()Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "setRestrictionService", "(Lcom/aeries/mobileportal/web_services/services/RestrictionService;)V", "signalKitService", "Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "getSignalKitService", "()Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "setSignalKitService", "(Lcom/aeries/mobileportal/web_services/services/SignalKitService;)V", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "getSupplementalAttendanceService", "()Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "setSupplementalAttendanceService", "(Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;)V", "whatIfService", "Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "getWhatIfService", "()Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "setWhatIfService", "(Lcom/aeries/mobileportal/web_services/services/WhatIfService;)V", "getAnalyticsRetrofit", "Lretrofit2/Retrofit;", "getRetrofit", "initServices", "", "setBaseURL", "url", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ServicesProvider.kt */
public class ServicesProvider {
    @NotNull
    public AnalyticsService analyticsService;
    @NotNull
    public ApplicationService applicationService;
    @NotNull
    public AttendanceService attendanceService;
    @NotNull
    private final Builder builder;
    @NotNull
    public ContactsService contactsService;
    @NotNull
    public CreateAccountService createAccountService;
    @NotNull
    public FeedbackService feedbackService;
    @NotNull
    public GradesService gradesService;
    @NotNull
    public LinkStudentService linkStudentService;
    @NotNull
    public LoginService loginService;
    @NotNull
    private final NetworkRepo networkRepository;
    @NotNull
    public NotificationService notificationService;
    @NotNull
    public PasswordService passwordService;
    @NotNull
    public ReportCardService reportCardService;
    @NotNull
    public RestrictionService restrictionService;
    @NotNull
    public SignalKitService signalKitService;
    @NotNull
    public SupplementalAttendanceService supplementalAttendanceService;
    @NotNull
    public WhatIfService whatIfService;

    public ServicesProvider(@NotNull Builder builder, @NotNull NetworkRepo networkRepo) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        this.builder = builder;
        this.networkRepository = networkRepo;
        initServices();
    }

    @NotNull
    public final Builder getBuilder() {
        return this.builder;
    }

    @NotNull
    public final NetworkRepo getNetworkRepository() {
        return this.networkRepository;
    }

    @NotNull
    public final LoginService getLoginService() {
        LoginService loginService = this.loginService;
        if (loginService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginService");
        }
        return loginService;
    }

    public final void setLoginService(@NotNull LoginService loginService) {
        Intrinsics.checkParameterIsNotNull(loginService, "<set-?>");
        this.loginService = loginService;
    }

    @NotNull
    public final GradesService getGradesService() {
        GradesService gradesService = this.gradesService;
        if (gradesService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradesService");
        }
        return gradesService;
    }

    public final void setGradesService(@NotNull GradesService gradesService) {
        Intrinsics.checkParameterIsNotNull(gradesService, "<set-?>");
        this.gradesService = gradesService;
    }

    @NotNull
    public final ContactsService getContactsService() {
        ContactsService contactsService = this.contactsService;
        if (contactsService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsService");
        }
        return contactsService;
    }

    public final void setContactsService(@NotNull ContactsService contactsService) {
        Intrinsics.checkParameterIsNotNull(contactsService, "<set-?>");
        this.contactsService = contactsService;
    }

    @NotNull
    public final AttendanceService getAttendanceService() {
        AttendanceService attendanceService = this.attendanceService;
        if (attendanceService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attendanceService");
        }
        return attendanceService;
    }

    public final void setAttendanceService(@NotNull AttendanceService attendanceService) {
        Intrinsics.checkParameterIsNotNull(attendanceService, "<set-?>");
        this.attendanceService = attendanceService;
    }

    @NotNull
    public final SignalKitService getSignalKitService() {
        SignalKitService signalKitService = this.signalKitService;
        if (signalKitService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalKitService");
        }
        return signalKitService;
    }

    public final void setSignalKitService(@NotNull SignalKitService signalKitService) {
        Intrinsics.checkParameterIsNotNull(signalKitService, "<set-?>");
        this.signalKitService = signalKitService;
    }

    @NotNull
    public final CreateAccountService getCreateAccountService() {
        CreateAccountService createAccountService = this.createAccountService;
        if (createAccountService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createAccountService");
        }
        return createAccountService;
    }

    public final void setCreateAccountService(@NotNull CreateAccountService createAccountService) {
        Intrinsics.checkParameterIsNotNull(createAccountService, "<set-?>");
        this.createAccountService = createAccountService;
    }

    @NotNull
    public final PasswordService getPasswordService() {
        PasswordService passwordService = this.passwordService;
        if (passwordService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passwordService");
        }
        return passwordService;
    }

    public final void setPasswordService(@NotNull PasswordService passwordService) {
        Intrinsics.checkParameterIsNotNull(passwordService, "<set-?>");
        this.passwordService = passwordService;
    }

    @NotNull
    public final LinkStudentService getLinkStudentService() {
        LinkStudentService linkStudentService = this.linkStudentService;
        if (linkStudentService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkStudentService");
        }
        return linkStudentService;
    }

    public final void setLinkStudentService(@NotNull LinkStudentService linkStudentService) {
        Intrinsics.checkParameterIsNotNull(linkStudentService, "<set-?>");
        this.linkStudentService = linkStudentService;
    }

    @NotNull
    public final SupplementalAttendanceService getSupplementalAttendanceService() {
        SupplementalAttendanceService supplementalAttendanceService = this.supplementalAttendanceService;
        if (supplementalAttendanceService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("supplementalAttendanceService");
        }
        return supplementalAttendanceService;
    }

    public final void setSupplementalAttendanceService(@NotNull SupplementalAttendanceService supplementalAttendanceService) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceService, "<set-?>");
        this.supplementalAttendanceService = supplementalAttendanceService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        ApplicationService applicationService = this.applicationService;
        if (applicationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("applicationService");
        }
        return applicationService;
    }

    public final void setApplicationService(@NotNull ApplicationService applicationService) {
        Intrinsics.checkParameterIsNotNull(applicationService, "<set-?>");
        this.applicationService = applicationService;
    }

    @NotNull
    public final FeedbackService getFeedbackService() {
        FeedbackService feedbackService = this.feedbackService;
        if (feedbackService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedbackService");
        }
        return feedbackService;
    }

    public final void setFeedbackService(@NotNull FeedbackService feedbackService) {
        Intrinsics.checkParameterIsNotNull(feedbackService, "<set-?>");
        this.feedbackService = feedbackService;
    }

    @NotNull
    public final RestrictionService getRestrictionService() {
        RestrictionService restrictionService = this.restrictionService;
        if (restrictionService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restrictionService");
        }
        return restrictionService;
    }

    public final void setRestrictionService(@NotNull RestrictionService restrictionService) {
        Intrinsics.checkParameterIsNotNull(restrictionService, "<set-?>");
        this.restrictionService = restrictionService;
    }

    @NotNull
    public final AnalyticsService getAnalyticsService() {
        AnalyticsService analyticsService = this.analyticsService;
        if (analyticsService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analyticsService");
        }
        return analyticsService;
    }

    public final void setAnalyticsService(@NotNull AnalyticsService analyticsService) {
        Intrinsics.checkParameterIsNotNull(analyticsService, "<set-?>");
        this.analyticsService = analyticsService;
    }

    @NotNull
    public final WhatIfService getWhatIfService() {
        WhatIfService whatIfService = this.whatIfService;
        if (whatIfService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfService");
        }
        return whatIfService;
    }

    public final void setWhatIfService(@NotNull WhatIfService whatIfService) {
        Intrinsics.checkParameterIsNotNull(whatIfService, "<set-?>");
        this.whatIfService = whatIfService;
    }

    @NotNull
    public final ReportCardService getReportCardService() {
        ReportCardService reportCardService = this.reportCardService;
        if (reportCardService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportCardService");
        }
        return reportCardService;
    }

    public final void setReportCardService(@NotNull ReportCardService reportCardService) {
        Intrinsics.checkParameterIsNotNull(reportCardService, "<set-?>");
        this.reportCardService = reportCardService;
    }

    @NotNull
    public final NotificationService getNotificationService() {
        NotificationService notificationService = this.notificationService;
        if (notificationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationService");
        }
        return notificationService;
    }

    public final void setNotificationService(@NotNull NotificationService notificationService) {
        Intrinsics.checkParameterIsNotNull(notificationService, "<set-?>");
        this.notificationService = notificationService;
    }

    private final void initServices() {
        Retrofit retrofit = getRetrofit();
        Object create = retrofit.create(LoginService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(LoginService::class.java)");
        this.loginService = (LoginService) create;
        create = retrofit.create(GradesService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(GradesService::class.java)");
        this.gradesService = (GradesService) create;
        create = retrofit.create(ContactsService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ContactsService::class.java)");
        this.contactsService = (ContactsService) create;
        create = retrofit.create(AttendanceService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(AttendanceService::class.java)");
        this.attendanceService = (AttendanceService) create;
        create = retrofit.create(SignalKitService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(SignalKitService::class.java)");
        this.signalKitService = (SignalKitService) create;
        create = retrofit.create(CreateAccountService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(CreateAccountService::class.java)");
        this.createAccountService = (CreateAccountService) create;
        create = retrofit.create(PasswordService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(PasswordService::class.java)");
        this.passwordService = (PasswordService) create;
        create = retrofit.create(LinkStudentService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(LinkStudentService::class.java)");
        this.linkStudentService = (LinkStudentService) create;
        create = retrofit.create(SupplementalAttendanceService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(Suppleme…danceService::class.java)");
        this.supplementalAttendanceService = (SupplementalAttendanceService) create;
        create = retrofit.create(ApplicationService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ApplicationService::class.java)");
        this.applicationService = (ApplicationService) create;
        create = retrofit.create(FeedbackService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(FeedbackService::class.java)");
        this.feedbackService = (FeedbackService) create;
        create = retrofit.create(RestrictionService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RestrictionService::class.java)");
        this.restrictionService = (RestrictionService) create;
        create = getAnalyticsRetrofit().create(AnalyticsService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "getAnalyticsRetrofit().c…yticsService::class.java)");
        this.analyticsService = (AnalyticsService) create;
        create = retrofit.create(WhatIfService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(WhatIfService::class.java)");
        this.whatIfService = (WhatIfService) create;
        create = retrofit.create(ReportCardService.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(ReportCardService::class.java)");
        this.reportCardService = (ReportCardService) create;
        Object create2 = retrofit.create(NotificationService.class);
        Intrinsics.checkExpressionValueIsNotNull(create2, "retrofit.create(NotificationService::class.java)");
        this.notificationService = (NotificationService) create2;
    }

    private final Retrofit getRetrofit() {
        Retrofit build = this.builder.baseUrl(this.networkRepository.getCurrentBaseURL()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.baseUrl(networkR…CurrentBaseURL()).build()");
        return build;
    }

    private final Retrofit getAnalyticsRetrofit() {
        Retrofit build = this.builder.baseUrl(AppConstants.Companion.getANALYTICS_URL()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "builder.baseUrl(AppConst…ts.ANALYTICS_URL).build()");
        return build;
    }

    public final void setBaseURL(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        this.networkRepository.setCurrentBaseURL(str);
        initServices();
    }
}
