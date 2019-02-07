package com.aeries.mobileportal.adapters;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.AppConstants;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.utils.DateUtils;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.utils.StringUtils.Companion;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0018\u00010\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001e\u0010\u0018\u001a\u00060\u0002R\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter$AssignmentDetailHolder;", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "(Lcom/aeries/mobileportal/models/Assignment;)V", "LARGE_DETAIL", "", "getLARGE_DETAIL", "()I", "SMALL_DETAIL", "getSMALL_DETAIL", "getAssignment", "()Lcom/aeries/mobileportal/models/Assignment;", "titles", "", "getTitles", "()Ljava/util/List;", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AssignmentDetailHolder", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentDetailsAdapter.kt */
public final class AssignmentDetailsAdapter extends Adapter<AssignmentDetailHolder> {
    private final int LARGE_DETAIL = 1;
    private final int SMALL_DETAIL;
    @NotNull
    private final Assignment assignment;
    @NotNull
    private final List<Integer> titles = AppConstants.Companion.getASSIGNMENT_DETAIL_TITLES();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter$AssignmentDetailHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/aeries/mobileportal/adapters/AssignmentDetailsAdapter;Landroid/view/View;)V", "checkMark", "Landroid/widget/ImageView;", "getCheckMark", "()Landroid/widget/ImageView;", "setCheckMark", "(Landroid/widget/ImageView;)V", "detailTitleTV", "Landroid/widget/TextView;", "getDetailTitleTV", "()Landroid/widget/TextView;", "setDetailTitleTV", "(Landroid/widget/TextView;)V", "detailValueTV", "getDetailValueTV", "setDetailValueTV", "bindData", "", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "position", "", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentDetailsAdapter.kt */
    public final class AssignmentDetailHolder extends ViewHolder {
        @NotNull
        @BindView(2131361872)
        public ImageView checkMark;
        @NotNull
        @BindView(2131361927)
        public TextView detailTitleTV;
        @NotNull
        @BindView(2131361929)
        public TextView detailValueTV;
        final /* synthetic */ AssignmentDetailsAdapter this$0;

        public AssignmentDetailHolder(@NotNull AssignmentDetailsAdapter assignmentDetailsAdapter, View view) {
            Intrinsics.checkParameterIsNotNull(view, "itemView");
            this.this$0 = assignmentDetailsAdapter;
            super(view);
            ButterKnife.bind((Object) this, view);
        }

        @NotNull
        public final TextView getDetailTitleTV() {
            TextView textView = this.detailTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitleTV");
            }
            return textView;
        }

        public final void setDetailTitleTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailTitleTV = textView;
        }

        @NotNull
        public final TextView getDetailValueTV() {
            TextView textView = this.detailValueTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailValueTV");
            }
            return textView;
        }

        public final void setDetailValueTV(@NotNull TextView textView) {
            Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
            this.detailValueTV = textView;
        }

        @NotNull
        public final ImageView getCheckMark() {
            ImageView imageView = this.checkMark;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkMark");
            }
            return imageView;
        }

        public final void setCheckMark(@NotNull ImageView imageView) {
            Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
            this.checkMark = imageView;
        }

        public final void bindData(@NotNull Assignment assignment, int i) {
            Intrinsics.checkParameterIsNotNull(assignment, "assignment");
            TextView textView = this.detailTitleTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailTitleTV");
            }
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            textView.setText(view.getContext().getText(((Number) this.this$0.getTitles().get(i)).intValue()));
            if (Intrinsics.areEqual(assignment.isScoreValueACheckMark(), Boolean.valueOf(true)) && ((Number) this.this$0.getTitles().get(i)).intValue() == C0316R.string.score) {
                Object obj;
                textView = this.detailValueTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailValueTV");
                }
                int i2 = 8;
                textView.setVisibility(8);
                ImageView imageView = this.checkMark;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkMark");
                }
                String mark = assignment.getMark();
                if (mark == null) {
                    obj = null;
                } else if (mark != null) {
                    obj = mark.toLowerCase();
                    Intrinsics.checkExpressionValueIsNotNull(obj, "(this as java.lang.String).toLowerCase()");
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                if (Intrinsics.areEqual(obj, (Object) "scored")) {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            }
            textView = this.detailValueTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("detailValueTV");
            }
            switch (i) {
                case 0:
                    assignment = assignment.getCategory();
                    break;
                case 1:
                    assignment = assignment.getDescription();
                    break;
                case 2:
                    if (assignment.isExtraCredit() == 0 || StringUtils.Companion.checkIfNumber(assignment.getMark()) == 0) {
                        if (Intrinsics.areEqual(assignment.getMark(), (Object) "NA") == 0 && Intrinsics.areEqual(assignment.getMark(), (Object) "TX") == 0) {
                            if (StringUtils.Companion.checkIfNumber(assignment.getMark()) != 0 || (Intrinsics.areEqual(assignment.getMark(), (Object) "") ^ 1) == 0) {
                                if (assignment.getRubricAssignMent() == 0) {
                                    double d = 0.0d;
                                    if ((Intrinsics.areEqual(assignment.getNumberPossible(), 0.0d) ^ 1) != 0) {
                                        i = "%s/%s";
                                        Object[] objArr = new Object[2];
                                        Companion companion = StringUtils.Companion;
                                        Double numberCorrect = assignment.getNumberCorrect();
                                        objArr[0] = companion.formatDecimals(numberCorrect != null ? numberCorrect.doubleValue() : 0.0d);
                                        Companion companion2 = StringUtils.Companion;
                                        assignment = assignment.getNumberPossible();
                                        if (assignment != null) {
                                            d = assignment.doubleValue();
                                        }
                                        objArr[1] = companion2.formatDecimals(d);
                                        assignment = String.format(i, Arrays.copyOf(objArr, objArr.length));
                                        Intrinsics.checkExpressionValueIsNotNull(assignment, "java.lang.String.format(this, *args)");
                                    }
                                }
                                assignment = String.valueOf(assignment.getNumberCorrect());
                            }
                        }
                        assignment = assignment.getMark();
                    } else {
                        assignment = String.valueOf(assignment.getScore());
                    }
                    assignment = (CharSequence) assignment;
                    break;
                case 3:
                    assignment = assignment.getGradebookName();
                    break;
                case 4:
                    assignment = DateUtils.Companion.parseDotNetDate(assignment.getDateAssigned());
                    break;
                case 5:
                    assignment = DateUtils.Companion.parseDotNetDate(assignment.getDateDue());
                    break;
                case 6:
                    if (Intrinsics.areEqual(assignment.getDateCompleted(), (Object) "/Date(-62135568000000)/") == 0) {
                        if (assignment.getDateCompleted() != 0) {
                            assignment = DateUtils.Companion.parseDotNetDate(assignment.getDateCompleted());
                            assignment = (CharSequence) assignment;
                            break;
                        }
                    }
                    assignment = "";
                    assignment = (CharSequence) assignment;
                case 7:
                    assignment = (CharSequence) (assignment.isGraded() != null ? "Yes" : "No");
                    break;
                case 8:
                    assignment = assignment.getComment();
                    break;
                case 9:
                    assignment = assignment.getAssignmentDescription();
                    break;
                default:
                    assignment = "";
                    break;
            }
            textView.setText(assignment);
        }
    }

    public final class AssignmentDetailHolder_ViewBinding implements Unbinder {
        private AssignmentDetailHolder target;

        @UiThread
        public AssignmentDetailHolder_ViewBinding(AssignmentDetailHolder assignmentDetailHolder, View view) {
            this.target = assignmentDetailHolder;
            assignmentDetailHolder.detailTitleTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitleTV'", TextView.class);
            assignmentDetailHolder.detailValueTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_value, "field 'detailValueTV'", TextView.class);
            assignmentDetailHolder.checkMark = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.check_mark, "field 'checkMark'", ImageView.class);
        }

        public void unbind() {
            AssignmentDetailHolder assignmentDetailHolder = this.target;
            if (assignmentDetailHolder != null) {
                this.target = null;
                assignmentDetailHolder.detailTitleTV = null;
                assignmentDetailHolder.detailValueTV = null;
                assignmentDetailHolder.checkMark = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public AssignmentDetailsAdapter(@NotNull Assignment assignment) {
        Intrinsics.checkParameterIsNotNull(assignment, "assignment");
        this.assignment = assignment;
    }

    @NotNull
    public final Assignment getAssignment() {
        return this.assignment;
    }

    @NotNull
    public final List<Integer> getTitles() {
        return this.titles;
    }

    public final int getSMALL_DETAIL() {
        return this.SMALL_DETAIL;
    }

    public final int getLARGE_DETAIL() {
        return this.LARGE_DETAIL;
    }

    public int getItemCount() {
        return this.titles.size();
    }

    @NotNull
    public AssignmentDetailHolder onCreateViewHolder(@Nullable ViewGroup viewGroup, int i) {
        viewGroup = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(i == this.SMALL_DETAIL ? C0316R.layout.holder_two_texts_white_font_no_margin : C0316R.layout.holder_two_texts_white_font_no_margin_vertical, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewGroup, "view");
        return new AssignmentDetailHolder(this, viewGroup);
    }

    public void onBindViewHolder(@Nullable AssignmentDetailHolder assignmentDetailHolder, int i) {
        if (assignmentDetailHolder != null) {
            assignmentDetailHolder.bindData(this.assignment, i);
        }
    }

    public int getItemViewType(int i) {
        return i == 9 ? this.LARGE_DETAIL : this.SMALL_DETAIL;
    }
}
