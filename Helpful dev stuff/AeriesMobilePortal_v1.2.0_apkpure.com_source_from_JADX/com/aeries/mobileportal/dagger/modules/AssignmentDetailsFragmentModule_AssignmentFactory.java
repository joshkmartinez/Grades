package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.models.Assignment;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AssignmentDetailsFragmentModule_AssignmentFactory implements Factory<Assignment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AssignmentDetailsFragmentModule module;

    public AssignmentDetailsFragmentModule_AssignmentFactory(AssignmentDetailsFragmentModule assignmentDetailsFragmentModule) {
        this.module = assignmentDetailsFragmentModule;
    }

    public Assignment get() {
        return (Assignment) Preconditions.checkNotNull(this.module.assignment(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Assignment> create(AssignmentDetailsFragmentModule assignmentDetailsFragmentModule) {
        return new AssignmentDetailsFragmentModule_AssignmentFactory(assignmentDetailsFragmentModule);
    }
}
