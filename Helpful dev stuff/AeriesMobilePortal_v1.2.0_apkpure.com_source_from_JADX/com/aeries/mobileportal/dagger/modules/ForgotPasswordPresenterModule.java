package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.forgot_password.ForgotPasswordInteractor;
import com.aeries.mobileportal.presenters.forgot_password.ForgotPasswordPresenter;
import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ForgotPasswordPresenterModule;", "", "forgotPasswordViewModel", "Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;)V", "getForgotPasswordViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;", "forgotPasswordPresenter", "Lcom/aeries/mobileportal/presenters/forgot_password/ForgotPasswordPresenter;", "forgotPasswordInteractor", "Lcom/aeries/mobileportal/interactors/forgot_password/ForgotPasswordInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ForgotPasswordPresenterModule.kt */
public final class ForgotPasswordPresenterModule {
    @NotNull
    private final ForgotPasswordViewModel forgotPasswordViewModel;

    public ForgotPasswordPresenterModule(@NotNull ForgotPasswordViewModel forgotPasswordViewModel) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordViewModel, "forgotPasswordViewModel");
        this.forgotPasswordViewModel = forgotPasswordViewModel;
    }

    @NotNull
    public final ForgotPasswordViewModel getForgotPasswordViewModel() {
        return this.forgotPasswordViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ForgotPasswordViewModel forgotPasswordViewModel() {
        return this.forgotPasswordViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ForgotPasswordPresenter forgotPasswordPresenter(@NotNull ForgotPasswordViewModel forgotPasswordViewModel, @NotNull ForgotPasswordInteractor forgotPasswordInteractor) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordViewModel, "forgotPasswordViewModel");
        Intrinsics.checkParameterIsNotNull(forgotPasswordInteractor, "forgotPasswordInteractor");
        return new ForgotPasswordPresenter(forgotPasswordViewModel, forgotPasswordInteractor);
    }
}
