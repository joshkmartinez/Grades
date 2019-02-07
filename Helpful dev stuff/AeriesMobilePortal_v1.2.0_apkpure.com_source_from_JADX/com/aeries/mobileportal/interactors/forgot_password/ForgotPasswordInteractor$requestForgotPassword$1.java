package com.aeries.mobileportal.interactors.forgot_password;

import com.aeries.mobileportal.models.ForgotPasswordResponse;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ForgotPasswordResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ForgotPasswordInteractor.kt */
final class ForgotPasswordInteractor$requestForgotPassword$1<T> implements Consumer<ForgotPasswordResponse> {
    final /* synthetic */ ForgotPasswordCallback $callback;

    ForgotPasswordInteractor$requestForgotPassword$1(ForgotPasswordCallback forgotPasswordCallback) {
        this.$callback = forgotPasswordCallback;
    }

    public final void accept(ForgotPasswordResponse forgotPasswordResponse) {
        if (Intrinsics.areEqual(forgotPasswordResponse.getError(), (Object) "")) {
            ForgotPasswordCallback forgotPasswordCallback = this.$callback;
            Intrinsics.checkExpressionValueIsNotNull(forgotPasswordResponse, "it");
            forgotPasswordCallback.onForgotPasswordSuccess(forgotPasswordResponse);
            return;
        }
        forgotPasswordCallback = this.$callback;
        Intrinsics.checkExpressionValueIsNotNull(forgotPasswordResponse, "it");
        forgotPasswordCallback.onForgotPasswordFailed(forgotPasswordResponse);
    }
}
