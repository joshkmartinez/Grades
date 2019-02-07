package com.aeries.mobileportal.interactors.link_student;

import com.aeries.mobileportal.models.GenericServiceResponse;
import com.aeries.mobileportal.models.UpdateStudentContactRequest;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
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
/* compiled from: LinkStudentInteractor.kt */
final class LinkStudentInteractor$updateContact$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LinkStudentCallback $callback;
    final /* synthetic */ UpdateStudentContactRequest $updateContactRequest;
    final /* synthetic */ LinkStudentInteractor this$0;

    LinkStudentInteractor$updateContact$1(LinkStudentInteractor linkStudentInteractor, UpdateStudentContactRequest updateStudentContactRequest, LinkStudentCallback linkStudentCallback) {
        this.this$0 = linkStudentInteractor;
        this.$updateContactRequest = updateStudentContactRequest;
        this.$callback = linkStudentCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        LinkStudentInteractor linkStudentInteractor = this.this$0;
        str = this.this$0.getLinkStudentService().updateStudentContact(this.$updateContactRequest, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<GenericServiceResponse>() {
            public final void accept(GenericServiceResponse genericServiceResponse) {
                if (Intrinsics.areEqual(genericServiceResponse.getStatus(), Param.SUCCESS)) {
                    LinkStudentCallback linkStudentCallback = this.$callback;
                    Intrinsics.checkExpressionValueIsNotNull(genericServiceResponse, "it");
                    linkStudentCallback.onContactUpdatedSuccess(genericServiceResponse);
                    return;
                }
                linkStudentCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(genericServiceResponse, "it");
                linkStudentCallback.onContactUpdatedFail(genericServiceResponse);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                LinkStudentCallback linkStudentCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                linkStudentCallback.onContactUpdatedError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "linkStudentService.updat…  }\n                    )");
        linkStudentInteractor.addToCompositeDisposable(str);
    }
}
