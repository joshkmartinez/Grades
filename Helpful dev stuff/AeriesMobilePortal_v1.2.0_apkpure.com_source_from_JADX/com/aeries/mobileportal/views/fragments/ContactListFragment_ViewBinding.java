package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ContactListFragment_ViewBinding implements Unbinder {
    private ContactListFragment target;

    @UiThread
    public ContactListFragment_ViewBinding(ContactListFragment contactListFragment, View view) {
        this.target = contactListFragment;
        contactListFragment.contactsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.contacts_recycler_view, "field 'contactsRV'", RecyclerView.class);
        contactListFragment.noContactsView = Utils.findRequiredView(view, C0316R.id.no_contacts, "field 'noContactsView'");
    }

    public void unbind() {
        ContactListFragment contactListFragment = this.target;
        if (contactListFragment != null) {
            this.target = null;
            contactListFragment.contactsRV = null;
            contactListFragment.noContactsView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
