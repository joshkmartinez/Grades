package com.aeries.mobileportal.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.aeries.mobileportal.adapters.SettingsAdapter.SettingHolder;
import com.aeries.mobileportal.enums.Settings;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
/* compiled from: SettingsAdapter.kt */
final class SettingsAdapter$SettingHolder$bindData$1 implements OnClickListener {
    final /* synthetic */ Settings $setting;
    final /* synthetic */ SettingHolder this$0;

    SettingsAdapter$SettingHolder$bindData$1(SettingHolder settingHolder, Settings settings) {
        this.this$0 = settingHolder;
        this.$setting = settings;
    }

    public final void onClick(View view) {
        this.this$0.this$0.getListener().onSettingSelected(this.$setting);
    }
}
