package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class DemographicsActivity_ViewBinding implements Unbinder {
    private DemographicsActivity target;
    private View view2131361925;

    @UiThread
    public DemographicsActivity_ViewBinding(DemographicsActivity demographicsActivity) {
        this(demographicsActivity, demographicsActivity.getWindow().getDecorView());
    }

    @UiThread
    public DemographicsActivity_ViewBinding(final DemographicsActivity demographicsActivity, View view) {
        this.target = demographicsActivity;
        demographicsActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_name, "field 'detailName' and method 'closeActivity'");
        demographicsActivity.detailName = (TextView) Utils.castView(findRequiredView, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        this.view2131361925 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                demographicsActivity.closeActivity();
            }
        });
        demographicsActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        demographicsActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        demographicsActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        DemographicsActivity demographicsActivity = this.target;
        if (demographicsActivity != null) {
            this.target = null;
            demographicsActivity.detailTitle = null;
            demographicsActivity.detailName = null;
            demographicsActivity.detailIcon = null;
            demographicsActivity.fragmentContainer = null;
            demographicsActivity.progressBar = null;
            this.view2131361925.setOnClickListener(null);
            this.view2131361925 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
