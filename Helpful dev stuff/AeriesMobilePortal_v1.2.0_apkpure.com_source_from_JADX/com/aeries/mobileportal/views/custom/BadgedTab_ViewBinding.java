package com.aeries.mobileportal.views.custom;

import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class BadgedTab_ViewBinding implements Unbinder {
    private BadgedTab target;

    @UiThread
    public BadgedTab_ViewBinding(BadgedTab badgedTab) {
        this(badgedTab, badgedTab);
    }

    @UiThread
    public BadgedTab_ViewBinding(BadgedTab badgedTab, View view) {
        this.target = badgedTab;
        badgedTab.tabTitle = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.tab_title, "field 'tabTitle'", TextView.class);
        badgedTab.badge = (CardView) Utils.findRequiredViewAsType(view, C0316R.id.badge, "field 'badge'", CardView.class);
        badgedTab.badgeNumber = (TextView) Utils.findRequiredViewAsType(view, C0316R.id.badge_number, "field 'badgeNumber'", TextView.class);
    }

    public void unbind() {
        BadgedTab badgedTab = this.target;
        if (badgedTab != null) {
            this.target = null;
            badgedTab.tabTitle = null;
            badgedTab.badge = null;
            badgedTab.badgeNumber = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
