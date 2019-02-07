package com.aeries.mobileportal.views.fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentsFragment.kt */
final class AssignmentsFragment$showError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AssignmentsFragment this$0;

    AssignmentsFragment$showError$1(AssignmentsFragment assignmentsFragment) {
        this.this$0 = assignmentsFragment;
        super(0);
    }

    public final void invoke() {
        this.this$0.getFragmentManager().popBackStackImmediate();
    }
}
