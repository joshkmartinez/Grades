package com.aeries.mobileportal.views.activities;

import com.aeries.mobileportal.presenters.contacts.ContactsPresenter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ContactsActivity_MembersInjector implements MembersInjector<ContactsActivity> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ContactsPresenter> presenterProvider;

    public ContactsActivity_MembersInjector(Provider<ContactsPresenter> provider) {
        this.presenterProvider = provider;
    }

    public static MembersInjector<ContactsActivity> create(Provider<ContactsPresenter> provider) {
        return new ContactsActivity_MembersInjector(provider);
    }

    public void injectMembers(ContactsActivity contactsActivity) {
        if (contactsActivity != null) {
            contactsActivity.presenter = (ContactsPresenter) this.presenterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
