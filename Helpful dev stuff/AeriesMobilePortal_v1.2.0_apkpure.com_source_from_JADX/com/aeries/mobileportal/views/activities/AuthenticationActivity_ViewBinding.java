package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AuthenticationActivity_ViewBinding implements Unbinder {
    private AuthenticationActivity target;

    @UiThread
    public AuthenticationActivity_ViewBinding(AuthenticationActivity authenticationActivity) {
        this(authenticationActivity, authenticationActivity.getWindow().getDecorView());
    }

    @UiThread
    public AuthenticationActivity_ViewBinding(AuthenticationActivity authenticationActivity, View view) {
        this.target = authenticationActivity;
        authenticationActivity.loginForm = Utils.findRequiredView(view, C0316R.id.login_form, "field 'loginForm'");
        authenticationActivity.signInButton = (Button) Utils.findRequiredViewAsType(view, C0316R.id.email_sign_in_button, "field 'signInButton'", Button.class);
        authenticationActivity.email = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.email, "field 'email'", EditText.class);
        authenticationActivity.password = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.password, "field 'password'", EditText.class);
        authenticationActivity.loginProgress = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.login_progress, "field 'loginProgress'", ProgressBar.class);
        authenticationActivity.schoolSpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.school_spinner, "field 'schoolSpinner'", Spinner.class);
        authenticationActivity.aeriesLogo = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.aeries_logo, "field 'aeriesLogo'", ImageView.class);
        authenticationActivity.aeriesBG = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.aeries_bg, "field 'aeriesBG'", ImageView.class);
    }

    public void unbind() {
        AuthenticationActivity authenticationActivity = this.target;
        if (authenticationActivity != null) {
            this.target = null;
            authenticationActivity.loginForm = null;
            authenticationActivity.signInButton = null;
            authenticationActivity.email = null;
            authenticationActivity.password = null;
            authenticationActivity.loginProgress = null;
            authenticationActivity.schoolSpinner = null;
            authenticationActivity.aeriesLogo = null;
            authenticationActivity.aeriesBG = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
