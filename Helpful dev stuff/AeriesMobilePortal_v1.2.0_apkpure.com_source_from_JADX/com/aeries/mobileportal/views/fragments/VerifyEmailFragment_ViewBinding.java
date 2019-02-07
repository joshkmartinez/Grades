package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class VerifyEmailFragment_ViewBinding implements Unbinder {
    private VerifyEmailFragment target;
    private View view2131362058;

    @UiThread
    public VerifyEmailFragment_ViewBinding(final VerifyEmailFragment verifyEmailFragment, View view) {
        this.target = verifyEmailFragment;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        verifyEmailFragment.nextButton = (Button) Utils.castView(findRequiredView, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                verifyEmailFragment.onNextPressed();
            }
        });
        verifyEmailFragment.verificationCode = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.verification_code, "field 'verificationCode'", TextInputEditText.class);
        verifyEmailFragment.verifyEmailMessage = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.verify_email_message, "field 'verifyEmailMessage'", TextView.class);
    }

    public void unbind() {
        VerifyEmailFragment verifyEmailFragment = this.target;
        if (verifyEmailFragment != null) {
            this.target = null;
            verifyEmailFragment.nextButton = null;
            verifyEmailFragment.verificationCode = null;
            verifyEmailFragment.verifyEmailMessage = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
