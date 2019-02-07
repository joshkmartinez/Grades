package com.aeries.mobileportal.dagger.components;

import com.aeries.mobileportal.adapters.LinkContactsAdapter;
import com.aeries.mobileportal.adapters.LinkContactsAdapter.LinkContactListener;
import com.aeries.mobileportal.dagger.modules.UpdateContactFragmentModule;
import com.aeries.mobileportal.dagger.modules.UpdateContactFragmentModule_LinkContactAdapterFactory;
import com.aeries.mobileportal.dagger.modules.UpdateContactFragmentModule_LinkContactListenerFactory;
import com.aeries.mobileportal.views.fragments.UpdateContactFragment;
import com.aeries.mobileportal.views.fragments.UpdateContactFragment_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerUpdateContactFragmentComponent implements UpdateContactFragmentComponent {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Provider<LinkContactsAdapter> linkContactAdapterProvider;
    private Provider<LinkContactListener> linkContactListenerProvider;
    private MembersInjector<UpdateContactFragment> updateContactFragmentMembersInjector;

    public static final class Builder {
        private UpdateContactFragmentModule updateContactFragmentModule;

        private Builder() {
        }

        public UpdateContactFragmentComponent build() {
            if (this.updateContactFragmentModule != null) {
                return new DaggerUpdateContactFragmentComponent();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UpdateContactFragmentModule.class.getCanonicalName());
            stringBuilder.append(" must be set");
            throw new IllegalStateException(stringBuilder.toString());
        }

        public Builder updateContactFragmentModule(UpdateContactFragmentModule updateContactFragmentModule) {
            this.updateContactFragmentModule = (UpdateContactFragmentModule) Preconditions.checkNotNull(updateContactFragmentModule);
            return this;
        }
    }

    private DaggerUpdateContactFragmentComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private void initialize(Builder builder) {
        this.linkContactListenerProvider = DoubleCheck.provider(UpdateContactFragmentModule_LinkContactListenerFactory.create(builder.updateContactFragmentModule));
        this.linkContactAdapterProvider = DoubleCheck.provider(UpdateContactFragmentModule_LinkContactAdapterFactory.create(builder.updateContactFragmentModule, this.linkContactListenerProvider));
        this.updateContactFragmentMembersInjector = UpdateContactFragment_MembersInjector.create(this.linkContactAdapterProvider);
    }

    public void inject(UpdateContactFragment updateContactFragment) {
        this.updateContactFragmentMembersInjector.injectMembers(updateContactFragment);
    }
}
