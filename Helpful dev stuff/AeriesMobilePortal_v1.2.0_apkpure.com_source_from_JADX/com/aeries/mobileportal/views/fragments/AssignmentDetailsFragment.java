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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.AssignmentDetailsAdapter;
import com.aeries.mobileportal.dagger.components.AssignmentDetailsFragmentComponent;
import com.aeries.mobileportal.models.Assignment;
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

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020 H\u0007J\u0012\u0010$\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J(\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010/\u001a\u00020 H\u0016J\b\u00100\u001a\u00020 H\u0016J\b\u00101\u001a\u00020 H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment;", "Landroid/support/v4/app/DialogFragment;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;)V", "assignmentDetailsRV", "Landroid/support/v7/widget/RecyclerView;", "getAssignmentDetailsRV", "()Landroid/support/v7/widget/RecyclerView;", "setAssignmentDetailsRV", "(Landroid/support/v7/widget/RecyclerView;)V", "component", "Lcom/aeries/mobileportal/dagger/components/AssignmentDetailsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AssignmentDetailsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "doneButton", "Landroid/widget/Button;", "getDoneButton", "()Landroid/widget/Button;", "setDoneButton", "(Landroid/widget/Button;)V", "mAssignment", "Lcom/aeries/mobileportal/models/Assignment;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment$AssignmentDetailsFragmentListener;", "onAttach", "", "context", "Landroid/content/Context;", "onButtonPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "setupViews", "AssignmentDetailsFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentDetailsFragment.kt */
public final class AssignmentDetailsFragment extends DialogFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AssignmentDetailsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AssignmentDetailsFragmentComponent;"))};
    private static final String ASSIGNMENT = "param1";
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String TAG = "ASSIGNMENT_DETAILS";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public AssignmentDetailsAdapter adapter;
    @NotNull
    @BindView(2131361837)
    public RecyclerView assignmentDetailsRV;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AssignmentDetailsFragment$component$2(this));
    @NotNull
    @BindView(2131361938)
    public Button doneButton;
    private Assignment mAssignment;
    private AssignmentDetailsFragmentListener mListener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment$AssignmentDetailsFragmentListener;", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentDetailsFragment.kt */
    public interface AssignmentDetailsFragmentListener {
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment$Companion;", "", "()V", "ASSIGNMENT", "", "TAG", "getTAG", "()Ljava/lang/String;", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment;", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentDetailsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getTAG() {
            return AssignmentDetailsFragment.TAG;
        }

        @NotNull
        public final AssignmentDetailsFragment newInstance(@NotNull Assignment assignment) {
            Intrinsics.checkParameterIsNotNull(assignment, "assignment");
            AssignmentDetailsFragment assignmentDetailsFragment = new AssignmentDetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AssignmentDetailsFragment.ASSIGNMENT, assignment);
            assignmentDetailsFragment.setArguments(bundle);
            return assignmentDetailsFragment;
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
    public final AssignmentDetailsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AssignmentDetailsFragmentComponent) lazy.getValue();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final AssignmentDetailsAdapter getAdapter() {
        AssignmentDetailsAdapter assignmentDetailsAdapter = this.adapter;
        if (assignmentDetailsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return assignmentDetailsAdapter;
    }

    public final void setAdapter(@NotNull AssignmentDetailsAdapter assignmentDetailsAdapter) {
        Intrinsics.checkParameterIsNotNull(assignmentDetailsAdapter, "<set-?>");
        this.adapter = assignmentDetailsAdapter;
    }

    @NotNull
    public final RecyclerView getAssignmentDetailsRV() {
        RecyclerView recyclerView = this.assignmentDetailsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDetailsRV");
        }
        return recyclerView;
    }

    public final void setAssignmentDetailsRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.assignmentDetailsRV = recyclerView;
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mAssignment = (Assignment) getArguments().getParcelable(ASSIGNMENT);
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
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_assignment_details, viewGroup, false);
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

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        bundle = super.onCreateDialog(bundle);
        bundle.requestWindowFeature(1);
        Intrinsics.checkExpressionValueIsNotNull(bundle, "dialog");
        return bundle;
    }

    private final void setupViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation());
        RecyclerView recyclerView = this.assignmentDetailsRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDetailsRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.assignmentDetailsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDetailsRV");
        }
        recyclerView2.addItemDecoration(dividerItemDecoration);
        recyclerView2 = this.assignmentDetailsRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDetailsRV");
        }
        AssignmentDetailsAdapter assignmentDetailsAdapter = this.adapter;
        if (assignmentDetailsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(assignmentDetailsAdapter);
    }

    @OnClick({2131361938})
    public final void onButtonPressed() {
        dismiss();
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AssignmentDetailsFragmentListener) {
            this.mListener = (AssignmentDetailsFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AssignmentDetailsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AssignmentDetailsFragmentListener) null;
    }
}
