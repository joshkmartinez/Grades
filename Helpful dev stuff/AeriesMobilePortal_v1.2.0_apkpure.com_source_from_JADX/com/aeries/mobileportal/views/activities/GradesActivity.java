package com.aeries.mobileportal.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.Snackbar;
import android.support.transition.AutoTransition;
import android.support.transition.Transition.TransitionListener;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.dagger.components.GradesActivityComponent;
import com.aeries.mobileportal.enums.Permissions;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.models.MockGrade;
import com.aeries.mobileportal.models.MockGradebook;
import com.aeries.mobileportal.models.ViewPermission;
import com.aeries.mobileportal.presenters.BasePresenter;
import com.aeries.mobileportal.presenters.grades.GradesPresenter;
import com.aeries.mobileportal.utils.AnimationUtils;
import com.aeries.mobileportal.utils.DialogUtils;
import com.aeries.mobileportal.views.BaseActivity;
import com.aeries.mobileportal.views.BaseViewModel;
import com.aeries.mobileportal.views.fragments.AddWhatIfAssignmentFragment.AddWhatIfAssignmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment;
import com.aeries.mobileportal.views.fragments.AssignmentDetailsFragment.AssignmentDetailsFragmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentParentFragment;
import com.aeries.mobileportal.views.fragments.AssignmentParentFragment.AssignmentParentFragmentListener;
import com.aeries.mobileportal.views.fragments.AssignmentsFragment.AssignmentsFragmentListener;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment;
import com.aeries.mobileportal.views.fragments.CourseSelectFragment.CourseSelectFragmentListener;
import com.aeries.mobileportal.views.fragments.WhatIfModeFragment;
import com.aeries.mobileportal.views.fragments.WhatIfModeFragment.WhatIfModeFragmentListener;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import com.aeries.mobileportal.views.rowviewmodels.CourseRowViewModel;
import com.aeries.mobileportal.views.viewmodels.grades.GradesViewModel;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u0001B\u0005¢\u0006\u0002\u0010\tJ\b\u0010b\u001a\u00020cH\u0007J\u0010\u0010d\u001a\u00020c2\u0006\u0010e\u001a\u000201H\u0002J\u000f\u0010f\u001a\u0004\u0018\u00010ZH\u0014¢\u0006\u0002\u0010gJ\u0012\u0010h\u001a\u0004\u0018\u00010?2\u0006\u0010i\u001a\u00020>H\u0016J\u0010\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010jH\u0014J\n\u0010k\u001a\u0004\u0018\u00010lH\u0014J\b\u0010m\u001a\u00020cH\u0016J\b\u0010n\u001a\u000201H\u0016J \u0010o\u001a\u00020c2\u0006\u0010p\u001a\u00020q2\u0006\u0010i\u001a\u00020Z2\u0006\u0010r\u001a\u00020>H\u0016J \u0010s\u001a\u00020c2\u0006\u0010t\u001a\u00020u2\u0006\u0010i\u001a\u00020>2\u0006\u0010r\u001a\u00020>H\u0016J\u0010\u0010v\u001a\u00020c2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u00020cH\u0016J\b\u0010z\u001a\u00020cH\u0007J!\u0010{\u001a\u00020c2\u0006\u0010|\u001a\u00020}2\u0006\u0010~\u001a\u0002012\u0007\u0010\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020cH\u0016J\t\u0010\u0001\u001a\u00020cH\u0014J\t\u0010\u0001\u001a\u00020cH\u0016J)\u0010\u0001\u001a\u00020c2\u0006\u0010t\u001a\u00020u2\b\u0010i\u001a\u0004\u0018\u00010Z2\u0006\u0010r\u001a\u00020>H\u0016¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020cH\u0007J\u0012\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u000201H\u0016J\u0007\u0010\u0001\u001a\u00020cJ\t\u0010\u0001\u001a\u00020cH\u0002J\u0012\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u000201H\u0002J\t\u0010\u0001\u001a\u00020cH\u0002J\u0013\u0010\u0001\u001a\u00020c2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u000201H\u0016J\u001a\u0010\u0001\u001a\u00020c2\u0006\u00108\u001a\u0002012\u0007\u0010\u0001\u001a\u000201H\u0016J\u001a\u0010\u0001\u001a\u00020c2\u0007\u0010\u0001\u001a\u00020?2\u0006\u0010i\u001a\u00020>H\u0016R\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020?0=X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020G8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010L\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010N\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010-\"\u0004\bU\u0010/R\u001e\u0010V\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010!\"\u0004\bX\u0010#R\u000e\u0010Y\u001a\u00020ZX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010[\u001a\u00020Z8FX\u0002¢\u0006\f\n\u0004\b^\u0010\u000f\u001a\u0004\b\\\u0010]R\u001b\u0010_\u001a\u00020Z8FX\u0002¢\u0006\f\n\u0004\ba\u0010\u000f\u001a\u0004\b`\u0010]¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/views/activities/GradesActivity;", "Lcom/aeries/mobileportal/views/BaseActivity;", "Lcom/aeries/mobileportal/views/viewmodels/grades/GradesViewModel;", "Lcom/aeries/mobileportal/views/fragments/CourseSelectFragment$CourseSelectFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentsFragment$AssignmentsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentDetailsFragment$AssignmentDetailsFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/WhatIfModeFragment$WhatIfModeFragmentListener;", "Lcom/aeries/mobileportal/views/fragments/AddWhatIfAssignmentFragment$AddWhatIfAssignmentListener;", "Lcom/aeries/mobileportal/views/fragments/AssignmentParentFragment$AssignmentParentFragmentListener;", "()V", "component", "Lcom/aeries/mobileportal/dagger/components/GradesActivityComponent;", "getComponent", "()Lcom/aeries/mobileportal/dagger/components/GradesActivityComponent;", "component$delegate", "Lkotlin/Lazy;", "constraintLayout", "Landroid/support/constraint/ConstraintLayout;", "getConstraintLayout", "()Landroid/support/constraint/ConstraintLayout;", "setConstraintLayout", "(Landroid/support/constraint/ConstraintLayout;)V", "constraintSet1", "Landroid/support/constraint/ConstraintSet;", "constraintSet2", "data", "Lcom/aeries/mobileportal/models/ViewPermission;", "getData", "()Lcom/aeries/mobileportal/models/ViewPermission;", "data$delegate", "detailIcon", "Landroid/widget/ImageView;", "getDetailIcon", "()Landroid/widget/ImageView;", "setDetailIcon", "(Landroid/widget/ImageView;)V", "detailName", "Landroid/widget/TextView;", "getDetailName", "()Landroid/widget/TextView;", "setDetailName", "(Landroid/widget/TextView;)V", "detailTitle", "Landroid/support/v7/widget/CardView;", "getDetailTitle", "()Landroid/support/v7/widget/CardView;", "setDetailTitle", "(Landroid/support/v7/widget/CardView;)V", "editModeEnabled", "", "fragmentContainer", "Landroid/widget/RelativeLayout;", "getFragmentContainer", "()Landroid/widget/RelativeLayout;", "setFragmentContainer", "(Landroid/widget/RelativeLayout;)V", "hideScore", "mockGradebooks", "", "Lcom/aeries/mobileportal/models/MockGradebook;", "mockGrades", "", "", "Lcom/aeries/mobileportal/models/MockGrade;", "presenter", "Lcom/aeries/mobileportal/presenters/grades/GradesPresenter;", "getPresenter", "()Lcom/aeries/mobileportal/presenters/grades/GradesPresenter;", "setPresenter", "(Lcom/aeries/mobileportal/presenters/grades/GradesPresenter;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "setProgressBar", "(Landroid/widget/ProgressBar;)V", "showCategoriesAndWhatIf", "showHideWhatIfVersionCheck", "startAnimationEnded", "getStartAnimationEnded", "()Z", "setStartAnimationEnded", "(Z)V", "whatIfBanner", "getWhatIfBanner", "setWhatIfBanner", "whatIfButton", "getWhatIfButton", "setWhatIfButton", "whatIfDisabledMessage", "", "x", "getX", "()I", "x$delegate", "y", "getY", "y$delegate", "closeActivity", "", "disableWhatIfButton", "hideScores", "getLayout", "()Ljava/lang/Integer;", "getMockedGrade", "gradebookNumber", "Lcom/aeries/mobileportal/presenters/BasePresenter;", "getViewModel", "Lcom/aeries/mobileportal/views/BaseViewModel;", "inject", "isEditModeEnabled", "onAddWhatIfAssignment", "assignmentRowViewModel", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "termCode", "onAssignmentMocked", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "onAssignmentSelected", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onBackPressed", "onBannerClick", "onCourseSelect", "course", "Lcom/aeries/mobileportal/models/ClassSummary;", "showLastUpdated", "uiArguments", "Landroid/os/Bundle;", "onCreate", "onDestroy", "onHeaderClick", "onRemoveMockAssignment", "(Lcom/aeries/mobileportal/models/MockAssignment;Ljava/lang/Integer;Ljava/lang/String;)V", "onWhatIfButtonClick", "onWindowFocusChanged", "hasFocus", "performInitialSetup", "setLayoutConstraints", "setLoading", "b", "setupViews", "showError", "e", "", "showHideWhatIfCheck", "showWhatIf", "storeAndShowMockGrade", "mockGrade", "Companion", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: GradesActivity.kt */
public final class GradesActivity extends BaseActivity<GradesViewModel> implements GradesViewModel, CourseSelectFragmentListener, AssignmentsFragmentListener, AssignmentDetailsFragmentListener, WhatIfModeFragmentListener, AddWhatIfAssignmentListener, AssignmentParentFragmentListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GradesActivity.class), "x", "getX()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GradesActivity.class), "y", "getY()I")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GradesActivity.class), DataBufferSafeParcelable.DATA_FIELD, "getData()Lcom/aeries/mobileportal/models/ViewPermission;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GradesActivity.class), "component", "getComponent()Lcom/aeries/mobileportal/dagger/components/GradesActivityComponent;"))};
    public static final Companion Companion = new Companion();
    @NotNull
    private static final String GRADE_CHANGED = "GRADE_CHANGED";
    @NotNull
    private static final String MOCK_ASSIGNMENT_ADDED = "MOCK_ASSIGNMENT_ADDED";
    @NotNull
    private static final String MOCK_ASSIGNMENT_EXTRA = "MOCK_ASSIGNMENT_EXTRA";
    @NotNull
    private static final String MOCK_SCORE_EXTRA = "MOCK_SCORE_EXTRA";
    @NotNull
    private static final String WHAT_IF_ACTION = "WHAT_IF_ACTION";
    @NotNull
    private static final String WHAT_IF_ENABLED = "WHAT_IF_ENABLED";
    private HashMap _$_findViewCache;
    @NotNull
    private final Lazy component$delegate = LazyKt.lazy(new GradesActivity$component$2(this));
    @NotNull
    @BindView(2131361923)
    public ConstraintLayout constraintLayout;
    private final ConstraintSet constraintSet1 = new ConstraintSet();
    private final ConstraintSet constraintSet2 = new ConstraintSet();
    @NotNull
    private final Lazy data$delegate = LazyKt.lazy(new GradesActivity$data$2(this));
    @NotNull
    @BindView(2131361924)
    public ImageView detailIcon;
    @NotNull
    @BindView(2131361925)
    public TextView detailName;
    @NotNull
    @BindView(2131361927)
    public CardView detailTitle;
    private boolean editModeEnabled;
    @NotNull
    @BindView(2131361968)
    public RelativeLayout fragmentContainer;
    private boolean hideScore;
    private final List<MockGradebook> mockGradebooks = new ArrayList();
    private final Map<String, MockGrade> mockGrades = new LinkedHashMap();
    @Inject
    @NotNull
    public GradesPresenter presenter;
    @NotNull
    @BindView(2131362099)
    public ProgressBar progressBar;
    private boolean showCategoriesAndWhatIf = true;
    private boolean showHideWhatIfVersionCheck;
    private boolean startAnimationEnded;
    @NotNull
    @BindView(2131362282)
    public CardView whatIfBanner;
    @NotNull
    @BindView(2131362283)
    public ImageView whatIfButton;
    private int whatIfDisabledMessage;
    @NotNull
    private final Lazy x$delegate = LazyKt.lazy(new GradesActivity$x$2(this));
    @NotNull
    private final Lazy y$delegate = LazyKt.lazy(new GradesActivity$y$2(this));

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/aeries/mobileportal/views/activities/GradesActivity$Companion;", "", "()V", "GRADE_CHANGED", "", "getGRADE_CHANGED", "()Ljava/lang/String;", "MOCK_ASSIGNMENT_ADDED", "getMOCK_ASSIGNMENT_ADDED", "MOCK_ASSIGNMENT_EXTRA", "getMOCK_ASSIGNMENT_EXTRA", "MOCK_SCORE_EXTRA", "getMOCK_SCORE_EXTRA", "WHAT_IF_ACTION", "getWHAT_IF_ACTION", "WHAT_IF_ENABLED", "getWHAT_IF_ENABLED", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: GradesActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getWHAT_IF_ACTION() {
            return GradesActivity.WHAT_IF_ACTION;
        }

        @NotNull
        public final String getGRADE_CHANGED() {
            return GradesActivity.GRADE_CHANGED;
        }

        @NotNull
        public final String getMOCK_SCORE_EXTRA() {
            return GradesActivity.MOCK_SCORE_EXTRA;
        }

        @NotNull
        public final String getWHAT_IF_ENABLED() {
            return GradesActivity.WHAT_IF_ENABLED;
        }

        @NotNull
        public final String getMOCK_ASSIGNMENT_ADDED() {
            return GradesActivity.MOCK_ASSIGNMENT_ADDED;
        }

        @NotNull
        public final String getMOCK_ASSIGNMENT_EXTRA() {
            return GradesActivity.MOCK_ASSIGNMENT_EXTRA;
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
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    @NotNull
    public final GradesActivityComponent getComponent() {
        Lazy lazy = this.component$delegate;
        KProperty kProperty = $$delegatedProperties[3];
        return (GradesActivityComponent) lazy.getValue();
    }

    @NotNull
    public final ViewPermission getData() {
        Lazy lazy = this.data$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return (ViewPermission) lazy.getValue();
    }

    public final int getX() {
        Lazy lazy = this.x$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Number) lazy.getValue()).intValue();
    }

    public final int getY() {
        Lazy lazy = this.y$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).intValue();
    }

    @NotNull
    public final GradesPresenter m104getPresenter() {
        GradesPresenter gradesPresenter = this.presenter;
        if (gradesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return gradesPresenter;
    }

    public final void setPresenter(@NotNull GradesPresenter gradesPresenter) {
        Intrinsics.checkParameterIsNotNull(gradesPresenter, "<set-?>");
        this.presenter = gradesPresenter;
    }

    @NotNull
    public final CardView getDetailTitle() {
        CardView cardView = this.detailTitle;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        return cardView;
    }

    public final void setDetailTitle(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.detailTitle = cardView;
    }

    @NotNull
    public final CardView getWhatIfBanner() {
        CardView cardView = this.whatIfBanner;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfBanner");
        }
        return cardView;
    }

    public final void setWhatIfBanner(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.whatIfBanner = cardView;
    }

    @NotNull
    public final TextView getDetailName() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        return textView;
    }

    public final void setDetailName(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.detailName = textView;
    }

    @NotNull
    public final ImageView getDetailIcon() {
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        return imageView;
    }

    public final void setDetailIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.detailIcon = imageView;
    }

    @NotNull
    public final ImageView getWhatIfButton() {
        ImageView imageView = this.whatIfButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        return imageView;
    }

    public final void setWhatIfButton(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.whatIfButton = imageView;
    }

    @NotNull
    public final RelativeLayout getFragmentContainer() {
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        return relativeLayout;
    }

    public final void setFragmentContainer(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkParameterIsNotNull(relativeLayout, "<set-?>");
        this.fragmentContainer = relativeLayout;
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
    public final ConstraintLayout getConstraintLayout() {
        ConstraintLayout constraintLayout = this.constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("constraintLayout");
        }
        return constraintLayout;
    }

    public final void setConstraintLayout(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.constraintLayout = constraintLayout;
    }

    public final boolean getStartAnimationEnded() {
        return this.startAnimationEnded;
    }

    public final void setStartAnimationEnded(boolean z) {
        this.startAnimationEnded = z;
    }

    public void onCreate() {
        ButterKnife.bind((Activity) this);
        setupViews();
    }

    private final void setupViews() {
        String viewCode = getData().getViewCode();
        if (viewCode == null) {
            viewCode = "";
        }
        Permissions valueOf = Permissions.valueOf(viewCode);
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setText(getString(valueOf.getPermissionName()));
        ImageView imageView = this.detailIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailIcon");
        }
        imageView.setImageResource(valueOf.getImageID());
    }

    @OnClick({2131362283})
    public final void onWhatIfButtonClick() {
        if (this.hideScore) {
            RelativeLayout relativeLayout = this.fragmentContainer;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            }
            Snackbar.make((View) relativeLayout, this.whatIfDisabledMessage, 0).show();
            return;
        }
        this.editModeEnabled ^= 1;
        if (!this.editModeEnabled) {
            this.mockGradebooks.clear();
            this.mockGrades.clear();
        }
        ImageView imageView = this.whatIfButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        imageView.setImageResource(this.editModeEnabled ? C0316R.drawable.edit_button_selected : C0316R.drawable.edit_button);
        ConstraintLayout constraintLayout = this.constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("constraintLayout");
        }
        ViewGroup viewGroup = constraintLayout;
        TransitionSet transitionSet = new TransitionSet();
        AutoTransition autoTransition = new AutoTransition();
        RelativeLayout relativeLayout2 = this.fragmentContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        transitionSet = transitionSet.addTransition(autoTransition.addTarget((View) relativeLayout2));
        autoTransition = new AutoTransition();
        CardView cardView = this.whatIfBanner;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfBanner");
        }
        TransitionManager.beginDelayedTransition(viewGroup, transitionSet.addTransition(autoTransition.addTarget((View) cardView)).addListener((TransitionListener) new GradesActivity$onWhatIfButtonClick$1(this)));
        ConstraintSet constraintSet = this.editModeEnabled ? this.constraintSet2 : this.constraintSet1;
        ConstraintLayout constraintLayout2 = this.constraintLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("constraintLayout");
        }
        constraintSet.applyTo(constraintLayout2);
    }

    @OnClick({2131362282})
    public final void onBannerClick() {
        if (this.editModeEnabled) {
            WhatIfModeFragment.Companion.newInstance().show(getSupportFragmentManager(), "WHAT_IF");
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.startAnimationEnded) {
            z = AnimationUtils.Companion;
            CardView cardView = this.detailTitle;
            if (cardView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
            }
            z.translateToStart(cardView, (float) getX(), (float) getY(), new GradesActivity$onWindowFocusChanged$1(this));
        }
    }

    public final void performInitialSetup() {
        CardView cardView = this.whatIfBanner;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfBanner");
        }
        cardView.setVisibility(0);
        setLayoutConstraints();
        this.startAnimationEnded = true;
        setLoading(false);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        com.aeries.mobileportal.views.fragments.CourseSelectFragment.Companion companion = CourseSelectFragment.Companion;
        GradesPresenter gradesPresenter = this.presenter;
        if (gradesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        boolean dropdownVisible = gradesPresenter.getDropdownVisible();
        GradesPresenter gradesPresenter2 = this.presenter;
        if (gradesPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        beginTransaction.replace(C0316R.id.fragment_container, companion.newInstance(dropdownVisible, gradesPresenter2.getLastUpdatedVisible()), "COURSE_SELECT").commit();
    }

    private final void setLayoutConstraints() {
        ConstraintSet constraintSet = this.constraintSet1;
        ConstraintLayout constraintLayout = this.constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("constraintLayout");
        }
        constraintSet.clone(constraintLayout);
        this.constraintSet1.setVisibility(C0316R.id.progress_bar, 8);
        this.constraintSet1.setVisibility(C0316R.id.what_if_button, 0);
        constraintSet = this.constraintSet2;
        ConstraintLayout constraintLayout2 = this.constraintLayout;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("constraintLayout");
        }
        constraintSet.clone(constraintLayout2);
        this.constraintSet1.setVisibility(C0316R.id.progress_bar, 8);
        this.constraintSet2.setVisibility(C0316R.id.what_if_button, 0);
        this.constraintSet2.clear(C0316R.id.what_if_banner, 4);
        this.constraintSet2.connect(C0316R.id.what_if_banner, 3, C0316R.id.detail_title, 4, 0);
    }

    protected void onDestroy() {
        super.onDestroy();
        GradesPresenter gradesPresenter = this.presenter;
        if (gradesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        gradesPresenter.cancelRequests();
    }

    @Nullable
    protected Integer getLayout() {
        return Integer.valueOf(C0316R.layout.activity_student_detail);
    }

    @Nullable
    protected BasePresenter<GradesViewModel> getPresenter() {
        GradesPresenter gradesPresenter = this.presenter;
        if (gradesPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return gradesPresenter;
    }

    public void inject() {
        getComponent().inject(this);
    }

    @Nullable
    protected BaseViewModel getViewModel() {
        return this;
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentByTag(AssignmentParentFragment.Companion.getTAG()) != null) {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(AssignmentParentFragment.Companion.getTAG());
            if (findFragmentByTag != null) {
                AssignmentParentFragment assignmentParentFragment = (AssignmentParentFragment) findFragmentByTag;
                if (assignmentParentFragment.canGoBack()) {
                    assignmentParentFragment.getChildFragmentManager().popBackStackImmediate();
                    return;
                }
                if (this.editModeEnabled) {
                    onWhatIfButtonClick();
                }
                ImageView imageView = this.whatIfButton;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
                }
                imageView.setVisibility(8);
                super.onBackPressed();
                overridePendingTransition(17432576, 17432577);
                setLoading(false);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.aeries.mobileportal.views.fragments.AssignmentParentFragment");
        }
        super.onBackPressed();
        overridePendingTransition(17432576, 17432577);
        setLoading(false);
    }

    public void onHeaderClick() {
        if (this.editModeEnabled) {
            onWhatIfButtonClick();
        }
        ImageView imageView = this.whatIfButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        imageView.setVisibility(8);
    }

    @OnClick({2131361925})
    public final void closeActivity() {
        TextView textView = this.detailName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailName");
        }
        textView.setClickable(false);
        ImageView imageView = this.whatIfButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        imageView.setVisibility(8);
        CardView cardView = this.whatIfBanner;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfBanner");
        }
        cardView.setVisibility(8);
        com.aeries.mobileportal.utils.AnimationUtils.Companion companion = AnimationUtils.Companion;
        RelativeLayout relativeLayout = this.fragmentContainer;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
        }
        companion.fadeOut(relativeLayout);
        companion = AnimationUtils.Companion;
        CardView cardView2 = this.detailTitle;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailTitle");
        }
        companion.translateToPoint(cardView2, (float) getX(), (float) getY(), new GradesActivity$closeActivity$1(this));
    }

    private final void setLoading(boolean z) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        progressBar.setVisibility(z ? false : true);
    }

    public void onCourseSelect(@NotNull ClassSummary classSummary, boolean z, @NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(classSummary, "course");
        Intrinsics.checkParameterIsNotNull(bundle, "uiArguments");
        bundle.putFloat("rotation", -90.0f);
        getSupportFragmentManager().beginTransaction().setCustomAnimations(C0316R.anim.slide_in_right, C0316R.anim.slide_out_left, C0316R.anim.slide_in_left, C0316R.anim.slide_out_right).replace(C0316R.id.fragment_container, AssignmentParentFragment.Companion.newInstance(new CourseRowViewModel(classSummary, z, bundle), this.showCategoriesAndWhatIf), AssignmentParentFragment.Companion.getTAG()).addToBackStack(AssignmentParentFragment.Companion.getTAG()).commit();
    }

    private final void disableWhatIfButton(boolean z) {
        this.hideScore = z;
        ImageView imageView = this.whatIfButton;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        imageView.setImageResource(z ? true : true);
    }

    public void showWhatIf(boolean z, boolean z2) {
        this.whatIfDisabledMessage = z ? C0316R.string.school_what_if_disabled : C0316R.string.teacher_what_if_disabled;
        int i = 0;
        disableWhatIfButton(false);
        if (z) {
            disableWhatIfButton(true);
        } else if (this.showHideWhatIfVersionCheck) {
            disableWhatIfButton(z2 ^ 1);
        }
        z = this.whatIfButton;
        if (!z) {
            Intrinsics.throwUninitializedPropertyAccessException("whatIfButton");
        }
        if (!this.showCategoriesAndWhatIf) {
            i = 8;
        }
        z.setVisibility(i);
    }

    public void onAssignmentSelected(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        AssignmentDetailsFragment.Companion.newInstance(assignment).show(getSupportFragmentManager().beginTransaction(), AssignmentDetailsFragment.Companion.getTAG());
        assignment = this.presenter;
        if (assignment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        assignment.sendDetailsAnalytics();
    }

    public void showError(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "e");
        th.printStackTrace();
        if (Intrinsics.areEqual(th.getMessage(), (Object) "HTTP 401 Unauthorized")) {
            th = "There was a problem, please try again.";
        } else {
            th = th.getMessage();
            if (th == null) {
                th = "";
            }
        }
        DialogUtils.Companion.getErrorDialogBuilder(this, th).setButton((int) C0316R.string.got_it, (Function0) new GradesActivity$showError$1(this)).setCancelable(false).show();
    }

    public void onAssignmentMocked(@NotNull MockAssignment mockAssignment, @NotNull String str, @NotNull String str2) {
        MockGradebook mockGradebook;
        int i;
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        Intrinsics.checkParameterIsNotNull(str, "gradebookNumber");
        Intrinsics.checkParameterIsNotNull(str2, "termCode");
        Iterable<MockGradebook> iterable = this.mockGradebooks;
        int i2 = 0;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (MockGradebook mockGradebook2 : iterable) {
                if (Intrinsics.areEqual(mockGradebook2.getGradebookNumber(), (Object) str)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i != 0) {
            for (MockGradebook mockGradebook22 : this.mockGradebooks) {
                if (Intrinsics.areEqual(mockGradebook22.getGradebookNumber(), (Object) str)) {
                    for (MockAssignment assignmentNumber : mockGradebook22.getAssignments()) {
                        if (Intrinsics.areEqual(assignmentNumber.getAssignmentNumber(), mockAssignment.getAssignmentNumber())) {
                            break;
                        }
                        i2++;
                    }
                    i2 = -1;
                    if (i2 != -1) {
                        ((MockAssignment) mockGradebook22.getAssignments().get(i2)).setMark(mockAssignment.getMark());
                        ((MockAssignment) mockGradebook22.getAssignments().get(i2)).setMaxScore(mockAssignment.getMaxScore());
                        ((MockAssignment) mockGradebook22.getAssignments().get(i2)).setScore(mockAssignment.getScore());
                    } else {
                        mockGradebook22.getAssignments().add(mockAssignment);
                    }
                    mockGradebook22.setTermCode(str2);
                }
            }
            throw ((Throwable) new NoSuchElementException("Collection contains no element matching the predicate."));
        }
        mockGradebook22 = new MockGradebook();
        mockGradebook22.setGradebookNumber(str);
        mockGradebook22.setTermCode(str2);
        mockGradebook22.getAssignments().add(mockAssignment);
        this.mockGradebooks.add(mockGradebook22);
        mockAssignment = this.presenter;
        if (mockAssignment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        mockAssignment.getMockedGrade(mockGradebook22);
    }

    public void onRemoveMockAssignment(@NotNull MockAssignment mockAssignment, @Nullable Integer num, @NotNull String str) {
        MockGradebook mockGradebook;
        Object obj;
        Intrinsics.checkParameterIsNotNull(mockAssignment, "mockAssignment");
        Intrinsics.checkParameterIsNotNull(str, "termCode");
        Iterable<MockGradebook> iterable = this.mockGradebooks;
        Object obj2 = null;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (MockGradebook mockGradebook2 : iterable) {
                if (Intrinsics.areEqual(mockGradebook2.getGradebookNumber(), String.valueOf(num))) {
                    obj = 1;
                    break;
                }
            }
        }
        obj = null;
        if (obj == null) {
            List list = this.mockGradebooks;
            mockGradebook2 = new MockGradebook();
            mockGradebook2.setGradebookNumber(String.valueOf(num));
            mockGradebook2.setTermCode(str);
            list.add(mockGradebook2);
        }
        for (Object obj3 : (Iterable) this.mockGradebooks) {
            if (Intrinsics.areEqual(((MockGradebook) obj3).getGradebookNumber(), String.valueOf(num))) {
                break;
            }
        }
        obj3 = null;
        MockGradebook mockGradebook3 = (MockGradebook) obj3;
        if (mockGradebook3 != null) {
            num = mockGradebook3.getAssignments();
            if (num != null) {
                Iterable<MockAssignment> iterable2 = (Iterable) num;
                if ((iterable2 instanceof Collection) == null || ((Collection) iterable2).isEmpty() == null) {
                    for (MockAssignment assignmentNumber : iterable2) {
                        MockAssignment assignmentNumber2;
                        if (Intrinsics.areEqual(assignmentNumber2.getAssignmentNumber(), mockAssignment.getAssignmentNumber()) != null) {
                            obj2 = 1;
                            break;
                        }
                    }
                }
                if (obj2 == null) {
                    mockGradebook3.getAssignments().add(mockAssignment);
                }
            }
        }
        if (mockGradebook3 != null) {
            num = mockGradebook3.getAssignments();
            if (num != null) {
                for (String str2 : (Iterable) num) {
                    if (Intrinsics.areEqual(((MockAssignment) str2).getAssignmentNumber(), mockAssignment.getAssignmentNumber())) {
                        break;
                    }
                }
                str2 = null;
                assignmentNumber2 = (MockAssignment) str2;
                if (assignmentNumber2 != null) {
                    assignmentNumber2.setMark("NA");
                }
            }
        }
        if (mockGradebook3 != null) {
            mockAssignment = this.presenter;
            if (mockAssignment == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            mockAssignment.getMockedGrade(mockGradebook3);
        }
    }

    public void storeAndShowMockGrade(@NotNull MockGrade mockGrade, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(mockGrade, "mockGrade");
        Intrinsics.checkParameterIsNotNull(str, "gradebookNumber");
        this.mockGrades.put(str, mockGrade);
        str = new Intent(GRADE_CHANGED);
        str.putExtra(MOCK_SCORE_EXTRA, mockGrade);
        LocalBroadcastManager.getInstance(this).sendBroadcast(str);
    }

    @Nullable
    public MockGrade getMockedGrade(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "gradebookNumber");
        return (MockGrade) this.mockGrades.get(str);
    }

    public void onAddWhatIfAssignment(@NotNull AssignmentRowViewModel assignmentRowViewModel, int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(assignmentRowViewModel, "assignmentRowViewModel");
        Intrinsics.checkParameterIsNotNull(str, "termCode");
        MockAssignment mockAssignment = new MockAssignment();
        Assignment assignment = assignmentRowViewModel.getAssignment();
        mockAssignment.setAssignmentNumber(String.valueOf(assignment.getAssignmentNumber()));
        mockAssignment.setMaxScore(String.valueOf(assignment.getMaxScore()));
        mockAssignment.setScore(String.valueOf(assignment.getScore()));
        mockAssignment.setMark("");
        String category = assignment.getCategory();
        if (category == null) {
            category = "";
        }
        mockAssignment.setCategory(category);
        onAssignmentMocked(mockAssignment, String.valueOf(i), str);
        i = new Intent(MOCK_ASSIGNMENT_ADDED);
        i.putExtra(MOCK_ASSIGNMENT_EXTRA, assignmentRowViewModel);
        LocalBroadcastManager.getInstance(this).sendBroadcast(i);
    }

    public boolean isEditModeEnabled() {
        return this.editModeEnabled;
    }

    public boolean showHideWhatIfCheck() {
        return this.showHideWhatIfVersionCheck;
    }
}
