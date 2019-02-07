package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class SupplementalAttendanceActivity_ViewBinding implements Unbinder {
    private SupplementalAttendanceActivity target;

    @UiThread
    public SupplementalAttendanceActivity_ViewBinding(SupplementalAttendanceActivity supplementalAttendanceActivity) {
        this(supplementalAttendanceActivity, supplementalAttendanceActivity.getWindow().getDecorView());
    }

    @UiThread
    public SupplementalAttendanceActivity_ViewBinding(SupplementalAttendanceActivity supplementalAttendanceActivity, View view) {
        this.target = supplementalAttendanceActivity;
        supplementalAttendanceActivity.cameraView = (SurfaceView) Utils.findRequiredViewAsType(view, C0316R.id.camera_view, "field 'cameraView'", SurfaceView.class);
    }

    public void unbind() {
        SupplementalAttendanceActivity supplementalAttendanceActivity = this.target;
        if (supplementalAttendanceActivity != null) {
            this.target = null;
            supplementalAttendanceActivity.cameraView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
