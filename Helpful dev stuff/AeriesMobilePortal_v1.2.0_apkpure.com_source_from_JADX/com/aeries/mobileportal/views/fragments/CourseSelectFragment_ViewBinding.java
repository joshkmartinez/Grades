package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class CourseSelectFragment_ViewBinding implements Unbinder {
    private CourseSelectFragment target;

    @UiThread
    public CourseSelectFragment_ViewBinding(CourseSelectFragment courseSelectFragment, View view) {
        this.target = courseSelectFragment;
        courseSelectFragment.coursesRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.courses_recycler_view, "field 'coursesRV'", RecyclerView.class);
        courseSelectFragment.termSpinner = (Spinner) Utils.findRequiredViewAsType(view, C0316R.id.term_spinner, "field 'termSpinner'", Spinner.class);
        courseSelectFragment.noCoursesTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.no_courses_tv, "field 'noCoursesTV'", TextView.class);
        courseSelectFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        CourseSelectFragment courseSelectFragment = this.target;
        if (courseSelectFragment != null) {
            this.target = null;
            courseSelectFragment.coursesRV = null;
            courseSelectFragment.termSpinner = null;
            courseSelectFragment.noCoursesTV = null;
            courseSelectFragment.progressBar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
