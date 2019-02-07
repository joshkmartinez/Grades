package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.DemographicsAdapter;
import com.aeries.mobileportal.adapters.DemographicsAdapter.DemographicsListener;
import com.aeries.mobileportal.dagger.components.DemographicsFragmentComponent;
import com.aeries.mobileportal.models.Demographics;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J(\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\u0012\u0010+\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010/\u001a\u00020\u001bH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DemographicsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter$DemographicsListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/DemographicsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/DemographicsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/DemographicsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/DemographicsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "demographicsRV", "Landroid/support/v7/widget/RecyclerView;", "getDemographicsRV", "()Landroid/support/v7/widget/RecyclerView;", "setDemographicsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "mDemographics", "Lcom/aeries/mobileportal/models/Demographics;", "mListener", "Lcom/aeries/mobileportal/views/fragments/DemographicsFragment$DemographicsFragmentListener;", "onAddressSelected", "", "address", "", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onEmailSelected", "email", "onPhoneSelected", "phone", "setupViews", "Companion", "DemographicsFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: DemographicsFragment.kt */
public final class DemographicsFragment extends Fragment implements DemographicsListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DemographicsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/DemographicsFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String DEMOGRAPHICS = "DEMOGRAPHICS";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public DemographicsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new DemographicsFragment$component$2(this));
    @NotNull
    @BindView(2131361916)
    public RecyclerView demographicsRV;
    private Demographics mDemographics;
    private DemographicsFragmentListener mListener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DemographicsFragment$Companion;", "", "()V", "DEMOGRAPHICS", "", "getDEMOGRAPHICS", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/DemographicsFragment;", "demographics", "Lcom/aeries/mobileportal/models/Demographics;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getDEMOGRAPHICS() {
            return DemographicsFragment.DEMOGRAPHICS;
        }

        @NotNull
        public final DemographicsFragment newInstance(@NotNull Demographics demographics) {
            Intrinsics.checkParameterIsNotNull(demographics, "demographics");
            DemographicsFragment demographicsFragment = new DemographicsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(getDEMOGRAPHICS(), demographics);
            demographicsFragment.setArguments(bundle);
            return demographicsFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/DemographicsFragment$DemographicsFragmentListener;", "", "onAddressPressed", "", "address", "", "onEmailSelected", "email", "onPhoneSelected", "phone", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: DemographicsFragment.kt */
    public interface DemographicsFragmentListener {
        void onAddressPressed(@Nullable String str);

        void onEmailSelected(@Nullable String str);

        void onPhoneSelected(@Nullable String str);
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
    public final DemographicsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (DemographicsFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getDemographicsRV() {
        RecyclerView recyclerView = this.demographicsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demographicsRV");
        }
        return recyclerView;
    }

    public final void setDemographicsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.demographicsRV = recyclerView;
    }

    @NotNull
    public final DemographicsAdapter getAdapter() {
        DemographicsAdapter demographicsAdapter = this.adapter;
        if (demographicsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return demographicsAdapter;
    }

    public final void setAdapter(@NotNull DemographicsAdapter demographicsAdapter) {
        Intrinsics.checkParameterIsNotNull(demographicsAdapter, "<set-?>");
        this.adapter = demographicsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mDemographics = (Demographics) getArguments().getParcelable(DEMOGRAPHICS);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_demographics, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.demographicsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demographicsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.demographicsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("demographicsRV");
        }
        DemographicsAdapter demographicsAdapter = this.adapter;
        if (demographicsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(demographicsAdapter);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof DemographicsFragmentListener) {
            this.mListener = (DemographicsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement DemographicsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (DemographicsFragmentListener) null;
    }

    public void onAddressSelected(@Nullable String str) {
        DemographicsFragmentListener demographicsFragmentListener = this.mListener;
        if (demographicsFragmentListener != null) {
            demographicsFragmentListener.onAddressPressed(str);
        }
    }

    public void onEmailSelected(@Nullable String str) {
        DemographicsFragmentListener demographicsFragmentListener = this.mListener;
        if (demographicsFragmentListener != null) {
            demographicsFragmentListener.onEmailSelected(str);
        }
    }

    public void onPhoneSelected(@Nullable String str) {
        DemographicsFragmentListener demographicsFragmentListener = this.mListener;
        if (demographicsFragmentListener != null) {
            demographicsFragmentListener.onPhoneSelected(str);
        }
    }
}
