package com.aeries.mobileportal.interactors.settings;

import com.aeries.mobileportal.interactors.BaseInteractor;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.repos.adapters.NotificationsRepo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/interactors/settings/SettingsInteractor;", "Lcom/aeries/mobileportal/interactors/BaseInteractor;", "notificationsRepo", "Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "(Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;)V", "getNotificationsRepo", "()Lcom/aeries/mobileportal/repos/adapters/NotificationsRepo;", "getNewNotificationsSize", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsInteractor.kt */
public final class SettingsInteractor extends BaseInteractor {
    @NotNull
    private final NotificationsRepo notificationsRepo;

    public SettingsInteractor(@NotNull NotificationsRepo notificationsRepo) {
        Intrinsics.checkParameterIsNotNull(notificationsRepo, "notificationsRepo");
        this.notificationsRepo = notificationsRepo;
    }

    @NotNull
    public final NotificationsRepo getNotificationsRepo() {
        return this.notificationsRepo;
    }

    public final int getNewNotificationsSize() {
        Collection arrayList = new ArrayList();
        for (Object next : this.notificationsRepo.getNotifications()) {
            if ((Intrinsics.areEqual(((Notification) next).getStatus(), (Object) "Read") ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).size();
    }
}
