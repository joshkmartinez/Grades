package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ContactDetailFragment_ViewBinding implements Unbinder {
    private ContactDetailFragment target;
    private View view2131361870;

    @UiThread
    public ContactDetailFragment_ViewBinding(final ContactDetailFragment contactDetailFragment, View view) {
        this.target = contactDetailFragment;
        contactDetailFragment.fullNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.full_name, "field 'fullNameTV'", TextView.class);
        contactDetailFragment.relationshipTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.relationship, "field 'relationshipTV'", TextView.class);
        contactDetailFragment.mobilePhoneTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.mobile_phone, "field 'mobilePhoneTV'", TextView.class);
        contactDetailFragment.workPhoneTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.work_phone, "field 'workPhoneTV'", TextView.class);
        contactDetailFragment.telephoneTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.telephone, "field 'telephoneTV'", TextView.class);
        contactDetailFragment.addressTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.address, "field 'addressTV'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.check_in_button, "field 'closeButton' and method 'onCloseButtonPressed'");
        contactDetailFragment.closeButton = (Button) Utils.castView(findRequiredView, C0316R.id.check_in_button, "field 'closeButton'", Button.class);
        this.view2131361870 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactDetailFragment.onCloseButtonPressed();
            }
        });
        contactDetailFragment.wPhoneIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.wphone_icon, "field 'wPhoneIcon'", ImageView.class);
        contactDetailFragment.telephoneIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.telephone_icon, "field 'telephoneIcon'", ImageView.class);
        contactDetailFragment.mPhoneIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.mphone_icon, "field 'mPhoneIcon'", ImageView.class);
        contactDetailFragment.addressIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.address_icon, "field 'addressIcon'", ImageView.class);
    }

    public void unbind() {
        ContactDetailFragment contactDetailFragment = this.target;
        if (contactDetailFragment != null) {
            this.target = null;
            contactDetailFragment.fullNameTV = null;
            contactDetailFragment.relationshipTV = null;
            contactDetailFragment.mobilePhoneTV = null;
            contactDetailFragment.workPhoneTV = null;
            contactDetailFragment.telephoneTV = null;
            contactDetailFragment.addressTV = null;
            contactDetailFragment.closeButton = null;
            contactDetailFragment.wPhoneIcon = null;
            contactDetailFragment.telephoneIcon = null;
            contactDetailFragment.mPhoneIcon = null;
            contactDetailFragment.addressIcon = null;
            this.view2131361870.setOnClickListener(null);
            this.view2131361870 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
