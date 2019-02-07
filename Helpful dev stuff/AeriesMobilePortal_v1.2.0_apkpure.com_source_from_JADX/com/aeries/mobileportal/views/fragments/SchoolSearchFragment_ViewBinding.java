package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class SchoolSearchFragment_ViewBinding implements Unbinder {
    private SchoolSearchFragment target;

    @UiThread
    public SchoolSearchFragment_ViewBinding(SchoolSearchFragment schoolSearchFragment, View view) {
        this.target = schoolSearchFragment;
        schoolSearchFragment.searchview = (SearchView) Utils.findRequiredViewAsType(view, C0316R.id.school_searchbox, "field 'searchview'", SearchView.class);
        schoolSearchFragment.title = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.title, "field 'title'", TextView.class);
        schoolSearchFragment.subtitle = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.subtitle, "field 'subtitle'", TextView.class);
        schoolSearchFragment.nearYouMessage = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.schools_near_you, "field 'nearYouMessage'", TextView.class);
        schoolSearchFragment.message = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.message, "field 'message'", TextView.class);
        schoolSearchFragment.schoolRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.school_result_recyclerview, "field 'schoolRecyclerView'", RecyclerView.class);
        schoolSearchFragment.noResult = (LinearLayout) Utils.findRequiredViewAsType(view, C0316R.id.school_not_found, "field 'noResult'", LinearLayout.class);
        schoolSearchFragment.learnMoreTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.learn_more_link, "field 'learnMoreTV'", TextView.class);
        schoolSearchFragment.nearbyScoolsProgress = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.nearby_school_progress, "field 'nearbyScoolsProgress'", ProgressBar.class);
        schoolSearchFragment.nearbySchoolsMessage = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.nearby_school_message, "field 'nearbySchoolsMessage'", TextView.class);
    }

    public void unbind() {
        SchoolSearchFragment schoolSearchFragment = this.target;
        if (schoolSearchFragment != null) {
            this.target = null;
            schoolSearchFragment.searchview = null;
            schoolSearchFragment.title = null;
            schoolSearchFragment.subtitle = null;
            schoolSearchFragment.nearYouMessage = null;
            schoolSearchFragment.message = null;
            schoolSearchFragment.schoolRecyclerView = null;
            schoolSearchFragment.noResult = null;
            schoolSearchFragment.learnMoreTV = null;
            schoolSearchFragment.nearbyScoolsProgress = null;
            schoolSearchFragment.nearbySchoolsMessage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
