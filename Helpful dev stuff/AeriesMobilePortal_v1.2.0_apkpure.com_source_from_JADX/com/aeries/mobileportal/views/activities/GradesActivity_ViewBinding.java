package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
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

public final class GradesActivity_ViewBinding implements Unbinder {
    private GradesActivity target;
    private View view2131361925;
    private View view2131362282;
    private View view2131362283;

    @UiThread
    public GradesActivity_ViewBinding(GradesActivity gradesActivity) {
        this(gradesActivity, gradesActivity.getWindow().getDecorView());
    }

    @UiThread
    public GradesActivity_ViewBinding(final GradesActivity gradesActivity, View view) {
        this.target = gradesActivity;
        gradesActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.what_if_banner, "field 'whatIfBanner' and method 'onBannerClick'");
        gradesActivity.whatIfBanner = (CardView) Utils.castView(findRequiredView, C0316R.id.what_if_banner, "field 'whatIfBanner'", CardView.class);
        this.view2131362282 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                gradesActivity.onBannerClick();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_name, "field 'detailName' and method 'closeActivity'");
        gradesActivity.detailName = (TextView) Utils.castView(findRequiredView, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        this.view2131361925 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                gradesActivity.closeActivity();
            }
        });
        gradesActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        findRequiredView = Utils.findRequiredView(view, C0316R.id.what_if_button, "field 'whatIfButton' and method 'onWhatIfButtonClick'");
        gradesActivity.whatIfButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.what_if_button, "field 'whatIfButton'", ImageView.class);
        this.view2131362283 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                gradesActivity.onWhatIfButtonClick();
            }
        });
        gradesActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        gradesActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
        gradesActivity.constraintLayout = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.detailConstraintLayout, "field 'constraintLayout'", ConstraintLayout.class);
    }

    public void unbind() {
        GradesActivity gradesActivity = this.target;
        if (gradesActivity != null) {
            this.target = null;
            gradesActivity.detailTitle = null;
            gradesActivity.whatIfBanner = null;
            gradesActivity.detailName = null;
            gradesActivity.detailIcon = null;
            gradesActivity.whatIfButton = null;
            gradesActivity.fragmentContainer = null;
            gradesActivity.progressBar = null;
            gradesActivity.constraintLayout = null;
            this.view2131362282.setOnClickListener(null);
            this.view2131362282 = null;
            this.view2131361925.setOnClickListener(null);
            this.view2131361925 = null;
            this.view2131362283.setOnClickListener(null);
            this.view2131362283 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
