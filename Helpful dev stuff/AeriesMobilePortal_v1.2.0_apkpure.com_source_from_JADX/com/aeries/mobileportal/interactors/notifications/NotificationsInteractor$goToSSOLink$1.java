package com.aeries.mobileportal.interactors.notifications;

import android.content.Intent;
import android.net.Uri;
import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.Notification;
import com.aeries.mobileportal.models.School;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
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
final class NotificationsInteractor$goToSSOLink$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ NotificationsCallback $callback;
    final /* synthetic */ Notification $notification;
    final /* synthetic */ NotificationsInteractor this$0;

    NotificationsInteractor$goToSSOLink$1(NotificationsInteractor notificationsInteractor, Notification notification, NotificationsCallback notificationsCallback) {
        this.this$0 = notificationsInteractor;
        this.$notification = notification;
        this.$callback = notificationsCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        this.this$0.getNotificationService().getAuthorizationCode(this.$notification.getSchoolCode(), this.$notification.getUserID(), this.this$0.getUserRepository().getUserType(), str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GenericServiceResponse>() {
            public final void accept(GenericServiceResponse genericServiceResponse) {
                Intent intent = new Intent("android.intent.action.VIEW");
                School school = this.this$0.getSchoolRepo().getSchool(this.this$0.getConfigurationRepository().getSelectedSchoolCDS());
                String aeriesAppParentURL = school != null ? school.getAeriesAppParentURL() : null;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("/loginparentsso.aspx?url=");
                stringBuilder.append(this.$notification.getSsoUrl());
                stringBuilder.append("&acd=");
                stringBuilder.append(genericServiceResponse.getAuthorizationCode());
                intent.setData(Uri.parse(Intrinsics.stringPlus(aeriesAppParentURL, stringBuilder.toString())));
                intent.addFlags(ErrorDialogData.BINDER_CRASH);
                this.this$0.getContext().startActivity(intent);
                this.$callback.onSSORedirected();
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                th.printStackTrace();
                NotificationsCallback notificationsCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                notificationsCallback.onNotificationsError(th);
            }
        });
    }
}
