package com.aeries.mobileportal.views.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.models.Contact;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: ContactDetailFragment.kt */
final class ContactDetailFragment$setupViews$1 implements OnClickListener {
    final /* synthetic */ ContactDetailFragment this$0;

    ContactDetailFragment$setupViews$1(ContactDetailFragment contactDetailFragment) {
        this.this$0 = contactDetailFragment;
    }

    public final void onClick(View view) {
        view = this.this$0.mListener;
        if (view != null) {
            Contact access$getMContact$p = this.this$0.mContact;
            view.onPhonePressed(access$getMContact$p != null ? access$getMContact$p.getCellPhone() : null);
        }
    }
}
