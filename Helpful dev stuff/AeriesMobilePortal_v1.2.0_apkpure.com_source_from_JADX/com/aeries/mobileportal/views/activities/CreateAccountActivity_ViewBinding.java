package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class CreateAccountActivity_ViewBinding implements Unbinder {
    private CreateAccountActivity target;

    @UiThread
    public CreateAccountActivity_ViewBinding(CreateAccountActivity createAccountActivity) {
        this(createAccountActivity, createAccountActivity.getWindow().getDecorView());
    }

    @UiThread
    public CreateAccountActivity_ViewBinding(CreateAccountActivity createAccountActivity, View view) {
        this.target = createAccountActivity;
        createAccountActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        createAccountActivity.accountProgress = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.account_progress, "field 'accountProgress'", ProgressBar.class);
        createAccountActivity.percentageCompleteTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.percentage_complete_tv, "field 'percentageCompleteTV'", TextView.class);
    }

    public void unbind() {
        CreateAccountActivity createAccountActivity = this.target;
        if (createAccountActivity != null) {
            this.target = null;
            createAccountActivity.fragmentContainer = null;
            createAccountActivity.accountProgress = null;
            createAccountActivity.percentageCompleteTV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
