package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.login.LoginPresenter;
import com.aeries.mobileportal.views.viewmodels.login.LoginViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/LoginPresenterModule;", "", "loginViewModel", "Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;)V", "getLoginViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/login/LoginViewModel;", "loginPresenter", "Lcom/aeries/mobileportal/presenters/login/LoginPresenter;", "loginInteractor", "Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: LoginPresenterModule.kt */
public final class LoginPresenterModule {
    @NotNull
    private final LoginViewModel loginViewModel;

    public LoginPresenterModule(@NotNull LoginViewModel loginViewModel) {
        Intrinsics.checkParameterIsNotNull(loginViewModel, "loginViewModel");
        this.loginViewModel = loginViewModel;
    }

    @NotNull
    public final LoginViewModel getLoginViewModel() {
        return this.loginViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final LoginViewModel loginViewModel() {
        return this.loginViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final LoginPresenter loginPresenter(@NotNull LoginViewModel loginViewModel, @NotNull LoginInteractor loginInteractor) {
        Intrinsics.checkParameterIsNotNull(loginViewModel, "loginViewModel");
        Intrinsics.checkParameterIsNotNull(loginInteractor, "loginInteractor");
        return new LoginPresenter(loginViewModel, loginInteractor);
    }
}
