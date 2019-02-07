package com.aeries.mobileportal.views.custom;

import android.view.KeyEvent;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aeries.mobileportal.enums.ScoreType;
import com.aeries.mobileportal.utils.KeyboardUtils;
import com.aeries.mobileportal.views.custom.AssignmentRowView.AssignmentRowListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "p0", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "p1", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentRowView.kt */
final class AssignmentRowView$setupListeners$5 implements OnEditorActionListener {
    final /* synthetic */ AssignmentRowView this$0;

    AssignmentRowView$setupListeners$5(AssignmentRowView assignmentRowView) {
        this.this$0 = assignmentRowView;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        keyEvent = null;
        if (i != 6) {
            return false;
        }
        Intrinsics.checkExpressionValueIsNotNull(textView, "p0");
        if ((Intrinsics.areEqual(textView.getText().toString(), (Object) "") ^ 1) == 0) {
            return false;
        }
        Object obj = this.this$0.getScoreET().getText().toString();
        AssignmentRowListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onModify(this.this$0.getModel().mockAssignment(obj));
        }
        this.this$0.setModified(true);
        if ((Intrinsics.areEqual(this.this$0.getModel().getAssignment().getMaxScore(), 0.0d) ^ 1) != 0) {
            SeekBar gradeSeekBar = this.this$0.getGradeSeekBar();
            if ((Intrinsics.areEqual(obj, (Object) "") ^ 1) != 0) {
                keyEvent = (int) (Float.parseFloat(obj) * ((float) 10));
            }
            gradeSeekBar.setProgress(keyEvent);
        }
        this.this$0.getAssignmentScoreTV().setText(ScoreType.Companion.getScoreType(this.this$0.getModel().getAssignment()).getMockedString(this.this$0.getModel().getAssignment(), obj));
        KeyboardUtils.Companion.hideKeyboard(textView);
        return 1;
    }
}
