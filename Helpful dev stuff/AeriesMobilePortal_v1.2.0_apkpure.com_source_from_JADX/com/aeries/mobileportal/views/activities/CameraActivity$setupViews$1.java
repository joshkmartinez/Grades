package com.aeries.mobileportal.views.activities;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"com/aeries/mobileportal/views/activities/CameraActivity$setupViews$1", "Landroid/view/SurfaceHolder$Callback;", "(Lcom/aeries/mobileportal/views/activities/CameraActivity;)V", "surfaceChanged", "", "p0", "Landroid/view/SurfaceHolder;", "p1", "", "p2", "p3", "surfaceCreated", "surfaceDestroyed", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CameraActivity.kt */
public final class CameraActivity$setupViews$1 implements Callback {
    final /* synthetic */ CameraActivity this$0;

    public void surfaceChanged(@Nullable SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    CameraActivity$setupViews$1(CameraActivity cameraActivity) {
        this.this$0 = cameraActivity;
    }

    public void surfaceDestroyed(@Nullable SurfaceHolder surfaceHolder) {
        this.this$0.getCameraSource().stop();
    }

    public void surfaceCreated(@Nullable SurfaceHolder surfaceHolder) {
        this.this$0.openCamera();
    }
}
