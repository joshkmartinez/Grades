package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class FeedbackActivity_ViewBinding implements Unbinder {
    private FeedbackActivity target;
    private View view2131362057;

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity) {
        this(feedbackActivity, feedbackActivity.getWindow().getDecorView());
    }

    @UiThread
    public FeedbackActivity_ViewBinding(final FeedbackActivity feedbackActivity, View view) {
        this.target = feedbackActivity;
        feedbackActivity.feedbackEmail = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.feedback_email, "field 'feedbackEmail'", EditText.class);
        feedbackActivity.comment = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.comment, "field 'comment'", EditText.class);
        view = Utils.findRequiredView(view, C0316R.id.next, "field 'nextButton' and method 'onNextPressed'");
        feedbackActivity.nextButton = (Button) Utils.castView(view, C0316R.id.next, "field 'nextButton'", Button.class);
        this.view2131362057 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                feedbackActivity.onNextPressed();
            }
        });
    }

    public void unbind() {
        FeedbackActivity feedbackActivity = this.target;
        if (feedbackActivity != null) {
            this.target = null;
            feedbackActivity.feedbackEmail = null;
            feedbackActivity.comment = null;
            feedbackActivity.nextButton = null;
            this.view2131362057.setOnClickListener(null);
            this.view2131362057 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
