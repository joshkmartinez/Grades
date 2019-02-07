package com.aeries.mobileportal.views.activities;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.AuthErrorActivityComponent;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.auth_error.AuthErrorPresenter;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.viewmodels.auth_error.AuthErrorViewModel;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0002\u0010\u0012J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/aeries/mobileportal/views/activities/AuthErrorActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/auth_error/AuthErrorViewModel;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/AuthErrorActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AuthErrorActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/aeries/mobileportal/presenters/auth_error/AuthErrorPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/auth_error/AuthErrorPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/auth_error/AuthErrorPresenter;)V", "getLayout", "", "()Ljava/lang/Integer;", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "", "onCreate", "startLoginActivity", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AuthErrorActivity.kt */
public final class AuthErrorActivity extends BaseActivity<AuthErrorViewModel> implements AuthErrorViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AuthErrorActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AuthErrorActivityComponent;"))};
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AuthErrorActivity$component$2(this));
    @Inject
    @NotNull
    public AuthErrorPresenter presenter;

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
    public final AuthErrorActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AuthErrorActivityComponent) lazy.getValue();
    }

    @Nullable
    protected Integer getLayout() {
        return null;
    }

    @NotNull
    public final AuthErrorPresenter m95getPresenter() {
        AuthErrorPresenter authErrorPresenter = this.presenter;
        if (authErrorPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authErrorPresenter;
    }

    public final void setPresenter(@NotNull AuthErrorPresenter authErrorPresenter) {
        Intrinsics.checkParameterIsNotNull(authErrorPresenter, "<set-?>");
        this.presenter = authErrorPresenter;
    }

    public void onCreate() {
        new Builder(this).setTitle((CharSequence) getString(C0316R.string.session_expired)).setMessage((CharSequence) getString(C0316R.string.session_expired_message)).setPositiveButton((int) C0316R.string.got_it, (OnClickListener) new AuthErrorActivity$onCreate$1(this)).setCancelable(false).show();
    }

    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(872448000);
        startActivity(intent);
    }

    @Nullable
    protected BasePresenter<AuthErrorViewModel> getPresenter() {
        AuthErrorPresenter authErrorPresenter = this.presenter;
        if (authErrorPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authErrorPresenter;
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void inject() {
        getComponent().inject(this);
    }
}
