package com.aeries.mobileportal.views.fragments;

import com.aeries.mobileportal.dagger.components.ContactListFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerContactListFragmentComponent;
import com.aeries.mobileportal.dagger.modules.ContactListFragmentModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/ContactListFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: ContactListFragment.kt */
final class ContactListFragment$component$2 extends Lambda implements Function0<ContactListFragmentComponent> {
    final /* synthetic */ ContactListFragment this$0;

    ContactListFragment$component$2(ContactListFragment contactListFragment) {
        this.this$0 = contactListFragment;
        super(0);
    }

    public final ContactListFragmentComponent invoke() {
        return DaggerContactListFragmentComponent.builder().contactListFragmentModule(new ContactListFragmentModule(this.this$0)).build();
    }
}
