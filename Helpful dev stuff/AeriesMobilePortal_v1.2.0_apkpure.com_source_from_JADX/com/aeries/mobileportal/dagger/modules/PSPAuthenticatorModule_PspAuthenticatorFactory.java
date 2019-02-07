package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import com.aeries.mobileportal.PSPAuthenticator;
import com.aeries.mobileportal.PSPAuthenticator.PSPAuthenticatorListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PSPAuthenticatorModule_PspAuthenticatorFactory implements Factory<PSPAuthenticator> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<Context> contextProvider;
    private final Provider<PSPAuthenticatorListener> listenerProvider;
    private final PSPAuthenticatorModule module;

    public PSPAuthenticatorModule_PspAuthenticatorFactory(PSPAuthenticatorModule pSPAuthenticatorModule, Provider<Context> provider, Provider<PSPAuthenticatorListener> provider2) {
        this.module = pSPAuthenticatorModule;
        this.contextProvider = provider;
        this.listenerProvider = provider2;
    }

    public PSPAuthenticator get() {
        return (PSPAuthenticator) Preconditions.checkNotNull(this.module.pspAuthenticator((Context) this.contextProvider.get(), (PSPAuthenticatorListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<PSPAuthenticator> create(PSPAuthenticatorModule pSPAuthenticatorModule, Provider<Context> provider, Provider<PSPAuthenticatorListener> provider2) {
        return new PSPAuthenticatorModule_PspAuthenticatorFactory(pSPAuthenticatorModule, provider, provider2);
    }
}
