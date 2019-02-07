package com.aeries.mobileportal.views.activities;

import android.app.Activity;
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
import com.aeries.mobileportal.dagger.components.AttendanceActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.attendance.AttendancePresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.AttendanceDetailFragment;
import com.aeries.mobileportal.views.fragments.AttendanceDetailFragment.AttendanceDetailFragmentListener;
import com.aeries.mobileportal.views.fragments.AttendanceListFragment;
import com.aeries.mobileportal.views.fragments.AttendanceListFragment.AttendanceListFragmentListener;
import com.aeries.mobileportal.views.viewmodels.attendance.AttendanceViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010N\u001a\u00020OH\u0007J\u000f\u0010P\u001a\u0004\u0018\u00010GH\u0014¢\u0006\u0002\u0010QJ\u0010\u00106\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010RH\u0014J\n\u0010S\u001a\u0004\u0018\u00010TH\u0014J\b\u0010U\u001a\u00020OH\u0016J\u0010\u0010V\u001a\u00020O2\u0006\u0010W\u001a\u00020XH\u0016J\u0016\u0010Y\u001a\u00020O2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\\0[H\u0016J\u0010\u0010]\u001a\u00020O2\u0006\u0010^\u001a\u00020\\H\u0016J\b\u0010_\u001a\u00020OH\u0016J\b\u0010`\u001a\u00020OH\u0016J\b\u0010a\u001a\u00020OH\u0014J\u0010\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020AH\u0016J\b\u0010d\u001a\u00020OH\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138FX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001b\u0010F\u001a\u00020G8FX\u0002¢\u0006\f\n\u0004\bJ\u0010\u0011\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020G8FX\u0002¢\u0006\f\n\u0004\bM\u0010\u0011\u001a\u0004\bL\u0010I¨\u0006e"}, d2 = {"Lcom/aeries/mobileportal/views/activities/AttendanceActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/attendance/AttendanceViewModel;", "Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment$AttendanceListFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment$AttendanceDetailFragmentListener;", "()V", "attendanceDetailFragment", "Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment;", "getAttendanceDetailFragment", "()Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment;", "setAttendanceDetailFragment", "(Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment;)V", "attendanceListFragment", "Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment;", "getAttendanceListFragment", "()Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment;", "attendanceListFragment$delegate", "Lkotlin/Lazy;", "component", "Lcom/aeries/mobileportal/dagger/components/AttendanceActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AttendanceActivityComponent;", "component$delegate", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "presenter", "Lcom/aeries/mobileportal/presenters/attendance/AttendancePresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/attendance/AttendancePresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/attendance/AttendancePresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "startAnimationEnded", "", "getStartAnimationEnded", "()Z", "setStartAnimationEnded", "(Z)V", "x", "", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "closeActivity", "", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onAttendanceError", "e", "", "onAttendanceRetrieved", "attendances", "", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "onAttendanceSelected", "attendance", "onCreate", "onDetailSelected", "onPause", "onWindowFocusChanged", "hasFocus", "setupViews", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceActivity.kt */
public final class AttendanceActivity extends BaseActivity<AttendanceViewModel> implements AttendanceViewModel, AttendanceListFragmentListener, AttendanceDetailFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AttendanceActivityComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceActivity.class), "attendanceListFragment", "getAttendanceListFragment()Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment;"))};
    private HashMap _$_findViewCache;
    @Nullable
    private AttendanceDetailFragment attendanceDetailFragment;
    @NotNull
    private final Lazy attendanceListFragment$delegate = LazyKt.lazy(AttendanceActivity$attendanceListFragment$2.INSTANCE);
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AttendanceActivity$component$2(this));
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new AttendanceActivity$data$2(this));
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
    @Inject
    @NotNull
    public AttendancePresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean startAnimationEnded;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new AttendanceActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new AttendanceActivity$y$2(this));

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
    public final AttendanceListFragment getAttendanceListFragment() {
        Lazy lazy = this.attendanceListFragment$delegate;
        KProperty kProperty = $$delegatedProperties[4];
        return (AttendanceListFragment) lazy.getValue();
    }

    @NotNull
    public final AttendanceActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (AttendanceActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ViewPermission getData() {
        Lazy lazy = this.data$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (ViewPermission) lazy.getValue();
    }

    public final int getX() {
        Lazy lazy = this.x$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    public final int getY() {
        Lazy lazy = this.y$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
    }

    public final boolean getStartAnimationEnded() {
        return this.startAnimationEnded;
    }

    public final void setStartAnimationEnded(boolean z) {
        this.startAnimationEnded = z;
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
    public final AttendancePresenter m96getPresenter() {
        AttendancePresenter attendancePresenter = this.presenter;
        if (attendancePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return attendancePresenter;
    }

    public final void setPresenter(@NotNull AttendancePresenter attendancePresenter) {
        Intrinsics.checkParameterIsNotNull(attendancePresenter, "<set-?>");
        this.presenter = attendancePresenter;
    }

    @Nullable
    public final AttendanceDetailFragment getAttendanceDetailFragment() {
        return this.attendanceDetailFragment;
    }

    public final void setAttendanceDetailFragment(@Nullable AttendanceDetailFragment attendanceDetailFragment) {
        this.attendanceDetailFragment = attendanceDetailFragment;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    @Nullable
    protected BasePresenter<AttendanceViewModel> getPresenter() {
        AttendancePresenter attendancePresenter = this.presenter;
        if (attendancePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return attendancePresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        String viewCode = getData().getViewCode();
        if (viewCode == null) {
            Intrinsics.throwNpe();
        }
        Permissions valueOf = Permissions.valueOf(viewCode);
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setText(getText(valueOf.getPermissionName()));
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setImageResource(valueOf.getImageID());
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, getAttendanceListFragment()).commit();
    }

    protected void onPause() {
        super.onPause();
        AttendanceDetailFragment attendanceDetailFragment = this.attendanceDetailFragment;
        if (attendanceDetailFragment != null) {
            attendanceDetailFragment.dismiss();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new AttendanceActivity$onWindowFocusChanged$1(this));
        }
    }

    @OnClick({2131361925})
    public final void closeActivity() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setClickable(false);
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
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new AttendanceActivity$closeActivity$1(this));
    }

    public void onAttendanceRetrieved(@NotNull List<AttendanceDetail> list) {
        Intrinsics.checkParameterIsNotNull(list, "attendances");
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        getAttendanceListFragment().update(list);
    }

    public void onAttendanceError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        if (Intrinsics.areEqual(th.getMessage(), (Object) "HTTP 401 Unauthorized")) {
            th = "There was a problem, please try again later.";
        } else {
            th = th.getMessage();
            if (th == null) {
                th = "";
            }
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, th).setButton((int) C0316R.string.got_it, (Function0) new AttendanceActivity$onAttendanceError$1(this)).setCancelable(false).show();
    }

    public void onAttendanceSelected(@NotNull AttendanceDetail attendanceDetail) {
        Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
        this.attendanceDetailFragment = AttendanceDetailFragment.Companion.newInstance(attendanceDetail);
        attendanceDetail = this.attendanceDetailFragment;
        if (attendanceDetail != null) {
            attendanceDetail.setRetainInstance(true);
        }
        attendanceDetail = this.attendanceDetailFragment;
        if (attendanceDetail != null) {
            attendanceDetail.show(getSupportFragmentManager().beginTransaction(), "ATTENDANCE_DETAIL");
        }
        attendanceDetail = this.presenter;
        if (attendanceDetail == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        attendanceDetail.sendDetailsAnalytics();
    }

    public void onDetailSelected() {
        AttendanceDetailFragment attendanceDetailFragment = this.attendanceDetailFragment;
        if (attendanceDetailFragment != null) {
            attendanceDetailFragment.dismiss();
        }
    }
}
