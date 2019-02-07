package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.ContactsAdapter;
import com.aeries.mobileportal.adapters.ContactsAdapter.ContactsListener;
import com.aeries.mobileportal.dagger.modules.ContactListFragmentModule;
import com.aeries.mobileportal.dagger.modules.ContactListFragmentModule_ContactsAdapterFactory;
import com.aeries.mobileportal.dagger.modules.ContactListFragmentModule_ContactsListenerFactory;
import com.aeries.mobileportal.views.fragments.ContactListFragment;
import com.aeries.mobileportal.views.fragments.ContactListFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerContactListFragmentComponent implements ContactListFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private MembersInjector<ContactListFragment> contactListFragmentMembersInjector;
    private Provider<ContactsAdapter> contactsAdapterProvider;
    private Provider<ContactsListener> contactsListenerProvider;

    public static final class Builder {
        private ContactListFragmentModule contactListFragmentModule;

        private Builder() {
        }

        public ContactListFragmentComponent build() {
            if (this.contactListFragmentModule != null) {
                return new DaggerContactListFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ContactListFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder contactListFragmentModule(ContactListFragmentModule contactListFragmentModule) {
            this.contactListFragmentModule = (ContactListFragmentModule) Preconditions.checkNotNull(contactListFragmentModule);
            return this;
        }
    }

    private DaggerContactListFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.contactsListenerProvider = DoubleCheck.provider(ContactListFragmentModule_ContactsListenerFactory.create(builder.contactListFragmentModule));
        this.contactsAdapterProvider = DoubleCheck.provider(ContactListFragmentModule_ContactsAdapterFactory.create(builder.contactListFragmentModule, this.contactsListenerProvider));
        this.contactListFragmentMembersInjector = ContactListFragment_MembersInjector.create(this.contactsAdapterProvider);
    }

    public void inject(ContactListFragment contactListFragment) {
        this.contactListFragmentMembersInjector.injectMembers(contactListFragment);
    }
}
