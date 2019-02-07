package com.aeries.mobileportal.views.custom;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.TextInputEditText;
import android.support.transition.TransitionManager;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.aeries.mobileportal.C0316R;
import com.aeries.mobileportal.enums.ScoreType;
import com.aeries.mobileportal.models.Assignment;
import com.aeries.mobileportal.models.MockAssignment;
import com.aeries.mobileportal.utils.StringUtils;
import com.aeries.mobileportal.utils.StringUtils.Companion;
import com.aeries.mobileportal.views.rowviewmodels.AssignmentRowViewModel;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010i\u001a\u00020jH\u0002J\b\u0010k\u001a\u00020jH\u0002J\b\u0010l\u001a\u00020jH\u0002J\b\u0010m\u001a\u00020jH\u0002J\b\u0010n\u001a\u00020jH\u0002J\b\u0010o\u001a\u00020jH\u0002J\u000e\u0010p\u001a\u00020j2\u0006\u0010q\u001a\u00020SJ\u0010\u0010r\u001a\u00020j2\u0006\u0010s\u001a\u00020tH\u0002J\u000e\u0010u\u001a\u00020j2\u0006\u0010J\u001a\u00020KJ\u0010\u0010v\u001a\u00020j2\u0006\u0010w\u001a\u00020tH\u0002J\u0010\u0010x\u001a\u00020j2\u0006\u0010y\u001a\u00020zH\u0002J\b\u0010{\u001a\u00020jH\u0002J\b\u0010|\u001a\u00020jH\u0002J\u0010\u0010}\u001a\u00020j2\u0006\u0010~\u001a\u00020tH\u0002J\u0011\u0010\u001a\u00020j2\u0007\u0010\u0001\u001a\u00020YH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001e\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001e\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001e\u0010)\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001e\u0010,\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001e\u0010/\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\b\"\u0004\b1\u0010\nR\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R\u001e\u0010;\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R\u001e\u0010>\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\nR\u001e\u0010A\u001a\u00020B8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010L\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\b\"\u0004\bN\u0010\nR\u001e\u0010O\u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010#\"\u0004\bQ\u0010%R\u001a\u0010R\u001a\u00020SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020YX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020YX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010[\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\b\"\u0004\b]\u0010\nR\u001e\u0010^\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00105\"\u0004\b`\u00107R\u000e\u0010a\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010b\u001a\u00020c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u000e\u0010h\u001a\u00020YX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AssignmentRowView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "assignmentDescriptionTV", "Landroid/widget/TextView;", "getAssignmentDescriptionTV", "()Landroid/widget/TextView;", "setAssignmentDescriptionTV", "(Landroid/widget/TextView;)V", "assignmentScoreTV", "getAssignmentScoreTV", "setAssignmentScoreTV", "assignmentTypeTV", "getAssignmentTypeTV", "setAssignmentTypeTV", "changeGradeTV", "getChangeGradeTV", "setChangeGradeTV", "checkMark", "Landroid/widget/ImageView;", "getCheckMark", "()Landroid/widget/ImageView;", "setCheckMark", "(Landroid/widget/ImageView;)V", "dataLayout", "Landroid/support/v7/widget/CardView;", "getDataLayout", "()Landroid/support/v7/widget/CardView;", "setDataLayout", "(Landroid/support/v7/widget/CardView;)V", "deleteOption", "Landroid/widget/LinearLayout;", "getDeleteOption", "()Landroid/widget/LinearLayout;", "setDeleteOption", "(Landroid/widget/LinearLayout;)V", "deleteOptionIcon", "getDeleteOptionIcon", "setDeleteOptionIcon", "deletedIcon", "getDeletedIcon", "setDeletedIcon", "disabledIcon", "getDisabledIcon", "setDisabledIcon", "dropTV", "getDropTV", "setDropTV", "editLayout", "Landroid/support/constraint/ConstraintLayout;", "getEditLayout", "()Landroid/support/constraint/ConstraintLayout;", "setEditLayout", "(Landroid/support/constraint/ConstraintLayout;)V", "editOption", "getEditOption", "setEditOption", "editedIcon", "getEditedIcon", "setEditedIcon", "extra", "getExtra", "setExtra", "gradeSeekBar", "Landroid/widget/SeekBar;", "getGradeSeekBar", "()Landroid/widget/SeekBar;", "setGradeSeekBar", "(Landroid/widget/SeekBar;)V", "infoHolder", "getInfoHolder", "setInfoHolder", "listener", "Lcom/aeries/mobileportal/views/custom/AssignmentRowView$AssignmentRowListener;", "missing", "getMissing", "setMissing", "modOptionsLayout", "getModOptionsLayout", "setModOptionsLayout", "model", "Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "getModel", "()Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;", "setModel", "(Lcom/aeries/mobileportal/views/rowviewmodels/AssignmentRowViewModel;)V", "modifyAssignmentCS", "Landroid/support/constraint/ConstraintSet;", "modifyOptionsAssignmentCS", "reset", "getReset", "setReset", "root", "getRoot", "setRoot", "rootView", "scoreET", "Landroid/support/design/widget/TextInputEditText;", "getScoreET", "()Landroid/support/design/widget/TextInputEditText;", "setScoreET", "(Landroid/support/design/widget/TextInputEditText;)V", "viewAssignmentCS", "clear", "", "defineConstraints", "hideEditView", "hideViews", "init", "setAssignmentText", "setData", "assignmentRowViewModel", "setDeleted", "isDeleted", "", "setListener", "setModified", "isModified", "setupEditView", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "setupListeners", "showHideEditView", "showSeekBar", "b", "transitionView", "constraintSet", "AssignmentRowListener", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentRowView.kt */
public final class AssignmentRowView extends RelativeLayout {
    private HashMap _$_findViewCache;
    @NotNull
    @BindView(2131361836)
    public TextView assignmentDescriptionTV;
    @NotNull
    @BindView(2131361840)
    public TextView assignmentScoreTV;
    @NotNull
    @BindView(2131361841)
    public TextView assignmentTypeTV;
    @NotNull
    @BindView(2131361869)
    public TextView changeGradeTV;
    @NotNull
    @BindView(2131361872)
    public ImageView checkMark;
    @NotNull
    @BindView(2131361857)
    public CardView dataLayout;
    @NotNull
    @BindView(2131361913)
    public LinearLayout deleteOption;
    @NotNull
    @BindView(2131361914)
    public ImageView deleteOptionIcon;
    @NotNull
    @BindView(2131361915)
    public ImageView deletedIcon;
    @NotNull
    @BindView(2131361934)
    public ImageView disabledIcon;
    @NotNull
    @BindView(2131361939)
    public TextView dropTV;
    @NotNull
    @BindView(2131361940)
    public ConstraintLayout editLayout;
    @NotNull
    @BindView(2131361941)
    public LinearLayout editOption;
    @NotNull
    @BindView(2131361943)
    public ImageView editedIcon;
    @NotNull
    @BindView(2131361958)
    public TextView extra;
    @NotNull
    @BindView(2131361979)
    public SeekBar gradeSeekBar;
    @NotNull
    @BindView(2131361976)
    public LinearLayout infoHolder;
    private AssignmentRowListener listener;
    @NotNull
    @BindView(2131362040)
    public TextView missing;
    @NotNull
    @BindView(2131362046)
    public LinearLayout modOptionsLayout;
    @NotNull
    private AssignmentRowViewModel model;
    private final ConstraintSet modifyAssignmentCS;
    private final ConstraintSet modifyOptionsAssignmentCS;
    @NotNull
    @BindView(2131362108)
    public TextView reset;
    @NotNull
    @BindView(2131361835)
    public ConstraintLayout root;
    private final RelativeLayout rootView;
    @NotNull
    @BindView(2131361977)
    public TextInputEditText scoreET;
    private final ConstraintSet viewAssignmentCS;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0017\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/aeries/mobileportal/views/custom/AssignmentRowView$AssignmentRowListener;", "", "isInEditMode", "", "onAssignmentNotEditable", "", "onClick", "assignment", "Lcom/aeries/mobileportal/models/Assignment;", "onDelete", "mockAssignment", "Lcom/aeries/mobileportal/models/MockAssignment;", "isMocked", "onModify", "onViewModified", "assignmentNumber", "", "(Ljava/lang/Integer;)V", "app_release"}, k = 1, mv = {1, 1, 10})
    /* compiled from: AssignmentRowView.kt */
    public interface AssignmentRowListener {
        boolean isInEditMode();

        void onAssignmentNotEditable();

        void onClick(@NotNull Assignment assignment);

        void onDelete(@NotNull MockAssignment mockAssignment, boolean z);

        void onModify(@NotNull MockAssignment mockAssignment);

        void onViewModified(@Nullable Integer num);
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

    public AssignmentRowView(@Nullable Context context) {
        super(context);
        context = RelativeLayout.inflate(context, C0316R.layout.holder_assignment, this);
        if (context != null) {
            this.rootView = (RelativeLayout) context;
            this.model = new AssignmentRowViewModel(new Assignment(), false, false, false, false, false, false, 112, null);
            this.viewAssignmentCS = new ConstraintSet();
            this.modifyOptionsAssignmentCS = new ConstraintSet();
            this.modifyAssignmentCS = new ConstraintSet();
            init();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }

    @NotNull
    public final ConstraintLayout getRoot() {
        ConstraintLayout constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        return constraintLayout;
    }

    public final void setRoot(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.root = constraintLayout;
    }

    @NotNull
    public final LinearLayout getInfoHolder() {
        LinearLayout linearLayout = this.infoHolder;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoHolder");
        }
        return linearLayout;
    }

    public final void setInfoHolder(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.infoHolder = linearLayout;
    }

    @NotNull
    public final ConstraintLayout getEditLayout() {
        ConstraintLayout constraintLayout = this.editLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLayout");
        }
        return constraintLayout;
    }

    public final void setEditLayout(@NotNull ConstraintLayout constraintLayout) {
        Intrinsics.checkParameterIsNotNull(constraintLayout, "<set-?>");
        this.editLayout = constraintLayout;
    }

    @NotNull
    public final LinearLayout getModOptionsLayout() {
        LinearLayout linearLayout = this.modOptionsLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modOptionsLayout");
        }
        return linearLayout;
    }

    public final void setModOptionsLayout(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.modOptionsLayout = linearLayout;
    }

    @NotNull
    public final LinearLayout getEditOption() {
        LinearLayout linearLayout = this.editOption;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editOption");
        }
        return linearLayout;
    }

    public final void setEditOption(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.editOption = linearLayout;
    }

    @NotNull
    public final LinearLayout getDeleteOption() {
        LinearLayout linearLayout = this.deleteOption;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteOption");
        }
        return linearLayout;
    }

    public final void setDeleteOption(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkParameterIsNotNull(linearLayout, "<set-?>");
        this.deleteOption = linearLayout;
    }

    @NotNull
    public final ImageView getDeleteOptionIcon() {
        ImageView imageView = this.deleteOptionIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteOptionIcon");
        }
        return imageView;
    }

    public final void setDeleteOptionIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.deleteOptionIcon = imageView;
    }

    @NotNull
    public final TextView getDropTV() {
        TextView textView = this.dropTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dropTV");
        }
        return textView;
    }

    public final void setDropTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.dropTV = textView;
    }

    @NotNull
    public final SeekBar getGradeSeekBar() {
        SeekBar seekBar = this.gradeSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSeekBar");
        }
        return seekBar;
    }

    public final void setGradeSeekBar(@NotNull SeekBar seekBar) {
        Intrinsics.checkParameterIsNotNull(seekBar, "<set-?>");
        this.gradeSeekBar = seekBar;
    }

    @NotNull
    public final TextInputEditText getScoreET() {
        TextInputEditText textInputEditText = this.scoreET;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreET");
        }
        return textInputEditText;
    }

    public final void setScoreET(@NotNull TextInputEditText textInputEditText) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "<set-?>");
        this.scoreET = textInputEditText;
    }

    @NotNull
    public final TextView getChangeGradeTV() {
        TextView textView = this.changeGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGradeTV");
        }
        return textView;
    }

    public final void setChangeGradeTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.changeGradeTV = textView;
    }

    @NotNull
    public final TextView getReset() {
        TextView textView = this.reset;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reset");
        }
        return textView;
    }

    public final void setReset(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.reset = textView;
    }

    @NotNull
    public final CardView getDataLayout() {
        CardView cardView = this.dataLayout;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLayout");
        }
        return cardView;
    }

    public final void setDataLayout(@NotNull CardView cardView) {
        Intrinsics.checkParameterIsNotNull(cardView, "<set-?>");
        this.dataLayout = cardView;
    }

    @NotNull
    public final TextView getAssignmentDescriptionTV() {
        TextView textView = this.assignmentDescriptionTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDescriptionTV");
        }
        return textView;
    }

    public final void setAssignmentDescriptionTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.assignmentDescriptionTV = textView;
    }

    @NotNull
    public final TextView getAssignmentTypeTV() {
        TextView textView = this.assignmentTypeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentTypeTV");
        }
        return textView;
    }

    public final void setAssignmentTypeTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.assignmentTypeTV = textView;
    }

    @NotNull
    public final TextView getMissing() {
        TextView textView = this.missing;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("missing");
        }
        return textView;
    }

    public final void setMissing(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.missing = textView;
    }

    @NotNull
    public final TextView getExtra() {
        TextView textView = this.extra;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extra");
        }
        return textView;
    }

    public final void setExtra(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.extra = textView;
    }

    @NotNull
    public final ImageView getEditedIcon() {
        ImageView imageView = this.editedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedIcon");
        }
        return imageView;
    }

    public final void setEditedIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.editedIcon = imageView;
    }

    @NotNull
    public final ImageView getDeletedIcon() {
        ImageView imageView = this.deletedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deletedIcon");
        }
        return imageView;
    }

    public final void setDeletedIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.deletedIcon = imageView;
    }

    @NotNull
    public final ImageView getDisabledIcon() {
        ImageView imageView = this.disabledIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disabledIcon");
        }
        return imageView;
    }

    public final void setDisabledIcon(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.disabledIcon = imageView;
    }

    @NotNull
    public final TextView getAssignmentScoreTV() {
        TextView textView = this.assignmentScoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
        }
        return textView;
    }

    public final void setAssignmentScoreTV(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.assignmentScoreTV = textView;
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

    @NotNull
    public final AssignmentRowViewModel getModel() {
        return this.model;
    }

    public final void setModel(@NotNull AssignmentRowViewModel assignmentRowViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentRowViewModel, "<set-?>");
        this.model = assignmentRowViewModel;
    }

    private final void init() {
        ButterKnife.bind((Object) this, (View) this.rootView);
        defineConstraints();
        setupListeners();
    }

    private final void setupListeners() {
        LinearLayout linearLayout = this.infoHolder;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoHolder");
        }
        linearLayout.setOnClickListener(new AssignmentRowView$setupListeners$1(this));
        linearLayout = this.editOption;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editOption");
        }
        linearLayout.setOnClickListener(new AssignmentRowView$setupListeners$2(this));
        linearLayout = this.deleteOption;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteOption");
        }
        linearLayout.setOnClickListener(new AssignmentRowView$setupListeners$3(this));
        SeekBar seekBar = this.gradeSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSeekBar");
        }
        seekBar.setOnSeekBarChangeListener(new AssignmentRowView$setupListeners$4(this));
        TextInputEditText textInputEditText = this.scoreET;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreET");
        }
        textInputEditText.setOnEditorActionListener(new AssignmentRowView$setupListeners$5(this));
        TextView textView = this.reset;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reset");
        }
        textView.setOnClickListener(new AssignmentRowView$setupListeners$6(this));
    }

    private final void setDeleted(boolean z) {
        TextView textView;
        this.model.setDeleted(z);
        setModified(this.model.isModified());
        ImageView imageView = this.deletedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deletedIcon");
        }
        int i = 0;
        imageView.setVisibility(z ? 0 : 4);
        if (z) {
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            textView.setText("N/A");
        } else {
            setAssignmentText();
        }
        imageView = this.deleteOptionIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteOptionIcon");
        }
        imageView.setImageResource(z ? C0316R.drawable.recover_icon : C0316R.drawable.delete_icon);
        textView = this.dropTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dropTV");
        }
        textView.setText(z ? C0316R.string.recover : C0316R.string.drop);
        LinearLayout linearLayout = this.editOption;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editOption");
        }
        if (z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
    }

    private final void setModified(boolean z) {
        this.model.setModified(z);
        ImageView imageView = this.editedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedIcon");
        }
        z = ((z || this.model.isMocked()) && !this.model.isDeleted()) ? false : true;
        imageView.setVisibility(z);
    }

    private final void defineConstraints() {
        ConstraintSet constraintSet = this.viewAssignmentCS;
        ConstraintLayout constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        constraintSet.clone(constraintLayout);
        constraintSet = this.modifyOptionsAssignmentCS;
        constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        constraintSet.clone(constraintLayout);
        this.modifyOptionsAssignmentCS.setVisibility(C0316R.id.mod_options_layout, 0);
        constraintSet = this.modifyAssignmentCS;
        constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        constraintSet.clone(constraintLayout);
        this.modifyAssignmentCS.setVisibility(C0316R.id.edit_grade_layout, 0);
    }

    private final void showHideEditView() {
        this.model.setEditShowing(this.model.isEditShowing() ^ 1);
        this.model.setModifying(false);
        AssignmentRowListener assignmentRowListener = this.listener;
        if (assignmentRowListener != null) {
            assignmentRowListener.onViewModified(this.model.getAssignment().getAssignmentNumber());
        }
        transitionView(this.model.isEditShowing() ? this.modifyOptionsAssignmentCS : this.viewAssignmentCS);
    }

    private final void hideEditView() {
        transitionView(this.viewAssignmentCS);
    }

    private final void transitionView(ConstraintSet constraintSet) {
        ConstraintLayout constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        constraintSet.applyTo(constraintLayout);
    }

    public final void setData(@NotNull AssignmentRowViewModel assignmentRowViewModel) {
        Intrinsics.checkParameterIsNotNull(assignmentRowViewModel, "assignmentRowViewModel");
        this.model = assignmentRowViewModel;
        assignmentRowViewModel = assignmentRowViewModel.getAssignment();
        clear();
        hideViews();
        setupEditView(assignmentRowViewModel);
        TextView textView = this.assignmentDescriptionTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentDescriptionTV");
        }
        textView.setText(assignmentRowViewModel.getDescription());
        textView = this.assignmentTypeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentTypeTV");
        }
        textView.setText(assignmentRowViewModel.getCategory());
        setAssignmentText();
    }

    private final void setupEditView(Assignment assignment) {
        int mockedProgress;
        TextView textView = this.changeGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGradeTV");
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(C0316R.string.grade_score);
        Intrinsics.checkExpressionValueIsNotNull(string, "context.getString(R.string.grade_score)");
        Object[] objArr = new Object[1];
        Double maxScore = assignment.getMaxScore();
        objArr[0] = maxScore != null ? Integer.valueOf((int) maxScore.doubleValue()) : null;
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(string, "java.lang.String.format(format, *args)");
        textView.setText(string);
        SeekBar seekBar = this.gradeSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSeekBar");
        }
        seekBar.setMax(this.model.getSeekBarMax());
        seekBar = this.gradeSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSeekBar");
        }
        if (this.model.isModified() && this.model.isSeekbarShowing()) {
            mockedProgress = ((int) this.model.getMockedProgress()) * 10;
        } else {
            mockedProgress = this.model.getSeekBarInitProgress();
        }
        seekBar.setProgress(mockedProgress);
        TextInputEditText textInputEditText = this.scoreET;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scoreET");
        }
        if (this.model.isModified()) {
            assignment = this.model.getMockedGrade();
        } else {
            assignment = String.valueOf(assignment.getScore());
        }
        textInputEditText.setText((CharSequence) assignment);
    }

    public final void setListener(@NotNull AssignmentRowListener assignmentRowListener) {
        Intrinsics.checkParameterIsNotNull(assignmentRowListener, CastExtraArgs.LISTENER);
        this.listener = assignmentRowListener;
    }

    private final void hideViews() {
        ConstraintSet constraintSet;
        if (!this.model.isEditShowing()) {
            constraintSet = this.viewAssignmentCS;
        } else if (this.model.isModifying()) {
            constraintSet = this.modifyAssignmentCS;
        } else {
            constraintSet = this.modifyOptionsAssignmentCS;
        }
        ConstraintLayout constraintLayout = this.root;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        }
        constraintSet.applyTo(constraintLayout);
        int i = 0;
        TextView textView;
        if (this.model.getAssignment().isExtraCredit()) {
            textView = this.extra;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("extra");
            }
            textView.setVisibility(0);
        } else if (this.model.isMissing()) {
            textView = this.missing;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("missing");
            }
            textView.setVisibility(0);
        }
        ImageView imageView = this.disabledIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disabledIcon");
        }
        if (this.model.isEditDisabled()) {
            AssignmentRowListener assignmentRowListener = this.listener;
            if (assignmentRowListener != null && assignmentRowListener.isInEditMode()) {
                imageView.setVisibility(i);
                showSeekBar(this.model.isSeekbarShowing());
                setModified(this.model.isModified());
                setDeleted(this.model.isDeleted());
            }
        }
        i = 4;
        imageView.setVisibility(i);
        showSeekBar(this.model.isSeekbarShowing());
        setModified(this.model.isModified());
        setDeleted(this.model.isDeleted());
    }

    private final void showSeekBar(boolean z) {
        SeekBar seekBar = this.gradeSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gradeSeekBar");
        }
        int i = 8;
        seekBar.setVisibility(z ? 0 : 8);
        TextView textView = this.changeGradeTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGradeTV");
        }
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    private final void setAssignmentText() {
        TextView textView = this.assignmentScoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
        }
        textView.setVisibility(0);
        ImageView imageView = this.checkMark;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkMark");
        }
        imageView.setVisibility(8);
        textView = this.assignmentScoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
        }
        textView.setBackgroundColor(getResources().getColor(C0316R.color.gray1));
        if (this.model.isDeleted()) {
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            textView.setText("N/A");
        } else if (this.model.isMocked()) {
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            String str = "%s/%s";
            Object[] objArr = new Object[2];
            Companion companion = StringUtils.Companion;
            Double score = this.model.getAssignment().getScore();
            double d = 0.0d;
            objArr[0] = companion.formatDecimals(score != null ? score.doubleValue() : 0.0d);
            companion = StringUtils.Companion;
            score = this.model.getAssignment().getMaxScore();
            if (score != null) {
                d = score.doubleValue();
            }
            objArr[1] = companion.formatDecimals(d);
            String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
            textView.setText(format);
        } else if (this.model.isModified()) {
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            textView.setText(this.model.getMockedGrade());
        } else if (Intrinsics.areEqual(this.model.getGradeText(), ScoreType.Companion.getCHECK_MARK())) {
            Object obj;
            String mark = this.model.getAssignment().getMark();
            if (mark == null) {
                obj = null;
            } else if (mark != null) {
                obj = mark.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(obj, "(this as java.lang.String).toLowerCase()");
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            if (Intrinsics.areEqual(obj, (Object) "scored")) {
                imageView = this.checkMark;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("checkMark");
                }
                imageView.setVisibility(0);
                textView = this.assignmentScoreTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
                }
                textView.setText("");
                textView = this.assignmentScoreTV;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
                }
                textView.setBackgroundColor(getResources().getColor(C0316R.color.check_mark_bg));
                return;
            }
            imageView = this.checkMark;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkMark");
            }
            imageView.setVisibility(8);
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            textView.setVisibility(8);
        } else {
            textView = this.assignmentScoreTV;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
            }
            textView.setText(this.model.getGradeText());
        }
    }

    private final void clear() {
        LinearLayout linearLayout = this.modOptionsLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("modOptionsLayout");
        }
        linearLayout.setVisibility(8);
        ConstraintLayout constraintLayout = this.editLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editLayout");
        }
        constraintLayout.setVisibility(8);
        ImageView imageView = this.editedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editedIcon");
        }
        imageView.setVisibility(4);
        imageView = this.deletedIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deletedIcon");
        }
        imageView.setVisibility(4);
        TextView textView = this.missing;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("missing");
        }
        textView.setVisibility(4);
        textView = this.extra;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("extra");
        }
        textView.setVisibility(4);
        imageView = this.checkMark;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkMark");
        }
        imageView.setVisibility(8);
        textView = this.assignmentScoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
        }
        textView.setBackgroundColor(getResources().getColor(C0316R.color.gray1));
        textView = this.assignmentScoreTV;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("assignmentScoreTV");
        }
        textView.setText("");
    }
}
