package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.StudentDetailsAdapter;
import com.aeries.mobileportal.adapters.StudentDetailsAdapter.DetailListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.MainFragmentInteractor;
import com.aeries.mobileportal.presenters.MainFragmentPresenter;
import com.aeries.mobileportal.views.viewmodels.MainFragmentViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/MainFragmentModule;", "", "detailListener", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;", "(Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;)V", "getDetailListener", "()Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter$DetailListener;", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/MainFragmentViewModel;", "mainFragmentPresenter", "Lcom/aeries/mobileportal/presenters/MainFragmentPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/MainFragmentInteractor;", "studentDetailsAdapter", "Lcom/aeries/mobileportal/adapters/StudentDetailsAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: MainFragmentModule.kt */
public final class MainFragmentModule {
    @NotNull
    private final DetailListener detailListener;
    @NotNull
    private final MainFragmentViewModel viewModel;

    public MainFragmentModule(@NotNull DetailListener detailListener, @NotNull MainFragmentViewModel mainFragmentViewModel) {
        Intrinsics.checkParameterIsNotNull(detailListener, "detailListener");
        Intrinsics.checkParameterIsNotNull(mainFragmentViewModel, "viewModel");
        this.detailListener = detailListener;
        this.viewModel = mainFragmentViewModel;
    }

    @NotNull
    public final DetailListener getDetailListener() {
        return this.detailListener;
    }

    @NotNull
    public final MainFragmentViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final StudentDetailsAdapter studentDetailsAdapter() {
        return new StudentDetailsAdapter(this.detailListener);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final MainFragmentPresenter mainFragmentPresenter(@NotNull MainFragmentInteractor mainFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(mainFragmentInteractor, "interactor");
        return new MainFragmentPresenter(this.viewModel, mainFragmentInteractor);
    }
}
