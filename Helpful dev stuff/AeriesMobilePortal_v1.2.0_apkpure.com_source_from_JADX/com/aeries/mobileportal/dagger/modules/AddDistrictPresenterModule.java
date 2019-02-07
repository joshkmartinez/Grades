package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.add_district.AddDistrictInteractor;
import com.aeries.mobileportal.presenters.add_district.AddDistrictPresenter;
import com.aeries.mobileportal.views.viewmodels.add_district.AddDistrictViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AddDistrictPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/add_district/AddDistrictViewModel;", "addDistrictPresenter", "Lcom/aeries/mobileportal/presenters/add_district/AddDistrictPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/add_district/AddDistrictInteractor;", "addDistrictViewModel", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AddDistrictPresenterModule.kt */
public final class AddDistrictPresenterModule {
    @NotNull
    private final AddDistrictViewModel viewModel;

    public AddDistrictPresenterModule(@NotNull AddDistrictViewModel addDistrictViewModel) {
        Intrinsics.checkParameterIsNotNull(addDistrictViewModel, "viewModel");
        this.viewModel = addDistrictViewModel;
    }

    @NotNull
    public final AddDistrictViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AddDistrictViewModel addDistrictViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final AddDistrictPresenter addDistrictPresenter(@NotNull AddDistrictViewModel addDistrictViewModel, @NotNull AddDistrictInteractor addDistrictInteractor) {
        Intrinsics.checkParameterIsNotNull(addDistrictViewModel, "viewModel");
        Intrinsics.checkParameterIsNotNull(addDistrictInteractor, "interactor");
        return new AddDistrictPresenter(addDistrictViewModel, addDistrictInteractor);
    }
}
