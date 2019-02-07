package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.change_district.ChangeDistrictInteractor;
import com.aeries.mobileportal.presenters.change_district.ChangeDistrictPresenter;
import com.aeries.mobileportal.views.viewmodels.change_district.ChangeDistrictViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ChangeDistrictPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/change_district/ChangeDistrictViewModel;", "changeDistrictPresenter", "Lcom/aeries/mobileportal/presenters/change_district/ChangeDistrictPresenter;", "changeDistrictViewModel", "changeDistrictInteractor", "Lcom/aeries/mobileportal/interactors/change_district/ChangeDistrictInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ChangeDistrictPresenterModule.kt */
public final class ChangeDistrictPresenterModule {
    @NotNull
    private final ChangeDistrictViewModel viewModel;

    public ChangeDistrictPresenterModule(@NotNull ChangeDistrictViewModel changeDistrictViewModel) {
        Intrinsics.checkParameterIsNotNull(changeDistrictViewModel, "viewModel");
        this.viewModel = changeDistrictViewModel;
    }

    @NotNull
    public final ChangeDistrictViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangeDistrictViewModel changeDistrictViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ChangeDistrictPresenter changeDistrictPresenter(@NotNull ChangeDistrictViewModel changeDistrictViewModel, @NotNull ChangeDistrictInteractor changeDistrictInteractor) {
        Intrinsics.checkParameterIsNotNull(changeDistrictViewModel, "changeDistrictViewModel");
        Intrinsics.checkParameterIsNotNull(changeDistrictInteractor, "changeDistrictInteractor");
        return new ChangeDistrictPresenter(changeDistrictViewModel, changeDistrictInteractor);
    }
}
