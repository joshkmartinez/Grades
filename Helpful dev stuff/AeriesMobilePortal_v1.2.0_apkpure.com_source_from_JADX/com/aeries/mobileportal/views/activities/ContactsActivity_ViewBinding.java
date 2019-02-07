package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ContactsActivity_ViewBinding implements Unbinder {
    private ContactsActivity target;
    private View view2131361925;

    @UiThread
    public ContactsActivity_ViewBinding(ContactsActivity contactsActivity) {
        this(contactsActivity, contactsActivity.getWindow().getDecorView());
    }

    @UiThread
    public ContactsActivity_ViewBinding(final ContactsActivity contactsActivity, View view) {
        this.target = contactsActivity;
        contactsActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_name, "field 'detailName' and method 'closeActivity'");
        contactsActivity.detailName = (TextView) Utils.castView(findRequiredView, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        this.view2131361925 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                contactsActivity.closeActivity();
            }
        });
        contactsActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        contactsActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        contactsActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        ContactsActivity contactsActivity = this.target;
        if (contactsActivity != null) {
            this.target = null;
            contactsActivity.detailTitle = null;
            contactsActivity.detailName = null;
            contactsActivity.detailIcon = null;
            contactsActivity.fragmentContainer = null;
            contactsActivity.progressBar = null;
            this.view2131361925.setOnClickListener(null);
            this.view2131361925 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
