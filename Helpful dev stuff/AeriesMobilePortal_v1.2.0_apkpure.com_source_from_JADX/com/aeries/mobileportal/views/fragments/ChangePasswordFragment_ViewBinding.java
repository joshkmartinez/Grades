package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ChangePasswordFragment_ViewBinding implements Unbinder {
    private ChangePasswordFragment target;
    private View view2131362058;

    @UiThread
    public ChangePasswordFragment_ViewBinding(final ChangePasswordFragment changePasswordFragment, View view) {
        this.target = changePasswordFragment;
        changePasswordFragment.oldPassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.old_password, "field 'oldPassword'", TextInputEditText.class);
        changePasswordFragment.choosePassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.choose_password, "field 'choosePassword'", TextInputEditText.class);
        changePasswordFragment.confirmPassword = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.confirm_password, "field 'confirmPassword'", TextInputEditText.class);
        view = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        changePasswordFragment.nextButton = (Button) Utils.castView(view, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                changePasswordFragment.onNextPressed();
            }
        });
    }

    public void unbind() {
        ChangePasswordFragment changePasswordFragment = this.target;
        if (changePasswordFragment != null) {
            this.target = null;
            changePasswordFragment.oldPassword = null;
            changePasswordFragment.choosePassword = null;
            changePasswordFragment.confirmPassword = null;
            changePasswordFragment.nextButton = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
