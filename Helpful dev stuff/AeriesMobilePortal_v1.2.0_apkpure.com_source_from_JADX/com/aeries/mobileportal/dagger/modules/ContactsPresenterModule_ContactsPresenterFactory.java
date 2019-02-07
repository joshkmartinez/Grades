package com.aeries.mobileportal.dagger.modules;

import com.aeries.mobileportal.interactors.contacts.ContactsInteractor;
import com.aeries.mobileportal.presenters.contacts.ContactsPresenter;
import com.aeries.mobileportal.views.viewmodels.contacts.ContactsViewModel;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ContactsPresenterModule_ContactsPresenterFactory implements Factory<ContactsPresenter> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ContactsInteractor> contactsInteractorProvider;
    private final Provider<ContactsViewModel> contactsViewModelProvider;
    private final ContactsPresenterModule module;

    public ContactsPresenterModule_ContactsPresenterFactory(ContactsPresenterModule contactsPresenterModule, Provider<ContactsViewModel> provider, Provider<ContactsInteractor> provider2) {
        this.module = contactsPresenterModule;
        this.contactsViewModelProvider = provider;
        this.contactsInteractorProvider = provider2;
    }

    public ContactsPresenter get() {
        return (ContactsPresenter) Preconditions.checkNotNull(this.module.contactsPresenter((ContactsViewModel) this.contactsViewModelProvider.get(), (ContactsInteractor) this.contactsInteractorProvider.get()), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ContactsPresenter> create(ContactsPresenterModule contactsPresenterModule, Provider<ContactsViewModel> provider, Provider<ContactsInteractor> provider2) {
        return new ContactsPresenterModule_ContactsPresenterFactory(contactsPresenterModule, provider, provider2);
    }
}
