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
import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter;
import com.aeries.mobileportal.adapters.AssignmentCategoriesAdapter.AssignmentCategoriesAdapterListener;
import com.aeries.mobileportal.dagger.components.AssignmentCategoryFragmentComponent;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.presenters.grades.AssignmentCategoryPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentCategoryViewModel;
import io.realm.RealmList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 I2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002HIB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u0002002\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000200H\u0016J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u00010!2\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000200H\u0016J\b\u0010?\u001a\u000200H\u0016J\b\u0010@\u001a\u000200H\u0002J\u0010\u0010A\u001a\u0002002\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010B\u001a\u0002002\u0006\u0010C\u001a\u00020DH\u0016J\u0016\u0010E\u001a\u0002002\f\u0010F\u001a\b\u0012\u0004\u0012\u0002050GH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006J"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentCategoryViewModel;", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;)V", "categoriesRV", "Landroid/support/v7/widget/RecyclerView;", "getCategoriesRV", "()Landroid/support/v7/widget/RecyclerView;", "setCategoriesRV", "(Landroid/support/v7/widget/RecyclerView;)V", "classSummary", "Lcom/aeries/mobileportal/models/ClassSummary;", "component", "Lcom/aeries/mobileportal/dagger/components/AssignmentCategoryFragmentComponent;", "kotlin.jvm.PlatformType", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AssignmentCategoryFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "hideOverall", "", "listener", "Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment$AssignmentCategoryFragmentListener;", "noAssignmentsView", "Landroid/view/View;", "getNoAssignmentsView", "()Landroid/view/View;", "setNoAssignmentsView", "(Landroid/view/View;)V", "presenter", "Lcom/aeries/mobileportal/presenters/grades/AssignmentCategoryPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/grades/AssignmentCategoryPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/grades/AssignmentCategoryPresenter;)V", "hideScores", "isDoingRubric", "isOverallHidden", "onAttach", "", "context", "Landroid/content/Context;", "onCategorySelected", "assignmentCategory", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onResume", "setupViews", "showCategories", "showError", "e", "", "updateAssignmentList", "assignmentCategories", "", "AssignmentCategoryFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategoryFragment.kt */
public final class AssignmentCategoryFragment extends Fragment implements AssignmentCategoryViewModel, AssignmentCategoriesAdapterListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AssignmentCategoryFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AssignmentCategoryFragmentComponent;"))};
    private static final String CLASS_SUMMARY = "param2";
    public static final Companion Companion = new Companion();
    private static final String GRADEBOOK = "param1";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public AssignmentCategoriesAdapter adapter;
    @NotNull
    @BindView(2131361860)
    public RecyclerView categoriesRV;
    private ClassSummary classSummary;
    private final Lazy component$delegate = LazyKt.lazy(new AssignmentCategoryFragment$component$2(this));
    private Gradebook gradebook;
    private boolean hideOverall;
    private AssignmentCategoryFragmentListener listener;
    @NotNull
    @BindView(2131362060)
    public View noAssignmentsView;
    @Inject
    @NotNull
    public AssignmentCategoryPresenter presenter;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment$AssignmentCategoryFragmentListener;", "", "hideScores", "", "onCategorySelected", "", "category", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "showHideWhatIfCheck", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentCategoryFragment.kt */
    public interface AssignmentCategoryFragmentListener {
        boolean hideScores();

        void onCategorySelected(@NotNull AssignmentCategory assignmentCategory, @Nullable Gradebook gradebook);

        boolean showHideWhatIfCheck();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment$Companion;", "", "()V", "CLASS_SUMMARY", "", "GRADEBOOK", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "classSummary", "Lcom/aeries/mobileportal/models/ClassSummary;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentCategoryFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final AssignmentCategoryFragment newInstance(@NotNull Gradebook gradebook, @NotNull ClassSummary classSummary) {
            Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
            Intrinsics.checkParameterIsNotNull(classSummary, "classSummary");
            AssignmentCategoryFragment assignmentCategoryFragment = new AssignmentCategoryFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AssignmentCategoryFragment.GRADEBOOK, gradebook);
            bundle.putParcelable(AssignmentCategoryFragment.CLASS_SUMMARY, classSummary);
            assignmentCategoryFragment.setArguments(bundle);
            return assignmentCategoryFragment;
        }
    }

    private final AssignmentCategoryFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AssignmentCategoryFragmentComponent) lazy.getValue();
    }

    @JvmStatic
    @NotNull
    public static final AssignmentCategoryFragment newInstance(@NotNull Gradebook gradebook, @NotNull ClassSummary classSummary) {
        return Companion.newInstance(gradebook, classSummary);
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

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final RecyclerView getCategoriesRV() {
        RecyclerView recyclerView = this.categoriesRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesRV");
        }
        return recyclerView;
    }

    public final void setCategoriesRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.categoriesRV = recyclerView;
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
    public final AssignmentCategoryPresenter getPresenter() {
        AssignmentCategoryPresenter assignmentCategoryPresenter = this.presenter;
        if (assignmentCategoryPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return assignmentCategoryPresenter;
    }

    public final void setPresenter(@NotNull AssignmentCategoryPresenter assignmentCategoryPresenter) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoryPresenter, "<set-?>");
        this.presenter = assignmentCategoryPresenter;
    }

    @NotNull
    public final AssignmentCategoriesAdapter getAdapter() {
        AssignmentCategoriesAdapter assignmentCategoriesAdapter = this.adapter;
        if (assignmentCategoriesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return assignmentCategoriesAdapter;
    }

    public final void setAdapter(@NotNull AssignmentCategoriesAdapter assignmentCategoriesAdapter) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoriesAdapter, "<set-?>");
        this.adapter = assignmentCategoriesAdapter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.gradebook = (Gradebook) bundle.getParcelable(GRADEBOOK);
            this.classSummary = (ClassSummary) bundle.getParcelable(CLASS_SUMMARY);
            bundle = this.listener;
            boolean z = true;
            if (bundle == null || bundle.showHideWhatIfCheck() != 1) {
                bundle = this.classSummary;
                if (bundle != null) {
                    z = bundle.getHideScores();
                    this.hideOverall = z;
                }
            }
            bundle = this.gradebook;
            if ((bundle != null ? bundle.getShowWhatIf() : null) != null) {
                bundle = this.classSummary;
                if ((bundle != null ? bundle.getHideScores() : null) != null) {
                }
            }
            this.hideOverall = z;
            z = false;
            this.hideOverall = z;
        }
    }

    public void onResume() {
        super.onResume();
        AssignmentCategoriesAdapter assignmentCategoriesAdapter = this.adapter;
        if (assignmentCategoriesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        assignmentCategoriesAdapter.notifyDataSetChanged();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_assignment_category, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        return inflate;
    }

    private final void setupViews() {
        List list;
        RecyclerView recyclerView = this.categoriesRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesRV");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView = this.categoriesRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoriesRV");
        }
        AssignmentCategoriesAdapter assignmentCategoriesAdapter = this.adapter;
        if (assignmentCategoriesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(assignmentCategoriesAdapter);
        Gradebook gradebook = this.gradebook;
        if (gradebook != null) {
            RealmList categories = gradebook.getCategories();
            if (categories != null) {
                list = categories;
                updateAssignmentList(list);
            }
        }
        list = CollectionsKt.emptyList();
        updateAssignmentList(list);
    }

    private final void updateAssignmentList(List<? extends AssignmentCategory> list) {
        AssignmentCategoriesAdapter assignmentCategoriesAdapter = this.adapter;
        if (assignmentCategoriesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        assignmentCategoriesAdapter.update(list);
        View view = this.noAssignmentsView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noAssignmentsView");
        }
        view.setVisibility(list.isEmpty() != null ? null : 8);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        if (getParentFragment() instanceof AssignmentCategoryFragmentListener) {
            context = getParentFragment();
            if (context != null) {
                this.listener = (AssignmentCategoryFragmentListener) context;
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.fragments.AssignmentCategoryFragment.AssignmentCategoryFragmentListener");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AssignmentCategoryFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
        this.listener = (AssignmentCategoryFragmentListener) null;
    }

    public void showCategories(@NotNull Gradebook gradebook) {
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        this.gradebook = gradebook;
        gradebook = gradebook.getCategories();
        updateAssignmentList(gradebook != null ? (List) gradebook : CollectionsKt.emptyList());
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, th.getMessage()).setButton((int) C0316R.string.got_it, null).show();
    }

    public boolean hideScores() {
        AssignmentCategoryFragmentListener assignmentCategoryFragmentListener = this.listener;
        return assignmentCategoryFragmentListener != null ? assignmentCategoryFragmentListener.hideScores() : false;
    }

    public void onCategorySelected(@NotNull AssignmentCategory assignmentCategory) {
        Intrinsics.checkParameterIsNotNull(assignmentCategory, "assignmentCategory");
        AssignmentCategoryFragmentListener assignmentCategoryFragmentListener = this.listener;
        if (assignmentCategoryFragmentListener != null) {
            assignmentCategoryFragmentListener.onCategorySelected(assignmentCategory, this.gradebook);
        }
    }

    public boolean isDoingRubric() {
        ClassSummary classSummary = this.classSummary;
        return classSummary != null ? classSummary.getDoingRubric() : false;
    }

    public boolean isOverallHidden() {
        return this.hideOverall;
    }
}
