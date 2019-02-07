package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class LinkStudentInfoFragment_ViewBinding implements Unbinder {
    private LinkStudentInfoFragment target;
    private View view2131362058;

    @UiThread
    public LinkStudentInfoFragment_ViewBinding(final LinkStudentInfoFragment linkStudentInfoFragment, View view) {
        this.target = linkStudentInfoFragment;
        linkStudentInfoFragment.studentId = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.student_id, "field 'studentId'", TextInputEditText.class);
        linkStudentInfoFragment.studentPhone = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.student_phone, "field 'studentPhone'", TextInputEditText.class);
        linkStudentInfoFragment.verificationCode = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.verification_code, "field 'verificationCode'", TextInputEditText.class);
        view = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        linkStudentInfoFragment.nextButton = (Button) Utils.castView(view, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                linkStudentInfoFragment.onNextPressed();
            }
        });
    }

    public void unbind() {
        LinkStudentInfoFragment linkStudentInfoFragment = this.target;
        if (linkStudentInfoFragment != null) {
            this.target = null;
            linkStudentInfoFragment.studentId = null;
            linkStudentInfoFragment.studentPhone = null;
            linkStudentInfoFragment.verificationCode = null;
            linkStudentInfoFragment.nextButton = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
