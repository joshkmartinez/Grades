package com.aeries.mobileportal.dagger.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ContextModule_ContextFactory implements Factory<Context> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ContextModule module;

    public ContextModule_ContextFactory(ContextModule contextModule) {
        this.module = contextModule;
    }

    public Context get() {
        return (Context) Preconditions.checkNotNull(this.module.context(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<Context> create(ContextModule contextModule) {
        return new ContextModule_ContextFactory(contextModule);
    }
}
