package com.aeries.mobileportal.interactors;

import com.aeries.mobileportal.interactors.notifications.NotificationsCallback;
import com.aeries.mobileportal.models.Notification;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: MainFragmentInteractor.kt */
final class MainFragmentInteractor$getNotifications$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ NotificationsCallback $callback;
    final /* synthetic */ MainFragmentInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
    /* compiled from: MainFragmentInteractor.kt */
    static final class C07302<T> implements Consumer<Throwable> {
        public static final C07302 INSTANCE = new C07302();

        C07302() {
        }

        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    MainFragmentInteractor$getNotifications$1(MainFragmentInteractor mainFragmentInteractor, NotificationsCallback notificationsCallback) {
        this.this$0 = mainFragmentInteractor;
        this.$callback = notificationsCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getNotificationService().getNotifications(str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<? extends Notification>>() {
            public final void accept(List<? extends Notification> list) {
                NotificationsCallback notificationsCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(list, "it");
                notificationsCallback.onNotificationsRetreived(list);
                this.this$0.getNotificationsRepo().storeNotifications(list);
            }
        }, C07302.INSTANCE);
    }
}
