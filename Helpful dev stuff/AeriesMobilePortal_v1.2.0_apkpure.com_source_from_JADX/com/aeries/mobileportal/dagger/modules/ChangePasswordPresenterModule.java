package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.change_password.ChangePasswordInteractor;
import com.aeries.mobileportal.presenters.change_password.ChangePasswordPresenter;
import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ChangePasswordPresenterModule;", "", "changePasswordViewModel", "Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;)V", "getChangePasswordViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "changePasswordPresenter", "Lcom/aeries/mobileportal/presenters/change_password/ChangePasswordPresenter;", "changePasswordInteractor", "Lcom/aeries/mobileportal/interactors/change_password/ChangePasswordInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ChangePasswordPresenterModule.kt */
public final class ChangePasswordPresenterModule {
    @NotNull
    private final ChangePasswordViewModel changePasswordViewModel;

    public ChangePasswordPresenterModule(@NotNull ChangePasswordViewModel changePasswordViewModel) {
        Intrinsics.checkParameterIsNotNull(changePasswordViewModel, "changePasswordViewModel");
        this.changePasswordViewModel = changePasswordViewModel;
    }

    @NotNull
    public final ChangePasswordViewModel getChangePasswordViewModel() {
        return this.changePasswordViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangePasswordViewModel changePasswordViewModel() {
        return this.changePasswordViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangePasswordPresenter changePasswordPresenter(@NotNull ChangePasswordViewModel changePasswordViewModel, @NotNull ChangePasswordInteractor changePasswordInteractor) {
        Intrinsics.checkParameterIsNotNull(changePasswordViewModel, "changePasswordViewModel");
        Intrinsics.checkParameterIsNotNull(changePasswordInteractor, "changePasswordInteractor");
        return new ChangePasswordPresenter(changePasswordViewModel, changePasswordInteractor);
    }
}
