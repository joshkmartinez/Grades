package com.aeries.mobileportal.views.activities;

import android.app.AlertDialog.Builder;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.ChangePasswordActivityComponent;
import com.aeries.mobileportal.models.AccountTakenRequest;
import com.aeries.mobileportal.models.ChangePasswordRequest;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.change_password.ChangePasswordPresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.ChangePasswordFragment;
import com.aeries.mobileportal.views.fragments.ChangePasswordFragment.ChangePasswordFragmentListener;
import com.aeries.mobileportal.views.fragments.ForgotPasswordDoneFragment;
import com.aeries.mobileportal.views.fragments.ForgotPasswordDoneFragment.ForgotPasswordDoneFragmentListener;
import com.aeries.mobileportal.views.viewmodels.change_password.ChangePasswordViewModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0002\u0010\u0014J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015H\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/aeries/mobileportal/views/activities/ChangePasswordActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/change_password/ChangePasswordViewModel;", "Lcom/aeries/mobileportal/views/fragments/ChangePasswordFragment$ChangePasswordFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/ForgotPasswordDoneFragment$ForgotPasswordDoneFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/ChangePasswordActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ChangePasswordActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/aeries/mobileportal/presenters/change_password/ChangePasswordPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/change_password/ChangePasswordPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/change_password/ChangePasswordPresenter;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "", "onConfirmPassword", "changePasswordRequest", "Lcom/aeries/mobileportal/models/ChangePasswordRequest;", "onCreate", "onReturnToLoginPressed", "showDoneScreen", "showError", "error", "", "showPasswordFragment", "accountTakenRequest", "Lcom/aeries/mobileportal/models/AccountTakenRequest;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ChangePasswordActivity.kt */
public final class ChangePasswordActivity extends BaseActivity<ChangePasswordViewModel> implements ChangePasswordViewModel, ChangePasswordFragmentListener, ForgotPasswordDoneFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ChangePasswordActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ChangePasswordActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ChangePasswordActivity$component$2(this));
    @Inject
    @NotNull
    public ChangePasswordPresenter presenter;

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
    public final ChangePasswordActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ChangePasswordActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ChangePasswordPresenter m109getPresenter() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return changePasswordPresenter;
    }

    public final void setPresenter(@NotNull ChangePasswordPresenter changePasswordPresenter) {
        Intrinsics.checkParameterIsNotNull(changePasswordPresenter, "<set-?>");
        this.presenter = changePasswordPresenter;
    }

    public void onCreate() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.getEmailAddress();
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_change_password);
    }

    @Nullable
    protected BasePresenter<ChangePasswordViewModel> getPresenter() {
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return changePasswordPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }

    public void showPasswordFragment(@NotNull AccountTakenRequest accountTakenRequest) {
        Intrinsics.checkParameterIsNotNull(accountTakenRequest, "accountTakenRequest");
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, ChangePasswordFragment.Companion.newInstance(accountTakenRequest)).commit();
    }

    public void onConfirmPassword(@NotNull ChangePasswordRequest changePasswordRequest) {
        Intrinsics.checkParameterIsNotNull(changePasswordRequest, "changePasswordRequest");
        ChangePasswordPresenter changePasswordPresenter = this.presenter;
        if (changePasswordPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        changePasswordPresenter.changePassword(changePasswordRequest);
    }

    public void showDoneScreen() {
        getSupportFragmentManager().beginTransaction().replace(C0316R.id.fragment_container, ForgotPasswordDoneFragment.Companion.newInstance(false)).commit();
    }

    public void onReturnToLoginPressed() {
        finish();
    }

    public void showError(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "error");
        new Builder(this).setMessage(str).setTitle(C0316R.string.error).setPositiveButton(C0316R.string.got_it, null).create().show();
    }
}
