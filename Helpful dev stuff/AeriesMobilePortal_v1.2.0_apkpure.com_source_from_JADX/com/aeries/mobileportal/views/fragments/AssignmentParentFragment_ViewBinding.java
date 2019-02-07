package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.views.custom.CourseRowView;

public final class AssignmentParentFragment_ViewBinding implements Unbinder {
    private AssignmentParentFragment target;

    @UiThread
    public AssignmentParentFragment_ViewBinding(AssignmentParentFragment assignmentParentFragment, View view) {
        this.target = assignmentParentFragment;
        assignmentParentFragment.header = (CourseRowView) Utils.findRequiredViewAsType(view, C0316R.id.header, "field 'header'", CourseRowView.class);
        assignmentParentFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        AssignmentParentFragment assignmentParentFragment = this.target;
        if (assignmentParentFragment != null) {
            this.target = null;
            assignmentParentFragment.header = null;
            assignmentParentFragment.progressBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
