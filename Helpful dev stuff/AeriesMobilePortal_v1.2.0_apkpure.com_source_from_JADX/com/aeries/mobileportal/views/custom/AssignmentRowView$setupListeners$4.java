package com.aeries.mobileportal.views.custom;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.aeries.mobileportal.enums.ScoreType;
import com.aeries.mobileportal.views.custom.AssignmentRowView.AssignmentRowListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"com/aeries/mobileportal/views/custom/AssignmentRowView$setupListeners$4", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "(Lcom/aeries/mobileportal/views/custom/AssignmentRowView;)V", "onProgressChanged", "", "p0", "Landroid/widget/SeekBar;", "p1", "", "p2", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: AssignmentRowView.kt */
public final class AssignmentRowView$setupListeners$4 implements OnSeekBarChangeListener {
    final /* synthetic */ AssignmentRowView this$0;

    public void onStartTrackingTouch(@Nullable SeekBar seekBar) {
    }

    AssignmentRowView$setupListeners$4(AssignmentRowView assignmentRowView) {
        this.this$0 = assignmentRowView;
    }

    public void onProgressChanged(@Nullable SeekBar seekBar, int i, boolean z) {
        seekBar = String.valueOf(seekBar != null ? Double.valueOf(((double) seekBar.getProgress()) / 10.0d) : null);
        if (z) {
            this.this$0.getScoreET().setText((CharSequence) seekBar);
        } else {
            this.this$0.getAssignmentScoreTV().setText(ScoreType.Companion.getScoreType(this.this$0.getModel().getAssignment()).getMockedString(this.this$0.getModel().getAssignment(), seekBar));
        }
    }

    public void onStopTrackingTouch(@Nullable SeekBar seekBar) {
        seekBar = String.valueOf(seekBar != null ? Double.valueOf(((double) seekBar.getProgress()) / 10.0d) : null);
        AssignmentRowListener access$getListener$p = this.this$0.listener;
        if (access$getListener$p != null) {
            access$getListener$p.onModify(this.this$0.getModel().mockAssignment(seekBar));
        }
        this.this$0.setModified(true);
        this.this$0.getAssignmentScoreTV().setText(ScoreType.Companion.getScoreType(this.this$0.getModel().getAssignment()).getMockedString(this.this$0.getModel().getAssignment(), seekBar));
    }
}
