package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.DemographicsActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.Demographics;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.demographics.DemographicsPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.utils.IntentUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.DemographicsFragment;
import com.aeries.mobileportal.views.fragments.DemographicsFragment.DemographicsFragmentListener;
import com.aeries.mobileportal.views.viewmodels.demographics.DemographicsViewModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010H\u001a\u00020IH\u0007J\u000f\u0010J\u001a\u0004\u0018\u00010AH\u0014¢\u0006\u0002\u0010KJ\u0010\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010LH\u0014J\n\u0010M\u001a\u0004\u0018\u00010NH\u0014J\b\u0010O\u001a\u00020IH\u0016J\u0012\u0010P\u001a\u00020I2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\b\u0010S\u001a\u00020IH\u0016J\u0012\u0010T\u001a\u00020I2\b\u0010U\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010V\u001a\u00020I2\b\u0010W\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010X\u001a\u00020I2\u0006\u0010Y\u001a\u00020;H\u0016J\b\u0010Z\u001a\u00020IH\u0002J\u0010\u0010[\u001a\u00020I2\u0006\u0010\\\u001a\u00020]H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010@\u001a\u00020A8FX\u0002¢\u0006\f\n\u0004\bD\u0010\n\u001a\u0004\bB\u0010CR\u001b\u0010E\u001a\u00020A8FX\u0002¢\u0006\f\n\u0004\bG\u0010\n\u001a\u0004\bF\u0010C¨\u0006^"}, d2 = {"Lcom/aeries/mobileportal/views/activities/DemographicsActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/demographics/DemographicsViewModel;", "Lcom/aeries/mobileportal/views/fragments/DemographicsFragment$DemographicsFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/DemographicsActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/DemographicsActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "demographicsFragment", "Lcom/aeries/mobileportal/views/fragments/DemographicsFragment;", "getDemographicsFragment", "()Lcom/aeries/mobileportal/views/fragments/DemographicsFragment;", "setDemographicsFragment", "(Lcom/aeries/mobileportal/views/fragments/DemographicsFragment;)V", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "presenter", "Lcom/aeries/mobileportal/presenters/demographics/DemographicsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/demographics/DemographicsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/demographics/DemographicsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "startAnimationEnded", "", "getStartAnimationEnded", "()Z", "setStartAnimationEnded", "(Z)V", "x", "", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "closeActivity", "", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "onAddressPressed", "address", "", "onCreate", "onEmailSelected", "email", "onPhoneSelected", "phone", "onWindowFocusChanged", "hasFocus", "setupViews", "showDemographics", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DemographicsActivity.kt */
public final class DemographicsActivity extends BaseActivity<DemographicsViewModel> implements DemographicsViewModel, DemographicsFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DemographicsActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DemographicsActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DemographicsActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DemographicsActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/DemographicsActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new DemographicsActivity$component$2(this));
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new DemographicsActivity$data$2(this));
    @NotNull
    public DemographicsFragment demographicsFragment;
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
    public DemographicsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean startAnimationEnded;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new DemographicsActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new DemographicsActivity$y$2(this));

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
    public final DemographicsActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (DemographicsActivityComponent) lazy.getValue();
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
    public final DemographicsFragment getDemographicsFragment() {
        DemographicsFragment demographicsFragment = this.demographicsFragment;
        if (demographicsFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demographicsFragment");
        }
        return demographicsFragment;
    }

    public final void setDemographicsFragment(@NotNull DemographicsFragment demographicsFragment) {
        Intrinsics.checkParameterIsNotNull(demographicsFragment, "<set-?>");
        this.demographicsFragment = demographicsFragment;
    }

    @NotNull
    public final DemographicsPresenter m101getPresenter() {
        DemographicsPresenter demographicsPresenter = this.presenter;
        if (demographicsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return demographicsPresenter;
    }

    public final void setPresenter(@NotNull DemographicsPresenter demographicsPresenter) {
        Intrinsics.checkParameterIsNotNull(demographicsPresenter, "<set-?>");
        this.presenter = demographicsPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    @Nullable
    protected BasePresenter<DemographicsViewModel> getPresenter() {
        DemographicsPresenter demographicsPresenter = this.presenter;
        if (demographicsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return demographicsPresenter;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
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
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new DemographicsActivity$onWindowFocusChanged$1(this));
        }
    }

    public void showDemographics(@NotNull Demographics demographics) {
        Intrinsics.checkParameterIsNotNull(demographics, "demographics");
        this.demographicsFragment = DemographicsFragment.Companion.newInstance(demographics);
        demographics = getSupportFragmentManager().beginTransaction();
        DemographicsFragment demographicsFragment = this.demographicsFragment;
        if (demographicsFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demographicsFragment");
        }
        demographics.replace(C0316R.id.fragment_container, demographicsFragment).commit();
        this.startAnimationEnded = true;
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
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new DemographicsActivity$closeActivity$1(this));
    }

    public void onAddressPressed(@Nullable String str) {
        if (str != null) {
            startActivity(IntentUtils.Companion.getLocationIntent(str));
        }
    }

    public void onEmailSelected(@Nullable String str) {
        if (str != null) {
            str = IntentUtils.Companion.getEmailIntent(str);
            if (str.resolveActivity(getPackageManager()) != null) {
                startActivity(str);
            } else {
                Toast.makeText(this, "Email app not found!", 1).show();
            }
        }
    }

    public void onPhoneSelected(@Nullable String str) {
        if (str != null) {
            startActivity(IntentUtils.Companion.getPhoneIntent(str));
        }
    }
}
