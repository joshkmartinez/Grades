package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class DoneAccountFragment_ViewBinding implements Unbinder {
    private DoneAccountFragment target;
    private View view2131362027;

    @UiThread
    public DoneAccountFragment_ViewBinding(final DoneAccountFragment doneAccountFragment, View view) {
        this.target = doneAccountFragment;
        view = Utils.findRequiredView(view, C0316R.id.login_button, "field 'loginButton' and method 'onGoToLoginPressed'");
        doneAccountFragment.loginButton = (Button) Utils.castView(view, C0316R.id.login_button, "field 'loginButton'", Button.class);
        this.view2131362027 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                doneAccountFragment.onGoToLoginPressed();
            }
        });
    }

    public void unbind() {
        DoneAccountFragment doneAccountFragment = this.target;
        if (doneAccountFragment != null) {
            this.target = null;
            doneAccountFragment.loginButton = null;
            this.view2131362027.setOnClickListener(null);
            this.view2131362027 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
