package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class UserTypeSelectFragment_ViewBinding implements Unbinder {
    private UserTypeSelectFragment target;
    private View view2131362058;
    private View view2131362085;
    private View view2131362173;

    @UiThread
    public UserTypeSelectFragment_ViewBinding(final UserTypeSelectFragment userTypeSelectFragment, View view) {
        this.target = userTypeSelectFragment;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.student_image_view, "field 'studentButton' and method 'onStudentPressed'");
        userTypeSelectFragment.studentButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.student_image_view, "field 'studentButton'", ImageView.class);
        this.view2131362173 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                userTypeSelectFragment.onStudentPressed();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.parent_image_view, "field 'parentButton' and method 'onParentPressed'");
        userTypeSelectFragment.parentButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.parent_image_view, "field 'parentButton'", ImageView.class);
        this.view2131362085 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                userTypeSelectFragment.onParentPressed();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        userTypeSelectFragment.nextButton = (Button) Utils.castView(view, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                userTypeSelectFragment.onNextPressed();
            }
        });
    }

    public void unbind() {
        UserTypeSelectFragment userTypeSelectFragment = this.target;
        if (userTypeSelectFragment != null) {
            this.target = null;
            userTypeSelectFragment.studentButton = null;
            userTypeSelectFragment.parentButton = null;
            userTypeSelectFragment.nextButton = null;
            this.view2131362173.setOnClickListener(null);
            this.view2131362173 = null;
            this.view2131362085.setOnClickListener(null);
            this.view2131362085 = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
