package com.aeries.mobileportal.repos.realm;

import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import io.realm.Realm;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/repos/realm/NotificationRealmRepo;", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "()V", "deleteNotifications", "", "getNotifications", "", "Lcom/aeries/mobileportal/models/Notification;", "storeNotifications", "notifications", "updateNotification", "notification", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationRealmRepo.kt */
public final class NotificationRealmRepo implements NotificationsRepo {
    public void storeNotifications(@NotNull List<? extends Notification> list) {
        Intrinsics.checkParameterIsNotNull(list, "notifications");
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.beginTransaction();
        defaultInstance.delete(Notification.class);
        defaultInstance.copyToRealm(list);
        defaultInstance.commitTransaction();
        defaultInstance.close();
    }

    @NotNull
    public List<Notification> getNotifications() {
        Realm defaultInstance = Realm.getDefaultInstance();
        List<Notification> copyFromRealm = defaultInstance.copyFromRealm(defaultInstance.where(Notification.class).findAll());
        defaultInstance.close();
        Intrinsics.checkExpressionValueIsNotNull(copyFromRealm, "list");
        return copyFromRealm;
    }

    public void updateNotification(@NotNull Notification notification) {
        Intrinsics.checkParameterIsNotNull(notification, "notification");
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.beginTransaction();
        ((Notification) defaultInstance.where(Notification.class).equalTo("notificationID", notification.getNotificationID()).findFirst()).setStatus("Read");
        defaultInstance.commitTransaction();
        defaultInstance.close();
    }

    public void deleteNotifications() {
        Realm defaultInstance = Realm.getDefaultInstance();
        defaultInstance.beginTransaction();
        defaultInstance.delete(Notification.class);
        defaultInstance.commitTransaction();
        defaultInstance.close();
    }
}
