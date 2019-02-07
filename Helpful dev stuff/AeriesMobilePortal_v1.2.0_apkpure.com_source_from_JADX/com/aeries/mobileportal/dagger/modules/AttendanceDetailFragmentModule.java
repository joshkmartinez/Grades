package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.PeriodsAdapter;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.models.AttendancePeriod;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AttendanceDetailFragmentModule;", "", "periods", "", "Lcom/aeries/mobileportal/models/AttendancePeriod;", "(Ljava/util/List;)V", "getPeriods", "()Ljava/util/List;", "periodsAdapter", "Lcom/aeries/mobileportal/adapters/PeriodsAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AttendanceDetailFragmentModule.kt */
public final class AttendanceDetailFragmentModule {
    @NotNull
    private final List<AttendancePeriod> periods;

    public AttendanceDetailFragmentModule(@NotNull List<AttendancePeriod> list) {
        Intrinsics.checkParameterIsNotNull(list, "periods");
        this.periods = list;
    }

    @NotNull
    public final List<AttendancePeriod> getPeriods() {
        return this.periods;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final PeriodsAdapter periodsAdapter() {
        return new PeriodsAdapter(this.periods);
    }
}
