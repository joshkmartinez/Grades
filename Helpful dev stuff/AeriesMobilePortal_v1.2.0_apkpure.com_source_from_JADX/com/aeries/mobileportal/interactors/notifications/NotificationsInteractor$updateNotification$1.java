package com.aeries.mobileportal.interactors.notifications;

import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.models.UpdateNotification;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: NotificationsInteractor.kt */
final class NotificationsInteractor$updateNotification$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ Notification $notification;
    final /* synthetic */ NotificationsInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
    /* compiled from: NotificationsInteractor.kt */
    static final class C07662<T> implements Consumer<Throwable> {
        public static final C07662 INSTANCE = new C07662();

        C07662() {
        }

        public final void accept(Throwable th) {
            th.printStackTrace();
        }
    }

    NotificationsInteractor$updateNotification$1(NotificationsInteractor notificationsInteractor, Notification notification) {
        this.this$0 = notificationsInteractor;
        this.$notification = notification;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getNotificationService().updateNotification(new UpdateNotification(this.$notification.getNotificationID()), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GenericServiceResponse>() {
            public final void accept(GenericServiceResponse genericServiceResponse) {
                this.this$0.getNotificationsRepo().updateNotification(this.$notification);
            }
        }, C07662.INSTANCE);
    }
}
