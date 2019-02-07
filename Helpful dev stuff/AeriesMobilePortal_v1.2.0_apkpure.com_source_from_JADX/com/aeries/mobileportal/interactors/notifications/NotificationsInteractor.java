package com.aeries.mobileportal.interactors.notifications;

import android.content.Context;
import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import com.aeries.mobileportal.repos.adapters.SchoolRepo;
import com.aeries.mobileportal.repos.sharedpreferences.ConfigurationRepository;
import com.aeries.mobileportal.repos.sharedpreferences.UserRepository;
import com.aeries.mobileportal.web_services.TokenProvider;
import com.aeries.mobileportal.web_services.services.ApplicationService;
import com.aeries.mobileportal.web_services.services.NotificationService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&J\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010-\u001a\u00020$2\u0006\u0010(\u001a\u00020)R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006."}, d2 = {"Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "configurationRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "userRepository", "Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "schoolRepo", "Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "notificationService", "Lcom/aeries/mobileportal/web_services/services/NotificationService;", "notificationsRepo", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "applicationService", "Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "tokenProvider", "Lcom/aeries/mobileportal/web_services/TokenProvider;", "context", "Landroid/content/Context;", "(Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;Lcom/aeries/mobileportal/web_services/services/NotificationService;Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;Lcom/aeries/mobileportal/web_services/services/ApplicationService;Lcom/aeries/mobileportal/web_services/TokenProvider;Landroid/content/Context;)V", "getApplicationService", "()Lcom/aeries/mobileportal/web_services/services/ApplicationService;", "getConfigurationRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/ConfigurationRepository;", "getContext", "()Landroid/content/Context;", "getNotificationService", "()Lcom/aeries/mobileportal/web_services/services/NotificationService;", "getNotificationsRepo", "()Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "getSchoolRepo", "()Lcom/aeries/mobileportal/repos/adapters/SchoolRepo;", "getTokenProvider", "()Lcom/aeries/mobileportal/web_services/TokenProvider;", "getUserRepository", "()Lcom/aeries/mobileportal/repos/sharedpreferences/UserRepository;", "getNotifications", "", "callback", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsCallback;", "goToSSOLink", "notification", "Lcom/aeries/mobileportal/models/Notification;", "isChangePasswordDisabled", "", "refreshNotifications", "updateNotification", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsInteractor.kt */
public final class NotificationsInteractor extends BaseInteractor {
    @NotNull
    private final ApplicationService applicationService;
    @NotNull
    private final ConfigurationRepository configurationRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final NotificationService notificationService;
    @NotNull
    private final NotificationsRepo notificationsRepo;
    @NotNull
    private final SchoolRepo schoolRepo;
    @NotNull
    private final TokenProvider tokenProvider;
    @NotNull
    private final UserRepository userRepository;

    @NotNull
    public final ConfigurationRepository getConfigurationRepository() {
        return this.configurationRepository;
    }

    @NotNull
    public final UserRepository getUserRepository() {
        return this.userRepository;
    }

    @NotNull
    public final SchoolRepo getSchoolRepo() {
        return this.schoolRepo;
    }

    @NotNull
    public final NotificationService getNotificationService() {
        return this.notificationService;
    }

    @NotNull
    public final NotificationsRepo getNotificationsRepo() {
        return this.notificationsRepo;
    }

    @NotNull
    public final ApplicationService getApplicationService() {
        return this.applicationService;
    }

    @NotNull
    public final TokenProvider getTokenProvider() {
        return this.tokenProvider;
    }

    public NotificationsInteractor(@NotNull ConfigurationRepository configurationRepository, @NotNull UserRepository userRepository, @NotNull SchoolRepo schoolRepo, @NotNull NotificationService notificationService, @NotNull NotificationsRepo notificationsRepo, @NotNull ApplicationService applicationService, @NotNull TokenProvider tokenProvider, @NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(configurationRepository, "configurationRepository");
        Intrinsics.checkParameterIsNotNull(userRepository, "userRepository");
        Intrinsics.checkParameterIsNotNull(schoolRepo, "schoolRepo");
        Intrinsics.checkParameterIsNotNull(notificationService, "notificationService");
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        Intrinsics.checkParameterIsNotNull(applicationService, "applicationService");
        Intrinsics.checkParameterIsNotNull(tokenProvider, "tokenProvider");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.configurationRepository = configurationRepository;
        this.userRepository = userRepository;
        this.schoolRepo = schoolRepo;
        this.notificationService = notificationService;
        this.notificationsRepo = notificationsRepo;
        this.applicationService = applicationService;
        this.tokenProvider = tokenProvider;
        this.context = context;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public final void getNotifications(@NotNull NotificationsCallback notificationsCallback) {
        Intrinsics.checkParameterIsNotNull(notificationsCallback, "callback");
        List notifications = this.notificationsRepo.getNotifications();
        if (notifications.isEmpty()) {
            refreshNotifications(notificationsCallback);
        } else {
            notificationsCallback.onNotificationsRetreived(notifications);
        }
    }

    public final void refreshNotifications(@NotNull NotificationsCallback notificationsCallback) {
        Intrinsics.checkParameterIsNotNull(notificationsCallback, "callback");
        this.tokenProvider.performAuthCall(new NotificationsInteractor$refreshNotifications$1(this, notificationsCallback));
    }

    public final void updateNotification(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        this.tokenProvider.performAuthCall(new NotificationsInteractor$updateNotification$1(this, notification));
    }

    public final void goToSSOLink(@NotNull Notification notification, @NotNull NotificationsCallback notificationsCallback) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        Intrinsics.checkParameterIsNotNull(notificationsCallback, "callback");
        this.tokenProvider.performAuthCall(new NotificationsInteractor$goToSSOLink$1(this, notification, notificationsCallback));
    }

    public final boolean isChangePasswordDisabled() {
        String userType = this.userRepository.getUserType();
        int hashCode = userType.hashCode();
        if (hashCode != -1911556918) {
            if (hashCode == -214492645) {
                if (userType.equals("Student")) {
                    return this.configurationRepository.isChangePasswordStudentDisabled();
                }
            }
        } else if (userType.equals("Parent")) {
            return this.configurationRepository.isChangePasswordParentDisabled();
        }
        return false;
    }
}
