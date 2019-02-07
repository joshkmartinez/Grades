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

public final class CommunicationsActivity_ViewBinding implements Unbinder {
    private CommunicationsActivity target;
    private View view2131361846;
    private View view2131361870;
    private View view2131361967;

    @UiThread
    public CommunicationsActivity_ViewBinding(CommunicationsActivity communicationsActivity) {
        this(communicationsActivity, communicationsActivity.getWindow().getDecorView());
    }

    @UiThread
    public CommunicationsActivity_ViewBinding(final CommunicationsActivity communicationsActivity, View view) {
        this.target = communicationsActivity;
        communicationsActivity.detailTitle = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        communicationsActivity.detailName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        communicationsActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        communicationsActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.back_button, "field 'backButton' and method 'goBack'");
        communicationsActivity.backButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.back_button, "field 'backButton'", ImageView.class);
        this.view2131361846 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                communicationsActivity.goBack();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.forward_button, "field 'forwardButton' and method 'goForward'");
        communicationsActivity.forwardButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.forward_button, "field 'forwardButton'", ImageView.class);
        this.view2131361967 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                communicationsActivity.goForward();
            }
        });
        findRequiredView = Utils.findRequiredView(view, C0316R.id.check_in_button, "field 'closeButton' and method 'closeActivity'");
        communicationsActivity.closeButton = (ImageView) Utils.castView(findRequiredView, C0316R.id.check_in_button, "field 'closeButton'", ImageView.class);
        this.view2131361870 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                communicationsActivity.closeActivity();
            }
        });
        communicationsActivity.container = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.container, "field 'container'", ConstraintLayout.class);
        communicationsActivity.holderContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, C0316R.id.holder_container, "field 'holderContainer'", ConstraintLayout.class);
        communicationsActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        CommunicationsActivity communicationsActivity = this.target;
        if (communicationsActivity != null) {
            this.target = null;
            communicationsActivity.detailTitle = null;
            communicationsActivity.detailName = null;
            communicationsActivity.detailIcon = null;
            communicationsActivity.fragmentContainer = null;
            communicationsActivity.backButton = null;
            communicationsActivity.forwardButton = null;
            communicationsActivity.closeButton = null;
            communicationsActivity.container = null;
            communicationsActivity.holderContainer = null;
            communicationsActivity.progressBar = null;
            this.view2131361846.setOnClickListener(null);
            this.view2131361846 = null;
            this.view2131361967.setOnClickListener(null);
            this.view2131361967 = null;
            this.view2131361870.setOnClickListener(null);
            this.view2131361870 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
