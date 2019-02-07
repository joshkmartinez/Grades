package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.PSPApplicationScope;
import com.aeries.mobileportal.repos.adapters.NetworkRepo;
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
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006,"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/NetworkModule;", "", "()V", "attendanceService", "Lcom/aeries/mobileportal/web_services/services/AttendanceService;", "servicesProvider", "Lcom/aeries/mobileportal/dagger/modules/ServicesProvider;", "checkApplicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "contactsService", "Lcom/aeries/mobileportal/web_services/services/ContactsService;", "createAccountService", "Lcom/aeries/mobileportal/web_services/services/CreateAccountService;", "feedbackService", "Lcom/aeries/mobileportal/web_services/services/FeedbackService;", "gradesService", "Lcom/aeries/mobileportal/web_services/services/GradesService;", "linkStudentService", "Lcom/aeries/mobileportal/web_services/services/LinkStudentService;", "logInService", "Lcom/aeries/mobileportal/web_services/services/LoginService;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "passwordService", "Lcom/aeries/mobileportal/web_services/services/PasswordService;", "reportCardService", "Lcom/aeries/mobileportal/web_services/services/ReportCardService;", "restrictionService", "Lcom/aeries/mobileportal/web_services/services/RestrictionService;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "gson", "Lcom/google/gson/Gson;", "okHttpClient", "Lokhttp3/OkHttpClient;", "serviceContainer", "networkRepository", "Lcom/aeries/mobileportal/repos/adapters/NetworkRepo;", "signalKitService", "Lcom/aeries/mobileportal/web_services/services/SignalKitService;", "supplementalAttendanceService", "Lcom/aeries/mobileportal/web_services/services/SupplementalAttendanceService;", "whatIfService", "Lcom/aeries/mobileportal/web_services/services/WhatIfService;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module(includes = {NetworkUtilsModule.class})
/* compiled from: NetworkModule.kt */
public final class NetworkModule {
    @NotNull
    @PSPApplicationScope
    @Provides
    public final Builder retrofitBuilder(@NotNull Gson gson, @NotNull OkHttpClient okHttpClient) {
        Intrinsics.checkParameterIsNotNull(gson, "gson");
        Intrinsics.checkParameterIsNotNull(okHttpClient, "okHttpClient");
        gson = new Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).client(okHttpClient);
        Intrinsics.checkExpressionValueIsNotNull(gson, "Retrofit.Builder()\n     …    .client(okHttpClient)");
        return gson;
    }

    @NotNull
    @PSPApplicationScope
    @Provides
    public final ServicesProvider serviceContainer(@NotNull Builder builder, @NotNull NetworkRepo networkRepo) {
        Intrinsics.checkParameterIsNotNull(builder, "retrofitBuilder");
        Intrinsics.checkParameterIsNotNull(networkRepo, "networkRepository");
        return new ServicesProvider(builder, networkRepo);
    }

    @NotNull
    @Provides
    public final LoginService logInService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getLoginService();
    }

    @NotNull
    @Provides
    public final GradesService gradesService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getGradesService();
    }

    @NotNull
    @Provides
    public final ContactsService contactsService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getContactsService();
    }

    @NotNull
    @Provides
    public final AttendanceService attendanceService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getAttendanceService();
    }

    @NotNull
    @Provides
    public final SignalKitService signalKitService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getSignalKitService();
    }

    @NotNull
    @Provides
    public final CreateAccountService createAccountService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getCreateAccountService();
    }

    @NotNull
    @Provides
    public final PasswordService passwordService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getPasswordService();
    }

    @NotNull
    @Provides
    public final LinkStudentService linkStudentService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getLinkStudentService();
    }

    @NotNull
    @Provides
    public final SupplementalAttendanceService supplementalAttendanceService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getSupplementalAttendanceService();
    }

    @NotNull
    @Provides
    public final ApplicationService checkApplicationService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getApplicationService();
    }

    @NotNull
    @Provides
    public final FeedbackService feedbackService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getFeedbackService();
    }

    @NotNull
    @Provides
    public final RestrictionService restrictionService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getRestrictionService();
    }

    @NotNull
    @Provides
    public final WhatIfService whatIfService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getWhatIfService();
    }

    @NotNull
    @Provides
    public final ReportCardService reportCardService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getReportCardService();
    }

    @NotNull
    @Provides
    public final NotificationService notificationService(@NotNull ServicesProvider servicesProvider) {
        Intrinsics.checkParameterIsNotNull(servicesProvider, "servicesProvider");
        return servicesProvider.getNotificationService();
    }
}
