package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.ContactsAdapter;
import com.aeries.mobileportal.adapters.ContactsAdapter.ContactsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ContactListFragmentModule_ContactsAdapterFactory implements Factory<ContactsAdapter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ContactsListener> listenerProvider;
    private final ContactListFragmentModule module;

    public ContactListFragmentModule_ContactsAdapterFactory(ContactListFragmentModule contactListFragmentModule, Provider<ContactsListener> provider) {
        this.module = contactListFragmentModule;
        this.listenerProvider = provider;
    }

    public ContactsAdapter get() {
        return (ContactsAdapter) Preconditions.checkNotNull(this.module.contactsAdapter((ContactsListener) this.listenerProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ContactsAdapter> create(ContactListFragmentModule contactListFragmentModule, Provider<ContactsListener> provider) {
        return new ContactListFragmentModule_ContactsAdapterFactory(contactListFragmentModule, provider);
    }
}
