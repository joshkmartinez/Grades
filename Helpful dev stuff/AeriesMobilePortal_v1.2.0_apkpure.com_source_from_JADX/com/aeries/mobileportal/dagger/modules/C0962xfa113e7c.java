package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class C0962xfa113e7c implements Factory<AssignmentCategoriesAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AssignmentCategoryFragmentModule module;

    public C0962xfa113e7c(AssignmentCategoryFragmentModule assignmentCategoryFragmentModule) {
        this.module = assignmentCategoryFragmentModule;
    }

    public AssignmentCategoriesAdapter get() {
        return (AssignmentCategoriesAdapter) Preconditions.checkNotNull(this.module.assignmentCategoriesAdapter(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<AssignmentCategoriesAdapter> create(AssignmentCategoryFragmentModule assignmentCategoryFragmentModule) {
        return new C0962xfa113e7c(assignmentCategoryFragmentModule);
    }
}
