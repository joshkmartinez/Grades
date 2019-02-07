package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.LinkContactsAdapter;
import com.aeries.mobileportal.adapters.LinkContactsAdapter.LinkContactListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UpdateContactFragmentModule_LinkContactAdapterFactory implements Factory<LinkContactsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LinkContactListener> listenerProvider;
    private final UpdateContactFragmentModule module;

    public UpdateContactFragmentModule_LinkContactAdapterFactory(UpdateContactFragmentModule updateContactFragmentModule, Provider<LinkContactListener> provider) {
        this.module = updateContactFragmentModule;
        this.listenerProvider = provider;
    }

    public LinkContactsAdapter get() {
        return (LinkContactsAdapter) Preconditions.checkNotNull(this.module.linkContactAdapter((LinkContactListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<LinkContactsAdapter> create(UpdateContactFragmentModule updateContactFragmentModule, Provider<LinkContactListener> provider) {
        return new UpdateContactFragmentModule_LinkContactAdapterFactory(updateContactFragmentModule, provider);
    }
}
