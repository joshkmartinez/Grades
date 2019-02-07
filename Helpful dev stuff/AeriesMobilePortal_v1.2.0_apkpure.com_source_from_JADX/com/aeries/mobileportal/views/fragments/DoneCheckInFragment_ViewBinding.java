package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class DoneCheckInFragment_ViewBinding implements Unbinder {
    private DoneCheckInFragment target;
    private View view2131361989;

    @UiThread
    public DoneCheckInFragment_ViewBinding(final DoneCheckInFragment doneCheckInFragment, View view) {
        this.target = doneCheckInFragment;
        doneCheckInFragment.confirmedMessageTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.checkin_confirmed_message, "field 'confirmedMessageTV'", TextView.class);
        view = Utils.findRequiredView(view, C0316R.id.home_button, "field 'homeButton' and method 'onHomePressed'");
        doneCheckInFragment.homeButton = (TextView) Utils.castView(view, C0316R.id.home_button, "field 'homeButton'", TextView.class);
        this.view2131361989 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                doneCheckInFragment.onHomePressed();
            }
        });
    }

    public void unbind() {
        DoneCheckInFragment doneCheckInFragment = this.target;
        if (doneCheckInFragment != null) {
            this.target = null;
            doneCheckInFragment.confirmedMessageTV = null;
            doneCheckInFragment.homeButton = null;
            this.view2131361989.setOnClickListener(null);
            this.view2131361989 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
