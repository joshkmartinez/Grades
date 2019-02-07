package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AttendanceDetailFragment_ViewBinding implements Unbinder {
    private AttendanceDetailFragment target;
    private View view2131361937;

    @UiThread
    public AttendanceDetailFragment_ViewBinding(final AttendanceDetailFragment attendanceDetailFragment, View view) {
        this.target = attendanceDetailFragment;
        attendanceDetailFragment.dateTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.date, "field 'dateTV'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.done_button, "field 'doneButton' and method 'onButtonPressed'");
        attendanceDetailFragment.doneButton = (Button) Utils.castView(findRequiredView, C0316R.id.done_button, "field 'doneButton'", Button.class);
        this.view2131361937 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                attendanceDetailFragment.onButtonPressed();
            }
        });
        attendanceDetailFragment.periodRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.period_recycler_view, "field 'periodRV'", RecyclerView.class);
    }

    public void unbind() {
        AttendanceDetailFragment attendanceDetailFragment = this.target;
        if (attendanceDetailFragment != null) {
            this.target = null;
            attendanceDetailFragment.dateTV = null;
            attendanceDetailFragment.doneButton = null;
            attendanceDetailFragment.periodRV = null;
            this.view2131361937.setOnClickListener(null);
            this.view2131361937 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
