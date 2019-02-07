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
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.LinkContactsAdapter;
import com.aeries.mobileportal.adapters.LinkContactsAdapter.LinkContactListener;
import com.aeries.mobileportal.dagger.components.UpdateContactFragmentComponent;
import com.aeries.mobileportal.models.LinkContact;
import java.util.ArrayList;
import java.util.HashMap;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0002>?B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u001dH\u0016J\u0012\u00101\u001a\u00020,2\b\u00102\u001a\u0004\u0018\u000103H\u0016J(\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010:\u001a\u00020,H\u0016J\b\u0010;\u001a\u00020,H\u0007J\b\u0010<\u001a\u00020,H\u0007J\b\u0010=\u001a\u00020,H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006@"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/LinkContactsAdapter$LinkContactListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/LinkContactsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/LinkContactsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/LinkContactsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/UpdateContactFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/UpdateContactFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "guardiansRV", "Landroid/support/v7/widget/RecyclerView;", "getGuardiansRV", "()Landroid/support/v7/widget/RecyclerView;", "setGuardiansRV", "(Landroid/support/v7/widget/RecyclerView;)V", "mContacts", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/LinkContact;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment$UpdateContactFragmentListener;", "mSelectedStudent", "", "Ljava/lang/Integer;", "nextButton", "Landroid/widget/Button;", "getNextButton", "()Landroid/widget/Button;", "setNextButton", "(Landroid/widget/Button;)V", "notMeTextView", "Landroid/widget/TextView;", "getNotMeTextView", "()Landroid/widget/TextView;", "setNotMeTextView", "(Landroid/widget/TextView;)V", "onAttach", "", "context", "Landroid/content/Context;", "onContactSelected", "position", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onNextPressed", "onNotMePressed", "setupViews", "Companion", "UpdateContactFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: UpdateContactFragment.kt */
public final class UpdateContactFragment extends Fragment implements LinkContactListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(UpdateContactFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/UpdateContactFragmentComponent;"))};
    private static final String CONTACTS = "param1";
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public LinkContactsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new UpdateContactFragment$component$2(this));
    @NotNull
    @BindView(2131361981)
    public RecyclerView guardiansRV;
    private ArrayList<LinkContact> mContacts;
    private UpdateContactFragmentListener mListener;
    private Integer mSelectedStudent;
    @NotNull
    @BindView(2131362058)
    public Button nextButton;
    @NotNull
    @BindView(2131362071)
    public TextView notMeTextView;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment$Companion;", "", "()V", "CONTACTS", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment;", "contacts", "Ljava/util/ArrayList;", "Lcom/aeries/mobileportal/models/LinkContact;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UpdateContactFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final UpdateContactFragment newInstance(@NotNull ArrayList<LinkContact> arrayList) {
            Intrinsics.checkParameterIsNotNull(arrayList, "contacts");
            UpdateContactFragment updateContactFragment = new UpdateContactFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(UpdateContactFragment.CONTACTS, arrayList);
            updateContactFragment.setArguments(bundle);
            return updateContactFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/UpdateContactFragment$UpdateContactFragmentListener;", "", "onNextPressed", "", "linkContact", "Lcom/aeries/mobileportal/models/LinkContact;", "onNotMePressed", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: UpdateContactFragment.kt */
    public interface UpdateContactFragmentListener {
        void onNextPressed(@NotNull LinkContact linkContact);

        void onNotMePressed();
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
    public final UpdateContactFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (UpdateContactFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getGuardiansRV() {
        RecyclerView recyclerView = this.guardiansRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardiansRV");
        }
        return recyclerView;
    }

    public final void setGuardiansRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.guardiansRV = recyclerView;
    }

    @NotNull
    public final Button getNextButton() {
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        return button;
    }

    public final void setNextButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.nextButton = button;
    }

    @NotNull
    public final TextView getNotMeTextView() {
        TextView textView = this.notMeTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notMeTextView");
        }
        return textView;
    }

    public final void setNotMeTextView(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.notMeTextView = textView;
    }

    @NotNull
    public final LinkContactsAdapter getAdapter() {
        LinkContactsAdapter linkContactsAdapter = this.adapter;
        if (linkContactsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return linkContactsAdapter;
    }

    public final void setAdapter(@NotNull LinkContactsAdapter linkContactsAdapter) {
        Intrinsics.checkParameterIsNotNull(linkContactsAdapter, "<set-?>");
        this.adapter = linkContactsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mContacts = getArguments().getParcelableArrayList(CONTACTS);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_update_contact, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.guardiansRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardiansRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.guardiansRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardiansRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.guardiansRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guardiansRV");
        }
        LinkContactsAdapter linkContactsAdapter = this.adapter;
        if (linkContactsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(linkContactsAdapter);
        LinkContactsAdapter linkContactsAdapter2 = this.adapter;
        if (linkContactsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        ArrayList arrayList = this.mContacts;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        linkContactsAdapter2.update(arrayList);
    }

    @OnClick({2131362058})
    public final void onNextPressed() {
        ArrayList arrayList = this.mContacts;
        if (arrayList == null) {
            Intrinsics.throwNpe();
        }
        Integer num = this.mSelectedStudent;
        if (num == null) {
            Intrinsics.throwNpe();
        }
        LinkContact linkContact = (LinkContact) arrayList.get(num.intValue());
        if (this.mListener != null) {
            UpdateContactFragmentListener updateContactFragmentListener = this.mListener;
            if (updateContactFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(linkContact, "linkContact");
            updateContactFragmentListener.onNextPressed(linkContact);
        }
    }

    @OnClick({2131362071})
    public final void onNotMePressed() {
        if (this.mListener != null) {
            UpdateContactFragmentListener updateContactFragmentListener = this.mListener;
            if (updateContactFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            updateContactFragmentListener.onNotMePressed();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof UpdateContactFragmentListener) {
            this.mListener = (UpdateContactFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement UpdateContactFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (UpdateContactFragmentListener) null;
    }

    public void onContactSelected(int i) {
        Button button = this.nextButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextButton");
        }
        button.setEnabled(true);
        this.mSelectedStudent = Integer.valueOf(i);
    }
}
