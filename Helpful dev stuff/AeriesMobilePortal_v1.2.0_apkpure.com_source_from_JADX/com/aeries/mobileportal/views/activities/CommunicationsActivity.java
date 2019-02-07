package com.aeries.mobileportal.views.activities;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.CommunicationsActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.communications.CommunicationsPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.AnimationUtils.Companion;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.WebViewFragment;
import com.aeries.mobileportal.views.fragments.WebViewFragment.WebViewFragmentListener;
import com.aeries.mobileportal.views.viewmodels.communications.CommunicationsViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.HashMap;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020MH\u0016J\u0010\u0010a\u001a\u00020_2\u0006\u0010`\u001a\u00020MH\u0016J\b\u0010b\u001a\u00020_H\u0007J\b\u0010c\u001a\u00020_H\u0002J\u000f\u0010d\u001a\u0004\u0018\u000108H\u0014¢\u0006\u0002\u0010eJ\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010fH\u0014J\n\u0010g\u001a\u0004\u0018\u00010hH\u0014J\b\u0010i\u001a\u00020_H\u0007J\b\u0010j\u001a\u00020_H\u0007J\b\u0010k\u001a\u00020_H\u0002J\b\u0010l\u001a\u00020_H\u0016J\b\u0010m\u001a\u00020_H\u0016J\b\u0010n\u001a\u00020_H\u0016J-\u0010o\u001a\u00020_2\u0006\u0010p\u001a\u0002082\u000e\u0010q\u001a\n\u0012\u0006\b\u0001\u0012\u00020s0r2\u0006\u0010t\u001a\u00020uH\u0016¢\u0006\u0002\u0010vJ\b\u0010w\u001a\u00020_H\u0014J\u001c\u0010x\u001a\u00020_2\b\u0010y\u001a\u0004\u0018\u00010z2\b\u0010{\u001a\u0004\u0018\u00010|H\u0016J\u0010\u0010}\u001a\u00020_2\u0006\u0010~\u001a\u00020MH\u0016J\b\u0010\u001a\u00020_H\u0002J\t\u0010\u0001\u001a\u00020_H\u0002J\t\u0010\u0001\u001a\u00020_H\u0002J\u0012\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020sH\u0016J\u0014\u0010\u0001\u001a\u00020_2\t\u0010\u0001\u001a\u0004\u0018\u00010sH\u0016J\u0012\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020sH\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\nR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR\u001e\u00101\u001a\u0002028\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001e\u0010=\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0017\"\u0004\b?\u0010\u0019R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020G8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001b\u0010X\u001a\u0002088FX\u0002¢\u0006\f\n\u0004\bZ\u0010\u0013\u001a\u0004\bY\u0010:R\u001b\u0010[\u001a\u0002088FX\u0002¢\u0006\f\n\u0004\b]\u0010\u0013\u001a\u0004\b\\\u0010:¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/views/activities/CommunicationsActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/communications/CommunicationsViewModel;", "Lcom/aeries/mobileportal/views/fragments/WebViewFragment$WebViewFragmentListener;", "()V", "backButton", "Landroid/widget/ImageView;", "getBackButton", "()Landroid/widget/ImageView;", "setBackButton", "(Landroid/widget/ImageView;)V", "closeButton", "getCloseButton", "setCloseButton", "component", "Lcom/aeries/mobileportal/dagger/components/CommunicationsActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/CommunicationsActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "container", "Landroid/support/constraint/ConstraintLayout;", "getContainer", "()Landroid/support/constraint/ConstraintLayout;", "setContainer", "(Landroid/support/constraint/ConstraintLayout;)V", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "getDetailIcon", "setDetailIcon", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "forwardButton", "getForwardButton", "setForwardButton", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "headerHeight", "", "getHeaderHeight", "()I", "setHeaderHeight", "(I)V", "holderContainer", "getHolderContainer", "setHolderContainer", "presenter", "Lcom/aeries/mobileportal/presenters/communications/CommunicationsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/communications/CommunicationsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/communications/CommunicationsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "startAnimationEnded", "", "getStartAnimationEnded", "()Z", "setStartAnimationEnded", "(Z)V", "webViewFragment", "Lcom/aeries/mobileportal/views/fragments/WebViewFragment;", "getWebViewFragment", "()Lcom/aeries/mobileportal/views/fragments/WebViewFragment;", "setWebViewFragment", "(Lcom/aeries/mobileportal/views/fragments/WebViewFragment;)V", "x", "getX", "x$delegate", "y", "getY", "y$delegate", "canGoBack", "", "b", "canGoForward", "closeActivity", "disappearHeader", "getLayout", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "goBack", "goForward", "initializeActivity", "inject", "onBackPressed", "onCreate", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "outPersistentState", "Landroid/os/PersistableBundle;", "onWindowFocusChanged", "hasFocus", "reappearHeader", "requestPermissions", "setupViews", "showErrorMessage", "message", "showFailureMessage", "showWebView", "url", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CommunicationsActivity.kt */
public final class CommunicationsActivity extends BaseActivity<CommunicationsViewModel> implements CommunicationsViewModel, WebViewFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommunicationsActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommunicationsActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommunicationsActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CommunicationsActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/CommunicationsActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361846)
    public ImageView backButton;
    @NotNull
    @BindView(2131361870)
    public ImageView closeButton;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new CommunicationsActivity$component$2(this));
    @NotNull
    @BindView(2131361890)
    public ConstraintLayout container;
    @Nullable
    private final Lazy data$delegate = LazyKt.lazy(new CommunicationsActivity$data$2(this));
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
    @BindView(2131361967)
    public ImageView forwardButton;
    @NotNull
    @BindView(2131361968)
    public RelativeLayout fragmentContainer;
    private int headerHeight;
    @NotNull
    @BindView(2131361986)
    public ConstraintLayout holderContainer;
    @Inject
    @NotNull
    public CommunicationsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean startAnimationEnded;
    @Nullable
    private WebViewFragment webViewFragment;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new CommunicationsActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new CommunicationsActivity$y$2(this));

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
    public final CommunicationsActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (CommunicationsActivityComponent) lazy.getValue();
    }

    @Nullable
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
    public final ImageView getBackButton() {
        ImageView imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        return imageView;
    }

    public final void setBackButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.backButton = imageView;
    }

    @NotNull
    public final ImageView getForwardButton() {
        ImageView imageView = this.forwardButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
        }
        return imageView;
    }

    public final void setForwardButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.forwardButton = imageView;
    }

    @NotNull
    public final ImageView getCloseButton() {
        ImageView imageView = this.closeButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        }
        return imageView;
    }

    public final void setCloseButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.closeButton = imageView;
    }

    @NotNull
    public final ConstraintLayout getContainer() {
        ConstraintLayout constraintLayout = this.container;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        return constraintLayout;
    }

    public final void setContainer(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.container = constraintLayout;
    }

    @NotNull
    public final ConstraintLayout getHolderContainer() {
        ConstraintLayout constraintLayout = this.holderContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holderContainer");
        }
        return constraintLayout;
    }

    public final void setHolderContainer(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.holderContainer = constraintLayout;
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

    public final int getHeaderHeight() {
        return this.headerHeight;
    }

    public final void setHeaderHeight(int i) {
        this.headerHeight = i;
    }

    @NotNull
    public final CommunicationsPresenter m99getPresenter() {
        CommunicationsPresenter communicationsPresenter = this.presenter;
        if (communicationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return communicationsPresenter;
    }

    public final void setPresenter(@NotNull CommunicationsPresenter communicationsPresenter) {
        Intrinsics.checkParameterIsNotNull(communicationsPresenter, "<set-?>");
        this.presenter = communicationsPresenter;
    }

    @Nullable
    public final WebViewFragment getWebViewFragment() {
        return this.webViewFragment;
    }

    public final void setWebViewFragment(@Nullable WebViewFragment webViewFragment) {
        this.webViewFragment = webViewFragment;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_communications);
    }

    @Nullable
    protected BasePresenter<CommunicationsViewModel> getPresenter() {
        CommunicationsPresenter communicationsPresenter = this.presenter;
        if (communicationsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return communicationsPresenter;
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
        if (getData() != null) {
            ViewPermission data = getData();
            String viewCode = data != null ? data.getViewCode() : null;
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
    }

    public void onSaveInstanceState(@Nullable Bundle bundle, @Nullable PersistableBundle persistableBundle) {
        bundle = this.presenter;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.detachView();
        bundle = this.presenter;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle.cancelRequests();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new CommunicationsActivity$onWindowFocusChanged$1(this));
        }
    }

    protected void onResume() {
        super.onResume();
        if (getSupportFragmentManager().findFragmentById(C0316R.id.fragment_container) == null) {
            CommunicationsPresenter communicationsPresenter = this.presenter;
            if (communicationsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            communicationsPresenter.getSignalKitUrl();
        }
    }

    private final void initializeActivity() {
        requestPermissions();
    }

    private final void requestPermissions() {
        Context context = this;
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 || ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0) {
            CommunicationsPresenter communicationsPresenter = this.presenter;
            if (communicationsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            communicationsPresenter.getSignalKitUrl();
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"}, 1);
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr[0] == null && iArr[1] == null) {
            i = this.presenter;
            if (i == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            i.getSignalKitUrl();
            return;
        }
        new Builder(this).setMessage(2131624150).setPositiveButton(2131624112, new CommunicationsActivity$onRequestPermissionsResult$1(this)).setCancelable(false).create().show();
    }

    @OnClick({2131361870})
    public final void closeActivity() {
        reappearHeader();
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
        companion.translateToPoint(cardView, (float) getX(), (float) getY(), new CommunicationsActivity$closeActivity$1(this));
    }

    public void showWebView(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = this.container;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        constraintLayout.setLayoutTransition(new LayoutTransition());
        constraintLayout = this.container;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("container");
        }
        constraintLayout.getLayoutTransition().enableTransitionType(4);
        disappearHeader();
        this.webViewFragment = WebViewFragment.Companion.newInstance(str);
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, this.webViewFragment).commitAllowingStateLoss();
    }

    @OnClick({2131361846})
    public final void goBack() {
        WebViewFragment webViewFragment = this.webViewFragment;
        if (webViewFragment != null) {
            webViewFragment.goBack();
        }
    }

    @OnClick({2131361967})
    public final void goForward() {
        WebViewFragment webViewFragment = this.webViewFragment;
        if (webViewFragment != null) {
            webViewFragment.goForward();
        }
    }

    private final void disappearHeader() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setVisibility(8);
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setVisibility(8);
        ConstraintLayout constraintLayout = this.holderContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holderContainer");
        }
        this.headerHeight = constraintLayout.getLayoutParams().height;
        constraintLayout = this.holderContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holderContainer");
        }
        LayoutParams layoutParams = constraintLayout.getLayoutParams();
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        layoutParams.height = (int) TypedValue.applyDimension(1, 40.0f, resources.getDisplayMetrics());
        imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setVisibility(0);
        imageView = this.forwardButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
        }
        imageView.setVisibility(0);
        imageView = this.closeButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        }
        imageView.setVisibility(0);
    }

    private final void reappearHeader() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setVisibility(0);
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setVisibility(0);
        ConstraintLayout constraintLayout = this.holderContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("holderContainer");
        }
        constraintLayout.getLayoutParams().height = this.headerHeight;
        imageView = this.backButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        imageView.setVisibility(8);
        imageView = this.forwardButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
        }
        imageView.setVisibility(8);
        imageView = this.closeButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        }
        imageView.setVisibility(8);
    }

    public void showFailureMessage(@Nullable String str) {
        new Builder(this).setTitle(getString(C0316R.string.error)).setMessage(str).setCancelable(false).setPositiveButton(getString(C0316R.string.got_it), new CommunicationsActivity$showFailureMessage$1(this)).create().show();
    }

    public void showErrorMessage(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, SettingsJsonConstants.PROMPT_MESSAGE_KEY);
        if (Intrinsics.areEqual((Object) str, (Object) "HTTP 401 Unauthorized")) {
            str = "There was a problem, please try again.";
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, str).setButton((int) C0316R.string.got_it, (Function0) new CommunicationsActivity$showErrorMessage$1(this)).setCancelable(false).show();
    }

    public void canGoForward(boolean z) {
        if (z) {
            z = this.forwardButton;
            if (!z) {
                Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
            }
            z.setImageResource(C0316R.drawable.forwardbutton);
            return;
        }
        z = this.forwardButton;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("forwardButton");
        }
        z.setImageResource(C0316R.drawable.disabledforwardbutton);
    }

    public void canGoBack(boolean z) {
        if (z) {
            z = this.backButton;
            if (!z) {
                Intrinsics.throwUninitializedPropertyAccessException("backButton");
            }
            z.setImageResource(C0316R.drawable.backbutton);
            return;
        }
        z = this.backButton;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
        }
        z.setImageResource(C0316R.drawable.disabledbackbutton);
    }

    public void onBackPressed() {
        WebViewFragment webViewFragment = this.webViewFragment;
        if (webViewFragment == null || !webViewFragment.canGoBack()) {
            super.onBackPressed();
            return;
        }
        webViewFragment = this.webViewFragment;
        if (webViewFragment != null) {
            webViewFragment.goBack();
        }
    }
}
