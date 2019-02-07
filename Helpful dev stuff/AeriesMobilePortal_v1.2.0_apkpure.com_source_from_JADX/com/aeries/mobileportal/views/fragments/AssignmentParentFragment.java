package com.aeries.mobileportal.views.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.AssignmentParentFragmentComponent;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.Gradebook;
import com.aeries.mobileportal.presenters.grades.AssignmentParentPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.activities.GradesActivity;
import com.aeries.mobileportal.views.custom.CourseRowView;
import com.aeries.mobileportal.views.custom.CourseRowView.CourseRowListener;
import com.aeries.mobileportal.views.fragments.AssignmentCategoryFragment.AssignmentCategoryFragmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentsFragment.AssignmentsFragmentParentListener;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import com.aeries.mobileportal.views.rowviewmodels.CourseRowViewModel;
import com.aeries.mobileportal.views.viewmodels.grades.AssignmentParentViewModel;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002NOB\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010(\u001a\u00020\u001bJ\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001a\u00100\u001a\u00020-2\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020-H\u0016J\u0012\u00105\u001a\u00020-2\b\u00106\u001a\u0004\u0018\u000107H\u0016J(\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010>\u001a\u00020-H\u0016J\u0018\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u000207H\u0016J\b\u0010C\u001a\u00020-H\u0016J\b\u0010D\u001a\u00020-H\u0002J\u0010\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u001bH\u0002J\b\u0010G\u001a\u00020-H\u0002J\u0010\u0010H\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010I\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0016J\u0010\u0010J\u001a\u00020-2\u0006\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020\u001bH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006P"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/views/custom/CourseRowView$CourseRowListener;", "Lcom/aeries/mobileportal/views/viewmodels/grades/AssignmentParentViewModel;", "Lcom/aeries/mobileportal/views/fragments/AssignmentCategoryFragment$AssignmentCategoryFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentParentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/AssignmentParentFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/AssignmentParentFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "header", "Lcom/aeries/mobileportal/views/custom/CourseRowView;", "getHeader", "()Lcom/aeries/mobileportal/views/custom/CourseRowView;", "setHeader", "(Lcom/aeries/mobileportal/views/custom/CourseRowView;)V", "mAssignments", "", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "mListener", "Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment$AssignmentParentFragmentListener;", "mModel", "Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "mShowCategories", "", "presenter", "Lcom/aeries/mobileportal/presenters/grades/AssignmentParentPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/grades/AssignmentParentPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/grades/AssignmentParentPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "canGoBack", "getAssignments", "getShowCategories", "hideScores", "onAttach", "", "context", "Landroid/content/Context;", "onCategorySelected", "category", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "gradebook", "Lcom/aeries/mobileportal/models/Gradebook;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onHeaderClick", "summary", "Lcom/aeries/mobileportal/models/ClassSummary;", "uiArguments", "onStop", "resetAssignments", "setLoading", "b", "setupViews", "showAssignments", "showCategories", "showError", "e", "", "showHideWhatIfCheck", "AssignmentParentFragmentListener", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentParentFragment.kt */
public final class AssignmentParentFragment extends Fragment implements CourseRowListener, AssignmentParentViewModel, AssignmentCategoryFragmentListener, AssignmentsFragmentParentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AssignmentParentFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/AssignmentParentFragmentComponent;"))};
    @NotNull
    private static final String ASSIGNMENT_LIST_MODIFIED = "ASSIGNMENT_LIST_MODIFIED";
    private static final String COURSE_MODEL = "param1";
    public static final Companion Companion = new Companion();
    private static final String SHOW_CATEGORIES = "param2";
    @NotNull
    private static final String TAG = "ASSIGNMENT_PARENT_FRAGMENT";
    private HashMap _$_findViewCache;
    private final Lazy component$delegate = LazyKt.lazy(new AssignmentParentFragment$component$2(this));
    @NotNull
    @BindView(2131361984)
    public CourseRowView header;
    private List<AssignmentRowViewModel> mAssignments;
    private AssignmentParentFragmentListener mListener;
    private CourseRowViewModel mModel;
    private boolean mShowCategories = true;
    @Inject
    @NotNull
    public AssignmentParentPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment$AssignmentParentFragmentListener;", "", "onHeaderClick", "", "showHideWhatIfCheck", "", "showWhatIf", "hideScore", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentParentFragment.kt */
    public interface AssignmentParentFragmentListener {
        void onHeaderClick();

        boolean showHideWhatIfCheck();

        void showWhatIf(boolean z, boolean z2);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment$Companion;", "", "()V", "ASSIGNMENT_LIST_MODIFIED", "", "getASSIGNMENT_LIST_MODIFIED", "()Ljava/lang/String;", "COURSE_MODEL", "SHOW_CATEGORIES", "TAG", "getTAG", "newInstance", "Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment;", "courseModel", "Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "showCategories", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentParentFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getTAG() {
            return AssignmentParentFragment.TAG;
        }

        @NotNull
        public final String getASSIGNMENT_LIST_MODIFIED() {
            return AssignmentParentFragment.ASSIGNMENT_LIST_MODIFIED;
        }

        @NotNull
        public final AssignmentParentFragment newInstance(@NotNull CourseRowViewModel courseRowViewModel, boolean z) {
            Intrinsics.checkParameterIsNotNull(courseRowViewModel, "courseModel");
            AssignmentParentFragment assignmentParentFragment = new AssignmentParentFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(AssignmentParentFragment.COURSE_MODEL, courseRowViewModel);
            bundle.putBoolean(AssignmentParentFragment.SHOW_CATEGORIES, z);
            assignmentParentFragment.setArguments(bundle);
            return assignmentParentFragment;
        }
    }

    private final AssignmentParentFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (AssignmentParentFragmentComponent) lazy.getValue();
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
    public final CourseRowView getHeader() {
        CourseRowView courseRowView = this.header;
        if (courseRowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("header");
        }
        return courseRowView;
    }

    public final void setHeader(@NotNull CourseRowView courseRowView) {
        Intrinsics.checkParameterIsNotNull(courseRowView, "<set-?>");
        this.header = courseRowView;
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
    public final AssignmentParentPresenter getPresenter() {
        AssignmentParentPresenter assignmentParentPresenter = this.presenter;
        if (assignmentParentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return assignmentParentPresenter;
    }

    public final void setPresenter(@NotNull AssignmentParentPresenter assignmentParentPresenter) {
        Intrinsics.checkParameterIsNotNull(assignmentParentPresenter, "<set-?>");
        this.presenter = assignmentParentPresenter;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mModel = (CourseRowViewModel) getArguments().getParcelable(COURSE_MODEL);
            this.mShowCategories = getArguments().getBoolean(SHOW_CATEGORIES);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_assignments_parent, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews();
        viewGroup = new AssignmentParentFragment$onCreateView$mockGradeBR$1(this);
        bundle = new AssignmentParentFragment$onCreateView$whatIfBR$1(this);
        IntentFilter intentFilter = new IntentFilter(GradesActivity.Companion.getGRADE_CHANGED());
        IntentFilter intentFilter2 = new IntentFilter(GradesActivity.Companion.getWHAT_IF_ACTION());
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(getContext());
        instance.registerReceiver((BroadcastReceiver) viewGroup, intentFilter);
        instance.registerReceiver((BroadcastReceiver) bundle, intentFilter2);
        viewGroup = this.presenter;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        bundle = this.mModel;
        viewGroup.getGradebook(bundle != null ? bundle.getClassSummary() : null);
        viewGroup = this.presenter;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewGroup.sendAnalytics();
        setLoading(true);
        return inflate;
    }

    private final void resetAssignments() {
        List list = this.mAssignments;
        if (list != null) {
            CollectionsKt.removeAll(list, AssignmentParentFragment$resetAssignments$1.INSTANCE);
        }
        List<AssignmentRowViewModel> list2 = this.mAssignments;
        if (list2 != null) {
            for (AssignmentRowViewModel assignmentRowViewModel : list2) {
                assignmentRowViewModel.setEditShowing(false);
                assignmentRowViewModel.setModified(false);
                assignmentRowViewModel.setModifying(false);
                assignmentRowViewModel.setDeleted(false);
            }
        }
    }

    private final void setupViews() {
        CourseRowView courseRowView = this.header;
        if (courseRowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("header");
        }
        CourseRowViewModel courseRowViewModel = this.mModel;
        if (courseRowViewModel == null) {
            Intrinsics.throwNpe();
        }
        courseRowView.setData(courseRowViewModel);
        courseRowView = this.header;
        if (courseRowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("header");
        }
        courseRowView.setListener(this);
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof AssignmentParentFragmentListener) {
            this.mListener = (AssignmentParentFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement AssignmentParentFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onStop() {
        super.onStop();
        AssignmentParentPresenter assignmentParentPresenter = this.presenter;
        if (assignmentParentPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        assignmentParentPresenter.cancelNetworkCalls();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (AssignmentParentFragmentListener) null;
    }

    public void onHeaderClick(@NotNull ClassSummary classSummary, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "summary");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        classSummary = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(classSummary, "childFragmentManager");
        if (classSummary.getBackStackEntryCount() > null) {
            getChildFragmentManager().popBackStackImmediate();
            return;
        }
        getFragmentManager().popBackStack();
        classSummary = this.mListener;
        if (classSummary != null) {
            classSummary.onHeaderClick();
        }
    }

    public void showAssignments(@NotNull Gradebook gradebook) {
        List toMutableList;
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        boolean z = false;
        setLoading(false);
        AssignmentParentFragmentListener assignmentParentFragmentListener = this.mListener;
        if (assignmentParentFragmentListener != null) {
            CourseRowViewModel courseRowViewModel = this.mModel;
            if (courseRowViewModel != null) {
                ClassSummary classSummary = courseRowViewModel.getClassSummary();
                if (classSummary != null) {
                    z = classSummary.getHideScores();
                }
            }
            assignmentParentFragmentListener.showWhatIf(z, gradebook.getShowWhatIf());
        }
        RealmList assignments = gradebook.getAssignments();
        if (assignments != null) {
            Iterable<Assignment> iterable = assignments;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Assignment assignment : iterable) {
                Intrinsics.checkExpressionValueIsNotNull(assignment, "it");
                arrayList.add(new AssignmentRowViewModel(assignment, false, false, false, false, false, false, 126, null));
            }
            toMutableList = CollectionsKt.toMutableList((List) arrayList);
        } else {
            toMutableList = null;
        }
        this.mAssignments = toMutableList;
        getChildFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_right, C0316R.anim.slide_out_left, C0316R.anim.slide_in_left, C0316R.anim.slide_out_right).replace(C0316R.id.child_fragment_container, AssignmentsFragment.Companion.newInstance(gradebook)).commit();
    }

    public void showCategories(@NotNull Gradebook gradebook) {
        List toMutableList;
        Intrinsics.checkParameterIsNotNull(gradebook, "gradebook");
        boolean z = false;
        setLoading(false);
        AssignmentParentFragmentListener assignmentParentFragmentListener = this.mListener;
        if (assignmentParentFragmentListener != null) {
            CourseRowViewModel courseRowViewModel = this.mModel;
            if (courseRowViewModel != null) {
                ClassSummary classSummary = courseRowViewModel.getClassSummary();
                if (classSummary != null) {
                    z = classSummary.getHideScores();
                }
            }
            assignmentParentFragmentListener.showWhatIf(z, gradebook.getShowWhatIf());
        }
        RealmList assignments = gradebook.getAssignments();
        ClassSummary classSummary2 = null;
        if (assignments != null) {
            Iterable<Assignment> iterable = assignments;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Assignment assignment : iterable) {
                Intrinsics.checkExpressionValueIsNotNull(assignment, "it");
                arrayList.add(new AssignmentRowViewModel(assignment, false, false, false, false, false, false, 126, null));
            }
            toMutableList = CollectionsKt.toMutableList((List) arrayList);
        } else {
            toMutableList = null;
        }
        this.mAssignments = toMutableList;
        FragmentTransaction customAnimations = getChildFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_right, C0316R.anim.slide_out_left, C0316R.anim.slide_in_left, C0316R.anim.slide_out_right);
        com.aeries.mobileportal.views.fragments.AssignmentCategoryFragment.Companion companion = AssignmentCategoryFragment.Companion;
        CourseRowViewModel courseRowViewModel2 = this.mModel;
        if (courseRowViewModel2 != null) {
            classSummary2 = courseRowViewModel2.getClassSummary();
        }
        if (classSummary2 == null) {
            Intrinsics.throwNpe();
        }
        customAnimations.replace(C0316R.id.child_fragment_container, companion.newInstance(gradebook, classSummary2)).commit();
    }

    public boolean getShowCategories() {
        return this.mShowCategories;
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, th.getMessage()).setButton((int) C0316R.string.got_it, null).show();
    }

    public boolean hideScores() {
        CourseRowViewModel courseRowViewModel = this.mModel;
        if (courseRowViewModel != null) {
            ClassSummary classSummary = courseRowViewModel.getClassSummary();
            if (classSummary != null) {
                return classSummary.getHideScores();
            }
        }
        return false;
    }

    public void onCategorySelected(@NotNull AssignmentCategory assignmentCategory, @Nullable Gradebook gradebook) {
        Intrinsics.checkParameterIsNotNull(assignmentCategory, "category");
        getChildFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_right, C0316R.anim.slide_out_left, C0316R.anim.slide_in_left, C0316R.anim.slide_out_right).replace(C0316R.id.child_fragment_container, AssignmentsFragment.Companion.newInstance(gradebook, assignmentCategory)).addToBackStack(null).commit();
    }

    public boolean showHideWhatIfCheck() {
        AssignmentParentFragmentListener assignmentParentFragmentListener = this.mListener;
        return assignmentParentFragmentListener != null ? assignmentParentFragmentListener.showHideWhatIfCheck() : false;
    }

    private final void setLoading(boolean z) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(z ? false : true);
    }

    @Nullable
    public List<AssignmentRowViewModel> getAssignments() {
        return this.mAssignments;
    }

    public final boolean canGoBack() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        return childFragmentManager.getBackStackEntryCount() > 0;
    }
}
