package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.dagger.components.AssignmentDetailsFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAssignmentDetailsFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAssignmentDetailsFragmentComponent.Builder;
import com.aeries.mobileportal.dagger.modules.AssignmentDetailsFragmentModule;
import com.aeries.mobileportal.models.Assignment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AssignmentDetailsFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentDetailsFragment.kt */
final class AssignmentDetailsFragment$component$2 extends Lambda implements Function0<AssignmentDetailsFragmentComponent> {
    final /* synthetic */ AssignmentDetailsFragment this$0;

    AssignmentDetailsFragment$component$2(AssignmentDetailsFragment assignmentDetailsFragment) {
        this.this$0 = assignmentDetailsFragment;
        super(0);
    }

    public final AssignmentDetailsFragmentComponent invoke() {
        Builder builder = DaggerAssignmentDetailsFragmentComponent.builder();
        Assignment access$getMAssignment$p = this.this$0.mAssignment;
        if (access$getMAssignment$p == null) {
            Intrinsics.throwNpe();
        }
        return builder.assignmentDetailsFragmentModule(new AssignmentDetailsFragmentModule(access$getMAssignment$p)).build();
    }
}
