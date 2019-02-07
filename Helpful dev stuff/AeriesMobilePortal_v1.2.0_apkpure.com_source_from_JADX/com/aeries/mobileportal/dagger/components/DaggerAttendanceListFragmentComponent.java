package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.AttendanceAdapter;
import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceListener;
import com.aeries.mobileportal.dagger.modules.AttendanceListFragmentModule;
import com.aeries.mobileportal.dagger.modules.AttendanceListFragmentModule_AttendanceAdapterFactory;
import com.aeries.mobileportal.dagger.modules.AttendanceListFragmentModule_AttendanceListenerFactory;
import com.aeries.mobileportal.views.fragments.AttendanceListFragment;
import com.aeries.mobileportal.views.fragments.AttendanceListFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAttendanceListFragmentComponent implements AttendanceListFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AttendanceAdapter> attendanceAdapterProvider;
    private MembersInjector<AttendanceListFragment> attendanceListFragmentMembersInjector;
    private Provider<AttendanceListener> attendanceListenerProvider;

    public static final class Builder {
        private AttendanceListFragmentModule attendanceListFragmentModule;

        private Builder() {
        }

        public AttendanceListFragmentComponent build() {
            if (this.attendanceListFragmentModule != null) {
                return new DaggerAttendanceListFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AttendanceListFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder attendanceListFragmentModule(AttendanceListFragmentModule attendanceListFragmentModule) {
            this.attendanceListFragmentModule = (AttendanceListFragmentModule) Preconditions.checkNotNull(attendanceListFragmentModule);
            return this;
        }
    }

    private DaggerAttendanceListFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.attendanceListenerProvider = DoubleCheck.provider(AttendanceListFragmentModule_AttendanceListenerFactory.create(builder.attendanceListFragmentModule));
        this.attendanceAdapterProvider = DoubleCheck.provider(AttendanceListFragmentModule_AttendanceAdapterFactory.create(builder.attendanceListFragmentModule, this.attendanceListenerProvider));
        this.attendanceListFragmentMembersInjector = AttendanceListFragment_MembersInjector.create(this.attendanceAdapterProvider);
    }

    public void inject(AttendanceListFragment attendanceListFragment) {
        this.attendanceListFragmentMembersInjector.injectMembers(attendanceListFragment);
    }
}
