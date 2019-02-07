package com.aeries.mobileportal.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.AssignmentCategory;
import com.aeries.mobileportal.utils.ColorUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0019\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001e\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0018R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$ViewHolder;", "listener", "Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "(Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;)V", "categories", "", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "getCategories", "()Ljava/util/List;", "getListener", "()Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "", "AssignmentCategoriesAdapterListener", "ViewHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentCategoriesAdapter.kt */
public final class AssignmentCategoriesAdapter extends Adapter<ViewHolder> {
    @NotNull
    private final List<AssignmentCategory> categories = ((List) new ArrayList());
    @NotNull
    private final AssignmentCategoriesAdapterListener listener;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$AssignmentCategoriesAdapterListener;", "", "hideScores", "", "isDoingRubric", "isOverallHidden", "onCategorySelected", "", "assignmentCategory", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentCategoriesAdapter.kt */
    public interface AssignmentCategoriesAdapterListener {
        boolean hideScores();

        boolean isDoingRubric();

        boolean isOverallHidden();

        void onCategorySelected(@NotNull AssignmentCategory assignmentCategory);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001e\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AssignmentCategoriesAdapter;Landroid/view/View;)V", "categoryNameTV", "Landroid/widget/TextView;", "getCategoryNameTV", "()Landroid/widget/TextView;", "setCategoryNameTV", "(Landroid/widget/TextView;)V", "gradeHolder", "Landroid/support/constraint/ConstraintLayout;", "getGradeHolder", "()Landroid/support/constraint/ConstraintLayout;", "setGradeHolder", "(Landroid/support/constraint/ConstraintLayout;)V", "gradeTV", "getGradeTV", "setGradeTV", "numOfAssignmentsTV", "getNumOfAssignmentsTV", "setNumOfAssignmentsTV", "pointsTV", "getPointsTV", "setPointsTV", "bindData", "", "category", "Lcom/aeries/mobileportal/models/AssignmentCategory;", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentCategoriesAdapter.kt */
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @NotNull
        @BindView(2131361863)
        public TextView categoryNameTV;
        @NotNull
        @BindView(2131361975)
        public ConstraintLayout gradeHolder;
        @NotNull
        @BindView(2131361980)
        public TextView gradeTV;
        @NotNull
        @BindView(2131362079)
        public TextView numOfAssignmentsTV;
        @NotNull
        @BindView(2131362098)
        public TextView pointsTV;
        final /* synthetic */ AssignmentCategoriesAdapter this$0;

        public ViewHolder(@NotNull AssignmentCategoriesAdapter assignmentCategoriesAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = assignmentCategoriesAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
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
        public final TextView getGradeTV() {
            TextView textView = this.gradeTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeTV");
            }
            return textView;
        }

        public final void setGradeTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.gradeTV = textView;
        }

        @NotNull
        public final TextView getPointsTV() {
            TextView textView = this.pointsTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointsTV");
            }
            return textView;
        }

        public final void setPointsTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.pointsTV = textView;
        }

        @NotNull
        public final TextView getCategoryNameTV() {
            TextView textView = this.categoryNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryNameTV");
            }
            return textView;
        }

        public final void setCategoryNameTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.categoryNameTV = textView;
        }

        @NotNull
        public final TextView getNumOfAssignmentsTV() {
            TextView textView = this.numOfAssignmentsTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numOfAssignmentsTV");
            }
            return textView;
        }

        public final void setNumOfAssignmentsTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.numOfAssignmentsTV = textView;
        }

        public final void bindData(@NotNull AssignmentCategory assignmentCategory) {
            Intrinsics.checkParameterIsNotNull(assignmentCategory, "category");
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            int color = ContextCompat.getColor(view.getContext(), !this.this$0.getListener().isDoingRubric() ? ColorUtils.Companion.getGradeHolderColor(Double.valueOf(assignmentCategory.getPercent()), assignmentCategory.getMark()) : C0316R.color.grayBackground);
            View view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            int color2 = ContextCompat.getColor(view2.getContext(), !this.this$0.getListener().isDoingRubric() ? ColorUtils.Companion.getGradeTextColor(Double.valueOf(assignmentCategory.getPercent()), assignmentCategory.getMark()) : C0316R.color.black_font);
            ConstraintLayout constraintLayout = this.gradeHolder;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
            }
            int i = (this.this$0.getListener().isOverallHidden() && Intrinsics.areEqual(assignmentCategory.getName(), (Object) "Overall")) ? 4 : 0;
            constraintLayout.setVisibility(i);
            constraintLayout = this.gradeHolder;
            if (constraintLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
            }
            constraintLayout.setBackgroundColor(color);
            ConstraintLayout constraintLayout2 = this.gradeHolder;
            if (constraintLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
            }
            LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            float f = (!Intrinsics.areEqual(assignmentCategory.getName(), (Object) "Overall") || this.this$0.getListener().isOverallHidden()) ? 108.0f : 160.0f;
            View view3 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "itemView");
            Context context = view3.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "itemView.context");
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "itemView.context.resources");
            layoutParams.width = (int) TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
            if (this.this$0.getListener().hideScores()) {
                constraintLayout2 = this.gradeHolder;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
                }
                constraintLayout2.setVisibility(4);
                constraintLayout2 = this.gradeHolder;
                if (constraintLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gradeHolder");
                }
                constraintLayout2.getLayoutParams().width = 0;
            }
            TextView textView = this.gradeTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeTV");
            }
            textView.setTextColor(color2);
            textView = this.pointsTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointsTV");
            }
            textView.setTextColor(color2);
            textView = this.gradeTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradeTV");
            }
            textView.setText(assignmentCategory.getMark());
            StringBuilder stringBuilder = new StringBuilder();
            view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            String string = view2.getContext().getString(C0316R.string.two_decimal_value);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri…string.two_decimal_value)");
            Object[] objArr = new Object[]{Double.valueOf(assignmentCategory.getPercent())};
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(this, *args)");
            stringBuilder.append(string);
            stringBuilder.append(this.this$0.getListener().isDoingRubric() ? "" : "%");
            String stringBuilder2 = stringBuilder.toString();
            TextView textView2 = this.pointsTV;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointsTV");
            }
            textView2.setText(stringBuilder2);
            textView = this.categoryNameTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryNameTV");
            }
            textView.setText(assignmentCategory.getName());
            textView = this.numOfAssignmentsTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("numOfAssignmentsTV");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            view2 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
            string = view2.getContext().getString(C0316R.string.num_of_assignments);
            Intrinsics.checkExpressionValueIsNotNull(string, "itemView.context.getStri…tring.num_of_assignments)");
            objArr = new Object[]{Integer.valueOf(assignmentCategory.getNumberOfAssignment())};
            string = String.format(string, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
            textView.setText(string);
            this.itemView.setOnClickListener(new AssignmentCategoriesAdapter$ViewHolder$bindData$1(this, assignmentCategory));
        }
    }

    public final class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        @UiThread
        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.gradeHolder = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.grade_holder, "field 'gradeHolder'", ConstraintLayout.class);
            viewHolder.gradeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.grade_tv, "field 'gradeTV'", TextView.class);
            viewHolder.pointsTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.points_tv, "field 'pointsTV'", TextView.class);
            viewHolder.categoryNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.category_name, "field 'categoryNameTV'", TextView.class);
            viewHolder.numOfAssignmentsTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.number_of_assignments_tv, "field 'numOfAssignmentsTV'", TextView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.gradeHolder = null;
                viewHolder.gradeTV = null;
                viewHolder.pointsTV = null;
                viewHolder.categoryNameTV = null;
                viewHolder.numOfAssignmentsTV = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AssignmentCategoriesAdapter(@NotNull AssignmentCategoriesAdapterListener assignmentCategoriesAdapterListener) {
        Intrinsics.checkParameterIsNotNull(assignmentCategoriesAdapterListener, CastExtraArgs.LISTENER);
        this.listener = assignmentCategoriesAdapterListener;
    }

    @NotNull
    public final AssignmentCategoriesAdapterListener getListener() {
        return this.listener;
    }

    @NotNull
    public final List<AssignmentCategory> getCategories() {
        return this.categories;
    }

    public int getItemCount() {
        return this.categories.size();
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : 0).inflate(C0316R.layout.holder_assignment_category, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "inflater.inflate(R.layou…_category, parent, false)");
        return new ViewHolder(this, viewGroup);
    }

    public void onBindViewHolder(@Nullable ViewHolder viewHolder, int i) {
        if (viewHolder != null) {
            viewHolder.bindData((AssignmentCategory) this.categories.get(i));
        }
    }

    public final void update(@NotNull List<? extends AssignmentCategory> list) {
        Intrinsics.checkParameterIsNotNull(list, "categories");
        this.categories.clear();
        this.categories.addAll(list);
        notifyDataSetChanged();
    }
}
