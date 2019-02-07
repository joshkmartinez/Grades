package com.aeries.mobileportal.views.custom;

import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import com.aeries.mobileportal.views.custom.AssignmentRowView.AssignmentRowListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: AssignmentRowView.kt */
final class AssignmentRowView$setupListeners$6 implements OnClickListener {
    final /* synthetic */ AssignmentRowView this$0;

    AssignmentRowView$setupListeners$6(AssignmentRowView assignmentRowView) {
        this.this$0 = assignmentRowView;
    }

    public final void onClick(View view) {
        view = this.this$0.getModel().getAssignment();
        TextInputEditText scoreET = this.this$0.getScoreET();
        Double score = view.getScore();
        scoreET.setText(score != null ? String.valueOf(score.doubleValue()) : null);
        SeekBar gradeSeekBar = this.this$0.getGradeSeekBar();
        score = view.getScore();
        gradeSeekBar.setProgress(score != null ? (int) (score.doubleValue() * ((double) 10)) : 0);
        AssignmentRowListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            if ((Intrinsics.areEqual(view.getNumberCorrect(), 0.0d) ^ 1) == 0 || (Intrinsics.areEqual(view.getScore(), 0.0d) ^ 1) == 0) {
                view = this.this$0.getModel().mockDeletedAssignment();
            } else {
                view = this.this$0.getModel().mockAssignment(String.valueOf(view.getScore()));
            }
            access$getListener$p.onModify(view);
        }
        this.this$0.setAssignmentText();
        this.this$0.setModified(false);
    }
}
