package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class SchoolSelectMessageFragment_ViewBinding implements Unbinder {
    private SchoolSelectMessageFragment target;
    private View view2131362167;

    @UiThread
    public SchoolSelectMessageFragment_ViewBinding(final SchoolSelectMessageFragment schoolSelectMessageFragment, View view) {
        this.target = schoolSelectMessageFragment;
        view = Utils.findRequiredView(view, C0316R.id.start_button, "field 'startButton' and method 'onGetStartedTextViewPressed'");
        schoolSelectMessageFragment.startButton = (Button) Utils.castView(view, C0316R.id.start_button, "field 'startButton'", Button.class);
        this.view2131362167 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                schoolSelectMessageFragment.onGetStartedTextViewPressed();
            }
        });
    }

    public void unbind() {
        SchoolSelectMessageFragment schoolSelectMessageFragment = this.target;
        if (schoolSelectMessageFragment != null) {
            this.target = null;
            schoolSelectMessageFragment.startButton = null;
            this.view2131362167.setOnClickListener(null);
            this.view2131362167 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
