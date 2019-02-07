package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class CheckInFragment_ViewBinding implements Unbinder {
    private CheckInFragment target;
    private View view2131361870;
    private View view2131362118;

    @UiThread
    public CheckInFragment_ViewBinding(final CheckInFragment checkInFragment, View view) {
        this.target = checkInFragment;
        checkInFragment.messageTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'messageTV'", TextView.class);
        checkInFragment.iconIV = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.icon, "field 'iconIV'", ImageView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.check_in_button, "field 'checkInButton' and method 'onCheckInPressed'");
        checkInFragment.checkInButton = (Button) Utils.castView(findRequiredView, C0316R.id.check_in_button, "field 'checkInButton'", Button.class);
        this.view2131361870 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                checkInFragment.onCheckInPressed();
            }
        });
        view = Utils.findRequiredView(view, C0316R.id.scan_button, "field 'scanButton' and method 'onScanPressed'");
        checkInFragment.scanButton = (Button) Utils.castView(view, C0316R.id.scan_button, "field 'scanButton'", Button.class);
        this.view2131362118 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                checkInFragment.onScanPressed();
            }
        });
    }

    public void unbind() {
        CheckInFragment checkInFragment = this.target;
        if (checkInFragment != null) {
            this.target = null;
            checkInFragment.messageTV = null;
            checkInFragment.iconIV = null;
            checkInFragment.checkInButton = null;
            checkInFragment.scanButton = null;
            this.view2131361870.setOnClickListener(null);
            this.view2131361870 = null;
            this.view2131362118.setOnClickListener(null);
            this.view2131362118 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
