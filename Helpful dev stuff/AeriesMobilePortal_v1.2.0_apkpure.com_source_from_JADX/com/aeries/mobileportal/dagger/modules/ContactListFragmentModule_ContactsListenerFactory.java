package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.adapters.ContactsAdapter.ContactsListener;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ContactListFragmentModule_ContactsListenerFactory implements Factory<ContactsListener> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ContactListFragmentModule module;

    public ContactListFragmentModule_ContactsListenerFactory(ContactListFragmentModule contactListFragmentModule) {
        this.module = contactListFragmentModule;
    }

    public ContactsListener get() {
        return (ContactsListener) Preconditions.checkNotNull(this.module.contactsListener(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ContactsListener> create(ContactListFragmentModule contactListFragmentModule) {
        return new ContactListFragmentModule_ContactsListenerFactory(contactListFragmentModule);
    }
}
