package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ForgotPasswordDoneFragment_ViewBinding implements Unbinder {
    private ForgotPasswordDoneFragment target;
    private View view2131362027;

    @UiThread
    public ForgotPasswordDoneFragment_ViewBinding(final ForgotPasswordDoneFragment forgotPasswordDoneFragment, View view) {
        this.target = forgotPasswordDoneFragment;
        view = Utils.findRequiredView(view, C0316R.id.login_button, "field 'returnToLoginButton' and method 'onReturnToLoginPressed'");
        forgotPasswordDoneFragment.returnToLoginButton = (Button) Utils.castView(view, C0316R.id.login_button, "field 'returnToLoginButton'", Button.class);
        this.view2131362027 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                forgotPasswordDoneFragment.onReturnToLoginPressed();
            }
        });
    }

    public void unbind() {
        ForgotPasswordDoneFragment forgotPasswordDoneFragment = this.target;
        if (forgotPasswordDoneFragment != null) {
            this.target = null;
            forgotPasswordDoneFragment.returnToLoginButton = null;
            this.view2131362027.setOnClickListener(null);
            this.view2131362027 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
