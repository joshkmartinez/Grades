package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class FeedbackFragment_ViewBinding implements Unbinder {
    private FeedbackFragment target;
    private View view2131362057;

    @UiThread
    public FeedbackFragment_ViewBinding(final FeedbackFragment feedbackFragment, View view) {
        this.target = feedbackFragment;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.next, "field 'button' and method 'onButtonPressed'");
        feedbackFragment.button = (Button) Utils.castView(findRequiredView, C0316R.id.next, "field 'button'", Button.class);
        this.view2131362057 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                feedbackFragment.onButtonPressed();
            }
        });
        feedbackFragment.emailET = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.feedback_email, "field 'emailET'", EditText.class);
        feedbackFragment.comment = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.comment, "field 'comment'", EditText.class);
    }

    public void unbind() {
        FeedbackFragment feedbackFragment = this.target;
        if (feedbackFragment != null) {
            this.target = null;
            feedbackFragment.button = null;
            feedbackFragment.emailET = null;
            feedbackFragment.comment = null;
            this.view2131362057.setOnClickListener(null);
            this.view2131362057 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
