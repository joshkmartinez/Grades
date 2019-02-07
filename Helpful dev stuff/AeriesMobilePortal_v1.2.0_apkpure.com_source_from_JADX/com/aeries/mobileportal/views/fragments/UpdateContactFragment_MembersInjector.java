package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.adapters.LinkContactsAdapter;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class UpdateContactFragment_MembersInjector implements MembersInjector<UpdateContactFragment> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<LinkContactsAdapter> adapterProvider;

    public UpdateContactFragment_MembersInjector(Provider<LinkContactsAdapter> provider) {
        this.adapterProvider = provider;
    }

    public static MembersInjector<UpdateContactFragment> create(Provider<LinkContactsAdapter> provider) {
        return new UpdateContactFragment_MembersInjector(provider);
    }

    public void injectMembers(UpdateContactFragment updateContactFragment) {
        if (updateContactFragment != null) {
            updateContactFragment.adapter = (LinkContactsAdapter) this.adapterProvider.get();
            return;
        }
        throw new NullPointerException("Cannot inject members into a null reference");
    }
}
