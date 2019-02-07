package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.AssignmentDetailsAdapter;
import com.aeries.mobileportal.dagger.modules.AssignmentDetailsFragmentModule;
import com.aeries.mobileportal.dagger.modules.AssignmentDetailsFragmentModule_AssignmentDetailsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.AssignmentDetailsFragmentModule_AssignmentFactory;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerAssignmentDetailsFragmentComponent implements AssignmentDetailsFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<AssignmentDetailsAdapter> assignmentDetailsAdapterProvider;
    private MembersInjector<AssignmentDetailsFragment> assignmentDetailsFragmentMembersInjector;
    private Provider<Assignment> assignmentProvider;

    public static final class Builder {
        private AssignmentDetailsFragmentModule assignmentDetailsFragmentModule;

        private Builder() {
        }

        public AssignmentDetailsFragmentComponent build() {
            if (this.assignmentDetailsFragmentModule != null) {
                return new DaggerAssignmentDetailsFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AssignmentDetailsFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder assignmentDetailsFragmentModule(AssignmentDetailsFragmentModule assignmentDetailsFragmentModule) {
            this.assignmentDetailsFragmentModule = (AssignmentDetailsFragmentModule) Preconditions.checkNotNull(assignmentDetailsFragmentModule);
            return this;
        }
    }

    private DaggerAssignmentDetailsFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.assignmentProvider = DoubleCheck.provider(AssignmentDetailsFragmentModule_AssignmentFactory.create(builder.assignmentDetailsFragmentModule));
        this.assignmentDetailsAdapterProvider = DoubleCheck.provider(AssignmentDetailsFragmentModule_AssignmentDetailsAdapterFactory.create(builder.assignmentDetailsFragmentModule, this.assignmentProvider));
        this.assignmentDetailsFragmentMembersInjector = AssignmentDetailsFragment_MembersInjector.create(this.assignmentDetailsAdapterProvider);
    }

    public void inject(AssignmentDetailsFragment assignmentDetailsFragment) {
        this.assignmentDetailsFragmentMembersInjector.injectMembers(assignmentDetailsFragment);
    }
}
