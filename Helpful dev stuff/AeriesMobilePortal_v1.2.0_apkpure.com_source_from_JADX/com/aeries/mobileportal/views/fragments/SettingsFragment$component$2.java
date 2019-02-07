package com.aeries.mobileportal.views.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.aeries.mobileportal.PSPApplication;
import com.aeries.mobileportal.dagger.components.DaggerSettingsFragmentComponent;
import com.aeries.mobileportal.dagger.components.DaggerSettingsFragmentComponent.Builder;
import com.aeries.mobileportal.dagger.components.SettingsFragmentComponent;
import com.aeries.mobileportal.dagger.modules.SettingsFragmentModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/aeries/mobileportal/dagger/components/SettingsFragmentComponent;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
/* compiled from: SettingsFragment.kt */
final class SettingsFragment$component$2 extends Lambda implements Function0<SettingsFragmentComponent> {
    final /* synthetic */ SettingsFragment this$0;

    SettingsFragment$component$2(SettingsFragment settingsFragment) {
        this.this$0 = settingsFragment;
        super(0);
    }

    public final SettingsFragmentComponent invoke() {
        Builder builder = DaggerSettingsFragmentComponent.builder();
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        return builder.settingsFragmentModule(new SettingsFragmentModule(childFragmentManager, this.this$0.mNotificationsEnabled, Intrinsics.areEqual(this.this$0.mUserType, (Object) "Student"), this.this$0)).pSPComponent(PSPApplication.Companion.get((Fragment) this.this$0)).build();
    }
}
