package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.grades.CoursesInteractor;
import com.aeries.mobileportal.presenters.grades.CoursesPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.CoursesViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/CoursesPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "coursesPresenter", "Lcom/aeries/mobileportal/presenters/grades/CoursesPresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/grades/CoursesInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: CoursesPresenterModule.kt */
public final class CoursesPresenterModule {
    @NotNull
    private final CoursesViewModel viewModel;

    public CoursesPresenterModule(@NotNull CoursesViewModel coursesViewModel) {
        Intrinsics.checkParameterIsNotNull(coursesViewModel, "viewModel");
        this.viewModel = coursesViewModel;
    }

    @NotNull
    public final CoursesViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final CoursesPresenter coursesPresenter(@NotNull CoursesInteractor coursesInteractor) {
        Intrinsics.checkParameterIsNotNull(coursesInteractor, "interactor");
        return new CoursesPresenter(this.viewModel, coursesInteractor);
    }
}
