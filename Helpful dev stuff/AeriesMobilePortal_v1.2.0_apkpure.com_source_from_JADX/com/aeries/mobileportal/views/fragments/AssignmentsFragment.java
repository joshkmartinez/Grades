package com.aeries.mobileportal.views.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.AutoTransition;
import android.support.transition.Transition.TransitionListener;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.AssignmentsAdapter;
import com.aeries.mobileportal.adapters.AssignmentsAdapter.AssignmentListener;
import com.aeries.mobileportal.dagger.components.AssignmentsFragmentComponent;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.presenters.AssignmentsPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.activities.GradesActivity;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentsViewModel;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 }2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003{|}B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00190OH\u0002J\u000e\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00190OH\u0002J\b\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\u0010\u0010W\u001a\u00020T2\u0006\u0010X\u001a\u00020YH\u0016J\u0012\u0010Z\u001a\u00020T2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020TH\u0016J\u0012\u0010]\u001a\u00020T2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J \u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020R2\u0006\u0010e\u001a\u00020cH\u0016J(\u0010f\u001a\u0004\u0018\u00010\f2\b\u0010g\u001a\u0004\u0018\u00010h2\b\u0010i\u001a\u0004\u0018\u00010j2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\b\u0010k\u001a\u00020TH\u0016J\u0018\u0010l\u001a\u00020T2\u0006\u0010U\u001a\u00020V2\u0006\u0010m\u001a\u00020RH\u0016J\b\u0010n\u001a\u00020TH\u0016J\b\u0010o\u001a\u00020TH\u0007J\b\u0010p\u001a\u00020TH\u0002J\u0010\u0010q\u001a\u00020T2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010r\u001a\u00020TH\u0002J\b\u0010s\u001a\u00020TH\u0002J\b\u0010t\u001a\u00020TH\u0002J\b\u0010u\u001a\u00020TH\u0016J\u0018\u0010v\u001a\u00020T2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010OH\u0016J\u0010\u0010w\u001a\u00020T2\u0006\u0010x\u001a\u00020yH\u0016J\u0016\u0010z\u001a\u00020T2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190OH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8FX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u001e\u00105\u001a\u0002068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020C8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010H\u001a\u00020I8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006~"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter$AssignmentListener;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentsViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/AssignmentsAdapter;)V", "addWhatIfHolder", "Landroid/view/View;", "getAddWhatIfHolder", "()Landroid/view/View;", "setAddWhatIfHolder", "(Landroid/view/View;)V", "assignmentRV", "Landroid/support/v7/widget/RecyclerView;", "getAssignmentRV", "()Landroid/support/v7/widget/RecyclerView;", "setAssignmentRV", "(Landroid/support/v7/widget/RecyclerView;)V", "assignments", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "categoriesSpinner", "Landroid/widget/Spinner;", "getCategoriesSpinner", "()Landroid/widget/Spinner;", "setCategoriesSpinner", "(Landroid/widget/Spinner;)V", "component", "Lcom/aeries/mobileportal/dagger/components/AssignmentsFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AssignmentsFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "editModeConstraintSet", "Landroid/support/constraint/ConstraintSet;", "mCategory", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "mGradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "mGradesViewModel", "Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentListener;", "mParentListener", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentParentListener;", "noAssignmentsView", "getNoAssignmentsView", "setNoAssignmentsView", "noDataTV", "Landroid/widget/TextView;", "getNoDataTV", "()Landroid/widget/TextView;", "setNoDataTV", "(Landroid/widget/TextView;)V", "normalConstraintSet", "presenter", "Lcom/aeries/mobileportal/presenters/AssignmentsPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/AssignmentsPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/AssignmentsPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "screen", "Landroid/support/constraint/ConstraintLayout;", "getScreen", "()Landroid/support/constraint/ConstraintLayout;", "setScreen", "(Landroid/support/constraint/ConstraintLayout;)V", "filterAssignmentsByCategories", "", "getAssignments", "isEditModeEnabled", "", "onAssignmentMocked", "", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "onAssignmentSelected", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onRemoveMockAssignment", "isMocked", "onStop", "openWhatIfDialog", "setConstraints", "setEditMode", "setupAssignmentList", "setupSpinner", "setupViews", "showAssignmentDisabledMessage", "showAssignments", "showError", "e", "", "updateAssignmentList", "AssignmentsFragmentListener", "AssignmentsFragmentParentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentsFragment.kt */
public final class AssignmentsFragment extends Fragment implements AssignmentListener, AssignmentsViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AssignmentsFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AssignmentsFragmentComponent;"))};
    private static final String CATEGORY = "param1";
    public static final Companion Companion = new Companion();
    private static final String GRADEBOOK = "param2";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public AssignmentsAdapter adapter;
    @NotNull
    @BindView(2131361823)
    public View addWhatIfHolder;
    @NotNull
    @BindView(2131361839)
    public RecyclerView assignmentRV;
    private final List<AssignmentRowViewModel> assignments = new ArrayList();
    @NotNull
    @BindView(2131361861)
    public Spinner categoriesSpinner;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new AssignmentsFragment$component$2(this));
    private final ConstraintSet editModeConstraintSet = new ConstraintSet();
    private AssignmentCategory mCategory;
    private Gradebook mGradebook;
    private GradesViewModel mGradesViewModel;
    private AssignmentsFragmentListener mListener;
    private AssignmentsFragmentParentListener mParentListener;
    @NotNull
    @BindView(2131362060)
    public View noAssignmentsView;
    @NotNull
    @BindView(2131362063)
    public TextView noDataTV;
    private final ConstraintSet normalConstraintSet = new ConstraintSet();
    @Inject
    @NotNull
    public AssignmentsPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @NotNull
    @BindView(2131362126)
    public ConstraintLayout screen;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J'\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentListener;", "", "onAssignmentMocked", "", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "gradebookNumber", "", "termCode", "onAssignmentSelected", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onRemoveMockAssignment", "", "(Lcom/aeries/mobileportal/models/MockAssignment;Ljava/lang/Integer;Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentsFragment.kt */
    public interface AssignmentsFragmentListener {
        void onAssignmentMocked(@NotNull MockAssignment mockAssignment, @NotNull String str, @NotNull String str2);

        void onAssignmentSelected(@NotNull Assignment assignment);

        void onRemoveMockAssignment(@NotNull MockAssignment mockAssignment, @Nullable Integer num, @NotNull String str);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentParentListener;", "", "getAssignments", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentsFragment.kt */
    public interface AssignmentsFragmentParentListener {
        @Nullable
        List<AssignmentRowViewModel> getAssignments();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$Companion;", "", "()V", "CATEGORY", "", "GRADEBOOK", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "category", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AssignmentsFragment newInstance(@Nullable Gradebook gradebook) {
            AssignmentsFragment assignmentsFragment = new AssignmentsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AssignmentsFragment.GRADEBOOK, gradebook);
            assignmentsFragment.setArguments(bundle);
            return assignmentsFragment;
        }

        @NotNull
        public final AssignmentsFragment newInstance(@Nullable Gradebook gradebook, @NotNull AssignmentCategory assignmentCategory) {
            Intrinsics.checkParameterIsNotNull(assignmentCategory, "category");
            AssignmentsFragment assignmentsFragment = new AssignmentsFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AssignmentsFragment.GRADEBOOK, gradebook);
            bundle.putParcelable(AssignmentsFragment.CATEGORY, assignmentCategory);
            assignmentsFragment.setArguments(bundle);
            return assignmentsFragment;
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
    public final AssignmentsFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AssignmentsFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final ConstraintLayout getScreen() {
        ConstraintLayout constraintLayout = this.screen;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        return constraintLayout;
    }

    public final void setScreen(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.screen = constraintLayout;
    }

    @NotNull
    public final Spinner getCategoriesSpinner() {
        Spinner spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        return spinner;
    }

    public final void setCategoriesSpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.categoriesSpinner = spinner;
    }

    @NotNull
    public final View getAddWhatIfHolder() {
        View view = this.addWhatIfHolder;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWhatIfHolder");
        }
        return view;
    }

    public final void setAddWhatIfHolder(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.addWhatIfHolder = view;
    }

    @NotNull
    public final RecyclerView getAssignmentRV() {
        RecyclerView recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        return recyclerView;
    }

    public final void setAssignmentRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.assignmentRV = recyclerView;
    }

    @NotNull
    public final TextView getNoDataTV() {
        TextView textView = this.noDataTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noDataTV");
        }
        return textView;
    }

    public final void setNoDataTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.noDataTV = textView;
    }

    @NotNull
    public final ProgressBar getProgressBar() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return progressBar;
    }

    public final void setProgressBar(@NotNull ProgressBar progressBar) {
        Intrinsics.checkParameterIsNotNull(progressBar, "<set-?>");
        this.progressBar = progressBar;
    }

    @NotNull
    public final View getNoAssignmentsView() {
        View view = this.noAssignmentsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAssignmentsView");
        }
        return view;
    }

    public final void setNoAssignmentsView(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "<set-?>");
        this.noAssignmentsView = view;
    }

    @NotNull
    public final AssignmentsAdapter getAdapter() {
        AssignmentsAdapter assignmentsAdapter = this.adapter;
        if (assignmentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return assignmentsAdapter;
    }

    public final void setAdapter(@NotNull AssignmentsAdapter assignmentsAdapter) {
        Intrinsics.checkParameterIsNotNull(assignmentsAdapter, "<set-?>");
        this.adapter = assignmentsAdapter;
    }

    @NotNull
    public final AssignmentsPresenter getPresenter() {
        AssignmentsPresenter assignmentsPresenter = this.presenter;
        if (assignmentsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return assignmentsPresenter;
    }

    public final void setPresenter(@NotNull AssignmentsPresenter assignmentsPresenter) {
        Intrinsics.checkParameterIsNotNull(assignmentsPresenter, "<set-?>");
        this.presenter = assignmentsPresenter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mGradebook = (Gradebook) getArguments().getParcelable(GRADEBOOK);
            this.mCategory = (AssignmentCategory) getArguments().getParcelable(CATEGORY);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_assignments, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        viewGroup = new AssignmentsFragment$onCreateView$whatIfBR$1(this);
        bundle = new AssignmentsFragment$onCreateView$mockedAssignmentBR$1(this);
        IntentFilter intentFilter = new IntentFilter(AssignmentParentFragment.Companion.getASSIGNMENT_LIST_MODIFIED());
        IntentFilter intentFilter2 = new IntentFilter(GradesActivity.Companion.getMOCK_ASSIGNMENT_ADDED());
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getContext());
        instance.registerReceiver((BroadcastReceiver) viewGroup, intentFilter);
        instance.registerReceiver((BroadcastReceiver) bundle, intentFilter2);
        return inflate;
    }

    @NotNull
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (i2 == 0) {
            i = super.onCreateAnimation(i, z, i2);
            Intrinsics.checkExpressionValueIsNotNull(i, "super.onCreateAnimation(transit, enter, nextAnim)");
            return i;
        }
        i = AnimationUtils.loadAnimation(getContext(), i2);
        i.setAnimationListener((AnimationListener) new AssignmentsFragment$onCreateAnimation$1(this));
        Intrinsics.checkExpressionValueIsNotNull(i, "anim");
        return i;
    }

    private final void setEditMode(boolean z) {
        AssignmentsAdapter assignmentsAdapter = this.adapter;
        if (assignmentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        assignmentsAdapter.setEditModeEnabled(z);
        ConstraintLayout constraintLayout = this.screen;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        ViewGroup viewGroup = constraintLayout;
        TransitionSet transitionSet = new TransitionSet();
        AutoTransition autoTransition = new AutoTransition();
        View view = this.addWhatIfHolder;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addWhatIfHolder");
        }
        transitionSet = transitionSet.addTransition(autoTransition.addTarget(view));
        autoTransition = new AutoTransition();
        RecyclerView recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        TransitionManager.beginDelayedTransition(viewGroup, transitionSet.addTransition(autoTransition.addTarget((View) recyclerView)).addListener((TransitionListener) new AssignmentsFragment$setEditMode$1()));
        constraintLayout = this.screen;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        TransitionManager.beginDelayedTransition(constraintLayout);
        z = z ? this.editModeConstraintSet : this.normalConstraintSet;
        constraintLayout = this.screen;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        z.applyTo(constraintLayout);
    }

    private final void setupViews() {
        List assignments;
        GradesViewModel gradesViewModel;
        boolean z;
        ProgressBar progressBar;
        setupSpinner();
        setConstraints();
        setupAssignmentList();
        List list = this.assignments;
        AssignmentsFragmentParentListener assignmentsFragmentParentListener = this.mParentListener;
        if (assignmentsFragmentParentListener != null) {
            assignments = assignmentsFragmentParentListener.getAssignments();
            if (assignments != null) {
                list.addAll(assignments);
                gradesViewModel = this.mGradesViewModel;
                z = true;
                if (gradesViewModel != null || !gradesViewModel.isEditModeEnabled()) {
                    z = false;
                }
                setEditMode(z);
                progressBar = this.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                }
                progressBar.setVisibility(8);
            }
        }
        assignments = CollectionsKt.emptyList();
        list.addAll(assignments);
        gradesViewModel = this.mGradesViewModel;
        z = true;
        if (gradesViewModel != null) {
        }
        z = false;
        setEditMode(z);
        progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
    }

    private final void setConstraints() {
        ConstraintSet constraintSet = this.normalConstraintSet;
        ConstraintLayout constraintLayout = this.screen;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        constraintSet.clone(constraintLayout);
        this.normalConstraintSet.setVisibility(C0316R.id.progress_bar, 8);
        constraintSet = this.editModeConstraintSet;
        ConstraintLayout constraintLayout2 = this.screen;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screen");
        }
        constraintSet.clone(constraintLayout2);
        constraintSet = this.editModeConstraintSet;
        constraintSet.setVisibility(C0316R.id.add_what_if, 0);
        constraintSet.setVisibility(C0316R.id.progress_bar, 8);
    }

    private final void updateAssignmentList(List<AssignmentRowViewModel> list) {
        AssignmentsAdapter assignmentsAdapter = this.adapter;
        if (assignmentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        assignmentsAdapter.update(list);
        View view = this.noAssignmentsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAssignmentsView");
        }
        view.setVisibility(list.isEmpty() != null ? null : 8);
    }

    private final void setupAssignmentList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        recyclerView.setHasFixedSize(true);
        recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        recyclerView.setItemViewCacheSize(20);
        recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        recyclerView.setDrawingCacheQuality(1048576);
        recyclerView = this.assignmentRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = this.assignmentRV;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
        }
        AssignmentsAdapter assignmentsAdapter = this.adapter;
        if (assignmentsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(assignmentsAdapter);
        this.assignments.addAll(getAssignments());
        updateAssignmentList(this.assignments);
    }

    private final void setupSpinner() {
        Spinner spinner;
        if (this.mCategory == null) {
            spinner = this.categoriesSpinner;
            if (spinner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
            }
            spinner.setVisibility(8);
            return;
        }
        AssignmentCategory assignmentCategory;
        List list;
        ArrayAdapter arrayAdapter;
        Spinner spinner2;
        Gradebook gradebook;
        RealmList categories;
        Gradebook gradebook2;
        RealmList<Object> categories2;
        Object name;
        Object obj;
        int indexOf;
        Context context = getContext();
        Gradebook gradebook3 = this.mGradebook;
        if (gradebook3 != null) {
            RealmList categories3 = gradebook3.getCategories();
            if (categories3 != null) {
                Iterable<AssignmentCategory> iterable = categories3;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (AssignmentCategory assignmentCategory2 : iterable) {
                    arrayList.add(assignmentCategory2.getName());
                }
                list = (List) arrayList;
                arrayAdapter = new ArrayAdapter(context, 17367048, list);
                arrayAdapter.setDropDownViewResource(17367049);
                spinner2 = this.categoriesSpinner;
                if (spinner2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                }
                spinner2.setAdapter(arrayAdapter);
                spinner = this.categoriesSpinner;
                if (spinner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                }
                gradebook = this.mGradebook;
                if (gradebook != null) {
                    categories = gradebook.getCategories();
                    if (categories != null) {
                        gradebook2 = this.mGradebook;
                        if (gradebook2 != null) {
                            categories2 = gradebook2.getCategories();
                            if (categories2 != null) {
                                for (Object obj2 : categories2) {
                                    name = obj2.getName();
                                    assignmentCategory2 = this.mCategory;
                                    if (Intrinsics.areEqual(name, assignmentCategory2 == null ? assignmentCategory2.getName() : null)) {
                                        indexOf = categories.indexOf(obj2);
                                        spinner.setSelection(indexOf);
                                        spinner = this.categoriesSpinner;
                                        if (spinner == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                                        }
                                        spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        obj2 = null;
                        indexOf = categories.indexOf(obj2);
                        spinner.setSelection(indexOf);
                        spinner = this.categoriesSpinner;
                        if (spinner == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                        }
                        spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
                    }
                }
                indexOf = 0;
                spinner.setSelection(indexOf);
                spinner = this.categoriesSpinner;
                if (spinner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                }
                spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
            }
        }
        list = null;
        arrayAdapter = new ArrayAdapter(context, 17367048, list);
        arrayAdapter.setDropDownViewResource(17367049);
        spinner2 = this.categoriesSpinner;
        if (spinner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        spinner2.setAdapter(arrayAdapter);
        spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        gradebook = this.mGradebook;
        if (gradebook != null) {
            categories = gradebook.getCategories();
            if (categories != null) {
                gradebook2 = this.mGradebook;
                if (gradebook2 != null) {
                    categories2 = gradebook2.getCategories();
                    if (categories2 != null) {
                        for (Object obj22 : categories2) {
                            name = obj22.getName();
                            assignmentCategory2 = this.mCategory;
                            if (assignmentCategory2 == null) {
                            }
                            if (Intrinsics.areEqual(name, assignmentCategory2 == null ? assignmentCategory2.getName() : null)) {
                                indexOf = categories.indexOf(obj22);
                                spinner.setSelection(indexOf);
                                spinner = this.categoriesSpinner;
                                if (spinner == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                                }
                                spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                obj22 = null;
                indexOf = categories.indexOf(obj22);
                spinner.setSelection(indexOf);
                spinner = this.categoriesSpinner;
                if (spinner == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
                }
                spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
            }
        }
        indexOf = 0;
        spinner.setSelection(indexOf);
        spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        spinner.setOnItemSelectedListener(new AssignmentsFragment$setupSpinner$2(this));
    }

    private final List<AssignmentRowViewModel> getAssignments() {
        Spinner spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        if (spinner.getCount() != 0) {
            return filterAssignmentsByCategories();
        }
        AssignmentsFragmentParentListener assignmentsFragmentParentListener = this.mParentListener;
        if (assignmentsFragmentParentListener != null) {
            List<AssignmentRowViewModel> assignments = assignmentsFragmentParentListener.getAssignments();
            if (assignments != null) {
                return assignments;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final List<AssignmentRowViewModel> filterAssignmentsByCategories() {
        AssignmentsFragmentParentListener assignmentsFragmentParentListener = this.mParentListener;
        List<AssignmentRowViewModel> list = null;
        List assignments = assignmentsFragmentParentListener != null ? assignmentsFragmentParentListener.getAssignments() : null;
        Spinner spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        Object obj = spinner.getSelectedItem().toString();
        if (Intrinsics.areEqual(obj, (Object) "Overall")) {
            if (assignments != null) {
                list = CollectionsKt.toMutableList(assignments);
            }
        } else if (assignments != null) {
            Collection arrayList = new ArrayList();
            for (Object next : assignments) {
                if (Intrinsics.areEqual(((AssignmentRowViewModel) next).getAssignment().getCategory(), obj)) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    @OnClick({2131361823})
    public final void openWhatIfDialog() {
        com.aeries.mobileportal.views.fragments.AddWhatIfAssignmentFragment.Companion companion = AddWhatIfAssignmentFragment.Companion;
        Gradebook gradebook = this.mGradebook;
        if (gradebook == null) {
            Intrinsics.throwNpe();
        }
        Spinner spinner = this.categoriesSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesSpinner");
        }
        companion.newInstance(gradebook, spinner.getSelectedItemPosition()).show(getChildFragmentManager().beginTransaction(), null);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        StringBuilder stringBuilder;
        if (context instanceof AssignmentsFragmentListener) {
            this.mListener = (AssignmentsFragmentListener) context;
            if (context instanceof GradesViewModel) {
                this.mGradesViewModel = (GradesViewModel) context;
                if (getParentFragment() instanceof AssignmentsFragmentParentListener) {
                    context = getParentFragment();
                    if (context != null) {
                        this.mParentListener = (AssignmentsFragmentParentListener) context;
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.fragments.AssignmentsFragment.AssignmentsFragmentParentListener");
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(context.toString());
                stringBuilder.append(" must implement GradesViewModel");
                throw new RuntimeException(stringBuilder.toString());
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString());
            stringBuilder.append(" must implement GradesViewModel");
            throw new RuntimeException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AssignmentsFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onStop() {
        super.onStop();
        AssignmentsPresenter assignmentsPresenter = this.presenter;
        if (assignmentsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        assignmentsPresenter.cancelNetworkCalls();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AssignmentsFragmentListener) null;
    }

    public void onAssignmentSelected(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        AssignmentsFragmentListener assignmentsFragmentListener = this.mListener;
        if (assignmentsFragmentListener != null) {
            Gradebook gradebook = this.mGradebook;
            assignment.setGradebookName(gradebook != null ? gradebook.getGradebookName() : null);
            assignmentsFragmentListener.onAssignmentSelected(assignment);
        }
    }

    public void onAssignmentMocked(@NotNull MockAssignment mockAssignment) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        AssignmentsFragmentListener assignmentsFragmentListener = this.mListener;
        if (assignmentsFragmentListener != null) {
            String termCode;
            Gradebook gradebook = this.mGradebook;
            String valueOf = String.valueOf(gradebook != null ? gradebook.getGradebookNumber() : null);
            Gradebook gradebook2 = this.mGradebook;
            if (gradebook2 != null) {
                termCode = gradebook2.getTermCode();
                if (termCode != null) {
                    assignmentsFragmentListener.onAssignmentMocked(mockAssignment, valueOf, termCode);
                }
            }
            termCode = "";
            assignmentsFragmentListener.onAssignmentMocked(mockAssignment, valueOf, termCode);
        }
    }

    public void showAssignments(@Nullable List<? extends Assignment> list) {
        List list2;
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(8);
        if (list != null) {
            Iterable<Assignment> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Assignment assignmentRowViewModel : iterable) {
                arrayList.add(new AssignmentRowViewModel(assignmentRowViewModel, false, false, false, false, false, false, 126, null));
            }
            list2 = (List) arrayList;
        } else {
            list2 = CollectionsKt.emptyList();
        }
        updateAssignmentList(list2);
        if (list == null || list.isEmpty() != null) {
            list = this.noDataTV;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noDataTV");
            }
            list.setVisibility(0);
            list = this.assignmentRV;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentRV");
            }
            list.setVisibility(8);
        }
    }

    public void showAssignmentDisabledMessage() {
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getDialogBuilder(context, getContext().getString(C0316R.string.assignment_disabled_title), getContext().getString(C0316R.string.assignment_disabled)).setButton((int) C0316R.string.got_it, null).show();
    }

    public void onRemoveMockAssignment(@NotNull MockAssignment mockAssignment, boolean z) {
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        if (z) {
            z = this.mParentListener;
            if (z) {
                z = z.getAssignments();
                if (z) {
                    CollectionsKt.removeAll(z, new AssignmentsFragment$onRemoveMockAssignment$1(mockAssignment));
                }
            }
            updateAssignmentList(getAssignments());
        }
        z = this.mListener;
        if (z) {
            String termCode;
            Gradebook gradebook = this.mGradebook;
            Integer gradebookNumber = gradebook != null ? gradebook.getGradebookNumber() : null;
            Gradebook gradebook2 = this.mGradebook;
            if (gradebook2 != null) {
                termCode = gradebook2.getTermCode();
                if (termCode != null) {
                    z.onRemoveMockAssignment(mockAssignment, gradebookNumber, termCode);
                }
            }
            termCode = "";
            z.onRemoveMockAssignment(mockAssignment, gradebookNumber, termCode);
        }
    }

    public boolean isEditModeEnabled() {
        GradesViewModel gradesViewModel = this.mGradesViewModel;
        return gradesViewModel != null && gradesViewModel.isEditModeEnabled();
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, th.getMessage()).setButton((int) C0316R.string.yes, (Function0) new AssignmentsFragment$showError$1(this)).setOnCancelListener(new AssignmentsFragment$showError$2(this)).show();
    }
}
