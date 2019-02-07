package com.aeries.mobileportal.views.custom;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AssignmentRowView_ViewBinding implements Unbinder {
    private AssignmentRowView target;

    @UiThread
    public AssignmentRowView_ViewBinding(AssignmentRowView assignmentRowView) {
        this(assignmentRowView, assignmentRowView);
    }

    @UiThread
    public AssignmentRowView_ViewBinding(AssignmentRowView assignmentRowView, View view) {
        this.target = assignmentRowView;
        assignmentRowView.root = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.assignment_constraint_layout, "field 'root'", ConstraintLayout.class);
        assignmentRowView.infoHolder = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.grade_info_holder, "field 'infoHolder'", LinearLayout.class);
        assignmentRowView.editLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.edit_grade_layout, "field 'editLayout'", ConstraintLayout.class);
        assignmentRowView.modOptionsLayout = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.mod_options_layout, "field 'modOptionsLayout'", LinearLayout.class);
        assignmentRowView.editOption = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.edit_option, "field 'editOption'", LinearLayout.class);
        assignmentRowView.deleteOption = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.delete_option, "field 'deleteOption'", LinearLayout.class);
        assignmentRowView.deleteOptionIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.delete_option_icon, "field 'deleteOptionIcon'", ImageView.class);
        assignmentRowView.dropTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.drop_tv, "field 'dropTV'", TextView.class);
        assignmentRowView.gradeSeekBar = (SeekBar) Utils.findRequiredViewAsType(view, C0316R.id.grade_seek_bar, "field 'gradeSeekBar'", SeekBar.class);
        assignmentRowView.scoreET = (TextInputEditText) Utils.findRequiredViewAsType(view, C0316R.id.grade_input, "field 'scoreET'", TextInputEditText.class);
        assignmentRowView.changeGradeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.changed_grade_tv, "field 'changeGradeTV'", TextView.class);
        assignmentRowView.reset = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.reset, "field 'reset'", TextView.class);
        assignmentRowView.dataLayout = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.cardView, "field 'dataLayout'", CardView.class);
        assignmentRowView.assignmentDescriptionTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.assignment_description, "field 'assignmentDescriptionTV'", TextView.class);
        assignmentRowView.assignmentTypeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.assignment_type, "field 'assignmentTypeTV'", TextView.class);
        assignmentRowView.missing = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.missing, "field 'missing'", TextView.class);
        assignmentRowView.extra = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.extra, "field 'extra'", TextView.class);
        assignmentRowView.editedIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.edited_icon, "field 'editedIcon'", ImageView.class);
        assignmentRowView.deletedIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.deleted_icon, "field 'deletedIcon'", ImageView.class);
        assignmentRowView.disabledIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.disabled_icon, "field 'disabledIcon'", ImageView.class);
        assignmentRowView.assignmentScoreTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.assignment_score, "field 'assignmentScoreTV'", TextView.class);
        assignmentRowView.checkMark = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.check_mark, "field 'checkMark'", ImageView.class);
    }

    public void unbind() {
        AssignmentRowView assignmentRowView = this.target;
        if (assignmentRowView != null) {
            this.target = null;
            assignmentRowView.root = null;
            assignmentRowView.infoHolder = null;
            assignmentRowView.editLayout = null;
            assignmentRowView.modOptionsLayout = null;
            assignmentRowView.editOption = null;
            assignmentRowView.deleteOption = null;
            assignmentRowView.deleteOptionIcon = null;
            assignmentRowView.dropTV = null;
            assignmentRowView.gradeSeekBar = null;
            assignmentRowView.scoreET = null;
            assignmentRowView.changeGradeTV = null;
            assignmentRowView.reset = null;
            assignmentRowView.dataLayout = null;
            assignmentRowView.assignmentDescriptionTV = null;
            assignmentRowView.assignmentTypeTV = null;
            assignmentRowView.missing = null;
            assignmentRowView.extra = null;
            assignmentRowView.editedIcon = null;
            assignmentRowView.deletedIcon = null;
            assignmentRowView.disabledIcon = null;
            assignmentRowView.assignmentScoreTV = null;
            assignmentRowView.checkMark = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
