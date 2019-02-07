package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AddWhatIfAssignmentFragment_ViewBinding implements Unbinder {
    private AddWhatIfAssignmentFragment target;
    private View view2131361822;
    private View view2131361855;

    @UiThread
    public AddWhatIfAssignmentFragment_ViewBinding(final AddWhatIfAssignmentFragment addWhatIfAssignmentFragment, View view) {
        this.target = addWhatIfAssignmentFragment;
        addWhatIfAssignmentFragment.nameET = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.name, "field 'nameET'", EditText.class);
        addWhatIfAssignmentFragment.categorySpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.category, "field 'categorySpinner'", Spinner.class);
        addWhatIfAssignmentFragment.numCorrectET = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.num_correct, "field 'numCorrectET'", EditText.class);
        addWhatIfAssignmentFragment.numPossibleET = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.num_possible, "field 'numPossibleET'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.add_assignment, "field 'addAssignmentButton' and method 'onButtonPressed'");
        addWhatIfAssignmentFragment.addAssignmentButton = (Button) Utils.castView(findRequiredView, C0316R.id.add_assignment, "field 'addAssignmentButton'", Button.class);
        this.view2131361822 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                addWhatIfAssignmentFragment.onButtonPressed();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.cancel, "field 'cancelTV' and method 'cancel'");
        addWhatIfAssignmentFragment.cancelTV = (TextView) Utils.castView(view, C0316R.id.cancel, "field 'cancelTV'", TextView.class);
        this.view2131361855 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                addWhatIfAssignmentFragment.cancel();
            }
        });
    }

    public void unbind() {
        AddWhatIfAssignmentFragment addWhatIfAssignmentFragment = this.target;
        if (addWhatIfAssignmentFragment != null) {
            this.target = null;
            addWhatIfAssignmentFragment.nameET = null;
            addWhatIfAssignmentFragment.categorySpinner = null;
            addWhatIfAssignmentFragment.numCorrectET = null;
            addWhatIfAssignmentFragment.numPossibleET = null;
            addWhatIfAssignmentFragment.addAssignmentButton = null;
            addWhatIfAssignmentFragment.cancelTV = null;
            this.view2131361822.setOnClickListener(null);
            this.view2131361822 = null;
            this.view2131361855.setOnClickListener(null);
            this.view2131361855 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
