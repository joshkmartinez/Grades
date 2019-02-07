package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.PSPAuthenticator;
import com.aeries.mobileportal.PSPAuthenticator.PSPAuthenticatorListener;
import com.aeries.mobileportal.dagger.scopes.ServiceScope;
import com.aeries.mobileportal.interactors.login.LoginInteractor;
import com.aeries.mobileportal.presenters.AuthServicePresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u000f\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/aeries/mobileportal/dagger/modules/PSPAuthenticatorModule;", "", "listener", "Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "(Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;)V", "getListener", "()Lcom/aeries/mobileportal/PSPAuthenticator$PSPAuthenticatorListener;", "authServicePresenter", "Lcom/aeries/mobileportal/presenters/AuthServicePresenter;", "interactor", "Lcom/aeries/mobileportal/interactors/login/LoginInteractor;", "pspAuthenticator", "Lcom/aeries/mobileportal/PSPAuthenticator;", "context", "Landroid/content/Context;", "pspAuthenticatorListener", "app_release"}, k = 1, mv = {1, 1, 10})
@Module
/* compiled from: PSPAuthenticatorModule.kt */
public final class PSPAuthenticatorModule {
    @NotNull
    private final PSPAuthenticatorListener listener;

    public PSPAuthenticatorModule(@NotNull PSPAuthenticatorListener pSPAuthenticatorListener) {
        Intrinsics.checkParameterIsNotNull(pSPAuthenticatorListener, CastExtraArgs.LISTENER);
        this.listener = pSPAuthenticatorListener;
    }

    @NotNull
    public final PSPAuthenticatorListener getListener() {
        return this.listener;
    }

    @ServiceScope
    @NotNull
    @Provides
    public final PSPAuthenticatorListener pspAuthenticatorListener() {
        return this.listener;
    }

    @ServiceScope
    @NotNull
    @Provides
    public final PSPAuthenticator pspAuthenticator(@NotNull Context context, @NotNull PSPAuthenticatorListener pSPAuthenticatorListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(pSPAuthenticatorListener, CastExtraArgs.LISTENER);
        return new PSPAuthenticator(context, pSPAuthenticatorListener);
    }

    @ServiceScope
    @NotNull
    @Provides
    public final AuthServicePresenter authServicePresenter(@NotNull LoginInteractor loginInteractor) {
        Intrinsics.checkParameterIsNotNull(loginInteractor, "interactor");
        return new AuthServicePresenter(loginInteractor);
    }
}
