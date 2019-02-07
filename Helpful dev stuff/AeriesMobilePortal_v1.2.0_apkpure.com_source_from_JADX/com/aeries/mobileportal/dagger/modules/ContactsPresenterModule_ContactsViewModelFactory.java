package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.views.viewmodels.contacts.ContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ContactsPresenterModule_ContactsViewModelFactory implements Factory<ContactsViewModel> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ContactsPresenterModule module;

    public ContactsPresenterModule_ContactsViewModelFactory(ContactsPresenterModule contactsPresenterModule) {
        this.module = contactsPresenterModule;
    }

    public ContactsViewModel get() {
        return (ContactsViewModel) Preconditions.checkNotNull(this.module.contactsViewModel(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ContactsViewModel> create(ContactsPresenterModule contactsPresenterModule) {
        return new ContactsPresenterModule_ContactsViewModelFactory(contactsPresenterModule);
    }
}
