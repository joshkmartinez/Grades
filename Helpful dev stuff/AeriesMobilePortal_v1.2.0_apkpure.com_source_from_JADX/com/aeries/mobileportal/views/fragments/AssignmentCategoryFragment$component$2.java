package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.Fragment;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.AssignmentCategoryFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAssignmentCategoryFragmentComponent;
import com.aeries.mobileportal.dagger.modules.AssignmentCategoryFragmentModule;
import com.aeries.mobileportal.dagger.modules.AssignmentCategoryPresenterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AssignmentCategoryFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentCategoryFragment.kt */
final class AssignmentCategoryFragment$component$2 extends Lambda implements Function0<AssignmentCategoryFragmentComponent> {
    final /* synthetic */ AssignmentCategoryFragment this$0;

    AssignmentCategoryFragment$component$2(AssignmentCategoryFragment assignmentCategoryFragment) {
        this.this$0 = assignmentCategoryFragment;
        super(0);
    }

    public final AssignmentCategoryFragmentComponent invoke() {
        return DaggerAssignmentCategoryFragmentComponent.builder().pSPComponent(PSPApplication.Companion.get((Fragment) this.this$0)).assignmentCategoryFragmentModule(new AssignmentCategoryFragmentModule(this.this$0)).assignmentCategoryPresenterModule(new AssignmentCategoryPresenterModule(this.this$0)).build();
    }
}
