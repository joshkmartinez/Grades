package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AttendanceActivity_ViewBinding implements Unbinder {
    private AttendanceActivity target;
    private View view2131361925;

    @UiThread
    public AttendanceActivity_ViewBinding(AttendanceActivity attendanceActivity) {
        this(attendanceActivity, attendanceActivity.getWindow().getDecorView());
    }

    @UiThread
    public AttendanceActivity_ViewBinding(final AttendanceActivity attendanceActivity, View view) {
        this.target = attendanceActivity;
        attendanceActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_name, "field 'detailName' and method 'closeActivity'");
        attendanceActivity.detailName = (TextView) Utils.castView(findRequiredView, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        this.view2131361925 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                attendanceActivity.closeActivity();
            }
        });
        attendanceActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        attendanceActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        attendanceActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        AttendanceActivity attendanceActivity = this.target;
        if (attendanceActivity != null) {
            this.target = null;
            attendanceActivity.detailTitle = null;
            attendanceActivity.detailName = null;
            attendanceActivity.detailIcon = null;
            attendanceActivity.fragmentContainer = null;
            attendanceActivity.progressBar = null;
            this.view2131361925.setOnClickListener(null);
            this.view2131361925 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
