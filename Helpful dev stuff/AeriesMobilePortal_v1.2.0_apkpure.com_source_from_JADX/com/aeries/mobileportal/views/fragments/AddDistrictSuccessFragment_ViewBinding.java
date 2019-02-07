package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AddDistrictSuccessFragment_ViewBinding implements Unbinder {
    private AddDistrictSuccessFragment target;
    private View view2131361937;

    @UiThread
    public AddDistrictSuccessFragment_ViewBinding(final AddDistrictSuccessFragment addDistrictSuccessFragment, View view) {
        this.target = addDistrictSuccessFragment;
        view = Utils.findRequiredView(view, C0316R.id.done_button, "field 'doneButton' and method 'onHomePressed'");
        addDistrictSuccessFragment.doneButton = (Button) Utils.castView(view, C0316R.id.done_button, "field 'doneButton'", Button.class);
        this.view2131361937 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                addDistrictSuccessFragment.onHomePressed();
            }
        });
    }

    public void unbind() {
        AddDistrictSuccessFragment addDistrictSuccessFragment = this.target;
        if (addDistrictSuccessFragment != null) {
            this.target = null;
            addDistrictSuccessFragment.doneButton = null;
            this.view2131361937.setOnClickListener(null);
            this.view2131361937 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
