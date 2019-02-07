package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.communications.CommunicationsInteractor;
import com.aeries.mobileportal.presenters.communications.CommunicationsPresenter;
import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/CommunicationsPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "communicationsPresenter", "Lcom/aeries/mobileportal/presenters/communications/CommunicationsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/communications/CommunicationsInteractor;", "communicationsViewModel", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: CommunicationsPresenterModule.kt */
public final class CommunicationsPresenterModule {
    @NotNull
    private final CommunicationsViewModel viewModel;

    public CommunicationsPresenterModule(@NotNull CommunicationsViewModel communicationsViewModel) {
        Intrinsics.checkParameterIsNotNull(communicationsViewModel, "viewModel");
        this.viewModel = communicationsViewModel;
    }

    @NotNull
    public final CommunicationsViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CommunicationsViewModel communicationsViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final CommunicationsPresenter communicationsPresenter(@NotNull CommunicationsViewModel communicationsViewModel, @NotNull CommunicationsInteractor communicationsInteractor) {
        Intrinsics.checkParameterIsNotNull(communicationsViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(communicationsInteractor, "interactor");
        return new CommunicationsPresenter(communicationsViewModel, communicationsInteractor);
    }
}
