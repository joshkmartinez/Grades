package com.aeries.mobileportal.views.activities;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class MainTabletActivity_ViewBinding implements Unbinder {
    private MainTabletActivity target;

    @UiThread
    public MainTabletActivity_ViewBinding(MainTabletActivity mainTabletActivity) {
        this(mainTabletActivity, mainTabletActivity.getWindow().getDecorView());
    }

    @UiThread
    public MainTabletActivity_ViewBinding(MainTabletActivity mainTabletActivity, View view) {
        this.target = mainTabletActivity;
        mainTabletActivity.progress = (ProgressBar) Utils.findRequiredViewAsType(view, C0316R.id.detail_progress, "field 'progress'", ProgressBar.class);
    }

    public void unbind() {
        MainTabletActivity mainTabletActivity = this.target;
        if (mainTabletActivity != null) {
            this.target = null;
            mainTabletActivity.progress = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
