package com.aeries.mobileportal.presenters.auth_error;

import com.aeries.mobileportal.interactors.auth_error.AuthErrorCallback;
import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/presenters/auth_error/AuthErrorPresenter;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;", "Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorCallback;", "authErrorViewModel", "interactor", "Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;", "(Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;)V", "getAuthErrorViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;", "getInteractor", "()Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;", "deleteToken", "", "onCreate", "onTokenDeleted", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthErrorPresenter.kt */
public final class AuthErrorPresenter extends BasePresenter<AuthErrorViewModel> implements AuthErrorCallback {
    @NotNull
    private final AuthErrorViewModel authErrorViewModel;
    @NotNull
    private final AuthErrorInteractor interactor;

    public void onCreate() {
    }

    public AuthErrorPresenter(@NotNull AuthErrorViewModel authErrorViewModel, @NotNull AuthErrorInteractor authErrorInteractor) {
        Intrinsics.checkParameterIsNotNull(authErrorViewModel, "authErrorViewModel");
        Intrinsics.checkParameterIsNotNull(authErrorInteractor, "interactor");
        super(authErrorViewModel, authErrorInteractor);
        this.authErrorViewModel = authErrorViewModel;
        this.interactor = authErrorInteractor;
    }

    @NotNull
    public final AuthErrorViewModel getAuthErrorViewModel() {
        return this.authErrorViewModel;
    }

    @NotNull
    public final AuthErrorInteractor getInteractor() {
        return this.interactor;
    }

    public final void deleteToken() {
        this.interactor.deleteToken(this);
    }

    public void onTokenDeleted() {
        this.authErrorViewModel.startLoginActivity();
    }
}
