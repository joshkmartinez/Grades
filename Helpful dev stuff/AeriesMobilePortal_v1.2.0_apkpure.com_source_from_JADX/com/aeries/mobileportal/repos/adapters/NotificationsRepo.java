package com.aeries.mobileportal.repos.adapters;

import com.aeries.mobileportal.models.Notification;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "", "deleteNotifications", "", "getNotifications", "", "Lcom/aeries/mobileportal/models/Notification;", "storeNotifications", "notifications", "updateNotification", "notification", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: NotificationsRepo.kt */
public interface NotificationsRepo {
    void deleteNotifications();

    @NotNull
    List<Notification> getNotifications();

    void storeNotifications(@NotNull List<? extends Notification> list);

    void updateNotification(@NotNull Notification notification);
}
