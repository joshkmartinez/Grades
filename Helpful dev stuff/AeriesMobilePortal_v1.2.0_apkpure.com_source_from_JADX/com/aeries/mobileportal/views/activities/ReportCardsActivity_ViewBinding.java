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

public final class ReportCardsActivity_ViewBinding implements Unbinder {
    private ReportCardsActivity target;
    private View view2131361925;

    @UiThread
    public ReportCardsActivity_ViewBinding(ReportCardsActivity reportCardsActivity) {
        this(reportCardsActivity, reportCardsActivity.getWindow().getDecorView());
    }

    @UiThread
    public ReportCardsActivity_ViewBinding(final ReportCardsActivity reportCardsActivity, View view) {
        this.target = reportCardsActivity;
        reportCardsActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_name, "field 'detailName' and method 'closeActivity'");
        reportCardsActivity.detailName = (TextView) Utils.castView(findRequiredView, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        this.view2131361925 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                reportCardsActivity.closeActivity();
            }
        });
        reportCardsActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        reportCardsActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        reportCardsActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        ReportCardsActivity reportCardsActivity = this.target;
        if (reportCardsActivity != null) {
            this.target = null;
            reportCardsActivity.detailTitle = null;
            reportCardsActivity.detailName = null;
            reportCardsActivity.detailIcon = null;
            reportCardsActivity.fragmentContainer = null;
            reportCardsActivity.progressBar = null;
            this.view2131361925.setOnClickListener(null);
            this.view2131361925 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
