package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.SchoolListAdapter;
import com.aeries.mobileportal.adapters.SchoolListAdapter.SchoolListAdapterListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.SchoolSearchFragmentInteractor;
import com.aeries.mobileportal.presenters.SchoolSearchFragmentPresenter;
import com.aeries.mobileportal.views.viewmodels.SchoolSearchFragmentViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SchoolSearchFragmentModule;", "", "schoolListAdapterListener", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "(Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;)V", "getSchoolListAdapterListener", "()Lcom/aeries/mobileportal/adapters/SchoolListAdapter$SchoolListAdapterListener;", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/SchoolSearchFragmentViewModel;", "schoolListAdapter", "Lcom/aeries/mobileportal/adapters/SchoolListAdapter;", "schoolSearchFragmentPresenter", "Lcom/aeries/mobileportal/presenters/SchoolSearchFragmentPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/SchoolSearchFragmentInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SchoolSearchFragmentModule.kt */
public final class SchoolSearchFragmentModule {
    @NotNull
    private final SchoolListAdapterListener schoolListAdapterListener;
    @NotNull
    private final SchoolSearchFragmentViewModel viewModel;

    public SchoolSearchFragmentModule(@NotNull SchoolListAdapterListener schoolListAdapterListener, @NotNull SchoolSearchFragmentViewModel schoolSearchFragmentViewModel) {
        Intrinsics.checkParameterIsNotNull(schoolListAdapterListener, "schoolListAdapterListener");
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentViewModel, "viewModel");
        this.schoolListAdapterListener = schoolListAdapterListener;
        this.viewModel = schoolSearchFragmentViewModel;
    }

    @NotNull
    public final SchoolListAdapterListener getSchoolListAdapterListener() {
        return this.schoolListAdapterListener;
    }

    @NotNull
    public final SchoolSearchFragmentViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SchoolListAdapter schoolListAdapter() {
        return new SchoolListAdapter(this.schoolListAdapterListener);
    }

    @NotNull
    @FragmentScope
    @Provides
    public final SchoolSearchFragmentPresenter schoolSearchFragmentPresenter(@NotNull SchoolSearchFragmentInteractor schoolSearchFragmentInteractor) {
        Intrinsics.checkParameterIsNotNull(schoolSearchFragmentInteractor, "interactor");
        return new SchoolSearchFragmentPresenter(this.viewModel, schoolSearchFragmentInteractor);
    }
}
