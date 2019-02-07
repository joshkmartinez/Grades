package com.aeries.mobileportal.adapters;

import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentsAdapter.kt */
final class AssignmentsAdapter$removeMockAssignments$2 extends Lambda implements Function1<AssignmentRowViewModel, Boolean> {
    public static final AssignmentsAdapter$removeMockAssignments$2 INSTANCE = new AssignmentsAdapter$removeMockAssignments$2();

    AssignmentsAdapter$removeMockAssignments$2() {
        super(1);
    }

    public final boolean invoke(@NotNull AssignmentRowViewModel assignmentRowViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentRowViewModel, "it");
        return assignmentRowViewModel.isMocked();
    }
}
