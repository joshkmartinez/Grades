package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class LinkStudentActivity_ViewBinding implements Unbinder {
    private LinkStudentActivity target;
    private View view2131361855;

    @UiThread
    public LinkStudentActivity_ViewBinding(LinkStudentActivity linkStudentActivity) {
        this(linkStudentActivity, linkStudentActivity.getWindow().getDecorView());
    }

    @UiThread
    public LinkStudentActivity_ViewBinding(final LinkStudentActivity linkStudentActivity, View view) {
        this.target = linkStudentActivity;
        linkStudentActivity.linkStudentText = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.link_student_text, "field 'linkStudentText'", TextView.class);
        view = Utils.findRequiredView(view, C0316R.id.cancel, "method 'onCancelClick'");
        this.view2131361855 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                linkStudentActivity.onCancelClick();
            }
        });
    }

    public void unbind() {
        LinkStudentActivity linkStudentActivity = this.target;
        if (linkStudentActivity != null) {
            this.target = null;
            linkStudentActivity.linkStudentText = null;
            this.view2131361855.setOnClickListener(null);
            this.view2131361855 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
