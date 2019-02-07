package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Contact;
import com.aeries.mobileportal.utils.StringUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0018R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/adapters/ContactsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactHolder;", "listener", "Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "(Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;)V", "contacts", "", "Lcom/aeries/mobileportal/models/Contact;", "getContacts", "()Ljava/util/List;", "getListener", "()Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateContacts", "", "ContactHolder", "ContactsListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactsAdapter.kt */
public final class ContactsAdapter extends Adapter<ContactHolder> {
    @NotNull
    private final List<Contact> contacts = ((List) new ArrayList());
    @NotNull
    private final ContactsListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "", "onContactSelected", "", "contact", "Lcom/aeries/mobileportal/models/Contact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactsAdapter.kt */
    public interface ContactsListener {
        void onContactSelected(@NotNull Contact contact);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/ContactsAdapter;Landroid/view/View;)V", "contactNameTV", "Landroid/widget/TextView;", "getContactNameTV", "()Landroid/widget/TextView;", "setContactNameTV", "(Landroid/widget/TextView;)V", "contactRelationshipTV", "getContactRelationshipTV", "setContactRelationshipTV", "bindData", "", "contact", "Lcom/aeries/mobileportal/models/Contact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactsAdapter.kt */
    public final class ContactHolder extends ViewHolder {
        @NotNull
        @BindView(2131361887)
        public TextView contactNameTV;
        @NotNull
        @BindView(2131361888)
        public TextView contactRelationshipTV;
        final /* synthetic */ ContactsAdapter this$0;

        public ContactHolder(@NotNull ContactsAdapter contactsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = contactsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getContactNameTV() {
            TextView textView = this.contactNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactNameTV");
            }
            return textView;
        }

        public final void setContactNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.contactNameTV = textView;
        }

        @NotNull
        public final TextView getContactRelationshipTV() {
            TextView textView = this.contactRelationshipTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactRelationshipTV");
            }
            return textView;
        }

        public final void setContactRelationshipTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.contactRelationshipTV = textView;
        }

        public final void bindData(@NotNull Contact contact) {
            Intrinsics.checkParameterIsNotNull(contact, "contact");
            TextView textView = this.contactNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactNameTV");
            }
            textView.setText(StringUtils.Companion.getFullName(contact));
            textView = this.contactRelationshipTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactRelationshipTV");
            }
            textView.setText(StringUtils.Companion.checkForNA(contact.getRelationshipToStudentDescription()));
            this.itemView.setOnClickListener(new ContactsAdapter$ContactHolder$bindData$1(this, contact));
        }
    }

    public final class ContactHolder_ViewBinding implements Unbinder {
        private ContactHolder target;

        @UiThread
        public ContactHolder_ViewBinding(ContactHolder contactHolder, View view) {
            this.target = contactHolder;
            contactHolder.contactNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.contact_name, "field 'contactNameTV'", TextView.class);
            contactHolder.contactRelationshipTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.contact_relationship, "field 'contactRelationshipTV'", TextView.class);
        }

        public void unbind() {
            ContactHolder contactHolder = this.target;
            if (contactHolder != null) {
                this.target = null;
                contactHolder.contactNameTV = null;
                contactHolder.contactRelationshipTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public ContactsAdapter(@NotNull ContactsListener contactsListener) {
        Intrinsics.checkParameterIsNotNull(contactsListener, CastExtraArgs.LISTENER);
        this.listener = contactsListener;
    }

    @NotNull
    public final ContactsListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<Contact> getContacts() {
        return this.contacts;
    }

    public int getItemCount() {
        return this.contacts.size();
    }

    public void onBindViewHolder(@Nullable ContactHolder contactHolder, int i) {
        if (contactHolder != null) {
            contactHolder.bindData((Contact) this.contacts.get(i));
        }
    }

    @NotNull
    public ContactHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_contact, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new ContactHolder(this, viewGroup);
    }

    public final void updateContacts(@Nullable List<Contact> list) {
        this.contacts.clear();
        List list2 = this.contacts;
        if (list == null) {
            list = new ArrayList();
        }
        list2.addAll(list);
        notifyDataSetChanged();
    }
}
