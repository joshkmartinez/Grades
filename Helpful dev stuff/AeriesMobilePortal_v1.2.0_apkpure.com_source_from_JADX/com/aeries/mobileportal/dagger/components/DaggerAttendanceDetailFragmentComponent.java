package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.PeriodsAdapter;
import com.aeries.mobileportal.dagger.modules.AttendanceDetailFragmentModule;
import com.aeries.mobileportal.dagger.modules.AttendanceDetailFragmentModule_PeriodsAdapterFactory;
import com.aeries.mobileportal.views.fragments.AttendanceDetailFragment;
import com.aeries.mobileportal.views.fragments.AttendanceDetailFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAttendanceDetailFragmentComponent implements AttendanceDetailFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<AttendanceDetailFragment> attendanceDetailFragmentMembersInjector;
    private Provider<PeriodsAdapter> periodsAdapterProvider;

    public static final class Builder {
        private AttendanceDetailFragmentModule attendanceDetailFragmentModule;

        private Builder() {
        }

        public AttendanceDetailFragmentComponent build() {
            if (this.attendanceDetailFragmentModule != null) {
                return new DaggerAttendanceDetailFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AttendanceDetailFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder attendanceDetailFragmentModule(AttendanceDetailFragmentModule attendanceDetailFragmentModule) {
            this.attendanceDetailFragmentModule = (AttendanceDetailFragmentModule) Preconditions.checkNotNull(attendanceDetailFragmentModule);
            return this;
        }
    }

    private DaggerAttendanceDetailFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.periodsAdapterProvider = DoubleCheck.provider(AttendanceDetailFragmentModule_PeriodsAdapterFactory.create(builder.attendanceDetailFragmentModule));
        this.attendanceDetailFragmentMembersInjector = AttendanceDetailFragment_MembersInjector.create(this.periodsAdapterProvider);
    }

    public void inject(AttendanceDetailFragment attendanceDetailFragment) {
        this.attendanceDetailFragmentMembersInjector.injectMembers(attendanceDetailFragment);
    }
}
