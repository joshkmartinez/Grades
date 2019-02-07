package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.ContactsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ContactListFragment_MembersInjector implements MembersInjector<ContactListFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<ContactsAdapter> adapterProvider;

    public ContactListFragment_MembersInjector(Provider<ContactsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<ContactListFragment> create(Provider<ContactsAdapter> provider) {
        return new ContactListFragment_MembersInjector(provider);
    }

    public void injectMembers(ContactListFragment contactListFragment) {
        if (contactListFragment != null) {
            contactListFragment.adapter = (ContactsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
