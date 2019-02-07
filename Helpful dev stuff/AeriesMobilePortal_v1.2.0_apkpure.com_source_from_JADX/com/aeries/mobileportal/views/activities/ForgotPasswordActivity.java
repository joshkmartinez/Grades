package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.ForgotPasswordActivityComponent;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.models.ForgotPasswordResponse;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.forgot_password.ForgotPasswordPresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.EnterEmailFragment;
import com.aeries.mobileportal.views.fragments.EnterEmailFragment.EnterEmailFragmentListener;
import com.aeries.mobileportal.views.fragments.ForgotPasswordDoneFragment;
import com.aeries.mobileportal.views.fragments.ForgotPasswordDoneFragment.ForgotPasswordDoneFragmentListener;
import com.aeries.mobileportal.views.fragments.ForgotPasswordFragment;
import com.aeries.mobileportal.views.fragments.ForgotPasswordFragment.ChangePasswordFragmentListener;
import com.aeries.mobileportal.views.fragments.ForgotPasswordFragment.Companion;
import com.aeries.mobileportal.views.viewmodels.forgot_password.ForgotPasswordViewModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010$\u001a\u0004\u0018\u00010%H\u0014¢\u0006\u0002\u0010&J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010'H\u0014J\n\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020+2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020+H\u0016J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0016J\u0010\u00107\u001a\u00020+2\u0006\u00108\u001a\u00020\u0013H\u0016J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020;H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ForgotPasswordActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/forgot_password/ForgotPasswordViewModel;", "Lcom/aeries/mobileportal/views/fragments/EnterEmailFragment$EnterEmailFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordFragment$ChangePasswordFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment$ForgotPasswordDoneFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/ForgotPasswordActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ForgotPasswordActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "forgotPasswordDoneFragment", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment;", "getForgotPasswordDoneFragment", "()Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment;", "forgotPasswordDoneFragment$delegate", "mEmail", "", "getMEmail", "()Ljava/lang/String;", "setMEmail", "(Ljava/lang/String;)V", "presenter", "Lcom/aeries/mobileportal/presenters/forgot_password/ForgotPasswordPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/forgot_password/ForgotPasswordPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/forgot_password/ForgotPasswordPresenter;)V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "setProgressDialog", "(Landroid/app/ProgressDialog;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "", "onBackPressed", "onCreate", "onDataSubmitted", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "onNextPressed", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "onReturnToLoginPressed", "setupViews", "showDoneScreen", "showError", "error", "showVerificationScreen", "forgotPasswordResponse", "Lcom/aeries/mobileportal/models/ForgotPasswordResponse;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ForgotPasswordActivity.kt */
public final class ForgotPasswordActivity extends BaseActivity<ForgotPasswordViewModel> implements ForgotPasswordViewModel, EnterEmailFragmentListener, ChangePasswordFragmentListener, ForgotPasswordDoneFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ForgotPasswordActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ForgotPasswordActivityComponent;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ForgotPasswordActivity.class), "forgotPasswordDoneFragment", "getForgotPasswordDoneFragment()Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ForgotPasswordActivity$component$2(this));
    @NotNull
    private final Lazy forgotPasswordDoneFragment$delegate = LazyKt.lazy(ForgotPasswordActivity$forgotPasswordDoneFragment$2.INSTANCE);
    @NotNull
    public String mEmail;
    @Inject
    @NotNull
    public ForgotPasswordPresenter presenter;
    @NotNull
    public ProgressDialog progressDialog;

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
    public final ForgotPasswordActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ForgotPasswordActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ForgotPasswordDoneFragment getForgotPasswordDoneFragment() {
        Lazy lazy = this.forgotPasswordDoneFragment$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return (ForgotPasswordDoneFragment) lazy.getValue();
    }

    @NotNull
    public final ForgotPasswordPresenter m111getPresenter() {
        ForgotPasswordPresenter forgotPasswordPresenter = this.presenter;
        if (forgotPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return forgotPasswordPresenter;
    }

    public final void setPresenter(@NotNull ForgotPasswordPresenter forgotPasswordPresenter) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordPresenter, "<set-?>");
        this.presenter = forgotPasswordPresenter;
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
    public final String getMEmail() {
        String str = this.mEmail;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmail");
        }
        return str;
    }

    public final void setMEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mEmail = str;
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_forgot_password);
    }

    @Nullable
    protected BasePresenter<ForgotPasswordViewModel> getPresenter() {
        ForgotPasswordPresenter forgotPasswordPresenter = this.presenter;
        if (forgotPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return forgotPasswordPresenter;
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

    public void onBackPressed() {
        if (!getForgotPasswordDoneFragment().isVisible()) {
            super.onBackPressed();
        }
    }

    private final void setupViews() {
        this.progressDialog = new ProgressDialog(this);
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setCancelable(false);
        progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.setMessage(getString(C0316R.string.loading));
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, EnterEmailFragment.Companion.newInstance()).commit();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        new Builder(this).setTitle(getString(C0316R.string.error)).setMessage(str).setPositiveButton(C0316R.string.got_it, null).create().show();
    }

    public void showVerificationScreen(@NotNull ForgotPasswordResponse forgotPasswordResponse) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordResponse, "forgotPasswordResponse");
        forgotPasswordResponse = this.progressDialog;
        if (forgotPasswordResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        forgotPasswordResponse.dismiss();
        forgotPasswordResponse = getSupportFragmentManager().beginTransaction();
        Companion companion = ForgotPasswordFragment.Companion;
        String str = this.mEmail;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmail");
        }
        forgotPasswordResponse.replace(C0316R.id.fragment_container, companion.newInstance(str)).addToBackStack(null).commit();
    }

    public void showDoneScreen() {
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.dismiss();
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, getForgotPasswordDoneFragment()).addToBackStack(null).commit();
    }

    public void onDataSubmitted(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        this.mEmail = accountTakenRequest.getEmailaddress();
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.show();
        ForgotPasswordPresenter forgotPasswordPresenter = this.presenter;
        if (forgotPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        forgotPasswordPresenter.submitForgotPasswordEmail(accountTakenRequest.getEmailaddress());
    }

    public void onNextPressed(@NotNull ChangePasswordRequest changePasswordRequest) {
        Intrinsics.checkParameterIsNotNull(changePasswordRequest, "changePasswordRequest");
        ProgressDialog progressDialog = this.progressDialog;
        if (progressDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        }
        progressDialog.show();
        ForgotPasswordPresenter forgotPasswordPresenter = this.presenter;
        if (forgotPasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        forgotPasswordPresenter.changePassword(changePasswordRequest);
    }

    public void onReturnToLoginPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(67141632);
        startActivity(intent);
    }
}
