package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.Fragment;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.AccountSettingsFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerAccountSettingsFragmentComponent;
import com.aeries.mobileportal.dagger.modules.SettingsAdapterModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/AccountSettingsFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: AccountSettingsFragment.kt */
final class AccountSettingsFragment$component$2 extends Lambda implements Function0<AccountSettingsFragmentComponent> {
    final /* synthetic */ AccountSettingsFragment this$0;

    AccountSettingsFragment$component$2(AccountSettingsFragment accountSettingsFragment) {
        this.this$0 = accountSettingsFragment;
        super(0);
    }

    public final AccountSettingsFragmentComponent invoke() {
        return DaggerAccountSettingsFragmentComponent.builder().settingsAdapterModule(new SettingsAdapterModule(this.this$0, this.this$0)).pSPComponent(PSPApplication.Companion.get((Fragment) this.this$0)).build();
    }
}
