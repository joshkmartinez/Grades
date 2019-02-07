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
import com.aeries.mobileportal.dagger.components.ReportCardsComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.report_cards.ReportCardsPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.ReportCardsFragment;
import com.aeries.mobileportal.views.fragments.ReportCardsFragment.ReportCardsFragmentListener;
import com.aeries.mobileportal.views.viewmodels.report_cards.ReportCardsViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010>\u001a\u00020?H\u0007J\b\u0010@\u001a\u00020?H\u0002J\u000f\u0010A\u001a\u0004\u0018\u000107H\u0014¢\u0006\u0002\u0010BJ\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010CH\u0014J\n\u0010D\u001a\u0004\u0018\u00010EH\u0014J\b\u0010F\u001a\u00020?H\u0016J\b\u0010G\u001a\u00020?H\u0016J\u0010\u0010H\u001a\u00020?2\u0006\u0010I\u001a\u000205H\u0016J\b\u0010J\u001a\u00020?H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001b\u00106\u001a\u0002078FX\u0002¢\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u0002078FX\u0002¢\u0006\f\n\u0004\b=\u0010\n\u001a\u0004\b<\u00109¨\u0006K"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ReportCardsActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/report_cards/ReportCardsViewModel;", "Lcom/aeries/mobileportal/views/fragments/ReportCardsFragment$ReportCardsFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/ReportCardsComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ReportCardsComponent;", "component$delegate", "Lkotlin/Lazy;", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "presenter", "Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/report_cards/ReportCardsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "startAnimationEnded", "", "x", "", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "closeActivity", "", "displayReportsFragment", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onCreate", "onWindowFocusChanged", "hasFocus", "setupViews", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ReportCardsActivity.kt */
public final class ReportCardsActivity extends BaseActivity<ReportCardsViewModel> implements ReportCardsViewModel, ReportCardsFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReportCardsActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ReportCardsComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReportCardsActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReportCardsActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ReportCardsActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ReportCardsActivity$component$2(this));
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new ReportCardsActivity$data$2(this));
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
    public ReportCardsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean startAnimationEnded;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new ReportCardsActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new ReportCardsActivity$y$2(this));

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
    public final ReportCardsComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ReportCardsComponent) lazy.getValue();
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
    public final ReportCardsPresenter m106getPresenter() {
        ReportCardsPresenter reportCardsPresenter = this.presenter;
        if (reportCardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return reportCardsPresenter;
    }

    public final void setPresenter(@NotNull ReportCardsPresenter reportCardsPresenter) {
        Intrinsics.checkParameterIsNotNull(reportCardsPresenter, "<set-?>");
        this.presenter = reportCardsPresenter;
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void displayReportsFragment() {
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, ReportCardsFragment.Companion.newInstance()).commit();
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
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    @Nullable
    protected BasePresenter<ReportCardsViewModel> getPresenter() {
        ReportCardsPresenter reportCardsPresenter = this.presenter;
        if (reportCardsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return reportCardsPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
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
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new ReportCardsActivity$closeActivity$1(this));
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new ReportCardsActivity$onWindowFocusChanged$1(this));
        }
    }
}
