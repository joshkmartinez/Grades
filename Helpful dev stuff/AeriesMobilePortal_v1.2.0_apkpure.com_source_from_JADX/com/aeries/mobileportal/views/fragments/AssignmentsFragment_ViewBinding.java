package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AssignmentsFragment_ViewBinding implements Unbinder {
    private AssignmentsFragment target;
    private View view2131361823;

    @UiThread
    public AssignmentsFragment_ViewBinding(final AssignmentsFragment assignmentsFragment, View view) {
        this.target = assignmentsFragment;
        assignmentsFragment.screen = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.screen, "field 'screen'", ConstraintLayout.class);
        assignmentsFragment.categoriesSpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.categories_spinner, "field 'categoriesSpinner'", Spinner.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.add_what_if, "field 'addWhatIfHolder' and method 'openWhatIfDialog'");
        assignmentsFragment.addWhatIfHolder = findRequiredView;
        this.view2131361823 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                assignmentsFragment.openWhatIfDialog();
            }
        });
        assignmentsFragment.assignmentRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.assignment_recycler_view, "field 'assignmentRV'", RecyclerView.class);
        assignmentsFragment.noDataTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.no_data, "field 'noDataTV'", TextView.class);
        assignmentsFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        assignmentsFragment.noAssignmentsView = Utils.findRequiredView(view, C0316R.id.no_assignments, "field 'noAssignmentsView'");
    }

    public void unbind() {
        AssignmentsFragment assignmentsFragment = this.target;
        if (assignmentsFragment != null) {
            this.target = null;
            assignmentsFragment.screen = null;
            assignmentsFragment.categoriesSpinner = null;
            assignmentsFragment.addWhatIfHolder = null;
            assignmentsFragment.assignmentRV = null;
            assignmentsFragment.noDataTV = null;
            assignmentsFragment.progressBar = null;
            assignmentsFragment.noAssignmentsView = null;
            this.view2131361823.setOnClickListener(null);
            this.view2131361823 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
