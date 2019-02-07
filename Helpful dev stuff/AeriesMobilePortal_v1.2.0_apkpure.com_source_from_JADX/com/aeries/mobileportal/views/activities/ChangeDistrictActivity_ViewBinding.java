package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ChangeDistrictActivity_ViewBinding implements Unbinder {
    private ChangeDistrictActivity target;

    @UiThread
    public ChangeDistrictActivity_ViewBinding(ChangeDistrictActivity changeDistrictActivity) {
        this(changeDistrictActivity, changeDistrictActivity.getWindow().getDecorView());
    }

    @UiThread
    public ChangeDistrictActivity_ViewBinding(ChangeDistrictActivity changeDistrictActivity, View view) {
        this.target = changeDistrictActivity;
        changeDistrictActivity.districtsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.districts_recycler_view, "field 'districtsRV'", RecyclerView.class);
        changeDistrictActivity.currentDistrict = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.current_district, "field 'currentDistrict'", TextView.class);
        changeDistrictActivity.noDistrictsMessage = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.no_districts_message, "field 'noDistrictsMessage'", TextView.class);
    }

    public void unbind() {
        ChangeDistrictActivity changeDistrictActivity = this.target;
        if (changeDistrictActivity != null) {
            this.target = null;
            changeDistrictActivity.districtsRV = null;
            changeDistrictActivity.currentDistrict = null;
            changeDistrictActivity.noDistrictsMessage = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
