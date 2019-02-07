package com.aeries.mobileportal.views.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/aeries/mobileportal/views/activities/MainActivity$unlockReceiver$1", "Landroid/content/BroadcastReceiver;", "(Lcom/aeries/mobileportal/views/activities/MainActivity;)V", "onReceive", "", "p0", "Landroid/content/Context;", "p1", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 1, 10})
/* compiled from: MainActivity.kt */
public final class MainActivity$unlockReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ MainActivity this$0;

    MainActivity$unlockReceiver$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        this.this$0.getPresenter().getRestrictions();
        this.this$0.getPresenter().updatePortalVersion();
    }
}