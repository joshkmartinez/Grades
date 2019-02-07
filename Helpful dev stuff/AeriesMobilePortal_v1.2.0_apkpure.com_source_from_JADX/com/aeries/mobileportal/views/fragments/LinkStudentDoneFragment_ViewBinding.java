package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class LinkStudentDoneFragment_ViewBinding implements Unbinder {
    private LinkStudentDoneFragment target;
    private View view2131361937;

    @UiThread
    public LinkStudentDoneFragment_ViewBinding(final LinkStudentDoneFragment linkStudentDoneFragment, View view) {
        this.target = linkStudentDoneFragment;
        view = Utils.findRequiredView(view, C0316R.id.done_button, "field 'doneButton' and method 'onDonePressed'");
        linkStudentDoneFragment.doneButton = (Button) Utils.castView(view, C0316R.id.done_button, "field 'doneButton'", Button.class);
        this.view2131361937 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                linkStudentDoneFragment.onDonePressed();
            }
        });
    }

    public void unbind() {
        LinkStudentDoneFragment linkStudentDoneFragment = this.target;
        if (linkStudentDoneFragment != null) {
            this.target = null;
            linkStudentDoneFragment.doneButton = null;
            this.view2131361937.setOnClickListener(null);
            this.view2131361937 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
