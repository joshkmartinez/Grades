package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.LinkContact;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001e\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u001e\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u001e\u0010\u001c\u001a\u00020\u00152\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/aeries/mobileportal/adapters/LinkContactsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactHolder;", "listener", "Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactListener;", "(Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactListener;)V", "contacts", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/LinkContact;", "Lkotlin/collections/ArrayList;", "getContacts", "()Ljava/util/ArrayList;", "getListener", "()Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactListener;", "selectedItems", "Landroid/util/SparseBooleanArray;", "getSelectedItems", "()Landroid/util/SparseBooleanArray;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "linkContacts", "LinkContactHolder", "LinkContactListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: LinkContactsAdapter.kt */
public final class LinkContactsAdapter extends Adapter<LinkContactHolder> {
    @NotNull
    private final ArrayList<LinkContact> contacts = new ArrayList();
    @NotNull
    private final LinkContactListener listener;
    @NotNull
    private final SparseBooleanArray selectedItems = new SparseBooleanArray();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactListener;", "", "onContactSelected", "", "position", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LinkContactsAdapter.kt */
    public interface LinkContactListener {
        void onContactSelected(int i);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/LinkContactsAdapter;Landroid/view/View;)V", "background", "Landroid/support/constraint/ConstraintLayout;", "getBackground", "()Landroid/support/constraint/ConstraintLayout;", "setBackground", "(Landroid/support/constraint/ConstraintLayout;)V", "contactName", "Landroid/widget/TextView;", "getContactName", "()Landroid/widget/TextView;", "setContactName", "(Landroid/widget/TextView;)V", "contactRelationship", "getContactRelationship", "setContactRelationship", "bindData", "", "linkContact", "Lcom/aeries/mobileportal/models/LinkContact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: LinkContactsAdapter.kt */
    public final class LinkContactHolder extends ViewHolder {
        @NotNull
        @BindView(2131362015)
        public ConstraintLayout background;
        @NotNull
        @BindView(2131361887)
        public TextView contactName;
        @NotNull
        @BindView(2131361888)
        public TextView contactRelationship;
        final /* synthetic */ LinkContactsAdapter this$0;

        public LinkContactHolder(@NotNull LinkContactsAdapter linkContactsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = linkContactsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getContactName() {
            TextView textView = this.contactName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactName");
            }
            return textView;
        }

        public final void setContactName(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.contactName = textView;
        }

        @NotNull
        public final TextView getContactRelationship() {
            TextView textView = this.contactRelationship;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactRelationship");
            }
            return textView;
        }

        public final void setContactRelationship(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.contactRelationship = textView;
        }

        @NotNull
        public final ConstraintLayout getBackground() {
            ConstraintLayout constraintLayout = this.background;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
            }
            return constraintLayout;
        }

        public final void setBackground(@NotNull ConstraintLayout constraintLayout) {
            Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
            this.background = constraintLayout;
        }

        public final void bindData(@NotNull LinkContact linkContact) {
            Intrinsics.checkParameterIsNotNull(linkContact, "linkContact");
            ConstraintLayout constraintLayout = this.background;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("background");
            }
            constraintLayout.setSelected(this.this$0.getSelectedItems().get(getAdapterPosition(), false));
            TextView textView = this.contactName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactName");
            }
            textView.setText(linkContact.getName());
            textView = this.contactRelationship;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contactRelationship");
            }
            textView.setText(linkContact.getRelationship());
            this.itemView.setOnClickListener(new LinkContactsAdapter$LinkContactHolder$bindData$1(this));
        }
    }

    public final class LinkContactHolder_ViewBinding implements Unbinder {
        private LinkContactHolder target;

        @UiThread
        public LinkContactHolder_ViewBinding(LinkContactHolder linkContactHolder, View view) {
            this.target = linkContactHolder;
            linkContactHolder.contactName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.contact_name, "field 'contactName'", TextView.class);
            linkContactHolder.contactRelationship = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.contact_relationship, "field 'contactRelationship'", TextView.class);
            linkContactHolder.background = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.layout_contact, "field 'background'", ConstraintLayout.class);
        }

        public void unbind() {
            LinkContactHolder linkContactHolder = this.target;
            if (linkContactHolder != null) {
                this.target = null;
                linkContactHolder.contactName = null;
                linkContactHolder.contactRelationship = null;
                linkContactHolder.background = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public LinkContactsAdapter(@NotNull LinkContactListener linkContactListener) {
        Intrinsics.checkParameterIsNotNull(linkContactListener, CastExtraArgs.LISTENER);
        this.listener = linkContactListener;
    }

    @NotNull
    public final LinkContactListener getListener() {
        return this.listener;
    }

    @NotNull
    public final ArrayList<LinkContact> getContacts() {
        return this.contacts;
    }

    @NotNull
    public final SparseBooleanArray getSelectedItems() {
        return this.selectedItems;
    }

    public int getItemCount() {
        return this.contacts.size() - 1;
    }

    public void onBindViewHolder(@Nullable LinkContactHolder linkContactHolder, int i) {
        if (linkContactHolder != null) {
            ConstraintLayout background = linkContactHolder.getBackground();
            if (background != null) {
                background.setSelected(this.selectedItems.get(i, false));
            }
        }
        if (linkContactHolder != null) {
            i = this.contacts.get(i);
            Intrinsics.checkExpressionValueIsNotNull(i, "contacts[position]");
            linkContactHolder.bindData((LinkContact) i);
        }
    }

    @NotNull
    public LinkContactHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_contact, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new LinkContactHolder(this, viewGroup);
    }

    public final void update(@NotNull ArrayList<LinkContact> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "linkContacts");
        this.contacts.clear();
        this.contacts.addAll(arrayList);
        notifyDataSetChanged();
    }
}
