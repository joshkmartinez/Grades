package com.aeries.mobileportal.views.fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
import com.aeries.mobileportal.adapters.PeriodsAdapter;
import com.aeries.mobileportal.dagger.components.AttendanceDetailFragmentComponent;
import com.aeries.mobileportal.models.AttendanceDetail;
import com.aeries.mobileportal.utils.DateUtils;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 :2\u00020\u0001:\u00029:B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020&H\u0007J\u0012\u0010-\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010.\u001a\u00020/2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J(\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00106\u001a\u00020&H\u0016J\b\u00107\u001a\u00020&H\u0016J\b\u00108\u001a\u00020&H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006;"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment;", "Landroid/support/v4/app/DialogFragment;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/PeriodsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/PeriodsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/PeriodsAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/AttendanceDetailFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AttendanceDetailFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "dateTV", "Landroid/widget/TextView;", "getDateTV", "()Landroid/widget/TextView;", "setDateTV", "(Landroid/widget/TextView;)V", "doneButton", "Landroid/widget/Button;", "getDoneButton", "()Landroid/widget/Button;", "setDoneButton", "(Landroid/widget/Button;)V", "mDetail", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment$AttendanceDetailFragmentListener;", "periodRV", "Landroid/support/v7/widget/RecyclerView;", "getPeriodRV", "()Landroid/support/v7/widget/RecyclerView;", "setPeriodRV", "(Landroid/support/v7/widget/RecyclerView;)V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "setupViews", "AttendanceDetailFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AttendanceDetailFragment.kt */
public final class AttendanceDetailFragment extends DialogFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AttendanceDetailFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AttendanceDetailFragmentComponent;"))};
    private static final String ATTENDANCE_DETAIL = "param1";
    public static final Companion Companion = new Companion();
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public PeriodsAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AttendanceDetailFragment$component$2(this));
    @NotNull
    @BindView(2131361909)
    public TextView dateTV;
    @NotNull
    @BindView(2131361937)
    public Button doneButton;
    private AttendanceDetail mDetail;
    private AttendanceDetailFragmentListener mListener;
    @NotNull
    @BindView(2131362095)
    public RecyclerView periodRV;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment$AttendanceDetailFragmentListener;", "", "onDetailSelected", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceDetailFragment.kt */
    public interface AttendanceDetailFragmentListener {
        void onDetailSelected();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment$Companion;", "", "()V", "ATTENDANCE_DETAIL", "", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AttendanceDetailFragment;", "attendanceDetail", "Lcom/aeries/mobileportal/models/AttendanceDetail;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AttendanceDetailFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttendanceDetailFragment newInstance(@NotNull AttendanceDetail attendanceDetail) {
            Intrinsics.checkParameterIsNotNull(attendanceDetail, "attendanceDetail");
            AttendanceDetailFragment attendanceDetailFragment = new AttendanceDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AttendanceDetailFragment.ATTENDANCE_DETAIL, attendanceDetail);
            attendanceDetailFragment.setArguments(bundle);
            return attendanceDetailFragment;
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
    public final AttendanceDetailFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AttendanceDetailFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final TextView getDateTV() {
        TextView textView = this.dateTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTV");
        }
        return textView;
    }

    public final void setDateTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.dateTV = textView;
    }

    @NotNull
    public final Button getDoneButton() {
        Button button = this.doneButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("doneButton");
        }
        return button;
    }

    public final void setDoneButton(@NotNull Button button) {
        Intrinsics.checkParameterIsNotNull(button, "<set-?>");
        this.doneButton = button;
    }

    @NotNull
    public final RecyclerView getPeriodRV() {
        RecyclerView recyclerView = this.periodRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodRV");
        }
        return recyclerView;
    }

    public final void setPeriodRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.periodRV = recyclerView;
    }

    @NotNull
    public final PeriodsAdapter getAdapter() {
        PeriodsAdapter periodsAdapter = this.adapter;
        if (periodsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return periodsAdapter;
    }

    public final void setAdapter(@NotNull PeriodsAdapter periodsAdapter) {
        Intrinsics.checkParameterIsNotNull(periodsAdapter, "<set-?>");
        this.adapter = periodsAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mDetail = (AttendanceDetail) getArguments().getParcelable(ATTENDANCE_DETAIL);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        bundle = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        bundle.getWindow().requestFeature(1);
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_attendance_detail, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setLayout(-1, -1);
        dialog = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(dialog, "dialog");
        dialog.getWindow().setGravity(17);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = getDialog();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        bundle = bundle.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog.window");
        bundle.getAttributes().windowAnimations = C0316R.style.AttendanceDetailAnimation;
    }

    private final void setupViews() {
        com.aeries.mobileportal.utils.DateUtils.Companion companion = DateUtils.Companion;
        AttendanceDetail attendanceDetail = this.mDetail;
        String str = null;
        String dayInMonth = companion.getDayInMonth(attendanceDetail != null ? attendanceDetail.getAttendanceDate() : null);
        Context context = getContext();
        com.aeries.mobileportal.utils.DateUtils.Companion companion2 = DateUtils.Companion;
        AttendanceDetail attendanceDetail2 = this.mDetail;
        if (attendanceDetail2 != null) {
            str = attendanceDetail2.getAttendanceDate();
        }
        String string = context.getString(companion2.getMonth(str));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(dayInMonth);
        dayInMonth = stringBuilder.toString();
        TextView textView = this.dateTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateTV");
        }
        textView.setText(dayInMonth);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.periodRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.periodRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.periodRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("periodRV");
        }
        PeriodsAdapter periodsAdapter = this.adapter;
        if (periodsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(periodsAdapter);
    }

    @OnClick({2131361937})
    public final void onButtonPressed() {
        if (this.mListener != null) {
            AttendanceDetailFragmentListener attendanceDetailFragmentListener = this.mListener;
            if (attendanceDetailFragmentListener == null) {
                Intrinsics.throwNpe();
            }
            attendanceDetailFragmentListener.onDetailSelected();
        }
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AttendanceDetailFragmentListener) {
            this.mListener = (AttendanceDetailFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AttendanceDetailFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AttendanceDetailFragmentListener) null;
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        bundle = super.onCreateDialog(bundle);
        bundle.requestWindowFeature(1);
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        return bundle;
    }
}
