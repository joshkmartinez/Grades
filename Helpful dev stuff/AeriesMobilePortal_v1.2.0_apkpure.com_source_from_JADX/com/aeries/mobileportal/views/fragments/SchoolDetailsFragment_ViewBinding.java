package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class SchoolDetailsFragment_ViewBinding implements Unbinder {
    private SchoolDetailsFragment target;
    private View view2131362145;

    @UiThread
    public SchoolDetailsFragment_ViewBinding(final SchoolDetailsFragment schoolDetailsFragment, View view) {
        this.target = schoolDetailsFragment;
        schoolDetailsFragment.schoolNameTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.school_name, "field 'schoolNameTV'", TextView.class);
        schoolDetailsFragment.countyTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.county, "field 'countyTV'", TextView.class);
        schoolDetailsFragment.streetTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.street, "field 'streetTV'", TextView.class);
        schoolDetailsFragment.cityTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.city, "field 'cityTV'", TextView.class);
        schoolDetailsFragment.zipCodeTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.zip_code, "field 'zipCodeTV'", TextView.class);
        schoolDetailsFragment.stateTV = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.state, "field 'stateTV'", TextView.class);
        view = Utils.findRequiredView(view, C0316R.id.select_school_button, "field 'selectSchoolButton' and method 'onButtonPressed'");
        schoolDetailsFragment.selectSchoolButton = (Button) Utils.castView(view, C0316R.id.select_school_button, "field 'selectSchoolButton'", Button.class);
        this.view2131362145 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                schoolDetailsFragment.onButtonPressed();
            }
        });
    }

    public void unbind() {
        SchoolDetailsFragment schoolDetailsFragment = this.target;
        if (schoolDetailsFragment != null) {
            this.target = null;
            schoolDetailsFragment.schoolNameTV = null;
            schoolDetailsFragment.countyTV = null;
            schoolDetailsFragment.streetTV = null;
            schoolDetailsFragment.cityTV = null;
            schoolDetailsFragment.zipCodeTV = null;
            schoolDetailsFragment.stateTV = null;
            schoolDetailsFragment.selectSchoolButton = null;
            this.view2131362145.setOnClickListener(null);
            this.view2131362145 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
