package com.aeries.mobileportal.interactors.forgot_password;

import com.aeries.mobileportal.models.ChangePasswordResponse;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 10})
/* compiled from: ForgotPasswordInteractor.kt */
final class ForgotPasswordInteractor$changePassword$1<T> implements Consumer<ChangePasswordResponse> {
    final /* synthetic */ ForgotPasswordCallback $callback;

    ForgotPasswordInteractor$changePassword$1(ForgotPasswordCallback forgotPasswordCallback) {
        this.$callback = forgotPasswordCallback;
    }

    public final void accept(ChangePasswordResponse changePasswordResponse) {
        if (Intrinsics.areEqual(changePasswordResponse.getStatus(), Param.SUCCESS)) {
            ForgotPasswordCallback forgotPasswordCallback = this.$callback;
            Intrinsics.checkExpressionValueIsNotNull(changePasswordResponse, "it");
            forgotPasswordCallback.onChangePasswordSuccess(changePasswordResponse);
            return;
        }
        forgotPasswordCallback = this.$callback;
        Intrinsics.checkExpressionValueIsNotNull(changePasswordResponse, "it");
        forgotPasswordCallback.onChangePasswordFailed(changePasswordResponse);
    }
}
