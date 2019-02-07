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

public final class EnterEmailFragment_ViewBinding implements Unbinder {
    private EnterEmailFragment target;
    private View view2131362058;

    @UiThread
    public EnterEmailFragment_ViewBinding(final EnterEmailFragment enterEmailFragment, View view) {
        this.target = enterEmailFragment;
        enterEmailFragment.email = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.email, "field 'email'", TextInputEditText.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.next_button, "field 'nextButton' and method 'onNextPressed'");
        enterEmailFragment.nextButton = (Button) Utils.castView(findRequiredView, C0316R.id.next_button, "field 'nextButton'", Button.class);
        this.view2131362058 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                enterEmailFragment.onNextPressed();
            }
        });
        enterEmailFragment.enterEmailText = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.enter_email_text, "field 'enterEmailText'", TextView.class);
    }

    public void unbind() {
        EnterEmailFragment enterEmailFragment = this.target;
        if (enterEmailFragment != null) {
            this.target = null;
            enterEmailFragment.email = null;
            enterEmailFragment.nextButton = null;
            enterEmailFragment.enterEmailText = null;
            this.view2131362058.setOnClickListener(null);
            this.view2131362058 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
