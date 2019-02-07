package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.supplementan_attendance.ClassCheckInInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.ClassCheckInPresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\t\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/ClassCheckInPresenterModule;", "", "viewModel", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;)V", "getViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "classCheckInPresenter", "Lcom/aeries/mobileportal/presenters/supplemental_attendance/ClassCheckInPresenter;", "classCheckInViewModel", "classCheckInInteractor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/ClassCheckInInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: ClassCheckInPresenterModule.kt */
public final class ClassCheckInPresenterModule {
    @NotNull
    private final ClassCheckInViewModel viewModel;

    public ClassCheckInPresenterModule(@NotNull ClassCheckInViewModel classCheckInViewModel) {
        Intrinsics.checkParameterIsNotNull(classCheckInViewModel, "viewModel");
        this.viewModel = classCheckInViewModel;
    }

    @NotNull
    public final ClassCheckInViewModel getViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ClassCheckInViewModel classCheckInViewModel() {
        return this.viewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final ClassCheckInPresenter classCheckInPresenter(@NotNull ClassCheckInViewModel classCheckInViewModel, @NotNull ClassCheckInInteractor classCheckInInteractor) {
        Intrinsics.checkParameterIsNotNull(classCheckInViewModel, "classCheckInViewModel");
        Intrinsics.checkParameterIsNotNull(classCheckInInteractor, "classCheckInInteractor");
        return new ClassCheckInPresenter(classCheckInViewModel, classCheckInInteractor);
    }
}
