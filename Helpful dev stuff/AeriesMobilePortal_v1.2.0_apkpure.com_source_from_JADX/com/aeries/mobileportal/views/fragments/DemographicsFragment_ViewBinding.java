package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class DemographicsFragment_ViewBinding implements Unbinder {
    private DemographicsFragment target;

    @UiThread
    public DemographicsFragment_ViewBinding(DemographicsFragment demographicsFragment, View view) {
        this.target = demographicsFragment;
        demographicsFragment.demographicsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.demographics_rv, "field 'demographicsRV'", RecyclerView.class);
    }

    public void unbind() {
        DemographicsFragment demographicsFragment = this.target;
        if (demographicsFragment != null) {
            this.target = null;
            demographicsFragment.demographicsRV = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
