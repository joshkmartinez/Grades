package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class SettingsFragment_ViewBinding implements Unbinder {
    private SettingsFragment target;

    @UiThread
    public SettingsFragment_ViewBinding(SettingsFragment settingsFragment, View view) {
        this.target = settingsFragment;
        settingsFragment.tabLayout = (TabLayout) Utils.findRequiredViewAsType(view, C0316R.id.tab_layout, "field 'tabLayout'", TabLayout.class);
        settingsFragment.viewPager = (ViewPager) Utils.findRequiredViewAsType(view, C0316R.id.viewpager, "field 'viewPager'", ViewPager.class);
    }

    public void unbind() {
        SettingsFragment settingsFragment = this.target;
        if (settingsFragment != null) {
            this.target = null;
            settingsFragment.tabLayout = null;
            settingsFragment.viewPager = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
