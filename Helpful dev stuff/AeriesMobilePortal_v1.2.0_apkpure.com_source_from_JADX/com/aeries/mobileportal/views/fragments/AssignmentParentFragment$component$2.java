package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.Fragment;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.AssignmentParentFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAssignmentParentFragmentComponent;
import com.aeries.mobileportal.dagger.modules.AssignmentParentFragmentModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AssignmentParentFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentParentFragment.kt */
final class AssignmentParentFragment$component$2 extends Lambda implements Function0<AssignmentParentFragmentComponent> {
    final /* synthetic */ AssignmentParentFragment this$0;

    AssignmentParentFragment$component$2(AssignmentParentFragment assignmentParentFragment) {
        this.this$0 = assignmentParentFragment;
        super(0);
    }

    public final AssignmentParentFragmentComponent invoke() {
        return DaggerAssignmentParentFragmentComponent.builder().pSPComponent(PSPApplication.Companion.get((Fragment) this.this$0)).assignmentParentFragmentModule(new AssignmentParentFragmentModule(this.this$0)).build();
    }
}
