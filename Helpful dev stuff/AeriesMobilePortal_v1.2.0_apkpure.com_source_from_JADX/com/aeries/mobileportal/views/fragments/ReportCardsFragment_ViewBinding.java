package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class ReportCardsFragment_ViewBinding implements Unbinder {
    private ReportCardsFragment target;

    @UiThread
    public ReportCardsFragment_ViewBinding(ReportCardsFragment reportCardsFragment, View view) {
        this.target = reportCardsFragment;
        reportCardsFragment.reportCardsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.report_cards_rv, "field 'reportCardsRV'", RecyclerView.class);
        reportCardsFragment.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        reportCardsFragment.noReportsView = Utils.findRequiredView(view, C0316R.id.no_reports, "field 'noReportsView'");
    }

    public void unbind() {
        ReportCardsFragment reportCardsFragment = this.target;
        if (reportCardsFragment != null) {
            this.target = null;
            reportCardsFragment.reportCardsRV = null;
            reportCardsFragment.progressBar = null;
            reportCardsFragment.noReportsView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
