package com.aeries.mobileportal.interactors.notifications;

import com.aeries.mobileportal.BuildConfig;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.models.ServerInfo;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: NotificationsInteractor.kt */
final class NotificationsInteractor$refreshNotifications$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ NotificationsCallback $callback;
    final /* synthetic */ NotificationsInteractor this$0;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ServerInfo;", "apply"}, k = 3, mv = {1, 1, 10})
    /* compiled from: NotificationsInteractor.kt */
    static final class C07611<T, R> implements Function<T, R> {
        public static final C07611 INSTANCE = new C07611();

        C07611() {
        }

        @NotNull
        public final String apply(@NotNull ServerInfo serverInfo) {
            Intrinsics.checkParameterIsNotNull(serverInfo, "it");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[]{Integer.valueOf(serverInfo.getVersion().getMajor()), Integer.valueOf(serverInfo.getVersion().getMinor()), Integer.valueOf(serverInfo.getVersion().getBuild()), Integer.valueOf(serverInfo.getVersion().getRevision())};
            serverInfo = String.format("%02d%02d%02d%02d", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(serverInfo, "java.lang.String.format(format, *args)");
            return serverInfo;
        }
    }

    NotificationsInteractor$refreshNotifications$1(NotificationsInteractor notificationsInteractor, NotificationsCallback notificationsCallback) {
        this.this$0 = notificationsInteractor;
        this.$callback = notificationsCallback;
        super(1);
    }

    public final void invoke(@NotNull final String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getApplicationService().getServerInfo(str).map(C07611.INSTANCE).flatMap(new Function<T, ObservableSource<? extends R>>() {
            @NotNull
            public final Observable<List<Notification>> apply(@NotNull String str) {
                Intrinsics.checkParameterIsNotNull(str, "it");
                if (str.compareTo(BuildConfig.NOTIFICATIONS) >= null) {
                    return this.this$0.getNotificationService().getNotifications(str);
                }
                str = Observable.just(CollectionsKt.emptyList());
                Intrinsics.checkExpressionValueIsNotNull(str, "io.reactivex.Observable.just(listOf())");
                return str;
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<? extends Notification>>() {
            public final void accept(List<? extends Notification> list) {
                NotificationsCallback notificationsCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(list, "it");
                notificationsCallback.onNotificationsRetreived(list);
                this.this$0.getNotificationsRepo().storeNotifications(list);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                NotificationsCallback notificationsCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                notificationsCallback.onNotificationsError(th);
                th.printStackTrace();
            }
        });
    }
}
