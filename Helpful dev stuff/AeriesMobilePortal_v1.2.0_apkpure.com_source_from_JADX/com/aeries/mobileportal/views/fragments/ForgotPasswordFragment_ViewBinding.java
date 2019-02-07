package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ForgotPasswordFragment_ViewBinding implements Unbinder {
    private ForgotPasswordFragment target;
    private View view2131362058;

    @UiThread
    public ForgotPasswordFragment_ViewBinding(final ForgotPasswordFragment forgotPasswordFragment, View view) {
        this.target = forgotPasswordFragment;
        forgotPasswordFragment.verificationCode = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.verification_code, "field 'verificationCode'", TextInputEditText.class);
        forgotPasswordFragment.newPassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.new_password, "field 'newPassword'", TextInputEditText.class);
        forgotPasswordFragment.confirmPassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.confirm_password, "field 'confirmPassword'", TextInputEditText.class);
        view = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        forgotPasswordFragment.nextButton = (Button) Utils.castView(view, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                forgotPasswordFragment.onNextPressed();
            }
        });
    }

    public void unbind() {
        ForgotPasswordFragment forgotPasswordFragment = this.target;
        if (forgotPasswordFragment != null) {
            this.target = null;
            forgotPasswordFragment.verificationCode = null;
            forgotPasswordFragment.newPassword = null;
            forgotPasswordFragment.confirmPassword = null;
            forgotPasswordFragment.nextButton = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
