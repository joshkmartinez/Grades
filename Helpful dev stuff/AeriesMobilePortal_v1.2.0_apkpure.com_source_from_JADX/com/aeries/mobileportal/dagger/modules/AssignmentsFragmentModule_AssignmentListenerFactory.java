package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentsAdapter.AssignmentListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AssignmentsFragmentModule_AssignmentListenerFactory implements Factory<AssignmentListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AssignmentsFragmentModule module;

    public AssignmentsFragmentModule_AssignmentListenerFactory(AssignmentsFragmentModule assignmentsFragmentModule) {
        this.module = assignmentsFragmentModule;
    }

    public AssignmentListener get() {
        return (AssignmentListener) Preconditions.checkNotNull(this.module.assignmentListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentListener> create(AssignmentsFragmentModule assignmentsFragmentModule) {
        return new AssignmentsFragmentModule_AssignmentListenerFactory(assignmentsFragmentModule);
    }
}
