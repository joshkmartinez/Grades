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

public final class CheckOutFragment_ViewBinding implements Unbinder {
    private CheckOutFragment target;
    private View view2131361873;

    @UiThread
    public CheckOutFragment_ViewBinding(final CheckOutFragment checkOutFragment, View view) {
        this.target = checkOutFragment;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.check_out_button, "field 'checkOutButton' and method 'onButtonPressed'");
        checkOutFragment.checkOutButton = (Button) Utils.castView(findRequiredView, C0316R.id.check_out_button, "field 'checkOutButton'", Button.class);
        this.view2131361873 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                checkOutFragment.onButtonPressed();
            }
        });
        checkOutFragment.icon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.icon, "field 'icon'", ImageView.class);
        checkOutFragment.message = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'message'", TextView.class);
    }

    public void unbind() {
        CheckOutFragment checkOutFragment = this.target;
        if (checkOutFragment != null) {
            this.target = null;
            checkOutFragment.checkOutButton = null;
            checkOutFragment.icon = null;
            checkOutFragment.message = null;
            this.view2131361873.setOnClickListener(null);
            this.view2131361873 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
