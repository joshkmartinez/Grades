package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.SupplementalAttendanceActivityComponent;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendance;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.supplemental_attendance.SupplementalAttendancePresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.DoneCheckInFragment;
import com.aeries.mobileportal.views.fragments.DoneCheckInFragment.DoneCheckInFragmentListener;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment.SessionSelectFragmentListener;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.SupplementalAttendanceViewModel;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.android.gms.vision.barcode.BarcodeDetector.Builder;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001TB\u0005¢\u0006\u0002\u0010\u0005J\u000f\u00102\u001a\u0004\u0018\u000103H\u0014¢\u0006\u0002\u00104J\u0010\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000105H\u0014J\n\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0016J\u0010\u0010<\u001a\u0002092\u0006\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u000209H\u0016J\b\u0010@\u001a\u000209H\u0016J-\u0010A\u001a\u0002092\u0006\u0010B\u001a\u0002032\u000e\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0D2\u0006\u0010F\u001a\u00020GH\u0016¢\u0006\u0002\u0010HJ\u0006\u0010I\u001a\u000209J\b\u0010J\u001a\u000209H\u0002J\b\u0010K\u001a\u000209H\u0002J\u0010\u0010L\u001a\u0002092\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u0002092\u0006\u0010P\u001a\u00020NH\u0016J\u0010\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020EH\u0016J\b\u0010S\u001a\u000209H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/aeries/mobileportal/views/activities/SupplementalAttendanceActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/SupplementalAttendanceViewModel;", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment$SessionSelectFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment$DoneCheckInFragmentListener;", "()V", "barcodeDetector", "Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "getBarcodeDetector", "()Lcom/google/android/gms/vision/barcode/BarcodeDetector;", "setBarcodeDetector", "(Lcom/google/android/gms/vision/barcode/BarcodeDetector;)V", "cameraSource", "Lcom/google/android/gms/vision/CameraSource;", "getCameraSource", "()Lcom/google/android/gms/vision/CameraSource;", "setCameraSource", "(Lcom/google/android/gms/vision/CameraSource;)V", "cameraView", "Landroid/view/SurfaceView;", "getCameraView", "()Landroid/view/SurfaceView;", "setCameraView", "(Landroid/view/SurfaceView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/SupplementalAttendanceActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/SupplementalAttendanceActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "doneCheckInFragment", "Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment;", "getDoneCheckInFragment", "()Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment;", "setDoneCheckInFragment", "(Lcom/aeries/mobileportal/views/fragments/DoneCheckInFragment;)V", "presenter", "Lcom/aeries/mobileportal/presenters/supplemental_attendance/SupplementalAttendancePresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/supplemental_attendance/SupplementalAttendancePresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/supplemental_attendance/SupplementalAttendancePresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "sessionSelectFragment", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "initializeBarcodeDetector", "", "inject", "onCancelSelected", "onCourseSelected", "session", "Lcom/aeries/mobileportal/models/Session;", "onCreate", "onHomePressed", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openCamera", "requestPermission", "setupViews", "showCourseList", "attendance", "Lcom/aeries/mobileportal/models/SupplementalAttendance;", "showDoneScreen", "supplementalAttendance", "showError", "error", "showExplanation", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SupplementalAttendanceActivity.kt */
public final class SupplementalAttendanceActivity extends BaseActivity<SupplementalAttendanceViewModel> implements SupplementalAttendanceViewModel, SessionSelectFragmentListener, DoneCheckInFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SupplementalAttendanceActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/SupplementalAttendanceActivityComponent;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String URL = "URL";
    private HashMap _$_findViewCache;
    @NotNull
    public BarcodeDetector barcodeDetector;
    @NotNull
    public CameraSource cameraSource;
    @NotNull
    @BindView(2131361854)
    public SurfaceView cameraView;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new SupplementalAttendanceActivity$component$2(this));
    @NotNull
    public DoneCheckInFragment doneCheckInFragment;
    @Inject
    @NotNull
    public SupplementalAttendancePresenter presenter;
    @NotNull
    public ProgressDialog progressDialog;
    private SessionSelectFragment sessionSelectFragment;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/activities/SupplementalAttendanceActivity$Companion;", "", "()V", "URL", "", "getURL", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: SupplementalAttendanceActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getURL() {
            return SupplementalAttendanceActivity.URL;
        }
    }

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
    public final SupplementalAttendanceActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (SupplementalAttendanceActivityComponent) lazy.getValue();
    }

    public void showCourseList(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "attendance");
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

    @NotNull
    public final ProgressDialog getProgressDialog() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        return progressDialog;
    }

    public final void setProgressDialog(@NotNull ProgressDialog progressDialog) {
        Intrinsics.checkParameterIsNotNull(progressDialog, "<set-?>");
        this.progressDialog = progressDialog;
    }

    @NotNull
    public final DoneCheckInFragment getDoneCheckInFragment() {
        DoneCheckInFragment doneCheckInFragment = this.doneCheckInFragment;
        if (doneCheckInFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneCheckInFragment");
        }
        return doneCheckInFragment;
    }

    public final void setDoneCheckInFragment(@NotNull DoneCheckInFragment doneCheckInFragment) {
        Intrinsics.checkParameterIsNotNull(doneCheckInFragment, "<set-?>");
        this.doneCheckInFragment = doneCheckInFragment;
    }

    @NotNull
    public final SupplementalAttendancePresenter m108getPresenter() {
        SupplementalAttendancePresenter supplementalAttendancePresenter = this.presenter;
        if (supplementalAttendancePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return supplementalAttendancePresenter;
    }

    public final void setPresenter(@NotNull SupplementalAttendancePresenter supplementalAttendancePresenter) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendancePresenter, "<set-?>");
        this.presenter = supplementalAttendancePresenter;
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        Context context = this;
        this.progressDialog = new ProgressDialog(context);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setMessage(getString(C0316R.string.loading));
        progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setCancelable(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
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
        surfaceView.getHolder().addCallback(new SupplementalAttendanceActivity$setupViews$1(this));
        initializeBarcodeDetector();
    }

    private final void initializeBarcodeDetector() {
        BarcodeDetector barcodeDetector = this.barcodeDetector;
        if (barcodeDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barcodeDetector");
        }
        barcodeDetector.setProcessor(new SupplementalAttendanceActivity$initializeBarcodeDetector$1(this));
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
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.CAMERA")) {
            new AlertDialog.Builder(this).setTitle((CharSequence) "Permission request").setMessage((CharSequence) "The app needs your permission to use the camera so QR codes can be scanned.").setCancelable(false).setPositiveButton((int) C0316R.string.got_it, (OnClickListener) new SupplementalAttendanceActivity$showExplanation$1(this)).create().show();
        } else {
            requestPermission();
        }
    }

    private final void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, AppConstants.Companion.getPERMISSIONS_REQUEST_CAMERA());
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        if (i == AppConstants.Companion.getPERMISSIONS_REQUEST_CAMERA()) {
            if ((1 ^ (iArr.length == 0 ? 1 : 0)) == null || iArr[0] != 0) {
                finish();
            } else {
                openCamera();
            }
        }
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_supplemental_attendance);
    }

    @Nullable
    protected BasePresenter<SupplementalAttendanceViewModel> getPresenter() {
        SupplementalAttendancePresenter supplementalAttendancePresenter = this.presenter;
        if (supplementalAttendancePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return supplementalAttendancePresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCancelSelected() {
        initializeBarcodeDetector();
    }

    public void onCourseSelected(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        session = this.progressDialog;
        if (session == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        session.show();
    }

    public void showDoneScreen(@NotNull SupplementalAttendance supplementalAttendance) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendance, "supplementalAttendance");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        this.doneCheckInFragment = DoneCheckInFragment.Companion.newInstance(supplementalAttendance);
        supplementalAttendance = this.doneCheckInFragment;
        if (supplementalAttendance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneCheckInFragment");
        }
        supplementalAttendance.show(getSupportFragmentManager().beginTransaction(), "DONE");
    }

    public void onHomePressed() {
        finish();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        new android.app.AlertDialog.Builder(this).setTitle(C0316R.string.error).setMessage(str).setPositiveButton(C0316R.string.got_it, new SupplementalAttendanceActivity$showError$1(this)).create().show();
    }
}
