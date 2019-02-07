package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class WhatIfModeFragment_ViewBinding implements Unbinder {
    private WhatIfModeFragment target;
    private View view2131361892;
    private View view2131362109;

    @UiThread
    public WhatIfModeFragment_ViewBinding(final WhatIfModeFragment whatIfModeFragment, View view) {
        this.target = whatIfModeFragment;
        whatIfModeFragment.gradeSlider = (SeekBar) Utils.findRequiredViewAsType(view, C0316R.id.grade_seekBar, "field 'gradeSlider'", SeekBar.class);
        whatIfModeFragment.expectedScore = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.expected_score, "field 'expectedScore'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.reset_score, "field 'resetScore' and method 'onResetScore'");
        whatIfModeFragment.resetScore = (TextView) Utils.castView(findRequiredView, C0316R.id.reset_score, "field 'resetScore'", TextView.class);
        this.view2131362109 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                whatIfModeFragment.onResetScore();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.continue_button, "method 'onButtonPressed'");
        this.view2131361892 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                whatIfModeFragment.onButtonPressed();
            }
        });
    }

    public void unbind() {
        WhatIfModeFragment whatIfModeFragment = this.target;
        if (whatIfModeFragment != null) {
            this.target = null;
            whatIfModeFragment.gradeSlider = null;
            whatIfModeFragment.expectedScore = null;
            whatIfModeFragment.resetScore = null;
            this.view2131362109.setOnClickListener(null);
            this.view2131362109 = null;
            this.view2131361892.setOnClickListener(null);
            this.view2131361892 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
