package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class FingerprintDialog_ViewBinding implements Unbinder {
    private FingerprintDialog target;
    private View view2131362030;

    @UiThread
    public FingerprintDialog_ViewBinding(final FingerprintDialog fingerprintDialog, View view) {
        this.target = fingerprintDialog;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.login_password, "field 'loginWithPassword' and method 'loginWithPassword'");
        fingerprintDialog.loginWithPassword = (TextView) Utils.castView(findRequiredView, C0316R.id.login_password, "field 'loginWithPassword'", TextView.class);
        this.view2131362030 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                fingerprintDialog.loginWithPassword();
            }
        });
        fingerprintDialog.accountsSpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.accounts_spinner, "field 'accountsSpinner'", Spinner.class);
    }

    public void unbind() {
        FingerprintDialog fingerprintDialog = this.target;
        if (fingerprintDialog != null) {
            this.target = null;
            fingerprintDialog.loginWithPassword = null;
            fingerprintDialog.accountsSpinner = null;
            this.view2131362030.setOnClickListener(null);
            this.view2131362030 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
