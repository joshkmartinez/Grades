package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AttendanceListFragment_ViewBinding implements Unbinder {
    private AttendanceListFragment target;

    @UiThread
    public AttendanceListFragment_ViewBinding(AttendanceListFragment attendanceListFragment, View view) {
        this.target = attendanceListFragment;
        attendanceListFragment.attendanceRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.attendance_recycler_view, "field 'attendanceRV'", RecyclerView.class);
        attendanceListFragment.noAbsencesView = Utils.findRequiredView(view, C0316R.id.no_absences, "field 'noAbsencesView'");
    }

    public void unbind() {
        AttendanceListFragment attendanceListFragment = this.target;
        if (attendanceListFragment != null) {
            this.target = null;
            attendanceListFragment.attendanceRV = null;
            attendanceListFragment.noAbsencesView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
