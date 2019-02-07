package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ThankYouFragment_ViewBinding implements Unbinder {
    private ThankYouFragment target;
    private View view2131361987;

    @UiThread
    public ThankYouFragment_ViewBinding(final ThankYouFragment thankYouFragment, View view) {
        this.target = thankYouFragment;
        view = Utils.findRequiredView(view, C0316R.id.home, "field 'home' and method 'onHomePressed'");
        thankYouFragment.home = (Button) Utils.castView(view, C0316R.id.home, "field 'home'", Button.class);
        this.view2131361987 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                thankYouFragment.onHomePressed();
            }
        });
    }

    public void unbind() {
        ThankYouFragment thankYouFragment = this.target;
        if (thankYouFragment != null) {
            this.target = null;
            thankYouFragment.home = null;
            this.view2131361987.setOnClickListener(null);
            this.view2131361987 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
