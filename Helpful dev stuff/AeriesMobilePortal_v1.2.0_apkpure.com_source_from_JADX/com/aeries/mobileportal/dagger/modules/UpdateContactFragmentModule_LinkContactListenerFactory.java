package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.LinkContactsAdapter.LinkContactListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class UpdateContactFragmentModule_LinkContactListenerFactory implements Factory<LinkContactListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final UpdateContactFragmentModule module;

    public UpdateContactFragmentModule_LinkContactListenerFactory(UpdateContactFragmentModule updateContactFragmentModule) {
        this.module = updateContactFragmentModule;
    }

    public LinkContactListener get() {
        return (LinkContactListener) Preconditions.checkNotNull(this.module.linkContactListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkContactListener> create(UpdateContactFragmentModule updateContactFragmentModule) {
        return new UpdateContactFragmentModule_LinkContactListenerFactory(updateContactFragmentModule);
    }
}
