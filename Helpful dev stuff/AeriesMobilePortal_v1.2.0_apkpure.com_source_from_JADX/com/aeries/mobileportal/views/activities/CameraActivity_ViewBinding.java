package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class CameraActivity_ViewBinding implements Unbinder {
    private CameraActivity target;

    @UiThread
    public CameraActivity_ViewBinding(CameraActivity cameraActivity) {
        this(cameraActivity, cameraActivity.getWindow().getDecorView());
    }

    @UiThread
    public CameraActivity_ViewBinding(CameraActivity cameraActivity, View view) {
        this.target = cameraActivity;
        cameraActivity.cameraView = (SurfaceView) Utils.findRequiredViewAsType(view, C0316R.id.camera_view, "field 'cameraView'", SurfaceView.class);
    }

    public void unbind() {
        CameraActivity cameraActivity = this.target;
        if (cameraActivity != null) {
            this.target = null;
            cameraActivity.cameraView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
