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
import com.aeries.mobileportal.adapters.AttendanceAdapter;
import com.aeries.mobileportal.adapters.AttendanceAdapter.AttendanceListener;
import com.aeries.mobileportal.dagger.components.AttendanceListFragmentComponent;
import com.aeries.mobileportal.models.AttendanceDetail;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 32\u00020\u00012\u00020\u0002:\u000223B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J(\u0010(\u001a\u0004\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010-\u001a\u00020\u001fH\u0016J\b\u0010.\u001a\u00020\u001fH\u0002J\u0014\u0010/\u001a\u00020\u001f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020$01R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u00064"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter$AttendanceListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/AttendanceAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/AttendanceAdapter;)V", "attendanceRV", "Landroid/support/v7/widget/RecyclerView;", "getAttendanceRV", "()Landroid/support/v7/widget/RecyclerView;", "setAttendanceRV", "(Landroid/support/v7/widget/RecyclerView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/AttendanceListFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AttendanceListFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment$AttendanceListFragmentListener;", "noAbsencesView", "Landroid/view/View;", "getNoAbsencesView", "()Landroid/view/View;", "setNoAbsencesView", "(Landroid/view/View;)V", "onAttach", "", "context", "Landroid/content/Context;", "onAttendanceSelected", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "setupViews", "update", "attendances", "", "AttendanceListFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceListFragment.kt */
public final class AttendanceListFragment extends Fragment implements AttendanceListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceListFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AttendanceListFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public AttendanceAdapter adapter;
    @NotNull
    @BindView(2131361844)
    public RecyclerView attendanceRV;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AttendanceListFragment$component$2(this));
    private AttendanceListFragmentListener mListener;
    @NotNull
    @BindView(2131362059)
    public View noAbsencesView;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment$AttendanceListFragmentListener;", "", "onAttendanceSelected", "", "attendance", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceListFragment.kt */
    public interface AttendanceListFragmentListener {
        void onAttendanceSelected(@NotNull AttendanceDetail attendanceDetail);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment$Companion;", "", "()V", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AttendanceListFragment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttendanceListFragment newInstance() {
            AttendanceListFragment attendanceListFragment = new AttendanceListFragment();
            attendanceListFragment.setArguments(new Bundle());
            return attendanceListFragment;
        }
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
    public final AttendanceListFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AttendanceListFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getAttendanceRV() {
        RecyclerView recyclerView = this.attendanceRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attendanceRV");
        }
        return recyclerView;
    }

    public final void setAttendanceRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.attendanceRV = recyclerView;
    }

    @NotNull
    public final View getNoAbsencesView() {
        View view = this.noAbsencesView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAbsencesView");
        }
        return view;
    }

    public final void setNoAbsencesView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.noAbsencesView = view;
    }

    @NotNull
    public final AttendanceAdapter getAdapter() {
        AttendanceAdapter attendanceAdapter = this.adapter;
        if (attendanceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return attendanceAdapter;
    }

    public final void setAdapter(@NotNull AttendanceAdapter attendanceAdapter) {
        Intrinsics.checkParameterIsNotNull(attendanceAdapter, "<set-?>");
        this.adapter = attendanceAdapter;
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
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_attendance_list, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.attendanceRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attendanceRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.attendanceRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attendanceRV");
        }
        AttendanceAdapter attendanceAdapter = this.adapter;
        if (attendanceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(attendanceAdapter);
        recyclerView2 = this.attendanceRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attendanceRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AttendanceListFragmentListener) {
            this.mListener = (AttendanceListFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AttendanceListFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AttendanceListFragmentListener) null;
    }

    public final void update(@NotNull List<AttendanceDetail> list) {
        Intrinsics.checkParameterIsNotNull(list, "attendances");
        AttendanceAdapter attendanceAdapter = this.adapter;
        if (attendanceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        attendanceAdapter.update(list);
        View view = this.noAbsencesView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAbsencesView");
        }
        view.setVisibility(list.isEmpty() != null ? null : 8);
    }

    public void onAttendanceSelected(@NotNull AttendanceDetail attendanceDetail) {
        Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendance");
        AttendanceListFragmentListener attendanceListFragmentListener = this.mListener;
        if (attendanceListFragmentListener != null) {
            attendanceListFragmentListener.onAttendanceSelected(attendanceDetail);
        }
    }
}
