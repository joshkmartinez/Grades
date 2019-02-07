package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.NotificationsAdapter;
import com.aeries.mobileportal.adapters.NotificationsAdapter.NotificationListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.notifications.NotificationsInteractor;
import com.aeries.mobileportal.presenters.NotificationsPresenter;
import com.aeries.mobileportal.views.viewmodels.NotificationsViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/NotificationsFragmentModule;", "", "listener", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "(Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;)V", "getListener", "()Lcom/aeries/mobileportal/adapters/NotificationsAdapter$NotificationListener;", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/NotificationsViewModel;", "notificationsAdapter", "Lcom/aeries/mobileportal/adapters/NotificationsAdapter;", "notificationsPresenter", "Lcom/aeries/mobileportal/presenters/NotificationsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/notifications/NotificationsInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: NotificationsFragmentModule.kt */
public final class NotificationsFragmentModule {
    @NotNull
    private final NotificationListener listener;
    @NotNull
    private final NotificationsViewModel viewModel;

    public NotificationsFragmentModule(@NotNull NotificationListener notificationListener, @NotNull NotificationsViewModel notificationsViewModel) {
        Intrinsics.checkParameterIsNotNull(notificationListener, CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(notificationsViewModel, "viewModel");
        this.listener = notificationListener;
        this.viewModel = notificationsViewModel;
    }

    @NotNull
    public final NotificationListener getListener() {
        return this.listener;
    }

    @NotNull
    public final NotificationsViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final NotificationsAdapter notificationsAdapter() {
        return new NotificationsAdapter(this.listener);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final NotificationsPresenter notificationsPresenter(@NotNull NotificationsInteractor notificationsInteractor) {
        Intrinsics.checkParameterIsNotNull(notificationsInteractor, "interactor");
        return new NotificationsPresenter(this.viewModel, notificationsInteractor);
    }
}
