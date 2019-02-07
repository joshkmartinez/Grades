package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.AssignmentDetailsAdapter;
import com.aeries.mobileportal.dagger.scopes.FragmentScope;
import com.aeries.mobileportal.models.Assignment;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/AssignmentDetailsFragmentModule;", "", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "(Lcom/aeries/mobileportal/models/Assignment;)V", "getAssignment", "()Lcom/aeries/mobileportal/models/Assignment;", "assignmentDetailsAdapter", "Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: AssignmentDetailsFragmentModule.kt */
public final class AssignmentDetailsFragmentModule {
    @NotNull
    private final Assignment assignment;

    public AssignmentDetailsFragmentModule(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        this.assignment = assignment;
    }

    @NotNull
    public final Assignment getAssignment() {
        return this.assignment;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final Assignment assignment() {
        return this.assignment;
    }

    @NotNull
    @FragmentScope
    @Provides
    public final AssignmentDetailsAdapter assignmentDetailsAdapter(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        return new AssignmentDetailsAdapter(assignment);
    }
}
