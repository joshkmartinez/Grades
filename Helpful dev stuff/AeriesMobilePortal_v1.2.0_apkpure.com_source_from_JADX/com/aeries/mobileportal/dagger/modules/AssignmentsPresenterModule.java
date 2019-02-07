package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.interactors.grades.AssignmentsInteractor;
import com.aeries.mobileportal.presenters.AssignmentsPresenter;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentsViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentsPresenterModule;", "", "assignmentsViewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;)V", "assignmentPresenter", "Lcom/aeries/mobileportal/presenters/AssignmentsPresenter;", "assignmentsInteractor", "Lcom/aeries/mobileportal/interactors/grades/AssignmentsInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentsPresenterModule.kt */
public final class AssignmentsPresenterModule {
    private final AssignmentsViewModel assignmentsViewModel;

    public AssignmentsPresenterModule(@NotNull AssignmentsViewModel assignmentsViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentsViewModel, "assignmentsViewModel");
        this.assignmentsViewModel = assignmentsViewModel;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentsPresenter assignmentPresenter(@NotNull AssignmentsInteractor assignmentsInteractor) {
        Intrinsics.checkParameterIsNotNull(assignmentsInteractor, "assignmentsInteractor");
        return new AssignmentsPresenter(this.assignmentsViewModel, assignmentsInteractor);
    }
}
