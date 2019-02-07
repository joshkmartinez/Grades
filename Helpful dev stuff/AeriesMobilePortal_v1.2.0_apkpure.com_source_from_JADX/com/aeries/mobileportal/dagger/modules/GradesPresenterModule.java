package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.grades.GradesInteractor;
import com.aeries.mobileportal.presenters.grades.GradesPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/GradesPresenterModule;", "", "gradesViewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;)V", "getGradesViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "gradesPresenter", "Lcom/aeries/mobileportal/presenters/grades/GradesPresenter;", "gradesInteractor", "Lcom/aeries/mobileportal/interactors/grades/GradesInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: GradesPresenterModule.kt */
public final class GradesPresenterModule {
    @NotNull
    private final GradesViewModel gradesViewModel;

    public GradesPresenterModule(@NotNull GradesViewModel gradesViewModel) {
        Intrinsics.checkParameterIsNotNull(gradesViewModel, "gradesViewModel");
        this.gradesViewModel = gradesViewModel;
    }

    @NotNull
    public final GradesViewModel getGradesViewModel() {
        return this.gradesViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final GradesViewModel gradesViewModel() {
        return this.gradesViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final GradesPresenter gradesPresenter(@NotNull GradesViewModel gradesViewModel, @NotNull GradesInteractor gradesInteractor) {
        Intrinsics.checkParameterIsNotNull(gradesViewModel, "gradesViewModel");
        Intrinsics.checkParameterIsNotNull(gradesInteractor, "gradesInteractor");
        return new GradesPresenter(gradesViewModel, gradesInteractor);
    }
}
