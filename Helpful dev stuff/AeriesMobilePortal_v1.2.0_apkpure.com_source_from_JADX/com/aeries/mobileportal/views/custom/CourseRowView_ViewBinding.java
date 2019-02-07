package com.aeries.mobileportal.views.custom;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class CourseRowView_ViewBinding implements Unbinder {
    private CourseRowView target;

    @UiThread
    public CourseRowView_ViewBinding(CourseRowView courseRowView) {
        this(courseRowView, courseRowView);
    }

    @UiThread
    public CourseRowView_ViewBinding(CourseRowView courseRowView, View view) {
        this.target = courseRowView;
        courseRowView.courseHolder = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.course_holder, "field 'courseHolder'", ConstraintLayout.class);
        courseRowView.schoolNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.school_name, "field 'schoolNameTV'", TextView.class);
        courseRowView.mockGradeHolder = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.mock_grade_holder, "field 'mockGradeHolder'", ConstraintLayout.class);
        courseRowView.mockGradeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.mock_course_grade, "field 'mockGradeTV'", TextView.class);
        courseRowView.mockPercentTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.mock_course_percent, "field 'mockPercentTV'", TextView.class);
        courseRowView.editedTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.edited_tv, "field 'editedTV'", TextView.class);
        courseRowView.gradeHolder = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.grade_holder, "field 'gradeHolder'", ConstraintLayout.class);
        courseRowView.courseGradeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.course_grade, "field 'courseGradeTV'", TextView.class);
        courseRowView.coursePercentTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.course_percent, "field 'coursePercentTV'", TextView.class);
        courseRowView.currentTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.current_tv, "field 'currentTV'", TextView.class);
        courseRowView.courseToggleCardView = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.course_toggle, "field 'courseToggleCardView'", CardView.class);
        courseRowView.toggleIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.toggle_icon, "field 'toggleIcon'", ImageView.class);
        courseRowView.courseNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.course_name, "field 'courseNameTV'", TextView.class);
        courseRowView.courseTeacherTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.course_teacher, "field 'courseTeacherTV'", TextView.class);
        courseRowView.lastUpdated = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.last_updated, "field 'lastUpdated'", TextView.class);
    }

    public void unbind() {
        CourseRowView courseRowView = this.target;
        if (courseRowView != null) {
            this.target = null;
            courseRowView.courseHolder = null;
            courseRowView.schoolNameTV = null;
            courseRowView.mockGradeHolder = null;
            courseRowView.mockGradeTV = null;
            courseRowView.mockPercentTV = null;
            courseRowView.editedTV = null;
            courseRowView.gradeHolder = null;
            courseRowView.courseGradeTV = null;
            courseRowView.coursePercentTV = null;
            courseRowView.currentTV = null;
            courseRowView.courseToggleCardView = null;
            courseRowView.toggleIcon = null;
            courseRowView.courseNameTV = null;
            courseRowView.courseTeacherTV = null;
            courseRowView.lastUpdated = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
