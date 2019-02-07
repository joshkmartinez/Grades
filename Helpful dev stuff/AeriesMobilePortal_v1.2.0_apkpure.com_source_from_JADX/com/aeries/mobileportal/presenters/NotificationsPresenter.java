package com.aeries.mobileportal.presenters;

import android.content.Intent;
import android.net.Uri;
import com.aeries.mobileportal.interactors.notifications.NotificationsCallback;
import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.views.viewmodels.NotificationsViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/presenters/NotificationsPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsCallback;", "notificationsViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;", "getNotificationsViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "getNotifications", "", "isChangePasswordDisabled", "", "onActionButtonClick", "notification", "Lcom/aeries/mobileportal/models/Notification;", "onCreate", "onNotificationsError", "e", "", "onNotificationsRetreived", "notifications", "", "onSSORedirected", "refreshNotifications", "updateNotification", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsPresenter.kt */
public final class NotificationsPresenter extends BasePresenter<NotificationsViewModel> implements NotificationsCallback {
    @NotNull
    private final NotificationsInteractor interactor;
    @NotNull
    private final NotificationsViewModel notificationsViewModel;

    public void onCreate() {
    }

    @NotNull
    public final NotificationsInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final NotificationsViewModel getNotificationsViewModel() {
        return this.notificationsViewModel;
    }

    public NotificationsPresenter(@NotNull NotificationsViewModel notificationsViewModel, @NotNull NotificationsInteractor notificationsInteractor) {
        Intrinsics.checkParameterIsNotNull(notificationsViewModel, "notificationsViewModel");
        Intrinsics.checkParameterIsNotNull(notificationsInteractor, "interactor");
        super(notificationsViewModel, notificationsInteractor);
        this.notificationsViewModel = notificationsViewModel;
        this.interactor = notificationsInteractor;
    }

    public final void getNotifications() {
        this.notificationsViewModel.showProgressBar(true);
        this.interactor.getNotifications(this);
    }

    public final void refreshNotifications() {
        this.interactor.refreshNotifications(this);
    }

    public final void updateNotification(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        if ((Intrinsics.areEqual(notification.getStatus(), (Object) "Read") ^ 1) != 0) {
            this.interactor.updateNotification(notification);
        }
    }

    public final void onActionButtonClick(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        Intent intent = new Intent("android.intent.action.ALL_APPS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringsKt.substringBefore$default(notification.getSsoUrl(), ".", null, 2, null));
        stringBuilder.append(":");
        intent.setData(Uri.parse(stringBuilder.toString()));
        if (!this.notificationsViewModel.attemptStartActivity(intent) && (Intrinsics.areEqual(notification.getSsoUrl(), (Object) "0") ^ 1) != 0) {
            if (!(((CharSequence) notification.getSsoUrl()).length() == 0)) {
                this.interactor.goToSSOLink(notification, this);
                this.notificationsViewModel.showRedirectingDialog(true);
            }
        }
    }

    public final boolean isChangePasswordDisabled() {
        return this.interactor.isChangePasswordDisabled();
    }

    public void onNotificationsRetreived(@NotNull List<? extends Notification> list) {
        Intrinsics.checkParameterIsNotNull(list, "notifications");
        this.notificationsViewModel.showNotifications(list);
        this.notificationsViewModel.showProgressBar(false);
    }

    public void onSSORedirected() {
        this.notificationsViewModel.showRedirectingDialog(false);
    }

    public void onNotificationsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        NotificationsViewModel notificationsViewModel = this.notificationsViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Something went wrong! Please try again later.";
        }
        notificationsViewModel.showError(th);
        this.notificationsViewModel.showProgressBar(false);
    }
}
