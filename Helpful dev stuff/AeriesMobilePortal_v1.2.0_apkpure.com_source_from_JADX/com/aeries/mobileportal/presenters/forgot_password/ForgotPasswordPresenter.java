package com.aeries.mobileportal.presenters.forgot_password;

import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordCallback;
import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.models.ChangePasswordResponse;
import com.aeries.mobileportal.models.ForgotPasswordResponse;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fR\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006 "}, d2 = {"Lcom/aeries/mobileportal/presenters/forgot_password/ForgotPasswordPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;", "Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordCallback;", "forgotPasswordViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;)V", "getForgotPasswordViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;", "changePassword", "", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "onChangePasswordError", "e", "", "onChangePasswordFailed", "changePasswordResponse", "Lcom/aeries/mobileportal/models/ChangePasswordResponse;", "onChangePasswordSuccess", "onCreate", "onForgotPasswordError", "onForgotPasswordFailed", "forgotPasswordResponse", "Lcom/aeries/mobileportal/models/ForgotPasswordResponse;", "onForgotPasswordSuccess", "submitForgotPasswordEmail", "email", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordPresenter.kt */
public final class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordViewModel> implements ForgotPasswordCallback {
    @NotNull
    private final ForgotPasswordViewModel forgotPasswordViewModel;
    @NotNull
    private final ForgotPasswordInteractor interactor;

    public ForgotPasswordPresenter(@NotNull ForgotPasswordViewModel forgotPasswordViewModel, @NotNull ForgotPasswordInteractor forgotPasswordInteractor) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordViewModel, "forgotPasswordViewModel");
        Intrinsics.checkParameterIsNotNull(forgotPasswordInteractor, "interactor");
        super(forgotPasswordViewModel, forgotPasswordInteractor);
        this.forgotPasswordViewModel = forgotPasswordViewModel;
        this.interactor = forgotPasswordInteractor;
    }

    @NotNull
    public final ForgotPasswordViewModel getForgotPasswordViewModel() {
        return this.forgotPasswordViewModel;
    }

    @NotNull
    public final ForgotPasswordInteractor getInteractor() {
        return this.interactor;
    }

    public final void submitForgotPasswordEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        this.interactor.requestForgotPassword(str, this);
    }

    public final void changePassword(@NotNull ChangePasswordRequest changePasswordRequest) {
        Intrinsics.checkParameterIsNotNull(changePasswordRequest, "changePasswordRequest");
        this.interactor.changePassword(changePasswordRequest, this);
    }

    public void onForgotPasswordSuccess(@NotNull ForgotPasswordResponse forgotPasswordResponse) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordResponse, "forgotPasswordResponse");
        this.forgotPasswordViewModel.showVerificationScreen(forgotPasswordResponse);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }

    public void onForgotPasswordFailed(@NotNull ForgotPasswordResponse forgotPasswordResponse) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordResponse, "forgotPasswordResponse");
        this.forgotPasswordViewModel.showError(forgotPasswordResponse.getError());
    }

    public void onForgotPasswordError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        ForgotPasswordViewModel forgotPasswordViewModel = this.forgotPasswordViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        forgotPasswordViewModel.showError(th);
    }

    public void onChangePasswordError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        ForgotPasswordViewModel forgotPasswordViewModel = this.forgotPasswordViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        forgotPasswordViewModel.showError(th);
    }

    public void onChangePasswordFailed(@NotNull ChangePasswordResponse changePasswordResponse) {
        Intrinsics.checkParameterIsNotNull(changePasswordResponse, "changePasswordResponse");
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
        this.forgotPasswordViewModel.showError(str);
    }

    public void onChangePasswordSuccess(@NotNull ChangePasswordResponse changePasswordResponse) {
        Intrinsics.checkParameterIsNotNull(changePasswordResponse, "changePasswordResponse");
        this.interactor.sendCompletedAnalytics();
        this.forgotPasswordViewModel.showDoneScreen();
    }
}
