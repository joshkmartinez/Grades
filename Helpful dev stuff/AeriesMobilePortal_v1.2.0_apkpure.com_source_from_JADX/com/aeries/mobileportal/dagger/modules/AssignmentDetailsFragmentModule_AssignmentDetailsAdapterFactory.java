package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentDetailsAdapter;
import com.aeries.mobileportal.models.Assignment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AssignmentDetailsFragmentModule_AssignmentDetailsAdapterFactory implements Factory<AssignmentDetailsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Assignment> assignmentProvider;
    private final AssignmentDetailsFragmentModule module;

    public AssignmentDetailsFragmentModule_AssignmentDetailsAdapterFactory(AssignmentDetailsFragmentModule assignmentDetailsFragmentModule, Provider<Assignment> provider) {
        this.module = assignmentDetailsFragmentModule;
        this.assignmentProvider = provider;
    }

    public AssignmentDetailsAdapter get() {
        return (AssignmentDetailsAdapter) Preconditions.checkNotNull(this.module.assignmentDetailsAdapter((Assignment) this.assignmentProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentDetailsAdapter> create(AssignmentDetailsFragmentModule assignmentDetailsFragmentModule, Provider<Assignment> provider) {
        return new AssignmentDetailsFragmentModule_AssignmentDetailsAdapterFactory(assignmentDetailsFragmentModule, provider);
    }
}
