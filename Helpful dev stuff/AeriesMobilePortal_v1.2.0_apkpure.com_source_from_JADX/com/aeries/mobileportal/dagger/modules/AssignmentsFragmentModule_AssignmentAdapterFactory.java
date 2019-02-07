package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentsAdapter;
import com.aeries.mobileportal.adapters.AssignmentsAdapter.AssignmentListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AssignmentsFragmentModule_AssignmentAdapterFactory implements Factory<AssignmentsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<AssignmentListener> listenerProvider;
    private final AssignmentsFragmentModule module;

    public AssignmentsFragmentModule_AssignmentAdapterFactory(AssignmentsFragmentModule assignmentsFragmentModule, Provider<AssignmentListener> provider) {
        this.module = assignmentsFragmentModule;
        this.listenerProvider = provider;
    }

    public AssignmentsAdapter get() {
        return (AssignmentsAdapter) Preconditions.checkNotNull(this.module.assignmentAdapter((AssignmentListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentsAdapter> create(AssignmentsFragmentModule assignmentsFragmentModule, Provider<AssignmentListener> provider) {
        return new AssignmentsFragmentModule_AssignmentAdapterFactory(assignmentsFragmentModule, provider);
    }
}
