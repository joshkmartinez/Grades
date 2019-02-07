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

public final class ClassCheckInActivity_ViewBinding implements Unbinder {
    private ClassCheckInActivity target;
    private View view2131361927;

    @UiThread
    public ClassCheckInActivity_ViewBinding(ClassCheckInActivity classCheckInActivity) {
        this(classCheckInActivity, classCheckInActivity.getWindow().getDecorView());
    }

    @UiThread
    public ClassCheckInActivity_ViewBinding(final ClassCheckInActivity classCheckInActivity, View view) {
        this.target = classCheckInActivity;
        View findRequiredView = Utils.findRequiredView(view, C0316R.id.detail_title, "field 'detailTitle' and method 'closeActivity'");
        classCheckInActivity.detailTitle = (CardView) Utils.castView(findRequiredView, C0316R.id.detail_title, "field 'detailTitle'", CardView.class);
        this.view2131361927 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                classCheckInActivity.closeActivity();
            }
        });
        classCheckInActivity.detailName = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.detail_name, "field 'detailName'", TextView.class);
        classCheckInActivity.detailIcon = (ImageView) Utils.findRequiredViewAsType(view, C0316R.id.detail_icon, "field 'detailIcon'", ImageView.class);
        classCheckInActivity.fragmentContainer = (RelativeLayout) Utils.findRequiredViewAsType(view, C0316R.id.fragment_container, "field 'fragmentContainer'", RelativeLayout.class);
        classCheckInActivity.progressBar = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.progress_bar, "field 'progressBar'", ProgressBar.class);
    }

    public void unbind() {
        ClassCheckInActivity classCheckInActivity = this.target;
        if (classCheckInActivity != null) {
            this.target = null;
            classCheckInActivity.detailTitle = null;
            classCheckInActivity.detailName = null;
            classCheckInActivity.detailIcon = null;
            classCheckInActivity.fragmentContainer = null;
            classCheckInActivity.progressBar = null;
            this.view2131361927.setOnClickListener(null);
            this.view2131361927 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
