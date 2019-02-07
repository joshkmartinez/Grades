package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.PSPAuthenticator.PSPAuthenticatorListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PSPAuthenticatorModule_PspAuthenticatorListenerFactory implements Factory<PSPAuthenticatorListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final PSPAuthenticatorModule module;

    public PSPAuthenticatorModule_PspAuthenticatorListenerFactory(PSPAuthenticatorModule pSPAuthenticatorModule) {
        this.module = pSPAuthenticatorModule;
    }

    public PSPAuthenticatorListener get() {
        return (PSPAuthenticatorListener) Preconditions.checkNotNull(this.module.pspAuthenticatorListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<PSPAuthenticatorListener> create(PSPAuthenticatorModule pSPAuthenticatorModule) {
        return new PSPAuthenticatorModule_PspAuthenticatorListenerFactory(pSPAuthenticatorModule);
    }
}
