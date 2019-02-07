package com.aeries.mobileportal.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.adapters.CoursesAdapter;
import com.aeries.mobileportal.adapters.CoursesAdapter.CourseListener;
import com.aeries.mobileportal.dagger.components.CourseSelectFragmentComponent;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.SchoolClassSummary;
import com.aeries.mobileportal.presenters.grades.CoursesPresenter;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.viewmodels.grades.CoursesViewModel;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 R2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002RSB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0018\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u000205H\u0016J\u0012\u0010=\u001a\u0002052\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J(\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010>\u001a\u0004\u0018\u00010<H\u0016J\b\u0010E\u001a\u000205H\u0016J\b\u0010F\u001a\u000205H\u0016J\u0012\u0010G\u001a\u0002052\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0016\u0010H\u001a\u0002052\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0016J\u0012\u0010L\u001a\u0002052\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0012\u0010O\u001a\u0002052\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\u0010\u0010P\u001a\u0002052\u0006\u0010Q\u001a\u00020\u0018H\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006T"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/aeries/mobileportal/adapters/CoursesAdapter$CourseListener;", "Lcom/aeries/mobileportal/views/viewmodels/grades/CoursesViewModel;", "()V", "adapter", "Lcom/aeries/mobileportal/adapters/CoursesAdapter;", "getAdapter", "()Lcom/aeries/mobileportal/adapters/CoursesAdapter;", "setAdapter", "(Lcom/aeries/mobileportal/adapters/CoursesAdapter;)V", "component", "Lcom/aeries/mobileportal/dagger/components/CourseSelectFragmentComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/CourseSelectFragmentComponent;", "component$delegate", "Lkotlin/Lazy;", "coursesRV", "Landroid/support/v7/widget/RecyclerView;", "getCoursesRV", "()Landroid/support/v7/widget/RecyclerView;", "setCoursesRV", "(Landroid/support/v7/widget/RecyclerView;)V", "mDropdownVisibility", "", "mLastUpdatedVisibility", "mListener", "Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment$CourseSelectFragmentListener;", "noCoursesTV", "Landroid/widget/TextView;", "getNoCoursesTV", "()Landroid/widget/TextView;", "setNoCoursesTV", "(Landroid/widget/TextView;)V", "presenter", "Lcom/aeries/mobileportal/presenters/grades/CoursesPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/grades/CoursesPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/grades/CoursesPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "termSpinner", "Landroid/widget/Spinner;", "getTermSpinner", "()Landroid/widget/Spinner;", "setTermSpinner", "(Landroid/widget/Spinner;)V", "onAttach", "", "context", "Landroid/content/Context;", "onCourseSelect", "summary", "Lcom/aeries/mobileportal/models/ClassSummary;", "uiArguments", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onStop", "setupViews", "showCourses", "summaries", "", "Lcom/aeries/mobileportal/models/SchoolClassSummary;", "showError", "e", "", "showErrorAndFinish", "showProgressBar", "boolean", "Companion", "CourseSelectFragmentListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CourseSelectFragment.kt */
public final class CourseSelectFragment extends Fragment implements CourseListener, CoursesViewModel {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(CourseSelectFragment.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/CourseSelectFragmentComponent;"))};
    public static final Companion Companion = new Companion();
    private static final String DROPDOWN_VISIBILITY = "VISIBILITY";
    private static final String LAST_UPDATED_VISIBILITY = "L_U_VISIBILITY";
    private HashMap _$_findViewCache;
    @Inject
    @NotNull
    public CoursesAdapter adapter;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new CourseSelectFragment$component$2(this));
    @NotNull
    @BindView(2131361902)
    public RecyclerView coursesRV;
    private boolean mDropdownVisibility;
    private boolean mLastUpdatedVisibility;
    private CourseSelectFragmentListener mListener;
    @NotNull
    @BindView(2131362062)
    public TextView noCoursesTV;
    @Inject
    @NotNull
    public CoursesPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    @NotNull
    @BindView(2131362188)
    public Spinner termSpinner;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment$Companion;", "", "()V", "DROPDOWN_VISIBILITY", "", "LAST_UPDATED_VISIBILITY", "newInstance", "Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment;", "dropdownVisibility", "", "lastUpdatedVisibility", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CourseSelectFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final CourseSelectFragment newInstance(boolean z, boolean z2) {
            CourseSelectFragment courseSelectFragment = new CourseSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(CourseSelectFragment.DROPDOWN_VISIBILITY, z);
            bundle.putBoolean(CourseSelectFragment.LAST_UPDATED_VISIBILITY, z2);
            courseSelectFragment.setArguments(bundle);
            return courseSelectFragment;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment$CourseSelectFragmentListener;", "", "onCourseSelect", "", "course", "Lcom/aeries/mobileportal/models/ClassSummary;", "showLastUpdated", "", "uiArguments", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CourseSelectFragment.kt */
    public interface CourseSelectFragmentListener {
        void onCourseSelect(@NotNull ClassSummary classSummary, boolean z, @NotNull Bundle bundle);
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
    public final CourseSelectFragmentComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (CourseSelectFragmentComponent) lazy.getValue();
    }

    public void onCreate() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @NotNull
    public final CoursesAdapter getAdapter() {
        CoursesAdapter coursesAdapter = this.adapter;
        if (coursesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return coursesAdapter;
    }

    public final void setAdapter(@NotNull CoursesAdapter coursesAdapter) {
        Intrinsics.checkParameterIsNotNull(coursesAdapter, "<set-?>");
        this.adapter = coursesAdapter;
    }

    @NotNull
    public final CoursesPresenter getPresenter() {
        CoursesPresenter coursesPresenter = this.presenter;
        if (coursesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return coursesPresenter;
    }

    public final void setPresenter(@NotNull CoursesPresenter coursesPresenter) {
        Intrinsics.checkParameterIsNotNull(coursesPresenter, "<set-?>");
        this.presenter = coursesPresenter;
    }

    @NotNull
    public final RecyclerView getCoursesRV() {
        RecyclerView recyclerView = this.coursesRV;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursesRV");
        }
        return recyclerView;
    }

    public final void setCoursesRV(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "<set-?>");
        this.coursesRV = recyclerView;
    }

    @NotNull
    public final Spinner getTermSpinner() {
        Spinner spinner = this.termSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termSpinner");
        }
        return spinner;
    }

    public final void setTermSpinner(@NotNull Spinner spinner) {
        Intrinsics.checkParameterIsNotNull(spinner, "<set-?>");
        this.termSpinner = spinner;
    }

    @NotNull
    public final TextView getNoCoursesTV() {
        TextView textView = this.noCoursesTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("noCoursesTV");
        }
        return textView;
    }

    public final void setNoCoursesTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.noCoursesTV = textView;
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mDropdownVisibility = getArguments().getBoolean(DROPDOWN_VISIBILITY);
            this.mLastUpdatedVisibility = getArguments().getBoolean(LAST_UPDATED_VISIBILITY);
        }
    }

    @Nullable
    public View onCreateView(@Nullable LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        if (layoutInflater == null) {
            Intrinsics.throwNpe();
        }
        View inflate = layoutInflater.inflate(C0316R.layout.fragment_course_select, viewGroup, false);
        ButterKnife.bind((Object) this, inflate);
        getComponent().inject(this);
        setupViews(viewGroup);
        viewGroup = this.presenter;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewGroup.getCourses();
        viewGroup = this.presenter;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        viewGroup.sendAnalytics();
        return inflate;
    }

    private final void setupViews(ViewGroup viewGroup) {
        CoursesAdapter coursesAdapter = this.adapter;
        if (coursesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        int i = 0;
        showProgressBar(coursesAdapter.getItemCount() == 0);
        Context context = null;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup != null ? viewGroup.getContext() : null);
        if (viewGroup != null) {
            context = viewGroup.getContext();
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(context, linearLayoutManager.getOrientation());
        viewGroup = ContextCompat.getDrawable(getContext(), C0316R.drawable.divider_item);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "dividerDrawable");
        viewGroup.setAlpha(85);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), 17367048, CollectionsKt.mutableListOf(new String[]{getString(C0316R.string.current_terms), getString(C0316R.string.prior_terms), getString(C0316R.string.future_terms)}));
        arrayAdapter.setDropDownViewResource(17367049);
        Spinner spinner = this.termSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termSpinner");
        }
        if (!this.mDropdownVisibility) {
            i = 8;
        }
        spinner.setVisibility(i);
        spinner = this.termSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termSpinner");
        }
        spinner.setAdapter(arrayAdapter);
        spinner = this.termSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termSpinner");
        }
        spinner.setOnItemSelectedListener(new CourseSelectFragment$setupViews$1(this));
        dividerItemDecoration.setDrawable(viewGroup);
        viewGroup = this.coursesRV;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursesRV");
        }
        viewGroup.setLayoutManager(linearLayoutManager);
        viewGroup = this.coursesRV;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursesRV");
        }
        viewGroup.addItemDecoration(dividerItemDecoration);
        viewGroup = this.coursesRV;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursesRV");
        }
        if (viewGroup.getAdapter() == null) {
            viewGroup = this.coursesRV;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coursesRV");
            }
            coursesAdapter = this.adapter;
            if (coursesAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            viewGroup.setAdapter(coursesAdapter);
        }
        viewGroup = this.adapter;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewGroup.setLastUpdatedVisibility(this.mLastUpdatedVisibility);
    }

    private final void showProgressBar(boolean z) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(z ? false : true);
    }

    public void showCourses(@NotNull List<SchoolClassSummary> list) {
        Intrinsics.checkParameterIsNotNull(list, "summaries");
        showProgressBar(false);
        if (list.isEmpty()) {
            TextView textView = this.noCoursesTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("noCoursesTV");
            }
            textView.setVisibility(0);
        }
        CoursesAdapter coursesAdapter = this.adapter;
        if (coursesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        Spinner spinner = this.termSpinner;
        if (spinner == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termSpinner");
        }
        coursesAdapter.update(list, spinner.getSelectedItemPosition());
    }

    public void onAttach(@Nullable Context context) {
        super.onAttach(context);
        if (context instanceof CourseSelectFragmentListener) {
            this.mListener = (CourseSelectFragmentListener) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement CourseSelectFragmentListener");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onStop() {
        super.onStop();
        CoursesPresenter coursesPresenter = this.presenter;
        if (coursesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        coursesPresenter.cancelNetworkRequests();
    }

    public void onDetach() {
        super.onDetach();
        this.mListener = (CourseSelectFragmentListener) null;
    }

    public void onCourseSelect(@NotNull ClassSummary classSummary, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "summary");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        CourseSelectFragmentListener courseSelectFragmentListener = this.mListener;
        if (courseSelectFragmentListener != null) {
            courseSelectFragmentListener.onCourseSelect(classSummary, this.mLastUpdatedVisibility, bundle);
        }
    }

    public void showError(@Nullable String str) {
        showProgressBar(false);
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, str).setButton((int) C0316R.string.got_it, null).show();
    }

    public void showErrorAndFinish(@Nullable String str) {
        if (str != null && StringsKt.contains$default(str, "401", false, 2, null)) {
            str = getContext().getString(C0316R.string.request_not_completed);
        }
        showProgressBar(false);
        com.aeries.mobileportal.utils.DialogUtils.Companion companion = DialogUtils.Companion;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        companion.getErrorDialogBuilder(context, str).setButton((int) C0316R.string.got_it, (Function0) new CourseSelectFragment$showErrorAndFinish$1(this)).show();
    }
}
