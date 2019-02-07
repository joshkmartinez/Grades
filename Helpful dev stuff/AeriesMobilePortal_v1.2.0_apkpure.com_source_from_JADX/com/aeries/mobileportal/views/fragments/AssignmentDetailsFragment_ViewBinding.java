package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AssignmentDetailsFragment_ViewBinding implements Unbinder {
    private AssignmentDetailsFragment target;
    private View view2131361938;

    @UiThread
    public AssignmentDetailsFragment_ViewBinding(final AssignmentDetailsFragment assignmentDetailsFragment, View view) {
        this.target = assignmentDetailsFragment;
        assignmentDetailsFragment.assignmentDetailsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.assignment_details_recyclerview, "field 'assignmentDetailsRV'", RecyclerView.class);
        view = Utils.findRequiredView(view, C0316R.id.done_textview, "field 'doneButton' and method 'onButtonPressed'");
        assignmentDetailsFragment.doneButton = (Button) Utils.castView(view, C0316R.id.done_textview, "field 'doneButton'", Button.class);
        this.view2131361938 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                assignmentDetailsFragment.onButtonPressed();
            }
        });
    }

    public void unbind() {
        AssignmentDetailsFragment assignmentDetailsFragment = this.target;
        if (assignmentDetailsFragment != null) {
            this.target = null;
            assignmentDetailsFragment.assignmentDetailsRV = null;
            assignmentDetailsFragment.doneButton = null;
            this.view2131361938.setOnClickListener(null);
            this.view2131361938 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
