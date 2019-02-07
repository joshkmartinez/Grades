package com.aeries.mobileportal.views.fragments;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.aeries.mobileportal.C0316R;

public final class AccountSettingsFragment_ViewBinding implements Unbinder {
    private AccountSettingsFragment target;
    private View view2131361882;

    @UiThread
    public AccountSettingsFragment_ViewBinding(final AccountSettingsFragment accountSettingsFragment, View view) {
        this.target = accountSettingsFragment;
        accountSettingsFragment.settingsRV = (RecyclerView) Utils.findRequiredViewAsType(view, C0316R.id.settings, "field 'settingsRV'", RecyclerView.class);
        view = Utils.findRequiredView(view, C0316R.id.close_icon, "field 'closeIcon' and method 'close'");
        accountSettingsFragment.closeIcon = (ImageView) Utils.castView(view, C0316R.id.close_icon, "field 'closeIcon'", ImageView.class);
        this.view2131361882 = view;
        view.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                accountSettingsFragment.close();
            }
        });
    }

    public void unbind() {
        AccountSettingsFragment accountSettingsFragment = this.target;
        if (accountSettingsFragment != null) {
            this.target = null;
            accountSettingsFragment.settingsRV = null;
            accountSettingsFragment.closeIcon = null;
            this.view2131361882.setOnClickListener(null);
            this.view2131361882 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
