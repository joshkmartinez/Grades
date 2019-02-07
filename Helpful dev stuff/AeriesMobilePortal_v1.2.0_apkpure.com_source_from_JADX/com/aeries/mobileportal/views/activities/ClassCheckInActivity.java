package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.ClassCheckInActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.Session;
import com.aeries.mobileportal.models.SupplementalAttendanceStatus;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.supplemental_attendance.ClassCheckInPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.CheckInFragment;
import com.aeries.mobileportal.views.fragments.CheckInFragment.CheckInFragmentListener;
import com.aeries.mobileportal.views.fragments.CheckOutFragment;
import com.aeries.mobileportal.views.fragments.CheckOutFragment.CheckOutFragmentListener;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment;
import com.aeries.mobileportal.views.fragments.SessionSelectFragment.SessionSelectFragmentListener;
import com.aeries.mobileportal.views.viewmodels.supplemental_attendance.ClassCheckInViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010V\u001a\u00020WH\u0002J\b\u0010X\u001a\u00020WH\u0007J\b\u0010Y\u001a\u00020WH\u0002J\u000f\u0010Z\u001a\u0004\u0018\u00010OH\u0014¢\u0006\u0002\u0010[J\u0010\u00102\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\\H\u0014J\n\u0010]\u001a\u0004\u0018\u00010^H\u0014J\u0010\u0010_\u001a\u00020W2\u0006\u0010`\u001a\u00020IH\u0002J\b\u0010a\u001a\u00020WH\u0016J\"\u0010b\u001a\u00020W2\u0006\u0010c\u001a\u00020O2\u0006\u0010d\u001a\u00020O2\b\u0010\r\u001a\u0004\u0018\u00010eH\u0014J\b\u0010f\u001a\u00020WH\u0016J\b\u0010g\u001a\u00020WH\u0016J\u0010\u0010h\u001a\u00020W2\u0006\u0010i\u001a\u00020+H\u0016J\u0010\u0010j\u001a\u00020W2\u0006\u0010i\u001a\u00020+H\u0016J\b\u0010k\u001a\u00020WH\u0016J\b\u0010l\u001a\u00020WH\u0016J\u0010\u0010m\u001a\u00020W2\u0006\u0010n\u001a\u00020IH\u0016J\b\u0010o\u001a\u00020WH\u0002J\b\u0010p\u001a\u00020WH\u0002J\u0010\u0010q\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0016J\u0010\u0010t\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0016J\u0010\u0010u\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0016J\u0010\u0010v\u001a\u00020W2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u00020WH\u0002J\u0010\u0010z\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0016J\u0010\u0010{\u001a\u00020W2\u0006\u0010r\u001a\u00020sH\u0016J\u0016\u0010|\u001a\u00020W2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020+0~H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001b\u0010N\u001a\u00020O8FX\u0002¢\u0006\f\n\u0004\bR\u0010\f\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020O8FX\u0002¢\u0006\f\n\u0004\bU\u0010\f\u001a\u0004\bT\u0010Q¨\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ClassCheckInActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/supplemental_attendance/ClassCheckInViewModel;", "Lcom/aeries/mobileportal/views/fragments/CheckInFragment$CheckInFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment$SessionSelectFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/CheckOutFragment$CheckOutFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/ClassCheckInActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ClassCheckInActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "mSelectedSession", "Lcom/aeries/mobileportal/models/Session;", "getMSelectedSession", "()Lcom/aeries/mobileportal/models/Session;", "setMSelectedSession", "(Lcom/aeries/mobileportal/models/Session;)V", "presenter", "Lcom/aeries/mobileportal/presenters/supplemental_attendance/ClassCheckInPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/supplemental_attendance/ClassCheckInPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/supplemental_attendance/ClassCheckInPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "sessionSelectFragment", "Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;", "getSessionSelectFragment", "()Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;", "setSessionSelectFragment", "(Lcom/aeries/mobileportal/views/fragments/SessionSelectFragment;)V", "startAnimationEnded", "", "getStartAnimationEnded", "()Z", "setStartAnimationEnded", "(Z)V", "x", "", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "clearFragmentBackStack", "", "closeActivity", "dismissProgressDialog", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "hideProgressBar", "b", "inject", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onCancelSelected", "onCheckInPressed", "onCheckOutSelected", "session", "onCourseSelected", "onCreate", "onScanPressed", "onWindowFocusChanged", "hasFocus", "performInitialSetup", "setupViews", "showCheckInFragment", "supplementalAttendanceStatus", "Lcom/aeries/mobileportal/models/SupplementalAttendanceStatus;", "showCheckInToAnotherRoomFragment", "showCheckOutFragment", "showError", "message", "", "showProgressDialog", "showScanCheckOutFragment", "showSessionsFragment", "updateSessions", "sessions", "", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ClassCheckInActivity.kt */
public final class ClassCheckInActivity extends BaseActivity<ClassCheckInViewModel> implements ClassCheckInViewModel, CheckInFragmentListener, SessionSelectFragmentListener, CheckOutFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClassCheckInActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ClassCheckInActivityComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClassCheckInActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClassCheckInActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ClassCheckInActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ClassCheckInActivity$component$2(this));
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new ClassCheckInActivity$data$2(this));
    @NotNull
    @BindView(2131361924)
    public ImageView detailIcon;
    @NotNull
    @BindView(2131361925)
    public TextView detailName;
    @NotNull
    @BindView(2131361927)
    public CardView detailTitle;
    @NotNull
    @BindView(2131361968)
    public RelativeLayout fragmentContainer;
    @NotNull
    public Session mSelectedSession;
    @Inject
    @NotNull
    public ClassCheckInPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @Nullable
    private ProgressDialog progressDialog;
    @NotNull
    private SessionSelectFragment sessionSelectFragment = SessionSelectFragment.Companion.newInstance(new ArrayList());
    private boolean startAnimationEnded;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new ClassCheckInActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new ClassCheckInActivity$y$2(this));

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
    public final ClassCheckInActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ClassCheckInActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ViewPermission getData() {
        Lazy lazy = this.data$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (ViewPermission) lazy.getValue();
    }

    public final int getX() {
        Lazy lazy = this.x$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
    }

    public final int getY() {
        Lazy lazy = this.y$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).intValue();
    }

    @NotNull
    public final CardView getDetailTitle() {
        CardView cardView = this.detailTitle;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        return cardView;
    }

    public final void setDetailTitle(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.detailTitle = cardView;
    }

    @NotNull
    public final TextView getDetailName() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        return textView;
    }

    public final void setDetailName(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.detailName = textView;
    }

    @NotNull
    public final ImageView getDetailIcon() {
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        return imageView;
    }

    public final void setDetailIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.detailIcon = imageView;
    }

    @NotNull
    public final RelativeLayout getFragmentContainer() {
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        return relativeLayout;
    }

    public final void setFragmentContainer(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkParameterIsNotNull(relativeLayout, "<set-?>");
        this.fragmentContainer = relativeLayout;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final ClassCheckInPresenter m98getPresenter() {
        ClassCheckInPresenter classCheckInPresenter = this.presenter;
        if (classCheckInPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return classCheckInPresenter;
    }

    public final void setPresenter(@NotNull ClassCheckInPresenter classCheckInPresenter) {
        Intrinsics.checkParameterIsNotNull(classCheckInPresenter, "<set-?>");
        this.presenter = classCheckInPresenter;
    }

    public final boolean getStartAnimationEnded() {
        return this.startAnimationEnded;
    }

    public final void setStartAnimationEnded(boolean z) {
        this.startAnimationEnded = z;
    }

    @Nullable
    public final ProgressDialog getProgressDialog() {
        return this.progressDialog;
    }

    public final void setProgressDialog(@Nullable ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @NotNull
    public final SessionSelectFragment getSessionSelectFragment() {
        return this.sessionSelectFragment;
    }

    public final void setSessionSelectFragment(@NotNull SessionSelectFragment sessionSelectFragment) {
        Intrinsics.checkParameterIsNotNull(sessionSelectFragment, "<set-?>");
        this.sessionSelectFragment = sessionSelectFragment;
    }

    @NotNull
    public final Session getMSelectedSession() {
        Session session = this.mSelectedSession;
        if (session == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedSession");
        }
        return session;
    }

    public final void setMSelectedSession(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, "<set-?>");
        this.mSelectedSession = session;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    @Nullable
    protected BasePresenter<ClassCheckInViewModel> getPresenter() {
        ClassCheckInPresenter classCheckInPresenter = this.presenter;
        if (classCheckInPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return classCheckInPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    private final void setupViews() {
        String viewCode = getData().getViewCode();
        if (viewCode == null) {
            viewCode = "";
        }
        Permissions valueOf = Permissions.valueOf(viewCode);
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setText(getString(valueOf.getPermissionName()));
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setImageResource(valueOf.getImageID());
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new ClassCheckInActivity$onWindowFocusChanged$1(this));
        }
    }

    private final void performInitialSetup() {
        ClassCheckInPresenter classCheckInPresenter = this.presenter;
        if (classCheckInPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        classCheckInPresenter.getStatus();
        this.startAnimationEnded = true;
    }

    @OnClick({2131361927})
    public final void closeActivity() {
        Companion companion = AnimationUtils.Companion;
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        companion.fadeOut(relativeLayout);
        companion = AnimationUtils.Companion;
        CardView cardView = this.detailTitle;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new ClassCheckInActivity$closeActivity$1(this));
    }

    private final void showProgressDialog() {
        this.progressDialog = ProgressDialog.show(this, "", "Loading...", false, false);
    }

    private final void dismissProgressDialog() {
        if (this.progressDialog != null) {
            ProgressDialog progressDialog = this.progressDialog;
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog = this.progressDialog;
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }
        }
    }

    private final void clearFragmentBackStack() {
        while (true) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStackImmediate();
            } else {
                return;
            }
        }
    }

    public void onCheckInPressed() {
        hideProgressBar(false);
        this.sessionSelectFragment = SessionSelectFragment.Companion.newInstance(new ArrayList());
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.sessionSelectFragment).addToBackStack(null).commit();
        ClassCheckInPresenter classCheckInPresenter = this.presenter;
        if (classCheckInPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        classCheckInPresenter.getSessions();
    }

    public void onScanPressed() {
        startActivityForResult(new Intent(this, SupplementalAttendanceActivity.class), 100);
    }

    protected void onActivityResult(int i, int i2, @Nullable Intent intent) {
        this.startAnimationEnded = true;
        if (i2 == -1) {
            i = StringUtils.Companion;
            if (intent != null) {
                i2 = intent.getStringExtra(SupplementalAttendanceActivity.Companion.getURL());
                if (i2 != 0) {
                    i = i.extractAttendanceURLValues(i2);
                    this.mSelectedSession = new Session(null, null, i.getRoom());
                    if (i.getRoom() != 0) {
                        if (i.getSchoolCode() == 0) {
                            i2 = this.presenter;
                            if (i2 == 0) {
                                Intrinsics.throwUninitializedPropertyAccessException("presenter");
                            }
                            i2.scanCheckIn(i.getSchoolCode(), i.getRoom());
                            return;
                        }
                    }
                    DialogUtils.Companion.getErrorDialogBuilder(this, "Invalid QR code!").setButton((int) C0316R.string.got_it, null).show();
                }
            }
            i2 = "";
            i = i.extractAttendanceURLValues(i2);
            this.mSelectedSession = new Session(null, null, i.getRoom());
            if (i.getRoom() != 0) {
                if (i.getSchoolCode() == 0) {
                    i2 = this.presenter;
                    if (i2 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("presenter");
                    }
                    i2.scanCheckIn(i.getSchoolCode(), i.getRoom());
                    return;
                }
            }
            DialogUtils.Companion.getErrorDialogBuilder(this, "Invalid QR code!").setButton((int) C0316R.string.got_it, null).show();
        }
    }

    public void showCheckInFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        hideProgressBar(true);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, CheckInFragment.Companion.newInstance(supplementalAttendanceStatus)).commit();
    }

    private final void hideProgressBar(boolean z) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(z ? true : false);
    }

    public void showCheckOutFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Session session;
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        clearFragmentBackStack();
        dismissProgressDialog();
        hideProgressBar(true);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        CheckOutFragment.Companion companion = CheckOutFragment.Companion;
        ArrayList sessions = supplementalAttendanceStatus.getSessions();
        if (sessions != null) {
            session = (Session) CollectionsKt.first(sessions);
            if (session != null) {
                beginTransaction.replace(C0316R.id.fragment_container, companion.newInstance(supplementalAttendanceStatus, session)).commit();
            }
        }
        session = this.mSelectedSession;
        if (session == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSelectedSession");
        }
        beginTransaction.replace(C0316R.id.fragment_container, companion.newInstance(supplementalAttendanceStatus, session)).commit();
    }

    public void showScanCheckOutFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        ArrayList sessions = supplementalAttendanceStatus.getSessions();
        Session session = sessions != null ? (Session) CollectionsKt.first(sessions) : null;
        if (session == null) {
            Intrinsics.throwNpe();
        }
        this.mSelectedSession = session;
        clearFragmentBackStack();
        dismissProgressDialog();
        hideProgressBar(true);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, CheckOutFragment.Companion.newInstance(supplementalAttendanceStatus, (Session) CollectionsKt.first(supplementalAttendanceStatus.getSessions()))).commit();
    }

    public void showSessionsFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        dismissProgressDialog();
        SessionSelectFragment.Companion companion = SessionSelectFragment.Companion;
        supplementalAttendanceStatus = supplementalAttendanceStatus.getSessions();
        if (supplementalAttendanceStatus == null) {
            supplementalAttendanceStatus = new ArrayList();
        }
        this.sessionSelectFragment = companion.newInstance(supplementalAttendanceStatus);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.sessionSelectFragment).addToBackStack(null).commit();
    }

    public void updateSessions(@NotNull List<Session> list) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        hideProgressBar(true);
        this.sessionSelectFragment.update(list);
    }

    public void onCourseSelected(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C0316R.string.check_in_confirmation);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.check_in_confirmation)");
        Object[] objArr = new Object[]{session.getRoom()};
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        new Builder(this).setTitle((int) C0316R.string.check_in).setMessage((CharSequence) string).setPositiveButton((int) C0316R.string.yes, (OnClickListener) new ClassCheckInActivity$onCourseSelected$1(this, session)).setNegativeButton((int) C0316R.string.no, null).show();
    }

    public void onCancelSelected() {
        getSupportFragmentManager().popBackStackImmediate();
    }

    public void onCheckOutSelected(@NotNull Session session) {
        Intrinsics.checkParameterIsNotNull(session, SettingsJsonConstants.SESSION_KEY);
        new Builder(this).setTitle((int) C0316R.string.check_out).setMessage((int) C0316R.string.check_out_confirmation).setPositiveButton((int) C0316R.string.yes, (OnClickListener) new ClassCheckInActivity$onCheckOutSelected$1(this, session)).setNegativeButton((int) C0316R.string.no, null).show();
    }

    public void showCheckInToAnotherRoomFragment(@NotNull SupplementalAttendanceStatus supplementalAttendanceStatus) {
        Intrinsics.checkParameterIsNotNull(supplementalAttendanceStatus, "supplementalAttendanceStatus");
        dismissProgressDialog();
        clearFragmentBackStack();
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, CheckInFragment.Companion.newInstance(supplementalAttendanceStatus)).commit();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        dismissProgressDialog();
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, (Function0) new ClassCheckInActivity$showError$1(this)).show();
    }
}
