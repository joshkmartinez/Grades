package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AttendanceAdapter;
import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceListener;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AttendanceListFragmentModule;", "", "attendanceListener", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;)V", "getAttendanceListener", "()Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "attendanceAdapter", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AttendanceListFragmentModule.kt */
public final class AttendanceListFragmentModule {
    @NotNull
    private final AttendanceListener attendanceListener;

    public AttendanceListFragmentModule(@NotNull AttendanceListener attendanceListener) {
        Intrinsics.checkParameterIsNotNull(attendanceListener, "attendanceListener");
        this.attendanceListener = attendanceListener;
    }

    @NotNull
    public final AttendanceListener getAttendanceListener() {
        return this.attendanceListener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AttendanceListener attendanceListener() {
        return this.attendanceListener;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AttendanceAdapter attendanceAdapter(@NotNull AttendanceListener attendanceListener) {
        Intrinsics.checkParameterIsNotNull(attendanceListener, "attendanceListener");
        return new AttendanceAdapter(attendanceListener);
    }
}
