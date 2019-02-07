package com.aeries.mobileportal.presenters;

import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.interactors.notifications.NotificationsCallback;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.views.viewmodels.MainFragmentViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/aeries/mobileportal/presenters/MainFragmentPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsCallback;", "mainFragmentVM", "interactor", "Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;)V", "getInteractor", "()Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;", "getMainFragmentVM", "()Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;", "getNotifications", "", "getReportCardsEnabled", "", "onCreate", "onNotificationsError", "e", "", "onNotificationsRetreived", "notifications", "", "Lcom/aeries/mobileportal/models/Notification;", "onSSORedirected", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainFragmentPresenter.kt */
public final class MainFragmentPresenter extends BasePresenter<MainFragmentViewModel> implements NotificationsCallback {
    @NotNull
    private final MainFragmentInteractor interactor;
    @NotNull
    private final MainFragmentViewModel mainFragmentVM;

    public void onCreate() {
    }

    public void onNotificationsError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
    }

    public void onSSORedirected() {
    }

    @NotNull
    public final MainFragmentInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final MainFragmentViewModel getMainFragmentVM() {
        return this.mainFragmentVM;
    }

    public MainFragmentPresenter(@NotNull MainFragmentViewModel mainFragmentViewModel, @NotNull MainFragmentInteractor mainFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(mainFragmentViewModel, "mainFragmentVM");
        Intrinsics.checkParameterIsNotNull(mainFragmentInteractor, "interactor");
        super(mainFragmentViewModel, mainFragmentInteractor);
        this.mainFragmentVM = mainFragmentViewModel;
        this.interactor = mainFragmentInteractor;
    }

    public final void getNotifications() {
        this.interactor.getNotifications(this);
    }

    public final boolean getReportCardsEnabled() {
        String replace$default;
        String storedPortalVersion = this.interactor.getStoredPortalVersion();
        if (storedPortalVersion != null) {
            replace$default = StringsKt.replace$default(storedPortalVersion, ".", "", false, 4, null);
            if (replace$default != null) {
                return replace$default.compareTo("08180427") < 0;
            }
        }
        replace$default = "0";
        if (replace$default.compareTo("08180427") < 0) {
        }
    }

    public void onNotificationsRetreived(@NotNull List<? extends Notification> list) {
        Intrinsics.checkParameterIsNotNull(list, "notifications");
        MainFragmentViewModel mainFragmentViewModel = this.mainFragmentVM;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if ((Intrinsics.areEqual(((Notification) next).getStatus(), (Object) "Read") ^ 1) != 0) {
                arrayList.add(next);
            }
        }
        mainFragmentViewModel.showNotificationNumber(((List) arrayList).size());
    }
}
