package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.C0316R;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J-\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020\u0016H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/aeries/mobileportal/views/activities/CameraActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "barcodeDetector", "Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "getBarcodeDetector", "()Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "setBarcodeDetector", "(Lcom/google/android/gms/vision/barcode/BarcodeDetector;)V", "cameraSource", "Lcom/google/android/gms/vision/CameraSource;", "getCameraSource", "()Lcom/google/android/gms/vision/CameraSource;", "setCameraSource", "(Lcom/google/android/gms/vision/CameraSource;)V", "cameraView", "Landroid/view/SurfaceView;", "getCameraView", "()Landroid/view/SurfaceView;", "setCameraView", "(Landroid/view/SurfaceView;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openCamera", "setupViews", "showExplanation", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CameraActivity.kt */
public final class CameraActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public BarcodeDetector barcodeDetector;
    @NotNull
    public CameraSource cameraSource;
    @NotNull
    @BindView(2131361854)
    public SurfaceView cameraView;

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    @NotNull
    public final SurfaceView getCameraView() {
        SurfaceView surfaceView = this.cameraView;
        if (surfaceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        return surfaceView;
    }

    public final void setCameraView(@NotNull SurfaceView surfaceView) {
        Intrinsics.checkParameterIsNotNull(surfaceView, "<set-?>");
        this.cameraView = surfaceView;
    }

    @NotNull
    public final BarcodeDetector getBarcodeDetector() {
        BarcodeDetector barcodeDetector = this.barcodeDetector;
        if (barcodeDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeDetector");
        }
        return barcodeDetector;
    }

    public final void setBarcodeDetector(@NotNull BarcodeDetector barcodeDetector) {
        Intrinsics.checkParameterIsNotNull(barcodeDetector, "<set-?>");
        this.barcodeDetector = barcodeDetector;
    }

    @NotNull
    public final CameraSource getCameraSource() {
        CameraSource cameraSource = this.cameraSource;
        if (cameraSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraSource");
        }
        return cameraSource;
    }

    public final void setCameraSource(@NotNull CameraSource cameraSource) {
        Intrinsics.checkParameterIsNotNull(cameraSource, "<set-?>");
        this.cameraSource = cameraSource;
    }

    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0316R.layout.activity_camera);
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Context context = this;
        BarcodeDetector build = new Builder(context).setBarcodeFormats(256).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "BarcodeDetector.Builder(…\n                .build()");
        this.barcodeDetector = build;
        BarcodeDetector barcodeDetector = this.barcodeDetector;
        if (barcodeDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeDetector");
        }
        CameraSource build2 = new CameraSource.Builder(context, barcodeDetector).setFacing(0).setRequestedPreviewSize(displayMetrics.heightPixels, displayMetrics.widthPixels).build();
        Intrinsics.checkExpressionValueIsNotNull(build2, "CameraSource.Builder(thi…\n                .build()");
        this.cameraSource = build2;
        SurfaceView surfaceView = this.cameraView;
        if (surfaceView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraView");
        }
        surfaceView.getHolder().addCallback(new CameraActivity$setupViews$1(this));
        BarcodeDetector barcodeDetector2 = this.barcodeDetector;
        if (barcodeDetector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeDetector");
        }
        barcodeDetector2.setProcessor(new CameraActivity$setupViews$2(this));
    }

    public final void openCamera() {
        try {
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                CameraSource cameraSource = this.cameraSource;
                if (cameraSource == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraSource");
                }
                SurfaceView surfaceView = this.cameraView;
                if (surfaceView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cameraView");
                }
                cameraSource.start(surfaceView.getHolder());
                return;
            }
            showExplanation();
        } catch (IOException e) {
            Log.e("CAMERA SOURCE", e.getMessage());
        }
    }

    private final void showExplanation() {
        Activity activity = this;
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.CAMERA")) {
            new AlertDialog.Builder(this).setTitle((CharSequence) "Permission request").setMessage((CharSequence) "The app needs your permission to use the camera so QR codes can be scanned.").setPositiveButton((int) C0316R.string.got_it, null).create().show();
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CAMERA"}, AppConstants.Companion.getPERMISSIONS_REQUEST_CAMERA());
        }
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == AppConstants.Companion.getPERMISSIONS_REQUEST_CAMERA()) {
            if ((1 ^ (iArr.length == 0 ? 1 : 0)) == 0 || iArr[0] != 0) {
                setResult(0, new Intent());
                finish();
                return;
            }
            openCamera();
        }
    }
}
