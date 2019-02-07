package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.create_account.CreateAccountInteractor;
import com.aeries.mobileportal.presenters.create_account.CreateAccountPresenter;
import com.aeries.mobileportal.views.viewmodels.create_account.CreateAccountViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/CreateAccountPresenterModule;", "", "createAccountViewModel", "Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;)V", "getCreateAccountViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/create_account/CreateAccountViewModel;", "createAccountPresenter", "Lcom/aeries/mobileportal/presenters/create_account/CreateAccountPresenter;", "createAccountInteractor", "Lcom/aeries/mobileportal/interactors/create_account/CreateAccountInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: CreateAccountPresenterModule.kt */
public final class CreateAccountPresenterModule {
    @NotNull
    private final CreateAccountViewModel createAccountViewModel;

    public CreateAccountPresenterModule(@NotNull CreateAccountViewModel createAccountViewModel) {
        Intrinsics.checkParameterIsNotNull(createAccountViewModel, "createAccountViewModel");
        this.createAccountViewModel = createAccountViewModel;
    }

    @NotNull
    public final CreateAccountViewModel getCreateAccountViewModel() {
        return this.createAccountViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CreateAccountViewModel createAccountViewModel() {
        return this.createAccountViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CreateAccountPresenter createAccountPresenter(@NotNull CreateAccountViewModel createAccountViewModel, @NotNull CreateAccountInteractor createAccountInteractor) {
        Intrinsics.checkParameterIsNotNull(createAccountViewModel, "createAccountViewModel");
        Intrinsics.checkParameterIsNotNull(createAccountInteractor, "createAccountInteractor");
        return new CreateAccountPresenter(createAccountViewModel, createAccountInteractor);
    }
}
