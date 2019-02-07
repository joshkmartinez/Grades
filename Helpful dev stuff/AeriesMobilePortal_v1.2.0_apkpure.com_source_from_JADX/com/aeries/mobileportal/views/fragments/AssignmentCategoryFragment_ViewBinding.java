package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AssignmentCategoryFragment_ViewBinding implements Unbinder {
    private AssignmentCategoryFragment target;

    @UiThread
    public AssignmentCategoryFragment_ViewBinding(AssignmentCategoryFragment assignmentCategoryFragment, View view) {
        this.target = assignmentCategoryFragment;
        assignmentCategoryFragment.categoriesRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.categories_rv, "field 'categoriesRV'", RecyclerView.class);
        assignmentCategoryFragment.noAssignmentsView = Utils.findRequiredView(view, C0316R.id.no_assignments, "field 'noAssignmentsView'");
    }

    public void unbind() {
        AssignmentCategoryFragment assignmentCategoryFragment = this.target;
        if (assignmentCategoryFragment != null) {
            this.target = null;
            assignmentCategoryFragment.categoriesRV = null;
            assignmentCategoryFragment.noAssignmentsView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
