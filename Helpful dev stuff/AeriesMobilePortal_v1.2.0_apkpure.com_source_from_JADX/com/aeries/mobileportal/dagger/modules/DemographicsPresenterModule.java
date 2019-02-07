package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.demographics.DemographicsInteractor;
import com.aeries.mobileportal.presenters.demographics.DemographicsPresenter;
import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/DemographicsPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;", "demographicsPresenter", "Lcom/aeries/mobileportal/presenters/demographics/DemographicsPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/demographics/DemographicsInteractor;", "demographicsViewModel", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: DemographicsPresenterModule.kt */
public final class DemographicsPresenterModule {
    @NotNull
    private final DemographicsViewModel viewModel;

    public DemographicsPresenterModule(@NotNull DemographicsViewModel demographicsViewModel) {
        Intrinsics.checkParameterIsNotNull(demographicsViewModel, "viewModel");
        this.viewModel = demographicsViewModel;
    }

    @NotNull
    public final DemographicsViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final DemographicsViewModel demographicsViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final DemographicsPresenter demographicsPresenter(@NotNull DemographicsViewModel demographicsViewModel, @NotNull DemographicsInteractor demographicsInteractor) {
        Intrinsics.checkParameterIsNotNull(demographicsViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(demographicsInteractor, "interactor");
        return new DemographicsPresenter(demographicsViewModel, demographicsInteractor);
    }
}
