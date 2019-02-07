package com.aeries.mobileportal.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.aeries.mobileportal.PSPAuthenticator;
import com.aeries.mobileportal.PSPAuthenticator.PSPAuthenticatorListener;
import com.aeries.mobileportal.dagger.components.PSPAuthenticatorServiceComponent;
import com.aeries.mobileportal.models.RefreshUser;
import com.aeries.mobileportal.presenters.AuthServicePresenter;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/aeries/mobileportal/services/PSPAuthenticatorService;", "Landroid/app/Service;", "Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "()V", "authenticator", "Lcom/aeries/mobileportal/PSPAuthenticator;", "getAuthenticator", "()Lcom/aeries/mobileportal/PSPAuthenticator;", "setAuthenticator", "(Lcom/aeries/mobileportal/PSPAuthenticator;)V", "component", "Lcom/aeries/mobileportal/dagger/components/PSPAuthenticatorServiceComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/PSPAuthenticatorServiceComponent;", "component$delegate", "Lkotlin/Lazy;", "presenter", "Lcom/aeries/mobileportal/presenters/AuthServicePresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/AuthServicePresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/AuthServicePresenter;)V", "getToken", "", "password", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "refreshToken", "", "refreshUser", "Lcom/aeries/mobileportal/models/RefreshUser;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: PSPAuthenticatorService.kt */
public final class PSPAuthenticatorService extends Service implements PSPAuthenticatorListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(PSPAuthenticatorService.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/PSPAuthenticatorServiceComponent;"))};
    @Inject
    @NotNull
    public PSPAuthenticator authenticator;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new PSPAuthenticatorService$component$2(this));
    @Inject
    @NotNull
    public AuthServicePresenter presenter;

    @NotNull
    public final PSPAuthenticatorServiceComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (PSPAuthenticatorServiceComponent) lazy.getValue();
    }

    @NotNull
    public final PSPAuthenticator getAuthenticator() {
        PSPAuthenticator pSPAuthenticator = this.authenticator;
        if (pSPAuthenticator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticator");
        }
        return pSPAuthenticator;
    }

    public final void setAuthenticator(@NotNull PSPAuthenticator pSPAuthenticator) {
        Intrinsics.checkParameterIsNotNull(pSPAuthenticator, "<set-?>");
        this.authenticator = pSPAuthenticator;
    }

    @NotNull
    public final AuthServicePresenter getPresenter() {
        AuthServicePresenter authServicePresenter = this.presenter;
        if (authServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authServicePresenter;
    }

    public final void setPresenter(@NotNull AuthServicePresenter authServicePresenter) {
        Intrinsics.checkParameterIsNotNull(authServicePresenter, "<set-?>");
        this.presenter = authServicePresenter;
    }

    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        getComponent().inject(this);
        intent = this.authenticator;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authenticator");
        }
        return intent.getIBinder();
    }

    @Nullable
    public String getToken(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "password");
        AuthServicePresenter authServicePresenter = this.presenter;
        if (authServicePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return authServicePresenter.getAuthToken(str);
    }

    public void refreshToken(@NotNull RefreshUser refreshUser) {
        Intrinsics.checkParameterIsNotNull(refreshUser, "refreshUser");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append("not implemented");
        throw ((Throwable) new NotImplementedError(stringBuilder.toString()));
    }
}
