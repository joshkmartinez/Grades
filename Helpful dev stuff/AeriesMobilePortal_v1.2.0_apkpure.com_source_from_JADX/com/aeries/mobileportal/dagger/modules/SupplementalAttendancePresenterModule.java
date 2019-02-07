package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.dagger.scopes.ActivityScope;
import com.aeries.mobileportal.interactors.supplementan_attendance.SupplementalAttendanceInteractor;
import com.aeries.mobileportal.presenters.supplemental_attendance.SupplementalAttendancePresenter;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/SupplementalAttendancePresenterModule;", "", "supplementalAttendanceViewModel", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;", "(Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;)V", "getSupplementalAttendanceViewModel", "()Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;", "supplementalAttendancePresenter", "Lcom/aeries/mobileportal/presenters/supplemental_attendance/SupplementalAttendancePresenter;", "supplementalAttendanceInteractor", "Lcom/aeries/mobileportal/interactors/supplementan_attendance/SupplementalAttendanceInteractor;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: SupplementalAttendancePresenterModule.kt */
public final class SupplementalAttendancePresenterModule {
    @NotNull
    private final SupplementalAttendanceViewModel supplementalAttendanceViewModel;

    public SupplementalAttendancePresenterModule(@NotNull SupplementalAttendanceViewModel supplementalAttendanceViewModel) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceViewModel, "supplementalAttendanceViewModel");
        this.supplementalAttendanceViewModel = supplementalAttendanceViewModel;
    }

    @NotNull
    public final SupplementalAttendanceViewModel getSupplementalAttendanceViewModel() {
        return this.supplementalAttendanceViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SupplementalAttendanceViewModel supplementalAttendanceViewModel() {
        return this.supplementalAttendanceViewModel;
    }

    @NotNull
    @ActivityScope
    @Provides
    public final SupplementalAttendancePresenter supplementalAttendancePresenter(@NotNull SupplementalAttendanceViewModel supplementalAttendanceViewModel, @NotNull SupplementalAttendanceInteractor supplementalAttendanceInteractor) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceViewModel, "supplementalAttendanceViewModel");
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceInteractor, "supplementalAttendanceInteractor");
        return new SupplementalAttendancePresenter(supplementalAttendanceViewModel, supplementalAttendanceInteractor);
    }
}
