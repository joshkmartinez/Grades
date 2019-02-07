package com.aeries.mobileportal.views.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aeries.mobileportal.views.custom.BadgedTab;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/fragments/SettingsFragment$setupViews$3", "Landroid/content/BroadcastReceiver;", "(Lcom/aeries/mobileportal/views/custom/BadgedTab;)V", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: SettingsFragment.kt */
public final class SettingsFragment$setupViews$3 extends BroadcastReceiver {
    final /* synthetic */ BadgedTab $notificationsView;

    SettingsFragment$setupViews$3(BadgedTab badgedTab) {
        this.$notificationsView = badgedTab;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        context = this.$notificationsView;
        intent = intent != null ? Integer.valueOf(intent.getIntExtra(NotificationsFragment.Companion.getNEW_NOTIFICATION_NUMBER(), 0)) : null;
        if (intent == null) {
            Intrinsics.throwNpe();
        }
        context.setBadgeNumber(intent.intValue());
    }
}
