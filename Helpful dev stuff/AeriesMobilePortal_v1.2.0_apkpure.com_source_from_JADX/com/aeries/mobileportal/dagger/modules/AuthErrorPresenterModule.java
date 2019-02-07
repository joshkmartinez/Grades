package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.auth_error.AuthErrorInteractor;
import com.aeries.mobileportal.presenters.auth_error.AuthErrorPresenter;
import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AuthErrorPresenterModule;", "", "authErrorViewModel", "Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;)V", "getAuthErrorViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;", "authErrorPresenter", "Lcom/aeries/mobileportal/presenters/auth_error/AuthErrorPresenter;", "authErrorInteractor", "Lcom/aeries/mobileportal/interactors/auth_error/AuthErrorInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AuthErrorPresenterModule.kt */
public final class AuthErrorPresenterModule {
    @NotNull
    private final AuthErrorViewModel authErrorViewModel;

    public AuthErrorPresenterModule(@NotNull AuthErrorViewModel authErrorViewModel) {
        Intrinsics.checkParameterIsNotNull(authErrorViewModel, "authErrorViewModel");
        this.authErrorViewModel = authErrorViewModel;
    }

    @NotNull
    public final AuthErrorViewModel getAuthErrorViewModel() {
        return this.authErrorViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AuthErrorViewModel authErrorViewModel() {
        return this.authErrorViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AuthErrorPresenter authErrorPresenter(@NotNull AuthErrorViewModel authErrorViewModel, @NotNull AuthErrorInteractor authErrorInteractor) {
        Intrinsics.checkParameterIsNotNull(authErrorViewModel, "authErrorViewModel");
        Intrinsics.checkParameterIsNotNull(authErrorInteractor, "authErrorInteractor");
        return new AuthErrorPresenter(authErrorViewModel, authErrorInteractor);
    }
}
