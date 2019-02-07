package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class LoginActivity_ViewBinding implements Unbinder {
    private LoginActivity target;
    private View view2131361903;
    private View view2131361963;
    private View view2131361966;
    private View view2131361973;
    private View view2131362027;

    @UiThread
    public LoginActivity_ViewBinding(LoginActivity loginActivity) {
        this(loginActivity, loginActivity.getWindow().getDecorView());
    }

    @UiThread
    public LoginActivity_ViewBinding(final LoginActivity loginActivity, View view) {
        this.target = loginActivity;
        loginActivity.usernameTV = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.username, "field 'usernameTV'", EditText.class);
        loginActivity.passwordTV = (EditText) Utils.findRequiredViewAsType(view, C0316R.id.password, "field 'passwordTV'", EditText.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.login_button, "field 'loginButton' and method 'onLoginButtonClicked'");
        loginActivity.loginButton = (Button) Utils.castView(findRequiredView, C0316R.id.login_button, "field 'loginButton'", Button.class);
        this.view2131362027 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                loginActivity.onLoginButtonClicked();
            }
        });
        loginActivity.keepSessionSwitch = (Switch) Utils.findRequiredViewAsType(view, C0316R.id.keep_logged_in_switch, "field 'keepSessionSwitch'", Switch.class);
        findRequiredView = Utils.findRequiredView(view, C0316R.id.create_account_text, "field 'createAccountText' and method 'onCreateAccountButtonClicked'");
        loginActivity.createAccountText = (TextView) Utils.castView(findRequiredView, C0316R.id.create_account_text, "field 'createAccountText'", TextView.class);
        this.view2131361903 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                loginActivity.onCreateAccountButtonClicked();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.forgot_password_tv, "field 'forgotPasswordTV' and method 'onForgotPasswordClicked'");
        loginActivity.forgotPasswordTV = (TextView) Utils.castView(findRequiredView, C0316R.id.forgot_password_tv, "field 'forgotPasswordTV'", TextView.class);
        this.view2131361966 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                loginActivity.onForgotPasswordClicked();
            }
        });
        loginActivity.schoolsSpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.schools_spinner, "field 'schoolsSpinner'", Spinner.class);
        loginActivity.rootView = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.root_view, "field 'rootView'", ConstraintLayout.class);
        loginActivity.image = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.login_image, "field 'image'", ImageView.class);
        loginActivity.message = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'message'", TextView.class);
        loginActivity.logo = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.logo, "field 'logo'", ImageView.class);
        findRequiredView = Utils.findRequiredView(view, C0316R.id.fingerprint_auth_button, "field 'touchAuthButton' and method 'onFingerprintAuthSelected'");
        loginActivity.touchAuthButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.fingerprint_auth_button, "field 'touchAuthButton'", ImageView.class);
        this.view2131361963 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                loginActivity.onFingerprintAuthSelected();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.google_sign_in, "method 'onGoogleLoginButtonClicked'");
        this.view2131361973 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                loginActivity.onGoogleLoginButtonClicked();
            }
        });
    }

    public void unbind() {
        LoginActivity loginActivity = this.target;
        if (loginActivity != null) {
            this.target = null;
            loginActivity.usernameTV = null;
            loginActivity.passwordTV = null;
            loginActivity.loginButton = null;
            loginActivity.keepSessionSwitch = null;
            loginActivity.createAccountText = null;
            loginActivity.forgotPasswordTV = null;
            loginActivity.schoolsSpinner = null;
            loginActivity.rootView = null;
            loginActivity.image = null;
            loginActivity.message = null;
            loginActivity.logo = null;
            loginActivity.touchAuthButton = null;
            this.view2131362027.setOnClickListener(null);
            this.view2131362027 = null;
            this.view2131361903.setOnClickListener(null);
            this.view2131361903 = null;
            this.view2131361966.setOnClickListener(null);
            this.view2131361966 = null;
            this.view2131361963.setOnClickListener(null);
            this.view2131361963 = null;
            this.view2131361973.setOnClickListener(null);
            this.view2131361973 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
