package com.aeries.mobileportal.interactors.change_password;

import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.models.ChangePasswordResponse;
import com.aeries.mobileportal.utils.AccountUtils;
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
/* compiled from: ChangePasswordInteractor.kt */
final class ChangePasswordInteractor$changePassword$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ChangePasswordCallback $callback;
    final /* synthetic */ ChangePasswordRequest $changePasswordRequest;
    final /* synthetic */ ChangePasswordInteractor this$0;

    ChangePasswordInteractor$changePassword$1(ChangePasswordInteractor changePasswordInteractor, ChangePasswordRequest changePasswordRequest, ChangePasswordCallback changePasswordCallback) {
        this.this$0 = changePasswordInteractor;
        this.$changePasswordRequest = changePasswordRequest;
        this.$callback = changePasswordCallback;
        super(1);
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        ChangePasswordInteractor changePasswordInteractor = this.this$0;
        str = this.this$0.getPasswordService().changePasswordNoVerification(this.$changePasswordRequest, str).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<ChangePasswordResponse>() {
            public final void accept(ChangePasswordResponse changePasswordResponse) {
                if (Intrinsics.areEqual(changePasswordResponse.getStatus(), Param.SUCCESS)) {
                    changePasswordResponse = AccountUtils.Companion.getAccount(this.this$0.getAccountManager(), this.this$0.getUserRepository());
                    if (changePasswordResponse != null) {
                        this.this$0.getAccountManager().setPassword(changePasswordResponse, this.$changePasswordRequest.getPassword());
                    }
                    this.$callback.onPasswordChangedSuccess();
                    return;
                }
                String str = "";
                ChangePasswordResponse<String> errorList = changePasswordResponse.getErrorList();
                if (errorList == null) {
                    Intrinsics.throwNpe();
                }
                for (String str2 : errorList) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str2);
                    stringBuilder.append("\n");
                    str = stringBuilder.toString();
                }
                this.$callback.onPasswordChangedFail(str);
            }
        }, new Consumer<Throwable>() {
            public final void accept(Throwable th) {
                ChangePasswordCallback changePasswordCallback = this.$callback;
                Intrinsics.checkExpressionValueIsNotNull(th, "it");
                changePasswordCallback.onPasswordChangedError(th);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(str, "passwordService.changePa…  }\n                    )");
        changePasswordInteractor.addToCompositeDisposable(str);
    }
}
