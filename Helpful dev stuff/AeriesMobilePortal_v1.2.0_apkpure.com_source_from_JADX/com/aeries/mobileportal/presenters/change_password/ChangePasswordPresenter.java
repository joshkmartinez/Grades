package com.aeries.mobileportal.presenters.change_password;

import com.aeries.mobileportal.interactors.change_password.ChangePasswordCallback;
import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/aeries/mobileportal/presenters/change_password/ChangePasswordPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordCallback;", "changePasswordViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordInteractor;)V", "getChangePasswordViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordInteractor;", "changePassword", "", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "getEmailAddress", "onCreate", "onPasswordChangedError", "e", "", "onPasswordChangedFail", "error", "", "onPasswordChangedSuccess", "onUsernameRetrieved", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordPresenter.kt */
public final class ChangePasswordPresenter extends BasePresenter<ChangePasswordViewModel> implements ChangePasswordCallback {
    @NotNull
    private final ChangePasswordViewModel changePasswordViewModel;
    @NotNull
    private final ChangePasswordInteractor interactor;

    public ChangePasswordPresenter(@NotNull ChangePasswordViewModel changePasswordViewModel, @NotNull ChangePasswordInteractor changePasswordInteractor) {
        Intrinsics.checkParameterIsNotNull(changePasswordViewModel, "changePasswordViewModel");
        Intrinsics.checkParameterIsNotNull(changePasswordInteractor, "interactor");
        super(changePasswordViewModel, changePasswordInteractor);
        this.changePasswordViewModel = changePasswordViewModel;
        this.interactor = changePasswordInteractor;
    }

    @NotNull
    public final ChangePasswordViewModel getChangePasswordViewModel() {
        return this.changePasswordViewModel;
    }

    @NotNull
    public final ChangePasswordInteractor getInteractor() {
        return this.interactor;
    }

    public final void getEmailAddress() {
        this.interactor.getUserEmail(this);
    }

    public final void changePassword(@NotNull ChangePasswordRequest changePasswordRequest) {
        Intrinsics.checkParameterIsNotNull(changePasswordRequest, "changePasswordRequest");
        this.interactor.changePassword(changePasswordRequest, this);
    }

    public void onUsernameRetrieved(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        this.changePasswordViewModel.showPasswordFragment(accountTakenRequest);
    }

    public void onPasswordChangedSuccess() {
        this.changePasswordViewModel.showDoneScreen();
        this.interactor.sendSuccessAnalytics();
    }

    public void onPasswordChangedFail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        this.changePasswordViewModel.showError(str);
    }

    public void onPasswordChangedError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        ChangePasswordViewModel changePasswordViewModel = this.changePasswordViewModel;
        th = th.getMessage();
        if (th == null) {
            th = "Error";
        }
        changePasswordViewModel.showError(th);
    }

    public void onCreate() {
        this.interactor.sendAnalytics();
    }
}
