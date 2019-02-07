package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class PasswordFragment_ViewBinding implements Unbinder {
    private PasswordFragment target;
    private View view2131362058;

    @UiThread
    public PasswordFragment_ViewBinding(final PasswordFragment passwordFragment, View view) {
        this.target = passwordFragment;
        passwordFragment.choosePassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.choose_password, "field 'choosePassword'", TextInputEditText.class);
        passwordFragment.confirmPassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.confirm_password, "field 'confirmPassword'", TextInputEditText.class);
        view = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        passwordFragment.nextButton = (Button) Utils.castView(view, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                passwordFragment.onNextPressed();
            }
        });
    }

    public void unbind() {
        PasswordFragment passwordFragment = this.target;
        if (passwordFragment != null) {
            this.target = null;
            passwordFragment.choosePassword = null;
            passwordFragment.confirmPassword = null;
            passwordFragment.nextButton = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
