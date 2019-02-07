package com.aeries.mobileportal.views.custom;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.ClassSummary;
import com.aeries.mobileportal.utils.ColorUtils;
import com.aeries.mobileportal.utils.DateUtils;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.views.rowviewmodels.CourseRowViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 _2\u00020\u0001:\u0002_`B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u00020QH\u0002J\u000e\u0010R\u001a\u00020Q2\u0006\u0010>\u001a\u00020?J\u000e\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020Q2\u0006\u00103\u001a\u000204J\u000e\u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020YJ\u001c\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010O2\b\u0010\\\u001a\u0004\u0018\u00010OH\u0002J\b\u0010]\u001a\u00020QH\u0002J\u001a\u0010^\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010O2\b\u0010\\\u001a\u0004\u0018\u00010OR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001e\u0010\u0017\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001e\u0010\u001a\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000b\"\u0004\b,\u0010\rR\u001e\u0010-\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013R\u001e\u00100\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR\u000e\u00103\u001a\u000204X.¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\u001e\u00108\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR\u001e\u0010;\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000b\"\u0004\b=\u0010\rR\u000e\u0010>\u001a\u00020?X.¢\u0006\u0002\n\u0000R\u0011\u0010@\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)R\u0011\u0010B\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001e\u0010E\u001a\u00020\t8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000b\"\u0004\bG\u0010\rR\u001e\u0010H\u001a\u00020I8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006a"}, d2 = {"Lcom/aeries/mobileportal/views/custom/CourseRowView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "courseGradeTV", "Landroid/widget/TextView;", "getCourseGradeTV", "()Landroid/widget/TextView;", "setCourseGradeTV", "(Landroid/widget/TextView;)V", "courseHolder", "Landroid/support/constraint/ConstraintLayout;", "getCourseHolder", "()Landroid/support/constraint/ConstraintLayout;", "setCourseHolder", "(Landroid/support/constraint/ConstraintLayout;)V", "courseNameTV", "getCourseNameTV", "setCourseNameTV", "coursePercentTV", "getCoursePercentTV", "setCoursePercentTV", "courseTeacherTV", "getCourseTeacherTV", "setCourseTeacherTV", "courseToggleCardView", "Landroid/support/v7/widget/CardView;", "getCourseToggleCardView", "()Landroid/support/v7/widget/CardView;", "setCourseToggleCardView", "(Landroid/support/v7/widget/CardView;)V", "currentTV", "getCurrentTV", "setCurrentTV", "editCourseHolderCS", "Landroid/support/constraint/ConstraintSet;", "getEditCourseHolderCS", "()Landroid/support/constraint/ConstraintSet;", "editedTV", "getEditedTV", "setEditedTV", "gradeHolder", "getGradeHolder", "setGradeHolder", "lastUpdated", "getLastUpdated", "setLastUpdated", "listener", "Lcom/aeries/mobileportal/views/custom/CourseRowView$CourseRowListener;", "mockGradeHolder", "getMockGradeHolder", "setMockGradeHolder", "mockGradeTV", "getMockGradeTV", "setMockGradeTV", "mockPercentTV", "getMockPercentTV", "setMockPercentTV", "model", "Lcom/aeries/mobileportal/views/rowviewmodels/CourseRowViewModel;", "normalCourseHolderCS", "getNormalCourseHolderCS", "rootView", "getRootView", "()Landroid/widget/RelativeLayout;", "schoolNameTV", "getSchoolNameTV", "setSchoolNameTV", "toggleIcon", "Landroid/widget/ImageView;", "getToggleIcon", "()Landroid/widget/ImageView;", "setToggleIcon", "(Landroid/widget/ImageView;)V", "getGradeToDisplay", "", "setConstraints", "", "setData", "setEditMode", "isEditModeEnabled", "", "setListener", "setViewType", "viewType", "", "setupGradeHolder", "percent", "mark", "setupHeader", "setupMockGradeHolder", "Companion", "CourseRowListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: CourseRowView.kt */
public final class CourseRowView extends RelativeLayout {
    public static final Companion Companion = new Companion();
    public static final int HEADER_HOLDER = 0;
    public static final int HOLDER = 1;
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361896)
    public TextView courseGradeTV;
    @NotNull
    @BindView(2131361897)
    public ConstraintLayout courseHolder;
    @NotNull
    @BindView(2131361898)
    public TextView courseNameTV;
    @NotNull
    @BindView(2131361899)
    public TextView coursePercentTV;
    @NotNull
    @BindView(2131361900)
    public TextView courseTeacherTV;
    @NotNull
    @BindView(2131361901)
    public CardView courseToggleCardView;
    @NotNull
    @BindView(2131361905)
    public TextView currentTV;
    @NotNull
    private final ConstraintSet editCourseHolderCS;
    @NotNull
    @BindView(2131361944)
    public TextView editedTV;
    @NotNull
    @BindView(2131361975)
    public ConstraintLayout gradeHolder;
    @NotNull
    @BindView(2131362014)
    public TextView lastUpdated;
    private CourseRowListener listener;
    @NotNull
    @BindView(2131362045)
    public ConstraintLayout mockGradeHolder;
    @NotNull
    @BindView(2131362043)
    public TextView mockGradeTV;
    @NotNull
    @BindView(2131362044)
    public TextView mockPercentTV;
    private CourseRowViewModel model;
    @NotNull
    private final ConstraintSet normalCourseHolderCS;
    @NotNull
    private final RelativeLayout rootView;
    @NotNull
    @BindView(2131362119)
    public TextView schoolNameTV;
    @NotNull
    @BindView(2131362261)
    public ImageView toggleIcon;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/aeries/mobileportal/views/custom/CourseRowView$Companion;", "", "()V", "HEADER_HOLDER", "", "HOLDER", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CourseRowView.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/aeries/mobileportal/views/custom/CourseRowView$CourseRowListener;", "", "onHeaderClick", "", "summary", "Lcom/aeries/mobileportal/models/ClassSummary;", "uiArguments", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: CourseRowView.kt */
    public interface CourseRowListener {
        void onHeaderClick(@NotNull ClassSummary classSummary, @NotNull Bundle bundle);
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
    public static final /* synthetic */ CourseRowListener access$getListener$p(CourseRowView courseRowView) {
        courseRowView = courseRowView.listener;
        if (courseRowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(CastExtraArgs.LISTENER);
        }
        return courseRowView;
    }

    @NotNull
    public static final /* synthetic */ CourseRowViewModel access$getModel$p(CourseRowView courseRowView) {
        courseRowView = courseRowView.model;
        if (courseRowView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        return courseRowView;
    }

    @NotNull
    public final ConstraintLayout getCourseHolder() {
        ConstraintLayout constraintLayout = this.courseHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseHolder");
        }
        return constraintLayout;
    }

    public final void setCourseHolder(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.courseHolder = constraintLayout;
    }

    @NotNull
    public final TextView getSchoolNameTV() {
        TextView textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        return textView;
    }

    public final void setSchoolNameTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.schoolNameTV = textView;
    }

    @NotNull
    public final ConstraintLayout getMockGradeHolder() {
        ConstraintLayout constraintLayout = this.mockGradeHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockGradeHolder");
        }
        return constraintLayout;
    }

    public final void setMockGradeHolder(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.mockGradeHolder = constraintLayout;
    }

    @NotNull
    public final TextView getMockGradeTV() {
        TextView textView = this.mockGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockGradeTV");
        }
        return textView;
    }

    public final void setMockGradeTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mockGradeTV = textView;
    }

    @NotNull
    public final TextView getMockPercentTV() {
        TextView textView = this.mockPercentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockPercentTV");
        }
        return textView;
    }

    public final void setMockPercentTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.mockPercentTV = textView;
    }

    @NotNull
    public final TextView getEditedTV() {
        TextView textView = this.editedTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedTV");
        }
        return textView;
    }

    public final void setEditedTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.editedTV = textView;
    }

    @NotNull
    public final ConstraintLayout getGradeHolder() {
        ConstraintLayout constraintLayout = this.gradeHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
        }
        return constraintLayout;
    }

    public final void setGradeHolder(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.gradeHolder = constraintLayout;
    }

    @NotNull
    public final TextView getCourseGradeTV() {
        TextView textView = this.courseGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseGradeTV");
        }
        return textView;
    }

    public final void setCourseGradeTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.courseGradeTV = textView;
    }

    @NotNull
    public final TextView getCoursePercentTV() {
        TextView textView = this.coursePercentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursePercentTV");
        }
        return textView;
    }

    public final void setCoursePercentTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.coursePercentTV = textView;
    }

    @NotNull
    public final TextView getCurrentTV() {
        TextView textView = this.currentTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentTV");
        }
        return textView;
    }

    public final void setCurrentTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.currentTV = textView;
    }

    @NotNull
    public final CardView getCourseToggleCardView() {
        CardView cardView = this.courseToggleCardView;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseToggleCardView");
        }
        return cardView;
    }

    public final void setCourseToggleCardView(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.courseToggleCardView = cardView;
    }

    @NotNull
    public final ImageView getToggleIcon() {
        ImageView imageView = this.toggleIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleIcon");
        }
        return imageView;
    }

    public final void setToggleIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.toggleIcon = imageView;
    }

    @NotNull
    public final TextView getCourseNameTV() {
        TextView textView = this.courseNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseNameTV");
        }
        return textView;
    }

    public final void setCourseNameTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.courseNameTV = textView;
    }

    @NotNull
    public final TextView getCourseTeacherTV() {
        TextView textView = this.courseTeacherTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseTeacherTV");
        }
        return textView;
    }

    public final void setCourseTeacherTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.courseTeacherTV = textView;
    }

    @NotNull
    public final TextView getLastUpdated() {
        TextView textView = this.lastUpdated;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastUpdated");
        }
        return textView;
    }

    public final void setLastUpdated(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.lastUpdated = textView;
    }

    @NotNull
    public final RelativeLayout getRootView() {
        return this.rootView;
    }

    @NotNull
    public final ConstraintSet getNormalCourseHolderCS() {
        return this.normalCourseHolderCS;
    }

    @NotNull
    public final ConstraintSet getEditCourseHolderCS() {
        return this.editCourseHolderCS;
    }

    public CourseRowView(@Nullable Context context) {
        super(context);
        context = RelativeLayout.inflate(getContext(), C0316R.layout.holder_course, this);
        if (context != null) {
            this.rootView = (RelativeLayout) context;
            this.normalCourseHolderCS = new ConstraintSet();
            this.editCourseHolderCS = new ConstraintSet();
            this.rootView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    CourseRowView.access$getListener$p(this).onHeaderClick(CourseRowView.access$getModel$p(this).getClassSummary(), CourseRowView.access$getModel$p(this).getUiArguments());
                }
            });
            ButterKnife.bind((Object) this, (View) this.rootView);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public CourseRowView(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attributeSet");
        super(context, attributeSet);
        context = RelativeLayout.inflate(getContext(), C0316R.layout.holder_course, this);
        if (context != null) {
            this.rootView = (RelativeLayout) context;
            this.normalCourseHolderCS = new ConstraintSet();
            this.editCourseHolderCS = new ConstraintSet();
            this.rootView.setOnClickListener((OnClickListener) /* anonymous class already generated */);
            ButterKnife.bind((Object) this, (View) this.rootView);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    public final void setData(@NotNull CourseRowViewModel courseRowViewModel) {
        Intrinsics.checkParameterIsNotNull(courseRowViewModel, "model");
        this.model = courseRowViewModel;
        courseRowViewModel = courseRowViewModel.getClassSummary();
        setupHeader();
        setupGradeHolder(getGradeToDisplay(), courseRowViewModel.getCurrentMark());
        setConstraints();
    }

    public final void setEditMode(boolean z) {
        ConstraintLayout constraintLayout = this.courseHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseHolder");
        }
        TransitionManager.beginDelayedTransition(constraintLayout);
        z = z ? this.editCourseHolderCS : this.normalCourseHolderCS;
        constraintLayout = this.courseHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseHolder");
        }
        z.applyTo(constraintLayout);
        z = getGradeToDisplay();
        CourseRowViewModel courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        setupMockGradeHolder(z, courseRowViewModel.getClassSummary().getCurrentMark());
    }

    private final void setupGradeHolder(String str, String str2) {
        String stringBuilder;
        int i;
        if (str != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            CourseRowViewModel courseRowViewModel = this.model;
            if (courseRowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            stringBuilder2.append(courseRowViewModel.getClassSummary().getDoingRubric() ? "" : "%");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "";
        }
        Context context = getContext();
        CourseRowViewModel courseRowViewModel2 = this.model;
        if (courseRowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        Double d = null;
        if (courseRowViewModel2.getClassSummary().getDoingRubric()) {
            i = C0316R.color.grayBackground;
        } else {
            i = ColorUtils.Companion.getGradeHolderColor(str != null ? Double.valueOf(Double.parseDouble(str)) : null, str2);
        }
        int color = ContextCompat.getColor(context, i);
        Context context2 = getContext();
        CourseRowViewModel courseRowViewModel3 = this.model;
        if (courseRowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        if (courseRowViewModel3.getClassSummary().getDoingRubric()) {
            str = C0316R.color.black_font;
        } else {
            com.aeries.mobileportal.utils.ColorUtils.Companion companion = ColorUtils.Companion;
            if (str != null) {
                d = Double.valueOf(Double.parseDouble(str));
            }
            str = companion.getGradeTextColor(d, str2);
        }
        str = ContextCompat.getColor(context2, str);
        TextView textView = this.courseGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseGradeTV");
        }
        textView.setText(StringUtils.Companion.checkForNA(str2));
        str2 = this.coursePercentTV;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursePercentTV");
        }
        str2.setText(stringBuilder);
        str2 = this.gradeHolder;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
        }
        str2.setBackgroundColor(color);
        str2 = this.courseGradeTV;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseGradeTV");
        }
        str2.setTextColor(str);
        str2 = this.coursePercentTV;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coursePercentTV");
        }
        str2.setTextColor(str);
    }

    public final void setupMockGradeHolder(@Nullable String str, @Nullable String str2) {
        String stringBuilder;
        int i;
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        if (str != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(decimalFormat.format(Double.parseDouble(str)));
            CourseRowViewModel courseRowViewModel = this.model;
            if (courseRowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            stringBuilder2.append(courseRowViewModel.getClassSummary().getDoingRubric() ? "" : "%");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = "";
        }
        Context context = getContext();
        CourseRowViewModel courseRowViewModel2 = this.model;
        if (courseRowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        Double d = null;
        if (courseRowViewModel2.getClassSummary().getDoingRubric()) {
            i = C0316R.color.grayBackground;
        } else {
            i = ColorUtils.Companion.getGradeHolderColor(str != null ? Double.valueOf(Double.parseDouble(str)) : null, str2);
        }
        int color = ContextCompat.getColor(context, i);
        Context context2 = getContext();
        CourseRowViewModel courseRowViewModel3 = this.model;
        if (courseRowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        if (courseRowViewModel3.getClassSummary().getDoingRubric()) {
            str = C0316R.color.gray1;
        } else {
            com.aeries.mobileportal.utils.ColorUtils.Companion companion = ColorUtils.Companion;
            if (str != null) {
                d = Double.valueOf(Double.parseDouble(str));
            }
            str = companion.getGradeTextColor(d, str2);
        }
        str = ContextCompat.getColor(context2, str);
        TextView textView = this.mockGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockGradeTV");
        }
        textView.setText(StringUtils.Companion.checkForNA(str2));
        str2 = this.mockPercentTV;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockPercentTV");
        }
        str2.setText(stringBuilder);
        str2 = this.mockGradeHolder;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockGradeHolder");
        }
        str2.setBackgroundColor(color);
        str2 = this.mockGradeTV;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mockGradeTV");
        }
        str2.setTextColor(str);
    }

    private final void setupHeader() {
        int i;
        StringCompanionObject stringCompanionObject;
        String string;
        Object[] objArr;
        com.aeries.mobileportal.utils.DateUtils.Companion companion;
        String lastUpdated;
        Context context;
        String format;
        CardView cardView;
        ImageView imageView;
        String gradeToDisplay = getGradeToDisplay();
        CourseRowViewModel courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        ClassSummary classSummary = courseRowViewModel.getClassSummary();
        setupGradeHolder(gradeToDisplay, classSummary.getCurrentMark());
        TextView textView = this.courseNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseNameTV");
        }
        textView.setText(classSummary.getGradeBookName());
        if (classSummary.getHideScores()) {
            ConstraintLayout constraintLayout = this.gradeHolder;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
            }
            constraintLayout.setVisibility(8);
        }
        textView = this.courseTeacherTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseTeacherTV");
        }
        textView.setText(classSummary.getTeacherName());
        textView = this.lastUpdated;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastUpdated");
        }
        if (classSummary.getLastUpdated() != null) {
            CourseRowViewModel courseRowViewModel2 = this.model;
            if (courseRowViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("model");
            }
            if (courseRowViewModel2.getLastUpdatedVisibility()) {
                i = 0;
                textView.setVisibility(i);
                textView = this.lastUpdated;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastUpdated");
                }
                stringCompanionObject = StringCompanionObject.INSTANCE;
                string = getContext().getString(C0316R.string.last_updated);
                Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.last_updated)");
                objArr = new Object[2];
                companion = DateUtils.Companion;
                lastUpdated = classSummary.getLastUpdated();
                context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                objArr[0] = companion.parseSimpleDotNetDate(lastUpdated, context);
                objArr[1] = DateUtils.Companion.getHourMinute(classSummary.getLastUpdated());
                format = String.format(string, Arrays.copyOf(objArr, objArr.length));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
                textView = this.schoolNameTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
                }
                textView.setVisibility(8);
                textView = this.schoolNameTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
                }
                courseRowViewModel = this.model;
                if (courseRowViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                textView.setText(courseRowViewModel.getClassSummary().getSchoolName());
                textView = this.courseNameTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("courseNameTV");
                }
                courseRowViewModel = this.model;
                if (courseRowViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                textView.setTextColor(courseRowViewModel.getUiArguments().getInt("textColor"));
                cardView = this.courseToggleCardView;
                if (cardView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("courseToggleCardView");
                }
                courseRowViewModel = this.model;
                if (courseRowViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                cardView.setCardBackgroundColor(courseRowViewModel.getUiArguments().getInt("buttonColor"));
                imageView = this.toggleIcon;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("toggleIcon");
                }
                courseRowViewModel = this.model;
                if (courseRowViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("model");
                }
                imageView.setRotation(courseRowViewModel.getUiArguments().getFloat("rotation", 0.0f));
            }
        }
        i = 8;
        textView.setVisibility(i);
        textView = this.lastUpdated;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastUpdated");
        }
        stringCompanionObject = StringCompanionObject.INSTANCE;
        string = getContext().getString(C0316R.string.last_updated);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.last_updated)");
        objArr = new Object[2];
        companion = DateUtils.Companion;
        lastUpdated = classSummary.getLastUpdated();
        context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        objArr[0] = companion.parseSimpleDotNetDate(lastUpdated, context);
        objArr[1] = DateUtils.Companion.getHourMinute(classSummary.getLastUpdated());
        format = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        textView.setVisibility(8);
        textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        textView.setText(courseRowViewModel.getClassSummary().getSchoolName());
        textView = this.courseNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseNameTV");
        }
        courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        textView.setTextColor(courseRowViewModel.getUiArguments().getInt("textColor"));
        cardView = this.courseToggleCardView;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseToggleCardView");
        }
        courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        cardView.setCardBackgroundColor(courseRowViewModel.getUiArguments().getInt("buttonColor"));
        imageView = this.toggleIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toggleIcon");
        }
        courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        imageView.setRotation(courseRowViewModel.getUiArguments().getFloat("rotation", 0.0f));
    }

    private final String getGradeToDisplay() {
        CourseRowViewModel courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        ClassSummary classSummary = courseRowViewModel.getClassSummary();
        return classSummary.getDoingRubric() ? classSummary.getAverage() : String.valueOf(classSummary.getPercent());
    }

    private final void setConstraints() {
        ConstraintSet constraintSet = this.normalCourseHolderCS;
        ConstraintLayout constraintLayout = this.courseHolder;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseHolder");
        }
        constraintSet.clone(constraintLayout);
        CourseRowViewModel courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        if (courseRowViewModel.getLastUpdatedVisibility()) {
            this.normalCourseHolderCS.setVisibility(C0316R.id.last_updated, 0);
        }
        constraintSet = this.editCourseHolderCS;
        ConstraintLayout constraintLayout2 = this.courseHolder;
        if (constraintLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("courseHolder");
        }
        constraintSet.clone(constraintLayout2);
        courseRowViewModel = this.model;
        if (courseRowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("model");
        }
        if (courseRowViewModel.getLastUpdatedVisibility()) {
            this.editCourseHolderCS.setVisibility(C0316R.id.last_updated, 0);
        }
        constraintSet = this.editCourseHolderCS;
        constraintSet.setVisibility(C0316R.id.mock_grade_holder, 0);
        constraintSet.setVisibility(C0316R.id.current_tv, 0);
        constraintSet.setAlpha(C0316R.id.grade_holder, 0.6f);
    }

    public final void setListener(@NotNull CourseRowListener courseRowListener) {
        Intrinsics.checkParameterIsNotNull(courseRowListener, CastExtraArgs.LISTENER);
        this.listener = courseRowListener;
    }

    public final void setViewType(int i) {
        TextView textView = this.schoolNameTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schoolNameTV");
        }
        textView.setVisibility(i == 0 ? 0 : 8);
    }
}
