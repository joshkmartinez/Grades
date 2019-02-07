package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.ContactsAdapter;
import com.aeries.mobileportal.adapters.ContactsAdapter.ContactsListener;
import com.aeries.mobileportal.dagger.components.ContactListFragmentComponent;
import com.aeries.mobileportal.models.Contact;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 22\u00020\u00012\u00020\u0002:\u000223B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J(\u0010(\u001a\u0004\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010-\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020\u001fH\u0002J\u0014\u0010/\u001a\u00020\u001f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020$01R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactListFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/ContactsAdapter$ContactsListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/ContactsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/ContactsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/ContactsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/ContactListFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/ContactListFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "contactsRV", "Landroid/support/v7/widget/RecyclerView;", "getContactsRV", "()Landroid/support/v7/widget/RecyclerView;", "setContactsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "mListener", "Lcom/aeries/mobileportal/views/fragments/ContactListFragment$ContactListFragmentListener;", "noContactsView", "Landroid/view/View;", "getNoContactsView", "()Landroid/view/View;", "setNoContactsView", "(Landroid/view/View;)V", "onAttach", "", "context", "Landroid/content/Context;", "onContactSelected", "contact", "Lcom/aeries/mobileportal/models/Contact;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setupViews", "updateContacts", "contacts", "", "Companion", "ContactListFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: ContactListFragment.kt */
public final class ContactListFragment extends Fragment implements ContactsListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ContactListFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/ContactListFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public ContactsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new ContactListFragment$component$2(this));
    @NotNull
    @BindView(2131361889)
    public RecyclerView contactsRV;
    private ContactListFragmentListener mListener;
    @NotNull
    @BindView(2131362061)
    public View noContactsView;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactListFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/ContactListFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ContactListFragment newInstance() {
            ContactListFragment contactListFragment = new ContactListFragment();
            contactListFragment.setArguments(new Bundle());
            return contactListFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/ContactListFragment$ContactListFragmentListener;", "", "onContactSelected", "", "contact", "Lcom/aeries/mobileportal/models/Contact;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: ContactListFragment.kt */
    public interface ContactListFragmentListener {
        void onContactSelected(@NotNull Contact contact);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    @NotNull
    public final ContactListFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (ContactListFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getContactsRV() {
        RecyclerView recyclerView = this.contactsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsRV");
        }
        return recyclerView;
    }

    public final void setContactsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.contactsRV = recyclerView;
    }

    @NotNull
    public final View getNoContactsView() {
        View view = this.noContactsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noContactsView");
        }
        return view;
    }

    public final void setNoContactsView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.noContactsView = view;
    }

    @NotNull
    public final ContactsAdapter getAdapter() {
        ContactsAdapter contactsAdapter = this.adapter;
        if (contactsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return contactsAdapter;
    }

    public final void setAdapter(@NotNull ContactsAdapter contactsAdapter) {
        Intrinsics.checkParameterIsNotNull(contactsAdapter, "<set-?>");
        this.adapter = contactsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_contact_list, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.contactsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.contactsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsRV");
        }
        ContactsAdapter contactsAdapter = this.adapter;
        if (contactsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(contactsAdapter);
        recyclerView2 = this.contactsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof ContactListFragmentListener) {
            this.mListener = (ContactListFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement ContactListFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (ContactListFragmentListener) null;
    }

    public final void updateContacts(@NotNull List<Contact> list) {
        Intrinsics.checkParameterIsNotNull(list, "contacts");
        ContactsAdapter contactsAdapter = this.adapter;
        if (contactsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        contactsAdapter.updateContacts(list);
        View view = this.noContactsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noContactsView");
        }
        view.setVisibility(list.isEmpty() != null ? null : 8);
    }

    public void onContactSelected(@NotNull Contact contact) {
        Intrinsics.checkParameterIsNotNull(contact, "contact");
        ContactListFragmentListener contactListFragmentListener = this.mListener;
        if (contactListFragmentListener != null) {
            contactListFragmentListener.onContactSelected(contact);
        }
    }
}
