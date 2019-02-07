package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.interactors.notifications.NotificationsCallback;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "notificationsRepo", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/web_services/services/NotificationService;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/web_services/TokenProvider;)V", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getNotificationService", "()Lcom/aeries/mobileportal/web_services/services/NotificationService;", "getNotificationsRepo", "()Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getNotifications", "", "callback", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsCallback;", "getStoredPortalVersion", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainFragmentInteractor.kt */
public final class MainFragmentInteractor extends BaseInteractor {
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final NotificationService notificationService;
    @NotNull
    private final NotificationsRepo notificationsRepo;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final NotificationsRepo getNotificationsRepo() {
        return this.notificationsRepo;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final NotificationService getNotificationService() {
        return this.notificationService;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public MainFragmentInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull NotificationsRepo notificationsRepo, @NotNull UserRepository userRepository, @NotNull NotificationService notificationService, @NotNull ApplicationService applicationService, @NotNull TokenProvider tokenProvider) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(notificationService, "notificationService");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        this.configurationRepository = configurationRepository;
        this.notificationsRepo = notificationsRepo;
        this.userRepository = userRepository;
        this.notificationService = notificationService;
        this.applicationService = applicationService;
        this.tokenProvider = tokenProvider;
    }

    public final void getNotifications(@NotNull NotificationsCallback notificationsCallback) {
        String replace$default;
        Intrinsics.checkParameterIsNotNull(notificationsCallback, "callback");
        String portalVersion = this.configurationRepository.getPortalVersion();
        if (portalVersion != null) {
            replace$default = StringsKt.replace$default(portalVersion, ".", "", false, 4, null);
            if (replace$default != null) {
                if (replace$default.compareTo(BuildConfig.NOTIFICATIONS) >= 0) {
                    this.tokenProvider.performAuthCall(new MainFragmentInteractor$getNotifications$1(this, notificationsCallback));
                }
            }
        }
        replace$default = "0";
        if (replace$default.compareTo(BuildConfig.NOTIFICATIONS) >= 0) {
            this.tokenProvider.performAuthCall(new MainFragmentInteractor$getNotifications$1(this, notificationsCallback));
        }
    }

    @Nullable
    public final String getStoredPortalVersion() {
        return this.configurationRepository.getPortalVersion();
    }
}
